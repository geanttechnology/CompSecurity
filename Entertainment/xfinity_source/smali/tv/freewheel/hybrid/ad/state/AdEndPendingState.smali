.class public Ltv/freewheel/hybrid/ad/state/AdEndPendingState;
.super Ltv/freewheel/hybrid/ad/state/AdState;
.source "AdEndPendingState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/AdEndPendingState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/AdEndPendingState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/AdEndPendingState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/AdEndPendingState;->instance:Ltv/freewheel/hybrid/ad/state/AdEndPendingState;

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
    sget-object v0, Ltv/freewheel/hybrid/ad/state/AdEndPendingState;->instance:Ltv/freewheel/hybrid/ad/state/AdEndPendingState;

    return-object v0
.end method


# virtual methods
.method public complete(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 14
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdEndPendingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "complete"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 15
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdEndedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 16
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->notifyAdDone(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 17
    return-void
.end method

.method public fail(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 20
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdEndPendingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "fail"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 21
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdFailedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 22
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->notifyAdDone(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 23
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    const-string v0, "AdEndPendingState"

    return-object v0
.end method
