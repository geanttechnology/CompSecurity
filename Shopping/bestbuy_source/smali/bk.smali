.class final Lbk;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Lao;

.field private final b:Lab;

.field private final c:Lag;

.field private final d:Ljava/util/Map;


# direct methods
.method constructor <init>(Lag;Lao;Lab;)V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    iput-object v0, p0, Lbk;->d:Ljava/util/Map;

    .line 30
    iput-object p2, p0, Lbk;->a:Lao;

    .line 31
    iput-object p1, p0, Lbk;->c:Lag;

    .line 32
    iput-object p3, p0, Lbk;->b:Lab;

    .line 33
    return-void
.end method

.method static synthetic a(Lbk;)Lag;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lbk;->c:Lag;

    return-object v0
.end method

.method static synthetic a(Lbk;Ljava/net/URLConnection;J)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0, p1, p2, p3}, Lbk;->a(Ljava/net/URLConnection;J)V

    return-void
.end method

.method private declared-synchronized a(Ljava/net/URLConnection;J)V
    .locals 6

    .prologue
    .line 182
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lbk;->e(Ljava/net/URLConnection;)Lbm;

    move-result-object v0

    .line 183
    if-eqz v0, :cond_0

    .line 184
    const/4 v1, 0x1

    invoke-static {v0, v1}, Lbm;->b(Lbm;Z)Z

    .line 185
    invoke-static {v0, p2, p3}, Lbm;->b(Lbm;J)J

    .line 186
    invoke-static {v0}, Lbm;->e(Lbm;)J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-gez v1, :cond_0

    .line 187
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lbm;->c(Lbm;J)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 190
    :cond_0
    monitor-exit p0

    return-void

    .line 182
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method static synthetic b(Lbk;)Lao;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lbk;->a:Lao;

    return-object v0
.end method

