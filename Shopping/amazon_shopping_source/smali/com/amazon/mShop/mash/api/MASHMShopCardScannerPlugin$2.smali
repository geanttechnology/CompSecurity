.class Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$2;
.super Ljava/lang/Object;
.source "MASHMShopCardScannerPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->showCardScanner(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$2;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 88
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$2;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-class v2, Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 89
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 90
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$2;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin$2;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopCardScannerPlugin;

    const/16 v3, 0x14

    invoke-interface {v1, v2, v0, v3}, Lorg/apache/cordova/CordovaInterface;->startActivityForResult(Lorg/apache/cordova/CordovaPlugin;Landroid/content/Intent;I)V

    .line 91
    return-void
.end method
