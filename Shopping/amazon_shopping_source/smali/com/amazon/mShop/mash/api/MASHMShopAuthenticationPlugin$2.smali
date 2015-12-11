.class Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$2;
.super Ljava/lang/Object;
.source "MASHMShopAuthenticationPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->userChangedPrimeStatus(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
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
    .line 112
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$2;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 121
    new-instance v0, Lcom/amazon/mShop/sso/MShopCheckLogin;

    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$2;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mShop/sso/MShopCheckLogin;-><init>(Landroid/content/Context;ZLcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;)V

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin;->checkLogin()V

    .line 122
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHMShopAuthenticationPlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v0}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 123
    return-void
.end method
