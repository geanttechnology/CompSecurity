.class Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;
.super Ljava/lang/Object;
.source "ShareToPartyShare.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;->executeState()V
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
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;

.field final synthetic val$callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field final synthetic val$isFragmentAdded:Z

.field final synthetic val$listingItem:Lcom/poshmark/data_model/models/ListingSummary;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;Lcom/poshmark/ui/fragments/PMFragment;ZLcom/poshmark/data_model/models/ListingSummary;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;

    iput-object p2, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iput-boolean p3, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$isFragmentAdded:Z

    iput-object p4, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$listingItem:Lcom/poshmark/data_model/models/ListingSummary;

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
    .line 41
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    sget-object v1, Lcom/poshmark/utils/NewRelicCustomInteractions;->SHARE_LISTING_TO_PARTY:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/config/NewRelicWrapper;->stopCustomInteraction(Ljava/lang/String;)V

    .line 42
    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 43
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_1

    .line 44
    iget-boolean v1, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$isFragmentAdded:Z

    if-eqz v1, :cond_0

    .line 45
    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f060259

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;)V

    .line 47
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 48
    .local v0, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "share_listing_options_screen"

    const-string v3, "listing"

    const-string v4, "share_listing_poshmark_poshparty"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v1}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 60
    :goto_0
    return-void

    .line 51
    .end local v0    # "label":Ljava/lang/String;
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 52
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "share_listing_options_screen"

    const-string v3, "listing"

    const-string v4, "share_listing_failed"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    iget-boolean v1, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$isFragmentAdded:Z

    if-eqz v1, :cond_2

    .line 54
    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->val$callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SHARE_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const v6, 0x7f0600fa

    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    .line 57
    :cond_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;

    iget-object v1, v1, Lcom/poshmark/utils/sharing/share_states/ShareToPartyShare;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v1}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    goto :goto_0
.end method
