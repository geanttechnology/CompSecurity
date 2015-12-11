.class public Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;
.super Ljava/lang/Object;
.source "LVMediaCoderSFVideoEncoder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;
    }
.end annotation


# static fields
.field public static LVMC_STREAM_AUDIO:I = 0x0

.field public static LVMC_STREAM_VIDEO:I = 0x0

.field private static LVSFVideoContext:I = 0x0

.field private static MAX_DSI_LEN:I = 0x0

.field static MAX_FRAME_LEN:I = 0x0

.field private static final TAG:Ljava/lang/String; = "LVSF_VideoEncoder"

.field static mFrameHeight:I

.field static mFrameWidth:I

.field static mFramerate:I

.field static mOutEncodedData:[B

.field static mVideoBitrate:I

.field static mVideoMime:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 54
    const/4 v0, 0x1

    sput v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LVMC_STREAM_VIDEO:I

    .line 55
    const/4 v0, 0x2

    sput v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LVMC_STREAM_AUDIO:I

    .line 160
    const/16 v0, 0x80

    sput v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->MAX_DSI_LEN:I

    .line 161
    sput v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LVSFVideoContext:I

    .line 164
    sput v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFrameWidth:I

    .line 165
    sput v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFrameHeight:I

    .line 166
    sput v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mVideoBitrate:I

    .line 167
    sput v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFramerate:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    return-void
.end method

.method private static native LVSFVideoEncoderInit(Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;IIII)I
.end method

.method private static native LifeVibesICSMediaCoderDestroy(I)I
.end method

.method private static native LifeVibesICSMediaCoderEncode(I[B[BZ)I
.end method

.method private static native LifeVibesICSPollEncoderForOutput(I[B)I
.end method

.method public static create(Ljava/lang/String;)Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;
    .locals 2
    .param p0, "mime"    # Ljava/lang/String;

    .prologue
    .line 71
    sput-object p0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mVideoMime:Ljava/lang/String;

    .line 72
    const-string v0, "video/avc"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 74
    const-string v0, "[LVSF_VideoEncoder] Creation not supported for non H264 mime"

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 75
    const/4 v0, 0x0

    .line 77
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    invoke-direct {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;-><init>()V

    goto :goto_0
.end method


# virtual methods
.method public configure(IIII)V
    .locals 4
    .param p1, "height"    # I
    .param p2, "width"    # I
    .param p3, "bitrate"    # I
    .param p4, "fps"    # I

    .prologue
    .line 84
    sput p2, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFrameWidth:I

    .line 85
    sput p1, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFrameHeight:I

    .line 86
    sput p3, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mVideoBitrate:I

    .line 87
    sput p4, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFramerate:I

    .line 88
    sget v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFrameHeight:I

    sget v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFrameWidth:I

    mul-int/2addr v0, v1

    int-to-double v0, v0

    const-wide v2, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v0, v2

    double-to-int v0, v0

    sput v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->MAX_FRAME_LEN:I

    .line 89
    sget v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->MAX_FRAME_LEN:I

    new-array v0, v0, [B

    sput-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mOutEncodedData:[B

    .line 90
    return-void
.end method

.method public encode([BZ)V
    .locals 3
    .param p1, "inputFrame"    # [B
    .param p2, "isEOS"    # Z

    .prologue
    .line 131
    const/4 v0, 0x0

    .line 134
    .local v0, "result":I
    sget v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LVSFVideoContext:I

    sget-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mOutEncodedData:[B

    invoke-static {v1, p1, v2, p2}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LifeVibesICSMediaCoderEncode(I[B[BZ)I

    move-result v0

    .line 135
    return-void
.end method

.method public pollEncoderForOutput()Ljava/nio/ByteBuffer;
    .locals 6

    .prologue
    .line 139
    const/4 v0, 0x0

    .line 142
    .local v0, "EncodedDataLen":I
    sget v4, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LVSFVideoContext:I

    sget-object v5, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mOutEncodedData:[B

    invoke-static {v4, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LifeVibesICSPollEncoderForOutput(I[B)I

    move-result v0

    .line 144
    if-nez v0, :cond_0

    .line 145
    const-string v4, "[LVSF_VideoEncoder] LVSF Native ICS Video Encode poll has DataLen = 0 !"

    const/4 v5, 0x1

    invoke-static {v4, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 146
    const/4 v1, 0x0

    .line 155
    :goto_0
    return-object v1

    .line 148
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVSF_VideoEncoder] LVSF Native ICS Video Encode poll has DataLen = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v4, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 150
    new-array v3, v0, [B

    .line 151
    .local v3, "mOutEncodedDatatest":[B
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, v0, :cond_1

    .line 152
    sget-object v4, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mOutEncodedData:[B

    aget-byte v4, v4, v2

    aput-byte v4, v3, v2

    .line 151
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 154
    :cond_1
    invoke-static {v3}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v1

    .line 155
    .local v1, "buffer":Ljava/nio/ByteBuffer;
    goto :goto_0
.end method

.method public start()V
    .locals 6

    .prologue
    .line 96
    const/4 v0, 0x0

    .line 97
    .local v0, "dsiData":Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;
    new-instance v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;

    .end local v0    # "dsiData":Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;
    invoke-direct {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;-><init>()V

    .line 98
    .restart local v0    # "dsiData":Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;
    sget v2, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->MAX_DSI_LEN:I

    new-array v2, v2, [B

    iput-object v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;->bufferDSI:[B

    .line 99
    const/4 v2, 0x0

    iput v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;->bufferSize:I

    .line 102
    sget v2, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFrameWidth:I

    sget v3, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFrameHeight:I

    sget v4, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mVideoBitrate:I

    sget v5, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->mFramerate:I

    invoke-static {v0, v2, v3, v4, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LVSFVideoEncoderInit(Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;IIII)I

    move-result v2

    sput v2, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LVSFVideoContext:I

    .line 103
    sget v2, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LVSFVideoContext:I

    if-nez v2, :cond_0

    .line 104
    const-string v2, "[LVSF_VideoEncoder] LVSF Native ICS Video Encoder creation failed"

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 105
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "LVSF Native ICS Video Encoder creation failed ..!"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 108
    :cond_0
    iget v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;->bufferSize:I

    new-array v2, v2, [B

    sput-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    .line 109
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget v2, v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;->bufferSize:I

    if-ge v1, v2, :cond_1

    .line 110
    sget-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mVideoDSI:[B

    iget-object v3, v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder$LVSF_mediaDSI;->bufferDSI:[B

    aget-byte v3, v3, v1

    aput-byte v3, v2, v1

    .line 109
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 113
    :cond_1
    return-void
.end method

.method public stop()V
    .locals 3

    .prologue
    .line 119
    sget v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LVSFVideoContext:I

    invoke-static {v1}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->LifeVibesICSMediaCoderDestroy(I)I

    move-result v0

    .line 120
    .local v0, "result":I
    if-eqz v0, :cond_0

    .line 121
    const-string v1, "[LVSF_VideoEncoder] LVSF Native ICS Video stop failed "

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 122
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "LVSF Native ICS Video stop failed ..!"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 124
    :cond_0
    return-void
.end method
