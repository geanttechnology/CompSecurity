.class Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;
.super Landroid/app/Dialog;
.source "PopupDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/popup/PopupDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/popup/PopupDialogFragment;Landroid/content/Context;I)V
    .locals 0
    .param p2, "x0"    # Landroid/content/Context;
    .param p3, "x1"    # I

    .prologue
    .line 128
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment.1;"
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    invoke-direct {p0, p2, p3}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    return-void
.end method

.method private isOutOfBounds(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 147
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment.1;"
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    float-to-int v1, v3

    .line 148
    .local v1, "x":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    float-to-int v2, v3

    .line 149
    .local v2, "y":I
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 150
    .local v0, "decorView":Landroid/view/View;
    if-ltz v1, :cond_0

    if-ltz v2, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v3

    if-gt v1, v3, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v3

    if-le v2, v3, :cond_1

    :cond_0
    const/4 v3, 0x1

    :goto_0
    return v3

    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method


# virtual methods
.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 131
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment.1;"
    invoke-super {p0, p1}, Landroid/app/Dialog;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 132
    .local v0, "handled":Z
    if-nez v0, :cond_0

    .line 137
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;->isShowing()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_0

    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;->isOutOfBounds(Landroid/view/MotionEvent;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 139
    invoke-virtual {p0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;->cancel()V

    .line 140
    const/4 v0, 0x1

    .line 143
    .end local v0    # "handled":Z
    :cond_0
    return v0
.end method
