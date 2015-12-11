.class public abstract Lcom/adobe/mediacore/timeline/advertising/AdProvider;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field protected _listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract doProvideAdTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;
.end method

.method protected abstract doResolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
.end method

.method public getAdTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;
    .locals 1

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->doProvideAdTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v0

    return-object v0
.end method

.method protected notifyResolveComplete(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    invoke-interface {v0, p0, p1}, Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;->onComplete(Lcom/adobe/mediacore/timeline/advertising/AdProvider;Ljava/util/List;)V

    :cond_0
    return-void
.end method

.method protected notifyResolveError(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    invoke-interface {v0, p0, p1}, Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;->onError(Lcom/adobe/mediacore/timeline/advertising/AdProvider;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    :cond_0
    return-void
.end method

.method protected notifyResolveWarning(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    invoke-interface {v0, p0, p1}, Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;->onWarning(Lcom/adobe/mediacore/timeline/advertising/AdProvider;Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V

    :cond_0
    return-void
.end method

.method public registerOnCompleteListener(Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Only one OnCompleteListener can be registered at a time.Remove first the listener previously registered."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    if-nez p1, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The listener which will be registered can\'t be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    return-void
.end method

.method public resolveAds(Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->doResolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V

    return-void
.end method

.method public resolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
    .locals 0

    invoke-virtual {p0, p1, p2}, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->doResolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V

    return-void
.end method

.method public unregisterOnCompleteListener(Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "No listener was previously registered."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    if-eq v0, p1, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The provided listener was not registered with this instance.Attempting to remove the wrong listener."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdProvider;->_listener:Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;

    return-void
.end method
