.class public Ltv/freewheel/ad/state/RendererStartedState;
.super Ltv/freewheel/ad/state/RendererState;
.source "RendererStartedState.java"


# static fields
.field private static final instance:Ltv/freewheel/ad/state/RendererStartedState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 7
    new-instance v0, Ltv/freewheel/ad/state/RendererStartedState;

    invoke-direct {v0}, Ltv/freewheel/ad/state/RendererStartedState;-><init>()V

    sput-object v0, Ltv/freewheel/ad/state/RendererStartedState;->instance:Ltv/freewheel/ad/state/RendererStartedState;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ltv/freewheel/ad/state/RendererState;-><init>()V

    return-void
.end method

.method public static Instance()Ltv/freewheel/ad/state/RendererState;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Ltv/freewheel/ad/state/RendererStartedState;->instance:Ltv/freewheel/ad/state/RendererStartedState;

    return-object v0
.end method


# virtual methods
.method public fail(Ltv/freewheel/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 36
    iget-object v0, p0, Ltv/freewheel/ad/state/RendererStartedState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "fail"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 37
    invoke-static {}, Ltv/freewheel/ad/state/RendererFailedState;->Instance()Ltv/freewheel/ad/state/RendererState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    .line 38
    iget-object v0, p1, Ltv/freewheel/ad/AdInstance;->renderer:Ltv/freewheel/renderers/interfaces/IRenderer;

    invoke-interface {v0}, Ltv/freewheel/renderers/interfaces/IRenderer;->dispose()V

    .line 39
    const/4 v0, 0x0

    iput-object v0, p1, Ltv/freewheel/ad/AdInstance;->renderer:Ltv/freewheel/renderers/interfaces/IRenderer;

    .line 40
    return-void
.end method

.method public notifyStopped(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;
    .param p2, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 23
    invoke-static {}, Ltv/freewheel/ad/state/RendererStopPendingState;->Instance()Ltv/freewheel/ad/state/RendererState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    .line 24
    iget-object v0, p1, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    invoke-virtual {v0, p1, p2}, Ltv/freewheel/ad/state/RendererState;->notifyStopped(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 25
    return-void
.end method

.method public stop(Ltv/freewheel/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 29
    iget-object v0, p0, Ltv/freewheel/ad/state/RendererStartedState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 30
    invoke-static {}, Ltv/freewheel/ad/state/RendererStopPendingState;->Instance()Ltv/freewheel/ad/state/RendererState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/ad/AdInstance;->rendererState:Ltv/freewheel/ad/state/RendererState;

    .line 31
    iget-object v0, p1, Ltv/freewheel/ad/AdInstance;->renderer:Ltv/freewheel/renderers/interfaces/IRenderer;

    invoke-interface {v0}, Ltv/freewheel/renderers/interfaces/IRenderer;->stop()V

    .line 32
    return-void
.end method
