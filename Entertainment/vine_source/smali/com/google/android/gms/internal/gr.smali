.class public final Lcom/google/android/gms/internal/gr;
.super Ljava/lang/Object;


# static fields
.field private static final BG:Lcom/google/android/gms/internal/gn;

.field public static final CN:Ljava/lang/Object;


# instance fields
.field private CJ:J

.field private CK:J

.field private CL:J

.field private CM:Lcom/google/android/gms/internal/gq;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/google/android/gms/internal/gn;

    const-string v1, "RequestTracker"

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/gn;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/google/android/gms/internal/gr;->BG:Lcom/google/android/gms/internal/gn;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/gr;->CN:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(J)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide p1, p0, Lcom/google/android/gms/internal/gr;->CJ:J

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/google/android/gms/internal/gr;->CK:J

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/google/android/gms/internal/gr;->CL:J

    return-void
.end method

.method private eu()V
    .locals 2

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/google/android/gms/internal/gr;->CK:J

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/gr;->CM:Lcom/google/android/gms/internal/gq;

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/google/android/gms/internal/gr;->CL:J

    return-void
.end method


# virtual methods
.method public a(JLcom/google/android/gms/internal/gq;)V
    .locals 6

    sget-object v1, Lcom/google/android/gms/internal/gr;->CN:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/gr;->CM:Lcom/google/android/gms/internal/gq;

    iget-wide v2, p0, Lcom/google/android/gms/internal/gr;->CK:J

    iput-wide p1, p0, Lcom/google/android/gms/internal/gr;->CK:J

    iput-object p3, p0, Lcom/google/android/gms/internal/gr;->CM:Lcom/google/android/gms/internal/gq;

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/google/android/gms/internal/gr;->CL:J

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    invoke-interface {v0, v2, v3}, Lcom/google/android/gms/internal/gq;->n(J)V

    :cond_0
    return-void

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public b(JILorg/json/JSONObject;)Z
    .locals 8

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v0, 0x0

    sget-object v3, Lcom/google/android/gms/internal/gr;->CN:Ljava/lang/Object;

    monitor-enter v3

    :try_start_0
    iget-wide v4, p0, Lcom/google/android/gms/internal/gr;->CK:J

    const-wide/16 v6, -0x1

    cmp-long v4, v4, v6

    if-eqz v4, :cond_1

    iget-wide v4, p0, Lcom/google/android/gms/internal/gr;->CK:J

    cmp-long v4, v4, p1

    if-nez v4, :cond_1

    sget-object v0, Lcom/google/android/gms/internal/gr;->BG:Lcom/google/android/gms/internal/gn;

    const-string v2, "request %d completed"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-wide v6, p0, Lcom/google/android/gms/internal/gr;->CK:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v2, v4}, Lcom/google/android/gms/internal/gn;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/gr;->CM:Lcom/google/android/gms/internal/gq;

    invoke-direct {p0}, Lcom/google/android/gms/internal/gr;->eu()V

    :goto_0
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/google/android/gms/internal/gq;->a(JILorg/json/JSONObject;)V

    :cond_0
    return v1

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_1
    move v1, v2

    goto :goto_0
.end method

.method public c(JI)Z
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/google/android/gms/internal/gr;->b(JILorg/json/JSONObject;)Z

    move-result v0

    return v0
.end method

.method public clear()V
    .locals 6

    sget-object v1, Lcom/google/android/gms/internal/gr;->CN:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-wide v2, p0, Lcom/google/android/gms/internal/gr;->CK:J

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/google/android/gms/internal/gr;->eu()V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public d(JI)Z
    .locals 10

    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v2, 0x0

    const-wide/16 v0, 0x0

    sget-object v5, Lcom/google/android/gms/internal/gr;->CN:Ljava/lang/Object;

    monitor-enter v5

    :try_start_0
    iget-wide v6, p0, Lcom/google/android/gms/internal/gr;->CK:J

    const-wide/16 v8, -0x1

    cmp-long v6, v6, v8

    if-eqz v6, :cond_1

    iget-wide v6, p0, Lcom/google/android/gms/internal/gr;->CL:J

    sub-long v6, p1, v6

    iget-wide v8, p0, Lcom/google/android/gms/internal/gr;->CJ:J

    cmp-long v6, v6, v8

    if-ltz v6, :cond_1

    sget-object v0, Lcom/google/android/gms/internal/gr;->BG:Lcom/google/android/gms/internal/gn;

    const-string v1, "request %d timed out"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget-wide v7, p0, Lcom/google/android/gms/internal/gr;->CK:J

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v2, v6

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/gn;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    iget-wide v0, p0, Lcom/google/android/gms/internal/gr;->CK:J

    iget-object v2, p0, Lcom/google/android/gms/internal/gr;->CM:Lcom/google/android/gms/internal/gq;

    invoke-direct {p0}, Lcom/google/android/gms/internal/gr;->eu()V

    :goto_0
    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v2, :cond_0

    invoke-interface {v2, v0, v1, p3, v3}, Lcom/google/android/gms/internal/gq;->a(JILorg/json/JSONObject;)V

    :cond_0
    return v4

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_1
    move v4, v2

    move-object v2, v3

    goto :goto_0
.end method

.method public ev()Z
    .locals 6

    sget-object v1, Lcom/google/android/gms/internal/gr;->CN:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-wide v2, p0, Lcom/google/android/gms/internal/gr;->CK:J

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public p(J)Z
    .locals 6

    sget-object v1, Lcom/google/android/gms/internal/gr;->CN:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-wide v2, p0, Lcom/google/android/gms/internal/gr;->CK:J

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    iget-wide v2, p0, Lcom/google/android/gms/internal/gr;->CK:J

    cmp-long v0, v2, p1

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
