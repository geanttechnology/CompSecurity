.class public Ltv/freewheel/ad/state/SlotPlayingState;
.super Ltv/freewheel/ad/state/SlotState;
.source "SlotPlayingState.java"


# static fields
.field private static final instance:Ltv/freewheel/ad/state/SlotPlayingState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/ad/state/SlotPlayingState;

    invoke-direct {v0}, Ltv/freewheel/ad/state/SlotPlayingState;-><init>()V

    sput-object v0, Ltv/freewheel/ad/state/SlotPlayingState;->instance:Ltv/freewheel/ad/state/SlotPlayingState;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ltv/freewheel/ad/state/SlotState;-><init>()V

    return-void
.end method

.method public static Instance()Ltv/freewheel/ad/state/SlotState;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Ltv/freewheel/ad/state/SlotPlayingState;->instance:Ltv/freewheel/ad/state/SlotPlayingState;

    return-object v0
.end method


# virtual methods
.method public complete(Ltv/freewheel/ad/slot/Slot;)V
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/ad/slot/Slot;

    .prologue
    .line 26
    iget-object v0, p0, Ltv/freewheel/ad/state/SlotPlayingState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "complete"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 27
    invoke-static {}, Ltv/freewheel/ad/state/SlotEndedState;->Instance()Ltv/freewheel/ad/state/SlotState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    .line 28
    invoke-virtual {p1}, Ltv/freewheel/ad/slot/Slot;->onComplete()V

    .line 29
    return-void
.end method

.method public stop(Ltv/freewheel/ad/slot/Slot;)V
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/ad/slot/Slot;

    .prologue
    .line 19
    iget-object v0, p0, Ltv/freewheel/ad/state/SlotPlayingState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 20
    invoke-static {}, Ltv/freewheel/ad/state/SlotEndedState;->Instance()Ltv/freewheel/ad/state/SlotState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/ad/slot/Slot;->state:Ltv/freewheel/ad/state/SlotState;

    .line 21
    invoke-virtual {p1}, Ltv/freewheel/ad/slot/Slot;->onStopPlay()V

    .line 22
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    const-string v0, "SlotPlayingState"

    return-object v0
.end method
