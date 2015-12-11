.class final Lj;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private a:Lbb;

.field private b:Lah;

.field private c:J

.field private synthetic d:Lg;


# direct methods
.method constructor <init>(Lg;Lbb;Lah;)V
    .locals 2

    .prologue
    .line 95
    iput-object p1, p0, Lj;->d:Lg;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lj;->c:J

    .line 96
    iput-object p2, p0, Lj;->a:Lbb;

    .line 97
    iput-object p3, p0, Lj;->b:Lah;

    .line 98
    return-void
.end method

.method static synthetic a(Lj;J)J
    .locals 1

    .prologue
    .line 90
    iput-wide p1, p0, Lj;->c:J

    return-wide p1
.end method


# virtual methods
.method final a()V
    .locals 6

    .prologue
    const-wide/16 v4, 0x0

    .line 101
    iget-wide v0, p0, Lj;->c:J

    cmp-long v0, v0, v4

    if-ltz v0, :cond_0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lj;->c:J

    sub-long/2addr v0, v2

    const-wide/32 v2, 0x493e0

    cmp-long v0, v0, v2

    if-ltz v0, :cond_1

    .line 103
    :cond_0
    const-string v0, "Attempting to schedule \'DynamicInfoPointVersionChecker\' immediately."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 104
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lj;->c:J

    .line 105
    iget-object v0, p0, Lj;->b:Lah;

    invoke-virtual {v0, p0, v4, v5}, Lah;->a(Ljava/lang/Runnable;J)V

    .line 107
    :cond_1
    return-void
.end method

.method public final run()V
    .locals 6

    .prologue
    const-wide/16 v4, 0x0

    .line 112
    :try_start_0
    iget-object v0, p0, Lj;->d:Lg;

    invoke-virtual {v0}, Lg;->b()Lm;

    move-result-object v0

    invoke-virtual {v0}, Lm;->d()Le;

    move-result-object v0

    .line 113
    const-string v1, "Connecting to URL: %s to download infopoint version"

    invoke-virtual {v0}, Le;->a()Ljava/net/URL;

    move-result-object v2

    invoke-static {v1, v2}, Lbc;->a(Ljava/lang/String;Ljava/lang/Object;)V

    .line 114
    invoke-virtual {v0}, Le;->h()I

    move-result v1

    const/16 v2, 0xc8

    if-eq v1, v2, :cond_0

    .line 115
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Warning: Invalid response from server = "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Le;->h()I

    move-result v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 153
    :goto_0
    return-void

    .line 119
    :cond_0
    invoke-virtual {v0}, Le;->g()Ljava/io/InputStream;

    move-result-object v0

    invoke-static {v0}, Lbb;->a(Ljava/io/InputStream;)Lorg/json/JSONObject;

    move-result-object v0

    .line 120
    const-string v1, "infopVersion"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 121
    const-string v1, "infopVersion"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 122
    cmp-long v2, v0, v4

    if-gtz v2, :cond_2

    .line 123
    sget-object v0, Ll;->d:Lb$1;

    if-eqz v0, :cond_1

    .line 124
    sget-object v0, Ll;->d:Lb$1;

    const-wide/16 v2, -0x1

    invoke-virtual {v0, v2, v3}, Lb$1;->a(J)V

    .line 126
    :cond_1
    const-string v0, "No dynamic infopoints defined for this application"

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 150
    :catch_0
    move-exception v0

    .line 151
    const-string v1, "Error downloading infopoint version from server"

    invoke-static {v1, v0}, Lbc;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 130
    :cond_2
    :try_start_1
    sget-object v2, Ll;->d:Lb$1;

    .line 131
    invoke-virtual {v2}, Lb$1;->e()J

    move-result-wide v2

    .line 132
    cmp-long v4, v2, v0

    if-ltz v4, :cond_3

    .line 133
    const-string v4, "Current version %d is greater or equal to server version %d.Not scheduling dex download"

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-static {v4, v2, v0}, Lbc;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0

    .line 138
    :cond_3
    monitor-enter p0
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 141
    :try_start_2
    iget-object v2, p0, Lj;->d:Lg;

    invoke-static {v2}, Lg;->a(Lg;)J

    move-result-wide v2

    cmp-long v2, v2, v0

    if-gez v2, :cond_4

    .line 142
    const-string v2, "Scheduling dex downloader for server version %d"

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lbc;->a(Ljava/lang/String;Ljava/lang/Object;)V

    .line 143
    iget-object v2, p0, Lj;->b:Lah;

    new-instance v3, Li;

    iget-object v4, p0, Lj;->d:Lg;

    const/4 v5, 0x0

    invoke-direct {v3, v4, v0, v1, v5}, Li;-><init>(Lg;JB)V

    const-wide/16 v4, 0x0

    invoke-virtual {v2, v3, v4, v5}, Lah;->a(Ljava/lang/Runnable;J)V

    .line 144
    iget-object v2, p0, Lj;->d:Lg;

    invoke-static {v2, v0, v1}, Lg;->a(Lg;J)J

    .line 146
    :cond_4
    monitor-exit p0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0

    .line 147
    :cond_5
    const-string v0, "Response has no dynamic infopoint version!"

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_0
.end method
