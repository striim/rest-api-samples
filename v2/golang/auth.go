package golang

import (
	"encoding/json"
	"errors"
	"io/ioutil"
	"net/http"
	"net/url"
)

const apiPath = "/security/authenticate"

// RespBody is the JSON structure for mapping successful authentication response.
type RespBody struct {
	Token string `json:"token"`
}

// GetAuthToken returns the auth-token for the username-password supplied.
func GetAuthToken(apiURL string, uname string, pwd string) (string, error) {
	resp, err := http.PostForm(apiURL+apiPath, url.Values{"username": {uname}, "password": {pwd}})
	if err != nil {
		return "", err
	}
	if resp.StatusCode != 200 {
		return "", errors.New("Non-200 response. Verify your username / password")
	}
	defer resp.Body.Close()
	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		return "", err
	}
	var respBody RespBody
	err = json.Unmarshal(body, &respBody)
	if err != nil {
		return "", err
	}

	return respBody.Token, nil
}
