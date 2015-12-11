.class public Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;
.super Ljava/io/OutputStream;
.source "HttpOutputStreamWrapper.java"


# static fields
.field private static final SYNC_OBEJCT:[Ljava/lang/Object;


# instance fields
.field private final mCollector:Ljava/io/ByteArrayOutputStream;

.field private final mConnection:Ljava/net/URLConnection;

.field private mOutputStream:Ljava/io/OutputStream;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->SYNC_OBEJCT:[Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Ljava/net/URLConnection;)V
    .locals 1
    .param p1, "connection"    # Ljava/net/URLConnection;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/io/OutputStream;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mConnection:Ljava/net/URLConnection;

    .line 22
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mCollector:Ljava/io/ByteArrayOutputStream;

    .line 23
    return-void
.end method


# virtual methods
.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mOutputStream:Ljava/io/OutputStream;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mOutputStream:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    .line 69
    :cond_0
    invoke-super {p0}, Ljava/io/OutputStream;->close()V

    .line 70
    return-void
.end method

.method public flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mOutputStream:Ljava/io/OutputStream;

    if-eqz v0, :cond_0

    .line 77
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mOutputStream:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V

    .line 80
    :cond_0
    invoke-super {p0}, Ljava/io/OutputStream;->flush()V

    .line 81
    return-void
.end method

.method public flushToUnderlyingStream()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 51
    sget-object v1, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->SYNC_OBEJCT:[Ljava/lang/Object;

    monitor-enter v1

    .line 53
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mConnection:Ljava/net/URLConnection;

    invoke-virtual {v0}, Ljava/net/URLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mOutputStream:Ljava/io/OutputStream;

    .line 55
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mOutputStream:Ljava/io/OutputStream;

    iget-object v2, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mCollector:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/io/OutputStream;->write([B)V

    .line 57
    invoke-virtual {p0}, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->flush()V

    .line 58
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public getCurrentBytes()[B
    .locals 2

    .prologue
    .line 43
    sget-object v1, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->SYNC_OBEJCT:[Ljava/lang/Object;

    monitor-enter v1

    .line 45
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mCollector:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object v0

    .line 46
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public write(I)V
    .locals 2
    .param p1, "b"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 28
    sget-object v1, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->SYNC_OBEJCT:[Ljava/lang/Object;

    monitor-enter v1

    .line 30
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mOutputStream:Ljava/io/OutputStream;

    if-eqz v0, :cond_0

    .line 32
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mOutputStream:Ljava/io/OutputStream;

    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write(I)V

    .line 38
    :goto_0
    monitor-exit v1

    return-void

    .line 36
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/request/HttpOutputStreamWrapper;->mCollector:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/ByteArrayOutputStream;->write(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 38
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
