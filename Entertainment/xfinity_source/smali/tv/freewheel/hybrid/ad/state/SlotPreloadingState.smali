.class public Ltv/freewheel/hybrid/ad/state/SlotPreloadingState;
.super Ltv/freewheel/hybrid/ad/state/SlotState;
.source "SlotPreloadingState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/SlotPreloadingState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/SlotPreloadingState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/SlotPreloadingState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/SlotPreloadingState;->instance:Ltv/freewheel/hybrid/ad/state/SlotPreloadingState;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/state/SlotState;-><init>()V

    return-void
.end method

.method public static Instance()Ltv/freewheel/hybrid/ad/state/SlotState;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Ltv/freewheel/hybrid/ad/state/SlotPreloadingState;->instance:Ltv/freewheel/hybrid/ad/state/SlotPreloadingState;

    return-object v0
.end method


# virtual methods
.method public play(Ltv/freewheel/hybrid/ad/slot/Slot;)V
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/slot/Slot;

    .prologue
    .line 19
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/SlotPreloadingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "play"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 20
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/SlotPlayingState;->Instance()Ltv/freewheel/hybrid/ad/state/SlotState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/slot/Slot;->state:Ltv/freewheel/hybrid/ad/state/SlotState;

    .line 21
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->onStartPlay()V

    .line 22
    return-void
.end method

.method public stop(Ltv/freewheel/hybrid/ad/slot/Slot;)V
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/slot/Slot;

    .prologue
    .line 13
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/SlotPreloadingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 14
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/SlotEndedState;->Instance()Ltv/freewheel/hybrid/ad/state/SlotState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/slot/Slot;->state:Ltv/freewheel/hybrid/ad/state/SlotState;

    .line 15
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->onStopPlay()V

    .line 16
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    const-string v0, "SlotPreloadingState"

    return-object v0
.end method
