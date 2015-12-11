.class public Lcom/auditude/ads/model/smil/Sequence;
.super Lcom/auditude/ads/model/BaseElement;
.source "Sequence.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/model/smil/Sequence$RefIterator;
    }
.end annotation


# static fields
.field public static PLAYABLE_AD_COUNT:Ljava/lang/String;

.field public static PLAYABLE_DURATION:Ljava/lang/String;

.field public static PLAYABLE_REFS:Ljava/lang/String;


# instance fields
.field private count:I

.field private creativeMaxDuration:I

.field private duration:I

.field private enumeratorIndex:I

.field private isWatched:Z

.field private maxCount:I

.field private maxDuration:I

.field private pars:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Par;",
            ">;"
        }
    .end annotation
.end field

.field private submissionId:Ljava/lang/String;

.field private type:Lcom/auditude/ads/model/smil/SmilElementType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-string v0, "playableDuration"

    sput-object v0, Lcom/auditude/ads/model/smil/Sequence;->PLAYABLE_DURATION:Ljava/lang/String;

    .line 32
    const-string v0, "playableAdCount"

    sput-object v0, Lcom/auditude/ads/model/smil/Sequence;->PLAYABLE_AD_COUNT:Ljava/lang/String;

    .line 33
    const-string v0, "playableRefs"

    sput-object v0, Lcom/auditude/ads/model/smil/Sequence;->PLAYABLE_REFS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/SmilElementType;)V
    .locals 3
    .param p1, "parent"    # Lcom/auditude/ads/model/BaseElement;
    .param p2, "type"    # Lcom/auditude/ads/model/smil/SmilElementType;

    .prologue
    const/4 v2, 0x0

    const/4 v1, -0x1

    .line 37
    invoke-direct {p0, p1}, Lcom/auditude/ads/model/BaseElement;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 19
    invoke-static {}, Lcom/auditude/ads/model/smil/SmilElementType;->values()[Lcom/auditude/ads/model/smil/SmilElementType;

    move-result-object v0

    aget-object v0, v0, v2

    iput-object v0, p0, Lcom/auditude/ads/model/smil/Sequence;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    .line 20
    iput v1, p0, Lcom/auditude/ads/model/smil/Sequence;->maxDuration:I

    .line 21
    iput v1, p0, Lcom/auditude/ads/model/smil/Sequence;->duration:I

    .line 22
    iput v1, p0, Lcom/auditude/ads/model/smil/Sequence;->maxCount:I

    .line 23
    iput v1, p0, Lcom/auditude/ads/model/smil/Sequence;->count:I

    .line 24
    iput v1, p0, Lcom/auditude/ads/model/smil/Sequence;->creativeMaxDuration:I

    .line 25
    iput-boolean v2, p0, Lcom/auditude/ads/model/smil/Sequence;->isWatched:Z

    .line 26
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/model/smil/Sequence;->pars:Ljava/util/ArrayList;

    .line 29
    iput v1, p0, Lcom/auditude/ads/model/smil/Sequence;->enumeratorIndex:I

    .line 38
    iput-object p2, p0, Lcom/auditude/ads/model/smil/Sequence;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    .line 39
    return-void
.end method


# virtual methods
.method public final addPar(Lcom/auditude/ads/model/smil/Par;)V
    .locals 1
    .param p1, "par"    # Lcom/auditude/ads/model/smil/Par;

    .prologue
    .line 250
    if-eqz p1, :cond_0

    .line 252
    invoke-virtual {p1, p0}, Lcom/auditude/ads/model/smil/Par;->setSequence(Lcom/auditude/ads/model/smil/Sequence;)V

    .line 253
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Sequence;->pars:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 255
    :cond_0
    return-void
.end method

.method public final addState(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 79
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {p2}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 81
    invoke-super {p0}, Lcom/auditude/ads/model/BaseElement;->getState()Ljava/util/HashMap;

    move-result-object v0

    .line 82
    .local v0, "sState":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez v0, :cond_0

    .line 84
    new-instance v0, Ljava/util/HashMap;

    .end local v0    # "sState":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 86
    .restart local v0    # "sState":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    invoke-super {p0, v0}, Lcom/auditude/ads/model/BaseElement;->setState(Ljava/util/HashMap;)V

    .line 89
    .end local v0    # "sState":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    return-void
.end method

.method public final getCreativeMaxDuration()I
    .locals 1

    .prologue
    .line 71
    iget v0, p0, Lcom/auditude/ads/model/smil/Sequence;->creativeMaxDuration:I

    return v0
.end method

.method public final getDuration()I
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lcom/auditude/ads/model/smil/Sequence;->duration:I

    return v0
.end method

.method public final getMaxCount()I
    .locals 1

    .prologue
    .line 67
    iget v0, p0, Lcom/auditude/ads/model/smil/Sequence;->maxCount:I

    if-gez v0, :cond_0

    iget v0, p0, Lcom/auditude/ads/model/smil/Sequence;->count:I

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/auditude/ads/model/smil/Sequence;->maxCount:I

    goto :goto_0
.end method

.method public final getMaxDuration()I
    .locals 1

    .prologue
    .line 63
    iget v0, p0, Lcom/auditude/ads/model/smil/Sequence;->maxDuration:I

    if-gez v0, :cond_0

    iget v0, p0, Lcom/auditude/ads/model/smil/Sequence;->duration:I

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/auditude/ads/model/smil/Sequence;->maxDuration:I

    goto :goto_0
.end method

.method public final getPars()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Par;",
            ">;"
        }
    .end annotation

    .prologue
    .line 91
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Sequence;->pars:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final getPlayableMetrics()Ljava/util/HashMap;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 102
    const/4 v7, 0x0

    .line 103
    .local v7, "totalDuration":I
    const/4 v6, 0x0

    .line 104
    .local v6, "totalCount":I
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 106
    .local v8, "totalRefs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/smil/Ref;>;"
    new-instance v0, Lcom/auditude/ads/model/smil/Sequence$RefIterator;

    iget-object v9, p0, Lcom/auditude/ads/model/smil/Sequence;->pars:Ljava/util/ArrayList;

    invoke-direct {v0, p0, v9}, Lcom/auditude/ads/model/smil/Sequence$RefIterator;-><init>(Lcom/auditude/ads/model/smil/Sequence;Ljava/util/ArrayList;)V

    .line 110
    .local v0, "ai":Lcom/auditude/ads/model/smil/Sequence$RefIterator;
    :cond_0
    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Sequence$RefIterator;->next()Lcom/auditude/ads/model/smil/Ref;

    move-result-object v4

    .line 111
    .local v4, "ref":Lcom/auditude/ads/model/smil/Ref;
    if-nez v4, :cond_2

    .line 140
    :cond_1
    :goto_0
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 141
    .local v5, "result":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v9, Lcom/auditude/ads/model/smil/Sequence;->PLAYABLE_DURATION:Ljava/lang/String;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v5, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    sget-object v9, Lcom/auditude/ads/model/smil/Sequence;->PLAYABLE_AD_COUNT:Ljava/lang/String;

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v5, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 143
    sget-object v9, Lcom/auditude/ads/model/smil/Sequence;->PLAYABLE_REFS:Ljava/lang/String;

    invoke-virtual {v5, v9, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    return-object v5

    .line 113
    .end local v5    # "result":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_2
    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v1

    .line 114
    .local v1, "asset":Lcom/auditude/ads/model/Asset;
    instance-of v9, v1, Lcom/auditude/ads/model/LinearAsset;

    if-eqz v9, :cond_0

    .line 117
    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Sequence;->getMaxCount()I

    move-result v9

    if-ltz v9, :cond_3

    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Sequence;->getMaxCount()I

    move-result v9

    if-ge v6, v9, :cond_1

    .line 118
    :cond_3
    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Sequence;->getMaxDuration()I

    move-result v9

    if-ltz v9, :cond_4

    move-object v9, v1

    check-cast v9, Lcom/auditude/ads/model/LinearAsset;

    invoke-virtual {v9}, Lcom/auditude/ads/model/LinearAsset;->getDurationInMillis()I

    move-result v9

    add-int/2addr v9, v7

    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Sequence;->getMaxDuration()I

    move-result v10

    if-gt v9, v10, :cond_0

    .line 120
    :cond_4
    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Sequence;->getCreativeMaxDuration()I

    move-result v9

    if-ltz v9, :cond_5

    invoke-virtual {v1}, Lcom/auditude/ads/model/Asset;->getDurationInMillis()I

    move-result v9

    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Sequence;->getCreativeMaxDuration()I

    move-result v10

    if-gt v9, v10, :cond_0

    .line 122
    :cond_5
    add-int/lit8 v6, v6, 0x1

    move-object v9, v1

    .line 123
    check-cast v9, Lcom/auditude/ads/model/LinearAsset;

    invoke-virtual {v9}, Lcom/auditude/ads/model/LinearAsset;->getDurationInMillis()I

    move-result v9

    add-int/2addr v7, v9

    .line 124
    invoke-virtual {v8, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 126
    invoke-virtual {v1}, Lcom/auditude/ads/model/Asset;->getAuditudeParams()Ljava/util/HashMap;

    move-result-object v2

    .line 127
    .local v2, "audParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v2, :cond_0

    const-string v9, "daisy_chaining"

    invoke-virtual {v2, v9}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 129
    const-string v9, "daisy_chaining"

    invoke-virtual {v2, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 130
    .local v3, "daisyChaining":Ljava/lang/String;
    const-string v9, "never"

    invoke-virtual {v3, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    goto :goto_0
.end method

.method public final getRefs()Ljava/util/ArrayList;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Ref;",
            ">;"
        }
    .end annotation

    .prologue
    .line 96
    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Sequence;->getPlayableMetrics()Ljava/util/HashMap;

    move-result-object v0

    .line 97
    .local v0, "result":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v1, Lcom/auditude/ads/model/smil/Sequence;->PLAYABLE_REFS:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    return-object v1
.end method

.method public final getSubmissionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Sequence;->submissionId:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Lcom/auditude/ads/model/smil/SmilElementType;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Sequence;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    return-object v0
.end method

.method public final isEmpty()Z
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Sequence;->pars:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public final isLinear()Z
    .locals 2

    .prologue
    .line 45
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Sequence;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    sget-object v1, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final setCount(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 61
    iput p1, p0, Lcom/auditude/ads/model/smil/Sequence;->count:I

    return-void
.end method

.method public final setCreativeMaxDuration(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 73
    iput p1, p0, Lcom/auditude/ads/model/smil/Sequence;->creativeMaxDuration:I

    return-void
.end method

.method public final setDuration(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 57
    iput p1, p0, Lcom/auditude/ads/model/smil/Sequence;->duration:I

    return-void
.end method

.method public final setMaxCount(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 69
    iput p1, p0, Lcom/auditude/ads/model/smil/Sequence;->maxCount:I

    return-void
.end method

.method public final setMaxDuration(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 65
    iput p1, p0, Lcom/auditude/ads/model/smil/Sequence;->maxDuration:I

    return-void
.end method

.method public final setSubmissionId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Sequence;->submissionId:Ljava/lang/String;

    return-void
.end method

.method public setType(Lcom/auditude/ads/model/smil/SmilElementType;)V
    .locals 0
    .param p1, "type"    # Lcom/auditude/ads/model/smil/SmilElementType;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Sequence;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    return-void
.end method
