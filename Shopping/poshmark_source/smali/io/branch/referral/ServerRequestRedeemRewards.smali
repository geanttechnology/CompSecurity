.class Lio/branch/referral/ServerRequestRedeemRewards;
.super Lio/branch/referral/ServerRequest;
.source "ServerRequestRedeemRewards.java"


# instance fields
.field actualNumOfCreditsToRedeem_:I

.field callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;ILio/branch/referral/Branch$BranchReferralStateChangedListener;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "bucketName"    # Ljava/lang/String;
    .param p3, "numOfCreditsToRedeem"    # I
    .param p4, "callback"    # Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    .prologue
    .line 34
    sget-object v3, Lio/branch/referral/Defines$RequestPath;->RedeemRewards:Lio/branch/referral/Defines$RequestPath;

    invoke-virtual {v3}, Lio/branch/referral/Defines$RequestPath;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, p1, v3}, Lio/branch/referral/ServerRequest;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 18
    const/4 v3, 0x0

    iput v3, p0, Lio/branch/referral/ServerRequestRedeemRewards;->actualNumOfCreditsToRedeem_:I

    .line 36
    iput-object p4, p0, Lio/branch/referral/ServerRequestRedeemRewards;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    .line 38
    iget-object v3, p0, Lio/branch/referral/ServerRequestRedeemRewards;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3, p2}, Lio/branch/referral/PrefHelper;->getCreditCount(Ljava/lang/String;)I

    move-result v0

    .line 39
    .local v0, "availableCredits":I
    iput p3, p0, Lio/branch/referral/ServerRequestRedeemRewards;->actualNumOfCreditsToRedeem_:I

    .line 40
    if-le p3, v0, :cond_0

    .line 41
    iput v0, p0, Lio/branch/referral/ServerRequestRedeemRewards;->actualNumOfCreditsToRedeem_:I

    .line 42
    const-string v3, "BranchSDK"

    const-string v4, "Branch Warning: You\'re trying to redeem more credits than are available. Have you updated loaded rewards"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 44
    :cond_0
    iget v3, p0, Lio/branch/referral/ServerRequestRedeemRewards;->actualNumOfCreditsToRedeem_:I

    if-lez v3, :cond_2

    .line 45
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 47
    .local v2, "post":Lorg/json/JSONObject;
    :try_start_0
    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->IdentityID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lio/branch/referral/ServerRequestRedeemRewards;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getIdentityID()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 48
    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->DeviceFingerprintID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lio/branch/referral/ServerRequestRedeemRewards;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getDeviceFingerPrintID()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 49
    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->SessionID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lio/branch/referral/ServerRequestRedeemRewards;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getSessionID()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 50
    iget-object v3, p0, Lio/branch/referral/ServerRequestRedeemRewards;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v3}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v3

    const-string v4, "bnc_no_value"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 51
    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->LinkClickID:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lio/branch/referral/ServerRequestRedeemRewards;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v4}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 53
    :cond_1
    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->Bucket:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 54
    sget-object v3, Lio/branch/referral/Defines$Jsonkey;->Amount:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v3}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v3

    iget v4, p0, Lio/branch/referral/ServerRequestRedeemRewards;->actualNumOfCreditsToRedeem_:I

    invoke-virtual {v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 55
    invoke-virtual {p0, v2}, Lio/branch/referral/ServerRequestRedeemRewards;->setPost(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    .end local v2    # "post":Lorg/json/JSONObject;
    :cond_2
    :goto_0
    return-void

    .line 56
    .restart local v2    # "post":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 57
    .local v1, "ex":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    .line 58
    const/4 v3, 0x1

    iput-boolean v3, p0, Lio/branch/referral/ServerRequestRedeemRewards;->constructError_:Z

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V
    .locals 1
    .param p1, "requestPath"    # Ljava/lang/String;
    .param p2, "post"    # Lorg/json/JSONObject;
    .param p3, "context"    # Landroid/content/Context;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2, p3}, Lio/branch/referral/ServerRequest;-><init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 18
    const/4 v0, 0x0

    iput v0, p0, Lio/branch/referral/ServerRequestRedeemRewards;->actualNumOfCreditsToRedeem_:I

    .line 66
    return-void
.end method


# virtual methods
.method public clearCallbacks()V
    .locals 1

    .prologue
    .line 125
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/ServerRequestRedeemRewards;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    .line 126
    return-void
.end method

.method public handleErrors(Landroid/content/Context;)Z
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 70
    invoke-super {p0, p1}, Lio/branch/referral/ServerRequest;->doesAppHasInternetPermission(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 71
    iget-object v2, p0, Lio/branch/referral/ServerRequestRedeemRewards;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    if-eqz v2, :cond_0

    .line 72
    iget-object v2, p0, Lio/branch/referral/ServerRequestRedeemRewards;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    new-instance v3, Lio/branch/referral/BranchError;

    const-string v4, "Trouble redeeming rewards."

    const/16 v5, -0x66

    invoke-direct {v3, v4, v5}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v2, v1, v3}, Lio/branch/referral/Branch$BranchReferralStateChangedListener;->onStateChanged(ZLio/branch/referral/BranchError;)V

    .line 82
    :cond_0
    :goto_0
    return v0

    .line 76
    :cond_1
    iget v2, p0, Lio/branch/referral/ServerRequestRedeemRewards;->actualNumOfCreditsToRedeem_:I

    if-gtz v2, :cond_2

    .line 77
    iget-object v2, p0, Lio/branch/referral/ServerRequestRedeemRewards;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    if-eqz v2, :cond_0

    .line 78
    iget-object v2, p0, Lio/branch/referral/ServerRequestRedeemRewards;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    new-instance v3, Lio/branch/referral/BranchError;

    const-string v4, "Trouble redeeming rewards."

    const/16 v5, -0x6b

    invoke-direct {v3, v4, v5}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v2, v1, v3}, Lio/branch/referral/Branch$BranchReferralStateChangedListener;->onStateChanged(ZLio/branch/referral/BranchError;)V

    goto :goto_0

    :cond_2
    move v0, v1

    .line 82
    goto :goto_0
.end method

.method public handleFailure(ILjava/lang/String;)V
    .locals 5
    .param p1, "statusCode"    # I
    .param p2, "causeMsg"    # Ljava/lang/String;

    .prologue
    .line 113
    iget-object v0, p0, Lio/branch/referral/ServerRequestRedeemRewards;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    if-eqz v0, :cond_0

    .line 114
    iget-object v0, p0, Lio/branch/referral/ServerRequestRedeemRewards;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    const/4 v1, 0x0

    new-instance v2, Lio/branch/referral/BranchError;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Trouble redeeming rewards. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, p1}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {v0, v1, v2}, Lio/branch/referral/Branch$BranchReferralStateChangedListener;->onStateChanged(ZLio/branch/referral/BranchError;)V

    .line 116
    :cond_0
    return-void
