.class Lcom/amazon/mShop/gno/GNOItemAdapter$2;
.super Ljava/lang/Object;
.source "GNOItemAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter;->setAppstoreCoinsCount(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 0

    .prologue
    .line 136
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$2;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 139
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$2;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    const-string/jumbo v3, "mshop:appstore"

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;

    .line 140
    .local v1, "item":Lcom/amazon/mShop/gno/GNODrawerItemAppstoreHeader;
    if-eqz v1, :cond_1

    .line 142
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$2;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    const-string/jumbo v3, "mshop:appstore/coins"

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/gno/GNOItemAdapter;->getItem(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItemHideable;

    .line 143
    .local v0, "coinTab":Lcom/amazon/mShop/gno/GNODrawerItemHideable;
    if-eqz v0, :cond_0

    .line 144
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$2;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-virtual {v2}, Lcom/amazon/mShop/gno/GNOItemAdapter;->createAppstoreCoinTabCallable()Ljava/util/concurrent/Callable;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/gno/GNODrawerItemHideable;->setIsHiddenCallable(Ljava/util/concurrent/Callable;)V

    .line 146
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$2;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    # invokes: Lcom/amazon/mShop/gno/GNOItemAdapter;->collectVisibleItems()V
    invoke-static {v2}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$200(Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    .line 147
    iget-object v2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$2;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-virtual {v2}, Lcom/amazon/mShop/gno/GNOItemAdapter;->notifyDataSetChanged()V

    .line 149
    .end local v0    # "coinTab":Lcom/amazon/mShop/gno/GNODrawerItemHideable;
    :cond_1
    return-void
.end method
