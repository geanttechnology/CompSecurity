.class Lcom/poshmark/utils/ShareManager_Old$6;
.super Ljava/lang/Object;
.source "ShareManager_Old.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/ShareManager_Old;->initiateShare(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)V
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
        "Lcom/poshmark/data_model/models/inner_models/ShortUrl;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/ShareManager_Old;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ShareManager_Old;)V
    .locals 0

    .prologue
    .line 538
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old$6;->this$0:Lcom/poshmark/utils/ShareManager_Old;

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
            "Lcom/poshmark/data_model/models/inner_models/ShortUrl;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 541
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/inner_models/ShortUrl;>;"
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$6;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v0}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 542
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 543
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$6;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;
    invoke-static {v0}, Lcom/poshmark/utils/ShareManager_Old;->access$400(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/data_model/models/ListingSocial;

    move-result-object v1

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/ShortUrl;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/ShortUrl;->short_url:Ljava/lang/String;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/ListingSocial;->setShortURL(Ljava/lang/String;)V

    .line 544
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$6;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager_Old;->showShareMessageEditor()V

    .line 548
    :goto_0
    return-void

    .line 546
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$6;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v0}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_LISTING_TWITTER:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
