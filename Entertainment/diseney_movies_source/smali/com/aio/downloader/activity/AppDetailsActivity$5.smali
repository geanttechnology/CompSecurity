.class Lcom/aio/downloader/activity/AppDetailsActivity$5;
.super Landroid/content/BroadcastReceiver;
.source "AppDetailsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$5;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 192
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x0

    .line 197
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$5;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailtopre2:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$5(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 198
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$5;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailtoprel:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$6(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 199
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$5;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 200
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$5;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 202
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$5;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$4(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 203
    return-void
.end method
