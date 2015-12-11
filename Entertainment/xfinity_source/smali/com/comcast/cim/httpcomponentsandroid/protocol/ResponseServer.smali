.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/ResponseServer;
.super Ljava/lang/Object;
.source "ResponseServer.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 3
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 57
    if-nez p1, :cond_0

    .line 58
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP request may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 60
    :cond_0
    const-string v1, "Server"

    invoke-interface {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->containsHeader(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 61
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v1

    const-string v2, "http.origin-server"

    invoke-interface {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 63
    .local v0, "s":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 64
    const-string v1, "Server"

    invoke-interface {p1, v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    .end local v0    # "s":Ljava/lang/String;
    :cond_1
    return-void
.end method
