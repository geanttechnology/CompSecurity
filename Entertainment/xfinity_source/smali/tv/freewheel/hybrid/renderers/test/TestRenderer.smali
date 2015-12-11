.class public Ltv/freewheel/hybrid/renderers/test/TestRenderer;
.super Ljava/lang/Object;
.source "TestRenderer.java"

# interfaces
.implements Ltv/freewheel/hybrid/renderers/interfaces/IRenderer;


# instance fields
.field private autoLoad:Z

.field private autoPlay:Z

.field private autoStop:Z

.field private canStop:Z

.field private constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

.field private loadPendingFail:Z

.field protected logger:Ltv/freewheel/hybrid/utils/Logger;

.field private playFail:Z

.field private playingFail:Z

.field private rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

.field private stopPendingFail:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoStop:Z

    .line 17
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoLoad:Z

    .line 18
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoPlay:Z

    .line 19
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->loadPendingFail:Z

    .line 20
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->playingFail:Z

    .line 21
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->playFail:Z

    .line 22
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->stopPendingFail:Z

    .line 23
    iput-boolean v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->canStop:Z

    .line 26
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 27
    return-void
.end method

.method private fail()V
    .locals 4

    .prologue
    .line 179
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 180
    .local v0, "info":Landroid/os/Bundle;
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_UNKNOWN()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 181
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 182
    .local v1, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_EXTRA_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 183
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_ERROR()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 184
    return-void
.end method


# virtual methods
.method public dispose()V
    .locals 0

    .prologue
    .line 172
    return-void
.end method

