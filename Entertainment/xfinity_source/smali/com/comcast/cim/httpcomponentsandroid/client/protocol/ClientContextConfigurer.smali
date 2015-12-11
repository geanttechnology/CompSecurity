.class public Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ClientContextConfigurer;
.super Ljava/lang/Object;
.source "ClientContextConfigurer.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ClientContext;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private final context:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;


# virtual methods
.method public setAuthSchemePref(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 80
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ClientContextConfigurer;->context:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    const-string v1, "http.auth.scheme-pref"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 81
    return-void
.end method

.method public setAuthSchemeRegistry(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;)V
    .locals 2
    .param p1, "registry"    # Lcom/comcast/cim/httpcomponentsandroid/auth/AuthSchemeRegistry;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ClientContextConfigurer;->context:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    const-string v1, "http.authscheme-registry"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 63
    return-void
.end method

.method public setCookieSpecRegistry(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;)V
    .locals 2
    .param p1, "registry"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecRegistry;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ClientContextConfigurer;->context:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    const-string v1, "http.cookiespec-registry"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 59
    return-void
.end method

.method public setCookieStore(Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;)V
    .locals 2
    .param p1, "store"    # Lcom/comcast/cim/httpcomponentsandroid/client/CookieStore;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ClientContextConfigurer;->context:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    const-string v1, "http.cookie-store"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 67
    return-void
.end method

.method public setCredentialsProvider(Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;)V
    .locals 2
    .param p1, "provider"    # Lcom/comcast/cim/httpcomponentsandroid/client/CredentialsProvider;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ClientContextConfigurer;->context:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    const-string v1, "http.auth.credentials-provider"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 71
    return-void
.end method
