.class Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$4;
.super Ljava/lang/Object;
.source "MASHMShopYourAccountPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->showYourAccount(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
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
    .line 129
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$4;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$4;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$4;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;

    iget-object v0, v0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v0}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startYourAccountActivity(Landroid/content/Context;)Z

    .line 133
    iget-object v0, p0, Lcom/amazon/mShop/mash/api/MASHMShopYourAccountPlugin$4;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v0}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 135
    return-void
.end method