.method public load(Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V
    .locals 6
    .param p1, "rendererContext"    # Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    .prologue
    .line 30
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v4, "init"

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 31
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    .line 32
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-interface {v3}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .line 34
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    const-string v4, "autoStop"

    invoke-interface {v3, v4}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 35
    .local v2, "param":Ljava/lang/Object;
    if-eqz v2, :cond_0

    .line 37
    :try_start_0
    move-object v0, v2

    check-cast v0, Ljava/lang/Boolean;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoStop:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 42
    .end local v2    # "param":Ljava/lang/Object;
    :cond_0
    :goto_0
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "autoStop is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoStop:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 44
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    const-string v4, "autoLoad"

    invoke-interface {v3, v4}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 45
    .restart local v2    # "param":Ljava/lang/Object;
    if-eqz v2, :cond_1

    .line 47
    :try_start_1
    move-object v0, v2

    check-cast v0, Ljava/lang/Boolean;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoLoad:Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 52
    .end local v2    # "param":Ljava/lang/Object;
    :cond_1
    :goto_1
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "autoLoad is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoLoad:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 54
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    const-string v4, "autoPlay"

    invoke-interface {v3, v4}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 55
    .restart local v2    # "param":Ljava/lang/Object;
    if-eqz v2, :cond_2

    .line 57
    :try_start_2
    move-object v0, v2

    check-cast v0, Ljava/lang/Boolean;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoPlay:Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 62
    .end local v2    # "param":Ljava/lang/Object;
    :cond_2
    :goto_2
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "autoPlay is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoPlay:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 64
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    const-string v4, "loadPendingFail"

    invoke-interface {v3, v4}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 65
    .restart local v2    # "param":Ljava/lang/Object;
    if-eqz v2, :cond_3

    .line 67
    :try_start_3
    move-object v0, v2

    check-cast v0, Ljava/lang/Boolean;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->loadPendingFail:Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 72
    .end local v2    # "param":Ljava/lang/Object;
    :cond_3
    :goto_3
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "loadPendingFail is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->loadPendingFail:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 74
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    const-string v4, "playingFail"

    invoke-interface {v3, v4}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 75
    .restart local v2    # "param":Ljava/lang/Object;
    if-eqz v2, :cond_4

    .line 77
    :try_start_4
    move-object v0, v2

    check-cast v0, Ljava/lang/Boolean;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->playingFail:Z
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    .line 82
    .end local v2    # "param":Ljava/lang/Object;
    :cond_4
    :goto_4
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "playingFail is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->playingFail:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 84
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    const-string v4, "playFail"

    invoke-interface {v3, v4}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 85
    .restart local v2    # "param":Ljava/lang/Object;
    if-eqz v2, :cond_5

    .line 87
    :try_start_5
    move-object v0, v2

    check-cast v0, Ljava/lang/Boolean;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->playFail:Z
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_5

    .line 92
    .end local v2    # "param":Ljava/lang/Object;
    :cond_5
    :goto_5
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "playFail is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->playFail:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 94
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    const-string v4, "canStop"

    invoke-interface {v3, v4}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 95
    .restart local v2    # "param":Ljava/lang/Object;
    if-eqz v2, :cond_6

    .line 97
    :try_start_6
    move-object v0, v2

    check-cast v0, Ljava/lang/Boolean;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->canStop:Z
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_6

    .line 102
    .end local v2    # "param":Ljava/lang/Object;
    :cond_6
    :goto_6
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "canStop is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->canStop:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 104
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    const-string v4, "stopPendingFail"

    invoke-interface {v3, v4}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 105
    .restart local v2    # "param":Ljava/lang/Object;
    if-eqz v2, :cond_7

    .line 107
    :try_start_7
    move-object v0, v2

    check-cast v0, Ljava/lang/Boolean;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->stopPendingFail:Z
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_7

    .line 112
    .end local v2    # "param":Ljava/lang/Object;
    :cond_7
    :goto_7
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "stopPendingFail is "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->stopPendingFail:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 114
    iget-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->loadPendingFail:Z

    if-eqz v3, :cond_9

    .line 115
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->fail()V

    .line 122
    :cond_8
    :goto_8
    return-void

    .line 38
    .restart local v2    # "param":Ljava/lang/Object;
    :catch_0
    move-exception v1

    .line 39
    .local v1, "e":Ljava/lang/Exception;
    check-cast v2, Ljava/lang/String;

    .end local v2    # "param":Ljava/lang/Object;
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoStop:Z

    goto/16 :goto_0

    .line 48
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "param":Ljava/lang/Object;
    :catch_1
    move-exception v1

    .line 49
    .restart local v1    # "e":Ljava/lang/Exception;
    check-cast v2, Ljava/lang/String;

    .end local v2    # "param":Ljava/lang/Object;
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoLoad:Z

    goto/16 :goto_1

    .line 58
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "param":Ljava/lang/Object;
    :catch_2
    move-exception v1

    .line 59
    .restart local v1    # "e":Ljava/lang/Exception;
    check-cast v2, Ljava/lang/String;

    .end local v2    # "param":Ljava/lang/Object;
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoPlay:Z

    goto/16 :goto_2

    .line 68
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "param":Ljava/lang/Object;
    :catch_3
    move-exception v1

    .line 69
    .restart local v1    # "e":Ljava/lang/Exception;
    check-cast v2, Ljava/lang/String;

    .end local v2    # "param":Ljava/lang/Object;
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->loadPendingFail:Z

    goto/16 :goto_3

    .line 78
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "param":Ljava/lang/Object;
    :catch_4
    move-exception v1

    .line 79
    .restart local v1    # "e":Ljava/lang/Exception;
    check-cast v2, Ljava/lang/String;

    .end local v2    # "param":Ljava/lang/Object;
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->playingFail:Z

    goto/16 :goto_4

    .line 88
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "param":Ljava/lang/Object;
    :catch_5
    move-exception v1

    .line 89
    .restart local v1    # "e":Ljava/lang/Exception;
    check-cast v2, Ljava/lang/String;

    .end local v2    # "param":Ljava/lang/Object;
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->playFail:Z

    goto/16 :goto_5

    .line 98
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "param":Ljava/lang/Object;
    :catch_6
    move-exception v1

    .line 99
    .restart local v1    # "e":Ljava/lang/Exception;
    check-cast v2, Ljava/lang/String;

    .end local v2    # "param":Ljava/lang/Object;
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->canStop:Z

    goto/16 :goto_6

    .line 108
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "param":Ljava/lang/Object;
    :catch_7
    move-exception v1

    .line 109
    .restart local v1    # "e":Ljava/lang/Exception;
    check-cast v2, Ljava/lang/String;

    .end local v2    # "param":Ljava/lang/Object;
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    iput-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->stopPendingFail:Z

    goto/16 :goto_7

    .line 119
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_9
    iget-boolean v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoLoad:Z

    if-eqz v3, :cond_8

    .line 120
    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v4, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_LOADED()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    goto/16 :goto_8
.end method

.method public resize()V
    .locals 0

    .prologue
    .line 201
    return-void
.end method

.method public start()V
    .locals 4

    .prologue
    .line 125
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v2, "start"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 127
    iget-boolean v1, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->playingFail:Z

    if-eqz v1, :cond_1

    .line 128
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->fail()V

    .line 149
    :cond_0
    :goto_0
    return-void

    .line 132
    :cond_1
    iget-boolean v1, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoPlay:Z

    if-eqz v1, :cond_2

    .line 133
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STARTED()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    .line 134
    iget-boolean v1, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->playFail:Z

    if-eqz v1, :cond_2

    .line 135
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->fail()V

    goto :goto_0

    .line 140
    :cond_2
    iget-boolean v1, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->autoStop:Z

    if-eqz v1, :cond_0

    .line 142
    const-wide/16 v2, 0xbb8

    :try_start_0
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 147
    :goto_1
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    goto :goto_0

    .line 143
    :catch_0
    move-exception v0

    .line 144
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_1
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 160
    iget-boolean v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->stopPendingFail:Z

    if-eqz v0, :cond_1

    .line 161
    invoke-direct {p0}, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->fail()V

    .line 168
    :cond_0
    :goto_0
    return-void

    .line 165
    :cond_1
    iget-boolean v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->canStop:Z

    if-eqz v0, :cond_0

    .line 166
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->rendererContext:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/test/TestRenderer;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->dispatchEvent(Ljava/lang/String;)V

    goto :goto_0
.end method
