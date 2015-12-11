.class Lcom/auditude/ads/util/event/EventListenerHolder;
.super Ljava/lang/Object;
.source "EventDispatcher.java"


# instance fields
.field public listener:Lcom/auditude/ads/util/event/IEventListener;

.field public priority:I


# direct methods
.method public constructor <init>(Lcom/auditude/ads/util/event/IEventListener;I)V
    .locals 1
    .param p1, "listener"    # Lcom/auditude/ads/util/event/IEventListener;
    .param p2, "priority"    # I

    .prologue
    .line 123
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 120
    const/4 v0, 0x0

    iput v0, p0, Lcom/auditude/ads/util/event/EventListenerHolder;->priority:I

    .line 125
    iput-object p1, p0, Lcom/auditude/ads/util/event/EventListenerHolder;->listener:Lcom/auditude/ads/util/event/IEventListener;

    .line 126
    iput p2, p0, Lcom/auditude/ads/util/event/EventListenerHolder;->priority:I

    .line 127
    return-void
.end method


# virtual methods
.method public invoke(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/Object;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/auditude/ads/util/event/EventListenerHolder;->listener:Lcom/auditude/ads/util/event/IEventListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/auditude/ads/util/event/EventListenerHolder;->listener:Lcom/auditude/ads/util/event/IEventListener;

    invoke-interface {v0, p1, p2}, Lcom/auditude/ads/util/event/IEventListener;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 132
    :cond_0
    return-void
.end method
