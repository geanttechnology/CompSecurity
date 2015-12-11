.class public Lcom/amazon/android/webkit/AmazonWebView;
.super Landroid/widget/FrameLayout;
.source "AmazonWebView.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ViewConstructor"
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;,
        Lcom/amazon/android/webkit/AmazonWebView$HitTestResult;
    }
.end annotation


# instance fields
.field private attachment:Ljava/lang/Object;

.field private pageLoadID:Ljava/lang/String;

.field private webViewDelegate:Lcom/amazon/android/webkit/AmazonWebViewDelegate;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 196
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 160
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->pageLoadID:Ljava/lang/String;

    .line 197
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->attachment:Ljava/lang/Object;

    .line 198
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 209
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 160
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->pageLoadID:Ljava/lang/String;

    .line 210
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->attachment:Ljava/lang/Object;

    .line 211
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 223
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 160
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->pageLoadID:Ljava/lang/String;

    .line 224
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->attachment:Ljava/lang/Object;

    .line 225
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/Object;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attachment"    # Ljava/lang/Object;

    .prologue
    const/4 v1, -0x1

    .line 237
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 160
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->pageLoadID:Ljava/lang/String;

    .line 238
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0}, Lcom/amazon/android/webkit/AmazonWebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 240
    iput-object p2, p0, Lcom/amazon/android/webkit/AmazonWebView;->attachment:Ljava/lang/Object;

    .line 241
    return-void
.end method

.method private static checkThread()V
    .locals 3

    .prologue
    .line 1578
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 1579
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Warning: A WebView method was called on thread \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "\'. "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "All WebView methods must be called on the UI thread."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1584
    :cond_0
    return-void
.end method


# virtual methods
.method public addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "interfaceName"    # Ljava/lang/String;

    .prologue
    .line 846
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 847
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 848
    return-void
.end method

.method public canGoBack()Z
    .locals 1

    .prologue
    .line 673
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 674
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->canGoBack()Z

    move-result v0

    return v0
.end method

.method public canScrollHorizontally(I)Z
    .locals 1
    .param p1, "direction"    # I

    .prologue
    .line 1530
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1531
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->canScrollHorizontally(I)Z

    move-result v0

    return v0
.end method

.method public canScrollVertically(I)Z
    .locals 1
    .param p1, "direction"    # I

    .prologue
    .line 1540
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1541
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->canScrollVertically(I)Z

    move-result v0

    return v0
.end method

.method public clearFormData()V
    .locals 1

    .prologue
    .line 723
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 724
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->clearFormData()V

    .line 725
    return-void
.end method

.method public computeScroll()V
    .locals 1

    .prologue
    .line 929
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->computeScroll()V

    .line 930
    return-void
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 693
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 694
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->destroy()V

    .line 695
    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 2
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 1569
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1570
    const-class v0, Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "AmazonWebView.draw() -- Unsupported method; Use capturePicture(int, int, int, int, int, AmazonPictureReadyListener) instead"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1574
    return-void
.end method

.method public getAttachment()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1359
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1360
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->attachment:Ljava/lang/Object;

    return-object v0
.end method

.method public getCertificate()Landroid/net/http/SslCertificate;
    .locals 1

    .prologue
    .line 456
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 457
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getCertificate()Landroid/net/http/SslCertificate;

    move-result-object v0

    return-object v0
.end method

.method public getContentHeight()I
    .locals 1

    .prologue
    .line 1550
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1551
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getContentHeight()I

    move-result v0

    return v0
.end method

.method public getFavicon()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 397
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 398
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getFavicon()Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public getHitTestResult()Lcom/amazon/android/webkit/AmazonWebView$HitTestResult;
    .locals 1

    .prologue
    .line 474
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 475
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getHitTestResult()Lcom/amazon/android/webkit/AmazonWebView$HitTestResult;

    move-result-object v0

    return-object v0
.end method

.method public getLoadingUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1339
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1340
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getLoadingUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMimeType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1511
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1512
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getMimeType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getOriginalUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 426
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 427
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getOriginalUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPageLoadID()Ljava/lang/String;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 287
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 288
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->pageLoadID:Ljava/lang/String;

    return-object v0
.end method

.method public getProgress()I
    .locals 1

    .prologue
    .line 436
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 437
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getProgress()I

    move-result v0

    return v0
.end method

.method public getScale()F
    .locals 1

    .prologue
    .line 954
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 955
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getScale()F

    move-result v0

    return v0
.end method

