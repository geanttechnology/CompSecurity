.class public abstract Loauth/signpost/AbstractOAuthProvider;
.super Ljava/lang/Object;
.source "AbstractOAuthProvider.java"

# interfaces
.implements Loauth/signpost/OAuthProvider;


# instance fields
.field private accessTokenEndpointUrl:Ljava/lang/String;

.field private authorizationWebsiteUrl:Ljava/lang/String;

.field private defaultHeaders:Ljava/util/Map;
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

.field private isOAuth10a:Z

.field private transient listener:Loauth/signpost/OAuthProviderListener;

.field private requestTokenEndpointUrl:Ljava/lang/String;

.field private responseParameters:Loauth/signpost/http/HttpParameters;


# virtual methods
.method public getAccessTokenEndpointUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 319
    iget-object v0, p0, Loauth/signpost/AbstractOAuthProvider;->accessTokenEndpointUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthorizationWebsiteUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 323
    iget-object v0, p0, Loauth/signpost/AbstractOAuthProvider;->authorizationWebsiteUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getRequestHeaders()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 331
    iget-object v0, p0, Loauth/signpost/AbstractOAuthProvider;->defaultHeaders:Ljava/util/Map;

    return-object v0
.end method

.method public getRequestTokenEndpointUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Loauth/signpost/AbstractOAuthProvider;->requestTokenEndpointUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getResponseParameters()Loauth/signpost/http/HttpParameters;
    .locals 1

    .prologue
    .line 286
    iget-object v0, p0, Loauth/signpost/AbstractOAuthProvider;->responseParameters:Loauth/signpost/http/HttpParameters;

    return-object v0
.end method

.method public isOAuth10a()Z
    .locals 1

    .prologue
    .line 311
    iget-boolean v0, p0, Loauth/signpost/AbstractOAuthProvider;->isOAuth10a:Z

    return v0
.end method

.method public setListener(Loauth/signpost/OAuthProviderListener;)V
    .locals 0
    .param p1, "listener"    # Loauth/signpost/OAuthProviderListener;

    .prologue
    .line 335
    iput-object p1, p0, Loauth/signpost/AbstractOAuthProvider;->listener:Loauth/signpost/OAuthProviderListener;

    .line 336
    return-void
.end method

.method public setOAuth10a(Z)V
    .locals 0
    .param p1, "isOAuth10aProvider"    # Z

    .prologue
    .line 307
    iput-boolean p1, p0, Loauth/signpost/AbstractOAuthProvider;->isOAuth10a:Z

    .line 308
    return-void
.end method

.method public setResponseParameters(Loauth/signpost/http/HttpParameters;)V
    .locals 0
    .param p1, "parameters"    # Loauth/signpost/http/HttpParameters;

    .prologue
    .line 303
    iput-object p1, p0, Loauth/signpost/AbstractOAuthProvider;->responseParameters:Loauth/signpost/http/HttpParameters;

    .line 304
    return-void
.end method
