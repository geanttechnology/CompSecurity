.class public Lcom/auditude/ads/event/PlayerErrorEvent;
.super Lcom/auditude/ads/util/event/Event;
.source "PlayerErrorEvent.java"


# instance fields
.field public exception:Lcom/auditude/ads/exception/PlayerException;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/util/event/IEventDispatcher;Lcom/auditude/ads/exception/PlayerException;)V
    .locals 0
    .param p1, "owner"    # Lcom/auditude/ads/util/event/IEventDispatcher;
    .param p2, "exception"    # Lcom/auditude/ads/exception/PlayerException;

    .prologue
    .line 15
    invoke-direct {p0, p1}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    .line 16
    iput-object p2, p0, Lcom/auditude/ads/event/PlayerErrorEvent;->exception:Lcom/auditude/ads/exception/PlayerException;

    .line 17
    return-void
.end method
