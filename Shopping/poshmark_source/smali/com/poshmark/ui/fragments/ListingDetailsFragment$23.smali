.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$23;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment;->addListingToBundle()V
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
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0

    .prologue
    .line 1267
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$23;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1270
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$23;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->hideProgressDialog()V

    .line 1271
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1272
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    invoke-virtual {v0}, Lcom/poshmark/http/api/PMApiError;->isAlreadyExistsError()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1273
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$23;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewBundle()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->access$500(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    .line 1284
    :goto_0
    return-void

    .line 1276
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$23;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->ADD_TO_BUNDLE:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$23;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const v5, 0x7f0600d3

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->LOW:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0

    .line 1281
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$23;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    sget-object v1, Lcom/poshmark/utils/FBDPAHelper;->PURCHASE_TYPE_BUNDLE:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/poshmark/utils/FBDPAHelper;->trackAddToCart(Lcom/poshmark/data_model/models/ListingSummary;Ljava/lang/String;)V

    .line 1282
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$23;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewBundle()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->access$500(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    goto :goto_0
.end method
