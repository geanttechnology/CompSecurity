.class public Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;
.super Ljava/lang/Object;
.source "PersistentCaptionsCache.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field public static final NAMESPACE:Ljava/lang/String;


# instance fields
.field private final storageCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;->NAMESPACE:Ljava/lang/String;

    .line 16
    const-class v0, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;)V
    .locals 0
    .param p1, "storageCache"    # Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;->storageCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    .line 25
    return-void
.end method


# virtual methods
.method public clear()V
    .locals 2

    .prologue
    .line 38
    iget-object v1, p0, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;->storageCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    monitor-enter v1

    .line 39
    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;->storageCache:Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/cachelib/NamespacedFileCache;->removeAll()V

    .line 40
    monitor-exit v1

    .line 41
    return-void

    .line 40
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
