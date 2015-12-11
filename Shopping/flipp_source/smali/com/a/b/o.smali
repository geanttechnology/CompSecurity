.class final Lcom/a/b/o;
.super Landroid/os/Handler;
.source "SourceFile"


# instance fields
.field private final a:Lcom/a/b/n;


# direct methods
.method public constructor <init>(Landroid/os/Looper;Lcom/a/b/n;)V
    .locals 0

    .prologue
    .line 215
    invoke-direct {p0, p1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 216
    iput-object p2, p0, Lcom/a/b/o;->a:Lcom/a/b/n;

    .line 217
    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 7

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x3

    const/4 v2, 0x1

    .line 220
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 260
    :pswitch_0
    sget-object v0, Lcom/a/b/ad;->a:Landroid/os/Handler;

    new-instance v1, Lcom/a/b/p;

    invoke-direct {v1, p0, p1}, Lcom/a/b/p;-><init>(Lcom/a/b/o;Landroid/os/Message;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 266
    :cond_0
    :goto_0
    return-void

    .line 222
    :pswitch_1
    iget-object v5, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v5, Lcom/a/b/a;

    .line 223
    iget-object v2, p0, Lcom/a/b/o;->a:Lcom/a/b/n;

    iget-object v0, v2, Lcom/a/b/n;->e:Ljava/util/Map;

    iget-object v1, v5, Lcom/a/b/a;->h:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/b/d;

    if-eqz v0, :cond_1

    invoke-virtual {v0, v5}, Lcom/a/b/d;->a(Lcom/a/b/a;)V

    goto :goto_0

    :cond_1
    iget-object v0, v2, Lcom/a/b/n;->c:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->isShutdown()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, v2, Lcom/a/b/n;->b:Landroid/content/Context;

    iget-object v1, v5, Lcom/a/b/a;->a:Lcom/a/b/ad;

    iget-object v3, v2, Lcom/a/b/n;->h:Lcom/a/b/h;

    iget-object v4, v2, Lcom/a/b/n;->i:Lcom/a/b/as;

    iget-object v6, v2, Lcom/a/b/n;->d:Lcom/a/b/s;

    invoke-static/range {v0 .. v6}, Lcom/a/b/d;->a(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;Lcom/a/b/s;)Lcom/a/b/d;

    move-result-object v0

    iget-object v1, v2, Lcom/a/b/n;->c:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v1, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    move-result-object v1

    iput-object v1, v0, Lcom/a/b/d;->k:Ljava/util/concurrent/Future;

    iget-object v1, v2, Lcom/a/b/n;->e:Ljava/util/Map;

    iget-object v2, v5, Lcom/a/b/a;->h:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 227
    :pswitch_2
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/a/b/a;

    .line 228
    iget-object v4, p0, Lcom/a/b/o;->a:Lcom/a/b/n;

    iget-object v5, v0, Lcom/a/b/a;->h:Ljava/lang/String;

    iget-object v1, v4, Lcom/a/b/n;->e:Ljava/util/Map;

    invoke-interface {v1, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/a/b/d;

    if-eqz v1, :cond_0

    iget-object v6, v1, Lcom/a/b/d;->h:Ljava/util/List;

    invoke-interface {v6, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    iget-object v0, v1, Lcom/a/b/d;->h:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, v1, Lcom/a/b/d;->k:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_2

    iget-object v0, v1, Lcom/a/b/d;->k:Ljava/util/concurrent/Future;

    invoke-interface {v0, v3}, Ljava/util/concurrent/Future;->cancel(Z)Z

    move-result v0

    if-eqz v0, :cond_2

    :goto_1
    if-eqz v2, :cond_0

    iget-object v0, v4, Lcom/a/b/n;->e:Ljava/util/Map;

    invoke-interface {v0, v5}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_2
    move v2, v3

    goto :goto_1

    .line 232
    :pswitch_3
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/a/b/d;

    .line 233
    iget-object v1, p0, Lcom/a/b/o;->a:Lcom/a/b/n;

    iget-boolean v2, v0, Lcom/a/b/d;->i:Z

    if-nez v2, :cond_3

    iget-object v2, v1, Lcom/a/b/n;->h:Lcom/a/b/h;

    iget-object v3, v0, Lcom/a/b/d;->f:Ljava/lang/String;

    iget-object v4, v0, Lcom/a/b/d;->j:Landroid/graphics/Bitmap;

    invoke-interface {v2, v3, v4}, Lcom/a/b/h;->a(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    :cond_3
    iget-object v2, v1, Lcom/a/b/n;->e:Ljava/util/Map;

    iget-object v3, v0, Lcom/a/b/d;->f:Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v1, v0}, Lcom/a/b/n;->c(Lcom/a/b/d;)V

    goto/16 :goto_0

    .line 237
    :pswitch_4
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/a/b/d;

    .line 238
    iget-object v1, p0, Lcom/a/b/o;->a:Lcom/a/b/n;

    invoke-virtual {v0}, Lcom/a/b/d;->b()Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, v1, Lcom/a/b/n;->c:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v2}, Ljava/util/concurrent/ExecutorService;->isShutdown()Z

    move-result v2

    if-nez v2, :cond_4

    iget-object v2, v1, Lcom/a/b/n;->l:Landroid/net/NetworkInfo;

    invoke-virtual {v0, v2}, Lcom/a/b/d;->a(Landroid/net/NetworkInfo;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget-object v1, v1, Lcom/a/b/n;->c:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v1, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    move-result-object v1

    iput-object v1, v0, Lcom/a/b/d;->k:Ljava/util/concurrent/Future;

    goto/16 :goto_0

    :cond_4
    invoke-virtual {v1, v0}, Lcom/a/b/n;->b(Lcom/a/b/d;)V

    goto/16 :goto_0

    .line 242
    :pswitch_5
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/a/b/d;

    .line 243
    iget-object v1, p0, Lcom/a/b/o;->a:Lcom/a/b/n;

    invoke-virtual {v1, v0}, Lcom/a/b/n;->b(Lcom/a/b/d;)V

    goto/16 :goto_0

    .line 247
    :pswitch_6
    iget-object v0, p0, Lcom/a/b/o;->a:Lcom/a/b/n;

    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, v0, Lcom/a/b/n;->j:Ljava/util/List;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iget-object v2, v0, Lcom/a/b/n;->j:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V

    iget-object v2, v0, Lcom/a/b/n;->g:Landroid/os/Handler;

    iget-object v0, v0, Lcom/a/b/n;->g:Landroid/os/Handler;

    const/16 v3, 0x8

    invoke-virtual {v0, v3, v1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_0

    .line 251
    :pswitch_7
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/net/NetworkInfo;

    .line 252
    iget-object v1, p0, Lcom/a/b/o;->a:Lcom/a/b/n;

    iput-object v0, v1, Lcom/a/b/n;->l:Landroid/net/NetworkInfo;

    iget-object v3, v1, Lcom/a/b/n;->c:Ljava/util/concurrent/ExecutorService;

    instance-of v3, v3, Lcom/a/b/an;

    if-eqz v3, :cond_0

    iget-object v1, v1, Lcom/a/b/n;->c:Ljava/util/concurrent/ExecutorService;

    check-cast v1, Lcom/a/b/an;

    if-eqz v0, :cond_5

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v3

    if-nez v3, :cond_6

    :cond_5
    invoke-virtual {v1, v4}, Lcom/a/b/an;->a(I)V

    goto/16 :goto_0

    :cond_6
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v3

    sparse-switch v3, :sswitch_data_0

    invoke-virtual {v1, v4}, Lcom/a/b/an;->a(I)V

    goto/16 :goto_0

    :sswitch_0
    const/4 v0, 0x4

    invoke-virtual {v1, v0}, Lcom/a/b/an;->a(I)V

    goto/16 :goto_0

    :sswitch_1
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v0

    packed-switch v0, :pswitch_data_1

    :pswitch_8
    invoke-virtual {v1, v4}, Lcom/a/b/an;->a(I)V

    goto/16 :goto_0

    :pswitch_9
    invoke-virtual {v1, v4}, Lcom/a/b/an;->a(I)V

    goto/16 :goto_0

    :pswitch_a
    const/4 v0, 0x2

    invoke-virtual {v1, v0}, Lcom/a/b/an;->a(I)V

    goto/16 :goto_0

    :pswitch_b
    invoke-virtual {v1, v2}, Lcom/a/b/an;->a(I)V

    goto/16 :goto_0

    .line 256
    :pswitch_c
    iget-object v1, p0, Lcom/a/b/o;->a:Lcom/a/b/n;

    iget v0, p1, Landroid/os/Message;->arg1:I

    if-ne v0, v2, :cond_7

    move v0, v2

    :goto_2
    iput-boolean v0, v1, Lcom/a/b/n;->m:Z

    goto/16 :goto_0

    :cond_7
    move v0, v3

    goto :goto_2

    .line 220
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_0
        :pswitch_7
        :pswitch_c
    .end packed-switch

    .line 252
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_1
        0x1 -> :sswitch_0
        0x6 -> :sswitch_0
        0x9 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_b
        :pswitch_b
        :pswitch_a
        :pswitch_a
        :pswitch_a
        :pswitch_a
        :pswitch_8
        :pswitch_8
        :pswitch_8
        :pswitch_8
        :pswitch_8
        :pswitch_a
        :pswitch_9
        :pswitch_9
        :pswitch_9
    .end packed-switch
.end method
