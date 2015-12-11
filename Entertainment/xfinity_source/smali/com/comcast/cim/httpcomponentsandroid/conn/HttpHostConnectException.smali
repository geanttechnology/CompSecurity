.class public Lcom/comcast/cim/httpcomponentsandroid/conn/HttpHostConnectException;
.super Ljava/net/ConnectException;
.source "HttpHostConnectException.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final host:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Ljava/net/ConnectException;)V
    .locals 2
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "cause"    # Ljava/net/ConnectException;

    .prologue
    .line 49
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Connection to "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " refused"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/net/ConnectException;-><init>(Ljava/lang/String;)V

    .line 50
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/HttpHostConnectException;->host:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 51
    invoke-virtual {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/conn/HttpHostConnectException;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    .line 52
    return-void
.end method


# virtual methods
.method public getHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/HttpHostConnectException;->host:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    return-object v0
.end method
