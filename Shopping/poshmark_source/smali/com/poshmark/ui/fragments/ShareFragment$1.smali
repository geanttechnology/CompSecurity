.class Lcom/poshmark/ui/fragments/ShareFragment$1;
.super Ljava/lang/Object;
.source "ShareFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShareFragment;->loadReferralData()V
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
        "Lcom/poshmark/data_model/models/Referral;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShareFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/Referral;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 215
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/Referral;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ShareFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 216
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ShareFragment;->hideProgressDialog()V

    .line 217
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 218
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v1, v0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v1, v0}, Lcom/poshmark/utils/ShareManager;->setReferralData(Lcom/poshmark/data_model/models/Referral;)V

    .line 219
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_0

    .line 220
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->referralMessageView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v1}, Lcom/poshmark/utils/ShareManager;->getReferralData()Lcom/poshmark/data_model/models/Referral;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/Referral;->getProgram()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 221
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->referralCodeView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v1}, Lcom/poshmark/utils/ShareManager;->getReferralData()Lcom/poshmark/data_model/models/Referral;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 234
    :cond_0
    :goto_0
    return-void

    .line 225
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_REFERRAL_CODE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShareFragment$1;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    const v5, 0x7f0600ec

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/ShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    new-instance v2, Lcom/poshmark/ui/fragments/ShareFragment$1$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ShareFragment$1$1;-><init>(Lcom/poshmark/ui/fragments/ShareFragment$1;)V

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/ShareFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    goto :goto_0
.end method
