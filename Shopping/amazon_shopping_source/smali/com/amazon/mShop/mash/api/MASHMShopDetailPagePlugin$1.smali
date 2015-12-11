.class Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;
.super Ljava/lang/Object;
.source "MASHMShopDetailPagePlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin;->showOfferListingPage(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin;

.field final synthetic val$asin:Ljava/lang/String;

.field final synthetic val$callback:Lorg/apache/cordova/CallbackContext;

.field final synthetic val$listId:Ljava/lang/String;

.field final synthetic val$listItemId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin;

    iput-object p2, p0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;->val$asin:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;->val$listId:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;->val$listItemId:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 46
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;->this$0:Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin;

    iget-object v1, v1, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v1}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 47
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;->val$asin:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;->val$listId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;->val$listItemId:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/mash/OfferListingView;->show(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    iget-object v1, p0, Lcom/amazon/mShop/mash/api/MASHMShopDetailPagePlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v1}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 49
    return-void
.end method
