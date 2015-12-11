.class Lcom/amazon/mShop/about/MShopAboutView$2;
.super Ljava/lang/Object;
.source "MShopAboutView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/about/MShopAboutView;-><init>(Landroid/content/Context;Ljava/lang/Integer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/about/MShopAboutView;

.field final synthetic val$c:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/about/MShopAboutView;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 115
    iput-object p1, p0, Lcom/amazon/mShop/about/MShopAboutView$2;->this$0:Lcom/amazon/mShop/about/MShopAboutView;

    iput-object p2, p0, Lcom/amazon/mShop/about/MShopAboutView$2;->val$c:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 119
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->clearNewUpgradeInfo()V

    .line 120
    new-instance v0, Lcom/amazon/mShop/upgrade/UpgradeController;

    invoke-direct {v0}, Lcom/amazon/mShop/upgrade/UpgradeController;-><init>()V

    .line 121
    .local v0, "controller":Lcom/amazon/mShop/upgrade/UpgradeController;
    new-instance v1, Lcom/amazon/mShop/about/MShopAboutView$2$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/about/MShopAboutView$2$1;-><init>(Lcom/amazon/mShop/about/MShopAboutView$2;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/upgrade/UpgradeController;->setSubscriber(Lcom/amazon/mShop/upgrade/UpgradeSubscriber;)V

    .line 170
    new-instance v1, Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v2, p0, Lcom/amazon/mShop/about/MShopAboutView$2;->this$0:Lcom/amazon/mShop/about/MShopAboutView;

    invoke-virtual {v2}, Lcom/amazon/mShop/about/MShopAboutView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->checking_for_upgrade:I

    invoke-virtual {v1, v0, v2}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/upgrade/UpgradeController;->checkForUpgrade(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 171
    return-void
.end method
