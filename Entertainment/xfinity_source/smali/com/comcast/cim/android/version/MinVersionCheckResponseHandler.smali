.class public Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;
.super Lcom/comcast/cim/cmasl/xip/XipResponseHandler;
.source "MinVersionCheckResponseHandler.java"


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private minVersion:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/xip/XipResponseHandler;-><init>()V

    .line 15
    const-class v0, Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;->LOG:Lorg/slf4j/Logger;

    .line 17
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;->minVersion:Ljava/lang/Integer;

    .line 21
    return-void
.end method


# virtual methods
.method public getMinVersion()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;->minVersion:Ljava/lang/Integer;

    return-object v0
.end method

.method public handleResponseBody(Ljava/io/InputStream;)V
    .locals 4
    .param p1, "inputStream"    # Ljava/io/InputStream;

    .prologue
    .line 30
    :try_start_0
    const-string v2, "UTF-8"

    invoke-static {p1, v2}, Lorg/apache/commons/io/IOUtils;->toString(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 31
    .local v1, "minVersionString":Ljava/lang/String;
    const-string v2, "0.0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 32
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, p0, Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;->minVersion:Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 38
    :cond_0
    return-void

    .line 34
    .end local v1    # "minVersionString":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 35
    .local v0, "e":Ljava/io/IOException;
    iget-object v2, p0, Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Failed to check Min Version"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 36
    new-instance v2, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    const-string v3, "Failed reading Min Version Response"

    invoke-direct {v2, v3, v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/lang/String;Ljava/io/IOException;)V

    throw v2
.end method
