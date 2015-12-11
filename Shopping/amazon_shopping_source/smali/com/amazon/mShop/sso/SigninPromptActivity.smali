.class public Lcom/amazon/mShop/sso/SigninPromptActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "SigninPromptActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 38
    const/4 v0, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    if-ne v0, v1, :cond_0

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_0

    .line 42
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->skipSigin(Landroid/content/Context;)V

    .line 44
    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 31
    if-nez p1, :cond_0

    const/4 v0, -0x1

    if-ne v0, p2, :cond_0

    .line 32
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/SigninPromptActivity;->finish()V

    .line 34
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x0

    .line 15
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 16
    invoke-virtual {p0}, Lcom/amazon/mShop/sso/SigninPromptActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/gno/GNODrawer;->lock(Z)V

    .line 17
    new-instance v0, Lcom/amazon/mShop/sso/SigninPromptView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/sso/SigninPromptView;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    .line 18
    .local v0, "view":Lcom/amazon/mShop/sso/SigninPromptView;
    invoke-virtual {p0, v0, v2}, Lcom/amazon/mShop/sso/SigninPromptActivity;->pushView(Landroid/view/View;Z)V

    .line 19
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 23
    const/4 v0, 0x0

    return v0
.end method
