.class public Ltv/freewheel/ad/CallbackManager;
.super Ljava/lang/Object;
.source "CallbackManager.java"


# instance fields
.field private adInstance:Ltv/freewheel/ad/AdInstance;

.field public defaultClickHandler:Ltv/freewheel/ad/handler/ClickCallbackHandler;

.field public defaultImpressionHandler:Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;

.field public errorHandler:Ltv/freewheel/ad/handler/ErrorCallbackHandler;

.field private handlers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ltv/freewheel/ad/handler/EventCallbackHandler;",
            ">;"
        }
    .end annotation
.end field

.field protected logger:Ltv/freewheel/utils/Logger;

.field private timer:Ltv/freewheel/utils/RecordTimer;


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/AdInstance;)V
    .locals 1
    .param p1, "adInstance"    # Ltv/freewheel/ad/AdInstance;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    .line 30
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/CallbackManager;->handlers:Ljava/util/HashMap;

    .line 31
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/CallbackManager;->logger:Ltv/freewheel/utils/Logger;

    .line 32
    return-void
.end method

.method private getHandlerFromResponse(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;
    .locals 7
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "eventType"    # Ljava/lang/String;

    .prologue
    .line 90
    const/4 v2, 0x0

    .line 91
    .local v2, "ret":Ltv/freewheel/ad/handler/EventCallbackHandler;
    iget-object v3, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    iget-object v3, v3, Ltv/freewheel/ad/AdInstance;->eventCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 93
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/EventCallback;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 94
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/EventCallback;

    .line 96
    .local v0, "evtCbk":Ltv/freewheel/ad/EventCallback;
    iget-object v3, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    invoke-virtual {v3, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 97
    iget-object v3, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    iget-object v5, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    const/4 v6, 0x0

    invoke-virtual {v3, v4, v5, v6}, Ltv/freewheel/ad/AdInstance;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v2

    goto :goto_0

    .line 100
    .end local v0    # "evtCbk":Ltv/freewheel/ad/EventCallback;
    :cond_1
    return-object v2
.end method


# virtual methods
.method public addEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;Ltv/freewheel/ad/handler/EventCallbackHandler;)V
    .locals 4
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "eventType"    # Ljava/lang/String;
    .param p3, "handler"    # Ltv/freewheel/ad/handler/EventCallbackHandler;

    .prologue
    .line 84
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 85
    .local v0, "key":Ljava/lang/String;
    iget-object v1, p0, Ltv/freewheel/ad/CallbackManager;->handlers:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 86
    iget-object v1, p0, Ltv/freewheel/ad/CallbackManager;->handlers:Ljava/util/HashMap;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    :cond_0
    return-void
.end method

.method public callback(Ljava/lang/String;)V
    .locals 1
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 183
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {p0, p1, v0}, Ltv/freewheel/ad/CallbackManager;->callback(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 184
    return-void
.end method

.method public callback(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 5
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "info"    # Landroid/os/Bundle;

    .prologue
    .line 187
    iget-object v2, p0, Ltv/freewheel/ad/CallbackManager;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "callback("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 188
    invoke-static {p1}, Ltv/freewheel/ad/EventCallback;->getEventTypeByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 189
    .local v0, "eventType":Ljava/lang/String;
    const-string v2, "firstQuartile"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, "midPoint"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, "thirdQuartile"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, "complete"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 193
    :cond_0
    invoke-virtual {p0, p1}, Ltv/freewheel/ad/CallbackManager;->sendQuartile(Ljava/lang/String;)V

    .line 206
    :cond_1
    :goto_0
    return-void

    .line 194
    :cond_2
    const-string v2, "resellerNoAd"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 195
    invoke-virtual {p0, p1, v0}, Ltv/freewheel/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/handler/ResellerNoAdCallbackHandler;

    .line 196
    .local v1, "handler":Ltv/freewheel/ad/handler/ResellerNoAdCallbackHandler;
    invoke-virtual {v1}, Ltv/freewheel/ad/handler/ResellerNoAdCallbackHandler;->send()V

    goto :goto_0

    .line 198
    .end local v1    # "handler":Ltv/freewheel/ad/handler/ResellerNoAdCallbackHandler;
    :cond_3
    const-string v2, "STANDARD"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 199
    invoke-virtual {p0, p1, v0}, Ltv/freewheel/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/handler/StandardCallbackHandler;

    .line 200
    .local v1, "handler":Ltv/freewheel/ad/handler/StandardCallbackHandler;
    invoke-virtual {v1}, Ltv/freewheel/ad/handler/StandardCallbackHandler;->send()V

    goto :goto_0

    .line 202
    .end local v1    # "handler":Ltv/freewheel/ad/handler/StandardCallbackHandler;
    :cond_4
    const-string v2, "CLICKTRACKING"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 203
    invoke-virtual {p0, p1, v0}, Ltv/freewheel/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v1

    check-cast v1, Ltv/freewheel/ad/handler/ClickCallbackHandler;

    .line 204
    .local v1, "handler":Ltv/freewheel/ad/handler/ClickCallbackHandler;
    invoke-virtual {v1, p2}, Ltv/freewheel/ad/handler/ClickCallbackHandler;->send(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public copyOtherHandlers(Ltv/freewheel/ad/CallbackManager;)V
    .locals 10
    .param p1, "sourceObj"    # Ltv/freewheel/ad/CallbackManager;

    .prologue
    .line 123
    iget-object v7, p0, Ltv/freewheel/ad/CallbackManager;->logger:Ltv/freewheel/utils/Logger;

    const-string v8, "copyOtherHandlers()"

    invoke-virtual {v7, v8}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 124
    iget-object v7, p1, Ltv/freewheel/ad/CallbackManager;->handlers:Ljava/util/HashMap;

    invoke-virtual {v7}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 125
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 126
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 127
    .local v1, "key":Ljava/lang/String;
    const-string v7, ":"

    invoke-virtual {v1, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 128
    .local v2, "kv":[Ljava/lang/String;
    array-length v7, v2

    const/4 v8, 0x2

    if-eq v7, v8, :cond_0

    .line 129
    iget-object v7, p0, Ltv/freewheel/ad/CallbackManager;->logger:Ltv/freewheel/utils/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "get invalid event callback name-value pair:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 132
    :cond_0
    const/4 v7, 0x0

    aget-object v3, v2, v7

    .line 133
    .local v3, "name":Ljava/lang/String;
    const/4 v7, 0x1

    aget-object v6, v2, v7

    .line 134
    .local v6, "type":Ljava/lang/String;
    invoke-virtual {p0, v3, v6}, Ltv/freewheel/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v4

    .line 135
    .local v4, "newHandler":Ltv/freewheel/ad/handler/EventCallbackHandler;
    iget-object v7, p1, Ltv/freewheel/ad/CallbackManager;->handlers:Ljava/util/HashMap;

    invoke-virtual {v7, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ltv/freewheel/ad/handler/EventCallbackHandler;

    .line 136
    .local v5, "oldHandler":Ltv/freewheel/ad/handler/EventCallbackHandler;
    invoke-virtual {v5}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getExternalTrackingURLs()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v4, v7}, Ltv/freewheel/ad/handler/EventCallbackHandler;->addExternalTrackingURLs(Ljava/util/ArrayList;)V

    .line 137
    const-string v7, "CLICK"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 138
    const-string v7, "cr"

    const-string v8, "cr"

    invoke-virtual {v5, v8}, Ltv/freewheel/ad/handler/EventCallbackHandler;->getUrlParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v7, v8}, Ltv/freewheel/ad/handler/EventCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    :cond_1
    const-string v7, ""

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    const-string v7, "ERROR"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    move-object v7, v4

    .line 141
    check-cast v7, Ltv/freewheel/ad/handler/ErrorCallbackHandler;

    iput-object v7, p0, Ltv/freewheel/ad/CallbackManager;->errorHandler:Ltv/freewheel/ad/handler/ErrorCallbackHandler;

    .line 147
    :cond_2
    :goto_1
    iget-object v7, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v4, v7}, Ltv/freewheel/ad/handler/EventCallbackHandler;->setAdInstance(Ltv/freewheel/ad/AdInstance;)V

    goto :goto_0

    .line 142
    :cond_3
    const-string v7, "defaultImpression"

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    const-string v7, "IMPRESSION"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    move-object v7, v4

    .line 143
    check-cast v7, Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;

    iput-object v7, p0, Ltv/freewheel/ad/CallbackManager;->defaultImpressionHandler:Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;

    goto :goto_1

    .line 144
    :cond_4
    const-string v7, "defaultClick"

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    const-string v7, "CLICK"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    move-object v7, v4

    .line 145
    check-cast v7, Ltv/freewheel/ad/handler/ClickCallbackHandler;

    iput-object v7, p0, Ltv/freewheel/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/ad/handler/ClickCallbackHandler;

    goto :goto_1

    .line 149
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "kv":[Ljava/lang/String;
    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "newHandler":Ltv/freewheel/ad/handler/EventCallbackHandler;
    .end local v5    # "oldHandler":Ltv/freewheel/ad/handler/EventCallbackHandler;
    .end local v6    # "type":Ljava/lang/String;
    :cond_5
    return-void
.end method

.method public getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;
    .locals 5
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "eventType"    # Ljava/lang/String;

    .prologue
    .line 104
    const-string v2, "CLICKTRACKING"

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 105
    const-string p2, "CLICK"

    .line 107
    :cond_0
    iget-object v2, p0, Ltv/freewheel/ad/CallbackManager;->handlers:Ljava/util/HashMap;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/handler/EventCallbackHandler;

    .line 108
    .local v0, "ret":Ltv/freewheel/ad/handler/EventCallbackHandler;
    if-nez v0, :cond_3

    .line 109
    invoke-direct {p0, p1, p2}, Ltv/freewheel/ad/CallbackManager;->getHandlerFromResponse(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v0

    .line 110
    if-nez v0, :cond_2

    .line 111
    const-string v2, "defaultImpression"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    const-string v2, "CLICK"

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    const-string v2, "defaultClick"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    :cond_1
    const/4 v1, 0x1

    .line 112
    .local v1, "useGeneric":Z
    :goto_0
    iget-object v2, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v2, p1, p2, v1}, Ltv/freewheel/ad/AdInstance;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v0

    .line 114
    .end local v1    # "useGeneric":Z
    :cond_2
    if-eqz v0, :cond_3

    .line 115
    iget-object v2, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v0, v2}, Ltv/freewheel/ad/handler/EventCallbackHandler;->setAdInstance(Ltv/freewheel/ad/AdInstance;)V

    .line 116
    invoke-virtual {p0, p1, p2, v0}, Ltv/freewheel/ad/CallbackManager;->addEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;Ltv/freewheel/ad/handler/EventCallbackHandler;)V

    .line 119
    :cond_3
    return-object v0

    .line 111
    :cond_4
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public init()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 35
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    const-string v5, ""

    const-string v6, "ERROR"

    const/4 v7, 0x1

    invoke-virtual {v4, v5, v6, v7}, Ltv/freewheel/ad/AdInstance;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v4

    check-cast v4, Ltv/freewheel/ad/handler/ErrorCallbackHandler;

    iput-object v4, p0, Ltv/freewheel/ad/CallbackManager;->errorHandler:Ltv/freewheel/ad/handler/ErrorCallbackHandler;

    .line 37
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->errorHandler:Ltv/freewheel/ad/handler/ErrorCallbackHandler;

    iget-object v5, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v4, v5}, Ltv/freewheel/ad/handler/ErrorCallbackHandler;->setAdInstance(Ltv/freewheel/ad/AdInstance;)V

    .line 38
    const-string v4, ""

    const-string v5, "ERROR"

    iget-object v6, p0, Ltv/freewheel/ad/CallbackManager;->errorHandler:Ltv/freewheel/ad/handler/ErrorCallbackHandler;

    invoke-virtual {p0, v4, v5, v6}, Ltv/freewheel/ad/CallbackManager;->addEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;Ltv/freewheel/ad/handler/EventCallbackHandler;)V

    .line 40
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    iget-object v4, v4, Ltv/freewheel/ad/AdInstance;->eventCallbacks:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 42
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/EventCallback;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 43
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/EventCallback;

    .line 45
    .local v0, "evtCbk":Ltv/freewheel/ad/EventCallback;
    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    const-string v5, "defaultImpression"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    const-string v5, "IMPRESSION"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 46
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    iget-object v5, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    iget-object v6, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    invoke-virtual {v4, v5, v6, v8}, Ltv/freewheel/ad/AdInstance;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v4

    check-cast v4, Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;

    iput-object v4, p0, Ltv/freewheel/ad/CallbackManager;->defaultImpressionHandler:Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;

    .line 48
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->defaultImpressionHandler:Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;

    iget-object v5, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v4, v5}, Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;->setAdInstance(Ltv/freewheel/ad/AdInstance;)V

    .line 49
    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    iget-object v5, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    iget-object v6, p0, Ltv/freewheel/ad/CallbackManager;->defaultImpressionHandler:Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;

    invoke-virtual {p0, v4, v5, v6}, Ltv/freewheel/ad/CallbackManager;->addEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;Ltv/freewheel/ad/handler/EventCallbackHandler;)V

    goto :goto_0

    .line 52
    :cond_1
    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    const-string v5, "defaultClick"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    const-string v5, "CLICK"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 53
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    iget-object v5, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    iget-object v6, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    invoke-virtual {v4, v5, v6, v8}, Ltv/freewheel/ad/AdInstance;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v4

    check-cast v4, Ltv/freewheel/ad/handler/ClickCallbackHandler;

    iput-object v4, p0, Ltv/freewheel/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/ad/handler/ClickCallbackHandler;

    .line 55
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    iget-object v4, v4, Ltv/freewheel/ad/AdInstance;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v4}, Ltv/freewheel/ad/AdContext;->getActivity()Landroid/app/Activity;

    move-result-object v4

    if-eqz v4, :cond_2

    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/ad/handler/ClickCallbackHandler;

    if-eqz v4, :cond_2

    .line 57
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/ad/handler/ClickCallbackHandler;

    iget-object v5, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v4, v5}, Ltv/freewheel/ad/handler/ClickCallbackHandler;->setAdInstance(Ltv/freewheel/ad/AdInstance;)V

    .line 59
    :cond_2
    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    iget-object v5, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    iget-object v6, p0, Ltv/freewheel/ad/CallbackManager;->defaultClickHandler:Ltv/freewheel/ad/handler/ClickCallbackHandler;

    invoke-virtual {p0, v4, v5, v6}, Ltv/freewheel/ad/CallbackManager;->addEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;Ltv/freewheel/ad/handler/EventCallbackHandler;)V

    goto :goto_0

    .line 62
    :cond_3
    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    const-string v5, "IMPRESSION"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    const-string v5, "firstQuartile"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_4

    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    const-string v5, "midPoint"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_4

    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    const-string v5, "thirdQuartile"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_4

    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    const-string v5, "complete"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 68
    :cond_4
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    iget-object v5, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    iget-object v6, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    invoke-virtual {v4, v5, v6, v8}, Ltv/freewheel/ad/AdInstance;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/handler/QuartileCallbackHandler;

    .line 70
    .local v2, "quartileHandler":Ltv/freewheel/ad/handler/QuartileCallbackHandler;
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v2, v4}, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->setAdInstance(Ltv/freewheel/ad/AdInstance;)V

    .line 71
    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    iget-object v5, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    invoke-virtual {p0, v4, v5, v2}, Ltv/freewheel/ad/CallbackManager;->addEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;Ltv/freewheel/ad/handler/EventCallbackHandler;)V

    goto/16 :goto_0

    .line 74
    .end local v2    # "quartileHandler":Ltv/freewheel/ad/handler/QuartileCallbackHandler;
    :cond_5
    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    const-string v5, "STANDARD"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 75
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    iget-object v5, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    iget-object v6, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    invoke-virtual {v4, v5, v6, v8}, Ltv/freewheel/ad/AdInstance;->createEventHandler(Ljava/lang/String;Ljava/lang/String;Z)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v3

    check-cast v3, Ltv/freewheel/ad/handler/StandardCallbackHandler;

    .line 77
    .local v3, "standardHandler":Ltv/freewheel/ad/handler/StandardCallbackHandler;
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v3, v4}, Ltv/freewheel/ad/handler/StandardCallbackHandler;->setAdInstance(Ltv/freewheel/ad/AdInstance;)V

    .line 78
    iget-object v4, v0, Ltv/freewheel/ad/EventCallback;->name:Ljava/lang/String;

    iget-object v5, v0, Ltv/freewheel/ad/EventCallback;->type:Ljava/lang/String;

    invoke-virtual {p0, v4, v5, v3}, Ltv/freewheel/ad/CallbackManager;->addEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;Ltv/freewheel/ad/handler/EventCallbackHandler;)V

    goto/16 :goto_0

    .line 81
    .end local v0    # "evtCbk":Ltv/freewheel/ad/EventCallback;
    .end local v3    # "standardHandler":Ltv/freewheel/ad/handler/StandardCallbackHandler;
    :cond_6
    return-void
