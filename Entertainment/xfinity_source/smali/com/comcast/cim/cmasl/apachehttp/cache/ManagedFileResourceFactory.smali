.class public Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;
.super Ljava/lang/Object;
.source "ManagedFileResourceFactory.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/cache/ResourceFactory;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private cacheDirInitialized:Z

.field private final delegate:Lcom/comcast/cim/cmasl/apachehttp/cache/FileResourceFactory;

.field private final resourceDirectory:Ljava/io/File;

.field private final resourceReferences:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;",
            ">;"
        }
    .end annotation
.end field

.field private final unusedResourceQueue:Ljava/lang/ref/ReferenceQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/ReferenceQueue",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/io/File;)V
    .locals 2
    .param p1, "resourceDirectory"    # Ljava/io/File;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->cacheDirInitialized:Z

    .line 28
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->resourceReferences:Ljava/util/List;

    .line 30
    new-instance v0, Ljava/lang/ref/ReferenceQueue;

    invoke-direct {v0}, Ljava/lang/ref/ReferenceQueue;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->unusedResourceQueue:Ljava/lang/ref/ReferenceQueue;

    .line 33
    iput-object p1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->resourceDirectory:Ljava/io/File;

    .line 34
    new-instance v0, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResourceFactory;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->resourceDirectory:Ljava/io/File;

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResourceFactory;-><init>(Ljava/io/File;)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->delegate:Lcom/comcast/cim/cmasl/apachehttp/cache/FileResourceFactory;

    .line 35
    return-void
.end method

.method private declared-synchronized initializeResourceDirOnce()V
    .locals 3

    .prologue
    .line 56
    monitor-enter p0

    :try_start_0
    iget-boolean v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->cacheDirInitialized:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 69
    :goto_0
    monitor-exit p0

    return-void

    .line 59
    :cond_0
    :try_start_1
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->resourceDirectory:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->resourceDirectory:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->mkdir()Z

    move-result v1

    if-nez v1, :cond_1

    .line 60
    new-instance v1, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    const-string v2, "Failed to create resource directory"

    invoke-direct {v1, v2}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 56
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 64
    :cond_1
    :try_start_2
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->resourceDirectory:Ljava/io/File;

    invoke-static {v1}, Lorg/apache/commons/io/FileUtils;->cleanDirectory(Ljava/io/File;)V

    .line 65
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->cacheDirInitialized:Z
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 66
    :catch_0
    move-exception v0

    .line 67
    .local v0, "e":Ljava/io/IOException;
    :try_start_3
    new-instance v1, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v1, v0}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0
.end method

.method private registerResourceReference(Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)V
    .locals 4
    .param p1, "resource"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    .prologue
    .line 72
    if-eqz p1, :cond_0

    .line 74
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->resourceReferences:Ljava/util/List;

    new-instance v2, Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;

    move-object v0, p1

    check-cast v0, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResource;->getFile()Ljava/io/File;

    move-result-object v0

    iget-object v3, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->unusedResourceQueue:Ljava/lang/ref/ReferenceQueue;

    invoke-direct {v2, v0, p1, v3}, Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;-><init>(Ljava/io/File;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;Ljava/lang/ref/ReferenceQueue;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 76
    :cond_0
    return-void
.end method


# virtual methods
.method public cleanUnusedResources()V
    .locals 4

    .prologue
    .line 80
    :goto_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->unusedResourceQueue:Ljava/lang/ref/ReferenceQueue;

    invoke-virtual {v2}, Ljava/lang/ref/ReferenceQueue;->poll()Ljava/lang/ref/Reference;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;

    .local v1, "ref":Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;
    if-eqz v1, :cond_1

    .line 81
    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/apachehttp/cache/ResourceReference;->getBackingFile()Ljava/io/File;

    move-result-object v0

    .line 82
    .local v0, "backingFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    move-result v2

    if-nez v2, :cond_0

    .line 83
    sget-object v2, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Failed to delete unused backing file {}"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Object;)V

    .line 87
    :goto_1
    iget-object v2, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->resourceReferences:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    .line 85
    :cond_0
    sget-object v2, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Deleted an unused backing file {}"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_1

    .line 89
    .end local v0    # "backingFile":Ljava/io/File;
    :cond_1
    return-void
.end method

.method public copy(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .locals 2
    .param p1, "requestId"    # Ljava/lang/String;
    .param p2, "resource"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->initializeResourceDirOnce()V

    .line 49
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->delegate:Lcom/comcast/cim/cmasl/apachehttp/cache/FileResourceFactory;

    invoke-virtual {v1, p1, p2}, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResourceFactory;->copy(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v0

    .line 50
    .local v0, "resourceCopy":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    invoke-direct {p0, v0}, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->registerResourceReference(Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)V

    .line 51
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->cleanUnusedResources()V

    .line 52
    return-object v0
.end method

.method public generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    .locals 2
    .param p1, "requestId"    # Ljava/lang/String;
    .param p2, "instream"    # Ljava/io/InputStream;
    .param p3, "limit"    # Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->initializeResourceDirOnce()V

    .line 40
    iget-object v1, p0, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->delegate:Lcom/comcast/cim/cmasl/apachehttp/cache/FileResourceFactory;

    invoke-virtual {v1, p1, p2, p3}, Lcom/comcast/cim/cmasl/apachehttp/cache/FileResourceFactory;->generate(Ljava/lang/String;Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/client/cache/InputLimit;)Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;

    move-result-object v0

    .line 41
    .local v0, "resource":Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;
    invoke-direct {p0, v0}, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->registerResourceReference(Lcom/comcast/cim/httpcomponentsandroid/client/cache/Resource;)V

    .line 42
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/apachehttp/cache/ManagedFileResourceFactory;->cleanUnusedResources()V

    .line 43
    return-object v0
.end method
