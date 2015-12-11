.class public Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "CheckoutConfirmationFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$9;,
        Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;
    }
.end annotation


# instance fields
.field CURRENT_REDIRECT_URL_RETRY_COUNT:I

.field CURRENT_SUBMIT_ORDER_RETRY_COUNT:I

.field CURRENT_TR_DATA_RETRY_COUNT:I

.field DEFAULT_REQUEST_CODE:I

.field REDIRECT_URL_RETRY_COUNT:I

.field SUBMIT_ORDER_RETRY_COUNT:I

.field TR_DATA_RETRY_COUNT:I

.field checkoutFormInitiated:Z

.field protected current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

.field protected flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

.field protected viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x3

    const/4 v1, 0x0

    .line 61
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 66
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->DEFAULT_REQUEST_CODE:I

    .line 71
    iput v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->TR_DATA_RETRY_COUNT:I

    .line 72
    iput v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_TR_DATA_RETRY_COUNT:I

    .line 74
    iput v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->REDIRECT_URL_RETRY_COUNT:I

    .line 75
    iput v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_REDIRECT_URL_RETRY_COUNT:I

    .line 77
    iput v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->SUBMIT_ORDER_RETRY_COUNT:I

    .line 78
    iput v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_SUBMIT_ORDER_RETRY_COUNT:I

    .line 80
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->checkoutFormInitiated:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->processOrder()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->fireOrderViaBrainTree_Step2(Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;)V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Ljava/util/Map;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;
    .param p1, "x1"    # Ljava/util/Map;

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->fireOrderViaServer(Ljava/util/Map;)V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Lcom/poshmark/http/api/PMApiResponse;Lcom/poshmark/data_model/models/PMOrder;Ljava/util/Map;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Lcom/poshmark/data_model/models/PMOrder;
    .param p3, "x3"    # Ljava/util/Map;

    .prologue
    .line 61
    invoke-direct {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->handlePostOrderResponse(Lcom/poshmark/http/api/PMApiResponse;Lcom/poshmark/data_model/models/PMOrder;Ljava/util/Map;)V

    return-void
.end method

.method private fireOrderViaBrainTree_Step1()V
    .locals 3

    .prologue
    .line 233
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v0

    .line 234
    .local v0, "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$4;

    invoke-direct {v2, p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$4;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Lcom/poshmark/data_model/models/PMOrder;)V

    invoke-static {v1, v2}, Lcom/poshmark/http/api/PMApi;->getCreditCardGatewayData(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 256
    return-void
.end method

.method private fireOrderViaBrainTree_Step2(Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;)V
    .locals 5
    .param p1, "info"    # Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;

    .prologue
    .line 260
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v3}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v2

    .line 261
    .local v2, "order":Lcom/poshmark/data_model/models/PMOrder;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 262
    .local v1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v3, "form_action"

    iget-object v4, p1, Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;->form_action:Ljava/lang/String;

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 263
    const-string v3, "tr_data"

    iget-object v4, p1, Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;->tr_data:Ljava/lang/String;

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 264
    const-string v3, "transaction[billing][extended_address]"

    const/4 v4, 0x0

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 265
    const-string v3, "transaction[billing][locality]"

    iget-object v4, v2, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/Address;->getCity()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 266
    const-string v3, "transaction[billing][postal_code]"

    iget-object v4, v2, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/Address;->getZip()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 267
    const-string v3, "transaction[billing][region]"

    iget-object v4, v2, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/Address;->getState()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 268
    const-string v3, "transaction[billing][street_address]"

    iget-object v4, v2, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/Address;->getStreet()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 269
    const-string v3, "transaction[credit_card][cardholder_name]"

    iget-object v4, v2, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/Address;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 272
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v3}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v0

    .line 273
    .local v0, "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getNumber()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 274
    const-string v3, "transaction[credit_card][cvv]"

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getSecurityCode()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 275
    const-string v3, "transaction[credit_card][expiration_month]"

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getExpirationMonth()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 276
    const-string v3, "transaction[credit_card][expiration_year]"

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getExpirationYear()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 277
    const-string v3, "transaction[credit_card][number]"

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getNumber()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 285
    :goto_0
    iget-object v3, p1, Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;->form_action:Ljava/lang/String;

    new-instance v4, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;

    invoke-direct {v4, p0, v1, p1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Ljava/util/Map;Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;)V

    invoke-static {v1, v3, v4}, Lcom/poshmark/http/api/BrainTreeApi;->PostBrainTreeValidation(Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/BrainTreeHttpResponseHandler;)V

    .line 322
    return-void

    .line 279
    :cond_0
    const-string v3, "transaction[credit_card][cvv]"

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v4}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getSecurityCode()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    const-string v3, "transaction[credit_card][expiration_month]"

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v4}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getExpirationMonth()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    const-string v3, "transaction[credit_card][expiration_year]"

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v4}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getExpirationYear()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 282
    const-string v3, "transaction[credit_card][number]"

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v4}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getNumber()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private fireOrderViaServer(Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 325
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v0

    .line 327
    .local v0, "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const-string v3, "pch"

    invoke-static {v2, v3}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 328
    .local v1, "trackingJSON":Ljava/lang/String;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$6;

    invoke-direct {v3, p0, v0, p1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$6;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Lcom/poshmark/data_model/models/PMOrder;Ljava/util/Map;)V

    invoke-static {v2, p1, v1, v3}, Lcom/poshmark/http/api/PMApi;->postOrder(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 337
    return-void
.end method

.method private handleNewState()V
    .locals 2

    .prologue
    .line 168
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->checkoutFormInitiated:Z

    if-nez v0, :cond_0

    .line 169
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->checkoutFormInitiated:Z

    .line 170
    sget-object v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$9;->$SwitchMap$com$poshmark$ui$fragments$CheckoutConfirmationFragment$FLOW_STATE:[I

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 176
    :cond_0
    :goto_0
    return-void

    .line 172
    :pswitch_0
    sget-object v0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->launchCheckoutForm(Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;)V

    goto :goto_0

    .line 170
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method private handlePostOrderResponse(Lcom/poshmark/http/api/PMApiResponse;Lcom/poshmark/data_model/models/PMOrder;Ljava/util/Map;)V
    .locals 12
    .param p2, "order"    # Lcom/poshmark/data_model/models/PMOrder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/PMOrder;",
            ">;",
            "Lcom/poshmark/data_model/models/PMOrder;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOrder;>;"
    .local p3, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 342
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_3

    .line 344
    invoke-virtual {p2}, Lcom/poshmark/data_model/models/PMOrder;->isOrderCheckoutTypeBundle()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 345
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "bundle"

    const-string v3, "completed_order"

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 349
    :goto_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->trackTransaction()V

    .line 350
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->hideProgressDialog()V

    .line 351
    iput v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_SUBMIT_ORDER_RETRY_COUNT:I

    .line 352
    invoke-virtual {p2}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v9

    .line 353
    .local v9, "items":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/LineItem;>;"
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v0

    if-ge v7, v0, :cond_1

    .line 354
    invoke-interface {v9, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/poshmark/data_model/models/inner_models/LineItem;

    .line 355
    .local v8, "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getProductId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingEditedMessage(Ljava/lang/String;)V

    .line 353
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 347
    .end local v7    # "i":I
    .end local v8    # "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    .end local v9    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/LineItem;>;"
    :cond_0
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "listing"

    const-string v3, "completed_order"

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 359
    .restart local v7    # "i":I
    .restart local v9    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/LineItem;>;"
    :cond_1
    invoke-virtual {p2}, Lcom/poshmark/data_model/models/PMOrder;->getTotal()Ljava/math/BigDecimal;

    move-result-object v10

    .line 360
    .local v10, "orderTotal":Ljava/math/BigDecimal;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getHasOffersObject()Lcom/mobileapptracker/MobileAppTracker;

    move-result-object v6

    .line 361
    .local v6, "hasOffersObj":Lcom/mobileapptracker/MobileAppTracker;
    if-eqz v6, :cond_2

    .line 362
    const-string v0, "order"

    invoke-virtual {v10}, Ljava/math/BigDecimal;->doubleValue()D

    move-result-wide v2

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencyCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v0, v2, v3, v1}, Lcom/mobileapptracker/MobileAppTracker;->measureAction(Ljava/lang/String;DLjava/lang/String;)V

    .line 365
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-static {v0, v10}, Lcom/poshmark/utils/FBDPAHelper;->trackPurchase(Lcom/poshmark/utils/CheckoutFlowHandler;Ljava/math/BigDecimal;)V

    .line 367
    const v0, 0x7f060093

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const v0, 0x7f0601e7

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const v0, 0x7f060097

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v5, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$7;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$7;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;)V

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    .line 398
    .end local v6    # "hasOffersObj":Lcom/mobileapptracker/MobileAppTracker;
    .end local v7    # "i":I
    .end local v9    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/LineItem;>;"
    .end local v10    # "orderTotal":Ljava/math/BigDecimal;
    :goto_2
    return-void

    .line 380
    :cond_3
    iget v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_SUBMIT_ORDER_RETRY_COUNT:I

    iget v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->SUBMIT_ORDER_RETRY_COUNT:I

    if-gt v0, v1, :cond_4

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    invoke-virtual {v0}, Lcom/poshmark/http/api/PMApiError;->isNetworkDomainError()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 381
    iget v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_SUBMIT_ORDER_RETRY_COUNT:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_SUBMIT_ORDER_RETRY_COUNT:I

    .line 382
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "pch"

    invoke-static {v0, v1}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 383
    .local v11, "trackingJSON":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$8;

    invoke-direct {v1, p0, p2, p3}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$8;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Lcom/poshmark/data_model/models/PMOrder;Ljava/util/Map;)V

    invoke-static {v0, p3, v11, v1}, Lcom/poshmark/http/api/PMApi;->postOrder(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_2

    .line 392
    .end local v11    # "trackingJSON":Ljava/lang/String;
    :cond_4
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->hideProgressDialog()V

    .line 393
    iput v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_SUBMIT_ORDER_RETRY_COUNT:I

    .line 394
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SUBMIT_ORDER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    const v3, 0x7f0600f5

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_2
.end method

.method private processOrder()V
    .locals 4

    .prologue
    .line 216
    const v2, 0x7f06021e

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 217
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v1

    .line 218
    .local v1, "order":Lcom/poshmark/data_model/models/PMOrder;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->isPaymentInfoAvailable()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->isCreditCardUpdated()Z

    move-result v2

    if-nez v2, :cond_0

    .line 219
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 220
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "braintree_token"

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getBrainTreeToken()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 221
    const-string v2, "checkout_type"

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getCheckoutType()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    const-string v2, "inventory_unit_ids"

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getInventoryUnitIds()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 223
    const-string v2, "order_id"

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 224
    const-string v2, "user_id"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 225
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->fireOrderViaServer(Ljava/util/Map;)V

    .line 229
    .end local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return-void

    .line 227
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->fireOrderViaBrainTree_Step1()V

    goto :goto_0
.end method

.method private trackTransaction()V
    .locals 11

    .prologue
    .line 523
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v0}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v10

    .line 524
    .local v10, "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Poshmark"

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PMOrder;->getTotal()Ljava/math/BigDecimal;

    move-result-object v3

    invoke-virtual {v3}, Ljava/math/BigDecimal;->doubleValue()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PMOrder;->getTotalTax()Ljava/math/BigDecimal;

    move-result-object v4

    invoke-virtual {v4}, Ljava/math/BigDecimal;->doubleValue()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PMOrder;->getTotalShippingAmount()Ljava/math/BigDecimal;

    move-result-object v5

    invoke-virtual {v5}, Ljava/math/BigDecimal;->doubleValue()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v5

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencyCode()Ljava/lang/String;

    move-result-object v6

    invoke-virtual/range {v0 .. v6}, Lcom/poshmark/analytics/Analytics;->trackTransaction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V

    .line 535
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v8, v0, :cond_0

    .line 536
    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/poshmark/data_model/models/inner_models/LineItem;

    .line 537
    .local v9, "lineItem":Lcom/poshmark/data_model/models/inner_models/LineItem;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v9}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v9}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getId()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v4}, Lcom/poshmark/utils/CheckoutFlowHandler;->getListingDetails()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getCategoryLabel()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v9}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getPrice()Ljava/math/BigDecimal;

    move-result-object v5

    invoke-virtual {v5}, Ljava/math/BigDecimal;->doubleValue()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v5

    const-wide/16 v6, 0x1

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencyCode()Ljava/lang/String;

    move-result-object v7

    invoke-virtual/range {v0 .. v7}, Lcom/poshmark/analytics/Analytics;->addItem(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;)V

    .line 535
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 551
    .end local v9    # "lineItem":Lcom/poshmark/data_model/models/inner_models/LineItem;
    :cond_0
    const-string v0, "order"

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/PMOrder;->getTotal()Ljava/math/BigDecimal;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;Ljava/lang/String;)V

    .line 553
    return-void
