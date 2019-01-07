import unittest
from auth_token import AuthToken, AuthErr

class TestAuthTokens(unittest.TestCase):

    URL = 'http://localhost:9080'

    def test_positive(self):
        authtoken = AuthToken(TestAuthTokens.URL)
        self.assertEqual(36, len(authtoken.get_token('admin','admin')))

    def test_negative(self):
        authtoken = AuthToken(TestAuthTokens.URL)
        with self.assertRaises(AuthErr):
            authtoken.get_token('admin','test')

if __name__ == '__main__':
    unittest.main()
