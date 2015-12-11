.class Lcom/aio/downloader/cleaner/PhoneBoostActivity$6;
.super Ljava/lang/Thread;
.source "PhoneBoostActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/PhoneBoostActivity;->AsyncData()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$6;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    .line 351
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 354
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$6;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$6;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->manager:Lcom/wjj/manager/BoostRuningAppManager;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$20(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/manager/BoostRuningAppManager;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$6;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->mlistener:Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$21(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/wjj/manager/BoostRuningAppManager;->getRuningUserApp(Lcom/wjj/manager/BoostRuningAppManager$BoostRuningAppManagerListener;)I

    move-result v1

    invoke-static {v0, v1}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$22(Lcom/aio/downloader/cleaner/PhoneBoostActivity;I)V

    .line 355
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$6;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$18(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Landroid/os/Handler;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 356
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 357
    return-void
.end method
