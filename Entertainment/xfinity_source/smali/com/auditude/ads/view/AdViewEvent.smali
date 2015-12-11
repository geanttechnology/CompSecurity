.class public Lcom/auditude/ads/view/AdViewEvent;
.super Lcom/auditude/ads/util/event/Event;
.source "AdViewEvent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;
    }
.end annotation


# instance fields
.field private source:Lcom/auditude/ads/view/model/IAdViewSource;

.field private type:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

.field private view:Lcom/auditude/ads/view/IAdView;


# virtual methods
.method public final getSource()Lcom/auditude/ads/view/model/IAdViewSource;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/auditude/ads/view/AdViewEvent;->source:Lcom/auditude/ads/view/model/IAdViewSource;

    return-object v0
.end method

.method public final getType()Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/auditude/ads/view/AdViewEvent;->type:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    return-object v0
.end method

.method public final getView()Lcom/auditude/ads/view/IAdView;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/auditude/ads/view/AdViewEvent;->view:Lcom/auditude/ads/view/IAdView;

    return-object v0
.end method
