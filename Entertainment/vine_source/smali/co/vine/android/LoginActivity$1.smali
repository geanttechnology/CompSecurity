.class Lco/vine/android/LoginActivity$1;
.super Ljava/lang/Object;
.source "LoginActivity.java"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/LoginActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/LoginActivity;


# direct methods
.method constructor <init>(Lco/vine/android/LoginActivity;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lco/vine/android/LoginActivity$1;->this$0:Lco/vine/android/LoginActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v3, 0x0

    .line 81
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    const/16 v2, 0x42

    if-eq v1, v2, :cond_1

    :cond_0
    const/4 v1, 0x6

    if-ne p2, v1, :cond_2

    iget-object v1, p0, Lco/vine/android/LoginActivity$1;->this$0:Lco/vine/android/LoginActivity;

    # invokes: Lco/vine/android/LoginActivity;->validate()Z
    invoke-static {v1}, Lco/vine/android/LoginActivity;->access$000(Lco/vine/android/LoginActivity;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 82
    :cond_1
    iget-object v1, p0, Lco/vine/android/LoginActivity$1;->this$0:Lco/vine/android/LoginActivity;

    const-string v2, "input_method"

    invoke-virtual {v1, v2}, Lco/vine/android/LoginActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 84
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    iget-object v1, p0, Lco/vine/android/LoginActivity$1;->this$0:Lco/vine/android/LoginActivity;

    # getter for: Lco/vine/android/LoginActivity;->mPassword:Landroid/widget/EditText;
    invoke-static {v1}, Lco/vine/android/LoginActivity;->access$100(Lco/vine/android/LoginActivity;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 85
    iget-object v1, p0, Lco/vine/android/LoginActivity$1;->this$0:Lco/vine/android/LoginActivity;

    # invokes: Lco/vine/android/LoginActivity;->login(Z)V
    invoke-static {v1, v3}, Lco/vine/android/LoginActivity;->access$200(Lco/vine/android/LoginActivity;Z)V

    .line 87
    .end local v0    # "imm":Landroid/view/inputmethod/InputMethodManager;
    :cond_2
    const/4 v1, 0x1

    return v1
.end method
