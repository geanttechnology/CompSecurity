.class Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$3;
.super Ljava/lang/Object;
.source "MASHMShopYourAccountPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->showOneClickSettings(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
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
    .line 109
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$3;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$3;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 112
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$3;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 114
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0, v2, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startOneClickSettingActivity(Landroid/content/Context;ZZ)Z

    .line 115
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$3;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v1}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 117
    return-void
.end method
