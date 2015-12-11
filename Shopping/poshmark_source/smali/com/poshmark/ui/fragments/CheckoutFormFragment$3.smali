.class Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;
.super Ljava/lang/Object;
.source "CheckoutFormFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutFormFragment;->postAddressesToServerAndFinish()V
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
        "Lcom/poshmark/data_model/models/PMOrder;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0

    .prologue
    .line 406
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

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
            "Lcom/poshmark/data_model/models/PMOrder;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 409
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOrder;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 410
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->hideProgressDialog()V

    .line 411
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_4

    .line 412
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/CheckoutFlowHandler;

    move-result-object v2

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/data_model/models/PMOrder;

    invoke-virtual {v2, v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->updatePoshmarkOrder(Lcom/poshmark/data_model/models/PMOrder;)V

    .line 414
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/CheckoutFlowHandler;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v0

    .line 415
    .local v0, "label":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$400(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    move-result-object v1

    sget-object v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CREDIT_CARD:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-eq v1, v2, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$400(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    move-result-object v1

    sget-object v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v1, v2, :cond_3

    .line 417
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/CheckoutFlowHandler;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->copy(Lcom/poshmark/data_model/models/inner_models/CreditCard;)V

    .line 418
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/CheckoutFlowHandler;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->setCreditCardUpdated(Z)V

    .line 422
    :cond_1
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 428
    .end local v0    # "label":Ljava/lang/String;
    :cond_2
    :goto_1
    return-void

    .line 419
    .restart local v0    # "label":Ljava/lang/String;
    :cond_3
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$400(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    move-result-object v1

    sget-object v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v1, v2, :cond_1

    .line 420
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "listing"

    const-string v4, "updated_order_address"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 424
    .end local v0    # "label":Ljava/lang/String;
    :cond_4
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->UPDATE_ORDER_ADDRESS:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    const v6, 0x7f0600d6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v2, v3, v4, v5, v6}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_1
.end method
