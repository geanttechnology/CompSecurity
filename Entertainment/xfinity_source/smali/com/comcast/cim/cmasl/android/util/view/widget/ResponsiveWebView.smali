.class public Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;
.super Landroid/webkit/WebView;
.source "ResponsiveWebView.java"


# instance fields
.field private adjustForActionBar:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 15
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->adjustForActionBar:Z

    .line 21
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->init()V

    .line 22
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 25
    invoke-direct {p0, p1, p2}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 15
    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->adjustForActionBar:Z

    .line 26
    sget-object v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_ResponsiveWebView:[I

    invoke-virtual {p1, p2, v1, v2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 28
    .local v0, "ta":Landroid/content/res/TypedArray;
    :try_start_0
    sget v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_ResponsiveWebView_adjustForActionBar:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->adjustForActionBar:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 30
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 32
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->init()V

    .line 33
    return-void

    .line 30
    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    throw v1
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 36
    invoke-direct {p0, p1, p2, p3}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 15
    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->adjustForActionBar:Z

    .line 37
    sget-object v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_ResponsiveWebView:[I

    invoke-virtual {p1, p2, v1, v2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 39
    .local v0, "ta":Landroid/content/res/TypedArray;
    :try_start_0
    sget v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_ResponsiveWebView_adjustForActionBar:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->adjustForActionBar:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 41
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 43
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->init()V

    .line 44
    return-void

    .line 41
    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    throw v1
.end method

.method private init()V
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 48
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 49
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->requestFitSystemWindows()V

    .line 51
    :cond_0
    return-void
.end method


# virtual methods
.method protected fitSystemWindows(Landroid/graphics/Rect;)Z
    .locals 7
    .param p1, "insets"    # Landroid/graphics/Rect;

    .prologue
    .line 55
    iget v1, p1, Landroid/graphics/Rect;->top:I

    .line 57
    .local v1, "insetTop":I
    iget-boolean v4, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->adjustForActionBar:Z

    if-nez v4, :cond_1

    .line 59
    new-instance v3, Landroid/util/TypedValue;

    invoke-direct {v3}, Landroid/util/TypedValue;-><init>()V

    .line 60
    .local v3, "tv":Landroid/util/TypedValue;
    const/4 v0, 0x0

    .line 61
    .local v0, "actionBarHeight":I
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v4

    const v5, 0x10102eb

    const/4 v6, 0x1

    invoke-virtual {v4, v5, v3, v6}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 62
    iget v4, v3, Landroid/util/TypedValue;->data:I

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/TypedValue;->complexToDimensionPixelSize(ILandroid/util/DisplayMetrics;)I

    move-result v0

    .line 65
    :cond_0
    sub-int/2addr v1, v0

    .line 68
    .end local v0    # "actionBarHeight":I
    .end local v3    # "tv":Landroid/util/TypedValue;
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 69
    .local v2, "params":Landroid/view/ViewGroup$MarginLayoutParams;
    iget v4, p1, Landroid/graphics/Rect;->left:I

    iget v5, p1, Landroid/graphics/Rect;->right:I

    iget v6, p1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v2, v4, v1, v5, v6}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    .line 70
    invoke-virtual {p0, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveWebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 72
    const-string v4, "ResponsiveWebView"

    const-string v5, "fitSystemWindows"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 73
    const/4 v4, 0x0

    return v4
.end method
