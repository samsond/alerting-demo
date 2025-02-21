
## Troubleshooting Prometheus & Alertmanager Setup

### Confirm /actuator/prometheus is Reachable
If you’re on Docker, you might confirm the endpoint is reachable from inside the Prometheus container:

```bash
docker exec -it <prometheus_container_name> wget -qO- http://alerting-demo:8080/actuator/prometheus
````
### Confirm the Prometheus Scrape Configuration
Check the actual prometheus.yml file inside the Prometheus container
```bash
docker exec -it alerting-demo-prometheus-1 cat /etc/prometheus/prometheus.yml
```

### Check the Prometheus Targets Page
Go to http://localhost:9090/targets. You should see an entry like:

```agsl
Job                | Endpoint                     | State | Labels
alerting-demo      | http://alerting-demo:8080/... | UP    | ...
```

### Check Prometheus’s “Rules” page at http://localhost:9090/alerts.
- You should see your alert rule (Many5xxErrors or similar) listed. If not, Prometheus may not have loaded your alerting_rules.yml.
Confirm the file is mounted in Docker:
```bash
docker exec -it alerting-demo-prometheus-1 cat /etc/prometheus/alert_rules.yml
```