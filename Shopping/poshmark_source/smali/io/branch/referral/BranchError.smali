.class public Lio/branch/referral/BranchError;
.super Ljava/lang/Object;
.source "BranchError.java"


# static fields
.field public static final ERR_API_LVL_14_NEEDED:I = -0x6c

.field public static final ERR_BRANCH_DUPLICATE_REFERRAL_CODE:I = -0x6a

.field public static final ERR_BRANCH_DUPLICATE_URL:I = -0x69

.field public static final ERR_BRANCH_INIT_FAILED:I = -0x68

.field public static final ERR_BRANCH_NOT_INSTANTIATED:I = -0x6d

.field public static final ERR_BRANCH_NO_SHARE_OPTION:I = -0x6e

.field public static final ERR_BRANCH_REDEEM_REWARD:I = -0x6b

.field public static final ERR_INVALID_REFERRAL_CODE:I = -0x67

.field public static final ERR_NO_INTERNET_PERMISSION:I = -0x66

.field public static final ERR_NO_SESSION:I = -0x65


# instance fields
.field errorMessage_:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;I)V
    .locals 2
    .param p1, "failMsg"    # Ljava/lang/String;
    .param p2, "statusCode"    # I

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    const-string v0, ""

    iput-object v0, p0, Lio/branch/referral/BranchError;->errorMessage_:Ljava/lang/String;

    .line 53
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-direct {p0, p2}, Lio/branch/referral/BranchError;->getLocalisedErrorMessage(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/BranchError;->errorMessage_:Ljava/lang/String;

    .line 54
    return-void
.end method

.method private getLocalisedErrorMessage(I)Ljava/lang/String;
    .locals 2
    .param p1, "statusCode"    # I

    .prologue
    .line 65
    const/16 v1, -0x3f1

    if-ne p1, v1, :cond_0

    .line 66
    const-string v0, " Branch API Error: poor network connectivity. Please try again later."

    .line 99
    .local v0, "errMsg":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 67
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_0
    const/16 v1, -0x4d2

    if-ne p1, v1, :cond_1

    .line 68
    const-string v0, " Branch API Error: Please enter your branch_key in your project\'s manifest file first."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 69
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_1
    const/16 v1, -0x68

    if-ne p1, v1, :cond_2

    .line 70
    const-string v0, " Did you forget to call init? Make sure you init the session before making Branch calls."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 71
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_2
    const/16 v1, -0x65

    if-ne p1, v1, :cond_3

    .line 72
    const-string v0, " Unable to initialize Branch. Check network connectivity or that your branch key is valid."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 73
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_3
    const/16 v1, -0x66

    if-ne p1, v1, :cond_4

    .line 74
    const-string v0, " Please add \'android.permission.INTERNET\' in your applications manifest file."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 75
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_4
    const/16 v1, -0x69

    if-ne p1, v1, :cond_5

    .line 76
    const-string v0, " Unable to create a URL with that alias. If you want to reuse the alias, make sure to submit the same properties for all arguments and that the user is the same owner."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 77
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_5
    const/16 v1, -0x6a

    if-ne p1, v1, :cond_6

    .line 78
    const-string v0, " That Branch referral code is already in use."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 79
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_6
    const/16 v1, -0x6b

    if-ne p1, v1, :cond_7

    .line 80
    const-string v0, " Unable to redeem rewards. Please make sure you have credits available to redeem."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 81
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_7
    const/16 v1, -0x6c

    if-ne p1, v1, :cond_8

    .line 82
    const-string v0, "BranchApp class can be used only with API level 14 or above. Please make sure your minimum API level supported is 14. If you wish to use API level below 14 consider calling getInstance(Context) instead."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 85
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_8
    const/16 v1, -0x6d

    if-ne p1, v1, :cond_9

    .line 86
    const-string v0, "Branch instance is not created. Make  sure your Application class is an instance of BranchLikedApp."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 88
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_9
    const/16 v1, -0x6e

    if-ne p1, v1, :cond_a

    .line 89
    const-string v0, " Unable create share options. Couldn\'t find applications on device to share the link."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 90
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_a
    const/16 v1, 0x1f4

    if-lt p1, v1, :cond_b

    .line 91
    const-string v0, " Unable to reach the Branch servers, please try again shortly."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 92
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_b
    const/16 v1, 0x199

    if-ne p1, v1, :cond_c

    .line 93
    const-string v0, " A resource with this identifier already exists."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 94
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_c
    const/16 v1, 0x190

    if-le p1, v1, :cond_d

    .line 95
    const-string v0, " The request was invalid."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0

    .line 97
    .end local v0    # "errMsg":Ljava/lang/String;
    :cond_d
    const-string v0, " Check network connectivity and that you properly initialized."

    .restart local v0    # "errMsg":Ljava/lang/String;
    goto :goto_0
.end method


# virtual methods
.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lio/branch/referral/BranchError;->errorMessage_:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    invoke-virtual {p0}, Lio/branch/referral/BranchError;->getMessage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
