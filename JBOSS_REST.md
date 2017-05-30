curl -u djadmin:admin123! http://localhost:9990/management/ -HContent-Type:application/json -d '{"operation":"read-resource", "include-runtime":"true", "address":[{"deployment":"OpenShiftDemo.war"}], "json.pretty":1}' 

# Active sessions for OpenShiftDemo.war
curl -u djadmin:admin123! http://localhost:9990/management/ -HContent-Type:application/json -d '{"operation":"read-resource", "include-runtime":"true", "address":[{"deployment":"OpenShiftDemo.war"},{"subsystem":"undertow"}], "json.pretty":1}'

# Read undertow
curl -u djadmin:admin123! http://localhost:9990/management/ -HContent-Type:application/json -d '{"operation":"read-resource", "include-runtime":"true", "address":[{"subsystem":"undertow"}], "json.pretty":1}'


curl --digest -L -D - http://admin:admin123@localhost:9990/management/ -d '{"operation":"write-attribute","address":[{"subsystem":"logging"},{"console-handler":"CONSOLE"}],"name":"level","value":"WARN", "json.pretty":1}' -HContent-Type:application/json

# Enable Stats
curl -u djadmin:admin123! http://localhost:9990/management/ -HContent-Type:application/json -d '{"operation":"write-attribute", "address":[{"subsystem":"undertow"}], "name":"statistics-enabled","value":"true", "json.pretty":1}'


curl -u djadmin:admin123! http://localhost:9990/management/ -HContent-Type:application/json -d  '{"operation":"read-resource", "include-runtime":"true", "address":[{"subsystem":"undertow"}], "json.pretty":1}'


[standalone@localhost:9990 /] /deployment=OpenShiftDemo.war/subdeployment=OpenShiftDemo.war/subsystem=undertow :read-attribute(name=active-sessions)
{
    "outcome" => "success",  
    "result" => 3
}

curl -u djadmin:admin123! http://localhost:9990/management/ -HContent-Type:application/json -d  '{"operation":"read-resource", "include-runtime":"true", "address":[{"subsystem":"undertow"},{"server":"default-server"},{"http-listener":"default"}], "json.pretty":1}'


,{"server":"default-server"},{"http-listener":"default"}
,{"":""}



# GET REQUES TCOUNT
curl -u djadmin:admin123! http://localhost:9990/management/ -HContent-Type:application/json -d  '{"operation":"read-resource", "include-runtime":"true", "address":[{"subsystem":"undertow"},{"server":"default-server"},{"https-listener":"https"}], "json.pretty":1}'
{
    "outcome" : "success",
    "result" : {
        "allow-encoded-slash" : false,
        "allow-equals-in-cookie-value" : false,
        "always-set-keep-alive" : true,
        "buffer-pipelined-data" : false,
        "buffer-pool" : "default",
        "bytes-received" : 0,
        "bytes-sent" : 0,
        "certificate-forwarding" : false,
        "decode-url" : true,
        "disallowed-methods" : ["TRACE"],
        "enable-http2" : false,
        "enabled" : true,
        "error-count" : 0,
        "http2-enable-push" : true,
        "http2-header-table-size" : null,
        "http2-initial-window-size" : null,
        "http2-max-concurrent-streams" : null,
        "http2-max-frame-size" : null,
        "http2-max-header-list-size" : null,
        "max-buffered-request-size" : 16384,
        "max-connections" : null,
        "max-cookies" : 200,
        "max-header-size" : 1048576,
        "max-headers" : 200,
        "max-parameters" : 1000,
        "max-post-size" : 104857600,
        "max-processing-time" : 0,
        "no-request-timeout" : 60000,
        "processing-time" : 0,
        "proxy-address-forwarding" : false,
        "read-timeout" : null,
        "receive-buffer" : null,
        "record-request-start-time" : false,
        "redirect-socket" : "https",
        "request-count" : 0,
        "request-parse-timeout" : null,
        "resolve-peer-address" : false,
        "secure" : false,
        "send-buffer" : null,
        "socket-binding" : "http",
        "tcp-backlog" : 10000,
        "tcp-keep-alive" : null,
        "url-charset" : "UTF-8",
        "worker" : "default",
        "write-timeout" : null
    }
}