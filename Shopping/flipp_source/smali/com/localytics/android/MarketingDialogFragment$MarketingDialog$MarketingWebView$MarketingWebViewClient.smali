.class final Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;
.super Landroid/webkit/WebViewClient;
.source "SourceFile"


# instance fields
.field private final mActivity:Landroid/app/Activity;

.field final synthetic this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 1080
    iput-object p1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    .line 1081
    iput-object p2, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->mActivity:Landroid/app/Activity;

    .line 1082
    return-void
.end method


# virtual methods
.method public final onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 6

    .prologue
    const/high16 v5, 0x3f000000    # 0.5f

    const/4 v1, 0x0

    .line 1093
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mMarketingMessage:Lcom/localytics/android/MarketingMessage;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$200(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/MarketingMessage;

    move-result-object v0

    const-string v2, "location"

    invoke-virtual {v0, v2}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1094
    const-string v2, "center"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/high16 v0, 0x41200000    # 10.0f

    iget-object v2, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v2, v2, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;
    invoke-static {v2}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1200(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v0, v2

    add-float/2addr v0, v5

    float-to-int v0, v0

    shl-int/lit8 v0, v0, 0x1

    .line 1095
    :goto_0
    iget-object v2, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v2, v2, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;
    invoke-static {v2}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1200(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    iget-object v3, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v3, v3, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;
    invoke-static {v3}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1200(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    sub-int/2addr v2, v0

    .line 1096
    iget-object v3, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v3, v3, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;
    invoke-static {v3}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1200(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->widthPixels:I

    iget-object v4, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v4, v4, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;
    invoke-static {v4}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1200(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    sub-int v0, v3, v0

    .line 1097
    iget-object v3, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v3, v3, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mWidth:F
    invoke-static {v3}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1300(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)F

    move-result v3

    iget-object v4, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v4, v4, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;
    invoke-static {v4}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1200(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v3, v4

    add-float/2addr v3, v5

    float-to-int v3, v3

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v3, v3, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;
    invoke-static {v3}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1200(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    div-float/2addr v2, v3

    .line 1098
    iget-object v3, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v3, v3, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mHeight:F
    invoke-static {v3}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1400(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)F

    move-result v3

    iget-object v4, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v4, v4, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;
    invoke-static {v4}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1200(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v3, v4

    add-float/2addr v3, v5

    float-to-int v3, v3

    invoke-static {v0, v3}, Ljava/lang/Math;->min(II)I

    move-result v0

    int-to-float v0, v0

    iget-object v3, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v3, v3, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mMetrics:Landroid/util/DisplayMetrics;
    invoke-static {v3}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$1200(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    div-float/2addr v0, v3

    .line 1100
    const-string v3, "javascript:(function() {  var viewportNode = document.createElement(\'meta\');  viewportNode.name    = \'viewport\';  viewportNode.content = \'width=%f, height=%f, user-scalable=no, minimum-scale=.25, maximum-scale=1\';  viewportNode.id      = \'metatag\';  document.getElementsByTagName(\'head\')[0].appendChild(viewportNode);})()"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    aput-object v2, v4, v1

    const/4 v2, 0x1

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    aput-object v0, v4, v2

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1109
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mJavaScriptClient:Lcom/localytics/android/JavaScriptClient;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$1100(Lcom/localytics/android/MarketingDialogFragment;)Lcom/localytics/android/JavaScriptClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/localytics/android/JavaScriptClient;->getJsGlueCode()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1112
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    # getter for: Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->mRootLayout:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->access$700(Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1113
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    # getter for: Lcom/localytics/android/MarketingDialogFragment;->mEnterAnimatable:Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {v0}, Lcom/localytics/android/MarketingDialogFragment;->access$1500(Lcom/localytics/android/MarketingDialogFragment;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1115
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    invoke-virtual {v0}, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->enterWithAnimation()V

    .line 1117
    :cond_0
    return-void

    :cond_1
    move v0, v1

    .line 1094
    goto/16 :goto_0
.end method

.method public final shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 2

    .prologue
    .line 1087
    iget-object v0, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->this$2:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView;->this$1:Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;

    iget-object v0, v0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog;->this$0:Lcom/localytics/android/MarketingDialogFragment;

    iget-object v1, p0, Lcom/localytics/android/MarketingDialogFragment$MarketingDialog$MarketingWebView$MarketingWebViewClient;->mActivity:Landroid/app/Activity;

    invoke-virtual {v0, p2, v1}, Lcom/localytics/android/MarketingDialogFragment;->handleUrl(Ljava/lang/String;Landroid/app/Activity;)Z

    move-result v0

    return v0
.end method
