.class public Lcom/amazon/dee/result/bif/EntityResolutionResult;
.super Ljava/lang/Object;
.source "EntityResolutionResult.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private mPriorityOrder:I

.field private mResolutionStatus:Lcom/amazon/dee/result/bif/ERStatus;

.field private mResolvedList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/ResolvedEntity;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 49
    const/4 v0, 0x0

    invoke-direct {p0, v0, v1, v1}, Lcom/amazon/dee/result/bif/EntityResolutionResult;-><init>(ILcom/amazon/dee/result/bif/ERStatus;Ljava/util/List;)V

    .line 50
    return-void
.end method

.method public constructor <init>(ILcom/amazon/dee/result/bif/ERStatus;Ljava/util/List;)V
    .locals 0
    .param p1, "priorityOrder"    # I
    .param p2, "resolutionStatus"    # Lcom/amazon/dee/result/bif/ERStatus;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/amazon/dee/result/bif/ERStatus;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/ResolvedEntity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 38
    .local p3, "resolvedList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/ResolvedEntity;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput p1, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mPriorityOrder:I

    .line 40
    iput-object p2, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolutionStatus:Lcom/amazon/dee/result/bif/ERStatus;

    .line 41
    iput-object p3, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolvedList:Ljava/util/List;

    .line 42
    return-void
.end method

.method public constructor <init>(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/ResolvedEntity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p1, "resolvedList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/ResolvedEntity;>;"
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1, p1}, Lcom/amazon/dee/result/bif/EntityResolutionResult;-><init>(ILcom/amazon/dee/result/bif/ERStatus;Ljava/util/List;)V

    .line 25
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 55
    instance-of v2, p1, Lcom/amazon/dee/result/bif/EntityResolutionResult;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 57
    check-cast v0, Lcom/amazon/dee/result/bif/EntityResolutionResult;

    .line 58
    .local v0, "other":Lcom/amazon/dee/result/bif/EntityResolutionResult;
    iget v2, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mPriorityOrder:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget v3, v0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mPriorityOrder:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolutionStatus:Lcom/amazon/dee/result/bif/ERStatus;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolutionStatus:Lcom/amazon/dee/result/bif/ERStatus;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolvedList:Ljava/util/List;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolvedList:Ljava/util/List;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 64
    .end local v0    # "other":Lcom/amazon/dee/result/bif/EntityResolutionResult;
    :cond_0
    return v1
.end method

.method public getBestResolvedEntity()Lcom/amazon/dee/result/bif/ResolvedEntity;
    .locals 2
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 142
    iget-object v0, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolvedList:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolvedList:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/dee/result/bif/ResolvedEntity;

    .line 146
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPriorityOrder()I
    .locals 1

    .prologue
    .line 81
    iget v0, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mPriorityOrder:I

    return v0
.end method

.method public getResolutionStatus()Lcom/amazon/dee/result/bif/ERStatus;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolutionStatus:Lcom/amazon/dee/result/bif/ERStatus;

    return-object v0
.end method

.method public getResolvedList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/ResolvedEntity;",
            ">;"
        }
    .end annotation

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolvedList:Ljava/util/List;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 71
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget v2, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mPriorityOrder:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolutionStatus:Lcom/amazon/dee/result/bif/ERStatus;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolvedList:Ljava/util/List;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public setPriorityOrder(I)V
    .locals 0
    .param p1, "priorityOrder"    # I

    .prologue
    .line 91
    iput p1, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mPriorityOrder:I

    .line 92
    return-void
.end method

.method public setResolutionStatus(Lcom/amazon/dee/result/bif/ERStatus;)V
    .locals 0
    .param p1, "resolutionStatus"    # Lcom/amazon/dee/result/bif/ERStatus;

    .prologue
    .line 111
    iput-object p1, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolutionStatus:Lcom/amazon/dee/result/bif/ERStatus;

    .line 112
    return-void
.end method

.method public setResolvedList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/ResolvedEntity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 131
    .local p1, "resolvedList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/ResolvedEntity;>;"
    iput-object p1, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolvedList:Ljava/util/List;

    .line 132
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 152
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/base/Objects;->toStringHelper(Ljava/lang/Class;)Lcom/google/common/base/Objects$ToStringHelper;

    move-result-object v0

    const-string/jumbo v1, "priorityOrder"

    iget v2, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mPriorityOrder:I

    invoke-virtual {v0, v1, v2}, Lcom/google/common/base/Objects$ToStringHelper;->add(Ljava/lang/String;I)Lcom/google/common/base/Objects$ToStringHelper;

    move-result-object v0

    const-string/jumbo v1, "resolutionStatus"

    iget-object v2, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolutionStatus:Lcom/amazon/dee/result/bif/ERStatus;

    invoke-virtual {v0, v1, v2}, Lcom/google/common/base/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/common/base/Objects$ToStringHelper;

    move-result-object v0

    const-string/jumbo v1, "resolvedList"

    iget-object v2, p0, Lcom/amazon/dee/result/bif/EntityResolutionResult;->mResolvedList:Ljava/util/List;

    invoke-virtual {v0, v1, v2}, Lcom/google/common/base/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/common/base/Objects$ToStringHelper;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/common/base/Objects$ToStringHelper;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
