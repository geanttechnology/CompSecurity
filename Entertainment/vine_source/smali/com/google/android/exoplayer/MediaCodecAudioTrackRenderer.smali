.class public Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;
.super Ljava/lang/Object;
.source "MediaCodecAudioTrackRenderer.java"


# static fields
.field public static final MSG_SET_VOLUME:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;->MSG_SET_VOLUME:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/exoplayer/FrameworkSampleSource;)V
    .locals 0
    .param p1, "sampleSource"    # Lcom/google/android/exoplayer/FrameworkSampleSource;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    return-void
.end method
