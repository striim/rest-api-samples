require "test/unit"
require_relative './striim_rest_client'

# Assumption:
# Server running in localhost:9080 with user-password `admin`/`admin`.
class TestStriimRestClient < Test::Unit::TestCase

  def test_auth_token_negative
    client = StriimRestClient.new('http://localhost:9080')
    assert_raise(RuntimeError) { client.auth_token('admin', 'test') }
  end

  def test_auth_token_positive
    client = StriimRestClient.new('http://localhost:9080')
    assert_equal(36, client.auth_token('admin', 'admin').length)
  end
              
end

