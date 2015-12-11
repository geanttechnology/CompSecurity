.class public Lcom/comcast/cim/android/image/BadUrlCache;
.super Ljava/lang/Object;
.source "BadUrlCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final cache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;",
            ">;"
        }
    .end annotation
.end field

.field private final lruDeque:Ljava/util/Deque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Deque",
            "<",
            "Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;",
            ">;"
        }
    .end annotation
.end field

.field private final maxAgeMillis:J

.field private final maxSize:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/comcast/cim/android/image/BadUrlCache;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/image/BadUrlCache;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(II)V
    .locals 3
    .param p1, "maxSize"    # I
    .param p2, "maxAgeSeconds"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    if-lez p1, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Lorg/apache/commons/lang3/Validate;->isTrue(Z)V

    .line 39
    if-ltz p2, :cond_1

    :goto_1
    invoke-static {v1}, Lorg/apache/commons/lang3/Validate;->isTrue(Z)V

    .line 41
    iput p1, p0, Lcom/comcast/cim/android/image/BadUrlCache;->maxSize:I

    .line 42
    mul-int/lit16 v0, p2, 0x3e8

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/comcast/cim/android/image/BadUrlCache;->maxAgeMillis:J

    .line 44
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, p1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lcom/comcast/cim/android/image/BadUrlCache;->cache:Ljava/util/Map;

    .line 45
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/android/image/BadUrlCache;->lruDeque:Ljava/util/Deque;

    .line 46
    return-void

    :cond_0
    move v0, v2

    .line 38
    goto :goto_0

    :cond_1
    move v1, v2

    .line 39
    goto :goto_1
.end method

.method private computeExpirationTime(J)J
    .locals 5
    .param p1, "now"    # J

    .prologue
    .line 49
    iget-wide v0, p0, Lcom/comcast/cim/android/image/BadUrlCache;->maxAgeMillis:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 50
    const-wide v0, 0x7fffffffffffffffL

    .line 52
    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/comcast/cim/android/image/BadUrlCache;->maxAgeMillis:J

    add-long/2addr v0, p1

    goto :goto_0
.end method

.method private trimCache(J)V
    .locals 9
    .param p1, "now"    # J

    .prologue
    const-wide/16 v6, 0x0

    .line 93
    iget-object v4, p0, Lcom/comcast/cim/android/image/BadUrlCache;->cache:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->size()I

    move-result v4

    int-to-long v2, v4

    .line 94
    .local v2, "theSize":J
    iget-object v4, p0, Lcom/comcast/cim/android/image/BadUrlCache;->lruDeque:Ljava/util/Deque;

    invoke-interface {v4}, Ljava/util/Deque;->peekFirst()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;

    iget-wide v0, v4, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;->expirationTime:J

    .line 96
    .local v0, "earliestExpiration":J
    :goto_0
    iget v4, p0, Lcom/comcast/cim/android/image/BadUrlCache;->maxSize:I

    int-to-long v4, v4

    cmp-long v4, v2, v4

    if-gtz v4, :cond_0

    cmp-long v4, v0, p1

    if-gez v4, :cond_2

    :cond_0
    cmp-long v4, v2, v6

    if-lez v4, :cond_2

    .line 97
    iget-object v5, p0, Lcom/comcast/cim/android/image/BadUrlCache;->cache:Ljava/util/Map;

    iget-object v4, p0, Lcom/comcast/cim/android/image/BadUrlCache;->lruDeque:Ljava/util/Deque;

    invoke-interface {v4}, Ljava/util/Deque;->removeFirst()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;

    iget-object v4, v4, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;->url:Ljava/lang/String;

    invoke-interface {v5, v4}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    const-wide/16 v4, 0x1

    sub-long/2addr v2, v4

    .line 100
    cmp-long v4, v2, v6

    if-lez v4, :cond_1

    .line 101
    iget-object v4, p0, Lcom/comcast/cim/android/image/BadUrlCache;->lruDeque:Ljava/util/Deque;

    invoke-interface {v4}, Ljava/util/Deque;->peekFirst()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;

    iget-wide v0, v4, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;->expirationTime:J

    goto :goto_0

    .line 103
    :cond_1
    const-wide v0, 0x7fffffffffffffffL

    goto :goto_0

    .line 106
    :cond_2
    return-void
.end method


# virtual methods
.method public declared-synchronized isBadUrl(Ljava/lang/String;)Z
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 75
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/android/image/BadUrlCache;->cache:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    .line 77
    .local v0, "response":Z
    if-eqz v0, :cond_0

    .line 78
    sget-object v1, Lcom/comcast/cim/android/image/BadUrlCache;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Skipping bad URL {}"

    invoke-interface {v1, v2, p1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 81
    :cond_0
    monitor-exit p0

    return v0

    .line 75
    .end local v0    # "response":Z
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized setBadUrl(Ljava/lang/String;)V
    .locals 6
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 58
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/android/image/BadUrlCache;->cache:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;

    .line 59
    .local v0, "entry":Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 61
    .local v2, "now":J
    if-nez v0, :cond_0

    .line 62
    new-instance v0, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;

    .end local v0    # "entry":Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;
    invoke-direct {p0, v2, v3}, Lcom/comcast/cim/android/image/BadUrlCache;->computeExpirationTime(J)J

    move-result-wide v4

    invoke-direct {v0, p0, p1, v4, v5}, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;-><init>(Lcom/comcast/cim/android/image/BadUrlCache;Ljava/lang/String;J)V

    .line 68
    .restart local v0    # "entry":Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/android/image/BadUrlCache;->cache:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    iget-object v1, p0, Lcom/comcast/cim/android/image/BadUrlCache;->lruDeque:Ljava/util/Deque;

    invoke-interface {v1, v0}, Ljava/util/Deque;->addLast(Ljava/lang/Object;)V

    .line 71
    invoke-direct {p0, v2, v3}, Lcom/comcast/cim/android/image/BadUrlCache;->trimCache(J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 72
    monitor-exit p0

    return-void

    .line 64
    :cond_0
    :try_start_1
    iget-object v1, p0, Lcom/comcast/cim/android/image/BadUrlCache;->lruDeque:Ljava/util/Deque;

    invoke-interface {v1, v0}, Ljava/util/Deque;->removeFirstOccurrence(Ljava/lang/Object;)Z

    .line 65
    invoke-direct {p0, v2, v3}, Lcom/comcast/cim/android/image/BadUrlCache;->computeExpirationTime(J)J

    move-result-wide v4

    iput-wide v4, v0, Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;->expirationTime:J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 58
    .end local v0    # "entry":Lcom/comcast/cim/android/image/BadUrlCache$BadUrlEntry;
    .end local v2    # "now":J
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
