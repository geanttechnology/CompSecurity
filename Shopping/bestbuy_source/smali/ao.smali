.class final Lao;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Laq;

.field private final b:Lan;

.field private final c:Ljava/util/concurrent/BlockingQueue;

.field private final d:Ljava/util/List;


# direct methods
.method varargs constructor <init>(Laq;Lan;Lam;[Lap;)V
    .locals 2

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lao;->a:Laq;

    .line 31
    iput-object p2, p0, Lao;->b:Lan;

    .line 32
    new-instance v0, Ljava/util/concurrent/LinkedBlockingQueue;

    const/16 v1, 0xc8

    invoke-direct {v0, v1}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>(I)V

    iput-object v0, p0, Lao;->c:Ljava/util/concurrent/BlockingQueue;

    .line 34
    invoke-static {p4}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lao;->d:Ljava/util/List;

    .line 35
    return-void
.end method

.method private a(Laf;)Z
    .locals 2

    .prologue
    .line 54
    iget-object v0, p0, Lao;->c:Ljava/util/concurrent/BlockingQueue;

    invoke-interface {v0, p1}, Ljava/util/concurrent/BlockingQueue;->offer(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 55
    const-string v0, "In-memory beacon queue is full; agent dropped beacon: %s"

    invoke-virtual {p1}, Laf;->b()Lorg/json/JSONObject;

    move-result-object v1

    invoke-static {v0, v1}, Lbc;->a(Ljava/lang/String;Ljava/lang/Object;)V

    .line 56
    const/4 v0, 0x0

    .line 59
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method final a()Laq;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lao;->a:Laq;

    return-object v0
.end method

.method final a(Lorg/json/JSONObject;)Z
    .locals 4

    .prologue
    .line 46
    new-instance v0, Laf;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-direct {v0, p1, v2, v3}, Laf;-><init>(Lorg/json/JSONObject;J)V

    invoke-direct {p0, v0}, Lao;->a(Laf;)Z

    move-result v0

    return v0
.end method

.method final b()V
    .locals 3

    .prologue
    .line 63
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 64
    iget-object v1, p0, Lao;->c:Ljava/util/concurrent/BlockingQueue;

    invoke-interface {v1, v0}, Ljava/util/concurrent/BlockingQueue;->drainTo(Ljava/util/Collection;)I

    .line 65
    const-string v1, "Persisting %s beacons"

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-static {v1, v2}, Lbc;->a(Ljava/lang/String;I)V

    .line 66
    iget-object v1, p0, Lao;->b:Lan;

    invoke-virtual {v1, v0}, Lan;->a(Ljava/util/List;)Z

    .line 67
    return-void
.end method

.method final b(Lorg/json/JSONObject;)V
    .locals 4

    .prologue
    .line 50
    new-instance v0, Laf;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-direct {v0, p1, v2, v3}, Laf;-><init>(Lorg/json/JSONObject;J)V

    invoke-direct {p0, v0}, Lao;->a(Laf;)Z

    .line 51
    return-void
.end method

.method final c()V
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 70
    const-string v0, "Loading persisted beacons"

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 71
    iget-object v0, p0, Lao;->b:Lan;

    invoke-virtual {v0}, Lan;->a()Ljava/util/List;

    move-result-object v0

    .line 72
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laf;

    .line 73
    invoke-virtual {v0}, Laf;->b()Lorg/json/JSONObject;

    move-result-object v1

    const-string v4, "type"

    const/4 v5, 0x0

    invoke-virtual {v1, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    sget-object v4, Lal;->b:Ljava/util/Set;

    invoke-interface {v4, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-virtual {v0}, Laf;->a()J

    move-result-wide v6

    sub-long/2addr v4, v6

    sget-wide v6, Lal;->d:J

    cmp-long v1, v4, v6

    if-lez v1, :cond_1

    const/4 v1, 0x1

    :goto_1
    if-nez v1, :cond_0

    .line 74
    invoke-direct {p0, v0}, Lao;->a(Laf;)Z

    goto :goto_0

    :cond_1
    move v1, v2

    .line 73
    goto :goto_1

    :cond_2
    move v1, v2

    goto :goto_1

    .line 77
    :cond_3
    return-void
.end method

.method final d()Z
    .locals 5

    .prologue
    .line 95
    iget-object v0, p0, Lao;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lap;

    .line 97
    :try_start_0
    invoke-interface {v0, p0}, Lap;->a(Lao;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 98
    :catch_0
    move-exception v2

    .line 99
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Error thrown by listener: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " before sending beacons."

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v2}, Lbc;->b(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 103
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 104
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 105
    iget-object v0, p0, Lao;->c:Ljava/util/concurrent/BlockingQueue;

    invoke-interface {v0, v1}, Ljava/util/concurrent/BlockingQueue;->drainTo(Ljava/util/Collection;)I

    .line 107
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laf;

    .line 108
    invoke-virtual {v0}, Laf;->b()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {v2, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_1

    .line 111
    :cond_1
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_3

    .line 112
    iget-object v0, p0, Lao;->a:Laq;

    invoke-virtual {v0, v2}, Laq;->a(Lorg/json/JSONArray;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 113
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Laf;

    .line 114
    invoke-direct {p0, v0}, Lao;->a(Laf;)Z

    goto :goto_2

    .line 116
    :cond_2
    const/4 v0, 0x0

    .line 120
    :goto_3
    return v0

    :cond_3
    const/4 v0, 0x1

    goto :goto_3
.end method

.method public final e()V
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lao;->b:Lan;

    invoke-virtual {v0}, Lan;->b()V

    .line 125
    return-void
.end method
