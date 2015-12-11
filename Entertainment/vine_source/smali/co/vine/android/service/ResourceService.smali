.class public Lco/vine/android/service/ResourceService;
.super Landroid/app/Service;
.source "ResourceService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/service/ResourceService$CameraServiceBinder;
    }
.end annotation


# static fields
.field public static final CONVERSATION_STATE_OFF:Ljava/lang/String; = "co.vine.android.camera.request.conversation.state.off"

.field public static final CONVERSATION_STATE_ON:Ljava/lang/String; = "co.vine.android.camera.request.conversation.state.on"

.field public static final CONVERSATION_STATE_ON_ID:Ljava/lang/String; = "co.vine.android.camera.request.conversation.state.id"

.field public static IS_READY:Z = false

.field public static final REQUEST_CONVERSATION_STATE_BC:I = 0x65

.field public static isConversationActive:Z

.field public static lastActiveconversationRowId:J

.field private static sAudioDataBufferByte:Lco/vine/android/recorder/AudioArray;

.field private static sAudioDataBufferShort:Lco/vine/android/recorder/AudioArray;

.field private static sBufferUserCountByte:I

.field private static sBufferUserCountShort:I

.field private static sFrameBuffer:Ljava/nio/ByteBuffer;

.field private static sIplImage:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

