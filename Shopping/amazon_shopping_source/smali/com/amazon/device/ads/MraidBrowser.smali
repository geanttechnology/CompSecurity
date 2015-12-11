.class Lcom/amazon/device/ads/MraidBrowser;
.super Ljava/lang/Object;
.source "MraidBrowser.java"

# interfaces
.implements Lcom/amazon/device/ads/IAdActivityAdapter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/MraidBrowser$MraidBrowserBuilder;,
        Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;
    }
.end annotation


# static fields
.field private static final BUTTON_SIZE_DP:I = 0x32

.field private static final HORIZONTAL_RULE_SIZE_DP:I = 0x3

.field protected static final LOG_TAG:Ljava/lang/String;

.field protected static final SHOW_OPEN_EXTERNAL_BROWSER_BTN:Ljava/lang/String; = "extra_open_btn"

.field protected static final URL_EXTRA:Ljava/lang/String; = "extra_url"


# instance fields
.field private activity:Landroid/app/Activity;

.field private mBrowserBackButton:Landroid/widget/ImageButton;

.field private mBrowserForwardButton:Landroid/widget/ImageButton;

.field private mCloseButton:Landroid/widget/ImageButton;

.field private mOpenExternalBrowserButton:Landroid/widget/ImageButton;

.field private mRefreshButton:Landroid/widget/ImageButton;

.field private mWebView:Landroid/webkit/WebView;

.field private showOpenExternalBrowserButton:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/amazon/device/ads/MraidBrowser;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/MraidBrowser;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 453
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/MraidBrowser;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/device/ads/MraidBrowser;Landroid/webkit/WebView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;
    .param p1, "x1"    # Landroid/webkit/WebView;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/MraidBrowser;->updateNavigationButtons(Landroid/webkit/WebView;)V

    return-void
.end method

