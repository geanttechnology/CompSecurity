.class public Lcom/poshmark/http/PMHttpRequest;
.super Ljava/lang/Object;
.source "PMHttpRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;
    }
.end annotation


# static fields
.field public static final DEFAULT_POST_TIMEOUT_MILLISECONDS:I = 0xafc8

.field public static final DEFAULT_TIMEOUT_MILLISECONDS:I = 0x4e20

.field public static final USE_DEFAULT_TIMEOUT:I = -0x1


# instance fields
.field public final formData:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final headers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final multipartData:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/poshmark/http/PMMultipartItem;",
            ">;"
        }
    .end annotation
.end field

.field public final nestedFormData:Lcom/poshmark/utils/view_holders/MultiMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/poshmark/utils/view_holders/MultiMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field public final queryParams:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final requestType:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

.field public responseHandler:Lcom/poshmark/http/PMBaseHttpResponseHandler;

.field public timeoutMilliSeconds:I

.field public final url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;Ljava/lang/String;)V
    .locals 3
    .param p1, "requestType"    # Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v0, -0x1

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/poshmark/http/PMHttpRequest;->headers:Ljava/util/Map;

    .line 29
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/poshmark/http/PMHttpRequest;->queryParams:Ljava/util/Map;

    .line 30
    new-instance v1, Lcom/poshmark/utils/view_holders/MultiMap;

    invoke-direct {v1}, Lcom/poshmark/utils/view_holders/MultiMap;-><init>()V

    iput-object v1, p0, Lcom/poshmark/http/PMHttpRequest;->formData:Ljava/util/Map;

    .line 31
    new-instance v1, Lcom/poshmark/utils/view_holders/MultiMap;

    invoke-direct {v1}, Lcom/poshmark/utils/view_holders/MultiMap;-><init>()V

    iput-object v1, p0, Lcom/poshmark/http/PMHttpRequest;->nestedFormData:Lcom/poshmark/utils/view_holders/MultiMap;

    .line 32
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/poshmark/http/PMHttpRequest;->multipartData:Ljava/util/Map;

    .line 33
    iput v0, p0, Lcom/poshmark/http/PMHttpRequest;->timeoutMilliSeconds:I

    .line 39
    iput-object p1, p0, Lcom/poshmark/http/PMHttpRequest;->requestType:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    .line 40
    iput-object p2, p0, Lcom/poshmark/http/PMHttpRequest;->url:Ljava/lang/String;

    .line 42
    sget-object v1, Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;->HTTP_GET:Lcom/poshmark/http/PMHttpRequest$REQUEST_TYPE;

    if-ne p1, v1, :cond_0

    :goto_0
    iput v0, p0, Lcom/poshmark/http/PMHttpRequest;->timeoutMilliSeconds:I

    .line 45
    iget-object v0, p0, Lcom/poshmark/http/PMHttpRequest;->headers:Ljava/util/Map;

    const-string v1, "Accept"

    const-string v2, "*/*"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    iget-object v0, p0, Lcom/poshmark/http/PMHttpRequest;->headers:Ljava/util/Map;

    const-string v1, "Accept-Language"

    const-string v2, "en-us"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    return-void

    .line 42
    :cond_0
    const v0, 0xafc8

    goto :goto_0
.end method


# virtual methods
.method public execute(Lcom/poshmark/http/PMHttpResponseHandler;)V
    .locals 1
    .param p1, "responseHandler"    # Lcom/poshmark/http/PMHttpResponseHandler;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/http/PMHttpRequest;->responseHandler:Lcom/poshmark/http/PMBaseHttpResponseHandler;

    .line 53
    new-instance v0, Lcom/poshmark/http/httpCore/PMHttpExecutor;

    invoke-direct {v0, p0}, Lcom/poshmark/http/httpCore/PMHttpExecutor;-><init>(Lcom/poshmark/http/PMHttpRequest;)V

    invoke-virtual {v0}, Lcom/poshmark/http/httpCore/PMHttpExecutor;->execute()V

    .line 54
    return-void
.end method
