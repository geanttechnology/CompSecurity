.class public final Lvy;
.super Ljava/lang/Object;

# interfaces
.implements Lwa;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Lwd;

.field private final c:J

.field private final d:Lvu;

.field private final e:Lcom/google/android/gms/internal/av;

.field private final f:Lcom/google/android/gms/internal/ay;

.field private final g:Landroid/content/Context;

.field private final h:Ljava/lang/Object;

.field private final i:Lcom/google/android/gms/internal/gs;

.field private j:Lwg;

.field private k:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Lwd;Lvv;Lvu;Lcom/google/android/gms/internal/av;Lcom/google/android/gms/internal/ay;Lcom/google/android/gms/internal/gs;)V
    .locals 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lvy;->h:Ljava/lang/Object;

    const/4 v0, -0x2

    iput v0, p0, Lvy;->k:I

    iput-object p1, p0, Lvy;->g:Landroid/content/Context;

    iput-object p3, p0, Lvy;->b:Lwd;

    iput-object p5, p0, Lvy;->d:Lvu;

    const-string v0, "com.google.ads.mediation.customevent.CustomEventAdapter"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lvy;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lvy;->a:Ljava/lang/String;

    :goto_0
    iget-wide v0, p4, Lvv;->b:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    iget-wide v0, p4, Lvv;->b:J

    :goto_1
    iput-wide v0, p0, Lvy;->c:J

    iput-object p6, p0, Lvy;->e:Lcom/google/android/gms/internal/av;

    iput-object p7, p0, Lvy;->f:Lcom/google/android/gms/internal/ay;

    iput-object p8, p0, Lvy;->i:Lcom/google/android/gms/internal/gs;

    return-void

    :cond_0
    iput-object p2, p0, Lvy;->a:Ljava/lang/String;

    goto :goto_0

    :cond_1
    const-wide/16 v0, 0x2710

    goto :goto_1
.end method

.method static synthetic a(Lvy;)Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lvy;->h:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic a(Lvy;Lwg;)Lwg;
    .locals 0

    iput-object p1, p0, Lvy;->j:Lwg;

    return-object p1
.end method

.method private a(JJJJ)V
    .locals 3

    :goto_0
    iget v0, p0, Lvy;->k:I

    const/4 v1, -0x2

    if-eq v0, v1, :cond_0

    return-void

    :cond_0
    invoke-direct/range {p0 .. p8}, Lvy;->b(JJJJ)V

    goto :goto_0
.end method

