.class public Ltv/freewheel/ad/state/RendererState;
.super Ljava/lang/Object;
.source "RendererState.java"


# instance fields
.field protected logger:Ltv/freewheel/utils/Logger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/state/RendererState;->logger:Ltv/freewheel/utils/Logger;

    return-void
.end method


# virtual methods
.method public dispose(Ltv/freewheel/ad/AdInstance;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 37
    const-string v0, "dispose"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/state/RendererState;->onErrorAction(Ljava/lang/String;)V

    .line 38
    return-void
.end method

.method public fail(Ltv/freewheel/ad/AdInstance;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 40
    const-string v0, "fail"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/state/RendererState;->onErrorAction(Ljava/lang/String;)V

    .line 41
    return-void
.end method

.method public load(Ltv/freewheel/ad/AdInstance;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 13
    const-string v0, "load"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/state/RendererState;->onErrorAction(Ljava/lang/String;)V

    .line 14
    return-void
.end method

.method public notifyLoaded(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;
    .param p2, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 16
    const-string v0, "notifyLoaded"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/state/RendererState;->onErrorAction(Ljava/lang/String;)V

    .line 17
    return-void
.end method

.method public notifyStarted(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;
    .param p2, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 22
    const-string v0, "notifyStarted"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/state/RendererState;->onErrorAction(Ljava/lang/String;)V

    .line 23
    return-void
.end method

.method public notifyStopped(Ltv/freewheel/ad/AdInstance;Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;
    .param p2, "event"    # Ltv/freewheel/ad/interfaces/IEvent;

    .prologue
    .line 34
    const-string v0, "notifyStopped"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/state/RendererState;->onErrorAction(Ljava/lang/String;)V

    .line 35
    return-void
.end method

.method protected onErrorAction(Ljava/lang/String;)V
    .locals 3
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    .line 10
    iget-object v0, p0, Ltv/freewheel/ad/state/RendererState;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid action "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 11
    return-void
.end method

.method public start(Ltv/freewheel/ad/AdInstance;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 19
    const-string v0, "start"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/state/RendererState;->onErrorAction(Ljava/lang/String;)V

    .line 20
    return-void
.end method

.method public stop(Ltv/freewheel/ad/AdInstance;)V
    .locals 1
    .param p1, "ad"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 31
    const-string v0, "stop"

    invoke-virtual {p0, v0}, Ltv/freewheel/ad/state/RendererState;->onErrorAction(Ljava/lang/String;)V

    .line 32
    return-void
.end method
