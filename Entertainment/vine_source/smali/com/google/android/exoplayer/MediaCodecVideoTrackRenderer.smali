.class public Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;
.super Ljava/lang/Object;
.source "MediaCodecVideoTrackRenderer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer$EventListener;
    }
.end annotation


# static fields
.field public static final MSG_SET_SURFACE:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/google/android/exoplayer/MediaCodecVideoTrackRenderer;->MSG_SET_SURFACE:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/exoplayer/FrameworkSampleSource;IILandroid/os/Handler;Lco/vine/android/player/SdkVideoView;I)V
    .locals 0
    .param p1, "sampleSource"    # Lcom/google/android/exoplayer/FrameworkSampleSource;
    .param p2, "videoScalingModeScaleToFit"    # I
    .param p3, "i"    # I
    .param p4, "mHandler"    # Landroid/os/Handler;
    .param p5, "sdkVideoView"    # Lco/vine/android/player/SdkVideoView;
    .param p6, "i1"    # I

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method
