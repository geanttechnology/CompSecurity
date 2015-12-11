.class Lcom/poshmark/ui/fragments/ChangePasswordFragment$1;
.super Ljava/lang/Object;
.source "ChangePasswordFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ChangePasswordFragment;->checkIfPasswordIsSet()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Lcom/poshmark/user/UserInfoDetails$PasswordStatus;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$1;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/user/UserInfoDetails$PasswordStatus;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 68
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/user/UserInfoDetails$PasswordStatus;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$1;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 69
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$1;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->hideProgressDialog()V

    .line 70
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_0

    .line 71
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/user/UserInfoDetails$PasswordStatus;

    .line 72
    .local v0, "passwordStatus":Lcom/poshmark/user/UserInfoDetails$PasswordStatus;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$1;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    iget-boolean v2, v0, Lcom/poshmark/user/UserInfoDetails$PasswordStatus;->password_set:Z

    iput-boolean v2, v1, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->isPasswordSet:Z

    .line 73
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ChangePasswordFragment$1;->this$0:Lcom/poshmark/ui/fragments/ChangePasswordFragment;

    # invokes: Lcom/poshmark/ui/fragments/ChangePasswordFragment;->updateView()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ChangePasswordFragment;->access$000(Lcom/poshmark/ui/fragments/ChangePasswordFragment;)V

    .line 78
    .end local v0    # "passwordStatus":Lcom/poshmark/user/UserInfoDetails$PasswordStatus;
    :cond_0
    return-void
.end method
