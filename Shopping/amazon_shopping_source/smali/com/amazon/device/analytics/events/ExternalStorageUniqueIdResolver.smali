.class public Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;
.super Lcom/amazon/device/analytics/events/UniqueIdResolverChain;
.source "ExternalStorageUniqueIdResolver.java"


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private final fileManager:Lcom/amazon/device/analytics/util/FileManager;

.field private final uniqueIdFile:Ljava/io/File;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/analytics/util/FileManager;Lcom/amazon/device/analytics/events/UniqueIdResolver;)V
    .locals 2
    .param p1, "fileManager"    # Lcom/amazon/device/analytics/util/FileManager;
    .param p2, "resolver"    # Lcom/amazon/device/analytics/events/UniqueIdResolver;

    .prologue
    .line 31
    invoke-direct {p0, p2}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;-><init>(Lcom/amazon/device/analytics/events/UniqueIdResolver;)V

    .line 32
    iput-object p1, p0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->fileManager:Lcom/amazon/device/analytics/util/FileManager;

    .line 33
    const-string/jumbo v0, "Android/data/amazon"

    const-string/jumbo v1, "amzn-unique.txt"

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/util/FileManager;->createFile(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->uniqueIdFile:Ljava/io/File;

    .line 34
    return-void
.end method


# virtual methods
.method public toJSONObject()Lorg/json/JSONObject;
    .locals 3

    .prologue
    .line 49
    invoke-super {p0}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v0

    .line 51
    .local v0, "json":Lorg/json/JSONObject;
    iget-object v1, p0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->uniqueIdFile:Ljava/io/File;

    if-eqz v1, :cond_0

    .line 53
    :try_start_0
    const-string/jumbo v1, "uniqueIdFile"

    iget-object v2, p0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->uniqueIdFile:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 57
    :cond_0
    :goto_0
    return-object v0

    .line 54
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v1

    .line 40
    .local v1, "json":Lorg/json/JSONObject;
    const/4 v2, 0x4

    :try_start_0
    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 42
    :goto_0
    return-object v2

    .line 41
    :catch_0
    move-exception v0

    .line 42
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public tryResolve()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 65
    iget-object v2, p0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->fileManager:Lcom/amazon/device/analytics/util/FileManager;

    invoke-virtual {v2}, Lcom/amazon/device/analytics/util/FileManager;->isExternalStoragePresent()Z

    move-result v2

    if-nez v2, :cond_0

    .line 73
    :goto_0
    return-object v1

    .line 70
    :cond_0
    :try_start_0
    iget-object v2, p0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->fileManager:Lcom/amazon/device/analytics/util/FileManager;

    iget-object v3, p0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->uniqueIdFile:Ljava/io/File;

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/util/FileManager;->readFileContents(Ljava/io/File;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 71
    :catch_0
    move-exception v0

    .line 72
    .local v0, "ex":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->logger:Lcom/amazon/device/analytics/log/Logger;

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public tryStore(Ljava/lang/String;)Z
    .locals 4
    .param p1, "uniqueId"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 82
    iget-object v2, p0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->fileManager:Lcom/amazon/device/analytics/util/FileManager;

    invoke-virtual {v2}, Lcom/amazon/device/analytics/util/FileManager;->isExternalStorageWritable()Z

    move-result v2

    if-nez v2, :cond_0

    .line 89
    :goto_0
    return v1

    .line 87
    :cond_0
    :try_start_0
    iget-object v2, p0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->fileManager:Lcom/amazon/device/analytics/util/FileManager;

    iget-object v3, p0, Lcom/amazon/device/analytics/events/ExternalStorageUniqueIdResolver;->uniqueIdFile:Ljava/io/File;

    invoke-virtual {v2, v3, p1}, Lcom/amazon/device/analytics/util/FileManager;->writeFileContents(Ljava/io/File;Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    goto :goto_0

    .line 88
    :catch_0
    move-exception v0

    .line 89
    .local v0, "ex":Ljava/lang/Exception;
    goto :goto_0
.end method
