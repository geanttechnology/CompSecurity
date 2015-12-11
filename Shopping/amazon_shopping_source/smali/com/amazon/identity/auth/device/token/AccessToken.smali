.class public Lcom/amazon/identity/auth/device/token/AccessToken;
.super Lcom/amazon/identity/auth/device/token/AbstractToken;
.source "AccessToken.java"


# static fields
.field public static final ALWAYS_EXPIRE:J = -0x1L

.field private static final LOG_TAG:Ljava/lang/String;

.field public static final NEVER_EXPIRE:J = 0x0L

.field protected static final PRE_EXPIRATION_PERIOD:J = 0x12cL


# instance fields
.field private mExpirationTime:Landroid/text/format/Time;

.field private mExpiresIn:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/identity/auth/device/token/AccessToken;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/AccessToken;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "token"    # Ljava/lang/String;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 31
    const-wide/16 v0, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/amazon/identity/auth/device/token/AccessToken;-><init>(Ljava/lang/String;Ljava/lang/String;J)V

    .line 32
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;J)V
    .locals 3
    .param p1, "token"    # Ljava/lang/String;
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "expiresIn"    # J

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/token/AbstractToken;-><init>(Ljava/lang/String;)V

    .line 37
    sget-object v0, Lcom/amazon/identity/auth/device/token/AccessToken;->LOG_TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Creating Token "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/AccessToken;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " for id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 38
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 40
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/AccessToken;->mTokenData:Ljava/util/Map;

    const-string/jumbo v1, "directedid"

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    :cond_0
    invoke-virtual {p0, p3, p4}, Lcom/amazon/identity/auth/device/token/AccessToken;->setExpirationTime(J)V

    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/AccessToken;->mTokenData:Ljava/util/Map;

    const-string/jumbo v1, "expires_in"

    invoke-static {p3, p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    return-void
.end method


# virtual methods
.method protected getCurrentTime()Landroid/text/format/Time;
    .locals 1

    .prologue
    .line 117
    new-instance v0, Landroid/text/format/Time;

    invoke-direct {v0}, Landroid/text/format/Time;-><init>()V

    .line 118
    .local v0, "currentTime":Landroid/text/format/Time;
    invoke-virtual {v0}, Landroid/text/format/Time;->setToNow()V

    .line 119
    return-object v0
.end method

.method public getExpiresIn()J
    .locals 2

    .prologue
    .line 154
    iget-wide v0, p0, Lcom/amazon/identity/auth/device/token/AccessToken;->mExpiresIn:J

    return-wide v0
.end method

.method protected getPreExpirationPeriod()J
    .locals 2

    .prologue
    .line 127
    const-wide/16 v0, 0x12c

    return-wide v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 138
    const-string/jumbo v0, "com.amazon.identity.token.accessToken"

    return-object v0
.end method

.method public hasExpired()Z
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 84
    const-wide/16 v2, 0x0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/AccessToken;->getExpiresIn()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    .line 97
    :cond_0
    :goto_0
    return v0

    .line 88
    :cond_1
    const-wide/16 v2, -0x1

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/AccessToken;->getExpiresIn()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-nez v2, :cond_2

    move v0, v1

    .line 90
    goto :goto_0

    .line 96
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/AccessToken;->getCurrentTime()Landroid/text/format/Time;

    move-result-object v2

    .line 97
    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/AccessToken;->mExpirationTime:Landroid/text/format/Time;

    invoke-static {v2, v3}, Landroid/text/format/Time;->compare(Landroid/text/format/Time;Landroid/text/format/Time;)I

    move-result v2

    if-ltz v2, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method protected setExpirationTime(J)V
    .locals 7
    .param p1, "expiresIn"    # J

    .prologue
    const-wide/16 v5, -0x1

    const/4 v4, 0x0

    .line 52
    iput-wide p1, p0, Lcom/amazon/identity/auth/device/token/AccessToken;->mExpiresIn:J

    .line 53
    const-wide/16 v2, 0x0

    cmp-long v2, p1, v2

    if-nez v2, :cond_0

    .line 56
    iput-object v4, p0, Lcom/amazon/identity/auth/device/token/AccessToken;->mExpirationTime:Landroid/text/format/Time;

    .line 75
    :goto_0
    return-void

    .line 58
    :cond_0
    cmp-long v2, p1, v5

    if-gtz v2, :cond_1

    .line 61
    iput-wide v5, p0, Lcom/amazon/identity/auth/device/token/AccessToken;->mExpiresIn:J

    .line 62
    iput-object v4, p0, Lcom/amazon/identity/auth/device/token/AccessToken;->mExpirationTime:Landroid/text/format/Time;

    goto :goto_0

    .line 68
    :cond_1
    new-instance v2, Landroid/text/format/Time;

    invoke-direct {v2}, Landroid/text/format/Time;-><init>()V

    iput-object v2, p0, Lcom/amazon/identity/auth/device/token/AccessToken;->mExpirationTime:Landroid/text/format/Time;

    .line 71
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/AccessToken;->getLocalTimestamp()Landroid/text/format/Time;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/text/format/Time;->toMillis(Z)J

    move-result-wide v2

    invoke-static {p1, p2}, Lcom/amazon/identity/auth/device/token/AccessToken;->secsToMillis(J)J

    move-result-wide v4

    add-long/2addr v2, v4

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/AccessToken;->getPreExpirationPeriod()J

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/token/AccessToken;->secsToMillis(J)J

    move-result-wide v4

    sub-long v0, v2, v4

    .line 73
    .local v0, "expireAt":J
    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/AccessToken;->mExpirationTime:Landroid/text/format/Time;

    invoke-virtual {v2, v0, v1}, Landroid/text/format/Time;->set(J)V

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
