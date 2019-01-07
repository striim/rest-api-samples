#lib imports
import json
import smtplib
import base64
import urllib
import urllib2
#requests lib required
import requests

class AuthToken:

   def authenticate(self, username, password):
       values = { 'username': username ,'password':password}
       data = urllib.urlencode(values)
       theToken = None
       try:
           url = "http://localhost:9080/security/authenticate"
           req = urllib2.Request(url, data)
           response = urllib2.urlopen(req)
           result = response.read()
           tokenjson = json.loads(result)
           theToken = tokenjson["token"]
       except:
           print "ERROR: Incorrect webaction username/password for authentication"
       finally:
           return theToken

if __name__ == '__main__':
    authToken = AuthToken()
    print authToken.authenticate('admin','admin')
