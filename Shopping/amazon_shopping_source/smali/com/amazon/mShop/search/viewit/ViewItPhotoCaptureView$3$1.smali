.class Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;
.super Ljava/lang/Object;
.source "ViewItPhotoCaptureView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->onDrawerOpened()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 198
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getViewItMetricHelper()Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v0

    const-string/jumbo v1, "history-maximized"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 199
    const-string/jumbo v0, "fl_tray_open"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 201
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateHandleBackground(F)V

    .line 202
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomToolBar()V

    .line 203
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v0

    const-string/jumbo v1, "off"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->setCameraFlashMode(Ljava/lang/String;)Z

    .line 204
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateFlashModeButtonVisibility()V

    .line 205
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->view_it_history_text:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateTitle(I)V

    .line 207
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 208
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->updateSlidingDrawerAndDismissAnimationWindow(Z)V

    .line 211
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->isEnginePaused()Z

    move-result v0

    if-nez v0, :cond_1

    .line 212
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->pauseEngine()V

    .line 214
    :cond_1
    return-void
.end method
