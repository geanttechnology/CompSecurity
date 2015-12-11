.class Lcom/aio/downloader/activity/MyMainActivity$10$1;
.super Ljava/util/TimerTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity$10;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyMainActivity$10;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity$10;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$10$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$10;

    .line 775
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 779
    const-string v1, "qwa"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "icon0="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$10$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$10;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$10;->icon0:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity$10;->access$0(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 780
    new-instance v0, Landroid/content/Intent;

    const-string v1, "paidppp"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 781
    .local v0, "intent_paid":Landroid/content/Intent;
    const-string v1, "icon0"

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$10$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$10;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$10;->icon0:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$10;->access$0(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 782
    const-string v1, "icon1"

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$10$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$10;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$10;->icon1:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$10;->access$1(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 783
    const-string v1, "icon2"

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$10$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$10;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$10;->icon2:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$10;->access$2(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 784
    const-string v1, "icon3"

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$10$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$10;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$10;->icon3:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$10;->access$3(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 785
    const-string v1, "icon4"

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$10$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$10;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$10;->icon4:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$10;->access$4(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 786
    const-string v1, "icon5"

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$10$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$10;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$10;->icon5:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity$10;->access$5(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 787
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$10$1;->this$1:Lcom/aio/downloader/activity/MyMainActivity$10;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity$10;->access$6(Lcom/aio/downloader/activity/MyMainActivity$10;)Lcom/aio/downloader/activity/MyMainActivity;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 789
    return-void
.end method
