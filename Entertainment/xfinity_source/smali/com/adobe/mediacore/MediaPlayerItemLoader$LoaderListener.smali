.class public interface abstract Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerItemLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "LoaderListener"
.end annotation


# virtual methods
.method public abstract onError(Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
.end method

.method public abstract onLoadComplete(Lcom/adobe/mediacore/MediaPlayerItem;)V
.end method
