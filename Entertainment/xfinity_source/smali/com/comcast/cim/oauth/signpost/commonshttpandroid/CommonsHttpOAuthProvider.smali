.class public Lcom/comcast/cim/oauth/signpost/commonshttpandroid/CommonsHttpOAuthProvider;
.super Loauth/signpost/AbstractOAuthProvider;
.source "CommonsHttpOAuthProvider.java"


# instance fields
.field private transient httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;


# virtual methods
.method public setHttpClient(Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 0
    .param p1, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/CommonsHttpOAuthProvider;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 54
    return-void
.end method
