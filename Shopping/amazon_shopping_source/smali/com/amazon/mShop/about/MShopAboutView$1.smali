.class Lcom/amazon/mShop/about/MShopAboutView$1;
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


# direct methods
.method constructor <init>(Lcom/amazon/mShop/about/MShopAboutView;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/amazon/mShop/about/MShopAboutView$1;->this$0:Lcom/amazon/mShop/about/MShopAboutView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 56
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/Context;

    .line 57
    .local v2, "context":Landroid/content/Context;
    iget-object v3, p0, Lcom/amazon/mShop/about/MShopAboutView$1;->this$0:Lcom/amazon/mShop/about/MShopAboutView;

    # operator++ for: Lcom/amazon/mShop/about/MShopAboutView;->mClickTimes:I
    invoke-static {v3}, Lcom/amazon/mShop/about/MShopAboutView;->access$008(Lcom/amazon/mShop/about/MShopAboutView;)I

    .line 58
    iget-object v3, p0, Lcom/amazon/mShop/about/MShopAboutView$1;->this$0:Lcom/amazon/mShop/about/MShopAboutView;

    # getter for: Lcom/amazon/mShop/about/MShopAboutView;->mClickTimes:I
    invoke-static {v3}, Lcom/amazon/mShop/about/MShopAboutView;->access$000(Lcom/amazon/mShop/about/MShopAboutView;)I

    move-result v3

    const/4 v4, 0x5

    if-ne v3, v4, :cond_0

    .line 59
    iget-object v3, p0, Lcom/amazon/mShop/about/MShopAboutView$1;->this$0:Lcom/amazon/mShop/about/MShopAboutView;

    const/4 v4, 0x0

    # setter for: Lcom/amazon/mShop/about/MShopAboutView;->mClickTimes:I
    invoke-static {v3, v4}, Lcom/amazon/mShop/about/MShopAboutView;->access$002(Lcom/amazon/mShop/about/MShopAboutView;I)I

    .line 60
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getApplicationId()Ljava/lang/String;

    move-result-object v1

    .line 61
    .local v1, "applicationId":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 62
    const-string/jumbo v3, ";"

    const-string/jumbo v4, "\n"

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 63
    .local v0, "appInfo":Ljava/lang/String;
    const/4 v3, 0x1

    invoke-static {v2, v0, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    .line 66
    .end local v0    # "appInfo":Ljava/lang/String;
    .end local v1    # "applicationId":Ljava/lang/String;
    :cond_0
    return-void
.end method
