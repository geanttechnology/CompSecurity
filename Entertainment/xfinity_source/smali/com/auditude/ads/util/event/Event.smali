.class public Lcom/auditude/ads/util/event/Event;
.super Ljava/lang/Object;
.source "Event.java"


# instance fields
.field private owner:Lcom/auditude/ads/util/event/IEventDispatcher;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/util/event/IEventDispatcher;)V
    .locals 0
    .param p1, "owner"    # Lcom/auditude/ads/util/event/IEventDispatcher;

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput-object p1, p0, Lcom/auditude/ads/util/event/Event;->owner:Lcom/auditude/ads/util/event/IEventDispatcher;

    .line 10
    return-void
.end method


# virtual methods
.method public getOwner()Lcom/auditude/ads/util/event/IEventDispatcher;
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/auditude/ads/util/event/Event;->owner:Lcom/auditude/ads/util/event/IEventDispatcher;

    return-object v0
.end method
