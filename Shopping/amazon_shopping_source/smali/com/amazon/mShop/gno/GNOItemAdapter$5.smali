.class Lcom/amazon/mShop/gno/GNOItemAdapter$5;
.super Ljava/lang/Object;
.source "GNOItemAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter;->expandGroup(Ljava/lang/String;Z)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

.field final synthetic val$activity:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOItemAdapter;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 350
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$5;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$5;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 353
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$5;->val$activity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    .line 354
    .local v0, "drawer":Lcom/amazon/mShop/gno/GNODrawer;
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$5;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    # getter for: Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$400(Lcom/amazon/mShop/gno/GNOItemAdapter;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawer;->isItemDisplayed(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 355
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$5;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    # getter for: Lcom/amazon/mShop/gno/GNOItemAdapter;->mExpandedGroupId:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->access$400(Lcom/amazon/mShop/gno/GNOItemAdapter;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawer;->scrollItemToTop(Ljava/lang/String;)V

    .line 357
    :cond_0
    return-void
.end method
