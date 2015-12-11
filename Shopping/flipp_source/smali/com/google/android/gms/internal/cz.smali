.class public final Lcom/google/android/gms/internal/cz;
.super Lcom/google/android/gms/internal/ee;

# interfaces
.implements Lcom/google/android/gms/internal/df;
.implements Lcom/google/android/gms/internal/fb;


# instance fields
.field final a:Lcom/google/android/gms/internal/cy;

.field final b:Lcom/google/android/gms/internal/ew;

.field final c:Ljava/lang/Object;

.field d:Lcom/google/android/gms/internal/cb;

.field private final g:Lcom/google/android/gms/internal/bn;

.field private final h:Ljava/lang/Object;

.field private final i:Landroid/content/Context;

.field private final j:Lcom/google/android/gms/internal/dk;

.field private final k:Lcom/google/android/gms/internal/jg;

.field private l:Lcom/google/android/gms/internal/ee;

.field private m:Z

.field private n:Lcom/google/android/gms/internal/al;

.field private o:Lcom/google/android/gms/internal/ao;

.field private p:Lcom/google/android/gms/internal/at;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/dk;Lcom/google/android/gms/internal/jg;Lcom/google/android/gms/internal/ew;Lcom/google/android/gms/internal/bn;Lcom/google/android/gms/internal/cy;)V
    .locals 1

    invoke-direct {p0}, Lcom/google/android/gms/internal/ee;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/cz;->h:Ljava/lang/Object;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/cz;->c:Ljava/lang/Object;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/internal/cz;->m:Z

    iput-object p5, p0, Lcom/google/android/gms/internal/cz;->g:Lcom/google/android/gms/internal/bn;

    iput-object p6, p0, Lcom/google/android/gms/internal/cz;->a:Lcom/google/android/gms/internal/cy;

    iput-object p4, p0, Lcom/google/android/gms/internal/cz;->b:Lcom/google/android/gms/internal/ew;

    iput-object p1, p0, Lcom/google/android/gms/internal/cz;->i:Landroid/content/Context;

    iput-object p2, p0, Lcom/google/android/gms/internal/cz;->j:Lcom/google/android/gms/internal/dk;

    iput-object p3, p0, Lcom/google/android/gms/internal/cz;->k:Lcom/google/android/gms/internal/jg;

    return-void
.end method

