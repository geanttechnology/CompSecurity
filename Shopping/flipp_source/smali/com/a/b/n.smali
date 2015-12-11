.class final Lcom/a/b/n;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Lcom/a/b/q;

.field final b:Landroid/content/Context;

.field final c:Ljava/util/concurrent/ExecutorService;

.field final d:Lcom/a/b/s;

.field final e:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/a/b/d;",
            ">;"
        }
    .end annotation
.end field

.field final f:Landroid/os/Handler;

.field final g:Landroid/os/Handler;

.field final h:Lcom/a/b/h;

.field final i:Lcom/a/b/as;

.field final j:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/a/b/d;",
            ">;"
        }
    .end annotation
.end field

.field final k:Lcom/a/b/r;

.field l:Landroid/net/NetworkInfo;

.field m:Z


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/util/concurrent/ExecutorService;Landroid/os/Handler;Lcom/a/b/s;Lcom/a/b/h;Lcom/a/b/as;)V
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    new-instance v0, Lcom/a/b/q;

    invoke-direct {v0}, Lcom/a/b/q;-><init>()V

    iput-object v0, p0, Lcom/a/b/n;->a:Lcom/a/b/q;

    .line 79
    iget-object v0, p0, Lcom/a/b/n;->a:Lcom/a/b/q;

    invoke-virtual {v0}, Lcom/a/b/q;->start()V

    .line 80
    iput-object p1, p0, Lcom/a/b/n;->b:Landroid/content/Context;

    .line 81
    iput-object p2, p0, Lcom/a/b/n;->c:Ljava/util/concurrent/ExecutorService;

    .line 82
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/a/b/n;->e:Ljava/util/Map;

    .line 83
    new-instance v0, Lcom/a/b/o;

    iget-object v3, p0, Lcom/a/b/n;->a:Lcom/a/b/q;

    invoke-virtual {v3}, Lcom/a/b/q;->getLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v0, v3, p0}, Lcom/a/b/o;-><init>(Landroid/os/Looper;Lcom/a/b/n;)V

    iput-object v0, p0, Lcom/a/b/n;->f:Landroid/os/Handler;

    .line 84
    iput-object p4, p0, Lcom/a/b/n;->d:Lcom/a/b/s;

    .line 85
    iput-object p3, p0, Lcom/a/b/n;->g:Landroid/os/Handler;

    .line 86
    iput-object p5, p0, Lcom/a/b/n;->h:Lcom/a/b/h;

    .line 87
    iput-object p6, p0, Lcom/a/b/n;->i:Lcom/a/b/as;

    .line 88
    new-instance v0, Ljava/util/ArrayList;

    const/4 v3, 0x4

    invoke-direct {v0, v3}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/a/b/n;->j:Ljava/util/List;

    .line 89
    iget-object v0, p0, Lcom/a/b/n;->b:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v3, "airplane_mode_on"

    invoke-static {v0, v3, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lcom/a/b/n;->m:Z

    .line 90
    new-instance v0, Lcom/a/b/r;

    iget-object v3, p0, Lcom/a/b/n;->b:Landroid/content/Context;

    invoke-direct {v0, p0, v3}, Lcom/a/b/r;-><init>(Lcom/a/b/n;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/a/b/n;->k:Lcom/a/b/r;

    .line 91
    iget-object v3, p0, Lcom/a/b/n;->k:Lcom/a/b/r;

    iget-object v0, v3, Lcom/a/b/r;->a:Lcom/a/b/n;

    iget-object v0, v0, Lcom/a/b/n;->c:Ljava/util/concurrent/ExecutorService;

    instance-of v0, v0, Lcom/a/b/an;

    if-eqz v0, :cond_3

    iget-object v0, v3, Lcom/a/b/r;->a:Lcom/a/b/n;

    iget-object v0, v0, Lcom/a/b/n;->b:Landroid/content/Context;

    const-string v4, "android.permission.ACCESS_NETWORK_STATE"

    invoke-virtual {v0, v4}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_2

    move v0, v1

    :goto_1
    if-eqz v0, :cond_3

    :goto_2
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    const-string v2, "android.intent.action.AIRPLANE_MODE"

    invoke-virtual {v0, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    if-eqz v1, :cond_0

    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    :cond_0
    iget-object v1, v3, Lcom/a/b/r;->a:Lcom/a/b/n;

    iget-object v1, v1, Lcom/a/b/n;->b:Landroid/content/Context;

    invoke-virtual {v1, v3, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 92
    return-void

    :cond_1
    move v0, v2

    .line 89
    goto :goto_0

    :cond_2
    move v0, v2

    .line 91
    goto :goto_1

    :cond_3
    move v1, v2

    goto :goto_2
.end method


# virtual methods
.method final a(Lcom/a/b/d;)V
    .locals 3

    .prologue
    .line 117
    iget-object v0, p0, Lcom/a/b/n;->f:Landroid/os/Handler;

    iget-object v1, p0, Lcom/a/b/n;->f:Landroid/os/Handler;

    const/4 v2, 0x6

    invoke-virtual {v1, v2, p1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 118
    return-void
.end method

.method final b(Lcom/a/b/d;)V
    .locals 2

    .prologue
    .line 186
    iget-object v0, p0, Lcom/a/b/n;->e:Ljava/util/Map;

    iget-object v1, p1, Lcom/a/b/d;->f:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 187
    invoke-virtual {p0, p1}, Lcom/a/b/n;->c(Lcom/a/b/d;)V

    .line 188
    return-void
.end method

.method final c(Lcom/a/b/d;)V
    .locals 4

    .prologue
    const/4 v1, 0x7

    .line 202
    invoke-virtual {p1}, Lcom/a/b/d;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 209
    :cond_0
    :goto_0
    return-void

    .line 205
    :cond_1
    iget-object v0, p0, Lcom/a/b/n;->j:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 206
    iget-object v0, p0, Lcom/a/b/n;->f:Landroid/os/Handler;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 207
    iget-object v0, p0, Lcom/a/b/n;->f:Landroid/os/Handler;

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0
.end method
