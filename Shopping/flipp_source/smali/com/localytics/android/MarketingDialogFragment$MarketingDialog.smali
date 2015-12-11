.class final Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;
.super Landroid/app/Dialog;
.source "SourceFile"


# static fields
.field private static final LOCATION_BOTTOM:Ljava/lang/String; = "bottom"

.field private static final LOCATION_CENTER:Ljava/lang/String; = "center"

.field private static final LOCATION_FULL:Ljava/lang/String; = "full"

.field private static final LOCATION_TOP:Ljava/lang/String; = "top"

.field private static final MARGIN:I = 0xa

.field private static final MAX_BANNER_WIDTH_DIP:I = 0x168


# instance fields
.field private mAnimBottomIn:Landroid/view/animation/TranslateAnimation;

.field private mAnimBottomOut:Landroid/view/animation/TranslateAnimation;

.field private mAnimCenterIn:Landroid/view/animation/TranslateAnimation;

.field private mAnimCenterOut:Landroid/view/animation/TranslateAnimation;

.field private mAnimFullIn:Landroid/view/animation/TranslateAnimation;

.field private mAnimFullOut:Landroid/view/animation/TranslateAnimation;

.field private mAnimTopIn:Landroid/view/animation/TranslateAnimation;

.field private mAnimTopOut:Landroid/view/animation/TranslateAnimation;

.field private mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

.field private mDialogLayout:Landroid/widget/RelativeLayout;

.field private mHeight:F

.field private mLocation:Ljava/lang/String;

.field private mMetrics:Landroid/util/DisplayMetrics;

.field private mRootLayout:Landroid/widget/RelativeLayout;

.field private mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

.field private mWidth:F

