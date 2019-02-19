package golang

import (
	"fmt"
	"testing"
)

func TestGetAuthToken(t *testing.T) {
	token, err := GetAuthToken("http://localhost:9080", "admin", "admin")
	if err != nil {
		t.Error(err)
		return
	}
	fmt.Printf("Token: %v.\n", token)
}
