### Download Java Agent
```bash
curl -Lo dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'
```

### DataDog Agent status
```bash
docker exec <data_dog_agent_container_id> agent status
```

System Overview Dashboard
```
https://us5.datadoghq.com/dash/integration/system_overview
```

API Keys
```
https://us5.datadoghq.com/organization-settings/api-keys
```

Start docker compose with API Key as env variable
```
DD_API_KEY=<datadog_api_key> docker compose
```
