.class Lcom/aio/downloader/cleaner/JunkActivity$7;
.super Ljava/lang/Thread;
.source "JunkActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/JunkActivity;->AsyncDataEmpty()V
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
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity$7;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    .line 410
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 413
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 414
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$7;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/JunkActivity$7;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->urm:Lcom/wjj/manager/UnloadingResidueManager;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$59(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/UnloadingResidueManager;

    move-result-object v2

    new-instance v3, Ljava/io/File;

    .line 415
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 414
    invoke-virtual {v2, v3}, Lcom/wjj/manager/UnloadingResidueManager;->GGGfile(Ljava/io/File;)Ljava/util/List;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$22(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/util/List;)V

    .line 416
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$7;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v0

    .line 417
    .local v0, "msg5":Landroid/os/Message;
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$7;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->emptyfile:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$23(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 418
    const/4 v1, 0x5

    iput v1, v0, Landroid/os/Message;->what:I

    .line 419
    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$7;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 420
    return-void
.end method
