.class public Lcom/amazon/dee/result/bif/Intent;
.super Ljava/lang/Object;
.source "Intent.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private mConfidenceScores:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dee/result/bif/ScoreSource;",
            "Lcom/amazon/dee/result/bif/Score;",
            ">;"
        }
    .end annotation
.end field

.field private mConfirmationState:Lcom/amazon/dee/result/bif/ConfirmationState;

.field private mMergedFromContext:Z

.field private mName:Ljava/lang/String;

.field private mSlots:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Slot;",
            ">;"
        }
    .end annotation
.end field

.field private mTokens:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 41
    const/4 v0, 0x0

    invoke-direct {p0, v1, v1, v1, v0}, Lcom/amazon/dee/result/bif/Intent;-><init>(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/dee/result/bif/ConfirmationState;Z)V

    .line 42
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 65
    const/4 v0, 0x0

    invoke-direct {p0, p1, v1, v1, v0}, Lcom/amazon/dee/result/bif/Intent;-><init>(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/dee/result/bif/ConfirmationState;Z)V

    .line 66
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dee/result/bif/ScoreSource;",
            "Lcom/amazon/dee/result/bif/Score;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 54
    .local p2, "confidenceScores":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/dee/result/bif/ScoreSource;Lcom/amazon/dee/result/bif/Score;>;"
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/amazon/dee/result/bif/Intent;-><init>(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/dee/result/bif/ConfirmationState;Z)V

    .line 55
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/dee/result/bif/ConfirmationState;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p3, "confirmationState"    # Lcom/amazon/dee/result/bif/ConfirmationState;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dee/result/bif/ScoreSource;",
            "Lcom/amazon/dee/result/bif/Score;",
            ">;",
            "Lcom/amazon/dee/result/bif/ConfirmationState;",
            ")V"
        }
    .end annotation

    .prologue
    .line 79
    .local p2, "confidenceScores":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/dee/result/bif/ScoreSource;Lcom/amazon/dee/result/bif/Score;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/dee/result/bif/Intent;-><init>(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/dee/result/bif/ConfirmationState;Z)V

    .line 80
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/dee/result/bif/ConfirmationState;Z)V
    .locals 5
    .param p1, "name"    # Ljava/lang/String;
    .param p3, "confirmationState"    # Lcom/amazon/dee/result/bif/ConfirmationState;
    .param p4, "mergedFromContext"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dee/result/bif/ScoreSource;",
            "Lcom/amazon/dee/result/bif/Score;",
            ">;",
            "Lcom/amazon/dee/result/bif/ConfirmationState;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 93
    .local p2, "confidenceScores":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/dee/result/bif/ScoreSource;Lcom/amazon/dee/result/bif/Score;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 94
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Intent;->mName:Ljava/lang/String;

    .line 95
    if-nez p2, :cond_0

    .line 97
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    .line 98
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    sget-object v1, Lcom/amazon/dee/result/bif/ScoreSource;->SLU:Lcom/amazon/dee/result/bif/ScoreSource;

    new-instance v2, Lcom/amazon/dee/result/bif/Score;

    const-wide/16 v3, 0x0

    invoke-direct {v2, v3, v4}, Lcom/amazon/dee/result/bif/Score;-><init>(D)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 103
    :goto_0
    iput-object p3, p0, Lcom/amazon/dee/result/bif/Intent;->mConfirmationState:Lcom/amazon/dee/result/bif/ConfirmationState;

    .line 104
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mSlots:Ljava/util/List;

    .line 105
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mTokens:Ljava/util/List;

    .line 106
    iput-boolean p4, p0, Lcom/amazon/dee/result/bif/Intent;->mMergedFromContext:Z

    .line 107
    return-void

    .line 101
    :cond_0
    iput-object p2, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    goto :goto_0
.end method


# virtual methods
.method public final addSlot(Lcom/amazon/dee/result/bif/Slot;)V
    .locals 1
    .param p1, "slot"    # Lcom/amazon/dee/result/bif/Slot;

    .prologue
    .line 139
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mSlots:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 140
    return-void
.end method

