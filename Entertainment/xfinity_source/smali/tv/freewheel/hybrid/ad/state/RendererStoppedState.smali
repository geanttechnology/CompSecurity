.class public Ltv/freewheel/hybrid/ad/state/RendererStoppedState;
.super Ltv/freewheel/hybrid/ad/state/RendererState;
.source "RendererStoppedState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/RendererStoppedState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/RendererStoppedState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/RendererStoppedState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/RendererStoppedState;->instance:Ltv/freewheel/hybrid/ad/state/RendererStoppedState;

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
    sget-object v0, Ltv/freewheel/hybrid/ad/state/RendererStoppedState;->instance:Ltv/freewheel/hybrid/ad/state/RendererStoppedState;

    return-object v0
.end method


# virtual methods
.method public dispose(Ltv/freewheel/hybrid/ad/AdInstance;)V
    .locals 2
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/AdInstance;

    .prologue
    .line 14
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/RendererStoppedState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "dispose"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 15
    iget-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    invoke-interface {v0}, Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;->dispose()V

    .line 16
    const/4 v0, 0x0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/AdInstance;->renderer:Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;

    .line 17
    return-void
.end method
