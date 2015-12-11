.class abstract Lio/branch/referral/ServerRequest;
.super Ljava/lang/Object;
.source "ServerRequest.java"


# static fields
.field private static final POST_KEY:Ljava/lang/String; = "REQ_POST"

.field private static final POST_PATH_KEY:Ljava/lang/String; = "REQ_POST_PATH"


# instance fields
.field public constructError_:Z

.field private post_:Lorg/json/JSONObject;

.field protected prefHelper_:Lio/branch/referral/PrefHelper;

.field protected requestPath_:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "requestPath"    # Ljava/lang/String;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const/4 v0, 0x0

    iput-boolean v0, p0, Lio/branch/referral/ServerRequest;->constructError_:Z

    .line 32
    iput-object p2, p0, Lio/branch/referral/ServerRequest;->requestPath_:Ljava/lang/String;

    .line 33
    invoke-static {p1}, Lio/branch/referral/PrefHelper;->getInstance(Landroid/content/Context;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/ServerRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    .line 34
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 1
    .param p1, "requestPath"    # Ljava/lang/String;
    .param p2, "post"    # Lorg/json/JSONObject;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const/4 v0, 0x0

    iput-boolean v0, p0, Lio/branch/referral/ServerRequest;->constructError_:Z

    .line 45
    iput-object p1, p0, Lio/branch/referral/ServerRequest;->requestPath_:Ljava/lang/String;

    .line 46
    iput-object p2, p0, Lio/branch/referral/ServerRequest;->post_:Lorg/json/JSONObject;

    .line 47
    invoke-static {p3}, Lio/branch/referral/PrefHelper;->getInstance(Landroid/content/Context;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/ServerRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    .line 49
    return-void
.end method

.method public static fromJSON(Lorg/json/JSONObject;Landroid/content/Context;)Lio/branch/referral/ServerRequest;
    .locals 3
    .param p0, "json"    # Lorg/json/JSONObject;
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 172
    const/4 v0, 0x0

    .line 173
    .local v0, "post":Lorg/json/JSONObject;
    const-string v1, ""

    .line 175
    .local v1, "requestPath":Ljava/lang/String;
    :try_start_0
    const-string v2, "REQ_POST"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 176
    const-string v2, "REQ_POST"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 183
    :cond_0
    :goto_0
    :try_start_1
    const-string v2, "REQ_POST_PATH"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 184
    const-string v2, "REQ_POST_PATH"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v1

    .line 190
    :cond_1
    :goto_1
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_2

    .line 191
    invoke-static {v1, v0, p1}, Lio/branch/referral/ServerRequest;->getExtendedServerRequest(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)Lio/branch/referral/ServerRequest;

    move-result-object v2

    .line 193
    :goto_2
    return-object v2

    :cond_2
    const/4 v2, 0x0

    goto :goto_2

    .line 186
    :catch_0
    move-exception v2

    goto :goto_1

    .line 178
    :catch_1
    move-exception v2

    goto :goto_0
.end method

.method private static getExtendedServerRequest(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)Lio/branch/referral/ServerRequest;
    .locals 2
    .param p0, "requestPath"    # Ljava/lang/String;
    .param p1, "post"    # Lorg/json/JSONObject;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 206
    const/4 v0, 0x0

    .line 208
    .local v0, "extendedReq":Lio/branch/referral/ServerRequest;
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->CompletedAction:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 209
    new-instance v0, Lio/branch/referral/ServerRequestActionCompleted;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestActionCompleted;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 240
    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    :cond_0
    :goto_0
    return-object v0

    .line 210
    :cond_1
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->ApplyReferralCode:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 211
    new-instance v0, Lio/branch/referral/ServerRequestApplyReferralCode;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestApplyReferralCode;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto :goto_0

    .line 212
    :cond_2
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->GetURL:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 213
    new-instance v0, Lio/branch/referral/ServerRequestCreateUrl;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestCreateUrl;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto :goto_0

    .line 214
    :cond_3
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->GetReferralCode:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 215
    new-instance v0, Lio/branch/referral/ServerRequestGetReferralCode;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestGetReferralCode;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto :goto_0

    .line 216
    :cond_4
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->Referrals:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 217
    new-instance v0, Lio/branch/referral/ServerRequestGetReferralCount;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestGetReferralCount;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto :goto_0

    .line 218
    :cond_5
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->GetCreditHistory:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 219
    new-instance v0, Lio/branch/referral/ServerRequestGetRewardHistory;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestGetRewardHistory;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto :goto_0

    .line 220
    :cond_6
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->GetCredits:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 221
    new-instance v0, Lio/branch/referral/ServerRequestGetRewards;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestGetRewards;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto :goto_0

    .line 222
    :cond_7
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->IdentifyUser:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 223
    new-instance v0, Lio/branch/referral/ServerRequestIdentifyUserRequest;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestIdentifyUserRequest;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto :goto_0

    .line 224
    :cond_8
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->Logout:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 225
    new-instance v0, Lio/branch/referral/ServerRequestLogout;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestLogout;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto/16 :goto_0

    .line 226
    :cond_9
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->RedeemRewards:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 227
    new-instance v0, Lio/branch/referral/ServerRequestRedeemRewards;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestRedeemRewards;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto/16 :goto_0

    .line 228
    :cond_a
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->RegisterClose:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 229
    new-instance v0, Lio/branch/referral/ServerRequestRegisterClose;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestRegisterClose;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto/16 :goto_0

    .line 230
    :cond_b
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->RegisterInstall:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 231
    new-instance v0, Lio/branch/referral/ServerRequestRegisterInstall;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestRegisterInstall;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto/16 :goto_0

    .line 232
    :cond_c
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->RegisterOpen:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 233
    new-instance v0, Lio/branch/referral/ServerRequestRegisterOpen;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestRegisterOpen;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto/16 :goto_0

    .line 234
    :cond_d
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->SendAPPList:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 235
    new-instance v0, Lio/branch/referral/ServerRequestSendAppList;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestSendAppList;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto/16 :goto_0

    .line 236
    :cond_e
    sget-object v1, Lio/branch/referral/Defines$RequestPath;->ValidateReferralCode:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v1}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 237
    new-instance v0, Lio/branch/referral/ServerRequestValidateReferralCode;

    .end local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    invoke-direct {v0, p0, p1, p2}, Lio/branch/referral/ServerRequestValidateReferralCode;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .restart local v0    # "extendedReq":Lio/branch/referral/ServerRequest;
    goto/16 :goto_0
.end method


# virtual methods
.method public abstract clearCallbacks()V
.end method

.method protected doesAppHasInternetPermission(Landroid/content/Context;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 273
    const-string v1, "android.permission.INTERNET"

    invoke-virtual {p1, v1}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v0

    .line 274
    .local v0, "result":I
    if-nez v0, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getPost()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lio/branch/referral/ServerRequest;->post_:Lorg/json/JSONObject;

    return-object v0
.end method

.method public final getRequestPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lio/branch/referral/ServerRequest;->requestPath_:Ljava/lang/String;

    return-object v0
.end method

.method public getRequestUrl()Ljava/lang/String;
    .locals 2

    .prologue
    .line 118
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lio/branch/referral/ServerRequest;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getAPIBaseUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/ServerRequest;->requestPath_:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public abstract handleErrors(Landroid/content/Context;)Z
.end method

.method public abstract handleFailure(ILjava/lang/String;)V
.end method

.method public abstract isGetRequest()Z
.end method

.method public abstract onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
.end method

.method protected setPost(Lorg/json/JSONObject;)V
    .locals 0
    .param p1, "post"    # Lorg/json/JSONObject;

    .prologue
    .line 128
    iput-object p1, p0, Lio/branch/referral/ServerRequest;->post_:Lorg/json/JSONObject;

    .line 129
    return-void
.end method

.method public shouldRetryOnFail()Z
    .locals 1

    .prologue
    .line 98
    const/4 v0, 0x0

    return v0
.end method

.method public toJSON()Lorg/json/JSONObject;
    .locals 4

    .prologue
    .line 151
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 153
    .local v1, "json":Lorg/json/JSONObject;
    :try_start_0
    const-string v2, "REQ_POST"

    iget-object v3, p0, Lio/branch/referral/ServerRequest;->post_:Lorg/json/JSONObject;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 154
    const-string v2, "REQ_POST_PATH"

    iget-object v3, p0, Lio/branch/referral/ServerRequest;->requestPath_:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 158
    .end local v1    # "json":Lorg/json/JSONObject;
    :goto_0
    return-object v1

    .line 155
    .restart local v1    # "json":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 156
    .local v0, "e":Lorg/json/JSONException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public updateGAdsParams(Lio/branch/referral/SystemObserver;)V
    .locals 5
    .param p1, "sysObserver"    # Lio/branch/referral/SystemObserver;

    .prologue
    .line 250
    :try_start_0
    invoke-virtual {p1}, Lio/branch/referral/SystemObserver;->getAdvertisingId()Ljava/lang/String;

    move-result-object v0

    .line 251
    .local v0, "advertisingId":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 252
    invoke-virtual {p0}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->GoogleAdvertisingID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 254
    :cond_0
    invoke-virtual {p1}, Lio/branch/referral/SystemObserver;->getLATValue()I

    move-result v2

    .line 255
    .local v2, "latVal":I
    invoke-virtual {p0}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 256
    invoke-virtual {p0}, Lio/branch/referral/ServerRequest;->getPost()Lorg/json/JSONObject;

    move-result-object v3

    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->LATVal:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 262
    .end local v0    # "advertisingId":Ljava/lang/String;
    .end local v2    # "latVal":I
    :cond_1
    :goto_0
    return-void

    .line 259
    :catch_0
    move-exception v1

    .line 260
    .local v1, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
