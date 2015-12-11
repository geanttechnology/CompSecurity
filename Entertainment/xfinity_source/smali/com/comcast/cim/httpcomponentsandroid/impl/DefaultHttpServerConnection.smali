.class public Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpServerConnection;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;
.source "DefaultHttpServerConnection.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/SocketHttpServerConnection;-><init>()V

    .line 58
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 79
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 80
    .local v0, "buffer":Ljava/lang/StringBuffer;
    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 81
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpServerConnection;->isOpen()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 82
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpServerConnection;->getRemotePort()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 86
    :goto_0
    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 87
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 84
    :cond_0
    const-string v1, "closed"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method
