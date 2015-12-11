.class Lcom/poshmark/ui/fragments/CheckoutFormFragment$5;
.super Ljava/lang/Object;
.source "CheckoutFormFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutFormFragment;->checkAddressValidity()V
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
        "Lcom/poshmark/data_model/models/AddressCheckerResults;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0

    .prologue
    .line 474
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/AddressCheckerResults;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 477
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/AddressCheckerResults;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 478
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->hideProgressDialog()V

    .line 479
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_2

    .line 480
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/AddressCheckerResults;

    .line 481
    .local v0, "results":Lcom/poshmark/data_model/models/AddressCheckerResults;
    iget-object v1, v0, Lcom/poshmark/data_model/models/AddressCheckerResults;->status:Ljava/lang/String;

    const-string v2, "exact_match_found"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 482
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->fireAddressPickerFragment(Lcom/poshmark/data_model/models/AddressCheckerResults;)V
    invoke-static {v1, v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$1000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;Lcom/poshmark/data_model/models/AddressCheckerResults;)V

    .line 492
    .end local v0    # "results":Lcom/poshmark/data_model/models/AddressCheckerResults;
    :cond_0
    :goto_0
    return-void

    .line 484
    .restart local v0    # "results":Lcom/poshmark/data_model/models/AddressCheckerResults;
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->postAddressesToServerAndFinish()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$900(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    goto :goto_0

    .line 488
    .end local v0    # "results":Lcom/poshmark/data_model/models/AddressCheckerResults;
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->UPDATE_ORDER_ADDRESS:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    const v6, 0x7f0600d6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v2, v3, v4, v5, v6}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
