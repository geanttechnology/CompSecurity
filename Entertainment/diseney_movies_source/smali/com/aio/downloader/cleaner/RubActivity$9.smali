.class Lcom/aio/downloader/cleaner/RubActivity$9;
.super Ljava/lang/Object;
.source "RubActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity;->initData()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/RubActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 757
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 11

    .prologue
    .line 760
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    new-instance v6, Lcom/aio/downloader/cleaner/TaskInfoProvider;

    iget-object v7, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-direct {v6, v7}, Lcom/aio/downloader/cleaner/TaskInfoProvider;-><init>(Landroid/content/Context;)V

    invoke-static {v5, v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$48(Lcom/aio/downloader/cleaner/RubActivity;Lcom/aio/downloader/cleaner/TaskInfoProvider;)V

    .line 761
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->taskInfoProvider:Lcom/aio/downloader/cleaner/TaskInfoProvider;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$49(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/cleaner/TaskInfoProvider;

    move-result-object v6

    iget-object v7, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->runningAppProcessInfos:Ljava/util/List;
    invoke-static {v7}, Lcom/aio/downloader/cleaner/RubActivity;->access$50(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/aio/downloader/cleaner/TaskInfoProvider;->getAllTask(Ljava/util/List;)Ljava/util/List;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$51(Lcom/aio/downloader/cleaner/RubActivity;Ljava/util/List;)V

    .line 763
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->taskInfos:Ljava/util/List;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/RubActivity;->access$19(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_0

    .line 766
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-wide v6, v6, Lcom/aio/downloader/cleaner/RubActivity;->total_show:J

    iput-wide v6, v5, Lcom/aio/downloader/cleaner/RubActivity;->total_wyc:J

    .line 768
    new-instance v0, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v0}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 770
    .local v0, "memoryInfo":Landroid/app/ActivityManager$MemoryInfo;
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->activityManager:Landroid/app/ActivityManager;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/RubActivity;->access$52(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/app/ActivityManager;

    move-result-object v5

    invoke-virtual {v5, v0}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 772
    iget-wide v2, v0, Landroid/app/ActivityManager$MemoryInfo;->availMem:J

    .line 774
    .local v2, "size":J
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-wide v6, v5, Lcom/aio/downloader/cleaner/RubActivity;->total_show:J

    const/16 v8, 0xa

    shl-long/2addr v6, v8

    iput-wide v6, v5, Lcom/aio/downloader/cleaner/RubActivity;->total_show:J

    .line 776
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-wide v6, v5, Lcom/aio/downloader/cleaner/RubActivity;->total_show:J

    add-long/2addr v6, v2

    iput-wide v6, v5, Lcom/aio/downloader/cleaner/RubActivity;->total_show:J

    .line 777
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-wide v6, v6, Lcom/aio/downloader/cleaner/RubActivity;->total_show:J

    invoke-static {v6, v7}, Lcom/aio/downloader/cleaner/TextFormater;->dataSizeFormat(J)Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$53(Lcom/aio/downloader/cleaner/RubActivity;Ljava/lang/String;)V

    .line 778
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 779
    .local v1, "msg":Landroid/os/Message;
    const/4 v5, 0x1

    iput v5, v1, Landroid/os/Message;->what:I

    .line 780
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->handler2:Landroid/os/Handler;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/RubActivity;->access$42(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/os/Handler;

    move-result-object v5

    invoke-virtual {v5, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 781
    return-void

    .line 763
    .end local v0    # "memoryInfo":Landroid/app/ActivityManager$MemoryInfo;
    .end local v1    # "msg":Landroid/os/Message;
    .end local v2    # "size":J
    :cond_0
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/cleaner/TaskInfo;

    .line 764
    .local v4, "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$9;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget-wide v7, v6, Lcom/aio/downloader/cleaner/RubActivity;->total_show:J

    invoke-virtual {v4}, Lcom/aio/downloader/cleaner/TaskInfo;->getMemory()I

    move-result v9

    int-to-long v9, v9

    add-long/2addr v7, v9

    iput-wide v7, v6, Lcom/aio/downloader/cleaner/RubActivity;->total_show:J

    goto :goto_0
.end method
