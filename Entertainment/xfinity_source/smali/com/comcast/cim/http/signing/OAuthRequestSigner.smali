.class public Lcom/comcast/cim/http/signing/OAuthRequestSigner;
.super Ljava/lang/Object;
.source "OAuthRequestSigner.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final key:Ljava/lang/String;

.field private final secret:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/comcast/cim/http/signing/OAuthRequestSigner;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/http/signing/OAuthRequestSigner;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "secret"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/comcast/cim/http/signing/OAuthRequestSigner;->key:Ljava/lang/String;

    .line 21
    iput-object p2, p0, Lcom/comcast/cim/http/signing/OAuthRequestSigner;->secret:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public signRequest(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)V
    .locals 4
    .param p1, "httpUriRequest"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    .prologue
    .line 26
    iget-object v2, p0, Lcom/comcast/cim/http/signing/OAuthRequestSigner;->key:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/comcast/cim/http/signing/OAuthRequestSigner;->secret:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 27
    new-instance v1, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/CommonsHttpOAuthConsumer;

    iget-object v2, p0, Lcom/comcast/cim/http/signing/OAuthRequestSigner;->key:Ljava/lang/String;

    iget-object v3, p0, Lcom/comcast/cim/http/signing/OAuthRequestSigner;->secret:Ljava/lang/String;

    invoke-direct {v1, v2, v3}, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/CommonsHttpOAuthConsumer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    .local v1, "oauthConsumer":Loauth/signpost/OAuthConsumer;
    :try_start_0
    invoke-interface {v1, p1}, Loauth/signpost/OAuthConsumer;->sign(Ljava/lang/Object;)Loauth/signpost/http/HttpRequest;
    :try_end_0
    .catch Loauth/signpost/exception/OAuthException; {:try_start_0 .. :try_end_0} :catch_0

    .line 36
    .end local v1    # "oauthConsumer":Loauth/signpost/OAuthConsumer;
    :cond_0
    :goto_0
    return-void

    .line 32
    .restart local v1    # "oauthConsumer":Loauth/signpost/OAuthConsumer;
    :catch_0
    move-exception v0

    .line 33
    .local v0, "ex":Loauth/signpost/exception/OAuthException;
    sget-object v2, Lcom/comcast/cim/http/signing/OAuthRequestSigner;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Exception occurred during oauth signing"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public bridge synthetic signRequest(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 13
    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/http/signing/OAuthRequestSigner;->signRequest(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)V

    return-void
.end method
