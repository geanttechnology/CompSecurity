.class public Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport$Factory;
.super Ljava/lang/Object;
.source "PlaybackSupportResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Factory"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static newPlaybackSupport(ZZ)Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;
    .locals 2
    .param p0, "isPlaybackSupported"    # Z
    .param p1, "isPlaybackSustainable"    # Z

    .prologue
    .line 57
    new-instance v0, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;-><init>(ZZLcom/amazon/avod/sdk/PlaybackSupportResponse$1;)V

    return-object v0
.end method