.field private static final sLOCK:[I

.field private static sPictureConverter:Lco/vine/android/recorder/PictureConverter;

.field private static sPreviewBitmap:Landroid/graphics/Bitmap;

.field private static sPreviewCanvas:Landroid/graphics/Canvas;

.field private static sRS:Landroid/support/v8/renderscript/RenderScript;

.field private static sThumbnailBitmap:Landroid/graphics/Bitmap;

.field private static sThumbnailBitmapCanvas:Landroid/graphics/Canvas;

.field private static sThumbnailMatrix:Landroid/graphics/Matrix;

.field private static sVineRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;


# instance fields
.field private final messenger:Landroid/os/Messenger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 46
    new-array v0, v1, [I

    sput-object v0, Lco/vine/android/service/ResourceService;->sLOCK:[I

    .line 49
    sput-boolean v1, Lco/vine/android/service/ResourceService;->IS_READY:Z

    .line 57
    sput-boolean v1, Lco/vine/android/service/ResourceService;->isConversationActive:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 224
    new-instance v0, Landroid/os/Messenger;

    new-instance v1, Lco/vine/android/service/ResourceService$CameraServiceBinder;

    invoke-direct {v1, p0}, Lco/vine/android/service/ResourceService$CameraServiceBinder;-><init>(Lco/vine/android/service/ResourceService;)V

    invoke-direct {v0, v1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lco/vine/android/service/ResourceService;->messenger:Landroid/os/Messenger;

    return-void
.end method

.method public static generateThumbnailBitmap(Landroid/graphics/Point;)Landroid/graphics/Bitmap;
    .locals 2
    .param p0, "size"    # Landroid/graphics/Point;

    .prologue
    .line 280
    iget v1, p0, Landroid/graphics/Point;->x:I

    div-int/lit8 v0, v1, 0x2

    .line 281
    .local v0, "thumbnailSize":I
    sget-object v1, Lco/vine/android/recorder/RecordConfigUtils;->DEFAULT_BITMAP_CONFIG:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v0, v1}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    return-object v1
.end method

.method public static generateThumbnailMatrix(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Matrix;
    .locals 4
    .param p0, "thumbnailBitmap"    # Landroid/graphics/Bitmap;
    .param p1, "previewBitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 273
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    .line 274
    .local v0, "thumbnailMatrix":Landroid/graphics/Matrix;
    const/high16 v2, 0x3f800000    # 1.0f

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    int-to-float v3, v3

    mul-float/2addr v2, v3

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    int-to-float v3, v3

    div-float v1, v2, v3

    .line 275
    .local v1, "thumbnailScale":F
    invoke-virtual {v0, v1, v1}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 276
    return-object v0
.end method

.method public static getAudioDataBuffer(Lco/vine/android/recorder/AudioArray$AudioArrayType;)Lco/vine/android/recorder/AudioArray;
    .locals 3
    .param p0, "type"    # Lco/vine/android/recorder/AudioArray$AudioArrayType;

    .prologue
    const/4 v2, 0x1

    .line 152
    sget-object v1, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v1

    .line 153
    :try_start_0
    sget-object v0, Lco/vine/android/recorder/AudioArray$AudioArrayType;->BYTE:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    if-ne p0, v0, :cond_2

    .line 154
    sget v0, Lco/vine/android/service/ResourceService;->sBufferUserCountByte:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lco/vine/android/service/ResourceService;->sBufferUserCountByte:I

    .line 155
    sget-object v0, Lco/vine/android/service/ResourceService;->sAudioDataBufferByte:Lco/vine/android/recorder/AudioArray;

    if-nez v0, :cond_0

    .line 156
    invoke-static {p0}, Lco/vine/android/recorder/RecordConfigUtils;->createAudioArray(Lco/vine/android/recorder/AudioArray$AudioArrayType;)Lco/vine/android/recorder/AudioArray;

    move-result-object v0

    sput-object v0, Lco/vine/android/service/ResourceService;->sAudioDataBufferByte:Lco/vine/android/recorder/AudioArray;

    .line 158
    :cond_0
    sget v0, Lco/vine/android/service/ResourceService;->sBufferUserCountByte:I

    if-le v0, v2, :cond_1

    .line 159
    invoke-static {p0}, Lco/vine/android/recorder/RecordConfigUtils;->createAudioArray(Lco/vine/android/recorder/AudioArray$AudioArrayType;)Lco/vine/android/recorder/AudioArray;

    move-result-object v0

    monitor-exit v1

    .line 170
    :goto_0
    return-object v0

    .line 161
    :cond_1
    sget-object v0, Lco/vine/android/service/ResourceService;->sAudioDataBufferByte:Lco/vine/android/recorder/AudioArray;

    monitor-exit v1

    goto :goto_0

    .line 172
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 163
    :cond_2
    :try_start_1
    sget v0, Lco/vine/android/service/ResourceService;->sBufferUserCountShort:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lco/vine/android/service/ResourceService;->sBufferUserCountShort:I

    .line 164
    sget-object v0, Lco/vine/android/service/ResourceService;->sAudioDataBufferShort:Lco/vine/android/recorder/AudioArray;

    if-nez v0, :cond_3

    .line 165
    invoke-static {p0}, Lco/vine/android/recorder/RecordConfigUtils;->createAudioArray(Lco/vine/android/recorder/AudioArray$AudioArrayType;)Lco/vine/android/recorder/AudioArray;

    move-result-object v0

    sput-object v0, Lco/vine/android/service/ResourceService;->sAudioDataBufferShort:Lco/vine/android/recorder/AudioArray;

    .line 167
    :cond_3
    sget v0, Lco/vine/android/service/ResourceService;->sBufferUserCountShort:I

    if-le v0, v2, :cond_4

    .line 168
    invoke-static {p0}, Lco/vine/android/recorder/RecordConfigUtils;->createAudioArray(Lco/vine/android/recorder/AudioArray$AudioArrayType;)Lco/vine/android/recorder/AudioArray;

    move-result-object v0

    monitor-exit v1

    goto :goto_0

    .line 170
    :cond_4
    sget-object v0, Lco/vine/android/service/ResourceService;->sAudioDataBufferShort:Lco/vine/android/recorder/AudioArray;

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public static getFrameBuffer()Ljava/nio/ByteBuffer;
    .locals 3

    .prologue
    .line 176
    sget-object v1, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v1

    .line 177
    :try_start_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sFrameBuffer:Ljava/nio/ByteBuffer;

    if-nez v0, :cond_0

    .line 178
    new-instance v0, Lcom/googlecode/javacpp/BytePointer;

    const v2, 0xe1000

    invoke-direct {v0, v2}, Lcom/googlecode/javacpp/BytePointer;-><init>(I)V

    invoke-virtual {v0}, Lcom/googlecode/javacpp/BytePointer;->asByteBuffer()Ljava/nio/ByteBuffer;

    move-result-object v0

    sput-object v0, Lco/vine/android/service/ResourceService;->sFrameBuffer:Ljava/nio/ByteBuffer;

    .line 180
    :cond_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sFrameBuffer:Ljava/nio/ByteBuffer;

    monitor-exit v1

    return-object v0

    .line 181
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getFrameImage()Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .locals 5

    .prologue
    .line 114
    sget-object v1, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v1

    .line 115
    :try_start_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sIplImage:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    if-nez v0, :cond_0

    .line 116
    const/16 v0, 0x1e0

    const/16 v2, 0x1e0

    const/16 v3, 0x8

    const/4 v4, 0x4

    invoke-static {v0, v2, v3, v4}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->create(IIII)Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-result-object v0

    sput-object v0, Lco/vine/android/service/ResourceService;->sIplImage:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    .line 120
    :cond_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sIplImage:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    monitor-exit v1

    return-object v0

    .line 121
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getPictureConverter()Lco/vine/android/recorder/PictureConverter;
    .locals 1

    .prologue
    .line 201
    sget-object v0, Lco/vine/android/service/ResourceService;->sPictureConverter:Lco/vine/android/recorder/PictureConverter;

    return-object v0
.end method

.method public static getPreviewBitmap()Landroid/graphics/Bitmap;
    .locals 2

    .prologue
    .line 105
    sget-object v1, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v1

    .line 106
    :try_start_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sPreviewBitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_0

    .line 107
    invoke-static {}, Lco/vine/android/recorder/RecordConfigUtils;->createDefaultSizeBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    sput-object v0, Lco/vine/android/service/ResourceService;->sPreviewBitmap:Landroid/graphics/Bitmap;

    .line 109
    :cond_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sPreviewBitmap:Landroid/graphics/Bitmap;

    monitor-exit v1

    return-object v0

    .line 110
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getPreviewCanvas()Landroid/graphics/Canvas;
    .locals 3

    .prologue
    .line 143
    sget-object v1, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v1

    .line 144
    :try_start_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sPreviewCanvas:Landroid/graphics/Canvas;

    if-nez v0, :cond_0

    .line 145
    new-instance v0, Landroid/graphics/Canvas;

    invoke-static {}, Lco/vine/android/service/ResourceService;->getPreviewBitmap()Landroid/graphics/Bitmap;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    sput-object v0, Lco/vine/android/service/ResourceService;->sPreviewCanvas:Landroid/graphics/Canvas;

    .line 147
    :cond_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sPreviewCanvas:Landroid/graphics/Canvas;

    monitor-exit v1

    return-object v0

    .line 148
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getRenderScript(Landroid/content/Context;)Landroid/support/v8/renderscript/RenderScript;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 96
    sget-object v1, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v1

    .line 97
    :try_start_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sRS:Landroid/support/v8/renderscript/RenderScript;

    if-nez v0, :cond_0

    .line 98
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v8/renderscript/RenderScript;->create(Landroid/content/Context;)Landroid/support/v8/renderscript/RenderScript;

    move-result-object v0

    sput-object v0, Lco/vine/android/service/ResourceService;->sRS:Landroid/support/v8/renderscript/RenderScript;

    .line 100
    :cond_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sRS:Landroid/support/v8/renderscript/RenderScript;

    monitor-exit v1

    return-object v0

    .line 101
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getThumbnailBitmap(Landroid/content/Context;)Landroid/graphics/Bitmap;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 86
    sget-object v2, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v2

    .line 87
    :try_start_0
    sget-object v1, Lco/vine/android/service/ResourceService;->sThumbnailBitmap:Landroid/graphics/Bitmap;

    if-nez v1, :cond_0

    .line 88
    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/content/Context;)Landroid/graphics/Point;

    move-result-object v0

    .line 89
    .local v0, "size":Landroid/graphics/Point;
    invoke-static {v0}, Lco/vine/android/service/ResourceService;->generateThumbnailBitmap(Landroid/graphics/Point;)Landroid/graphics/Bitmap;

    move-result-object v1

    sput-object v1, Lco/vine/android/service/ResourceService;->sThumbnailBitmap:Landroid/graphics/Bitmap;

    .line 91
    .end local v0    # "size":Landroid/graphics/Point;
    :cond_0
    sget-object v1, Lco/vine/android/service/ResourceService;->sThumbnailBitmap:Landroid/graphics/Bitmap;

    monitor-exit v2

    return-object v1

    .line 92
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public static getThumbnailCanvas(Landroid/content/Context;)Landroid/graphics/Canvas;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 134
    sget-object v1, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v1

    .line 135
    :try_start_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sThumbnailBitmapCanvas:Landroid/graphics/Canvas;

    if-nez v0, :cond_0

    .line 136
    new-instance v0, Landroid/graphics/Canvas;

    invoke-static {p0}, Lco/vine/android/service/ResourceService;->getThumbnailBitmap(Landroid/content/Context;)Landroid/graphics/Bitmap;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    sput-object v0, Lco/vine/android/service/ResourceService;->sThumbnailBitmapCanvas:Landroid/graphics/Canvas;

    .line 138
    :cond_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sThumbnailBitmapCanvas:Landroid/graphics/Canvas;

    monitor-exit v1

    return-object v0

    .line 139
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getThumbnailMatrix(Landroid/content/Context;)Landroid/graphics/Matrix;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 125
    sget-object v1, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v1

    .line 126
    :try_start_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sThumbnailMatrix:Landroid/graphics/Matrix;

    if-nez v0, :cond_0

    .line 127
    invoke-static {p0}, Lco/vine/android/service/ResourceService;->getThumbnailBitmap(Landroid/content/Context;)Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-static {}, Lco/vine/android/service/ResourceService;->getPreviewBitmap()Landroid/graphics/Bitmap;

    move-result-object v2

    invoke-static {v0, v2}, Lco/vine/android/service/ResourceService;->generateThumbnailMatrix(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Matrix;

    move-result-object v0

    sput-object v0, Lco/vine/android/service/ResourceService;->sThumbnailMatrix:Landroid/graphics/Matrix;

    .line 129
    :cond_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sThumbnailMatrix:Landroid/graphics/Matrix;

    monitor-exit v1

    return-object v0

    .line 130
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static initVineRecorder(Landroid/content/Context;)V
    .locals 10
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 62
    sget-object v9, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v9

    .line 63
    :try_start_0
    sget-object v0, Lco/vine/android/service/ResourceService;->sVineRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_2

    .line 66
    :try_start_1
    sget-boolean v0, Lco/vine/android/recorder/SwVineFrameRecorder;->hasEverSuccessfullyLoaded:Z

    if-nez v0, :cond_1

    .line 67
    invoke-static {p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->tryLoad(Landroid/content/Context;)V

    .line 68
    sget-object v0, Lco/vine/android/recorder/RecordSessionManager;->DEFAULT_VERSION:Lco/vine/android/recorder/RecordSessionVersion;

    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->SW_MP4:Lco/vine/android/recorder/RecordSessionVersion;

    if-ne v0, v1, :cond_0

    .line 69
    invoke-static {}, Lco/vine/android/recorder/EncoderManager;->tryLoad()V

    .line 71
    :cond_0
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lco/vine/android/recorder/RecordConfigUtils;->setLoadWasEverSuccessful(Landroid/content/Context;Z)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 77
    :cond_1
    :goto_0
    :try_start_2
    new-instance v0, Lco/vine/android/recorder/SwVineFrameRecorder;

    const-string v1, ""

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-direct/range {v0 .. v6}, Lco/vine/android/recorder/SwVineFrameRecorder;-><init>(Ljava/lang/String;IIILcom/googlecode/javacv/cpp/avcodec$AVPacket;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)V

    sput-object v0, Lco/vine/android/service/ResourceService;->sVineRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 82
    :cond_2
    :goto_1
    :try_start_3
    monitor-exit v9
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 83
    return-void

    .line 73
    :catch_0
    move-exception v7

    .line 74
    .local v7, "e":Ljava/lang/Throwable;
    :try_start_4
    const-string v0, "Failed to load"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v7, v0, v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 75
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lco/vine/android/recorder/RecordConfigUtils;->setLoadWasEverSuccessful(Landroid/content/Context;Z)V
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 78
    .end local v7    # "e":Ljava/lang/Throwable;
    :catch_1
    move-exception v8

    .line 79
    .local v8, "throwable":Ljava/lang/Throwable;
    :try_start_5
    invoke-static {v8}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 82
    .end local v8    # "throwable":Ljava/lang/Throwable;
    :catchall_0
    move-exception v0

    monitor-exit v9
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    throw v0
.end method

.method public static releaseAudioBuffer(Lco/vine/android/recorder/AudioArray$AudioArrayType;)V
    .locals 2
    .param p0, "type"    # Lco/vine/android/recorder/AudioArray$AudioArrayType;

    .prologue
    .line 185
    sget-object v1, Lco/vine/android/service/ResourceService;->sLOCK:[I

    monitor-enter v1

    .line 186
    :try_start_0
    sget-object v0, Lco/vine/android/recorder/AudioArray$AudioArrayType;->BYTE:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    if-ne p0, v0, :cond_1

    .line 187
    sget v0, Lco/vine/android/service/ResourceService;->sBufferUserCountByte:I

    add-int/lit8 v0, v0, -0x1

    sput v0, Lco/vine/android/service/ResourceService;->sBufferUserCountByte:I

    .line 188
    sget v0, Lco/vine/android/service/ResourceService;->sBufferUserCountByte:I

    if-gez v0, :cond_0

    .line 189
    const/4 v0, 0x0

    sput v0, Lco/vine/android/service/ResourceService;->sBufferUserCountByte:I

    .line 197
    :cond_0
    :goto_0
    monitor-exit v1

    .line 198
    return-void

    .line 192
    :cond_1
    sget v0, Lco/vine/android/service/ResourceService;->sBufferUserCountShort:I

    add-int/lit8 v0, v0, -0x1

    sput v0, Lco/vine/android/service/ResourceService;->sBufferUserCountShort:I

    .line 193
    sget v0, Lco/vine/android/service/ResourceService;->sBufferUserCountShort:I

    if-gez v0, :cond_0

    .line 194
    const/4 v0, 0x0

    sput v0, Lco/vine/android/service/ResourceService;->sBufferUserCountShort:I

    goto :goto_0

    .line 197
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static setPictureConverter(Lco/vine/android/recorder/PictureConverter;)V
    .locals 0
    .param p0, "pictureConverter"    # Lco/vine/android/recorder/PictureConverter;

    .prologue
    .line 205
    sput-object p0, Lco/vine/android/service/ResourceService;->sPictureConverter:Lco/vine/android/recorder/PictureConverter;

    .line 206
    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 228
    iget-object v0, p0, Lco/vine/android/service/ResourceService;->messenger:Landroid/os/Messenger;

    invoke-virtual {v0}, Landroid/os/Messenger;->getBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public onCreate()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 244
    const-string v3, "Camera Service onCreate start."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 245
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 247
    .local v1, "start":J
    :try_start_0
    invoke-static {p0}, Lco/vine/android/service/ResourceService;->getThumbnailBitmap(Landroid/content/Context;)Landroid/graphics/Bitmap;

    .line 248
    invoke-static {p0}, Lco/vine/android/service/ResourceService;->getRenderScript(Landroid/content/Context;)Landroid/support/v8/renderscript/RenderScript;

    .line 249
    sget-boolean v3, Lco/vine/android/recorder/RecordConfigUtils;->HW_ENABLED:Z

    if-eqz v3, :cond_0

    .line 250
    invoke-static {}, Lco/vine/android/service/ResourceService;->getFrameBuffer()Ljava/nio/ByteBuffer;

    .line 252
    :cond_0
    sget-boolean v3, Lco/vine/android/recorder/RecordConfigUtils;->SW_ENABLED:Z

    if-eqz v3, :cond_1

    .line 253
    invoke-static {p0}, Lco/vine/android/service/ResourceService;->initVineRecorder(Landroid/content/Context;)V

    .line 254
    invoke-static {}, Lco/vine/android/service/ResourceService;->getFrameImage()Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    .line 256
    :cond_1
    invoke-static {}, Lco/vine/android/service/ResourceService;->getPreviewBitmap()Landroid/graphics/Bitmap;

    .line 257
    invoke-static {p0}, Lco/vine/android/service/ResourceService;->getThumbnailMatrix(Landroid/content/Context;)Landroid/graphics/Matrix;

    .line 258
    invoke-static {p0}, Lco/vine/android/service/ResourceService;->getThumbnailCanvas(Landroid/content/Context;)Landroid/graphics/Canvas;

    .line 259
    invoke-static {}, Lco/vine/android/service/ResourceService;->getPreviewCanvas()Landroid/graphics/Canvas;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 263
    :goto_0
    sput-boolean v6, Lco/vine/android/service/ResourceService;->IS_READY:Z

    .line 264
    const-string v3, "Camera Service took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long/2addr v4, v1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 265
    return-void

    .line 260
    :catch_0
    move-exception v0

    .line 261
    .local v0, "e":Ljava/lang/Throwable;
    const-string v3, "Failed to init camera service, it is ok."

    new-array v4, v6, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 233
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 234
    sget-object v0, Lco/vine/android/service/ResourceService;->sVineRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    if-eqz v0, :cond_0

    .line 235
    sget-object v0, Lco/vine/android/service/ResourceService;->sVineRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    invoke-virtual {v0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 236
    const/4 v0, 0x0

    sput-object v0, Lco/vine/android/service/ResourceService;->sVineRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    .line 238
    :cond_0
    const-string v0, "Camera Service onDestroy.."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 239
    const/4 v0, 0x0

    sput-boolean v0, Lco/vine/android/service/ResourceService;->IS_READY:Z

    .line 240
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 269
    const/4 v0, 0x1

    return v0
.end method
