.class public Lcom/uplynk/media/MediaPlayer;
.super Ljava/lang/Object;
.source "MediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/uplynk/media/MediaPlayer$EventHandler;,
        Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;,
        Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;,
        Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;,
        Lcom/uplynk/media/MediaPlayer$OnCompletionListener;,
        Lcom/uplynk/media/MediaPlayer$OnErrorListener;,
        Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;,
        Lcom/uplynk/media/MediaPlayer$OnInfoListener;,
        Lcom/uplynk/media/MediaPlayer$OnPreparedListener;,
        Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;,
        Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;,
        Lcom/uplynk/media/MediaPlayer$OnUplynkSegmentListener;,
        Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;,
        Lcom/uplynk/media/MediaPlayer$SurfaceListener;,
        Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;,
        Lcom/uplynk/media/MediaPlayer$UplynkID3;,
        Lcom/uplynk/media/MediaPlayer$UplynkMetadata;,
        Lcom/uplynk/media/MediaPlayer$UplynkSegment;,
        Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;
    }
.end annotation


# static fields
.field private static final IMEDIA_PLAYER:Ljava/lang/String; = "android.media.IMediaPlayer"

.field private static final LOAD_LOLLIPOP_STANDALONE:Z = true

.field private static final LOAD_SHARED_LIB_SET:Z = true

.field private static final MEDIA_BUFFERING_UPDATE:I = 0x3

.field private static final MEDIA_CC_DETECTED:I = 0xc9

.field private static final MEDIA_DISCONTINUITY:I = 0x7

.field private static final MEDIA_ERROR:I = 0x64

.field public static final MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK:I = 0xc8

.field public static final MEDIA_ERROR_SERVER_DIED:I = 0x64

.field public static final MEDIA_ERROR_UNKNOWN:I = 0x1

.field public static final MEDIA_ERROR_UNSUPPORTED_FORMAT:I = 0x190

.field private static final MEDIA_ID3_METADATA:I = 0x191

.field private static final MEDIA_INFO:I = 0xc8

.field public static final MEDIA_INFO_BAD_INTERLEAVING:I = 0x320

.field public static final MEDIA_INFO_BUFFERING_END:I = 0x2be

.field public static final MEDIA_INFO_BUFFERING_START:I = 0x2bd

.field public static final MEDIA_INFO_METADATA_UPDATE:I = 0x322

.field public static final MEDIA_INFO_NOT_SEEKABLE:I = 0x321

.field public static final MEDIA_INFO_UNKNOWN:I = 0x1

.field public static final MEDIA_INFO_VIDEO_TRACK_LAGGING:I = 0x2bc

.field private static final MEDIA_NOP:I = 0x0

.field private static final MEDIA_PLAYBACK_COMPLETE:I = 0x2

.field private static final MEDIA_PREPARED:I = 0x1

.field private static final MEDIA_SEEK_COMPLETE:I = 0x4

.field private static final MEDIA_SET_VIDEO_SIZE:I = 0x5

.field private static final MEDIA_SET_WINDOW_SIZE:I = 0x6

.field private static final MEDIA_UPLYNK_METADATA:I = 0x190

.field public static final PLAYER_STATE_PAUSED:I = 0x4

.field public static final PLAYER_STATE_PLAYING:I = 0x3

.field public static final PLAYER_STATE_PREPARED:I = 0x2

.field public static final PLAYER_STATE_PREPARING:I = 0x1

.field public static final PLAYER_STATE_STOPPED:I = 0x0

.field private static final REQUIRE_UPLYNK_SRC:Z = true

.field private static final SET_FIXED_SURFACE_SIZE:Z

.field private static final SURFACE_TYPE_NORMAL:I = 0x0

.field private static final TAG:Ljava/lang/String; = "upLynkMediaPlayer"

.field private static mSurfaceType:I


# instance fields
.field private _ccManager:Lcom/uplynk/media/CaptionManager;

.field private _currentAssetID:Ljava/lang/String;

.field private _currentAssetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

.field private _hasCaptions:Z

.field private _trackOptions:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/util/Vector",
            "<",
            "Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;",
            ">;>;"
        }
    .end annotation
.end field

.field private mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

.field private mListenerContext:I

.field private mNativeContext:I

.field private mOnAssetBoundaryListener:Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;

.field private mOnBufferingUpdateListener:Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;

.field protected mOnCaptionEventListener:Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;

.field private mOnCompletionListener:Lcom/uplynk/media/MediaPlayer$OnCompletionListener;

.field private mOnErrorListener:Lcom/uplynk/media/MediaPlayer$OnErrorListener;

.field private mOnID3MetadataListener:Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;

.field private mOnInfoListener:Lcom/uplynk/media/MediaPlayer$OnInfoListener;

.field private mOnPreparedListener:Lcom/uplynk/media/MediaPlayer$OnPreparedListener;

.field private mOnSeekCompleteListener:Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;

.field private mOnUplynkMetadataListener:Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;

.field private mOnUplynkSegmentListener:Lcom/uplynk/media/MediaPlayer$OnUplynkSegmentListener;

.field private mOnVideoSizeChangedListener:Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;

.field private mScreenOnWhilePlaying:Z

.field private mStayAwake:Z

.field private mSurface:Landroid/view/Surface;

.field private mSurfaceHolder:Landroid/view/SurfaceHolder;

.field private final mSurfaceListener:Lcom/uplynk/media/MediaPlayer$SurfaceListener;

.field private mWakeLock:Landroid/os/PowerManager$WakeLock;

