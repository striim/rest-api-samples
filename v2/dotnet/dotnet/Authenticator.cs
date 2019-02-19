using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;

namespace dotnet
{
    public class Authenticator
    {
        private const string AuthPath = "/security/authenticate";
        private readonly Uri _url;

        private static readonly HttpClient Client = new HttpClient();

        public Authenticator(string host)
        {
            _url = new Uri(new Uri(host), AuthPath);
        }

        public bool Authenticate(string username, string password)
        {
            var content = new FormUrlEncodedContent(new Dictionary<string, string>
            {
                { "username", username },
                { "password", password }
            });

            var response = Client.PostAsync(_url, content).Result;

            return response.StatusCode == HttpStatusCode.OK;
        }
    }
}