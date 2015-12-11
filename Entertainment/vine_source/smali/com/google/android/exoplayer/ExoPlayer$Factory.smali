.class public Lcom/google/android/exoplayer/ExoPlayer$Factory;
.super Ljava/lang/Object;
.source "ExoPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/exoplayer/ExoPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Factory"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 96
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static newInstance(III)Lcom/google/android/exoplayer/ExoPlayer;
    .locals 1
    .param p0, "rendererCount"    # I
    .param p1, "i"    # I
    .param p2, "i1"    # I

    .prologue
    .line 98
    const/4 v0, 0x0

    return-object v0
.end method
