.class Lcom/aio/downloader/activity/AppDetailsActivity$2;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$2;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 148
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 151
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$2;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 153
    return-void
.end method
