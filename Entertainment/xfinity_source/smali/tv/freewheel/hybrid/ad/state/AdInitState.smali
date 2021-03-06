.class public Ltv/freewheel/hybrid/ad/state/AdInitState;
.super Ltv/freewheel/hybrid/ad/state/AdState;
.source "AdInitState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/AdInitState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/AdInitState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/AdInitState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/AdInitState;->instance:Ltv/freewheel/hybrid/ad/state/AdInitState;

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
    sget-object v0, Ltv/freewheel/hybrid/ad/state/AdInitState;->instance:Ltv/freewheel/hybrid/ad/state/AdInitState;

    return-object v0
.end method


# virtual methods
.method public fail(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 28
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdInitState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "fail"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 29
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdFailedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 30
    return-void
.end method

.method public load(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 13
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdInitState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "load"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 14
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdLoadingState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 15
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/AdInstance;->loadRenderer()V

    .line 16
    return-void
.end method

.method public play(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 0
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 19
    invoke-virtual {p0, p1}, Ltv/freewheel/hybrid/ad/state/AdInitState;->load(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 20
    return-void
.end method

.method public stop(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 23
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/AdInitState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 24
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/AdEndedState;->Instance()Ltv/freewheel/hybrid/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    .line 25
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    const-string v0, "AdInitState"

    return-object v0
.end method
