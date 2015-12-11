.class public Lcom/amazon/mShop/util/KeyUtils;
.super Ljava/lang/Object;
.source "KeyUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isActionMatching(Landroid/view/KeyEvent;I)Z
    .locals 1
    .param p0, "event"    # Landroid/view/KeyEvent;
    .param p1, "action"    # I

    .prologue
    .line 22
    invoke-virtual {p0}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isEventMatching(Landroid/view/KeyEvent;II)Z
    .locals 1
    .param p0, "event"    # Landroid/view/KeyEvent;
    .param p1, "keyCode"    # I
    .param p2, "action"    # I

    .prologue
    .line 41
    invoke-static {p0, p1}, Lcom/amazon/mShop/util/KeyUtils;->isKeyCodeMatching(Landroid/view/KeyEvent;I)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0, p2}, Lcom/amazon/mShop/util/KeyUtils;->isActionMatching(Landroid/view/KeyEvent;I)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isKeyCodeMatching(Landroid/view/KeyEvent;I)Z
    .locals 1
    .param p0, "event"    # Landroid/view/KeyEvent;
    .param p1, "keyCode"    # I

    .prologue
    .line 31
    invoke-virtual {p0}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
