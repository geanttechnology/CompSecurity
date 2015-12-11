.class public Lcom/auditude/ads/util/log/LogEvent;
.super Lcom/auditude/ads/util/event/Event;
.source "LogEvent.java"


# instance fields
.field public data:Ljava/lang/Object;

.field public level:Lcom/auditude/ads/util/log/LogLevel;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/util/event/IEventDispatcher;Ljava/lang/Object;Lcom/auditude/ads/util/log/LogLevel;)V
    .locals 0
    .param p1, "owner"    # Lcom/auditude/ads/util/event/IEventDispatcher;
    .param p2, "data"    # Ljava/lang/Object;
    .param p3, "level"    # Lcom/auditude/ads/util/log/LogLevel;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lcom/auditude/ads/util/event/Event;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V

    .line 23
    iput-object p2, p0, Lcom/auditude/ads/util/log/LogEvent;->data:Ljava/lang/Object;

    .line 24
    iput-object p3, p0, Lcom/auditude/ads/util/log/LogEvent;->level:Lcom/auditude/ads/util/log/LogLevel;

    .line 25
    return-void
.end method
