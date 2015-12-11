.class public Lcom/newrelic/agent/android/transport/http/HttpJsonTransportFactory;
.super Ljava/lang/Object;
.source "HttpJsonTransportFactory.java"

# interfaces
.implements Lcom/newrelic/agent/android/transport/TransportFactory;


# instance fields
.field private final endpoint:Ljava/lang/String;

.field private final licenseKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "endpoint"    # Ljava/lang/String;
    .param p2, "licenseKey"    # Ljava/lang/String;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransportFactory;->endpoint:Ljava/lang/String;

    .line 13
    iput-object p2, p0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransportFactory;->licenseKey:Ljava/lang/String;

    .line 14
    return-void
.end method


# virtual methods
.method public newTransport()Lcom/newrelic/agent/android/transport/Transport;
    .locals 3

    .prologue
    .line 17
    new-instance v0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;

    iget-object v1, p0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransportFactory;->endpoint:Ljava/lang/String;

    iget-object v2, p0, Lcom/newrelic/agent/android/transport/http/HttpJsonTransportFactory;->licenseKey:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/newrelic/agent/android/transport/http/HttpJsonTransport;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method
