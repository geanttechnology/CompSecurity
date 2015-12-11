.class public Lcom/amazon/communication/ServiceSideInputStreamProxy;
.super Ljava/io/InputStream;

# interfaces
.implements Landroid/os/IBinder$DeathRecipient;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private mInputStream:Lcom/amazon/communication/IInputStream;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.ServiceSideInputStreamProxy"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/communication/IInputStream;)V
    .locals 6

    const/4 v5, 0x0

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    iput-object p1, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;

    invoke-interface {p1}, Lcom/amazon/communication/IInputStream;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    const/4 v1, 0x0

    :try_start_0
    invoke-interface {v0, p0, v1}, Landroid/os/IBinder;->linkToDeath(Landroid/os/IBinder$DeathRecipient;I)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/amazon/communication/ServiceSideInputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "constructor"

    const-string/jumbo v3, "Binder has already died.  Swallowing and allowing read call path to discover this"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcom/amazon/communication/ServiceSideInputStreamProxy;->binderDied()V

    goto :goto_0
.end method


# virtual methods
.method public available()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;

    if-nez v0, :cond_0

    sget-object v0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "available"

    const-string/jumbo v2, "Client-side callback object is now stale"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "Client-side callback object is now stale"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    invoke-interface {v0}, Lcom/amazon/communication/IInputStream;->available()I

    move-result v0

    const/4 v1, -0x2

    if-ne v0, v1, :cond_1

    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "IOException in client-side InputStream"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :cond_1
    return v0
.end method

.method public declared-synchronized binderDied()V
    .locals 1

    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public close()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;

    if-nez v0, :cond_0

    sget-object v0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "close"

    const-string/jumbo v2, "Client-side callback object is now stale"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "Client-side callback object is now stale"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    invoke-interface {v0}, Lcom/amazon/communication/IInputStream;->close()Z

    move-result v1

    invoke-interface {v0}, Lcom/amazon/communication/IInputStream;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, p0, v2}, Landroid/os/IBinder;->unlinkToDeath(Landroid/os/IBinder$DeathRecipient;I)Z

    monitor-enter p0
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_0

    const/4 v0, 0x0

    :try_start_3
    iput-object v0, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;

    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    if-nez v1, :cond_1

    :try_start_4
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "IOException in client-side InputStream"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_4
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :catchall_1
    move-exception v0

    :try_start_5
    monitor-exit p0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    :try_start_6
    throw v0
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_6 .. :try_end_6} :catch_0

    :cond_1
    return-void
.end method

.method public read()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;

    if-nez v0, :cond_0

    sget-object v0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "read()"

    const-string/jumbo v2, "Client-side callback object is now stale"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "Client-side callback object is now stale"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    invoke-interface {v0}, Lcom/amazon/communication/IInputStream;->readByte()I

    move-result v0

    const/4 v1, -0x2

    if-ne v0, v1, :cond_1

    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "IOException in client-side InputStream"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :cond_1
    return v0
.end method

.method public read([B)I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/communication/ServiceSideInputStreamProxy;->read([BII)I

    move-result v0

    return v0
.end method

.method public read([BII)I
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v11, 0x1

    const/4 v2, 0x0

    if-ltz p2, :cond_0

    if-ltz p3, :cond_0

    array-length v0, p1

    if-le p2, v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    const-string/jumbo v1, "read(byte[],int,int)"

    const-string/jumbo v3, "Index out of bounds"

    const/4 v4, 0x6

    new-array v4, v4, [Ljava/lang/Object;

    const-string/jumbo v5, "array.length"

    aput-object v5, v4, v2

    array-length v2, p1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v4, v11

    const-string/jumbo v2, "offset"

    aput-object v2, v4, v6

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v4, v7

    const-string/jumbo v2, "length"

    aput-object v2, v4, v8

    const/4 v2, 0x5

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v2

    invoke-static {v1, v3, v4}, Lcom/amazon/dp/logger/DPFormattedMessage;->toDPFormat(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    if-nez p3, :cond_3

    move v0, v2

    :cond_2
    :goto_0
    return v0

    :cond_3
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;

    if-nez v0, :cond_4

    sget-object v0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "read(byte[],int,int)"

    const-string/jumbo v2, "Client-side callback object is now stale"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "Client-side callback object is now stale"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_4
    :try_start_1
    iget-object v5, p0, Lcom/amazon/communication/ServiceSideInputStreamProxy;->mInputStream:Lcom/amazon/communication/IInputStream;

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move v4, p3

    move v0, v2

    :cond_5
    const v1, 0x19000

    if-le v4, v1, :cond_6

    const v1, 0x19000

    move v3, v1

    :goto_1
    :try_start_2
    sget-object v1, Lcom/amazon/communication/ServiceSideInputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v6, "read(byte[],int,int)"

    const-string/jumbo v7, "About to read"

    const/16 v8, 0x8

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    const-string/jumbo v10, "bytesToRead"

    aput-object v10, v8, v9

    const/4 v9, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x2

    const-string/jumbo v10, "Size of buffer"

    aput-object v10, v8, v9

    const/4 v9, 0x3

    array-length v10, p1

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x4

    const-string/jumbo v10, "totalBytesRead"

    aput-object v10, v8, v9

    const/4 v9, 0x5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x6

    const-string/jumbo v10, "remainingBytesToRead"

    aput-object v10, v8, v9

    const/4 v9, 0x7

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-virtual {v1, v6, v7, v8}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    add-int v1, p2, v0

    invoke-interface {v5, p1, v1, v3}, Lcom/amazon/communication/IInputStream;->readBytesIntoOffset([BII)I

    move-result v1

    const/4 v6, -0x2

    if-ne v1, v6, :cond_7

    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "IOException in client-side InputStream"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/amazon/communication/ServiceSideInputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v3, "read(byte[],int,int)"

    const-string/jumbo v4, "RemoteException occurred reading from InputStream"

    new-array v5, v11, [Ljava/lang/Object;

    aput-object v0, v5, v2

    invoke-virtual {v1, v3, v4, v5}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :cond_6
    move v3, v4

    goto :goto_1

    :cond_7
    const/4 v6, -0x1

    if-ne v1, v6, :cond_8

    if-gtz v0, :cond_2

    move v0, v1

    goto/16 :goto_0

    :cond_8
    add-int/2addr v0, v1

    sub-int/2addr v4, v1

    if-lt v1, v3, :cond_2

    if-gtz v4, :cond_5

    goto/16 :goto_0
.end method
