.class Lcom/poshmark/ui/fragments/BrandFragment$8;
.super Ljava/lang/Object;
.source "BrandFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandFragment;->getSearchResults(Z)V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandFragment;)V
    .locals 0

    .prologue
    .line 435
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment$8;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

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
    .line 438
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/SearchResults;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$8;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/BrandFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 439
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$8;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    const/4 v1, 0x1

    # invokes: Lcom/poshmark/ui/fragments/BrandFragment;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/BrandFragment;->access$600(Lcom/poshmark/ui/fragments/BrandFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 441
    :cond_0
    return-void
.end method
