.class public Lcom/poshmark/ui/fragments/MakeOfferFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "MakeOfferFragment.java"


# instance fields
.field CHEKOUT_CONIRMATION_REQUEST:I

.field private flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

.field offerText:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 53
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->CHEKOUT_CONIRMATION_REQUEST:I

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/MakeOfferFragment;)Lcom/poshmark/utils/OfferFlowHandler;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MakeOfferFragment;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    return-object v0
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/MakeOfferFragment;Ljava/lang/String;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MakeOfferFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->offerValid(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/MakeOfferFragment;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MakeOfferFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->setupOffer(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/MakeOfferFragment;Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/MakeOfferFragment;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->handleAddProductResponse(Lcom/poshmark/http/api/PMApiResponse;)V

    return-void
.end method

.method private handleAddProductResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 5
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
    .line 215
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOfferInfo;>;"
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->hideProgressDialog()V

    .line 216
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 217
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMOfferInfo;

    invoke-virtual {v1, v0}, Lcom/poshmark/utils/OfferFlowHandler;->setOffer(Lcom/poshmark/data_model/models/PMOfferInfo;)V

    .line 218
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->showConfirmationForm()V

    .line 224
    :goto_0
    return-void

    .line 221
    :cond_0
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->ADD_PRODUCT_TO_ORDER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    const v3, 0x7f0600d5

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method

.method private offerValid(Ljava/lang/String;)Z
    .locals 12
    .param p1, "amount"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 150
    iget-object v8, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    invoke-virtual {v8}, Lcom/poshmark/utils/OfferFlowHandler;->getListingDetails()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSummary;->getPrice()Ljava/math/BigDecimal;

    move-result-object v8

    invoke-virtual {v8}, Ljava/math/BigDecimal;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v0

    .line 151
    .local v0, "currentPrice":F
    const/high16 v8, 0x41200000    # 10.0f

    div-float v8, v0, v8

    float-to-double v8, v8

    invoke-static {v8, v9}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v8

    double-to-int v5, v8

    .line 152
    .local v5, "tenPercent":I
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/utils/FeatureManager;->getListingFeature()Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->getMinimumSellingPrice()Ljava/math/BigDecimal;

    move-result-object v8

    invoke-virtual {v8}, Ljava/math/BigDecimal;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    .line 153
    .local v3, "minPrice":I
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v8

    if-nez v8, :cond_1

    .line 154
    :cond_0
    const-string v7, "Make An Offer"

    const-string v8, "Invalid Offer Price"

    invoke-virtual {p0, v7, v8}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    :goto_0
    return v6

    .line 157
    :cond_1
    invoke-virtual {p1, v7}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    .line 159
    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    .line 160
    .local v4, "offer":I
    int-to-float v8, v4

    cmpl-float v8, v8, v0

    if-ltz v8, :cond_2

    .line 161
    const-string v7, "Make An Offer"

    const-string v8, "Offer price should not exceed $%s"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    float-to-int v11, v0

    add-int/lit8 v11, v11, -0x1

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v7, v8}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 170
    .end local v4    # "offer":I
    :catch_0
    move-exception v1

    .line 171
    .local v1, "exp":Ljava/lang/NumberFormatException;
    const-string v7, "Make An Offer"

    const-string v8, "Invalid Offer Price"

    invoke-virtual {p0, v7, v8}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 164
    .end local v1    # "exp":Ljava/lang/NumberFormatException;
    .restart local v4    # "offer":I
    :cond_2
    if-gt v5, v3, :cond_3

    move v2, v3

    .line 165
    .local v2, "minAllowedOffer":I
    :goto_1
    if-ge v4, v2, :cond_4

    .line 166
    :try_start_1
    const-string v7, "Make An Offer"

    const-string v8, "Offer price should be at least $%s"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v7, v8}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .end local v2    # "minAllowedOffer":I
    :cond_3
    move v2, v5

    .line 164
    goto :goto_1

    .restart local v2    # "minAllowedOffer":I
    :cond_4
    move v6, v7

    .line 176
    goto :goto_0
.end method

