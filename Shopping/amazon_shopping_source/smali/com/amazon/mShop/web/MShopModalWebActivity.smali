.class public Lcom/amazon/mShop/web/MShopModalWebActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "MShopModalWebActivity.java"


# instance fields
.field private mSupportGNO:Z

.field private mSupportMenu:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 17
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    .line 18
    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopModalWebActivity;->mSupportMenu:Z

    .line 19
    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopModalWebActivity;->mSupportGNO:Z

    return-void
.end method


# virtual methods
.method public isSupportGNO()Z
    .locals 1

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopModalWebActivity;->mSupportGNO:Z

    return v0
.end method

.method public isSupportMenu()Z
    .locals 1

    .prologue
    .line 22
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopModalWebActivity;->mSupportMenu:Z

    return v0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->isSupportMenu()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 45
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->onPrepareOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    .line 47
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setSupportGNO(Z)V
    .locals 2
    .param p1, "supportGNO"    # Z

    .prologue
    .line 34
    iput-boolean p1, p0, Lcom/amazon/mShop/web/MShopModalWebActivity;->mSupportGNO:Z

    .line 35
    if-eqz p1, :cond_0

    .line 36
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNODrawer;->unlock()V

    .line 40
    :goto_0
    return-void

    .line 38
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawer;->lock(Z)V

    goto :goto_0
.end method

.method public setSupportMenu(Z)V
    .locals 0
    .param p1, "supportMenu"    # Z

    .prologue
    .line 26
    iput-boolean p1, p0, Lcom/amazon/mShop/web/MShopModalWebActivity;->mSupportMenu:Z

    .line 27
    return-void
.end method