.method private a(Lcom/google/android/gms/internal/bz;)Lcom/google/android/gms/internal/x;
    .locals 11

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v0, v0, Lcom/google/android/gms/internal/cb;->m:Ljava/lang/String;

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/dd;

    const-string v1, "The ad response must specify one of the supported ad sizes."

    invoke-direct {v0, v1, v3}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v0, v0, Lcom/google/android/gms/internal/cb;->m:Ljava/lang/String;

    const-string v1, "x"

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    array-length v1, v0

    const/4 v2, 0x2

    if-eq v1, v2, :cond_1

    new-instance v0, Lcom/google/android/gms/internal/dd;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Could not parse the ad size from the ad response: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v2, v2, Lcom/google/android/gms/internal/cb;->m:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v3}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

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

    iget-object v0, p1, Lcom/google/android/gms/internal/bz;->d:Lcom/google/android/gms/internal/x;

    iget-object v6, v0, Lcom/google/android/gms/internal/x;->h:[Lcom/google/android/gms/internal/x;

    array-length v7, v6

    move v2, v3

    :goto_0
    if-ge v2, v7, :cond_5

    aget-object v8, v6, v2

    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->i:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v1, v0, Landroid/util/DisplayMetrics;->density:F

    iget v0, v8, Lcom/google/android/gms/internal/x;->f:I

    const/4 v9, -0x1

    if-ne v0, v9, :cond_2

    iget v0, v8, Lcom/google/android/gms/internal/x;->g:I

    int-to-float v0, v0

    div-float/2addr v0, v1

    float-to-int v0, v0

    :goto_1
    iget v9, v8, Lcom/google/android/gms/internal/x;->c:I

    const/4 v10, -0x2

    if-ne v9, v10, :cond_3

    iget v9, v8, Lcom/google/android/gms/internal/x;->d:I

    int-to-float v9, v9

    div-float v1, v9, v1

    float-to-int v1, v1

    :goto_2
    if-ne v4, v0, :cond_4

    if-ne v5, v1, :cond_4

    new-instance v0, Lcom/google/android/gms/internal/x;

    iget-object v1, p1, Lcom/google/android/gms/internal/bz;->d:Lcom/google/android/gms/internal/x;

    iget-object v1, v1, Lcom/google/android/gms/internal/x;->h:[Lcom/google/android/gms/internal/x;

    invoke-direct {v0, v8, v1}, Lcom/google/android/gms/internal/x;-><init>(Lcom/google/android/gms/internal/x;[Lcom/google/android/gms/internal/x;)V

    return-object v0

    :catch_0
    move-exception v0

    new-instance v0, Lcom/google/android/gms/internal/dd;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Could not parse the ad size from the ad response: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v2, v2, Lcom/google/android/gms/internal/cb;->m:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v3}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_2
    iget v0, v8, Lcom/google/android/gms/internal/x;->f:I

    goto :goto_1

    :cond_3
    iget v1, v8, Lcom/google/android/gms/internal/x;->c:I

    goto :goto_2

    :cond_4
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    :cond_5
    new-instance v0, Lcom/google/android/gms/internal/dd;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "The ad size from the ad response was not one of the requested sizes: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v2, v2, Lcom/google/android/gms/internal/cb;->m:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, v3}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v0
.end method

.method private a(J)V
    .locals 3

    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/cz;->b(J)Z

    move-result v0

    if-nez v0, :cond_1

    new-instance v0, Lcom/google/android/gms/internal/dd;

    const-string v1, "Timed out waiting for WebView to finish loading."

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_1
    iget-boolean v0, p0, Lcom/google/android/gms/internal/cz;->m:Z

    if-eqz v0, :cond_0

    return-void
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
    iget-object v2, p0, Lcom/google/android/gms/internal/cz;->c:Ljava/lang/Object;

    invoke-virtual {v2, v0, v1}, Ljava/lang/Object;->wait(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v0, Lcom/google/android/gms/internal/dd;

    const-string v1, "Ad request cancelled."

    const/4 v2, -0x1

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v0
.end method


# virtual methods
.method public final a()V
    .locals 25

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gms/internal/cz;->c:Ljava/lang/Object;

    move-object/from16 v24, v0

    monitor-enter v24

    :try_start_0
    const-string v2, "AdLoaderBackgroundTask started."

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->k:Lcom/google/android/gms/internal/jg;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/jg;->a()Lcom/google/android/gms/internal/fl;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gms/internal/cz;->i:Landroid/content/Context;

    invoke-interface {v2, v3}, Lcom/google/android/gms/internal/fl;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    new-instance v12, Lcom/google/android/gms/internal/bz;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gms/internal/cz;->j:Lcom/google/android/gms/internal/dk;

    invoke-direct {v12, v3, v2}, Lcom/google/android/gms/internal/bz;-><init>(Lcom/google/android/gms/internal/dk;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    const/4 v3, 0x0

    const/4 v6, -0x2

    :try_start_1
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v4

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/google/android/gms/internal/cz;->i:Landroid/content/Context;

    iget-object v2, v12, Lcom/google/android/gms/internal/bz;->k:Lcom/google/android/gms/internal/cu;

    iget-boolean v2, v2, Lcom/google/android/gms/internal/cu;->e:Z

    if-eqz v2, :cond_1

    const-string v2, "Fetching ad response from local ad request service."

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    new-instance v2, Lcom/google/android/gms/internal/dh;

    move-object/from16 v0, p0

    invoke-direct {v2, v7, v12, v0}, Lcom/google/android/gms/internal/dh;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/bz;Lcom/google/android/gms/internal/df;)V

    iget-object v7, v2, Lcom/google/android/gms/internal/ee;->e:Ljava/lang/Runnable;

    invoke-static {v7}, Lcom/google/android/gms/internal/eg;->a(Ljava/lang/Runnable;)V

    :goto_0
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/google/android/gms/internal/cz;->h:Ljava/lang/Object;

    monitor-enter v7
    :try_end_1
    .catch Lcom/google/android/gms/internal/dd; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :try_start_2
    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/google/android/gms/internal/cz;->l:Lcom/google/android/gms/internal/ee;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->l:Lcom/google/android/gms/internal/ee;

    if-nez v2, :cond_3

    new-instance v2, Lcom/google/android/gms/internal/dd;

    const-string v4, "Could not start the ad request service."

    const/4 v5, 0x0

    invoke-direct {v2, v4, v5}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v2

    :catchall_0
    move-exception v2

    monitor-exit v7
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v2
    :try_end_3
    .catch Lcom/google/android/gms/internal/dd; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :catch_0
    move-exception v2

    :try_start_4
    iget v6, v2, Lcom/google/android/gms/internal/dd;->a:I

    const/4 v4, 0x3

    if-eq v6, v4, :cond_0

    const/4 v4, -0x1

    if-ne v6, v4, :cond_b

    :cond_0
    invoke-virtual {v2}, Lcom/google/android/gms/internal/dd;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->b(Ljava/lang/String;)V

    :goto_1
    new-instance v2, Lcom/google/android/gms/internal/cb;

    invoke-direct {v2, v6}, Lcom/google/android/gms/internal/cb;-><init>(I)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    sget-object v2, Lcom/google/android/gms/internal/er;->a:Landroid/os/Handler;

    new-instance v4, Lcom/google/android/gms/internal/da;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/google/android/gms/internal/da;-><init>(Lcom/google/android/gms/internal/cz;)V

    invoke-virtual {v2, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    move-object/from16 v21, v3

    :goto_2
    new-instance v2, Lcom/google/android/gms/internal/eb;

    iget-object v3, v12, Lcom/google/android/gms/internal/bz;->c:Lcom/google/android/gms/internal/v;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gms/internal/cz;->b:Lcom/google/android/gms/internal/ew;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v5, v5, Lcom/google/android/gms/internal/cb;->d:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v7, v7, Lcom/google/android/gms/internal/cb;->f:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v8, v8, Lcom/google/android/gms/internal/cb;->j:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget v9, v9, Lcom/google/android/gms/internal/cb;->l:I

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-wide v10, v10, Lcom/google/android/gms/internal/cb;->k:J

    iget-object v12, v12, Lcom/google/android/gms/internal/bz;->i:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-boolean v13, v13, Lcom/google/android/gms/internal/cb;->h:Z

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    if-eqz v14, :cond_c

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    iget-object v14, v14, Lcom/google/android/gms/internal/at;->b:Lcom/google/android/gms/internal/an;

    :goto_3
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    if-eqz v15, :cond_d

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    iget-object v15, v15, Lcom/google/android/gms/internal/at;->c:Lcom/google/android/gms/internal/bq;

    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    move-object/from16 v16, v0

    if-eqz v16, :cond_e

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/google/android/gms/internal/at;->d:Ljava/lang/String;

    move-object/from16 v16, v0

    :goto_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gms/internal/cz;->o:Lcom/google/android/gms/internal/ao;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    move-object/from16 v18, v0

    if-eqz v18, :cond_f

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/google/android/gms/internal/at;->e:Lcom/google/android/gms/internal/aq;

    move-object/from16 v18, v0

    :goto_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget-wide v0, v0, Lcom/google/android/gms/internal/cb;->i:J

    move-wide/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-wide v0, v0, Lcom/google/android/gms/internal/cb;->g:J

    move-wide/from16 v22, v0

    invoke-direct/range {v2 .. v23}, Lcom/google/android/gms/internal/eb;-><init>(Lcom/google/android/gms/internal/v;Lcom/google/android/gms/internal/ew;Ljava/util/List;ILjava/util/List;Ljava/util/List;IJLjava/lang/String;ZLcom/google/android/gms/internal/an;Lcom/google/android/gms/internal/bq;Ljava/lang/String;Lcom/google/android/gms/internal/ao;Lcom/google/android/gms/internal/aq;JLcom/google/android/gms/internal/x;J)V

    sget-object v3, Lcom/google/android/gms/internal/er;->a:Landroid/os/Handler;

    new-instance v4, Lcom/google/android/gms/internal/db;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v2}, Lcom/google/android/gms/internal/db;-><init>(Lcom/google/android/gms/internal/cz;Lcom/google/android/gms/internal/eb;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    monitor-exit v24
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    return-void

    :cond_1
    :try_start_5
    const-string v2, "Fetching ad response from remote ad request service."

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    invoke-static {v7}, Lcom/google/android/gms/common/g;->a(Landroid/content/Context;)I

    move-result v2

    if-eqz v2, :cond_2

    const-string v2, "Failed to connect to remote ad request service."

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    const/4 v2, 0x0

    goto/16 :goto_0

    :cond_2
    new-instance v2, Lcom/google/android/gms/internal/di;

    move-object/from16 v0, p0

    invoke-direct {v2, v7, v12, v0}, Lcom/google/android/gms/internal/di;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/bz;Lcom/google/android/gms/internal/df;)V
    :try_end_5
    .catch Lcom/google/android/gms/internal/dd; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto/16 :goto_0

    :catchall_1
    move-exception v2

    :try_start_6
    monitor-exit v24
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    throw v2

    :cond_3
    :try_start_7
    monitor-exit v7
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    :cond_4
    :try_start_8
    move-object/from16 v0, p0

    invoke-direct {v0, v4, v5}, Lcom/google/android/gms/internal/cz;->b(J)Z

    move-result v2

    if-nez v2, :cond_5

    new-instance v2, Lcom/google/android/gms/internal/dd;

    const-string v4, "Timed out waiting for ad response."

    const/4 v5, 0x2

    invoke-direct {v2, v4, v5}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v2

    :cond_5
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    if-eqz v2, :cond_4

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/google/android/gms/internal/cz;->h:Ljava/lang/Object;

    monitor-enter v7
    :try_end_8
    .catch Lcom/google/android/gms/internal/dd; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    const/4 v2, 0x0

    :try_start_9
    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/google/android/gms/internal/cz;->l:Lcom/google/android/gms/internal/ee;

    monitor-exit v7
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    :try_start_a
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget v2, v2, Lcom/google/android/gms/internal/cb;->e:I

    const/4 v7, -0x2

    if-eq v2, v7, :cond_6

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget v2, v2, Lcom/google/android/gms/internal/cb;->e:I

    const/4 v7, -0x3

    if-eq v2, v7, :cond_6

    new-instance v2, Lcom/google/android/gms/internal/dd;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "There was a problem getting an ad response. ErrorCode: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget v5, v5, Lcom/google/android/gms/internal/cb;->e:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget v5, v5, Lcom/google/android/gms/internal/cb;->e:I

    invoke-direct {v2, v4, v5}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v2
    :try_end_a
    .catch Lcom/google/android/gms/internal/dd; {:try_start_a .. :try_end_a} :catch_0
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    :catchall_2
    move-exception v2

    :try_start_b
    monitor-exit v7
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    :try_start_c
    throw v2

    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget v2, v2, Lcom/google/android/gms/internal/cb;->e:I

    const/4 v7, -0x3

    if-eq v2, v7, :cond_8

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v2, v2, Lcom/google/android/gms/internal/cb;->c:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_7

    new-instance v2, Lcom/google/android/gms/internal/dd;

    const-string v4, "No fill from ad server."

    const/4 v5, 0x3

    invoke-direct {v2, v4, v5}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v2

    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-boolean v2, v2, Lcom/google/android/gms/internal/cb;->h:Z
    :try_end_c
    .catch Lcom/google/android/gms/internal/dd; {:try_start_c .. :try_end_c} :catch_0
    .catchall {:try_start_c .. :try_end_c} :catchall_1

    if-eqz v2, :cond_8

    :try_start_d
    new-instance v2, Lcom/google/android/gms/internal/ao;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v7, v7, Lcom/google/android/gms/internal/cb;->c:Ljava/lang/String;

    invoke-direct {v2, v7}, Lcom/google/android/gms/internal/ao;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/google/android/gms/internal/cz;->o:Lcom/google/android/gms/internal/ao;
    :try_end_d
    .catch Lorg/json/JSONException; {:try_start_d .. :try_end_d} :catch_1
    .catch Lcom/google/android/gms/internal/dd; {:try_start_d .. :try_end_d} :catch_0
    .catchall {:try_start_d .. :try_end_d} :catchall_1

    :cond_8
    :try_start_e
    iget-object v2, v12, Lcom/google/android/gms/internal/bz;->d:Lcom/google/android/gms/internal/x;

    iget-object v2, v2, Lcom/google/android/gms/internal/x;->h:[Lcom/google/android/gms/internal/x;

    if-eqz v2, :cond_9

    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lcom/google/android/gms/internal/cz;->a(Lcom/google/android/gms/internal/bz;)Lcom/google/android/gms/internal/x;

    move-result-object v3

    :cond_9
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-boolean v2, v2, Lcom/google/android/gms/internal/cb;->h:Z

    if-eqz v2, :cond_a

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/google/android/gms/internal/cz;->h:Ljava/lang/Object;

    monitor-enter v7
    :try_end_e
    .catch Lcom/google/android/gms/internal/dd; {:try_start_e .. :try_end_e} :catch_0
    .catchall {:try_start_e .. :try_end_e} :catchall_1

    :try_start_f
    new-instance v2, Lcom/google/android/gms/internal/al;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/google/android/gms/internal/cz;->i:Landroid/content/Context;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/google/android/gms/internal/cz;->g:Lcom/google/android/gms/internal/bn;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/google/android/gms/internal/cz;->o:Lcom/google/android/gms/internal/ao;

    invoke-direct {v2, v8, v12, v9, v10}, Lcom/google/android/gms/internal/al;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/bz;Lcom/google/android/gms/internal/bn;Lcom/google/android/gms/internal/ao;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/google/android/gms/internal/cz;->n:Lcom/google/android/gms/internal/al;

    monitor-exit v7
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_3

    :try_start_10
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->n:Lcom/google/android/gms/internal/al;

    invoke-virtual {v2, v4, v5}, Lcom/google/android/gms/internal/al;->a(J)Lcom/google/android/gms/internal/at;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    iget v2, v2, Lcom/google/android/gms/internal/at;->a:I

    packed-switch v2, :pswitch_data_0

    new-instance v2, Lcom/google/android/gms/internal/dd;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Unexpected mediation result: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/google/android/gms/internal/cz;->p:Lcom/google/android/gms/internal/at;

    iget v5, v5, Lcom/google/android/gms/internal/at;->a:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-direct {v2, v4, v5}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v2

    :catch_1
    move-exception v2

    new-instance v2, Lcom/google/android/gms/internal/dd;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Could not parse mediation config: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v5, v5, Lcom/google/android/gms/internal/cb;->c:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-direct {v2, v4, v5}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v2
    :try_end_10
    .catch Lcom/google/android/gms/internal/dd; {:try_start_10 .. :try_end_10} :catch_0
    .catchall {:try_start_10 .. :try_end_10} :catchall_1

    :catchall_3
    move-exception v2

    :try_start_11
    monitor-exit v7
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_3

    :try_start_12
    throw v2

    :pswitch_0
    move-object/from16 v21, v3

    goto/16 :goto_2

    :pswitch_1
    new-instance v2, Lcom/google/android/gms/internal/dd;

    const-string v4, "No fill from any mediation ad networks."

    const/4 v5, 0x3

    invoke-direct {v2, v4, v5}, Lcom/google/android/gms/internal/dd;-><init>(Ljava/lang/String;I)V

    throw v2

    :cond_a
    sget-object v2, Lcom/google/android/gms/internal/er;->a:Landroid/os/Handler;

    new-instance v7, Lcom/google/android/gms/internal/dc;

    move-object/from16 v0, p0

    invoke-direct {v7, v0}, Lcom/google/android/gms/internal/dc;-><init>(Lcom/google/android/gms/internal/cz;)V

    invoke-virtual {v2, v7}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v5}, Lcom/google/android/gms/internal/cz;->a(J)V
    :try_end_12
    .catch Lcom/google/android/gms/internal/dd; {:try_start_12 .. :try_end_12} :catch_0
    .catchall {:try_start_12 .. :try_end_12} :catchall_1

    move-object/from16 v21, v3

    goto/16 :goto_2

    :cond_b
    :try_start_13
    invoke-virtual {v2}, Lcom/google/android/gms/internal/dd;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_1

    goto/16 :goto_1

    :cond_c
    const/4 v14, 0x0

    goto/16 :goto_3

    :cond_d
    const/4 v15, 0x0

    goto/16 :goto_4

    :cond_e
    const/16 v16, 0x0

    goto/16 :goto_5

    :cond_f
    const/16 v18, 0x0

    goto/16 :goto_6

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final a(Lcom/google/android/gms/internal/cb;)V
    .locals 2

    iget-object v1, p0, Lcom/google/android/gms/internal/cz;->c:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    const-string v0, "Received ad response."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    iput-object p1, p0, Lcom/google/android/gms/internal/cz;->d:Lcom/google/android/gms/internal/cb;

    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->c:Ljava/lang/Object;

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

.method public final a(Lcom/google/android/gms/internal/ew;)V
    .locals 2

    iget-object v1, p0, Lcom/google/android/gms/internal/cz;->c:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    const-string v0, "WebView finished loading."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gms/internal/cz;->m:Z

    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->c:Ljava/lang/Object;

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

.method public final b_()V
    .locals 6

    iget-object v1, p0, Lcom/google/android/gms/internal/cz;->h:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->l:Lcom/google/android/gms/internal/ee;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->l:Lcom/google/android/gms/internal/ee;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ee;->e()V

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->b:Lcom/google/android/gms/internal/ew;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ew;->stopLoading()V

    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->b:Lcom/google/android/gms/internal/ew;

    invoke-static {v0}, Lcom/google/android/gms/internal/ej;->a(Landroid/webkit/WebView;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->n:Lcom/google/android/gms/internal/al;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/google/android/gms/internal/cz;->n:Lcom/google/android/gms/internal/al;

    iget-object v2, v0, Lcom/google/android/gms/internal/al;->a:Ljava/lang/Object;

    monitor-enter v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    const/4 v3, 0x1

    :try_start_1
    iput-boolean v3, v0, Lcom/google/android/gms/internal/al;->b:Z

    iget-object v3, v0, Lcom/google/android/gms/internal/al;->c:Lcom/google/android/gms/internal/ar;

    if-eqz v3, :cond_2

    iget-object v3, v0, Lcom/google/android/gms/internal/al;->c:Lcom/google/android/gms/internal/ar;

    iget-object v4, v3, Lcom/google/android/gms/internal/ar;->e:Ljava/lang/Object;

    monitor-enter v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :try_start_2
    iget-object v0, v3, Lcom/google/android/gms/internal/ar;->g:Lcom/google/android/gms/internal/bq;

    if-eqz v0, :cond_1

    iget-object v0, v3, Lcom/google/android/gms/internal/ar;->g:Lcom/google/android/gms/internal/bq;

    invoke-interface {v0}, Lcom/google/android/gms/internal/bq;->c()V
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :cond_1
    :goto_0
    const/4 v0, -0x1

    :try_start_3
    iput v0, v3, Lcom/google/android/gms/internal/ar;->h:I

    iget-object v0, v3, Lcom/google/android/gms/internal/ar;->e:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :cond_2
    :try_start_4
    monitor-exit v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    :cond_3
    :try_start_5
    monitor-exit v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    return-void

    :catch_0
    move-exception v0

    :try_start_6
    const-string v5, "Could not destroy mediation adapter."

    invoke-static {v5, v0}, Lcom/google/android/gms/internal/et;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v4
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    :try_start_7
    throw v0

    :catchall_1
    move-exception v0

    monitor-exit v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    :try_start_8
    throw v0

    :catchall_2
    move-exception v0

    monitor-exit v1
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    throw v0
.end method
