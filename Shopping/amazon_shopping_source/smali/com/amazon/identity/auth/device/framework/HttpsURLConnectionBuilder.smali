.class public Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;
.super Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;
.source "HttpsURLConnectionBuilder.java"


# instance fields
.field private final mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;


# direct methods
.method public constructor <init>(Ljava/net/URL;)V
    .locals 3
    .param p1, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;-><init>(Ljava/net/URL;)V

    .line 23
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->getInnerStore()Ljava/net/HttpURLConnection;

    move-result-object v0

    .line 24
    .local v0, "connection":Ljava/net/HttpURLConnection;
    instance-of v1, v0, Ljavax/net/ssl/HttpsURLConnection;

    if-nez v1, :cond_0

    .line 26
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "url must be https"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 29
    :cond_0
    check-cast v0, Ljavax/net/ssl/HttpsURLConnection;

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    .line 30
    return-void
.end method


# virtual methods
.method public bridge synthetic addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-super {p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->addRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public bridge synthetic getAllowUserInteraction()Z
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getAllowUserInteraction()Z

    move-result v0

    return v0
.end method

.method public getCipherSuite()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getCipherSuite()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getConnectTimeout()I
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getConnectTimeout()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getDefaultUseCaches()Z
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getDefaultUseCaches()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic getDoInput()Z
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getDoInput()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic getDoOutput()Z
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getDoOutput()Z

    move-result v0

    return v0
.end method

.method public getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getIfModifiedSince()J
    .locals 2

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getIfModifiedSince()J

    move-result-wide v0

    return-wide v0
.end method

.method public bridge synthetic getInstanceFollowRedirects()Z
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getInstanceFollowRedirects()Z

    move-result v0

    return v0
.end method

.method public getLocalCertificates()[Ljava/security/cert/Certificate;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getLocalCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    return-object v0
.end method

.method public getLocalPrincipal()Ljava/security/Principal;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getLocalPrincipal()Ljava/security/Principal;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getOutputStream()Ljava/io/OutputStream;
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v0

    return-object v0
.end method

.method public getPeerPrincipal()Ljava/security/Principal;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/net/ssl/SSLPeerUnverifiedException;
        }
    .end annotation

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getPeerPrincipal()Ljava/security/Principal;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getReadTimeout()I
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getReadTimeout()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getRequestMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getRequestMethod()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getRequestProperties()Ljava/util/Map;
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getRequestProperties()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getRequestProperty(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v0

    return-object v0
.end method

.method public getServerCertificates()[Ljava/security/cert/Certificate;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/net/ssl/SSLPeerUnverifiedException;
        }
    .end annotation

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getServerCertificates()[Ljava/security/cert/Certificate;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getURL()Ljava/net/URL;
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getURL()Ljava/net/URL;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getUseCaches()Z
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->getUseCaches()Z

    move-result v0

    return v0
.end method

.method protected populateConnectionAttributes(Ljava/net/HttpURLConnection;)V
    .locals 2
    .param p1, "httpConnection"    # Ljava/net/HttpURLConnection;

    .prologue
    .line 81
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->populateConnectionAttributes(Ljava/net/HttpURLConnection;)V

    .line 83
    instance-of v1, p1, Ljavax/net/ssl/HttpsURLConnection;

    if-nez v1, :cond_0

    .line 92
    :goto_0
    return-void

    :cond_0
    move-object v0, p1

    .line 88
    check-cast v0, Ljavax/net/ssl/HttpsURLConnection;

    .line 90
    .local v0, "httpsConnection":Ljavax/net/ssl/HttpsURLConnection;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v1}, Ljavax/net/ssl/HttpsURLConnection;->getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljavax/net/ssl/HttpsURLConnection;->setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V

    .line 91
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v1}, Ljavax/net/ssl/HttpsURLConnection;->getHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljavax/net/ssl/HttpsURLConnection;->setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    goto :goto_0
.end method

.method public bridge synthetic setAllowUserInteraction(Z)V
    .locals 0
    .param p1, "x0"    # Z

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setAllowUserInteraction(Z)V

    return-void
.end method

.method public bridge synthetic setChunkedStreamingMode(I)V
    .locals 0
    .param p1, "x0"    # I

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setChunkedStreamingMode(I)V

    return-void
.end method

.method public bridge synthetic setConnectTimeout(I)V
    .locals 0
    .param p1, "x0"    # I

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setConnectTimeout(I)V

    return-void
.end method

.method public bridge synthetic setDefaultUseCaches(Z)V
    .locals 0
    .param p1, "x0"    # Z

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setDefaultUseCaches(Z)V

    return-void
.end method

.method public bridge synthetic setDoInput(Z)V
    .locals 0
    .param p1, "x0"    # Z

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setDoInput(Z)V

    return-void
.end method

.method public bridge synthetic setDoOutput(Z)V
    .locals 0
    .param p1, "x0"    # Z

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setDoOutput(Z)V

    return-void
.end method

.method public bridge synthetic setFixedLengthStreamingMode(J)V
    .locals 0
    .param p1, "x0"    # J

    .prologue
    .line 15
    invoke-super {p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setFixedLengthStreamingMode(J)V

    return-void
.end method

.method public setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V
    .locals 1
    .param p1, "v"    # Ljavax/net/ssl/HostnameVerifier;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0, p1}, Ljavax/net/ssl/HttpsURLConnection;->setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    .line 36
    return-void
.end method

.method public bridge synthetic setIfModifiedSince(J)V
    .locals 0
    .param p1, "x0"    # J

    .prologue
    .line 15
    invoke-super {p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setIfModifiedSince(J)V

    return-void
.end method

.method public bridge synthetic setInstanceFollowRedirects(Z)V
    .locals 0
    .param p1, "x0"    # Z

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setInstanceFollowRedirects(Z)V

    return-void
.end method

.method public bridge synthetic setReadTimeout(I)V
    .locals 0
    .param p1, "x0"    # I

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setReadTimeout(I)V

    return-void
.end method

.method public bridge synthetic setRequestMethod(Ljava/lang/String;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/ProtocolException;
        }
    .end annotation

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setRequestMethod(Ljava/lang/String;)V

    return-void
.end method

.method public bridge synthetic setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-super {p0, p1, p2}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V
    .locals 1
    .param p1, "sf"    # Ljavax/net/ssl/SSLSocketFactory;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/HttpsURLConnectionBuilder;->mInnerConnectionStore:Ljavax/net/ssl/HttpsURLConnection;

    invoke-virtual {v0, p1}, Ljavax/net/ssl/HttpsURLConnection;->setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V

    .line 41
    return-void
.end method

.method public bridge synthetic setUseCaches(Z)V
    .locals 0
    .param p1, "x0"    # Z

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->setUseCaches(Z)V

    return-void
.end method

.method public bridge synthetic toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic usingProxy()Z
    .locals 1

    .prologue
    .line 15
    invoke-super {p0}, Lcom/amazon/identity/auth/device/framework/HttpURLConnectionBuilder;->usingProxy()Z

    move-result v0

    return v0
.end method
