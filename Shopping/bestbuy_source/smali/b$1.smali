.class public Lb$1;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lb;
.end annotation


# instance fields
.field private final a:Lx;

.field private final b:Ljava/lang/String;

.field private c:J


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 30
    new-instance v0, Lx;

    invoke-direct {v0, p1}, Lx;-><init>(Landroid/content/Context;)V

    invoke-direct {p0, v0, p2}, Lb$1;-><init>(Lx;Ljava/lang/String;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Lx;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lb$1;->c:J

    .line 34
    iput-object p1, p0, Lb$1;->a:Lx;

    .line 38
    iput-object p2, p0, Lb$1;->b:Ljava/lang/String;

    .line 39
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 3

    .prologue
    .line 46
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "mobileAgentToken"

    const-string v2, "-1"

    invoke-virtual {v0, v1, v2}, Lx;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(J)V
    .locals 5

    .prologue
    .line 84
    iget-object v0, p0, Lb$1;->b:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 85
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "buildId"

    iget-object v2, p0, Lb$1;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lx;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    :cond_0
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "info_point_version"

    invoke-virtual {v0, v1, p1, p2}, Lx;->a(Ljava/lang/String;J)V

    .line 88
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "info_point_version_counter"

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lx;->a(Ljava/lang/String;J)V

    .line 89
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 42
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "mobileAgentToken"

    invoke-virtual {v0, v1, p1}, Lx;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    return-void
.end method

.method public a(Z)V
    .locals 2

    .prologue
    .line 135
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "infoPointSafetyFlag"

    invoke-virtual {v0, v1, p1}, Lx;->a(Ljava/lang/String;Z)V

    .line 136
    return-void
.end method

.method public b()Ljava/lang/String;
    .locals 3

    .prologue
    .line 55
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "agentIdentifier"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lx;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 56
    if-nez v0, :cond_0

    .line 57
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 58
    iget-object v1, p0, Lb$1;->a:Lx;

    const-string v2, "agentIdentifier"

    invoke-virtual {v1, v2, v0}, Lx;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    :cond_0
    return-object v0
.end method

.method b(J)V
    .locals 5

    .prologue
    .line 120
    iget-wide v0, p0, Lb$1;->c:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 122
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "event_counter"

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lx;->b(Ljava/lang/String;J)J

    move-result-wide v0

    iput-wide v0, p0, Lb$1;->c:J

    .line 125
    :cond_0
    iget-wide v0, p0, Lb$1;->c:J

    add-long/2addr v0, p1

    iput-wide v0, p0, Lb$1;->c:J

    .line 127
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "event_counter"

    iget-wide v2, p0, Lb$1;->c:J

    invoke-virtual {v0, v1, v2, v3}, Lx;->a(Ljava/lang/String;J)V

    .line 128
    return-void
.end method

.method public c()Z
    .locals 4

    .prologue
    .line 64
    invoke-virtual {p0}, Lb$1;->e()J

    move-result-wide v0

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public d()J
    .locals 6

    .prologue
    .line 74
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "info_point_version_counter"

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lx;->b(Ljava/lang/String;J)J

    move-result-wide v0

    .line 75
    iget-object v2, p0, Lb$1;->a:Lx;

    const-string v3, "info_point_version_counter"

    const-wide/16 v4, 0x1

    add-long/2addr v0, v4

    invoke-virtual {v2, v3, v0, v1}, Lx;->a(Ljava/lang/String;J)V

    .line 76
    return-wide v0
.end method

.method public e()J
    .locals 6

    .prologue
    const-wide/16 v0, -0x1

    .line 80
    iget-object v2, p0, Lb$1;->b:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lb$1;->b:Ljava/lang/String;

    iget-object v3, p0, Lb$1;->a:Lx;

    const-string v4, "buildId"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Lx;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    const/4 v2, 0x1

    :goto_0
    if-eqz v2, :cond_0

    iget-object v2, p0, Lb$1;->a:Lx;

    const-string v3, "info_point_version"

    invoke-virtual {v2, v3, v0, v1}, Lx;->b(Ljava/lang/String;J)J

    move-result-wide v0

    :cond_0
    return-wide v0

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public f()J
    .locals 4

    .prologue
    .line 98
    iget-wide v0, p0, Lb$1;->c:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 100
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "event_counter"

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lx;->b(Ljava/lang/String;J)J

    move-result-wide v0

    iput-wide v0, p0, Lb$1;->c:J

    .line 103
    :cond_0
    iget-wide v0, p0, Lb$1;->c:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lb$1;->c:J

    .line 105
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "event_counter"

    iget-wide v2, p0, Lb$1;->c:J

    invoke-virtual {v0, v1, v2, v3}, Lx;->a(Ljava/lang/String;J)V

    .line 107
    iget-wide v0, p0, Lb$1;->c:J

    return-wide v0
.end method

.method g()J
    .locals 4

    .prologue
    .line 112
    iget-wide v0, p0, Lb$1;->c:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    const-wide/16 v0, 0x0

    .line 116
    :goto_0
    return-wide v0

    .line 114
    :cond_0
    iget-wide v0, p0, Lb$1;->c:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lb$1;->c:J

    .line 116
    iget-wide v0, p0, Lb$1;->c:J

    goto :goto_0
.end method

.method public h()Z
    .locals 3

    .prologue
    .line 139
    iget-object v0, p0, Lb$1;->a:Lx;

    const-string v1, "infoPointSafetyFlag"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lx;->b(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method
