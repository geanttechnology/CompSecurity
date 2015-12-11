.class public final Lcom/google/analytics/tracking/android/ay;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Ljava/lang/String;

.field private final c:Lcom/google/analytics/tracking/android/az;

.field private d:J

.field private e:J

.field private final f:Lcom/google/analytics/tracking/android/k;

.field private final g:Lcom/google/analytics/tracking/android/au;

.field private final h:Lcom/google/analytics/tracking/android/i;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/analytics/tracking/android/az;)V
    .locals 7

    .prologue
    .line 61
    invoke-static {}, Lcom/google/analytics/tracking/android/k;->a()Lcom/google/analytics/tracking/android/k;

    move-result-object v4

    invoke-static {}, Lcom/google/analytics/tracking/android/au;->a()Lcom/google/analytics/tracking/android/au;

    move-result-object v5

    invoke-static {}, Lcom/google/analytics/tracking/android/i;->a()Lcom/google/analytics/tracking/android/i;

    move-result-object v6

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v6}, Lcom/google/analytics/tracking/android/ay;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/analytics/tracking/android/az;Lcom/google/analytics/tracking/android/k;Lcom/google/analytics/tracking/android/au;Lcom/google/analytics/tracking/android/i;)V

    .line 63
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/analytics/tracking/android/az;Lcom/google/analytics/tracking/android/k;Lcom/google/analytics/tracking/android/au;Lcom/google/analytics/tracking/android/i;)V
    .locals 3

    .prologue
    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ay;->a:Ljava/util/Map;

    .line 53
    const-wide/32 v0, 0x1d4c0

    iput-wide v0, p0, Lcom/google/analytics/tracking/android/ay;->d:J

    .line 70
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 71
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Tracker name cannot be empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 73
    :cond_0
    iput-object p1, p0, Lcom/google/analytics/tracking/android/ay;->b:Ljava/lang/String;

    .line 74
    iput-object p3, p0, Lcom/google/analytics/tracking/android/ay;->c:Lcom/google/analytics/tracking/android/az;

    .line 75
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ay;->a:Ljava/util/Map;

    const-string v1, "&tid"

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ay;->a:Ljava/util/Map;

    const-string v1, "useSecure"

    const-string v2, "1"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    iput-object p4, p0, Lcom/google/analytics/tracking/android/ay;->f:Lcom/google/analytics/tracking/android/k;

    .line 81
    iput-object p5, p0, Lcom/google/analytics/tracking/android/ay;->g:Lcom/google/analytics/tracking/android/au;

    .line 82
    iput-object p6, p0, Lcom/google/analytics/tracking/android/ay;->h:Lcom/google/analytics/tracking/android/i;

    .line 83
    return-void
.end method

.method private declared-synchronized a()Z
    .locals 10

    .prologue
    const-wide/32 v4, 0x1d4c0

    const-wide/16 v8, 0x7d0

    .line 193
    monitor-enter p0

    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 194
    iget-wide v2, p0, Lcom/google/analytics/tracking/android/ay;->d:J

    cmp-long v2, v2, v4

    if-gez v2, :cond_0

    .line 195
    iget-wide v2, p0, Lcom/google/analytics/tracking/android/ay;->e:J

    sub-long v2, v0, v2

    .line 196
    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-lez v4, :cond_0

    .line 197
    const-wide/32 v4, 0x1d4c0

    iget-wide v6, p0, Lcom/google/analytics/tracking/android/ay;->d:J

    add-long/2addr v2, v6

    invoke-static {v4, v5, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/google/analytics/tracking/android/ay;->d:J

    .line 200
    :cond_0
    iput-wide v0, p0, Lcom/google/analytics/tracking/android/ay;->e:J

    .line 201
    iget-wide v0, p0, Lcom/google/analytics/tracking/android/ay;->d:J

    cmp-long v0, v0, v8

    if-ltz v0, :cond_1

    .line 202
    iget-wide v0, p0, Lcom/google/analytics/tracking/android/ay;->d:J

    sub-long/2addr v0, v8

    iput-wide v0, p0, Lcom/google/analytics/tracking/android/ay;->d:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 203
    const/4 v0, 0x1

    .line 206
    :goto_0
    monitor-exit p0

    return v0

    .line 205
    :cond_1
    :try_start_1
    const-string v0, "Excessive tracking detected.  Tracking call ignored."

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 206
    const/4 v0, 0x0

    goto :goto_0

    .line 193
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public final a(Ljava/util/Map;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 104
    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v0

    sget-object v1, Lcom/google/analytics/tracking/android/aj;->l:Lcom/google/analytics/tracking/android/aj;

    invoke-virtual {v0, v1}, Lcom/google/analytics/tracking/android/ai;->a(Lcom/google/analytics/tracking/android/aj;)V

    .line 105
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 106
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ay;->a:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 107
    if-eqz p1, :cond_0

    .line 108
    invoke-interface {v1, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 111
    :cond_0
    const-string v0, "&tid"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 112
    const-string v0, "Missing tracking id (%s) parameter."

    new-array v2, v5, [Ljava/lang/Object;

    const-string v3, "&tid"

    aput-object v3, v2, v4

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    .line 115
    :cond_1
    const-string v0, "&t"

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 116
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 117
    const-string v0, "Missing hit type (%s) parameter."

    new-array v2, v5, [Ljava/lang/Object;

    const-string v3, "&t"

    aput-object v3, v2, v4

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    .line 118
    const-string v0, ""

    .line 122
    :cond_2
    const-string v2, "transaction"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    const-string v2, "item"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    invoke-direct {p0}, Lcom/google/analytics/tracking/android/ay;->a()Z

    move-result v0

    if-nez v0, :cond_3

    .line 125
    const-string v0, "Too many hits sent too quickly, rate limiting invoked."

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    .line 129
    :goto_0
    return-void

    .line 127
    :cond_3
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ay;->c:Lcom/google/analytics/tracking/android/az;

    invoke-virtual {v0, v1}, Lcom/google/analytics/tracking/android/az;->a(Ljava/util/Map;)V

    goto :goto_0
.end method
