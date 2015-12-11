.class Lcom/aio/downloader/activity/MyMainActivity$9;
.super Landroid/content/BroadcastReceiver;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$9;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 634
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 637
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$9;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$13(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 638
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$9;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 639
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$9;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$9;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimation:Landroid/view/animation/Animation;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity;->access$16(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 641
    return-void
.end method
