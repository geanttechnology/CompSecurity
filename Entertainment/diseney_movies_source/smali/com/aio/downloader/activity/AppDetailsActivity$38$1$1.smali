.class Lcom/aio/downloader/activity/AppDetailsActivity$38$1$1;
.super Ljava/lang/Object;
.source "AppDetailsActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/activity/AppDetailsActivity$38$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity$38$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$38$1;

    .line 2853
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2857
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$38$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$38;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$38$1;)Lcom/aio/downloader/activity/AppDetailsActivity$38;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$38;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$38;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$4(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v0

    const/16 v1, 0x5a

    if-lt v0, v1, :cond_1

    .line 2858
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$38$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$38;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$38$1;)Lcom/aio/downloader/activity/AppDetailsActivity$38;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$38;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$38;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2859
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$38$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$38;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$38$1;)Lcom/aio/downloader/activity/AppDetailsActivity$38;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$38;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$38;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 2866
    :cond_0
    :goto_0
    return-void

    .line 2862
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$38$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$38;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$38$1;)Lcom/aio/downloader/activity/AppDetailsActivity$38;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$38;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$38;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$4(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    .line 2863
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$38$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$38;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$38$1;)Lcom/aio/downloader/activity/AppDetailsActivity$38;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$38;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$38;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$4(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ProgressBar;

    move-result-object v1

    .line 2864
    invoke-virtual {v1}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v1

    .line 2863
    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    goto :goto_0
.end method
