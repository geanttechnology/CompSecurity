.class public Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;
.super Ljava/lang/Object;
.source "HalNetworkProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/hal/model/HalParseable;


# instance fields
.field private brand:Ljava/lang/String;

.field private companyId:J

.field private isPremium:Z
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "isPremium"
    .end annotation
.end field

.field private logoUrl:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private networkId:J

.field private parentCompany:Ljava/lang/String;

.field private shortCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 8
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 75
    if-ne p0, p1, :cond_1

    .line 109
    :cond_0
    :goto_0
    return v1

    .line 78
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 79
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 82
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    .line 84
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->companyId:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->companyId:J

    cmp-long v3, v4, v6

    if-eqz v3, :cond_4

    move v1, v2

    .line 85
    goto :goto_0

    .line 87
    :cond_4
    iget-boolean v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->isPremium:Z

    iget-boolean v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->isPremium:Z

    if-eq v3, v4, :cond_5

    move v1, v2

    .line 88
    goto :goto_0

    .line 90
    :cond_5
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->networkId:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->networkId:J

    cmp-long v3, v4, v6

    if-eqz v3, :cond_6

    move v1, v2

    .line 91
    goto :goto_0

    .line 93
    :cond_6
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->brand:Ljava/lang/String;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->brand:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->brand:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    :cond_7
    move v1, v2

    .line 94
    goto :goto_0

    .line 93
    :cond_8
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->brand:Ljava/lang/String;

    if-nez v3, :cond_7

    .line 96
    :cond_9
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->logoUrl:Ljava/lang/String;

    if-eqz v3, :cond_b

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->logoUrl:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->logoUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    :cond_a
    move v1, v2

    .line 97
    goto :goto_0

    .line 96
    :cond_b
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->logoUrl:Ljava/lang/String;

    if-nez v3, :cond_a

    .line 99
    :cond_c
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->name:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_d

    move v1, v2

    .line 100
    goto :goto_0

    .line 102
    :cond_d
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->parentCompany:Ljava/lang/String;

    if-eqz v3, :cond_f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->parentCompany:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->parentCompany:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_10

    :cond_e
    move v1, v2

    .line 103
    goto :goto_0

    .line 102
    :cond_f
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->parentCompany:Ljava/lang/String;

    if-nez v3, :cond_e

    .line 105
    :cond_10
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->shortCode:Ljava/lang/String;

    if-eqz v3, :cond_11

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->shortCode:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->shortCode:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 106
    goto/16 :goto_0

    .line 105
    :cond_11
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->shortCode:Ljava/lang/String;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getBrand()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->brand:Ljava/lang/String;

    return-object v0
.end method

.method public getCompanyId()J
    .locals 2

    .prologue
    .line 70
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->companyId:J

    return-wide v0
.end method

.method public getLogoUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->logoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getNetworkId()J
    .locals 2

    .prologue
    .line 42
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->networkId:J

    return-wide v0
.end method

.method public getParentCompany()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->parentCompany:Ljava/lang/String;

    return-object v0
.end method

.method public getShortCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->shortCode:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 8

    .prologue
    const/16 v3, 0x20

    const/4 v2, 0x0

    .line 114
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->networkId:J

    iget-wide v6, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->networkId:J

    ushr-long/2addr v6, v3

    xor-long/2addr v4, v6

    long-to-int v0, v4

    .line 115
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->companyId:J

    iget-wide v6, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->companyId:J

    ushr-long/2addr v6, v3

    xor-long/2addr v4, v6

    long-to-int v3, v4

    add-int v0, v1, v3

    .line 116
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->name:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v3

    add-int v0, v1, v3

    .line 117
    mul-int/lit8 v3, v0, 0x1f

    iget-boolean v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->isPremium:Z

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    add-int v0, v3, v1

    .line 118
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->shortCode:Ljava/lang/String;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->shortCode:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_1
    add-int v0, v3, v1

    .line 119
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->logoUrl:Ljava/lang/String;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->logoUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_2
    add-int v0, v3, v1

    .line 120
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->brand:Ljava/lang/String;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->brand:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_3
    add-int v0, v3, v1

    .line 121
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->parentCompany:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->parentCompany:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :cond_0
    add-int v0, v1, v2

    .line 122
    return v0

    :cond_1
    move v1, v2

    .line 117
    goto :goto_0

    :cond_2
    move v1, v2

    .line 118
    goto :goto_1

    :cond_3
    move v1, v2

    .line 119
    goto :goto_2

    :cond_4
    move v1, v2

    .line 120
    goto :goto_3
.end method

.method public isPremium()Z
    .locals 1

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->isPremium:Z

    return v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 4
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 23
    const-string v2, "companyId"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 24
    .local v0, "companyIdString":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 25
    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->companyId:J

    .line 27
    const-string v2, "id"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 28
    .local v1, "networkIdString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 29
    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->networkId:J

    .line 32
    :cond_0
    const-string v2, "name"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->name:Ljava/lang/String;

    .line 33
    const-string v2, "isPremium"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->isPremium:Z

    .line 34
    const-string v2, "shortCode"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->shortCode:Ljava/lang/String;

    .line 35
    const-string v2, "logo"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->logoUrl:Ljava/lang/String;

    .line 36
    const-string v2, "brand"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->brand:Ljava/lang/String;

    .line 37
    const-string v2, "parentCompany"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->parentCompany:Ljava/lang/String;

    .line 39
    .end local v1    # "networkIdString":Ljava/lang/String;
    :cond_1
    return-void
.end method
