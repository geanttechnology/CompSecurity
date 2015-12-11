.class Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;
.super Ljava/lang/Object;
.source "CheckoutConfirmationFragment_Offers.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->fireOffer(Ljava/util/Map;Ljava/lang/String;)V
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
        "Lcom/poshmark/data_model/models/PMOffer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

.field final synthetic val$order:Lcom/poshmark/data_model/models/PMOrder;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;Lcom/poshmark/data_model/models/PMOrder;)V
    .locals 0

    .prologue
    .line 296
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->val$order:Lcom/poshmark/data_model/models/PMOrder;

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
            "Lcom/poshmark/data_model/models/PMOffer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 299
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOffer;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 300
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->hideProgressDialog()V

    .line 301
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 302
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->mode:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;->EXISTING_OFFER:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE;

    if-ne v0, v1, :cond_1

    .line 303
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    const v2, 0x7f0601dd

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4$1;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;)V

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    .line 324
    :cond_0
    :goto_0
    return-void

    .line 311
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    const v2, 0x7f0601de

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4$2;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4$2;-><init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;)V

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    goto :goto_0

    .line 320
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$4;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    const v5, 0x7f0600f4

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->getString(I)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
