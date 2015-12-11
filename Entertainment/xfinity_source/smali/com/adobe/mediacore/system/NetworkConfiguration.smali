.class public Lcom/adobe/mediacore/system/NetworkConfiguration;
.super Lcom/adobe/mediacore/metadata/MetadataNode;


# instance fields
.field private _cookieHeaders:Lcom/adobe/mediacore/metadata/Metadata;

.field private _customHeaders:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private _masterUpdateInterval:I

.field private _useCookieHeadersForAllRequests:Z

.field private _useRedirectedUrl:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    iput-object v1, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_cookieHeaders:Lcom/adobe/mediacore/metadata/Metadata;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_useCookieHeadersForAllRequests:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_useRedirectedUrl:Z

    iput-object v1, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_customHeaders:Ljava/util/HashMap;

    const/4 v0, -0x1

    iput v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_masterUpdateInterval:I

    return-void
.end method


# virtual methods
.method public addCustomHeader(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_customHeaders:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_customHeaders:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_customHeaders:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public getCookieHeaders()Lcom/adobe/mediacore/metadata/Metadata;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_cookieHeaders:Lcom/adobe/mediacore/metadata/Metadata;

    return-object v0
.end method

.method public getCustomHeaders()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_customHeaders:Ljava/util/HashMap;

    return-object v0
.end method

.method public getMasterUpdateInterval()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_masterUpdateInterval:I

    return v0
.end method

.method public getUseCookieHeadersForAllRequests()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_useCookieHeadersForAllRequests:Z

    return v0
.end method

.method public getUseRedirectedUrl()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_useRedirectedUrl:Z

    return v0
.end method

.method public setCookieHeaders(Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_cookieHeaders:Lcom/adobe/mediacore/metadata/Metadata;

    return-void
.end method

.method public setMasterUpdateInterval(I)V
    .locals 0

    iput p1, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_masterUpdateInterval:I

    return-void
.end method

.method public setUseCookieHeadersForAllRequests(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_useCookieHeadersForAllRequests:Z

    return-void
.end method

.method public setUseRedirectedUrl(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/system/NetworkConfiguration;->_useRedirectedUrl:Z

    return-void
.end method
