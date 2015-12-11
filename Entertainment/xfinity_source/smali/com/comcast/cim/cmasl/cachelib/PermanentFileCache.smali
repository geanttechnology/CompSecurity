.class public Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;
.super Ljava/lang/Object;
.source "PermanentFileCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/StorageCache;


# instance fields
.field private final context:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;->context:Landroid/content/Context;

    .line 21
    return-void
.end method


# virtual methods
.method public remove(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;->context:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    .line 55
    return-void
.end method

.method public removeAll()V
    .locals 6

    .prologue
    .line 59
    iget-object v5, p0, Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;->context:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v1

    .line 60
    .local v1, "directory":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v0

    .local v0, "arr$":[Ljava/io/File;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v2, v0, v3

    .line 61
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;->remove(Ljava/lang/String;)V

    .line 60
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 63
    .end local v2    # "file":Ljava/io/File;
    :cond_0
    return-void
.end method

.method public retrieve(Ljava/lang/String;)Ljava/io/InputStream;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 41
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;->context:Landroid/content/Context;

    invoke-virtual {v1, p1}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 43
    :goto_0
    return-object v1

    .line 42
    :catch_0
    move-exception v0

    .line 43
    .local v0, "e":Ljava/io/FileNotFoundException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public store(Ljava/io/InputStream;Ljava/lang/String;)V
    .locals 6
    .param p1, "data"    # Ljava/io/InputStream;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 25
    const/4 v2, 0x0

    .line 27
    .local v2, "os":Ljava/io/OutputStream;
    :try_start_0
    iget-object v3, p0, Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;->context:Landroid/content/Context;

    const/4 v4, 0x0

    invoke-virtual {v3, p2, v4}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v2

    .line 28
    invoke-static {p1, v2}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 33
    invoke-static {p1}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 34
    invoke-static {v2}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    .line 36
    return-void

    .line 29
    :catch_0
    move-exception v1

    .line 30
    .local v1, "e":Ljava/io/IOException;
    :try_start_1
    iget-object v3, p0, Lcom/comcast/cim/cmasl/cachelib/PermanentFileCache;->context:Landroid/content/Context;

    invoke-virtual {v3, p2}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    move-result v0

    .line 31
    .local v0, "deleted":Z
    new-instance v4, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to store stream with key "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, ", cache file was "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    if-eqz v0, :cond_0

    const-string v3, "deleted"

    :goto_0
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v4, v3, v1}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 33
    .end local v0    # "deleted":Z
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v3

    invoke-static {p1}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 34
    invoke-static {v2}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    throw v3

    .line 31
    .restart local v0    # "deleted":Z
    .restart local v1    # "e":Ljava/io/IOException;
    :cond_0
    :try_start_2
    const-string v3, "not deleted"
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method
