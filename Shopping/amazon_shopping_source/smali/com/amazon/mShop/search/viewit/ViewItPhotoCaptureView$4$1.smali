.class Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;
.super Ljava/lang/Object;
.source "ViewItPhotoCaptureView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->onDrawerClosed()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;)V
    .locals 0

    .prologue
    .line 227
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 230
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getViewItMetricHelper()Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;

    move-result-object v1

    const-string/jumbo v2, "history-minimized"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/search/viewit/ViewItMetricHelper;->logCountMetricsPerSession(Ljava/lang/String;I)V

    .line 231
    const-string/jumbo v1, "fl_tray_close"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 233
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v1

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateHandleBackground(F)V

    .line 234
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomToolBar()V

    .line 235
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateFlashModeButtonVisibility()V

    .line 236
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->view_it_searching:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateTitle(I)V

    .line 238
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBrowser()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v0

    .line 239
    .local v0, "browser":Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->deleteUndoObject()V

    .line 244
    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getObjectsCount()I

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isProgressBarDisplayed()Z

    move-result v1

    if-nez v1, :cond_1

    .line 245
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->setListViewHeaderVisibility(I)V

    .line 246
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v2, v2, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-virtual {v2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_vertical_bottom_empty_offset:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->updateBottomOffset(I)V

    .line 257
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->isEngineStopped()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 258
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->startScanning()V

    .line 262
    :cond_0
    :goto_1
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->enableLoading()V

    .line 263
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->enableDrawing()V

    .line 264
    return-void

    .line 249
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;)V

    invoke-interface {v1, v2}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 259
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->isEnginePaused()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 260
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    iget-object v1, v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->unpauseEngine()V

    goto :goto_1
.end method
