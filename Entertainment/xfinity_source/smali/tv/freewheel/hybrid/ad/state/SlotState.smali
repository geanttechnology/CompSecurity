.class public Ltv/freewheel/hybrid/ad/state/SlotState;
.super Ljava/lang/Object;
.source "SlotState.java"


# instance fields
.field protected logger:Ltv/freewheel/hybrid/utils/Logger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/state/SlotState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-void
.end method


# virtual methods
.method public complete(Ltv/freewheel/hybrid/ad/slot/Slot;)V
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/slot/Slot;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/SlotState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "invalid action: complete"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 25
    return-void
.end method

.method public play(Ltv/freewheel/hybrid/ad/slot/Slot;)V
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/slot/Slot;

    .prologue
    .line 12
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/SlotState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "invalid action: play"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 13
    return-void
.end method

.method public resume(Ltv/freewheel/hybrid/ad/slot/Slot;)V
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/slot/Slot;

    .prologue
    .line 18
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/SlotState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "invalid action: resume"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public stop(Ltv/freewheel/hybrid/ad/slot/Slot;)V
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/slot/Slot;

    .prologue
    .line 21
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/SlotState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "invalid action: stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    .line 22
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    const-string v0, "SlotState"

    return-object v0
.end method
