.class Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;
.super Ljava/lang/Object;
.source "AuthenticationActivity.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/authentication/AuthenticationActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HTCEditTextFix"
.end annotation


# instance fields
.field private mEditText:Landroid/widget/EditText;

.field final synthetic this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/authentication/AuthenticationActivity;Landroid/widget/EditText;)V
    .locals 0
    .param p2, "editText"    # Landroid/widget/EditText;

    .prologue
    .line 317
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>.HTCEditTextFix;"
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;->this$0:Lcom/comcast/cim/android/authentication/AuthenticationActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 318
    iput-object p2, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;->mEditText:Landroid/widget/EditText;

    .line 319
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 320
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>.HTCEditTextFix;"
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 321
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>.HTCEditTextFix;"
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 3
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 323
    .local p0, "this":Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;, "Lcom/comcast/cim/android/authentication/AuthenticationActivity<TT;TS;>.HTCEditTextFix;"
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/AuthenticationActivity$HTCEditTextFix;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    new-instance v1, Landroid/text/style/ForegroundColorSpan;

    const/4 v2, -0x1

    invoke-direct {v1, v2}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/16 v2, 0x21

    invoke-interface {v0, v1, p2, p2, v2}, Landroid/text/Editable;->setSpan(Ljava/lang/Object;III)V

    .line 324
    return-void
.end method
