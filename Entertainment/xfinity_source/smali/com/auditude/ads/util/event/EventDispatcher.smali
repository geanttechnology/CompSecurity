.class public Lcom/auditude/ads/util/event/EventDispatcher;
.super Ljava/lang/Object;
.source "EventDispatcher.java"

# interfaces
.implements Lcom/auditude/ads/util/event/IEventDispatcher;


# instance fields
.field private listeners:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/util/event/EventListenerHolder;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/util/event/EventDispatcher;->listeners:Ljava/util/HashMap;

    .line 11
    return-void
.end method

.method private getListenersForType(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/util/event/EventListenerHolder;",
            ">;"
        }
    .end annotation

    .prologue
    .line 97
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/auditude/ads/util/event/EventDispatcher;->getListenersForType(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method private getListenersForType(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/util/ArrayList;
    .locals 2
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "createNew"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/util/event/EventListenerHolder;",
            ">;"
        }
    .end annotation

    .prologue
    .line 102
    iget-object v1, p0, Lcom/auditude/ads/util/event/EventDispatcher;->listeners:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 104
    iget-object v1, p0, Lcom/auditude/ads/util/event/EventDispatcher;->listeners:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    .line 114
    :goto_0
    return-object v1

    .line 107
    :cond_0
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 109
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 110
    .local v0, "listenerHolders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    iget-object v1, p0, Lcom/auditude/ads/util/event/EventDispatcher;->listeners:Ljava/util/HashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v1, v0

    .line 111
    goto :goto_0

    .line 114
    .end local v0    # "listenerHolders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/auditude/ads/util/event/IEventListener;

    .prologue
    .line 17
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/auditude/ads/util/event/EventDispatcher;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;I)V

    .line 18
    return-void
.end method

.method public addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;I)V
    .locals 4
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/auditude/ads/util/event/IEventListener;
    .param p3, "priority"    # I

    .prologue
    .line 22
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    if-eqz p2, :cond_1

    .line 24
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-direct {p0, p1, v3}, Lcom/auditude/ads/util/event/EventDispatcher;->getListenersForType(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/util/ArrayList;

    move-result-object v2

    .line 26
    .local v2, "typeListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 27
    .local v1, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_2

    .line 42
    new-instance v0, Lcom/auditude/ads/util/event/EventListenerHolder;

    invoke-direct {v0, p2, p3}, Lcom/auditude/ads/util/event/EventListenerHolder;-><init>(Lcom/auditude/ads/util/event/IEventListener;I)V

    .line 43
    .local v0, "holder":Lcom/auditude/ads/util/event/EventListenerHolder;
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 45
    new-instance v3, Lcom/auditude/ads/util/event/ListenerPriorityComparator;

    invoke-direct {v3}, Lcom/auditude/ads/util/event/ListenerPriorityComparator;-><init>()V

    invoke-static {v2, v3}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 47
    .end local v0    # "holder":Lcom/auditude/ads/util/event/EventListenerHolder;
    .end local v1    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    .end local v2    # "typeListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    :cond_1
    :goto_0
    return-void

    .line 29
    .restart local v1    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    .restart local v2    # "typeListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/util/event/EventListenerHolder;

    .line 30
    .restart local v0    # "holder":Lcom/auditude/ads/util/event/EventListenerHolder;
    iget-object v3, v0, Lcom/auditude/ads/util/event/EventListenerHolder;->listener:Lcom/auditude/ads/util/event/IEventListener;

    if-ne v3, p2, :cond_0

    .line 32
    iget v3, v0, Lcom/auditude/ads/util/event/EventListenerHolder;->priority:I

    if-eq v3, p3, :cond_1

    .line 34
    iput p3, v0, Lcom/auditude/ads/util/event/EventListenerHolder;->priority:I

    .line 35
    new-instance v3, Lcom/auditude/ads/util/event/ListenerPriorityComparator;

    invoke-direct {v3}, Lcom/auditude/ads/util/event/ListenerPriorityComparator;-><init>()V

    invoke-static {v2, v3}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    goto :goto_0
.end method

.method public dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 3
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/Object;

    .prologue
    .line 51
    iget-object v2, p0, Lcom/auditude/ads/util/event/EventDispatcher;->listeners:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 53
    invoke-direct {p0, p1}, Lcom/auditude/ads/util/event/EventDispatcher;->getListenersForType(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    .line 54
    .local v1, "typeListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    if-eqz v1, :cond_0

    .line 56
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 57
    .local v0, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 63
    .end local v0    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    .end local v1    # "typeListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    :cond_0
    return-void

    .line 59
    .restart local v0    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    .restart local v1    # "typeListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/auditude/ads/util/event/EventListenerHolder;

    invoke-virtual {v2, p1, p2}, Lcom/auditude/ads/util/event/EventListenerHolder;->invoke(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V
    .locals 3
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/auditude/ads/util/event/IEventListener;

    .prologue
    .line 78
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    if-eqz p2, :cond_1

    .line 80
    invoke-direct {p0, p1}, Lcom/auditude/ads/util/event/EventDispatcher;->getListenersForType(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    .line 81
    .local v1, "typeListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    if-eqz v1, :cond_1

    .line 83
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 84
    .local v0, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_2

    .line 93
    .end local v0    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    .end local v1    # "typeListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    :cond_1
    return-void

    .line 86
    .restart local v0    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    .restart local v1    # "typeListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/util/event/EventListenerHolder;>;"
    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/auditude/ads/util/event/EventListenerHolder;

    iget-object v2, v2, Lcom/auditude/ads/util/event/EventListenerHolder;->listener:Lcom/auditude/ads/util/event/IEventListener;

    if-ne v2, p2, :cond_0

    .line 88
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    goto :goto_0
.end method
