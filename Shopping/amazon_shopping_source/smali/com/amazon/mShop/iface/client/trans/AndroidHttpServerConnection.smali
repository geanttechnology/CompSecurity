.class public Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;
.super Lcom/amazon/rio/j2me/client/trans/ServerConnection;
.source "AndroidHttpServerConnection.java"


# static fields
.field private static final DEBUG:Z

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mCustomHeaders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mHttpConnection:Ljava/net/HttpURLConnection;

.field private mInputStream:Ljava/io/InputStream;

.field private mOutputStream:Ljava/io/OutputStream;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 40
    const-string/jumbo v0, "http.keepAlive"

    const-string/jumbo v1, "true"

    invoke-static {v0, v1}, Ljava/lang/System;->setProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 44
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->DEBUG:Z

    .line 45
    const-class v0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 57
    invoke-direct {p0, p1}, Lcom/amazon/rio/j2me/client/trans/ServerConnection;-><init>(Ljava/lang/String;)V

    .line 50
    iput-object v0, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    .line 51
    iput-object v0, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mOutputStream:Ljava/io/OutputStream;

    .line 52
    iput-object v0, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mInputStream:Ljava/io/InputStream;

    .line 58
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mCustomHeaders:Ljava/util/Map;

    .line 59
    return-void
.end method

.method private close(Ljava/io/InputStream;Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    .locals 2
    .param p1, "is"    # Ljava/io/InputStream;
    .param p2, "os"    # Ljava/io/OutputStream;
    .param p3, "con"    # Ljava/net/HttpURLConnection;

    .prologue
    .line 121
    if-eqz p1, :cond_0

    .line 122
    :try_start_0
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 126
    :cond_0
    :goto_0
    if-eqz p2, :cond_1

    .line 127
    :try_start_1
    invoke-virtual {p2}, Ljava/io/OutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 131
    :cond_1
    :goto_1
    if-eqz p3, :cond_2

    .line 132
    invoke-virtual {p3}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 134
    :cond_2
    return-void

    .line 123
    :catch_0
    move-exception v0

    .local v0, "ie":Ljava/io/IOException;
    sget-boolean v1, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->DEBUG:Z

    if-eqz v1, :cond_0

    sget-object v1, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->TAG:Ljava/lang/String;

    invoke-static {v1, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 128
    .end local v0    # "ie":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .restart local v0    # "ie":Ljava/io/IOException;
    sget-boolean v1, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->DEBUG:Z

    if-eqz v1, :cond_1

    sget-object v1, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->TAG:Ljava/lang/String;

    invoke-static {v1, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method


# virtual methods
.method public addCustomHeaders(Ljava/lang/String;)V
    .locals 8
    .param p1, "method"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-static {p1}, Lcom/amazon/mShop/feature/FeatureTrigger;->getHttpHeaderFeatureTriggers(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 65
    .local v2, "headers":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 66
    iget-object v5, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mCustomHeaders:Ljava/util/Map;

    const-string/jumbo v6, "x-amz-msh-feature-trigger"

    invoke-interface {v5, v6, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    :cond_0
    invoke-static {p1}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getCustomHeaderFields(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v0

    .line 71
    .local v0, "clickstreamHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v0, :cond_2

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v5

    if-lez v5, :cond_2

    .line 72
    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 73
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_1

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 74
    iget-object v5, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mCustomHeaders:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 81
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_2
    invoke-static {p1}, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->getHttpHeaderForRefmarker(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 82
    .local v4, "refmarker":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 83
    iget-object v5, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mCustomHeaders:Ljava/util/Map;

    const-string/jumbo v6, "x-amz-msh-ref-marker"

    invoke-interface {v5, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    :cond_3
    return-void
.end method

.method protected getInputStream()Ljava/io/InputStream;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 155
    iget-object v2, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mInputStream:Ljava/io/InputStream;

    if-nez v2, :cond_2

    .line 156
    iget-object v2, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    .line 157
    .local v1, "rc":I
    const/16 v2, 0xc8

    if-eq v1, v2, :cond_1

    .line 158
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "HTTP response error: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 159
    .local v0, "msg":Ljava/lang/String;
    sget-boolean v2, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->DEBUG:Z

    if-eqz v2, :cond_0

    .line 160
    sget-object v2, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "getInputStream(): "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 161
    :cond_0
    new-instance v2, Ljava/io/IOException;

    invoke-direct {v2, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 164
    .end local v0    # "msg":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mInputStream:Ljava/io/InputStream;

    .line 167
    .end local v1    # "rc":I
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mInputStream:Ljava/io/InputStream;

    return-object v2
.end method

.method protected getOutputStream()Ljava/io/OutputStream;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 138
    iget-object v1, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mOutputStream:Ljava/io/OutputStream;

    if-nez v1, :cond_2

    .line 139
    iget-object v1, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mInputStream:Ljava/io/InputStream;

    if-eqz v1, :cond_1

    .line 140
    const-string/jumbo v0, "output stream must be opened before input stream"

    .line 141
    .local v0, "msg":Ljava/lang/String;
    sget-boolean v1, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 142
    sget-object v1, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "getOutputStream(): output stream must be opened before input stream"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 143
    :cond_0
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "output stream must be opened before input stream"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 146
    .end local v0    # "msg":Ljava/lang/String;
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 147
    iget-object v1, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mOutputStream:Ljava/io/OutputStream;

    .line 150
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mOutputStream:Ljava/io/OutputStream;

    return-object v1
.end method

.method protected initializeNetworkConnection(I)V
    .locals 8
    .param p1, "numBytes"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v7, 0x7530

    .line 89
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->waitForNetworkConnectivity()V

    .line 92
    invoke-static {}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->checkAndWait()V

    .line 94
    new-instance v2, Ljava/net/URL;

    invoke-virtual {p0}, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 95
    .local v2, "url":Ljava/net/URL;
    invoke-virtual {v2}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v4

    check-cast v4, Ljava/net/HttpURLConnection;

    iput-object v4, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    .line 96
    iget-object v4, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    const-string/jumbo v5, "POST"

    invoke-virtual {v4, v5}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 97
    iget-object v4, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    const-string/jumbo v5, "Content-Type"

    const-string/jumbo v6, "application/octet-stream"

    invoke-virtual {v4, v5, v6}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 98
    iget-object v4, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v4, v7}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 99
    iget-object v4, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v4, v7}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 100
    iget-object v4, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    const-string/jumbo v5, "Content-Length"

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    const-string/jumbo v4, "http.agent"

    invoke-static {v4}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 103
    .local v3, "userAgent":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 104
    iget-object v4, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    const-string/jumbo v5, "User-Agent"

    invoke-virtual {v4, v5, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mCustomHeaders:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 109
    .local v1, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 110
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 111
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v6, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v6, v4, v5}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 113
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    return-void
.end method

.method protected releaseNetworkConnection()V
    .locals 3

    .prologue
    .line 117
    iget-object v0, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mInputStream:Ljava/io/InputStream;

    iget-object v1, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mOutputStream:Ljava/io/OutputStream;

    iget-object v2, p0, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/mShop/iface/client/trans/AndroidHttpServerConnection;->close(Ljava/io/InputStream;Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V

    .line 118
    return-void
.end method
