.class public Ltv/freewheel/hybrid/ad/state/AdLoadedState;
.super Ltv/freewheel/hybrid/ad/state/AdState;
.source "AdLoadedState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/AdLoadedState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/AdLoadedState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/AdLoadedState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/AdLoadedState;->instance:Ltv/freewheel/hybrid/ad/state/AdLoadedState;

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
    sget-object v0, Ltv/freewheel/hybrid/ad/state/AdLoadedState;->instance:Ltv/freewheel/hybrid/ad/state/AdLoadedState;

    return-object v0
.end method


# virtual methods
.method public fail(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 25
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdLoadedState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "fail"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 26
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdFailedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 27
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->notifyAdDone(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 28
    return-void
.end method

.method public play(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 13
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdLoadedState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "play"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 14
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdPlayingState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 15
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/AdInstance;->onStartPlay()V

    .line 16
    return-void
.end method

.method public stop(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 19
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdLoadedState;->logger:Ltv/freewheel/hybrid/utils/Logger;

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
    .line 31
    const-string v0, "AdLoadedState"

    return-object v0
.end method
