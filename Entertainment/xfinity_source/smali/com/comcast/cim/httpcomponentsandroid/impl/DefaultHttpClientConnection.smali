.class public Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpClientConnection;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;
.source "DefaultHttpClientConnection.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;-><init>()V

    .line 58
    return-void
.end method


# virtual methods
.method public bind(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 3
    .param p1, "socket"    # Ljava/net/Socket;
    .param p2, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 63
    if-nez p1, :cond_0

    .line 64
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Socket may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 66
    :cond_0
    if-nez p2, :cond_1

    .line 67
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP parameters may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 69
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpClientConnection;->assertNotOpen()V

    .line 70
    invoke-static {p2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->getTcpNoDelay(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Z

    move-result v1

    invoke-virtual {p1, v1}, Ljava/net/Socket;->setTcpNoDelay(Z)V

    .line 71
    invoke-static {p2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->getSoTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)I

    move-result v1

    invoke-virtual {p1, v1}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 73
    invoke-static {p2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->getLinger(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)I

    move-result v0

    .line 74
    .local v0, "linger":I
    if-ltz v0, :cond_2

    .line 75
    if-lez v0, :cond_3

    const/4 v1, 0x1

    :goto_0
    invoke-virtual {p1, v1, v0}, Ljava/net/Socket;->setSoLinger(ZI)V

    .line 77
    :cond_2
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpClientConnection;->bind(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 78
    return-void

    .line 75
    :cond_3
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 81
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 82
    .local v0, "buffer":Ljava/lang/StringBuffer;
    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 83
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpClientConnection;->isOpen()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 84
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpClientConnection;->getRemotePort()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 88
    :goto_0
    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 89
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 86
    :cond_0
    const-string v1, "closed"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method
