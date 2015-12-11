.class public Ltv/freewheel/ad/AdChain;
.super Ljava/lang/Object;
.source "AdChain.java"


# instance fields
.field public adInstances:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/AdInstance;",
            ">;"
        }
    .end annotation
.end field

.field protected chainBehavior:Ltv/freewheel/ad/ChainBehavior;

.field protected logger:Ltv/freewheel/utils/Logger;


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/AdInstance;)V
    .locals 1
    .param p1, "adInstance"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/ad/AdChain;->chainBehavior:Ltv/freewheel/ad/ChainBehavior;

    .line 15
    const/4 v0, 0x0

    invoke-static {p0, v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;Z)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/AdChain;->logger:Ltv/freewheel/utils/Logger;

    .line 16
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    .line 17
    invoke-virtual {p0, p1}, Ltv/freewheel/ad/AdChain;->append(Ltv/freewheel/ad/AdInstance;)V

    .line 18
    return-void
.end method


# virtual methods
.method public append(Ltv/freewheel/ad/AdInstance;)V
    .locals 3
    .param p1, "adInstance"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/ad/AdChain;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " append "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 35
    if-eqz p1, :cond_0

    .line 36
    iget-object v0, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 37
    iput-object p0, p1, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    .line 39
    :cond_0
    return-void
.end method

.method public findNextPlayableAd(Ltv/freewheel/ad/AdInstance;)Ltv/freewheel/ad/AdInstance;
    .locals 6
    .param p1, "from"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 21
    iget-object v3, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v3

    add-int/lit8 v0, v3, 0x1

    .line 22
    .local v0, "fromIndex":I
    const/4 v2, 0x0

    .line 23
    .local v2, "ret":Ltv/freewheel/ad/AdInstance;
    move v1, v0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v1, v3, :cond_0

    .line 24
    iget-object v3, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v3}, Ltv/freewheel/ad/AdInstance;->isPlayable()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 25
    iget-object v3, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "ret":Ltv/freewheel/ad/AdInstance;
    check-cast v2, Ltv/freewheel/ad/AdInstance;

    .line 29
    .restart local v2    # "ret":Ltv/freewheel/ad/AdInstance;
    :cond_0
    iget-object v3, p0, Ltv/freewheel/ad/AdChain;->logger:Ltv/freewheel/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " findNextPlayableAd returning "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 30
    return-object v2

    .line 23
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public getLastAdInstanceInChain()Ltv/freewheel/ad/AdInstance;
    .locals 2

    .prologue
    .line 61
    iget-object v0, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 62
    const/4 v0, 0x0

    .line 64
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    iget-object v1, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/AdInstance;

    goto :goto_0
.end method

.method public insertAfter(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/AdInstance;)V
    .locals 4
    .param p1, "newAdInstance"    # Ltv/freewheel/ad/AdInstance;
    .param p2, "target"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 42
    iget-object v1, p0, Ltv/freewheel/ad/AdChain;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " insertAfter("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 43
    iget-object v1, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    invoke-virtual {v1, p2}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 44
    .local v0, "i":I
    if-ltz v0, :cond_0

    .line 45
    iget-object v1, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    add-int/lit8 v2, v0, 0x1

    invoke-virtual {v1, v2, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 46
    iput-object p0, p1, Ltv/freewheel/ad/AdInstance;->adChain:Ltv/freewheel/ad/AdChain;

    .line 50
    :goto_0
    return-void

    .line 48
    :cond_0
    iget-object v1, p0, Ltv/freewheel/ad/AdChain;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " target "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is not in this chain"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public isChainStopper(Ltv/freewheel/ad/AdInstance;)Z
    .locals 1
    .param p1, "adInstance"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 57
    iget-object v0, p0, Ltv/freewheel/ad/AdChain;->chainBehavior:Ltv/freewheel/ad/ChainBehavior;

    invoke-virtual {v0, p1}, Ltv/freewheel/ad/ChainBehavior;->isChainStopper(Ltv/freewheel/ad/AdInstance;)Z

    move-result v0

    return v0
.end method

.method public relatedSlotState()Ltv/freewheel/ad/state/SlotState;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Ltv/freewheel/ad/AdChain;->chainBehavior:Ltv/freewheel/ad/ChainBehavior;

    invoke-virtual {v0}, Ltv/freewheel/ad/ChainBehavior;->relatedSlotState()Ltv/freewheel/ad/state/SlotState;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 73
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[AdChain "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/ad/AdChain;->adInstances:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