.method private e(Ljava/net/URLConnection;)Lbm;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lbk;->d:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Lbk;->d:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lbm;

    .line 56
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final declared-synchronized a(I)V
    .locals 10

    .prologue
    .line 36
    monitor-enter p0

    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 37
    iget-object v0, p0, Lbk;->d:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/net/URLConnection;

    .line 38
    invoke-direct {p0, v0}, Lbk;->e(Ljava/net/URLConnection;)Lbm;

    move-result-object v4

    .line 39
    if-eqz v4, :cond_0

    invoke-static {v4}, Lbm;->a(Lbm;)Z

    move-result v5

    if-nez v5, :cond_0

    invoke-static {v4}, Lbm;->b(Lbm;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 40
    invoke-static {v4}, Lbm;->c(Lbm;)J

    move-result-wide v6

    const-wide/16 v8, 0x2710

    add-long/2addr v6, v8

    cmp-long v5, v6, v2

    if-gez v5, :cond_0

    .line 41
    const/4 v5, 0x1

    invoke-static {v4, v5}, Lbm;->a(Lbm;Z)Z

    .line 42
    invoke-static {v4, v0}, Lbm;->a(Lbm;Ljava/net/URLConnection;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 36
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 46
    :cond_1
    monitor-exit p0

    return-void
.end method

.method final declared-synchronized a(Ljava/net/URLConnection;)V
    .locals 2

    .prologue
    .line 120
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lbk;->e(Ljava/net/URLConnection;)Lbm;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 121
    const/4 v1, 0x1

    invoke-static {v0, v1}, Lbm;->b(Lbm;Z)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 123
    :cond_0
    monitor-exit p0

    return-void

    .line 120
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method final declared-synchronized a(Ljava/net/URLConnection;Ljava/lang/Exception;)V
    .locals 8

    .prologue
    .line 164
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lbk;->e(Ljava/net/URLConnection;)Lbm;

    move-result-object v0

    .line 165
    if-nez v0, :cond_1

    .line 166
    iget-object v0, p0, Lbk;->c:Lag;

    invoke-virtual {p1}, Ljava/net/URLConnection;->getURL()Ljava/net/URL;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lag;->a(Ljava/net/URL;Ljava/lang/Exception;)Lorg/json/JSONObject;

    move-result-object v0

    .line 167
    if-eqz v0, :cond_0

    iget-object v1, p0, Lbk;->a:Lao;

    invoke-virtual {v1, v0}, Lao;->b(Lorg/json/JSONObject;)V

    .line 178
    :cond_0
    :goto_0
    iget-object v0, p0, Lbk;->b:Lab;

    sget-object v1, Lad;->c:Lad;

    invoke-virtual {v0, v1}, Lab;->a(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 179
    monitor-exit p0

    return-void

    .line 169
    :cond_1
    const/4 v1, 0x1

    :try_start_1
    invoke-static {v0, v1}, Lbm;->a(Lbm;Z)Z

    .line 171
    iget-object v1, p0, Lbk;->c:Lag;

    invoke-virtual {p1}, Ljava/net/URLConnection;->getURL()Ljava/net/URL;

    move-result-object v2

    invoke-static {v0}, Lbm;->d(Lbm;)J

    move-result-wide v4

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    move-object v3, p2

    invoke-virtual/range {v1 .. v7}, Lag;->a(Ljava/net/URL;Ljava/lang/Exception;JJ)Lorg/json/JSONObject;

    move-result-object v0

    .line 176
    if-eqz v0, :cond_0

    iget-object v1, p0, Lbk;->a:Lao;

    invoke-virtual {v1, v0}, Lao;->b(Lorg/json/JSONObject;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 164
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method final declared-synchronized b(Ljava/net/URLConnection;)V
    .locals 7

    .prologue
    .line 127
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lbk;->e(Ljava/net/URLConnection;)Lbm;

    move-result-object v1

    if-nez v1, :cond_1

    .line 128
    iget-object v1, p0, Lbk;->d:Ljava/util/Map;

    new-instance v2, Lbm;

    invoke-virtual {p1}, Ljava/net/URLConnection;->getURL()Ljava/net/URL;

    move-result-object v3

    const/4 v4, 0x0

    invoke-direct {v2, p0, v3, v4}, Lbm;-><init>(Lbk;Ljava/net/URL;B)V

    invoke-interface {v1, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 129
    instance-of v1, p1, Ljava/net/HttpURLConnection;

    if-eqz v1, :cond_1

    .line 130
    move-object v0, p1

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v1, v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 132
    :try_start_1
    invoke-static {}, Lq;->a()Ljava/util/Map;

    move-result-object v2

    .line 133
    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 134
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 135
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v1, v4, v3}, Ljava/net/HttpURLConnection;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 144
    :catch_0
    move-exception v1

    :try_start_2
    const-string v1, "Agent couldn\'t add server correlation header because headers have already been sent."

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    .line 149
    :cond_1
    :goto_1
    iget-object v1, p0, Lbk;->b:Lab;

    sget-object v2, Lad;->a:Lad;

    invoke-virtual {v1, v2}, Lab;->a(Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 150
    monitor-exit p0

    return-void

    .line 138
    :cond_2
    :try_start_3
    invoke-static {}, Lbc;->a()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 139
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Agent added server correlation header to request: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/net/URLConnection;->getURL()Ljava/net/URL;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/IllegalStateException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 127
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method final declared-synchronized c(Ljava/net/URLConnection;)V
    .locals 4

    .prologue
    .line 153
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lbk;->e(Ljava/net/URLConnection;)Lbm;

    move-result-object v0

    .line 154
    if-eqz v0, :cond_0

    .line 155
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 156
    invoke-static {v0, v2, v3}, Lbm;->a(Lbm;J)J

    .line 158
    invoke-static {v0, p1}, Lbm;->a(Lbm;Ljava/net/URLConnection;)V

    .line 160
    :cond_0
    iget-object v0, p0, Lbk;->b:Lab;

    sget-object v1, Lad;->b:Lad;

    invoke-virtual {v0, v1}, Lab;->a(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 161
    monitor-exit p0

    return-void

    .line 153
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method final declared-synchronized d(Ljava/net/URLConnection;)V
    .locals 4

    .prologue
    .line 193
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1}, Lbk;->e(Ljava/net/URLConnection;)Lbm;

    move-result-object v0

    .line 194
    if-eqz v0, :cond_0

    invoke-static {v0}, Lbm;->a(Lbm;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 195
    invoke-static {v0}, Lbm;->f(Lbm;)Z

    move-result v1

    .line 197
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lbm;->a(Lbm;J)J

    .line 198
    const/4 v2, 0x1

    invoke-static {v0, v2}, Lbm;->a(Lbm;Z)Z

    .line 199
    invoke-static {v0, p1}, Lbm;->a(Lbm;Ljava/net/URLConnection;)V

    .line 201
    if-nez v1, :cond_0

    .line 202
    iget-object v0, p0, Lbk;->b:Lab;

    sget-object v1, Lad;->b:Lad;

    invoke-virtual {v0, v1}, Lab;->a(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 205
    :cond_0
    monitor-exit p0

    return-void

    .line 193
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
