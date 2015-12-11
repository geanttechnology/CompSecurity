.class public Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;
.super Lcom/amazon/android/webkit/AmazonWebViewDelegate;
.source "AndroidWebViewDelegate.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ViewConstructor"
    }
.end annotation


# static fields
.field private static final DEBUG_DUMP:Ljava/lang/reflect/Method;

.field private static final WEB_HISTORY_ITEM_DATA_FIELD:Ljava/lang/reflect/Field;


# instance fields
.field private final solidColor:I

.field private final urlRequestHandler:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Lcom/amazon/android/webkit/AmazonUrlRequestHandler;",
            ">;"
        }
    .end annotation
.end field

.field private final webSettings:Lcom/amazon/android/webkit/AmazonWebSettings;

.field private final webviewDelegate:Landroid/webkit/WebView;

.field private final webviewReflection:Lcom/amazon/android/webkit/android/AndroidWebViewReflection;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    .line 69
    const-class v0, Landroid/webkit/WebHistoryItem;

    .line 70
    .local v0, "historyItemClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v1, 0x0

    .line 74
    .local v1, "historyItemDataField":Ljava/lang/reflect/Field;
    :try_start_0
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x10

    if-le v2, v3, :cond_0

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x13

    if-ge v2, v3, :cond_0

    .line 76
    const-string/jumbo v2, "android.webkit.WebHistoryItemClassic"

    invoke-static {v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 78
    :cond_0
    const-string/jumbo v2, "mFlattenedData"

    invoke-static {v0, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredPrivateField(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    :try_end_0
    .catch Ljava/lang/AssertionError; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 83
    :goto_0
    sput-object v1, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->WEB_HISTORY_ITEM_DATA_FIELD:Ljava/lang/reflect/Field;

    .line 86
    const-class v2, Landroid/webkit/WebView;

    const-string/jumbo v3, "debugDump"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Class;

    invoke-static {v2, v3, v4}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    sput-object v2, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->DEBUG_DUMP:Ljava/lang/reflect/Method;

    return-void

    .line 81
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public constructor <init>(Lcom/amazon/android/webkit/AmazonWebView;ILjava/util/concurrent/atomic/AtomicReference;)V
    .locals 2
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "solidColor"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/android/webkit/AmazonWebView;",
            "I",
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Lcom/amazon/android/webkit/AmazonUrlRequestHandler;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 112
    .local p3, "urlRequestHandler":Ljava/util/concurrent/atomic/AtomicReference;, "Ljava/util/concurrent/atomic/AtomicReference<Lcom/amazon/android/webkit/AmazonUrlRequestHandler;>;"
    invoke-direct {p0, p1}, Lcom/amazon/android/webkit/AmazonWebViewDelegate;-><init>(Lcom/amazon/android/webkit/AmazonWebView;)V

    .line 113
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lcom/amazon/android/webkit/AmazonWebView;->setVerticalFadingEdgeEnabled(Z)V

    .line 114
    const/16 v0, 0xa

    invoke-virtual {p1, v0}, Lcom/amazon/android/webkit/AmazonWebView;->setFadingEdgeLength(I)V

    .line 115
    iput p2, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->solidColor:I

    .line 117
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$1;

    invoke-virtual {p1}, Lcom/amazon/android/webkit/AmazonWebView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$1;-><init>(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    .line 143
    iput-object p3, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->urlRequestHandler:Ljava/util/concurrent/atomic/AtomicReference;

    .line 144
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/android/webkit/android/AndroidWebSettings;-><init>(Landroid/webkit/WebSettings;)V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webSettings:Lcom/amazon/android/webkit/AmazonWebSettings;

    .line 145
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-static {v0}, Lcom/amazon/android/webkit/android/AndroidWebViewReflection;->create(Landroid/webkit/WebView;)Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewReflection:Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    .line 146
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {p1, v0}, Lcom/amazon/android/webkit/AmazonWebView;->addView(Landroid/view/View;)V

    .line 147
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;IIIIIIIIZ)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;
    .param p1, "x1"    # I
    .param p2, "x2"    # I
    .param p3, "x3"    # I
    .param p4, "x4"    # I
    .param p5, "x5"    # I
    .param p6, "x6"    # I
    .param p7, "x7"    # I
    .param p8, "x8"    # I
    .param p9, "x9"    # Z

    .prologue
    .line 64
    invoke-virtual/range {p0 .. p9}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->onWebViewOverScrollBy(IIIIIIIIZ)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;IIII)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;
    .param p1, "x1"    # I
    .param p2, "x2"    # I
    .param p3, "x3"    # I
    .param p4, "x4"    # I

    .prologue
    .line 64
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->onWebViewScrolling(IIII)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;II)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;
    .param p1, "x1"    # I
    .param p2, "x2"    # I

    .prologue
    .line 64
    invoke-virtual {p0, p1, p2}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->onWebViewScrollChanged(II)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;Landroid/view/MotionEvent;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;
    .param p1, "x1"    # Landroid/view/MotionEvent;

    .prologue
    .line 64
    invoke-virtual {p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->onWebViewTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method private convertWebBackForwardList(Landroid/webkit/WebBackForwardList;)Lcom/amazon/android/webkit/AmazonWebBackForwardList;
    .locals 10
    .param p1, "list"    # Landroid/webkit/WebBackForwardList;

    .prologue
    .line 438
    if-nez p1, :cond_0

    .line 439
    const/4 v0, 0x0

    .line 450
    :goto_0
    return-object v0

    .line 441
    :cond_0
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 442
    .local v7, "historyItems":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/android/webkit/AmazonWebHistoryItem;>;"
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_1
    invoke-virtual {p1}, Landroid/webkit/WebBackForwardList;->getSize()I

    move-result v0

    if-ge v8, v0, :cond_1

    .line 443
    invoke-virtual {p1, v8}, Landroid/webkit/WebBackForwardList;->getItemAtIndex(I)Landroid/webkit/WebHistoryItem;

    move-result-object v9

    .line 446
    .local v9, "item":Landroid/webkit/WebHistoryItem;
    new-instance v0, Lcom/amazon/android/webkit/AmazonWebHistoryItem;

    invoke-virtual {v9}, Landroid/webkit/WebHistoryItem;->getFavicon()Landroid/graphics/Bitmap;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v9}, Landroid/webkit/WebHistoryItem;->getOriginalUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9}, Landroid/webkit/WebHistoryItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v9}, Landroid/webkit/WebHistoryItem;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v9}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebHistoryItemFlattenedData(Landroid/webkit/WebHistoryItem;)[B

    move-result-object v6

    invoke-direct/range {v0 .. v6}, Lcom/amazon/android/webkit/AmazonWebHistoryItem;-><init>(Landroid/graphics/Bitmap;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 442
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 450
    .end local v9    # "item":Landroid/webkit/WebHistoryItem;
    :cond_1
    new-instance v0, Lcom/amazon/android/webkit/AmazonWebBackForwardList;

    invoke-virtual {p1}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v1

    invoke-direct {v0, v7, v1}, Lcom/amazon/android/webkit/AmazonWebBackForwardList;-><init>(Ljava/util/List;I)V

    goto :goto_0
.end method

.method private getWebHistoryItemFlattenedData(Landroid/webkit/WebHistoryItem;)[B
    .locals 4
    .param p1, "item"    # Landroid/webkit/WebHistoryItem;

    .prologue
    .line 422
    sget-object v1, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->WEB_HISTORY_ITEM_DATA_FIELD:Ljava/lang/reflect/Field;

    if-nez v1, :cond_0

    .line 423
    const-class v1, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Method not supported in Android WebView"

    new-instance v3, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v3}, Ljava/lang/UnsupportedOperationException;-><init>()V

    invoke-static {v1, v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 424
    const/4 v1, 0x0

    .line 428
    :goto_0
    return-object v1

    :cond_0
    :try_start_0
    sget-object v1, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->WEB_HISTORY_ITEM_DATA_FIELD:Ljava/lang/reflect/Field;

    invoke-virtual {v1, p1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    check-cast v1, [B
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 429
    :catch_0
    move-exception v0

    .line 430
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 431
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v0

    .line 432
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;
    .locals 3

    .prologue
    .line 905
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewReflection:Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    if-nez v0, :cond_0

    .line 906
    const-class v0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Method not supported in Android WebView"

    new-instance v2, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v2}, Ljava/lang/UnsupportedOperationException;-><init>()V

    invoke-static {v0, v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 909
    :cond_0
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewReflection:Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    return-object v0
.end method


# virtual methods
.method public addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "interfaceName"    # Ljava/lang/String;

    .prologue
    .line 391
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 392
    return-void
.end method

.method public canGoBack()Z
    .locals 1

    .prologue
    .line 290
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    return v0
.end method

.method public canScrollHorizontally(I)Z
    .locals 1
    .param p1, "direction"    # I

    .prologue
    .line 876
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->canScrollHorizontally(I)Z

    move-result v0

    return v0
.end method

.method public canScrollVertically(I)Z
    .locals 1
    .param p1, "direction"    # I

    .prologue
    .line 881
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->canScrollVertically(I)Z

    move-result v0

    return v0
.end method

.method public clearFormData()V
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->clearFormData()V

    .line 316
    return-void
.end method

.method public computeScroll()V
    .locals 1

    .prologue
    .line 586
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->computeScroll()V

    .line 587
    return-void
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->destroy()V

    .line 301
    return-void
.end method

.method public getCertificate()Landroid/net/http/SslCertificate;
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getCertificate()Landroid/net/http/SslCertificate;

    move-result-object v0

    return-object v0
.end method

.method public getContentHeight()I
    .locals 1

    .prologue
    .line 601
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getContentHeight()I

    move-result v0

    return v0
.end method

.method public getFavicon()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getFavicon()Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public getHitTestResult()Lcom/amazon/android/webkit/AmazonWebView$HitTestResult;
    .locals 4

    .prologue
    .line 497
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getHitTestResult()Landroid/webkit/WebView$HitTestResult;

    move-result-object v0

    .line 499
    .local v0, "result":Landroid/webkit/WebView$HitTestResult;
    new-instance v1, Lcom/amazon/android/webkit/AmazonWebView$HitTestResult;

    invoke-virtual {v0}, Landroid/webkit/WebView$HitTestResult;->getType()I

    move-result v2

    invoke-virtual {v0}, Landroid/webkit/WebView$HitTestResult;->getExtra()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazon/android/webkit/AmazonWebView$HitTestResult;-><init>(ILjava/lang/String;)V

    return-object v1
.end method

.method public getOriginalUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getOriginalUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getProgress()I
    .locals 1

    .prologue
    .line 529
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getProgress()I

    move-result v0

    return v0
.end method

.method public getScale()F
    .locals 1

    .prologue
    .line 606
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getScale()F

    move-result v0

    return v0
.end method

.method public getScrollBarStyle()I
    .locals 1

    .prologue
    .line 722
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getScrollBarStyle()I

    move-result v0

    return v0
.end method

.method public getSettings()Lcom/amazon/android/webkit/AmazonWebSettings;
    .locals 1

    .prologue
    .line 504
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webSettings:Lcom/amazon/android/webkit/AmazonWebSettings;

    return-object v0
.end method

.method public getSolidColor()I
    .locals 1

    .prologue
    .line 509
    iget v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->solidColor:I

    return v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTouchIconUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 325
    invoke-direct {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v0

    if-nez v0, :cond_0

    .line 326
    const/4 v0, 0x0

    .line 328
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/android/AndroidWebViewReflection;->getTouchIconUrl()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVerticalScrollOffset()I
    .locals 1

    .prologue
    .line 763
    invoke-direct {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v0

    if-nez v0, :cond_0

    .line 764
    const/4 v0, 0x0

    .line 766
    :goto_0
    return v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/android/AndroidWebViewReflection;->getVerticalScrollOffset()I

    move-result v0

    goto :goto_0
.end method

.method public goBack()V
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->goBack()V

    .line 180
    return-void
.end method

.method public isHorizontalScrollBarEnabled()Z
    .locals 1

    .prologue
    .line 742
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->isHorizontalScrollBarEnabled()Z

    move-result v0

    return v0
.end method

.method public isVerticalScrollBarEnabled()Z
    .locals 1

    .prologue
    .line 747
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->isVerticalScrollBarEnabled()Z

    move-result v0

    return v0
.end method

.method public loadUrl(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 151
    invoke-virtual {p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->onUrlLoadRequested(Ljava/lang/String;)V

    .line 152
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 153
    return-void
.end method

.method public onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;
    .locals 1
    .param p1, "outAttrs"    # Landroid/view/inputmethod/EditorInfo;

    .prologue
    .line 616
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;

    move-result-object v0

    return-object v0
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .prologue
    .line 621
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 622
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 1
    .param p1, "info"    # Landroid/view/accessibility/AccessibilityNodeInfo;

    .prologue
    .line 626
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 627
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 830
    const/4 v0, 0x0

    return v0
.end method

.method public onWindowFocusChanged(Z)V
    .locals 1
    .param p1, "hasWindowFocus"    # Z

    .prologue
    .line 631
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->onWindowFocusChanged(Z)V

    .line 632
    return-void
.end method

.method public pauseTimers()V
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->pauseTimers()V

    .line 232
    return-void
.end method

.method public performAccessibilityAction(ILandroid/os/Bundle;)Z
    .locals 1
    .param p1, "action"    # I
    .param p2, "arguments"    # Landroid/os/Bundle;

    .prologue
    .line 656
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/WebView;->performAccessibilityAction(ILandroid/os/Bundle;)Z

    move-result v0

    return v0
.end method

.method public performLongClick()Z
    .locals 1

    .prologue
    .line 661
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->performLongClick()Z

    move-result v0

    return v0
.end method

.method public reload()V
    .locals 1

    .prologue
    .line 163
    invoke-virtual {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->onUrlLoadRequested(Ljava/lang/String;)V

    .line 164
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->reload()V

    .line 165
    return-void
.end method

.method public requestFocus(ILandroid/graphics/Rect;)Z
    .locals 1
    .param p1, "direction"    # I
    .param p2, "previouslyFocusedRect"    # Landroid/graphics/Rect;

    .prologue
    .line 666
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/WebView;->requestFocus(ILandroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method

.method public restoreState(Landroid/os/Bundle;)Lcom/amazon/android/webkit/AmazonWebBackForwardList;
    .locals 1
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    .line 461
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->restoreState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->convertWebBackForwardList(Landroid/webkit/WebBackForwardList;)Lcom/amazon/android/webkit/AmazonWebBackForwardList;

    move-result-object v0

    return-object v0
.end method

.method public resumeTimers()V
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->resumeTimers()V

    .line 237
    return-void
.end method

.method public saveState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    .line 285
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->saveState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    .line 286
    return-void
.end method

.method public scrollBy(II)V
    .locals 1
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 886
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/WebView;->scrollBy(II)V

    .line 887
    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 686
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setBackgroundColor(I)V

    .line 687
    return-void
.end method

.method public setCertificate(Landroid/net/http/SslCertificate;)V
    .locals 1
    .param p1, "certificate"    # Landroid/net/http/SslCertificate;

    .prologue
    .line 691
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setCertificate(Landroid/net/http/SslCertificate;)V

    .line 692
    return-void
.end method

.method public setContentDescription(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "contentDescription"    # Ljava/lang/CharSequence;

    .prologue
    .line 891
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 892
    return-void
.end method

.method public setDownloadDelegate(Lcom/amazon/android/webkit/AmazonDownloadDelegate;)V
    .locals 2
    .param p1, "delegate"    # Lcom/amazon/android/webkit/AmazonDownloadDelegate;

    .prologue
    .line 813
    const/4 v0, 0x0

    .line 814
    .local v0, "androidListener":Landroid/webkit/DownloadListener;
    if-eqz p1, :cond_0

    .line 815
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$5;

    .end local v0    # "androidListener":Landroid/webkit/DownloadListener;
    invoke-direct {v0, p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$5;-><init>(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;Lcom/amazon/android/webkit/AmazonDownloadDelegate;)V

    .line 825
    .restart local v0    # "androidListener":Landroid/webkit/DownloadListener;
    :cond_0
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->setDownloadListener(Landroid/webkit/DownloadListener;)V

    .line 826
    return-void
.end method

.method public setDownloadListener(Lcom/amazon/android/webkit/AmazonDownloadListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonDownloadListener;

    .prologue
    .line 406
    const/4 v0, 0x0

    .line 407
    .local v0, "androidListener":Landroid/webkit/DownloadListener;
    if-eqz p1, :cond_0

    .line 408
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$2;

    .end local v0    # "androidListener":Landroid/webkit/DownloadListener;
    invoke-direct {v0, p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$2;-><init>(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;Lcom/amazon/android/webkit/AmazonDownloadListener;)V

    .line 418
    .restart local v0    # "androidListener":Landroid/webkit/DownloadListener;
    :cond_0
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->setDownloadListener(Landroid/webkit/DownloadListener;)V

    .line 419
    return-void
.end method

.method public setFindIsUp(Z)V
    .locals 1
    .param p1, "isUp"    # Z

    .prologue
    .line 339
    invoke-direct {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 340
    invoke-direct {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewReflection;->setFindIsUp(Z)V

    .line 341
    :cond_0
    return-void
.end method

.method public setFindListener(Lcom/amazon/android/webkit/AmazonFindListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonFindListener;

    .prologue
    .line 257
    invoke-direct {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 258
    invoke-direct {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewReflection;->setFindListener(Lcom/amazon/android/webkit/AmazonFindListener;)V

    .line 259
    :cond_0
    return-void
.end method

.method public setHorizontalScrollBarEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 732
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setHorizontalScrollBarEnabled(Z)V

    .line 733
    return-void
.end method

.method public setHorizontalScrollbarOverlay(Z)V
    .locals 1
    .param p1, "overlay"    # Z

    .prologue
    .line 696
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setHorizontalScrollbarOverlay(Z)V

    .line 697
    return-void
.end method

.method public setInitialScale(I)V
    .locals 1
    .param p1, "scaleInPercent"    # I

    .prologue
    .line 701
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setInitialScale(I)V

    .line 702
    return-void
.end method

.method public setLayerType(ILandroid/graphics/Paint;)Z
    .locals 1
    .param p1, "layerType"    # I
    .param p2, "paint"    # Landroid/graphics/Paint;

    .prologue
    .line 706
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/WebView;->setLayerType(ILandroid/graphics/Paint;)V

    .line 707
    const/4 v0, 0x1

    return v0
.end method

.method public setMapTrackballToArrowKeys(Z)V
    .locals 1
    .param p1, "setMap"    # Z

    .prologue
    .line 712
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setMapTrackballToArrowKeys(Z)V

    .line 713
    return-void
.end method

.method public setNetworkAvailable(Z)V
    .locals 1
    .param p1, "flg"    # Z

    .prologue
    .line 221
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setNetworkAvailable(Z)V

    .line 222
    return-void
.end method

.method public setOnKeyListener(Landroid/view/View$OnKeyListener;)V
    .locals 1
    .param p1, "l"    # Landroid/view/View$OnKeyListener;

    .prologue
    .line 835
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 836
    return-void
.end method

.method public setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    .locals 1
    .param p1, "l"    # Landroid/view/View$OnTouchListener;

    .prologue
    .line 896
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 897
    return-void
.end method

.method public setOverScrollMode(I)V
    .locals 1
    .param p1, "overScrollMode"    # I

    .prologue
    .line 772
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    if-eqz v0, :cond_0

    .line 773
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setOverScrollMode(I)V

    .line 775
    :cond_0
    return-void
.end method

.method public setScrollBarStyle(I)V
    .locals 1
    .param p1, "style"    # I

    .prologue
    .line 717
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setScrollBarStyle(I)V

    .line 718
    return-void
.end method

.method public setSelectPopupHandler(Lcom/amazon/android/webkit/AmazonSelectPopupHandler;)V
    .locals 1
    .param p1, "handler"    # Lcom/amazon/android/webkit/AmazonSelectPopupHandler;

    .prologue
    .line 840
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public setVerticalScrollBarEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 737
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setVerticalScrollBarEnabled(Z)V

    .line 738
    return-void
.end method

.method public setVerticalScrollbarOverlay(Z)V
    .locals 1
    .param p1, "overlay"    # Z

    .prologue
    .line 727
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setVerticalScrollbarOverlay(Z)V

    .line 728
    return-void
.end method

.method public setWebBackForwardListClient(Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;)V
    .locals 2
    .param p1, "client"    # Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;

    .prologue
    .line 467
    invoke-direct {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v1

    if-nez v1, :cond_0

    .line 493
    :goto_0
    return-void

    .line 470
    :cond_0
    const/4 v0, 0x0

    .line 471
    .local v0, "androidClient":Landroid/webkit/WebBackForwardListClient;
    if-eqz p1, :cond_1

    .line 472
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$3;

    .end local v0    # "androidClient":Landroid/webkit/WebBackForwardListClient;
    invoke-direct {v0, p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$3;-><init>(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;Lcom/amazon/android/webkit/AmazonWebBackForwardListClient;)V

    .line 492
    .restart local v0    # "androidClient":Landroid/webkit/WebBackForwardListClient;
    :cond_1
    invoke-direct {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebViewReflection()Lcom/amazon/android/webkit/android/AndroidWebViewReflection;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/android/webkit/android/AndroidWebViewReflection;->setWebBackForwardListClient(Landroid/webkit/WebBackForwardListClient;)V

    goto :goto_0
.end method

.method public setWebChromeClient(Lcom/amazon/android/webkit/AmazonWebChromeClient;)V
    .locals 3
    .param p1, "client"    # Lcom/amazon/android/webkit/AmazonWebChromeClient;

    .prologue
    .line 401
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    new-instance v1, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;

    invoke-virtual {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebView()Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;-><init>(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonWebChromeClient;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 402
    return-void
.end method

.method public setWebViewClient(Lcom/amazon/android/webkit/AmazonWebViewClient;)V
    .locals 2
    .param p1, "webViewClient"    # Lcom/amazon/android/webkit/AmazonWebViewClient;

    .prologue
    .line 169
    const/4 v0, 0x0

    .line 170
    .local v0, "androidClient":Landroid/webkit/WebViewClient;
    if-eqz p1, :cond_0

    .line 171
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebViewClient;

    .end local v0    # "androidClient":Landroid/webkit/WebViewClient;
    invoke-virtual {p0}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->getWebView()Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewClient;-><init>(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonWebViewClient;)V

    .line 174
    .restart local v0    # "androidClient":Landroid/webkit/WebViewClient;
    :cond_0
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 175
    return-void
.end method

.method public setZOrderOverlay(Z)V
    .locals 0
    .param p1, "shouldOverlay"    # Z

    .prologue
    .line 902
    return-void
.end method

.method public shouldDelayChildPressedState()Z
    .locals 1

    .prologue
    .line 867
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->shouldDelayChildPressedState()Z

    move-result v0

    return v0
.end method

.method public stopLoading()V
    .locals 1

    .prologue
    .line 280
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->webviewDelegate:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->stopLoading()V

    .line 281
    return-void
.end method
