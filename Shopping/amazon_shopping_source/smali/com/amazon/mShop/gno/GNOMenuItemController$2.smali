.class Lcom/amazon/mShop/gno/GNOMenuItemController$2;
.super Ljava/lang/Object;
.source "GNOMenuItemController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemController;->fetchMenuItems(Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

.field final synthetic val$itemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 0

    .prologue
    .line 216
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2;->val$itemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 226
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->mIsCallingMShopServer:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$102(Lcom/amazon/mShop/gno/GNOMenuItemController;Z)Z

    .line 227
    # getter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$300()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Failed to get menu items : call cancelled"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 228
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 4
    .param p1, "response"    # Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 232
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    # setter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->mLastUpdateTime:J
    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$402(Lcom/amazon/mShop/gno/GNOMenuItemController;J)J

    .line 233
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    const/4 v2, 0x0

    # setter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->mIsCallingMShopServer:Z
    invoke-static {v1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$102(Lcom/amazon/mShop/gno/GNOMenuItemController;Z)Z

    .line 235
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    # invokes: Lcom/amazon/mShop/gno/GNOMenuItemController;->parseResponse(Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;)Ljava/util/Collection;
    invoke-static {v1, p1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$500(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;)Ljava/util/Collection;

    move-result-object v0

    .line 238
    .local v0, "responseItems":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/gno/GNODrawerItem;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/gno/GNOMenuItemController$2$1;

    invoke-direct {v2, p0, v0}, Lcom/amazon/mShop/gno/GNOMenuItemController$2$1;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemController$2;Ljava/util/Collection;)V

    invoke-interface {v1, v2}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 258
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 220
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$2;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->mIsCallingMShopServer:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$102(Lcom/amazon/mShop/gno/GNOMenuItemController;Z)Z

    .line 221
    # getter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$300()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Failed to get menu items"

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 222
    return-void
.end method
