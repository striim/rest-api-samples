require "test/unit"
require_relative './AuthToken'

# Assumption:
# Server running in localhost:9080 with user-password `admin`/`admin`.
class TestClient < Test::Unit::TestCase

  def test_negative
    client = StriimRestClient.new('http://localhost:9080')
    assert_raise(RuntimeError) { client.auth_token('admin', 'test') }
  end

  def test_positive
    client = StriimRestClient.new('http://localhost:9080')
    assert_equal(36, client.auth_token('admin', 'admin').length)
  end
              
end

