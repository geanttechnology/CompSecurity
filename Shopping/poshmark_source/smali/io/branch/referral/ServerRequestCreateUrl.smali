.class Lio/branch/referral/ServerRequestCreateUrl;
.super Lio/branch/referral/ServerRequest;
.source "ServerRequestCreateUrl.java"


# static fields
.field private static final DEF_BASE_URL:Ljava/lang/String; = "https://bnc.lt/a/"


# instance fields
.field private callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

.field private isAsync_:Z

.field private linkPost_:Lio/branch/referral/BranchLinkData;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;IILjava/util/Collection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/Branch$BranchLinkCreateListener;Z)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "alias"    # Ljava/lang/String;
    .param p3, "type"    # I
    .param p4, "duration"    # I
    .param p6, "channel"    # Ljava/lang/String;
    .param p7, "feature"    # Ljava/lang/String;
    .param p8, "stage"    # Ljava/lang/String;
    .param p9, "params"    # Ljava/lang/String;
    .param p10, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
    .param p11, "async"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "II",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lio/branch/referral/Branch$BranchLinkCreateListener;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 59
    .local p5, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->GetURL:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p1, v1}, Lio/branch/referral/ServerRequest;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 19
    const/4 v1, 0x1

    iput-boolean v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->isAsync_:Z

    .line 61
    iput-object p10, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    .line 62
    iput-boolean p11, p0, Lio/branch/referral/ServerRequestCreateUrl;->isAsync_:Z

    .line 64
    new-instance v1, Lio/branch/referral/BranchLinkData;

    invoke-direct {v1}, Lio/branch/referral/BranchLinkData;-><init>()V

    iput-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    .line 66
    :try_start_0
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestCreateUrl;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 67
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestCreateUrl;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 68
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestCreateUrl;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 69
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v1

    const-string v2, "bnc_no_value"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 70
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    sget-object v2, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v2}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/ServerRequestCreateUrl;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lio/branch/referral/BranchLinkData;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 73
    :cond_0
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v1, p3}, Lio/branch/referral/BranchLinkData;->putType(I)V

    .line 74
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v1, p4}, Lio/branch/referral/BranchLinkData;->putDuration(I)V

    .line 75
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v1, p5}, Lio/branch/referral/BranchLinkData;->putTags(Ljava/util/Collection;)V

    .line 76
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v1, p2}, Lio/branch/referral/BranchLinkData;->putAlias(Ljava/lang/String;)V

    .line 77
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v1, p6}, Lio/branch/referral/BranchLinkData;->putChannel(Ljava/lang/String;)V

    .line 78
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v1, p7}, Lio/branch/referral/BranchLinkData;->putFeature(Ljava/lang/String;)V

    .line 79
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v1, p8}, Lio/branch/referral/BranchLinkData;->putStage(Ljava/lang/String;)V

    .line 80
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v1, p9}, Lio/branch/referral/BranchLinkData;->putParams(Ljava/lang/String;)V

    .line 82
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {p0, v1}, Lio/branch/referral/ServerRequestCreateUrl;->setPost(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 89
    :goto_0
    return-void

    .line 84
    :catch_0
    move-exception v0

    .line 85
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 86
    const/4 v1, 0x1

    iput-boolean v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->constructError_:Z

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 1
    .param p1, "requestPath"    # Ljava/lang/String;
    .param p2, "post"    # Lorg/json/JSONObject;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 92
    invoke-direct {p0, p1, p2, p3}, Lio/branch/referral/ServerRequest;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 19
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/branch/referral/ServerRequestCreateUrl;->isAsync_:Z

    .line 93
    return-void
.end method

.method private generateLongUrlWithParams(Ljava/lang/String;)Ljava/lang/String;
    .locals 19
    .param p1, "baseUrl"    # Ljava/lang/String;

    .prologue
    .line 183
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p1

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "?"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 184
    .local v10, "longUrl":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v15}, Lio/branch/referral/BranchLinkData;->getTags()Ljava/util/Collection;

    move-result-object v14

    .line 185
    .local v14, "tags":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    if-eqz v14, :cond_1

    .line 186
    invoke-interface {v14}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_1

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 187
    .local v13, "tag":Ljava/lang/String;
    if-eqz v13, :cond_0

    invoke-virtual {v13}, Ljava/lang/String;->length()I

    move-result v15

    if-lez v15, :cond_0

    .line 188
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    sget-object v18, Lio/branch/referral/Defines$LinkParam;->Tags:Lio/branch/referral/Defines$LinkParam;

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "="

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "&"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    goto :goto_0

    .line 191
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v13    # "tag":Ljava/lang/String;
    :cond_1
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v15}, Lio/branch/referral/BranchLinkData;->getAlias()Ljava/lang/String;

    move-result-object v2

    .line 192
    .local v2, "alias":Ljava/lang/String;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v15

    if-lez v15, :cond_2

    .line 193
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    sget-object v18, Lio/branch/referral/Defines$LinkParam;->Alias:Lio/branch/referral/Defines$LinkParam;

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "="

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "&"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 196
    :cond_2
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v15}, Lio/branch/referral/BranchLinkData;->getChannel()Ljava/lang/String;

    move-result-object v4

    .line 197
    .local v4, "channel":Ljava/lang/String;
    if-eqz v4, :cond_3

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v15

    if-lez v15, :cond_3

    .line 198
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    sget-object v18, Lio/branch/referral/Defines$LinkParam;->Channel:Lio/branch/referral/Defines$LinkParam;

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "="

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "&"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 201
    :cond_3
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v15}, Lio/branch/referral/BranchLinkData;->getFeature()Ljava/lang/String;

    move-result-object v8

    .line 202
    .local v8, "feature":Ljava/lang/String;
    if-eqz v8, :cond_4

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v15

    if-lez v15, :cond_4

    .line 203
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    sget-object v18, Lio/branch/referral/Defines$LinkParam;->Feature:Lio/branch/referral/Defines$LinkParam;

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "="

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "&"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 206
    :cond_4
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v15}, Lio/branch/referral/BranchLinkData;->getStage()Ljava/lang/String;

    move-result-object v12

    .line 207
    .local v12, "stage":Ljava/lang/String;
    if-eqz v12, :cond_5

    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v15

    if-lez v15, :cond_5

    .line 208
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    sget-object v18, Lio/branch/referral/Defines$LinkParam;->Stage:Lio/branch/referral/Defines$LinkParam;

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "="

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "&"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 211
    :cond_5
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v15}, Lio/branch/referral/BranchLinkData;->getType()I

    move-result v15

    int-to-long v0, v15

    move-wide/from16 v16, v0

    .line 212
    .local v16, "type":J
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    sget-object v18, Lio/branch/referral/Defines$LinkParam;->Type:Lio/branch/referral/Defines$LinkParam;

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "="

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual/range {v15 .. v17}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "&"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 214
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v15}, Lio/branch/referral/BranchLinkData;->getDuration()I

    move-result v15

    int-to-long v6, v15

    .line 215
    .local v6, "duration":J
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    sget-object v18, Lio/branch/referral/Defines$LinkParam;->Duration:Lio/branch/referral/Defines$LinkParam;

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "="

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "&"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 217
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    invoke-virtual {v15}, Lio/branch/referral/BranchLinkData;->getParams()Ljava/lang/String;

    move-result-object v11

    .line 218
    .local v11, "params":Ljava/lang/String;
    if-eqz v11, :cond_6

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v15

    if-lez v15, :cond_6

    .line 219
    invoke-virtual {v11}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    .line 220
    .local v5, "data":[B
    const/4 v15, 0x2

    invoke-static {v5, v15}, Lio/branch/referral/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v3

    .line 221
    .local v3, "base64Data":Ljava/lang/String;
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v18, "source=android&data="

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 224
    .end local v3    # "base64Data":Ljava/lang/String;
    .end local v5    # "data":[B
    :cond_6
    return-object v10
.end method

.method private hasUser()Z
    .locals 2

    .prologue
    .line 159
    iget-object v0, p0, Lio/branch/referral/ServerRequestCreateUrl;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v0

    const-string v1, "bnc_no_value"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public clearCallbacks()V
    .locals 1

    .prologue
    .line 170
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    .line 171
    return-void
.end method

.method public getLinkPost()Lio/branch/referral/BranchLinkData;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lio/branch/referral/ServerRequestCreateUrl;->linkPost_:Lio/branch/referral/BranchLinkData;

    return-object v0
.end method

.method public getLongUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 144
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getUserURL()Ljava/lang/String;

    move-result-object v1

    const-string v2, "bnc_no_value"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 145
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getUserURL()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lio/branch/referral/ServerRequestCreateUrl;->generateLongUrlWithParams(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 149
    .local v0, "longUrl":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 147
    .end local v0    # "longUrl":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "https://bnc.lt/a/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lio/branch/referral/ServerRequestCreateUrl;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v2}, Lio/branch/referral/PrefHelper;->getBranchKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lio/branch/referral/ServerRequestCreateUrl;->generateLongUrlWithParams(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "longUrl":Ljava/lang/String;
    goto :goto_0
.end method

.method public handleDuplicateURLError()V
    .locals 5

    .prologue
    .line 153
    iget-object v0, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    if-eqz v0, :cond_0

    .line 154
    iget-object v0, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    const/4 v1, 0x0

    new-instance v2, Lio/branch/referral/BranchError;

    const-string v3, "Trouble creating a URL."

    const/16 v4, -0x69

    invoke-direct {v2, v3, v4}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v0, v1, v2}, Lio/branch/referral/Branch$BranchLinkCreateListener;->onLinkCreate(Ljava/lang/String;Lio/branch/referral/BranchError;)V

    .line 156
    :cond_0
    return-void
.end method

.method public handleErrors(Landroid/content/Context;)Z
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x1

    .line 101
    invoke-super {p0, p1}, Lio/branch/referral/ServerRequest;->doesAppHasInternetPermission(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 102
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    if-eqz v1, :cond_0

    .line 103
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    const/4 v2, 0x0

    new-instance v3, Lio/branch/referral/BranchError;

    const-string v4, "Trouble creating a URL."

    const/16 v5, -0x66

    invoke-direct {v3, v4, v5}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v1, v2, v3}, Lio/branch/referral/Branch$BranchLinkCreateListener;->onLinkCreate(Ljava/lang/String;Lio/branch/referral/BranchError;)V

    .line 107
    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-boolean v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->isAsync_:Z

    if-nez v1, :cond_2

    invoke-direct {p0}, Lio/branch/referral/ServerRequestCreateUrl;->hasUser()Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public handleFailure(ILjava/lang/String;)V
    .locals 5
    .param p1, "statusCode"    # I
    .param p2, "causeMsg"    # Ljava/lang/String;

    .prologue
    .line 136
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    if-eqz v1, :cond_0

    .line 137
    invoke-virtual {p0}, Lio/branch/referral/ServerRequestCreateUrl;->getLongUrl()Ljava/lang/String;

    move-result-object v0

    .line 138
    .local v0, "failedUrl":Ljava/lang/String;
    iget-object v1, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    new-instance v2, Lio/branch/referral/BranchError;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Trouble creating a URL. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, p1}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v1, v0, v2}, Lio/branch/referral/Branch$BranchLinkCreateListener;->onLinkCreate(Ljava/lang/String;Lio/branch/referral/BranchError;)V

    .line 140
    .end local v0    # "failedUrl":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public isAsync()Z
    .locals 1

    .prologue
    .line 174
    iget-boolean v0, p0, Lio/branch/referral/ServerRequestCreateUrl;->isAsync_:Z

    return v0
