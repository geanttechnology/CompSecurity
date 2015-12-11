.class Lcom/poshmark/ui/fragments/SearchResultsFragment$4;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SearchResultsFragment;->getSearchResults(Z)V
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
        "Lcom/poshmark/data_model/models/SearchResults;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SearchResultsFragment;)V
    .locals 0

    .prologue
    .line 260
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/SearchResults;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 263
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/SearchResults;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 264
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    const/4 v1, 0x1

    # invokes: Lcom/poshmark/ui/fragments/SearchResultsFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->access$100(Lcom/poshmark/ui/fragments/SearchResultsFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 266
    :cond_0
    return-void
.end method
