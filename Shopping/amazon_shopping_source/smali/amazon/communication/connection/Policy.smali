.class public final Lamazon/communication/connection/Policy;
.super Ljava/lang/Object;
.source "Policy.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lamazon/communication/connection/Policy$1;,
        Lamazon/communication/connection/Policy$Builder;
    }
.end annotation


# static fields
.field public static final FAST_BIDI:Lamazon/communication/connection/Policy;

.field public static final ONE_SHOT:Lamazon/communication/connection/Policy;

.field public static final SHARED_BIDI:Lamazon/communication/connection/Policy;


# instance fields
.field private final mCompressionOption:Lamazon/communication/connection/CompressionOption;

.field private final mIsAnonymousCredentialsAllowed:Z

.field private final mIsClearText:Z

.field private final mIsDedicated:Z

.field private final mIsLowLatencyNecessary:Z

.field private final mIsRequestResponseOnly:Z

.field private final mIsWiFiNecessary:Z

.field private final mKeepAlive:Lamazon/communication/connection/KeepAlive;

.field private final mPriority:Lamazon/communication/connection/Priority;

.field private final mPurpose:Lamazon/communication/connection/Purpose;

.field private final mReconnectOnFailure:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 23
    new-instance v0, Lamazon/communication/connection/Policy$Builder;

    invoke-direct {v0}, Lamazon/communication/connection/Policy$Builder;-><init>()V

    invoke-virtual {v0, v1}, Lamazon/communication/connection/Policy$Builder;->setIsRequestResponseOnly(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0, v1}, Lamazon/communication/connection/Policy$Builder;->setIsClearText(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/connection/Policy$Builder;->build()Lamazon/communication/connection/Policy;

    move-result-object v0

    sput-object v0, Lamazon/communication/connection/Policy;->ONE_SHOT:Lamazon/communication/connection/Policy;

    .line 30
    new-instance v0, Lamazon/communication/connection/Policy$Builder;

    invoke-direct {v0}, Lamazon/communication/connection/Policy$Builder;-><init>()V

    invoke-virtual {v0, v1}, Lamazon/communication/connection/Policy$Builder;->setIsLowLatencyNecessary(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/connection/Policy$Builder;->build()Lamazon/communication/connection/Policy;

    move-result-object v0

    sput-object v0, Lamazon/communication/connection/Policy;->SHARED_BIDI:Lamazon/communication/connection/Policy;

    .line 35
    new-instance v0, Lamazon/communication/connection/Policy$Builder;

    invoke-direct {v0}, Lamazon/communication/connection/Policy$Builder;-><init>()V

    invoke-virtual {v0, v1}, Lamazon/communication/connection/Policy$Builder;->setIsLowLatencyNecessary(Z)Lamazon/communication/connection/Policy$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lamazon/communication/connection/Policy$Builder;->build()Lamazon/communication/connection/Policy;

    move-result-object v0

    sput-object v0, Lamazon/communication/connection/Policy;->FAST_BIDI:Lamazon/communication/connection/Policy;

    return-void
.end method

.method private constructor <init>(Lamazon/communication/connection/CompressionOption;Lamazon/communication/connection/Priority;ZZZZZZLamazon/communication/connection/Purpose;ZLamazon/communication/connection/KeepAlive;)V
    .locals 0
    .param p1, "compressionOption"    # Lamazon/communication/connection/CompressionOption;
    .param p2, "priority"    # Lamazon/communication/connection/Priority;
    .param p3, "isLowLatencyNecessary"    # Z
    .param p4, "isRequestResponseOnly"    # Z
    .param p5, "isClearText"    # Z
    .param p6, "isWiFiNecessary"    # Z
    .param p7, "isAnonymousCredentialsAllowed"    # Z
    .param p8, "isDedicated"    # Z
    .param p9, "purpose"    # Lamazon/communication/connection/Purpose;
    .param p10, "isReconnectOnFailure"    # Z
    .param p11, "keepAlive"    # Lamazon/communication/connection/KeepAlive;

    .prologue
    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    iput-object p1, p0, Lamazon/communication/connection/Policy;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    .line 77
    iput-object p2, p0, Lamazon/communication/connection/Policy;->mPriority:Lamazon/communication/connection/Priority;

    .line 78
    iput-boolean p3, p0, Lamazon/communication/connection/Policy;->mIsLowLatencyNecessary:Z

    .line 79
    iput-boolean p4, p0, Lamazon/communication/connection/Policy;->mIsRequestResponseOnly:Z

    .line 80
    iput-boolean p5, p0, Lamazon/communication/connection/Policy;->mIsClearText:Z

    .line 81
    iput-boolean p6, p0, Lamazon/communication/connection/Policy;->mIsWiFiNecessary:Z

    .line 82
    iput-boolean p7, p0, Lamazon/communication/connection/Policy;->mIsAnonymousCredentialsAllowed:Z

    .line 83
    iput-boolean p8, p0, Lamazon/communication/connection/Policy;->mIsDedicated:Z

    .line 84
    iput-object p9, p0, Lamazon/communication/connection/Policy;->mPurpose:Lamazon/communication/connection/Purpose;

    .line 85
    iput-boolean p10, p0, Lamazon/communication/connection/Policy;->mReconnectOnFailure:Z

    .line 86
    iput-object p11, p0, Lamazon/communication/connection/Policy;->mKeepAlive:Lamazon/communication/connection/KeepAlive;

    .line 87
    return-void
.end method

.method synthetic constructor <init>(Lamazon/communication/connection/CompressionOption;Lamazon/communication/connection/Priority;ZZZZZZLamazon/communication/connection/Purpose;ZLamazon/communication/connection/KeepAlive;Lamazon/communication/connection/Policy$1;)V
    .locals 0
    .param p1, "x0"    # Lamazon/communication/connection/CompressionOption;
    .param p2, "x1"    # Lamazon/communication/connection/Priority;
    .param p3, "x2"    # Z
    .param p4, "x3"    # Z
    .param p5, "x4"    # Z
    .param p6, "x5"    # Z
    .param p7, "x6"    # Z
    .param p8, "x7"    # Z
    .param p9, "x8"    # Lamazon/communication/connection/Purpose;
    .param p10, "x9"    # Z
    .param p11, "x10"    # Lamazon/communication/connection/KeepAlive;
    .param p12, "x11"    # Lamazon/communication/connection/Policy$1;

    .prologue
    .line 21
    invoke-direct/range {p0 .. p11}, Lamazon/communication/connection/Policy;-><init>(Lamazon/communication/connection/CompressionOption;Lamazon/communication/connection/Priority;ZZZZZZLamazon/communication/connection/Purpose;ZLamazon/communication/connection/KeepAlive;)V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 182
    if-ne p0, p1, :cond_1

    .line 192
    :cond_0
    :goto_0
    return v1

    .line 185
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 186
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 189
    check-cast v0, Lamazon/communication/connection/Policy;

    .line 192
    .local v0, "policy":Lamazon/communication/connection/Policy;
    iget-object v3, p0, Lamazon/communication/connection/Policy;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    iget-object v4, v0, Lamazon/communication/connection/Policy;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    if-ne v3, v4, :cond_5

    iget-object v3, p0, Lamazon/communication/connection/Policy;->mPriority:Lamazon/communication/connection/Priority;

    iget-object v4, v0, Lamazon/communication/connection/Policy;->mPriority:Lamazon/communication/connection/Priority;

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lamazon/communication/connection/Policy;->mIsLowLatencyNecessary:Z

    iget-boolean v4, v0, Lamazon/communication/connection/Policy;->mIsLowLatencyNecessary:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lamazon/communication/connection/Policy;->mIsRequestResponseOnly:Z

    iget-boolean v4, v0, Lamazon/communication/connection/Policy;->mIsRequestResponseOnly:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lamazon/communication/connection/Policy;->mIsClearText:Z

    iget-boolean v4, v0, Lamazon/communication/connection/Policy;->mIsClearText:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lamazon/communication/connection/Policy;->mIsWiFiNecessary:Z

    iget-boolean v4, v0, Lamazon/communication/connection/Policy;->mIsWiFiNecessary:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lamazon/communication/connection/Policy;->mIsAnonymousCredentialsAllowed:Z

    iget-boolean v4, v0, Lamazon/communication/connection/Policy;->mIsAnonymousCredentialsAllowed:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lamazon/communication/connection/Policy;->mIsDedicated:Z

    iget-boolean v4, v0, Lamazon/communication/connection/Policy;->mIsDedicated:Z

    if-ne v3, v4, :cond_5

    iget-object v3, p0, Lamazon/communication/connection/Policy;->mPurpose:Lamazon/communication/connection/Purpose;

    iget-object v4, v0, Lamazon/communication/connection/Policy;->mPurpose:Lamazon/communication/connection/Purpose;

    if-eq v3, v4, :cond_4

    iget-object v3, p0, Lamazon/communication/connection/Policy;->mPurpose:Lamazon/communication/connection/Purpose;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lamazon/communication/connection/Policy;->mPurpose:Lamazon/communication/connection/Purpose;

    iget-object v4, v0, Lamazon/communication/connection/Policy;->mPurpose:Lamazon/communication/connection/Purpose;

    invoke-virtual {v3, v4}, Lamazon/communication/connection/Purpose;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    :cond_4
    iget-boolean v3, p0, Lamazon/communication/connection/Policy;->mReconnectOnFailure:Z

    iget-boolean v4, v0, Lamazon/communication/connection/Policy;->mReconnectOnFailure:Z

    if-ne v3, v4, :cond_5

    iget-object v3, p0, Lamazon/communication/connection/Policy;->mKeepAlive:Lamazon/communication/connection/KeepAlive;

    iget-object v4, v0, Lamazon/communication/connection/Policy;->mKeepAlive:Lamazon/communication/connection/KeepAlive;

    if-eq v3, v4, :cond_0

    :cond_5
    move v1, v2

    goto :goto_0
.end method

.method public getCompressionOption()Lamazon/communication/connection/CompressionOption;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lamazon/communication/connection/Policy;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    return-object v0
.end method

.method public getKeepAlive()Lamazon/communication/connection/KeepAlive;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lamazon/communication/connection/Policy;->mKeepAlive:Lamazon/communication/connection/KeepAlive;

    return-object v0
.end method

.method public getPriority()Lamazon/communication/connection/Priority;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lamazon/communication/connection/Policy;->mPriority:Lamazon/communication/connection/Priority;

    return-object v0
.end method

.method public getPurpose()Lamazon/communication/connection/Purpose;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lamazon/communication/connection/Policy;->mPurpose:Lamazon/communication/connection/Purpose;

    return-object v0
.end method

.method public getReconnectOnFailure()Z
    .locals 1

    .prologue
    .line 170
    iget-boolean v0, p0, Lamazon/communication/connection/Policy;->mReconnectOnFailure:Z

    return v0
.end method

.method public hashCode()I
    .locals 5

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 207
    const/4 v0, 0x7

    .line 208
    .local v0, "hash":I
    iget-object v1, p0, Lamazon/communication/connection/Policy;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    invoke-virtual {v1}, Lamazon/communication/connection/CompressionOption;->hashCode()I

    move-result v1

    add-int/lit16 v0, v1, 0xd9

    .line 209
    mul-int/lit8 v1, v0, 0x1f

    iget-object v4, p0, Lamazon/communication/connection/Policy;->mPriority:Lamazon/communication/connection/Priority;

    invoke-virtual {v4}, Lamazon/communication/connection/Priority;->hashCode()I

    move-result v4

    add-int v0, v1, v4

    .line 210
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsLowLatencyNecessary:Z

    if-eqz v1, :cond_0

    move v1, v2

    :goto_0
    add-int v0, v4, v1

    .line 211
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsRequestResponseOnly:Z

    if-eqz v1, :cond_1

    move v1, v2

    :goto_1
    add-int v0, v4, v1

    .line 212
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsClearText:Z

    if-eqz v1, :cond_2

    move v1, v2

    :goto_2
    add-int v0, v4, v1

    .line 213
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsWiFiNecessary:Z

    if-eqz v1, :cond_3

    move v1, v2

    :goto_3
    add-int v0, v4, v1

    .line 214
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsAnonymousCredentialsAllowed:Z

    if-eqz v1, :cond_4

    move v1, v2

    :goto_4
    add-int v0, v4, v1

    .line 215
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsDedicated:Z

    if-eqz v1, :cond_5

    move v1, v2

    :goto_5
    add-int v0, v4, v1

    .line 216
    mul-int/lit8 v1, v0, 0x1f

    iget-object v4, p0, Lamazon/communication/connection/Policy;->mPurpose:Lamazon/communication/connection/Purpose;

    invoke-virtual {v4}, Lamazon/communication/connection/Purpose;->hashCode()I

    move-result v4

    add-int v0, v1, v4

    .line 217
    mul-int/lit8 v1, v0, 0x1f

    iget-boolean v4, p0, Lamazon/communication/connection/Policy;->mReconnectOnFailure:Z

    if-eqz v4, :cond_6

    :goto_6
    add-int v0, v1, v2

    .line 218
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lamazon/communication/connection/Policy;->mKeepAlive:Lamazon/communication/connection/KeepAlive;

    invoke-virtual {v2}, Lamazon/communication/connection/KeepAlive;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 220
    return v0

    :cond_0
    move v1, v3

    .line 210
    goto :goto_0

    :cond_1
    move v1, v3

    .line 211
    goto :goto_1

    :cond_2
    move v1, v3

    .line 212
    goto :goto_2

    :cond_3
    move v1, v3

    .line 213
    goto :goto_3

    :cond_4
    move v1, v3

    .line 214
    goto :goto_4

    :cond_5
    move v1, v3

    .line 215
    goto :goto_5

    :cond_6
    move v2, v3

    .line 217
    goto :goto_6
.end method

.method public isAnonymousCredentialsAllowed()Z
    .locals 1

    .prologue
    .line 148
    iget-boolean v0, p0, Lamazon/communication/connection/Policy;->mIsAnonymousCredentialsAllowed:Z

    return v0
.end method

.method public isClearText()Z
    .locals 1

    .prologue
    .line 132
    iget-boolean v0, p0, Lamazon/communication/connection/Policy;->mIsClearText:Z

    return v0
.end method

.method public isDedicated()Z
    .locals 1

    .prologue
    .line 156
    iget-boolean v0, p0, Lamazon/communication/connection/Policy;->mIsDedicated:Z

    return v0
.end method

.method public isLowLatencyNecessary()Z
    .locals 1

    .prologue
    .line 114
    iget-boolean v0, p0, Lamazon/communication/connection/Policy;->mIsLowLatencyNecessary:Z

    return v0
.end method

.method public isRequestResponseOnly()Z
    .locals 1

    .prologue
    .line 122
    iget-boolean v0, p0, Lamazon/communication/connection/Policy;->mIsRequestResponseOnly:Z

    return v0
.end method

.method public isWiFiNecessary()Z
    .locals 1

    .prologue
    .line 140
    iget-boolean v0, p0, Lamazon/communication/connection/Policy;->mIsWiFiNecessary:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 225
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "{ "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string/jumbo v1, ", CompressionOption: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lamazon/communication/connection/Policy;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", Priority: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lamazon/communication/connection/Policy;->mPriority:Lamazon/communication/connection/Priority;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", LowLatency: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsLowLatencyNecessary:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", RequestResponseOnly: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsRequestResponseOnly:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", IsClearText: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsClearText:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", IsWiFiNecessary: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsWiFiNecessary:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", IsAnonymousCredentialsAllowed: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsAnonymousCredentialsAllowed:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", mIsDedicated: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mIsDedicated:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", mPurpose: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lamazon/communication/connection/Policy;->mPurpose:Lamazon/communication/connection/Purpose;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", mReconnectOnFailure: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lamazon/communication/connection/Policy;->mReconnectOnFailure:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", mKeepAlive: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lamazon/communication/connection/Policy;->mKeepAlive:Lamazon/communication/connection/KeepAlive;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
