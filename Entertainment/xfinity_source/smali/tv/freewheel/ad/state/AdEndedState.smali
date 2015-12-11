.class public Ltv/freewheel/ad/state/AdEndedState;
.super Ltv/freewheel/ad/state/AdState;
.source "AdEndedState.java"


# static fields
.field private static final instance:Ltv/freewheel/ad/state/AdEndedState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/ad/state/AdEndedState;

    invoke-direct {v0}, Ltv/freewheel/ad/state/AdEndedState;-><init>()V

    sput-object v0, Ltv/freewheel/ad/state/AdEndedState;->instance:Ltv/freewheel/ad/state/AdEndedState;

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
    sget-object v0, Ltv/freewheel/ad/state/AdEndedState;->instance:Ltv/freewheel/ad/state/AdEndedState;

    return-object v0
.end method


# virtual methods
.method public fail(Ltv/freewheel/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 23
    iget-object v0, p0, Ltv/freewheel/ad/state/AdEndedState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "fail"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 24
    invoke-static {}, Ltv/freewheel/ad/state/AdFailedState;->Instance()Ltv/freewheel/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    .line 25
    return-void
.end method

.method public load(Ltv/freewheel/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 13
    iget-object v0, p0, Ltv/freewheel/ad/state/AdEndedState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "load"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 14
    invoke-static {}, Ltv/freewheel/ad/state/AdLoadingState;->Instance()Ltv/freewheel/ad/state/AdState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/ad/AdInstance;->state:Ltv/freewheel/ad/state/AdState;

    .line 15
    invoke-virtual {p1}, Ltv/freewheel/ad/AdInstance;->loadRenderer()V

    .line 16
    return-void
.end method

.method public play(Ltv/freewheel/ad/AdInstance;)V
    .locals 0
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 19
    invoke-virtual {p0, p1}, Ltv/freewheel/ad/state/AdEndedState;->load(Ltv/freewheel/ad/AdInstance;)V

    .line 20
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    const-string v0, "AdEndedState"

    return-object v0
.end method
