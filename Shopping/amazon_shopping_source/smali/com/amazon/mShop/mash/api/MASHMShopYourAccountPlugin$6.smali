.class Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;
.super Ljava/lang/Object;
.source "MASHMShopYourAccountPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->changedSmileStatus(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;

.field final synthetic val$charityName:Ljava/lang/String;

.field final synthetic val$isSmile:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;ZLjava/lang/String;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

    iput-boolean p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;->val$isSmile:Z

    iput-object p3, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;->val$charityName:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 181
    iget-boolean v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;->val$isSmile:Z

    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;->val$charityName:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/amazon/mShop/smile/SmileHelper;->updateSmileInfo(ZLjava/lang/String;)Z

    move-result v0

    .line 182
    .local v0, "success":Z
    if-eqz v0, :cond_0

    .line 183
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v1}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 187
    :goto_0
    return-void

    .line 185
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$6;->val$callback:Lorg/apache/cordova/CallbackContext;

    sget-object v2, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method
