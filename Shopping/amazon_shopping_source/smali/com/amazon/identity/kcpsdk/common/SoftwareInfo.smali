.class public final Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;
.super Ljava/lang/Object;
.source "SoftwareInfo.java"


# instance fields
.field private final mSoftwareComponentId:Ljava/lang/String;

.field private final mSoftwareVersion:Ljava/lang/Integer;


# direct methods
.method public constructor <init>(Ljava/lang/Integer;Ljava/lang/String;)V
    .locals 0
    .param p1, "softwareVersion"    # Ljava/lang/Integer;
    .param p2, "softwareComponentId"    # Ljava/lang/String;

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareVersion:Ljava/lang/Integer;

    .line 12
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareComponentId:Ljava/lang/String;

    .line 13
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 38
    if-ne p0, p1, :cond_1

    move v3, v2

    .line 77
    :cond_0
    :goto_0
    return v3

    .line 42
    :cond_1
    if-eqz p1, :cond_0

    .line 46
    instance-of v4, p1, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    if-eqz v4, :cond_0

    move-object v1, p1

    .line 51
    check-cast v1, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    .line 53
    .local v1, "other":Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareComponentId:Ljava/lang/String;

    if-nez v4, :cond_3

    .line 56
    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareComponentId()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_2

    move v0, v2

    .line 63
    .local v0, "attributesEqual":Z
    :goto_1
    if-eqz v0, :cond_0

    .line 68
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareVersion:Ljava/lang/Integer;

    if-nez v4, :cond_5

    .line 70
    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareComponentId()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_4

    move v0, v2

    :goto_2
    move v3, v0

    .line 77
    goto :goto_0

    .end local v0    # "attributesEqual":Z
    :cond_2
    move v0, v3

    .line 56
    goto :goto_1

    .line 60
    :cond_3
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareComponentId:Ljava/lang/String;

    iget-object v5, v1, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareComponentId:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .restart local v0    # "attributesEqual":Z
    goto :goto_1

    :cond_4
    move v0, v3

    .line 70
    goto :goto_2

    .line 74
    :cond_5
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareComponentId:Ljava/lang/String;

    iget-object v3, v1, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareComponentId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_2
.end method

.method public getSoftwareComponentId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareComponentId:Ljava/lang/String;

    return-object v0
.end method

.method public getSoftwareVersion()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareVersion:Ljava/lang/Integer;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 28
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareComponentId:Ljava/lang/String;

    if-nez v1, :cond_0

    move v1, v2

    :goto_0
    add-int/lit8 v0, v1, 0x1f

    .line 31
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareVersion:Ljava/lang/Integer;

    if-nez v3, :cond_1

    :goto_1
    add-int/2addr v1, v2

    .line 32
    return v1

    .line 28
    .end local v0    # "result":I
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareComponentId:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_0

    .line 31
    .restart local v0    # "result":I
    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareVersion:Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->hashCode()I

    move-result v2

    goto :goto_1
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 83
    const-string/jumbo v1, "Version: %s, ComponentId: %s"

    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareVersion:Ljava/lang/Integer;

    if-nez v0, :cond_0

    const-string/jumbo v0, "None"

    :goto_0
    aput-object v0, v2, v3

    const/4 v0, 0x1

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareComponentId:Ljava/lang/String;

    aput-object v3, v2, v0

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->mSoftwareVersion:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
