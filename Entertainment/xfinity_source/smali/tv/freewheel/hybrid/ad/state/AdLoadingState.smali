.class public Ltv/freewheel/hybrid/ad/state/AdLoadingState;
.super Ltv/freewheel/hybrid/ad/state/AdState;
.source "AdLoadingState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/AdLoadingState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/AdLoadingState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/AdLoadingState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/AdLoadingState;->instance:Ltv/freewheel/hybrid/ad/state/AdLoadingState;

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
    sget-object v0, Ltv/freewheel/hybrid/ad/state/AdLoadingState;->instance:Ltv/freewheel/hybrid/ad/state/AdLoadingState;

    return-object v0
.end method


# virtual methods
.method public fail(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 22
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdLoadingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "fail"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 23
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdFailedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 24
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v0, p1}, Ltv/freewheel/hybrid/ad/slot/Slot;->notifyAdDone(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 25
    return-void
.end method

.method public notifyAdLoaded(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 13
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdLoadingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "notifyAdLoaded"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 14
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdLoadedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 15
    return-void
.end method

.method public notifyRendererModuleLoaded(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 0
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 18
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/AdInstance;->onRendererModuleLoaded()V

    .line 19
    return-void
.end method

.method public stop(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 28
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdLoadingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 29
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdEndPendingState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 30
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/AdInstance;->onStopPlay()V

    .line 31
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    const-string v0, "AdLoadingState"

    return-object v0
.end method
