{
"kind": "PodList",
"apiVersion": "v1",
"metadata": {
"selfLink": "/api/v1/namespaces/mwe-demo/pods",
"resourceVersion": "40734319"
},
"items": [
{
"metadata": {
"name": "admin-mwe-demo-1-xsxq9",
"generateName": "admin-mwe-demo-1-",
"namespace": "mwe-demo",
"selfLink": "/api/v1/namespaces/mwe-demo/pods/admin-mwe-demo-1-xsxq9",
"uid": "2ad5f459-3be8-11e7-b257-005056bf0dd5",
"resourceVersion": "40273175",
"creationTimestamp": "2017-05-18T16:36:39Z",
"labels": {
"deployment": "admin-mwe-demo-1",
"deploymentconfig": "admin-mwe-demo",
"name": "admin-mwe-demo"
},
"annotations": {
"kubernetes.io/created-by": "{\"kind\":\"SerializedReference\",\"apiVersion\":\"v1\",\"reference\":{\"kind\":\"ReplicationController\",\"namespace\":\"mwe-demo\",\"name\":\"admin-mwe-demo-1\",\"uid\":\"290f528d-3be8-11e7-b257-005056bf0dd5\",\"apiVersion\":\"v1\",\"resourceVersion\":\"40273151\"}}\n",
"openshift.io/deployment-config.latest-version": "1",
"openshift.io/deployment-config.name": "admin-mwe-demo",
"openshift.io/deployment.name": "admin-mwe-demo-1",
"openshift.io/scc": "restricted"
}
},
"spec": {
"volumes": [
{
"name": "appsecret",
"secret": {
"secretName": "app-secret",
"defaultMode": 420
}
},
{
"name": "wladminacctsecret",
"secret": {
"secretName": "wladminacct",
"defaultMode": 420
}
},
{
"name": "infrasecret",
"secret": {
"secretName": "infraaccts",
"defaultMode": 420
}
},
{
"name": "wlsslvol",
"secret": {
"secretName": "wlssl",
"defaultMode": 420
}
},
{
"name": "default-token-xjjsv",
"secret": {
"secretName": "default-token-xjjsv",
"defaultMode": 420
}
}
],
"containers": [
{
"name": "admin-mwe-demo",
"image": "uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest:0.2",
"ports": [
{
"name": "https",
"containerPort": 8001,
"protocol": "TCP"
}
],
"env": [
{
"name": "POD_IP",
"valueFrom": {
"fieldRef": {
"apiVersion": "v1",
"fieldPath": "status.podIP"
}
}
},
{
"name": "CLUSTERED",
"value": "true"
},
{
"name": "CLUSTER_ADDRESS",
"value": "ms-mwe-demo-service"
},
{
"name": "TYPE",
"value": "admin"
}
],
"resources": {},
"volumeMounts": [
{
"name": "appsecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/app"
},
{
"name": "wladminacctsecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/wl"
},
{
"name": "infrasecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/infra"
},
{
"name": "wlsslvol",
"readOnly": true,
"mountPath": "/pkgs/secrets/ssl"
},
{
"name": "default-token-xjjsv",
"readOnly": true,
"mountPath": "/var/run/secrets/kubernetes.io/serviceaccount"
}
],
"terminationMessagePath": "/dev/termination-log",
"imagePullPolicy": "IfNotPresent",
"securityContext": {
"capabilities": {
"drop": [
"KILL",
"MKNOD",
"SETGID",
"SETUID",
"SYS_CHROOT"
]
},
"privileged": false,
"seLinuxOptions": {
"level": "s0:c32,c14"
},
"runAsUser": 1001020000
}
}
],
"restartPolicy": "Always",
"terminationGracePeriodSeconds": 30,
"dnsPolicy": "ClusterFirst",
"serviceAccountName": "default",
"serviceAccount": "default",
"nodeName": "he3ilxvdapp570.fhlmc.com",
"securityContext": {
"seLinuxOptions": {
"level": "s0:c32,c14"
},
"fsGroup": 1001020000
},
"imagePullSecrets": [
{
"name": "default-dockercfg-h06ru"
},
{
"name": "artifactory-secret"
}
]
},
"status": {
"phase": "Failed",
"conditions": [
{
"type": "Initialized",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:36:39Z"
},
{
"type": "Ready",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:36:42Z"
},
{
"type": "PodScheduled",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:36:39Z"
}
],
"hostIP": "172.28.168.33",
"podIP": "10.200.19.100",
"startTime": "2017-05-18T16:36:39Z",
"containerStatuses": [
{
"name": "admin-mwe-demo",
"state": {
"running": {
"startedAt": "2017-05-18T16:36:42Z"
}
},
"lastState": {},
"ready": true,
"restartCount": 0,
"image": "uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest:0.2",
"imageID": "docker-pullable://uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest@sha256:1c688de9d4ab02106ee3bf282d9b3e664a75712587ed23619330a9103f42d53a",
"containerID": "docker://42cc48552bb7b379569be115aa704f06d012d26fce4af347c8e117eb15296968"
}
]
}
},
{
"metadata": {
"name": "ms-mwe-demo-1-08nto",
"generateName": "ms-mwe-demo-1-",
"namespace": "mwe-demo",
"selfLink": "/api/v1/namespaces/mwe-demo/pods/ms-mwe-demo-1-08nto",
"uid": "efda77f2-3be8-11e7-b257-005056bf0dd5",
"resourceVersion": "40274557",
"creationTimestamp": "2017-05-18T16:42:10Z",
"labels": {
"deployment": "ms-mwe-demo-1",
"deploymentconfig": "ms-mwe-demo",
"name": "ms-mwe-demo"
},
"annotations": {
"kubernetes.io/created-by": "{\"kind\":\"SerializedReference\",\"apiVersion\":\"v1\",\"reference\":{\"kind\":\"ReplicationController\",\"namespace\":\"mwe-demo\",\"name\":\"ms-mwe-demo-1\",\"uid\":\"ee4e7147-3be8-11e7-b257-005056bf0dd5\",\"apiVersion\":\"v1\",\"resourceVersion\":\"40274396\"}}\n",
"openshift.io/deployment-config.latest-version": "1",
"openshift.io/deployment-config.name": "ms-mwe-demo",
"openshift.io/deployment.name": "ms-mwe-demo-1",
"openshift.io/scc": "restricted"
}
},
"spec": {
"volumes": [
{
"name": "appsecret",
"secret": {
"secretName": "app-secret",
"defaultMode": 420
}
},
{
"name": "wladminacctsecret",
"secret": {
"secretName": "wladminacct",
"defaultMode": 420
}
},
{
"name": "infrasecret",
"secret": {
"secretName": "infraaccts",
"defaultMode": 420
}
},
{
"name": "wlsslvol",
"secret": {
"secretName": "wlssl",
"defaultMode": 420
}
},
{
"name": "default-token-xjjsv",
"secret": {
"secretName": "default-token-xjjsv",
"defaultMode": 420
}
}
],
"containers": [
{
"name": "ms-mwe-demo",
"image": "uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest:0.2",
"ports": [
{
"name": "https",
"containerPort": 8001,
"protocol": "TCP"
}
],
"env": [
{
"name": "POD_IP",
"valueFrom": {
"fieldRef": {
"apiVersion": "v1",
"fieldPath": "status.podIP"
}
}
},
{
"name": "CLUSTERED",
"value": "true"
},
{
"name": "TYPE",
"value": "managed"
},
{
"name": "adminname",
"value": "admin-mwe-demo-service"
}
],
"resources": {},
"volumeMounts": [
{
"name": "appsecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/app"
},
{
"name": "wladminacctsecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/wl"
},
{
"name": "infrasecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/infra"
},
{
"name": "wlsslvol",
"readOnly": true,
"mountPath": "/pkgs/secrets/ssl"
},
{
"name": "default-token-xjjsv",
"readOnly": true,
"mountPath": "/var/run/secrets/kubernetes.io/serviceaccount"
}
],
"readinessProbe": {
"exec": {
"command": [
"sleep",
"30"
]
},
"timeoutSeconds": 35,
"periodSeconds": 10,
"successThreshold": 1,
"failureThreshold": 3
},
"terminationMessagePath": "/dev/termination-log",
"imagePullPolicy": "IfNotPresent",
"securityContext": {
"capabilities": {
"drop": [
"KILL",
"MKNOD",
"SETGID",
"SETUID",
"SYS_CHROOT"
]
},
"privileged": false,
"seLinuxOptions": {
"level": "s0:c32,c14"
},
"runAsUser": 1001020000
}
}
],
"restartPolicy": "Always",
"terminationGracePeriodSeconds": 30,
"dnsPolicy": "ClusterFirst",
"serviceAccountName": "default",
"serviceAccount": "default",
"nodeName": "he3ilxvdapp499.fhlmc.com",
"securityContext": {
"seLinuxOptions": {
"level": "s0:c32,c14"
},
"fsGroup": 1001020000
},
"imagePullSecrets": [
{
"name": "default-dockercfg-h06ru"
},
{
"name": "artifactory-secret"
}
]
},
"status": {
"phase": "Running",
"conditions": [
{
"type": "Initialized",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:42:10Z"
},
{
"type": "Ready",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:42:44Z"
},
{
"type": "PodScheduled",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:42:10Z"
}
],
"hostIP": "172.28.167.238",
"podIP": "10.200.11.76",
"startTime": "2017-05-18T16:42:10Z",
"containerStatuses": [
{
"name": "ms-mwe-demo",
"state": {
"running": {
"startedAt": "2017-05-18T16:42:12Z"
}
},
"lastState": {},
"ready": true,
"restartCount": 0,
"image": "uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest:0.2",
"imageID": "docker-pullable://uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest@sha256:1c688de9d4ab02106ee3bf282d9b3e664a75712587ed23619330a9103f42d53a",
"containerID": "docker://6e21d08402291e7247e3bc3a9b29c77f0b4d0174ce91f63699906e1a4674ce66"
}
]
}
},
{
"metadata": {
"name": "ms-mwe-demo-1-4vfyz",
"generateName": "ms-mwe-demo-1-",
"namespace": "mwe-demo",
"selfLink": "/api/v1/namespaces/mwe-demo/pods/ms-mwe-demo-1-4vfyz",
"uid": "efd84d89-3be8-11e7-b257-005056bf0dd5",
"resourceVersion": "40274583",
"creationTimestamp": "2017-05-18T16:42:10Z",
"labels": {
"deployment": "ms-mwe-demo-1",
"deploymentconfig": "ms-mwe-demo",
"name": "ms-mwe-demo"
},
"annotations": {
"kubernetes.io/created-by": "{\"kind\":\"SerializedReference\",\"apiVersion\":\"v1\",\"reference\":{\"kind\":\"ReplicationController\",\"namespace\":\"mwe-demo\",\"name\":\"ms-mwe-demo-1\",\"uid\":\"ee4e7147-3be8-11e7-b257-005056bf0dd5\",\"apiVersion\":\"v1\",\"resourceVersion\":\"40274396\"}}\n",
"openshift.io/deployment-config.latest-version": "1",
"openshift.io/deployment-config.name": "ms-mwe-demo",
"openshift.io/deployment.name": "ms-mwe-demo-1",
"openshift.io/scc": "restricted"
}
},
"spec": {
"volumes": [
{
"name": "appsecret",
"secret": {
"secretName": "app-secret",
"defaultMode": 420
}
},
{
"name": "wladminacctsecret",
"secret": {
"secretName": "wladminacct",
"defaultMode": 420
}
},
{
"name": "infrasecret",
"secret": {
"secretName": "infraaccts",
"defaultMode": 420
}
},
{
"name": "wlsslvol",
"secret": {
"secretName": "wlssl",
"defaultMode": 420
}
},
{
"name": "default-token-xjjsv",
"secret": {
"secretName": "default-token-xjjsv",
"defaultMode": 420
}
}
],
"containers": [
{
"name": "ms-mwe-demo",
"image": "uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest:0.2",
"ports": [
{
"name": "https",
"containerPort": 8001,
"protocol": "TCP"
}
],
"env": [
{
"name": "POD_IP",
"valueFrom": {
"fieldRef": {
"apiVersion": "v1",
"fieldPath": "status.podIP"
}
}
},
{
"name": "CLUSTERED",
"value": "true"
},
{
"name": "TYPE",
"value": "managed"
},
{
"name": "adminname",
"value": "admin-mwe-demo-service"
}
],
"resources": {},
"volumeMounts": [
{
"name": "appsecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/app"
},
{
"name": "wladminacctsecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/wl"
},
{
"name": "infrasecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/infra"
},
{
"name": "wlsslvol",
"readOnly": true,
"mountPath": "/pkgs/secrets/ssl"
},
{
"name": "default-token-xjjsv",
"readOnly": true,
"mountPath": "/var/run/secrets/kubernetes.io/serviceaccount"
}
],
"readinessProbe": {
"exec": {
"command": [
"sleep",
"30"
]
},
"timeoutSeconds": 35,
"periodSeconds": 10,
"successThreshold": 1,
"failureThreshold": 3
},
"terminationMessagePath": "/dev/termination-log",
"imagePullPolicy": "IfNotPresent",
"securityContext": {
"capabilities": {
"drop": [
"KILL",
"MKNOD",
"SETGID",
"SETUID",
"SYS_CHROOT"
]
},
"privileged": false,
"seLinuxOptions": {
"level": "s0:c32,c14"
},
"runAsUser": 1001020000
}
}
],
"restartPolicy": "Always",
"terminationGracePeriodSeconds": 30,
"dnsPolicy": "ClusterFirst",
"serviceAccountName": "default",
"serviceAccount": "default",
"nodeName": "he3ilxvdapp573.fhlmc.com",
"securityContext": {
"seLinuxOptions": {
"level": "s0:c32,c14"
},
"fsGroup": 1001020000
},
"imagePullSecrets": [
{
"name": "default-dockercfg-h06ru"
},
{
"name": "artifactory-secret"
}
]
},
"status": {
"phase": "Running",
"conditions": [
{
"type": "Initialized",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:42:10Z"
},
{
"type": "Ready",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:42:50Z"
},
{
"type": "PodScheduled",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:42:10Z"
}
],
"hostIP": "172.28.168.130",
"podIP": "10.200.20.105",
"startTime": "2017-05-18T16:42:10Z",
"containerStatuses": [
{
"name": "ms-mwe-demo",
"state": {
"running": {
"startedAt": "2017-05-18T16:42:17Z"
}
},
"lastState": {},
"ready": true,
"restartCount": 0,
"image": "uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest:0.2",
"imageID": "docker-pullable://uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest@sha256:1c688de9d4ab02106ee3bf282d9b3e664a75712587ed23619330a9103f42d53a",
"containerID": "docker://122fed84221f7e242ff80885cdd059128c96b719a068b60d850ac1ad472a8c65"
}
]
}
},
{
"metadata": {
"name": "ms-mwe-demo-1-q2fqm",
"generateName": "ms-mwe-demo-1-",
"namespace": "mwe-demo",
"selfLink": "/api/v1/namespaces/mwe-demo/pods/ms-mwe-demo-1-q2fqm",
"uid": "efd9d046-3be8-11e7-b257-005056bf0dd5",
"resourceVersion": "40274552",
"creationTimestamp": "2017-05-18T16:42:10Z",
"labels": {
"deployment": "ms-mwe-demo-1",
"deploymentconfig": "ms-mwe-demo",
"name": "ms-mwe-demo"
},
"annotations": {
"kubernetes.io/created-by": "{\"kind\":\"SerializedReference\",\"apiVersion\":\"v1\",\"reference\":{\"kind\":\"ReplicationController\",\"namespace\":\"mwe-demo\",\"name\":\"ms-mwe-demo-1\",\"uid\":\"ee4e7147-3be8-11e7-b257-005056bf0dd5\",\"apiVersion\":\"v1\",\"resourceVersion\":\"40274396\"}}\n",
"openshift.io/deployment-config.latest-version": "1",
"openshift.io/deployment-config.name": "ms-mwe-demo",
"openshift.io/deployment.name": "ms-mwe-demo-1",
"openshift.io/scc": "restricted"
}
},
"spec": {
"volumes": [
{
"name": "appsecret",
"secret": {
"secretName": "app-secret",
"defaultMode": 420
}
},
{
"name": "wladminacctsecret",
"secret": {
"secretName": "wladminacct",
"defaultMode": 420
}
},
{
"name": "infrasecret",
"secret": {
"secretName": "infraaccts",
"defaultMode": 420
}
},
{
"name": "wlsslvol",
"secret": {
"secretName": "wlssl",
"defaultMode": 420
}
},
{
"name": "default-token-xjjsv",
"secret": {
"secretName": "default-token-xjjsv",
"defaultMode": 420
}
}
],
"containers": [
{
"name": "ms-mwe-demo",
"image": "uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest:0.2",
"ports": [
{
"name": "https",
"containerPort": 8001,
"protocol": "TCP"
}
],
"env": [
{
"name": "POD_IP",
"valueFrom": {
"fieldRef": {
"apiVersion": "v1",
"fieldPath": "status.podIP"
}
}
},
{
"name": "CLUSTERED",
"value": "true"
},
{
"name": "TYPE",
"value": "managed"
},
{
"name": "adminname",
"value": "admin-mwe-demo-service"
}
],
"resources": {},
"volumeMounts": [
{
"name": "appsecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/app"
},
{
"name": "wladminacctsecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/wl"
},
{
"name": "infrasecret",
"readOnly": true,
"mountPath": "/pkgs/secrets/infra"
},
{
"name": "wlsslvol",
"readOnly": true,
"mountPath": "/pkgs/secrets/ssl"
},
{
"name": "default-token-xjjsv",
"readOnly": true,
"mountPath": "/var/run/secrets/kubernetes.io/serviceaccount"
}
],
"readinessProbe": {
"exec": {
"command": [
"sleep",
"30"
]
},
"timeoutSeconds": 35,
"periodSeconds": 10,
"successThreshold": 1,
"failureThreshold": 3
},
"terminationMessagePath": "/dev/termination-log",
"imagePullPolicy": "IfNotPresent",
"securityContext": {
"capabilities": {
"drop": [
"KILL",
"MKNOD",
"SETGID",
"SETUID",
"SYS_CHROOT"
]
},
"privileged": false,
"seLinuxOptions": {
"level": "s0:c32,c14"
},
"runAsUser": 1001020000
}
}
],
"restartPolicy": "Always",
"terminationGracePeriodSeconds": 30,
"dnsPolicy": "ClusterFirst",
"serviceAccountName": "default",
"serviceAccount": "default",
"nodeName": "he3ilxvdapp570.fhlmc.com",
"securityContext": {
"seLinuxOptions": {
"level": "s0:c32,c14"
},
"fsGroup": 1001020000
},
"imagePullSecrets": [
{
"name": "default-dockercfg-h06ru"
},
{
"name": "artifactory-secret"
}
]
},
"status": {
"phase": "Running",
"conditions": [
{
"type": "Initialized",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:42:10Z"
},
{
"type": "Ready",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:42:43Z"
},
{
"type": "PodScheduled",
"status": "True",
"lastProbeTime": null,
"lastTransitionTime": "2017-05-18T16:42:10Z"
}
],
"hostIP": "172.28.168.33",
"podIP": "10.200.19.101",
"startTime": "2017-05-18T16:42:10Z",
"containerStatuses": [
{
"name": "ms-mwe-demo",
"state": {
"running": {
"startedAt": "2017-05-18T16:42:12Z"
}
},
"lastState": {},
"ready": true,
"restartCount": 0,
"image": "uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest:0.2",
"imageID": "docker-pullable://uat.dockertestregistry.fhlmc.com/docker-mwe-local/asmtest@sha256:1c688de9d4ab02106ee3bf282d9b3e664a75712587ed23619330a9103f42d53a",
"containerID": "docker://adb94500d4c58f451c74095356043a46e45053a8fce862416507e9ab5ed59958"
}
]
}
}

]
}
