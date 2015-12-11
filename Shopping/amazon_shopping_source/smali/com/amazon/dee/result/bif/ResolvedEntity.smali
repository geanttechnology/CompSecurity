.class public Lcom/amazon/dee/result/bif/ResolvedEntity;
.super Ljava/lang/Object;
.source "ResolvedEntity.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

.field private mExtraDataFromAuthority:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mIdentifiers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mName:Ljava/lang/String;

.field private mResolvedValue:Lcom/amazon/dee/result/bif/Value;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Value;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Lcom/amazon/dee/result/bif/Value;

    .prologue
    const/4 v4, 0x0

    .line 66
    move-object v3, v4

    check-cast v3, Lcom/amazon/dee/result/bif/Score;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/ResolvedEntity;-><init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Value;Lcom/amazon/dee/result/bif/Score;Ljava/util/Map;Ljava/util/Map;)V

    .line 67
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Value;Lcom/amazon/dee/result/bif/Score;Ljava/util/Map;Ljava/util/Map;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Lcom/amazon/dee/result/bif/Value;
    .param p3, "confidenceScore"    # Lcom/amazon/dee/result/bif/Score;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/dee/result/bif/Value;",
            "Lcom/amazon/dee/result/bif/Score;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 48
    .local p4, "ids":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p5, "extraDataFromAuthority":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mName:Ljava/lang/String;

    .line 50
    iput-object p2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mResolvedValue:Lcom/amazon/dee/result/bif/Value;

    .line 51
    iput-object p3, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    .line 52
    iput-object p4, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    .line 53
    iput-object p5, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    .line 54
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Value;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Lcom/amazon/dee/result/bif/Value;
    .param p3, "relevance"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/dee/result/bif/Value;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 42
    .local p4, "ids":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p5, "extraDataFromAuthority":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p3, :cond_0

    const-string/jumbo v0, ""

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v3, 0x0

    :goto_0
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/ResolvedEntity;-><init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Value;Lcom/amazon/dee/result/bif/Score;Ljava/util/Map;Ljava/util/Map;)V

    .line 44
    return-void

    .line 42
    :cond_1
    new-instance v3, Lcom/amazon/dee/result/bif/Score;

    invoke-static {p3}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    invoke-direct {v3, v0, v1}, Lcom/amazon/dee/result/bif/Score;-><init>(D)V

    goto :goto_0
.end method


# virtual methods
.method public addExtraDataFromAuthorityObject(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "infoKey"    # Ljava/lang/String;
    .param p2, "infoValue"    # Ljava/lang/String;

    .prologue
    .line 281
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    if-eqz v0, :cond_0

    .line 283
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 290
    :goto_0
    return-void

    .line 287
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    .line 288
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public addIdentifier(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "idType"    # Ljava/lang/String;
    .param p2, "idValue"    # Ljava/lang/String;

    .prologue
    .line 225
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    if-eqz v0, :cond_0

    .line 227
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 234
    :goto_0
    return-void

    .line 231
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    .line 232
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 79
    instance-of v2, p1, Lcom/amazon/dee/result/bif/ResolvedEntity;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 81
    check-cast v0, Lcom/amazon/dee/result/bif/ResolvedEntity;

    .line 82
    .local v0, "other":Lcom/amazon/dee/result/bif/ResolvedEntity;
    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mName:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mName:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mResolvedValue:Lcom/amazon/dee/result/bif/Value;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mResolvedValue:Lcom/amazon/dee/result/bif/Value;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 90
    .end local v0    # "other":Lcom/amazon/dee/result/bif/ResolvedEntity;
    :cond_0
    return v1
.end method

.method public getConfidenceScore()Lcom/amazon/dee/result/bif/Score;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    return-object v0
.end method

.method public getExtraDataFromAuthority()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 299
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    return-object v0
.end method

.method public getExtraDataFromAuthorityGivenKey(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 268
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getIdentifier(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 212
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getIdentifiers()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 243
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public getRelevance()Ljava/lang/String;
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 153
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    invoke-virtual {v0}, Lcom/amazon/dee/result/bif/Score;->getValue()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getResolvedValue()Lcom/amazon/dee/result/bif/Value;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mResolvedValue:Lcom/amazon/dee/result/bif/Value;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 97
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mName:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mResolvedValue:Lcom/amazon/dee/result/bif/Value;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    aput-object v2, v0, v1

    const/4 v1, 0x4

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public setConfidenceScore(Lcom/amazon/dee/result/bif/Score;)V
    .locals 0
    .param p1, "confidenceScore"    # Lcom/amazon/dee/result/bif/Score;

    .prologue
    .line 199
    iput-object p1, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    .line 200
    return-void
.end method

.method public setExtraDataFromAuthority(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 310
    .local p1, "extraDataFromAuthority":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    .line 311
    return-void
.end method

.method public setIdentifiers(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 254
    .local p1, "identifiers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    .line 255
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 119
    iput-object p1, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mName:Ljava/lang/String;

    .line 120
    return-void
.end method

.method public setRelevance(Ljava/lang/String;)V
    .locals 3
    .param p1, "relevance"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 166
    if-eqz p1, :cond_0

    const-string/jumbo v2, ""

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 168
    :cond_0
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    .line 181
    :goto_0
    return-void

    .line 171
    :cond_1
    invoke-static {p1}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    .line 172
    .local v0, "score":D
    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    if-nez v2, :cond_2

    .line 174
    new-instance v2, Lcom/amazon/dee/result/bif/Score;

    invoke-direct {v2, v0, v1}, Lcom/amazon/dee/result/bif/Score;-><init>(D)V

    iput-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    goto :goto_0

    .line 178
    :cond_2
    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    invoke-virtual {v2, v0, v1}, Lcom/amazon/dee/result/bif/Score;->setValue(D)V

    goto :goto_0
.end method

.method public setResolvedValue(Lcom/amazon/dee/result/bif/Value;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/dee/result/bif/Value;

    .prologue
    .line 140
    iput-object p1, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mResolvedValue:Lcom/amazon/dee/result/bif/Value;

    .line 141
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 316
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/base/Objects;->toStringHelper(Ljava/lang/Class;)Lcom/google/common/base/Objects$ToStringHelper;

    move-result-object v0

    const-string/jumbo v1, "name"

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mName:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/common/base/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/common/base/Objects$ToStringHelper;

    move-result-object v0

    const-string/jumbo v1, "resolvedValue"

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mResolvedValue:Lcom/amazon/dee/result/bif/Value;

    invoke-virtual {v0, v1, v2}, Lcom/google/common/base/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/common/base/Objects$ToStringHelper;

    move-result-object v0

    const-string/jumbo v1, "confidenceScore"

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mConfidenceScore:Lcom/amazon/dee/result/bif/Score;

    invoke-virtual {v0, v1, v2}, Lcom/google/common/base/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/common/base/Objects$ToStringHelper;

    move-result-object v0

    const-string/jumbo v1, "identifiers"

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mIdentifiers:Ljava/util/Map;

    invoke-virtual {v0, v1, v2}, Lcom/google/common/base/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/common/base/Objects$ToStringHelper;

    move-result-object v0

    const-string/jumbo v1, "extraDataFromAuthority"

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntity;->mExtraDataFromAuthority:Ljava/util/Map;

    invoke-virtual {v0, v1, v2}, Lcom/google/common/base/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/common/base/Objects$ToStringHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/common/base/Objects$ToStringHelper;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