.method public final addSlots(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Slot;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 293
    .local p1, "slots":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Slot;>;"
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mSlots:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 294
    return-void
.end method

.method public final addToken(Lcom/amazon/dee/result/bif/Token;)V
    .locals 1
    .param p1, "token"    # Lcom/amazon/dee/result/bif/Token;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mTokens:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 118
    return-void
.end method

.method public final addTokens(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 128
    .local p1, "tokens":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Token;>;"
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mTokens:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 129
    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 341
    instance-of v2, p1, Lcom/amazon/dee/result/bif/Intent;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 343
    check-cast v0, Lcom/amazon/dee/result/bif/Intent;

    .line 344
    .local v0, "other":Lcom/amazon/dee/result/bif/Intent;
    iget-object v2, p0, Lcom/amazon/dee/result/bif/Intent;->mName:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Intent;->mName:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Intent;->mTokens:Ljava/util/List;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Intent;->mTokens:Ljava/util/List;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Intent;->mSlots:Ljava/util/List;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Intent;->mSlots:Ljava/util/List;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 351
    .end local v0    # "other":Lcom/amazon/dee/result/bif/Intent;
    :cond_0
    return v1
.end method

.method public getConfidenceScore(Lcom/amazon/dee/result/bif/ScoreSource;)D
    .locals 3
    .param p1, "source"    # Lcom/amazon/dee/result/bif/ScoreSource;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 182
    const/4 v0, 0x0

    .line 183
    .local v0, "score":Lcom/amazon/dee/result/bif/Score;
    iget-object v1, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    if-eqz v1, :cond_0

    .line 185
    iget-object v1, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "score":Lcom/amazon/dee/result/bif/Score;
    check-cast v0, Lcom/amazon/dee/result/bif/Score;

    .line 187
    .restart local v0    # "score":Lcom/amazon/dee/result/bif/Score;
    :cond_0
    if-nez v0, :cond_1

    const-wide/16 v1, 0x0

    :goto_0
    return-wide v1

    :cond_1
    invoke-virtual {v0}, Lcom/amazon/dee/result/bif/Score;->getValue()D

    move-result-wide v1

    goto :goto_0
.end method

.method public getConfidenceScoreBin(Lcom/amazon/dee/result/bif/ScoreSource;)Lcom/amazon/dee/result/bif/ConfidenceBin;
    .locals 2
    .param p1, "source"    # Lcom/amazon/dee/result/bif/ScoreSource;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 199
    const/4 v0, 0x0

    .line 200
    .local v0, "score":Lcom/amazon/dee/result/bif/Score;
    iget-object v1, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    if-eqz v1, :cond_0

    .line 202
    iget-object v1, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "score":Lcom/amazon/dee/result/bif/Score;
    check-cast v0, Lcom/amazon/dee/result/bif/Score;

    .line 204
    .restart local v0    # "score":Lcom/amazon/dee/result/bif/Score;
    :cond_0
    if-nez v0, :cond_1

    const/4 v1, 0x0

    :goto_0
    return-object v1

    :cond_1
    invoke-virtual {v0}, Lcom/amazon/dee/result/bif/Score;->getBin()Lcom/amazon/dee/result/bif/ConfidenceBin;

    move-result-object v1

    goto :goto_0
.end method

.method public final getConfidenceScores()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dee/result/bif/ScoreSource;",
            "Lcom/amazon/dee/result/bif/Score;",
            ">;"
        }
    .end annotation

    .prologue
    .line 170
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    return-object v0
.end method

.method public final getConfirmationState()Lcom/amazon/dee/result/bif/ConfirmationState;
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mConfirmationState:Lcom/amazon/dee/result/bif/ConfirmationState;

    return-object v0
.end method

.method public final getEmptySlots()Ljava/util/List;
    .locals 5
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Slot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 369
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 370
    .local v0, "emptySlots":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Slot;>;"
    iget-object v4, p0, Lcom/amazon/dee/result/bif/Intent;->mSlots:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/dee/result/bif/Slot;

    .line 372
    .local v2, "slot":Lcom/amazon/dee/result/bif/Slot;
    invoke-virtual {v2}, Lcom/amazon/dee/result/bif/Slot;->getValue()Lcom/amazon/dee/result/bif/Entity;

    move-result-object v3

    .line 373
    .local v3, "slotValue":Lcom/amazon/dee/result/bif/Entity;
    if-nez v3, :cond_0

    .line 375
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 378
    .end local v2    # "slot":Lcom/amazon/dee/result/bif/Slot;
    .end local v3    # "slotValue":Lcom/amazon/dee/result/bif/Entity;
    :cond_1
    return-object v0
.end method

.method public final getMergedFromContext()Z
    .locals 1

    .prologue
    .line 323
    iget-boolean v0, p0, Lcom/amazon/dee/result/bif/Intent;->mMergedFromContext:Z

    return v0
.end method

.method public final getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public final getSlotByName(Ljava/lang/String;)Lcom/amazon/dee/result/bif/Slot;
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 264
    iget-object v2, p0, Lcom/amazon/dee/result/bif/Intent;->mSlots:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/dee/result/bif/Slot;

    .line 266
    .local v1, "slot":Lcom/amazon/dee/result/bif/Slot;
    invoke-virtual {v1}, Lcom/amazon/dee/result/bif/Slot;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 271
    .end local v1    # "slot":Lcom/amazon/dee/result/bif/Slot;
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public final getSlots()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Slot;",
            ">;"
        }
    .end annotation

    .prologue
    .line 250
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mSlots:Ljava/util/List;

    return-object v0
.end method

.method public final getTokens()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;"
        }
    .end annotation

    .prologue
    .line 229
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Intent;->mTokens:Ljava/util/List;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 358
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Intent;->mName:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Intent;->mSlots:Ljava/util/List;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Intent;->mTokens:Ljava/util/List;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public final setConfidenceScores(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dee/result/bif/ScoreSource;",
            "Lcom/amazon/dee/result/bif/Score;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 216
    .local p1, "confidenceScores":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/dee/result/bif/ScoreSource;Lcom/amazon/dee/result/bif/Score;>;"
    if-eqz p1, :cond_0

    .line 218
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Intent;->mConfidenceScores:Ljava/util/Map;

    .line 220
    :cond_0
    return-void
.end method

.method public setConfirmationState(Lcom/amazon/dee/result/bif/ConfirmationState;)V
    .locals 0
    .param p1, "confirmationState"    # Lcom/amazon/dee/result/bif/ConfirmationState;

    .prologue
    .line 313
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Intent;->mConfirmationState:Lcom/amazon/dee/result/bif/ConfirmationState;

    .line 314
    return-void
.end method

.method public setMergedFromContext(Z)V
    .locals 0
    .param p1, "mergedFromContext"    # Z

    .prologue
    .line 334
    iput-boolean p1, p0, Lcom/amazon/dee/result/bif/Intent;->mMergedFromContext:Z

    .line 335
    return-void
.end method

.method public final setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 160
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Intent;->mName:Ljava/lang/String;

    .line 161
    return-void
.end method

.method public final setSlots(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Slot;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 282
    .local p1, "slots":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Slot;>;"
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Intent;->mSlots:Ljava/util/List;

    .line 283
    return-void
.end method

.method public final setTokens(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 240
    .local p1, "tokens":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Token;>;"
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Intent;->mTokens:Ljava/util/List;

    .line 241
    return-void
.end method
