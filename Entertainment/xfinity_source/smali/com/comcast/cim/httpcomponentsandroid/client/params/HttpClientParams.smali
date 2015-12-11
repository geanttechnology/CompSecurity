.class public Lcom/comcast/cim/httpcomponentsandroid/client/params/HttpClientParams;
.super Ljava/lang/Object;
.source "HttpClientParams.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    return-void
.end method

.method public static getCookiePolicy(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/lang/String;
    .locals 3
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 78
    if-nez p0, :cond_0

    .line 79
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP parameters may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 81
    :cond_0
    const-string v1, "http.protocol.cookie-policy"

    invoke-interface {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 83
    .local v0, "cookiePolicy":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 84
    const-string v0, "best-match"

    .line 86
    .end local v0    # "cookiePolicy":Ljava/lang/String;
    :cond_1
    return-object v0
.end method

.method public static isAuthenticating(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Z
    .locals 2
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 62
    if-nez p0, :cond_0

    .line 63
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 65
    :cond_0
    const-string v0, "http.protocol.handle-authentication"

    const/4 v1, 0x1

    invoke-interface {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getBooleanParameter(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public static isRedirecting(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Z
    .locals 2
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 46
    if-nez p0, :cond_0

    .line 47
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 49
    :cond_0
    const-string v0, "http.protocol.handle-redirects"

    const/4 v1, 0x1

    invoke-interface {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getBooleanParameter(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method
