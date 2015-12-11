.class Lcom/aio/downloader/activity/AppDetailsActivity$6;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$6;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 205
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    .line 210
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$6;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailtopre2:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$5(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->performClick()Z

    .line 211
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$6;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailtopre2:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$5(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 212
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$6;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_start:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$8(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 213
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$6;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_start:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$8(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    const-string v1, "Retry"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 215
    return-void
.end method
