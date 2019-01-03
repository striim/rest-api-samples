require 'net/http'

class StriimRestClient
      def getAuthToken(user, pass)
      #This is the most basic http lib example.
      uri=URI('http://localhost:9080/security/authenticate')
      req= Net::HTTP::Post.new(uri) 
      req.set_form_data('username' => user , 'password' => pass )
      res = Net::HTTP.start(uri.hostname, uri.port) do |http|
      http.request(req)
      end

      # This common exception handling
      # Use puts to see output directly from program
      case res
      when Net::HTTPSuccess, Net::HTTPRedirection
          
          #puts res.body
          res.body
          #puts res.code
          res.code
      else
          #puts res.message
          res.message
          #puts res.code
          res.code
      end
   end

end
#Uncomment this also if you want direct output.
#client=StriimRestClient.new()
#client.getAuthToken('admin','admin')
