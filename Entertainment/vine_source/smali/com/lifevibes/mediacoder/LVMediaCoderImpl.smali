.class public Lcom/lifevibes/mediacoder/LVMediaCoderImpl;
.super Ljava/lang/Object;
.source "LVMediaCoderImpl.java"

# interfaces
.implements Lcom/lifevibes/mediacoder/LVMediaCoder;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x10
.end annotation


# static fields
.field private static final AAC_ADTS:Ljava/lang/String; = "audio/mp4a-latm"

.field private static final AUDIO_SAMPLE_SIZE:I = 0x2

.field public static final H264_AVC:Ljava/lang/String; = "video/avc"

.field private static final PCM_SIZE_MONO:I = 0x800

.field private static final PCM_SIZE_STEREO:I = 0x1000

.field private static final TAG:Ljava/lang/String; = "LVMediaCoderImpl"

.field static isRunningOnICS:Z

.field static mAudioDSI:[B

.field static mVideoDSI:[B

.field private static outData:Ljava/nio/ByteBuffer;


# instance fields
.field private ain:Landroid/support/v8/renderscript/Allocation;

.field private ain2:Landroid/support/v8/renderscript/Allocation;

.field private ain3:Landroid/support/v8/renderscript/Allocation;

.field private ain4:Landroid/support/v8/renderscript/Allocation;

.field private aout:Landroid/support/v8/renderscript/Allocation;

.field private correctVideoBitRate:Z

.field private isAudioEncoderRunning:Z

.field private isEndOfStream:Z

.field private isRecordingSession:Z

.field private isStride512Aligned:Z

.field private isUVInterchanged:Z

.field private isUVStride2KAligned:Z

.field private isVideoEncoderRunning:Z

.field private isYUVStride2KAligned:Z

.field private mAudioBufferInfo:Landroid/media/MediaCodec$BufferInfo;

.field private mAudioEncoder:Landroid/media/MediaCodec;

.field private mAudioFormat:Landroid/media/MediaFormat;

.field private mAudioFrameDuration:I

.field private mAudioFrameNumber:I

.field private mAudioFramesRecorded:I

.field private mBufferInfo:Landroid/media/MediaCodec$BufferInfo;

.field private mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

.field private mContext:Landroid/content/Context;

.field private mICSAudioEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

.field private mICSVideoEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

.field private mICSVideoEncoderListener:Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;

.field private mInputAudioBuffers:[Ljava/nio/ByteBuffer;

.field private mInputDataToRSFilter:[B

.field private mInputVideoBuffers:[Ljava/nio/ByteBuffer;

.field private mOutBuffer:Ljava/nio/ByteBuffer;

.field private mOutputAudioBuffers:[Ljava/nio/ByteBuffer;

.field private mOutputFilePath:Ljava/lang/String;

.field private mOutputFromRSFilter:[B

.field private mOutputH264Dump:Ljava/io/FileOutputStream;

.field private mOutputVideoBuffers:[Ljava/nio/ByteBuffer;

.field private mPCMFrameData:[B

.field private mRGBABufferSize:I

.field private mRGBBufferSize:I

.field private mRenderScript:Landroid/support/v8/renderscript/RenderScript;

.field private mRetrievedEncodedFrameCount:I

.field private mScript:Lcom/lifevibes/mediacoder/ScriptC_Filters;

.field private mSonyXperiaZ1_Height:I

.field private mSonyXperiaZ1_Width:I

.field private mSuppliedEncodedFrameCount:I

.field private mSupportedAudioCodecs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mSupportedColorFormat:I

.field private mVideoDataInput:[B

.field private mVideoEncoder:Landroid/media/MediaCodec;

.field private mVideoFormat:Landroid/media/MediaFormat;

.field private mVideoFrameNumber:I

.field private mVideoFramesRecorded:I

.field private mWriterJNIContext:I

.field private mYUVBufferSize:I

.field private mYUVData:[B

.field private pullerFlagExit:Z

.field private run:Z

.field private skipExtraBytesAtStart:Z

.field private tempBuffer:[B

.field private tempBuffer1:[B


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "configuration"    # Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NullPointerException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 165
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    iput-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->run:Z

    .line 95
    iput-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->pullerFlagExit:Z

    .line 111
    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    .line 112
    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameNumber:I

    .line 166
    if-nez p1, :cond_0

    .line 167
    const-string v0, "[LVMediaCoderImpl] Context is NULL."

    invoke-static {v0, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 168
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Context is NULL."

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 170
    :cond_0
    if-nez p2, :cond_1

    .line 171
    const-string v0, "[LVMediaCoderImpl] Configuration is NULL."

    invoke-static {v0, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 172
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Configuration is NULL."

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 175
    :cond_1
    iput-object p2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    .line 177
    sget-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-nez v0, :cond_2

    .line 178
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    invoke-direct {p0, p1, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->configure(Landroid/content/Context;Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;)V

    .line 180
    :cond_2
    return-void
.end method

.method static synthetic access$000(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)Z
    .locals 1
    .param p0, "x0"    # Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    .prologue
    .line 74
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->pullerFlagExit:Z

    return v0
.end method

.method static synthetic access$100()Ljava/nio/ByteBuffer;
    .locals 1

    .prologue
    .line 74
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->outData:Ljava/nio/ByteBuffer;

    return-object v0
.end method

.method static synthetic access$102(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    .locals 0
    .param p0, "x0"    # Ljava/nio/ByteBuffer;

    .prologue
    .line 74
    sput-object p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->outData:Ljava/nio/ByteBuffer;

    return-object p0
.end method

.method static synthetic access$200(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;
    .locals 1
    .param p0, "x0"    # Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    .prologue
    .line 74
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    return-object v0
.end method

.method static synthetic access$300(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)I
    .locals 1
    .param p0, "x0"    # Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    .prologue
    .line 74
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I

    return v0
.end method

.method static synthetic access$308(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)I
    .locals 2
    .param p0, "x0"    # Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    .prologue
    .line 74
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I

    return v0
.end method

.method static synthetic access$400(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;
    .locals 1
    .param p0, "x0"    # Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    .prologue
    .line 74
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoderListener:Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;

    return-object v0
.end method

.method static synthetic access$500(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)Z
    .locals 1
    .param p0, "x0"    # Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    .prologue
    .line 74
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isEndOfStream:Z

    return v0
.end method

.method static synthetic access$600(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)I
    .locals 1
    .param p0, "x0"    # Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    .prologue
    .line 74
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    return v0
.end method

.method static synthetic access$700(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)V
    .locals 0
    .param p0, "x0"    # Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    .prologue
    .line 74
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->cancelEncodingICS()V

    return-void
.end method

.method private cancelEncodingICS()V
    .locals 2

    .prologue
    .line 919
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    if-nez v0, :cond_1

    .line 920
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Encoder is not running."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 921
    :cond_1
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    .line 922
    return-void
.end method

.method private checkAudioCodecs()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 275
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    iput-object v7, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedAudioCodecs:Ljava/util/ArrayList;

    .line 277
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-static {}, Landroid/media/MediaCodecList;->getCodecCount()I

    move-result v7

    if-ge v2, v7, :cond_3

    .line 278
    invoke-static {v2}, Landroid/media/MediaCodecList;->getCodecInfoAt(I)Landroid/media/MediaCodecInfo;

    move-result-object v1

    .line 279
    .local v1, "codecInfo":Landroid/media/MediaCodecInfo;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "[LVMediaCoderImpl] Encoder "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ": "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v9}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 280
    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->isEncoder()Z

    move-result v7

    if-nez v7, :cond_1

    .line 277
    :cond_0
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 283
    :cond_1
    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getSupportedTypes()[Ljava/lang/String;

    move-result-object v5

    .line 284
    .local v5, "supportedTypes":[Ljava/lang/String;
    move-object v0, v5

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_2
    if-ge v3, v4, :cond_0

    aget-object v6, v0, v3

    .line 285
    .local v6, "type":Ljava/lang/String;
    sget-object v7, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v6, v7}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v7

    const-string v8, "mp4a-latm"

    invoke-virtual {v7, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 286
    iget-object v7, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedAudioCodecs:Ljava/util/ArrayList;

    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 287
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "[LVMediaCoderImpl] Encoder "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "/"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {}, Landroid/media/MediaCodecList;->getCodecCount()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ": "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v1}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " supports ["

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "]"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v9}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    goto :goto_1

    .line 284
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 292
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "codecInfo":Landroid/media/MediaCodecInfo;
    .end local v3    # "i$":I
    .end local v4    # "len$":I
    .end local v5    # "supportedTypes":[Ljava/lang/String;
    .end local v6    # "type":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method private checkDevice()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 300
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "lge"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "hammerhead"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "msm8974"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "lge"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "lg-d802"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 304
    :cond_1
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->correctVideoBitRate:Z

    .line 308
    :cond_2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-lt v0, v1, :cond_4

    .line 309
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[LVMediaCoderImpl] Application is running on Android version: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ". No need of special color-conv filters."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 395
    :cond_3
    :goto_0
    return-void

    .line 313
    :cond_4
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "asus"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5

    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    const-string v1, "flo"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 314
    const-string v0, "[LVMediaCoderImpl] Application is running on ASUS on flo board!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 315
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isYUVStride2KAligned:Z

    goto :goto_0

    .line 317
    :cond_5
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "motorola"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_6

    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    const-string v1, "msm8960"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 318
    const-string v0, "[LVMediaCoderImpl] Application is running on Motorola on msm8960 board!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 319
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isUVStride2KAligned:Z

    goto :goto_0

    .line 321
    :cond_6
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "htc"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_a

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "htc one"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 323
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "apq8064"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 324
    const-string v0, "[LVMediaCoderImpl] Application is running on HTC One [APQ8064] with 2048 bit align stride!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 325
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isYUVStride2KAligned:Z

    goto :goto_0

    .line 326
    :cond_7
    sget-object v0, Landroid/os/Build;->HARDWARE:Ljava/lang/String;

    const-string v1, "m7"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 327
    const-string v0, "[LVMediaCoderImpl] Application is running on HTC One [APQ8064T] with 2048 bit align stride!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 328
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isUVStride2KAligned:Z

    goto/16 :goto_0

    .line 329
    :cond_8
    sget-object v0, Landroid/os/Build;->HARDWARE:Ljava/lang/String;

    const-string v1, "elite"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    sget-object v0, Landroid/os/Build;->HARDWARE:Ljava/lang/String;

    const-string v1, "ville"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 331
    :cond_9
    const-string v0, "[LVMediaCoderImpl] Application is running on HTC One X/S with 2048 bit align stride!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 332
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isUVStride2KAligned:Z

    goto/16 :goto_0

    .line 335
    :cond_a
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "sony"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 336
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    const-string v1, "MSM8660_SURF"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 337
    const-string v0, "[LVMediaCoderImpl] Application is running on SONY device with 2048 bit align stride!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 338
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isYUVStride2KAligned:Z

    .line 344
    :cond_b
    :goto_1
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    const-string v1, "MSM8226"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 345
    const-string v0, "[LVMediaCoderImpl] Application is running on SONY XPeria Z1 with bit rate correction!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 346
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->correctVideoBitRate:Z

    goto/16 :goto_0

    .line 339
    :cond_c
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "msm8974"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 341
    const-string v0, "[LVMediaCoderImpl] Application is running on SONY XPeria Z1 with 512 bit align stride!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 342
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isStride512Aligned:Z

    goto :goto_1

    .line 349
    :cond_d
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "lge"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 350
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    const-string v1, "MAKO"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 352
    const-string v0, "[LVMediaCoderImpl] Application is running on LGE Nexus 4 with 2048 bit aligned stride!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 353
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isYUVStride2KAligned:Z

    goto/16 :goto_0

    .line 355
    :cond_e
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "lg-d802"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 357
    const-string v0, "[LVMediaCoderImpl] Application is running on LGE G2 with 512 bit aligned stride!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 358
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isStride512Aligned:Z

    goto/16 :goto_0

    .line 360
    :cond_f
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    const-string v1, "gee"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 362
    const-string v0, "[LVMediaCoderImpl] Application is running on LG device on gee board!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 363
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isUVStride2KAligned:Z

    goto/16 :goto_0

    .line 365
    :cond_10
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    const-string v1, "u2"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 366
    const-string v0, "[LVMediaCoderImpl] Application is running on LG device that returns extra zeores with 1st encoded frame!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 367
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->skipExtraBytesAtStart:Z

    goto/16 :goto_0

    .line 370
    :cond_11
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "samsung"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_14

    .line 371
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "smdk4x12"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_12

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "gt-i9300"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_12

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x12

    if-ge v0, v1, :cond_12

    .line 375
    const-string v0, "[LVMediaCoderImpl] Application is running on Samsung smdk4x12 with UV-planes interchanged!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 376
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isUVInterchanged:Z

    goto/16 :goto_0

    .line 378
    :cond_12
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    const-string v1, "msm8960"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 379
    const-string v0, "[LVMediaCoderImpl] Application is running on Samsung MSM8960 board!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 380
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isUVStride2KAligned:Z

    goto/16 :goto_0

    .line 382
    :cond_13
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    const-string v1, "piranha"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 383
    const-string v0, "[LVMediaCoderImpl] Application is running on Samsung Piranha board!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 384
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->skipExtraBytesAtStart:Z

    goto/16 :goto_0

    .line 386
    :cond_14
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "huawei"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_15

    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "y301a1"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_15

    .line 388
    const-string v0, "[LVMediaCoderImpl] Application is running on Huawei device, which has UV planes interleaved!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 389
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isUVInterchanged:Z

    goto/16 :goto_0

    .line 390
    :cond_15
    sget-object v0, Landroid/os/Build;->BOARD:Ljava/lang/String;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "msm8974"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 391
    const-string v0, "[LVMediaCoderImpl] Application is running on Qualcomm MSM8974!"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 392
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isYUVStride2KAligned:Z

    goto/16 :goto_0
.end method

.method private configure(Landroid/content/Context;Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "configuration"    # Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    .prologue
    .line 188
    const-string v0, "[LVMediaCoderImpl] configure called!"

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 189
    iput-object p1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mContext:Landroid/content/Context;

    .line 195
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    mul-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x3

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    .line 196
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    mul-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBABufferSize:I

    .line 197
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVBufferSize:I

    .line 199
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->checkDevice()V

    .line 200
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->checkAudioCodecs()V

    .line 202
    const-string v0, "video/avc"

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-static {v0, v1, v2}, Landroid/media/MediaFormat;->createVideoFormat(Ljava/lang/String;II)Landroid/media/MediaFormat;

    move-result-object v0

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    .line 203
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const-string v1, "color-format"

    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->getColorFormat()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 204
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->correctVideoBitRate:Z

    if-eqz v0, :cond_0

    .line 205
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const-string v1, "bitrate"

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoBitRate:I

    mul-int/lit8 v2, v2, 0x8

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 209
    :goto_0
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const-string v1, "frame-rate"

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoFrameRate:I

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 210
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const-string v1, "i-frame-interval"

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoIFrameInterval:I

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 211
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const-string v1, "aac-profile"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 213
    new-instance v0, Landroid/media/MediaFormat;

    invoke-direct {v0}, Landroid/media/MediaFormat;-><init>()V

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    .line 214
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    const-string v1, "mime"

    const-string v2, "audio/mp4a-latm"

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    const-string v1, "bitrate"

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioBitRate:I

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 216
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    const-string v1, "channel-count"

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 217
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    const-string v1, "sample-rate"

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioSampleRate:I

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 218
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    const-string v1, "aac-profile"

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 219
    return-void

    .line 207
    :cond_0
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const-string v1, "bitrate"

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoBitRate:I

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private configureLVSFSession()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1067
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    mul-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x3

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    .line 1068
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    mul-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBABufferSize:I

    .line 1069
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVBufferSize:I

    .line 1071
    const-string v0, "video/avc"

    invoke-static {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->create(Ljava/lang/String;)Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    move-result-object v0

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    .line 1072
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoBitRate:I

    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v4, v4, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoFrameRate:I

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->configure(IIII)V

    .line 1074
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    invoke-virtual {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->start()V

    .line 1075
    iput-boolean v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    .line 1076
    iput v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I

    .line 1077
    iput v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    .line 1082
    const-string v0, "audio/mp4a-latm"

    invoke-static {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->create(Ljava/lang/String;)Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

    move-result-object v0

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSAudioEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

    .line 1083
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSAudioEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioBitRate:I

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioSampleRate:I

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    invoke-virtual {v0, v1, v2, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->configure(III)V

    .line 1085
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSAudioEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

    invoke-virtual {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->start()V

    .line 1086
    iput-boolean v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    .line 1088
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSAudioEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

    invoke-virtual {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->getDSI()V

    .line 1089
    return-void
.end method

.method private configureSession()V
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    const/4 v7, 0x0

    const/4 v9, 0x1

    .line 1098
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] \nBOARD = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->BOARD:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nBOOTLOADER = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->BOOTLOADER:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nBRAND = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nCPU_ABI = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nCPU_ABI2 = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nDEVICE = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nAndroid Version = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nFINGERPRINT = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nHARDWARE = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->HARDWARE:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nHOST = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->HOST:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nID = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->ID:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nMANUFACTURER = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nMODEL = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nPRODUCT = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nSERIAL = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->SERIAL:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nTAGS = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->TAGS:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nTIME = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-wide v5, Landroid/os/Build;->TIME:J

    invoke-virtual {v4, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nTYPE = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->TYPE:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nUNKNOWN = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "unknown"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\nUSER = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Landroid/os/Build;->USER:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\ngetRadioVersion() = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {}, Landroid/os/Build;->getRadioVersion()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v10}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1123
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->generateVideoDSI()V

    .line 1126
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    if-nez v4, :cond_0

    .line 1127
    const-string v4, "video/avc"

    invoke-static {v4}, Landroid/media/MediaCodec;->createEncoderByType(Ljava/lang/String;)Landroid/media/MediaCodec;

    move-result-object v4

    iput-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    .line 1128
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    invoke-virtual {v4, v5, v7, v7, v9}, Landroid/media/MediaCodec;->configure(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V

    .line 1129
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v4}, Landroid/media/MediaCodec;->start()V

    .line 1130
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v4}, Landroid/media/MediaCodec;->getInputBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v4

    iput-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputVideoBuffers:[Ljava/nio/ByteBuffer;

    .line 1131
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v4}, Landroid/media/MediaCodec;->getOutputBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v4

    iput-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputVideoBuffers:[Ljava/nio/ByteBuffer;

    .line 1132
    iput-boolean v9, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    .line 1136
    :cond_0
    iget-boolean v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    if-nez v4, :cond_3

    .line 1138
    :cond_1
    :try_start_0
    const-string v4, "audio/mp4a-latm"

    invoke-static {v4}, Landroid/media/MediaCodec;->createEncoderByType(Ljava/lang/String;)Landroid/media/MediaCodec;

    move-result-object v4

    iput-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    .line 1139
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x1

    invoke-virtual {v4, v5, v6, v7, v8}, Landroid/media/MediaCodec;->configure(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1160
    :cond_2
    :goto_0
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v4}, Landroid/media/MediaCodec;->start()V

    .line 1161
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v4}, Landroid/media/MediaCodec;->getInputBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v4

    iput-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputAudioBuffers:[Ljava/nio/ByteBuffer;

    .line 1162
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v4}, Landroid/media/MediaCodec;->getOutputBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v4

    iput-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputAudioBuffers:[Ljava/nio/ByteBuffer;

    .line 1163
    iput-boolean v9, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    .line 1167
    :cond_3
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->generateAudioDSI()V

    .line 1169
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] Session configuration_______________\n\t\t\t\t Is Recording ON:\t"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRecordingSession:Z

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n\t\t\t\t Color Format:\t\t"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const-string v6, "color-format"

    invoke-virtual {v5, v6}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n\t\t\t\t Video Resolution:\t"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v5, v5, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "x"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v5, v5, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n\t\t\t\t Video BitRate:\t\t"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const-string v6, "bitrate"

    invoke-virtual {v5, v6}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n\t\t\t\t Video Frame Rate:\t"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const-string v6, "frame-rate"

    invoke-virtual {v5, v6}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n\t\t\t\t Video I-Frame Int:\t"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const-string v6, "i-frame-interval"

    invoke-virtual {v5, v6}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n\t\t\t\t Audio Bit Rate:\t"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    const-string v6, "bitrate"

    invoke-virtual {v5, v6}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n\t\t\t\t Audio Channels:\t"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    const-string v6, "channel-count"

    invoke-virtual {v5, v6}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n\t\t\t\t Audio Sample Rate:\t"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    const-string v6, "sample-rate"

    invoke-virtual {v5, v6}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v10}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1179
    return-void

    .line 1140
    :catch_0
    move-exception v1

    .line 1141
    .local v1, "e":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v9}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1142
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedAudioCodecs:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_4
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1144
    .local v0, "audioEncoder":Ljava/lang/String;
    :try_start_1
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    if-eqz v4, :cond_5

    .line 1145
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v4}, Landroid/media/MediaCodec;->release()V

    .line 1147
    :cond_5
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", Trying to instantiate AudioEncoder with "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v4, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1148
    invoke-static {v0}, Landroid/media/MediaCodec;->createByCodecName(Ljava/lang/String;)Landroid/media/MediaCodec;

    move-result-object v4

    iput-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    .line 1149
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFormat:Landroid/media/MediaFormat;

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x1

    invoke-virtual {v4, v5, v6, v7, v8}, Landroid/media/MediaCodec;->configure(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    .line 1151
    :catch_1
    move-exception v2

    .line 1152
    .local v2, "e1":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v9}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1153
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedAudioCodecs:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedAudioCodecs:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    if-ne v4, v5, :cond_4

    .line 1154
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", AudioEncoder creation failed with available audio codecs on the device. Try with different audio parameters."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v9}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1155
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "AudioEncoder creation failed with available audio codecs on the device. Try with different audio parameters."

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method private convertICSRGBToYUV(Ljava/nio/ByteBuffer;I)[B
    .locals 4
    .param p1, "inputFrame"    # Ljava/nio/ByteBuffer;
    .param p2, "inputType"    # I

    .prologue
    .line 688
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    mul-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x3

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    .line 689
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    mul-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBABufferSize:I

    .line 690
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVBufferSize:I

    .line 691
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    if-nez v0, :cond_0

    .line 692
    if-nez p2, :cond_2

    .line 693
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    .line 698
    :cond_0
    :goto_0
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    div-int/lit8 v0, v0, 0x2

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    .line 700
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 701
    sget-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DUMPS:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    invoke-static {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->dumpInputVideoData([B)V

    .line 704
    :cond_1
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-static {v0, v1, v2, v3, p2}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->RGB888toYUV420WithPlanar([B[BIII)C

    .line 705
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    return-object v0

    .line 694
    :cond_2
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    .line 695
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBABufferSize:I

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    goto :goto_0
.end method

.method private convertRGBToYUV(Ljava/nio/ByteBuffer;I)[B
    .locals 9
    .param p1, "inputFrame"    # Ljava/nio/ByteBuffer;
    .param p2, "inputType"    # I

    .prologue
    const/4 v2, 0x0

    .line 716
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    if-nez v0, :cond_0

    .line 717
    if-nez p2, :cond_3

    .line 718
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    .line 723
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 724
    sget-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DUMPS:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    invoke-static {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->dumpInputVideoData([B)V

    .line 727
    :cond_1
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isStride512Aligned:Z

    if-eqz v0, :cond_6

    .line 729
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    if-nez v0, :cond_2

    .line 730
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    rem-int/lit16 v0, v0, 0x80

    if-eqz v0, :cond_4

    .line 731
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    div-int/lit16 v0, v0, 0x80

    add-int/lit8 v0, v0, 0x1

    mul-int/lit16 v0, v0, 0x80

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSonyXperiaZ1_Width:I

    .line 734
    :goto_1
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    rem-int/lit8 v0, v0, 0x20

    if-eqz v0, :cond_5

    .line 735
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    div-int/lit8 v0, v0, 0x20

    add-int/lit8 v0, v0, 0x1

    mul-int/lit8 v0, v0, 0x20

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSonyXperiaZ1_Height:I

    .line 738
    :goto_2
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSonyXperiaZ1_Width:I

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSonyXperiaZ1_Height:I

    mul-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x3

    div-int/lit8 v0, v0, 0x2

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    .line 740
    :cond_2
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSonyXperiaZ1_Width:I

    iget v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSonyXperiaZ1_Height:I

    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v4, v4, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v5, v5, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    move v6, p2

    invoke-static/range {v0 .. v6}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->RGB888toYUV420WithStride512Aligned([B[BIIIII)C

    .line 783
    :goto_3
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    return-object v0

    .line 719
    :cond_3
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    .line 720
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBABufferSize:I

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    goto :goto_0

    .line 733
    :cond_4
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSonyXperiaZ1_Width:I

    goto :goto_1

    .line 737
    :cond_5
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSonyXperiaZ1_Height:I

    goto :goto_2

    .line 742
    :cond_6
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isYUVStride2KAligned:Z

    if-eqz v0, :cond_a

    .line 743
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    if-nez v0, :cond_9

    .line 744
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    mul-int/2addr v0, v1

    rem-int/lit16 v8, v0, 0x800

    .line 745
    .local v8, "lgeNexus4StrideOffSet":I
    if-lez v8, :cond_7

    .line 746
    rsub-int v8, v8, 0x800

    .line 748
    :cond_7
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    mul-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x2

    rem-int/lit16 v7, v0, 0x800

    .line 749
    .local v7, "UVOffset":I
    if-lez v7, :cond_8

    .line 750
    rsub-int v0, v7, 0x800

    add-int/2addr v8, v0

    .line 752
    :cond_8
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVBufferSize:I

    add-int/2addr v0, v8

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    .line 754
    .end local v7    # "UVOffset":I
    .end local v8    # "lgeNexus4StrideOffSet":I
    :cond_9
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-static {v0, v1, v2, v3, p2}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->RGB888toYUV420WithSemiPlanar([B[BIII)C

    goto :goto_3

    .line 756
    :cond_a
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isUVStride2KAligned:Z

    if-eqz v0, :cond_d

    .line 757
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    if-nez v0, :cond_c

    .line 758
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    mul-int/2addr v0, v1

    rem-int/lit16 v8, v0, 0x800

    .line 759
    .restart local v8    # "lgeNexus4StrideOffSet":I
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[LVMediaCoderImpl] Calling HTCOne stride:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 760
    if-lez v8, :cond_b

    .line 761
    rsub-int v8, v8, 0x800

    .line 763
    :cond_b
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVBufferSize:I

    add-int/2addr v0, v8

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    .line 765
    .end local v8    # "lgeNexus4StrideOffSet":I
    :cond_c
    const-string v0, "[LVMediaCoderImpl] Calling HTCOne filter...."

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 766
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-static {v0, v1, v2, v3, p2}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->RGB888toYUV420WithUVStride2KAligned([B[BIII)C

    goto/16 :goto_3

    .line 769
    :cond_d
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    if-nez v0, :cond_e

    .line 770
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVBufferSize:I

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    .line 772
    :cond_e
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedColorFormat:I

    const/16 v1, 0x13

    if-ne v0, v1, :cond_f

    .line 773
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-static {v0, v1, v2, v3, p2}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->RGB888toYUV420WithPlanar([B[BIII)C

    goto/16 :goto_3

    .line 775
    :cond_f
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isUVInterchanged:Z

    if-eqz v0, :cond_10

    .line 776
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-static {v0, v1, v2, v3, p2}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->RGB888toYUV420WithUVInterchanged([B[BIII)C

    goto/16 :goto_3

    .line 779
    :cond_10
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-static {v0, v1, v2, v3, p2}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->RGB888toYUV420WithSemiPlanar([B[BIII)C

    goto/16 :goto_3
.end method

.method private convertRGBToYUVinRS(Ljava/nio/ByteBuffer;I)[B
    .locals 12
    .param p1, "inputFrame"    # Ljava/nio/ByteBuffer;
    .param p2, "inputType"    # I

    .prologue
    const v11, 0x70800

    const v10, 0x38400

    const/4 v9, 0x0

    .line 605
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    if-nez v5, :cond_0

    .line 606
    if-nez p2, :cond_4

    .line 607
    iget v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    new-array v5, v5, [B

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    .line 612
    :cond_0
    :goto_0
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 613
    sget-boolean v5, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DUMPS:Z

    if-eqz v5, :cond_1

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    invoke-static {v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->dumpInputVideoData([B)V

    .line 615
    :cond_1
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    if-nez v5, :cond_2

    .line 616
    iget-boolean v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isStride512Aligned:Z

    if-eqz v5, :cond_5

    .line 618
    const v5, 0x5a000

    new-array v5, v5, [B

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    .line 625
    :cond_2
    :goto_1
    if-nez p2, :cond_6

    .line 626
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    if-nez v5, :cond_3

    .line 627
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    array-length v5, v5

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    array-length v6, v6

    div-int/lit8 v6, v6, 0x3

    add-int/2addr v5, v6

    new-array v5, v5, [B

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    .line 629
    :cond_3
    const/4 v1, 0x0

    .local v1, "i":I
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_2
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    array-length v5, v5

    if-ge v1, v5, :cond_8

    .line 630
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    aget-byte v6, v6, v1

    aput-byte v6, v5, v2

    .line 631
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    add-int/lit8 v6, v2, 0x1

    iget-object v7, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    add-int/lit8 v8, v1, 0x1

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 632
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    add-int/lit8 v6, v2, 0x2

    iget-object v7, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    add-int/lit8 v8, v1, 0x2

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 629
    add-int/lit8 v1, v1, 0x3

    add-int/lit8 v2, v2, 0x4

    goto :goto_2

    .line 608
    .end local v1    # "i":I
    .end local v2    # "j":I
    :cond_4
    const/4 v5, 0x1

    if-ne p2, v5, :cond_0

    .line 609
    iget v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBABufferSize:I

    new-array v5, v5, [B

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    goto :goto_0

    .line 620
    :cond_5
    iget v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVBufferSize:I

    new-array v5, v5, [B

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    goto :goto_1

    .line 635
    :cond_6
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    if-nez v5, :cond_7

    .line 636
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    array-length v5, v5

    new-array v5, v5, [B

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    .line 638
    :cond_7
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    .line 641
    :cond_8
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputFromRSFilter:[B

    if-nez v5, :cond_9

    .line 642
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    array-length v5, v5

    new-array v5, v5, [B

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputFromRSFilter:[B

    .line 645
    :cond_9
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 647
    .local v3, "startTime":J
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain:Landroid/support/v8/renderscript/Allocation;

    if-eqz v5, :cond_a

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->aout:Landroid/support/v8/renderscript/Allocation;

    if-nez v5, :cond_b

    .line 648
    :cond_a
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRenderScript:Landroid/support/v8/renderscript/RenderScript;

    invoke-static {v5}, Landroid/support/v8/renderscript/Element;->RGB_888(Landroid/support/v8/renderscript/RenderScript;)Landroid/support/v8/renderscript/Element;

    move-result-object v0

    .line 649
    .local v0, "e":Landroid/support/v8/renderscript/Element;
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRenderScript:Landroid/support/v8/renderscript/RenderScript;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    array-length v6, v6

    div-int/lit8 v6, v6, 0x4

    invoke-static {v5, v0, v6}, Landroid/support/v8/renderscript/Allocation;->createSized(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;I)Landroid/support/v8/renderscript/Allocation;

    move-result-object v5

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain:Landroid/support/v8/renderscript/Allocation;

    .line 650
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRenderScript:Landroid/support/v8/renderscript/RenderScript;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRenderScript:Landroid/support/v8/renderscript/RenderScript;

    invoke-static {v6}, Landroid/support/v8/renderscript/Element;->U8(Landroid/support/v8/renderscript/RenderScript;)Landroid/support/v8/renderscript/Element;

    move-result-object v6

    iget-object v7, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    array-length v7, v7

    invoke-static {v5, v6, v7}, Landroid/support/v8/renderscript/Allocation;->createSized(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;I)Landroid/support/v8/renderscript/Allocation;

    move-result-object v5

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain2:Landroid/support/v8/renderscript/Allocation;

    .line 651
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRenderScript:Landroid/support/v8/renderscript/RenderScript;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRenderScript:Landroid/support/v8/renderscript/RenderScript;

    invoke-static {v6}, Landroid/support/v8/renderscript/Element;->U8(Landroid/support/v8/renderscript/RenderScript;)Landroid/support/v8/renderscript/Element;

    move-result-object v6

    iget-object v7, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    array-length v7, v7

    invoke-static {v5, v6, v7}, Landroid/support/v8/renderscript/Allocation;->createSized(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;I)Landroid/support/v8/renderscript/Allocation;

    move-result-object v5

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain3:Landroid/support/v8/renderscript/Allocation;

    .line 652
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRenderScript:Landroid/support/v8/renderscript/RenderScript;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRenderScript:Landroid/support/v8/renderscript/RenderScript;

    invoke-static {v6}, Landroid/support/v8/renderscript/Element;->U8(Landroid/support/v8/renderscript/RenderScript;)Landroid/support/v8/renderscript/Element;

    move-result-object v6

    invoke-static {v5, v6, v11}, Landroid/support/v8/renderscript/Allocation;->createSized(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;I)Landroid/support/v8/renderscript/Allocation;

    move-result-object v5

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain4:Landroid/support/v8/renderscript/Allocation;

    .line 653
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRenderScript:Landroid/support/v8/renderscript/RenderScript;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputDataToRSFilter:[B

    array-length v6, v6

    div-int/lit8 v6, v6, 0x4

    invoke-static {v5, v0, v6}, Landroid/support/v8/renderscript/Allocation;->createSized(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;I)Landroid/support/v8/renderscript/Allocation;

    move-result-object v5

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->aout:Landroid/support/v8/renderscript/Allocation;

    .line 654
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "[LVMediaCoderImpl] Time taken for setting up RS: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long/2addr v6, v3

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v9}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 656
    .end local v0    # "e":Landroid/support/v8/renderscript/Element;
    :cond_b
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->tempBuffer:[B

    if-nez v5, :cond_c

    .line 657
    const v5, 0xa8c00

    new-array v5, v5, [B

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->tempBuffer:[B

    .line 658
    new-array v5, v11, [B

    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->tempBuffer1:[B

    .line 661
    :cond_c
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain2:Landroid/support/v8/renderscript/Allocation;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDataInput:[B

    invoke-virtual {v5, v6}, Landroid/support/v8/renderscript/Allocation;->copyFrom([B)V

    .line 662
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mScript:Lcom/lifevibes/mediacoder/ScriptC_Filters;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain2:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v5, v6}, Lcom/lifevibes/mediacoder/ScriptC_Filters;->set_input(Landroid/support/v8/renderscript/Allocation;)V

    .line 663
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mScript:Lcom/lifevibes/mediacoder/ScriptC_Filters;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v5, v6}, Lcom/lifevibes/mediacoder/ScriptC_Filters;->forEach_RGB888YUV444(Landroid/support/v8/renderscript/Allocation;)V

    .line 665
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mScript:Lcom/lifevibes/mediacoder/ScriptC_Filters;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain3:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v5, v6}, Lcom/lifevibes/mediacoder/ScriptC_Filters;->set_output(Landroid/support/v8/renderscript/Allocation;)V

    .line 667
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mScript:Lcom/lifevibes/mediacoder/ScriptC_Filters;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain:Landroid/support/v8/renderscript/Allocation;

    iget-object v7, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->aout:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v5, v6, v7}, Lcom/lifevibes/mediacoder/ScriptC_Filters;->forEach_YUVPackedToPlanar(Landroid/support/v8/renderscript/Allocation;Landroid/support/v8/renderscript/Allocation;)V

    .line 668
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mScript:Lcom/lifevibes/mediacoder/ScriptC_Filters;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain3:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v5, v6}, Lcom/lifevibes/mediacoder/ScriptC_Filters;->set_output1(Landroid/support/v8/renderscript/Allocation;)V

    .line 670
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mScript:Lcom/lifevibes/mediacoder/ScriptC_Filters;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain4:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v5, v6}, Lcom/lifevibes/mediacoder/ScriptC_Filters;->set_output2(Landroid/support/v8/renderscript/Allocation;)V

    .line 673
    iget v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedColorFormat:I

    const/16 v6, 0x13

    if-ne v5, v6, :cond_d

    .line 674
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mScript:Lcom/lifevibes/mediacoder/ScriptC_Filters;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain4:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v5, v6}, Lcom/lifevibes/mediacoder/ScriptC_Filters;->forEach_YUV444ToYUV420(Landroid/support/v8/renderscript/Allocation;)V

    .line 680
    :goto_3
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain3:Landroid/support/v8/renderscript/Allocation;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->tempBuffer:[B

    invoke-virtual {v5, v6}, Landroid/support/v8/renderscript/Allocation;->copyTo([B)V

    .line 681
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain4:Landroid/support/v8/renderscript/Allocation;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->tempBuffer1:[B

    invoke-virtual {v5, v6}, Landroid/support/v8/renderscript/Allocation;->copyTo([B)V

    .line 682
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->tempBuffer:[B

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    invoke-static {v5, v9, v6, v9, v10}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 683
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->tempBuffer1:[B

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    const v7, 0x1c200

    invoke-static {v5, v9, v6, v10, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 684
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVData:[B

    return-object v5

    .line 675
    :cond_d
    iget v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedColorFormat:I

    const/16 v6, 0x15

    if-ne v5, v6, :cond_e

    .line 676
    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mScript:Lcom/lifevibes/mediacoder/ScriptC_Filters;

    iget-object v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->ain4:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v5, v6}, Lcom/lifevibes/mediacoder/ScriptC_Filters;->forEach_YUV444ToYUV420SemiPlanar(Landroid/support/v8/renderscript/Allocation;)V

    goto :goto_3

    .line 678
    :cond_e
    new-instance v5, Ljava/lang/IllegalStateException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "RenderScript doesn\'t have color conversion filter for Color Format: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v7, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedColorFormat:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5
.end method

.method private deleteOutputFile()V
    .locals 2

    .prologue
    .line 925
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputFilePath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 926
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 927
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 929
    :cond_0
    return-void
.end method

.method private dumpH264DataToFile([B)V
    .locals 6
    .param p1, "h264Data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 575
    :try_start_0
    new-instance v3, Ljava/io/File;

    const-string v4, "/mnt/sdcard/Twitter/"

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->mkdir()Z

    .line 576
    const-string v2, "/mnt/sdcard/Twitter/Encoded Video.h264"

    .line 577
    .local v2, "filename":Ljava/lang/String;
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 578
    .local v1, "file":Ljava/io/File;
    new-instance v3, Ljava/io/FileOutputStream;

    const/4 v4, 0x1

    invoke-direct {v3, v1, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    iput-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputH264Dump:Ljava/io/FileOutputStream;

    .line 579
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputH264Dump:Ljava/io/FileOutputStream;

    invoke-virtual {v3, p1}, Ljava/io/FileOutputStream;->write([B)V

    .line 580
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputH264Dump:Ljava/io/FileOutputStream;

    invoke-virtual {v3}, Ljava/io/FileOutputStream;->flush()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 585
    return-void

    .line 581
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "filename":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 582
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 583
    new-instance v3, Ljava/lang/Exception;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error while dumping H264 data to file: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method private encodeAudioFrame([BII)Ljava/nio/ShortBuffer;
    .locals 20
    .param p1, "pcmFrame"    # [B
    .param p2, "start"    # I
    .param p3, "shortCount"    # I

    .prologue
    .line 1324
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    if-nez v2, :cond_0

    .line 1325
    const-string v2, "[LVMediaCoderImpl] LVMediaCoder is not running."

    const/4 v4, 0x1

    invoke-static {v2, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1326
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v4, "LVMediaCoder is not running."

    invoke-direct {v2, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1328
    :cond_0
    add-int v2, p2, p3

    move-object/from16 v0, p1

    array-length v4, v0

    if-le v2, v4, :cond_1

    .line 1329
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] Index out of bound. Length of pcmFrame is: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p1

    array-length v4, v0

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " however (Start + ShortCount) = "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    add-int v4, p2, p3

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x1

    invoke-static {v2, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1330
    new-instance v2, Ljava/lang/IndexOutOfBoundsException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Index out of bound. Length of pcmFrame is: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p1

    array-length v5, v0

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " Start + ShortCount = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    add-int v5, p2, p3

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1333
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] \t\tencodeAudio(): Length of input pcmFrame# "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget v4, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameNumber:I

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ": "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p1

    array-length v4, v0

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ", Length: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move/from16 v0, p3

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ", Position: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move/from16 v0, p2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-static {v2, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1334
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    if-nez v2, :cond_2

    .line 1335
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    const/4 v4, 0x1

    if-ne v2, v4, :cond_3

    .line 1336
    const/16 v2, 0x800

    new-array v2, v2, [B

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    .line 1342
    :cond_2
    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    const/4 v4, 0x1

    if-ne v2, v4, :cond_4

    const/16 v2, 0x800

    move/from16 v0, p3

    if-ne v0, v2, :cond_4

    .line 1343
    const/4 v12, 0x0

    .line 1344
    .local v12, "index":I
    move/from16 v11, p2

    .local v11, "i":I
    :goto_1
    add-int v2, p2, p3

    if-ge v11, v2, :cond_9

    .line 1345
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    aget-byte v4, p1, v11

    aput-byte v4, v2, v12

    .line 1346
    add-int/lit8 v12, v12, 0x1

    .line 1344
    add-int/lit8 v11, v11, 0x1

    goto :goto_1

    .line 1338
    .end local v11    # "i":I
    .end local v12    # "index":I
    :cond_3
    const/16 v2, 0x1000

    new-array v2, v2, [B

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    goto :goto_0

    .line 1349
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    const/4 v4, 0x1

    if-ne v2, v4, :cond_7

    const/16 v2, 0x800

    move/from16 v0, p3

    if-eq v0, v2, :cond_7

    .line 1350
    const/16 v2, 0x800

    move/from16 v0, p3

    if-ge v0, v2, :cond_6

    .line 1351
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] \t\tencodeAudio(): pcmFrame# "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget v4, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameNumber:I

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ": Length < PCM_MONO, hence wraping it in 2048 byte array."

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-static {v2, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1353
    const/4 v12, 0x0

    .line 1354
    .restart local v12    # "index":I
    move/from16 v11, p2

    .restart local v11    # "i":I
    :goto_2
    add-int v2, p2, p3

    if-ge v11, v2, :cond_5

    .line 1355
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    aget-byte v4, p1, v11

    aput-byte v4, v2, v12

    .line 1356
    add-int/lit8 v12, v12, 0x1

    .line 1354
    add-int/lit8 v11, v11, 0x1

    goto :goto_2

    .line 1359
    :cond_5
    move/from16 v11, p3

    :goto_3
    const/16 v2, 0x800

    if-ge v11, v2, :cond_9

    .line 1360
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    const/4 v4, 0x0

    aput-byte v4, v2, v11

    .line 1359
    add-int/lit8 v11, v11, 0x1

    goto :goto_3

    .line 1363
    .end local v11    # "i":I
    .end local v12    # "index":I
    :cond_6
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] Check the size of input PCM data. For Mono PCM Data, this should be 1024 bytes.\nSize of input pcmFrame: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move/from16 v0, p3

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x1

    invoke-static {v2, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1364
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v4, "Check the size of input PCM data. For Mono PCM Data, this should be 1024 bytes."

    invoke-direct {v2, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1366
    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    const/4 v4, 0x2

    if-ne v2, v4, :cond_8

    const/16 v2, 0x1000

    move/from16 v0, p3

    if-eq v0, v2, :cond_8

    .line 1367
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] Check the size of input PCM data. For Stereo PCM Data, this should be 2048 bytes.\nSize of input pcmFrame: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move/from16 v0, p3

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x1

    invoke-static {v2, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1368
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v4, "Check the size of input PCM data. For Stereo PCM Data, this should be 2048 bytes."

    invoke-direct {v2, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1369
    :cond_8
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    const/4 v4, 0x2

    if-ne v2, v4, :cond_9

    const/16 v2, 0x1000

    move/from16 v0, p3

    if-ne v0, v2, :cond_9

    .line 1370
    const/4 v12, 0x0

    .line 1371
    .restart local v12    # "index":I
    move/from16 v11, p2

    .restart local v11    # "i":I
    :goto_4
    add-int v2, p2, p3

    if-ge v11, v2, :cond_9

    .line 1372
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    aget-byte v4, p1, v11

    aput-byte v4, v2, v12

    .line 1373
    add-int/lit8 v12, v12, 0x1

    .line 1371
    add-int/lit8 v11, v11, 0x1

    goto :goto_4

    .line 1377
    .end local v11    # "i":I
    .end local v12    # "index":I
    :cond_9
    sget-boolean v2, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DUMPS:Z

    if-eqz v2, :cond_a

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    invoke-static {v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->dumpInputAudioData([B)V

    .line 1380
    :cond_a
    const/4 v9, 0x0

    .line 1384
    .local v9, "doneSubmittingInput":Z
    :cond_b
    :goto_5
    if-nez v9, :cond_c

    .line 1385
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    const-wide/16 v4, 0x1

    invoke-virtual {v2, v4, v5}, Landroid/media/MediaCodec;->dequeueInputBuffer(J)I

    move-result v3

    .line 1386
    .local v3, "inputBufferIndex":I
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] \t\tencodeAudio(): Audio Input BufferIndex: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-static {v2, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1387
    const/4 v2, -0x1

    if-eq v3, v2, :cond_c

    .line 1388
    if-ltz v3, :cond_c

    .line 1389
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    move-object/from16 v16, v0

    .line 1390
    .local v16, "pcmData":[B
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputAudioBuffers:[Ljava/nio/ByteBuffer;

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    .line 1391
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputAudioBuffers:[Ljava/nio/ByteBuffer;

    aget-object v2, v2, v3

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    .line 1393
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    const/4 v4, 0x0

    move-object/from16 v0, v16

    array-length v5, v0

    const-wide/16 v6, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v2 .. v8}, Landroid/media/MediaCodec;->queueInputBuffer(IIIJI)V

    .line 1394
    const/4 v9, 0x1

    .line 1395
    move-object/from16 v0, p0

    iget v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameNumber:I

    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameNumber:I

    .line 1399
    .end local v3    # "inputBufferIndex":I
    .end local v16    # "pcmData":[B
    :cond_c
    if-eqz v9, :cond_b

    .line 1400
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    if-nez v2, :cond_d

    .line 1401
    new-instance v2, Landroid/media/MediaCodec$BufferInfo;

    invoke-direct {v2}, Landroid/media/MediaCodec$BufferInfo;-><init>()V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    .line 1403
    :cond_d
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    const-wide/16 v5, 0x0

    invoke-virtual {v2, v4, v5, v6}, Landroid/media/MediaCodec;->dequeueOutputBuffer(Landroid/media/MediaCodec$BufferInfo;J)I

    move-result v15

    .line 1404
    .local v15, "outputBufferIndex":I
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] \t\tencodeAudio(): Audio Output BufferIndex: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-static {v2, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1406
    const/4 v2, -0x1

    if-eq v15, v2, :cond_b

    .line 1407
    const/4 v2, -0x2

    if-eq v15, v2, :cond_b

    .line 1408
    const/4 v2, -0x3

    if-ne v15, v2, :cond_e

    .line 1409
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v2}, Landroid/media/MediaCodec;->getOutputBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputAudioBuffers:[Ljava/nio/ByteBuffer;

    goto/16 :goto_5

    .line 1411
    :cond_e
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputAudioBuffers:[Ljava/nio/ByteBuffer;

    aget-object v14, v2, v15

    .line 1412
    .local v14, "outputBuffer":Ljava/nio/ByteBuffer;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    iget v2, v2, Landroid/media/MediaCodec$BufferInfo;->size:I

    new-array v13, v2, [B

    .line 1413
    .local v13, "outData":[B
    invoke-virtual {v14, v13}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 1414
    invoke-virtual {v14}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    .line 1415
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    iget v2, v2, Landroid/media/MediaCodec$BufferInfo;->flags:I

    and-int/lit8 v2, v2, 0x4

    if-eqz v2, :cond_10

    .line 1430
    :cond_f
    :goto_6
    array-length v2, v13

    invoke-static {v2}, Ljava/nio/ShortBuffer;->allocate(I)Ljava/nio/ShortBuffer;

    move-result-object v18

    .line 1431
    .local v18, "shortBuffer":Ljava/nio/ShortBuffer;
    array-length v0, v13

    move/from16 v19, v0

    .line 1432
    .local v19, "size":I
    move/from16 v0, v19

    new-array v0, v0, [S

    move-object/from16 v17, v0

    .line 1434
    .local v17, "shortArray2":[S
    const/4 v12, 0x0

    .restart local v12    # "index":I
    :goto_7
    move/from16 v0, v19

    if-ge v12, v0, :cond_11

    .line 1435
    aget-byte v2, v13, v12

    int-to-short v2, v2

    aput-short v2, v17, v12

    .line 1434
    add-int/lit8 v12, v12, 0x1

    goto :goto_7

    .line 1419
    .end local v12    # "index":I
    .end local v17    # "shortArray2":[S
    .end local v18    # "shortBuffer":Ljava/nio/ShortBuffer;
    .end local v19    # "size":I
    :cond_10
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    const/4 v4, 0x0

    invoke-virtual {v2, v15, v4}, Landroid/media/MediaCodec;->releaseOutputBuffer(IZ)V

    .line 1421
    move-object/from16 v0, p0

    iget v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameNumber:I

    const/4 v4, 0x1

    if-ne v2, v4, :cond_f

    sget-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioDSI:[B

    if-nez v2, :cond_f

    .line 1422
    sput-object v13, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioDSI:[B

    .line 1423
    move-object/from16 v0, p0

    iget v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameNumber:I

    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameNumber:I

    goto :goto_6

    .line 1437
    .restart local v12    # "index":I
    .restart local v17    # "shortArray2":[S
    .restart local v18    # "shortBuffer":Ljava/nio/ShortBuffer;
    .restart local v19    # "size":I
    :cond_11
    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/nio/ShortBuffer;->put([S)Ljava/nio/ShortBuffer;

    .line 1438
    sget-boolean v2, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-eqz v2, :cond_12

    .line 1440
    :try_start_0
    move-object/from16 v0, p0

    invoke-direct {v0, v13}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->writeAACToFile([B)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1446
    :cond_12
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] \t\tencodeAudio(): Operation Ended! returning "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, v17

    array-length v4, v0

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " bytes."

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-static {v2, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1448
    return-object v18

    .line 1441
    :catch_0
    move-exception v10

    .line 1442
    .local v10, "e":Ljava/lang/Exception;
    new-instance v2, Ljava/lang/IllegalStateException;

    invoke-virtual {v10}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method private encodeICSAudioFrame([BII)Ljava/nio/ShortBuffer;
    .locals 10
    .param p1, "pcmFrame"    # [B
    .param p2, "start"    # I
    .param p3, "shortCount"    # I

    .prologue
    const/4 v9, 0x2

    const/16 v8, 0x1000

    const/16 v7, 0x800

    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 1259
    const-string v3, "[LVMediaCoderImpl] ICS: encodeICSAudioFrame"

    invoke-static {v3, v6}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1260
    iget-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    if-nez v3, :cond_0

    .line 1261
    const-string v3, "[LVMediaCoderImpl] LVMediaCoder is not running."

    invoke-static {v3, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1262
    new-instance v3, Ljava/lang/IllegalStateException;

    const-string v4, "LVMediaCoder is not running."

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 1264
    :cond_0
    add-int v3, p2, p3

    array-length v4, p1

    if-le v3, v4, :cond_1

    .line 1265
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] Index out of bound. Length of pcmFrame is: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    array-length v4, p1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " however (Start + ShortCount) = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    add-int v4, p2, p3

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1266
    new-instance v3, Ljava/lang/IndexOutOfBoundsException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Index out of bound. Length of pcmFrame is: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    array-length v5, p1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " Start + ShortCount = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    add-int v5, p2, p3

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 1269
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] \t\tencodeAudio(): Length of input pcmFrame# "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameNumber:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    array-length v4, p1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", Length: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", Position: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v6}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1270
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    if-nez v3, :cond_2

    .line 1271
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    if-ne v3, v5, :cond_3

    .line 1272
    new-array v3, v7, [B

    iput-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    .line 1278
    :cond_2
    :goto_0
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    if-ne v3, v5, :cond_4

    if-ne p3, v7, :cond_4

    .line 1279
    const/4 v1, 0x0

    .line 1280
    .local v1, "index":I
    move v0, p2

    .local v0, "i":I
    :goto_1
    add-int v3, p2, p3

    if-ge v0, v3, :cond_9

    .line 1281
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    aget-byte v4, p1, v0

    aput-byte v4, v3, v1

    .line 1282
    add-int/lit8 v1, v1, 0x1

    .line 1280
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1274
    .end local v0    # "i":I
    .end local v1    # "index":I
    :cond_3
    new-array v3, v8, [B

    iput-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    goto :goto_0

    .line 1285
    :cond_4
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    if-ne v3, v5, :cond_7

    if-eq p3, v7, :cond_7

    .line 1286
    if-ge p3, v7, :cond_6

    .line 1287
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] \t\tencodeAudio(): pcmFrame# "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameNumber:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": Length < PCM_MONO, hence wraping it in 2048 byte array."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v6}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1289
    const/4 v1, 0x0

    .line 1290
    .restart local v1    # "index":I
    move v0, p2

    .restart local v0    # "i":I
    :goto_2
    add-int v3, p2, p3

    if-ge v0, v3, :cond_5

    .line 1291
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    aget-byte v4, p1, v0

    aput-byte v4, v3, v1

    .line 1292
    add-int/lit8 v1, v1, 0x1

    .line 1290
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 1295
    :cond_5
    move v0, p3

    :goto_3
    if-ge v0, v7, :cond_9

    .line 1296
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    aput-byte v6, v3, v0

    .line 1295
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 1299
    .end local v0    # "i":I
    .end local v1    # "index":I
    :cond_6
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] Check the size of input PCM data. For Mono PCM Data, this should be 1024 bytes.\nSize of input pcmFrame: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1300
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Check the size of input PCM data. For Mono PCM Data, this should be 1024 bytes."

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 1302
    :cond_7
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    if-ne v3, v9, :cond_8

    if-eq p3, v8, :cond_8

    .line 1303
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] Check the size of input PCM data. For Stereo PCM Data, this should be 2048 bytes.\nSize of input pcmFrame: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1304
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Check the size of input PCM data. For Stereo PCM Data, this should be 2048 bytes."

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 1305
    :cond_8
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    if-ne v3, v9, :cond_9

    if-ne p3, v8, :cond_9

    .line 1306
    const/4 v1, 0x0

    .line 1307
    .restart local v1    # "index":I
    move v0, p2

    .restart local v0    # "i":I
    :goto_4
    add-int v3, p2, p3

    if-ge v0, v3, :cond_9

    .line 1308
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    aget-byte v4, p1, v0

    aput-byte v4, v3, v1

    .line 1309
    add-int/lit8 v1, v1, 0x1

    .line 1307
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 1313
    .end local v0    # "i":I
    .end local v1    # "index":I
    :cond_9
    sget-boolean v3, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DUMPS:Z

    if-eqz v3, :cond_a

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    invoke-static {v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->dumpInputAudioData([B)V

    .line 1316
    :cond_a
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSAudioEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mPCMFrameData:[B

    invoke-virtual {v3, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->encode([B)Ljava/nio/ShortBuffer;

    move-result-object v2

    .line 1317
    .local v2, "shortBuffer":Ljava/nio/ShortBuffer;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] \t\tencodeAudio(): Operation Ended! returning "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Ljava/nio/ShortBuffer;->limit()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " bytes."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v6}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1319
    return-object v2
.end method

.method private encodeICSVideo(Ljava/nio/ByteBuffer;IZ)Ljava/nio/ByteBuffer;
    .locals 6
    .param p1, "inputFrame"    # Ljava/nio/ByteBuffer;
    .param p2, "inputType"    # I
    .param p3, "isEoS"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 485
    if-nez p2, :cond_0

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v3

    iget v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    if-eq v3, v4, :cond_0

    .line 486
    const-string v3, "[LVMediaCoderImpl] encodeVideo(): Improper size of input RGB data."

    invoke-static {v3, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 487
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Improper size of input RGB data."

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 489
    :cond_0
    if-ne p2, v5, :cond_1

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v3

    iget v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBABufferSize:I

    if-eq v3, v4, :cond_1

    .line 490
    const-string v3, "[LVMediaCoderImpl] encodeVideo(): Improper size of input RGBA data."

    invoke-static {v3, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 491
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Improper size of input RGBA data."

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 494
    :cond_1
    const-string v3, "[LVMediaCoderImpl] encodeVideo(): Called."

    const/4 v4, 0x0

    invoke-static {v3, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 498
    invoke-direct {p0, p1, p2}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->convertICSRGBToYUV(Ljava/nio/ByteBuffer;I)[B

    move-result-object v2

    .line 499
    .local v2, "yuvData":[B
    sget-boolean v3, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-eqz v3, :cond_2

    .line 501
    :try_start_0
    invoke-direct {p0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->writeYUVToFile([B)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 508
    :cond_2
    const/4 v0, 0x0

    .line 509
    .local v0, "buffer":Ljava/nio/ByteBuffer;
    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    invoke-virtual {v3, v2, p3}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->encode([BZ)V

    .line 512
    return-object v0

    .line 502
    .end local v0    # "buffer":Ljava/nio/ByteBuffer;
    :catch_0
    move-exception v1

    .line 503
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 504
    new-instance v3, Ljava/lang/IllegalStateException;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method private encodeVideoAsyncPull()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 425
    sget-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-eqz v0, :cond_0

    .line 427
    monitor-enter p0

    .line 429
    :try_start_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;

    invoke-direct {v1, p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;-><init>(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 479
    monitor-exit p0

    .line 482
    :cond_0
    return-void

    .line 479
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private encodeYUVToH264([B)Ljava/nio/ByteBuffer;
    .locals 17
    .param p1, "yuvData"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 794
    if-nez p1, :cond_0

    .line 795
    const-string v1, "[LVMediaCoderImpl] encodeYUVToH264(): YUV Data is null"

    const/4 v3, 0x1

    invoke-static {v1, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 796
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v3, "YUV Data is null"

    invoke-direct {v1, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 800
    :cond_0
    const/4 v8, 0x0

    .line 804
    .local v8, "doneSubmittingInput":Z
    :cond_1
    :goto_0
    if-nez v8, :cond_2

    .line 805
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    const-wide/16 v3, 0x1

    invoke-virtual {v1, v3, v4}, Landroid/media/MediaCodec;->dequeueInputBuffer(J)I

    move-result v2

    .line 806
    .local v2, "inputBufferIndex":I
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[LVMediaCoderImpl] encodeYUVToH264(): Video InputBufferIndex : "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " for frame# "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p0

    iget v3, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x0

    invoke-static {v1, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 807
    const/4 v1, -0x1

    if-eq v2, v1, :cond_2

    .line 808
    if-ltz v2, :cond_2

    .line 809
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputVideoBuffers:[Ljava/nio/ByteBuffer;

    aget-object v1, v1, v2

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    .line 810
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputVideoBuffers:[Ljava/nio/ByteBuffer;

    aget-object v1, v1, v2

    move-object/from16 v0, p1

    invoke-virtual {v1, v0}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    .line 812
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    const/4 v3, 0x0

    move-object/from16 v0, p1

    array-length v4, v0

    move-object/from16 v0, p0

    iget v5, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    mul-int/lit8 v5, v5, 0x21

    int-to-long v5, v5

    const/4 v7, 0x0

    invoke-virtual/range {v1 .. v7}, Landroid/media/MediaCodec;->queueInputBuffer(IIIJI)V

    .line 813
    const/4 v8, 0x1

    .line 814
    move-object/from16 v0, p0

    iget v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    add-int/lit8 v1, v1, 0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    .line 819
    .end local v2    # "inputBufferIndex":I
    :cond_2
    if-eqz v8, :cond_1

    .line 820
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    if-nez v1, :cond_3

    .line 821
    new-instance v1, Landroid/media/MediaCodec$BufferInfo;

    invoke-direct {v1}, Landroid/media/MediaCodec$BufferInfo;-><init>()V

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    .line 823
    :cond_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    const-wide/16 v4, 0x0

    invoke-virtual {v1, v3, v4, v5}, Landroid/media/MediaCodec;->dequeueOutputBuffer(Landroid/media/MediaCodec$BufferInfo;J)I

    move-result v15

    .line 824
    .local v15, "outputBufferIndex":I
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_4

    .line 825
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[LVMediaCoderImpl] encodeYUVToH264(): Video OutputBufferIndex : "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " for frame# "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p0

    iget v3, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x0

    invoke-static {v1, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 827
    :cond_4
    const/4 v1, -0x1

    if-eq v15, v1, :cond_1

    .line 828
    const/4 v1, -0x2

    if-eq v15, v1, :cond_1

    .line 829
    const/4 v1, -0x3

    if-ne v15, v1, :cond_5

    .line 830
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v1}, Landroid/media/MediaCodec;->getOutputBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputVideoBuffers:[Ljava/nio/ByteBuffer;

    goto/16 :goto_0

    .line 832
    :cond_5
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputVideoBuffers:[Ljava/nio/ByteBuffer;

    aget-object v14, v1, v15

    .line 833
    .local v14, "outputBuffer":Ljava/nio/ByteBuffer;
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->skipExtraBytesAtStart:Z

    if-eqz v1, :cond_8

    move-object/from16 v0, p0

    iget v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    const/4 v3, 0x3

    if-ne v1, v3, :cond_8

    const/4 v13, 0x1

    .line 837
    .local v13, "isDsi":Z
    :goto_1
    if-eqz v13, :cond_9

    .line 838
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    iget v1, v1, Landroid/media/MediaCodec$BufferInfo;->size:I

    sget-object v3, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    array-length v3, v3

    add-int v16, v1, v3

    .line 839
    .local v16, "size":I
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[LVMediaCoderImpl] OutputBufferSize: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v14}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "mBufferInfo.size: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    iget v3, v3, Landroid/media/MediaCodec$BufferInfo;->size:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "mVideoDSI.length: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v3, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    array-length v3, v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x0

    invoke-static {v1, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 843
    :goto_2
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    if-eqz v1, :cond_6

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->capacity()I

    move-result v1

    move/from16 v0, v16

    if-ge v1, v0, :cond_7

    .line 844
    :cond_6
    invoke-static/range {v16 .. v16}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    .line 846
    :cond_7
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 847
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    move/from16 v0, v16

    invoke-virtual {v1, v0}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 848
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_3
    move/from16 v0, v16

    if-ge v12, v0, :cond_a

    .line 849
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v14}, Ljava/nio/ByteBuffer;->get()B

    move-result v3

    invoke-virtual {v1, v3}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 848
    add-int/lit8 v12, v12, 0x1

    goto :goto_3

    .line 833
    .end local v12    # "i":I
    .end local v13    # "isDsi":Z
    .end local v16    # "size":I
    :cond_8
    const/4 v13, 0x0

    goto/16 :goto_1

    .line 841
    .restart local v13    # "isDsi":Z
    :cond_9
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    iget v0, v1, Landroid/media/MediaCodec$BufferInfo;->size:I

    move/from16 v16, v0

    .restart local v16    # "size":I
    goto :goto_2

    .line 851
    .restart local v12    # "i":I
    :cond_a
    invoke-virtual {v14}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    .line 853
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mBufferInfo:Landroid/media/MediaCodec$BufferInfo;

    iget v1, v1, Landroid/media/MediaCodec$BufferInfo;->flags:I

    and-int/lit8 v1, v1, 0x4

    if-eqz v1, :cond_b

    .line 854
    const-string v1, "[LVMediaCoderImpl] encodeYUVToH264(): BUFFER_FLAG_END_OF_STREAM. Breaking out!!!!"

    const/4 v3, 0x0

    invoke-static {v1, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 896
    :goto_4
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[LVMediaCoderImpl] encodeYUVToH264(): Returning "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v3

    array-length v3, v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " bytes."

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x0

    invoke-static {v1, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 898
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    return-object v1

    .line 858
    :cond_b
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    if-nez v1, :cond_c

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    if-nez v1, :cond_c

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    const/4 v3, 0x2

    invoke-virtual {v1, v3}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    if-nez v1, :cond_c

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    const/4 v3, 0x3

    invoke-virtual {v1, v3}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    const/4 v3, 0x1

    if-eq v1, v3, :cond_d

    .line 861
    :cond_c
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[LVMediaCoderImpl] encodeYUVToH264(): Header missing! for Frame: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p0

    iget v3, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x0

    invoke-static {v1, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 864
    :cond_d
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    const/4 v3, 0x0

    invoke-virtual {v1, v15, v3}, Landroid/media/MediaCodec;->releaseOutputBuffer(IZ)V

    .line 865
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 866
    move-object/from16 v0, p0

    iget v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    const/4 v3, 0x1

    if-ne v1, v3, :cond_f

    .line 867
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v1

    new-array v1, v1, [B

    sput-object v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    .line 868
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutBuffer:Ljava/nio/ByteBuffer;

    sget-object v3, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    invoke-virtual {v1, v3}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 869
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRecordingSession:Z

    if-eqz v1, :cond_e

    .line 870
    sget-boolean v1, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-eqz v1, :cond_e

    .line 871
    new-instance v1, Ljava/io/File;

    const-string v3, "/mnt/sdcard/Twitter/"

    invoke-direct {v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->mkdir()Z

    .line 872
    const-string v11, "/mnt/sdcard/Twitter/Encoded Video.h264"

    .line 873
    .local v11, "filename":Ljava/lang/String;
    new-instance v10, Ljava/io/File;

    invoke-direct {v10, v11}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 875
    .local v10, "file":Ljava/io/File;
    :try_start_0
    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, v10}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputH264Dump:Ljava/io/FileOutputStream;

    .line 876
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputH264Dump:Ljava/io/FileOutputStream;

    sget-object v3, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    invoke-virtual {v1, v3}, Ljava/io/FileOutputStream;->write([B)V

    .line 877
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputH264Dump:Ljava/io/FileOutputStream;

    invoke-virtual {v1}, Ljava/io/FileOutputStream;->flush()V

    .line 878
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputH264Dump:Ljava/io/FileOutputStream;

    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 885
    .end local v10    # "file":Ljava/io/File;
    .end local v11    # "filename":Ljava/lang/String;
    :cond_e
    move-object/from16 v0, p0

    iget v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    add-int/lit8 v1, v1, 0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    .line 886
    const/4 v8, 0x0

    .line 887
    goto/16 :goto_0

    .line 879
    .restart local v10    # "file":Ljava/io/File;
    .restart local v11    # "filename":Ljava/lang/String;
    :catch_0
    move-exception v9

    .line 880
    .local v9, "e":Ljava/io/IOException;
    invoke-virtual {v9}, Ljava/io/IOException;->printStackTrace()V

    .line 881
    new-instance v1, Ljava/lang/Exception;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error while writing VideoDSI to debug file: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v9}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v1

    .line 889
    .end local v9    # "e":Ljava/io/IOException;
    .end local v10    # "file":Ljava/io/File;
    .end local v11    # "filename":Ljava/lang/String;
    :cond_f
    move-object/from16 v0, p0

    iget v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    const/4 v3, 0x1

    if-le v1, v3, :cond_1

    goto/16 :goto_4
.end method

.method private generateAudioDSI()V
    .locals 4

    .prologue
    .line 1055
    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 1056
    const/16 v1, 0x800

    invoke-static {v1}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 1057
    .local v0, "pcmData":Ljava/nio/ByteBuffer;
    sget-object v1, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 1061
    :goto_0
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v3

    array-length v3, v3

    invoke-virtual {p0, v1, v2, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeAudio([BII)Ljava/nio/ShortBuffer;

    .line 1062
    return-void

    .line 1059
    .end local v0    # "pcmData":Ljava/nio/ByteBuffer;
    :cond_0
    const/16 v1, 0x1000

    invoke-static {v1}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .restart local v0    # "pcmData":Ljava/nio/ByteBuffer;
    goto :goto_0
.end method

.method private generateVideoDSI()V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 1020
    const-string v2, "video/avc"

    invoke-static {v2}, Landroid/media/MediaCodec;->createEncoderByType(Ljava/lang/String;)Landroid/media/MediaCodec;

    move-result-object v2

    iput-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    .line 1021
    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFormat:Landroid/media/MediaFormat;

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v5, v5, v4}, Landroid/media/MediaCodec;->configure(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V

    .line 1024
    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v2}, Landroid/media/MediaCodec;->start()V

    .line 1027
    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v2}, Landroid/media/MediaCodec;->getInputBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v2

    iput-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputVideoBuffers:[Ljava/nio/ByteBuffer;

    .line 1028
    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v2}, Landroid/media/MediaCodec;->getOutputBuffers()[Ljava/nio/ByteBuffer;

    move-result-object v2

    iput-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputVideoBuffers:[Ljava/nio/ByteBuffer;

    .line 1031
    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mYUVBufferSize:I

    new-array v1, v2, [B

    .line 1033
    .local v1, "yuvData":[B
    :try_start_0
    invoke-direct {p0, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeYUVToH264([B)Ljava/nio/ByteBuffer;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1040
    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v2}, Landroid/media/MediaCodec;->stop()V

    .line 1041
    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v2}, Landroid/media/MediaCodec;->release()V

    .line 1042
    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    .line 1043
    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputVideoBuffers:[Ljava/nio/ByteBuffer;

    .line 1044
    iput-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputVideoBuffers:[Ljava/nio/ByteBuffer;

    .line 1046
    iput v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFrameNumber:I

    .line 1047
    iput-boolean v6, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    .line 1048
    return-void

    .line 1034
    :catch_0
    move-exception v0

    .line 1035
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 1036
    throw v0
.end method

.method private getAudioTimeStamp(I)I
    .locals 1
    .param p1, "audioFramesRecorded"    # I

    .prologue
    .line 1502
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameDuration:I

    mul-int/2addr v0, p1

    return v0
.end method

.method private getColorFormat()I
    .locals 15

    .prologue
    const/4 v14, 0x0

    .line 225
    const/4 v8, 0x0

    .line 226
    .local v8, "index":I
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 227
    .local v4, "compatibleEncoders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/media/MediaCodecInfo;>;"
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    invoke-static {}, Landroid/media/MediaCodecList;->getCodecCount()I

    move-result v12

    if-ge v6, v12, :cond_3

    .line 228
    invoke-static {v6}, Landroid/media/MediaCodecList;->getCodecInfoAt(I)Landroid/media/MediaCodecInfo;

    move-result-object v2

    .line 229
    .local v2, "codecInfo":Landroid/media/MediaCodecInfo;
    invoke-virtual {v2}, Landroid/media/MediaCodecInfo;->isEncoder()Z

    move-result v12

    if-nez v12, :cond_1

    .line 227
    :cond_0
    :goto_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 232
    :cond_1
    invoke-virtual {v2}, Landroid/media/MediaCodecInfo;->getSupportedTypes()[Ljava/lang/String;

    move-result-object v10

    .line 233
    .local v10, "supportedTypes":[Ljava/lang/String;
    move-object v0, v10

    .local v0, "arr$":[Ljava/lang/String;
    array-length v9, v0

    .local v9, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    :goto_2
    if-ge v7, v9, :cond_0

    aget-object v11, v0, v7

    .line 234
    .local v11, "type":Ljava/lang/String;
    sget-object v12, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v11, v12}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v12

    const-string v13, "avc"

    invoke-virtual {v12, v13}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 235
    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 236
    move v8, v6

    .line 237
    goto :goto_1

    .line 233
    :cond_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    .line 242
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v2    # "codecInfo":Landroid/media/MediaCodecInfo;
    .end local v7    # "i$":I
    .end local v9    # "len$":I
    .end local v10    # "supportedTypes":[Ljava/lang/String;
    .end local v11    # "type":Ljava/lang/String;
    :cond_3
    invoke-static {v8}, Landroid/media/MediaCodecList;->getCodecInfoAt(I)Landroid/media/MediaCodecInfo;

    move-result-object v12

    const-string v13, "video/avc"

    invoke-virtual {v12, v13}, Landroid/media/MediaCodecInfo;->getCapabilitiesForType(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;

    move-result-object v1

    .line 244
    .local v1, "capabilities":Landroid/media/MediaCodecInfo$CodecCapabilities;
    const/4 v3, 0x0

    .line 245
    .local v3, "colorFormat":I
    const/4 v5, 0x0

    .line 246
    .local v5, "format":I
    const/4 v6, 0x0

    :goto_3
    iget-object v12, v1, Landroid/media/MediaCodecInfo$CodecCapabilities;->colorFormats:[I

    array-length v12, v12

    if-ge v6, v12, :cond_4

    .line 247
    iget-object v12, v1, Landroid/media/MediaCodecInfo$CodecCapabilities;->colorFormats:[I

    aget v5, v12, v6

    .line 248
    sparse-switch v5, :sswitch_data_0

    .line 260
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "[LVMediaCoderImpl] Skipping unsupported color format "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v12, v14}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 246
    :goto_4
    add-int/lit8 v6, v6, 0x1

    goto :goto_3

    .line 255
    :sswitch_0
    move v3, v5

    .line 256
    goto :goto_4

    .line 265
    :cond_4
    iput v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedColorFormat:I

    .line 266
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "[LVMediaCoderImpl] Color format selected: "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    iget v13, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedColorFormat:I

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v12, v14}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 267
    return v3

    .line 248
    nop

    :sswitch_data_0
    .sparse-switch
        0x13 -> :sswitch_0
        0x14 -> :sswitch_0
        0x15 -> :sswitch_0
        0x27 -> :sswitch_0
        0x7f000100 -> :sswitch_0
    .end sparse-switch
.end method

.method private writeAACToFile([B)V
    .locals 6
    .param p1, "aacData"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 1452
    new-instance v1, Ljava/io/File;

    const-string v3, "mnt/sdcard/Twitter/"

    invoke-direct {v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1453
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    .line 1454
    new-instance v1, Ljava/io/File;

    .end local v1    # "file":Ljava/io/File;
    const-string v3, "mnt/sdcard/Twitter/Twitter_Audio.aac"

    invoke-direct {v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1456
    .restart local v1    # "file":Ljava/io/File;
    :try_start_0
    new-instance v2, Ljava/io/FileOutputStream;

    const/4 v3, 0x1

    invoke-direct {v2, v1, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    .line 1457
    .local v2, "fileOutputStream":Ljava/io/FileOutputStream;
    invoke-virtual {v2, p1}, Ljava/io/FileOutputStream;->write([B)V

    .line 1458
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->flush()V

    .line 1459
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V

    .line 1460
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] writeAACToFile(): "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    array-length v4, p1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " bytes written to file."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v3, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1465
    return-void

    .line 1461
    .end local v2    # "fileOutputStream":Ljava/io/FileOutputStream;
    :catch_0
    move-exception v0

    .line 1462
    .local v0, "e":Ljava/lang/Exception;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] writeAACToFile(): Error writting "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    array-length v4, p1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " bytes to file."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1463
    new-instance v3, Ljava/lang/Exception;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "writeAACToFile(): Error writting "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    array-length v5, p1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " bytes to file."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method private writeYUVToFile([B)V
    .locals 6
    .param p1, "yuvData"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 588
    new-instance v1, Ljava/io/File;

    const-string v3, "mnt/sdcard/Twitter/"

    invoke-direct {v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 589
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    .line 590
    new-instance v1, Ljava/io/File;

    .end local v1    # "file":Ljava/io/File;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "mnt/sdcard/Twitter/YUV_CF_"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSupportedColorFormat:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".yuv"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 592
    .restart local v1    # "file":Ljava/io/File;
    :try_start_0
    new-instance v2, Ljava/io/FileOutputStream;

    const/4 v3, 0x1

    invoke-direct {v2, v1, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    .line 593
    .local v2, "fileOutputStream":Ljava/io/FileOutputStream;
    invoke-virtual {v2, p1}, Ljava/io/FileOutputStream;->write([B)V

    .line 594
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->flush()V

    .line 595
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V

    .line 596
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] writeYUVToFile(): "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    array-length v4, p1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " bytes written to file."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v3, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 601
    return-void

    .line 597
    .end local v2    # "fileOutputStream":Ljava/io/FileOutputStream;
    :catch_0
    move-exception v0

    .line 598
    .local v0, "e":Ljava/lang/Exception;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[LVMediaCoderImpl] writeYUVToFile(): Error writting "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    array-length v4, p1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " bytes to file."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 599
    new-instance v3, Ljava/lang/Exception;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error writting "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    array-length v5, p1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " bytes to file: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v3
.end method


# virtual methods
.method public cancel()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 904
    sget-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-eqz v0, :cond_2

    .line 905
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->cancelEncodingICS()V

    .line 910
    :cond_0
    invoke-virtual {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->stop()V

    .line 912
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRecordingSession:Z

    if-eqz v0, :cond_1

    .line 913
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->deleteOutputFile()V

    .line 916
    :cond_1
    return-void

    .line 906
    :cond_2
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    if-nez v0, :cond_0

    .line 907
    :cond_3
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Encoder is not running."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public encodeAudio([BII)Ljava/nio/ShortBuffer;
    .locals 1
    .param p1, "pcmFrame"    # [B
    .param p2, "start"    # I
    .param p3, "shortCount"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 1251
    sget-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-eqz v0, :cond_0

    .line 1252
    invoke-direct {p0, p1, p2, p3}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeICSAudioFrame([BII)Ljava/nio/ShortBuffer;

    move-result-object v0

    .line 1254
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeAudioFrame([BII)Ljava/nio/ShortBuffer;

    move-result-object v0

    goto :goto_0
.end method

.method public encodeVideo(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;
    .locals 8
    .param p1, "inputFrame"    # Ljava/nio/ByteBuffer;
    .param p2, "inputType"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 517
    const-string v4, "[LVMediaCoderImpl] encodeVideo(): Called."

    invoke-static {v4, v7}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 519
    sget-boolean v4, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-eqz v4, :cond_0

    .line 520
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "LVMediaCoder is running on ICS. Call encodeVideoAsync instead."

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 523
    :cond_0
    iget-boolean v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    if-nez v4, :cond_1

    .line 524
    const-string v4, "[LVMediaCoderImpl] encodeVideo(): LVMediaCoder is not running."

    invoke-static {v4, v6}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 525
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "LVMediaCoder is not running."

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 527
    :cond_1
    if-nez p2, :cond_2

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v4

    iget v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBBufferSize:I

    if-eq v4, v5, :cond_2

    .line 528
    const-string v4, "[LVMediaCoderImpl] encodeVideo(): Improper size of input RGB data."

    invoke-static {v4, v6}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 529
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Improper size of input RGB data."

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 531
    :cond_2
    if-ne p2, v6, :cond_3

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v4

    iget v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRGBABufferSize:I

    if-eq v4, v5, :cond_3

    .line 532
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] encodeVideo(): Improper size of input RGBA data."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " bytes."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v6}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 533
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Improper size of input RGBA data."

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 542
    :cond_3
    invoke-direct {p0, p1, p2}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->convertRGBToYUV(Ljava/nio/ByteBuffer;I)[B

    move-result-object v3

    .line 543
    .local v3, "yuvData":[B
    sget-boolean v4, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-eqz v4, :cond_4

    .line 545
    :try_start_0
    invoke-direct {p0, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->writeYUVToFile([B)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 554
    :cond_4
    :try_start_1
    invoke-direct {p0, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeYUVToH264([B)Ljava/nio/ByteBuffer;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 560
    .local v0, "buffer":Ljava/nio/ByteBuffer;
    sget-boolean v4, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-eqz v4, :cond_5

    .line 562
    :try_start_2
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->dumpH264DataToFile([B)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 569
    :cond_5
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] encodeVideo(): Returning "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v5

    array-length v5, v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " bytes."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v7}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 570
    return-object v0

    .line 546
    .end local v0    # "buffer":Ljava/nio/ByteBuffer;
    :catch_0
    move-exception v1

    .line 547
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 548
    new-instance v4, Ljava/lang/IllegalStateException;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 555
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v2

    .line 556
    .local v2, "e1":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    .line 557
    new-instance v4, Ljava/lang/IllegalStateException;

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 563
    .end local v2    # "e1":Ljava/lang/Exception;
    .restart local v0    # "buffer":Ljava/nio/ByteBuffer;
    :catch_2
    move-exception v1

    .line 564
    .restart local v1    # "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 565
    new-instance v4, Ljava/lang/IllegalStateException;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public encodeVideoAsync(Ljava/nio/ByteBuffer;IZ)V
    .locals 3
    .param p1, "inputFrame"    # Ljava/nio/ByteBuffer;
    .param p2, "inputType"    # I
    .param p3, "isEoS"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 403
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    if-nez v0, :cond_0

    .line 404
    const-string v0, "[LVMediaCoderImpl] encodeVideo(): LVMediaCoder is not running."

    invoke-static {v0, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 405
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "LVMediaCoder is not running."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 407
    :cond_0
    sget-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-eqz v0, :cond_2

    .line 409
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->run:Z

    if-nez v0, :cond_1

    .line 411
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeVideoAsyncPull()V

    .line 412
    const-string v0, "[LVMediaCoderImpl] Starting encodeVideoAsyncPull()"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 413
    iput-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->run:Z

    .line 415
    :cond_1
    iput-boolean p3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isEndOfStream:Z

    .line 416
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[LVMediaCoderImpl] Sending RGB frame "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 417
    invoke-direct {p0, p1, p2, p3}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeICSVideo(Ljava/nio/ByteBuffer;IZ)Ljava/nio/ByteBuffer;

    .line 418
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    .line 422
    return-void

    .line 420
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Method encodeVideoAsync is not supported on JB and above."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getConfiguration()Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;
    .locals 1

    .prologue
    .line 1531
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    return-object v0
.end method

.method public getOutputFilePath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1536
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputFilePath:Ljava/lang/String;

    return-object v0
.end method

.method public recordAudio(Ljava/nio/ShortBuffer;)V
    .locals 16
    .param p1, "aacFrame"    # Ljava/nio/ShortBuffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 1469
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    if-nez v1, :cond_0

    .line 1470
    const-string v1, "[LVMediaCoderImpl] LVMediaCoder is not running."

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1471
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "LVMediaCoder is not running."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1473
    :cond_0
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRecordingSession:Z

    if-nez v1, :cond_1

    .line 1474
    const-string v1, "[LVMediaCoderImpl] Current session is not configured for audio-recording."

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1475
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Current session is not configured for audio-recording."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1478
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[LVMediaCoderImpl] recordAudio(): Capacity of input aacFrame #"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p0

    iget v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFramesRecorded:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual/range {p1 .. p1}, Ljava/nio/ShortBuffer;->capacity()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " shorts, Remaining: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual/range {p1 .. p1}, Ljava/nio/ShortBuffer;->remaining()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1479
    move-object/from16 v0, p0

    iget v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFramesRecorded:I

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->getAudioTimeStamp(I)I

    move-result v15

    .line 1480
    .local v15, "timeStamp":I
    move-object/from16 v0, p0

    iget v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFramesRecorded:I

    add-int/lit8 v1, v1, 0x1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFramesRecorded:I

    .line 1482
    invoke-virtual/range {p1 .. p1}, Ljava/nio/ShortBuffer;->remaining()I

    move-result v1

    invoke-static {v1}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v11

    .line 1484
    .local v11, "audioBuffer":Ljava/nio/ByteBuffer;
    invoke-virtual/range {p1 .. p1}, Ljava/nio/ShortBuffer;->remaining()I

    move-result v1

    new-array v9, v1, [S

    .line 1485
    .local v9, "aacFrameData":[S
    move-object/from16 v0, p1

    invoke-virtual {v0, v9}, Ljava/nio/ShortBuffer;->get([S)Ljava/nio/ShortBuffer;

    .line 1486
    move-object v10, v9

    .local v10, "arr$":[S
    array-length v13, v10

    .local v13, "len$":I
    const/4 v12, 0x0

    .local v12, "i$":I
    :goto_0
    if-ge v12, v13, :cond_2

    aget-short v14, v10, v12

    .line 1487
    .local v14, "s":S
    int-to-byte v1, v14

    invoke-virtual {v11, v1}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 1486
    add-int/lit8 v12, v12, 0x1

    goto :goto_0

    .line 1489
    .end local v14    # "s":S
    :cond_2
    invoke-virtual {v11}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v7

    .line 1490
    .local v7, "audioData":[B
    move-object/from16 v0, p0

    iget v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mWriterJNIContext:I

    if-nez v1, :cond_3

    .line 1491
    const-string v1, "[LVMediaCoderImpl] recordAudio(): WriterJNIContext is NULL"

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1492
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "recordAudio(): WriterJNIContext is NULL"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1494
    :cond_3
    move-object/from16 v0, p0

    iget v1, v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mWriterJNIContext:I

    array-length v2, v7

    int-to-double v3, v15

    int-to-double v5, v15

    const/4 v8, 0x1

    invoke-static/range {v1 .. v8}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->LVMediaCoderWriterProcess(IIDD[BI)I

    .line 1495
    return-void
.end method

.method public recordVideo(Ljava/nio/ByteBuffer;I)V
    .locals 8
    .param p1, "h264Frame"    # Ljava/nio/ByteBuffer;
    .param p2, "timeStamp"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    const/4 v2, 0x1

    .line 1507
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    if-nez v0, :cond_0

    .line 1508
    const-string v0, "[LVMediaCoderImpl] LVMediaCoder is not running."

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1509
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "LVMediaCoder is not running."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1511
    :cond_0
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRecordingSession:Z

    if-nez v0, :cond_1

    .line 1512
    const-string v0, "[LVMediaCoderImpl] Current session is not configured for video-recording."

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1513
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Current session is not configured for video-recording."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1516
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[LVMediaCoderImpl] recordVideo(): Size of input h264Frame #"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFramesRecorded:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " bytes. "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "Position: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " Limit: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " Capacity: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->capacity()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v7}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1518
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v0

    new-array v6, v0, [B

    .line 1519
    .local v6, "videoData":[B
    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 1520
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFramesRecorded:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoFramesRecorded:I

    .line 1522
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mWriterJNIContext:I

    if-nez v0, :cond_2

    .line 1523
    const-string v0, "[LVMediaCoderImpl] recordVideo(): WriterJNIContext is NULL"

    invoke-static {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1524
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "recordVideo(): WriterJNIContext is NULL"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1526
    :cond_2
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mWriterJNIContext:I

    array-length v1, v6

    int-to-double v2, p2

    int-to-double v4, p2

    invoke-static/range {v0 .. v7}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->LVMediaCoderWriterProcess(IIDD[BI)I

    .line 1527
    return-void
.end method

.method public setEncoderVideoAsyncListener(Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;

    .prologue
    .line 399
    iput-object p1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoderListener:Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;

    .line 400
    return-void
.end method

.method public startEncoding()V
    .locals 3

    .prologue
    .line 933
    iget-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    if-eqz v1, :cond_1

    .line 934
    :cond_0
    const-string v1, "[LVMediaCoderImpl] LVMediaCoder is already running."

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 935
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "LVMediaCoder is already running."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 937
    :cond_1
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRecordingSession:Z

    .line 939
    sget-boolean v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-eqz v1, :cond_2

    .line 940
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->configureLVSFSession()V

    .line 949
    :goto_0
    return-void

    .line 943
    :cond_2
    :try_start_0
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->configureSession()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 944
    :catch_0
    move-exception v0

    .line 945
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 946
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public startRecording(Ljava/lang/String;)V
    .locals 11
    .param p1, "outputFilePath"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    .line 953
    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    if-eqz v0, :cond_1

    .line 954
    :cond_0
    const-string v0, "[LVMediaCoderImpl] LVMediaCoder is already running."

    invoke-static {v0, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 955
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "LVMediaCoder is already running."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 957
    :cond_1
    if-eqz p1, :cond_2

    const-string v0, ""

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 958
    :cond_2
    const-string v0, "[LVMediaCoderImpl] Invalid output filepath"

    invoke-static {v0, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 959
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid output filepath parameter."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 961
    :cond_3
    iput-object p1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputFilePath:Ljava/lang/String;

    .line 964
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputFilePath:Ljava/lang/String;

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 965
    .local v6, "directories":[Ljava/lang/String;
    const-string v9, ""

    .line 966
    .local v9, "outputDirectory":Ljava/lang/String;
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    array-length v0, v6

    add-int/lit8 v0, v0, -0x1

    if-ge v8, v0, :cond_4

    .line 967
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 968
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    aget-object v1, v6, v8

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 966
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 970
    :cond_4
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v9}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 972
    iput-boolean v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRecordingSession:Z

    .line 973
    sget-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-eqz v0, :cond_7

    .line 974
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->configureLVSFSession()V

    .line 984
    :goto_1
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameDuration:I

    if-nez v0, :cond_6

    .line 985
    const/16 v10, 0x400

    .line 986
    .local v10, "pcmSize":I
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v0, v0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_5

    .line 987
    const/16 v10, 0x800

    .line 989
    :cond_5
    mul-int/lit8 v0, v10, 0x2

    mul-int/lit16 v0, v0, 0x3e8

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v1, v1, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioSampleRate:I

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    mul-int/2addr v1, v2

    mul-int/lit8 v1, v1, 0x2

    div-int/2addr v0, v1

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioFrameDuration:I

    .line 991
    .end local v10    # "pcmSize":I
    :cond_6
    iget-object v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputFilePath:Ljava/lang/String;

    invoke-static {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->LVMediaCoderInitWriter(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mWriterJNIContext:I

    .line 992
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mWriterJNIContext:I

    if-nez v0, :cond_8

    .line 993
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[LVMediaCoderImpl] LVMediaCoderInitWriter failed! "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 994
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "LVMediaCoderInitWriter failed! "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 977
    :cond_7
    :try_start_0
    invoke-direct {p0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->configureSession()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 978
    :catch_0
    move-exception v7

    .line 979
    .local v7, "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    .line 980
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-virtual {v7}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 997
    .end local v7    # "e":Ljava/lang/Exception;
    :cond_8
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    if-nez v0, :cond_9

    .line 998
    const-string v0, "[LVMediaCoderImpl] startRecording(): Problem getting the Video DSI."

    invoke-static {v0, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 999
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Problem getting the Video DSI."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1001
    :cond_9
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioDSI:[B

    if-nez v0, :cond_a

    .line 1002
    const-string v0, "[LVMediaCoderImpl] startRecording(): Problem getting the Audio DSI"

    invoke-static {v0, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1003
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Problem getting the Audio DSI."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1006
    :cond_a
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mWriterJNIContext:I

    sget-object v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    iget-object v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v2, v2, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    sget-object v4, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    array-length v4, v4

    invoke-static {v0, v1, v2, v3, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->LVMediaCoderWriterAddStreamVideo(I[BIII)I

    .line 1007
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mWriterJNIContext:I

    sget-object v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioDSI:[B

    sget-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioDSI:[B

    array-length v2, v2

    iget-object v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v3, v3, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioBitRate:I

    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v4, v4, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioSampleRate:I

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mConfiguration:Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    iget v5, v5, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    invoke-static/range {v0 .. v5}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->LVMediaCoderWriterAddStreamAudio(I[BIIII)I

    .line 1008
    return-void
.end method

.method public stop()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 1184
    :try_start_0
    sget-boolean v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-eqz v1, :cond_2

    .line 1185
    :goto_0
    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    if-ge v1, v2, :cond_0

    .line 1187
    const-string v1, "[LVMediaCoderImpl] WAITING to complete frame extraction .... ..... ... !!!!!! "

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1188
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[LVMediaCoderImpl] Got : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "sent :"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1190
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->pullerFlagExit:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1242
    :catch_0
    move-exception v0

    .line 1243
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 1244
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[LVMediaCoderImpl] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1245
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " Error while executing stop()"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1193
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    :try_start_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[LVMediaCoderImpl] Got : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "sent :"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1195
    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I

    if-ne v1, v2, :cond_1

    .line 1196
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->pullerFlagExit:Z

    .line 1197
    const/4 v1, 0x0

    iput v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I

    .line 1198
    const/4 v1, 0x0

    iput v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I

    .line 1199
    const-string v1, "[LVMediaCoderImpl] stop(): DONE with frame extraction .... ..... ... !!!!!! "

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 1201
    :cond_1
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->run:Z

    .line 1204
    :cond_2
    iget-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRecordingSession:Z

    if-eqz v1, :cond_3

    .line 1205
    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mWriterJNIContext:I

    invoke-static {v1}, Lcom/lifevibes/mediacoder/LVMediaCoderWriterJNI;->LVMediaCoderWriterClose(I)I

    .line 1208
    :cond_3
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRecordingSession:Z

    .line 1209
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isAudioEncoderRunning:Z

    .line 1210
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isVideoEncoderRunning:Z

    .line 1212
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputVideoBuffers:[Ljava/nio/ByteBuffer;

    .line 1213
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputVideoBuffers:[Ljava/nio/ByteBuffer;

    .line 1214
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mInputAudioBuffers:[Ljava/nio/ByteBuffer;

    .line 1215
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mOutputAudioBuffers:[Ljava/nio/ByteBuffer;

    .line 1217
    sget-boolean v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-nez v1, :cond_4

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    if-eqz v1, :cond_4

    .line 1218
    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v1}, Landroid/media/MediaCodec;->stop()V

    .line 1219
    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v1}, Landroid/media/MediaCodec;->release()V

    .line 1220
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioEncoder:Landroid/media/MediaCodec;

    .line 1222
    :cond_4
    sget-boolean v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSAudioEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

    if-eqz v1, :cond_5

    .line 1223
    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSAudioEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

    invoke-virtual {v1}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->stop()V

    .line 1224
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSAudioEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

    .line 1227
    :cond_5
    sget-boolean v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-nez v1, :cond_6

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    if-eqz v1, :cond_6

    .line 1228
    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v1}, Landroid/media/MediaCodec;->stop()V

    .line 1229
    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    invoke-virtual {v1}, Landroid/media/MediaCodec;->release()V

    .line 1230
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoEncoder:Landroid/media/MediaCodec;

    .line 1232
    :cond_6
    sget-boolean v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    if-eqz v1, :cond_7

    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    if-eqz v1, :cond_7

    .line 1233
    iget-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    invoke-virtual {v1}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->stop()V

    .line 1234
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    .line 1237
    :cond_7
    const/4 v1, 0x0

    iput v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mWriterJNIContext:I

    .line 1238
    const/4 v1, 0x0

    sput-object v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioDSI:[B

    .line 1239
    const/4 v1, 0x0

    sput-object v1, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    .line 1241
    const-string v1, "[LVMediaCoderImpl] LVMediaCoder stopped!"

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 1247
    return-void
.end method
