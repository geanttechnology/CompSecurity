.class final Lbm;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:J

.field private b:J

.field private c:J

.field private d:J

.field private final e:Ljava/net/URL;

.field private f:Z

.field private g:Z

.field private h:Z

.field private synthetic i:Lbk;


# direct methods
.method private constructor <init>(Lbk;Ljava/net/URL;)V
    .locals 6

    .prologue
    const-wide/16 v4, -0x1

    const/4 v2, 0x0

    .line 72
    iput-object p1, p0, Lbm;->i:Lbk;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 73
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lbm;->a:J

    .line 74
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lbm;->d:J

    .line 75
    iput-wide v4, p0, Lbm;->b:J

    .line 76
    iput-wide v4, p0, Lbm;->c:J

    .line 77
    iput-object p2, p0, Lbm;->e:Ljava/net/URL;

    .line 78
    iput-boolean v2, p0, Lbm;->f:Z

    .line 79
    iput-boolean v2, p0, Lbm;->g:Z

    .line 80
    return-void
.end method

.method synthetic constructor <init>(Lbk;Ljava/net/URL;B)V
    .locals 0

    .prologue
    .line 60
    invoke-direct {p0, p1, p2}, Lbm;-><init>(Lbk;Ljava/net/URL;)V

    return-void
.end method

.method static synthetic a(Lbm;J)J
    .locals 1

    .prologue
    .line 60
    iput-wide p1, p0, Lbm;->c:J

    return-wide p1
.end method

.method static synthetic a(Lbm;Ljava/net/URLConnection;)V
    .locals 13

    .prologue
    const-wide/16 v4, 0x0

    const/4 v12, 0x0

    .line 60
    iget-wide v2, p0, Lbm;->c:J

    cmp-long v2, v2, v4

    if-lez v2, :cond_3

    iget-boolean v2, p0, Lbm;->f:Z

    if-eqz v2, :cond_3

    iget-boolean v2, p0, Lbm;->g:Z

    if-nez v2, :cond_3

    iget-wide v2, p0, Lbm;->b:J

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    iput-wide v4, p0, Lbm;->b:J

    :cond_0
    :try_start_0
    move-object v0, p1

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v2, v0

    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v8

    const/16 v2, 0x190

    if-lt v8, v2, :cond_5

    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Ljava/net/URLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    :goto_0
    new-instance v10, Lv;

    invoke-direct {v10}, Lv;-><init>()V

    invoke-virtual {p1}, Ljava/net/URLConnection;->getHeaderFields()Ljava/util/Map;

    move-result-object v4

    if-eqz v4, :cond_4

    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v4, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    invoke-virtual {v10, v2, v3}, Lv;->a(Ljava/lang/String;Ljava/util/List;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v2

    move-object v11, v2

    iget-object v2, p0, Lbm;->i:Lbk;

    invoke-static {v2}, Lbk;->a(Lbk;)Lag;

    move-result-object v2

    iget-object v3, p0, Lbm;->e:Ljava/net/URL;

    iget-wide v4, p0, Lbm;->a:J

    iget-wide v6, p0, Lbm;->c:J

    const/4 v8, 0x0

    move-object v9, v12

    move-object v10, v12

    invoke-virtual/range {v2 .. v10}, Lag;->a(Ljava/net/URL;JJILjava/lang/String;Lt;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v3, p0, Lbm;->i:Lbk;

    invoke-static {v3}, Lbk;->b(Lbk;)Lao;

    move-result-object v3

    invoke-virtual {v3, v2}, Lao;->b(Lorg/json/JSONObject;)V

    :cond_1
    const-string v2, "Unexpected error fetching HTTP response code"

    invoke-static {v2, v11}, Lp;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    :cond_2
    :goto_2
    const/4 v2, 0x1

    iput-boolean v2, p0, Lbm;->g:Z

    :cond_3
    return-void

    :cond_4
    :try_start_1
    iget-object v2, p0, Lbm;->i:Lbk;

    invoke-static {v2}, Lbk;->a(Lbk;)Lag;

    move-result-object v2

    iget-object v3, p0, Lbm;->e:Ljava/net/URL;

    iget-wide v4, p0, Lbm;->a:J

    iget-wide v6, p0, Lbm;->c:J

    invoke-virtual {v10}, Lv;->a()Lt;

    move-result-object v10

    invoke-virtual/range {v2 .. v10}, Lag;->a(Ljava/net/URL;JJILjava/lang/String;Lt;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v3, p0, Lbm;->i:Lbk;

    invoke-static {v3}, Lbk;->b(Lbk;)Lao;

    move-result-object v3

    invoke-virtual {v3, v2}, Lao;->b(Lorg/json/JSONObject;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2

    :cond_5
    move-object v9, v12

    goto :goto_0
.end method

.method static synthetic a(Lbm;)Z
    .locals 1

    .prologue
    .line 60
    iget-boolean v0, p0, Lbm;->f:Z

    return v0
.end method

.method static synthetic a(Lbm;Z)Z
    .locals 1

    .prologue
    .line 60
    const/4 v0, 0x1

    iput-boolean v0, p0, Lbm;->f:Z

    return v0
.end method

.method static synthetic b(Lbm;J)J
    .locals 3

    .prologue
    .line 60
    iget-wide v0, p0, Lbm;->d:J

    add-long/2addr v0, p1

    iput-wide v0, p0, Lbm;->d:J

    return-wide v0
.end method

.method static synthetic b(Lbm;)Z
    .locals 1

    .prologue
    .line 60
    iget-boolean v0, p0, Lbm;->h:Z

    return v0
.end method

.method static synthetic b(Lbm;Z)Z
    .locals 1

    .prologue
    .line 60
    const/4 v0, 0x1

    iput-boolean v0, p0, Lbm;->h:Z

    return v0
.end method

.method static synthetic c(Lbm;)J
    .locals 2

    .prologue
    .line 60
    iget-wide v0, p0, Lbm;->c:J

    return-wide v0
.end method

.method static synthetic c(Lbm;J)J
    .locals 1

    .prologue
    .line 60
    iput-wide p1, p0, Lbm;->b:J

    return-wide p1
.end method

.method static synthetic d(Lbm;)J
    .locals 2

    .prologue
    .line 60
    iget-wide v0, p0, Lbm;->a:J

    return-wide v0
.end method

.method static synthetic e(Lbm;)J
    .locals 2

    .prologue
    .line 60
    iget-wide v0, p0, Lbm;->b:J

    return-wide v0
.end method

.method static synthetic f(Lbm;)Z
    .locals 1

    .prologue
    .line 60
    iget-boolean v0, p0, Lbm;->g:Z

    return v0
.end method
