.class public final Lcom/amazon/identity/auth/device/utils/StreamUtils;
.super Ljava/lang/Object;
.source "StreamUtils.java"


# static fields
.field public static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/amazon/identity/auth/device/utils/StreamUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/StreamUtils;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    return-void
.end method

.method public static closeParcelFileDescriptor(Landroid/os/ParcelFileDescriptor;)V
    .locals 2
    .param p0, "pfd"    # Landroid/os/ParcelFileDescriptor;

    .prologue
    .line 40
    if-nez p0, :cond_0

    .line 53
    :goto_0
    return-void

    .line 47
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 51
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/utils/StreamUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "IOException closing parcel file descriptor"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static closeStream(Ljava/io/Closeable;)V
    .locals 2
    .param p0, "inputStream"    # Ljava/io/Closeable;

    .prologue
    .line 23
    if-nez p0, :cond_0

    .line 36
    :goto_0
    return-void

    .line 30
    :cond_0
    :try_start_0
    invoke-interface {p0}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 34
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/utils/StreamUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "IOException thrown closing input stream"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static readInputStream(Ljava/io/InputStream;)[B
    .locals 4
    .param p0, "stream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 57
    if-nez p0, :cond_0

    .line 59
    const/4 v3, 0x0

    .line 78
    :goto_0
    return-object v3

    .line 62
    :cond_0
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 63
    .local v2, "readBytes":Ljava/io/ByteArrayOutputStream;
    const/16 v3, 0x400

    new-array v0, v3, [B

    .line 65
    .local v0, "buffer":[B
    const/4 v1, 0x0

    .line 69
    .local v1, "numRead":I
    :goto_1
    invoke-virtual {p0, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    .line 70
    if-ltz v1, :cond_1

    .line 72
    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3, v1}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_1

    .line 78
    :cond_1
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    goto :goto_0
.end method

.method public static writeToStreamAndClose(Ljava/io/OutputStream;[B)V
    .locals 1
    .param p0, "outStream"    # Ljava/io/OutputStream;
    .param p1, "bytes"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 85
    :try_start_0
    invoke-virtual {p0, p1}, Ljava/io/OutputStream;->write([B)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 89
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    .line 90
    return-void

    .line 89
    :catchall_0
    move-exception v0

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    throw v0
.end method
