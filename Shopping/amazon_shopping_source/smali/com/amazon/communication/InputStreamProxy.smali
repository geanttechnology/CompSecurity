.class public Lcom/amazon/communication/InputStreamProxy;
.super Lcom/amazon/communication/IInputStream$Stub;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mInputStream:Ljava/io/InputStream;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "TComm.InputStreamProxy"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/communication/InputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Ljava/io/InputStream;)V
    .locals 2

    invoke-direct {p0}, Lcom/amazon/communication/IInputStream$Stub;-><init>()V

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "InputStream cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Lcom/amazon/communication/InputStreamProxy;->mInputStream:Ljava/io/InputStream;

    return-void
.end method


# virtual methods
.method public available()I
    .locals 6

    :try_start_0
    iget-object v0, p0, Lcom/amazon/communication/InputStreamProxy;->mInputStream:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->available()I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    return v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/amazon/communication/InputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "available"

    const-string/jumbo v3, "IOException caught while calling available"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    const/4 v0, -0x2

    goto :goto_0
.end method

.method public close()Z
    .locals 6

    const/4 v0, 0x1

    const/4 v1, 0x0

    :try_start_0
    iget-object v2, p0, Lcom/amazon/communication/InputStreamProxy;->mInputStream:Ljava/io/InputStream;

    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return v0

    :catch_0
    move-exception v2

    sget-object v3, Lcom/amazon/communication/InputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "close"

    const-string/jumbo v5, "IOException caught while calling close"

    new-array v0, v0, [Ljava/lang/Object;

    aput-object v2, v0, v1

    invoke-virtual {v3, v4, v5, v0}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    move v0, v1

    goto :goto_0
.end method

.method public readByte()I
    .locals 6

    :try_start_0
    iget-object v0, p0, Lcom/amazon/communication/InputStreamProxy;->mInputStream:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    return v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/amazon/communication/InputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "readByte"

    const-string/jumbo v3, "IOException caught while calling read"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    const/4 v0, -0x2

    goto :goto_0
.end method

.method public readBytes([B)I
    .locals 9

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    invoke-static {p1}, Lcom/dp/utils/FailFast;->expectNotNull(Ljava/lang/Object;)V

    sget-object v0, Lcom/amazon/communication/InputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "read(byte[])"

    const-string/jumbo v2, "About to read"

    new-array v3, v8, [Ljava/lang/Object;

    const-string/jumbo v4, "length"

    aput-object v4, v3, v6

    array-length v4, p1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    :try_start_0
    iget-object v0, p0, Lcom/amazon/communication/InputStreamProxy;->mInputStream:Ljava/io/InputStream;

    invoke-virtual {v0, p1}, Ljava/io/InputStream;->read([B)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    return v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/amazon/communication/InputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "readBytes"

    const-string/jumbo v3, "IOException caught while calling read"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const-string/jumbo v5, "data.length"

    aput-object v5, v4, v6

    array-length v5, p1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    aput-object v0, v4, v8

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    const/4 v0, -0x2

    goto :goto_0
.end method

.method public readBytesIntoOffset([BII)I
    .locals 8

    const/4 v7, 0x1

    const/4 v6, 0x0

    invoke-static {p1}, Lcom/dp/utils/FailFast;->expectNotNull(Ljava/lang/Object;)V

    sget-object v0, Lcom/amazon/communication/InputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "read(byte[],int,int)"

    const-string/jumbo v2, "About to read"

    const/4 v3, 0x6

    new-array v3, v3, [Ljava/lang/Object;

    const-string/jumbo v4, "data.length"

    aput-object v4, v3, v6

    array-length v4, p1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v7

    const/4 v4, 0x2

    const-string/jumbo v5, "offset"

    aput-object v5, v3, v4

    const/4 v4, 0x3

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x4

    const-string/jumbo v5, "length"

    aput-object v5, v3, v4

    const/4 v4, 0x5

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    :try_start_0
    iget-object v0, p0, Lcom/amazon/communication/InputStreamProxy;->mInputStream:Ljava/io/InputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/InputStream;->read([BII)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    return v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/amazon/communication/InputStreamProxy;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "readBytesIntoOffset"

    const-string/jumbo v3, "IOException caught while calling read"

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v0, v4, v6

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    const/4 v0, -0x2

    goto :goto_0
.end method