.end method

.method public sendDefaultImpression(Z)V
    .locals 6
    .param p1, "end"    # Z

    .prologue
    .line 152
    iget-object v3, p0, Ltv/freewheel/ad/CallbackManager;->logger:Ltv/freewheel/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "sendDefaultImpression("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 153
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 154
    .local v2, "info":Landroid/os/Bundle;
    const-string v3, "endAck"

    invoke-virtual {v2, v3, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 155
    const-string v3, "metr"

    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v4}, Ltv/freewheel/ad/AdInstance;->getMetrValue()I

    move-result v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 157
    if-eqz p1, :cond_1

    .line 158
    iget-object v3, p0, Ltv/freewheel/ad/CallbackManager;->timer:Ltv/freewheel/utils/RecordTimer;

    if-nez v3, :cond_0

    .line 180
    :goto_0
    return-void

    .line 165
    :cond_0
    iget-object v3, p0, Ltv/freewheel/ad/CallbackManager;->timer:Ltv/freewheel/utils/RecordTimer;

    invoke-virtual {v3}, Ltv/freewheel/utils/RecordTimer;->tick()J

    move-result-wide v0

    .line 166
    .local v0, "ctValue":J
    const-string v3, "ct"

    invoke-virtual {v2, v3, v0, v1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 167
    const/4 v3, 0x0

    iput-object v3, p0, Ltv/freewheel/ad/CallbackManager;->timer:Ltv/freewheel/utils/RecordTimer;

    .line 175
    :goto_1
    iget-object v3, p0, Ltv/freewheel/ad/CallbackManager;->defaultImpressionHandler:Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;

    if-eqz v3, :cond_2

    .line 176
    iget-object v3, p0, Ltv/freewheel/ad/CallbackManager;->defaultImpressionHandler:Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;

    invoke-virtual {v3, v2}, Ltv/freewheel/ad/handler/AdImpressionCallbackHandler;->send(Landroid/os/Bundle;)V

    goto :goto_0

    .line 170
    .end local v0    # "ctValue":J
    :cond_1
    new-instance v3, Ltv/freewheel/utils/RecordTimer;

    invoke-direct {v3}, Ltv/freewheel/utils/RecordTimer;-><init>()V

    iput-object v3, p0, Ltv/freewheel/ad/CallbackManager;->timer:Ltv/freewheel/utils/RecordTimer;

    .line 171
    iget-object v3, p0, Ltv/freewheel/ad/CallbackManager;->timer:Ltv/freewheel/utils/RecordTimer;

    invoke-virtual {v3}, Ltv/freewheel/utils/RecordTimer;->tick()J

    move-result-wide v0

    .line 172
    .restart local v0    # "ctValue":J
    const-string v3, "ct"

    invoke-virtual {v2, v3, v0, v1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto :goto_1

    .line 178
    :cond_2
    iget-object v3, p0, Ltv/freewheel/ad/CallbackManager;->logger:Ltv/freewheel/utils/Logger;

    const-string v4, "no default impression callback url"

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public sendQuartile(Ljava/lang/String;)V
    .locals 8
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 209
    sget-object v4, Ltv/freewheel/ad/InternalConstants;->METR_MAP:Ljava/util/HashMap;

    invoke-virtual {v4, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    .line 210
    .local v2, "mask":Ljava/lang/Integer;
    if-nez v2, :cond_1

    .line 232
    :cond_0
    :goto_0
    return-void

    .line 213
    :cond_1
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->adInstance:Ltv/freewheel/ad/AdInstance;

    invoke-virtual {v4}, Ltv/freewheel/ad/AdInstance;->getMetrValue()I

    move-result v3

    .line 215
    .local v3, "metr":I
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v4

    and-int/2addr v4, v3

    if-eqz v4, :cond_3

    .line 216
    const-string v4, "IMPRESSION"

    invoke-virtual {p0, p1, v4}, Ltv/freewheel/ad/CallbackManager;->getEventCallbackHandler(Ljava/lang/String;Ljava/lang/String;)Ltv/freewheel/ad/handler/EventCallbackHandler;

    move-result-object v0

    check-cast v0, Ltv/freewheel/ad/handler/QuartileCallbackHandler;

    .line 218
    .local v0, "handler":Ltv/freewheel/ad/handler/QuartileCallbackHandler;
    iget-boolean v4, v0, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->imprSent:Z

    if-nez v4, :cond_0

    .line 219
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->timer:Ltv/freewheel/utils/RecordTimer;

    if-nez v4, :cond_2

    .line 220
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->logger:Ltv/freewheel/utils/Logger;

    const-string v5, "Quartile should not be sent before impression, do nothing, there must be bug in the renderer!"

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 223
    :cond_2
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 224
    .local v1, "info":Landroid/os/Bundle;
    const-string v4, "ct"

    iget-object v5, p0, Ltv/freewheel/ad/CallbackManager;->timer:Ltv/freewheel/utils/RecordTimer;

    invoke-virtual {v5}, Ltv/freewheel/utils/RecordTimer;->tick()J

    move-result-wide v6

    invoke-virtual {v1, v4, v6, v7}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 225
    const-string v4, "metr"

    invoke-virtual {v1, v4, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 226
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "sendQuartile("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 227
    invoke-virtual {v0, v1}, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->send(Landroid/os/Bundle;)V

    goto :goto_0

    .line 230
    .end local v0    # "handler":Ltv/freewheel/ad/handler/QuartileCallbackHandler;
    .end local v1    # "info":Landroid/os/Bundle;
    :cond_3
    iget-object v4, p0, Ltv/freewheel/ad/CallbackManager;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Renderer does not support sending "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", ignore."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method
