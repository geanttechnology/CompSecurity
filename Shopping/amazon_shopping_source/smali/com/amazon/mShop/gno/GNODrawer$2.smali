.class Lcom/amazon/mShop/gno/GNODrawer$2;
.super Ljava/lang/Object;
.source "GNODrawer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawer;->focusOn(Ljava/lang/String;Z)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawer;

.field final synthetic val$id:Ljava/lang/String;

.field final synthetic val$item:Lcom/amazon/mShop/gno/GNODrawerItem;

.field final synthetic val$pinToTop:Z


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNODrawer;Lcom/amazon/mShop/gno/GNODrawerItem;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 287
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawer$2;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNODrawer$2;->val$item:Lcom/amazon/mShop/gno/GNODrawerItem;

    iput-object p3, p0, Lcom/amazon/mShop/gno/GNODrawer$2;->val$id:Ljava/lang/String;

    iput-boolean p4, p0, Lcom/amazon/mShop/gno/GNODrawer$2;->val$pinToTop:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 290
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer$2;->val$item:Lcom/amazon/mShop/gno/GNODrawerItem;

    invoke-interface {v2}, Lcom/amazon/mShop/gno/GNODrawerItem;->getParent()Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v1

    .line 293
    .local v1, "parent":Lcom/amazon/mShop/gno/GNODrawerItem;
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v3

    if-eqz v1, :cond_1

    invoke-interface {v1}, Lcom/amazon/mShop/gno/GNODrawerItem;->getId()Ljava/lang/String;

    move-result-object v2

    :goto_0
    invoke-virtual {v3, v2}, Lcom/amazon/mShop/gno/GNOItemAdapter;->expandGroup(Ljava/lang/String;)Z

    .line 295
    iget-boolean v2, p0, Lcom/amazon/mShop/gno/GNODrawer$2;->val$pinToTop:Z

    if-eqz v2, :cond_0

    .line 297
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/gno/GNODrawer$2;->val$id:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getVisibleItemPosition(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getListViewPosition(I)I

    move-result v0

    .line 298
    .local v0, "itemPos":I
    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    .line 299
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer$2;->this$0:Lcom/amazon/mShop/gno/GNODrawer;

    # getter for: Lcom/amazon/mShop/gno/GNODrawer;->mMenuList:Landroid/widget/ListView;
    invoke-static {v2}, Lcom/amazon/mShop/gno/GNODrawer;->access$200(Lcom/amazon/mShop/gno/GNODrawer;)Landroid/widget/ListView;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/widget/ListView;->setSelection(I)V

    .line 302
    .end local v0    # "itemPos":I
    :cond_0
    return-void

    .line 293
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNODrawer$2;->val$id:Ljava/lang/String;

    goto :goto_0
.end method
