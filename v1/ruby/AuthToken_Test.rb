require "test/unit"
require_relative './AuthToken'


# Assumes server is already running on localhost:9080
class TestClient < Test::Unit::TestCase

   def test_negative
       # This is assuming server started with admin/admin
       assert_match('500',StriimRestClient.new().getAuthToken('admin','test'),"Authentication Error")
   end

   def test_positive
        assert_match('200',StriimRestClient.new().getAuthToken('admin','admin'),"Authentication Request Succeeded")
   end
     
   def teardown
      # Nothing to do
   end
              
end

