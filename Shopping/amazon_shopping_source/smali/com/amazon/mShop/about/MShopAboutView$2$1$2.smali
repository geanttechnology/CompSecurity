.class Lcom/amazon/mShop/about/MShopAboutView$2$1$2;
.super Ljava/lang/Object;
.source "MShopAboutView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/about/MShopAboutView$2$1;->onUpgradeAvailable(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/amazon/mShop/about/MShopAboutView$2$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/about/MShopAboutView$2$1;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/amazon/mShop/about/MShopAboutView$2$1$2;->this$2:Lcom/amazon/mShop/about/MShopAboutView$2$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 145
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 146
    .local v0, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "upgradeShouldShowDialog"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 147
    iget-object v1, p0, Lcom/amazon/mShop/about/MShopAboutView$2$1$2;->this$2:Lcom/amazon/mShop/about/MShopAboutView$2$1;

    iget-object v1, v1, Lcom/amazon/mShop/about/MShopAboutView$2$1;->this$1:Lcom/amazon/mShop/about/MShopAboutView$2;

    iget-object v1, v1, Lcom/amazon/mShop/about/MShopAboutView$2;->val$c:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/mShop/util/UpgradeUtil;->showUpgradeNotificationDialog(Landroid/content/Context;)V

    .line 148
    return-void
.end method
