.class Lio/branch/referral/ServerRequestRegisterView;
.super Lio/branch/referral/ServerRequest;
.source "ServerRequestRegisterView.java"


# instance fields
.field callback_:Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lio/branch/indexing/BranchUniversalObject;Lio/branch/referral/SystemObserver;Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "branchUniversalObject"    # Lio/branch/indexing/BranchUniversalObject;
    .param p3, "sysObserver"    # Lio/branch/referral/SystemObserver;
    .param p4, "callback"    # Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;

    .prologue
    .line 29
    sget-object v2, Lio/branch/referral/Defines$RequestPath;->RegisterView:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v2}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1, v2}, Lio/branch/referral/ServerRequest;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 30
    iput-object p4, p0, Lio/branch/referral/ServerRequestRegisterView;->callback_:Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;

    .line 33
    :try_start_0
    invoke-direct {p0, p2, p3}, Lio/branch/referral/ServerRequestRegisterView;->createContentViewJson(Lio/branch/indexing/BranchUniversalObject;Lio/branch/referral/SystemObserver;)Lorg/json/JSONObject;

    move-result-object v1

    .line 34
    .local v1, "registerViewPost":Lorg/json/JSONObject;
    invoke-virtual {p0, v1}, Lio/branch/referral/ServerRequestRegisterView;->setPost(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 39
    .end local v1    # "registerViewPost":Lorg/json/JSONObject;
    :goto_0
    return-void

    .line 35
    :catch_0
    move-exception v0

    .line 36
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 37
    const/4 v2, 0x1

    iput-boolean v2, p0, Lio/branch/referral/ServerRequestRegisterView;->constructError_:Z

    goto :goto_0
.end method

.method private createContentViewJson(Lio/branch/indexing/BranchUniversalObject;Lio/branch/referral/SystemObserver;)Lorg/json/JSONObject;
    .locals 26
    .param p1, "universalObject"    # Lio/branch/indexing/BranchUniversalObject;
    .param p2, "sysObserver"    # Lio/branch/referral/SystemObserver;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 86
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 89
    .local v6, "contentObject":Lorg/json/JSONObject;
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "Android "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    sget v23, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 90
    .local v17, "os_Info":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lio/branch/referral/ServerRequestRegisterView;->prefHelper_:Lio/branch/referral/PrefHelper;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v19

    .line 92
    .local v19, "sessionID":Ljava/lang/String;
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->OS:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v17

    invoke-virtual {v6, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 93
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v19

    invoke-virtual {v6, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 94
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lio/branch/referral/ServerRequestRegisterView;->prefHelper_:Lio/branch/referral/PrefHelper;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    invoke-virtual {v6, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 96
    move-object/from16 v0, p0

    iget-object v0, v0, Lio/branch/referral/ServerRequestRegisterView;->prefHelper_:Lio/branch/referral/PrefHelper;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/PrefHelper;->getExternDebug()Z

    move-result v22

    move-object/from16 v0, p2

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lio/branch/referral/SystemObserver;->getUniqueID(Z)Ljava/lang/String;

    move-result-object v21

    .line 97
    .local v21, "uniqueId":Ljava/lang/String;
    const-string v22, "bnc_no_value"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v22

    if-nez v22, :cond_0

    invoke-virtual/range {p2 .. p2}, Lio/branch/referral/SystemObserver;->hasRealHardwareId()Z

    move-result v22

    if-eqz v22, :cond_0

    .line 98
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->HardwareID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    invoke-virtual {v6, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 101
    :cond_0
    invoke-virtual/range {p2 .. p2}, Lio/branch/referral/SystemObserver;->getAppVersion()Ljava/lang/String;

    move-result-object v4

    .line 102
    .local v4, "appVersion":Ljava/lang/String;
    const-string v22, "bnc_no_value"

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v22

    if-nez v22, :cond_1

    .line 103
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->AppVersion:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v6, v0, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 106
    :cond_1
    new-instance v18, Lorg/json/JSONObject;

    invoke-direct/range {v18 .. v18}, Lorg/json/JSONObject;-><init>()V

    .line 108
    .local v18, "paramsObj":Lorg/json/JSONObject;
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->ContentKeyWords:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->getKeywordsJsonArray()Lorg/json/JSONArray;

    move-result-object v23

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 109
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->PublicallyIndexable:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->isPublicallyIndexable()Z

    move-result v23

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 111
    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->getCanonicalIdentifier()Ljava/lang/String;

    move-result-object v5

    .line 112
    .local v5, "canonicalId":Ljava/lang/String;
    if-eqz v5, :cond_2

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/String;->length()I

    move-result v22

    if-lez v22, :cond_2

    .line 113
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->CanonicalIdentifier:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    invoke-virtual {v0, v1, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 115
    :cond_2
    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->getTitle()Ljava/lang/String;

    move-result-object v20

    .line 116
    .local v20, "title":Ljava/lang/String;
    if-eqz v20, :cond_3

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/String;->length()I

    move-result v22

    if-lez v22, :cond_3

    .line 117
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->ContentTitle:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->getTitle()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 120
    :cond_3
    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->getDescription()Ljava/lang/String;

    move-result-object v8

    .line 121
    .local v8, "desc":Ljava/lang/String;
    if-eqz v8, :cond_4

    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/String;->length()I

    move-result v22

    if-lez v22, :cond_4

    .line 122
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->ContentDesc:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    invoke-virtual {v0, v1, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 124
    :cond_4
    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->getImageUrl()Ljava/lang/String;

    move-result-object v13

    .line 125
    .local v13, "imageUrl":Ljava/lang/String;
    if-eqz v13, :cond_5

    invoke-virtual {v13}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/String;->length()I

    move-result v22

    if-lez v22, :cond_5

    .line 126
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->ContentImgUrl:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    invoke-virtual {v0, v1, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 128
    :cond_5
    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->getType()Ljava/lang/String;

    move-result-object v7

    .line 129
    .local v7, "contentType":Ljava/lang/String;
    if-eqz v7, :cond_6

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/String;->length()I

    move-result v22

    if-lez v22, :cond_6

    .line 130
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->ContentType:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    invoke-virtual {v0, v1, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 132
    :cond_6
    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->getExpirationTime()J

    move-result-wide v10

    .line 133
    .local v10, "expiryTime":J
    const-wide/16 v22, 0x0

    cmp-long v22, v10, v22

    if-lez v22, :cond_7

    .line 134
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->ContentExpiryTime:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->getExpirationTime()J

    move-result-wide v24

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    move-wide/from16 v2, v24

    invoke-virtual {v0, v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 137
    :cond_7
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->Params:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v18

    invoke-virtual {v6, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 139
    invoke-virtual/range {p1 .. p1}, Lio/branch/indexing/BranchUniversalObject;->getMetadata()Ljava/util/HashMap;

    move-result-object v15

    .line 140
    .local v15, "metaData":Ljava/util/HashMap;
    invoke-virtual {v15}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v9

    .line 141
    .local v9, "extraKeys":Ljava/util/Set;
    new-instance v16, Lorg/json/JSONObject;

    invoke-direct/range {v16 .. v16}, Lorg/json/JSONObject;-><init>()V

    .line 142
    .local v16, "metaDataObject":Lorg/json/JSONObject;
    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .local v12, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v22

    if-eqz v22, :cond_8

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    .local v14, "key":Ljava/lang/Object;
    move-object/from16 v22, v14

    .line 143
    check-cast v22, Ljava/lang/String;

    invoke-virtual {v15, v14}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v23

    move-object/from16 v0, v16

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0

    .line 145
    .end local v14    # "key":Ljava/lang/Object;
    :cond_8
    sget-object v22, Lio/branch/referral/Defines$Jsonkey;->Metadata:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual/range {v22 .. v22}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v16

    invoke-virtual {v6, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 147
    return-object v6
.end method


# virtual methods
.method public clearCallbacks()V
    .locals 1

    .prologue
    .line 73
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/ServerRequestRegisterView;->callback_:Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;

    .line 74
    return-void
.end method

.method public handleErrors(Landroid/content/Context;)Z
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 57
    invoke-super {p0, p1}, Lio/branch/referral/ServerRequest;->doesAppHasInternetPermission(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 58
    iget-object v1, p0, Lio/branch/referral/ServerRequestRegisterView;->callback_:Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;

    if-eqz v1, :cond_0

    .line 59
    iget-object v1, p0, Lio/branch/referral/ServerRequestRegisterView;->callback_:Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;

    new-instance v2, Lio/branch/referral/BranchError;

    const-string v3, "Unable to register content view"

    const/16 v4, -0x66

    invoke-direct {v2, v3, v4}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v1, v0, v2}, Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;->onRegisterViewFinished(ZLio/branch/referral/BranchError;)V

    .line 61
    :cond_0
    const/4 v0, 0x1

    .line 63
    :cond_1
    return v0
.end method

.method public handleFailure(ILjava/lang/String;)V
    .locals 5
    .param p1, "statusCode"    # I
    .param p2, "causeMsg"    # Ljava/lang/String;

    .prologue
    .line 50
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterView;->callback_:Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterView;->callback_:Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;

    const/4 v1, 0x0

    new-instance v2, Lio/branch/referral/BranchError;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to register content view. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, p1}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v0, v1, v2}, Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;->onRegisterViewFinished(ZLio/branch/referral/BranchError;)V

    .line 53
    :cond_0
    return-void
.end method

.method public isGetRequest()Z
    .locals 1

    .prologue
    .line 68
    const/4 v0, 0x0

    return v0
.end method

.method public onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    .locals 3
    .param p1, "resp"    # Lio/branch/referral/ServerResponse;
    .param p2, "branch"    # Lio/branch/referral/Branch;

    .prologue
    .line 43
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterView;->callback_:Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lio/branch/referral/ServerRequestRegisterView;->callback_:Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;->onRegisterViewFinished(ZLio/branch/referral/BranchError;)V

    .line 46
    :cond_0
    return-void
.end method
