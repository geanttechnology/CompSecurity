.class public Lcom/amazon/dee/result/bif/Slot;
.super Ljava/lang/Object;
.source "Slot.java"


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

.field private mName:Ljava/lang/String;

.field private mTraits:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/SlotTrait;",
            ">;"
        }
    .end annotation
.end field

.field private mValue:Lcom/amazon/dee/result/bif/Entity;


# direct methods
.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 30
    move-object v0, p0

    move-object v2, v1

    move-object v3, v1

    move-object v4, v1

    move-object v5, v1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/Slot;-><init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Entity;Ljava/util/Map;Ljava/util/List;Lcom/amazon/dee/result/bif/ConfirmationState;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Entity;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Lcom/amazon/dee/result/bif/Entity;

    .prologue
    const/4 v0, 0x0

    .line 106
    invoke-direct {p0, p1, p2, v0, v0}, Lcom/amazon/dee/result/bif/Slot;-><init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Entity;Ljava/util/Map;Ljava/util/List;)V

    .line 107
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Entity;Ljava/util/Map;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Lcom/amazon/dee/result/bif/Entity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/dee/result/bif/Entity;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dee/result/bif/ScoreSource;",
            "Lcom/amazon/dee/result/bif/Score;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "confidenceScores":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/dee/result/bif/ScoreSource;Lcom/amazon/dee/result/bif/Score;>;"
    const/4 v4, 0x0

    .line 93
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/Slot;-><init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Entity;Ljava/util/Map;Ljava/util/List;Lcom/amazon/dee/result/bif/ConfirmationState;)V

    .line 94
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Entity;Ljava/util/Map;Ljava/util/List;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Lcom/amazon/dee/result/bif/Entity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/dee/result/bif/Entity;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dee/result/bif/ScoreSource;",
            "Lcom/amazon/dee/result/bif/Score;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/SlotTrait;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 78
    .local p3, "confidenceScores":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/dee/result/bif/ScoreSource;Lcom/amazon/dee/result/bif/Score;>;"
    .local p4, "traits":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/SlotTrait;>;"
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/Slot;-><init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Entity;Ljava/util/Map;Ljava/util/List;Lcom/amazon/dee/result/bif/ConfirmationState;)V

    .line 79
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/dee/result/bif/Entity;Ljava/util/Map;Ljava/util/List;Lcom/amazon/dee/result/bif/ConfirmationState;)V
    .locals 5
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Lcom/amazon/dee/result/bif/Entity;
    .param p5, "confirmationState"    # Lcom/amazon/dee/result/bif/ConfirmationState;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/dee/result/bif/Entity;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dee/result/bif/ScoreSource;",
            "Lcom/amazon/dee/result/bif/Score;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/SlotTrait;",
            ">;",
            "Lcom/amazon/dee/result/bif/ConfirmationState;",
            ")V"
        }
    .end annotation

    .prologue
    .line 49
    .local p3, "confidenceScores":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/dee/result/bif/ScoreSource;Lcom/amazon/dee/result/bif/Score;>;"
    .local p4, "traits":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/SlotTrait;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Slot;->mName:Ljava/lang/String;

    .line 51
    iput-object p2, p0, Lcom/amazon/dee/result/bif/Slot;->mValue:Lcom/amazon/dee/result/bif/Entity;

    .line 52
    if-nez p3, :cond_0

    .line 54
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    .line 55
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    sget-object v1, Lcom/amazon/dee/result/bif/ScoreSource;->SLU:Lcom/amazon/dee/result/bif/ScoreSource;

    new-instance v2, Lcom/amazon/dee/result/bif/Score;

    const-wide/16 v3, 0x0

    invoke-direct {v2, v3, v4}, Lcom/amazon/dee/result/bif/Score;-><init>(D)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    :goto_0
    if-eqz p4, :cond_1

    .end local p4    # "traits":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/SlotTrait;>;"
    :goto_1
    iput-object p4, p0, Lcom/amazon/dee/result/bif/Slot;->mTraits:Ljava/util/List;

    .line 60
    iput-object p5, p0, Lcom/amazon/dee/result/bif/Slot;->mConfirmationState:Lcom/amazon/dee/result/bif/ConfirmationState;

    .line 61
    return-void

    .line 57
    .restart local p4    # "traits":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/SlotTrait;>;"
    :cond_0
    iput-object p3, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    goto :goto_0

    .line 59
    :cond_1
    new-instance p4, Ljava/util/ArrayList;

    .end local p4    # "traits":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/SlotTrait;>;"
    invoke-direct {p4}, Ljava/util/ArrayList;-><init>()V

    goto :goto_1
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 112
    instance-of v2, p1, Lcom/amazon/dee/result/bif/Slot;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 114
    check-cast v0, Lcom/amazon/dee/result/bif/Slot;

    .line 115
    .local v0, "other":Lcom/amazon/dee/result/bif/Slot;
    iget-object v2, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Slot;->mName:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Slot;->mName:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Slot;->mValue:Lcom/amazon/dee/result/bif/Entity;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Slot;->mValue:Lcom/amazon/dee/result/bif/Entity;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Slot;->mTraits:Ljava/util/List;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Slot;->mTraits:Ljava/util/List;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 122
    .end local v0    # "other":Lcom/amazon/dee/result/bif/Slot;
    :cond_0
    return v1