.end method

.method public isGetRequest()Z
    .locals 1

    .prologue
    .line 164
    const/4 v0, 0x0

    return v0
.end method

.method public onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    .locals 4
    .param p1, "resp"    # Lio/branch/referral/ServerResponse;
    .param p2, "branch"    # Lio/branch/referral/Branch;

    .prologue
    .line 113
    :try_start_0
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "url"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 114
    .local v1, "url":Ljava/lang/String;
    iget-object v2, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    if-eqz v2, :cond_0

    .line 115
    iget-object v2, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    const/4 v3, 0x0

    invoke-interface {v2, v1, v3}, Lio/branch/referral/Branch$BranchLinkCreateListener;->onLinkCreate(Ljava/lang/String;Lio/branch/referral/BranchError;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 120
    .end local v1    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 117
    :catch_0
    move-exception v0

    .line 118
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public onUrlAvailable(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 129
    iget-object v0, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    if-eqz v0, :cond_0

    .line 130
    iget-object v0, p0, Lio/branch/referral/ServerRequestCreateUrl;->callback_:Lio/branch/referral/Branch$BranchLinkCreateListener;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Lio/branch/referral/Branch$BranchLinkCreateListener;->onLinkCreate(Ljava/lang/String;Lio/branch/referral/BranchError;)V

    .line 132
    :cond_0
    return-void
.end method
