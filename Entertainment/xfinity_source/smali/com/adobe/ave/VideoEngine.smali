.class public Lcom/adobe/ave/VideoEngine;
.super Ljava/lang/Object;
.source "VideoEngine.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/ave/VideoEngine$EventHandler;,
        Lcom/adobe/ave/VideoEngine$customMessage;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "VideoEngine(j)"

.field private static final kCTBackgroundManifestError:I = 0x4000

.field private static final kCTBackgroundManifestWarning:I = 0x8000

.field private static final kCTDRMError:I = 0x2000

.field private static final kCTDRMMetadata:I = 0x10

.field private static final kCTData:I = 0x40

.field private static final kCTDictionaryData:I = 0x400

.field private static final kCTError:I = 0x1

.field private static final kCTLoadInfo:I = 0x800

.field private static final kCTManifestLoad:I = 0x80

.field private static final kCTPlayState:I = 0x2

.field private static final kCTSeekComplete:I = 0x100

.field private static final kCTStreamMetadata:I = 0x8

.field private static final kCTStreamSwitch:I = 0x4

.field private static final kCTTimeline:I = 0x20

.field private static final kCTTrickPlayEnded:I = 0x1000

.field private static final kCTWarning:I = 0x200


# instance fields
.field private mEnableCaption:Z

.field private mEventHandler:Lcom/adobe/ave/VideoEngine$EventHandler;

.field private mListener:Lcom/adobe/ave/VideoEngineListener;

.field private mListenerTypeSet:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/adobe/ave/ListenerType;",
            ">;"
        }
    .end annotation
.end field

.field private mNativeContext:J

.field private mVideoView:Lcom/adobe/ave/VideoEngineView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 152
    const-string v0, "AVEAndroid"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 153
    invoke-static {}, Lcom/adobe/ave/VideoEngine;->nativeInitVideoEngine()V

    .line 154
    return-void
.end method

