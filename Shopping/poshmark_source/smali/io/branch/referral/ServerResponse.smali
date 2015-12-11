.class Lio/branch/referral/ServerResponse;
.super Ljava/lang/Object;
.source "ServerResponse.java"


# instance fields
.field private linkData_:Lio/branch/referral/BranchLinkData;

.field private post_:Ljava/lang/Object;

.field private statusCode_:I

.field private tag_:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;I)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "statusCode"    # I

    .prologue
    .line 53
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lio/branch/referral/ServerResponse;-><init>(Ljava/lang/String;ILio/branch/referral/BranchLinkData;)V

    .line 54
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ILio/branch/referral/BranchLinkData;)V
    .locals 0
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "linkData"    # Lio/branch/referral/BranchLinkData;

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    iput-object p1, p0, Lio/branch/referral/ServerResponse;->tag_:Ljava/lang/String;

    .line 66
    iput p2, p0, Lio/branch/referral/ServerResponse;->statusCode_:I

    .line 67
    iput-object p3, p0, Lio/branch/referral/ServerResponse;->linkData_:Lio/branch/referral/BranchLinkData;

    .line 68
    return-void
.end method


# virtual methods
.method public getArray()Lorg/json/JSONArray;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lio/branch/referral/ServerResponse;->post_:Ljava/lang/Object;

    instance-of v0, v0, Lorg/json/JSONArray;

    if-eqz v0, :cond_0

    .line 123
    iget-object v0, p0, Lio/branch/referral/ServerResponse;->post_:Ljava/lang/Object;

    check-cast v0, Lorg/json/JSONArray;

    .line 126
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFailReason()Ljava/lang/String;
    .locals 4

    .prologue
    .line 146
    const-string v0, ""

    .line 148
    .local v0, "causeMsg":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p0}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v1

    .line 149
    .local v1, "postObj":Lorg/json/JSONObject;
    if-eqz v1, :cond_0

    const-string v2, "error"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "error"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "message"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 152
    const-string v2, "error"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "message"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 153
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 154
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 159
    .end local v1    # "postObj":Lorg/json/JSONObject;
    :cond_0
    :goto_0
    return-object v0

    .line 157
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public getLinkData()Lio/branch/referral/BranchLinkData;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lio/branch/referral/ServerResponse;->linkData_:Lio/branch/referral/BranchLinkData;

    return-object v0
.end method

.method public getObject()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lio/branch/referral/ServerResponse;->post_:Ljava/lang/Object;

    instance-of v0, v0, Lorg/json/JSONObject;

    if-eqz v0, :cond_0

    .line 108
    iget-object v0, p0, Lio/branch/referral/ServerResponse;->post_:Ljava/lang/Object;

    check-cast v0, Lorg/json/JSONObject;

    .line 111
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getStatusCode()I
    .locals 1

    .prologue
    .line 85
    iget v0, p0, Lio/branch/referral/ServerResponse;->statusCode_:I

    return v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lio/branch/referral/ServerResponse;->tag_:Ljava/lang/String;

    return-object v0
.end method

.method public setPost(Ljava/lang/Object;)V
    .locals 0
    .param p1, "post"    # Ljava/lang/Object;

    .prologue
    .line 96
    iput-object p1, p0, Lio/branch/referral/ServerResponse;->post_:Ljava/lang/Object;

    .line 97
    return-void
.end method
