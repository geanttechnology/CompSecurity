.class public Ltv/freewheel/hybrid/ad/VideoAsset;
.super Ltv/freewheel/hybrid/ad/EventCallbackHolder;
.source "VideoAsset.java"


# instance fields
.field public callbackHandler:Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

.field public state:Ltv/freewheel/hybrid/ad/state/VideoState;

.field public timer:Ltv/freewheel/hybrid/utils/RecordTimer;


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/EventCallbackHolder;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 21
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/VideoInitState;->Instance()Ltv/freewheel/hybrid/ad/state/VideoState;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->state:Ltv/freewheel/hybrid/ad/state/VideoState;

    .line 22
    return-void
.end method


# virtual methods
.method public isReadyToStart()Z
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->callbackHandler:Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    if-nez v0, :cond_1

    .line 130
    new-instance v0, Ltv/freewheel/hybrid/utils/RecordTimer;

    invoke-direct {v0}, Ltv/freewheel/hybrid/utils/RecordTimer;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->timer:Ltv/freewheel/hybrid/utils/RecordTimer;

    .line 131
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdRequest;->hasSetVideoAssetId()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 132
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v0, v0, Ltv/freewheel/hybrid/ad/AdContext;->adRequest:Ltv/freewheel/hybrid/ad/AdRequest;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/AdRequest;->requestVideoView()V

    .line 134
    :cond_0
    const/4 v0, 0x0

    .line 137
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onResumePlay()V
    .locals 2

    .prologue
    .line 111
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "onResumePlay"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 112
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->callbackHandler:Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    if-nez v0, :cond_0

    .line 113
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->timer:Ltv/freewheel/hybrid/utils/RecordTimer;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/utils/RecordTimer;->resume()V

    .line 117
    :goto_0
    return-void

    .line 115
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->callbackHandler:Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->resume()V

    goto :goto_0
.end method

