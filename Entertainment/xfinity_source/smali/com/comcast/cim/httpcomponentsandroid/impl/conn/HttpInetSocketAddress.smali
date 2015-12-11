.class Lcom/comcast/cim/httpcomponentsandroid/impl/conn/HttpInetSocketAddress;
.super Ljava/net/InetSocketAddress;
.source "HttpInetSocketAddress.java"


# instance fields
.field private final host:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Ljava/net/InetAddress;I)V
    .locals 2
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "addr"    # Ljava/net/InetAddress;
    .param p3, "port"    # I

    .prologue
    .line 45
    invoke-direct {p0, p2, p3}, Ljava/net/InetSocketAddress;-><init>(Ljava/net/InetAddress;I)V

    .line 46
    if-nez p1, :cond_0

    .line 47
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP host may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 49
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/HttpInetSocketAddress;->host:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 50
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 58
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/HttpInetSocketAddress;->host:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getHostName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/HttpInetSocketAddress;->getPort()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
