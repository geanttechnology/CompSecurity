.class public Lco/vine/android/ResetPasswordActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "ResetPasswordActivity.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ResetPasswordActivity$1;,
        Lco/vine/android/ResetPasswordActivity$ResetPasswordListener;
    }
.end annotation


# static fields
.field private static final DIALOG_CONFIRMED:I = 0x1

.field public static final EXTRA_EMAIL:Ljava/lang/String; = "email"


# instance fields
.field private mEmail:Landroid/widget/EditText;

.field private mSend:Landroid/view/MenuItem;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    .line 116
    return-void
.end method

.method private validate()Z
    .locals 2

    .prologue
    .line 113
    iget-object v0, p0, Lco/vine/android/ResetPasswordActivity;->mEmail:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    const/4 v1, 0x3

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "editable"    # Landroid/text/Editable;

    .prologue
    .line 109
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 98
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 33
    const v3, 0x7f030087

    invoke-super {p0, p1, v3, v7}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 34
    const-string v3, "input_method"

    invoke-virtual {p0, v3}, Lco/vine/android/ResetPasswordActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/inputmethod/InputMethodManager;

    .line 36
    .local v2, "imm":Landroid/view/inputmethod/InputMethodManager;
    invoke-virtual {p0}, Lco/vine/android/ResetPasswordActivity;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v3

    invoke-virtual {v2, v3, v7}, Landroid/view/inputmethod/InputMethodManager;->showSoftInputFromInputMethod(Landroid/os/IBinder;I)V

    .line 38
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    const v5, 0x7f0e0172

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {p0, v3, v4, v5, v6}, Lco/vine/android/ResetPasswordActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 40
    new-instance v3, Lco/vine/android/ResetPasswordActivity$ResetPasswordListener;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v4}, Lco/vine/android/ResetPasswordActivity$ResetPasswordListener;-><init>(Lco/vine/android/ResetPasswordActivity;Lco/vine/android/ResetPasswordActivity$1;)V

    iput-object v3, p0, Lco/vine/android/ResetPasswordActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 42
    const v3, 0x7f0a01e8

    invoke-virtual {p0, v3}, Lco/vine/android/ResetPasswordActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    .line 43
    .local v1, "email":Landroid/widget/EditText;
    invoke-virtual {v1, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 44
    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v3

    const/4 v4, 0x2

    invoke-virtual {v3, v7, v4}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/EditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 47
    invoke-virtual {p0}, Lco/vine/android/ResetPasswordActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 48
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    const-string v3, "email"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 49
    const-string v3, "email"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 50
    invoke-virtual {v1}, Landroid/widget/EditText;->length()I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/widget/EditText;->setSelection(I)V

    .line 52
    :cond_0
    iput-object v1, p0, Lco/vine/android/ResetPasswordActivity;->mEmail:Landroid/widget/EditText;

    .line 53
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 57
    invoke-virtual {p0}, Lco/vine/android/ResetPasswordActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v1, 0x7f100010

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 58
    const v0, 0x7f0a024b

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/ResetPasswordActivity;->mSend:Landroid/view/MenuItem;

    .line 59
    iget-object v0, p0, Lco/vine/android/ResetPasswordActivity;->mSend:Landroid/view/MenuItem;

    invoke-direct {p0}, Lco/vine/android/ResetPasswordActivity;->validate()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 60
    const/4 v0, 0x1

    return v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 65
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 79
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    :goto_0
    return v1

    .line 67
    :pswitch_0
    invoke-direct {p0}, Lco/vine/android/ResetPasswordActivity;->validate()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 68
    new-instance v0, Landroid/app/ProgressDialog;

    const v1, 0x7f0f0037

    invoke-direct {v0, p0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 70
    .local v0, "dialog":Landroid/app/ProgressDialog;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 71
    const v1, 0x7f0e00b9

    invoke-virtual {p0, v1}, Lco/vine/android/ResetPasswordActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 72
    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 73
    iput-object v0, p0, Lco/vine/android/ResetPasswordActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 74
    iget-object v1, p0, Lco/vine/android/ResetPasswordActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/ResetPasswordActivity;->mEmail:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/client/AppController;->resetPassword(Ljava/lang/String;)Ljava/lang/String;

    .line 76
    .end local v0    # "dialog":Landroid/app/ProgressDialog;
    :cond_0
    const/4 v1, 0x1

    goto :goto_0

    .line 65
    :pswitch_data_0
    .packed-switch 0x7f0a024b
        :pswitch_0
    .end packed-switch
.end method

.method protected onPause()V
    .locals 2

    .prologue
    .line 86
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onPause()V

    .line 87
    iget-object v0, p0, Lco/vine/android/ResetPasswordActivity;->mEmail:Landroid/widget/EditText;

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 88
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 92
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onResume()V

    .line 93
    iget-object v0, p0, Lco/vine/android/ResetPasswordActivity;->mEmail:Landroid/widget/EditText;

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 94
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 102
    iget-object v0, p0, Lco/vine/android/ResetPasswordActivity;->mSend:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lco/vine/android/ResetPasswordActivity;->mSend:Landroid/view/MenuItem;

    invoke-direct {p0}, Lco/vine/android/ResetPasswordActivity;->validate()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 105
    :cond_0
    return-void
.end method
