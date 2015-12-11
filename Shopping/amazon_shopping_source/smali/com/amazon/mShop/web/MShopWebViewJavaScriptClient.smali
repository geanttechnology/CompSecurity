.class Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;
.super Ljava/lang/Object;
.source "MShopWebViewJavaScriptClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$MASHcallback;
    }
.end annotation


# static fields
.field public static final JAVASCRIPT_INTERFACE_NAME:Ljava/lang/String; = "webclient"


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mNavigationManager:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

.field private final mWebView:Lcom/amazon/mShop/web/MShopWebView;

.field private final mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/mShop/web/MShopWebViewContainer;Lcom/amazon/mobile/mash/nav/MASHNavDelegate;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "webViewContainer"    # Lcom/amazon/mShop/web/MShopWebViewContainer;
    .param p3, "navigationManager"    # Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 72
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;

    .line 73
    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    .line 74
    invoke-virtual {p2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/web/MShopWebView;

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    .line 75
    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mNavigationManager:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    .line 76
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 60
    invoke-direct {p0, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;
    .param p4, "x4"    # Ljava/lang/String;
    .param p5, "x5"    # Ljava/lang/String;
    .param p6, "x6"    # Ljava/lang/String;
    .param p7, "x7"    # Ljava/lang/String;

    .prologue
    .line 60
    invoke-direct/range {p0 .. p7}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->getShareChooserIntent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mShop/web/MShopWebViewContainer;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)Lcom/amazon/mobile/mash/nav/MASHNavDelegate;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mNavigationManager:Lcom/amazon/mobile/mash/nav/MASHNavDelegate;

    return-object v0
.end method

.method private getShareChooserIntent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 4
    .param p1, "messagePlain160"    # Ljava/lang/String;
    .param p2, "messagePlain140"    # Ljava/lang/String;
    .param p3, "messageHTML"    # Ljava/lang/String;
    .param p4, "messagePlain"    # Ljava/lang/String;
    .param p5, "subject"    # Ljava/lang/String;
    .param p6, "imageURL"    # Ljava/lang/String;
    .param p7, "url"    # Ljava/lang/String;

    .prologue
    .line 260
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.SEND"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 261
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "text/plain"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 263
    invoke-direct {p0, p5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 264
    const-string/jumbo v2, "android.intent.extra.SUBJECT"

    invoke-virtual {v0, v2, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 267
    :cond_0
    invoke-direct {p0, p4}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 268
    const-string/jumbo v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 271
    :cond_1
    invoke-direct {p0, p6}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 272
    const-string/jumbo v2, "imgUrl"

    invoke-virtual {v0, v2, p6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 275
    :cond_2
    invoke-direct {p0, p7}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->isDefined(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 276
    const-string/jumbo v2, "url"

    invoke-virtual {v0, v2, p7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 279
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sharing_share:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 280
    .local v1, "title":Ljava/lang/String;
    invoke-static {v0, v1}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v2

    return-object v2
.end method

.method private isDefined(Ljava/lang/String;)Z
    .locals 1
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 801
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "undefined"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 802
    :cond_0
    const/4 v0, 0x0

    .line 804
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public addToWishList(Ljava/lang/String;)V
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 458
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$13;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$13;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 466
    return-void
.end method

.method public buyAsin(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 10
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "offerId"    # Ljava/lang/String;
    .param p3, "listId"    # Ljava/lang/String;
    .param p4, "listItemId"    # Ljava/lang/String;
    .param p5, "dealId"    # Ljava/lang/String;
    .param p6, "clickStream"    # Ljava/lang/String;
    .param p7, "oneClickShippingSpeed"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 517
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v9

    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;

    move-object v1, p0

    move-object/from16 v2, p6

    move-object v3, p5

    move-object v4, p3

    move-object v5, p4

    move-object/from16 v6, p7

    move-object v7, p1

    move-object v8, p2

    invoke-direct/range {v0 .. v8}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$15;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v9, v0}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 547
    return-void
.end method

.method public connectWithFacebook(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "appId"    # Ljava/lang/String;
    .param p2, "permissions"    # Ljava/lang/String;
    .param p3, "successCallback"    # Ljava/lang/String;
    .param p4, "failureCallback"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 975
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 976
    .local v0, "arguments":Landroid/os/Bundle;
    const-string/jumbo v2, "appID"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 977
    const-string/jumbo v2, "permissions"

    invoke-virtual {v0, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 978
    const-string/jumbo v2, "successCallback"

    invoke-virtual {v0, v2, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 979
    const-string/jumbo v2, "failureCallback"

    invoke-virtual {v0, v2, p4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 980
    new-instance v1, Lcom/amazon/mShop/social/FacebookConnectHelper;

    invoke-direct {v1}, Lcom/amazon/mShop/social/FacebookConnectHelper;-><init>()V

    .line 981
    .local v1, "fbConnectActivity":Lcom/amazon/mShop/social/FacebookConnectHelper;
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mWebView:Lcom/amazon/mShop/web/MShopWebView;

    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;

    invoke-virtual {v1, v2, v0, v3}, Lcom/amazon/mShop/social/FacebookConnectHelper;->launchFacebookLogin(Lcom/amazon/mShop/web/MShopWebView;Landroid/os/Bundle;Landroid/content/Context;)V

    .line 982
    return-void
.end method

.method public finishSpinnerOnNonWebviewAnimation()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 902
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$24;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$24;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 911
    return-void
.end method

.method public finishSpinnerWebviewAnimated(Ljava/lang/String;)V
    .locals 2
    .param p1, "animationTargetUrl"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 882
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$23;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$23;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 895
    return-void
.end method

.method public getRealClickTime()J
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 789
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;

    instance-of v0, v0, Lcom/amazon/mShop/web/MShopWebActivity;

    if-eqz v0, :cond_0

    .line 790
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;

    check-cast v0, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebActivity;->getRealClickTime()J

    move-result-wide v0

    .line 792
    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public goBack()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 644
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$17;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$17;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 654
    return-void
.end method

.method public hideBottomButton(I)V
    .locals 2
    .param p1, "id"    # I
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 346
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$7;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$7;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;I)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 352
    return-void
.end method

.method public hideProgressDialog()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 706
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$20;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$20;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 712
    return-void
.end method

.method public navigate(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 633
    invoke-virtual {p0, p1, v0, v0}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->navigate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 634
    return-void
.end method

.method public navigate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "transitionEffect"    # Ljava/lang/String;
    .param p3, "callbackId"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 559
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;

    invoke-direct {v1, p0, p2, p1, p3}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$16;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 623
    return-void
.end method

.method public openInExternalBrowser(Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 212
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 213
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 214
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;

    invoke-virtual {v2, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 215
    return-void
.end method

.method public payWithAlipay(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "orderInfo"    # Ljava/lang/String;
    .param p2, "returnUrl"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 942
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;

    instance-of v0, v0, Lcom/amazon/mShop/web/MShopWebActivity;

    if-eqz v0, :cond_0

    .line 943
    invoke-static {}, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$Factory;->getInstance()Lcom/amazon/mShop/payment/alipay/AlipayDelegate;

    move-result-object v1

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;

    check-cast v0, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-virtual {v1, v0, p1, p2}, Lcom/amazon/mShop/payment/alipay/AlipayDelegate;->payWithAlipay(Lcom/amazon/mShop/web/MShopWebActivity;Ljava/lang/String;Ljava/lang/String;)V

    .line 945
    :cond_0
    return-void
.end method

.method public registerForNotifications(Ljava/lang/String;)V
    .locals 2
    .param p1, "callbackId"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 766
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$22;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$22;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 772
    return-void
.end method

.method public setBottomButtonEnabled(IZ)V
    .locals 2
    .param p1, "id"    # I
    .param p2, "isEnabled"    # Z
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 376
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$9;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$9;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;IZ)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 382
    return-void
.end method

.method public setBottomButtonOnTouch(ILjava/lang/String;)V
    .locals 2
    .param p1, "id"    # I
    .param p2, "callbackId"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 391
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$10;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$10;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;ILjava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 397
    return-void
.end method

.method public setBottomButtonText(ILjava/lang/String;)V
    .locals 2
    .param p1, "id"    # I
    .param p2, "text"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 361
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$8;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$8;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;ILjava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 367
    return-void
.end method

.method public share(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "subject"    # Ljava/lang/String;
    .param p2, "messagePlain"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 225
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$3;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$3;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 231
    return-void
.end method

.method public share_1_3_0(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 10
    .param p1, "messagePlain160"    # Ljava/lang/String;
    .param p2, "messagePlain140"    # Ljava/lang/String;
    .param p3, "messageHTML"    # Ljava/lang/String;
    .param p4, "messagePlain"    # Ljava/lang/String;
    .param p5, "subject"    # Ljava/lang/String;
    .param p6, "imageURL"    # Ljava/lang/String;
    .param p7, "url"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 250
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v9

    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    move-object/from16 v7, p6

    move-object/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$4;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v9, v0}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 256
    return-void
.end method

.method public showAlert(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "cancelButtonTitle"    # Ljava/lang/String;
    .param p4, "buttonTitles"    # [Ljava/lang/String;
    .param p5, "callbackId"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 157
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v7

    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p5

    move-object v5, p4

    move-object v6, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$2;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v7, v0}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 203
    return-void
.end method

.method public showBottomButton(ILjava/lang/String;ZLjava/lang/String;)V
    .locals 7
    .param p1, "id"    # I
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "isEnabled"    # Z
    .param p4, "callbackId"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 332
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v6

    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;

    move-object v1, p0

    move v2, p1

    move-object v3, p2

    move v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$6;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;ILjava/lang/String;ZLjava/lang/String;)V

    invoke-interface {v6, v0}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 338
    return-void
.end method

.method public showChooser(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "buttonTitles"    # [Ljava/lang/String;
    .param p3, "cancelButtonTitle"    # Ljava/lang/String;
    .param p4, "callbackId"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 98
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v6

    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p4

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$1;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v6, v0}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 142
    return-void
.end method

.method public showImageGallery(Ljava/lang/String;I[Ljava/lang/String;)V
    .locals 2
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "startIndex"    # I
    .param p3, "imageUrls"    # [Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 476
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;->mContext:Landroid/content/Context;

    instance-of v0, v0, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v0, :cond_0

    .line 477
    const-string/jumbo v0, "dp_img"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 479
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;

    invoke-direct {v1, p0, p3, p2, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$14;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;[Ljava/lang/String;ILjava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 497
    :cond_0
    return-void
.end method

.method public showLoginDialog(Ljava/lang/String;)V
    .locals 2
    .param p1, "callbackId"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 722
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$21;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$21;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 741
    return-void
.end method

.method public showNotificationSettings(Ljava/lang/String;)V
    .locals 2
    .param p1, "category"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 662
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$18;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$18;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 673
    return-void
.end method

.method public showOfferListingPage(Ljava/lang/String;)V
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 441
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$12;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$12;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 447
    return-void
.end method

.method public showProgressDialog(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "dialogTitle"    # Ljava/lang/String;
    .param p2, "callbackId"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 684
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$19;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 699
    return-void
.end method

.method public updateCartCount(I)Z
    .locals 2
    .param p1, "cartCount"    # I
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 291
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$5;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$5;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;I)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 316
    const/4 v0, 0x1

    return v0
.end method

.method public vibrate(I)V
    .locals 2
    .param p1, "milliSeconds"    # I
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 407
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$11;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient$11;-><init>(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;I)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 414
    return-void
.end method
