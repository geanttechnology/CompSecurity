.class public Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;
.super Ljava/lang/Object;
.source "RetryingHttpService.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/service/HttpService;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/service/HttpService",
        "<TT;",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<TT;>;>;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final delegateService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private final predicate:Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;)V
    .locals 0
    .param p2, "predicate"    # Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;",
            ")V"
        }
    .end annotation

    .prologue
    .line 19
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;, "Lcom/comcast/cim/cmasl/http/service/RetryingHttpService<TT;>;"
    .local p1, "delegateService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;->delegateService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 21
    iput-object p2, p0, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;->predicate:Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;

    .line 22
    return-void
.end method


# virtual methods
.method public executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<RS::",
            "Lcom/comcast/cim/cmasl/http/response/ResponseHandler;",
            ">(",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<TRS;>;)TRS;"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;, "Lcom/comcast/cim/cmasl/http/service/RetryingHttpService<TT;>;"
    .local p1, "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    .local p2, "responseHandlerProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<TRS;>;"
    const/4 v1, 0x0

    .line 29
    .local v1, "retryCount":I
    :goto_0
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;->delegateService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    invoke-interface {v2, p1, p2}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    :try_end_0
    .catch Lcom/comcast/cim/cmasl/utils/exceptions/CimException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    return-object v2

    .line 30
    :catch_0
    move-exception v0

    .line 31
    .local v0, "e":Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
    iget-object v2, p0, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;->predicate:Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;

    invoke-interface {v2, v0, v1}, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;->shouldRetry(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 32
    sget-object v2, Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Caught exception processing request, retrying"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 33
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 35
    :cond_0
    throw v0
.end method
