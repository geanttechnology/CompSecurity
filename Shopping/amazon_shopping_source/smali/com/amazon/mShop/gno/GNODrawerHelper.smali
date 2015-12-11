.class public Lcom/amazon/mShop/gno/GNODrawerHelper;
.super Ljava/lang/Object;
.source "GNODrawerHelper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static closeDrawerAndExecute(Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/Runnable;)V
    .locals 2
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "pushBlankPage"    # Z
    .param p2, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    .line 17
    .local v0, "drawer":Lcom/amazon/mShop/gno/GNODrawer;
    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->isClosed()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 18
    invoke-interface {p2}, Ljava/lang/Runnable;->run()V

    .line 36
    :goto_0
    return-void

    .line 21
    :cond_0
    new-instance v1, Lcom/amazon/mShop/gno/GNODrawerHelper$1;

    invoke-direct {v1, p2}, Lcom/amazon/mShop/gno/GNODrawerHelper$1;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawer;->addListener(Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;)V

    .line 30
    if-eqz p1, :cond_1

    .line 31
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonActivity;->pushTemporaryBlankView()V

    .line 34
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->close()V

    goto :goto_0
.end method
