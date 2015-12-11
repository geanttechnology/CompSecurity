.class public Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;
.super Ljava/lang/Object;
.source "NamespacedFileCache.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/StorageCache;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizer;,
        Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizerFactory;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final context:Landroid/content/Context;

.field private final namespace:Ljava/lang/String;

.field private final normalizer:Lcom/comcast/cim/cmasl/cachelib/Normalizer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "namespace"    # Ljava/lang/String;

    .prologue
    .line 31
    new-instance v0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizerFactory;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$DefaultNormalizerFactory;-><init>(Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;)V

    invoke-direct {p0, p1, p2, v0}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;)V

    .line 32
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "namespace"    # Ljava/lang/String;
    .param p3, "normalizerFactory"    # Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 36
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notBlank(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 37
    iput-object p1, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->context:Landroid/content/Context;

    .line 38
    iput-object p2, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->namespace:Ljava/lang/String;

    .line 39
    invoke-interface {p3, p2}, Lcom/comcast/cim/cmasl/cachelib/NormalizerFactory;->get(Ljava/lang/String;)Lcom/comcast/cim/cmasl/cachelib/Normalizer;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->normalizer:Lcom/comcast/cim/cmasl/cachelib/Normalizer;

    .line 40
    return-void
.end method

.method static synthetic access$100(Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->namespace:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public remove(Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 76
    iget-object v1, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->normalizer:Lcom/comcast/cim/cmasl/cachelib/Normalizer;

    invoke-interface {v1, p1}, Lcom/comcast/cim/cmasl/cachelib/Normalizer;->normalize(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 77
    .local v0, "normalizedKey":Ljava/lang/String;
    iget-object v1, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    .line 78
    return-void
.end method

.method public removeAll()V
    .locals 9

    .prologue
    .line 82
    sget-object v6, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->LOG:Lorg/slf4j/Logger;

    const-string v7, "Removing all entries for namespace {}"

    iget-object v8, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->namespace:Ljava/lang/String;

    invoke-interface {v6, v7, v8}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 83
    iget-object v6, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->context:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v1

    .line 84
    .local v1, "directory":Ljava/io/File;
    new-instance v3, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;

    invoke-direct {v3, p0}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache$1;-><init>(Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;)V

    .line 91
    .local v3, "filter":Ljava/io/FilenameFilter;
    invoke-virtual {v1, v3}, Ljava/io/File;->listFiles(Ljava/io/FilenameFilter;)[Ljava/io/File;

    move-result-object v0

    .local v0, "arr$":[Ljava/io/File;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_0

    aget-object v2, v0, v4

    .line 92
    .local v2, "file":Ljava/io/File;
    iget-object v6, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->context:Landroid/content/Context;

    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    .line 91
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 94
    .end local v2    # "file":Ljava/io/File;
    :cond_0
    return-void
.end method

.method public retrieve(Ljava/lang/String;)Ljava/io/InputStream;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 60
    iget-object v2, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->normalizer:Lcom/comcast/cim/cmasl/cachelib/Normalizer;

    invoke-interface {v2, p1}, Lcom/comcast/cim/cmasl/cachelib/Normalizer;->normalize(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 62
    .local v1, "normalizedKey":Ljava/lang/String;
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->context:Landroid/content/Context;

    invoke-virtual {v2, v1}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 64
    :goto_0
    return-object v2

    .line 63
    :catch_0
    move-exception v0

    .line 64
    .local v0, "e":Ljava/io/FileNotFoundException;
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public store(Ljava/io/InputStream;Ljava/lang/String;)V
    .locals 7
    .param p1, "data"    # Ljava/io/InputStream;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 44
    iget-object v4, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->normalizer:Lcom/comcast/cim/cmasl/cachelib/Normalizer;

    invoke-interface {v4, p2}, Lcom/comcast/cim/cmasl/cachelib/Normalizer;->normalize(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 45
    .local v2, "normalizedKey":Ljava/lang/String;
    const/4 v3, 0x0

    .line 47
    .local v3, "os":Ljava/io/OutputStream;
    :try_start_0
    iget-object v4, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->context:Landroid/content/Context;

    const/4 v5, 0x0

    invoke-virtual {v4, v2, v5}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v3

    .line 48
    invoke-static {p1, v3}, Lorg/apache/commons/io/IOUtils;->copy(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 53
    invoke-static {p1}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 54
    invoke-static {v3}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    .line 56
    return-void

    .line 49
    :catch_0
    move-exception v1

    .line 50
    .local v1, "e":Ljava/io/IOException;
    :try_start_1
    iget-object v4, p0, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->context:Landroid/content/Context;

    invoke-virtual {v4, v2}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    move-result v0

    .line 51
    .local v0, "deleted":Z
    new-instance v5, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Failed to store stream with key "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, ", cache file was "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    if-eqz v0, :cond_0

    const-string v4, "deleted"

    :goto_0
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v5, v4, v1}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 53
    .end local v0    # "deleted":Z
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    invoke-static {p1}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/InputStream;)V

    .line 54
    invoke-static {v3}, Lorg/apache/commons/io/IOUtils;->closeQuietly(Ljava/io/OutputStream;)V

    throw v4

    .line 51
    .restart local v0    # "deleted":Z
    .restart local v1    # "e":Ljava/io/IOException;
    :cond_0
    :try_start_2
    const-string v4, "not deleted"
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method
