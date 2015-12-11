.class Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;
.super Ljava/lang/Object;
.source "CheckoutFormFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CheckoutFormFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0

    .prologue
    .line 354
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 357
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->isValidInput()Z
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$100(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 360
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$400(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    move-result-object v1

    sget-object v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CREDIT_CARD:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v1, v2, :cond_2

    .line 361
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->saveCreditCardInfo()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$200(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    .line 362
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/CheckoutFlowHandler;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v0

    .line 363
    .local v0, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "listing"

    const-string v4, "update_credit_card"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 364
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    move-result-object v1

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCheckbox:Landroid/widget/CheckBox;

    invoke-virtual {v1}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 366
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$700(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$600(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/Address;->copy(Lcom/poshmark/data_model/models/inner_models/Address;)V

    .line 370
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->postAddressesToServerAndFinish()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$900(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    .line 377
    .end local v0    # "label":Ljava/lang/String;
    :cond_0
    :goto_1
    return-void

    .line 368
    .restart local v0    # "label":Ljava/lang/String;
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->populateBillingAddress()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$800(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    goto :goto_0

    .line 371
    .end local v0    # "label":Ljava/lang/String;
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$400(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    move-result-object v1

    sget-object v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v1, v2, :cond_0

    .line 372
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/CheckoutFlowHandler;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v0

    .line 373
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "listing"

    const-string v4, "update_shipping_address"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 374
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->checkAddressValidity()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$300(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    goto :goto_1
.end method