.field private url:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/16 v6, 0x15

    const/4 v3, 0x0

    const/16 v5, 0xa

    .line 41
    sget-object v2, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    const-string v4, "motorola"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    if-le v2, v5, :cond_6

    .line 42
    :cond_0
    sget-object v2, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    const-string v4, "LGE"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    if-le v2, v5, :cond_6

    .line 43
    :cond_1
    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v4, "SAMSUNG-SGH-I727"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 44
    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v4, "SPH-M820"

    invoke-virtual {v2, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6

    move v2, v3

    .line 41
    :goto_0
    sput-boolean v2, Lcom/uplynk/media/MediaPlayer;->SET_FIXED_SURFACE_SIZE:Z

    .line 52
    const-string v2, "gnustl_shared"

    invoke-static {v2}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 55
    const/4 v1, 0x0

    .line 56
    .local v1, "verPostfix":Ljava/lang/String;
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x9

    if-eq v2, v4, :cond_2

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ne v2, v5, :cond_7

    .line 57
    :cond_2
    const-string v1, "_2_3"

    .line 89
    :cond_3
    :goto_1
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge v2, v6, :cond_10

    .line 91
    const-string v2, "UplynkCore"

    invoke-static {v2}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 93
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "uplynk"

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 95
    const-string v2, "UplynkPlayer"

    invoke-static {v2}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 98
    const-string v2, "neon"

    invoke-static {v2}, Lcom/uplynk/tools/CpuInfo;->hasFeature(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 99
    const-string v2, "UplynkNeonExt"

    invoke-static {v2}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 108
    :cond_4
    :goto_2
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    .line 109
    .local v0, "androidVersion":Ljava/lang/String;
    const-string v2, "M"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 111
    const-string v2, "upLynkMediaPlayer"

    const-string v4, "*** M Preview ***"

    invoke-static {v2, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 112
    const-string v0, "6.0.0"

    .line 115
    :cond_5
    sget-object v2, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v4, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-static {v0, v2, v4}, Lcom/uplynk/media/MediaPlayer;->nativeInit(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    sput v3, Lcom/uplynk/media/MediaPlayer;->mSurfaceType:I

    .line 1069
    return-void

    .line 41
    .end local v0    # "androidVersion":Ljava/lang/String;
    .end local v1    # "verPostfix":Ljava/lang/String;
    :cond_6
    const/4 v2, 0x1

    goto :goto_0

    .line 59
    .restart local v1    # "verPostfix":Ljava/lang/String;
    :cond_7
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xe

    if-lt v2, v4, :cond_8

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xf

    if-gt v2, v4, :cond_8

    .line 60
    const-string v1, "_4_0"

    .line 61
    goto :goto_1

    .line 62
    :cond_8
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x10

    if-ne v2, v4, :cond_9

    .line 63
    const-string v1, "_4_1"

    .line 64
    goto :goto_1

    .line 65
    :cond_9
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x11

    if-ne v2, v4, :cond_a

    .line 66
    const-string v1, "_4_2"

    .line 67
    goto :goto_1

    .line 68
    :cond_a
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x12

    if-ne v2, v4, :cond_b

    .line 69
    const-string v1, "_4_3"

    .line 70
    goto :goto_1

    .line 71
    :cond_b
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x13

    if-ne v2, v4, :cond_c

    .line 72
    const-string v1, "_4_4"

    .line 73
    goto :goto_1

    .line 74
    :cond_c
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    if-eq v2, v6, :cond_d

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x16

    if-ne v2, v4, :cond_e

    .line 75
    :cond_d
    const-string v1, "_5_0"

    .line 78
    sget-object v2, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    const-string v4, "M"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 79
    const-string v1, "_6_0"

    .line 80
    goto/16 :goto_1

    .line 81
    :cond_e
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x17

    if-lt v2, v4, :cond_f

    .line 82
    const-string v1, "_6_0"

    .line 83
    goto/16 :goto_1

    .line 85
    :cond_f
    new-instance v2, Ljava/lang/Error;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "SDK Version "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " is not supported"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v2

    .line 104
    :cond_10
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "Uplynk"

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    goto/16 :goto_2
.end method

.method public constructor <init>()V
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 143
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 128
    new-instance v1, Lcom/uplynk/media/MediaPlayer$SurfaceListener;

    invoke-direct {v1, p0, v2}, Lcom/uplynk/media/MediaPlayer$SurfaceListener;-><init>(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$SurfaceListener;)V

    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceListener:Lcom/uplynk/media/MediaPlayer$SurfaceListener;

    .line 130
    iput-object v2, p0, Lcom/uplynk/media/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    .line 145
    new-instance v1, Lcom/uplynk/media/CaptionManager;

    invoke-direct {v1, p0}, Lcom/uplynk/media/CaptionManager;-><init>(Lcom/uplynk/media/MediaPlayer;)V

    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    .line 146
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/uplynk/media/MediaPlayer;->_hasCaptions:Z

    .line 147
    new-instance v1, Landroid/util/SparseArray;

    invoke-direct {v1}, Landroid/util/SparseArray;-><init>()V

    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->_trackOptions:Landroid/util/SparseArray;

    .line 150
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    .local v0, "looper":Landroid/os/Looper;
    if-eqz v0, :cond_0

    .line 151
    new-instance v1, Lcom/uplynk/media/MediaPlayer$EventHandler;

    invoke-direct {v1, p0, p0, v0}, Lcom/uplynk/media/MediaPlayer$EventHandler;-><init>(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer;Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    .line 152
    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    new-instance v2, Lcom/uplynk/media/CaptionManager$CCEventHandler;

    iget-object v3, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget-object v4, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-direct {v2, v3, p0, v4, v0}, Lcom/uplynk/media/CaptionManager$CCEventHandler;-><init>(Lcom/uplynk/media/CaptionManager;Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/CaptionManager;Landroid/os/Looper;)V

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager;->setEventHandler(Lcom/uplynk/media/CaptionManager$CCEventHandler;)V

    .line 163
    :goto_0
    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-direct {p0, v1}, Lcom/uplynk/media/MediaPlayer;->nativeSetup(Ljava/lang/Object;)V

    .line 164
    return-void

    .line 153
    :cond_0
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 154
    new-instance v1, Lcom/uplynk/media/MediaPlayer$EventHandler;

    invoke-direct {v1, p0, p0, v0}, Lcom/uplynk/media/MediaPlayer$EventHandler;-><init>(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer;Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    .line 155
    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    new-instance v2, Lcom/uplynk/media/CaptionManager$CCEventHandler;

    iget-object v3, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    iget-object v4, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-direct {v2, v3, p0, v4, v0}, Lcom/uplynk/media/CaptionManager$CCEventHandler;-><init>(Lcom/uplynk/media/CaptionManager;Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/CaptionManager;Landroid/os/Looper;)V

    invoke-virtual {v1, v2}, Lcom/uplynk/media/CaptionManager;->setEventHandler(Lcom/uplynk/media/CaptionManager$CCEventHandler;)V

    goto :goto_0

    .line 157
    :cond_1
    iput-object v2, p0, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    goto :goto_0
.end method

.method private native _pause()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method private native _play(Ljava/lang/String;)V
.end method

.method private native _reset()V
.end method

.method private native _resume()V
.end method

.method private native _seekTo(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method private native _setDataSource(Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method private native _setSurface(Landroid/view/Surface;IIII)V
.end method

.method private native _start()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method private native _stop()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method static synthetic access$0(Lcom/uplynk/media/MediaPlayer;)I
    .locals 1

    .prologue
    .line 122
    iget v0, p0, Lcom/uplynk/media/MediaPlayer;->mNativeContext:I

    return v0
.end method

.method static synthetic access$1(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnPreparedListener;
    .locals 1

    .prologue
    .line 852
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mOnPreparedListener:Lcom/uplynk/media/MediaPlayer$OnPreparedListener;

    return-object v0
.end method

.method static synthetic access$10(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnErrorListener;
    .locals 1

    .prologue
    .line 1028
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mOnErrorListener:Lcom/uplynk/media/MediaPlayer$OnErrorListener;

    return-object v0
.end method

.method static synthetic access$11(Lcom/uplynk/media/MediaPlayer;Z)V
    .locals 0

    .prologue
    .line 136
    iput-boolean p1, p0, Lcom/uplynk/media/MediaPlayer;->_hasCaptions:Z

    return-void
.end method

.method static synthetic access$12(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnInfoListener;
    .locals 1

    .prologue
    .line 1108
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mOnInfoListener:Lcom/uplynk/media/MediaPlayer$OnInfoListener;

    return-object v0
.end method

.method static synthetic access$13(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;
    .locals 1

    .prologue
    .line 1119
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mOnAssetBoundaryListener:Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;

    return-object v0
.end method

.method static synthetic access$14(Lcom/uplynk/media/MediaPlayer;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 484
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->getMetadata()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$15(Lcom/uplynk/media/MediaPlayer;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_currentAssetID:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$16(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->_currentAssetID:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$17(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_currentAssetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    return-object v0
.end method

.method static synthetic access$18(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 485
    invoke-direct {p0, p1}, Lcom/uplynk/media/MediaPlayer;->getAssetInfo(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$19(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;)V
    .locals 0

    .prologue
    .line 139
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->_currentAssetInfo:Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    return-void
.end method

.method static synthetic access$2(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnCompletionListener;
    .locals 1

    .prologue
    .line 879
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mOnCompletionListener:Lcom/uplynk/media/MediaPlayer$OnCompletionListener;

    return-object v0
.end method

.method static synthetic access$20(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;
    .locals 1

    .prologue
    .line 1157
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mOnUplynkMetadataListener:Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;

    return-object v0
.end method

.method static synthetic access$21(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;
    .locals 1

    .prologue
    .line 1141
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mOnID3MetadataListener:Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;

    return-object v0
.end method

.method static synthetic access$22(Lcom/uplynk/media/MediaPlayer;IIII)V
    .locals 0

    .prologue
    .line 471
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/uplynk/media/MediaPlayer;->updateSurfaceBounds(IIII)V

    return-void
.end method

.method static synthetic access$23(Lcom/uplynk/media/MediaPlayer;Landroid/view/Surface;IIII)V
    .locals 0

    .prologue
    .line 470
    invoke-direct/range {p0 .. p5}, Lcom/uplynk/media/MediaPlayer;->_setSurface(Landroid/view/Surface;IIII)V

    return-void
.end method

.method static synthetic access$24(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$SurfaceListener;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceListener:Lcom/uplynk/media/MediaPlayer$SurfaceListener;

    return-object v0
.end method

.method static synthetic access$25(Lcom/uplynk/media/MediaPlayer;Landroid/view/SurfaceHolder;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    return-void
.end method

.method static synthetic access$3(Lcom/uplynk/media/MediaPlayer;Z)V
    .locals 0

    .prologue
    .line 304
    invoke-direct {p0, p1}, Lcom/uplynk/media/MediaPlayer;->stayAwake(Z)V

    return-void
.end method

.method static synthetic access$4(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/CaptionManager;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    return-object v0
.end method

.method static synthetic access$5(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;
    .locals 1

    .prologue
    .line 908
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mOnBufferingUpdateListener:Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;

    return-object v0
.end method

.method static synthetic access$6(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;
    .locals 1

    .prologue
    .line 935
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mOnSeekCompleteListener:Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;

    return-object v0
.end method

.method static synthetic access$7(Lcom/uplynk/media/MediaPlayer;)Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;
    .locals 1

    .prologue
    .line 964
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mOnVideoSizeChangedListener:Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;

    return-object v0
.end method

.method static synthetic access$8()Z
    .locals 1

    .prologue
    .line 41
    sget-boolean v0, Lcom/uplynk/media/MediaPlayer;->SET_FIXED_SURFACE_SIZE:Z

    return v0
.end method

.method static synthetic access$9(Lcom/uplynk/media/MediaPlayer;)Landroid/view/SurfaceHolder;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    return-object v0
.end method

.method private native disposePlayer()V
.end method

.method private native getAssetInfo(Ljava/lang/String;)Ljava/lang/String;
.end method

.method private native getContentState()I
.end method

.method private native getMetadata()Ljava/lang/String;
.end method

.method private static native getNeededSurfaceType()I
.end method

.method public static initSurfaceHolder(Landroid/view/SurfaceHolder;)V
    .locals 3
    .param p0, "sh"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 179
    if-nez p0, :cond_0

    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "SurfaceHolder cannot be null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 181
    :cond_0
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xa

    if-gt v1, v2, :cond_1

    .line 185
    invoke-static {}, Lcom/uplynk/media/MediaPlayer;->getNeededSurfaceType()I

    move-result v0

    .line 186
    .local v0, "type":I
    sput v0, Lcom/uplynk/media/MediaPlayer;->mSurfaceType:I

    .line 187
    invoke-interface {p0, v0}, Landroid/view/SurfaceHolder;->setType(I)V

    .line 189
    .end local v0    # "type":I
    :cond_1
    return-void
.end method

.method private static final native nativeInit(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end method

.method private final native nativeSetup(Ljava/lang/Object;)V
.end method

.method private static postCCEventFromNative(Ljava/lang/Object;III[C)V
    .locals 5
    .param p0, "mediaplayer_ref"    # Ljava/lang/Object;
    .param p1, "type"    # I
    .param p2, "channel"    # I
    .param p3, "size"    # I
    .param p4, "data"    # [C

    .prologue
    .line 1316
    if-eqz p2, :cond_2

    .line 1318
    const-string v3, "upLynkMediaPlayer"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "Ignoring CC Data from Channel + "

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ": "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    if-eqz p4, :cond_1

    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, p4}, Ljava/lang/String;-><init>([C)V

    :goto_0
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 1335
    .end local p0    # "mediaplayer_ref":Ljava/lang/Object;
    :cond_0
    :goto_1
    return-void

    .line 1318
    .restart local p0    # "mediaplayer_ref":Ljava/lang/Object;
    :cond_1
    const-string v2, "null"

    goto :goto_0

    .line 1323
    :cond_2
    check-cast p0, Ljava/lang/ref/WeakReference;

    .end local p0    # "mediaplayer_ref":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/uplynk/media/MediaPlayer;

    .line 1324
    .local v1, "mp":Lcom/uplynk/media/MediaPlayer;
    if-eqz v1, :cond_0

    .line 1327
    iget-object v2, v1, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v2, :cond_0

    .line 1330
    iget-object v2, v1, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v2}, Lcom/uplynk/media/CaptionManager;->getEventHandler()Lcom/uplynk/media/CaptionManager$CCEventHandler;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 1332
    iget-object v2, v1, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v2}, Lcom/uplynk/media/CaptionManager;->getEventHandler()Lcom/uplynk/media/CaptionManager$CCEventHandler;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, p1, p3, v3, p4}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 1333
    .local v0, "m":Landroid/os/Message;
    iget-object v2, v1, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v2}, Lcom/uplynk/media/CaptionManager;->getEventHandler()Lcom/uplynk/media/CaptionManager$CCEventHandler;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/uplynk/media/CaptionManager$CCEventHandler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_1
.end method

.method private static postCCPacketFromNative(Ljava/lang/Object;CCC)V
    .locals 2
    .param p0, "mediaplayer_ref"    # Ljava/lang/Object;
    .param p1, "data1"    # C
    .param p2, "data2"    # C
    .param p3, "fieldType"    # C

    .prologue
    .line 1356
    check-cast p0, Ljava/lang/ref/WeakReference;

    .end local p0    # "mediaplayer_ref":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/MediaPlayer;

    .line 1357
    .local v0, "mp":Lcom/uplynk/media/MediaPlayer;
    if-nez v0, :cond_1

    .line 1366
    :cond_0
    :goto_0
    return-void

    .line 1360
    :cond_1
    iget-object v1, v0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v1, :cond_0

    .line 1363
    iget-object v1, v0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v1, p1, p2, p3}, Lcom/uplynk/media/CaptionManager;->processPacket(CCC)V

    goto :goto_0
.end method

.method private static postEventFromNative(Ljava/lang/Object;IIILjava/lang/Object;)V
    .locals 3
    .param p0, "mediaplayer_ref"    # Ljava/lang/Object;
    .param p1, "what"    # I
    .param p2, "arg1"    # I
    .param p3, "arg2"    # I
    .param p4, "obj"    # Ljava/lang/Object;

    .prologue
    .line 816
    check-cast p0, Ljava/lang/ref/WeakReference;

    .end local p0    # "mediaplayer_ref":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/uplynk/media/MediaPlayer;

    .line 817
    .local v1, "mp":Lcom/uplynk/media/MediaPlayer;
    if-nez v1, :cond_1

    .line 825
    :cond_0
    :goto_0
    return-void

    .line 821
    :cond_1
    iget-object v2, v1, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    if-eqz v2, :cond_0

    .line 822
    iget-object v2, v1, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    invoke-virtual {v2, p1, p2, p3, p4}, Lcom/uplynk/media/MediaPlayer$EventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 823
    .local v0, "m":Landroid/os/Message;
    iget-object v2, v1, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    invoke-virtual {v2, v0}, Lcom/uplynk/media/MediaPlayer$EventHandler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0
.end method

.method private static postMetadataEventFromNative(Ljava/lang/Object;ILjava/lang/String;Ljava/lang/String;I[C)V
    .locals 7
    .param p0, "mediaplayer_ref"    # Ljava/lang/Object;
    .param p1, "type"    # I
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "desc"    # Ljava/lang/String;
    .param p4, "size"    # I
    .param p5, "data"    # [C

    .prologue
    const/4 v6, 0x0

    .line 1374
    check-cast p0, Ljava/lang/ref/WeakReference;

    .end local p0    # "mediaplayer_ref":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/uplynk/media/MediaPlayer;

    .line 1375
    .local v1, "mp":Lcom/uplynk/media/MediaPlayer;
    if-nez v1, :cond_1

    .line 1384
    :cond_0
    :goto_0
    return-void

    .line 1378
    :cond_1
    const/4 v3, 0x1

    if-ne p1, v3, :cond_0

    iget-object v3, v1, Lcom/uplynk/media/MediaPlayer;->mOnID3MetadataListener:Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;

    if-eqz v3, :cond_0

    if-lez p4, :cond_0

    .line 1380
    new-instance v2, Ljava/lang/String;

    add-int/lit8 v3, p4, -0x1

    invoke-direct {v2, p5, v6, v3}, Ljava/lang/String;-><init>([CII)V

    .line 1381
    .local v2, "value":Ljava/lang/String;
    iget-object v3, v1, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    const/16 v4, 0x191

    new-instance v5, Lcom/uplynk/media/MediaPlayer$UplynkID3;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-direct {v5, v1, p2, v2, p3}, Lcom/uplynk/media/MediaPlayer$UplynkID3;-><init>(Lcom/uplynk/media/MediaPlayer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v3, v4, v6, v6, v5}, Lcom/uplynk/media/MediaPlayer$EventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 1382
    .local v0, "m":Landroid/os/Message;
    iget-object v3, v1, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    invoke-virtual {v3, v0}, Lcom/uplynk/media/MediaPlayer$EventHandler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0
.end method

.method private postNativeCrash()V
    .locals 5

    .prologue
    const/16 v4, 0x3e8

    .line 1339
    const-string v1, "upLynkMediaPlayer"

    const-string v2, "Unknown Error Caused Player to Abort"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1341
    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    if-nez v1, :cond_0

    .line 1349
    :goto_0
    return-void

    .line 1343
    :cond_0
    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    const/16 v2, 0x64

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v4, v4, v3}, Lcom/uplynk/media/MediaPlayer$EventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 1344
    .local v0, "m":Landroid/os/Message;
    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    invoke-virtual {v1, v0}, Lcom/uplynk/media/MediaPlayer$EventHandler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_0
.end method

.method private static postSegmentListFromNative(Ljava/lang/Object;I[C)V
    .locals 13
    .param p0, "mediaplayer_ref"    # Ljava/lang/Object;
    .param p1, "size"    # I
    .param p2, "data"    # [C

    .prologue
    .line 1526
    check-cast p0, Ljava/lang/ref/WeakReference;

    .end local p0    # "mediaplayer_ref":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/uplynk/media/MediaPlayer;

    .line 1527
    .local v2, "mp":Lcom/uplynk/media/MediaPlayer;
    if-nez v2, :cond_1

    .line 1563
    :cond_0
    :goto_0
    return-void

    .line 1530
    :cond_1
    if-lez p1, :cond_4

    .line 1532
    new-instance v12, Ljava/lang/String;

    invoke-direct {v12, p2}, Ljava/lang/String;-><init>([C)V

    .line 1533
    .local v12, "str":Ljava/lang/String;
    invoke-virtual {v12}, Ljava/lang/String;->trim()Ljava/lang/String;

    .line 1535
    const-string v3, "\\|"

    invoke-virtual {v12, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 1538
    .local v11, "segments":[Ljava/lang/String;
    new-instance v9, Ljava/util/Vector;

    invoke-direct {v9}, Ljava/util/Vector;-><init>()V

    .line 1541
    .local v9, "list":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/uplynk/media/MediaPlayer$UplynkSegment;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v3, v11

    if-lt v0, v3, :cond_2

    .line 1555
    iget-object v3, v2, Lcom/uplynk/media/MediaPlayer;->mOnUplynkSegmentListener:Lcom/uplynk/media/MediaPlayer$OnUplynkSegmentListener;

    if-eqz v3, :cond_0

    .line 1557
    iget-object v3, v2, Lcom/uplynk/media/MediaPlayer;->mOnUplynkSegmentListener:Lcom/uplynk/media/MediaPlayer$OnUplynkSegmentListener;

    invoke-interface {v3, v2, v9}, Lcom/uplynk/media/MediaPlayer$OnUplynkSegmentListener;->onUplynkSegmentList(Lcom/uplynk/media/MediaPlayer;Ljava/util/Vector;)Z

    goto :goto_0

    .line 1544
    :cond_2
    aget-object v3, v11, v0

    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v10

    .line 1545
    .local v10, "params":[Ljava/lang/String;
    array-length v3, v10

    const/4 v4, 0x4

    if-eq v3, v4, :cond_3

    .line 1547
    const-string v3, "upLynkMediaPlayer"

    const-string v4, "Skipping Invalid Segment Params: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aget-object v7, v11, v0

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1541
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1551
    :cond_3
    new-instance v1, Lcom/uplynk/media/MediaPlayer$UplynkSegment;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 v3, 0x0

    aget-object v3, v10, v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/4 v4, 0x1

    aget-object v4, v10, v4

    invoke-static {v4}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    const/4 v6, 0x2

    aget-object v6, v10, v6

    invoke-static {v6}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v6

    const/4 v8, 0x3

    aget-object v8, v10, v8

    invoke-direct/range {v1 .. v8}, Lcom/uplynk/media/MediaPlayer$UplynkSegment;-><init>(Lcom/uplynk/media/MediaPlayer;CDDLjava/lang/String;)V

    .line 1552
    .local v1, "us":Lcom/uplynk/media/MediaPlayer$UplynkSegment;
    invoke-virtual {v9, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 1562
    .end local v0    # "i":I
    .end local v1    # "us":Lcom/uplynk/media/MediaPlayer$UplynkSegment;
    .end local v9    # "list":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/uplynk/media/MediaPlayer$UplynkSegment;>;"
    .end local v10    # "params":[Ljava/lang/String;
    .end local v11    # "segments":[Ljava/lang/String;
    .end local v12    # "str":Ljava/lang/String;
    :cond_4
    const-string v3, "upLynkMediaPlayer"

    const-string v4, "postSegmentListFromNative : No Data"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private static postTrackOptionsFromNative(Ljava/lang/Object;I[C)V
    .locals 15
    .param p0, "mediaplayer_ref"    # Ljava/lang/Object;
    .param p1, "size"    # I
    .param p2, "data"    # [C

    .prologue
    .line 1438
    check-cast p0, Ljava/lang/ref/WeakReference;

    .end local p0    # "mediaplayer_ref":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/uplynk/media/MediaPlayer;

    .line 1439
    .local v2, "mp":Lcom/uplynk/media/MediaPlayer;
    if-nez v2, :cond_1

    .line 1480
    :cond_0
    :goto_0
    return-void

    .line 1442
    :cond_1
    if-lez p1, :cond_7

    .line 1444
    new-instance v12, Ljava/lang/String;

    move-object/from16 v0, p2

    invoke-direct {v12, v0}, Ljava/lang/String;-><init>([C)V

    .line 1445
    .local v12, "str":Ljava/lang/String;
    invoke-virtual {v12}, Ljava/lang/String;->trim()Ljava/lang/String;

    .line 1447
    const-string v3, "\\|"

    invoke-virtual {v12, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v13

    .line 1451
    .local v13, "streams":[Ljava/lang/String;
    iget-object v3, v2, Lcom/uplynk/media/MediaPlayer;->_trackOptions:Landroid/util/SparseArray;

    invoke-virtual {v3}, Landroid/util/SparseArray;->clear()V

    .line 1454
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_1
    array-length v3, v13

    if-ge v10, v3, :cond_0

    .line 1457
    aget-object v3, v13, v10

    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 1458
    .local v11, "params":[Ljava/lang/String;
    array-length v3, v11

    const/16 v4, 0x8

    if-eq v3, v4, :cond_2

    .line 1460
    const-string v3, "upLynkMediaPlayer"

    const-string v4, "Skipping Invalid Track Params: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aget-object v7, v13, v10

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1454
    :goto_2
    add-int/lit8 v10, v10, 0x1

    goto :goto_1

    .line 1464
    :cond_2
    new-instance v1, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 v3, 0x0

    aget-object v3, v11, v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/4 v4, 0x1

    aget-object v4, v11, v4

    const/4 v5, 0x2

    aget-object v5, v11, v5

    const/4 v6, 0x3

    aget-object v6, v11, v6

    const/4 v7, 0x4

    aget-object v7, v11, v7

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Ljava/lang/String;->charAt(I)C

    move-result v7

    const/16 v8, 0x59

    if-ne v7, v8, :cond_4

    const/4 v7, 0x1

    :goto_3
    const/4 v8, 0x5

    aget-object v8, v11, v8

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Ljava/lang/String;->charAt(I)C

    move-result v8

    const/16 v9, 0x59

    if-ne v8, v9, :cond_5

    const/4 v8, 0x1

    :goto_4
    const/4 v9, 0x6

    aget-object v9, v11, v9

    const/4 v14, 0x0

    invoke-virtual {v9, v14}, Ljava/lang/String;->charAt(I)C

    move-result v9

    const/16 v14, 0x59

    if-ne v9, v14, :cond_6

    const/4 v9, 0x1

    :goto_5
    invoke-direct/range {v1 .. v9}, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;-><init>(Lcom/uplynk/media/MediaPlayer;CLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V

    .line 1467
    .local v1, "ti":Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;
    iget-object v3, v2, Lcom/uplynk/media/MediaPlayer;->_trackOptions:Landroid/util/SparseArray;

    invoke-virtual {v1}, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->getType()C

    move-result v4

    invoke-virtual {v3, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    if-nez v3, :cond_3

    .line 1468
    iget-object v3, v2, Lcom/uplynk/media/MediaPlayer;->_trackOptions:Landroid/util/SparseArray;

    invoke-virtual {v1}, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->getType()C

    move-result v4

    new-instance v5, Ljava/util/Vector;

    invoke-direct {v5}, Ljava/util/Vector;-><init>()V

    invoke-virtual {v3, v4, v5}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 1471
    :cond_3
    iget-object v3, v2, Lcom/uplynk/media/MediaPlayer;->_trackOptions:Landroid/util/SparseArray;

    invoke-virtual {v1}, Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;->getType()C

    move-result v4

    invoke-virtual {v3, v4}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Vector;

    invoke-virtual {v3, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 1464
    .end local v1    # "ti":Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;
    :cond_4
    const/4 v7, 0x0

    goto :goto_3

    :cond_5
    const/4 v8, 0x0

    goto :goto_4

    :cond_6
    const/4 v9, 0x0

    goto :goto_5

    .line 1479
    .end local v10    # "i":I
    .end local v11    # "params":[Ljava/lang/String;
    .end local v12    # "str":Ljava/lang/String;
    .end local v13    # "streams":[Ljava/lang/String;
    :cond_7
    const-string v3, "upLynkMediaPlayer"

    const-string v4, "postTrackOptionsFromNative : No Data"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0
.end method

.method private native selectSecondaryTrack(II)I
.end method

.method private static native setAppInfo(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method private stayAwake(Z)V
    .locals 1
    .param p1, "awake"    # Z

    .prologue
    .line 305
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    if-eqz v0, :cond_0

    .line 306
    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v0

    if-nez v0, :cond_1

    .line 307
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->acquire()V

    .line 312
    :cond_0
    :goto_0
    iput-boolean p1, p0, Lcom/uplynk/media/MediaPlayer;->mStayAwake:Z

    .line 313
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->updateSurfaceScreenOn()V

    .line 314
    return-void

    .line 308
    :cond_1
    if-nez p1, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 309
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->release()V

    goto :goto_0
.end method

.method private native updateSurfaceBounds(IIII)V
.end method

.method private updateSurfaceScreenOn()V
    .locals 2

    .prologue
    .line 317
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    if-eqz v0, :cond_0

    .line 318
    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    iget-boolean v0, p0, Lcom/uplynk/media/MediaPlayer;->mScreenOnWhilePlaying:Z

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/uplynk/media/MediaPlayer;->mStayAwake:Z

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-interface {v1, v0}, Landroid/view/SurfaceHolder;->setKeepScreenOn(Z)V

    .line 320
    :cond_0
    return-void

    .line 318
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public canPause()Z
    .locals 1

    .prologue
    .line 569
    invoke-virtual {p0}, Lcom/uplynk/media/MediaPlayer;->isLive()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public canSeekBackward()Z
    .locals 1

    .prologue
    .line 574
    invoke-virtual {p0}, Lcom/uplynk/media/MediaPlayer;->isLive()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public canSeekForward()Z
    .locals 1

    .prologue
    .line 579
    invoke-virtual {p0}, Lcom/uplynk/media/MediaPlayer;->isLive()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public native getAudioSessionId()I
.end method

.method public getAudioTrackOptions()Ljava/util/Vector;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Vector",
            "<",
            "Lcom/uplynk/media/MediaPlayer$UplynkTrackInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1420
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_trackOptions:Landroid/util/SparseArray;

    const/16 v1, 0x41

    invoke-virtual {v0, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Vector;

    return-object v0
.end method

.method public native getCurrentPosition()I
.end method

.method public native getDuration()I
.end method

.method public getState()I
    .locals 1

    .prologue
    .line 441
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->getContentState()I

    move-result v0

    return v0
.end method

.method public native getVideoHeight()I
.end method

.method public native getVideoWidth()I
.end method

.method public hasCaptions()Z
    .locals 1

    .prologue
    .line 512
    iget-boolean v0, p0, Lcom/uplynk/media/MediaPlayer;->_hasCaptions:Z

    return v0
.end method

.method protected hasNativeContext()Z
    .locals 1

    .prologue
    .line 168
    iget v0, p0, Lcom/uplynk/media/MediaPlayer;->mNativeContext:I

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public native isLive()Z
.end method

.method public native isPlaying()Z
.end method

.method public pause()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 421
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/uplynk/media/MediaPlayer;->stayAwake(Z)V

    .line 422
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->_pause()V

    .line 423
    return-void
.end method

.method public native prepare()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public native prepareAsync()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public release()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 334
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    if-eqz v0, :cond_0

    .line 337
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer$EventHandler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 344
    :cond_0
    invoke-virtual {p0}, Lcom/uplynk/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 346
    invoke-virtual {p0}, Lcom/uplynk/media/MediaPlayer;->stop()V

    .line 349
    :cond_1
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/uplynk/media/MediaPlayer;->stayAwake(Z)V

    .line 350
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->updateSurfaceScreenOn()V

    .line 353
    invoke-virtual {p0, v1}, Lcom/uplynk/media/MediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 355
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnAssetBoundaryListener:Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;

    .line 356
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnPreparedListener:Lcom/uplynk/media/MediaPlayer$OnPreparedListener;

    .line 357
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnBufferingUpdateListener:Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;

    .line 358
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnCaptionEventListener:Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;

    .line 359
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnCompletionListener:Lcom/uplynk/media/MediaPlayer$OnCompletionListener;

    .line 360
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnSeekCompleteListener:Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;

    .line 361
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnErrorListener:Lcom/uplynk/media/MediaPlayer$OnErrorListener;

    .line 362
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnInfoListener:Lcom/uplynk/media/MediaPlayer$OnInfoListener;

    .line 363
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnVideoSizeChangedListener:Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;

    .line 364
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnUplynkMetadataListener:Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;

    .line 365
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnID3MetadataListener:Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;

    .line 366
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mOnUplynkSegmentListener:Lcom/uplynk/media/MediaPlayer$OnUplynkSegmentListener;

    .line 368
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v0, :cond_2

    .line 370
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager;->release()V

    .line 371
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    .line 375
    :cond_2
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->disposePlayer()V

    .line 377
    const-string v0, "upLynkMediaPlayer"

    const-string v1, "MediaPlayer Released"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 378
    return-void
.end method

.method public reset()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 451
    invoke-direct {p0, v1}, Lcom/uplynk/media/MediaPlayer;->stayAwake(Z)V

    .line 452
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v0, :cond_0

    .line 453
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager;->reset()V

    .line 454
    :cond_0
    iput-boolean v1, p0, Lcom/uplynk/media/MediaPlayer;->_hasCaptions:Z

    .line 455
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->_reset()V

    .line 457
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mEventHandler:Lcom/uplynk/media/MediaPlayer$EventHandler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/uplynk/media/MediaPlayer$EventHandler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 458
    return-void
.end method

.method public seekTo(I)V
    .locals 1
    .param p1, "msec"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 435
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v0, :cond_0

    .line 436
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager;->reset()V

    .line 437
    :cond_0
    invoke-direct {p0, p1}, Lcom/uplynk/media/MediaPlayer;->_seekTo(I)V

    .line 438
    return-void
.end method

.method public selectAudioTrack(I)Z
    .locals 1
    .param p1, "trackIndex"    # I

    .prologue
    const/4 v0, 0x1

    .line 1431
    invoke-direct {p0, v0, p1}, Lcom/uplynk/media/MediaPlayer;->selectSecondaryTrack(II)I

    .line 1432
    return v0
.end method

.method public native setAudioSessionId(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public setAudioStreamType(I)V
    .locals 0
    .param p1, "type"    # I

    .prologue
    .line 585
    return-void
.end method

.method public setCaptionChannel(I)Z
    .locals 2
    .param p1, "channel"    # I

    .prologue
    .line 539
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v0, :cond_0

    .line 540
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    add-int/lit8 v1, p1, -0x1

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionManager;->setPreferredCaptionChannel(I)Z

    move-result v0

    .line 542
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setCaptionLayoutContainer(Landroid/widget/RelativeLayout;)V
    .locals 1
    .param p1, "layout"    # Landroid/widget/RelativeLayout;

    .prologue
    .line 1614
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v0, :cond_0

    .line 1615
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v0, p1}, Lcom/uplynk/media/CaptionManager;->setLayoutContainer(Landroid/widget/RelativeLayout;)V

    .line 1616
    :cond_0
    return-void
.end method

.method public setCaptionPreviewText(IILjava/lang/String;)V
    .locals 1
    .param p1, "row"    # I
    .param p2, "column"    # I
    .param p3, "text"    # Ljava/lang/String;

    .prologue
    .line 553
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v0, :cond_0

    .line 554
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v0, p1, p2, p3}, Lcom/uplynk/media/CaptionManager;->setPreviewText(IILjava/lang/String;)V

    .line 555
    :cond_0
    return-void
.end method

.method public setCaptionPreviewText(Ljava/lang/String;)V
    .locals 2
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 564
    const/4 v0, 0x7

    const/4 v1, 0x5

    invoke-virtual {p0, v0, v1, p1}, Lcom/uplynk/media/MediaPlayer;->setCaptionPreviewText(IILjava/lang/String;)V

    .line 565
    return-void
.end method

.method public setCaptionStyle(Lcom/uplynk/media/CaptionStyle;)V
    .locals 1
    .param p1, "style"    # Lcom/uplynk/media/CaptionStyle;

    .prologue
    .line 527
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v0, :cond_0

    .line 528
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v0, p1}, Lcom/uplynk/media/CaptionManager;->setCaptionStyle(Lcom/uplynk/media/CaptionStyle;)V

    .line 529
    :cond_0
    return-void
.end method

.method public setCaptionsEnabled(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 517
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v0, :cond_0

    .line 518
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v0, p1}, Lcom/uplynk/media/CaptionManager;->setEnabled(Z)V

    .line 519
    :cond_0
    return-void
.end method

.method public setContext(Landroid/content/Context;)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;

    .prologue
    .line 392
    if-eqz p1, :cond_0

    .line 393
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/uplynk/media/MediaPlayer;->setAppInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 405
    :cond_0
    return-void
.end method

.method public setDataSource(Ljava/lang/String;)V
    .locals 6
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 271
    const/4 v2, 0x0

    .line 274
    .local v2, "url":Ljava/net/URL;
    :try_start_0
    new-instance v3, Ljava/net/URL;

    invoke-direct {v3, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .line 279
    .end local v2    # "url":Ljava/net/URL;
    .local v3, "url":Ljava/net/URL;
    :try_start_1
    invoke-virtual {v3}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 281
    .local v0, "host":Ljava/lang/String;
    const-string v4, "uplynk.com"

    invoke-virtual {v0, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    const-string v4, "uplynk.dev"

    invoke-virtual {v0, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 282
    :cond_0
    invoke-direct {p0, p1}, Lcom/uplynk/media/MediaPlayer;->_setDataSource(Ljava/lang/String;)V

    .line 293
    return-void

    .line 284
    :cond_1
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "upLynk Source Expected"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_1
    .catch Ljava/net/MalformedURLException; {:try_start_1 .. :try_end_1} :catch_0

    .line 289
    .end local v0    # "host":Ljava/lang/String;
    :catch_0
    move-exception v1

    move-object v2, v3

    .line 291
    .end local v3    # "url":Ljava/net/URL;
    .local v1, "mexp":Ljava/net/MalformedURLException;
    .restart local v2    # "url":Ljava/net/URL;
    :goto_0
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Invalid Content URL"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 289
    .end local v1    # "mexp":Ljava/net/MalformedURLException;
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method public setDisplay(Landroid/view/SurfaceHolder;)V
    .locals 8
    .param p1, "sh"    # Landroid/view/SurfaceHolder;

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 221
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    if-eqz v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    iget-object v3, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceListener:Lcom/uplynk/media/MediaPlayer$SurfaceListener;

    invoke-interface {v0, v3}, Landroid/view/SurfaceHolder;->removeCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 226
    :cond_0
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 228
    if-eqz p1, :cond_4

    .line 232
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v0

    if-eqz v0, :cond_3

    sget v0, Lcom/uplynk/media/MediaPlayer;->mSurfaceType:I

    if-gtz v0, :cond_1

    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Surface;->isValid()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 234
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceListener:Lcom/uplynk/media/MediaPlayer$SurfaceListener;

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 235
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v0

    iput-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mSurface:Landroid/view/Surface;

    .line 262
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurfaceFrame()Landroid/graphics/Rect;

    move-result-object v7

    .line 264
    .local v7, "r":Landroid/graphics/Rect;
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v1

    iget v2, v7, Landroid/graphics/Rect;->left:I

    iget v3, v7, Landroid/graphics/Rect;->top:I

    iget v4, v7, Landroid/graphics/Rect;->right:I

    iget v5, v7, Landroid/graphics/Rect;->bottom:I

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/uplynk/media/MediaPlayer;->_setSurface(Landroid/view/Surface;IIII)V

    .line 266
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->updateSurfaceScreenOn()V

    .line 267
    .end local v7    # "r":Landroid/graphics/Rect;
    :cond_2
    :goto_0
    return-void

    .line 239
    :cond_3
    const-string v0, "upLynkMediaPlayer"

    const-string v3, "Surface is invalid"

    invoke-static {v0, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 240
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 241
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mSurface:Landroid/view/Surface;

    move-object v0, p0

    move v3, v2

    move v4, v2

    move v5, v2

    .line 242
    invoke-direct/range {v0 .. v5}, Lcom/uplynk/media/MediaPlayer;->_setSurface(Landroid/view/Surface;IIII)V

    goto :goto_0

    .line 248
    :cond_4
    iput-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mSurface:Landroid/view/Surface;

    .line 249
    iget v0, p0, Lcom/uplynk/media/MediaPlayer;->mNativeContext:I

    if-eqz v0, :cond_2

    sget v0, Lcom/uplynk/media/MediaPlayer;->mSurfaceType:I

    if-nez v0, :cond_2

    .line 252
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    :try_start_0
    invoke-direct/range {v0 .. v5}, Lcom/uplynk/media/MediaPlayer;->_setSurface(Landroid/view/Surface;IIII)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 254
    :catch_0
    move-exception v6

    .line 256
    .local v6, "ise":Ljava/lang/IllegalStateException;
    const-string v0, "upLynkMediaPlayer"

    const-string v1, "Ignoring IllegalStateException on _setSurface(null, 0, 0, 0, 0)"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public native setMaxBitrate(I)V
.end method

.method public setOnAssetBoundaryListener(Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;

    .prologue
    .line 1128
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnAssetBoundaryListener:Lcom/uplynk/media/MediaPlayer$OnAssetBoundaryListener;

    .line 1129
    return-void
.end method

.method public setOnBufferingUpdateListener(Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;

    .prologue
    .line 905
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnBufferingUpdateListener:Lcom/uplynk/media/MediaPlayer$OnBufferingUpdateListener;

    .line 906
    return-void
.end method

.method public setOnCaptionEventListener(Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;

    .prologue
    .line 1625
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnCaptionEventListener:Lcom/uplynk/media/MediaPlayer$OnCaptionEventListener;

    .line 1626
    return-void
.end method

.method public setOnCompletionListener(Lcom/uplynk/media/MediaPlayer$OnCompletionListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnCompletionListener;

    .prologue
    .line 876
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnCompletionListener:Lcom/uplynk/media/MediaPlayer$OnCompletionListener;

    .line 877
    return-void
.end method

.method public setOnErrorListener(Lcom/uplynk/media/MediaPlayer$OnErrorListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnErrorListener;

    .prologue
    .line 1025
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnErrorListener:Lcom/uplynk/media/MediaPlayer$OnErrorListener;

    .line 1026
    return-void
.end method

.method public setOnID3MetadataListener(Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;

    .prologue
    .line 1138
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnID3MetadataListener:Lcom/uplynk/media/MediaPlayer$OnID3MetadataListener;

    .line 1139
    return-void
.end method

.method public setOnInfoListener(Lcom/uplynk/media/MediaPlayer$OnInfoListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnInfoListener;

    .prologue
    .line 1105
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnInfoListener:Lcom/uplynk/media/MediaPlayer$OnInfoListener;

    .line 1106
    return-void
.end method

.method public setOnPreparedListener(Lcom/uplynk/media/MediaPlayer$OnPreparedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnPreparedListener;

    .prologue
    .line 849
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnPreparedListener:Lcom/uplynk/media/MediaPlayer$OnPreparedListener;

    .line 850
    return-void
.end method

.method public setOnSeekCompleteListener(Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;

    .prologue
    .line 932
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnSeekCompleteListener:Lcom/uplynk/media/MediaPlayer$OnSeekCompleteListener;

    .line 933
    return-void
.end method

.method public setOnUplynkMetadataListener(Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;

    .prologue
    .line 1154
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnUplynkMetadataListener:Lcom/uplynk/media/MediaPlayer$OnUplynkMetadataListener;

    .line 1155
    return-void
.end method

.method public setOnUplynkSegmentListener(Lcom/uplynk/media/MediaPlayer$OnUplynkSegmentListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnUplynkSegmentListener;

    .prologue
    .line 1518
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnUplynkSegmentListener:Lcom/uplynk/media/MediaPlayer$OnUplynkSegmentListener;

    .line 1519
    return-void
.end method

.method public setOnVideoSizeChangedListener(Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;

    .prologue
    .line 961
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mOnVideoSizeChangedListener:Lcom/uplynk/media/MediaPlayer$OnVideoSizeChangedListener;

    .line 962
    return-void
.end method

.method public setScreenOnWhilePlaying(Z)V
    .locals 1
    .param p1, "screenOn"    # Z

    .prologue
    .line 298
    iget-boolean v0, p0, Lcom/uplynk/media/MediaPlayer;->mScreenOnWhilePlaying:Z

    if-eq v0, p1, :cond_0

    .line 299
    iput-boolean p1, p0, Lcom/uplynk/media/MediaPlayer;->mScreenOnWhilePlaying:Z

    .line 300
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->updateSurfaceScreenOn()V

    .line 302
    :cond_0
    return-void
.end method

.method public setSurface(Landroid/view/Surface;)V
    .locals 7
    .param p1, "surface"    # Landroid/view/Surface;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 193
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    if-eqz v0, :cond_0

    .line 194
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    iget-object v1, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceListener:Lcom/uplynk/media/MediaPlayer$SurfaceListener;

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->removeCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 197
    :cond_0
    iput-object v3, p0, Lcom/uplynk/media/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 198
    iput-object v3, p0, Lcom/uplynk/media/MediaPlayer;->mSurface:Landroid/view/Surface;

    .line 200
    if-nez p1, :cond_2

    .line 202
    iget v0, p0, Lcom/uplynk/media/MediaPlayer;->mNativeContext:I

    if-eqz v0, :cond_1

    .line 205
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    :try_start_0
    invoke-direct/range {v0 .. v5}, Lcom/uplynk/media/MediaPlayer;->_setSurface(Landroid/view/Surface;IIII)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 218
    :cond_1
    :goto_0
    return-void

    .line 206
    :catch_0
    move-exception v6

    .line 208
    .local v6, "ise":Ljava/lang/IllegalStateException;
    const-string v0, "upLynkMediaPlayer"

    const-string v1, "Ignoring IllegalStateException on _setSurface(null, 0, 0, 0, 0)"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 215
    .end local v6    # "ise":Ljava/lang/IllegalStateException;
    :cond_2
    iput-object p1, p0, Lcom/uplynk/media/MediaPlayer;->mSurface:Landroid/view/Surface;

    move-object v0, p0

    move-object v1, p1

    move v3, v2

    move v4, v2

    move v5, v2

    .line 216
    invoke-direct/range {v0 .. v5}, Lcom/uplynk/media/MediaPlayer;->_setSurface(Landroid/view/Surface;IIII)V

    goto :goto_0
.end method

.method public native setVolume(FF)V
.end method

.method public start()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 409
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->getContentState()I

    move-result v0

    .line 412
    .local v0, "state":I
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/uplynk/media/MediaPlayer;->stayAwake(Z)V

    .line 414
    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 415
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->_resume()V

    .line 418
    :goto_0
    return-void

    .line 417
    :cond_0
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->_start()V

    goto :goto_0
.end method

.method public stop()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 427
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/uplynk/media/MediaPlayer;->stayAwake(Z)V

    .line 428
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    if-eqz v0, :cond_0

    .line 429
    iget-object v0, p0, Lcom/uplynk/media/MediaPlayer;->_ccManager:Lcom/uplynk/media/CaptionManager;

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager;->reset()V

    .line 430
    :cond_0
    invoke-direct {p0}, Lcom/uplynk/media/MediaPlayer;->_stop()V

    .line 431
    return-void
.end method
