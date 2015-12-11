.class public interface abstract Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$EventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "AdPlaybackEventListener"
.end annotation


# virtual methods
.method public abstract onAdBreakComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
.end method

.method public abstract onAdBreakSkipped(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
.end method

.method public abstract onAdBreakStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
.end method

.method public abstract onAdClick(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;Lcom/adobe/mediacore/timeline/advertising/AdClick;)V
.end method

.method public abstract onAdComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V
.end method

.method public abstract onAdProgress(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)V
.end method

.method public abstract onAdStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V
.end method
