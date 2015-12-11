.class final Lcom/a/b/as;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Landroid/os/HandlerThread;

.field final b:Lcom/a/b/h;

.field final c:Landroid/os/Handler;

.field d:J

.field e:J

.field f:J

.field g:J

.field h:J

.field i:J

.field j:I

.field k:I


# direct methods
.method constructor <init>(Lcom/a/b/h;)V
    .locals 3

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p1, p0, Lcom/a/b/as;->b:Lcom/a/b/h;

    .line 49
    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "Picasso-Stats"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    iput-object v0, p0, Lcom/a/b/as;->a:Landroid/os/HandlerThread;

    .line 50
    iget-object v0, p0, Lcom/a/b/as;->a:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 51
    new-instance v0, Lcom/a/b/at;

    iget-object v1, p0, Lcom/a/b/as;->a:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Lcom/a/b/at;-><init>(Landroid/os/Looper;Lcom/a/b/as;)V

    iput-object v0, p0, Lcom/a/b/as;->c:Landroid/os/Handler;

    .line 52
    return-void
.end method


# virtual methods
.method final a()V
    .locals 2

    .prologue
    .line 63
    iget-object v0, p0, Lcom/a/b/as;->c:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 64
    return-void
.end method

.method final a(Landroid/graphics/Bitmap;I)V
    .locals 4

    .prologue
    .line 103
    invoke-static {p1}, Lcom/a/b/ba;->a(Landroid/graphics/Bitmap;)I

    move-result v0

    .line 104
    iget-object v1, p0, Lcom/a/b/as;->c:Landroid/os/Handler;

    iget-object v2, p0, Lcom/a/b/as;->c:Landroid/os/Handler;

    const/4 v3, 0x0

    invoke-virtual {v2, p2, v0, v3}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 105
    return-void
.end method

.method final declared-synchronized b()Lcom/a/b/av;
    .locals 22

    .prologue
    .line 95
    monitor-enter p0

    :try_start_0
    new-instance v3, Lcom/a/b/av;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/a/b/as;->b:Lcom/a/b/h;

    invoke-interface {v2}, Lcom/a/b/h;->b()I

    move-result v4

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/a/b/as;->b:Lcom/a/b/h;

    invoke-interface {v2}, Lcom/a/b/h;->a()I

    move-result v5

    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/a/b/as;->d:J

    move-object/from16 v0, p0

    iget-wide v8, v0, Lcom/a/b/as;->e:J

    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/a/b/as;->f:J

    move-object/from16 v0, p0

    iget-wide v12, v0, Lcom/a/b/as;->g:J

    move-object/from16 v0, p0

    iget-wide v14, v0, Lcom/a/b/as;->h:J

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/a/b/as;->i:J

    move-wide/from16 v16, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/a/b/as;->j:I

    move/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/a/b/as;->k:I

    move/from16 v19, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v20

    invoke-direct/range {v3 .. v21}, Lcom/a/b/av;-><init>(IIJJJJJJIIJ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v3

    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method
