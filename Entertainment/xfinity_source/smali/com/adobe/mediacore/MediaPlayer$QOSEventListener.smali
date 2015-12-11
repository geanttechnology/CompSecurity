.class public interface abstract Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$EventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "QOSEventListener"
.end annotation


# virtual methods
.method public abstract onBufferComplete()V
.end method

.method public abstract onBufferStart()V
.end method

.method public abstract onLoadInfo(Lcom/adobe/mediacore/qos/LoadInfo;)V
.end method

.method public abstract onOperationFailed(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V
.end method

.method public abstract onSeekComplete(J)V
.end method

.method public abstract onSeekStart()V
.end method
