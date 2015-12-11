.class Lcom/aio/downloader/cleaner/JunkActivity$8;
.super Ljava/lang/Thread;
.source "JunkActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/JunkActivity;->initBoostData()V
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
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity$8;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    .line 458
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 461
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 462
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$8;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/JunkActivity$8;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->runappmana:Lcom/wjj/manager/RuningAppManager;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$60(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/RuningAppManager;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/cleaner/JunkActivity$8;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->runlistener:Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;
    invoke-static {v3}, Lcom/aio/downloader/cleaner/JunkActivity;->access$61(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/wjj/manager/RuningAppManager;->getRuningUserApp(Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;)Ljava/util/List;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$0(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/util/List;)V

    .line 463
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$8;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .line 464
    .local v0, "msg":Landroid/os/Message;
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$8;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$47(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 465
    const/4 v1, 0x1

    iput v1, v0, Landroid/os/Message;->what:I

    .line 466
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$8;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 467
    return-void
.end method
