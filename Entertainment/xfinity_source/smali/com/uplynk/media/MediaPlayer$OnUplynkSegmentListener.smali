.class public interface abstract Lcom/uplynk/media/MediaPlayer$OnUplynkSegmentListener;
.super Ljava/lang/Object;
.source "MediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "OnUplynkSegmentListener"
.end annotation


# virtual methods
.method public abstract onUplynkSegmentList(Lcom/uplynk/media/MediaPlayer;Ljava/util/Vector;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/uplynk/media/MediaPlayer;",
            "Ljava/util/Vector",
            "<",
            "Lcom/uplynk/media/MediaPlayer$UplynkSegment;",
            ">;)Z"
        }
    .end annotation
.end method
