require 'net/http'
require 'json'

class StriimRestClient
  
  AUTH_PATH = '/security/authenticate'

  def initialize(url)
    @url = url
  end
  
  def auth_token(user, pass)
    uri = URI(@url + AUTH_PATH)
    req = Net::HTTP::Post.new(uri) 
    req.set_form_data('username' => user, 'password' => pass )
    res = Net::HTTP.start(uri.hostname, uri.port) do | http |
      http.request(req)
    end

    case res
    when Net::HTTPSuccess, Net::HTTPRedirection
      j = JSON.parse(res.body)
      j['token']
    else
      raise 'Error authenticating'
    end
  end
end
#Uncomment this also if you want direct output.
#client=StriimRestClient.new()
#client.getAuthToken('admin','admin')
