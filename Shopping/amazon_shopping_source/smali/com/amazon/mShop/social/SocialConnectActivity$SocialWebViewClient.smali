.class Lcom/amazon/mShop/social/SocialConnectActivity$SocialWebViewClient;
.super Lcom/amazon/mShop/web/MShopWebViewClient;
.source "SocialConnectActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/social/SocialConnectActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SocialWebViewClient"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/social/SocialConnectActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/social/SocialConnectActivity;Lorg/apache/cordova/CordovaInterface;)V
    .locals 2
    .param p2, "cordova"    # Lorg/apache/cordova/CordovaInterface;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/mShop/social/SocialConnectActivity$SocialWebViewClient;->this$0:Lcom/amazon/mShop/social/SocialConnectActivity;

    .line 54
    new-instance v0, Lcom/amazon/mShop/social/SocialConnectActivity$SocialNavManager;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/amazon/mShop/social/SocialConnectActivity$SocialNavManager;-><init>(Lcom/amazon/mShop/social/SocialConnectActivity;Lcom/amazon/mShop/social/SocialConnectActivity$1;)V

    invoke-direct {p0, p2, v0}, Lcom/amazon/mShop/web/MShopWebViewClient;-><init>(Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mShop/mash/nav/AmazonNavManager;)V

    .line 55
    return-void
.end method
