.class public Lcom/poshmark/utils/OfferFlowHandler;
.super Lcom/poshmark/utils/CheckoutFlowHandler;
.source "OfferFlowHandler.java"


# instance fields
.field MAKE_OFFER_REQUEST_CODE:I

.field bt_info:Lcom/poshmark/data_model/models/BrainTreeInfo;


# direct methods
.method public constructor <init>(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 1
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 24
    invoke-direct {p0, p1}, Lcom/poshmark/utils/CheckoutFlowHandler;-><init>(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 20
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/utils/OfferFlowHandler;->MAKE_OFFER_REQUEST_CODE:I

    .line 25
    new-instance v0, Lcom/poshmark/data_model/models/PMOffer;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/PMOffer;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/OfferFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    .line 26
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/data_model/models/PMOfferInfo;)V
    .locals 1
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p2, "offerInfo"    # Lcom/poshmark/data_model/models/PMOfferInfo;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lcom/poshmark/utils/CheckoutFlowHandler;-><init>(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 20
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/utils/OfferFlowHandler;->MAKE_OFFER_REQUEST_CODE:I

    .line 30
    iget-object v0, p2, Lcom/poshmark/data_model/models/PMOfferInfo;->data:Lcom/poshmark/data_model/models/PMOffer;

    iput-object v0, p0, Lcom/poshmark/utils/OfferFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    .line 31
    iget-object v0, p2, Lcom/poshmark/data_model/models/PMOfferInfo;->meta:Lcom/poshmark/data_model/models/BrainTreeInfo;

    iput-object v0, p0, Lcom/poshmark/utils/OfferFlowHandler;->bt_info:Lcom/poshmark/data_model/models/BrainTreeInfo;

    .line 32
    return-void
.end method

.method private showOfferForm()V
    .locals 6

    .prologue
    .line 49
    iget-object v1, p0, Lcom/poshmark/utils/OfferFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 50
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    .line 51
    const/4 v1, 0x0

    const-class v2, Lcom/poshmark/ui/fragments/MakeOfferFragment;

    iget-object v4, p0, Lcom/poshmark/utils/OfferFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget v5, p0, Lcom/poshmark/utils/OfferFlowHandler;->MAKE_OFFER_REQUEST_CODE:I

    move-object v3, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 53
    :cond_0
    return-void
.end method


# virtual methods
.method public beginCheckoutForListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 0
    .param p1, "listingDetails"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/poshmark/utils/OfferFlowHandler;->listing:Lcom/poshmark/data_model/models/ListingSummary;

    .line 45
    invoke-direct {p0}, Lcom/poshmark/utils/OfferFlowHandler;->showOfferForm()V

    .line 46
    return-void
.end method

.method public getEncryptionKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/poshmark/utils/OfferFlowHandler;->bt_info:Lcom/poshmark/data_model/models/BrainTreeInfo;

    if-eqz v0, :cond_0

    .line 37
    iget-object v0, p0, Lcom/poshmark/utils/OfferFlowHandler;->bt_info:Lcom/poshmark/data_model/models/BrainTreeInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/BrainTreeInfo;->bt_public_key:Ljava/lang/String;

    .line 39
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setOffer(Lcom/poshmark/data_model/models/PMOfferInfo;)V
    .locals 1
    .param p1, "offerInfo"    # Lcom/poshmark/data_model/models/PMOfferInfo;

    .prologue
    .line 56
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOfferInfo;->data:Lcom/poshmark/data_model/models/PMOffer;

    iput-object v0, p0, Lcom/poshmark/utils/OfferFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    .line 57
    iget-object v0, p1, Lcom/poshmark/data_model/models/PMOfferInfo;->meta:Lcom/poshmark/data_model/models/BrainTreeInfo;

    iput-object v0, p0, Lcom/poshmark/utils/OfferFlowHandler;->bt_info:Lcom/poshmark/data_model/models/BrainTreeInfo;

    .line 58
    return-void
.end method
