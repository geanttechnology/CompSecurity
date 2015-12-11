.class Lco/vine/android/ConfirmationFlowVerificationFragment$1;
.super Ljava/lang/Object;
.source "ConfirmationFlowVerificationFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/ConfirmationFlowVerificationFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConfirmationFlowVerificationFragment;

.field final synthetic val$confirmationBox:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lco/vine/android/ConfirmationFlowVerificationFragment;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lco/vine/android/ConfirmationFlowVerificationFragment$1;->this$0:Lco/vine/android/ConfirmationFlowVerificationFragment;

    iput-object p2, p0, Lco/vine/android/ConfirmationFlowVerificationFragment$1;->val$confirmationBox:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 112
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 99
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 103
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment$1;->val$confirmationBox:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 104
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment$1;->this$0:Lco/vine/android/ConfirmationFlowVerificationFragment;

    const/4 v1, 0x1

    # invokes: Lco/vine/android/ConfirmationFlowVerificationFragment;->toggleDoneAction(Z)V
    invoke-static {v0, v1}, Lco/vine/android/ConfirmationFlowVerificationFragment;->access$100(Lco/vine/android/ConfirmationFlowVerificationFragment;Z)V

    .line 108
    :goto_0
    return-void

    .line 106
    :cond_0
    iget-object v0, p0, Lco/vine/android/ConfirmationFlowVerificationFragment$1;->this$0:Lco/vine/android/ConfirmationFlowVerificationFragment;

    const/4 v1, 0x0

    # invokes: Lco/vine/android/ConfirmationFlowVerificationFragment;->toggleDoneAction(Z)V
    invoke-static {v0, v1}, Lco/vine/android/ConfirmationFlowVerificationFragment;->access$100(Lco/vine/android/ConfirmationFlowVerificationFragment;Z)V

    goto :goto_0
.end method
