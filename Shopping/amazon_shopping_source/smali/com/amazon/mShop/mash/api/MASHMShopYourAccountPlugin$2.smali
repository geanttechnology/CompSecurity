.class Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$2;
.super Ljava/lang/Object;
.source "MASHMShopYourAccountPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->showAmazonPoints(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
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
    .line 87
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$2;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 90
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$2;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 91
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_hasPoints:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 92
    new-instance v1, Lcom/amazon/mShop/youraccount/AmazonPointsView;

    invoke-direct {v1, v0}, Lcom/amazon/mShop/youraccount/AmazonPointsView;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    .line 93
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v1}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 97
    :goto_0
    return-void

    .line 95
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    sget-object v2, Lcom/amazon/mobile/mash/error/MASHError;->NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method
