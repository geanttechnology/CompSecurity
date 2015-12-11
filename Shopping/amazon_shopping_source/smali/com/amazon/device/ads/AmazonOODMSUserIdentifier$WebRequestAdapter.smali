.class Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;
.super Lcom/amazon/device/ads/WebRequest;
.source "AmazonOODMSUserIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "WebRequestAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;

.field private final webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;Lcom/AmazonDevice/Identity/Common/WebRequest;)V
    .locals 0
    .param p2, "webRequest"    # Lcom/AmazonDevice/Identity/Common/WebRequest;

    .prologue
    .line 322
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;->this$0:Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;

    invoke-direct {p0}, Lcom/amazon/device/ads/WebRequest;-><init>()V

    .line 323
    iput-object p2, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    .line 324
    return-void
.end method


# virtual methods
.method protected addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 358
    if-eqz p2, :cond_0

    .line 360
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    invoke-virtual {v0, p1, p2}, Lcom/AmazonDevice/Identity/Common/WebRequest;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 362
    :cond_0
    return-void
.end method

.method protected doHttpNetworkCall(Ljava/net/URL;)Lcom/amazon/device/ads/WebRequest$WebResponse;
    .locals 1
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/device/ads/WebRequest$WebRequestException;
        }
    .end annotation

    .prologue
    .line 368
    const/4 v0, 0x0

    return-object v0
.end method

.method protected getSubLogTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 375
    const/4 v0, 0x0

    return-object v0
.end method

.method public putUnencodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p1, "parameter"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 337
    invoke-virtual {p0, p1, p2}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 338
    return-object p2
.end method

.method public putUrlEncodedQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "parameter"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 329
    invoke-virtual {p0, p1, p2}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 330
    return-void
.end method

.method public setHost(Ljava/lang/String;)V
    .locals 1
    .param p1, "host"    # Ljava/lang/String;

    .prologue
    .line 344
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    invoke-virtual {v0, p1}, Lcom/AmazonDevice/Identity/Common/WebRequest;->setHost(Ljava/lang/String;)V

    .line 345
    return-void
.end method

.method public setUseSecure(Z)V
    .locals 1
    .param p1, "useSecure"    # Z

    .prologue
    .line 350
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$WebRequestAdapter;->webRequest:Lcom/AmazonDevice/Identity/Common/WebRequest;

    invoke-virtual {v0, p1}, Lcom/AmazonDevice/Identity/Common/WebRequest;->setAuthenticationRequired(Z)V

    .line 351
    return-void
.end method