.method private setupOffer(Ljava/lang/String;)V
    .locals 4
    .param p1, "amount"    # Ljava/lang/String;

    .prologue
    .line 200
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 201
    .local v0, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "offer_amount"

    invoke-virtual {v0, v2, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 202
    const v2, 0x7f06009b

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 203
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const-string v3, "ofr_i"

    invoke-static {v2, v3}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 204
    .local v1, "trackingJSON":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/OfferFlowHandler;->getListingDetails()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/MakeOfferFragment$4;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment$4;-><init>(Lcom/poshmark/ui/fragments/MakeOfferFragment;)V

    invoke-static {v2, v0, v1, v3}, Lcom/poshmark/http/api/PMApi;->addProductToOffer(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 212
    return-void
.end method

.method private setupView(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 73
    const v4, 0x7f0c0201

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->offerText:Landroid/widget/EditText;

    .line 74
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    if-eqz v4, :cond_0

    .line 75
    const v4, 0x7f0c00b5

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 76
    .local v1, "listingImageView":Lcom/poshmark/ui/customviews/PMListingImageView;
    const v4, 0x7f0c00b7

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 77
    .local v3, "listingTitleView":Landroid/widget/TextView;
    const v4, 0x7f0c0202

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 79
    .local v2, "listingPriceView":Landroid/widget/TextView;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    invoke-virtual {v4}, Lcom/poshmark/utils/OfferFlowHandler;->getListingDetails()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getSmallCovershot()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->loadImage(Ljava/lang/String;)V

    .line 80
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    invoke-virtual {v4}, Lcom/poshmark/utils/OfferFlowHandler;->getListingDetails()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 81
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const v5, 0x7f06017e

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ": "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    invoke-virtual {v5}, Lcom/poshmark/utils/OfferFlowHandler;->getListingDetails()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSummary;->getPriceString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    const v4, 0x7f0c01ff

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 84
    .local v0, "button":Landroid/widget/ImageButton;
    new-instance v4, Lcom/poshmark/ui/fragments/MakeOfferFragment$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment$1;-><init>(Lcom/poshmark/ui/fragments/MakeOfferFragment;)V

    invoke-virtual {v0, v4}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->offerText:Landroid/widget/EditText;

    new-instance v5, Lcom/poshmark/ui/fragments/MakeOfferFragment$2;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment$2;-><init>(Lcom/poshmark/ui/fragments/MakeOfferFragment;)V

    invoke-virtual {v4, v5}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 116
    .end local v0    # "button":Landroid/widget/ImageButton;
    .end local v1    # "listingImageView":Lcom/poshmark/ui/customviews/PMListingImageView;
    .end local v2    # "listingPriceView":Landroid/widget/TextView;
    .end local v3    # "listingTitleView":Landroid/widget/TextView;
    :cond_0
    return-void
.end method

.method private showConfirmationForm()V
    .locals 6

    .prologue
    .line 227
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 228
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "CHECKOUT_FORM_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 229
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 230
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    .line 231
    const-class v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    iget v5, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->CHEKOUT_CONIRMATION_REQUEST:I

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 233
    :cond_0
    return-void
.end method


# virtual methods
.method public done(I)V
    .locals 5
    .param p1, "resultCode"    # I

    .prologue
    .line 241
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 242
    .local v0, "b":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/fragments/PMFragment;

    .line 243
    .local v3, "targetFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v3, :cond_1

    .line 244
    const-string v4, "RESULT_CODE"

    invoke-virtual {v0, v4, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 245
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getTargetRequestCode()I

    move-result v2

    .line 246
    .local v2, "requestCode":I
    invoke-virtual {v3, v0, v2}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    .line 247
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 248
    .local v1, "parent":Landroid/app/Activity;
    if-eqz v1, :cond_0

    .line 249
    invoke-virtual {v1}, Landroid/app/Activity;->onBackPressed()V

    .line 254
    .end local v1    # "parent":Landroid/app/Activity;
    .end local v2    # "requestCode":I
    :cond_0
    :goto_0
    return-void

    .line 252
    :cond_1
    const/4 v4, 0x0

    invoke-virtual {p0, p1, v4}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 181
    iget v0, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->CHEKOUT_CONIRMATION_REQUEST:I

    if-ne p1, v0, :cond_0

    .line 182
    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    .line 183
    invoke-virtual {p0, p2}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->done(I)V

    .line 186
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 58
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 59
    if-nez p1, :cond_0

    .line 60
    const-class v0, Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/OfferFlowHandler;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    .line 62
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 66
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 67
    const v1, 0x7f03007f

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 68
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->setupView(Landroid/view/View;)V

    .line 69
    return-object v0
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 3
    .param p1, "b"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    .line 190
    invoke-super {p0, p1, p2}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    .line 191
    iget v1, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->CHEKOUT_CONIRMATION_REQUEST:I

    if-ne p2, v1, :cond_0

    .line 192
    const-string v1, "RESULT_CODE"

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 193
    .local v0, "resultCode":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 194
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->done(I)V

    .line 197
    .end local v0    # "resultCode":I
    :cond_0
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 120
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 121
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;

    invoke-virtual {v0, p0}, Lcom/poshmark/utils/OfferFlowHandler;->setCallingFragment(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 122
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->offerText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 123
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 125
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 237
    const-string v0, "offer_price_form_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 238
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 129
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 130
    const v0, 0x7f06019a

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->setTitle(Ljava/lang/String;)V

    .line 131
    const v0, 0x7f0601cc

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;-><init>(Lcom/poshmark/ui/fragments/MakeOfferFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 147
    return-void
.end method
