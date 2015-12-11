.class Lcom/amazon/mShop/social/SocialConnectActivity$SocialNavManager;
.super Lcom/amazon/mShop/mash/nav/AmazonNavManager;
.source "SocialConnectActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/social/SocialConnectActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SocialNavManager"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/social/SocialConnectActivity;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/social/SocialConnectActivity;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/mShop/social/SocialConnectActivity$SocialNavManager;->this$0:Lcom/amazon/mShop/social/SocialConnectActivity;

    invoke-direct {p0}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/social/SocialConnectActivity;Lcom/amazon/mShop/social/SocialConnectActivity$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/social/SocialConnectActivity;
    .param p2, "x1"    # Lcom/amazon/mShop/social/SocialConnectActivity$1;

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/amazon/mShop/social/SocialConnectActivity$SocialNavManager;-><init>(Lcom/amazon/mShop/social/SocialConnectActivity;)V

    return-void
.end method


# virtual methods
.method protected handleDismissAll(Landroid/webkit/WebView;Landroid/net/Uri;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "uri"    # Landroid/net/Uri;

    .prologue
    .line 46
    iget-object v1, p0, Lcom/amazon/mShop/social/SocialConnectActivity$SocialNavManager;->this$0:Lcom/amazon/mShop/social/SocialConnectActivity;

    if-eqz p2, :cond_0

    const-string/jumbo v0, "do_not_show_again"

    invoke-virtual {p2, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "1"

    const-string/jumbo v2, "do_not_show_again"

    invoke-virtual {p2, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    # setter for: Lcom/amazon/mShop/social/SocialConnectActivity;->mSocialConnectDoNotShowAgain:Z
    invoke-static {v1, v0}, Lcom/amazon/mShop/social/SocialConnectActivity;->access$002(Lcom/amazon/mShop/social/SocialConnectActivity;Z)Z

    .line 47
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;->handleDismissAll(Landroid/webkit/WebView;Landroid/net/Uri;)V

    .line 48
    return-void

    .line 46
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
