.class Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;
.super Ljava/lang/Object;
.source "HttpURLConnectionBuilder.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mChunkLength:Ljava/lang/Integer;

.field private mContentLength:Ljava/lang/Long;

.field private final mInnerConnectionStore:Ljava/net/HttpURLConnection;

.field private final mOutputStream:Ljava/io/ByteArrayOutputStream;

.field private final mProperties:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/net/URL;)V
    .locals 3
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mProperties:Ljava/util/Map;

    .line 30
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mOutputStream:Ljava/io/ByteArrayOutputStream;

    .line 32
    iput-object v2, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mChunkLength:Ljava/lang/Integer;

    .line 33
    iput-object v2, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mContentLength:Ljava/lang/Long;

    .line 37
    if-nez p1, :cond_0

    .line 39
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "url cannot be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 42
    :cond_0
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/security/EnhancedURLConnectionFactory;->createURLConnection(Ljava/net/URL;)Ljava/net/URLConnection;

    move-result-object v0

    .line 44
    .local v0, "connection":Ljava/net/URLConnection;
    instance-of v1, v0, Ljava/net/HttpURLConnection;

    if-nez v1, :cond_1

    .line 46
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "url must be atleast http"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 49
    :cond_1
    check-cast v0, Ljava/net/HttpURLConnection;

    .end local v0    # "connection":Ljava/net/URLConnection;
    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    .line 50
    return-void
.end method

