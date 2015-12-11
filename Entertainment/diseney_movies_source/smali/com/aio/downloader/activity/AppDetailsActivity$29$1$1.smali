.class Lcom/aio/downloader/activity/AppDetailsActivity$29$1$1;
.super Ljava/lang/Object;
.source "AppDetailsActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/aio/downloader/activity/AppDetailsActivity$29$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity$29$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$29$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$29$1;

    .line 1962
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1966
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$29$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$29$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$29;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$29$1;)Lcom/aio/downloader/activity/AppDetailsActivity$29;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$29;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$29;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$4(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$29$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$29$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$29;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$29$1;)Lcom/aio/downloader/activity/AppDetailsActivity$29;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$29;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$29;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_pro:I
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$78(Lcom/aio/downloader/activity/AppDetailsActivity;)I

    move-result v1

    if-lt v0, v1, :cond_1

    .line 1967
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$29$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$29$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$29;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$29$1;)Lcom/aio/downloader/activity/AppDetailsActivity$29;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$29;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$29;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1968
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$29$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$29$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$29;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$29$1;)Lcom/aio/downloader/activity/AppDetailsActivity$29;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$29;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$29;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 1976
    :cond_0
    :goto_0
    return-void

    .line 1971
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$29$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$29$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$29;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$29$1;)Lcom/aio/downloader/activity/AppDetailsActivity$29;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$29;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$29;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$4(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    .line 1972
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$29$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$29$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$29;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$29$1;)Lcom/aio/downloader/activity/AppDetailsActivity$29;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity$29;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$29;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$4(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ProgressBar;

    move-result-object v1

    .line 1973
    invoke-virtual {v1}, Landroid/widget/ProgressBar;->getProgress()I

    move-result v1

    .line 1972
    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 1974
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$29$1$1;->this$2:Lcom/aio/downloader/activity/AppDetailsActivity$29$1;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$29;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$29$1;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity$29$1;)Lcom/aio/downloader/activity/AppDetailsActivity$29;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$29;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$29;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$29;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_pro_cru:I
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$76(Lcom/aio/downloader/activity/AppDetailsActivity;)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$79(Lcom/aio/downloader/activity/AppDetailsActivity;I)V

    goto :goto_0
.end method
