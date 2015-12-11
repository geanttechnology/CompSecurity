.class public Ltv/freewheel/hybrid/ad/state/RendererInitState;
.super Ltv/freewheel/hybrid/ad/state/RendererState;
.source "RendererInitState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/RendererInitState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/RendererInitState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/RendererInitState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/RendererInitState;->instance:Ltv/freewheel/hybrid/ad/state/RendererInitState;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/state/RendererState;-><init>()V

    return-void
.end method

.method public static Instance()Ltv/freewheel/hybrid/ad/state/RendererState;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Ltv/freewheel/hybrid/ad/state/RendererInitState;->instance:Ltv/freewheel/hybrid/ad/state/RendererInitState;

    return-object v0
.end method


# virtual methods
.method public fail(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 20
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/RendererInitState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "fail"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 21
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/RendererFailedState;->Instance()Ltv/freewheel/hybrid/ad/state/RendererState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    .line 22
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    invoke-interface {v0}, Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;->dispose()V

    .line 23
    const/4 v0, 0x0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    .line 24
    return-void
.end method

.method public load(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 13
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/RendererInitState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "load"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 14
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/RendererLoadPendingState;->Instance()Ltv/freewheel/hybrid/ad/state/RendererState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->rendererState:Ltv/freewheel/hybrid/ad/state/RendererState;

    .line 15
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    invoke-interface {v0, p1}, Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;->load(Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V

    .line 16
    return-void
.end method
