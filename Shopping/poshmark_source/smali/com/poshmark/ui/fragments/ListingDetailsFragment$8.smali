.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$8;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment;->markForSale()V
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
    .line 435
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

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
    .line 438
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 439
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->hideProgressDialog()V

    .line 440
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 442
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingEditedMessage(Ljava/lang/String;)V

    .line 448
    :cond_0
    :goto_0
    return-void

    .line 444
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->UPDATE_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const v5, 0x7f0600e5

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
