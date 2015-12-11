.class Lcom/auditude/ads/util/event/ListenerPriorityComparator;
.super Ljava/lang/Object;
.source "EventDispatcher.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/auditude/ads/util/event/EventListenerHolder;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 135
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/auditude/ads/util/event/EventListenerHolder;Lcom/auditude/ads/util/event/EventListenerHolder;)I
    .locals 2
    .param p1, "a"    # Lcom/auditude/ads/util/event/EventListenerHolder;
    .param p2, "b"    # Lcom/auditude/ads/util/event/EventListenerHolder;

    .prologue
    .line 140
    iget v0, p1, Lcom/auditude/ads/util/event/EventListenerHolder;->priority:I

    iget v1, p2, Lcom/auditude/ads/util/event/EventListenerHolder;->priority:I

    if-le v0, v1, :cond_0

    .line 142
    const/4 v0, -0x1

    .line 149
    :goto_0
    return v0

    .line 144
    :cond_0
    iget v0, p1, Lcom/auditude/ads/util/event/EventListenerHolder;->priority:I

    iget v1, p2, Lcom/auditude/ads/util/event/EventListenerHolder;->priority:I

    if-ge v0, v1, :cond_1

    .line 146
    const/4 v0, 0x1

    goto :goto_0

    .line 149
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 1
    check-cast p1, Lcom/auditude/ads/util/event/EventListenerHolder;

    check-cast p2, Lcom/auditude/ads/util/event/EventListenerHolder;

    invoke-virtual {p0, p1, p2}, Lcom/auditude/ads/util/event/ListenerPriorityComparator;->compare(Lcom/auditude/ads/util/event/EventListenerHolder;Lcom/auditude/ads/util/event/EventListenerHolder;)I

    move-result v0

    return v0
.end method
