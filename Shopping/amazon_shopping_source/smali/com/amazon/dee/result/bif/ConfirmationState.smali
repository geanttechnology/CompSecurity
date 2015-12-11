.class public Lcom/amazon/dee/result/bif/ConfirmationState;
.super Ljava/lang/Object;
.source "ConfirmationState.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private mScore:D

.field private mValue:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mScore:D

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mValue:Z

    .line 30
    return-void
.end method

.method public constructor <init>(ZD)V
    .locals 0
    .param p1, "value"    # Z
    .param p2, "score"    # D

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-wide p2, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mScore:D

    .line 43
    iput-boolean p1, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mValue:Z

    .line 44
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 92
    instance-of v2, p1, Lcom/amazon/dee/result/bif/ConfirmationState;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 94
    check-cast v0, Lcom/amazon/dee/result/bif/ConfirmationState;

    .line 95
    .local v0, "other":Lcom/amazon/dee/result/bif/ConfirmationState;
    iget-wide v2, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mScore:D

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    iget-wide v3, v0, Lcom/amazon/dee/result/bif/ConfirmationState;->mScore:D

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-boolean v2, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mValue:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iget-boolean v3, v0, Lcom/amazon/dee/result/bif/ConfirmationState;->mValue:Z

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 100
    .end local v0    # "other":Lcom/amazon/dee/result/bif/ConfirmationState;
    :cond_0
    return v1
.end method

.method public getScore()D
    .locals 2

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mScore:D

    return-wide v0
.end method

.method public getValue()Z
    .locals 1

    .prologue
    .line 85
    iget-boolean v0, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mValue:Z

    return v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .line 107
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-wide v2, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mScore:D

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-boolean v2, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mValue:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public setScore(D)V
    .locals 0
    .param p1, "score"    # D

    .prologue
    .line 54
    iput-wide p1, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mScore:D

    .line 55
    return-void
.end method

.method public setValue(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 65
    iput-boolean p1, p0, Lcom/amazon/dee/result/bif/ConfirmationState;->mValue:Z

    .line 66
    return-void
.end method
