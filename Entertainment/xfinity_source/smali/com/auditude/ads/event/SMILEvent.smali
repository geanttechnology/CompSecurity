.class public Lcom/auditude/ads/event/SMILEvent;
.super Lcom/auditude/ads/util/event/Event;
.source "SMILEvent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/event/SMILEvent$SMILEventType;
    }
.end annotation


# instance fields
.field private advancePattern:Z

.field private par:Lcom/auditude/ads/model/smil/Par;

.field private sequence:Lcom/auditude/ads/model/smil/Sequence;

.field private type:Lcom/auditude/ads/event/SMILEvent$SMILEventType;


# virtual methods
.method public final getAdvancePattern()Z
    .locals 1

    .prologue
    .line 39
    iget-boolean v0, p0, Lcom/auditude/ads/event/SMILEvent;->advancePattern:Z

    return v0
.end method

.method public final getPar()Lcom/auditude/ads/model/smil/Par;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/auditude/ads/event/SMILEvent;->par:Lcom/auditude/ads/model/smil/Par;

    return-object v0
.end method

.method public final getSequence()Lcom/auditude/ads/model/smil/Sequence;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/auditude/ads/event/SMILEvent;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    return-object v0
.end method

.method public final getType()Lcom/auditude/ads/event/SMILEvent$SMILEventType;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/auditude/ads/event/SMILEvent;->type:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    return-object v0
.end method
