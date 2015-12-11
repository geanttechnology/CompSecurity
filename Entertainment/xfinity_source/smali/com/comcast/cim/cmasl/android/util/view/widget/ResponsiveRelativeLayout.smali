.class public Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
.super Landroid/widget/RelativeLayout;
.source "ResponsiveRelativeLayout.java"


# instance fields
.field private adjustForActionBar:Z

.field statusBarHeight:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 15
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->adjustForActionBar:Z

    .line 23
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->init()V

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 27
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 15
    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->adjustForActionBar:Z

    .line 28
    sget-object v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_ResponsiveRelativeLayout:[I

    invoke-virtual {p1, p2, v1, v2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 30
    .local v0, "ta":Landroid/content/res/TypedArray;
    :try_start_0
    sget v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_ResponsiveRelativeLayout_adjustForActionBar:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->adjustForActionBar:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 32
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 34
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->init()V

    .line 35
    return-void

    .line 32
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

    .line 38
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 15
    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->adjustForActionBar:Z

    .line 39
    sget-object v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_ResponsiveRelativeLayout:[I

    invoke-virtual {p1, p2, v1, v2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 41
    .local v0, "ta":Landroid/content/res/TypedArray;
    :try_start_0
    sget v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_ResponsiveRelativeLayout_adjustForActionBar:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->adjustForActionBar:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 43
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 45
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->init()V

    .line 46
    return-void

    .line 43
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
    .line 50
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 51
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->requestFitSystemWindows()V

    .line 53
    :cond_0
    return-void
.end method


# virtual methods
.method public adjustForFullScreen()V
    .locals 5

    .prologue
    .line 75
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 76
    .local v0, "params":Landroid/view/ViewGroup$MarginLayoutParams;
    iget v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    iget v2, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    iget v3, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->statusBarHeight:I

    sub-int/2addr v2, v3

    iget v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    iget v4, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    .line 77
    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 78
    return-void
.end method

.method public adjustForStatusBar()V
    .locals 5

    .prologue
    .line 81
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 82
    .local v0, "params":Landroid/view/ViewGroup$MarginLayoutParams;
    iget v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    iget v2, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    iget v3, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->statusBarHeight:I

    add-int/2addr v2, v3

    iget v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    iget v4, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    .line 83
    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 84
    return-void
.end method

.method public fitSystemWindows(Landroid/graphics/Rect;)Z
    .locals 6
    .param p1, "insets"    # Landroid/graphics/Rect;

    .prologue
    .line 57
    iget v1, p1, Landroid/graphics/Rect;->top:I

    .line 59
    .local v1, "insetTop":I
    iget-boolean v3, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->adjustForActionBar:Z

    if-nez v3, :cond_1

    .line 61
    new-instance v2, Landroid/util/TypedValue;

    invoke-direct {v2}, Landroid/util/TypedValue;-><init>()V

    .line 62
    .local v2, "tv":Landroid/util/TypedValue;
    const/4 v0, 0x0

    .line 63
    .local v0, "actionBarHeight":I
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v3

    const v4, 0x10102eb

    const/4 v5, 0x1

    invoke-virtual {v3, v4, v2, v5}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 64
    iget v3, v2, Landroid/util/TypedValue;->data:I

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/TypedValue;->complexToDimensionPixelSize(ILandroid/util/DisplayMetrics;)I

    move-result v0

    .line 67
    :cond_0
    sub-int v3, v1, v0

    iput v3, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->statusBarHeight:I

    .line 70
    .end local v0    # "actionBarHeight":I
    .end local v2    # "tv":Landroid/util/TypedValue;
    :cond_1
    const-string v3, "ResponsiveRelativeLayout"

    const-string v4, "fitSystemWindows"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 71
    const/4 v3, 0x0

    return v3
.end method

.method public getStatusBarHeight()I
    .locals 1

    .prologue
    .line 87
    iget v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;->statusBarHeight:I

    return v0
.end method
