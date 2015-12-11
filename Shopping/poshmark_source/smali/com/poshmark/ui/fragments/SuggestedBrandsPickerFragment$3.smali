.class Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;
.super Ljava/lang/Object;
.source "SuggestedBrandsPickerFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setupBrandList()V
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
        "Lcom/poshmark/db/AllBrandsModel;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V
    .locals 0

    .prologue
    .line 120
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/db/AllBrandsModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/db/AllBrandsModel;>;"
    const/4 v3, 0x0

    .line 123
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->hideProgressDialog()V

    .line 124
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_0

    .line 125
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->retryButton:Landroid/widget/TextView;

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 126
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/db/AllBrandsModel;

    iput-object v1, v2, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    .line 127
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    iget-object v2, v2, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    iput v2, v1, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->serverSuggestedBrandsCount:I

    .line 128
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    # invokes: Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setupSuggestedBrandMap()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->access$100(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V

    .line 129
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    # invokes: Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->showSuggestedBrands()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->access$200(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V

    .line 137
    :goto_0
    return-void

    .line 132
    :cond_0
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->LOW:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v0, v1, v3, v3, v2}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    .line 134
    .local v0, "errorContext":Lcom/poshmark/ui/model/ActionErrorContext;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 135
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->retryButton:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method
