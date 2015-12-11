.class Lcom/amazon/mShop/web/MShopWebViewClient$1;
.super Ljava/lang/Object;
.source "MShopWebViewClient.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewClient;->handleAuthentication(Landroid/webkit/WebView;Ljava/lang/String;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewClient;

.field final synthetic val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$urlAfterSuccessfulLogin:Ljava/lang/String;

.field final synthetic val$webView:Landroid/webkit/WebView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewClient;Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Landroid/webkit/WebView;)V
    .locals 0

    .prologue
    .line 430
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewClient$1;->this$0:Lcom/amazon/mShop/web/MShopWebViewClient;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewClient$1;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iput-object p3, p0, Lcom/amazon/mShop/web/MShopWebViewClient$1;->val$urlAfterSuccessfulLogin:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/web/MShopWebViewClient$1;->val$webView:Landroid/webkit/WebView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public userCancelledSignIn()V
    .locals 1

    .prologue
    .line 437
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient$1;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->popView()Z

    .line 438
    return-void
.end method

.method public userSuccessfullySignedIn()V
    .locals 2

    .prologue
    .line 442
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient$1;->val$urlAfterSuccessfulLogin:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 444
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient$1;->val$webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->clearView()V

    .line 445
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient$1;->val$webView:Landroid/webkit/WebView;

    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewClient$1;->val$urlAfterSuccessfulLogin:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 447
    :cond_0
    return-void
.end method
