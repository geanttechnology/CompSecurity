.class public Lzw;
.super Labn;

# interfaces
.implements Laaf;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lzh;

.field private final b:Ljava/lang/Object;

.field private final c:Landroid/content/Context;

.field private final d:Ljava/lang/Object;

.field private final e:Laak;

.field private final f:Laea;

.field private g:Labn;

.field private h:Lcom/google/android/gms/internal/fj;

.field private i:Lvv;


# direct methods
.method public constructor <init>(Landroid/content/Context;Laak;Laea;Lzh;)V
    .locals 1

    invoke-direct {p0}, Labn;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lzw;->b:Ljava/lang/Object;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lzw;->d:Ljava/lang/Object;

    iput-object p4, p0, Lzw;->a:Lzh;

    iput-object p1, p0, Lzw;->c:Landroid/content/Context;

    iput-object p2, p0, Lzw;->e:Laak;

    iput-object p3, p0, Lzw;->f:Laea;

    return-void
.end method

.method private a(Lcom/google/android/gms/internal/fh;)Lcom/google/android/gms/internal/ay;
    .locals 11

    const/4 v3, 0x0

    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v0, v0, Lcom/google/android/gms/internal/fj;->m:Ljava/lang/String;

    if-nez v0, :cond_0

    new-instance v0, Lzx;

    const-string v1, "The ad response must specify one of the supported ad sizes."

    invoke-direct {v0, v1, v3}, Lzx;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_0
    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v0, v0, Lcom/google/android/gms/internal/fj;->m:Ljava/lang/String;

    const-string v1, "x"

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    array-length v1, v0

    const/4 v2, 0x2

    if-eq v1, v2, :cond_1

    new-instance v0, Lzx;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not parse the ad size from the ad response: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v2, v2, Lcom/google/android/gms/internal/fj;->m:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v3}, Lzx;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_1
    const/4 v1, 0x0

    :try_start_0
    aget-object v1, v0, v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    const/4 v1, 0x1

    aget-object v0, v0, v1

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    iget-object v0, p1, Lcom/google/android/gms/internal/fh;->d:Lcom/google/android/gms/internal/ay;

    iget-object v6, v0, Lcom/google/android/gms/internal/ay;->h:[Lcom/google/android/gms/internal/ay;

    array-length v7, v6

    move v2, v3

    :goto_0
    if-ge v2, v7, :cond_5

    aget-object v8, v6, v2

    iget-object v0, p0, Lzw;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v1, v0, Landroid/util/DisplayMetrics;->density:F

    iget v0, v8, Lcom/google/android/gms/internal/ay;->f:I

    const/4 v9, -0x1

    if-ne v0, v9, :cond_2

    iget v0, v8, Lcom/google/android/gms/internal/ay;->g:I

    int-to-float v0, v0

    div-float/2addr v0, v1

    float-to-int v0, v0

    :goto_1
    iget v9, v8, Lcom/google/android/gms/internal/ay;->c:I

    const/4 v10, -0x2

    if-ne v9, v10, :cond_3

    iget v9, v8, Lcom/google/android/gms/internal/ay;->d:I

    int-to-float v9, v9

    div-float v1, v9, v1

    float-to-int v1, v1

    :goto_2
    if-ne v4, v0, :cond_4

    if-ne v5, v1, :cond_4

    new-instance v0, Lcom/google/android/gms/internal/ay;

    iget-object v1, p1, Lcom/google/android/gms/internal/fh;->d:Lcom/google/android/gms/internal/ay;

    iget-object v1, v1, Lcom/google/android/gms/internal/ay;->h:[Lcom/google/android/gms/internal/ay;

    invoke-direct {v0, v8, v1}, Lcom/google/android/gms/internal/ay;-><init>(Lcom/google/android/gms/internal/ay;[Lcom/google/android/gms/internal/ay;)V

    return-object v0

    :catch_0
    move-exception v0

    new-instance v0, Lzx;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not parse the ad size from the ad response: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v2, v2, Lcom/google/android/gms/internal/fj;->m:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v3}, Lzx;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_2
    iget v0, v8, Lcom/google/android/gms/internal/ay;->f:I

    goto :goto_1

    :cond_3
    iget v1, v8, Lcom/google/android/gms/internal/ay;->c:I

    goto :goto_2

    :cond_4
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    :cond_5
    new-instance v0, Lzx;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "The ad size from the ad response was not one of the requested sizes: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v2, v2, Lcom/google/android/gms/internal/fj;->m:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v3}, Lzx;-><init>(Ljava/lang/String;I)V

    throw v0
.end method

.method static synthetic a(Lzw;)Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lzw;->d:Ljava/lang/Object;

    return-object v0
.end method

.method private a(J)V
    .locals 3

    :cond_0
    invoke-direct {p0, p1, p2}, Lzw;->b(J)Z

    move-result v0

    if-nez v0, :cond_1

    new-instance v0, Lzx;

    const-string v1, "Timed out waiting for ad response."

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lzx;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_1
    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lzw;->b:Ljava/lang/Object;

    monitor-enter v1

    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lzw;->g:Labn;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget v0, v0, Lcom/google/android/gms/internal/fj;->e:I

    const/4 v1, -0x2

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget v0, v0, Lcom/google/android/gms/internal/fj;->e:I

    const/4 v1, -0x3

    if-eq v0, v1, :cond_2

    new-instance v0, Lzx;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "There was a problem getting an ad response. ErrorCode: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget v2, v2, Lcom/google/android/gms/internal/fj;->e:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget v2, v2, Lcom/google/android/gms/internal/fj;->e:I

    invoke-direct {v0, v1, v2}, Lzx;-><init>(Ljava/lang/String;I)V

    throw v0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_2
    return-void
.end method

.method private a(Z)V
    .locals 2

    invoke-static {}, Labi;->a()Labi;

    move-result-object v0

    invoke-virtual {v0, p1}, Labi;->a(Z)V

    invoke-static {}, Labi;->a()Labi;

    move-result-object v0

    iget-object v1, p0, Lzw;->c:Landroid/content/Context;

    invoke-virtual {v0, v1}, Labi;->a(Landroid/content/Context;)Lsy;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lsy;->isAlive()Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "start fetching content..."

    invoke-static {v1}, Lacb;->a(Ljava/lang/String;)V

    invoke-virtual {v0}, Lsy;->a()V

    :cond_0
    return-void
.end method

.method static synthetic b(Lzw;)Lzh;
    .locals 1

    iget-object v0, p0, Lzw;->a:Lzh;

    return-object v0
.end method

.method private b(J)Z
    .locals 5

    const-wide/32 v0, 0xea60

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    sub-long/2addr v2, p1

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-gtz v2, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    :try_start_0
    iget-object v2, p0, Lzw;->d:Ljava/lang/Object;

    invoke-virtual {v2, v0, v1}, Ljava/lang/Object;->wait(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v0, Lzx;

    const-string v1, "Ad request cancelled."

    const/4 v2, -0x1

    invoke-direct {v0, v1, v2}, Lzx;-><init>(Ljava/lang/String;I)V

    throw v0
.end method

.method private c()V
    .locals 3

    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget v0, v0, Lcom/google/android/gms/internal/fj;->e:I

    const/4 v1, -0x3

    if-ne v0, v1, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v0, v0, Lcom/google/android/gms/internal/fj;->c:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    new-instance v0, Lzx;

    const-string v1, "No fill from ad server."

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2}, Lzx;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_2
    iget-object v0, p0, Lzw;->c:Landroid/content/Context;

    iget-object v1, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-boolean v1, v1, Lcom/google/android/gms/internal/fj;->u:Z

    invoke-static {v0, v1}, Labi;->a(Landroid/content/Context;Z)V

    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/fj;->h:Z

    if-eqz v0, :cond_0

    :try_start_0
    new-instance v0, Lvv;

    iget-object v1, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v1, v1, Lcom/google/android/gms/internal/fj;->c:Ljava/lang/String;

    invoke-direct {v0, v1}, Lvv;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lzw;->i:Lvv;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v0, Lzx;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not parse mediation config: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v2, v2, Lcom/google/android/gms/internal/fj;->c:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lzx;-><init>(Ljava/lang/String;I)V

    throw v0
.end method


# virtual methods
.method public a()V
    .locals 12

    const/4 v8, 0x0

    iget-object v11, p0, Lzw;->d:Ljava/lang/Object;

    monitor-enter v11

    :try_start_0
    const-string v0, "AdLoaderBackgroundTask started."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lzw;->f:Laea;

    invoke-virtual {v0}, Laea;->a()Labh;

    move-result-object v0

    iget-object v1, p0, Lzw;->c:Landroid/content/Context;

    invoke-interface {v0, v1}, Labh;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/google/android/gms/internal/fh;

    iget-object v2, p0, Lzw;->e:Laak;

    invoke-direct {v1, v2, v0}, Lcom/google/android/gms/internal/fh;-><init>(Laak;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    const/4 v5, -0x2

    const-wide/16 v2, -0x1

    :try_start_1
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v6

    iget-object v0, p0, Lzw;->c:Landroid/content/Context;

    invoke-static {v0, v1, p0}, Laae;->a(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laaf;)Labn;

    move-result-object v0

    iget-object v4, p0, Lzw;->b:Ljava/lang/Object;

    monitor-enter v4
    :try_end_1
    .catch Lzx; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :try_start_2
    iput-object v0, p0, Lzw;->g:Labn;

    iget-object v0, p0, Lzw;->g:Labn;

    if-nez v0, :cond_1

    new-instance v0, Lzx;

    const-string v5, "Could not start the ad request service."

    const/4 v6, 0x0

    invoke-direct {v0, v5, v6}, Lzx;-><init>(Ljava/lang/String;I)V

    throw v0

    :catchall_0
    move-exception v0

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0
    :try_end_3
    .catch Lzx; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :catch_0
    move-exception v0

    move-object v4, v8

    :goto_0
    :try_start_4
    invoke-virtual {v0}, Lzx;->a()I

    move-result v5

    const/4 v6, 0x3

    if-eq v5, v6, :cond_0

    const/4 v6, -0x1

    if-ne v5, v6, :cond_2

    :cond_0
    invoke-virtual {v0}, Lzx;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    :goto_1
    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    if-nez v0, :cond_3

    new-instance v0, Lcom/google/android/gms/internal/fj;

    invoke-direct {v0, v5}, Lcom/google/android/gms/internal/fj;-><init>(I)V

    iput-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    :goto_2
    sget-object v0, Laca;->a:Landroid/os/Handler;

    new-instance v6, Lzw$1;

    invoke-direct {v6, p0}, Lzw$1;-><init>(Lzw;)V

    invoke-virtual {v0, v6}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    move-wide v6, v2

    :goto_3
    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v0, v0, Lcom/google/android/gms/internal/fj;->r:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result v0

    if-nez v0, :cond_4

    :try_start_5
    new-instance v10, Lorg/json/JSONObject;

    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v0, v0, Lcom/google/android/gms/internal/fj;->r:Ljava/lang/String;

    invoke-direct {v10, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    :goto_4
    :try_start_6
    new-instance v0, Labe;

    iget-object v2, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v3, p0, Lzw;->i:Lvv;

    iget-object v8, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-wide v8, v8, Lcom/google/android/gms/internal/fj;->n:J

    invoke-direct/range {v0 .. v10}, Labe;-><init>(Lcom/google/android/gms/internal/fh;Lcom/google/android/gms/internal/fj;Lvv;Lcom/google/android/gms/internal/ay;IJJLorg/json/JSONObject;)V

    sget-object v1, Laca;->a:Landroid/os/Handler;

    new-instance v2, Lzw$2;

    invoke-direct {v2, p0, v0}, Lzw$2;-><init>(Lzw;Labe;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    monitor-exit v11
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    return-void

    :cond_1
    :try_start_7
    monitor-exit v4
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    :try_start_8
    invoke-direct {p0, v6, v7}, Lzw;->a(J)V

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    invoke-direct {p0}, Lzw;->c()V

    iget-object v0, v1, Lcom/google/android/gms/internal/fh;->d:Lcom/google/android/gms/internal/ay;

    iget-object v0, v0, Lcom/google/android/gms/internal/ay;->h:[Lcom/google/android/gms/internal/ay;

    if-eqz v0, :cond_5

    invoke-direct {p0, v1}, Lzw;->a(Lcom/google/android/gms/internal/fh;)Lcom/google/android/gms/internal/ay;
    :try_end_8
    .catch Lzx; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    move-result-object v4

    :goto_5
    :try_start_9
    iget-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-boolean v0, v0, Lcom/google/android/gms/internal/fj;->v:Z

    invoke-direct {p0, v0}, Lzw;->a(Z)V
    :try_end_9
    .catch Lzx; {:try_start_9 .. :try_end_9} :catch_2
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    move-wide v6, v2

    goto :goto_3

    :cond_2
    :try_start_a
    invoke-virtual {v0}, Lzx;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_1

    :catchall_1
    move-exception v0

    monitor-exit v11
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    throw v0

    :cond_3
    :try_start_b
    new-instance v0, Lcom/google/android/gms/internal/fj;

    iget-object v6, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-wide v6, v6, Lcom/google/android/gms/internal/fj;->k:J

    invoke-direct {v0, v5, v6, v7}, Lcom/google/android/gms/internal/fj;-><init>(IJ)V

    iput-object v0, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    goto :goto_2

    :catch_1
    move-exception v0

    const-string v2, "Error parsing the JSON for Active View."

    invoke-static {v2, v0}, Lacb;->b(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    :cond_4
    move-object v10, v8

    goto :goto_4

    :catch_2
    move-exception v0

    goto/16 :goto_0

    :cond_5
    move-object v4, v8

    goto :goto_5
.end method

.method public a(Lcom/google/android/gms/internal/fj;)V
    .locals 2

    iget-object v1, p0, Lzw;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    const-string v0, "Received ad response."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    iput-object p1, p0, Lzw;->h:Lcom/google/android/gms/internal/fj;

    iget-object v0, p0, Lzw;->d:Ljava/lang/Object;

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

.method public b()V
    .locals 2

    iget-object v1, p0, Lzw;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lzw;->g:Labn;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lzw;->g:Labn;

    invoke-virtual {v0}, Labn;->f()V

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
