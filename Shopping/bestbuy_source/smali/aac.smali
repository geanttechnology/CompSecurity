.class public Laac;
.super Labn;

# interfaces
.implements Lacf;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lwd;

.field private final b:Laab;

.field private final c:Lcom/google/android/gms/internal/gu;

.field private final d:Ljava/lang/Object;

.field private final e:Landroid/content/Context;

.field private final f:Ljava/lang/Object;

.field private final g:Labe;

.field private h:Lcom/google/android/gms/internal/fj;

.field private i:Z

.field private j:Lvt;

.field private k:Lvv;

.field private l:Lvz;


# direct methods
.method public constructor <init>(Landroid/content/Context;Labe;Lcom/google/android/gms/internal/gu;Lwd;Laab;)V
    .locals 1

    invoke-direct {p0}, Labn;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Laac;->d:Ljava/lang/Object;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Laac;->f:Ljava/lang/Object;

    const/4 v0, 0x0

    iput-boolean v0, p0, Laac;->i:Z

    iput-object p1, p0, Laac;->e:Landroid/content/Context;

    iput-object p2, p0, Laac;->g:Labe;

    iget-object v0, p2, Labe;->b:Lcom/google/android/gms/internal/fj;

    iput-object v0, p0, Laac;->h:Lcom/google/android/gms/internal/fj;

    iput-object p3, p0, Laac;->c:Lcom/google/android/gms/internal/gu;

    iput-object p4, p0, Laac;->a:Lwd;

    iput-object p5, p0, Laac;->b:Laab;

    iget-object v0, p2, Labe;->c:Lvv;

    iput-object v0, p0, Laac;->k:Lvv;

    return-void
.end method

.method static synthetic a(Laac;)Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Laac;->f:Ljava/lang/Object;

    return-object v0
.end method

.method private a(Lcom/google/android/gms/internal/fh;J)V
    .locals 6

    iget-object v1, p0, Laac;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    new-instance v0, Lvt;

    iget-object v2, p0, Laac;->e:Landroid/content/Context;

    iget-object v3, p0, Laac;->a:Lwd;

    iget-object v4, p0, Laac;->k:Lvv;

    invoke-direct {v0, v2, p1, v3, v4}, Lvt;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Lwd;Lvv;)V

    iput-object v0, p0, Laac;->j:Lvt;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Laac;->j:Lvt;

    const-wide/32 v2, 0xea60

    invoke-virtual {v0, p2, p3, v2, v3}, Lvt;->a(JJ)Lvz;

    move-result-object v0

    iput-object v0, p0, Laac;->l:Lvz;

    iget-object v0, p0, Laac;->l:Lvz;

    iget v0, v0, Lvz;->a:I

    packed-switch v0, :pswitch_data_0

    new-instance v0, Laad;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected mediation result: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Laac;->l:Lvz;

    iget v2, v2, Lvz;->a:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Laad;-><init>(Ljava/lang/String;I)V

    throw v0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :pswitch_0
    new-instance v0, Laad;

    const-string v1, "No fill from any mediation ad networks."

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2}, Laad;-><init>(Ljava/lang/String;I)V

    throw v0

    :pswitch_1
    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method static synthetic b(Laac;)Laab;
    .locals 1

    iget-object v0, p0, Laac;->b:Laab;

    return-object v0
.end method

