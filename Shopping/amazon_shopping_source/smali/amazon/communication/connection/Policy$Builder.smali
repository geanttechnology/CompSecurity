.class public final Lamazon/communication/connection/Policy$Builder;
.super Ljava/lang/Object;
.source "Policy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/communication/connection/Policy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private mBuilt:Z

.field private mCompressionOption:Lamazon/communication/connection/CompressionOption;

.field private mIsAnonymousCredentialsAllowed:Z

.field private mIsClearText:Z

.field private mIsDedicated:Z

.field private mIsLowLatencyNecessary:Z

.field private mIsRequestResponseOnly:Z

.field private mIsWiFiNecessary:Z

.field private mKeepAlive:Lamazon/communication/connection/KeepAlive;

.field private mPriority:Lamazon/communication/connection/Priority;

.field private mPurpose:Lamazon/communication/connection/Purpose;

.field private mReconnectOnFailure:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 277
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 278
    sget-object v0, Lamazon/communication/connection/CompressionOption;->ALLOWED:Lamazon/communication/connection/CompressionOption;

    iput-object v0, p0, Lamazon/communication/connection/Policy$Builder;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    .line 279
    sget-object v0, Lamazon/communication/connection/Priority;->PRIORITY_NORMAL:Lamazon/communication/connection/Priority;

    iput-object v0, p0, Lamazon/communication/connection/Policy$Builder;->mPriority:Lamazon/communication/connection/Priority;

    .line 280
    iput-boolean v1, p0, Lamazon/communication/connection/Policy$Builder;->mIsLowLatencyNecessary:Z

    .line 281
    iput-boolean v1, p0, Lamazon/communication/connection/Policy$Builder;->mIsRequestResponseOnly:Z

    .line 282
    iput-boolean v1, p0, Lamazon/communication/connection/Policy$Builder;->mIsClearText:Z

    .line 283
    iput-boolean v1, p0, Lamazon/communication/connection/Policy$Builder;->mIsWiFiNecessary:Z

    .line 284
    iput-boolean v1, p0, Lamazon/communication/connection/Policy$Builder;->mIsAnonymousCredentialsAllowed:Z

    .line 285
    iput-boolean v1, p0, Lamazon/communication/connection/Policy$Builder;->mIsDedicated:Z

    .line 286
    sget-object v0, Lamazon/communication/connection/Purpose;->REGULAR:Lamazon/communication/connection/Purpose;

    iput-object v0, p0, Lamazon/communication/connection/Policy$Builder;->mPurpose:Lamazon/communication/connection/Purpose;

    .line 287
    iput-boolean v1, p0, Lamazon/communication/connection/Policy$Builder;->mReconnectOnFailure:Z

    .line 288
    sget-object v0, Lamazon/communication/connection/KeepAlive;->NONE:Lamazon/communication/connection/KeepAlive;

    iput-object v0, p0, Lamazon/communication/connection/Policy$Builder;->mKeepAlive:Lamazon/communication/connection/KeepAlive;

    .line 289
    iput-boolean v1, p0, Lamazon/communication/connection/Policy$Builder;->mBuilt:Z

    .line 290
    return-void
.end method

.method private enforceSingleBuild()V
    .locals 2

    .prologue
    .line 501
    iget-boolean v0, p0, Lamazon/communication/connection/Policy$Builder;->mBuilt:Z

    if-eqz v0, :cond_0

    .line 502
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Each builder can only be used once. Create a new builder"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 505
    :cond_0
    return-void
.end method


# virtual methods
.method public build()Lamazon/communication/connection/Policy;
    .locals 13

    .prologue
    .line 298
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 299
    const/4 v0, 0x1

    iput-boolean v0, p0, Lamazon/communication/connection/Policy$Builder;->mBuilt:Z

    .line 301
    iget-boolean v0, p0, Lamazon/communication/connection/Policy$Builder;->mIsDedicated:Z

    if-eqz v0, :cond_0

    sget-object v0, Lamazon/communication/connection/Purpose;->REGULAR:Lamazon/communication/connection/Purpose;

    iget-object v1, p0, Lamazon/communication/connection/Policy$Builder;->mPurpose:Lamazon/communication/connection/Purpose;

    invoke-virtual {v0, v1}, Lamazon/communication/connection/Purpose;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 302
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "purpose must be set for dedicated connection"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 305
    :cond_0
    new-instance v0, Lamazon/communication/connection/Policy;

    iget-object v1, p0, Lamazon/communication/connection/Policy$Builder;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    iget-object v2, p0, Lamazon/communication/connection/Policy$Builder;->mPriority:Lamazon/communication/connection/Priority;

    iget-boolean v3, p0, Lamazon/communication/connection/Policy$Builder;->mIsLowLatencyNecessary:Z

    iget-boolean v4, p0, Lamazon/communication/connection/Policy$Builder;->mIsRequestResponseOnly:Z

    iget-boolean v5, p0, Lamazon/communication/connection/Policy$Builder;->mIsClearText:Z

    iget-boolean v6, p0, Lamazon/communication/connection/Policy$Builder;->mIsWiFiNecessary:Z

    iget-boolean v7, p0, Lamazon/communication/connection/Policy$Builder;->mIsAnonymousCredentialsAllowed:Z

    iget-boolean v8, p0, Lamazon/communication/connection/Policy$Builder;->mIsDedicated:Z

    iget-object v9, p0, Lamazon/communication/connection/Policy$Builder;->mPurpose:Lamazon/communication/connection/Purpose;

    iget-boolean v10, p0, Lamazon/communication/connection/Policy$Builder;->mReconnectOnFailure:Z

    iget-object v11, p0, Lamazon/communication/connection/Policy$Builder;->mKeepAlive:Lamazon/communication/connection/KeepAlive;

    const/4 v12, 0x0

    invoke-direct/range {v0 .. v12}, Lamazon/communication/connection/Policy;-><init>(Lamazon/communication/connection/CompressionOption;Lamazon/communication/connection/Priority;ZZZZZZLamazon/communication/connection/Purpose;ZLamazon/communication/connection/KeepAlive;Lamazon/communication/connection/Policy$1;)V

    return-object v0
