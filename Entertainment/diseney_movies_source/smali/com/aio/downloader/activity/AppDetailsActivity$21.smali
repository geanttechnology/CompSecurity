.class Lcom/aio/downloader/activity/AppDetailsActivity$21;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$21;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1015
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AppDetailsActivity$21;)Lcom/aio/downloader/activity/AppDetailsActivity;
    .locals 1

    .prologue
    .line 1015
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$21;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 1020
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$21;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk1:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$3(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1021
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$21;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_start:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$8(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1022
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$21;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$4(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$21;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_pro_cru:I
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$76(Lcom/aio/downloader/activity/AppDetailsActivity;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 1024
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$21;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$77(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/util/Timer;)V

    .line 1025
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$21;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$77(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/util/Timer;)V

    .line 1026
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$21;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$21$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$21$1;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity$21;)V

    .line 1046
    const-wide/16 v2, 0x3e8

    const-wide/16 v4, 0x258

    .line 1026
    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 1048
    new-instance v6, Landroid/content/Intent;

    const-string v0, "pdtpause"

    invoke-direct {v6, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1049
    .local v6, "intent":Landroid/content/Intent;
    const-string v0, "type"

    const-string v1, "resume"

    invoke-virtual {v6, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1050
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$21;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v0, v6}, Lcom/aio/downloader/activity/AppDetailsActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 1052
    return-void
.end method
