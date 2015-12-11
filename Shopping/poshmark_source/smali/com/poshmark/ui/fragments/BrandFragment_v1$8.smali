.class Lcom/poshmark/ui/fragments/BrandFragment_v1$8;
.super Ljava/lang/Object;
.source "BrandFragment_v1.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandFragment_v1;->getSearchResults(Z)V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V
    .locals 0

    .prologue
    .line 427
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$8;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

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
    .line 430
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/SearchResults;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$8;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 431
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$8;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    const/4 v1, 0x1

    # invokes: Lcom/poshmark/ui/fragments/BrandFragment_v1;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$600(Lcom/poshmark/ui/fragments/BrandFragment_v1;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 433
    :cond_0
    return-void
.end method
