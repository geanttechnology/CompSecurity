.class Lcom/amazon/device/ads/AmazonOOAuthenticatedWebRequest;
.super Lcom/amazon/device/ads/HttpURLConnectionWebRequest;
.source "AmazonOOAuthenticatedWebRequest.java"


# instance fields
.field private final authMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)V
    .locals 0
    .param p1, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/amazon/device/ads/HttpURLConnectionWebRequest;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOOAuthenticatedWebRequest;->authMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    .line 30
    return-void
.end method


# virtual methods
.method protected openConnection(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    .locals 1
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOAuthenticatedWebRequest;->authMethod:Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;

    move-result-object v0

    return-object v0
.end method
