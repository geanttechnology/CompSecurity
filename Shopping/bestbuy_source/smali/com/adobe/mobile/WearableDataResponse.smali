.class Lcom/adobe/mobile/WearableDataResponse;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field protected success:Z


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mobile/WearableDataResponse;->success:Z

    .line 77
    return-void
.end method

.method static synthetic access$000(Lcom/google/android/gms/wearable/Asset;Ljava/lang/String;Lqm;)V
    .locals 0

    .prologue
    .line 35
    invoke-static {p0, p1, p2}, Lcom/adobe/mobile/WearableDataResponse;->saveFileFromAsset(Lcom/google/android/gms/wearable/Asset;Ljava/lang/String;Lqm;)V

    return-void
.end method

.method protected static createResponseFromDataMap(Latz;Lqm;)Lcom/adobe/mobile/WearableDataResponse;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 150
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Latz;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 168
    :cond_0
    :goto_0
    return-object v0

    .line 153
    :cond_1
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "POST"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 154
    new-instance v0, Lcom/adobe/mobile/WearableDataResponse$PostResponse;

    invoke-direct {v0, p0}, Lcom/adobe/mobile/WearableDataResponse$PostResponse;-><init>(Latz;)V

    goto :goto_0

    .line 156
    :cond_2
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "GET"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 157
    new-instance v0, Lcom/adobe/mobile/WearableDataResponse$GetResponse;

    invoke-direct {v0, p0}, Lcom/adobe/mobile/WearableDataResponse$GetResponse;-><init>(Latz;)V

    goto :goto_0

    .line 159
    :cond_3
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "Config"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 160
    new-instance v0, Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;

    invoke-direct {v0, p0}, Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;-><init>(Latz;)V

    goto :goto_0

    .line 162
    :cond_4
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "File"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 163
    new-instance v0, Lcom/adobe/mobile/WearableDataResponse$CacheResponse;

    invoke-direct {v0, p0, p1}, Lcom/adobe/mobile/WearableDataResponse$CacheResponse;-><init>(Latz;Lqm;)V

    goto :goto_0

    .line 165
    :cond_5
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "ThirdParty"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 166
    new-instance v0, Lcom/adobe/mobile/WearableDataResponse$ThirdPartyResponse;

    invoke-direct {v0, p0}, Lcom/adobe/mobile/WearableDataResponse$ThirdPartyResponse;-><init>(Latz;)V

    goto :goto_0
.end method

.method private static saveFileFromAsset(Lcom/google/android/gms/wearable/Asset;Ljava/lang/String;Lqm;)V
    .locals 7

    .prologue
    const/4 v5, 0x0

    .line 110
    if-eqz p0, :cond_0

    if-nez p2, :cond_1

    .line 147
    :cond_0
    :goto_0
    return-void

    .line 113
    :cond_1
    const-wide/16 v0, 0x3a98

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {p2, v0, v1, v2}, Lqm;->a(JLjava/util/concurrent/TimeUnit;)Lpp;

    move-result-object v0

    .line 114
    invoke-virtual {v0}, Lpp;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 118
    sget-object v0, Lauj;->a:Latr;

    invoke-interface {v0, p2, p0}, Latr;->a(Lqm;Lcom/google/android/gms/wearable/Asset;)Lqq;

    move-result-object v0

    invoke-interface {v0}, Lqq;->b()Lqt;

    move-result-object v0

    check-cast v0, Latu;

    invoke-interface {v0}, Latu;->c()Ljava/io/InputStream;

    move-result-object v2

    .line 119
    invoke-interface {p2}, Lqm;->c()V

    .line 121
    if-eqz v2, :cond_0

    .line 125
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 126
    const/4 v1, 0x0

    .line 128
    :try_start_0
    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_7
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 129
    const/16 v1, 0x2000

    :try_start_1
    new-array v1, v1, [B

    .line 131
    :goto_1
    invoke-virtual {v2, v1}, Ljava/io/InputStream;->read([B)I

    move-result v3

    const/4 v4, -0x1

    if-eq v3, v4, :cond_2

    .line 132
    const/4 v4, 0x0

    invoke-virtual {v0, v1, v4, v3}, Ljava/io/OutputStream;->write([BII)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    .line 134
    :catch_0
    move-exception v1

    .line 135
    :goto_2
    :try_start_2
    const-string v1, "Wearable - Failed to save cache file"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 139
    if-eqz v0, :cond_0

    .line 141
    :try_start_3
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 142
    :catch_1
    move-exception v0

    .line 143
    const-string v0, "Wearable - Failed to close file output stream"

    new-array v1, v5, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 139
    :cond_2
    if-eqz v0, :cond_0

    .line 141
    :try_start_4
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_0

    .line 142
    :catch_2
    move-exception v0

    .line 143
    const-string v0, "Wearable - Failed to close file output stream"

    new-array v1, v5, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 136
    :catch_3
    move-exception v0

    move-object v0, v1

    .line 137
    :goto_3
    :try_start_5
    const-string v1, "Wearable - Failed to save cache file"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 139
    if-eqz v0, :cond_0

    .line 141
    :try_start_6
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4

    goto :goto_0

    .line 142
    :catch_4
    move-exception v0

    .line 143
    const-string v0, "Wearable - Failed to close file output stream"

    new-array v1, v5, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 139
    :catchall_0
    move-exception v0

    :goto_4
    if-eqz v1, :cond_3

    .line 141
    :try_start_7
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_5

    .line 144
    :cond_3
    :goto_5
    throw v0

    .line 142
    :catch_5
    move-exception v1

    .line 143
    const-string v1, "Wearable - Failed to close file output stream"

    new-array v2, v5, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_5

    .line 139
    :catchall_1
    move-exception v1

    move-object v6, v1

    move-object v1, v0

    move-object v0, v6

    goto :goto_4

    .line 136
    :catch_6
    move-exception v1

    goto :goto_3

    .line 134
    :catch_7
    move-exception v0

    move-object v0, v1

    goto :goto_2
.end method


# virtual methods
.method protected isSuccess()Z
    .locals 1

    .prologue
    .line 39
    iget-boolean v0, p0, Lcom/adobe/mobile/WearableDataResponse;->success:Z

    return v0
.end method
