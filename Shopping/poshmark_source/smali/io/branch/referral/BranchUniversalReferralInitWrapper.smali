.class Lio/branch/referral/BranchUniversalReferralInitWrapper;
.super Ljava/lang/Object;
.source "BranchUniversalReferralInitWrapper.java"

# interfaces
.implements Lio/branch/referral/Branch$BranchReferralInitListener;


# instance fields
.field private final universalReferralInitListener_:Lio/branch/referral/Branch$BranchUniversalReferralInitListener;


# direct methods
.method public constructor <init>(Lio/branch/referral/Branch$BranchUniversalReferralInitListener;)V
    .locals 0
    .param p1, "universalReferralInitListener"    # Lio/branch/referral/Branch$BranchUniversalReferralInitListener;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lio/branch/referral/BranchUniversalReferralInitWrapper;->universalReferralInitListener_:Lio/branch/referral/Branch$BranchUniversalReferralInitListener;

    .line 16
    return-void
.end method


# virtual methods
.method public onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V
    .locals 4
    .param p1, "referringParams"    # Lorg/json/JSONObject;
    .param p2, "error"    # Lio/branch/referral/BranchError;

    .prologue
    const/4 v3, 0x0

    .line 20
    iget-object v2, p0, Lio/branch/referral/BranchUniversalReferralInitWrapper;->universalReferralInitListener_:Lio/branch/referral/Branch$BranchUniversalReferralInitListener;

    if-eqz v2, :cond_0

    .line 21
    if-eqz p2, :cond_1

    .line 22
    iget-object v2, p0, Lio/branch/referral/BranchUniversalReferralInitWrapper;->universalReferralInitListener_:Lio/branch/referral/Branch$BranchUniversalReferralInitListener;

    invoke-interface {v2, v3, v3, p2}, Lio/branch/referral/Branch$BranchUniversalReferralInitListener;->onInitFinished(Lio/branch/indexing/BranchUniversalObject;Lio/branch/referral/util/LinkProperties;Lio/branch/referral/BranchError;)V

    .line 29
    :cond_0
    :goto_0
    return-void

    .line 24
    :cond_1
    invoke-static {}, Lio/branch/indexing/BranchUniversalObject;->getReferredBranchUniversalObject()Lio/branch/indexing/BranchUniversalObject;

    move-result-object v0

    .line 25
    .local v0, "branchUniversalObject":Lio/branch/indexing/BranchUniversalObject;
    invoke-static {}, Lio/branch/referral/util/LinkProperties;->getReferredLinkProperties()Lio/branch/referral/util/LinkProperties;

    move-result-object v1

    .line 26
    .local v1, "linkProperties":Lio/branch/referral/util/LinkProperties;
    iget-object v2, p0, Lio/branch/referral/BranchUniversalReferralInitWrapper;->universalReferralInitListener_:Lio/branch/referral/Branch$BranchUniversalReferralInitListener;

    invoke-interface {v2, v0, v1, p2}, Lio/branch/referral/Branch$BranchUniversalReferralInitListener;->onInitFinished(Lio/branch/indexing/BranchUniversalObject;Lio/branch/referral/util/LinkProperties;Lio/branch/referral/BranchError;)V

    goto :goto_0
.end method
