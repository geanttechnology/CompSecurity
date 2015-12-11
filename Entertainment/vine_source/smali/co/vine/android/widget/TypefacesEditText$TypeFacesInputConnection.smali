.class Lco/vine/android/widget/TypefacesEditText$TypeFacesInputConnection;
.super Landroid/view/inputmethod/InputConnectionWrapper;
.source "TypefacesEditText.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/TypefacesEditText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TypeFacesInputConnection"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/widget/TypefacesEditText;


# direct methods
.method public constructor <init>(Lco/vine/android/widget/TypefacesEditText;Landroid/view/inputmethod/InputConnection;Z)V
    .locals 0
    .param p2, "target"    # Landroid/view/inputmethod/InputConnection;
    .param p3, "mutable"    # Z

    .prologue
    .line 83
    iput-object p1, p0, Lco/vine/android/widget/TypefacesEditText$TypeFacesInputConnection;->this$0:Lco/vine/android/widget/TypefacesEditText;

    .line 84
    invoke-direct {p0, p2, p3}, Landroid/view/inputmethod/InputConnectionWrapper;-><init>(Landroid/view/inputmethod/InputConnection;Z)V

    .line 85
    return-void
.end method


# virtual methods
.method public sendKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 89
    iget-object v0, p0, Lco/vine/android/widget/TypefacesEditText$TypeFacesInputConnection;->this$0:Lco/vine/android/widget/TypefacesEditText;

    # getter for: Lco/vine/android/widget/TypefacesEditText;->mKeyboardListener:Lco/vine/android/widget/TypefacesEditText$KeyboardListener;
    invoke-static {v0}, Lco/vine/android/widget/TypefacesEditText;->access$000(Lco/vine/android/widget/TypefacesEditText;)Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/widget/TypefacesEditText$TypeFacesInputConnection;->this$0:Lco/vine/android/widget/TypefacesEditText;

    # getter for: Lco/vine/android/widget/TypefacesEditText;->mKeyboardListener:Lco/vine/android/widget/TypefacesEditText$KeyboardListener;
    invoke-static {v0}, Lco/vine/android/widget/TypefacesEditText;->access$000(Lco/vine/android/widget/TypefacesEditText;)Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

    move-result-object v0

    invoke-interface {v0, p1}, Lco/vine/android/widget/TypefacesEditText$KeyboardListener;->sendKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    invoke-super {p0, p1}, Landroid/view/inputmethod/InputConnectionWrapper;->sendKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
