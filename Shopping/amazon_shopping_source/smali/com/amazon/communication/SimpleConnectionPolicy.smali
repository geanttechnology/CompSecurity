.class public Lcom/amazon/communication/SimpleConnectionPolicy;
.super Ljava/lang/Object;
.source "SimpleConnectionPolicy.java"

# interfaces
.implements Lamazon/communication/connection/ConnectionPolicy;


# instance fields
.field protected mCompressionOption:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

.field protected mIsAnonymousCredentialsAllowed:Z

.field protected mIsClearText:Z

.field protected mIsInstanceLocked:Z

.field protected mIsLowLatencyNecessary:Z

.field protected mIsRequestResponseOnly:Z

.field protected mIsRoamingAllowed:Z

.field protected mIsShortLived:Z

.field protected mIsWiFiNecessary:Z

.field protected mPriority:Lamazon/communication/connection/Priority;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-boolean v0, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRoamingAllowed:Z

    .line 49
    iput-boolean v0, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsShortLived:Z

    .line 50
    iput-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsLowLatencyNecessary:Z

    .line 51
    iput-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRequestResponseOnly:Z

    .line 52
    sget-object v0, Lamazon/communication/connection/Priority;->PRIORITY_NORMAL:Lamazon/communication/connection/Priority;

    iput-object v0, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mPriority:Lamazon/communication/connection/Priority;

    .line 53
    iput-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsInstanceLocked:Z

    .line 54
    iput-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsClearText:Z

    .line 55
    iput-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsWiFiNecessary:Z

    .line 56
    iput-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsAnonymousCredentialsAllowed:Z

    .line 57
    sget-object v0, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->ALLOWED:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    iput-object v0, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mCompressionOption:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    .line 58
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "that"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 151
    if-ne p0, p1, :cond_1

    .line 160
    :cond_0
    :goto_0
    return v1

    .line 154
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 155
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 158
    check-cast v0, Lcom/amazon/communication/SimpleConnectionPolicy;

    .line 160
    .local v0, "other":Lcom/amazon/communication/SimpleConnectionPolicy;
    iget-boolean v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRoamingAllowed:Z

    iget-boolean v4, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRoamingAllowed:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsShortLived:Z

    iget-boolean v4, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsShortLived:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsLowLatencyNecessary:Z

    iget-boolean v4, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsLowLatencyNecessary:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRequestResponseOnly:Z

    iget-boolean v4, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRequestResponseOnly:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsInstanceLocked:Z

    iget-boolean v4, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsInstanceLocked:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsClearText:Z

    iget-boolean v4, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsClearText:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsWiFiNecessary:Z

    iget-boolean v4, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsWiFiNecessary:Z

    if-ne v3, v4, :cond_5

    iget-boolean v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsAnonymousCredentialsAllowed:Z

    iget-boolean v4, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsAnonymousCredentialsAllowed:Z

    if-ne v3, v4, :cond_5

    iget-object v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mPriority:Lamazon/communication/connection/Priority;

    iget-object v4, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mPriority:Lamazon/communication/connection/Priority;

    if-ne v3, v4, :cond_5

    iget-object v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mCompressionOption:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    if-nez v3, :cond_4

    iget-object v3, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mCompressionOption:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    if-eqz v3, :cond_0

    :cond_4
    iget-object v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mCompressionOption:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mCompressionOption:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    iget-object v4, v0, Lcom/amazon/communication/SimpleConnectionPolicy;->mCompressionOption:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-virtual {v3, v4}, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_5
    move v1, v2

    goto :goto_0
.end method

