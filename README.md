## Run Application

grails runApp

## Use curl to send a post Request
```
curl -X POST \
  http://localhost:8080/world \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d '{
   "field": "testing"
}'
```

It will save the data and respond with a JSON with a new ID.
