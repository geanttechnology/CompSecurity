.class Lcom/aio/downloader/activity/AppDetailsActivity$20;
.super Ljava/lang/Object;
.source "AppDetailsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$20;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 998
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 1002
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$20;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk1:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$3(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v1

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1003
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$20;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_start:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$8(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1004
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$20;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 1005
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$20;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Timer;->cancel()V

    .line 1008
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "pdtpause"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1009
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "type"

    const-string v2, "pause"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1010
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$20;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 1012
    return-void
.end method
