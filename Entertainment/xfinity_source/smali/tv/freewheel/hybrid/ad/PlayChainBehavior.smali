.class public Ltv/freewheel/hybrid/ad/PlayChainBehavior;
.super Ltv/freewheel/hybrid/ad/ChainBehavior;
.source "PlayChainBehavior.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/ChainBehavior;-><init>()V

    return-void
.end method


# virtual methods
.method public isChainStopper(Ltv/freewheel/hybrid/ad/AdInstance;)Z
    .locals 1
    .param p1, "adInstance"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 19
    iget-boolean v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->imprSent:Z

    return v0
.end method

.method public isDestState(Ltv/freewheel/hybrid/ad/state/AdState;)Z
    .locals 1
    .param p1, "adState"    # Ltv/freewheel/hybrid/ad/state/AdState;

    .prologue
    .line 23
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdEndedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    if-eq p1, v0, :cond_0

    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdFailedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    if-ne p1, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public relatedSlotState()Ltv/freewheel/hybrid/ad/state/SlotState;
    .locals 1

    .prologue
    .line 15
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/SlotPlayingState;->Instance()Ltv/freewheel/hybrid/ad/state/SlotState;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 11
    const-string v0, "PlayChainBehavior"

    return-object v0
.end method
