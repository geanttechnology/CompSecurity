.class Lcom/amazon/mShop/sso/SSOSplashScreenView$5;
.super Ljava/lang/Object;
.source "SSOSplashScreenView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/SSOSplashScreenView;->initSplashScreen()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/SSOSplashScreenView;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$5;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 130
    iget-object v2, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$5;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    # getter for: Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->access$000(Lcom/amazon/mShop/sso/SSOSplashScreenView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sso_cookies_and_internet_advertising_url:I

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 131
    .local v0, "privacyNoticelinkUrl":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$5;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    # getter for: Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->access$000(Lcom/amazon/mShop/sso/SSOSplashScreenView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sso_cookies_and_internet_advertising:I

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 132
    .local v1, "title":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$5;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    # invokes: Lcom/amazon/mShop/sso/SSOSplashScreenView;->handleLinkTextAction(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v2, v0, v1}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->access$100(Lcom/amazon/mShop/sso/SSOSplashScreenView;Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    return-void
.end method
