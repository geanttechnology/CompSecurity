.class public Ltv/freewheel/hybrid/ad/state/AdPlayingState;
.super Ltv/freewheel/hybrid/ad/state/AdState;
.source "AdPlayingState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/AdPlayingState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/AdPlayingState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/AdPlayingState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/AdPlayingState;->instance:Ltv/freewheel/hybrid/ad/state/AdPlayingState;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/state/AdState;-><init>()V

    return-void
.end method

.method public static Instance()Ltv/freewheel/hybrid/ad/state/AdState;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Ltv/freewheel/hybrid/ad/state/AdPlayingState;->instance:Ltv/freewheel/hybrid/ad/state/AdPlayingState;

    return-object v0
.end method


# virtual methods
.method public complete(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 26
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdPlayingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "complete"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 27
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdEndedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 28
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->notifyAdDone(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 29
    return-void
.end method

.method public fail(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 32
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdPlayingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "fail"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 33
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdFailedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 34
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->notifyAdDone(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 35
    return-void
.end method

.method public stop(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 19
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdPlayingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 20
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdEndPendingState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 21
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/AdInstance;->onStopPlay()V

    .line 22
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    const-string v0, "AdPlayingState"

    return-object v0
.end method
