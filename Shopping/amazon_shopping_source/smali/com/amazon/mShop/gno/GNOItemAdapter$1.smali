.class Lcom/amazon/mShop/gno/GNOItemAdapter$1;
.super Ljava/lang/Object;
.source "GNOItemAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter;->setItems(Ljava/util/Collection;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

.field final synthetic val$items:Ljava/util/Collection;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOItemAdapter;Ljava/util/Collection;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$1;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$1;->val$items:Ljava/util/Collection;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 117
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$1;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    # getter for: Lcom/amazon/mShop/gno/GNOItemAdapter;->mDrawerItems:Ljava/util/Map;
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$000(Lcom/amazon/mShop/gno/GNOItemAdapter;)Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 118
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$1;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$1;->val$items:Ljava/util/Collection;

    # invokes: Lcom/amazon/mShop/gno/GNOItemAdapter;->addItems(Ljava/util/Collection;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$100(Lcom/amazon/mShop/gno/GNOItemAdapter;Ljava/util/Collection;)V

    .line 119
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$1;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    # invokes: Lcom/amazon/mShop/gno/GNOItemAdapter;->collectVisibleItems()V
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$200(Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    .line 120
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$1;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->notifyDataSetChanged()V

    .line 121
    return-void
.end method