.method static synthetic access$1000(Lcom/amazon/device/ads/MraidBrowser;Landroid/content/Intent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;
    .param p1, "x1"    # Landroid/content/Intent;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/amazon/device/ads/MraidBrowser;->initializeButtons(Landroid/content/Intent;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/device/ads/MraidBrowser;)Landroid/webkit/WebView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserBackButton:Landroid/widget/ImageButton;

    return-object v0
.end method

.method static synthetic access$302(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;
    .param p1, "x1"    # Landroid/widget/ImageButton;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserBackButton:Landroid/widget/ImageButton;

    return-object p1
.end method

.method static synthetic access$400(Lcom/amazon/device/ads/MraidBrowser;Ljava/lang/String;IIII)Landroid/widget/ImageButton;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # I
    .param p3, "x3"    # I
    .param p4, "x4"    # I
    .param p5, "x5"    # I

    .prologue
    .line 36
    invoke-direct/range {p0 .. p5}, Lcom/amazon/device/ads/MraidBrowser;->createButton(Ljava/lang/String;IIII)Landroid/widget/ImageButton;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;

    return-object v0
.end method

.method static synthetic access$502(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;
    .param p1, "x1"    # Landroid/widget/ImageButton;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;

    return-object p1
.end method

.method static synthetic access$600(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mCloseButton:Landroid/widget/ImageButton;

    return-object v0
.end method

.method static synthetic access$602(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;
    .param p1, "x1"    # Landroid/widget/ImageButton;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser;->mCloseButton:Landroid/widget/ImageButton;

    return-object p1
.end method

.method static synthetic access$700(Lcom/amazon/device/ads/MraidBrowser;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;

    .prologue
    .line 36
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidBrowser;->showOpenExternalBrowserButton:Z

    return v0
.end method

.method static synthetic access$800(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mOpenExternalBrowserButton:Landroid/widget/ImageButton;

    return-object v0
.end method

.method static synthetic access$802(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;
    .param p1, "x1"    # Landroid/widget/ImageButton;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser;->mOpenExternalBrowserButton:Landroid/widget/ImageButton;

    return-object p1
.end method

.method static synthetic access$900(Lcom/amazon/device/ads/MraidBrowser;)Landroid/widget/ImageButton;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mRefreshButton:Landroid/widget/ImageButton;

    return-object v0
.end method

.method static synthetic access$902(Lcom/amazon/device/ads/MraidBrowser;Landroid/widget/ImageButton;)Landroid/widget/ImageButton;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/ads/MraidBrowser;
    .param p1, "x1"    # Landroid/widget/ImageButton;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser;->mRefreshButton:Landroid/widget/ImageButton;

    return-object p1
.end method

.method private createButton(Ljava/lang/String;IIII)Landroid/widget/ImageButton;
    .locals 3
    .param p1, "src"    # Ljava/lang/String;
    .param p2, "verb"    # I
    .param p3, "anchor"    # I
    .param p4, "buttonWidth"    # I
    .param p5, "buttonHeight"    # I

    .prologue
    .line 129
    new-instance v0, Landroid/widget/ImageButton;

    iget-object v2, p0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-direct {v0, v2}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;)V

    .line 130
    .local v0, "button":Landroid/widget/ImageButton;
    invoke-static {p1}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 131
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v1, p4, p5}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 133
    .local v1, "params":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {v1, p2, p3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 134
    const/16 v2, 0xc

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 135
    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 136
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setBackgroundColor(I)V

    .line 137
    sget-object v2, Landroid/widget/ImageView$ScaleType;->FIT_CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 138
    return-object v0
.end method

.method private enableCookies()V
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-static {v0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 267
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->startSync()V

    .line 268
    return-void
.end method

.method private initializeButtons(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 195
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserBackButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/amazon/device/ads/MraidBrowser$3;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/MraidBrowser$3;-><init>(Lcom/amazon/device/ads/MraidBrowser;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 201
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/amazon/device/ads/MraidBrowser$4;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/MraidBrowser$4;-><init>(Lcom/amazon/device/ads/MraidBrowser;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 207
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mRefreshButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/amazon/device/ads/MraidBrowser$5;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/MraidBrowser$5;-><init>(Lcom/amazon/device/ads/MraidBrowser;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 213
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mCloseButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/amazon/device/ads/MraidBrowser$6;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/MraidBrowser$6;-><init>(Lcom/amazon/device/ads/MraidBrowser;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 219
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidBrowser;->showOpenExternalBrowserButton:Z

    if-eqz v0, :cond_0

    .line 221
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mOpenExternalBrowserButton:Landroid/widget/ImageButton;

    new-instance v1, Lcom/amazon/device/ads/MraidBrowser$7;

    invoke-direct {v1, p0, p1}, Lcom/amazon/device/ads/MraidBrowser$7;-><init>(Lcom/amazon/device/ads/MraidBrowser;Landroid/content/Intent;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 239
    :cond_0
    return-void
.end method

.method private initializeEntireView(Landroid/content/Intent;)V
    .locals 18
    .param p1, "intent"    # Landroid/content/Intent;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "InlinedApi"
        }
    .end annotation

    .prologue
    .line 75
    new-instance v10, Landroid/util/DisplayMetrics;

    invoke-direct {v10}, Landroid/util/DisplayMetrics;-><init>()V

    .line 76
    .local v10, "metrics":Landroid/util/DisplayMetrics;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    const-string/jumbo v2, "window"

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Landroid/view/WindowManager;

    .line 77
    .local v16, "wm":Landroid/view/WindowManager;
    invoke-interface/range {v16 .. v16}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1, v10}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 78
    iget v8, v10, Landroid/util/DisplayMetrics;->density:F

    .line 79
    .local v8, "mDensity":F
    const/high16 v1, 0x42480000    # 50.0f

    mul-float/2addr v1, v8

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 80
    .local v6, "buttonHeight":I
    const/high16 v1, 0x40400000    # 3.0f

    mul-float/2addr v1, v8

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v14, v1

    .line 81
    .local v14, "ruleSize":I
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/amazon/device/ads/MraidBrowser;->showOpenExternalBrowserButton:Z

    if-eqz v1, :cond_1

    const/4 v7, 0x5

    .line 82
    .local v7, "buttonCount":I
    :goto_0
    iget v1, v10, Landroid/util/DisplayMetrics;->widthPixels:I

    div-int v5, v1, v7

    .line 83
    .local v5, "buttonWidth":I
    mul-int/lit8 v1, v6, 0x2

    if-le v5, v1, :cond_0

    .line 85
    mul-int/lit8 v5, v6, 0x2

    .line 88
    :cond_0
    new-instance v4, Landroid/widget/RelativeLayout;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-direct {v4, v1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 89
    .local v4, "layout":Landroid/widget/RelativeLayout;
    const/16 v1, 0x2828

    invoke-virtual {v4, v1}, Landroid/widget/RelativeLayout;->setId(I)V

    .line 90
    new-instance v13, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v1, -0x1

    add-int v2, v6, v14

    invoke-direct {v13, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 92
    .local v13, "rp":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v1, 0xc

    invoke-virtual {v13, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 93
    invoke-virtual {v4, v13}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 94
    const v1, -0xf0f10

    invoke-virtual {v4, v1}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    .line 96
    new-instance v1, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    invoke-direct/range {v1 .. v6}, Lcom/amazon/device/ads/MraidBrowser$LoadButtonsTask;-><init>(Lcom/amazon/device/ads/MraidBrowser;Landroid/content/Intent;Landroid/view/ViewGroup;II)V

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-static {v1, v2}, Lcom/amazon/device/ads/ThreadUtils;->executeAsyncTask(Landroid/os/AsyncTask;[Ljava/lang/Object;)V

    .line 99
    new-instance v15, Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-direct {v15, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 100
    .local v15, "ruler":Landroid/view/View;
    const v1, -0x333334

    invoke-virtual {v15, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 101
    new-instance v11, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v1, -0x1

    invoke-direct {v11, v1, v14}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 102
    .local v11, "params":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v1, 0xa

    invoke-virtual {v11, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 103
    invoke-virtual {v15, v11}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 104
    invoke-virtual {v4, v15}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 106
    invoke-static {}, Lcom/amazon/device/ads/WebViewFactory;->getInstance()Lcom/amazon/device/ads/WebViewFactory;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-virtual {v1, v2}, Lcom/amazon/device/ads/WebViewFactory;->createWebView(Landroid/content/Context;)Landroid/webkit/WebView;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;

    .line 107
    new-instance v17, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v1, -0x1

    const/4 v2, -0x1

    move-object/from16 v0, v17

    invoke-direct {v0, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 109
    .local v17, "wrp":Landroid/widget/RelativeLayout$LayoutParams;
    const/4 v1, 0x2

    invoke-virtual {v4}, Landroid/widget/RelativeLayout;->getId()I

    move-result v2

    move-object/from16 v0, v17

    invoke-virtual {v0, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 110
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;

    move-object/from16 v0, v17

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 112
    new-instance v12, Landroid/widget/RelativeLayout;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-direct {v12, v1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 113
    .local v12, "rl":Landroid/widget/RelativeLayout;
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v3, -0x2

    invoke-direct {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v12, v1}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 115
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v12, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 116
    invoke-virtual {v12, v4}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 118
    new-instance v9, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-direct {v9, v1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 119
    .local v9, "mainll":Landroid/widget/LinearLayout;
    const/4 v1, 0x1

    invoke-virtual {v9, v1}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 120
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v3, -0x1

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v9, v1}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 123
    invoke-virtual {v9, v12}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 124
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-virtual {v1, v9}, Landroid/app/Activity;->setContentView(Landroid/view/View;)V

    .line 125
    return-void

    .line 81
    .end local v4    # "layout":Landroid/widget/RelativeLayout;
    .end local v5    # "buttonWidth":I
    .end local v7    # "buttonCount":I
    .end local v9    # "mainll":Landroid/widget/LinearLayout;
    .end local v11    # "params":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v12    # "rl":Landroid/widget/RelativeLayout;
    .end local v13    # "rp":Landroid/widget/RelativeLayout$LayoutParams;
    .end local v15    # "ruler":Landroid/view/View;
    .end local v17    # "wrp":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_1
    const/4 v7, 0x4

    goto/16 :goto_0
.end method

.method private initializeWebView(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 143
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;

    sget-object v2, Lcom/amazon/device/ads/MraidBrowser;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/WebViewFactory;->setJavaScriptEnabledForWebView(ZLandroid/webkit/WebView;Ljava/lang/String;)Z

    .line 145
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;

    const-string/jumbo v1, "extra_url"

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 146
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;

    new-instance v1, Lcom/amazon/device/ads/MraidBrowser$1;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/MraidBrowser$1;-><init>(Lcom/amazon/device/ads/MraidBrowser;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 180
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;

    new-instance v1, Lcom/amazon/device/ads/MraidBrowser$2;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/MraidBrowser$2;-><init>(Lcom/amazon/device/ads/MraidBrowser;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 192
    return-void
.end method

.method private updateNavigationButtons(Landroid/webkit/WebView;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;

    .prologue
    const/16 v2, 0xff

    const/16 v1, 0x66

    .line 243
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserBackButton:Landroid/widget/ImageButton;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;

    if-eqz v0, :cond_0

    .line 245
    invoke-virtual {p1}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 247
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserBackButton:Landroid/widget/ImageButton;

    invoke-static {v0, v2}, Lcom/amazon/device/ads/AndroidTargetUtils;->setImageButtonAlpha(Landroid/widget/ImageButton;I)V

    .line 254
    :goto_0
    invoke-virtual {p1}, Landroid/webkit/WebView;->canGoForward()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 256
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;

    invoke-static {v0, v2}, Lcom/amazon/device/ads/AndroidTargetUtils;->setImageButtonAlpha(Landroid/widget/ImageButton;I)V

    .line 263
    :cond_0
    :goto_1
    return-void

    .line 251
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserBackButton:Landroid/widget/ImageButton;

    invoke-static {v0, v1}, Lcom/amazon/device/ads/AndroidTargetUtils;->setImageButtonAlpha(Landroid/widget/ImageButton;I)V

    goto :goto_0

    .line 260
    :cond_2
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mBrowserForwardButton:Landroid/widget/ImageButton;

    invoke-static {v0, v1}, Lcom/amazon/device/ads/AndroidTargetUtils;->setImageButtonAlpha(Landroid/widget/ImageButton;I)V

    goto :goto_1
.end method


# virtual methods
.method protected canPauseWebViewTimers()Z
    .locals 2

    .prologue
    .line 286
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidBrowser;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    .line 287
    .local v0, "webView":Landroid/webkit/WebView;
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidBrowser;->getShouldPauseWebViewTimers()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected canResumeWebViewTimers()Z
    .locals 2

    .prologue
    .line 323
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidBrowser;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    .line 324
    .local v0, "webView":Landroid/webkit/WebView;
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidBrowser;->getShouldPauseWebViewTimers()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected getShouldPauseWebViewTimers()Z
    .locals 3

    .prologue
    .line 277
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "shouldPauseWebViewTimersInWebViewRelatedActivities"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/Settings;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method protected getWebView()Landroid/webkit/WebView;
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;

    return-object v0
.end method

.method protected isAtLeastAndroidAPI(I)Z
    .locals 1
    .param p1, "api"    # I

    .prologue
    .line 362
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCreate()V
    .locals 4

    .prologue
    const/4 v3, 0x2

    .line 62
    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/view/Window;->requestFeature(I)Z

    .line 63
    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v3, v2}, Landroid/view/Window;->setFeatureInt(II)V

    .line 65
    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 66
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "extra_open_btn"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/amazon/device/ads/MraidBrowser;->showOpenExternalBrowserButton:Z

    .line 67
    invoke-direct {p0, v0}, Lcom/amazon/device/ads/MraidBrowser;->initializeEntireView(Landroid/content/Intent;)V

    .line 68
    invoke-direct {p0, v0}, Lcom/amazon/device/ads/MraidBrowser;->initializeWebView(Landroid/content/Intent;)V

    .line 69
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidBrowser;->enableCookies()V

    .line 70
    return-void
.end method

.method public onPause()V
    .locals 3

    .prologue
    .line 296
    sget-object v1, Lcom/amazon/device/ads/MraidBrowser;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "onPause"

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidBrowser;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    .line 301
    .local v0, "webView":Landroid/webkit/WebView;
    const/16 v1, 0xb

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/MraidBrowser;->isAtLeastAndroidAPI(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 303
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidBrowser;->webViewOnPause(Landroid/webkit/WebView;)V

    .line 310
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidBrowser;->canPauseWebViewTimers()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 312
    invoke-virtual {v0}, Landroid/webkit/WebView;->pauseTimers()V

    .line 315
    :cond_0
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->stopSync()V

    .line 316
    return-void

    .line 307
    :cond_1
    sget-object v1, Lcom/amazon/device/ads/MraidBrowser;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "Unable to call WebView.onPause"

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 333
    sget-object v1, Lcom/amazon/device/ads/MraidBrowser;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "onResume"

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 335
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidBrowser;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    .line 338
    .local v0, "webView":Landroid/webkit/WebView;
    const/16 v1, 0xb

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/MraidBrowser;->isAtLeastAndroidAPI(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 340
    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidBrowser;->webViewOnResume(Landroid/webkit/WebView;)V

    .line 347
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidBrowser;->canResumeWebViewTimers()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 349
    invoke-virtual {v0}, Landroid/webkit/WebView;->resumeTimers()V

    .line 352
    :cond_0
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->startSync()V

    .line 353
    return-void

    .line 344
    :cond_1
    sget-object v1, Lcom/amazon/device/ads/MraidBrowser;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "Unable to call WebView.onResume"

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onStop()V
    .locals 0

    .prologue
    .line 388
    return-void
.end method

.method public preOnCreate()V
    .locals 0

    .prologue
    .line 448
    return-void
.end method

.method public setActivity(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;

    .line 58
    return-void
.end method

.method protected webViewOnPause(Landroid/webkit/WebView;)V
    .locals 0
    .param p1, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 371
    invoke-static {p1}, Lcom/amazon/device/ads/AndroidTargetUtils;->webViewOnPause(Landroid/webkit/WebView;)V

    .line 372
    return-void
.end method

.method protected webViewOnResume(Landroid/webkit/WebView;)V
    .locals 0
    .param p1, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 380
    invoke-static {p1}, Lcom/amazon/device/ads/AndroidTargetUtils;->webViewOnResume(Landroid/webkit/WebView;)V

    .line 381
    return-void
.end method
