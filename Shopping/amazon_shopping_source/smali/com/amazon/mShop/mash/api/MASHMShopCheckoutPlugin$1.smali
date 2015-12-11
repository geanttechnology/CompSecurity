.class Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;
.super Ljava/lang/Object;
.source "MASHMShopCheckoutPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->showDeliveryDestinationPicker(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 60
    iget-object v3, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;

    iget-object v4, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    # setter for: Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;
    invoke-static {v3, v4}, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->access$002(Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;Lorg/apache/cordova/CallbackContext;)Lorg/apache/cordova/CallbackContext;

    .line 61
    iget-object v3, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;

    iget-object v3, v3, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v3}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 62
    .local v0, "activity":Landroid/app/Activity;
    invoke-static {v0}, Lcom/amazon/mShop/opl/AddressPickerView;->hasCVSD(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 63
    iget-object v3, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    sget-object v4, Lcom/amazon/mobile/mash/error/MASHError;->NOT_SUPPORTED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 73
    :goto_0
    return-void

    .line 67
    :cond_0
    :try_start_0
    invoke-static {v0}, Lcom/amazon/mShop/opl/AddressPickerView;->getCVSDMapActivityIntent(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v2

    .line 68
    .local v2, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;

    iget-object v3, v3, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    iget-object v4, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;

    const/4 v5, 0x6

    invoke-interface {v3, v4, v2, v5}, Lorg/apache/cordova/CordovaInterface;->startActivityForResult(Lorg/apache/cordova/CordovaPlugin;Landroid/content/Intent;I)V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 69
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_0
    move-exception v1

    .line 70
    .local v1, "e":Ljava/lang/ClassNotFoundException;
    # getter for: Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin;->access$100()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/ClassNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 71
    iget-object v3, p0, Lcom/amazon/mShop/mash/api/MASHMShopCheckoutPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    sget-object v4, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method
