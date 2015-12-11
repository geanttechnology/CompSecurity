.class public Lcom/poshmark/utils/BundleFlowHandler;
.super Lcom/poshmark/utils/CheckoutFlowHandler;
.source "BundleFlowHandler.java"


# static fields
.field public static BUY_BUNDLE_REQUEST:I


# instance fields
.field bundle:Lcom/poshmark/data_model/models/PMBundle;

.field bundleItemsCount:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    const/16 v0, 0x7b

    sput v0, Lcom/poshmark/utils/BundleFlowHandler;->BUY_BUNDLE_REQUEST:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/poshmark/utils/CheckoutFlowHandler;-><init>()V

    .line 38
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 0
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lcom/poshmark/utils/CheckoutFlowHandler;-><init>(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 42
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/utils/BundleFlowHandler;Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/BundleFlowHandler;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/poshmark/utils/BundleFlowHandler;->handleAddProductResponse(Lcom/poshmark/http/api/PMApiResponse;)V

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
    .line 99
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOrder;>;"
    iget-object v0, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 100
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 101
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/PMOrder;

    iput-object v0, p0, Lcom/poshmark/utils/BundleFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    .line 102
    iget v0, p0, Lcom/poshmark/utils/BundleFlowHandler;->bundleItemsCount:I

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    .line 103
    invoke-virtual {p0}, Lcom/poshmark/utils/BundleFlowHandler;->showBundleConfirmationForm()V

    .line 107
    :goto_0
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const/4 v1, 0x0

    const-string v2, "bundle"

    const-string v3, "added_bundle_to_order"

    iget-object v4, p0, Lcom/poshmark/utils/BundleFlowHandler;->poshmarkOrder:Lcom/poshmark/data_model/models/PMOrder;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    :goto_1
    return-void

    .line 105
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/utils/BundleFlowHandler;->showSingleItemConfirmationForm()V

    goto :goto_0

    .line 110
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->ADD_PRODUCT_TO_ORDER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v5, 0x7f0600d5

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_1
.end method


# virtual methods
.method protected addProductWithId(Ljava/util/List;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 52
    .local p1, "postIDs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    if-nez v4, :cond_1

    .line 87
    :cond_0
    :goto_0
    return-void

    .line 56
    :cond_1
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 57
    .local v2, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    .line 58
    .local v0, "ids":Ljava/lang/String;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 59
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 60
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 61
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 62
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 65
    :cond_3
    const-string v4, "checkout_type"

    const-string v5, "bbdl"

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v4

    const/4 v5, 0x1

    if-le v4, v5, :cond_4

    .line 67
    const-string v4, "product_ids"

    invoke-virtual {v2, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    iget-object v4, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const-string v5, "bnd_crt"

    invoke-static {v4, v5}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 73
    .local v3, "trackingJSON":Ljava/lang/String;
    :goto_2
    const-string v4, "order_id"

    const-string v5, "self"

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 74
    const-string v4, "user_id"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    iget-object v4, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v5, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v6, 0x7f0601e8

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 78
    new-instance v4, Lcom/poshmark/utils/BundleFlowHandler$1;

    invoke-direct {v4, p0}, Lcom/poshmark/utils/BundleFlowHandler$1;-><init>(Lcom/poshmark/utils/BundleFlowHandler;)V

    invoke-static {v2, v3, v4}, Lcom/poshmark/http/api/PMApi;->addProductToOrder(Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto/16 :goto_0

    .line 70
    .end local v3    # "trackingJSON":Ljava/lang/String;
    :cond_4
    const-string v4, "product_ids"

    invoke-virtual {v2, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    iget-object v4, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const-string v5, "cart"

    invoke-static {v4, v5}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .restart local v3    # "trackingJSON":Ljava/lang/String;
    goto :goto_2
.end method

.method public beginCheckoutForBundle(Lcom/poshmark/data_model/models/PMBundle;)V
    .locals 2
    .param p1, "bundle"    # Lcom/poshmark/data_model/models/PMBundle;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/poshmark/utils/BundleFlowHandler;->bundle:Lcom/poshmark/data_model/models/PMBundle;

    .line 46
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iput v0, p0, Lcom/poshmark/utils/BundleFlowHandler;->bundleItemsCount:I

    .line 47
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSummary;

    iput-object v0, p0, Lcom/poshmark/utils/BundleFlowHandler;->listing:Lcom/poshmark/data_model/models/ListingSummary;

    .line 48
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/PMBundle;->getListOfPostsInBundle()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/BundleFlowHandler;->addProductWithId(Ljava/util/List;)V

    .line 49
    return-void
.end method

.method public getListingDetails()Lcom/poshmark/data_model/models/ListingSummary;
    .locals 2

    .prologue
    .line 127
    iget-object v0, p0, Lcom/poshmark/utils/BundleFlowHandler;->bundle:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSummary;

    return-object v0
.end method

.method protected showBundleConfirmationForm()V
    .locals 6

    .prologue
    .line 90
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 91
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "CHECKOUT_FORM_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 92
    iget-object v2, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 93
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    .line 94
    const-class v2, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;

    iget-object v4, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    sget v5, Lcom/poshmark/utils/BundleFlowHandler;->BUY_BUNDLE_REQUEST:I

    move-object v3, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 96
    :cond_0
    return-void
.end method

.method protected showSingleItemConfirmationForm()V
    .locals 6

    .prologue
    .line 117
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 118
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "CHECKOUT_FORM_MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS:Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 119
    iget-object v2, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 120
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v0, :cond_0

    .line 121
    const-class v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iget-object v4, p0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    sget v5, Lcom/poshmark/utils/BundleFlowHandler;->BUY_BUNDLE_REQUEST:I

    move-object v3, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 123
    :cond_0
    return-void
.end method