.method private a(Lvx;)V
    .locals 7

    :try_start_0
    iget-object v0, p0, Lvy;->i:Lcom/google/android/gms/internal/gs;

    iget v0, v0, Lcom/google/android/gms/internal/gs;->d:I

    const v1, 0x3e8fa0

    if-ge v0, v1, :cond_1

    iget-object v0, p0, Lvy;->f:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lvy;->j:Lwg;

    iget-object v1, p0, Lvy;->g:Landroid/content/Context;

    invoke-static {v1}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v1

    iget-object v2, p0, Lvy;->e:Lcom/google/android/gms/internal/av;

    iget-object v3, p0, Lvy;->d:Lvu;

    iget-object v3, v3, Lvu;->g:Ljava/lang/String;

    invoke-interface {v0, v1, v2, v3, p1}, Lwg;->a(Lry;Lcom/google/android/gms/internal/av;Ljava/lang/String;Lwl;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lvy;->j:Lwg;

    iget-object v1, p0, Lvy;->g:Landroid/content/Context;

    invoke-static {v1}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v1

    iget-object v2, p0, Lvy;->f:Lcom/google/android/gms/internal/ay;

    iget-object v3, p0, Lvy;->e:Lcom/google/android/gms/internal/av;

    iget-object v4, p0, Lvy;->d:Lvu;

    iget-object v4, v4, Lvu;->g:Ljava/lang/String;

    move-object v5, p1

    invoke-interface/range {v0 .. v5}, Lwg;->a(Lry;Lcom/google/android/gms/internal/ay;Lcom/google/android/gms/internal/av;Ljava/lang/String;Lwl;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "Could not request ad from mediation adapter."

    invoke-static {v1, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 v0, 0x5

    invoke-virtual {p0, v0}, Lvy;->a(I)V

    goto :goto_0

    :cond_1
    :try_start_1
    iget-object v0, p0, Lvy;->f:Lcom/google/android/gms/internal/ay;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lvy;->j:Lwg;

    iget-object v1, p0, Lvy;->g:Landroid/content/Context;

    invoke-static {v1}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v1

    iget-object v2, p0, Lvy;->e:Lcom/google/android/gms/internal/av;

    iget-object v3, p0, Lvy;->d:Lvu;

    iget-object v3, v3, Lvu;->g:Ljava/lang/String;

    iget-object v4, p0, Lvy;->d:Lvu;

    iget-object v4, v4, Lvu;->a:Ljava/lang/String;

    move-object v5, p1

    invoke-interface/range {v0 .. v5}, Lwg;->a(Lry;Lcom/google/android/gms/internal/av;Ljava/lang/String;Ljava/lang/String;Lwl;)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lvy;->j:Lwg;

    iget-object v1, p0, Lvy;->g:Landroid/content/Context;

    invoke-static {v1}, Lsb;->a(Ljava/lang/Object;)Lry;

    move-result-object v1

    iget-object v2, p0, Lvy;->f:Lcom/google/android/gms/internal/ay;

    iget-object v3, p0, Lvy;->e:Lcom/google/android/gms/internal/av;

    iget-object v4, p0, Lvy;->d:Lvu;

    iget-object v4, v4, Lvu;->g:Ljava/lang/String;

    iget-object v5, p0, Lvy;->d:Lvu;

    iget-object v5, v5, Lvu;->a:Ljava/lang/String;

    move-object v6, p1

    invoke-interface/range {v0 .. v6}, Lwg;->a(Lry;Lcom/google/android/gms/internal/ay;Lcom/google/android/gms/internal/av;Ljava/lang/String;Ljava/lang/String;Lwl;)V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method static synthetic a(Lvy;Lvx;)V
    .locals 0

    invoke-direct {p0, p1}, Lvy;->a(Lvx;)V

    return-void
.end method

.method static synthetic b(Lvy;)I
    .locals 1

    iget v0, p0, Lvy;->k:I

    return v0
.end method

.method private b()Ljava/lang/String;
    .locals 2

    :try_start_0
    iget-object v0, p0, Lvy;->d:Lvu;

    iget-object v0, v0, Lvu;->e:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lvy;->b:Lwd;

    iget-object v1, p0, Lvy;->d:Lvu;

    iget-object v1, v1, Lvu;->e:Ljava/lang/String;

    invoke-interface {v0, v1}, Lwd;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter"

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "com.google.ads.mediation.customevent.CustomEventAdapter"
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v0, "Fail to determine the custom event\'s version, assuming the old one."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    :cond_1
    const-string v0, "com.google.ads.mediation.customevent.CustomEventAdapter"

    goto :goto_0
.end method

.method private b(JJJJ)V
    .locals 7

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    sub-long v2, v0, p1

    sub-long v2, p3, v2

    sub-long/2addr v0, p5

    sub-long v0, p7, v0

    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-lez v4, :cond_0

    const-wide/16 v4, 0x0

    cmp-long v4, v0, v4

    if-gtz v4, :cond_1

    :cond_0
    const-string v0, "Timed out waiting for adapter."

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    const/4 v0, 0x3

    iput v0, p0, Lvy;->k:I

    :goto_0
    return-void

    :cond_1
    :try_start_0
    iget-object v4, p0, Lvy;->h:Ljava/lang/Object;

    invoke-static {v2, v3, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    invoke-virtual {v4, v0, v1}, Ljava/lang/Object;->wait(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const/4 v0, -0x1

    iput v0, p0, Lvy;->k:I

    goto :goto_0
.end method

.method private c()Lwg;
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Instantiating mediation adapter: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lvy;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    :try_start_0
    iget-object v0, p0, Lvy;->b:Lwd;

    iget-object v1, p0, Lvy;->a:Ljava/lang/String;

    invoke-interface {v0, v1}, Lwd;->a(Ljava/lang/String;)Lwg;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not instantiate mediation adapter: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lvy;->a:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lacb;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic c(Lvy;)Lwg;
    .locals 1

    invoke-direct {p0}, Lvy;->c()Lwg;

    move-result-object v0

    return-object v0
.end method

.method static synthetic d(Lvy;)Lwg;
    .locals 1

    iget-object v0, p0, Lvy;->j:Lwg;

    return-object v0
.end method


# virtual methods
.method public a(JJ)Lvz;
    .locals 13

    iget-object v10, p0, Lvy;->h:Ljava/lang/Object;

    monitor-enter v10

    :try_start_0
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    new-instance v11, Lvx;

    invoke-direct {v11}, Lvx;-><init>()V

    sget-object v0, Laca;->a:Landroid/os/Handler;

    new-instance v1, Lvy$1;

    invoke-direct {v1, p0, v11}, Lvy$1;-><init>(Lvy;Lvx;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    iget-wide v4, p0, Lvy;->c:J

    move-object v1, p0

    move-wide v6, p1

    move-wide/from16 v8, p3

    invoke-direct/range {v1 .. v9}, Lvy;->a(JJJJ)V

    new-instance v0, Lvz;

    iget-object v1, p0, Lvy;->d:Lvu;

    iget-object v2, p0, Lvy;->j:Lwg;

    iget-object v3, p0, Lvy;->a:Ljava/lang/String;

    iget v5, p0, Lvy;->k:I

    move-object v4, v11

    invoke-direct/range {v0 .. v5}, Lvz;-><init>(Lvu;Lwg;Ljava/lang/String;Lvx;I)V

    monitor-exit v10

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v10
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a()V
    .locals 3

    iget-object v1, p0, Lvy;->h:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lvy;->j:Lwg;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lvy;->j:Lwg;

    invoke-interface {v0}, Lwg;->c()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    :goto_0
    const/4 v0, -0x1

    :try_start_1
    iput v0, p0, Lvy;->k:I

    iget-object v0, p0, Lvy;->h:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    return-void

    :catch_0
    move-exception v0

    const-string v2, "Could not destroy mediation adapter."

    invoke-static {v2, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public a(I)V
    .locals 2

    iget-object v1, p0, Lvy;->h:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iput p1, p0, Lvy;->k:I

    iget-object v0, p0, Lvy;->h:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
