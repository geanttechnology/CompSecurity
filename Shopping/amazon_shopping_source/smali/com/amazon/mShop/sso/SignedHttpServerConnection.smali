.class Lcom/amazon/mShop/sso/SignedHttpServerConnection;
.super Ljava/lang/Object;
.source "SignedHttpServerConnection.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/trans/IServiceConnection;


# instance fields
.field private volatile mCancelled:Z

.field private volatile mHttpConnection:Ljava/net/HttpURLConnection;

.field private volatile mRunning:Z

.field private mUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 44
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 45
    .local v1, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v2, "currentSSOCheckLoginServer"

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 46
    .local v0, "currentSSOCheckLoginServer":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/Context;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_serviceURL:I

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mUrl:Ljava/lang/String;

    .line 47
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string/jumbo v2, "SHM"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 48
    iget-object v2, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mUrl:Ljava/lang/String;

    const-string/jumbo v3, "msh"

    const-string/jumbo v4, "shm"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    .line 52
    .end local v0    # "currentSSOCheckLoginServer":Ljava/lang/String;
    .end local v1    # "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :cond_0
    const-string/jumbo v2, "/mShop/service"

    const-string/jumbo v3, "/mShop/signed"

    invoke-virtual {p1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mUrl:Ljava/lang/String;

    .line 53
    return-void
.end method

.method private declared-synchronized isCancelled()Z
    .locals 1

    .prologue
    .line 223
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mCancelled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized isRunning()Z
    .locals 1

    .prologue
    .line 213
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mRunning:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized setRunning(Z)V
    .locals 1
    .param p1, "running"    # Z

    .prologue
    .line 217
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mRunning:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 218
    monitor-exit p0

    return-void

    .line 217
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public addCustomHeaders(Ljava/lang/String;)V
    .locals 0
    .param p1, "method"    # Ljava/lang/String;

    .prologue
    .line 239
    return-void
.end method

.method public declared-synchronized cancel()V
    .locals 2

    .prologue
    .line 229
    monitor-enter p0

    :try_start_0
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 230
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "SignedHttpServerConnection.cancel"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 232
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mCancelled:Z

    .line 233
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 234
    monitor-exit p0

    return-void

    .line 229
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized close()V
    .locals 3

    .prologue
    .line 175
    monitor-enter p0

    :try_start_0
    sget-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 176
    const-string/jumbo v1, "Amazon.SSOUtil"

    const-string/jumbo v2, "SignedHttpServerConnection.close"

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 178
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->isRunning()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 182
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mCancelled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 205
    :cond_1
    :goto_0
    monitor-exit p0

    return-void

    .line 184
    :cond_2
    :try_start_1
    iget-object v1, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-eqz v1, :cond_1

    .line 186
    :try_start_2
    iget-object v1, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 195
    :cond_3
    :goto_1
    :try_start_3
    iget-object v1, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 196
    :catch_0
    move-exception v0

    .line 198
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    sget-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v1, :cond_1

    .line 199
    const-string/jumbo v1, "Amazon.SSOUtil"

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 200
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 175
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 187
    :catch_1
    move-exception v0

    .line 189
    .restart local v0    # "e":Ljava/lang/Exception;
    :try_start_5
    sget-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v1, :cond_3

    .line 190
    const-string/jumbo v1, "Amazon.SSOUtil"

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 191
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_1
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mUrl:Ljava/lang/String;

    return-object v0
.end method

.method public send([[B)Ljava/io/InputStream;
    .locals 19
    .param p1, "data"    # [[B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 72
    sget-boolean v16, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v16, :cond_0

    .line 73
    const-string/jumbo v16, "Amazon.SSOUtil"

    const-string/jumbo v17, "SignedHttpServerConnection.send START"

    invoke-static/range {v16 .. v17}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 76
    :cond_0
    monitor-enter p0

    .line 77
    :try_start_0
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->isCancelled()Z

    move-result v16

    if-eqz v16, :cond_1

    .line 78
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->close()V

    .line 79
    const/4 v13, 0x0

    monitor-exit p0

    .line 162
    :goto_0
    return-object v13

    .line 81
    :cond_1
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 87
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->waitForNetworkConnectivity()V

    .line 90
    monitor-enter p0

    .line 91
    :try_start_1
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->isCancelled()Z

    move-result v16

    if-eqz v16, :cond_2

    .line 92
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->close()V

    .line 93
    const/4 v13, 0x0

    monitor-exit p0

    goto :goto_0

    .line 97
    :catchall_0
    move-exception v16

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v16

    .line 81
    :catchall_1
    move-exception v16

    :try_start_2
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v16

    .line 96
    :cond_2
    const/16 v16, 0x1

    :try_start_3
    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-direct {v0, v1}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->setRunning(Z)V

    .line 97
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 99
    sget-boolean v16, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v16, :cond_3

    .line 100
    const-string/jumbo v16, "Amazon.SSOUtil"

    const-string/jumbo v17, "SignedHttpServerConnection.send AFTER WAIT FOR CONNECTION"

    invoke-static/range {v16 .. v17}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 102
    :cond_3
    new-instance v5, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v5}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 103
    .local v5, "baos":Ljava/io/ByteArrayOutputStream;
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_1
    move-object/from16 v0, p1

    array-length v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    if-ge v12, v0, :cond_4

    .line 104
    aget-object v16, p1, v12

    move-object/from16 v0, v16

    invoke-virtual {v5, v0}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 103
    add-int/lit8 v12, v12, 0x1

    goto :goto_1

    .line 106
    :cond_4
    invoke-virtual {v5}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v7

    .line 107
    .local v7, "byteArray":[B
    const/4 v13, 0x0

    .line 110
    .local v13, "is":Ljava/io/InputStream;
    :try_start_4
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    .line 111
    .local v8, "context":Landroid/content/Context;
    invoke-static {v8}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v9

    .line 112
    .local v9, "currentAccount":Ljava/lang/String;
    new-instance v15, Ljava/net/URL;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->getUrl()Ljava/lang/String;

    move-result-object v16

    invoke-direct/range {v15 .. v16}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 113
    .local v15, "url":Ljava/net/URL;
    new-instance v2, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;

    invoke-direct {v2, v8, v9}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 114
    .local v2, "authFactory":Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;
    sget-object v16, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ADPAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->newAuthenticationMethod(Lcom/amazon/identity/auth/device/api/AuthenticationType;)Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    move-result-object v3

    .line 115
    .local v3, "authMethod":Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    sget-boolean v16, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v16, :cond_5

    .line 116
    const-string/jumbo v16, "Amazon.SSOUtil"

    const-string/jumbo v17, "New apporach with ADP authenticator"

    invoke-static/range {v16 .. v17}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 117
    const-string/jumbo v16, "Amazon.SSOUtil"

    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v18, "Current MAP account "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v16 .. v17}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 119
    :cond_5
    invoke-static {v15, v3}, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;

    move-result-object v16

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    .line 120
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    const-string/jumbo v17, "POST"

    invoke-virtual/range {v16 .. v17}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 121
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    const/16 v17, 0x1

    invoke-virtual/range {v16 .. v17}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 122
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    const-string/jumbo v17, "Content-Type"

    const-string/jumbo v18, "application/octet-stream"

    invoke-virtual/range {v16 .. v18}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    const-string/jumbo v17, "Content-Length"

    array-length v0, v7

    move/from16 v18, v0

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v16 .. v18}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    const/16 v17, 0x7530

    invoke-virtual/range {v16 .. v17}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 125
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    const/16 v17, 0x7530

    invoke-virtual/range {v16 .. v17}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 128
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v14

    .line 129
    .local v14, "os":Ljava/io/OutputStream;
    invoke-virtual {v14, v7}, Ljava/io/OutputStream;->write([B)V

    .line 131
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    move-result-object v13

    .line 149
    sget-boolean v16, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v16, :cond_6

    .line 150
    const-string/jumbo v16, "Amazon.SSOUtil"

    const-string/jumbo v17, "SignedHttpServerConnection.send END"

    invoke-static/range {v16 .. v17}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    :cond_6
    monitor-enter p0

    .line 154
    const/16 v16, 0x0

    :try_start_5
    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-direct {v0, v1}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->setRunning(Z)V

    .line 156
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->isCancelled()Z

    move-result v16

    if-eqz v16, :cond_7

    .line 157
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->close()V

    .line 159
    :cond_7
    monitor-exit p0

    goto/16 :goto_0

    :catchall_2
    move-exception v16

    monitor-exit p0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    throw v16

    .line 132
    .end local v2    # "authFactory":Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;
    .end local v3    # "authMethod":Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .end local v8    # "context":Landroid/content/Context;
    .end local v9    # "currentAccount":Ljava/lang/String;
    .end local v14    # "os":Ljava/io/OutputStream;
    .end local v15    # "url":Ljava/net/URL;
    :catch_0
    move-exception v10

    .line 133
    .local v10, "e":Ljava/io/IOException;
    :try_start_6
    sget-boolean v16, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v16, :cond_b

    .line 134
    const-string/jumbo v16, "Amazon.SSOUtil"

    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v18, "IOException in send "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v16 .. v17}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 135
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 136
    .local v4, "b":Ljava/lang/StringBuilder;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 137
    const-string/jumbo v16, " "

    move-object/from16 v0, v16

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 138
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 139
    const-string/jumbo v16, " "

    move-object/from16 v0, v16

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 140
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v11

    .line 141
    .local v11, "error":Ljava/io/InputStream;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->mHttpConnection:Ljava/net/HttpURLConnection;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Ljava/net/HttpURLConnection;->getContentLength()I

    move-result v16

    move/from16 v0, v16

    new-array v6, v0, [B

    .line 142
    .local v6, "buffer":[B
    :goto_2
    const/16 v16, -0x1

    invoke-virtual {v11, v6}, Ljava/io/InputStream;->read([B)I

    move-result v17

    move/from16 v0, v16

    move/from16 v1, v17

    if-eq v0, v1, :cond_a

    .line 143
    new-instance v16, Ljava/lang/String;

    move-object/from16 v0, v16

    invoke-direct {v0, v6}, Ljava/lang/String;-><init>([B)V

    move-object/from16 v0, v16

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    goto :goto_2

    .line 149
    .end local v4    # "b":Ljava/lang/StringBuilder;
    .end local v6    # "buffer":[B
    .end local v10    # "e":Ljava/io/IOException;
    .end local v11    # "error":Ljava/io/InputStream;
    :catchall_3
    move-exception v16

    sget-boolean v17, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v17, :cond_8

    .line 150
    const-string/jumbo v17, "Amazon.SSOUtil"

    const-string/jumbo v18, "SignedHttpServerConnection.send END"

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    :cond_8
    monitor-enter p0

    .line 154
    const/16 v17, 0x0

    :try_start_7
    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-direct {v0, v1}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->setRunning(Z)V

    .line 156
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->isCancelled()Z

    move-result v17

    if-eqz v17, :cond_9

    .line 157
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/sso/SignedHttpServerConnection;->close()V

    .line 159
    :cond_9
    monitor-exit p0
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_4

    throw v16

    .line 145
    .restart local v4    # "b":Ljava/lang/StringBuilder;
    .restart local v6    # "buffer":[B
    .restart local v10    # "e":Ljava/io/IOException;
    .restart local v11    # "error":Ljava/io/InputStream;
    :cond_a
    :try_start_8
    const-string/jumbo v16, "Amazon.SSOUtil"

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v16 .. v17}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 147
    .end local v4    # "b":Ljava/lang/StringBuilder;
    .end local v6    # "buffer":[B
    .end local v11    # "error":Ljava/io/InputStream;
    :cond_b
    throw v10
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_3

    .line 159
    .end local v10    # "e":Ljava/io/IOException;
    :catchall_4
    move-exception v16

    :try_start_9
    monitor-exit p0
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_4

    throw v16
.end method
