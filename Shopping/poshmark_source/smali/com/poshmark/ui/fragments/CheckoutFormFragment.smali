.class public Lcom/poshmark/ui/fragments/CheckoutFormFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "CheckoutFormFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/CheckoutFormFragment$15;,
        Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;,
        Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;
    }
.end annotation


# instance fields
.field private PICK_ADDRESS:I

.field private billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

.field cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

.field private checkedChangeListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field private checkoutButtonListener:Landroid/view/View$OnClickListener;

.field private currentInputEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

.field private flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

.field private focusChangeListener:Landroid/view/View$OnFocusChangeListener;

.field private formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

.field mode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;

.field private nextButtonListener:Landroid/view/View$OnClickListener;

.field private otl:Landroid/view/View$OnTouchListener;

.field private shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

.field private tapListener:Lcom/poshmark/ui/customviews/PMEditText$OnTapListener;

.field private updatedShippingAddress:Landroid/os/Bundle;

.field private viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 58
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->PICK_ADDRESS:I

    .line 59
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/CreditCard;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/CreditCard;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    .line 61
    sget-object v0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;->BUY_MODE:Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->mode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;

    .line 73
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/Address;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    .line 74
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/Address;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    .line 75
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    .line 220
    new-instance v0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->checkoutButtonListener:Landroid/view/View$OnClickListener;

    .line 354
    new-instance v0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$2;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->nextButtonListener:Landroid/view/View$OnClickListener;

    .line 504
    new-instance v0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$6;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$6;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->tapListener:Lcom/poshmark/ui/customviews/PMEditText$OnTapListener;

    .line 511
    new-instance v0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->otl:Landroid/view/View$OnTouchListener;

    .line 532
    new-instance v0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->focusChangeListener:Landroid/view/View$OnFocusChangeListener;

    .line 550
    new-instance v0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$9;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$9;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->checkedChangeListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/CheckoutFlowHandler;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    return-object v0
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->isValidInput()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;Lcom/poshmark/data_model/models/AddressCheckerResults;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/AddressCheckerResults;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->fireAddressPickerFragment(Lcom/poshmark/data_model/models/AddressCheckerResults;)V

    return-void
.end method

