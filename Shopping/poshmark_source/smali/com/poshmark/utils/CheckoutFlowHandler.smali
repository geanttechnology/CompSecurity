.class public Lcom/poshmark/utils/CheckoutFlowHandler;
.super Ljava/lang/Object;
.source "CheckoutFlowHandler.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/CheckoutFlowHandler$MODE;
    }
.end annotation


# instance fields
.field protected callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field protected creditCard:Lcom/poshmark/data_model/models/inner_models/CreditCard;

.field protected creditCardUpdated:Z

.field protected listing:Lcom/poshmark/data_model/models/ListingSummary;

.field protected poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-instance v0, Lcom/poshmark/data_model/models/PMOrder;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/PMOrder;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    .line 35
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/CreditCard;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/CreditCard;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->creditCard:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->creditCardUpdated:Z

    .line 41
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 1
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-instance v0, Lcom/poshmark/data_model/models/PMOrder;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/PMOrder;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    .line 35
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/CreditCard;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/CreditCard;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->creditCard:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->creditCardUpdated:Z

    .line 44
    iput-object p1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 45
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/utils/CheckoutFlowHandler;Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/CheckoutFlowHandler;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/poshmark/utils/CheckoutFlowHandler;->handleAddProductResponse(Lcom/poshmark/http/api/PMApiResponse;)V

    return-void
.end method

.method private handleAddProductResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 6
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
    .line 118
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOrder;>;"
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 119
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 120
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMOrder;

    iput-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    .line 121
    invoke-virtual {p0}, Lcom/poshmark/utils/CheckoutFlowHandler;->showSingleItemConfirmationForm()V

    .line 122
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const/4 v1, 0x0

    const-string v2, "listing"

    const-string v3, "added_lineitem_to_order"

    iget-object v4, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    :goto_0
    return-void

    .line 125
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->ADD_PRODUCT_TO_ORDER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v5, 0x7f0600d5

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private isAddressInfoAvailable()Z
    .locals 2

    .prologue
    .line 131
    const/4 v0, 0x0

    .line 132
    .local v0, "retVal":Z
    iget-object v1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    iget-object v1, v1, Lcom/poshmark/data_model/models/PMOrder;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->isDataAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    iget-object v1, v1, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->isDataAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 133
    const/4 v0, 0x1

    .line 135
    :cond_0
    return v0
.end method

.method private showFormToAddPaymentAndShippingInfo()V
    .locals 4

    .prologue
    .line 139
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 140
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "CHECKOUT_FORM_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 141
    iget-object v2, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 142
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-virtual {v1, v0, v2, p0}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 143
    return-void
.end method


# virtual methods
.method protected addProductWithId(Ljava/lang/String;)V
    .locals 5
    .param p1, "productId"    # Ljava/lang/String;

    .prologue
    .line 96
    if-eqz p1, :cond_0

    iget-object v2, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-nez v2, :cond_1

    .line 115
    :cond_0
    :goto_0
    return-void

    .line 99
    :cond_1
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 100
    .local v0, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "checkout_type"

    const-string v3, "bnow"

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    const-string v2, "product_ids"

    invoke-virtual {v0, v2, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    const-string v2, "order_id"

    const-string v3, "self"

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 103
    const-string v2, "user_id"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    iget-object v2, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v3, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v4, 0x7f0601e8

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 106
    iget-object v2, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const-string v3, "cart"

    invoke-static {v2, v3}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 107
    .local v1, "trackingJSON":Ljava/lang/String;
    new-instance v2, Lcom/poshmark/utils/CheckoutFlowHandler$1;

    invoke-direct {v2, p0}, Lcom/poshmark/utils/CheckoutFlowHandler$1;-><init>(Lcom/poshmark/utils/CheckoutFlowHandler;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->addProductToOrder(Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method public addressesEqual()Z
    .locals 2

    .prologue
    .line 77
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    iget-object v0, v0, Lcom/poshmark/data_model/models/PMOrder;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    iget-object v1, v1, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->isSameAs(Lcom/poshmark/data_model/models/inner_models/Address;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 78
    const/4 v0, 0x1

    .line 80
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public beginCheckoutForListing(Lcom/poshmark/data_model/models/ListingSummary;)V
    .locals 1
    .param p1, "listingDetails"    # Lcom/poshmark/data_model/models/ListingSummary;

    .prologue
    .line 52
    if-nez p1, :cond_0

    .line 58
    :goto_0
    return-void

    .line 55
    :cond_0
    iput-object p1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->listing:Lcom/poshmark/data_model/models/ListingSummary;

    .line 56
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->listing:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/CheckoutFlowHandler;->addProductWithId(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->creditCard:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    return-object v0
.end method

.method public getEncryptionKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 164
    const/4 v0, 0x0

    return-object v0
.end method

.method public getListingDetails()Lcom/poshmark/data_model/models/ListingSummary;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->listing:Lcom/poshmark/data_model/models/ListingSummary;

    return-object v0
.end method

.method public getPoshmarkOffer()Lcom/poshmark/data_model/models/PMOffer;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    instance-of v0, v0, Lcom/poshmark/data_model/models/PMOffer;

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    check-cast v0, Lcom/poshmark/data_model/models/PMOffer;

    .line 72
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    return-object v0
.end method

.method public isCreditCardUpdated()Z
    .locals 1

    .prologue
    .line 84
    iget-boolean v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->creditCardUpdated:Z

    return v0
.end method

.method public isPaymentInfoAvailable()Z
    .locals 2

    .prologue
    .line 155
    const/4 v0, 0x0

    .line 156
    .local v0, "retVal":Z
    iget-object v1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->isCreditCardInfoValid()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 157
    const/4 v0, 0x1

    .line 160
    :cond_0
    return v0
.end method

.method public setCallingFragment(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 0
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 49
    return-void
.end method

.method public setCreditCardUpdated(Z)V
    .locals 0
    .param p1, "updated"    # Z

    .prologue
    .line 88
    iput-boolean p1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->creditCardUpdated:Z

    .line 89
    return-void
.end method

.method protected showSingleItemConfirmationForm()V
    .locals 4

    .prologue
    .line 146
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 147
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "CHECKOUT_FORM_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 148
    iget-object v2, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 149
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v1, :cond_0

    .line 150
    const-class v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    invoke-virtual {v1, v0, v2, p0}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 152
    :cond_0
    return-void
.end method

.method public updatePoshmarkOrder(Lcom/poshmark/data_model/models/PMOrder;)V
    .locals 0
    .param p1, "order"    # Lcom/poshmark/data_model/models/PMOrder;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/poshmark/utils/CheckoutFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    .line 93
    return-void
.end method
