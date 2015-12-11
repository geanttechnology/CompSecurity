.class Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;
.super Ljava/lang/Object;
.source "MASHAppUiPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;->navMenuFocusOnItem(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;

.field final synthetic val$menuItemId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;->this$0:Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;->val$menuItemId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 85
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    .line 90
    .local v0, "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;->this$0:Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    if-ne v1, v0, :cond_1

    .line 91
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;->val$menuItemId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawer;->focusOn(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 93
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v1}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 105
    :goto_0
    return-void

    .line 96
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;->val$callback:Lorg/apache/cordova/CallbackContext;

    sget-object v2, Lcom/amazon/mobile/mash/error/FocusOnItemError;->NOT_FOUND:Lcom/amazon/mobile/mash/error/FocusOnItemError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/FocusOnItemError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 99
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$3;->val$callback:Lorg/apache/cordova/CallbackContext;

    sget-object v2, Lcom/amazon/mobile/mash/error/FocusOnItemError;->ITEM_CAN_NOT_BE_IN_FOCUS:Lcom/amazon/mobile/mash/error/FocusOnItemError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/FocusOnItemError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method