.method public onStartPlay()V
    .locals 4

    .prologue
    .line 120
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "onStartPlay"

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 121
    const-wide/16 v0, 0x0

    .line 122
    .local v0, "delay":J
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->timer:Ltv/freewheel/hybrid/utils/RecordTimer;

    if-eqz v2, :cond_0

    .line 123
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->timer:Ltv/freewheel/hybrid/utils/RecordTimer;

    invoke-virtual {v2}, Ltv/freewheel/hybrid/utils/RecordTimer;->tick()J

    move-result-wide v0

    .line 125
    :cond_0
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->callbackHandler:Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    invoke-virtual {v2, v0, v1}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->start(J)V

    .line 126
    return-void
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 8
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    .line 50
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 52
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_3

    .line 53
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 54
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    if-ne v4, v7, :cond_0

    .line 55
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 56
    .local v3, "name":Ljava/lang/String;
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "parse(), name: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 58
    const-string v4, "adSlots"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 59
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->context:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdContext;->capabilities:Ltv/freewheel/hybrid/ad/Capabilities;

    const-string v5, "skipsAdSelection"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/ad/Capabilities;->getCapability(Ljava/lang/String;)I

    move-result v4

    if-ne v4, v7, :cond_0

    .line 60
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/ad/VideoAsset;->parseTemporalAdSlots(Lorg/w3c/dom/Element;)V

    .line 52
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 62
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    .restart local v3    # "name":Ljava/lang/String;
    :cond_1
    const-string v4, "eventCallbacks"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 63
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/ad/VideoAsset;->parseEventCallbacks(Lorg/w3c/dom/Element;)V

    .line 64
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->callbackHandler:Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    if-nez v4, :cond_0

    .line 65
    const-string v4, "videoView"

    const-string v5, "IMPRESSION"

    const/4 v6, 0x0

    invoke-virtual {p0, v4, v5, v6}, Ltv/freewheel/hybrid/ad/VideoAsset;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;

    move-result-object v4

    check-cast v4, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->callbackHandler:Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    goto :goto_1

    .line 71
    .restart local v1    # "childNode":Lorg/w3c/dom/Node;
    :cond_2
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "ignore node: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 75
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    .end local v3    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method public parseTemporalAdSlots(Lorg/w3c/dom/Element;)V
    .locals 11
    .param p1, "node"    # Lorg/w3c/dom/Element;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
        }
    .end annotation

    .prologue
    .line 25
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 27
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v8

    if-ge v4, v8, :cond_3

    .line 28
    invoke-interface {v1, v4}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 29
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v8

    const/4 v9, 0x1

    if-ne v8, v9, :cond_0

    .line 30
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v5

    .line 31
    .local v5, "name":Ljava/lang/String;
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "parseTemporalAdSlots(), name: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 32
    const-string v8, "temporalAdSlot"

    invoke-virtual {v5, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    move-object v0, v2

    .line 33
    check-cast v0, Lorg/w3c/dom/Element;

    .line 34
    .local v0, "childElement":Lorg/w3c/dom/Element;
    const-string v8, "customId"

    invoke-interface {v0, v8}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 35
    .local v3, "customId":Ljava/lang/String;
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "adding new TemporalSlot:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " to collection:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/VideoAsset;->getAdResponse()Ltv/freewheel/hybrid/ad/AdResponse;

    move-result-object v10

    iget-object v10, v10, Ltv/freewheel/hybrid/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v10}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ", context: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-virtual {v10}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 38
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/VideoAsset;->getAdRequest()Ltv/freewheel/hybrid/ad/AdRequest;

    move-result-object v8

    invoke-virtual {v8, v3}, Ltv/freewheel/hybrid/ad/AdRequest;->getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/slot/Slot;

    move-result-object v6

    check-cast v6, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;

    .line 39
    .local v6, "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    if-eqz v6, :cond_1

    invoke-virtual {v6}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->copy()Ltv/freewheel/hybrid/ad/slot/TemporalSlot;

    move-result-object v6

    move-object v7, v6

    .line 40
    .end local v6    # "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    .local v7, "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    :goto_1
    invoke-virtual {v7, v0}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;->parse(Lorg/w3c/dom/Element;)V

    .line 41
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/VideoAsset;->getAdResponse()Ltv/freewheel/hybrid/ad/AdResponse;

    move-result-object v8

    iget-object v8, v8, Ltv/freewheel/hybrid/ad/AdResponse;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v8, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 27
    .end local v0    # "childElement":Lorg/w3c/dom/Element;
    .end local v3    # "customId":Ljava/lang/String;
    .end local v5    # "name":Ljava/lang/String;
    .end local v7    # "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    :cond_0
    :goto_2
    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_0

    .line 39
    .restart local v0    # "childElement":Lorg/w3c/dom/Element;
    .restart local v3    # "customId":Ljava/lang/String;
    .restart local v5    # "name":Ljava/lang/String;
    .restart local v6    # "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    :cond_1
    new-instance v7, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;

    iget-object v8, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->context:Ltv/freewheel/hybrid/ad/AdContext;

    const/4 v9, 0x0

    invoke-direct {v7, v8, v9}, Ltv/freewheel/hybrid/ad/slot/TemporalSlot;-><init>(Ltv/freewheel/hybrid/ad/AdContext;I)V

    goto :goto_1

    .line 43
    .end local v0    # "childElement":Lorg/w3c/dom/Element;
    .end local v3    # "customId":Ljava/lang/String;
    .end local v6    # "slot":Ltv/freewheel/hybrid/ad/slot/TemporalSlot;
    :cond_2
    iget-object v8, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "ignore node: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_2

    .line 47
    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    .end local v5    # "name":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method public play()V
    .locals 2

    .prologue
    .line 78
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "play"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 79
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/VideoAsset;->state:Ltv/freewheel/hybrid/ad/state/VideoState;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/ad/state/VideoState;->play(Ltv/freewheel/hybrid/ad/VideoAsset;)V

    .line 80
    return-void
.end method
