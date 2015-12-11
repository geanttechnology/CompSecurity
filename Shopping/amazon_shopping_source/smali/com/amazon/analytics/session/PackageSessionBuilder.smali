.class public Lcom/amazon/analytics/session/PackageSessionBuilder;
.super Ljava/lang/Object;
.source "PackageSessionBuilder.java"


# static fields
.field private static final logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private final lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

.field private final packageSessions:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/analytics/session/PackageSession;",
            ">;"
        }
    .end annotation
.end field

.field private final readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

.field private final writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/amazon/analytics/session/PackageSessionBuilder;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/analytics/session/PackageSessionBuilder;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    .line 18
    iget-object v0, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    .line 19
    iget-object v0, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    .line 21
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->packageSessions:Ljava/util/concurrent/ConcurrentHashMap;

    return-void
.end method

.method private cleanInstanceMappings()V
    .locals 4

    .prologue
    .line 76
    iget-object v2, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->packageSessions:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentHashMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 77
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/analytics/session/PackageSession;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/analytics/session/PackageSession;

    invoke-virtual {v2}, Lcom/amazon/analytics/session/PackageSession;->getSessionState()Lcom/amazon/analytics/session/SessionState;

    move-result-object v2

    sget-object v3, Lcom/amazon/analytics/session/SessionState;->NO_SESSION:Lcom/amazon/analytics/session/SessionState;

    if-eq v2, v3, :cond_1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/analytics/session/PackageSession;

    invoke-virtual {v2}, Lcom/amazon/analytics/session/PackageSession;->getSessionState()Lcom/amazon/analytics/session/SessionState;

    move-result-object v2

    sget-object v3, Lcom/amazon/analytics/session/SessionState;->ORPHANED_SESSION:Lcom/amazon/analytics/session/SessionState;

    if-ne v2, v3, :cond_0

    .line 78
    :cond_1
    iget-object v2, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->packageSessions:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 81
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/analytics/session/PackageSession;>;"
    :cond_2
    return-void
.end method


# virtual methods
.method public getInstance(Ljava/lang/String;)Lcom/amazon/analytics/session/PackageSession;
    .locals 4
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 53
    iget-object v1, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->lock()V

    .line 55
    :try_start_0
    sget-object v1, Lcom/amazon/analytics/session/PackageSessionBuilder;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v2, "Initializing cleanup by deregistering sessions in no session state"

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 56
    invoke-direct {p0}, Lcom/amazon/analytics/session/PackageSessionBuilder;->cleanInstanceMappings()V

    .line 57
    sget-object v1, Lcom/amazon/analytics/session/PackageSessionBuilder;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Getting PackageSession object for package "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 58
    iget-object v1, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->packageSessions:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/analytics/session/PackageSession;

    .line 59
    .local v0, "pSession":Lcom/amazon/analytics/session/PackageSession;
    if-nez v0, :cond_0

    .line 60
    new-instance v0, Lcom/amazon/analytics/session/PackageSession;

    .end local v0    # "pSession":Lcom/amazon/analytics/session/PackageSession;
    invoke-direct {v0, p1}, Lcom/amazon/analytics/session/PackageSession;-><init>(Ljava/lang/String;)V

    .line 61
    .restart local v0    # "pSession":Lcom/amazon/analytics/session/PackageSession;
    iget-object v1, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->packageSessions:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    sget-object v1, Lcom/amazon/analytics/session/PackageSessionBuilder;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Creating PackageSession object for package "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " and caching it"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 67
    :cond_0
    iget-object v1, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    return-object v0

    .end local v0    # "pSession":Lcom/amazon/analytics/session/PackageSession;
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    throw v1
.end method

.method public getRunningSessions()Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/analytics/session/PackageSession;",
            ">;"
        }
    .end annotation

    .prologue
    .line 29
    iget-object v3, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->lock()V

    .line 31
    :try_start_0
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 32
    .local v1, "runningSessions":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/analytics/session/PackageSession;>;"
    iget-object v3, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->packageSessions:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v3}, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/analytics/session/PackageSession;

    .line 33
    .local v2, "session":Lcom/amazon/analytics/session/PackageSession;
    invoke-virtual {v2}, Lcom/amazon/analytics/session/PackageSession;->getSessionState()Lcom/amazon/analytics/session/SessionState;

    move-result-object v3

    sget-object v4, Lcom/amazon/analytics/session/SessionState;->RUNNING_SESSION:Lcom/amazon/analytics/session/SessionState;

    if-ne v3, v4, :cond_0

    .line 34
    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 39
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "runningSessions":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/analytics/session/PackageSession;>;"
    .end local v2    # "session":Lcom/amazon/analytics/session/PackageSession;
    :catchall_0
    move-exception v3

    iget-object v4, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    throw v3

    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v1    # "runningSessions":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/analytics/session/PackageSession;>;"
    :cond_1
    iget-object v3, p0, Lcom/amazon/analytics/session/PackageSessionBuilder;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    return-object v1
.end method
