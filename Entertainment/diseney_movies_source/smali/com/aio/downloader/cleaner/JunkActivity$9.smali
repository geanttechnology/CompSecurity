.class Lcom/aio/downloader/cleaner/JunkActivity$9;
.super Ljava/lang/Thread;
.source "JunkActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/JunkActivity;->initCache()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/JunkActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/JunkActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity$9;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    .line 488
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 492
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 493
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$9;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/JunkActivity$9;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->rubmamager:Lcom/wjj/manager/RubSoftwareManager;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$62(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/RubSoftwareManager;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/cleaner/JunkActivity$9;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cachelistener:Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$63(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/wjj/manager/RubSoftwareManager;->getApplicationInfo(Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;)Ljava/util/List;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$14(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/util/List;)V

    .line 494
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$9;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .line 495
    .local v0, "msg":Landroid/os/Message;
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$9;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->cachelist:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$16(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 496
    const/4 v1, 0x3

    iput v1, v0, Landroid/os/Message;->what:I

    .line 497
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$9;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 499
    return-void
.end method