.method static synthetic access$1100(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/ui/customviews/LabelledEditText;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->currentInputEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    return-object v0
.end method

.method static synthetic access$1102(Lcom/poshmark/ui/fragments/CheckoutFormFragment;Lcom/poshmark/ui/customviews/LabelledEditText;)Lcom/poshmark/ui/customviews/LabelledEditText;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;
    .param p1, "x1"    # Lcom/poshmark/ui/customviews/LabelledEditText;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->currentInputEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    return-object p1
.end method

.method static synthetic access$1200(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showCreditCardExpirationSelectorDialog()V

    return-void
.end method

.method static synthetic access$1300(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showStateSelectorDialog()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->saveCreditCardInfo()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->checkAddressValidity()V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    return-object v0
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    return-object v0
.end method

.method static synthetic access$600(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/data_model/models/inner_models/Address;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    return-object v0
.end method

.method static synthetic access$700(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/data_model/models/inner_models/Address;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    return-object v0
.end method

.method static synthetic access$800(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->populateBillingAddress()V

    return-void
.end method

.method static synthetic access$900(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    .prologue
    .line 57
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->postAddressesToServerAndFinish()V

    return-void
.end method

.method private checkAddressValidity()V
    .locals 2

    .prologue
    .line 460
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v0, v1, :cond_1

    .line 461
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->populateShippingAddress()V

    .line 462
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v0}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    .line 473
    :cond_0
    :goto_0
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 474
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    new-instance v1, Lcom/poshmark/ui/fragments/CheckoutFormFragment$5;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$5;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getAddressConfirmation(Lcom/poshmark/data_model/models/inner_models/Address;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 494
    return-void

    .line 463
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v0, v1, :cond_0

    .line 464
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->populateShippingAddress()V

    .line 465
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCheckbox:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 467
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->copy(Lcom/poshmark/data_model/models/inner_models/Address;)V

    goto :goto_0

    .line 469
    :cond_2
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->populateBillingAddress()V

    goto :goto_0
.end method

.method private fireAddressPickerFragment(Lcom/poshmark/data_model/models/AddressCheckerResults;)V
    .locals 6
    .param p1, "results"    # Lcom/poshmark/data_model/models/AddressCheckerResults;

    .prologue
    .line 498
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 499
    .local v1, "b":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 500
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/AddressMatchFragment;

    iget v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->PICK_ADDRESS:I

    move-object v3, p1

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 502
    return-void
.end method

.method private isValidInput()Z
    .locals 5

    .prologue
    .line 268
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2}, Ljava/lang/String;-><init>()V

    .line 269
    .local v2, "validateTxt":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v4, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CREDIT_CARD:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-eq v3, v4, :cond_0

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v4, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v3, v4, :cond_1

    .line 271
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->validateCCInfo()Ljava/lang/String;

    move-result-object v2

    .line 273
    :cond_1
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCheckbox:Landroid/widget/CheckBox;

    invoke-virtual {v3}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v1

    .line 274
    .local v1, "isBillingSameAsShipping":Z
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v4, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CREDIT_CARD:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v3, v4, :cond_3

    .line 276
    if-nez v1, :cond_2

    .line 277
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->validateBillingInfo()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 294
    :cond_2
    :goto_0
    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_7

    .line 295
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f060148

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3, v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 296
    const/4 v3, 0x0

    .line 299
    :goto_1
    return v3

    .line 279
    :cond_3
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v4, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v3, v4, :cond_6

    .line 280
    if-nez v1, :cond_5

    .line 281
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 282
    .local v0, "billingInfoValidateTxt":Ljava/lang/String;
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->validateBillingInfo()Ljava/lang/String;

    move-result-object v0

    .line 283
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 284
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->validateShippingInfo()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 286
    :cond_4
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 287
    goto :goto_0

    .line 288
    .end local v0    # "billingInfoValidateTxt":Ljava/lang/String;
    :cond_5
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->validateShippingInfo()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 290
    :cond_6
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v4, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v3, v4, :cond_2

    .line 291
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->validateShippingInfo()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 299
    :cond_7
    const/4 v3, 0x1

    goto :goto_1
.end method

.method private populateBillingAddress()V
    .locals 2

    .prologue
    .line 258
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingNameEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setName(Ljava/lang/String;)V

    .line 259
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStreetEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setStreet(Ljava/lang/String;)V

    .line 260
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStreet2EditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setStreet2(Ljava/lang/String;)V

    .line 261
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setCity(Ljava/lang/String;)V

    .line 262
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setState(Ljava/lang/String;)V

    .line 263
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingZipEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setZip(Ljava/lang/String;)V

    .line 264
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingPhoneEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setPhone(Ljava/lang/String;)V

    .line 265
    return-void
.end method

.method private populateShippingAddress()V
    .locals 2

    .prologue
    .line 248
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingNameEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setName(Ljava/lang/String;)V

    .line 249
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStreetEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setStreet(Ljava/lang/String;)V

    .line 250
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStreet2EditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setStreet2(Ljava/lang/String;)V

    .line 251
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingCityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setCity(Ljava/lang/String;)V

    .line 252
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setState(Ljava/lang/String;)V

    .line 253
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingZipEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setZip(Ljava/lang/String;)V

    .line 254
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingPhoneEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setPhone(Ljava/lang/String;)V

    .line 255
    return-void
.end method

.method private postAddressesToServerAndFinish()V
    .locals 4

    .prologue
    .line 391
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/Address;->isSameAs(Lcom/poshmark/data_model/models/inner_models/Address;)Z

    move-result v1

    .line 392
    .local v1, "areAddressesSame":Z
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    const-string v3, "shipping"

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/Address;->setType(Ljava/lang/String;)V

    .line 393
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    const-string v3, "billing"

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/Address;->setType(Ljava/lang/String;)V

    .line 394
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 395
    .local v0, "addressData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "billing"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/Address;->getJsonString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 396
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->mode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;->BUY_MODE:Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;

    if-ne v2, v3, :cond_0

    .line 398
    const-string v2, "inventory_unit_ids"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v3}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->getInventoryUnitIds()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 400
    :cond_0
    const-string v2, "is_same_as_shipping"

    invoke-static {v1}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 401
    const-string v2, "shipping"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/Address;->getJsonString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 402
    const-string v2, "validated"

    const-string v3, "true"

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 404
    const v2, 0x7f0602b5

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 405
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->mode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;

    sget-object v3, Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;->BUY_MODE:Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;

    if-ne v2, v3, :cond_1

    .line 406
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$3;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    invoke-static {v2, v0, v3}, Lcom/poshmark/http/api/PMApi;->postOrderAddresses(Ljava/lang/String;Ljava/util/Map;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 457
    :goto_0
    return-void

    .line 431
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/CheckoutFormFragment$4;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$4;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    invoke-static {v2, v0, v3}, Lcom/poshmark/http/api/PMApi;->postOfferAddresses(Ljava/lang/String;Ljava/util/Map;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private saveCreditCardInfo()V
    .locals 2

    .prologue
    .line 381
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->cardNumberEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->setNumber(Ljava/lang/String;)V

    .line 382
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->securityCodeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->setSecurityCode(Ljava/lang/String;)V

    .line 383
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCheckbox:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 384
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->setUseShippingAddress(Z)V

    .line 388
    :goto_0
    return-void

    .line 386
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->setUseShippingAddress(Z)V

    goto :goto_0
.end method

.method private setupCCExpirationView(Landroid/view/View;)V
    .locals 14
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/high16 v13, 0x60000

    const/16 v12, 0x14

    const/16 v11, 0xc

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 648
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v4

    .line 649
    .local v4, "now":Ljava/util/Calendar;
    invoke-virtual {v4, v10}, Ljava/util/Calendar;->get(I)I

    move-result v5

    .line 650
    .local v5, "year":I
    const/4 v8, 0x2

    invoke-virtual {v4, v8}, Ljava/util/Calendar;->get(I)I

    move-result v1

    .line 653
    .local v1, "month":I
    new-array v3, v11, [Ljava/lang/String;

    .line 655
    .local v3, "months":[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v8, v3

    if-ge v0, v8, :cond_0

    .line 656
    add-int/lit8 v8, v0, 0x1

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v3, v0

    .line 655
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 658
    :cond_0
    const v8, 0x7f0c009b

    invoke-virtual {p1, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/NumberPicker;

    .line 659
    .local v2, "monthPicker":Landroid/widget/NumberPicker;
    invoke-virtual {v2, v13}, Landroid/widget/NumberPicker;->setDescendantFocusability(I)V

    .line 660
    invoke-virtual {v2, v11}, Landroid/widget/NumberPicker;->setMaxValue(I)V

    .line 661
    invoke-virtual {v2, v10}, Landroid/widget/NumberPicker;->setMinValue(I)V

    .line 662
    invoke-virtual {v2, v9}, Landroid/widget/NumberPicker;->setWrapSelectorWheel(Z)V

    .line 663
    invoke-virtual {v2, v3}, Landroid/widget/NumberPicker;->setDisplayedValues([Ljava/lang/String;)V

    .line 664
    add-int/lit8 v8, v1, 0x1

    invoke-virtual {v2, v8}, Landroid/widget/NumberPicker;->setValue(I)V

    .line 667
    new-array v7, v12, [Ljava/lang/String;

    .line 668
    .local v7, "years":[Ljava/lang/String;
    const/4 v0, 0x0

    :goto_1
    if-ge v0, v12, :cond_1

    .line 669
    add-int v8, v5, v0

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v0

    .line 668
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 671
    :cond_1
    const v8, 0x7f0c009c

    invoke-virtual {p1, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/NumberPicker;

    .line 672
    .local v6, "yearPicker":Landroid/widget/NumberPicker;
    invoke-virtual {v6, v13}, Landroid/widget/NumberPicker;->setDescendantFocusability(I)V

    .line 673
    add-int/lit8 v8, v5, 0x13

    invoke-virtual {v6, v8}, Landroid/widget/NumberPicker;->setMaxValue(I)V

    .line 674
    invoke-virtual {v6, v5}, Landroid/widget/NumberPicker;->setMinValue(I)V

    .line 675
    invoke-virtual {v6, v9}, Landroid/widget/NumberPicker;->setWrapSelectorWheel(Z)V

    .line 676
    invoke-virtual {v6, v7}, Landroid/widget/NumberPicker;->setDisplayedValues([Ljava/lang/String;)V

    .line 677
    invoke-virtual {v6, v5}, Landroid/widget/NumberPicker;->setValue(I)V

    .line 678
    return-void
.end method

.method private setupView(Landroid/view/View;)V
    .locals 10
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/high16 v9, 0x41f00000    # 30.0f

    const/16 v8, 0x8

    const/4 v7, 0x0

    .line 681
    new-instance v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    invoke-direct {v5}, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;-><init>()V

    iput-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    .line 683
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00ae

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->firstTimeInfoLayout:Landroid/widget/RelativeLayout;

    .line 684
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00b1

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->offerInfoLink:Lcom/poshmark/ui/customviews/PMTextView;

    .line 685
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00a3

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->itemSummaryLayout:Landroid/widget/LinearLayout;

    .line 686
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00ad

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleItemSummaryLayout:Landroid/widget/LinearLayout;

    .line 688
    const/4 v0, 0x0

    .line 689
    .local v0, "firtOffer":Z
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v5}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOffer()Lcom/poshmark/data_model/models/PMOffer;

    move-result-object v3

    .line 690
    .local v3, "offer":Lcom/poshmark/data_model/models/PMOffer;
    if-eqz v3, :cond_1

    .line 691
    iget-object v5, v3, Lcom/poshmark/data_model/models/PMOffer;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    if-eqz v5, :cond_0

    iget-object v5, v3, Lcom/poshmark/data_model/models/PMOffer;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/Address;->isDataAvailable()Z

    move-result v5

    if-nez v5, :cond_1

    .line 692
    :cond_0
    const/4 v0, 0x1

    .line 696
    :cond_1
    if-nez v0, :cond_6

    .line 697
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v6, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v5, v6, :cond_5

    .line 698
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v5}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v4

    .line 699
    .local v4, "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMOrder;->isOrderCheckoutTypeBundle()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 700
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->itemSummaryLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 701
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleItemSummaryLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 719
    .end local v4    # "order":Lcom/poshmark/data_model/models/PMOrder;
    :goto_0
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00b5

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMListingImageView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->listingImageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 720
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00b7

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->listingTitleView:Landroid/widget/TextView;

    .line 721
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00b8

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->listingSizeView:Landroid/widget/TextView;

    .line 722
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00b9

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->listingSellerView:Landroid/widget/TextView;

    .line 725
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c0074

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMListingImageView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleListingImageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 726
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c0075

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleItemsCountIndicator:Lcom/poshmark/ui/customviews/PMTextView;

    .line 727
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c0077

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleTitleView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 728
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c0078

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundlePriceView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 729
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c0079

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleItemsCountView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 730
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c007a

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleSellerNameView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 733
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00a7

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->paymentTitleTextView:Landroid/widget/TextView;

    .line 735
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00b2

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->creditCardInfoLayout:Landroid/widget/LinearLayout;

    .line 736
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00de

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->cardNumberEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 737
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00df

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->expirationEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 738
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00e0

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->securityCodeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 739
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00e1

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/CheckBox;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCheckbox:Landroid/widget/CheckBox;

    .line 741
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00e2

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingAddressLayout:Landroid/widget/LinearLayout;

    .line 743
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00e3

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingNameEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 744
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00e4

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStreetEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 745
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00e5

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStreet2EditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 746
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00e6

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 747
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00e7

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 748
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00e8

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingZipEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 749
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00e9

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingPhoneEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 752
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00a9

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingTitleTextView:Landroid/widget/TextView;

    .line 754
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00b3

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingAddressLayout:Landroid/widget/LinearLayout;

    .line 755
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c02c4

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingNameEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 756
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c02c5

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStreetEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 757
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c02c6

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStreet2EditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 758
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c02c7

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingCityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 759
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c02c8

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 760
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c02c9

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingZipEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 761
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c02ca

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingPhoneEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 764
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00ab

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bottomBarLayout:Landroid/widget/LinearLayout;

    .line 765
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    const v5, 0x7f0c00b4

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, v6, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->checkoutButton:Landroid/widget/Button;

    .line 766
    if-eqz v3, :cond_2

    .line 767
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->checkoutButton:Landroid/widget/Button;

    const v6, 0x7f0601cc

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 770
    :cond_2
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v6, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v5, v6, :cond_8

    .line 771
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v5}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v4

    .line 772
    .restart local v4    # "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMOrder;->isOrderCheckoutTypeBundle()Z

    move-result v5

    if-eqz v5, :cond_7

    .line 773
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updateBundleSummary()V

    .line 779
    :goto_1
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->paymentTitleTextView:Landroid/widget/TextView;

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 780
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->creditCardInfoLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 781
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingTitleTextView:Landroid/widget/TextView;

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 782
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingAddressLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 783
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bottomBarLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 813
    .end local v4    # "order":Lcom/poshmark/data_model/models/PMOrder;
    :cond_3
    :goto_2
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCheckbox:Landroid/widget/CheckBox;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->checkedChangeListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    invoke-virtual {v5, v6}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 814
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->expirationEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->otl:Landroid/view/View$OnTouchListener;

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 815
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->expirationEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->focusChangeListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 816
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->otl:Landroid/view/View$OnTouchListener;

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 817
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->focusChangeListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 818
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->otl:Landroid/view/View$OnTouchListener;

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 819
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->focusChangeListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 820
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->checkoutButton:Landroid/widget/Button;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->checkoutButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 821
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->offerInfoLink:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v6, Lcom/poshmark/ui/fragments/CheckoutFormFragment$14;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$14;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 831
    return-void

    .line 704
    .restart local v4    # "order":Lcom/poshmark/data_model/models/PMOrder;
    :cond_4
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->itemSummaryLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 705
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleItemSummaryLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0

    .line 709
    .end local v4    # "order":Lcom/poshmark/data_model/models/PMOrder;
    :cond_5
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->itemSummaryLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 710
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleItemSummaryLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0

    .line 713
    :cond_6
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->firstTimeInfoLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 714
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->itemSummaryLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 715
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleItemSummaryLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0

    .line 776
    .restart local v4    # "order":Lcom/poshmark/data_model/models/PMOrder;
    :cond_7
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updateListingSummary()V

    goto/16 :goto_1

    .line 785
    .end local v4    # "order":Lcom/poshmark/data_model/models/PMOrder;
    :cond_8
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v6, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CREDIT_CARD:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v5, v6, :cond_9

    .line 786
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->creditCardInfoLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 787
    .local v1, "lp":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5, v9}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v5

    float-to-int v2, v5

    .line 788
    .local v2, "margin":I
    invoke-virtual {v1, v7, v2, v7, v7}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 790
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->paymentTitleTextView:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 791
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->creditCardInfoLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 792
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingTitleTextView:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 793
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingAddressLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 794
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bottomBarLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 796
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v5}, Lcom/poshmark/utils/CheckoutFlowHandler;->addressesEqual()Z

    move-result v5

    if-nez v5, :cond_3

    .line 797
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingAddressLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 798
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCheckbox:Landroid/widget/CheckBox;

    invoke-virtual {v5, v7}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_2

    .line 801
    .end local v1    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v2    # "margin":I
    :cond_9
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v6, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v5, v6, :cond_3

    .line 802
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingAddressLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 803
    .restart local v1    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5, v9}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v5

    float-to-int v2, v5

    .line 804
    .restart local v2    # "margin":I
    invoke-virtual {v1, v7, v2, v7, v7}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 806
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->paymentTitleTextView:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 807
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->creditCardInfoLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 808
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingTitleTextView:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 809
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingAddressLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 810
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bottomBarLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_2
.end method

.method private showCreditCardExpirationSelectorDialog()V
    .locals 6

    .prologue
    .line 590
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v2

    .line 591
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const v4, 0x7f030020

    const/4 v5, 0x0

    invoke-virtual {v2, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 592
    .local v3, "v":Landroid/view/View;
    invoke-direct {p0, v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->setupCCExpirationView(Landroid/view/View;)V

    .line 594
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v1, v4}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 595
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    const v4, 0x7f060104

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 596
    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 598
    const v4, 0x7f0600bf

    new-instance v5, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;

    invoke-direct {v5, p0, v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;Landroid/view/View;)V

    invoke-virtual {v1, v4, v5}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 610
    const v4, 0x7f06006d

    new-instance v5, Lcom/poshmark/ui/fragments/CheckoutFormFragment$13;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$13;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    invoke-virtual {v1, v4, v5}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 617
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 618
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 619
    return-void
.end method

.method private showStateSelectorDialog()V
    .locals 6

    .prologue
    .line 563
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 564
    .local v3, "states":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {}, Lcom/poshmark/utils/AddressUtils;->statesOfUSA()Ljava/util/HashMap;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 565
    invoke-static {v3}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 566
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v4

    new-array v4, v4, [Ljava/lang/CharSequence;

    invoke-interface {v3, v4}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/CharSequence;

    .line 568
    .local v2, "items":[Ljava/lang/CharSequence;
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v1, v4}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 569
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    const v4, 0x7f060244

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 570
    new-instance v4, Lcom/poshmark/ui/fragments/CheckoutFormFragment$10;

    invoke-direct {v4, p0, v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$10;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;[Ljava/lang/CharSequence;)V

    invoke-virtual {v1, v2, v4}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 577
    const v4, 0x7f06006d

    new-instance v5, Lcom/poshmark/ui/fragments/CheckoutFormFragment$11;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$11;-><init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    invoke-virtual {v1, v4, v5}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 584
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 585
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 586
    return-void
.end method

.method private updateBundleSummary()V
    .locals 7

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 637
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v0

    .line 639
    .local v0, "poshmarkOrder":Lcom/poshmark/data_model/models/PMOrder;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleListingImageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOrder;->getPictureUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMListingImageView;->loadImage(Ljava/lang/String;)V

    .line 640
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleItemsCountIndicator:Lcom/poshmark/ui/customviews/PMTextView;

    const-string v2, "%d"

    new-array v3, v5, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 641
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleTitleView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOrder;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 642
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundlePriceView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOrder;->getTotalPriceString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 643
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleItemsCountView:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const v3, 0x7f06015a

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "%d"

    new-array v4, v5, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 644
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->bundleSellerNameView:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const v3, 0x7f060249

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOrder;->getSellerName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 645
    return-void
.end method

.method private updateListingSummary()V
    .locals 6

    .prologue
    .line 622
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v3}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v2

    .line 623
    .local v2, "poshmarkOrder":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v1

    .line 624
    .local v1, "lineItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/LineItem;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-nez v3, :cond_0

    .line 634
    :goto_0
    return-void

    .line 628
    :cond_0
    const/4 v3, 0x0

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/LineItem;

    .line 630
    .local v0, "item":Lcom/poshmark/data_model/models/inner_models/LineItem;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->listingImageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getPictureURL()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->loadImage(Ljava/lang/String;)V

    .line 631
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->listingTitleView:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 632
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->listingSizeView:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const v5, 0x7f060281

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

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

    .line 633
    iget-object v3, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->listingSellerView:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const v5, 0x7f060249

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

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

.method private validateBillingInfo()Ljava/lang/String;
    .locals 3

    .prologue
    .line 323
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 324
    .local v0, "validateTxt":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingNameEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_0

    .line 325
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingNameEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 327
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStreetEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_1

    .line 328
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStreetEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 330
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_2

    .line 331
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 333
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_3

    .line 334
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 336
    :cond_3
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingZipEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_4

    .line 337
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingZipEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 338
    :cond_4
    return-object v0
.end method

.method private validateCCInfo()Ljava/lang/String;
    .locals 3

    .prologue
    .line 342
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 343
    .local v0, "validateTxt":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->cardNumberEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_0

    .line 344
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->cardNumberEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 346
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->expirationEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_1

    .line 347
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->expirationEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 349
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->securityCodeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_2

    .line 350
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->securityCodeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 351
    :cond_2
    return-object v0
.end method

.method private validateShippingInfo()Ljava/lang/String;
    .locals 3

    .prologue
    .line 303
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 304
    .local v0, "validateTxt":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingNameEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_0

    .line 305
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingNameEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 307
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStreetEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_1

    .line 308
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStreetEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 310
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingCityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_2

    .line 311
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingCityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 313
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_3

    .line 314
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 316
    :cond_3
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingZipEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->isValid()Z

    move-result v1

    if-nez v1, :cond_4

    .line 317
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingZipEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getValidatorString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 319
    :cond_4
    return-object v0
.end method


# virtual methods
.method public handleBack()Z
    .locals 1

    .prologue
    .line 859
    const/4 v0, 0x0

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 126
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 127
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 198
    const/4 v1, -0x1

    if-ne p2, v1, :cond_0

    .line 199
    iget v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->PICK_ADDRESS:I

    if-ne p1, v1, :cond_0

    .line 200
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 201
    .local v0, "b":Landroid/os/Bundle;
    invoke-virtual {v0}, Landroid/os/Bundle;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    .line 204
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 79
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 80
    invoke-static {}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->values()[Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    move-result-object v1

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "CHECKOUT_FORM_MODE"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    aget-object v1, v1, v2

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    .line 81
    if-nez p1, :cond_2

    .line 82
    const-class v1, Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/utils/CheckoutFlowHandler;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    .line 83
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->copy(Lcom/poshmark/data_model/models/inner_models/CreditCard;)V

    .line 84
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/data_model/models/PMOrder;->billing_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/Address;->copy(Lcom/poshmark/data_model/models/inner_models/Address;)V

    .line 85
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/data_model/models/PMOrder;->shipping_address:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/Address;->copy(Lcom/poshmark/data_model/models/inner_models/Address;)V

    .line 108
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    if-eqz v1, :cond_1

    .line 109
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    instance-of v1, v1, Lcom/poshmark/utils/OfferFlowHandler;

    if-eqz v1, :cond_1

    .line 110
    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;->OFFER_MODE:Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->mode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$MODE;

    .line 113
    :cond_1
    return-void

    .line 87
    :cond_2
    const-string v1, "FLOW_HANDLER_OBJECT"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/os/ParcelUuid;

    .line 88
    .local v0, "key":Landroid/os/ParcelUuid;
    if-eqz v0, :cond_3

    .line 89
    invoke-virtual {v0}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/utils/CheckoutFlowHandler;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    .line 92
    :cond_3
    const-string v1, "CC_LOCAL"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .end local v0    # "key":Landroid/os/ParcelUuid;
    check-cast v0, Landroid/os/ParcelUuid;

    .line 93
    .restart local v0    # "key":Landroid/os/ParcelUuid;
    if-eqz v0, :cond_4

    .line 94
    invoke-virtual {v0}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/CreditCard;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    .line 97
    :cond_4
    const-string v1, "SHIPPING_ADDRESS"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .end local v0    # "key":Landroid/os/ParcelUuid;
    check-cast v0, Landroid/os/ParcelUuid;

    .line 98
    .restart local v0    # "key":Landroid/os/ParcelUuid;
    if-eqz v0, :cond_5

    .line 99
    invoke-virtual {v0}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/Address;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    .line 102
    :cond_5
    const-string v1, "BILLING_ADDRESS"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .end local v0    # "key":Landroid/os/ParcelUuid;
    check-cast v0, Landroid/os/ParcelUuid;

    .line 103
    .restart local v0    # "key":Landroid/os/ParcelUuid;
    if-eqz v0, :cond_0

    .line 104
    invoke-virtual {v0}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v1

    invoke-static {v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/Address;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 117
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 118
    const v1, 0x7f030023

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 119
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->setupView(Landroid/view/View;)V

    .line 120
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->populateViews()V

    .line 121
    return-object v0
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 155
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onResume()V

    .line 156
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    if-eqz v1, :cond_0

    .line 157
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/Address;-><init>()V

    .line 158
    .local v0, "address":Lcom/poshmark/data_model/models/inner_models/Address;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    const-string v2, "CITY"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setCity(Ljava/lang/String;)V

    .line 159
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    const-string v2, "NAME"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setName(Ljava/lang/String;)V

    .line 160
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    const-string v2, "PHONE"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setPhone(Ljava/lang/String;)V

    .line 161
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    const-string v2, "STATE"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setState(Ljava/lang/String;)V

    .line 162
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    const-string v2, "STREET"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setStreet(Ljava/lang/String;)V

    .line 163
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    const-string v2, "STREET2"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setStreet2(Ljava/lang/String;)V

    .line 164
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    const-string v2, "TYPE"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setType(Ljava/lang/String;)V

    .line 165
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    const-string v2, "ZIP"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/inner_models/Address;->setZip(Ljava/lang/String;)V

    .line 167
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->updatedShippingAddress:Landroid/os/Bundle;

    .line 169
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/inner_models/Address;->copy(Lcom/poshmark/data_model/models/inner_models/Address;)V

    .line 170
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->postAddressesToServerAndFinish()V

    .line 172
    .end local v0    # "address":Lcom/poshmark/data_model/models/inner_models/Address;
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 131
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 133
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    if-eqz v1, :cond_0

    .line 134
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 135
    .local v0, "id":Ljava/util/UUID;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-static {v0, v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 136
    const-string v1, "FLOW_HANDLER_OBJECT"

    new-instance v2, Landroid/os/ParcelUuid;

    invoke-direct {v2, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 139
    .end local v0    # "id":Ljava/util/UUID;
    :cond_0
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 140
    .restart local v0    # "id":Ljava/util/UUID;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    invoke-static {v0, v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 141
    const-string v1, "CC_LOCAL"

    new-instance v2, Landroid/os/ParcelUuid;

    invoke-direct {v2, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 143
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 144
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-static {v0, v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 145
    const-string v1, "SHIPPING_ADDRESS"

    new-instance v2, Landroid/os/ParcelUuid;

    invoke-direct {v2, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 147
    invoke-static {}, Lcom/poshmark/utils/ObjectPickupDropOff;->getUniqueKey()Ljava/util/UUID;

    move-result-object v0

    .line 148
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-static {v0, v1}, Lcom/poshmark/utils/ObjectPickupDropOff;->dropOffDataObject(Ljava/util/UUID;Ljava/lang/Object;)V

    .line 149
    const-string v1, "BILLING_ADDRESS"

    new-instance v2, Landroid/os/ParcelUuid;

    invoke-direct {v2, v0}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 150
    return-void
.end method

.method public populateViews()V
    .locals 2

    .prologue
    .line 834
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CREDIT_CARD:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v0, v1, :cond_1

    .line 835
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v0}, Lcom/poshmark/utils/CheckoutFlowHandler;->addressesEqual()Z

    move-result v0

    if-nez v0, :cond_0

    .line 836
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingCityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getCity()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 837
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingNameEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 838
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingPhoneEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getPhone()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 839
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getState()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 840
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStreetEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getStreet()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 841
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStreet2EditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getStreet2()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 842
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingZipEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->billingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getZip()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 855
    :cond_0
    :goto_0
    return-void

    .line 845
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v0, v1, :cond_0

    .line 846
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingCityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getCity()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 847
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingNameEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 848
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingPhoneEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getPhone()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 849
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getState()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 850
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStreetEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getStreet()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 851
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStreet2EditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getStreet2()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 852
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingZipEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->shippingAddress:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Address;->getZip()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public setViewNameForAnalytics()V
    .locals 2

    .prologue
    .line 207
    sget-object v0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$15;->$SwitchMap$com$poshmark$ui$fragments$CheckoutFormFragment$CHECKOUT_FORM_MODES:[I

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 218
    :goto_0
    return-void

    .line 209
    :pswitch_0
    const-string v0, "order_edit_credit_card_and_address_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 212
    :pswitch_1
    const-string v0, "order_edit_credit_card_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 215
    :pswitch_2
    const-string v0, "order_edit_address_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 207
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public setupActionBar()V
    .locals 4

    .prologue
    const v3, 0x7f0600bf

    .line 176
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 177
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v1, v2, :cond_2

    .line 178
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOffer()Lcom/poshmark/data_model/models/PMOffer;

    move-result-object v0

    .line 179
    .local v0, "offer":Lcom/poshmark/data_model/models/PMOffer;
    if-eqz v0, :cond_1

    .line 180
    const v1, 0x7f0601df

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->setTitle(Ljava/lang/String;)V

    .line 193
    .end local v0    # "offer":Lcom/poshmark/data_model/models/PMOffer;
    :cond_0
    :goto_0
    return-void

    .line 182
    .restart local v0    # "offer":Lcom/poshmark/data_model/models/PMOffer;
    :cond_1
    const v1, 0x7f060078

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->setTitle(Ljava/lang/String;)V

    goto :goto_0

    .line 185
    .end local v0    # "offer":Lcom/poshmark/data_model/models/PMOffer;
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CREDIT_CARD:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v1, v2, :cond_3

    .line 186
    const v1, 0x7f060031

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->setTitle(Ljava/lang/String;)V

    .line 187
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->nextButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {p0, v1, v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    goto :goto_0

    .line 189
    :cond_3
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->formMode:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    sget-object v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    if-ne v1, v2, :cond_0

    .line 190
    const v1, 0x7f060261

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->setTitle(Ljava/lang/String;)V

    .line 191
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->nextButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {p0, v1, v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    goto :goto_0
.end method
