.class public Lcom/xfinity/playerlib/model/consumable/hal/HalReview;
.super Ljava/lang/Object;
.source "HalReview.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/hal/model/HalParseable;


# instance fields
.field private commonSenseMediaTargetAge:I

.field private provider:Ljava/lang/String;

.field private rottenTomatoesCriticScore:I

.field private rottenTomatoesFanScore:I


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
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 69
    if-ne p0, p1, :cond_1

    .line 91
    :cond_0
    :goto_0
    return v1

    .line 72
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 73
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 76
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;

    .line 78
    .local v0, "halReview":Lcom/xfinity/playerlib/model/consumable/hal/HalReview;
    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->commonSenseMediaTargetAge:I

    iget v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->commonSenseMediaTargetAge:I

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 79
    goto :goto_0

    .line 81
    :cond_4
    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesCriticScore:I

    iget v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesCriticScore:I

    if-eq v3, v4, :cond_5

    move v1, v2

    .line 82
    goto :goto_0

    .line 84
    :cond_5
    iget v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesFanScore:I

    iget v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesFanScore:I

    if-eq v3, v4, :cond_6

    move v1, v2

    .line 85
    goto :goto_0

    .line 87
    :cond_6
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->provider:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->provider:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 88
    goto :goto_0
.end method

.method public getCommonSenseMediaTargetAge()I
    .locals 1

    .prologue
    .line 64
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->commonSenseMediaTargetAge:I

    return v0
.end method

.method public getProvider()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->provider:Ljava/lang/String;

    return-object v0
.end method

.method public getRottenTomatoesCriticScore()I
    .locals 1

    .prologue
    .line 60
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesCriticScore:I

    return v0
.end method

.method public getRottenTomatoesFanScore()I
    .locals 1

    .prologue
    .line 56
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesFanScore:I

    return v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 96
    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->provider:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 97
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesFanScore:I

    add-int v0, v1, v2

    .line 98
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesCriticScore:I

    add-int v0, v1, v2

    .line 99
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->commonSenseMediaTargetAge:I

    add-int v0, v1, v2

    .line 100
    return v0
.end method

.method public isCommonSenseMedia()Z
    .locals 2

    .prologue
    .line 44
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->provider:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->provider:Ljava/lang/String;

    const-string v1, "CSM"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isRottenTomatoes()Z
    .locals 2

    .prologue
    .line 40
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->provider:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->provider:Ljava/lang/String;

    const-string v1, "RT"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isRottenTomatoesCriticFresh()Z
    .locals 2

    .prologue
    .line 52
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesCriticScore:I

    const/16 v1, 0x3c

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isRottenTomatoesFanFresh()Z
    .locals 2

    .prologue
    .line 48
    iget v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesFanScore:I

    const/16 v1, 0x3c

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 4
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    const/4 v3, -0x1

    .line 24
    const-string v2, "provider"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->provider:Ljava/lang/String;

    .line 25
    const-string v2, "attributes"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchItem(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v1

    .line 27
    .local v1, "attributes":Lcom/comcast/cim/microdata/model/MicrodataItem;
    if-eqz v1, :cond_0

    .line 28
    invoke-virtual {p1, v1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v0

    .line 29
    .local v0, "attributeResolver":Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;
    const-string v2, "urnrtfanSummaryScore"

    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesFanScore:I

    .line 30
    const-string v2, "urnrtcriticSummaryScore"

    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->rottenTomatoesCriticScore:I

    .line 31
    const-string v2, "urncsmtargetAge"

    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->commonSenseMediaTargetAge:I

    .line 33
    .end local v0    # "attributeResolver":Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;
    :cond_0
    return-void
.end method
