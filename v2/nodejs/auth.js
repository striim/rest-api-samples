const request = require('request')

const AUTH_PATH = '/security/authenticate'

let auth = (url, username, password, cb) => {
    request.post(
        url + AUTH_PATH,
        {
            form:{
                'username':username,
                'password': password
            }
        },
        (err, res, body) => {
            if(err != null) {
                console.log(err)
                cb(err, null)
                return
            }
            if(res.statusCode != 200) {
                cb(`Non-200 status: ${res.statusCode}.`, null)
                return
            }
            let o = JSON.parse(body)
            cb(null, o.token)
        }
    )
}

module.exports.auth = auth
