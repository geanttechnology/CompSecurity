.class Lcom/aio/downloader/activity/AppDetailsActivity$8;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$8;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 226
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    .line 231
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$8;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk1:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$3(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/TextView;->performClick()Z

    .line 232
    return-void
.end method
