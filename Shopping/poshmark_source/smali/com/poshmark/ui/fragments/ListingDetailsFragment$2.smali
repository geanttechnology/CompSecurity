.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fetchListingDetails()V
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
        "Lcom/poshmark/data_model/models/ListingDetails;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0

    .prologue
    .line 263
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/ListingDetails;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 266
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ListingDetails;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 267
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->hideProgressDialog()V

    .line 268
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_1

    .line 269
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/data_model/models/ListingDetails;

    iput-object v1, v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    .line 270
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getTrackingList()Ljava/util/List;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/poshmark/utils/FBDPAHelper;->trackListingView(Lcom/poshmark/data_model/models/ListingDetails;Ljava/util/List;)V

    .line 271
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setupActionBarNextActionButton()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->access$100(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    .line 272
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateCursorData()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->access$000(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    .line 273
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateView()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->access$200(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    .line 283
    :cond_0
    :goto_0
    return-void

    .line 275
    :cond_1
    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v1, v1, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_NOT_FOUND:Lcom/poshmark/data_model/models/PMErrorType;

    if-eq v1, v2, :cond_2

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v1, v1, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->HTTP_GONE:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v1, v2, :cond_3

    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0600e3

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 279
    .local v0, "operationString":Ljava/lang/String;
    :goto_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->LOAD_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v2, v3, v4, v0}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0

    .line 275
    .end local v0    # "operationString":Ljava/lang/String;
    :cond_3
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0600e6

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method
