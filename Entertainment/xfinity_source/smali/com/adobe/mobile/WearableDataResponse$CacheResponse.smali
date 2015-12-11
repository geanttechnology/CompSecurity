.class Lcom/adobe/mobile/WearableDataResponse$CacheResponse;
.super Lcom/adobe/mobile/WearableDataResponse;
.source "WearableDataResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mobile/WearableDataResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "CacheResponse"
.end annotation


# instance fields
.field final result:Z


# direct methods
.method protected constructor <init>(Lcom/google/android/gms/wearable/DataMap;Lcom/google/android/gms/common/api/GoogleApiClient;)V
    .locals 7
    .param p1, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;
    .param p2, "mGoogleApiClient"    # Lcom/google/android/gms/common/api/GoogleApiClient;

    .prologue
    .line 79
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataResponse;-><init>()V

    .line 80
    const-string v5, "FileFound"

    invoke-virtual {p1, v5}, Lcom/google/android/gms/wearable/DataMap;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    .line 81
    .local v2, "fileFound":Z
    if-nez v2, :cond_1

    .line 82
    const-string v5, "adbdownloadcache"

    invoke-static {v5}, Lcom/adobe/mobile/RemoteDownload;->deleteFilesInDirectory(Ljava/lang/String;)V

    .line 83
    const/4 v5, 0x0

    iput-boolean v5, p0, Lcom/adobe/mobile/WearableDataResponse$CacheResponse;->result:Z

    .line 102
    :cond_0
    :goto_0
    return-void

    .line 86
    :cond_1
    const-string v5, "Updated"

    invoke-virtual {p1, v5}, Lcom/google/android/gms/wearable/DataMap;->getBoolean(Ljava/lang/String;)Z

    move-result v5

    iput-boolean v5, p0, Lcom/adobe/mobile/WearableDataResponse$CacheResponse;->result:Z

    .line 87
    iget-boolean v5, p0, Lcom/adobe/mobile/WearableDataResponse$CacheResponse;->result:Z

    if-eqz v5, :cond_0

    .line 88
    const-string v5, "URL"

    invoke-virtual {p1, v5}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 89
    .local v4, "url":Ljava/lang/String;
    const-string v5, "adbdownloadcache"

    invoke-static {v4, v5}, Lcom/adobe/mobile/RemoteDownload;->deleteCachedDataForURL(Ljava/lang/String;Ljava/lang/String;)Z

    .line 93
    const-string v5, "FileContent"

    invoke-virtual {p1, v5}, Lcom/google/android/gms/wearable/DataMap;->getAsset(Ljava/lang/String;)Lcom/google/android/gms/wearable/Asset;

    move-result-object v0

    .line 94
    .local v0, "asset":Lcom/google/android/gms/wearable/Asset;
    const-string v5, "FileName"

    invoke-virtual {p1, v5}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 95
    .local v3, "fileName":Ljava/lang/String;
    const-string v5, "adbdownloadcache"

    invoke-static {v5}, Lcom/adobe/mobile/RemoteDownload;->getDownloadCacheDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    .line 96
    .local v1, "dir":Ljava/io/File;
    if-eqz v1, :cond_0

    .line 100
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    # invokes: Lcom/adobe/mobile/WearableDataResponse;->saveFileFromAsset(Lcom/google/android/gms/wearable/Asset;Ljava/lang/String;Lcom/google/android/gms/common/api/GoogleApiClient;)V
    invoke-static {v0, v5, p2}, Lcom/adobe/mobile/WearableDataResponse;->access$000(Lcom/google/android/gms/wearable/Asset;Ljava/lang/String;Lcom/google/android/gms/common/api/GoogleApiClient;)V

    goto :goto_0
.end method


# virtual methods
.method protected getResult()Z
    .locals 1

    .prologue
    .line 104
    iget-boolean v0, p0, Lcom/adobe/mobile/WearableDataResponse$CacheResponse;->result:Z

    return v0
.end method
