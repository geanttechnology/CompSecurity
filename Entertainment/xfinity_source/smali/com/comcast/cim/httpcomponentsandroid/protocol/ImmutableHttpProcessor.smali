.class public final Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;
.super Ljava/lang/Object;
.source "ImmutableHttpProcessor.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpProcessor;


# instance fields
.field private final requestInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

.field private final responseInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;


# direct methods
.method public constructor <init>([Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;[Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;)V
    .locals 5
    .param p1, "requestInterceptors"    # [Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;
    .param p2, "responseInterceptors"    # [Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    .prologue
    const/4 v4, 0x0

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    if-eqz p1, :cond_0

    .line 53
    array-length v0, p1

    .line 54
    .local v0, "count":I
    new-array v2, v0, [Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;->requestInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    .line 55
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 56
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;->requestInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    aget-object v3, p1, v1

    aput-object v3, v2, v1

    .line 55
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 59
    .end local v0    # "count":I
    .end local v1    # "i":I
    :cond_0
    new-array v2, v4, [Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;->requestInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    .line 61
    :cond_1
    if-eqz p2, :cond_2

    .line 62
    array-length v0, p2

    .line 63
    .restart local v0    # "count":I
    new-array v2, v0, [Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;->responseInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    .line 64
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_1
    if-ge v1, v0, :cond_3

    .line 65
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;->responseInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    aget-object v3, p2, v1

    aput-object v3, v2, v1

    .line 64
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 68
    .end local v0    # "count":I
    .end local v1    # "i":I
    :cond_2
    new-array v2, v4, [Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;->responseInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    .line 70
    :cond_3
    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 2
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;
        }
    .end annotation

    .prologue
    .line 107
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;->requestInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 108
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;->requestInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;

    aget-object v1, v1, v0

    invoke-interface {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequestInterceptor;->process(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 107
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 110
    :cond_0
    return-void
.end method

.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 2
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;
        }
    .end annotation

    .prologue
    .line 115
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;->responseInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 116
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ImmutableHttpProcessor;->responseInterceptors:[Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;

    aget-object v1, v1, v0

    invoke-interface {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;->process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V

    .line 115
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 118
    :cond_0
    return-void
.end method
