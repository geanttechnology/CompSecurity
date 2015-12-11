.class public Ltv/freewheel/ad/state/AdLoadingState;
.super Ltv/freewheel/ad/state/AdState;
.source "AdLoadingState.java"


# static fields
.field private static final instance:Ltv/freewheel/ad/state/AdLoadingState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/ad/state/AdLoadingState;

    invoke-direct {v0}, Ltv/freewheel/ad/state/AdLoadingState;-><init>()V

    sput-object v0, Ltv/freewheel/ad/state/AdLoadingState;->instance:Ltv/freewheel/ad/state/AdLoadingState;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ltv/freewheel/ad/state/AdState;-><init>()V

    return-void
.end method

.method public static Instance()Ltv/freewheel/ad/state/AdState;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Ltv/freewheel/ad/state/AdLoadingState;->instance:Ltv/freewheel/ad/state/AdLoadingState;

    return-object v0
.end method


# virtual methods
.method public fail(Ltv/freewheel/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 22
    iget-object v0, p0, Ltv/freewheel/ad/state/AdLoadingState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "fail"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 23
    const/4 v0, 0x0

    iput-boolean v0, p1, Ltv/freewheel/ad/AdInstance;->pauseWhenLoading:Z

    .line 24
    invoke-static {}, Ltv/freewheel/ad/state/AdFailedState;->Instance()Ltv/freewheel/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    .line 25
    iget-object v0, p1, Ltv/freewheel/ad/AdInstance;->slot:Ltv/freewheel/ad/slot/Slot;

    invoke-virtual {v0, p1}, Ltv/freewheel/ad/slot/Slot;->notifyAdDone(Ltv/freewheel/ad/AdInstance;)V

    .line 26
    return-void
.end method

.method public notifyAdLoaded(Ltv/freewheel/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 13
    iget-object v0, p0, Ltv/freewheel/ad/state/AdLoadingState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "notifyAdLoaded"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 14
    invoke-static {}, Ltv/freewheel/ad/state/AdLoadedState;->Instance()Ltv/freewheel/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    .line 15
    return-void
.end method

.method public notifyRendererModuleLoaded(Ltv/freewheel/ad/AdInstance;)V
    .locals 0
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 18
    invoke-virtual {p1}, Ltv/freewheel/ad/AdInstance;->onRendererModuleLoaded()V

    .line 19
    return-void
.end method

.method public stop(Ltv/freewheel/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/ad/state/AdLoadingState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 35
    const/4 v0, 0x0

    iput-boolean v0, p1, Ltv/freewheel/ad/AdInstance;->pauseWhenLoading:Z

    .line 36
    invoke-static {}, Ltv/freewheel/ad/state/AdEndPendingState;->Instance()Ltv/freewheel/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    .line 37
    invoke-virtual {p1}, Ltv/freewheel/ad/AdInstance;->onStopPlay()V

    .line 38
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    const-string v0, "AdLoadingState"

    return-object v0
.end method