.method private b(J)V
    .locals 3

    sget-object v0, Laca;->a:Landroid/os/Handler;

    new-instance v1, Laac$3;

    invoke-direct {v1, p0}, Laac$3;-><init>(Laac;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    invoke-direct {p0, p1, p2}, Laac;->c(J)V

    return-void
.end method

.method static synthetic c(Laac;)Lcom/google/android/gms/internal/fj;
    .locals 1

    iget-object v0, p0, Laac;->h:Lcom/google/android/gms/internal/fj;

    return-object v0
.end method

.method private c(J)V
    .locals 3

    :cond_0
    invoke-direct {p0, p1, p2}, Laac;->d(J)Z

    move-result v0

    if-nez v0, :cond_1

    new-instance v0, Laad;

    const-string v1, "Timed out waiting for WebView to finish loading."

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Laad;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_1
    iget-boolean v0, p0, Laac;->i:Z

    if-eqz v0, :cond_0

    return-void
.end method

.method static synthetic d(Laac;)Lcom/google/android/gms/internal/gu;
    .locals 1

    iget-object v0, p0, Laac;->c:Lcom/google/android/gms/internal/gu;

    return-object v0
.end method

.method private d(J)Z
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
    iget-object v2, p0, Laac;->f:Ljava/lang/Object;

    invoke-virtual {v2, v0, v1}, Ljava/lang/Object;->wait(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v0, Laad;

    const-string v1, "Ad request cancelled."

    const/4 v2, -0x1

    invoke-direct {v0, v1, v2}, Laad;-><init>(Ljava/lang/String;I)V

    throw v0
.end method


# virtual methods
.method public a()V
    .locals 32

    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->f:Ljava/lang/Object;

    move-object/from16 v31, v0

    monitor-enter v31

    :try_start_0
    const-string v2, "AdRendererBackgroundTask started."

    invoke-static {v2}, Lacb;->a(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Laac;->g:Labe;

    iget-object v12, v2, Labe;->a:Lcom/google/android/gms/internal/fh;

    move-object/from16 v0, p0

    iget-object v2, v0, Laac;->g:Labe;

    iget v6, v2, Labe;->e:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    move-object/from16 v0, p0

    iget-object v4, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    iget-boolean v4, v4, Lcom/google/android/gms/internal/fj;->h:Z

    if-eqz v4, :cond_0

    move-object/from16 v0, p0

    invoke-direct {v0, v12, v2, v3}, Laac;->a(Lcom/google/android/gms/internal/fh;J)V
    :try_end_1
    .catch Laad; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :goto_0
    :try_start_2
    new-instance v2, Labd;

    iget-object v3, v12, Lcom/google/android/gms/internal/fh;->c:Lcom/google/android/gms/internal/av;

    move-object/from16 v0, p0

    iget-object v4, v0, Laac;->c:Lcom/google/android/gms/internal/gu;

    move-object/from16 v0, p0

    iget-object v5, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    iget-object v5, v5, Lcom/google/android/gms/internal/fj;->d:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v7, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    iget-object v7, v7, Lcom/google/android/gms/internal/fj;->f:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v8, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    iget-object v8, v8, Lcom/google/android/gms/internal/fj;->j:Ljava/util/List;

    move-object/from16 v0, p0

    iget-object v9, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    iget v9, v9, Lcom/google/android/gms/internal/fj;->l:I

    move-object/from16 v0, p0

    iget-object v10, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    iget-wide v10, v10, Lcom/google/android/gms/internal/fj;->k:J

    iget-object v12, v12, Lcom/google/android/gms/internal/fh;->i:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v13, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    iget-boolean v13, v13, Lcom/google/android/gms/internal/fj;->h:Z

    move-object/from16 v0, p0

    iget-object v14, v0, Laac;->l:Lvz;

    if-eqz v14, :cond_5

    move-object/from16 v0, p0

    iget-object v14, v0, Laac;->l:Lvz;

    iget-object v14, v14, Lvz;->b:Lvu;

    :goto_1
    move-object/from16 v0, p0

    iget-object v15, v0, Laac;->l:Lvz;

    if-eqz v15, :cond_6

    move-object/from16 v0, p0

    iget-object v15, v0, Laac;->l:Lvz;

    iget-object v15, v15, Lvz;->c:Lwg;

    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->l:Lvz;

    move-object/from16 v16, v0

    if-eqz v16, :cond_7

    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->l:Lvz;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lvz;->d:Ljava/lang/String;

    move-object/from16 v16, v0

    :goto_3
    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->k:Lvv;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->l:Lvz;

    move-object/from16 v18, v0

    if-eqz v18, :cond_8

    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->l:Lvz;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Lvz;->e:Lvx;

    move-object/from16 v18, v0

    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget-wide v0, v0, Lcom/google/android/gms/internal/fj;->i:J

    move-wide/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->g:Labe;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Labe;->d:Lcom/google/android/gms/internal/ay;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-wide v0, v0, Lcom/google/android/gms/internal/fj;->g:J

    move-wide/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->g:Labe;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    iget-wide v0, v0, Labe;->f:J

    move-wide/from16 v24, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    iget-wide v0, v0, Lcom/google/android/gms/internal/fj;->n:J

    move-wide/from16 v26, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    iget-object v0, v0, Lcom/google/android/gms/internal/fj;->o:Ljava/lang/String;

    move-object/from16 v28, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Laac;->g:Labe;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    iget-object v0, v0, Labe;->h:Lorg/json/JSONObject;

    move-object/from16 v29, v0

    const/16 v30, 0x0

    invoke-direct/range {v2 .. v30}, Labd;-><init>(Lcom/google/android/gms/internal/av;Lcom/google/android/gms/internal/gu;Ljava/util/List;ILjava/util/List;Ljava/util/List;IJLjava/lang/String;ZLvu;Lwg;Ljava/lang/String;Lvv;Lvx;JLcom/google/android/gms/internal/ay;JJJLjava/lang/String;Lorg/json/JSONObject;Lut;)V

    sget-object v3, Laca;->a:Landroid/os/Handler;

    new-instance v4, Laac$2;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v2}, Laac$2;-><init>(Laac;Labd;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    monitor-exit v31
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    return-void

    :cond_0
    :try_start_3
    move-object/from16 v0, p0

    iget-object v4, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    iget-boolean v4, v4, Lcom/google/android/gms/internal/fj;->p:Z

    if-eqz v4, :cond_2

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v3}, Laac;->a(J)V
    :try_end_3
    .catch Laad; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_0

    :catch_0
    move-exception v2

    :try_start_4
    invoke-virtual {v2}, Laad;->a()I

    move-result v6

    const/4 v3, 0x3

    if-eq v6, v3, :cond_1

    const/4 v3, -0x1

    if-ne v6, v3, :cond_3

    :cond_1
    invoke-virtual {v2}, Laad;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lacb;->c(Ljava/lang/String;)V

    :goto_5
    move-object/from16 v0, p0

    iget-object v2, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    if-nez v2, :cond_4

    new-instance v2, Lcom/google/android/gms/internal/fj;

    invoke-direct {v2, v6}, Lcom/google/android/gms/internal/fj;-><init>(I)V

    move-object/from16 v0, p0

    iput-object v2, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    :goto_6
    sget-object v2, Laca;->a:Landroid/os/Handler;

    new-instance v3, Laac$1;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Laac$1;-><init>(Laac;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto/16 :goto_0

    :catchall_0
    move-exception v2

    monitor-exit v31
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v2

    :cond_2
    :try_start_5
    move-object/from16 v0, p0

    invoke-direct {v0, v2, v3}, Laac;->b(J)V
    :try_end_5
    .catch Laad; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_0

    :cond_3
    :try_start_6
    invoke-virtual {v2}, Laad;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_5

    :cond_4
    new-instance v2, Lcom/google/android/gms/internal/fj;

    move-object/from16 v0, p0

    iget-object v3, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    iget-wide v4, v3, Lcom/google/android/gms/internal/fj;->k:J

    invoke-direct {v2, v6, v4, v5}, Lcom/google/android/gms/internal/fj;-><init>(IJ)V

    move-object/from16 v0, p0

    iput-object v2, v0, Laac;->h:Lcom/google/android/gms/internal/fj;

    goto :goto_6

    :cond_5
    const/4 v14, 0x0

    goto/16 :goto_1

    :cond_6
    const/4 v15, 0x0

    goto/16 :goto_2

    :cond_7
    const-class v16, Loi;

    invoke-virtual/range {v16 .. v16}, Ljava/lang/Class;->getName()Ljava/lang/String;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-result-object v16

    goto/16 :goto_3

    :cond_8
    const/16 v18, 0x0

    goto/16 :goto_4
.end method

.method protected a(J)V
    .locals 5

    iget-object v0, p0, Laac;->c:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->e()Lcom/google/android/gms/internal/ay;

    move-result-object v0

    iget-boolean v1, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-eqz v1, :cond_0

    iget-object v0, p0, Laac;->e:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v1, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget-object v0, p0, Laac;->e:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    :goto_0
    new-instance v2, Lzy;

    iget-object v3, p0, Laac;->c:Lcom/google/android/gms/internal/gu;

    invoke-direct {v2, p0, v3, v1, v0}, Lzy;-><init>(Lacf;Lcom/google/android/gms/internal/gu;II)V

    sget-object v0, Laca;->a:Landroid/os/Handler;

    new-instance v1, Laac$4;

    invoke-direct {v1, p0, v2}, Laac$4;-><init>(Laac;Lzy;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    invoke-direct {p0, p1, p2}, Laac;->c(J)V

    invoke-virtual {v2}, Lzy;->c()Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "Ad-Network indicated no fill with passback URL."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    new-instance v0, Laad;

    const-string v1, "AdNetwork sent passback url"

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2}, Laad;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_0
    iget v1, v0, Lcom/google/android/gms/internal/ay;->g:I

    iget v0, v0, Lcom/google/android/gms/internal/ay;->d:I

    goto :goto_0

    :cond_1
    invoke-virtual {v2}, Lzy;->d()Z

    move-result v0

    if-nez v0, :cond_2

    new-instance v0, Laad;

    const-string v1, "AdNetwork timed out"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Laad;-><init>(Ljava/lang/String;I)V

    throw v0

    :cond_2
    return-void
.end method

.method public a(Lcom/google/android/gms/internal/gu;)V
    .locals 2

    iget-object v1, p0, Laac;->f:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    const-string v0, "WebView finished loading."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Laac;->i:Z

    iget-object v0, p0, Laac;->f:Ljava/lang/Object;

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

    iget-object v1, p0, Laac;->d:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Laac;->c:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->stopLoading()V

    iget-object v0, p0, Laac;->c:Lcom/google/android/gms/internal/gu;

    invoke-static {v0}, Labq;->a(Landroid/webkit/WebView;)V

    iget-object v0, p0, Laac;->j:Lvt;

    if-eqz v0, :cond_0

    iget-object v0, p0, Laac;->j:Lvt;

    invoke-virtual {v0}, Lvt;->a()V

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
