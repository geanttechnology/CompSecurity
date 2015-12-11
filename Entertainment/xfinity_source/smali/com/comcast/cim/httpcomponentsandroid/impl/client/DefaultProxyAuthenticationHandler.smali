.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultProxyAuthenticationHandler;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractAuthenticationHandler;
.source "DefaultProxyAuthenticationHandler.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractAuthenticationHandler;-><init>()V

    .line 55
    return-void
.end method


# virtual methods
.method protected getAuthPreferences(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/util/List;
    .locals 3
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;",
            "Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 82
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v1

    const-string v2, "http.auth.proxy-scheme-pref"

    invoke-interface {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 84
    .local v0, "authpref":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    .line 87
    .end local v0    # "authpref":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    return-object v0

    .restart local v0    # "authpref":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/AbstractAuthenticationHandler;->getAuthPreferences(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public getChallenges(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/util/Map;
    .locals 3
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;",
            "Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;
        }
    .end annotation

    .prologue
    .line 70
    if-nez p1, :cond_0

    .line 71
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP response may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 73
    :cond_0
    const-string v1, "Proxy-Authenticate"

    invoke-interface {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 74
    .local v0, "headers":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultProxyAuthenticationHandler;->parseChallenges([Lcom/comcast/cim/httpcomponentsandroid/Header;)Ljava/util/Map;

    move-result-object v1

    return-object v1
.end method

.method public isAuthenticationRequested(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z
    .locals 3
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .prologue
    .line 60
    if-nez p1, :cond_0

    .line 61
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP response may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 63
    :cond_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v0

    .line 64
    .local v0, "status":I
    const/16 v1, 0x197

    if-ne v0, v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method
