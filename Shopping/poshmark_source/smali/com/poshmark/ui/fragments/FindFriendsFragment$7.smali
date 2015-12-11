.class Lcom/poshmark/ui/fragments/FindFriendsFragment$7;
.super Ljava/lang/Object;
.source "FindFriendsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindFriendsFragment;->fetchTwFriends()V
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
        "Lcom/poshmark/data_model/models/UserReferenceList;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V
    .locals 0

    .prologue
    .line 252
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$7;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

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
            "Lcom/poshmark/data_model/models/UserReferenceList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 255
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/UserReferenceList;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$7;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 256
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$7;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->hideProgressDialog()V

    .line 257
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_1

    .line 258
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$7;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/UserReferenceList;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;->twitterList:Lcom/poshmark/data_model/models/UserReferenceList;

    .line 259
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$7;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    # invokes: Lcom/poshmark/ui/fragments/FindFriendsFragment;->updateTwitterPanel()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->access$300(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V

    .line 265
    :cond_0
    :goto_0
    return-void

    .line 262
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$7;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    new-instance v1, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v3, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->FETCH_TWITTER_PM_USERS:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    invoke-direct {v1, v2, v3}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