.method private getConnection()Ljava/net/HttpURLConnection;
    .locals 3

    .prologue
    .line 144
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/security/EnhancedURLConnectionFactory;->createURLConnection(Ljava/net/URL;)Ljava/net/URLConnection;

    move-result-object v1

    check-cast v1, Ljava/net/HttpURLConnection;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 150
    :goto_0
    return-object v1

    .line 146
    :catch_0
    move-exception v0

    .line 148
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "IOException while cloning connection. Should not happen"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 150
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private putRequestProperty(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 2
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;
    .param p3, "replace"    # Z

    .prologue
    .line 181
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mProperties:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 182
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez v0, :cond_0

    .line 184
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 185
    .restart local v0    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mProperties:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 188
    :cond_0
    if-eqz p3, :cond_1

    .line 190
    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 193
    :cond_1
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 194
    return-void
.end method


# virtual methods
.method public addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 160
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->putRequestProperty(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 161
    return-void
.end method

.method public final createConnection()Ljava/net/HttpURLConnection;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 59
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getConnection()Ljava/net/HttpURLConnection;

    move-result-object v0

    .line 60
    .local v0, "httpConnection":Ljava/net/HttpURLConnection;
    if-nez v0, :cond_1

    move-object v0, v1

    .line 69
    .end local v0    # "httpConnection":Ljava/net/HttpURLConnection;
    :cond_0
    :goto_0
    return-object v0

    .line 65
    .restart local v0    # "httpConnection":Ljava/net/HttpURLConnection;
    :cond_1
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->populateConnectionAttributes(Ljava/net/HttpURLConnection;)V

    .line 67
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "POST"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string/jumbo v3, "PUT"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_2
    :try_start_0
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    :try_start_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mOutputStream:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/io/OutputStream;->write([B)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    goto :goto_0

    :catchall_0
    move-exception v2

    move-object v4, v2

    move-object v2, v1

    move-object v1, v4

    :goto_1
    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    throw v1

    :catchall_1
    move-exception v1

    goto :goto_1
.end method

.method public getAllowUserInteraction()Z
    .locals 1

    .prologue
    .line 238
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getAllowUserInteraction()Z

    move-result v0

    return v0
.end method

.method public getConnectTimeout()I
    .locals 1

    .prologue
    .line 298
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getConnectTimeout()I

    move-result v0

    return v0
.end method

.method public getDefaultUseCaches()Z
    .locals 1

    .prologue
    .line 248
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public getDoInput()Z
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDoInput()Z

    move-result v0

    return v0
.end method

.method public getDoOutput()Z
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getDoOutput()Z

    move-result v0

    return v0
.end method

.method public getIfModifiedSince()J
    .locals 2

    .prologue
    .line 278
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getIfModifiedSince()J

    move-result-wide v0

    return-wide v0
.end method

.method protected getInnerStore()Ljava/net/HttpURLConnection;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    return-object v0
.end method

.method public getInstanceFollowRedirects()Z
    .locals 1

    .prologue
    .line 228
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public getOutputStream()Ljava/io/OutputStream;
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mOutputStream:Ljava/io/ByteArrayOutputStream;

    return-object v0
.end method

.method public getReadTimeout()I
    .locals 1

    .prologue
    .line 308
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public getRequestMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getRequestProperties()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mProperties:Ljava/util/Map;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "field"    # Ljava/lang/String;

    .prologue
    .line 170
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mProperties:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 171
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_1

    .line 173
    :cond_0
    const/4 v1, 0x0

    .line 176
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    goto :goto_0
.end method

.method public getURL()Ljava/net/URL;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public getUseCaches()Z
    .locals 1

    .prologue
    .line 288
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method protected populateConnectionAttributes(Ljava/net/HttpURLConnection;)V
    .locals 6
    .param p1, "httpConnection"    # Ljava/net/HttpURLConnection;

    .prologue
    .line 76
    :try_start_0
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/ProtocolException; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mChunkLength:Ljava/lang/Integer;

    if-eqz v4, :cond_0

    .line 85
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mChunkLength:Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setChunkedStreamingMode(I)V

    .line 88
    :cond_0
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mContentLength:Ljava/lang/Long;

    if-eqz v4, :cond_1

    .line 90
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0x13

    if-lt v4, v5, :cond_3

    .line 92
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mContentLength:Ljava/lang/Long;

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-virtual {p1, v4, v5}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(J)V

    .line 100
    :cond_1
    :goto_0
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getInstanceFollowRedirects()Z

    move-result v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 102
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getAllowUserInteraction()Z

    move-result v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setAllowUserInteraction(Z)V

    .line 103
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getConnectTimeout()I

    move-result v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 104
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getDefaultUseCaches()Z

    move-result v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setDefaultUseCaches(Z)V

    .line 105
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getDoInput()Z

    move-result v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 106
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getDoOutput()Z

    move-result v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 107
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getIfModifiedSince()J

    move-result-wide v4

    invoke-virtual {p1, v4, v5}, Ljava/net/HttpURLConnection;->setIfModifiedSince(J)V

    .line 108
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getReadTimeout()I

    move-result v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 109
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getUseCaches()Z

    move-result v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 111
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mProperties:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 113
    .local v2, "property":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 115
    .local v3, "value":Ljava/lang/String;
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {p1, v4, v3}, Ljava/net/HttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 80
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "property":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v3    # "value":Ljava/lang/String;
    :catch_0
    move-exception v4

    new-instance v4, Ljava/lang/IllegalStateException;

    const-string/jumbo v5, "Connection has been already executed"

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 96
    :cond_3
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mContentLength:Ljava/lang/Long;

    invoke-virtual {v4}, Ljava/lang/Long;->intValue()I

    move-result v4

    invoke-virtual {p1, v4}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(I)V

    goto/16 :goto_0

    .line 118
    :cond_4
    return-void
.end method

.method public setAllowUserInteraction(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 243
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setAllowUserInteraction(Z)V

    .line 244
    return-void
.end method

.method public setChunkedStreamingMode(I)V
    .locals 1
    .param p1, "chunkLength"    # I

    .prologue
    .line 203
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mChunkLength:Ljava/lang/Integer;

    .line 204
    return-void
.end method

.method public setConnectTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 303
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 304
    return-void
.end method

.method public setDefaultUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 253
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDefaultUseCaches(Z)V

    .line 254
    return-void
.end method

.method public setDoInput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 263
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 264
    return-void
.end method

.method public setDoOutput(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 273
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 274
    return-void
.end method

.method public setFixedLengthStreamingMode(J)V
    .locals 1
    .param p1, "contentLength"    # J

    .prologue
    .line 208
    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mContentLength:Ljava/lang/Long;

    .line 209
    return-void
.end method

.method public setIfModifiedSince(J)V
    .locals 1
    .param p1, "newValue"    # J

    .prologue
    .line 283
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->setIfModifiedSince(J)V

    .line 284
    return-void
.end method

.method public setInstanceFollowRedirects(Z)V
    .locals 1
    .param p1, "followRedirects"    # Z

    .prologue
    .line 233
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 234
    return-void
.end method

.method public setReadTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 313
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 314
    return-void
.end method

.method public setRequestMethod(Ljava/lang/String;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/ProtocolException;
        }
    .end annotation

    .prologue
    .line 223
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 224
    return-void
.end method

.method public setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "field"    # Ljava/lang/String;
    .param p2, "newValue"    # Ljava/lang/String;

    .prologue
    .line 165
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->putRequestProperty(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 166
    return-void
.end method

.method public setUseCaches(Z)V
    .locals 1
    .param p1, "newValue"    # Z

    .prologue
    .line 293
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 294
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 324
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public usingProxy()Z
    .locals 1

    .prologue
    .line 318
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->mInnerConnectionStore:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->usingProxy()Z

    move-result v0

    return v0
.end method
