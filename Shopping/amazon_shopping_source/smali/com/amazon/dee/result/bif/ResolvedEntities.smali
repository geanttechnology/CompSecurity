.class public Lcom/amazon/dee/result/bif/ResolvedEntities;
.super Ljava/lang/Object;
.source "ResolvedEntities.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private final mResolutionsPerAuthority:Lcom/google/common/collect/ImmutableMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/dee/result/bif/EntityResolutionResult;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/Map;)V
    .locals 1
    .param p1    # Ljava/util/Map;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "resolutionsPerAuthority"
        .end annotation
    .end param
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonCreator;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/dee/result/bif/EntityResolutionResult;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 41
    .local p1, "resolutionsPerAuthority":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/dee/result/bif/EntityResolutionResult;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    invoke-static {p1}, Lcom/google/common/collect/ImmutableMap;->copyOf(Ljava/util/Map;)Lcom/google/common/collect/ImmutableMap;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntities;->mResolutionsPerAuthority:Lcom/google/common/collect/ImmutableMap;

    .line 44
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 49
    instance-of v1, p1, Lcom/amazon/dee/result/bif/ResolvedEntities;

    if-eqz v1, :cond_0

    move-object v0, p1

    .line 51
    check-cast v0, Lcom/amazon/dee/result/bif/ResolvedEntities;

    .line 52
    .local v0, "other":Lcom/amazon/dee/result/bif/ResolvedEntities;
    iget-object v1, p0, Lcom/amazon/dee/result/bif/ResolvedEntities;->mResolutionsPerAuthority:Lcom/google/common/collect/ImmutableMap;

    iget-object v2, v0, Lcom/amazon/dee/result/bif/ResolvedEntities;->mResolutionsPerAuthority:Lcom/google/common/collect/ImmutableMap;

    invoke-static {v1, v2}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    .line 56
    .end local v0    # "other":Lcom/amazon/dee/result/bif/ResolvedEntities;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getEntityResolutionResult(Ljava/lang/String;)Lcom/amazon/dee/result/bif/EntityResolutionResult;
    .locals 1
    .param p1, "authSource"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntities;->mResolutionsPerAuthority:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v0, p1}, Lcom/google/common/collect/ImmutableMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/dee/result/bif/EntityResolutionResult;

    return-object v0
.end method

.method public getResolutionsPerAuthority()Ljava/util/Map;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/dee/result/bif/EntityResolutionResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/dee/result/bif/ResolvedEntities;->mResolutionsPerAuthority:Lcom/google/common/collect/ImmutableMap;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 63
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/ResolvedEntities;->mResolutionsPerAuthority:Lcom/google/common/collect/ImmutableMap;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 94
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "[Resolutions per Authority="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/dee/result/bif/ResolvedEntities;->mResolutionsPerAuthority:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
