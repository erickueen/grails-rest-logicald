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

Instead of saving data, the application will respond with an empty array (It's redirecting to the index action, not save.)
