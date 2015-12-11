.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;
.super Ljava/lang/Object;
.source "UriPatternMatcher.java"


# instance fields
.field private final map:Ljava/util/Map;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;->map:Ljava/util/Map;

    .line 59
    return-void
.end method


# virtual methods
.method public declared-synchronized setHandlers(Ljava/util/Map;)V
    .locals 2
    .param p1, "map"    # Ljava/util/Map;

    .prologue
    .line 90
    monitor-enter p0

    if-nez p1, :cond_0

    .line 91
    :try_start_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Map of handlers may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 90
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 93
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 94
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;->map:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 95
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized setObjects(Ljava/util/Map;)V
    .locals 2
    .param p1, "map"    # Ljava/util/Map;

    .prologue
    .line 102
    monitor-enter p0

    if-nez p1, :cond_0

    .line 103
    :try_start_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Map of handlers may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 102
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 105
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;->map:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 106
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/UriPatternMatcher;->map:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 107
    monitor-exit p0

    return-void
.end method
