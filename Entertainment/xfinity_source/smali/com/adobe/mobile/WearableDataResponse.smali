.class Lcom/adobe/mobile/WearableDataResponse;
.super Ljava/lang/Object;
.source "WearableDataResponse.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mobile/WearableDataResponse$CacheResponse;,
        Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;,
        Lcom/adobe/mobile/WearableDataResponse$ThirdPartyResponse;,
        Lcom/adobe/mobile/WearableDataResponse$PostResponse;,
        Lcom/adobe/mobile/WearableDataResponse$GetResponse;
    }
.end annotation


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

.method static synthetic access$000(Lcom/google/android/gms/wearable/Asset;Ljava/lang/String;Lcom/google/android/gms/common/api/GoogleApiClient;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gms/wearable/Asset;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/google/android/gms/common/api/GoogleApiClient;

    .prologue
    .line 35
    invoke-static {p0, p1, p2}, Lcom/adobe/mobile/WearableDataResponse;->saveFileFromAsset(Lcom/google/android/gms/wearable/Asset;Ljava/lang/String;Lcom/google/android/gms/common/api/GoogleApiClient;)V

    return-void
.end method

.method protected static createResponseFromDataMap(Lcom/google/android/gms/wearable/DataMap;Lcom/google/android/gms/common/api/GoogleApiClient;)Lcom/adobe/mobile/WearableDataResponse;
    .locals 3
    .param p0, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;
    .param p1, "mGoogleApiClient"    # Lcom/google/android/gms/common/api/GoogleApiClient;

    .prologue
    const/4 v0, 0x0

    .line 150
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Lcom/google/android/gms/wearable/DataMap;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 168
    :cond_0
    :goto_0
    return-object v0

    .line 153
    :cond_1
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "POST"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 154
    new-instance v0, Lcom/adobe/mobile/WearableDataResponse$PostResponse;

    invoke-direct {v0, p0}, Lcom/adobe/mobile/WearableDataResponse$PostResponse;-><init>(Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0

    .line 156
    :cond_2
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "GET"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 157
    new-instance v0, Lcom/adobe/mobile/WearableDataResponse$GetResponse;

    invoke-direct {v0, p0}, Lcom/adobe/mobile/WearableDataResponse$GetResponse;-><init>(Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0

    .line 159
    :cond_3
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "Config"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 160
    new-instance v0, Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;

    invoke-direct {v0, p0}, Lcom/adobe/mobile/WearableDataResponse$ShareConfigResponse;-><init>(Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0

    .line 162
    :cond_4
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "File"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 163
    new-instance v0, Lcom/adobe/mobile/WearableDataResponse$CacheResponse;

    invoke-direct {v0, p0, p1}, Lcom/adobe/mobile/WearableDataResponse$CacheResponse;-><init>(Lcom/google/android/gms/wearable/DataMap;Lcom/google/android/gms/common/api/GoogleApiClient;)V

    goto :goto_0

    .line 165
    :cond_5
    const-string v1, "Type"

    invoke-virtual {p0, v1}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "ThirdParty"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 166
    new-instance v0, Lcom/adobe/mobile/WearableDataResponse$ThirdPartyResponse;

    invoke-direct {v0, p0}, Lcom/adobe/mobile/WearableDataResponse$ThirdPartyResponse;-><init>(Lcom/google/android/gms/wearable/DataMap;)V

    goto :goto_0
.end method

.method private static saveFileFromAsset(Lcom/google/android/gms/wearable/Asset;Ljava/lang/String;Lcom/google/android/gms/common/api/GoogleApiClient;)V
    .locals 12
    .param p0, "asset"    # Lcom/google/android/gms/wearable/Asset;
    .param p1, "fileName"    # Ljava/lang/String;
    .param p2, "mGoogleApiClient"    # Lcom/google/android/gms/common/api/GoogleApiClient;

    .prologue
    const/4 v11, 0x0

    .line 110
    if-eqz p0, :cond_0

    if-nez p2, :cond_1

    .line 147
    :cond_0
    :goto_0
    return-void

    .line 113
    :cond_1
    const-wide/16 v8, 0x3a98

    sget-object v10, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {p2, v8, v9, v10}, Lcom/google/android/gms/common/api/GoogleApiClient;->blockingConnect(JLjava/util/concurrent/TimeUnit;)Lcom/google/android/gms/common/ConnectionResult;

    move-result-object v6

    .line 114
    .local v6, "result":Lcom/google/android/gms/common/ConnectionResult;
    invoke-virtual {v6}, Lcom/google/android/gms/common/ConnectionResult;->isSuccess()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 118
    sget-object v8, Lcom/google/android/gms/wearable/Wearable;->DataApi:Lcom/google/android/gms/wearable/DataApi;

    invoke-interface {v8, p2, p0}, Lcom/google/android/gms/wearable/DataApi;->getFdForAsset(Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/wearable/Asset;)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v8

    invoke-interface {v8}, Lcom/google/android/gms/common/api/PendingResult;->await()Lcom/google/android/gms/common/api/Result;

    move-result-object v8

    check-cast v8, Lcom/google/android/gms/wearable/DataApi$GetFdForAssetResult;

    invoke-interface {v8}, Lcom/google/android/gms/wearable/DataApi$GetFdForAssetResult;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    .line 119
    .local v0, "assetInputStream":Ljava/io/InputStream;
    invoke-interface {p2}, Lcom/google/android/gms/common/api/GoogleApiClient;->disconnect()V

    .line 121
    if-eqz v0, :cond_0

    .line 125
    new-instance v7, Ljava/io/File;

    invoke-direct {v7, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 126
    .local v7, "targetFile":Ljava/io/File;
    const/4 v4, 0x0

    .line 128
    .local v4, "outStream":Ljava/io/OutputStream;
    :try_start_0
    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v7}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_7
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 129
    .end local v4    # "outStream":Ljava/io/OutputStream;
    .local v5, "outStream":Ljava/io/OutputStream;
    const/16 v8, 0x2000

    :try_start_1
    new-array v1, v8, [B

    .line 131
    .local v1, "buffer":[B
    :goto_1
    invoke-virtual {v0, v1}, Ljava/io/InputStream;->read([B)I

    move-result v2

    .local v2, "bytesRead":I
    const/4 v8, -0x1

    if-eq v2, v8, :cond_2

    .line 132
    const/4 v8, 0x0

    invoke-virtual {v5, v1, v8, v2}, Ljava/io/OutputStream;->write([BII)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    .line 134
    .end local v1    # "buffer":[B
    .end local v2    # "bytesRead":I
    :catch_0
    move-exception v3

    move-object v4, v5

    .line 135
    .end local v5    # "outStream":Ljava/io/OutputStream;
    .local v3, "e":Ljava/io/FileNotFoundException;
    .restart local v4    # "outStream":Ljava/io/OutputStream;
    :goto_2
    :try_start_2
    const-string v8, "Wearable - Failed to save cache file"

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-static {v8, v9}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 139
    if-eqz v4, :cond_0

    .line 141
    :try_start_3
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 142
    :catch_1
    move-exception v3

    .line 143
    .local v3, "e":Ljava/io/IOException;
    const-string v8, "Wearable - Failed to close file output stream"

    new-array v9, v11, [Ljava/lang/Object;

    invoke-static {v8, v9}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 139
    .end local v3    # "e":Ljava/io/IOException;
    .end local v4    # "outStream":Ljava/io/OutputStream;
    .restart local v1    # "buffer":[B
    .restart local v2    # "bytesRead":I
    .restart local v5    # "outStream":Ljava/io/OutputStream;
    :cond_2
    if-eqz v5, :cond_4

    .line 141
    :try_start_4
    invoke-virtual {v5}, Ljava/io/OutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    move-object v4, v5

    .line 144
    .end local v5    # "outStream":Ljava/io/OutputStream;
    .restart local v4    # "outStream":Ljava/io/OutputStream;
    goto :goto_0

    .line 142
    .end local v4    # "outStream":Ljava/io/OutputStream;
    .restart local v5    # "outStream":Ljava/io/OutputStream;
    :catch_2
    move-exception v3

    .line 143
    .restart local v3    # "e":Ljava/io/IOException;
    const-string v8, "Wearable - Failed to close file output stream"

    new-array v9, v11, [Ljava/lang/Object;

    invoke-static {v8, v9}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    move-object v4, v5

    .line 144
    .end local v5    # "outStream":Ljava/io/OutputStream;
    .restart local v4    # "outStream":Ljava/io/OutputStream;
    goto :goto_0

    .line 136
    .end local v1    # "buffer":[B
    .end local v2    # "bytesRead":I
    .end local v3    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v3

    .line 137
    .restart local v3    # "e":Ljava/io/IOException;
    :goto_3
    :try_start_5
    const-string v8, "Wearable - Failed to save cache file"

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-static {v8, v9}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 139
    if-eqz v4, :cond_0

    .line 141
    :try_start_6
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4

    goto :goto_0

    .line 142
    :catch_4
    move-exception v3

    .line 143
    const-string v8, "Wearable - Failed to close file output stream"

    new-array v9, v11, [Ljava/lang/Object;

    invoke-static {v8, v9}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 139
    .end local v3    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v8

    :goto_4
    if-eqz v4, :cond_3

    .line 141
    :try_start_7
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_5

    .line 144
    :cond_3
    :goto_5
    throw v8

    .line 142
    :catch_5
    move-exception v3

    .line 143
    .restart local v3    # "e":Ljava/io/IOException;
    const-string v9, "Wearable - Failed to close file output stream"

    new-array v10, v11, [Ljava/lang/Object;

    invoke-static {v9, v10}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_5

    .line 139
    .end local v3    # "e":Ljava/io/IOException;
    .end local v4    # "outStream":Ljava/io/OutputStream;
    .restart local v5    # "outStream":Ljava/io/OutputStream;
    :catchall_1
    move-exception v8

    move-object v4, v5

    .end local v5    # "outStream":Ljava/io/OutputStream;
    .restart local v4    # "outStream":Ljava/io/OutputStream;
    goto :goto_4

    .line 136
    .end local v4    # "outStream":Ljava/io/OutputStream;
    .restart local v5    # "outStream":Ljava/io/OutputStream;
    :catch_6
    move-exception v3

    move-object v4, v5

    .end local v5    # "outStream":Ljava/io/OutputStream;
    .restart local v4    # "outStream":Ljava/io/OutputStream;
    goto :goto_3

    .line 134
    :catch_7
    move-exception v3

    goto :goto_2

    .end local v4    # "outStream":Ljava/io/OutputStream;
    .restart local v1    # "buffer":[B
    .restart local v2    # "bytesRead":I
    .restart local v5    # "outStream":Ljava/io/OutputStream;
    :cond_4
    move-object v4, v5

    .end local v5    # "outStream":Ljava/io/OutputStream;
    .restart local v4    # "outStream":Ljava/io/OutputStream;
    goto/16 :goto_0
.end method


# virtual methods
.method protected isSuccess()Z
    .locals 1

    .prologue
    .line 39
    iget-boolean v0, p0, Lcom/adobe/mobile/WearableDataResponse;->success:Z

    return v0
.end method