.end method

.method public isGetRequest()Z
    .locals 1

    .prologue
    .line 120
    const/4 v0, 0x0

    return v0
.end method

.method public onRequestSucceeded(Lio/branch/referral/ServerResponse;Lio/branch/referral/Branch;)V
    .locals 9
    .param p1, "resp"    # Lio/branch/referral/ServerResponse;
    .param p2, "branch"    # Lio/branch/referral/Branch;

    .prologue
    .line 87
    const/4 v3, 0x0

    .line 88
    .local v3, "isRedemptionSucceeded":Z
    invoke-virtual {p0}, Lio/branch/referral/ServerRequestRedeemRewards;->getPost()Lorg/json/JSONObject;

    move-result-object v4

    .line 89
    .local v4, "post":Lorg/json/JSONObject;
    if-eqz v4, :cond_0

    .line 90
    sget-object v7, Lio/branch/referral/Defines$Jsonkey;->Bucket:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v7}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    sget-object v7, Lio/branch/referral/Defines$Jsonkey;->Amount:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v7}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 92
    :try_start_0
    sget-object v7, Lio/branch/referral/Defines$Jsonkey;->Amount:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v7}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    .line 93
    .local v5, "redeemedCredits":I
    sget-object v7, Lio/branch/referral/Defines$Jsonkey;->Bucket:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v7}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 94
    .local v1, "creditBucket":Ljava/lang/String;
    if-lez v5, :cond_2

    const/4 v3, 0x1

    .line 96
    :goto_0
    iget-object v7, p0, Lio/branch/referral/ServerRequestRedeemRewards;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7, v1}, Lio/branch/referral/PrefHelper;->getCreditCount(Ljava/lang/String;)I

    move-result v7

    sub-int v6, v7, v5

    .line 97
    .local v6, "updatedCreditCount":I
    iget-object v7, p0, Lio/branch/referral/ServerRequestRedeemRewards;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v7, v1, v6}, Lio/branch/referral/PrefHelper;->setCreditCount(Ljava/lang/String;I)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 104
    .end local v1    # "creditBucket":Ljava/lang/String;
    .end local v5    # "redeemedCredits":I
    .end local v6    # "updatedCreditCount":I
    :cond_0
    :goto_1
    iget-object v7, p0, Lio/branch/referral/ServerRequestRedeemRewards;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    if-eqz v7, :cond_1

    .line 105
    if-eqz v3, :cond_3

    const/4 v0, 0x0

    .line 106
    .local v0, "branchError":Lio/branch/referral/BranchError;
    :goto_2
    iget-object v7, p0, Lio/branch/referral/ServerRequestRedeemRewards;->callback_:Lio/branch/referral/Branch$BranchReferralStateChangedListener;

    invoke-interface {v7, v3, v0}, Lio/branch/referral/Branch$BranchReferralStateChangedListener;->onStateChanged(ZLio/branch/referral/BranchError;)V

    .line 109
    .end local v0    # "branchError":Lio/branch/referral/BranchError;
    :cond_1
    return-void

    .line 94
    .restart local v1    # "creditBucket":Ljava/lang/String;
    .restart local v5    # "redeemedCredits":I
    :cond_2
    const/4 v3, 0x0

    goto :goto_0

    .line 98
    .end local v1    # "creditBucket":Ljava/lang/String;
    .end local v5    # "redeemedCredits":I
    :catch_0
    move-exception v2

    .line 99
    .local v2, "e":Lorg/json/JSONException;
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 105
    .end local v2    # "e":Lorg/json/JSONException;
    :cond_3
    new-instance v0, Lio/branch/referral/BranchError;

    const-string v7, "Trouble redeeming rewards."

    const/16 v8, -0x6b

    invoke-direct {v0, v7, v8}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    goto :goto_2
.end method
