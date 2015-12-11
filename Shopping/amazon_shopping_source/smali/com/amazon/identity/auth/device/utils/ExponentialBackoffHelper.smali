.class Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;
.super Ljava/lang/Object;
.source "ExponentialBackoffHelper.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mCurrentMultiple:I

.field private mFirstRetryIntervalMs:I

.field private mJitterRange:I

.field private mMaxRetryIntervalMs:I

.field private mRetryAttempts:I

.field private final mRng:Ljava/util/Random;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const-class v0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(II)V
    .locals 2
    .param p1, "firstRetryIntervalMs"    # I
    .param p2, "maxRetryIntervalMs"    # I

    .prologue
    .line 23
    const/16 v0, 0x1e

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;-><init>(IIII)V

    .line 24
    return-void
.end method

.method public constructor <init>(III)V
    .locals 1
    .param p1, "firstRetryIntervalMs"    # I
    .param p2, "maxRetryIntervalMs"    # I
    .param p3, "jitterRangePercent"    # I

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;-><init>(IIII)V

    .line 31
    return-void
.end method

.method public constructor <init>(IIII)V
    .locals 7
    .param p1, "firstRetryIntervalMs"    # I
    .param p2, "maxRetryIntervalMs"    # I
    .param p3, "jitterRangePercent"    # I
    .param p4, "retryAttempts"    # I

    .prologue
    const/16 v6, 0xa

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mRng:Ljava/util/Random;

    .line 42
    iput p1, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mFirstRetryIntervalMs:I

    .line 43
    iput p2, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mMaxRetryIntervalMs:I

    .line 44
    iput p4, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mRetryAttempts:I

    .line 45
    invoke-direct {p0, p4}, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->calculateMultiple(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mCurrentMultiple:I

    .line 46
    iput p3, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mJitterRange:I

    .line 48
    iget v0, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mFirstRetryIntervalMs:I

    if-gtz v0, :cond_0

    .line 50
    iput v6, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mFirstRetryIntervalMs:I

    .line 52
    sget-object v0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "ExponentialBackoffHelper: was constructed with a first retry interval value less than or equal to zero. It has been set to a default value (%d ms)"

    new-array v2, v5, [Ljava/lang/Object;

    iget v3, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mFirstRetryIntervalMs:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    :cond_0
    iget v0, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mJitterRange:I

    if-gtz v0, :cond_1

    .line 59
    iput v6, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mJitterRange:I

    .line 61
    sget-object v0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "ExponentialBackoffHelper: was constructed with a jitter percent range less than or equal to zero. It has been set to a default value (%d percent)"

    new-array v2, v5, [Ljava/lang/Object;

    iget v3, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mJitterRange:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    :cond_1
    return-void
.end method

.method private calculateMultiple(I)I
    .locals 5
    .param p1, "numRetries"    # I

    .prologue
    .line 69
    const/4 v1, 0x1

    .line 71
    .local v1, "multiple":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p1, :cond_0

    .line 73
    iget v3, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mFirstRetryIntervalMs:I

    mul-int v2, v3, v1

    .line 74
    .local v2, "nextTime":I
    mul-int/lit8 v3, v2, 0x2

    iget v4, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mMaxRetryIntervalMs:I

    if-gt v3, v4, :cond_0

    .line 76
    mul-int/lit8 v1, v1, 0x2

    .line 71
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 82
    .end local v2    # "nextTime":I
    :cond_0
    return v1
.end method


# virtual methods
.method public nextRetryInterval()I
    .locals 7

    .prologue
    .line 87
    iget v1, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mRetryAttempts:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mRetryAttempts:I

    .line 89
    iget v1, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mFirstRetryIntervalMs:I

    iget v2, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mCurrentMultiple:I

    mul-int v0, v1, v2

    .line 90
    .local v0, "nextTime":I
    mul-int/lit8 v1, v0, 0x2

    iget v2, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mMaxRetryIntervalMs:I

    if-gt v1, v2, :cond_0

    .line 92
    iget v1, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mCurrentMultiple:I

    mul-int/lit8 v1, v1, 0x2

    iput v1, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mCurrentMultiple:I

    .line 95
    :cond_0
    const-wide/32 v1, 0x7fffffff

    const-wide/16 v3, 0x2

    iget v5, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mJitterRange:I

    int-to-long v5, v5

    mul-long/2addr v3, v5

    int-to-long v5, v0

    mul-long/2addr v3, v5

    const-wide/16 v5, 0x64

    div-long/2addr v3, v5

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v1

    long-to-int v1, v1

    if-eqz v1, :cond_1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mRng:Ljava/util/Random;

    invoke-virtual {v2, v1}, Ljava/util/Random;->nextInt(I)I

    move-result v2

    div-int/lit8 v1, v1, 0x2

    sub-int v1, v0, v1

    add-int v0, v1, v2

    .end local v0    # "nextTime":I
    :cond_1
    return v0
.end method

.method public numberOfRetryAttempts()I
    .locals 1

    .prologue
    .line 100
    iget v0, p0, Lcom/amazon/identity/auth/device/utils/ExponentialBackoffHelper;->mRetryAttempts:I

    return v0
.end method
