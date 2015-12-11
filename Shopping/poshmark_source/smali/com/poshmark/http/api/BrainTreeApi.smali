.class public Lcom/poshmark/http/api/BrainTreeApi;
.super Ljava/lang/Object;
.source "BrainTreeApi.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static PostBrainTreeValidation(Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/BrainTreeHttpResponseHandler;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "handler"    # Lcom/poshmark/http/BrainTreeHttpResponseHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/BrainTreeHttpResponseHandler;",
            ")V"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/poshmark/http/PMHttpRequest;

    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_POST:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    invoke-direct {v0, v1, p1}, Lcom/poshmark/http/PMHttpRequest;-><init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;)V

    .line 17
    .local v0, "apiRequest":Lcom/poshmark/http/PMHttpRequest;
    iget-object v1, v0, Lcom/poshmark/http/PMHttpRequest;->formData:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 18
    invoke-virtual {v0, p2}, Lcom/poshmark/http/PMHttpRequest;->execute(Lcom/poshmark/http/PMHttpResponseHandler;)V

    .line 19
    return-void
.end method
