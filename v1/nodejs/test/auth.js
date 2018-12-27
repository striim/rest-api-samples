const auth = require('../auth')
const assert = require('assert')

describe('Auth', () => {
    describe('#auth', () => {
        it('should return auth-token in UUID format', (done) => {
            let cb = (err, token) => {
                if(err != null) {
                    done(err)
                } else {
                    console.log(`      Token: ${token}.`)
                    assert.strictEqual(token.length, 36)
                    done()
                }
            }
            auth.auth('http://localhost:9080', 'admin', 'admin', cb)
        })
    })
})
