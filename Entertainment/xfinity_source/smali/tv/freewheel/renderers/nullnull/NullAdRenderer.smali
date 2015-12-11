.class public Ltv/freewheel/renderers/nullnull/NullAdRenderer;
.super Ljava/lang/Object;
.source "NullAdRenderer.java"

# interfaces
.implements Ltv/freewheel/renderers/interfaces/IRenderer;


# instance fields
.field private constants:Ltv/freewheel/ad/interfaces/IConstants;

.field protected logger:Ltv/freewheel/utils/Logger;

.field private rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->logger:Ltv/freewheel/utils/Logger;

    .line 18
    return-void
.end method


# virtual methods
.method public dispose()V
    .locals 2

    .prologue
    .line 68
    iget-object v0, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "ignore"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 69
    return-void
.end method

.method public getDuration()D
    .locals 2

    .prologue
    .line 60
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    return-wide v0
.end method

.method public load(Ltv/freewheel/renderers/interfaces/IRendererContext;)V
    .locals 3
    .param p1, "rendererContext"    # Ltv/freewheel/renderers/interfaces/IRendererContext;

    .prologue
    .line 21
    iget-object v0, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "NullAdRenderer init"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 22
    iput-object p1, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    .line 23
    iget-object v0, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    invoke-interface {v0}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    .line 24
    iget-object v0, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_CLICK()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->CAPABILITY_STATUS_OFF()I

    move-result v2

    invoke-interface {v0, v1, v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->setRendererCapability(Ljava/lang/String;I)V

    .line 25
    iget-object v0, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 26
    return-void
.end method

.method public start()V
    .locals 4

    .prologue
    .line 29
    iget-object v1, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v2, "start"

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 30
    iget-object v1, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v2, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_STARTED()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 33
    const-wide/16 v2, 0x1f4

    :try_start_0
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 38
    :goto_0
    iget-object v1, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->rendererContext:Ltv/freewheel/renderers/interfaces/IRendererContext;

    iget-object v2, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->constants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ltv/freewheel/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 39
    return-void

    .line 34
    :catch_0
    move-exception v0

    .line 35
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 50
    iget-object v0, p0, Ltv/freewheel/renderers/nullnull/NullAdRenderer;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "ignore"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 51
    return-void
.end method
