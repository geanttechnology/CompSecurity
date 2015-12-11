.class public Lcom/xfinity/playerlib/model/user/PlayNowUser;
.super Lcom/comcast/cim/model/user/XipUser;
.source "PlayNowUser.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private isGrandfatheredForCellularUse:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/comcast/cim/model/user/XipUser;-><init>()V

    .line 17
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayNowUser;->isGrandfatheredForCellularUse:Ljava/lang/Boolean;

    .line 20
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)V
    .locals 1
    .param p1, "userCredentials"    # Lcom/comcast/cim/android/authentication/UserCredentials;
    .param p2, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/model/user/XipUser;-><init>(Lcom/comcast/cim/android/authentication/UserCredentials;Lcom/comcast/cim/model/user/AuthKeys;)V

    .line 17
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayNowUser;->isGrandfatheredForCellularUse:Ljava/lang/Boolean;

    .line 24
    return-void
.end method

.method private doFlagsMatchMask(Ljava/lang/String;J)Z
    .locals 8
    .param p1, "flags"    # Ljava/lang/String;
    .param p2, "mask"    # J

    .prologue
    .line 43
    const/4 v2, 0x0

    .line 46
    .local v2, "matches":Z
    if-nez p1, :cond_0

    .line 47
    :try_start_0
    const-string p1, "0"

    .line 51
    :cond_0
    const-string v3, "-"

    const-string v4, ""

    invoke-virtual {p1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p1

    .line 53
    new-instance v0, Ljava/math/BigInteger;

    const/16 v3, 0x10

    invoke-direct {v0, p1, v3}, Ljava/math/BigInteger;-><init>(Ljava/lang/String;I)V

    .line 55
    .local v0, "flagsValue":Ljava/math/BigInteger;
    invoke-static {p2, p3}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/math/BigInteger;->and(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v3}, Ljava/math/BigInteger;->longValue()J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-lez v3, :cond_1

    const/4 v2, 0x1

    .line 60
    .end local v0    # "flagsValue":Ljava/math/BigInteger;
    :goto_0
    return v2

    .line 55
    .restart local v0    # "flagsValue":Ljava/math/BigInteger;
    :cond_1
    const/4 v2, 0x0

    goto :goto_0

    .line 56
    .end local v0    # "flagsValue":Ljava/math/BigInteger;
    :catch_0
    move-exception v1

    .line 57
    .local v1, "ignored":Ljava/lang/Exception;
    sget-object v3, Lcom/xfinity/playerlib/model/user/PlayNowUser;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Problem with Grandfathering"

    invoke-interface {v3, v4, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public isGrandfatheredForCellularUse()Z
    .locals 4

    .prologue
    .line 28
    iget-object v2, p0, Lcom/xfinity/playerlib/model/user/PlayNowUser;->isGrandfatheredForCellularUse:Ljava/lang/Boolean;

    if-nez v2, :cond_0

    .line 30
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/user/PlayNowUser;->isGrandfatheredForCellularUse:Ljava/lang/Boolean;

    .line 32
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v0

    .line 34
    .local v0, "authKeys":Lcom/comcast/cim/model/user/AuthKeys;
    invoke-virtual {v0}, Lcom/comcast/cim/model/user/AuthKeys;->getFlags()Ljava/lang/String;

    move-result-object v1

    .line 36
    .local v1, "flags":Ljava/lang/String;
    const-wide v2, 0x800000040000080L

    invoke-direct {p0, v1, v2, v3}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->doFlagsMatchMask(Ljava/lang/String;J)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/user/PlayNowUser;->isGrandfatheredForCellularUse:Ljava/lang/Boolean;

    .line 39
    .end local v0    # "authKeys":Lcom/comcast/cim/model/user/AuthKeys;
    .end local v1    # "flags":Ljava/lang/String;
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/model/user/PlayNowUser;->isGrandfatheredForCellularUse:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    return v2
.end method
