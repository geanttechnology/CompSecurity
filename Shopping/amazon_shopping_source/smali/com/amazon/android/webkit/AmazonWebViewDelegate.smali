.class public abstract Lcom/amazon/android/webkit/AmazonWebViewDelegate;
.super Ljava/lang/Object;
.source "AmazonWebViewDelegate.java"


# instance fields
.field private loadingUrl:Ljava/lang/String;

.field private onScrollChangedListener:Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;

.field private onScrollingListener:Lcom/amazon/android/webkit/AmazonOnScrollingListener;

.field private onTouchListenerOverride:Landroid/view/View$OnTouchListener;

.field private onUrlLoadRequestedListener:Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;

.field private overScrollByListener:Lcom/amazon/android/webkit/AmazonOverScrollByListener;

.field private final view:Lcom/amazon/android/webkit/AmazonWebView;


# direct methods
.method protected constructor <init>(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 1
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    const/4 v0, 0x0

    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onTouchListenerOverride:Landroid/view/View$OnTouchListener;

    .line 40
    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->overScrollByListener:Lcom/amazon/android/webkit/AmazonOverScrollByListener;

    .line 43
    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onScrollChangedListener:Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;

    .line 49
    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onUrlLoadRequestedListener:Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;

    .line 58
    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->loadingUrl:Ljava/lang/String;

    .line 61
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->view:Lcom/amazon/android/webkit/AmazonWebView;

    .line 62
    return-void
.end method


# virtual methods
.method protected abstract addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V
.end method

.method protected abstract canGoBack()Z
.end method

.method protected abstract canScrollHorizontally(I)Z
.end method

.method protected abstract canScrollVertically(I)Z
.end method

.method protected abstract clearFormData()V
.end method

.method protected abstract computeScroll()V
.end method

.method protected abstract destroy()V
.end method

.method protected abstract getCertificate()Landroid/net/http/SslCertificate;
.end method

.method protected abstract getContentHeight()I
.end method

.method protected abstract getFavicon()Landroid/graphics/Bitmap;
.end method

.method protected abstract getHitTestResult()Lcom/amazon/android/webkit/AmazonWebView$HitTestResult;
.end method

.method protected getLoadingUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 518
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->loadingUrl:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->loadingUrl:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getUrl()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected getMimeType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 600
    const-string/jumbo v0, "application/octet-stream"

    return-object v0
.end method

.method protected abstract getOriginalUrl()Ljava/lang/String;
.end method

.method protected abstract getProgress()I
.end method

.method protected abstract getScale()F
.end method

.method protected abstract getScrollBarStyle()I
.end method

.method protected abstract getSettings()Lcom/amazon/android/webkit/AmazonWebSettings;
.end method

.method protected abstract getSolidColor()I
.end method

.method protected abstract getTitle()Ljava/lang/String;
.end method

.method protected abstract getTouchIconUrl()Ljava/lang/String;
.end method

.method protected abstract getUrl()Ljava/lang/String;
.end method

.method protected abstract getVerticalScrollOffset()I
.end method

.method protected getWebView()Lcom/amazon/android/webkit/AmazonWebView;
    .locals 1

    .prologue
    .line 595
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->view:Lcom/amazon/android/webkit/AmazonWebView;

    return-object v0
.end method

.method protected abstract goBack()V
.end method

.method protected abstract isHorizontalScrollBarEnabled()Z
.end method

.method protected abstract isVerticalScrollBarEnabled()Z
.end method

.method protected abstract loadUrl(Ljava/lang/String;)V
.end method

.method protected abstract onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;
.end method

.method protected abstract onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
.end method

.method protected abstract onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
.end method

.method protected abstract onTouchEvent(Landroid/view/MotionEvent;)Z
.end method

.method protected onUrlLoadRequested(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 578
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onUrlLoadRequestedListener:Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;

    if-eqz v0, :cond_0

    .line 579
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onUrlLoadRequestedListener:Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;

    iget-object v1, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->view:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-interface {v0, v1, p1}, Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;->urlLoadRequested(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V

    .line 581
    :cond_0
    return-void
.end method

.method protected onWebViewOverScrollBy(IIIIIIIIZ)V
    .locals 10
    .param p1, "deltaX"    # I
    .param p2, "deltaY"    # I
    .param p3, "scrollX"    # I
    .param p4, "scrollY"    # I
    .param p5, "scrollRangeX"    # I
    .param p6, "scrollRangeY"    # I
    .param p7, "maxOverScrollX"    # I
    .param p8, "maxOverScrollY"    # I
    .param p9, "isTouchEvent"    # Z

    .prologue
    .line 557
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->overScrollByListener:Lcom/amazon/android/webkit/AmazonOverScrollByListener;

    if-eqz v0, :cond_0

    .line 558
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->overScrollByListener:Lcom/amazon/android/webkit/AmazonOverScrollByListener;

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    invoke-interface/range {v0 .. v9}, Lcom/amazon/android/webkit/AmazonOverScrollByListener;->onOverScrollBy(IIIIIIIIZ)V

    .line 560
    :cond_0
    return-void
.end method

.method protected onWebViewScrollChanged(II)V
    .locals 1
    .param p1, "newScrollX"    # I
    .param p2, "newScrollY"    # I

    .prologue
    .line 567
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onScrollChangedListener:Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;

    if-eqz v0, :cond_0

    .line 568
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onScrollChangedListener:Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;

    invoke-interface {v0, p1, p2}, Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;->onScrollChanged(II)V

    .line 570
    :cond_0
    return-void
.end method

.method protected onWebViewScrolling(IIII)V
    .locals 1
    .param p1, "deltaX"    # I
    .param p2, "deltaY"    # I
    .param p3, "scrollX"    # I
    .param p4, "scrollY"    # I

    .prologue
    .line 588
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onScrollingListener:Lcom/amazon/android/webkit/AmazonOnScrollingListener;

    if-eqz v0, :cond_0

    .line 589
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onScrollingListener:Lcom/amazon/android/webkit/AmazonOnScrollingListener;

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/amazon/android/webkit/AmazonOnScrollingListener;->onScrolling(IIII)V

    .line 591
    :cond_0
    return-void
.end method

.method protected onWebViewTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 532
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onTouchListenerOverride:Landroid/view/View$OnTouchListener;

    if-eqz v0, :cond_0

    .line 533
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onTouchListenerOverride:Landroid/view/View$OnTouchListener;

    iget-object v1, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->view:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-interface {v0, v1, p1}, Landroid/view/View$OnTouchListener;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z

    move-result v0

    .line 536
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected abstract onWindowFocusChanged(Z)V
.end method

.method protected abstract pauseTimers()V
.end method

.method protected abstract performAccessibilityAction(ILandroid/os/Bundle;)Z
.end method

.method protected abstract performLongClick()Z
.end method

.method protected abstract reload()V
.end method

.method protected abstract requestFocus(ILandroid/graphics/Rect;)Z
.end method

.method protected abstract restoreState(Landroid/os/Bundle;)Lcom/amazon/android/webkit/AmazonWebBackForwardList;
.end method

.method protected abstract resumeTimers()V
.end method

.method protected abstract saveState(Landroid/os/Bundle;)V
.end method

.method protected scrollBy(II)V
    .locals 1
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 608
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method protected abstract setBackgroundColor(I)V
.end method

.method protected abstract setCertificate(Landroid/net/http/SslCertificate;)V
.end method

.method protected abstract setContentDescription(Ljava/lang/CharSequence;)V
.end method

.method protected abstract setDownloadDelegate(Lcom/amazon/android/webkit/AmazonDownloadDelegate;)V
.end method

.method protected abstract setDownloadListener(Lcom/amazon/android/webkit/AmazonDownloadListener;)V
.end method

.method protected abstract setFindIsUp(Z)V
.end method

.method protected abstract setFindListener(Lcom/amazon/android/webkit/AmazonFindListener;)V
.end method

.method protected abstract setHorizontalScrollBarEnabled(Z)V
.end method

.method protected abstract setHorizontalScrollbarOverlay(Z)V
.end method

.method protected abstract setInitialScale(I)V
.end method

.method protected abstract setLayerType(ILandroid/graphics/Paint;)Z
.end method

.method protected setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    .locals 0
    .param p1, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 612
    return-void
.end method

.method protected setLoadingUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "loadingUrl"    # Ljava/lang/String;

    .prologue
    .line 523
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->loadingUrl:Ljava/lang/String;

    .line 524
    return-void
.end method

.method protected abstract setMapTrackballToArrowKeys(Z)V
.end method

.method protected abstract setNetworkAvailable(Z)V
.end method

.method protected abstract setOnKeyListener(Landroid/view/View$OnKeyListener;)V
.end method

.method protected setOnOverscrollByListener(Lcom/amazon/android/webkit/AmazonOverScrollByListener;)V
    .locals 0
    .param p1, "amazonOverScrollByListener"    # Lcom/amazon/android/webkit/AmazonOverScrollByListener;

    .prologue
    .line 498
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->overScrollByListener:Lcom/amazon/android/webkit/AmazonOverScrollByListener;

    .line 499
    return-void
.end method

.method protected setOnScrollChangedListener(Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;

    .prologue
    .line 503
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onScrollChangedListener:Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;

    .line 504
    return-void
.end method

.method protected setOnScrollingListener(Lcom/amazon/android/webkit/AmazonOnScrollingListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonOnScrollingListener;

    .prologue
    .line 513
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onScrollingListener:Lcom/amazon/android/webkit/AmazonOnScrollingListener;

    .line 514
    return-void
.end method

.method protected abstract setOnTouchListener(Landroid/view/View$OnTouchListener;)V
.end method

.method protected setOnTouchOverride(Landroid/view/View$OnTouchListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/view/View$OnTouchListener;

    .prologue
    .line 493
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onTouchListenerOverride:Landroid/view/View$OnTouchListener;

    .line 494
    return-void
.end method

.method protected setOnUrlLoadRequested(Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;

    .prologue
    .line 508
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onUrlLoadRequestedListener:Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;

    .line 509
    return-void
.end method

.method protected abstract setOverScrollMode(I)V
.end method

.method protected abstract setScrollBarStyle(I)V
.end method

.method protected abstract setSelectPopupHandler(Lcom/amazon/android/webkit/AmazonSelectPopupHandler;)V
.end method

.method protected abstract setVerticalScrollBarEnabled(Z)V
.end method

.method protected abstract setVerticalScrollbarOverlay(Z)V
.end method

.method protected abstract setWebBackForwardListClient(Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;)V
.end method

.method protected abstract setWebChromeClient(Lcom/amazon/android/webkit/AmazonWebChromeClient;)V
.end method

.method protected abstract setWebViewClient(Lcom/amazon/android/webkit/AmazonWebViewClient;)V
.end method

.method protected setZOrderOverlay(Z)V
    .locals 1
    .param p1, "shouldOverlay"    # Z

    .prologue
    .line 632
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method protected abstract shouldDelayChildPressedState()Z
.end method

.method protected abstract stopLoading()V
.end method
