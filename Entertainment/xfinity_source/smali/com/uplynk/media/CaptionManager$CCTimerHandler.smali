.class public Lcom/uplynk/media/CaptionManager$CCTimerHandler;
.super Landroid/os/Handler;
.source "CaptionManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "CCTimerHandler"
.end annotation


# instance fields
.field private _channel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

.field final synthetic this$0:Lcom/uplynk/media/CaptionManager;


# direct methods
.method public constructor <init>(Lcom/uplynk/media/CaptionManager;Lcom/uplynk/media/CaptionManager$CaptionChannel;Landroid/os/Looper;)V
    .locals 0
    .param p2, "channel"    # Lcom/uplynk/media/CaptionManager$CaptionChannel;
    .param p3, "looper"    # Landroid/os/Looper;

    .prologue
    .line 862
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->this$0:Lcom/uplynk/media/CaptionManager;

    .line 863
    invoke-direct {p0, p3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 864
    iput-object p2, p0, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->_channel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    .line 865
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 8
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v7, 0x1

    .line 870
    iget v3, p1, Landroid/os/Message;->what:I

    if-ne v3, v7, :cond_0

    .line 872
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->_channel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    # getter for: Lcom/uplynk/media/CaptionManager$CaptionChannel;->_runTimer:Z
    invoke-static {v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->access$0(Lcom/uplynk/media/CaptionManager$CaptionChannel;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 898
    :cond_0
    :goto_0
    return-void

    .line 877
    :cond_1
    iget-object v4, p0, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->_channel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    monitor-enter v4

    .line 879
    :try_start_0
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->_channel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget-object v3, v3, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queue:Ljava/util/LinkedList;

    invoke-virtual {v3}, Ljava/util/LinkedList;->size()I

    move-result v3

    if-lez v3, :cond_2

    .line 881
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->_channel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    iget-object v3, v3, Lcom/uplynk/media/CaptionManager$CaptionChannel;->queue:Ljava/util/LinkedList;

    invoke-virtual {v3}, Ljava/util/LinkedList;->removeFirst()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;

    .line 883
    .local v1, "item":Lcom/uplynk/media/CaptionManager$CaptionQueueItem;
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->_channel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    # getter for: Lcom/uplynk/media/CaptionManager$CaptionChannel;->_mgr:Ljava/lang/ref/WeakReference;
    invoke-static {v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->access$1(Lcom/uplynk/media/CaptionManager$CaptionChannel;)Ljava/lang/ref/WeakReference;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v3}, Lcom/uplynk/media/CaptionManager;->getEventHandler()Lcom/uplynk/media/CaptionManager$CCEventHandler;

    move-result-object v0

    .line 885
    .local v0, "eh":Lcom/uplynk/media/CaptionManager$CCEventHandler;
    if-eqz v0, :cond_2

    .line 887
    const/4 v3, 0x2

    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->_channel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    # getter for: Lcom/uplynk/media/CaptionManager$CaptionChannel;->_index:I
    invoke-static {v5}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->access$2(Lcom/uplynk/media/CaptionManager$CaptionChannel;)I

    move-result v5

    const/4 v6, 0x0

    invoke-virtual {v0, v3, v5, v6, v1}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    .line 888
    .local v2, "m":Landroid/os/Message;
    invoke-virtual {v0, v2}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->sendMessage(Landroid/os/Message;)Z

    .line 877
    .end local v0    # "eh":Lcom/uplynk/media/CaptionManager$CCEventHandler;
    .end local v1    # "item":Lcom/uplynk/media/CaptionManager$CaptionQueueItem;
    .end local v2    # "m":Landroid/os/Message;
    :cond_2
    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 893
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->_channel:Lcom/uplynk/media/CaptionManager$CaptionChannel;

    # getter for: Lcom/uplynk/media/CaptionManager$CaptionChannel;->_runTimer:Z
    invoke-static {v3}, Lcom/uplynk/media/CaptionManager$CaptionChannel;->access$0(Lcom/uplynk/media/CaptionManager$CaptionChannel;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 895
    const-wide/16 v4, 0x1e

    invoke-virtual {p0, v7, v4, v5}, Lcom/uplynk/media/CaptionManager$CCTimerHandler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0

    .line 877
    :catchall_0
    move-exception v3

    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v3
.end method
