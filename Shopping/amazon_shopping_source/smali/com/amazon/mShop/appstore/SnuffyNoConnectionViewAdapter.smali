.class public Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;
.super Ljava/lang/Object;
.source "SnuffyNoConnectionViewAdapter.java"

# interfaces
.implements Lcom/amazon/venezia/web/NoConnectionViewAdapter;


# instance fields
.field private final errorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

.field private listener:Landroid/view/View$OnClickListener;


# direct methods
.method constructor <init>(Landroid/view/View;I)V
    .locals 7
    .param p1, "parentView"    # Landroid/view/View;
    .param p2, "viewId"    # I

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const/4 v5, 0x0

    iput-object v5, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->listener:Landroid/view/View$OnClickListener;

    .line 26
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 27
    .local v1, "context":Landroid/content/Context;
    sget v5, Lcom/amazon/mShop/android/lib/R$string;->error_network_no_connection_message:I

    invoke-virtual {v1, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x1

    invoke-static {v5, v6}, Lcom/amazon/mShop/util/UIUtils;->formatErrorMessage(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v3

    .line 30
    .local v3, "message":Ljava/lang/String;
    new-instance v5, Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-direct {v5, v1}, Lcom/amazon/mShop/error/AmazonErrorBox;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->errorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    move-object v4, p1

    .line 31
    check-cast v4, Landroid/view/ViewGroup;

    .line 32
    .local v4, "parent":Landroid/view/ViewGroup;
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 33
    .local v0, "C":Landroid/view/View;
    invoke-virtual {v4, v0}, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I

    move-result v2

    .line 34
    .local v2, "index":I
    invoke-virtual {v4, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 35
    iget-object v5, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->errorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Lcom/amazon/mShop/error/AmazonErrorBox;->setVisibility(I)V

    .line 36
    iget-object v5, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->errorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {v4, v5, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;I)V

    .line 37
    iget-object v5, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->errorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {v5, v3}, Lcom/amazon/mShop/error/AmazonErrorBox;->setMessage(Ljava/lang/CharSequence;)V

    .line 38
    iget-object v5, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->errorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    const/4 v6, -0x1

    invoke-virtual {v5, v6}, Lcom/amazon/mShop/error/AmazonErrorBox;->setBackgroundColor(I)V

    .line 39
    iget-object v5, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->errorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    invoke-virtual {v5}, Lcom/amazon/mShop/error/AmazonErrorBox;->bringToFront()V

    .line 40
    return-void
.end method


# virtual methods
.method public getView()Landroid/view/View;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->errorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    return-object v0
.end method

.method public setOnReloadListener(Landroid/view/View$OnClickListener;)V
    .locals 3
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->listener:Landroid/view/View$OnClickListener;

    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->errorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/error/AmazonErrorBox;->setButtonOnClick(ILandroid/view/View$OnClickListener;)V

    .line 53
    return-void
.end method

.method public setReloadEnabled(Z)V
    .locals 3
    .param p1, "enabled"    # Z

    .prologue
    .line 58
    iget-object v1, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->errorBox:Lcom/amazon/mShop/error/AmazonErrorBox;

    const/4 v2, 0x1

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapter;->listener:Landroid/view/View$OnClickListener;

    :goto_0
    invoke-virtual {v1, v2, v0}, Lcom/amazon/mShop/error/AmazonErrorBox;->setButtonOnClick(ILandroid/view/View$OnClickListener;)V

    .line 59
    return-void

    .line 58
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
