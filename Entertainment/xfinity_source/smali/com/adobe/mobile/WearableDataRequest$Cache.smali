.class Lcom/adobe/mobile/WearableDataRequest$Cache;
.super Lcom/adobe/mobile/WearableDataRequest;
.source "WearableDataRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mobile/WearableDataRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Cache"
.end annotation


# instance fields
.field protected fileName:Ljava/lang/String;

.field protected url:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Lcom/google/android/gms/wearable/DataMap;)V
    .locals 1
    .param p1, "dataMap"    # Lcom/google/android/gms/wearable/DataMap;

    .prologue
    .line 271
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataRequest;-><init>()V

    .line 272
    const-string v0, "ID"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->uuid:Ljava/lang/String;

    .line 273
    const-string v0, "FileName"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->fileName:Ljava/lang/String;

    .line 274
    const-string v0, "URL"

    invoke-virtual {p1, v0}, Lcom/google/android/gms/wearable/DataMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->url:Ljava/lang/String;

    .line 275
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "fileName"    # Ljava/lang/String;
    .param p3, "timeOut"    # I

    .prologue
    .line 266
    invoke-direct {p0, p3}, Lcom/adobe/mobile/WearableDataRequest;-><init>(I)V

    .line 267
    iput-object p1, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->url:Ljava/lang/String;

    .line 268
    iput-object p2, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->fileName:Ljava/lang/String;

    .line 269
    return-void
.end method


# virtual methods
.method protected getDataMap()Lcom/google/android/gms/wearable/DataMap;
    .locals 3

    .prologue
    .line 278
    new-instance v0, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v0}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 279
    .local v0, "dataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v1, "Type"

    const-string v2, "File"

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 281
    const-string v1, "URL"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->url:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 282
    const-string v1, "FileName"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->fileName:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 283
    return-object v0
.end method

.method protected handle(Landroid/content/Context;)Lcom/google/android/gms/wearable/DataMap;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 287
    new-instance v2, Lcom/google/android/gms/wearable/DataMap;

    invoke-direct {v2}, Lcom/google/android/gms/wearable/DataMap;-><init>()V

    .line 288
    .local v2, "responseDataMap":Lcom/google/android/gms/wearable/DataMap;
    const-string v3, "ID"

    iget-object v4, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->uuid:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 289
    const-string v3, "Type"

    const-string v4, "File"

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 290
    const-string v3, "URL"

    iget-object v4, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->url:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    iget-object v3, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->url:Ljava/lang/String;

    invoke-static {v3}, Lcom/adobe/mobile/RemoteDownload;->getFileForCachedURL(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 293
    .local v0, "file":Ljava/io/File;
    if-nez v0, :cond_1

    .line 294
    const-string v3, "FileFound"

    invoke-virtual {v2, v3, v5}, Lcom/google/android/gms/wearable/DataMap;->putBoolean(Ljava/lang/String;Z)V

    .line 308
    :cond_0
    :goto_0
    return-object v2

    .line 296
    :cond_1
    const-string v3, "FileFound"

    invoke-virtual {v2, v3, v6}, Lcom/google/android/gms/wearable/DataMap;->putBoolean(Ljava/lang/String;Z)V

    .line 297
    invoke-virtual {v0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->fileName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 298
    const-string v3, "Updated"

    invoke-virtual {v2, v3, v5}, Lcom/google/android/gms/wearable/DataMap;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0

    .line 300
    :cond_2
    const-string v3, "Updated"

    invoke-virtual {v2, v3, v6}, Lcom/google/android/gms/wearable/DataMap;->putBoolean(Ljava/lang/String;Z)V

    .line 301
    const-string v3, "FileName"

    invoke-virtual {v0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/wearable/DataMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 302
    # invokes: Lcom/adobe/mobile/WearableDataRequest;->readFile(Ljava/io/File;)[B
    invoke-static {v0}, Lcom/adobe/mobile/WearableDataRequest;->access$000(Ljava/io/File;)[B

    move-result-object v1

    .line 303
    .local v1, "fileContents":[B
    if-eqz v1, :cond_0

    array-length v3, v1

    if-lez v3, :cond_0

    .line 304
    const-string v3, "FileContent"

    invoke-static {v1}, Lcom/google/android/gms/wearable/Asset;->createFromBytes([B)Lcom/google/android/gms/wearable/Asset;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/wearable/DataMap;->putAsset(Ljava/lang/String;Lcom/google/android/gms/wearable/Asset;)V

    goto :goto_0
.end method
