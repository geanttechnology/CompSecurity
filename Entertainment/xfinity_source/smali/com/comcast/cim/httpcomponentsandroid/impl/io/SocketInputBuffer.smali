.class public Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractSessionInputBuffer;
.source "SocketInputBuffer.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;


# static fields
.field private static final SOCKET_TIMEOUT_CLASS:Ljava/lang/Class;


# instance fields
.field private eof:Z

.field private final socket:Ljava/net/Socket;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    invoke-static {}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->SocketTimeoutExceptionClass()Ljava/lang/Class;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->SOCKET_TIMEOUT_CLASS:Ljava/lang/Class;

    return-void
.end method

.method public constructor <init>(Ljava/net/Socket;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 2
    .param p1, "socket"    # Ljava/net/Socket;
    .param p2, "buffersize"    # I
    .param p3, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 95
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractSessionInputBuffer;-><init>()V

    .line 96
    if-nez p1, :cond_0

    .line 97
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Socket may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 99
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->socket:Ljava/net/Socket;

    .line 100
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->eof:Z

    .line 101
    if-gez p2, :cond_1

    .line 102
    invoke-virtual {p1}, Ljava/net/Socket;->getReceiveBufferSize()I

    move-result p2

    .line 104
    :cond_1
    const/16 v0, 0x400

    if-ge p2, v0, :cond_2

    .line 105
    const/16 p2, 0x400

    .line 107
    :cond_2
    invoke-virtual {p1}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->init(Ljava/io/InputStream;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 108
    return-void
.end method

.method private static SocketTimeoutExceptionClass()Ljava/lang/Class;
    .locals 2

    .prologue
    .line 63
    :try_start_0
    const-string v1, "java.net.SocketTimeoutException"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 65
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    :goto_0
    return-object v1

    .line 64
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    :catch_0
    move-exception v0

    .line 65
    .restart local v0    # "e":Ljava/lang/ClassNotFoundException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private static isSocketTimeoutException(Ljava/io/InterruptedIOException;)Z
    .locals 1
    .param p0, "e"    # Ljava/io/InterruptedIOException;

    .prologue
    .line 70
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->SOCKET_TIMEOUT_CLASS:Ljava/lang/Class;

    if-eqz v0, :cond_0

    .line 71
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->SOCKET_TIMEOUT_CLASS:Ljava/lang/Class;

    invoke-virtual {v0, p0}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v0

    .line 73
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method protected fillBuffer()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 111
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/AbstractSessionInputBuffer;->fillBuffer()I

    move-result v0

    .line 112
    .local v0, "i":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    iput-boolean v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->eof:Z

    .line 113
    return v0

    .line 112
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isDataAvailable(I)Z
    .locals 5
    .param p1, "timeout"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 117
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->hasBufferedData()Z

    move-result v2

    .line 118
    .local v2, "result":Z
    if-nez v2, :cond_0

    .line 119
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->socket:Ljava/net/Socket;

    invoke-virtual {v3}, Ljava/net/Socket;->getSoTimeout()I

    move-result v1

    .line 121
    .local v1, "oldtimeout":I
    :try_start_0
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->socket:Ljava/net/Socket;

    invoke-virtual {v3, p1}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 122
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->fillBuffer()I

    .line 123
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->hasBufferedData()Z
    :try_end_0
    .catch Ljava/io/InterruptedIOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    .line 129
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->socket:Ljava/net/Socket;

    invoke-virtual {v3, v1}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 132
    .end local v1    # "oldtimeout":I
    :cond_0
    :goto_0
    return v2

    .line 124
    .restart local v1    # "oldtimeout":I
    :catch_0
    move-exception v0

    .line 125
    .local v0, "e":Ljava/io/InterruptedIOException;
    :try_start_1
    invoke-static {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->isSocketTimeoutException(Ljava/io/InterruptedIOException;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 126
    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 129
    .end local v0    # "e":Ljava/io/InterruptedIOException;
    :catchall_0
    move-exception v3

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->socket:Ljava/net/Socket;

    invoke-virtual {v4, v1}, Ljava/net/Socket;->setSoTimeout(I)V

    throw v3

    .restart local v0    # "e":Ljava/io/InterruptedIOException;
    :cond_1
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->socket:Ljava/net/Socket;

    invoke-virtual {v3, v1}, Ljava/net/Socket;->setSoTimeout(I)V

    goto :goto_0
.end method

.method public isEof()Z
    .locals 1

    .prologue
    .line 136
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/io/SocketInputBuffer;->eof:Z

    return v0
.end method