.end method


# virtual methods
.method public done(I)V
    .locals 11
    .param p1, "resultCode"    # I

    .prologue
    const/4 v10, 0x0

    .line 556
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 557
    .local v0, "b":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/fragments/PMFragment;

    .line 558
    .local v5, "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v5, :cond_1

    .line 559
    const-string v6, "RESULT_CODE"

    invoke-virtual {v0, v6, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 560
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getTargetRequestCode()I

    move-result v4

    .line 561
    .local v4, "requestCode":I
    invoke-virtual {v5, v0, v4}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    .line 562
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    .line 563
    .local v3, "parent":Landroid/app/Activity;
    if-eqz v3, :cond_0

    .line 564
    invoke-virtual {v3}, Landroid/app/Activity;->onBackPressed()V

    .line 575
    .end local v3    # "parent":Landroid/app/Activity;
    .end local v4    # "requestCode":I
    :cond_0
    :goto_0
    return-void

    .line 567
    :cond_1
    if-nez p1, :cond_2

    .line 568
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v6}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v2

    .line 569
    .local v2, "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMOrder;->getOrderListingId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7, v10}, Lcom/poshmark/http/api/PMApi;->releaseOrder(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 570
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v1

    .line 571
    .local v1, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    iget-object v7, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v8, "listing"

    const-string v9, "removed_lineitem_from_order"

    invoke-virtual {v6, v7, v8, v9, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 573
    .end local v1    # "label":Ljava/lang/String;
    .end local v2    # "order":Lcom/poshmark/data_model/models/PMOrder;
    :cond_2
    invoke-virtual {p0, p1, v10}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public handleBack()Z
    .locals 6

    .prologue
    .line 507
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v1

    .line 508
    .local v1, "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderListingId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/poshmark/http/api/PMApi;->releaseOrder(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 509
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v0

    .line 510
    .local v0, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "removed_lineitem_from_order"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 511
    const/4 v2, 0x0

    return v2
.end method

.method protected launchCheckoutForm(Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;)V
    .locals 6
    .param p1, "mode"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    .prologue
    .line 515
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 516
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "CHECKOUT_FORM_MODE"

    invoke-virtual {p1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 517
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 518
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->ordinal()I

    move-result v5

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 520
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 131
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 132
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->updateListingSummary()V

    .line 133
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->setupHandlers()V

    .line 134
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 156
    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    .line 157
    sget-object v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->CHECKOUT:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    .line 158
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->updateView()V

    .line 165
    :cond_0
    :goto_0
    return-void

    .line 161
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->GATHER_DETAILS:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    if-ne v0, v1, :cond_0

    .line 162
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->done(I)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 88
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 89
    if-nez p1, :cond_3

    .line 90
    const-class v1, Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/utils/CheckoutFlowHandler;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    .line 100
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    if-eqz v1, :cond_2

    .line 102
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->isPaymentInfoAvailable()Z

    move-result v1

    if-nez v1, :cond_4

    .line 103
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->isCreditCardUpdated()Z

    move-result v1

    if-nez v1, :cond_1

    .line 104
    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->GATHER_DETAILS:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    .line 110
    :cond_1
    :goto_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->handleNewState()V

    .line 112
    :cond_2
    return-void

    .line 92
    :cond_3
    const-string v1, "NEXT_FORM_INITIATED"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->checkoutFormInitiated:Z

    .line 93
    const-string v1, "FLOW_HANDLER_OBJECT"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/os/ParcelUuid;

    .line 94
    .local v0, "key":Landroid/os/ParcelUuid;
    if-eqz v0, :cond_0

    .line 95
    invoke-virtual {v0}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/utils/CheckoutFlowHandler;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    goto :goto_0

    .line 107
    .end local v0    # "key":Landroid/os/ParcelUuid;
    :cond_4
    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->CHECKOUT:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 116
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 117
    const v1, 0x7f030022

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 118
    .local v0, "v":Landroid/view/View;
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->setupView(Landroid/view/View;)V

    .line 119
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->updateView()V

    .line 120
    return-object v0
.end method

.method public onPMResume()V
    .locals 1

    .prologue
    .line 125
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 126
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v0, p0}, Lcom/poshmark/utils/CheckoutFlowHandler;->setCallingFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 127
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 144
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 145
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    if-eqz v1, :cond_0

    .line 146
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 147
    .local v0, "id":Ljava/util/UUID;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-static {v0, v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 148
    const-string v1, "FLOW_HANDLER_OBJECT"

    new-instance v2, Landroid/os/ParcelUuid;

    invoke-direct {v2, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 151
    .end local v0    # "id":Ljava/util/UUID;
    :cond_0
    const-string v1, "NEXT_FORM_INITIATED"

    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->checkoutFormInitiated:Z

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 152
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 179
    const-string v0, "checkout_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 180
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 138
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 139
    const v0, 0x7f060078

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->setTitle(Ljava/lang/String;)V

    .line 140
    return-void
.end method

.method protected setupHandlers()V
    .locals 2

    .prologue
    .line 183
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeCreditCardInfoButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$1;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 191
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeShippingInfoButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$2;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 199
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->submitOrderButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$3;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 211
    return-void
.end method

.method protected setupView(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 463
    new-instance v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    invoke-direct {v0}, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    .line 466
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a2

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->singleItemSummaryAndPricingContainer:Landroid/widget/LinearLayout;

    .line 467
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->singleItemSummaryAndPricingContainer:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 469
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a3

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->itemSummaryLayout:Landroid/widget/LinearLayout;

    .line 470
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00b5

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMListingImageView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingImageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 471
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00b7

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingTitleView:Landroid/widget/TextView;

    .line 472
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00b8

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingSizeView:Landroid/widget/TextView;

    .line 473
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00b9

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingSellerView:Landroid/widget/TextView;

    .line 476
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0224

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->priceLabelView:Landroid/widget/TextView;

    .line 477
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0225

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->priceValueView:Landroid/widget/TextView;

    .line 478
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0226

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->taxesLabelView:Landroid/widget/TextView;

    .line 479
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0227

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->taxesValueView:Landroid/widget/TextView;

    .line 480
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0228

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->shippingLabelView:Landroid/widget/TextView;

    .line 481
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0229

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->shippingValueView:Landroid/widget/TextView;

    .line 482
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022a

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->totalLabelView:Landroid/widget/TextView;

    .line 483
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022b

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->totalValueView:Landroid/widget/TextView;

    .line 485
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022c

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditLayout:Landroid/widget/LinearLayout;

    .line 486
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022d

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditLabelView:Landroid/widget/TextView;

    .line 487
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022e

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditValueView:Landroid/widget/TextView;

    .line 489
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022f

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceLayout:Landroid/widget/LinearLayout;

    .line 490
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0230

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceLabelView:Landroid/widget/TextView;

    .line 491
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0231

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceValueView:Landroid/widget/TextView;

    .line 493
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0232

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->netChargeLayout:Landroid/widget/LinearLayout;

    .line 494
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0233

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->netChargeLabelView:Landroid/widget/TextView;

    .line 495
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0234

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->netChargeValueView:Landroid/widget/TextView;

    .line 497
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a7

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentTextView:Landroid/widget/TextView;

    .line 498
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a9

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->shipToTextView:Landroid/widget/TextView;

    .line 500
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a8

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeCreditCardInfoButton:Landroid/widget/Button;

    .line 501
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00aa

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeShippingInfoButton:Landroid/widget/Button;

    .line 502
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00ac

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->submitOrderButton:Landroid/widget/Button;

    .line 503
    return-void
.end method

.method protected updateListingSummary()V
    .locals 6

    .prologue
    .line 402
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v3}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v2

    .line 403
    .local v2, "poshmarkOrder":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v1

    .line 404
    .local v1, "lineItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/LineItem;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-nez v3, :cond_0

    .line 414
    :goto_0
    return-void

    .line 408
    :cond_0
    const/4 v3, 0x0

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/LineItem;

    .line 410
    .local v0, "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingImageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getPictureURL()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->loadImage(Ljava/lang/String;)V

    .line 411
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingTitleView:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 412
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingSizeView:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const v5, 0x7f060281

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getSize()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 413
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingSellerView:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const v5, 0x7f060249

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getSellerName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method protected updateView()V
    .locals 10

    .prologue
    const/16 v9, 0x8

    const/4 v8, 0x0

    .line 417
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    sget-object v6, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->GATHER_DETAILS:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    if-ne v5, v6, :cond_1

    .line 460
    :cond_0
    :goto_0
    return-void

    .line 420
    :cond_1
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v5}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v3

    .line 422
    .local v3, "poshmarkOrder":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_0

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getShippingAmount()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 425
    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v2

    .line 426
    .local v2, "currencySymbol":Ljava/lang/String;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getShippingAmount()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;

    .line 427
    .local v4, "shippingAmount":Lcom/poshmark/data_model/models/inner_models/ShippingAmount;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->priceValueView:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getBasePrice()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 428
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->taxesValueView:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getTotalTax()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 429
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->shippingValueView:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;->getAmount()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 430
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->totalValueView:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getTotal()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 432
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getCreditsToApply()Ljava/math/BigDecimal;

    move-result-object v5

    sget-object v6, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    invoke-virtual {v5, v6}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v5

    if-lez v5, :cond_3

    .line 433
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 434
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditValueView:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "-"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getCreditsToApply()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 440
    :goto_1
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getRedeemableToApply()Ljava/math/BigDecimal;

    move-result-object v5

    sget-object v6, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    invoke-virtual {v5, v6}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v5

    if-lez v5, :cond_4

    .line 441
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 442
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceValueView:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "-"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getRedeemableToApply()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 448
    :goto_2
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->netChargeValueView:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getNetBalance()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 450
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v5}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v1

    .line 451
    .local v1, "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    if-eqz v1, :cond_5

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getNumber()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_5

    .line 452
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5, v1}, Lcom/poshmark/utils/CreditCardUtils;->getStringFromCreditCard(Landroid/content/Context;Lcom/poshmark/data_model/models/inner_models/CreditCard;)Ljava/lang/String;

    move-result-object v0

    .line 453
    .local v0, "ccText":Ljava/lang/String;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeCreditCardInfoButton:Landroid/widget/Button;

    invoke-virtual {v5, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 459
    .end local v0    # "ccText":Ljava/lang/String;
    :cond_2
    :goto_3
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeShippingInfoButton:Landroid/widget/Button;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getShippingAddress()Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v6

    invoke-static {v6}, Lcom/poshmark/utils/AddressUtils;->addressStringWithoutPhone(Lcom/poshmark/data_model/models/inner_models/Address;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 437
    .end local v1    # "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    :cond_3
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_1

    .line 445
    :cond_4
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_2

    .line 455
    .restart local v1    # "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    :cond_5
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getLastPaymentInfo()Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 456
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getLastPaymentInfo()Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/poshmark/utils/CreditCardUtils;->getStringFromPaymentInfo(Landroid/content/Context;Lcom/poshmark/data_model/models/inner_models/PaymentInfo;)Ljava/lang/String;

    move-result-object v0

    .line 457
    .restart local v0    # "ccText":Ljava/lang/String;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeCreditCardInfoButton:Landroid/widget/Button;

    invoke-virtual {v5, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3
.end method
