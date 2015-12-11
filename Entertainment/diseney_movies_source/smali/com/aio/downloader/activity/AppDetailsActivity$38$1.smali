.class Lcom/aio/downloader/activity/AppDetailsActivity$38$1;
.super Ljava/util/TimerTask;
.source "AppDetailsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity$38;->onPostExecute(Ljava/lang/Void;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/AppDetailsActivity$38;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity$38;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$38;

    .line 2850
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AppDetailsActivity$38$1;)Lcom/aio/downloader/activity/AppDetailsActivity$38;
    .locals 1

    .prologue
    .line 2850
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$38;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2853
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38$1;->this$1:Lcom/aio/downloader/activity/AppDetailsActivity$38;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity$38;->access$2(Lcom/aio/downloader/activity/AppDetailsActivity$38;)Lcom/aio/downloader/activity/AppDetailsActivity;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$38$1$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$38$1$1;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity$38$1;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2868
    return-void
.end method
