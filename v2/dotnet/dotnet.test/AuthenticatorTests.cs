using Xunit;

namespace dotnet.test
{
    [Trait(nameof(Authenticator), nameof(Authenticator.Authenticate))]
    public class AuthenticatorTests
    {
        protected Authenticator Auth;

        public AuthenticatorTests()
        {
            Auth = new Authenticator("http://localhost:9080");
        }

        public class When_correct_credentials : AuthenticatorTests
        {
            [Fact]
            void It_should_return_true()
            {
                Assert.True(Auth.Authenticate("admin", "admin"));
            }
        }

        public class When_incorrect_credentials : AuthenticatorTests
        {
            [Fact]
            void It_should_return_false()
            {
                Assert.False(Auth.Authenticate("admin", "incorrect_password"));
            }
        }
    }
}
