.class public Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;
.super Ljava/lang/Object;
.source "LVMediaCoderSFAudioEncoder.java"


# static fields
.field private static MAX_DSI_LEN:I = 0x0

.field static MAX_FRAME_LEN:I = 0x0

.field private static final TAG:Ljava/lang/String; = "LVSF_AudioEncoder"

.field static mAudioBitrate:I

.field static mAudioDataInput:[B

.field static mAudioMime:Ljava/lang/String;

.field static mChannels:I

.field static mOutEncodedData:[B

.field static mSampleRate:I


# instance fields
.field private LVSFAudioContext:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 128
    const/16 v0, 0x80

    sput v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->MAX_DSI_LEN:I

    .line 132
    sput v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mSampleRate:I

    .line 133
    sput v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mAudioBitrate:I

    .line 134
    sput v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mChannels:I

    .line 138
    const/16 v0, 0x1000

    sput v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->MAX_FRAME_LEN:I

    .line 139
    sget v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->MAX_FRAME_LEN:I

    new-array v0, v0, [B

    sput-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mOutEncodedData:[B

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 129
    const/4 v0, 0x0

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioContext:I

    return-void
.end method

.method private static native LVSFAudioEncoderEncode(I[B[BI)I
.end method

.method private static native LVSFAudioEncoderGetDSIInfo(I[B)I
.end method

.method private static native LVSFAudioEncoderInit(III)I
.end method

.method private static native LVSFAudioEncoderStop(I)I
.end method

.method public static create(Ljava/lang/String;)Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;
    .locals 2
    .param p0, "mime"    # Ljava/lang/String;

    .prologue
    .line 56
    sput-object p0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mAudioMime:Ljava/lang/String;

    .line 57
    const-string v0, "audio/mp4a-latm"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 59
    const-string v0, "[LVSF_AudioEncoder] Creation not supported for non AAC mime"

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 60
    const/4 v0, 0x0

    .line 62
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;

    invoke-direct {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;-><init>()V

    goto :goto_0
.end method


# virtual methods
.method public configure(III)V
    .locals 0
    .param p1, "bitrate"    # I
    .param p2, "sampleRate"    # I
    .param p3, "channels"    # I

    .prologue
    .line 69
    sput p1, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mAudioBitrate:I

    .line 70
    sput p2, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mSampleRate:I

    .line 71
    sput p3, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mChannels:I

    .line 72
    return-void
.end method

.method public encode([B)Ljava/nio/ShortBuffer;
    .locals 7
    .param p1, "inPCM"    # [B

    .prologue
    .line 114
    sget v5, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mChannels:I

    mul-int/lit16 v1, v5, 0x800

    .line 115
    .local v1, "inputLength":I
    iget v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioContext:I

    sget-object v6, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mOutEncodedData:[B

    invoke-static {v5, p1, v6, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioEncoderEncode(I[B[BI)I

    move-result v4

    .line 117
    .local v4, "size":I
    invoke-static {v4}, Ljava/nio/ShortBuffer;->allocate(I)Ljava/nio/ShortBuffer;

    move-result-object v3

    .line 118
    .local v3, "shortBuffer":Ljava/nio/ShortBuffer;
    new-array v2, v4, [S

    .line 120
    .local v2, "shortArray2":[S
    const/4 v0, 0x0

    .local v0, "index":I
    :goto_0
    if-ge v0, v4, :cond_0

    .line 121
    sget-object v5, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mOutEncodedData:[B

    aget-byte v5, v5, v0

    int-to-short v5, v5

    aput-short v5, v2, v0

    .line 120
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 123
    :cond_0
    invoke-virtual {v3, v2}, Ljava/nio/ShortBuffer;->put([S)Ljava/nio/ShortBuffer;

    .line 124
    return-object v3
.end method

.method public getDSI()V
    .locals 5

    .prologue
    .line 88
    sget v3, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->MAX_DSI_LEN:I

    new-array v2, v3, [B

    .line 89
    .local v2, "tempDSI":[B
    const/4 v0, 0x0

    .line 90
    .local v0, "dsilen":I
    iget v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioContext:I

    if-eqz v3, :cond_0

    .line 92
    iget v3, p0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioContext:I

    invoke-static {v3, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioEncoderGetDSIInfo(I[B)I

    move-result v0

    .line 93
    new-array v3, v0, [B

    sput-object v3, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioDSI:[B

    .line 94
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 95
    sget-object v3, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mAudioDSI:[B

    aget-byte v4, v2, v1

    aput-byte v4, v3, v1

    .line 94
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 98
    .end local v1    # "i":I
    :cond_0
    return-void
.end method

.method public start()V
    .locals 3

    .prologue
    .line 78
    sget v0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mAudioBitrate:I

    sget v1, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mSampleRate:I

    sget v2, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->mChannels:I

    invoke-static {v0, v1, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioEncoderInit(III)I

    move-result v0

    iput v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioContext:I

    .line 79
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioContext:I

    if-nez v0, :cond_0

    .line 80
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "LVSF Native ICS Audio Encoder creation failed ..!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 82
    :cond_0
    return-void
.end method

.method public stop()V
    .locals 3

    .prologue
    .line 104
    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioContext:I

    invoke-static {v1}, Lcom/lifevibes/mediacoder/LVMediaCoderSFAudioEncoder;->LVSFAudioEncoderStop(I)I

    move-result v0

    .line 105
    .local v0, "result":I
    if-eqz v0, :cond_0

    .line 106
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "LVSF Native ICS Audio Encoder stop failed ..!"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 108
    :cond_0
    return-void
.end method
