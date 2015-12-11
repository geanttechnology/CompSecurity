.class public Lcom/xfinity/playerlib/authorization/VideoAuthToken;
.super Ljava/lang/Object;
.source "VideoAuthToken.java"


# instance fields
.field private issueTime:Ljava/lang/String;

.field private keyName:Ljava/lang/String;

.field private opaqueUserID:Ljava/lang/String;

.field private rawData:Ljava/lang/String;

.field private requestorID:Ljava/lang/String;

.field private resourceID:Ljava/lang/String;

.field private titleID:Ljava/lang/String;

.field private ttl:Ljava/lang/String;

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method


# virtual methods
.method public getIssueTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->issueTime:Ljava/lang/String;

    return-object v0
.end method

.method public getKeyName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->keyName:Ljava/lang/String;

    return-object v0
.end method

.method public getOpaqueUserID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->opaqueUserID:Ljava/lang/String;

    return-object v0
.end method

.method public getRawData()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->rawData:Ljava/lang/String;

    return-object v0
.end method

.method public getRequestorID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->requestorID:Ljava/lang/String;

    return-object v0
.end method

.method public getResourceID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->resourceID:Ljava/lang/String;

    return-object v0
.end method

.method public getTitleID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->titleID:Ljava/lang/String;

    return-object v0
.end method

.method public getTtl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->ttl:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->value:Ljava/lang/String;

    return-object v0
.end method

.method public setIssueTime(Ljava/lang/String;)V
    .locals 0
    .param p1, "issueTime"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->issueTime:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setKeyName(Ljava/lang/String;)V
    .locals 0
    .param p1, "keyName"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->keyName:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setOpaqueUserID(Ljava/lang/String;)V
    .locals 0
    .param p1, "opaqueUserID"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->opaqueUserID:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setRawData(Ljava/lang/String;)V
    .locals 0
    .param p1, "rawData"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->rawData:Ljava/lang/String;

    .line 92
    return-void
.end method

.method public setRequestorID(Ljava/lang/String;)V
    .locals 0
    .param p1, "requestorID"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->requestorID:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setResourceID(Ljava/lang/String;)V
    .locals 0
    .param p1, "resourceID"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->resourceID:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setTitleID(Ljava/lang/String;)V
    .locals 0
    .param p1, "titleID"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->titleID:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setTtl(Ljava/lang/String;)V
    .locals 0
    .param p1, "ttl"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->ttl:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->value:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 96
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "resourceID"

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->resourceID:Ljava/lang/String;

    .line 97
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "titleId"

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->titleID:Ljava/lang/String;

    .line 98
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "requestorID"

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->requestorID:Ljava/lang/String;

    .line 99
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "issueTime"

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->issueTime:Ljava/lang/String;

    .line 100
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "ttl"

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->ttl:Ljava/lang/String;

    .line 101
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "opaqueUserID"

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->opaqueUserID:Ljava/lang/String;

    .line 102
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "keyName"

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->keyName:Ljava/lang/String;

    .line 103
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "value"

    iget-object v2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthToken;->value:Ljava/lang/String;

    .line 104
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    .line 105
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
