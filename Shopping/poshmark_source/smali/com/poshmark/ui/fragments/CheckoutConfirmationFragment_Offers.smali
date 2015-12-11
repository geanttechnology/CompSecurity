.class public Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;
.super Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;
.source "CheckoutConfirmationFragment_Offers.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;
    }
.end annotation


# instance fields
.field derivedClassView:Landroid/view/View;

.field fixedPaymentFailed:Z

.field mode:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;-><init>()V

    .line 52
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->derivedClassView:Landroid/view/View;

    .line 53
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->fixedPaymentFailed:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->processOffer()V

    return-void
.end method

.method private encryptFormField(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 331
    new-instance v0, Lcom/braintreegateway/encryption/Braintree;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->getEncryptionKey()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/braintreegateway/encryption/Braintree;-><init>(Ljava/lang/String;)V

    .line 333
    .local v0, "braintree":Lcom/braintreegateway/encryption/Braintree;
    :try_start_0
    invoke-virtual {v0, p1}, Lcom/braintreegateway/encryption/Braintree;->encrypt(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lcom/braintreegateway/encryption/BraintreeEncryptionException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 335
    :goto_0
    return-object v2

    .line 334
    :catch_0
    move-exception v1

    .line 335
    .local v1, "e":Lcom/braintreegateway/encryption/BraintreeEncryptionException;
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private fireOffer(Ljava/util/Map;Ljava/lang/String;)V
    .locals 3
    .param p2, "trackingJSON"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 293
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v0

    .line 295
    .local v0, "order":Lcom/poshmark/data_model/models/PMOrder;
    const-string v1, "Processing..."

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 296
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;

    invoke-direct {v2, p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;Lcom/poshmark/data_model/models/PMOrder;)V

    invoke-static {v1, p1, p2, v2}, Lcom/poshmark/http/api/PMApi;->postOffer(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 328
    return-void
.end method

.method private processOffer()V
    .locals 11

    .prologue
    .line 258
    iget-object v9, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v9}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v6

    .line 259
    .local v6, "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PMOrder;->getBrainTreeToken()Ljava/lang/String;

    move-result-object v7

    .line 261
    .local v7, "token":Ljava/lang/String;
    iget-object v9, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v9}, Lcom/poshmark/utils/CheckoutFlowHandler;->isCreditCardUpdated()Z

    move-result v9

    if-eqz v9, :cond_2

    .line 263
    iget-object v9, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v9}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v3

    .line 264
    .local v3, "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    new-instance v1, Lcom/poshmark/data_model/models/EncryptedCreditCardInfo;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/EncryptedCreditCardInfo;-><init>()V

    .line 265
    .local v1, "ccInfo":Lcom/poshmark/data_model/models/EncryptedCreditCardInfo;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getNumber()Ljava/lang/String;

    move-result-object v9

    invoke-direct {p0, v9}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->encryptFormField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    iput-object v9, v1, Lcom/poshmark/data_model/models/EncryptedCreditCardInfo;->cc_number:Ljava/lang/String;

    .line 266
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    invoke-static {v9, v3}, Lcom/poshmark/utils/CreditCardUtils;->getFormattedCreditCardExpirationDate(Landroid/content/Context;Lcom/poshmark/data_model/models/inner_models/CreditCard;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {p0, v9}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->encryptFormField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    iput-object v9, v1, Lcom/poshmark/data_model/models/EncryptedCreditCardInfo;->cc_exp_date:Ljava/lang/String;

    .line 267
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getSecurityCode()Ljava/lang/String;

    move-result-object v9

    invoke-direct {p0, v9}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->encryptFormField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    iput-object v9, v1, Lcom/poshmark/data_model/models/EncryptedCreditCardInfo;->cc_cvv:Ljava/lang/String;

    .line 269
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 270
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v4

    .line 271
    .local v4, "gson":Lcom/google/gson/Gson;
    const-class v9, Lcom/poshmark/data_model/models/EncryptedCreditCardInfo;

    instance-of v10, v4, Lcom/google/gson/Gson;

    if-nez v10, :cond_1

    invoke-virtual {v4, v1, v9}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 273
    .end local v4    # "gson":Lcom/google/gson/Gson;
    .local v2, "cc_json":Ljava/lang/String;
    :goto_0
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 274
    .local v5, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v9, "cc_new_token_response"

    invoke-interface {v5, v9, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 275
    const-string v9, "payment_type"

    const-string v10, "bt"

    invoke-interface {v5, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 276
    const-string v9, "post_id"

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PMOrder;->getOrderListingId()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v5, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 277
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    const-string v10, "ofr_s"

    invoke-static {v9, v10}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 278
    .local v8, "trackingJSON":Ljava/lang/String;
    invoke-direct {p0, v5, v8}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->fireOffer(Ljava/util/Map;Ljava/lang/String;)V

    .line 290
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v1    # "ccInfo":Lcom/poshmark/data_model/models/EncryptedCreditCardInfo;
    .end local v2    # "cc_json":Ljava/lang/String;
    .end local v3    # "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    .end local v5    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v8    # "trackingJSON":Ljava/lang/String;
    :cond_0
    :goto_1
    return-void

    .line 271
    .restart local v0    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v1    # "ccInfo":Lcom/poshmark/data_model/models/EncryptedCreditCardInfo;
    .restart local v3    # "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    .restart local v4    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast v4, Lcom/google/gson/Gson;

    .end local v4    # "gson":Lcom/google/gson/Gson;
    invoke-static {v4, v1, v9}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 280
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v1    # "ccInfo":Lcom/poshmark/data_model/models/EncryptedCreditCardInfo;
    .end local v3    # "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    :cond_2
    if-eqz v7, :cond_0

    .line 282
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 283
    .restart local v5    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v9, "cc_token"

    invoke-interface {v5, v9, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 284
    const-string v9, "payment_type"

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PMOrder;->getLastPaymentInfo()Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/inner_models/PaymentInfo;->getPaymentType()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v5, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 285
    const-string v9, "post_id"

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PMOrder;->getOrderListingId()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v5, v9, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 286
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    const-string v10, "ofr_s"

    invoke-static {v9, v10}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 287
    .restart local v8    # "trackingJSON":Ljava/lang/String;
    invoke-direct {p0, v5, v8}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->fireOffer(Ljava/util/Map;Ljava/lang/String;)V

    goto :goto_1
.end method


# virtual methods
.method public handleBack()Z
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 341
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->setCreditCardUpdated(Z)V

    .line 342
    return v1
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 89
    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    .line 90
    sget-object v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->CHECKOUT:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    .line 91
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->fixedPaymentFailed:Z

    .line 92
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->updateView()V

    .line 99
    :cond_0
    :goto_0
    return-void

    .line 95
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->GATHER_DETAILS:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    if-ne v0, v1, :cond_0

    .line 96
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->done(I)V

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 59
    const v1, 0x7f030091

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 60
    .local v0, "v":Landroid/view/View;
    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->derivedClassView:Landroid/view/View;

    .line 61
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOffer()Lcom/poshmark/data_model/models/PMOffer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOffer;->getStatus()Ljava/lang/String;

    move-result-object v1

    const-string v2, "pf"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 62
    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->EXISTING_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->mode:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    .line 66
    :goto_0
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->setupView(Landroid/view/View;)V

    .line 67
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->updateView()V

    .line 68
    return-object v0

    .line 64
    :cond_0
    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->NEW_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->mode:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    goto :goto_0
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 73
    invoke-super {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->onPMResume()V

    .line 74
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v0}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOffer()Lcom/poshmark/data_model/models/PMOffer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOffer;->getStatus()Ljava/lang/String;

    move-result-object v0

    const-string v1, "pf"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v0, p0}, Lcom/poshmark/utils/CheckoutFlowHandler;->setCallingFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 77
    :cond_0
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 81
    invoke-super {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->setupActionBar()V

    .line 82
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->mode:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->NEW_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    if-ne v0, v1, :cond_0

    .line 83
    const v0, 0x7f0601df

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->setTitle(Ljava/lang/String;)V

    .line 85
    :cond_0
    return-void
.end method

.method protected setupHandlers()V
    .locals 2

    .prologue
    .line 230
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeCreditCardInfoButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$1;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 238
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeShippingInfoButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$2;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 246
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->submitOrderButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$3;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 254
    return-void
.end method

.method protected setupView(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 103
    new-instance v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    invoke-direct {v0}, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    .line 105
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a3

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->itemSummaryLayout:Landroid/widget/LinearLayout;

    .line 106
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00b5

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMListingImageView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingImageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 107
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00b7

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingTitleView:Landroid/widget/TextView;

    .line 108
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00b8

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingSizeView:Landroid/widget/TextView;

    .line 109
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00b9

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->listingSellerView:Landroid/widget/TextView;

    .line 112
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0224

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->priceLabelView:Landroid/widget/TextView;

    .line 113
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0225

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->priceValueView:Landroid/widget/TextView;

    .line 114
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0226

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->taxesLabelView:Landroid/widget/TextView;

    .line 115
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0227

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->taxesValueView:Landroid/widget/TextView;

    .line 116
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0228

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->shippingLabelView:Landroid/widget/TextView;

    .line 117
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0229

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->shippingValueView:Landroid/widget/TextView;

    .line 118
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022a

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->totalLabelView:Landroid/widget/TextView;

    .line 119
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022b

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->totalValueView:Landroid/widget/TextView;

    .line 121
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022c

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditLayout:Landroid/widget/LinearLayout;

    .line 122
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022d

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditLabelView:Landroid/widget/TextView;

    .line 123
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022e

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditValueView:Landroid/widget/TextView;

    .line 125
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c022f

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceLayout:Landroid/widget/LinearLayout;

    .line 126
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0230

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceLabelView:Landroid/widget/TextView;

    .line 127
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0231

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceValueView:Landroid/widget/TextView;

    .line 129
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0232

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->netChargeLayout:Landroid/widget/LinearLayout;

    .line 130
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0233

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->netChargeLabelView:Landroid/widget/TextView;

    .line 131
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0234

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->netChargeValueView:Landroid/widget/TextView;

    .line 133
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a7

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentTextView:Landroid/widget/TextView;

    .line 134
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a9

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->shipToTextView:Landroid/widget/TextView;

    .line 136
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a8

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeCreditCardInfoButton:Landroid/widget/Button;

    .line 137
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00aa

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeShippingInfoButton:Landroid/widget/Button;

    .line 138
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00ac

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->submitOrderButton:Landroid/widget/Button;

    .line 140
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->derivedClassView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 141
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v1, 0x7f0c0221

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoLeftBorder:Landroid/view/View;

    .line 142
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v1, 0x7f0c021f

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoTopBorder:Landroid/view/View;

    .line 143
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v1, 0x7f0c0222

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoRightBorder:Landroid/view/View;

    .line 144
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v1, 0x7f0c0220

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoBottomBorder:Landroid/view/View;

    .line 145
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c0223

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->offerInfoText:Lcom/poshmark/ui/customviews/PMTextView;

    .line 147
    :cond_0
    return-void
.end method

.method protected updateView()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/16 v8, 0x8

    .line 151
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    sget-object v6, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->GATHER_DETAILS:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    if-ne v5, v6, :cond_1

    .line 226
    :cond_0
    :goto_0
    return-void

    .line 154
    :cond_1
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v5}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v3

    .line 156
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

    .line 159
    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v2

    .line 160
    .local v2, "currencySymbol":Ljava/lang/String;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getShippingAmount()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/inner_models/ShippingAmount;

    .line 161
    .local v4, "shippingAmount":Lcom/poshmark/data_model/models/inner_models/ShippingAmount;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

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

    .line 162
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

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

    .line 163
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

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

    .line 164
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

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

    .line 166
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getCreditsToApply()Ljava/math/BigDecimal;

    move-result-object v5

    sget-object v6, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    invoke-virtual {v5, v6}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v5

    if-lez v5, :cond_3

    .line 167
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 168
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

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

    .line 174
    :goto_1
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getRedeemableToApply()Ljava/math/BigDecimal;

    move-result-object v5

    sget-object v6, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    invoke-virtual {v5, v6}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v5

    if-lez v5, :cond_4

    .line 175
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 176
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

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

    .line 182
    :goto_2
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

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

    .line 184
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v5}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v1

    .line 185
    .local v1, "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    if-eqz v1, :cond_5

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getNumber()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_5

    .line 186
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5, v1}, Lcom/poshmark/utils/CreditCardUtils;->getStringFromCreditCard(Landroid/content/Context;Lcom/poshmark/data_model/models/inner_models/CreditCard;)Ljava/lang/String;

    move-result-object v0

    .line 187
    .local v0, "ccText":Ljava/lang/String;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeCreditCardInfoButton:Landroid/widget/Button;

    invoke-virtual {v5, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 193
    .end local v0    # "ccText":Ljava/lang/String;
    :cond_2
    :goto_3
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeShippingInfoButton:Landroid/widget/Button;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getShippingAddress()Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v6

    invoke-static {v6}, Lcom/poshmark/utils/AddressUtils;->addressStringWithoutPhone(Lcom/poshmark/data_model/models/inner_models/Address;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 195
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->derivedClassView:Landroid/view/View;

    if-eqz v5, :cond_0

    .line 196
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->mode:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    sget-object v6, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->NEW_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    if-ne v5, v6, :cond_6

    .line 197
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->submitOrderButton:Landroid/widget/Button;

    const v6, 0x7f06028e

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(I)V

    .line 198
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoLeftBorder:Landroid/view/View;

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    .line 199
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoTopBorder:Landroid/view/View;

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    .line 200
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoRightBorder:Landroid/view/View;

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    .line 201
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoBottomBorder:Landroid/view/View;

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 171
    .end local v1    # "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    :cond_3
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->poshCreditLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_1

    .line 179
    :cond_4
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->redeemableBalanceLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_2

    .line 189
    .restart local v1    # "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    :cond_5
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getLastPaymentInfo()Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 190
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getLastPaymentInfo()Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/poshmark/utils/CreditCardUtils;->getStringFromPaymentInfo(Landroid/content/Context;Lcom/poshmark/data_model/models/inner_models/PaymentInfo;)Ljava/lang/String;

    move-result-object v0

    .line 191
    .restart local v0    # "ccText":Ljava/lang/String;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeCreditCardInfoButton:Landroid/widget/Button;

    invoke-virtual {v5, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3

    .line 203
    .end local v0    # "ccText":Ljava/lang/String;
    :cond_6
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->offerInfoText:Lcom/poshmark/ui/customviews/PMTextView;

    if-eqz v5, :cond_7

    .line 204
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->offerInfoText:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v5, v8}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 206
    :cond_7
    iget-boolean v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->fixedPaymentFailed:Z

    if-eqz v5, :cond_8

    .line 208
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoLeftBorder:Landroid/view/View;

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    .line 209
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoTopBorder:Landroid/view/View;

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    .line 210
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoRightBorder:Landroid/view/View;

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    .line 211
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoBottomBorder:Landroid/view/View;

    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    .line 213
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentTextView:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f090038

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 215
    :cond_8
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->submitOrderButton:Landroid/widget/Button;

    const v6, 0x7f06028f

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(I)V

    .line 217
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoLeftBorder:Landroid/view/View;

    invoke-virtual {v5, v9}, Landroid/view/View;->setVisibility(I)V

    .line 218
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoTopBorder:Landroid/view/View;

    invoke-virtual {v5, v9}, Landroid/view/View;->setVisibility(I)V

    .line 219
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoRightBorder:Landroid/view/View;

    invoke-virtual {v5, v9}, Landroid/view/View;->setVisibility(I)V

    .line 220
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentInfoBottomBorder:Landroid/view/View;

    invoke-virtual {v5, v9}, Landroid/view/View;->setVisibility(I)V

    .line 222
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->paymentTextView:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f09000c

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0
.end method
