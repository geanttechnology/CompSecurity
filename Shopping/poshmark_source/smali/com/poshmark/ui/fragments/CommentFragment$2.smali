.class Lcom/poshmark/ui/fragments/CommentFragment$2;
.super Ljava/lang/Object;
.source "CommentFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CommentFragment;->postComment()V
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
        "Lcom/poshmark/data_model/models/inner_models/Comment;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CommentFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CommentFragment;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CommentFragment$2;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Comment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/inner_models/Comment;>;"
    const/4 v3, 0x0

    .line 128
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment$2;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CommentFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 129
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment$2;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CommentFragment;->hideProgressDialog()V

    .line 130
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_1

    .line 131
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment$2;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/CommentFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-static {v1}, Lcom/poshmark/utils/FBDPAHelper;->trackComment(Lcom/poshmark/data_model/models/ListingSummary;)V

    .line 132
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CommentFragment$2;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CommentFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "comment"

    invoke-virtual {v1, v2, v4, v5, v3}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    iget-object v7, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v7, Lcom/poshmark/data_model/models/inner_models/Comment;

    .line 134
    .local v7, "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CommentFragment$2;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CommentFragment;->listingId:Ljava/lang/String;

    invoke-virtual {v1, v2, v7}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingCommentMessage(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V

    .line 135
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment$2;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/CommentFragment;->finishActivity()V

    .line 156
    .end local v7    # "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    :cond_0
    :goto_0
    return-void

    .line 138
    :cond_1
    const/4 v0, 0x0

    .line 139
    .local v0, "errorContext":Lcom/poshmark/ui/model/ActionErrorContext;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0600d2

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 140
    .local v6, "errorMessage":Ljava/lang/String;
    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v1, v1, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v2, Lcom/poshmark/data_model/models/PMErrorType;->INSUFFICIENT_PRIVILEGES_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v1, v2, :cond_3

    .line 142
    const-string v8, ""

    .line 143
    .local v8, "handle":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment$2;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/CommentFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingSocial;

    if-eqz v1, :cond_2

    .line 144
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment$2;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/CommentFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSocial;->getUserName()Ljava/lang/String;

    move-result-object v8

    .line 145
    :cond_2
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0600d1

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v8, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 146
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    .end local v0    # "errorContext":Lcom/poshmark/ui/model/ActionErrorContext;
    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->ADD_COMMENT:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    move-object v5, v3

    invoke-direct/range {v0 .. v6}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;Ljava/lang/String;Ljava/lang/String;)V

    .line 153
    .end local v8    # "handle":Ljava/lang/String;
    .restart local v0    # "errorContext":Lcom/poshmark/ui/model/ActionErrorContext;
    :goto_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment$2;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/fragments/CommentFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0

    .line 150
    :cond_3
    new-instance v0, Lcom/poshmark/ui/model/ActionErrorContext;

    .end local v0    # "errorContext":Lcom/poshmark/ui/model/ActionErrorContext;
    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v2, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->ADD_COMMENT:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v0, v1, v2, v6, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    .restart local v0    # "errorContext":Lcom/poshmark/ui/model/ActionErrorContext;
    goto :goto_1
.end method
