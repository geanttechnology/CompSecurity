.class public abstract Lcom/xfinity/playerlib/view/programdetails/DetailActivity;
.super Lcom/xfinity/playerlib/view/PlayNowActivity;
.source "DetailActivity.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/PlayNowActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 28
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;->finish()V

    .line 29
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 12
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/PlayNowActivity;->onCreate(Landroid/os/Bundle;)V

    .line 13
    const-string v0, ""

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 14
    return-void
.end method

.method protected setupTalkDelegateForAccessibilityViaLayout()V
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->isTabletDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 20
    sget v0, Lcom/xfinity/playerlib/R$style;->Theme_xfinity:I

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;->setTheme(I)V

    .line 23
    :cond_0
    invoke-super {p0}, Lcom/xfinity/playerlib/view/PlayNowActivity;->setupTalkDelegateForAccessibilityViaLayout()V

    .line 24
    return-void
.end method
