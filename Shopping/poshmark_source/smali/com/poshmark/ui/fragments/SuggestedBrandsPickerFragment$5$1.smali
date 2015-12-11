.class Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$1;
.super Ljava/lang/Object;
.source "SuggestedBrandsPickerFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;->onClick(Lcom/poshmark/ui/customviews/PMImageView;Landroid/os/Bundle;)V
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
.field final synthetic this$1:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;

.field final synthetic val$brand:Lcom/poshmark/data_model/models/Brand;

.field final synthetic val$parent:Landroid/widget/FrameLayout;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;Lcom/poshmark/data_model/models/Brand;Landroid/widget/FrameLayout;)V
    .locals 0

    .prologue
    .line 334
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$1;->this$1:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$1;->val$brand:Lcom/poshmark/data_model/models/Brand;

    iput-object p3, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$1;->val$parent:Landroid/widget/FrameLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 3
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
    .line 337
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 338
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$1;->val$brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v1, v1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/controllers/GlobalDbController;->unFollowBrand(Ljava/lang/String;)V

    .line 343
    :goto_0
    return-void

    .line 340
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$1;->this$1:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$1;->val$parent:Landroid/widget/FrameLayout;

    const/4 v2, 0x0

    # invokes: Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setOverlay(Landroid/widget/FrameLayout;I)V
    invoke-static {v0, v1, v2}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->access$300(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;Landroid/widget/FrameLayout;I)V

    .line 341
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$1;->this$1:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    const-string v1, "Oops!"

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;)V

    goto :goto_0
.end method
