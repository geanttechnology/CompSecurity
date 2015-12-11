.class Lcom/aio/downloader/activity/AppDetailsActivity$3;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$3;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 163
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$3;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    const-string v1, "downpath"

    invoke-virtual {p2, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$1(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V

    .line 168
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$3;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_install:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 169
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$3;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk1:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$3(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 171
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$3;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$4(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 173
    return-void
.end method