.method public constructor <init>()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 172
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput-object v2, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    .line 46
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/adobe/ave/VideoEngine;->mEnableCaption:Z

    .line 173
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 177
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    .local v0, "looper":Landroid/os/Looper;
    if-eqz v0, :cond_0

    .line 178
    new-instance v1, Lcom/adobe/ave/VideoEngine$EventHandler;

    invoke-direct {v1, p0, p0, v0}, Lcom/adobe/ave/VideoEngine$EventHandler;-><init>(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/VideoEngine;Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/adobe/ave/VideoEngine;->mEventHandler:Lcom/adobe/ave/VideoEngine$EventHandler;

    .line 185
    :goto_0
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeCreateVideoEngine()V

    .line 186
    return-void

    .line 179
    :cond_0
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 180
    new-instance v1, Lcom/adobe/ave/VideoEngine$EventHandler;

    invoke-direct {v1, p0, p0, v0}, Lcom/adobe/ave/VideoEngine$EventHandler;-><init>(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/VideoEngine;Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/adobe/ave/VideoEngine;->mEventHandler:Lcom/adobe/ave/VideoEngine$EventHandler;

    goto :goto_0

    .line 182
    :cond_1
    iput-object v2, p0, Lcom/adobe/ave/VideoEngine;->mEventHandler:Lcom/adobe/ave/VideoEngine$EventHandler;

    goto :goto_0
.end method

.method static synthetic access$100(Lcom/adobe/ave/VideoEngine;)J
    .locals 2
    .param p0, "x0"    # Lcom/adobe/ave/VideoEngine;

    .prologue
    .line 42
    iget-wide v0, p0, Lcom/adobe/ave/VideoEngine;->mNativeContext:J

    return-wide v0
.end method

.method static synthetic access$200(Lcom/adobe/ave/VideoEngine;)Lcom/adobe/ave/VideoEngineListener;
    .locals 1
    .param p0, "x0"    # Lcom/adobe/ave/VideoEngine;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;

    return-object v0
.end method

.method static synthetic access$300(Lcom/adobe/ave/VideoEngine;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/adobe/ave/VideoEngine;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;

    return-object v0
.end method

.method private failIfNotUIThread()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 141
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 142
    new-instance v0, Lcom/adobe/ave/VideoEngineException;

    sget-object v1, Lcom/adobe/ave/MediaErrorCode;->CALLED_FROM_WRONG_THREAD:Lcom/adobe/ave/MediaErrorCode;

    const-string v2, "Method must be called from the application\'s main thread"

    invoke-direct {v0, v1, v2}, Lcom/adobe/ave/VideoEngineException;-><init>(Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V

    throw v0

    .line 143
    :cond_0
    return-void
.end method

.method public static getVersionString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 163
    invoke-static {}, Lcom/adobe/ave/VideoEngine;->nativeGetVersionString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private native nativeAddCustomHeader(Ljava/lang/String;[Ljava/lang/String;I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeAddListener(ILcom/adobe/ave/VideoEngineListener;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeCreateVideoEngine()V
.end method

.method private native nativeEnableCaptions(Z)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeFastForward(F)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeFinalize()V
.end method

.method private native nativeGetARCorrectedOutputRectangle()Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetBackgroundTimeline()Lcom/adobe/ave/Timeline;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetBufferLength()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetClientLivePoint()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetLocalTime(I)J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetPlayState()I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetQosBufferUnderrunCount()I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetQosDroppedFrameCount()I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetQosFileDuration()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetQosFileSize()I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetQosFrameRate()F
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetQosLoadTime()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetQosTimeToFirstByte()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetTime()J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetTimeline()Lcom/adobe/ave/Timeline;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private static native nativeGetVersionString()Ljava/lang/String;
.end method

.method private static final native nativeInitVideoEngine()V
.end method

.method private native nativeInjectData(IJ[BI)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeLoad(Ljava/lang/String;II)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeLoadWithBackgroundManifest(Ljava/lang/String;IILjava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativePause()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativePlay()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativePrepareBuffer()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeRelease()V
.end method

.method private native nativeReleaseGPUResources()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeRemoveListener(Lcom/adobe/ave/VideoEngineListener;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeReset()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeRewind(F)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSeek(JZ)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSeekToKeyFrame(JZ)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSeekToLivePoint()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSeekToLocalTime(IJ)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSelectTrack(III)I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetABRParameters(Lcom/adobe/ave/ABRParameters;)V
.end method

.method private native nativeSetBandwidth(I)V
.end method

.method private native nativeSetBufferTime(J)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetCaptionStyle([Ljava/lang/String;[Ljava/lang/String;I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetCuePointTags([Ljava/lang/String;I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetCustomConfiguration(Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetDRMManager(Lcom/adobe/ave/drm/DRMManager;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetInitialBufferTime(J)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetMasterUpdateInterval(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetNetworkingParameters(Lcom/adobe/ave/NetworkingParameters;)V
.end method

.method private native nativeSetPlaySpeed(FZ)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetSourceViewport(IIII)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetSubscribedTags([Ljava/lang/String;I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetSubscribedTagsForBackgroundManifest([Ljava/lang/String;I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetSurface(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetVolume(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeUseRedirectedUrl(Z)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativesetLocalStoragePath(Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private static postEventFromNative(Ljava/lang/Object;IIILjava/lang/Object;)V
    .locals 6
    .param p0, "videoEngine"    # Ljava/lang/Object;
    .param p1, "what"    # I
    .param p2, "arg1"    # I
    .param p3, "arg2"    # I
    .param p4, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 1114
    move-object v0, p0

    check-cast v0, Lcom/adobe/ave/VideoEngine;

    .line 1115
    .local v0, "Ve":Lcom/adobe/ave/VideoEngine;
    if-eqz v0, :cond_1

    move v2, v3

    :goto_0
    iget-object v5, v0, Lcom/adobe/ave/VideoEngine;->mEventHandler:Lcom/adobe/ave/VideoEngine$EventHandler;

    if-eqz v5, :cond_2

    :goto_1
    and-int/2addr v2, v3

    if-eqz v2, :cond_0

    .line 1116
    iget-object v2, v0, Lcom/adobe/ave/VideoEngine;->mEventHandler:Lcom/adobe/ave/VideoEngine$EventHandler;

    invoke-virtual {v2, p1, p2, p3, p4}, Lcom/adobe/ave/VideoEngine$EventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .line 1117
    .local v1, "m":Landroid/os/Message;
    iget-object v2, v0, Lcom/adobe/ave/VideoEngine;->mEventHandler:Lcom/adobe/ave/VideoEngine$EventHandler;

    invoke-virtual {v2, v1}, Lcom/adobe/ave/VideoEngine$EventHandler;->sendMessage(Landroid/os/Message;)Z

    .line 1123
    .end local v1    # "m":Landroid/os/Message;
    :cond_0
    return-void

    :cond_1
    move v2, v4

    .line 1115
    goto :goto_0

    :cond_2
    move v3, v4

    goto :goto_1
.end method

.method private static postEventFromNativeEx(Ljava/lang/Object;IIIJJLjava/lang/Object;)V
    .locals 12
    .param p0, "videoEngine"    # Ljava/lang/Object;
    .param p1, "what"    # I
    .param p2, "n1"    # I
    .param p3, "n2"    # I
    .param p4, "l1"    # J
    .param p6, "l2"    # J
    .param p8, "obj"    # Ljava/lang/Object;

    .prologue
    .line 1150
    move-object v0, p0

    check-cast v0, Lcom/adobe/ave/VideoEngine;

    .line 1151
    .local v0, "Ve":Lcom/adobe/ave/VideoEngine;
    if-eqz v0, :cond_1

    const/4 v2, 0x1

    :goto_0
    iget-object v3, v0, Lcom/adobe/ave/VideoEngine;->mEventHandler:Lcom/adobe/ave/VideoEngine$EventHandler;

    if-eqz v3, :cond_2

    const/4 v3, 0x1

    :goto_1
    and-int/2addr v2, v3

    if-eqz v2, :cond_0

    .line 1152
    new-instance v1, Lcom/adobe/ave/VideoEngine$customMessage;

    const/4 v9, 0x0

    move v2, p2

    move v3, p3

    move-wide/from16 v4, p4

    move-wide/from16 v6, p6

    move-object/from16 v8, p8

    invoke-direct/range {v1 .. v9}, Lcom/adobe/ave/VideoEngine$customMessage;-><init>(IIJJLjava/lang/Object;Lcom/adobe/ave/VideoEngine$1;)V

    .line 1153
    .local v1, "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    iget-object v2, v0, Lcom/adobe/ave/VideoEngine;->mEventHandler:Lcom/adobe/ave/VideoEngine$EventHandler;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v2, p1, v3, v4, v1}, Lcom/adobe/ave/VideoEngine$EventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v10

    .line 1154
    .local v10, "m":Landroid/os/Message;
    iget-object v2, v0, Lcom/adobe/ave/VideoEngine;->mEventHandler:Lcom/adobe/ave/VideoEngine$EventHandler;

    invoke-virtual {v2, v10}, Lcom/adobe/ave/VideoEngine$EventHandler;->sendMessage(Landroid/os/Message;)Z

    .line 1160
    .end local v1    # "customMsg":Lcom/adobe/ave/VideoEngine$customMessage;
    .end local v10    # "m":Landroid/os/Message;
    :cond_0
    return-void

    .line 1151
    :cond_1
    const/4 v2, 0x0

    goto :goto_0

    :cond_2
    const/4 v3, 0x0

    goto :goto_1
.end method


# virtual methods
.method public addCustomHeader(Ljava/lang/String;[Ljava/lang/String;I)V
    .locals 0
    .param p1, "headerName"    # Ljava/lang/String;
    .param p2, "headerData"    # [Ljava/lang/String;
    .param p3, "arraySize"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 1096
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 1097
    invoke-direct {p0, p1, p2, p3}, Lcom/adobe/ave/VideoEngine;->nativeAddCustomHeader(Ljava/lang/String;[Ljava/lang/String;I)V

    .line 1098
    return-void
.end method

.method public addListener(Ljava/util/Set;Lcom/adobe/ave/VideoEngineListener;)V
    .locals 2
    .param p2, "listener"    # Lcom/adobe/ave/VideoEngineListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Lcom/adobe/ave/ListenerType;",
            ">;",
            "Lcom/adobe/ave/VideoEngineListener;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 417
    .local p1, "listenerTypeSet":Ljava/util/Set;, "Ljava/util/Set<Lcom/adobe/ave/ListenerType;>;"
    const/4 v0, 0x0

    .line 418
    .local v0, "lisenerTypeBit":I
    iput-object p1, p0, Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;

    .line 420
    sget-object v1, Lcom/adobe/ave/ListenerType;->ERROR:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 421
    sget-object v1, Lcom/adobe/ave/ListenerType;->ERROR:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 423
    :cond_0
    sget-object v1, Lcom/adobe/ave/ListenerType;->PLAY_STATE:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 424
    sget-object v1, Lcom/adobe/ave/ListenerType;->PLAY_STATE:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 426
    :cond_1
    sget-object v1, Lcom/adobe/ave/ListenerType;->STREAM_SWITCH:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 427
    sget-object v1, Lcom/adobe/ave/ListenerType;->STREAM_SWITCH:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 429
    :cond_2
    sget-object v1, Lcom/adobe/ave/ListenerType;->STREAM_METADATA:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 430
    sget-object v1, Lcom/adobe/ave/ListenerType;->STREAM_METADATA:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 432
    :cond_3
    sget-object v1, Lcom/adobe/ave/ListenerType;->DRM_METADATA:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 433
    sget-object v1, Lcom/adobe/ave/ListenerType;->DRM_METADATA:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 435
    :cond_4
    sget-object v1, Lcom/adobe/ave/ListenerType;->TIMELINE:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 436
    sget-object v1, Lcom/adobe/ave/ListenerType;->TIMELINE:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 438
    :cond_5
    sget-object v1, Lcom/adobe/ave/ListenerType;->DATA:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 439
    sget-object v1, Lcom/adobe/ave/ListenerType;->DATA:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 441
    :cond_6
    sget-object v1, Lcom/adobe/ave/ListenerType;->MANIFEST_LOAD:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 442
    sget-object v1, Lcom/adobe/ave/ListenerType;->MANIFEST_LOAD:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 444
    :cond_7
    sget-object v1, Lcom/adobe/ave/ListenerType;->SEEK_COMPLETE:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 445
    sget-object v1, Lcom/adobe/ave/ListenerType;->SEEK_COMPLETE:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 447
    :cond_8
    sget-object v1, Lcom/adobe/ave/ListenerType;->WARNING:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 448
    sget-object v1, Lcom/adobe/ave/ListenerType;->WARNING:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 450
    :cond_9
    sget-object v1, Lcom/adobe/ave/ListenerType;->DICTIONARY_DATA:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 451
    sget-object v1, Lcom/adobe/ave/ListenerType;->DICTIONARY_DATA:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 453
    :cond_a
    sget-object v1, Lcom/adobe/ave/ListenerType;->LOAD_INFO:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 454
    sget-object v1, Lcom/adobe/ave/ListenerType;->LOAD_INFO:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 456
    :cond_b
    sget-object v1, Lcom/adobe/ave/ListenerType;->TRICK_PLAY_ENDED:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 457
    sget-object v1, Lcom/adobe/ave/ListenerType;->TRICK_PLAY_ENDED:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 459
    :cond_c
    sget-object v1, Lcom/adobe/ave/ListenerType;->DRM_ERROR:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 460
    sget-object v1, Lcom/adobe/ave/ListenerType;->DRM_ERROR:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 462
    :cond_d
    sget-object v1, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_ERROR:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 463
    sget-object v1, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_ERROR:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 465
    :cond_e
    sget-object v1, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_WARNING:Lcom/adobe/ave/ListenerType;

    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 466
    sget-object v1, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_WARNING:Lcom/adobe/ave/ListenerType;

    invoke-virtual {v1}, Lcom/adobe/ave/ListenerType;->getValue()I

    move-result v1

    or-int/2addr v0, v1

    .line 468
    :cond_f
    iget-object v1, p0, Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;

    if-eqz v1, :cond_10

    .line 469
    invoke-direct {p0, p2}, Lcom/adobe/ave/VideoEngine;->nativeRemoveListener(Lcom/adobe/ave/VideoEngineListener;)V

    .line 471
    :cond_10
    iput-object p2, p0, Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;

    .line 472
    invoke-direct {p0, v0, p2}, Lcom/adobe/ave/VideoEngine;->nativeAddListener(ILcom/adobe/ave/VideoEngineListener;)V

    .line 473
    return-void
.end method

.method public enableCaptions(Z)V
    .locals 2
    .param p1, "enable"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 813
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 814
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeEnableCaptions(Z)V

    .line 815
    iput-boolean p1, p0, Lcom/adobe/ave/VideoEngine;->mEnableCaption:Z

    .line 817
    iget-object v0, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_0

    .line 819
    iget-boolean v0, p0, Lcom/adobe/ave/VideoEngine;->mEnableCaption:Z

    if-ne v0, v1, :cond_1

    .line 820
    iget-object v0, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngineView;->setWillNotDrawCaption(Z)V

    .line 824
    :cond_0
    :goto_0
    return-void

    .line 822
    :cond_1
    iget-object v0, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngineView;->setWillNotDrawCaption(Z)V

    goto :goto_0
.end method

.method public fastForward(F)V
    .locals 0
    .param p1, "rate"    # F
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 787
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 788
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeFastForward(F)V

    .line 789
    return-void
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 207
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeFinalize()V

    .line 208
    return-void
.end method

.method public getARCorrectedOutputRectangle()Landroid/graphics/Rect;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 339
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 340
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetARCorrectedOutputRectangle()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Rect;

    return-object v0
.end method

.method public getBackgroundTimeline()Lcom/adobe/ave/Timeline;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 985
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 986
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetBackgroundTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    return-object v0
.end method

.method public getBufferLength()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 743
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 744
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetBufferLength()J

    move-result-wide v0

    return-wide v0
.end method

.method public getClientLivePoint()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 1082
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 1083
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetClientLivePoint()J

    move-result-wide v0

    return-wide v0
.end method

.method public getLocalTime(I)J
    .locals 2
    .param p1, "periodIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 708
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeGetLocalTime(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getPlayState()Lcom/adobe/ave/PlayState;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 670
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 671
    sget-object v2, Lcom/adobe/ave/PlayState;->UNINITIALIZED:Lcom/adobe/ave/PlayState;

    .line 672
    .local v2, "state":Lcom/adobe/ave/PlayState;
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetPlayState()I

    move-result v0

    .line 674
    .local v0, "nativeState":I
    invoke-static {}, Lcom/adobe/ave/PlayState;->values()[Lcom/adobe/ave/PlayState;

    move-result-object v4

    array-length v5, v4

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v1, v4, v3

    .line 676
    .local v1, "p":Lcom/adobe/ave/PlayState;
    invoke-virtual {v1}, Lcom/adobe/ave/PlayState;->getValue()I

    move-result v6

    if-ne v6, v0, :cond_1

    .line 678
    move-object v2, v1

    .line 683
    .end local v1    # "p":Lcom/adobe/ave/PlayState;
    :cond_0
    return-object v2

    .line 674
    .restart local v1    # "p":Lcom/adobe/ave/PlayState;
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method public getQosBufferUnderrunCount()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 961
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 962
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetQosBufferUnderrunCount()I

    move-result v0

    return v0
.end method

.method public getQosDroppedFrameCount()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 894
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 895
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetQosDroppedFrameCount()I

    move-result v0

    return v0
.end method

.method public getQosFileDuration()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 918
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetQosFileDuration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getQosFileSize()I
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 906
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 907
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetQosFileSize()I

    move-result v0

    return v0
.end method

.method public getQosFrameRate()F
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 881
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 882
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetQosFrameRate()F

    move-result v0

    return v0
.end method

.method public getQosLoadTime()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 933
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 934
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetQosLoadTime()J

    move-result-wide v0

    return-wide v0
.end method

.method public getQosTimeToFirstByte()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 947
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 948
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetQosTimeToFirstByte()J

    move-result-wide v0

    return-wide v0
.end method

.method public getTime()J
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 695
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 696
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetTime()J

    move-result-wide v0

    return-wide v0
.end method

.method public getTimeline()Lcom/adobe/ave/Timeline;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 973
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 974
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeGetTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    return-object v0
.end method

.method public injectData(Lcom/adobe/ave/DataType;J[BI)V
    .locals 6
    .param p1, "dataType"    # Lcom/adobe/ave/DataType;
    .param p2, "timestamp"    # J
    .param p4, "data"    # [B
    .param p5, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 503
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 504
    invoke-virtual {p1}, Lcom/adobe/ave/DataType;->getValue()I

    move-result v1

    move-object v0, p0

    move-wide v2, p2

    move-object v4, p4

    move v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/adobe/ave/VideoEngine;->nativeInjectData(IJ[BI)V

    .line 505
    return-void
.end method

.method public load(Ljava/lang/String;Lcom/adobe/ave/ContainerType;I)V
    .locals 1
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "type"    # Lcom/adobe/ave/ContainerType;
    .param p3, "userdata"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 254
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 255
    invoke-virtual {p2}, Lcom/adobe/ave/ContainerType;->getValue()I

    move-result v0

    invoke-direct {p0, p1, v0, p3}, Lcom/adobe/ave/VideoEngine;->nativeLoad(Ljava/lang/String;II)V

    .line 256
    return-void
.end method

.method public loadWithBackgroundManifest(Ljava/lang/String;Lcom/adobe/ave/ContainerType;ILjava/lang/String;)V
    .locals 1
    .param p1, "source"    # Ljava/lang/String;
    .param p2, "type"    # Lcom/adobe/ave/ContainerType;
    .param p3, "userdata"    # I
    .param p4, "backgroundManifest"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 274
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 275
    invoke-virtual {p2}, Lcom/adobe/ave/ContainerType;->getValue()I

    move-result v0

    invoke-direct {p0, p1, v0, p3, p4}, Lcom/adobe/ave/VideoEngine;->nativeLoadWithBackgroundManifest(Ljava/lang/String;IILjava/lang/String;)V

    .line 276
    return-void
.end method

.method public pause()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 545
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 546
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativePause()V

    .line 547
    return-void
.end method

.method public play()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 531
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 532
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativePlay()V

    .line 533
    return-void
.end method

.method public prepareBuffer()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 515
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 516
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativePrepareBuffer()V

    .line 517
    return-void
.end method

.method public release()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 196
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 197
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeRelease()V

    .line 198
    return-void
.end method

.method public releaseGPUResources()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 658
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 659
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeReleaseGPUResources()V

    .line 660
    return-void
.end method

.method public removeListener(Lcom/adobe/ave/VideoEngineListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/adobe/ave/VideoEngineListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 482
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeRemoveListener(Lcom/adobe/ave/VideoEngineListener;)V

    .line 483
    iput-object v0, p0, Lcom/adobe/ave/VideoEngine;->mListener:Lcom/adobe/ave/VideoEngineListener;

    .line 484
    iput-object v0, p0, Lcom/adobe/ave/VideoEngine;->mListenerTypeSet:Ljava/util/Set;

    .line 485
    return-void
.end method

.method public reset()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 639
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 641
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/adobe/ave/VideoEngine;->enableCaptions(Z)V

    .line 642
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeReset()V

    .line 643
    return-void
.end method

.method public rewind(F)V
    .locals 0
    .param p1, "rate"    # F
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 801
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 802
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeRewind(F)V

    .line 803
    return-void
.end method

.method public seek(JZ)V
    .locals 1
    .param p1, "time"    # J
    .param p3, "attemptInBufferSeek"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 567
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 568
    invoke-direct {p0, p1, p2, p3}, Lcom/adobe/ave/VideoEngine;->nativeSeek(JZ)V

    .line 569
    return-void
.end method

.method public seekToKeyFrame(JZ)V
    .locals 1
    .param p1, "time"    # J
    .param p3, "attemptInBufferSeek"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 624
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 625
    invoke-direct {p0, p1, p2, p3}, Lcom/adobe/ave/VideoEngine;->nativeSeekToKeyFrame(JZ)V

    .line 626
    return-void
.end method

.method public seekToLivePoint()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 602
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 603
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->nativeSeekToLivePoint()V

    .line 604
    return-void
.end method

.method public seekToLocalTime(IJ)V
    .locals 0
    .param p1, "periodIndex"    # I
    .param p2, "time"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 588
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 589
    invoke-direct {p0, p1, p2, p3}, Lcom/adobe/ave/VideoEngine;->nativeSeekToLocalTime(IJ)V

    .line 590
    return-void
.end method

.method public selectTrack(ILcom/adobe/ave/PayloadType;I)Lcom/adobe/ave/MediaErrorCode;
    .locals 7
    .param p1, "periodIndex"    # I
    .param p2, "type"    # Lcom/adobe/ave/PayloadType;
    .param p3, "trackIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 297
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 298
    invoke-virtual {p2}, Lcom/adobe/ave/PayloadType;->getValue()I

    move-result v3

    invoke-direct {p0, p1, v3, p3}, Lcom/adobe/ave/VideoEngine;->nativeSelectTrack(III)I

    move-result v0

    .line 300
    .local v0, "err":I
    sget-object v1, Lcom/adobe/ave/MediaErrorCode;->GENERIC_ERROR:Lcom/adobe/ave/MediaErrorCode;

    .line 301
    .local v1, "errorCode":Lcom/adobe/ave/MediaErrorCode;
    invoke-static {}, Lcom/adobe/ave/MediaErrorCode;->values()[Lcom/adobe/ave/MediaErrorCode;

    move-result-object v4

    array-length v5, v4

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v2, v4, v3

    .line 303
    .local v2, "m":Lcom/adobe/ave/MediaErrorCode;
    invoke-virtual {v2}, Lcom/adobe/ave/MediaErrorCode;->getValue()I

    move-result v6

    if-ne v6, v0, :cond_1

    .line 305
    move-object v1, v2

    .line 309
    .end local v2    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_0
    return-object v1

    .line 301
    .restart local v2    # "m":Lcom/adobe/ave/MediaErrorCode;
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method public setABRParameters(Lcom/adobe/ave/ABRParameters;)V
    .locals 0
    .param p1, "abrParams"    # Lcom/adobe/ave/ABRParameters;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 375
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 376
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeSetABRParameters(Lcom/adobe/ave/ABRParameters;)V

    .line 377
    return-void
.end method

.method public setBandwidth(I)V
    .locals 0
    .param p1, "bitsPerSecond"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 399
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 400
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeSetBandwidth(I)V

    .line 401
    return-void
.end method

.method public setBufferTime(J)V
    .locals 1
    .param p1, "bufferTime"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 732
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 733
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/VideoEngine;->nativeSetBufferTime(J)V

    .line 734
    return-void
.end method

.method public setCaptionStyle([Ljava/lang/String;[Ljava/lang/String;I)V
    .locals 0
    .param p1, "variableArray"    # [Ljava/lang/String;
    .param p2, "valueArray"    # [Ljava/lang/String;
    .param p3, "arraySize"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 868
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 869
    invoke-direct {p0, p1, p2, p3}, Lcom/adobe/ave/VideoEngine;->nativeSetCaptionStyle([Ljava/lang/String;[Ljava/lang/String;I)V

    .line 870
    return-void
.end method

.method public setCuePointTags([Ljava/lang/String;I)V
    .locals 0
    .param p1, "tagArray"    # [Ljava/lang/String;
    .param p2, "arraySize"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 999
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 1000
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/VideoEngine;->nativeSetCuePointTags([Ljava/lang/String;I)V

    .line 1001
    return-void
.end method

.method public setCustomConfiguration(Ljava/lang/String;)V
    .locals 0
    .param p1, "configuration"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 1103
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 1104
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeSetCustomConfiguration(Ljava/lang/String;)V

    .line 1105
    return-void
.end method

.method public setDRMManager(Lcom/adobe/ave/drm/DRMManager;)V
    .locals 0
    .param p1, "drmManager"    # Lcom/adobe/ave/drm/DRMManager;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 351
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 352
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeSetDRMManager(Lcom/adobe/ave/drm/DRMManager;)V

    .line 353
    return-void
.end method

.method public setInitialBufferTime(J)V
    .locals 1
    .param p1, "bufferTime"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 720
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 721
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/VideoEngine;->nativeSetInitialBufferTime(J)V

    .line 722
    return-void
.end method

.method public setLocalStoragePath(Ljava/lang/String;)V
    .locals 0
    .param p1, "localStoragePath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 363
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 364
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativesetLocalStoragePath(Ljava/lang/String;)V

    .line 365
    return-void
.end method

.method public setMasterUpdateInterval(I)V
    .locals 0
    .param p1, "interval"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 1070
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 1071
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeSetMasterUpdateInterval(I)V

    .line 1072
    return-void
.end method

.method public setNetworkingParameters(Lcom/adobe/ave/NetworkingParameters;)V
    .locals 0
    .param p1, "netParams"    # Lcom/adobe/ave/NetworkingParameters;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 387
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 388
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeSetNetworkingParameters(Lcom/adobe/ave/NetworkingParameters;)V

    .line 389
    return-void
.end method

.method public setPlaySpeed(FZ)V
    .locals 0
    .param p1, "speed"    # F
    .param p2, "muteAudio"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 773
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 774
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/VideoEngine;->nativeSetPlaySpeed(FZ)V

    .line 775
    return-void
.end method

.method public setScreenOnWhilePlaying(Z)V
    .locals 2
    .param p1, "screenOn"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 1041
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 1042
    iget-object v1, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v1, :cond_0

    .line 1044
    iget-object v1, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngineView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    .line 1045
    .local v0, "holder":Landroid/view/SurfaceHolder;
    invoke-interface {v0, p1}, Landroid/view/SurfaceHolder;->setKeepScreenOn(Z)V

    .line 1047
    .end local v0    # "holder":Landroid/view/SurfaceHolder;
    :cond_0
    return-void
.end method

.method public setSourceViewport(IIII)V
    .locals 0
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 324
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 325
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/adobe/ave/VideoEngine;->nativeSetSourceViewport(IIII)V

    .line 326
    return-void
.end method

.method public setSubscribedTags([Ljava/lang/String;I)V
    .locals 0
    .param p1, "tagArray"    # [Ljava/lang/String;
    .param p2, "arraySize"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 1014
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 1015
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/VideoEngine;->nativeSetSubscribedTags([Ljava/lang/String;I)V

    .line 1016
    return-void
.end method

.method public setSubscribedTagsForBackgroundManifest([Ljava/lang/String;I)V
    .locals 0
    .param p1, "tagArray"    # [Ljava/lang/String;
    .param p2, "arraySize"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 1029
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 1030
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/VideoEngine;->nativeSetSubscribedTagsForBackgroundManifest([Ljava/lang/String;I)V

    .line 1031
    return-void
.end method

.method public setView(Lcom/adobe/ave/VideoEngineView;)V
    .locals 4
    .param p1, "view"    # Lcom/adobe/ave/VideoEngineView;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 220
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeSetSurface(Ljava/lang/Object;)V

    .line 223
    if-nez p1, :cond_0

    .line 224
    iget-object v0, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v2, v3}, Lcom/adobe/ave/VideoEngineView;->setNativeInstance(J)V

    .line 226
    :cond_0
    iput-object p1, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    .line 228
    iget-object v0, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    if-eqz v0, :cond_1

    .line 230
    iget-boolean v0, p0, Lcom/adobe/ave/VideoEngine;->mEnableCaption:Z

    if-ne v0, v1, :cond_2

    .line 231
    iget-object v0, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngineView;->setWillNotDrawCaption(Z)V

    .line 235
    :cond_1
    :goto_0
    return-void

    .line 233
    :cond_2
    iget-object v0, p0, Lcom/adobe/ave/VideoEngine;->mVideoView:Lcom/adobe/ave/VideoEngineView;

    invoke-virtual {v0, v1}, Lcom/adobe/ave/VideoEngineView;->setWillNotDrawCaption(Z)V

    goto :goto_0
.end method

.method public setVolume(I)V
    .locals 0
    .param p1, "volume"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 756
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 757
    invoke-direct {p0, p1}, Lcom/adobe/ave/VideoEngine;->nativeSetVolume(I)V

    .line 758
    return-void
.end method

.method public useRedirectedUrl(Z)V
    .locals 1
    .param p1, "val"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x1

    .line 1058
    invoke-direct {p0}, Lcom/adobe/ave/VideoEngine;->failIfNotUIThread()V

    .line 1059
    if-ne p1, v0, :cond_0

    :goto_0
    invoke-direct {p0, v0}, Lcom/adobe/ave/VideoEngine;->nativeUseRedirectedUrl(Z)V

    .line 1060
    return-void

    .line 1059
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