.method public getScrollBarStyle()I
    .locals 1

    .prologue
    .line 1175
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getScrollBarStyle()I

    move-result v0

    return v0
.end method

.method public getSettings()Lcom/amazon/android/webkit/AmazonWebSettings;
    .locals 1

    .prologue
    .line 407
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getSettings()Lcom/amazon/android/webkit/AmazonWebSettings;

    move-result-object v0

    return-object v0
.end method

.method public getSolidColor()I
    .locals 1

    .prologue
    .line 866
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 867
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getSolidColor()I

    move-result v0

    return v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 446
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 447
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTouchIconUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 741
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getTouchIconUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 416
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 417
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVerticalScrollOffset()I
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1285
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1286
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->getVerticalScrollOffset()I

    move-result v0

    return v0
.end method

.method public getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;
    .locals 2

    .prologue
    .line 248
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->webViewDelegate:Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    if-nez v0, :cond_0

    .line 249
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "webview delegate not set because user did not call AmazonWebKitFactory.initializeWebView() first"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 252
    :cond_0
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->webViewDelegate:Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    return-object v0
.end method

.method public goBack()V
    .locals 1

    .prologue
    .line 357
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 358
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->goBack()V

    .line 359
    return-void
.end method

.method public isHorizontalScrollBarEnabled()Z
    .locals 1

    .prologue
    .line 1226
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1227
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->isHorizontalScrollBarEnabled()Z

    move-result v0

    return v0
.end method

.method public isVerticalScrollBarEnabled()Z
    .locals 1

    .prologue
    .line 1237
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1238
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->isVerticalScrollBarEnabled()Z

    move-result v0

    return v0
.end method

