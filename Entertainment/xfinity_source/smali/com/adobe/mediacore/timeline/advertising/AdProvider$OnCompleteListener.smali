.class public interface abstract Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/timeline/advertising/AdProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "OnCompleteListener"
.end annotation


# virtual methods
.method public abstract onComplete(Lcom/adobe/mediacore/timeline/advertising/AdProvider;Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/timeline/advertising/AdProvider;",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract onError(Lcom/adobe/mediacore/timeline/advertising/AdProvider;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V
.end method

.method public abstract onWarning(Lcom/adobe/mediacore/timeline/advertising/AdProvider;Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V
.end method
