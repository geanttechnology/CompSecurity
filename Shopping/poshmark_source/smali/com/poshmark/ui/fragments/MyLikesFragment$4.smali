.class Lcom/poshmark/ui/fragments/MyLikesFragment$4;
.super Ljava/lang/Object;
.source "MyLikesFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MyLikesFragment;->handleNotification(Landroid/content/Intent;)V
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
        "Lcom/poshmark/data_model/models/MyLikes;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

.field final synthetic val$intent:Landroid/content/Intent;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MyLikesFragment;Landroid/content/Intent;)V
    .locals 0

    .prologue
    .line 253
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$4;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$4;->val$intent:Landroid/content/Intent;

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
            "Lcom/poshmark/data_model/models/MyLikes;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 256
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/MyLikes;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$4;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->hideProgressDialog()V

    .line 257
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$4;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getSearchModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/SearchFilterModel;->clearCount()V

    .line 258
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$4;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 259
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_0

    .line 260
    iget-object v2, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$4;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/data_model/models/MyLikes;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MyLikes;->getFacets()Lcom/poshmark/data_model/models/Facets;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/poshmark/ui/fragments/MyLikesFragment;->saveFacetLists(Lcom/poshmark/data_model/models/Facets;)V

    .line 261
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$4;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    .line 262
    .local v0, "base":Lcom/poshmark/ui/fragments/PMFilterableFragment;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$4;->val$intent:Landroid/content/Intent;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->handleNotification(Landroid/content/Intent;)V

    .line 265
    .end local v0    # "base":Lcom/poshmark/ui/fragments/PMFilterableFragment;
    :cond_0
    return-void
.end method