.end method

.method public getConfidenceScore(Lcom/amazon/dee/result/bif/ScoreSource;)D
    .locals 3
    .param p1, "source"    # Lcom/amazon/dee/result/bif/ScoreSource;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 208
    const/4 v0, 0x0

    .line 209
    .local v0, "score":Lcom/amazon/dee/result/bif/Score;
    iget-object v1, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    if-eqz v1, :cond_0

    .line 211
    iget-object v1, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "score":Lcom/amazon/dee/result/bif/Score;
    check-cast v0, Lcom/amazon/dee/result/bif/Score;

    .line 213
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
    .line 225
    const/4 v0, 0x0

    .line 226
    .local v0, "score":Lcom/amazon/dee/result/bif/Score;
    iget-object v1, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    if-eqz v1, :cond_0

    .line 228
    iget-object v1, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "score":Lcom/amazon/dee/result/bif/Score;
    check-cast v0, Lcom/amazon/dee/result/bif/Score;

    .line 230
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
    .line 181
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    return-object v0
.end method

.method public getConfirmationState()Lcom/amazon/dee/result/bif/ConfirmationState;
    .locals 1

    .prologue
    .line 294
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Slot;->mConfirmationState:Lcom/amazon/dee/result/bif/ConfirmationState;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Slot;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public getToken(Lcom/amazon/dee/result/bif/Intent;)Ljava/util/List;
    .locals 1
    .param p1, "parent"    # Lcom/amazon/dee/result/bif/Intent;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/dee/result/bif/Intent;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;"
        }
    .end annotation

    .prologue
    .line 267
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Slot;->mValue:Lcom/amazon/dee/result/bif/Entity;

    if-eqz v0, :cond_0

    .line 269
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Slot;->mValue:Lcom/amazon/dee/result/bif/Entity;

    invoke-virtual {v0, p1}, Lcom/amazon/dee/result/bif/Entity;->getTokens(Lcom/amazon/dee/result/bif/Intent;)Ljava/util/List;

    move-result-object v0

    .line 273
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getTraits()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/SlotTrait;",
            ">;"
        }
    .end annotation

    .prologue
    .line 242
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Slot;->mTraits:Ljava/util/List;

    return-object v0
.end method

.method public getValue()Lcom/amazon/dee/result/bif/Entity;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Slot;->mValue:Lcom/amazon/dee/result/bif/Entity;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 129
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Slot;->mName:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Slot;->mValue:Lcom/amazon/dee/result/bif/Entity;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Slot;->mTraits:Ljava/util/List;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public setConfidenceScores(Ljava/util/Map;)V
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
    .line 193
    .local p1, "confidenceScores":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/dee/result/bif/ScoreSource;Lcom/amazon/dee/result/bif/Score;>;"
    if-eqz p1, :cond_0

    .line 195
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Slot;->mConfidenceScores:Ljava/util/Map;

    .line 197
    :cond_0
    return-void
.end method

.method public setConfirmationState(Lcom/amazon/dee/result/bif/ConfirmationState;)V
    .locals 0
    .param p1, "state"    # Lcom/amazon/dee/result/bif/ConfirmationState;

    .prologue
    .line 284
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Slot;->mConfirmationState:Lcom/amazon/dee/result/bif/ConfirmationState;

    .line 285
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 150
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Slot;->mName:Ljava/lang/String;

    .line 151
    return-void
.end method

.method public setTraits(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/SlotTrait;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 253
    .local p1, "traits":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/SlotTrait;>;"
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Slot;->mTraits:Ljava/util/List;

    .line 254
    return-void
.end method

.method public setValue(Lcom/amazon/dee/result/bif/Entity;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/dee/result/bif/Entity;

    .prologue
    .line 171
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Slot;->mValue:Lcom/amazon/dee/result/bif/Entity;

    .line 172
    return-void
.end method
