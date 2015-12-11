.class public Lcom/google/analytics/tracking/android/ak;
.super Lcom/google/analytics/tracking/android/az;
.source "SourceFile"


# static fields
.field private static h:Lcom/google/analytics/tracking/android/ak;


# instance fields
.field volatile a:Ljava/lang/Boolean;

.field b:Lcom/google/analytics/tracking/android/ao;

.field private c:Z

.field private d:Lcom/google/analytics/tracking/android/h;

.field private e:Landroid/content/Context;

.field private f:Lcom/google/analytics/tracking/android/ay;

.field private final g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/analytics/tracking/android/ay;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 48
    invoke-static {p1}, Lcom/google/analytics/tracking/android/ae;->a(Landroid/content/Context;)Lcom/google/analytics/tracking/android/ae;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/google/analytics/tracking/android/ak;-><init>(Landroid/content/Context;Lcom/google/analytics/tracking/android/h;)V

    .line 49
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Lcom/google/analytics/tracking/android/h;)V
    .locals 2

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/google/analytics/tracking/android/az;-><init>()V

    .line 38
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ak;->a:Ljava/lang/Boolean;

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ak;->g:Ljava/util/Map;

    .line 52
    if-nez p1, :cond_0

    .line 53
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "context cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 55
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ak;->e:Landroid/content/Context;

    .line 56
    iput-object p2, p0, Lcom/google/analytics/tracking/android/ak;->d:Lcom/google/analytics/tracking/android/h;

    .line 58
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ak;->e:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/i;->a(Landroid/content/Context;)V

    .line 59
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ak;->e:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/au;->a(Landroid/content/Context;)V

    .line 60
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ak;->e:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/k;->a(Landroid/content/Context;)V

    .line 62
    new-instance v0, Lcom/google/analytics/tracking/android/n;

    invoke-direct {v0}, Lcom/google/analytics/tracking/android/n;-><init>()V

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ak;->b:Lcom/google/analytics/tracking/android/ao;

    .line 63
    return-void
.end method

.method static a()Lcom/google/analytics/tracking/android/ak;
    .locals 2

    .prologue
    .line 86
    const-class v1, Lcom/google/analytics/tracking/android/ak;

    monitor-enter v1

    .line 87
    :try_start_0
    sget-object v0, Lcom/google/analytics/tracking/android/ak;->h:Lcom/google/analytics/tracking/android/ak;

    monitor-exit v1

    return-object v0

    .line 88
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static a(Landroid/content/Context;)Lcom/google/analytics/tracking/android/ak;
    .locals 2

    .prologue
    .line 71
    const-class v1, Lcom/google/analytics/tracking/android/ak;

    monitor-enter v1

    .line 72
    :try_start_0
    sget-object v0, Lcom/google/analytics/tracking/android/ak;->h:Lcom/google/analytics/tracking/android/ak;

    if-nez v0, :cond_0

    .line 73
    new-instance v0, Lcom/google/analytics/tracking/android/ak;

    invoke-direct {v0, p0}, Lcom/google/analytics/tracking/android/ak;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/google/analytics/tracking/android/ak;->h:Lcom/google/analytics/tracking/android/ak;

    .line 75
    :cond_0
    sget-object v0, Lcom/google/analytics/tracking/android/ak;->h:Lcom/google/analytics/tracking/android/ak;

    monitor-exit v1

    return-object v0

    .line 76
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public final a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/ay;
    .locals 4

    .prologue
    .line 162
    monitor-enter p0

    .line 163
    :try_start_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 164
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Tracker name cannot be empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 180
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 166
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ak;->g:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/analytics/tracking/android/ay;

    .line 168
    if-nez v0, :cond_1

    .line 169
    new-instance v0, Lcom/google/analytics/tracking/android/ay;

    invoke-direct {v0, p1, p2, p0}, Lcom/google/analytics/tracking/android/ay;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/analytics/tracking/android/az;)V

    .line 170
    iget-object v1, p0, Lcom/google/analytics/tracking/android/ak;->g:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 171
    iget-object v1, p0, Lcom/google/analytics/tracking/android/ak;->f:Lcom/google/analytics/tracking/android/ay;

    if-nez v1, :cond_1

    .line 172
    iput-object v0, p0, Lcom/google/analytics/tracking/android/ak;->f:Lcom/google/analytics/tracking/android/ay;

    .line 175
    :cond_1
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 176
    const-string v1, "&tid"

    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v2

    sget-object v3, Lcom/google/analytics/tracking/android/aj;->k:Lcom/google/analytics/tracking/android/aj;

    invoke-virtual {v2, v3}, Lcom/google/analytics/tracking/android/ai;->a(Lcom/google/analytics/tracking/android/aj;)V

    iget-object v2, v0, Lcom/google/analytics/tracking/android/ay;->a:Ljava/util/Map;

    invoke-interface {v2, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 178
    :cond_2
    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v1

    sget-object v2, Lcom/google/analytics/tracking/android/aj;->N:Lcom/google/analytics/tracking/android/aj;

    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/ai;->a(Lcom/google/analytics/tracking/android/aj;)V

    .line 179
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v0
.end method

.method final a(Ljava/util/Map;)V
    .locals 3
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
    .line 235
    monitor-enter p0

    .line 236
    :try_start_0
    const-string v0, "&ul"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-static {v1}, Lcom/google/analytics/tracking/android/ba;->a(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/google/analytics/tracking/android/ba;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V

    .line 242
    const-string v0, "&sr"

    invoke-static {}, Lcom/google/analytics/tracking/android/au;->a()Lcom/google/analytics/tracking/android/au;

    move-result-object v1

    const-string v2, "&sr"

    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/au;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/google/analytics/tracking/android/ba;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V

    .line 244
    const-string v0, "&_u"

    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/analytics/tracking/android/ai;->c()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 245
    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/ai;->b()Ljava/lang/String;

    .line 247
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ak;->d:Lcom/google/analytics/tracking/android/h;

    invoke-interface {v0, p1}, Lcom/google/analytics/tracking/android/h;->a(Ljava/util/Map;)V

    .line 248
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public final b()Z
    .locals 2

    .prologue
    .line 143
    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v0

    sget-object v1, Lcom/google/analytics/tracking/android/aj;->ad:Lcom/google/analytics/tracking/android/aj;

    invoke-virtual {v0, v1}, Lcom/google/analytics/tracking/android/ai;->a(Lcom/google/analytics/tracking/android/aj;)V

    .line 144
    iget-boolean v0, p0, Lcom/google/analytics/tracking/android/ak;->c:Z

    return v0
.end method
