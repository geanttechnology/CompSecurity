.class Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$1;
.super Ljava/lang/Object;
.source "MASHMShopYourAccountPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->showAdsPreferences(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 68
    invoke-static {}, Lcom/amazon/mShop/mobileads/AdsHelper;->isAdsEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 69
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 70
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/mobileads/AdsHelper;->openUserPreferences(Lcom/amazon/mShop/AmazonActivity;)V

    .line 71
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v1}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 75
    .end local v0    # "activity":Lcom/amazon/mShop/AmazonActivity;
    :goto_0
    return-void

    .line 73
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    sget-object v2, Lcom/amazon/mobile/mash/error/MASHError;->NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method
