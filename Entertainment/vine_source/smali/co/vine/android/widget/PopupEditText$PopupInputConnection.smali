.class Lco/vine/android/widget/PopupEditText$PopupInputConnection;
.super Landroid/view/inputmethod/InputConnectionWrapper;
.source "PopupEditText.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/PopupEditText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PopupInputConnection"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/widget/PopupEditText;


# direct methods
.method public constructor <init>(Lco/vine/android/widget/PopupEditText;Landroid/view/inputmethod/InputConnection;Z)V
    .locals 0
    .param p2, "target"    # Landroid/view/inputmethod/InputConnection;
    .param p3, "mutable"    # Z

    .prologue
    .line 603
    iput-object p1, p0, Lco/vine/android/widget/PopupEditText$PopupInputConnection;->this$0:Lco/vine/android/widget/PopupEditText;

    .line 604
    invoke-direct {p0, p2, p3}, Landroid/view/inputmethod/InputConnectionWrapper;-><init>(Landroid/view/inputmethod/InputConnection;Z)V

    .line 605
    return-void
.end method


# virtual methods
.method public deleteSurroundingText(II)Z
    .locals 3
    .param p1, "beforeLength"    # I
    .param p2, "afterLength"    # I

    .prologue
    .line 620
    iget-object v0, p0, Lco/vine/android/widget/PopupEditText$PopupInputConnection;->this$0:Lco/vine/android/widget/PopupEditText;

    # getter for: Lco/vine/android/widget/PopupEditText;->mSelectedEntity:Lco/vine/android/api/VineEntity;
    invoke-static {v0}, Lco/vine/android/widget/PopupEditText;->access$100(Lco/vine/android/widget/PopupEditText;)Lco/vine/android/api/VineEntity;

    move-result-object v0

    if-eqz v0, :cond_0

    if-lez p1, :cond_0

    if-nez p2, :cond_0

    .line 621
    new-instance v0, Landroid/view/KeyEvent;

    const/4 v1, 0x0

    const/16 v2, 0x43

    invoke-direct {v0, v1, v2}, Landroid/view/KeyEvent;-><init>(II)V

    invoke-virtual {p0, v0}, Lco/vine/android/widget/PopupEditText$PopupInputConnection;->sendKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    .line 623
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/view/inputmethod/InputConnectionWrapper;->deleteSurroundingText(II)Z

    move-result v0

    goto :goto_0
.end method

.method public sendKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x1

    .line 609
    iget-object v1, p0, Lco/vine/android/widget/PopupEditText$PopupInputConnection;->this$0:Lco/vine/android/widget/PopupEditText;

    # getter for: Lco/vine/android/widget/PopupEditText;->mSelectedEntity:Lco/vine/android/api/VineEntity;
    invoke-static {v1}, Lco/vine/android/widget/PopupEditText;->access$100(Lco/vine/android/widget/PopupEditText;)Lco/vine/android/api/VineEntity;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    const/16 v2, 0x43

    if-ne v1, v2, :cond_0

    .line 611
    iget-object v1, p0, Lco/vine/android/widget/PopupEditText$PopupInputConnection;->this$0:Lco/vine/android/widget/PopupEditText;

    iget-object v2, p0, Lco/vine/android/widget/PopupEditText$PopupInputConnection;->this$0:Lco/vine/android/widget/PopupEditText;

    # getter for: Lco/vine/android/widget/PopupEditText;->mSelectedEntity:Lco/vine/android/api/VineEntity;
    invoke-static {v2}, Lco/vine/android/widget/PopupEditText;->access$100(Lco/vine/android/widget/PopupEditText;)Lco/vine/android/api/VineEntity;

    move-result-object v2

    iget v2, v2, Lco/vine/android/api/VineEntity;->start:I

    invoke-virtual {v1, v2, v0}, Lco/vine/android/widget/PopupEditText;->clearSelectedEntity(IZ)Z

    .line 614
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/view/inputmethod/InputConnectionWrapper;->sendKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method
