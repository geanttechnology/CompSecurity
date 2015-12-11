.class final enum Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command$1;
.super Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
.source "AivHttpIntentActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p3, "x0"    # Ljava/lang/String;

    .prologue
    .line 29
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/aiv/AivHttpIntentActivity$Command;-><init>(Ljava/lang/String;ILjava/lang/String;Lcom/amazon/mShop/aiv/AivHttpIntentActivity$1;)V

    return-void
.end method


# virtual methods
.method public performCommand(Landroid/app/Activity;Ljava/util/List;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 31
    .local p2, "segments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v2, 0x3

    invoke-interface {p2, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 32
    .local v0, "asin":Ljava/lang/String;
    new-instance v1, Lcom/amazon/mShop/control/item/ProductController;

    sget-object v2, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_DEFAULT:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-direct {v1, v0, v2}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/String;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 33
    .local v1, "productController":Lcom/amazon/mShop/control/item/ProductController;
    const/4 v2, 0x0

    new-array v2, v2, [I

    invoke-static {p1, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->launchDetailsPage(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;[I)Z

    .line 34
    return-void
.end method
