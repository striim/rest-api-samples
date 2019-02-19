using System;

namespace dotnet.console
{
    class Program
    {
        static void Main()
        {
            var authenticator = new Authenticator("http://localhost:9080");
            var result = authenticator.Authenticate("admin", "admin");
            Console.WriteLine($"Authentication result = {result}");
        }
    }
}
