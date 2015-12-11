.class public Lcom/amazon/mShop/smile/SmileHelper;
.super Ljava/lang/Object;
.source "SmileHelper.java"


# static fields
.field private static LAST_SYNC_TIME:J

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 23
    const-class v0, Lcom/amazon/mShop/smile/SmileHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/smile/SmileHelper;->TAG:Ljava/lang/String;

    .line 28
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/mShop/smile/SmileHelper;->LAST_SYNC_TIME:J

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isSmile()Z
    .locals 1

    .prologue
    .line 55
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSmileEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/model/auth/User;->isSmile()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static shouldSyncSmileInfo()Z
    .locals 1

    .prologue
    .line 77
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSmileEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static syncSmileInfoWithTimeInterval()V
    .locals 6

    .prologue
    .line 63
    invoke-static {}, Lcom/amazon/mShop/smile/SmileHelper;->shouldSyncSmileInfo()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 64
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    .line 65
    .local v0, "currentTime":J
    sget-wide v2, Lcom/amazon/mShop/smile/SmileHelper;->LAST_SYNC_TIME:J

    sub-long v2, v0, v2

    const-wide/32 v4, 0x927c0

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 66
    sput-wide v0, Lcom/amazon/mShop/smile/SmileHelper;->LAST_SYNC_TIME:J

    .line 67
    invoke-static {}, Lcom/amazon/mShop/control/smile/SmileController;->getInstance()Lcom/amazon/mShop/control/smile/SmileController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/control/smile/SmileController;->syncSmileInfo()V

    .line 68
    sget-object v2, Lcom/amazon/mShop/smile/SmileHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "AmazonSmile sync the smile info in each ten minutes"

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/DebugUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    :cond_0
    return-void
.end method

.method public static updateSmileInfo(ZLjava/lang/String;)Z
    .locals 1
    .param p0, "isSmile"    # Z
    .param p1, "charityName"    # Ljava/lang/String;

    .prologue
    .line 38
    invoke-static {p0, p1}, Lcom/amazon/mShop/model/auth/User;->userUpdated(ZLjava/lang/String;)V

    .line 39
    const/4 v0, 0x1

    return v0
.end method
