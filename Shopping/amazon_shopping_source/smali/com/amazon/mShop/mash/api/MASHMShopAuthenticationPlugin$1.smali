.class Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;
.super Ljava/lang/Object;
.source "MASHMShopAuthenticationPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->logout(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 67
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 69
    sget-object v1, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$3;->$SwitchMap$com$amazon$mShop$sso$IdentityType:[I

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/sso/IdentityType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 81
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

    # getter for: Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;
    invoke-static {v1}, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->access$000(Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;)Lorg/apache/cordova/CallbackContext;

    move-result-object v1

    sget-object v2, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 88
    :goto_0
    return-void

    .line 71
    :pswitch_0
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-class v2, Lcom/amazon/mShop/sso/CentralSSOLogoutActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 84
    .local v0, "intent":Landroid/content/Intent;
    :goto_1
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

    const/4 v3, 0x1

    invoke-interface {v1, v2, v0, v3}, Lorg/apache/cordova/CordovaInterface;->startActivityForResult(Lorg/apache/cordova/CordovaPlugin;Landroid/content/Intent;I)V

    goto :goto_0

    .line 74
    .end local v0    # "intent":Landroid/content/Intent;
    :pswitch_1
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-class v2, Lcom/amazon/mShop/sso/DistributedSSOLogoutActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 75
    .restart local v0    # "intent":Landroid/content/Intent;
    goto :goto_1

    .line 77
    .end local v0    # "intent":Landroid/content/Intent;
    :pswitch_2
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-class v2, Lcom/amazon/mShop/account/LogoutActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 78
    .restart local v0    # "intent":Landroid/content/Intent;
    goto :goto_1

    .line 86
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    sget-object v2, Lcom/amazon/mobile/mash/error/LogoutError;->NOT_LOGGED_IN:Lcom/amazon/mobile/mash/error/LogoutError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/LogoutError;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 69
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