.method public loadUrl(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 307
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 308
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->loadUrl(Ljava/lang/String;)V

    .line 309
    return-void
.end method

.method public onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;
    .locals 1
    .param p1, "outAttrs"    # Landroid/view/inputmethod/EditorInfo;

    .prologue
    .line 974
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;

    move-result-object v0

    return-object v0
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .prologue
    .line 983
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 984
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 985
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 1
    .param p1, "info"    # Landroid/view/accessibility/AccessibilityNodeInfo;

    .prologue
    .line 993
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 994
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 995
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 1491
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public onWindowFocusChanged(Z)V
    .locals 1
    .param p1, "hasWindowFocus"    # Z

    .prologue
    .line 1003
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->onWindowFocusChanged(Z)V

    .line 1004
    return-void
.end method

.method public pauseTimers()V
    .locals 1

    .prologue
    .line 545
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 546
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->pauseTimers()V

    .line 547
    return-void
.end method

.method public performAccessibilityAction(ILandroid/os/Bundle;)Z
    .locals 2
    .param p1, "action"    # I
    .param p2, "arguments"    # Landroid/os/Bundle;

    .prologue
    .line 1052
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->performAccessibilityAction(ILandroid/os/Bundle;)Z

    move-result v0

    .line 1053
    .local v0, "value":Z
    if-nez v0, :cond_0

    .line 1054
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->performAccessibilityAction(ILandroid/os/Bundle;)Z

    move-result v0

    .line 1056
    .end local v0    # "value":Z
    :cond_0
    return v0
.end method

.method public performLongClick()Z
    .locals 1

    .prologue
    .line 1065
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->performLongClick()Z

    move-result v0

    return v0
.end method

.method public reload()V
    .locals 1

    .prologue
    .line 337
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 338
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->reload()V

    .line 339
    return-void
.end method

.method public requestFocus(ILandroid/graphics/Rect;)Z
    .locals 1
    .param p1, "direction"    # I
    .param p2, "previouslyFocusedRect"    # Landroid/graphics/Rect;

    .prologue
    .line 1075
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->requestFocus(ILandroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method

.method public restoreState(Landroid/os/Bundle;)Lcom/amazon/android/webkit/AmazonWebBackForwardList;
    .locals 1
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    .line 663
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 664
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->restoreState(Landroid/os/Bundle;)Lcom/amazon/android/webkit/AmazonWebBackForwardList;

    move-result-object v0

    return-object v0
.end method

.method public resumeTimers()V
    .locals 1

    .prologue
    .line 555
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 556
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->resumeTimers()V

    .line 557
    return-void
.end method

.method public saveState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    .line 653
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 654
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->saveState(Landroid/os/Bundle;)V

    .line 655
    return-void
.end method

.method public scrollBy(II)V
    .locals 1
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 1561
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1562
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->scrollBy(II)V

    .line 1563
    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 1110
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setBackgroundColor(I)V

    .line 1111
    return-void
.end method

.method public setCertificate(Landroid/net/http/SslCertificate;)V
    .locals 1
    .param p1, "certificate"    # Landroid/net/http/SslCertificate;

    .prologue
    .line 1119
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1120
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setCertificate(Landroid/net/http/SslCertificate;)V

    .line 1121
    return-void
.end method

.method public setContentDescription(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "contentDescription"    # Ljava/lang/CharSequence;

    .prologue
    .line 1604
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1605
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1606
    return-void
.end method

.method public setDownloadDelegate(Lcom/amazon/android/webkit/AmazonDownloadDelegate;)V
    .locals 1
    .param p1, "delegate"    # Lcom/amazon/android/webkit/AmazonDownloadDelegate;

    .prologue
    .line 505
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 506
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setDownloadDelegate(Lcom/amazon/android/webkit/AmazonDownloadDelegate;)V

    .line 507
    return-void
.end method

.method public setDownloadListener(Lcom/amazon/android/webkit/AmazonDownloadListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonDownloadListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 496
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 497
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setDownloadListener(Lcom/amazon/android/webkit/AmazonDownloadListener;)V

    .line 498
    return-void
.end method

.method public setFindIsUp(Z)V
    .locals 1
    .param p1, "isUp"    # Z

    .prologue
    .line 756
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 757
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setFindIsUp(Z)V

    .line 758
    return-void
.end method

.method public setFindListener(Lcom/amazon/android/webkit/AmazonFindListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonFindListener;

    .prologue
    .line 297
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 298
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setFindListener(Lcom/amazon/android/webkit/AmazonFindListener;)V

    .line 299
    return-void
.end method

.method public setHorizontalScrollBarEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 1204
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1205
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setHorizontalScrollBarEnabled(Z)V

    .line 1206
    return-void
.end method

.method public setHorizontalScrollbarOverlay(Z)V
    .locals 1
    .param p1, "overlay"    # Z

    .prologue
    .line 1129
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1130
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setHorizontalScrollbarOverlay(Z)V

    .line 1131
    return-void
.end method

.method public setInitialScale(I)V
    .locals 1
    .param p1, "scaleInPercent"    # I

    .prologue
    .line 1139
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1140
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setInitialScale(I)V

    .line 1141
    return-void
.end method

.method public setLayerType(ILandroid/graphics/Paint;)V
    .locals 1
    .param p1, "layerType"    # I
    .param p2, "paint"    # Landroid/graphics/Paint;

    .prologue
    .line 1148
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setLayerType(ILandroid/graphics/Paint;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1149
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->setLayerType(ILandroid/graphics/Paint;)V

    .line 1150
    :cond_0
    return-void
.end method

.method public setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1
    .param p1, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 1593
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1595
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->webViewDelegate:Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    if-eqz v0, :cond_0

    .line 1596
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->webViewDelegate:Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1598
    :cond_0
    return-void
.end method

.method public setLoadingUrl(Ljava/lang/String;)V
    .locals 1
    .param p1, "loadingUrl"    # Ljava/lang/String;

    .prologue
    .line 1349
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1350
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setLoadingUrl(Ljava/lang/String;)V

    .line 1351
    return-void
.end method

.method public setMapTrackballToArrowKeys(Z)V
    .locals 1
    .param p1, "setMap"    # Z

    .prologue
    .line 1156
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1157
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setMapTrackballToArrowKeys(Z)V

    .line 1158
    return-void
.end method

.method public setNetworkAvailable(Z)V
    .locals 1
    .param p1, "flg"    # Z

    .prologue
    .line 484
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 485
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setNetworkAvailable(Z)V

    .line 486
    return-void
.end method

.method public setOnKeyListener(Landroid/view/View$OnKeyListener;)V
    .locals 1
    .param p1, "l"    # Landroid/view/View$OnKeyListener;

    .prologue
    .line 1501
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1502
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 1503
    return-void
.end method

.method public setOnOverscrollByListener(Lcom/amazon/android/webkit/AmazonOverScrollByListener;)V
    .locals 1
    .param p1, "amazonOverScrollByListener"    # Lcom/amazon/android/webkit/AmazonOverScrollByListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1310
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1311
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setOnOverscrollByListener(Lcom/amazon/android/webkit/AmazonOverScrollByListener;)V

    .line 1312
    return-void
.end method

.method public setOnScrollChangedListener(Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;

    .prologue
    .line 1320
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1321
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setOnScrollChangedListener(Lcom/amazon/android/webkit/AmazonOnScrollChangedListener;)V

    .line 1322
    return-void
.end method

.method public setOnScrollingListener(Lcom/amazon/android/webkit/AmazonOnScrollingListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonOnScrollingListener;

    .prologue
    .line 1330
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1331
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setOnScrollingListener(Lcom/amazon/android/webkit/AmazonOnScrollingListener;)V

    .line 1332
    return-void
.end method

.method public setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    .locals 1
    .param p1, "l"    # Landroid/view/View$OnTouchListener;

    .prologue
    .line 1615
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1616
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1617
    return-void
.end method

.method public setOnTouchOverride(Landroid/view/View$OnTouchListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/view/View$OnTouchListener;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1299
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1300
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setOnTouchOverride(Landroid/view/View$OnTouchListener;)V

    .line 1301
    return-void
.end method

.method public setOnUrlLoadRequested(Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;

    .prologue
    .line 1371
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1372
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setOnUrlLoadRequested(Lcom/amazon/android/webkit/AmazonWebView$OnUrlLoadRequestedListener;)V

    .line 1373
    return-void
.end method

.method public setOverScrollMode(I)V
    .locals 1
    .param p1, "overScrollMode"    # I

    .prologue
    .line 1480
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->webViewDelegate:Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    if-eqz v0, :cond_0

    .line 1481
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->webViewDelegate:Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setOverScrollMode(I)V

    .line 1483
    :cond_0
    return-void
.end method

.method public setScrollBarStyle(I)V
    .locals 1
    .param p1, "style"    # I

    .prologue
    .line 1166
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setScrollBarStyle(I)V

    .line 1167
    return-void
.end method

.method public setSelectPopupHandler(Lcom/amazon/android/webkit/AmazonSelectPopupHandler;)V
    .locals 1
    .param p1, "handler"    # Lcom/amazon/android/webkit/AmazonSelectPopupHandler;

    .prologue
    .line 1468
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1469
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setSelectPopupHandler(Lcom/amazon/android/webkit/AmazonSelectPopupHandler;)V

    .line 1470
    return-void
.end method

.method public setVerticalScrollBarEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 1215
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1216
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setVerticalScrollBarEnabled(Z)V

    .line 1217
    return-void
.end method

.method public setVerticalScrollbarOverlay(Z)V
    .locals 1
    .param p1, "overlay"    # Z

    .prologue
    .line 1193
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1194
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setVerticalScrollbarOverlay(Z)V

    .line 1195
    return-void
.end method

.method public setWebBackForwardListClient(Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;)V
    .locals 1
    .param p1, "client"    # Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;

    .prologue
    .line 805
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 806
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setWebBackForwardListClient(Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;)V

    .line 807
    return-void
.end method

.method public setWebChromeClient(Lcom/amazon/android/webkit/AmazonWebChromeClient;)V
    .locals 1
    .param p1, "client"    # Lcom/amazon/android/webkit/AmazonWebChromeClient;

    .prologue
    .line 535
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 536
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setWebChromeClient(Lcom/amazon/android/webkit/AmazonWebChromeClient;)V

    .line 537
    return-void
.end method

.method public setWebViewClient(Lcom/amazon/android/webkit/AmazonWebViewClient;)V
    .locals 1
    .param p1, "webViewClient"    # Lcom/amazon/android/webkit/AmazonWebViewClient;

    .prologue
    .line 347
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 348
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setWebViewClient(Lcom/amazon/android/webkit/AmazonWebViewClient;)V

    .line 349
    return-void
.end method

.method public setWebViewDelegate(Lcom/amazon/android/webkit/AmazonWebViewDelegate;)V
    .locals 2
    .param p1, "delegate"    # Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    .prologue
    .line 262
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebView;->webViewDelegate:Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    if-nez v0, :cond_0

    .line 263
    iput-object p1, p0, Lcom/amazon/android/webkit/AmazonWebView;->webViewDelegate:Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    .line 267
    return-void

    .line 265
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "WebViewDelegate is already set."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setZOrderOverlay(Z)V
    .locals 1
    .param p1, "shouldOverlay"    # Z

    .prologue
    .line 1636
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 1637
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->setZOrderOverlay(Z)V

    .line 1638
    return-void
.end method

.method public shouldDelayChildPressedState()Z
    .locals 1

    .prologue
    .line 1245
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->shouldDelayChildPressedState()Z

    move-result v0

    return v0
.end method

.method public stopLoading()V
    .locals 1

    .prologue
    .line 643
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebView;->checkThread()V

    .line 644
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getWebViewDelegate()Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;->stopLoading()V

    .line 645
    return-void
.end method