.field final synthetic this$0:Lcom/localytics/android/MarketingDialogFragment;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingDialogFragment;Landroid/content/Context;I)V
    .locals 2

    .prologue
    .line 700
    iput-object p1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    .line 701
    invoke-direct {p0, p2, p3}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 704
    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;
    invoke-static {p1}, Lcom/localytics/android/MarketingDialogFragment;->access$200(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingMessage;

    move-result-object v0

    if-nez v0, :cond_0

    .line 706
    invoke-virtual {p1}, Lcom/localytics/android/MarketingDialogFragment;->dismiss()V

    .line 736
    :goto_0
    return-void

    .line 709
    :cond_0
    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;
    invoke-static {p1}, Lcom/localytics/android/MarketingDialogFragment;->access$200(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingMessage;

    move-result-object v0

    const-string v1, "location"

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mLocation:Ljava/lang/String;

    .line 711
    invoke-direct {p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->setupViews()V

    .line 712
    invoke-direct {p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->createAnimations()V

    .line 713
    invoke-direct {p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->adjustLayout()V

    .line 720
    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;
    invoke-static {p1}, Lcom/localytics/android/MarketingDialogFragment;->access$200(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingMessage;

    move-result-object v0

    const-string v1, "html_url"

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 721
    if-eqz v0, :cond_1

    .line 723
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    invoke-virtual {v1, v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0

    .line 727
    :cond_1
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v1, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$1;

    invoke-direct {v1, p0, p1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$1;-><init>(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;Lcom/localytics/android/MarketingDialogFragment;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method static synthetic access$100(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;
    .locals 1

    .prologue
    .line 609
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/view/animation/TranslateAnimation;
    .locals 1

    .prologue
    .line 609
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimBottomOut:Landroid/view/animation/TranslateAnimation;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/util/DisplayMetrics;
    .locals 1

    .prologue
    .line 609
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)F
    .locals 1

    .prologue
    .line 609
    iget v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWidth:F

    return v0
.end method

.method static synthetic access$1400(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)F
    .locals 1

    .prologue
    .line 609
    iget v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mHeight:F

    return v0
.end method

.method static synthetic access$600(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/view/animation/TranslateAnimation;
    .locals 1

    .prologue
    .line 609
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimCenterOut:Landroid/view/animation/TranslateAnimation;

    return-object v0
.end method

.method static synthetic access$700(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 609
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$800(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/view/animation/TranslateAnimation;
    .locals 1

    .prologue
    .line 609
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimFullOut:Landroid/view/animation/TranslateAnimation;

    return-object v0
.end method

.method static synthetic access$900(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/view/animation/TranslateAnimation;
    .locals 1

    .prologue
    .line 609
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimTopOut:Landroid/view/animation/TranslateAnimation;

    return-object v0
.end method

.method private adjustLayout()V
    .locals 11
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/16 v10, 0x400

    const/16 v5, 0x20

    const/4 v6, 0x0

    const/4 v9, 0x0

    const/high16 v8, 0x3f000000    # 0.5f

    .line 880
    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    .line 881
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment;->getActivity()Landroid/support/v4/app/ac;

    move-result-object v0

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/ac;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 882
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    invoke-virtual {v0, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 885
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$200(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingMessage;

    move-result-object v0

    const-string v1, "display_width"

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    iput v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWidth:F

    .line 886
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$200(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingMessage;

    move-result-object v0

    const-string v1, "display_height"

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    iput v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mHeight:F

    .line 889
    iget v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mHeight:F

    iget v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWidth:F

    div-float v1, v0, v1

    .line 890
    const/high16 v0, 0x43b40000    # 360.0f

    iget-object v2, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v0, v2

    iget-object v2, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    iget v2, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    iget-object v3, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    iget v3, v3, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    int-to-float v2, v2

    invoke-static {v0, v2}, Ljava/lang/Math;->min(FF)F

    move-result v2

    .line 895
    invoke-virtual {p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->getWindow()Landroid/view/Window;

    move-result-object v3

    .line 896
    invoke-virtual {v3}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 898
    new-instance v4, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v4, v9}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v3, v4}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 899
    invoke-virtual {v3, v5, v5}, Landroid/view/Window;->setFlags(II)V

    .line 902
    iget-object v4, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mLocation:Ljava/lang/String;

    const-string v5, "center"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 905
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget-object v4, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    iget v4, v4, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-virtual {v3, v0, v4}, Landroid/view/Window;->setLayout(II)V

    .line 907
    const/high16 v0, 0x41200000    # 10.0f

    iget-object v4, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v0, v4

    add-float/2addr v0, v8

    float-to-int v4, v0

    .line 908
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 909
    shl-int/lit8 v5, v4, 0x1

    int-to-float v5, v5

    sub-float v5, v2, v5

    iget v6, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWidth:F

    iget-object v7, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    iget v7, v7, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v6, v7

    add-float/2addr v6, v8

    float-to-int v6, v6

    int-to-float v6, v6

    invoke-static {v5, v6}, Ljava/lang/Math;->min(FF)F

    move-result v5

    float-to-int v5, v5

    shl-int/lit8 v6, v4, 0x1

    add-int/2addr v5, v6

    iput v5, v0, Landroid/view/ViewGroup$MarginLayoutParams;->width:I

    .line 910
    shl-int/lit8 v5, v4, 0x1

    int-to-float v5, v5

    sub-float/2addr v2, v5

    iget v5, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWidth:F

    iget-object v6, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v5, v6

    add-float/2addr v5, v8

    float-to-int v5, v5

    int-to-float v5, v5

    invoke-static {v2, v5}, Ljava/lang/Math;->min(FF)F

    move-result v2

    mul-float/2addr v1, v2

    float-to-int v1, v1

    shl-int/lit8 v2, v4, 0x1

    add-int/2addr v1, v2

    iput v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->height:I

    .line 911
    invoke-virtual {v0, v4, v4, v4, v4}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    .line 912
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    invoke-virtual {v1, v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 913
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->requestLayout()V

    .line 915
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 916
    neg-int v1, v4

    invoke-virtual {v0, v9, v9, v1, v9}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 917
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    invoke-virtual {v1, v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 918
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;->requestLayout()V

    .line 944
    :cond_0
    :goto_0
    invoke-virtual {v3, v10, v10}, Landroid/view/Window;->setFlags(II)V

    .line 945
    return-void

    .line 921
    :cond_1
    iget-object v4, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mLocation:Ljava/lang/String;

    const-string v5, "full"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 924
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;

    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-virtual {v3, v0, v1}, Landroid/view/Window;->setLayout(II)V

    goto :goto_0

    .line 927
    :cond_2
    iget-object v4, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mLocation:Ljava/lang/String;

    const-string v5, "top"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 929
    const v4, -0xfffffff

    iput v4, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 930
    iput v6, v0, Landroid/view/WindowManager$LayoutParams;->dimAmount:F

    .line 932
    float-to-int v0, v2

    mul-float/2addr v1, v2

    add-float/2addr v1, v8

    float-to-int v1, v1

    invoke-virtual {v3, v0, v1}, Landroid/view/Window;->setLayout(II)V

    goto :goto_0

    .line 935
    :cond_3
    iget-object v4, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mLocation:Ljava/lang/String;

    const-string v5, "bottom"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 937
    const v4, 0xfffffff

    iput v4, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 938
    iput v6, v0, Landroid/view/WindowManager$LayoutParams;->dimAmount:F

    .line 940
    float-to-int v0, v2

    mul-float/2addr v1, v2

    add-float/2addr v1, v8

    float-to-int v1, v1

    invoke-virtual {v3, v0, v1}, Landroid/view/Window;->setLayout(II)V

    goto :goto_0
.end method

.method private createAnimations()V
    .locals 9

    .prologue
    .line 788
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x2

    const/high16 v6, 0x3f800000    # 1.0f

    const/4 v7, 0x2

    const/4 v8, 0x0

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimCenterIn:Landroid/view/animation/TranslateAnimation;

    .line 789
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimCenterIn:Landroid/view/animation/TranslateAnimation;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 790
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x2

    const/4 v6, 0x0

    const/4 v7, 0x2

    const/high16 v8, 0x3f800000    # 1.0f

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimCenterOut:Landroid/view/animation/TranslateAnimation;

    .line 791
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimCenterOut:Landroid/view/animation/TranslateAnimation;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 793
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x2

    const/high16 v6, -0x40800000    # -1.0f

    const/4 v7, 0x2

    const/4 v8, 0x0

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimTopIn:Landroid/view/animation/TranslateAnimation;

    .line 794
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimTopIn:Landroid/view/animation/TranslateAnimation;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 795
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x2

    const/4 v6, 0x0

    const/4 v7, 0x2

    const/high16 v8, -0x40800000    # -1.0f

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimTopOut:Landroid/view/animation/TranslateAnimation;

    .line 796
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimTopOut:Landroid/view/animation/TranslateAnimation;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 798
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x2

    const/high16 v6, 0x3f800000    # 1.0f

    const/4 v7, 0x2

    const/4 v8, 0x0

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimBottomIn:Landroid/view/animation/TranslateAnimation;

    .line 799
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimBottomIn:Landroid/view/animation/TranslateAnimation;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 800
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x2

    const/4 v6, 0x0

    const/4 v7, 0x2

    const/high16 v8, 0x3f800000    # 1.0f

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimBottomOut:Landroid/view/animation/TranslateAnimation;

    .line 801
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimBottomOut:Landroid/view/animation/TranslateAnimation;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 803
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x2

    const/high16 v6, 0x3f800000    # 1.0f

    const/4 v7, 0x2

    const/4 v8, 0x0

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimFullIn:Landroid/view/animation/TranslateAnimation;

    .line 804
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimFullIn:Landroid/view/animation/TranslateAnimation;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 805
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/4 v1, 0x2

    const/4 v2, 0x0

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x2

    const/4 v6, 0x0

    const/4 v7, 0x2

    const/high16 v8, 0x3f800000    # 1.0f

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimFullOut:Landroid/view/animation/TranslateAnimation;

    .line 806
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimFullOut:Landroid/view/animation/TranslateAnimation;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 808
    new-instance v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$3;

    invoke-direct {v0, p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$3;-><init>(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)V

    .line 838
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimCenterOut:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 839
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimTopOut:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 840
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimBottomOut:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 841
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimFullOut:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 843
    new-instance v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$4;

    invoke-direct {v0, p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$4;-><init>(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)V

    .line 870
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimCenterIn:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 871
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimTopIn:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 872
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimBottomIn:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 873
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimFullIn:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v1, v0}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 874
    return-void
.end method

.method private setupViews()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, -0x2

    .line 741
    new-instance v0, Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    .line 742
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 743
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    const-string v1, "amp_view"

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 744
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 747
    new-instance v0, Landroid/widget/RelativeLayout;

    invoke-virtual {p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mDialogLayout:Landroid/widget/RelativeLayout;

    .line 748
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 749
    const/16 v1, 0xd

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 750
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mDialogLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 751
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mDialogLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 754
    new-instance v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    invoke-virtual {p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p0, v1, v3}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;-><init>(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    .line 755
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->setId(I)V

    .line 756
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mDialogLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 759
    new-instance v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    invoke-virtual {p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p0, v1, v3}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;-><init>(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    .line 760
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    new-instance v1, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$2;

    invoke-direct {v1, p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$2;-><init>(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)V

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 770
    # getter for: Lcom/localytics/android/MarketingDialogFragment;->dismissButtonLocation:Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;
    invoke-static {}, Lcom/localytics/android/MarketingDialogFragment;->access$400()Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;

    move-result-object v0

    sget-object v1, Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;->RIGHT:Lcom/localytics/android/Localytics$InAppMessageDismissButtonLocation;

    if-ne v0, v1, :cond_0

    .line 772
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 773
    const/4 v1, 0x7

    iget-object v2, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWebView:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    invoke-virtual {v2}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->getId()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 774
    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    invoke-virtual {v1, v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 776
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mDialogLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 778
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->requestWindowFeature(I)Z

    .line 780
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {p0, v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->setContentView(Landroid/view/View;)V

    .line 781
    return-void
.end method


# virtual methods
.method final dismissWithAnimation()V
    .locals 2

    .prologue
    .line 953
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v1, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;

    invoke-direct {v1, p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$5;-><init>(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 982
    return-void
.end method

.method final enterWithAnimation()V
    .locals 2

    .prologue
    .line 989
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$200(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingMessage;

    move-result-object v0

    const-string v1, "location"

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 992
    const-string v1, "center"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 994
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimCenterIn:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 1011
    :cond_0
    :goto_0
    return-void

    .line 997
    :cond_1
    const-string v1, "full"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 999
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimFullIn:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 1002
    :cond_2
    const-string v1, "top"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1004
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimTopIn:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 1007
    :cond_3
    const-string v1, "bottom"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1009
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mAnimBottomIn:Landroid/view/animation/TranslateAnimation;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0
.end method

.method public final onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2

    .prologue
    .line 1026
    const/4 v0, 0x4

    if-ne p1, v0, :cond_1

    .line 1028
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mExitAnimatable:Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$300(Lcom/localytics/android/MarketingDialogFragment;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1030
    invoke-virtual {p0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->dismissWithAnimation()V

    .line 1032
    :cond_0
    const/4 v0, 0x1

    .line 1034
    :goto_0
    return v0

    :cond_1
    invoke-super {p0, p1, p2}, Landroid/app/Dialog;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected final onStop()V
    .locals 1

    .prologue
    .line 1016
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    if-eqz v0, :cond_0

    .line 1018
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mBtnClose:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$CloseButton;->release()V

    .line 1020
    :cond_0
    invoke-super {p0}, Landroid/app/Dialog;->onStop()V

    .line 1021
    return-void
.end method
