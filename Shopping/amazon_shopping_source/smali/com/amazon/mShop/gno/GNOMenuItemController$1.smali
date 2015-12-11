.class Lcom/amazon/mShop/gno/GNOMenuItemController$1;
.super Ljava/lang/Object;
.source "GNOMenuItemController.java"

# interfaces
.implements Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemController;->switchLanguageAndFetchMenu(Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

.field final synthetic val$itemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;

.field final synthetic val$menuId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 0

    .prologue
    .line 177
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->val$menuId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->val$itemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 183
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    # getter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$000(Lcom/amazon/mShop/gno/GNOMenuItemController;)Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->error_message_switching_language:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;I)V

    .line 184
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->mIsCallingMShopServer:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$102(Lcom/amazon/mShop/gno/GNOMenuItemController;Z)Z

    .line 185
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->val$menuId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->val$itemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;

    # invokes: Lcom/amazon/mShop/gno/GNOMenuItemController;->fetchMenuItems(Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$200(Lcom/amazon/mShop/gno/GNOMenuItemController;Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    .line 186
    return-void
.end method

.method public onLocaleSwitchCompleted(Ljava/lang/String;)V
    .locals 3
    .param p1, "currentCode"    # Ljava/lang/String;

    .prologue
    .line 190
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/gno/GNOMenuItemController;->mIsCallingMShopServer:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$102(Lcom/amazon/mShop/gno/GNOMenuItemController;Z)Z

    .line 191
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->val$menuId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$1;->val$itemAdapter:Lcom/amazon/mShop/gno/GNOItemAdapter;

    # invokes: Lcom/amazon/mShop/gno/GNOMenuItemController;->fetchMenuItems(Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/gno/GNOMenuItemController;->access$200(Lcom/amazon/mShop/gno/GNOMenuItemController;Ljava/lang/String;Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    .line 192
    return-void
.end method
