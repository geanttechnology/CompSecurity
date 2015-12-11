.class Lcom/amazon/mShop/about/MShopAboutView$2$1;
.super Lcom/amazon/mShop/upgrade/UpgradeSubscriberAdapter;
.source "MShopAboutView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/about/MShopAboutView$2;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/about/MShopAboutView$2;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/about/MShopAboutView$2;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/amazon/mShop/about/MShopAboutView$2$1;->this$1:Lcom/amazon/mShop/about/MShopAboutView$2;

    invoke-direct {p0}, Lcom/amazon/mShop/upgrade/UpgradeSubscriberAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public awareUniqueId()Z
    .locals 1

    .prologue
    .line 166
    const/4 v0, 0x0

    return v0
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 125
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/about/MShopAboutView$2$1$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/about/MShopAboutView$2$1$1;-><init>(Lcom/amazon/mShop/about/MShopAboutView$2$1;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 137
    return-void
.end method

.method public onNoUpgrade()V
    .locals 2

    .prologue
    .line 155
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/about/MShopAboutView$2$1$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/about/MShopAboutView$2$1$3;-><init>(Lcom/amazon/mShop/about/MShopAboutView$2$1;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 163
    return-void
.end method

.method public onUpgradeAvailable(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;)V
    .locals 2
    .param p1, "info"    # Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;

    .prologue
    .line 141
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/about/MShopAboutView$2$1$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/about/MShopAboutView$2$1$2;-><init>(Lcom/amazon/mShop/about/MShopAboutView$2$1;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 151
    return-void
.end method
