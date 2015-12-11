.class public Ltv/freewheel/hybrid/ad/EventCallbackHolder;
.super Ltv/freewheel/hybrid/ad/AdContextScoped;
.source "EventCallbackHolder.java"


# instance fields
.field public eventCallbacks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/EventCallback;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 26
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/AdContextScoped;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 27
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/EventCallbackHolder;->eventCallbacks:Ljava/util/ArrayList;

    .line 28
    return-void
.end method


# virtual methods
.method public createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .locals 7
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "useGeneric"    # Z

    .prologue
    .line 66
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/EventCallbackHolder;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "createEventHandler("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 67
    const/4 v2, 0x0

    .line 68
    .local v2, "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    invoke-virtual {p0, p1, p2, p3}, Ltv/freewheel/hybrid/ad/EventCallbackHolder;->fetchEventCallback(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/hybrid/ad/EventCallback;

    move-result-object v0

    .line 71
    .local v0, "callback":Ltv/freewheel/hybrid/ad/EventCallback;
    :try_start_0
    const-string v4, "ERROR"

    invoke-virtual {p2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 72
    new-instance v3, Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;

    invoke-direct {v3, v0}, Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V

    .end local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .local v3, "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    move-object v2, v3

    .line 99
    .end local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    :cond_0
    :goto_0
    return-object v2

    .line 73
    :cond_1
    const-string v4, "STANDARD"

    invoke-virtual {p2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 74
    new-instance v3, Ltv/freewheel/hybrid/ad/handler/StandardCallbackHandler;

    invoke-direct {v3, v0}, Ltv/freewheel/hybrid/ad/handler/StandardCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 75
    .end local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    :try_start_1
    const-string v4, "cn"

    invoke-virtual {v3, v4, p1}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/net/MalformedURLException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v2, v3

    .end local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    goto :goto_0

    .line 76
    :cond_2
    :try_start_2
    const-string v4, "CLICK"

    invoke-virtual {p2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    const-string v4, "CLICKTRACKING"

    invoke-virtual {p2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 77
    :cond_3
    new-instance v3, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;

    invoke-direct {v3, v0}, Ltv/freewheel/hybrid/ad/handler/ClickCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V
    :try_end_2
    .catch Ljava/net/MalformedURLException; {:try_start_2 .. :try_end_2} :catch_0

    .line 78
    .end local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    :try_start_3
    const-string v4, "defaultClick"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_9

    if-eqz p3, :cond_9

    .line 79
    const-string v4, "cn"

    invoke-virtual {v3, v4, p1}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    const-string v4, "et"

    invoke-static {p2}, Ltv/freewheel/hybrid/ad/EventCallback;->getShortenedEventType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/net/MalformedURLException; {:try_start_3 .. :try_end_3} :catch_1

    move-object v2, v3

    .end local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    goto :goto_0

    .line 82
    :cond_4
    :try_start_4
    const-string v4, "slotImpression"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 83
    new-instance v3, Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;

    invoke-direct {v3, v0}, Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V

    .end local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    move-object v2, v3

    .end local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    goto :goto_0

    .line 84
    :cond_5
    const-string v4, "defaultImpression"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 85
    new-instance v3, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;

    invoke-direct {v3, v0}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V

    .end local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    move-object v2, v3

    .end local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    goto :goto_0

    .line 86
    :cond_6
    const-string v4, "videoView"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 87
    new-instance v3, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    invoke-direct {v3, v0}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V

    .end local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    move-object v2, v3

    .end local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    goto :goto_0

    .line 88
    :cond_7
    const-string v4, "resellerNoAd"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 89
    new-instance v3, Ltv/freewheel/hybrid/ad/handler/ResellerNoAdCallbackHandler;

    invoke-direct {v3, v0}, Ltv/freewheel/hybrid/ad/handler/ResellerNoAdCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V

    .end local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    move-object v2, v3

    .end local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    goto :goto_0

    .line 90
    :cond_8
    const-string v4, "IMPRESSION"

    invoke-virtual {p2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 91
    new-instance v3, Ltv/freewheel/hybrid/ad/handler/QuartileCallbackHandler;

    invoke-direct {v3, v0}, Ltv/freewheel/hybrid/ad/handler/QuartileCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V
    :try_end_4
    .catch Ljava/net/MalformedURLException; {:try_start_4 .. :try_end_4} :catch_0

    .line 92
    .end local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    :try_start_5
    const-string v4, "cn"

    invoke-virtual {v3, v4, p1}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/net/MalformedURLException; {:try_start_5 .. :try_end_5} :catch_1

    :cond_9
    move-object v2, v3

    .end local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    goto/16 :goto_0

    .line 94
    :catch_0
    move-exception v1

    .line 95
    .local v1, "e":Ljava/net/MalformedURLException;
    :goto_1
    const/4 v2, 0x0

    .line 96
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/EventCallbackHolder;->logger:Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {v1}, Ljava/net/MalformedURLException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->warn(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 94
    .end local v1    # "e":Ljava/net/MalformedURLException;
    .end local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    :catch_1
    move-exception v1

    move-object v2, v3

    .end local v3    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    .restart local v2    # "ret":Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
    goto :goto_1
.end method

.method public fetchEventCallback(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/hybrid/ad/EventCallback;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "useGeneric"    # Z

    .prologue
    .line 48
    const/4 v2, 0x0

    .line 49
    .local v2, "ret":Ltv/freewheel/hybrid/ad/EventCallback;
    const/4 v0, 0x0

    .line 50
    .local v0, "generic":Ltv/freewheel/hybrid/ad/EventCallback;
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/EventCallbackHolder;->eventCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 51
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/EventCallback;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 52
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ltv/freewheel/hybrid/ad/EventCallback;

    .line 53
    .local v3, "temp":Ltv/freewheel/hybrid/ad/EventCallback;
    iget-object v4, v3, Ltv/freewheel/hybrid/ad/EventCallback;->name:Ljava/lang/String;

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    iget-object v4, v3, Ltv/freewheel/hybrid/ad/EventCallback;->type:Ljava/lang/String;

    invoke-virtual {v4, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 54
    move-object v2, v3

    .line 62
    .end local v3    # "temp":Ltv/freewheel/hybrid/ad/EventCallback;
    :cond_1
    if-eqz v2, :cond_3

    .end local v2    # "ret":Ltv/freewheel/hybrid/ad/EventCallback;
    :goto_1
    return-object v2

    .line 57
    .restart local v2    # "ret":Ltv/freewheel/hybrid/ad/EventCallback;
    .restart local v3    # "temp":Ltv/freewheel/hybrid/ad/EventCallback;
    :cond_2
    if-eqz p3, :cond_0

    iget-object v4, v3, Ltv/freewheel/hybrid/ad/EventCallback;->type:Ljava/lang/String;

    const-string v5, "GENERIC"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 59
    move-object v0, v3

    goto :goto_0

    .end local v3    # "temp":Ltv/freewheel/hybrid/ad/EventCallback;
    :cond_3
    move-object v2, v0

    .line 62
    goto :goto_1
.end method

.method public parseEventCallbacks(Lorg/w3c/dom/Element;)V
    .locals 7
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 31
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v1

    .line 32
    .local v1, "childList":Lorg/w3c/dom/NodeList;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v1}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v3, v5, :cond_1

    .line 33
    invoke-interface {v1, v3}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v2

    .line 34
    .local v2, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 35
    invoke-interface {v2}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v4

    .line 36
    .local v4, "name":Ljava/lang/String;
    const-string v5, "eventCallback"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 37
    new-instance v0, Ltv/freewheel/hybrid/ad/EventCallback;

    iget-object v5, p0, Ltv/freewheel/hybrid/ad/EventCallbackHolder;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v0, v5}, Ltv/freewheel/hybrid/ad/EventCallback;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 38
    .local v0, "callback":Ltv/freewheel/hybrid/ad/EventCallback;
    check-cast v2, Lorg/w3c/dom/Element;

    .end local v2    # "childNode":Lorg/w3c/dom/Node;
    invoke-virtual {v0, v2}, Ltv/freewheel/hybrid/ad/EventCallback;->parse(Lorg/w3c/dom/Element;)V

    .line 39
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/EventCallbackHolder;->eventCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 32
    .end local v0    # "callback":Ltv/freewheel/hybrid/ad/EventCallback;
    .end local v4    # "name":Ljava/lang/String;
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 43
    :cond_1
    return-void
.end method
