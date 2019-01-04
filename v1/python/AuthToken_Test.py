import unittest
from AuthToken import AuthToken

class TestAuthTokens(unittest.TestCase):

    def test_positive(self):
       authtoken = AuthToken()
       self.assertIsNotNone( authtoken.authenticate('admin','admin'),'Authenticated Successfully')

    def test_negative(self):
       authtoken = AuthToken()
       self.assertIsNone( authtoken.authenticate('admin','test'),'Authentication Failure')

if __name__ == '__main__':
     unittest.main()
