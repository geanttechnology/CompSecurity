.class public Lcom/auditude/ads/model/smil/Ref;
.super Ljava/lang/Object;
.source "Ref.java"


# instance fields
.field private ad:Lcom/auditude/ads/model/Ad;

.field private assets:[Lcom/auditude/ads/model/Asset;

.field private companions:[Lcom/auditude/ads/model/OnPageAsset;

.field private id:Ljava/lang/String;

.field private isWatched:Z

.field private par:Lcom/auditude/ads/model/smil/Par;

.field private primaryAsset:Lcom/auditude/ads/model/Asset;

.field private type:Lcom/auditude/ads/model/smil/SmilElementType;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/auditude/ads/model/smil/Ref;-><init>(Lcom/auditude/ads/model/smil/Par;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Lcom/auditude/ads/model/smil/Par;)V
    .locals 1
    .param p1, "par"    # Lcom/auditude/ads/model/smil/Par;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/auditude/ads/model/smil/Ref;->isWatched:Z

    .line 15
    sget-object v0, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    iput-object v0, p0, Lcom/auditude/ads/model/smil/Ref;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    .line 27
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Ref;->par:Lcom/auditude/ads/model/smil/Par;

    .line 28
    return-void
.end method

.method private mapAssets()V
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 98
    iget-object v3, p0, Lcom/auditude/ads/model/smil/Ref;->ad:Lcom/auditude/ads/model/Ad;

    if-nez v3, :cond_0

    .line 128
    :goto_0
    return-void

    .line 103
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 104
    .local v1, "banners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/OnPageAsset;>;"
    iput-object v4, p0, Lcom/auditude/ads/model/smil/Ref;->primaryAsset:Lcom/auditude/ads/model/Asset;

    .line 106
    iget-object v3, p0, Lcom/auditude/ads/model/smil/Ref;->assets:[Lcom/auditude/ads/model/Asset;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/auditude/ads/model/smil/Ref;->assets:[Lcom/auditude/ads/model/Asset;

    array-length v3, v3

    if-lez v3, :cond_1

    .line 109
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    iget-object v3, p0, Lcom/auditude/ads/model/smil/Ref;->assets:[Lcom/auditude/ads/model/Asset;

    array-length v3, v3

    if-lt v2, v3, :cond_2

    .line 127
    .end local v2    # "i":I
    :cond_1
    const/4 v3, 0x0

    new-array v3, v3, [Lcom/auditude/ads/model/OnPageAsset;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Lcom/auditude/ads/model/OnPageAsset;

    iput-object v3, p0, Lcom/auditude/ads/model/smil/Ref;->companions:[Lcom/auditude/ads/model/OnPageAsset;

    goto :goto_0

    .line 111
    .restart local v2    # "i":I
    :cond_2
    iget-object v3, p0, Lcom/auditude/ads/model/smil/Ref;->assets:[Lcom/auditude/ads/model/Asset;

    aget-object v0, v3, v2

    .line 112
    .local v0, "asset":Lcom/auditude/ads/model/Asset;
    instance-of v3, v0, Lcom/auditude/ads/model/ILinearAsset;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/auditude/ads/model/smil/Ref;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    sget-object v5, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    if-ne v3, v5, :cond_4

    .line 114
    iput-object v0, p0, Lcom/auditude/ads/model/smil/Ref;->primaryAsset:Lcom/auditude/ads/model/Asset;

    .line 109
    :cond_3
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 116
    :cond_4
    instance-of v3, v0, Lcom/auditude/ads/model/INonLinearAsset;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/auditude/ads/model/smil/Ref;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    sget-object v5, Lcom/auditude/ads/model/smil/SmilElementType;->NON_LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    if-ne v3, v5, :cond_5

    .line 118
    iput-object v0, p0, Lcom/auditude/ads/model/smil/Ref;->primaryAsset:Lcom/auditude/ads/model/Asset;

    goto :goto_2

    .line 120
    :cond_5
    instance-of v3, v0, Lcom/auditude/ads/model/OnPageAsset;

    if-eqz v3, :cond_3

    .line 122
    instance-of v3, v0, Lcom/auditude/ads/model/OnPageAsset;

    if-eqz v3, :cond_6

    move-object v3, v0

    :goto_3
    check-cast v3, Lcom/auditude/ads/model/OnPageAsset;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    :cond_6
    move-object v3, v4

    goto :goto_3
.end method


# virtual methods
.method public final getAd()Lcom/auditude/ads/model/Ad;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Ref;->ad:Lcom/auditude/ads/model/Ad;

    return-object v0
.end method

.method public final getID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Ref;->id:Ljava/lang/String;

    return-object v0
.end method

.method public final getPar()Lcom/auditude/ads/model/smil/Par;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Ref;->par:Lcom/auditude/ads/model/smil/Par;

    return-object v0
.end method

.method public final getPrimaryAsset()Lcom/auditude/ads/model/Asset;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Ref;->primaryAsset:Lcom/auditude/ads/model/Asset;

    return-object v0
.end method

.method public final setAd(Lcom/auditude/ads/model/Ad;)V
    .locals 0
    .param p1, "value"    # Lcom/auditude/ads/model/Ad;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Ref;->ad:Lcom/auditude/ads/model/Ad;

    .line 63
    return-void
.end method

.method public final setAssets([Lcom/auditude/ads/model/Asset;)V
    .locals 0
    .param p1, "value"    # [Lcom/auditude/ads/model/Asset;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Ref;->assets:[Lcom/auditude/ads/model/Asset;

    .line 73
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Ref;->mapAssets()V

    .line 74
    return-void
.end method

.method public final setID(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Ref;->id:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setPar(Lcom/auditude/ads/model/smil/Par;)V
    .locals 0
    .param p1, "par"    # Lcom/auditude/ads/model/smil/Par;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Ref;->par:Lcom/auditude/ads/model/smil/Par;

    .line 38
    return-void
.end method
