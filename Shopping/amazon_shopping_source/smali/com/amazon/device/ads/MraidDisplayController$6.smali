.class Lcom/amazon/device/ads/MraidDisplayController$6;
.super Ljava/lang/Object;
.source "MraidDisplayController.java"

# interfaces
.implements Lcom/amazon/device/ads/AdVideoPlayer$AdVideoPlayerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/MraidDisplayController;->playVideo(Ljava/lang/String;Lcom/amazon/device/ads/Controller$Dimensions;Lcom/amazon/device/ads/Controller$PlayerProperties;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/MraidDisplayController;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidDisplayController;)V
    .locals 0

    .prologue
    .line 728
    iput-object p1, p0, Lcom/amazon/device/ads/MraidDisplayController$6;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onComplete()V
    .locals 3

    .prologue
    .line 738
    const-string/jumbo v1, "MraidDisplayController"

    const-string/jumbo v2, "videoplayback complete"

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 739
    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController$6;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    const/4 v2, 0x0

    # setter for: Lcom/amazon/device/ads/MraidDisplayController;->vidPlaying_:Z
    invoke-static {v1, v2}, Lcom/amazon/device/ads/MraidDisplayController;->access$202(Lcom/amazon/device/ads/MraidDisplayController;Z)Z

    .line 740
    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController$6;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    # getter for: Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidDisplayController;->access$400(Lcom/amazon/device/ads/MraidDisplayController;)Landroid/widget/FrameLayout;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/MraidDisplayController$6;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    # getter for: Lcom/amazon/device/ads/MraidDisplayController;->videoContainerId_:I
    invoke-static {v2}, Lcom/amazon/device/ads/MraidDisplayController;->access$300(Lcom/amazon/device/ads/MraidDisplayController;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 741
    .local v0, "vidContainer":Landroid/widget/FrameLayout;
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 742
    iget-object v1, p0, Lcom/amazon/device/ads/MraidDisplayController$6;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    # getter for: Lcom/amazon/device/ads/MraidDisplayController;->mRootView:Landroid/widget/FrameLayout;
    invoke-static {v1}, Lcom/amazon/device/ads/MraidDisplayController;->access$400(Lcom/amazon/device/ads/MraidDisplayController;)Landroid/widget/FrameLayout;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V

    .line 743
    return-void
.end method

.method public onError()V
    .locals 0

    .prologue
    .line 732
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidDisplayController$6;->onComplete()V

    .line 733
    return-void
.end method
