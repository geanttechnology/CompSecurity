.class Lcom/adobe/mobile/WearableDataRequest$Cache;
.super Lcom/adobe/mobile/WearableDataRequest;
.source "SourceFile"


# instance fields
.field protected fileName:Ljava/lang/String;

.field protected url:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Latz;)V
    .locals 1

    .prologue
    .line 271
    invoke-direct {p0}, Lcom/adobe/mobile/WearableDataRequest;-><init>()V

    .line 272
    const-string v0, "ID"

    invoke-virtual {p1, v0}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->uuid:Ljava/lang/String;

    .line 273
    const-string v0, "FileName"

    invoke-virtual {p1, v0}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->fileName:Ljava/lang/String;

    .line 274
    const-string v0, "URL"

    invoke-virtual {p1, v0}, Latz;->f(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->url:Ljava/lang/String;

    .line 275
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0

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
.method protected getDataMap()Latz;
    .locals 3

    .prologue
    .line 278
    new-instance v0, Latz;

    invoke-direct {v0}, Latz;-><init>()V

    .line 279
    const-string v1, "Type"

    const-string v2, "File"

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 281
    const-string v1, "URL"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->url:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 282
    const-string v1, "FileName"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->fileName:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 283
    return-object v0
.end method

.method protected handle(Landroid/content/Context;)Latz;
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 287
    new-instance v0, Latz;

    invoke-direct {v0}, Latz;-><init>()V

    .line 288
    const-string v1, "ID"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->uuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 289
    const-string v1, "Type"

    const-string v2, "File"

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 290
    const-string v1, "URL"

    iget-object v2, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->url:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    iget-object v1, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->url:Ljava/lang/String;

    invoke-static {v1}, Lcom/adobe/mobile/RemoteDownload;->getFileForCachedURL(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    .line 293
    if-nez v1, :cond_1

    .line 294
    const-string v1, "FileFound"

    invoke-virtual {v0, v1, v4}, Latz;->a(Ljava/lang/String;Z)V

    .line 308
    :cond_0
    :goto_0
    return-object v0

    .line 296
    :cond_1
    const-string v2, "FileFound"

    invoke-virtual {v0, v2, v5}, Latz;->a(Ljava/lang/String;Z)V

    .line 297
    invoke-virtual {v1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mobile/WearableDataRequest$Cache;->fileName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 298
    const-string v1, "Updated"

    invoke-virtual {v0, v1, v4}, Latz;->a(Ljava/lang/String;Z)V

    goto :goto_0

    .line 300
    :cond_2
    const-string v2, "Updated"

    invoke-virtual {v0, v2, v5}, Latz;->a(Ljava/lang/String;Z)V

    .line 301
    const-string v2, "FileName"

    invoke-virtual {v1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Latz;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 302
    # invokes: Lcom/adobe/mobile/WearableDataRequest;->readFile(Ljava/io/File;)[B
    invoke-static {v1}, Lcom/adobe/mobile/WearableDataRequest;->access$000(Ljava/io/File;)[B

    move-result-object v1

    .line 303
    if-eqz v1, :cond_0

    array-length v2, v1

    if-lez v2, :cond_0

    .line 304
    const-string v2, "FileContent"

    invoke-static {v1}, Lcom/google/android/gms/wearable/Asset;->a([B)Lcom/google/android/gms/wearable/Asset;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Latz;->a(Ljava/lang/String;Lcom/google/android/gms/wearable/Asset;)V

    goto :goto_0
.end method
