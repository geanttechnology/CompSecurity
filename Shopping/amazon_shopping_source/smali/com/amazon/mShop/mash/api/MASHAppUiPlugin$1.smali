.class Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$1;
.super Ljava/lang/Object;
.source "MASHAppUiPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;->cancelFullscreen(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 48
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 49
    .local v0, "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->showActionBar(Lcom/amazon/mShop/AmazonActivity;)V

    .line 50
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHAppUiPlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v1}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 51
    return-void
.end method
