.class Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;
.super Ljava/lang/Object;
.source "ChangePasswordFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ChangePasswordFragment;->setupNextActionButton()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 92
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->hideKeyboard()V

    .line 93
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    # invokes: Lcom/poshmark/ui/fragments/ChangePasswordFragment;->isFormValid()Z
    invoke-static {v2}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->access$100(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 94
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    const v4, 0x7f0602b5

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 95
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    # getter for: Lcom/poshmark/ui/fragments/ChangePasswordFragment;->originalPassword:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->access$200(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 96
    .local v1, "oldPasswordTxt":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    # getter for: Lcom/poshmark/ui/fragments/ChangePasswordFragment;->newPassword:Lcom/poshmark/ui/customviews/PMEditText;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->access$300(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)Lcom/poshmark/ui/customviews/PMEditText;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 98
    .local v0, "newPasswordTxt":Ljava/lang/String;
    new-instance v2, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ChangePasswordFragment$2$1;-><init>(Lcom/poshmark/ui/fragments/ChangePasswordFragment$2;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->postNewPassword(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 115
    .end local v0    # "newPasswordTxt":Ljava/lang/String;
    .end local v1    # "oldPasswordTxt":Ljava/lang/String;
    :cond_0
    return-void
.end method
