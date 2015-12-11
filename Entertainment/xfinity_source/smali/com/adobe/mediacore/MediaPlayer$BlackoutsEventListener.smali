.class public interface abstract Lcom/adobe/mediacore/MediaPlayer$BlackoutsEventListener;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$EventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "BlackoutsEventListener"
.end annotation


# virtual methods
.method public abstract onBackgroundManifestFailed()V
.end method

.method public abstract onTimedMetadataInBackgroundItem(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
.end method