.method public hashCode()I
    .locals 5

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 175
    const/4 v0, 0x7

    .line 176
    .local v0, "hash":I
    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRoamingAllowed:Z

    if-eqz v1, :cond_0

    move v1, v2

    :goto_0
    add-int/lit16 v0, v1, 0xd9

    .line 177
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsShortLived:Z

    if-eqz v1, :cond_1

    move v1, v2

    :goto_1
    add-int v0, v4, v1

    .line 178
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsLowLatencyNecessary:Z

    if-eqz v1, :cond_2

    move v1, v2

    :goto_2
    add-int v0, v4, v1

    .line 179
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRequestResponseOnly:Z

    if-eqz v1, :cond_3

    move v1, v2

    :goto_3
    add-int v0, v4, v1

    .line 180
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsInstanceLocked:Z

    if-eqz v1, :cond_4

    move v1, v2

    :goto_4
    add-int v0, v4, v1

    .line 181
    mul-int/lit8 v1, v0, 0x1f

    iget-object v4, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mCompressionOption:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-virtual {v4}, Lamazon/communication/connection/ConnectionPolicy$CompressionOption;->hashCode()I

    move-result v4

    add-int v0, v1, v4

    .line 182
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsClearText:Z

    if-eqz v1, :cond_5

    move v1, v2

    :goto_5
    add-int v0, v4, v1

    .line 183
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsWiFiNecessary:Z

    if-eqz v1, :cond_6

    move v1, v2

    :goto_6
    add-int v0, v4, v1

    .line 184
    mul-int/lit8 v1, v0, 0x1f

    iget-boolean v4, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsAnonymousCredentialsAllowed:Z

    if-eqz v4, :cond_7

    :goto_7
    add-int v0, v1, v2

    .line 185
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mPriority:Lamazon/communication/connection/Priority;

    invoke-virtual {v2}, Lamazon/communication/connection/Priority;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 186
    return v0

    :cond_0
    move v1, v3

    .line 176
    goto :goto_0

    :cond_1
    move v1, v3

    .line 177
    goto :goto_1

    :cond_2
    move v1, v3

    .line 178
    goto :goto_2

    :cond_3
    move v1, v3

    .line 179
    goto :goto_3

    :cond_4
    move v1, v3

    .line 180
    goto :goto_4

    :cond_5
    move v1, v3

    .line 182
    goto :goto_5

    :cond_6
    move v1, v3

    .line 183
    goto :goto_6

    :cond_7
    move v2, v3

    .line 184
    goto :goto_7
.end method

.method public setCompressionOption(Lamazon/communication/connection/ConnectionPolicy$CompressionOption;)V
    .locals 0
    .param p1, "compressionOption"    # Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    .prologue
    .line 134
    iput-object p1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mCompressionOption:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    .line 135
    return-void
.end method

.method public setIsClearText(Z)V
    .locals 0
    .param p1, "isClearText"    # Z

    .prologue
    .line 138
    iput-boolean p1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsClearText:Z

    .line 139
    return-void
.end method

.method public setIsInstanceLocked(Z)V
    .locals 0
    .param p1, "isLocked"    # Z

    .prologue
    .line 110
    iput-boolean p1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsInstanceLocked:Z

    .line 111
    return-void
.end method

.method public setIsLowLatencyNecessary(Z)V
    .locals 0
    .param p1, "isLowLatencyNecessary"    # Z

    .prologue
    .line 118
    iput-boolean p1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsLowLatencyNecessary:Z

    .line 119
    return-void
.end method

.method public setIsRequestResponseOnly(Z)V
    .locals 0
    .param p1, "isRequestResponseOnly"    # Z

    .prologue
    .line 114
    iput-boolean p1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRequestResponseOnly:Z

    .line 115
    return-void
.end method

.method public setIsRoamingAllowed(Z)V
    .locals 0
    .param p1, "isAllowed"    # Z

    .prologue
    .line 130
    iput-boolean p1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRoamingAllowed:Z

    .line 131
    return-void
.end method

.method public setIsShortLived(Z)V
    .locals 0
    .param p1, "isShortLived"    # Z

    .prologue
    .line 122
    iput-boolean p1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsShortLived:Z

    .line 123
    return-void
.end method

.method public setIsWiFiNecessary(Z)V
    .locals 0
    .param p1, "isWiFiNecessary"    # Z

    .prologue
    .line 142
    iput-boolean p1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsWiFiNecessary:Z

    .line 143
    return-void
.end method

.method public setPriority(Lamazon/communication/connection/Priority;)V
    .locals 0
    .param p1, "priority"    # Lamazon/communication/connection/Priority;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mPriority:Lamazon/communication/connection/Priority;

    .line 127
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 191
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "{ Roaming: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRoamingAllowed:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", ShortLived: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsShortLived:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", LowLatency: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsLowLatencyNecessary:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", RequestResponseOnly: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsRequestResponseOnly:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", Priority: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mPriority:Lamazon/communication/connection/Priority;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", CompressionOption: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mCompressionOption:Lamazon/communication/connection/ConnectionPolicy$CompressionOption;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", IsClearText: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsClearText:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", IsWiFiNecessary: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsWiFiNecessary:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", IsAnonymousCredentialsAllowed: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/communication/SimpleConnectionPolicy;->mIsAnonymousCredentialsAllowed:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