.end method

.method public setCompressionOption(Lamazon/communication/connection/CompressionOption;)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "compressionOption"    # Lamazon/communication/connection/CompressionOption;

    .prologue
    .line 349
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 350
    iput-object p1, p0, Lamazon/communication/connection/Policy$Builder;->mCompressionOption:Lamazon/communication/connection/CompressionOption;

    .line 352
    return-object p0
.end method

.method public setIsAnonymousCredentialsAllowed(Z)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "isAnonymousCredentialsAllowed"    # Z

    .prologue
    .line 430
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 431
    iput-boolean p1, p0, Lamazon/communication/connection/Policy$Builder;->mIsAnonymousCredentialsAllowed:Z

    .line 433
    return-object p0
.end method

.method public setIsClearText(Z)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "isClearText"    # Z

    .prologue
    .line 403
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 404
    iput-boolean p1, p0, Lamazon/communication/connection/Policy$Builder;->mIsClearText:Z

    .line 406
    return-object p0
.end method

.method public setIsDedicated(Z)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "isDedicated"    # Z

    .prologue
    .line 444
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 445
    iput-boolean p1, p0, Lamazon/communication/connection/Policy$Builder;->mIsDedicated:Z

    .line 447
    return-object p0
.end method

.method public setIsLowLatencyNecessary(Z)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "isLowLatencyNecessary"    # Z

    .prologue
    .line 376
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 377
    iput-boolean p1, p0, Lamazon/communication/connection/Policy$Builder;->mIsLowLatencyNecessary:Z

    .line 379
    return-object p0
.end method

.method public setIsRequestResponseOnly(Z)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "isRequestResponseOnly"    # Z

    .prologue
    .line 390
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 391
    iput-boolean p1, p0, Lamazon/communication/connection/Policy$Builder;->mIsRequestResponseOnly:Z

    .line 393
    return-object p0
.end method

.method public setIsWiFiNecessary(Z)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "isWiFiNecessary"    # Z

    .prologue
    .line 416
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 417
    iput-boolean p1, p0, Lamazon/communication/connection/Policy$Builder;->mIsWiFiNecessary:Z

    .line 419
    return-object p0
.end method

.method public setKeepAlive(Lamazon/communication/connection/KeepAlive;)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "keepAlive"    # Lamazon/communication/connection/KeepAlive;

    .prologue
    .line 494
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 495
    iput-object p1, p0, Lamazon/communication/connection/Policy$Builder;->mKeepAlive:Lamazon/communication/connection/KeepAlive;

    .line 497
    return-object p0
.end method

.method public setPriority(Lamazon/communication/connection/Priority;)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "priority"    # Lamazon/communication/connection/Priority;

    .prologue
    .line 362
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 363
    iput-object p1, p0, Lamazon/communication/connection/Policy$Builder;->mPriority:Lamazon/communication/connection/Priority;

    .line 365
    return-object p0
.end method

.method public setPurpose(Lamazon/communication/connection/Purpose;)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "purpose"    # Lamazon/communication/connection/Purpose;

    .prologue
    .line 457
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 458
    iput-object p1, p0, Lamazon/communication/connection/Policy$Builder;->mPurpose:Lamazon/communication/connection/Purpose;

    .line 460
    return-object p0
.end method

.method public setReconnectOnFailure(Z)Lamazon/communication/connection/Policy$Builder;
    .locals 0
    .param p1, "reconnectOnFailure"    # Z

    .prologue
    .line 479
    invoke-direct {p0}, Lamazon/communication/connection/Policy$Builder;->enforceSingleBuild()V

    .line 480
    iput-boolean p1, p0, Lamazon/communication/connection/Policy$Builder;->mReconnectOnFailure:Z

    .line 482
    return-object p0
.end method
