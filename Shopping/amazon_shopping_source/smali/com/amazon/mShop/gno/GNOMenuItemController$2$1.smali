.class Lcom/amazon/mShop/gno/GNOMenuItemController$2$1;
.super Ljava/lang/Object;
.source "GNOMenuItemController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemController$2;->completed(Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/gno/GNOMenuItemController$2;

.field final synthetic val$responseItems:Ljava/util/Collection;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemController$2;Ljava/util/Collection;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2$1;->this$1:Lcom/amazon/mShop/gno/GNOMenuItemController$2;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2$1;->val$responseItems:Ljava/util/Collection;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 241
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2$1;->val$responseItems:Ljava/util/Collection;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 245
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 246
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2$1;->val$responseItems:Ljava/util/Collection;

    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2$1;->this$1:Lcom/amazon/mShop/gno/GNOMenuItemController$2;

    iget-object v2, v2, Lcom/amazon/mShop/gno/GNOMenuItemController$2;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    # getter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->PROVIDER_DEBUG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$600()Ljava/lang/String;

    move-result-object v3

    # invokes: Lcom/amazon/mShop/gno/GNOMenuItemController;->getProvider(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNOMenuItemProvider;
    invoke-static {v2, v3}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$700(Lcom/amazon/mShop/gno/GNOMenuItemController;Ljava/lang/String;)Lcom/amazon/mShop/gno/GNOMenuItemProvider;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/gno/GNOMenuItemProvider;->getItems()Ljava/util/Collection;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/CollectionsUtil;->sum(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Collection;

    move-result-object v0

    .line 253
    .local v0, "items":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2$1;->this$1:Lcom/amazon/mShop/gno/GNOMenuItemController$2;

    iget-object v1, v1, Lcom/amazon/mShop/gno/GNOMenuItemController$2;->val$itemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->setItems(Ljava/util/Collection;)V

    .line 254
    # getter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$300()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "updated menu"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 256
    .end local v0    # "items":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    :cond_0
    return-void

    .line 250
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2$1;->val$responseItems:Ljava/util/Collection;

    .restart local v0    # "items":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    goto :goto_0
.end method
