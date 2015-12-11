.class public abstract Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;
.super Ljava/lang/Object;
.source "AbstractDrmResponse.java"


# instance fields
.field protected messageId:Ljava/lang/String;

.field protected notOnOrAfter:Ljava/lang/String;

.field protected parsed:Z

.field protected rawXml:Ljava/lang/String;

.field protected status:Ljava/lang/String;

.field protected token:Ljava/lang/String;


# virtual methods
.method public getMessageId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->messageId:Ljava/lang/String;

    return-object v0
.end method

.method public getNotOnOrAfter()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->notOnOrAfter:Ljava/lang/String;

    return-object v0
.end method

.method public getRawXml()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->rawXml:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->status:Ljava/lang/String;

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->token:Ljava/lang/String;

    return-object v0
.end method

.method public isParsed()Z
    .locals 1

    .prologue
    .line 89
    iget-boolean v0, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->parsed:Z

    return v0
.end method

.method public setNotOnOrAfter(Ljava/lang/String;)V
    .locals 0
    .param p1, "notOnOrAfter"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->notOnOrAfter:Ljava/lang/String;

    .line 118
    return-void
.end method

.method public setParsed(Z)V
    .locals 0
    .param p1, "parsed"    # Z

    .prologue
    .line 93
    iput-boolean p1, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->parsed:Z

    .line 94
    return-void
.end method

.method public setRawXml(Ljava/lang/String;)V
    .locals 0
    .param p1, "rawXml"    # Ljava/lang/String;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->rawXml:Ljava/lang/String;

    .line 86
    return-void
.end method

.method public setStatus(Ljava/lang/String;)V
    .locals 0
    .param p1, "status"    # Ljava/lang/String;

    .prologue
    .line 101
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->status:Ljava/lang/String;

    .line 102
    return-void
.end method

.method public setToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/response/AbstractDrmResponse;->token:Ljava/lang/String;

    .line 110
    return-void
.end method
