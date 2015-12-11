.class public Ltv/freewheel/hybrid/ad/state/RendererStartingState;
.super Ltv/freewheel/hybrid/ad/state/RendererState;
.source "RendererStartingState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/RendererStartingState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 7
    new-instance v0, Ltv/freewheel/hybrid/ad/state/RendererStartingState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/RendererStartingState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/RendererStartingState;->instance:Ltv/freewheel/hybrid/ad/state/RendererStartingState;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/state/RendererState;-><init>()V

    return-void
.end method

.method public static Instance()Ltv/freewheel/hybrid/ad/state/RendererState;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Ltv/freewheel/hybrid/ad/state/RendererStartingState;->instance:Ltv/freewheel/hybrid/ad/state/RendererStartingState;

    return-object v0
.end method


# virtual methods
.method public fail(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 41
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/RendererStartingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "fail"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 42
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/RendererFailedState;->Instance()Ltv/freewheel/hybrid/ad/state/RendererState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    .line 43
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    invoke-interface {v0}, Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;->dispose()V

    .line 44
    const/4 v0, 0x0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    .line 45
    return-void
.end method

.method public notifyStarted(Ltv/freewheel/hybrid/ad/AdInstance;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;
    .param p2, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 15
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/RendererStartedState;->Instance()Ltv/freewheel/hybrid/ad/state/RendererState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    .line 16
    invoke-virtual {p1, p2}, Ltv/freewheel/hybrid/ad/AdInstance;->onRendererStarted(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 17
    return-void
.end method

.method public notifyStopped(Ltv/freewheel/hybrid/ad/AdInstance;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;
    .param p2, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 28
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/RendererStopPendingState;->Instance()Ltv/freewheel/hybrid/ad/state/RendererState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    .line 29
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/hybrid/ad/state/RendererState;->notifyStopped(Ltv/freewheel/hybrid/ad/AdInstance;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 30
    return-void
.end method

.method public stop(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/RendererStartingState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 35
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/RendererStopPendingState;->Instance()Ltv/freewheel/hybrid/ad/state/RendererState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    .line 36
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    invoke-interface {v0}, Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;->stop()V

    .line 37
    return-void
.end method
