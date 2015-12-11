.class Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem$1;
.super Ljava/lang/Object;
.source "GNOItemAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;)V
    .locals 0

    .prologue
    .line 594
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem$1;->this$1:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 597
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem$1;->this$1:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    iget-object v0, v0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/gno/GNOItemAdapter;->mIsAnimating:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$602(Lcom/amazon/mShop/gno/GNOItemAdapter;Z)Z

    .line 600
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem$1;->this$1:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    # getter for: Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->mIsExpanding:Z
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->access$700(Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 601
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem$1;->this$1:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    iget-object v0, v0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$402(Lcom/amazon/mShop/gno/GNOItemAdapter;Ljava/lang/String;)Ljava/lang/String;

    .line 605
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem$1;->this$1:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    iget-object v0, v0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->updateVisibleItems()V

    .line 607
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem$1;->this$1:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    # getter for: Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->mEndActionRunnable:Ljava/lang/Runnable;
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->access$800(Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;)Ljava/lang/Runnable;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 608
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem$1;->this$1:Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;

    # getter for: Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->mEndActionRunnable:Ljava/lang/Runnable;
    invoke-static {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;->access$800(Lcom/amazon/mShop/gno/GNOItemAdapter$FakeExpandCollapseDrawerItem;)Ljava/lang/Runnable;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 610
    :cond_1
    return-void
.end method
