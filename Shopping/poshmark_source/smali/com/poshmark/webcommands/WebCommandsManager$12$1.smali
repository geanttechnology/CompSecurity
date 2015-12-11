.class Lcom/poshmark/webcommands/WebCommandsManager$12$1;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager$12;->runOnUIThread(Ljava/lang/Object;)V
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
        "Lcom/poshmark/data_model/models/PMOfferInfo;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager$12;)V
    .locals 0

    .prologue
    .line 724
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/PMOfferInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 727
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOfferInfo;>;"
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 728
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->hideProgressDialog()V

    .line 729
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 730
    new-instance v3, Lcom/poshmark/utils/OfferFlowHandler;

    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v2, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMOfferInfo;

    invoke-direct {v3, v2, v0}, Lcom/poshmark/utils/OfferFlowHandler;-><init>(Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/data_model/models/PMOfferInfo;)V

    .line 731
    .local v3, "offerFlowHandler":Lcom/poshmark/utils/OfferFlowHandler;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 732
    .local v1, "b":Landroid/os/Bundle;
    const-string v0, "CHECKOUT_FORM_MODE"

    sget-object v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->ordinal()I

    move-result v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 733
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    iget-object v4, v4, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v4, v4, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v5, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    iget-object v5, v5, Lcom/poshmark/webcommands/WebCommandsManager$12;->val$command:Lcom/poshmark/webcommands/WebCommand;

    invoke-virtual {v5}, Lcom/poshmark/webcommands/WebCommand;->commandHashCode()I

    move-result v5

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 746
    .end local v1    # "b":Landroid/os/Bundle;
    .end local v3    # "offerFlowHandler":Lcom/poshmark/utils/OfferFlowHandler;
    :cond_0
    :goto_0
    return-void

    .line 735
    :cond_1
    new-instance v6, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SUBMIT_ORDER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    iget-object v4, v4, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v4, v4, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const v5, 0x7f0600f4

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/MappPageFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v6, v0, v2, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    .line 738
    .local v6, "actionErrorContext":Lcom/poshmark/ui/model/ActionErrorContext;
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    iget-object v2, v2, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v2, v2, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const v4, 0x7f0600d0

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/MappPageFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v4, v6, Lcom/poshmark/ui/model/ActionErrorContext;->message:Ljava/lang/String;

    new-instance v5, Lcom/poshmark/webcommands/WebCommandsManager$12$1$1;

    invoke-direct {v5, p0}, Lcom/poshmark/webcommands/WebCommandsManager$12$1$1;-><init>(Lcom/poshmark/webcommands/WebCommandsManager$12$1;)V

    invoke-virtual {v0, v2, v4, v5}, Lcom/poshmark/ui/fragments/MappPageFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V

    goto :goto_0
.end method
