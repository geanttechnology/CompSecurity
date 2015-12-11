.class Lcom/poshmark/utils/ShareManager_Old$3;
.super Ljava/lang/Object;
.source "ShareManager_Old.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/ShareManager_Old;->shareToFollowers()V
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
.field final synthetic this$0:Lcom/poshmark/utils/ShareManager_Old;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ShareManager_Old;)V
    .locals 0

    .prologue
    .line 431
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

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
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 435
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    sget-object v1, Lcom/poshmark/utils/NewRelicCustomInteractions;->SHARE_LISTING_TO_FOLLOWERS:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/config/NewRelicWrapper;->stopCustomInteraction(Ljava/lang/String;)V

    .line 436
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v1}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 437
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_0

    .line 438
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v1}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$300(Lcom/poshmark/utils/ShareManager_Old;)Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060259

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    iget-object v3, v3, Lcom/poshmark/utils/ShareManager_Old;->dismissListener:Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    .line 440
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$400(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/data_model/models/ListingSocial;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$400(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/data_model/models/ListingSocial;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 441
    .local v0, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "share_listing_options_screen"

    const-string v3, "listing"

    const-string v4, "share_listing_poshmark"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 450
    :goto_0
    return-void

    .line 444
    .end local v0    # "label":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$400(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/data_model/models/ListingSocial;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;
    invoke-static {v2}, Lcom/poshmark/utils/ShareManager_Old;->access$400(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/data_model/models/ListingSocial;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 445
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "share_listing_options_screen"

    const-string v3, "listing"

    const-string v4, "share_listing_failed"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 447
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v1}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v5, p0, Lcom/poshmark/utils/ShareManager_Old$3;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;
    invoke-static {v5}, Lcom/poshmark/utils/ShareManager_Old;->access$300(Lcom/poshmark/utils/ShareManager_Old;)Landroid/content/Context;

    move-result-object v5

    const v6, 0x7f0600fa

    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
