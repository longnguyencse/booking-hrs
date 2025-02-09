# diagram.py
from diagrams import Diagram, Cluster
from diagrams.aws.analytics import ElasticsearchService
from diagrams.aws.business import Workmail
from diagrams.aws.compute import EC2, Lambda
from diagrams.aws.database import RDS, ElastiCache
from diagrams.aws.engagement import Pinpoint, SimpleEmailServiceSesEmail
from diagrams.aws.general import Users
from diagrams.aws.integration import SimpleQueueServiceSqs
from diagrams.aws.management import Cloudformation
from diagrams.aws.network import CF, Route53
from diagrams.aws.network import ELB
from diagrams.aws.security import Cognito, CertificateManager
from diagrams.aws.storage import SimpleStorageServiceS3
from diagrams.onprem.ci import GithubActions, Jenkins
from diagrams.onprem.iac import Ansible, Terraform
from diagrams.onprem.logging import Fluentbit, Loki
from diagrams.onprem.monitoring import Prometheus, Grafana
from diagrams.onprem.vcs import Github

with(Diagram("DevOps", show=False)):
    with Cluster("DevOps"):
        infa_as_code = Cloudformation("Cloudformation")
        # jenkins = Jenkins("Jenkins")
        github_action = GithubActions("GithubActions")
        grafana = Grafana("Grafana")
        prometheus = Prometheus("Prometheus")
        github = Github("Github")
        fluentbit = Fluentbit("Fluentbit")
        loki = Loki("Loki")
        ansible = Ansible("Ansible")
        # terraform = Terraform("Terraform")

        fluentbit - loki - prometheus - grafana
        infa_as_code  - ansible - github - github_action



with (Diagram("App Service", show=False)):
    client = Users("Clients")
    with Cluster("VPC Network"):
        dns = Route53("Route53")
        elb = ELB("ELB")
        s3 = SimpleStorageServiceS3("S3")
        cf = CF("CF")
        db = RDS("Postgresql")
        redis = ElastiCache("Redis")
        comp = Lambda("Lambda")
        user_pool = Cognito("Cognito")
        queue = SimpleQueueServiceSqs("Queue")
        workmail = Workmail("Workmail")
        cert = CertificateManager("CertificateManager")
        openSearch = ElasticsearchService("OpenSearch")

        with Cluster("Web server"):
            ws_group = [EC2("EC2")]

        # with Cluster("DB"):
        # db_group = [db, redis]

        client >> dns
        dns >> cf
        dns >> elb
        dns >> user_pool
        dns >> cert

        cf >> s3
        elb >> ws_group
        elb >> openSearch
        # elb >> cert

        ws_group >> db
        ws_group >> redis
        user_pool >> comp

        # ws_group >> s3
        # comp >> s3

        # queue
        ws_group >> queue
        comp >> queue
        queue >> Pinpoint("FanOut") >> SimpleEmailServiceSesEmail("Sent Email") >> workmail
