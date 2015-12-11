.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment;->reportListing(Ljava/lang/String;)V
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
    .line 480
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

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
    .line 484
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 485
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->hideProgressDialog()V

    .line 486
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 487
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "listing"

    const-string v3, "report_listing"

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 488
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const v2, 0x7f060228

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showAutoHideSuccessMessage(Ljava/lang/String;)V

    .line 494
    :cond_0
    :goto_0
    return-void

    .line 490
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->REPORT_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const v5, 0x7f0600f6

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
