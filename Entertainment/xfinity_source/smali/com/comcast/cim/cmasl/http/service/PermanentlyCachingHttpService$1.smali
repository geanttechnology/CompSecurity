.class Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;
.super Ljava/lang/Object;
.source "PermanentlyCachingHttpService.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService",
        "<TT;>.com/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler<TRS;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

.field final synthetic val$requestProvider:Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;

.field final synthetic val$responseHandlerProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)V
    .locals 0

    .prologue
    .line 34
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService.1;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;->this$0:Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;->val$requestProvider:Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;

    iput-object p3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;->val$responseHandlerProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService",
            "<TT;>.com/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler<TRS;>;"
        }
    .end annotation

    .prologue
    .line 36
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService.1;"
    new-instance v0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;->this$0:Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;->this$0:Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;

    # getter for: Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->storageCache:Lcom/comcast/cim/cmasl/utils/StorageCache;
    invoke-static {v2}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;->access$000(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;)Lcom/comcast/cim/cmasl/utils/StorageCache;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;->val$requestProvider:Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;->getCacheKey()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;->val$responseHandlerProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;-><init>(Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService;Lcom/comcast/cim/cmasl/utils/StorageCache;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/response/ResponseHandler;Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 34
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;, "Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService.1;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$1;->get()Lcom/comcast/cim/cmasl/http/service/PermanentlyCachingHttpService$StreamStoringResponseHandler;

    move-result-object v0

    return-object v0
.end method
