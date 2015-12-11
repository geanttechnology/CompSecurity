.class public Lco/vine/android/recorder/SwVineFrameRecorder;
.super Ljava/lang/Object;
.source "SwVineFrameRecorder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z

.field public static final LOCK:[I

.field public static hasEverSuccessfullyLoaded:Z

.field private static loadingException:Lco/vine/android/recorder/SwVineFrameRecorder$Exception;


# instance fields
.field protected audioBitrate:I

.field protected audioChannels:I

.field protected audioCodec:I

.field protected audioCodecName:Ljava/lang/String;

.field protected audioOptions:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected audioQuality:D

.field private audioRecordTime:J

.field private audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

.field private audio_clock:J

.field private audio_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

.field private audio_input_frame_size:I

.field private audio_outbuf:Lcom/googlecode/javacpp/BytePointer;

.field private audio_outbuf_size:I

.field public audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

.field private audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

.field private filename:Ljava/lang/String;

.field protected format:Ljava/lang/String;

.field private frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

.field protected frameNumber:I

.field protected frameRate:D

.field private got_audio_packet:[I

.field private got_video_packet:[I

.field private hasData:Z

.field protected imageHeight:I

.field protected imageWidth:I

.field private img_convert_ctx:Lcom/googlecode/javacv/cpp/swscale$SwsContext;

.field protected interleaved:Z

.field private volatile isReleased:Z

.field private isVorbis:Z

.field private oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

.field private oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

.field private picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

.field private picture_buf:Lcom/googlecode/javacpp/BytePointer;

.field protected pixelFormat:I

.field protected sampleFormat:I

.field protected sampleRate:I

.field private samples_convert_ctx:Lcom/googlecode/javacv/cpp/swresample$SwrContext;

.field private samples_in:[Lcom/googlecode/javacpp/Pointer;

.field private samples_in_ptr:Lcom/googlecode/javacpp/PointerPointer;

.field private samples_out:[Lcom/googlecode/javacpp/BytePointer;

.field private samples_out_ptr:Lcom/googlecode/javacpp/PointerPointer;

.field protected timestamp:J

.field private tmp_picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

.field protected videoBitrate:I

.field protected videoCodec:I

.field protected videoCodecName:Ljava/lang/String;

.field private videoEncodeTime:J

.field protected videoOptions:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected videoQuality:D

.field private videoScaleTime:J

.field private videoWriteTime:J

.field private video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

.field private video_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

.field private video_outbuf:Lcom/googlecode/javacpp/BytePointer;

.field private video_outbuf_size:I

.field public video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

.field private video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 194
    const-class v0, Lco/vine/android/recorder/SwVineFrameRecorder;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lco/vine/android/recorder/SwVineFrameRecorder;->$assertionsDisabled:Z

    .line 210
    new-array v0, v1, [I

    sput-object v0, Lco/vine/android/recorder/SwVineFrameRecorder;->LOCK:[I

    .line 216
    const/4 v0, 0x0

    sput-object v0, Lco/vine/android/recorder/SwVineFrameRecorder;->loadingException:Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    .line 218
    sput-boolean v1, Lco/vine/android/recorder/SwVineFrameRecorder;->hasEverSuccessfullyLoaded:Z

    .line 264
    sget-object v1, Lco/vine/android/recorder/SwVineFrameRecorder;->LOCK:[I

    monitor-enter v1

    .line 265
    :try_start_0
    invoke-static {}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_register_all()V

    .line 266
    invoke-static {}, Lcom/googlecode/javacv/cpp/avformat;->av_register_all()V

    .line 267
    monitor-exit v1

    .line 268
    return-void

    :cond_0
    move v0, v1

    .line 194
    goto :goto_0

    .line 267
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public constructor <init>(Ljava/io/File;I)V
    .locals 1
    .param p1, "file"    # Ljava/io/File;
    .param p2, "audioChannels"    # I

    .prologue
    const/4 v0, 0x0

    .line 244
    invoke-direct {p0, p1, v0, v0, p2}, Lco/vine/android/recorder/SwVineFrameRecorder;-><init>(Ljava/io/File;III)V

    .line 245
    return-void
.end method

.method public constructor <init>(Ljava/io/File;II)V
    .locals 1
    .param p1, "file"    # Ljava/io/File;
    .param p2, "imageWidth"    # I
    .param p3, "imageHeight"    # I

    .prologue
    .line 252
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lco/vine/android/recorder/SwVineFrameRecorder;-><init>(Ljava/io/File;III)V

    .line 253
    return-void
.end method

.method public constructor <init>(Ljava/io/File;III)V
    .locals 1
    .param p1, "file"    # Ljava/io/File;
    .param p2, "imageWidth"    # I
    .param p3, "imageHeight"    # I
    .param p4, "audioChannels"    # I

    .prologue
    .line 260
    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p2, p3, p4}, Lco/vine/android/recorder/SwVineFrameRecorder;-><init>(Ljava/lang/String;III)V

    .line 261
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 1
    .param p1, "filename"    # Ljava/lang/String;
    .param p2, "audioChannels"    # I

    .prologue
    const/4 v0, 0x0

    .line 248
    invoke-direct {p0, p1, v0, v0, p2}, Lco/vine/android/recorder/SwVineFrameRecorder;-><init>(Ljava/lang/String;III)V

    .line 249
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;II)V
    .locals 1
    .param p1, "filename"    # Ljava/lang/String;
    .param p2, "imageWidth"    # I
    .param p3, "imageHeight"    # I

    .prologue
    .line 256
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lco/vine/android/recorder/SwVineFrameRecorder;-><init>(Ljava/lang/String;III)V

    .line 257
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;III)V
    .locals 7
    .param p1, "filename"    # Ljava/lang/String;
    .param p2, "imageWidth"    # I
    .param p3, "imageHeight"    # I
    .param p4, "audioChannels"    # I

    .prologue
    const/4 v5, 0x0

    .line 295
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move-object v6, v5

    invoke-direct/range {v0 .. v6}, Lco/vine/android/recorder/SwVineFrameRecorder;-><init>(Ljava/lang/String;IIILcom/googlecode/javacv/cpp/avcodec$AVPacket;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)V

    .line 296
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;IIILcom/googlecode/javacv/cpp/avcodec$AVPacket;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)V
    .locals 5
    .param p1, "filename"    # Ljava/lang/String;
    .param p2, "imageWidth"    # I
    .param p3, "imageHeight"    # I
    .param p4, "audioChannels"    # I
    .param p5, "videoPacket"    # Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    .param p6, "audioPacket"    # Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .prologue
    const/4 v4, -0x1

    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    const/4 v3, 0x0

    .line 270
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 199
    iput-wide v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoQuality:D

    .line 201
    iput-wide v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioQuality:D

    .line 203
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoOptions:Ljava/util/HashMap;

    .line 204
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioOptions:Ljava/util/HashMap;

    .line 205
    iput v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->frameNumber:I

    .line 206
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->timestamp:J

    .line 212
    iput-boolean v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->hasData:Z

    .line 213
    iput-boolean v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->isReleased:Z

    .line 272
    const-string v0, "Creating a recorder thats {} * {}"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 274
    iput-object p1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    .line 275
    iput p2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageWidth:I

    .line 276
    iput p3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageHeight:I

    .line 277
    iput p4, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioChannels:I

    .line 279
    iput v4, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->pixelFormat:I

    .line 280
    iput v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoCodec:I

    .line 281
    sget v0, Lco/vine/android/recorder/RecordConfigUtils;->VIDEO_BIT_RATE:I

    iput v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoBitrate:I

    .line 282
    const-wide/high16 v0, 0x403e000000000000L    # 30.0

    iput-wide v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->frameRate:D

    .line 284
    iput v4, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleFormat:I

    .line 285
    iput v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioCodec:I

    .line 286
    sget v0, Lco/vine/android/recorder/RecordConfigUtils;->AUDIO_BIT_RATE:I

    iput v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioBitrate:I

    .line 287
    const v0, 0xac44

    iput v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleRate:I

    .line 289
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->interleaved:Z

    .line 290
    if-eqz p5, :cond_0

    .end local p5    # "videoPacket":Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    :goto_0
    iput-object p5, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 291
    if-eqz p6, :cond_1

    .end local p6    # "audioPacket":Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    :goto_1
    iput-object p6, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 292
    return-void

    .line 290
    .restart local p5    # "videoPacket":Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    .restart local p6    # "audioPacket":Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    :cond_0
    new-instance p5, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .end local p5    # "videoPacket":Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    invoke-direct {p5}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;-><init>()V

    goto :goto_0

    .line 291
    :cond_1
    new-instance p6, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .end local p6    # "audioPacket":Lcom/googlecode/javacv/cpp/avcodec$AVPacket;
    invoke-direct {p6}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;-><init>()V

    goto :goto_1
.end method

.method public static tryLoad(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 222
    sget-object v1, Lco/vine/android/recorder/SwVineFrameRecorder;->loadingException:Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    if-eqz v1, :cond_0

    .line 223
    sget-object v1, Lco/vine/android/recorder/SwVineFrameRecorder;->loadingException:Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    throw v1

    .line 226
    :cond_0
    :try_start_0
    const-class v1, Lcom/googlecode/javacv/cpp/avutil;

    invoke-static {v1}, Lcom/googlecode/javacpp/Loader;->load(Ljava/lang/Class;)Ljava/lang/String;

    .line 227
    const-class v1, Lcom/googlecode/javacv/cpp/avcodec;

    invoke-static {v1}, Lcom/googlecode/javacpp/Loader;->load(Ljava/lang/Class;)Ljava/lang/String;

    .line 228
    const-class v1, Lcom/googlecode/javacv/cpp/avformat;

    invoke-static {v1}, Lcom/googlecode/javacpp/Loader;->load(Ljava/lang/Class;)Ljava/lang/String;

    .line 229
    const-class v1, Lcom/googlecode/javacv/cpp/swscale;

    invoke-static {v1}, Lcom/googlecode/javacpp/Loader;->load(Ljava/lang/Class;)Ljava/lang/String;

    .line 230
    const-class v1, Lcom/googlecode/javacv/cpp/swresample;

    invoke-static {v1}, Lcom/googlecode/javacpp/Loader;->load(Ljava/lang/Class;)Ljava/lang/String;

    .line 231
    const/4 v1, 0x1

    sput-boolean v1, Lco/vine/android/recorder/SwVineFrameRecorder;->hasEverSuccessfullyLoaded:Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 239
    invoke-static {p0, v2}, Lco/vine/android/recorder/RecordConfigUtils;->setLoadWasEverSuccessful(Landroid/content/Context;Z)V

    .line 241
    return-void

    .line 232
    :catch_0
    move-exception v0

    .line 233
    .local v0, "t":Ljava/lang/Throwable;
    instance-of v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    if-eqz v1, :cond_1

    .line 234
    check-cast v0, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    .end local v0    # "t":Ljava/lang/Throwable;
    sput-object v0, Lco/vine/android/recorder/SwVineFrameRecorder;->loadingException:Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    throw v0

    .line 236
    .restart local v0    # "t":Ljava/lang/Throwable;
    :cond_1
    new-instance v1, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to load "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-class v3, Lco/vine/android/recorder/SwVineFrameRecorder;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    sput-object v1, Lco/vine/android/recorder/SwVineFrameRecorder;->loadingException:Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    throw v1
.end method

.method private writeVideoFrame()I
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    .line 901
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 902
    .local v1, "start":J
    iget-object v4, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    monitor-enter v4

    .line 904
    :try_start_0
    iget-boolean v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->interleaved:Z

    if-eqz v3, :cond_0

    iget-object v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    if-eqz v3, :cond_0

    .line 905
    iget-object v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    iget-object v5, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-static {v3, v5}, Lcom/googlecode/javacv/cpp/avformat;->av_interleaved_write_frame(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)I

    move-result v0

    .local v0, "ret":I
    if-gez v0, :cond_1

    .line 906
    new-instance v3, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "av_interleaved_write_frame() error "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " while writing interleaved video frame."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v5}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v3

    .line 915
    .end local v0    # "ret":I
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 909
    :cond_0
    :try_start_1
    iget-object v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    iget-object v5, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-static {v3, v5}, Lcom/googlecode/javacv/cpp/avformat;->av_write_frame(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)I

    move-result v0

    .restart local v0    # "ret":I
    if-gez v0, :cond_1

    .line 910
    new-instance v3, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "av_write_frame() error "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " while writing video frame."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v5}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v3

    .line 913
    :cond_1
    iget-wide v5, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoWriteTime:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    sub-long/2addr v7, v1

    add-long/2addr v5, v7

    iput-wide v5, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoWriteTime:J

    .line 914
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return v0
.end method


# virtual methods
.method public encode(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;[BI)I
    .locals 3
    .param p1, "image"    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .param p2, "output"    # [B
    .param p3, "start"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    const/4 v1, -0x1

    .line 859
    const/4 v2, 0x1

    invoke-virtual {p0, p1, v1, v2}, Lco/vine/android/recorder/SwVineFrameRecorder;->record(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;IZ)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 860
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->data()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v0

    .line 861
    .local v0, "data":Lcom/googlecode/javacpp/BytePointer;
    if-eqz v0, :cond_0

    .line 862
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->size()I

    move-result v1

    .line 863
    .local v1, "limit":I
    invoke-virtual {v0, p2, p3, v1}, Lcom/googlecode/javacpp/BytePointer;->get([BII)Lcom/googlecode/javacpp/BytePointer;

    .line 867
    .end local v0    # "data":Lcom/googlecode/javacpp/BytePointer;
    .end local v1    # "limit":I
    :cond_0
    return v1
.end method

.method protected finalize()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 384
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 385
    invoke-virtual {p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 386
    return-void
.end method

.method public getAudioCodecName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1027
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioCodecName:Ljava/lang/String;

    return-object v0
.end method

.method public getErrorString(I)Ljava/lang/String;
    .locals 8
    .param p1, "ret"    # I

    .prologue
    .line 448
    const/16 v6, 0x40

    new-array v5, v6, [B

    .line 449
    .local v5, "st":[B
    array-length v6, v5

    int-to-long v6, v6

    invoke-static {v5, v6, v7, p1}, Lcom/googlecode/javacv/cpp/avutil;->av_make_error_string([BJI)[B

    .line 450
    const/4 v2, 0x0

    .line 451
    .local v2, "i":I
    move-object v1, v5

    .local v1, "arr$":[B
    array-length v4, v1

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-byte v0, v1, v3

    .line 452
    .local v0, "a":B
    if-nez v0, :cond_1

    .line 458
    .end local v0    # "a":B
    :cond_0
    new-instance v6, Ljava/lang/String;

    const/4 v7, 0x0

    invoke-direct {v6, v5, v7, v2}, Ljava/lang/String;-><init>([BII)V

    return-object v6

    .line 455
    .restart local v0    # "a":B
    :cond_1
    add-int/lit8 v2, v2, 0x1

    .line 451
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method public getFilename()Ljava/lang/String;
    .locals 1

    .prologue
    .line 389
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    return-object v0
.end method

.method public getFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1213
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->format:Ljava/lang/String;

    return-object v0
.end method

.method public getFrameNumber()I
    .locals 2

    .prologue
    .line 416
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts()J

    move-result-wide v0

    long-to-int v0, v0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->pts()J

    move-result-wide v0

    long-to-int v0, v0

    goto :goto_0
.end method

.method public getFrameRate()D
    .locals 2

    .prologue
    .line 1225
    iget-wide v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->frameRate:D

    return-wide v0
.end method

.method public getTimestamp()J
    .locals 4

    .prologue
    const-wide/32 v2, 0xf4240

    .line 428
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-nez v0, :cond_0

    .line 429
    iget-wide v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_clock:J

    mul-long/2addr v0, v2

    iget v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleRate:I

    int-to-long v2, v2

    div-long/2addr v0, v2

    .line 431
    :goto_0
    return-wide v0

    :cond_0
    invoke-virtual {p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->getFrameNumber()I

    move-result v0

    int-to-long v0, v0

    mul-long/2addr v0, v2

    long-to-double v0, v0

    invoke-virtual {p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->getFrameRate()D

    move-result-wide v2

    div-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    goto :goto_0
.end method

.method public getVideoCodecName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1019
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoCodecName:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoCodecPixFormat()I
    .locals 1

    .prologue
    .line 871
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->pix_fmt()I

    move-result v0

    return v0
.end method

.method public hasData()Z
    .locals 1

    .prologue
    .line 1205
    iget-boolean v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->hasData:Z

    return v0
.end method

.method public isReleased()Z
    .locals 1

    .prologue
    .line 1209
    iget-boolean v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->isReleased:Z

    return v0
.end method

.method public record(Lcom/googlecode/javacv/Frame;)V
    .locals 1
    .param p1, "frame"    # Lcom/googlecode/javacv/Frame;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    .line 1245
    if-eqz p1, :cond_0

    iget-object v0, p1, Lcom/googlecode/javacv/Frame;->image:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    if-nez v0, :cond_2

    iget-object v0, p1, Lcom/googlecode/javacv/Frame;->samples:[Ljava/nio/Buffer;

    if-nez v0, :cond_2

    .line 1246
    :cond_0
    const/4 v0, 0x0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/SwVineFrameRecorder;->record(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)Z

    .line 1255
    :cond_1
    :goto_0
    return-void

    .line 1248
    :cond_2
    iget-object v0, p1, Lcom/googlecode/javacv/Frame;->image:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    if-eqz v0, :cond_3

    .line 1249
    iget-object v0, p1, Lcom/googlecode/javacv/Frame;->image:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/SwVineFrameRecorder;->record(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)Z

    move-result v0

    iput-boolean v0, p1, Lcom/googlecode/javacv/Frame;->keyFrame:Z

    .line 1251
    :cond_3
    iget-object v0, p1, Lcom/googlecode/javacv/Frame;->samples:[Ljava/nio/Buffer;

    if-eqz v0, :cond_1

    .line 1252
    iget-object v0, p1, Lcom/googlecode/javacv/Frame;->samples:[Ljava/nio/Buffer;

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/SwVineFrameRecorder;->record([Ljava/nio/Buffer;)Z

    move-result v0

    iput-boolean v0, p1, Lcom/googlecode/javacv/Frame;->keyFrame:Z

    goto :goto_0
.end method

.method record(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)Z
    .locals 6
    .param p1, "frame"    # Lcom/googlecode/javacv/cpp/avutil$AVFrame;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 1170
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avcodec;->av_init_packet(Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)V

    .line 1171
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf:Lcom/googlecode/javacpp/BytePointer;

    invoke-virtual {v2, v3}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->data(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 1172
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf_size:I

    invoke-virtual {v2, v3}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->size(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 1173
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    iget-object v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v4, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->got_audio_packet:[I

    invoke-static {v2, v3, p1, v4}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_encode_audio2(Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;Lcom/googlecode/javacv/cpp/avutil$AVFrame;[I)I

    move-result v0

    .local v0, "ret":I
    if-gez v0, :cond_0

    .line 1174
    new-instance v1, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "avcodec_encode_audio2() error "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ": Could not encode audio packet."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1176
    :cond_0
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->got_audio_packet:[I

    aget v2, v2, v1

    if-eqz v2, :cond_5

    .line 1177
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts()J

    move-result-wide v1

    sget-wide v3, Lcom/googlecode/javacv/cpp/avutil;->AV_NOPTS_VALUE:J

    cmp-long v1, v1, v3

    if-eqz v1, :cond_1

    .line 1178
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts()J

    move-result-wide v2

    iget-object v4, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v5}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v5

    invoke-static {v2, v3, v4, v5}, Lcom/googlecode/javacv/cpp/avutil;->av_rescale_q(JLcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts(J)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 1180
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->dts()J

    move-result-wide v1

    sget-wide v3, Lcom/googlecode/javacv/cpp/avutil;->AV_NOPTS_VALUE:J

    cmp-long v1, v1, v3

    if-eqz v1, :cond_2

    .line 1181
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->dts()J

    move-result-wide v2

    iget-object v4, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v5}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v5

    invoke-static {v2, v3, v4, v5}, Lcom/googlecode/javacv/cpp/avutil;->av_rescale_q(JLcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->dts(J)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 1183
    :cond_2
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->flags()I

    move-result v2

    or-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->flags(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 1184
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->index()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->stream_index(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 1190
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    monitor-enter v2

    .line 1191
    :try_start_0
    iget-boolean v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->interleaved:Z

    if-eqz v1, :cond_3

    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    if-eqz v1, :cond_3

    .line 1192
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    iget-object v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-static {v1, v3}, Lcom/googlecode/javacv/cpp/avformat;->av_interleaved_write_frame(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)I

    move-result v0

    if-gez v0, :cond_4

    .line 1193
    new-instance v1, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "av_interleaved_write_frame() error "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " while writing interleaved audio frame."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1200
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 1196
    :cond_3
    :try_start_1
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    iget-object v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-static {v1, v3}, Lcom/googlecode/javacv/cpp/avformat;->av_write_frame(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)I

    move-result v0

    if-gez v0, :cond_4

    .line 1197
    new-instance v1, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "av_write_frame() error "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " while writing audio frame."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1200
    :cond_4
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1201
    const/4 v1, 0x1

    :cond_5
    return v1
.end method

.method public record(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)Z
    .locals 2
    .param p1, "image"    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    .line 855
    const/4 v0, -0x1

    const/4 v1, 0x0

    invoke-virtual {p0, p1, v0, v1}, Lco/vine/android/recorder/SwVineFrameRecorder;->record(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;IZ)Z

    move-result v0

    return v0
.end method

.method public record(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;IZ)Z
    .locals 19
    .param p1, "image"    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .param p2, "pixelFormat"    # I
    .param p3, "encodeOnly"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    .line 919
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    if-nez v1, :cond_0

    .line 920
    new-instance v1, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v4, "No video output stream (Is imageWidth > 0 && imageHeight > 0 and has start() been called?)"

    invoke-direct {v1, v4}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v1

    .line 923
    :cond_0
    if-nez p1, :cond_1

    .line 973
    :goto_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->flags()I

    move-result v1

    and-int/lit8 v1, v1, 0x20

    if-eqz v1, :cond_13

    .line 974
    if-nez p1, :cond_11

    .line 975
    const/4 v1, 0x0

    .line 1015
    :goto_1
    return v1

    .line 928
    :cond_1
    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->hasData:Z

    .line 929
    invoke-virtual/range {p1 .. p1}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->width()I

    move-result v2

    .line 930
    .local v2, "width":I
    invoke-virtual/range {p1 .. p1}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->height()I

    move-result v3

    .line 931
    .local v3, "height":I
    invoke-virtual/range {p1 .. p1}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->widthStep()I

    move-result v18

    .line 932
    .local v18, "step":I
    invoke-virtual/range {p1 .. p1}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->imageData()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v13

    .line 934
    .local v13, "data":Lcom/googlecode/javacpp/BytePointer;
    const/4 v1, -0x1

    move/from16 v0, p2

    if-ne v0, v1, :cond_3

    .line 935
    invoke-virtual/range {p1 .. p1}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->depth()I

    move-result v14

    .line 936
    .local v14, "depth":I
    invoke-virtual/range {p1 .. p1}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->nChannels()I

    move-result v12

    .line 937
    .local v12, "channels":I
    const/16 v1, 0x8

    if-eq v14, v1, :cond_2

    const v1, -0x7ffffff8

    if-ne v14, v1, :cond_5

    :cond_2
    const/4 v1, 0x3

    if-ne v12, v1, :cond_5

    .line 938
    const/16 p2, 0x3

    .line 953
    .end local v12    # "channels":I
    .end local v14    # "depth":I
    :cond_3
    :goto_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v16

    .line 955
    .local v16, "start":J
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->pix_fmt()I

    move-result v1

    move/from16 v0, p2

    if-ne v1, v0, :cond_4

    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width()I

    move-result v1

    if-ne v1, v2, :cond_4

    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height()I

    move-result v1

    if-eq v1, v3, :cond_10

    .line 957
    :cond_4
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->img_convert_ctx:Lcom/googlecode/javacv/cpp/swscale$SwsContext;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width()I

    move-result v5

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height()I

    move-result v6

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->pix_fmt()I

    move-result v7

    const/4 v8, 0x2

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    check-cast v11, Lcom/googlecode/javacpp/DoublePointer;

    move/from16 v4, p2

    invoke-static/range {v1 .. v11}, Lcom/googlecode/javacv/cpp/swscale;->sws_getCachedContext(Lcom/googlecode/javacv/cpp/swscale$SwsContext;IIIIIIILcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacv/cpp/swscale$SwsFilter;Lcom/googlecode/javacpp/DoublePointer;)Lcom/googlecode/javacv/cpp/swscale$SwsContext;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->img_convert_ctx:Lcom/googlecode/javacv/cpp/swscale$SwsContext;

    .line 959
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->img_convert_ctx:Lcom/googlecode/javacv/cpp/swscale$SwsContext;

    if-nez v1, :cond_f

    .line 960
    new-instance v1, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v4, "sws_getCachedContext() error: Cannot initialize the conversion context."

    invoke-direct {v1, v4}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v1

    .line 939
    .end local v16    # "start":J
    .restart local v12    # "channels":I
    .restart local v14    # "depth":I
    :cond_5
    const/16 v1, 0x8

    if-eq v14, v1, :cond_6

    const v1, -0x7ffffff8

    if-ne v14, v1, :cond_7

    :cond_6
    const/4 v1, 0x1

    if-ne v12, v1, :cond_7

    .line 940
    const/16 p2, 0x8

    goto :goto_2

    .line 941
    :cond_7
    const/16 v1, 0x10

    if-eq v14, v1, :cond_8

    const v1, -0x7ffffff0

    if-ne v14, v1, :cond_a

    :cond_8
    const/4 v1, 0x1

    if-ne v12, v1, :cond_a

    .line 942
    invoke-static {}, Ljava/nio/ByteOrder;->nativeOrder()Ljava/nio/ByteOrder;

    move-result-object v1

    sget-object v4, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {v1, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    const/16 p2, 0x1f

    :goto_3
    goto/16 :goto_2

    :cond_9
    const/16 p2, 0x20

    goto :goto_3

    .line 943
    :cond_a
    const/16 v1, 0x8

    if-eq v14, v1, :cond_b

    const v1, -0x7ffffff8

    if-ne v14, v1, :cond_c

    :cond_b
    const/4 v1, 0x4

    if-ne v12, v1, :cond_c

    .line 944
    const/16 p2, 0x1c

    goto/16 :goto_2

    .line 945
    :cond_c
    const/16 v1, 0x8

    if-eq v14, v1, :cond_d

    const v1, -0x7ffffff8

    if-ne v14, v1, :cond_e

    :cond_d
    const/4 v1, 0x2

    if-ne v12, v1, :cond_e

    .line 946
    const/16 p2, 0x1a

    .line 947
    move/from16 v18, v2

    goto/16 :goto_2

    .line 949
    :cond_e
    new-instance v1, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not guess pixel format of image: depth="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v14}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", channels="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v1

    .line 962
    .end local v12    # "channels":I
    .end local v14    # "depth":I
    .restart local v16    # "start":J
    :cond_f
    new-instance v1, Lcom/googlecode/javacv/cpp/avcodec$AVPicture;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->tmp_picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-direct {v1, v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPicture;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    move/from16 v0, p2

    invoke-static {v1, v13, v0, v2, v3}, Lcom/googlecode/javacv/cpp/avcodec;->avpicture_fill(Lcom/googlecode/javacv/cpp/avcodec$AVPicture;Lcom/googlecode/javacpp/BytePointer;III)I

    .line 963
    new-instance v1, Lcom/googlecode/javacv/cpp/avcodec$AVPicture;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-direct {v1, v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPicture;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture_buf:Lcom/googlecode/javacpp/BytePointer;

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v5}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->pix_fmt()I

    move-result v5

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v6}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width()I

    move-result v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v7}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height()I

    move-result v7

    invoke-static {v1, v4, v5, v6, v7}, Lcom/googlecode/javacv/cpp/avcodec;->avpicture_fill(Lcom/googlecode/javacv/cpp/avcodec$AVPicture;Lcom/googlecode/javacpp/BytePointer;III)I

    .line 964
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->tmp_picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    const/4 v4, 0x0

    move/from16 v0, v18

    invoke-virtual {v1, v4, v0}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->linesize(II)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 965
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->img_convert_ctx:Lcom/googlecode/javacv/cpp/swscale$SwsContext;

    new-instance v5, Lcom/googlecode/javacpp/PointerPointer;

    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->tmp_picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-direct {v5, v1}, Lcom/googlecode/javacpp/PointerPointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->tmp_picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->linesize()Lcom/googlecode/javacpp/IntPointer;

    move-result-object v6

    const/4 v7, 0x0

    new-instance v9, Lcom/googlecode/javacpp/PointerPointer;

    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-direct {v9, v1}, Lcom/googlecode/javacpp/PointerPointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->linesize()Lcom/googlecode/javacpp/IntPointer;

    move-result-object v10

    move v8, v3

    invoke-static/range {v4 .. v10}, Lcom/googlecode/javacv/cpp/swscale;->sws_scale(Lcom/googlecode/javacv/cpp/swscale$SwsContext;Lcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;IILcom/googlecode/javacpp/PointerPointer;Lcom/googlecode/javacpp/IntPointer;)I

    .line 967
    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoScaleTime:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long v6, v6, v16

    add-long/2addr v4, v6

    move-object/from16 v0, p0

    iput-wide v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoScaleTime:J

    goto/16 :goto_0

    .line 969
    :cond_10
    new-instance v1, Lcom/googlecode/javacv/cpp/avcodec$AVPicture;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-direct {v1, v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPicture;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    move/from16 v0, p2

    invoke-static {v1, v13, v0, v2, v3}, Lcom/googlecode/javacv/cpp/avcodec;->avpicture_fill(Lcom/googlecode/javacv/cpp/avcodec$AVPicture;Lcom/googlecode/javacpp/BytePointer;III)I

    .line 970
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    const/4 v4, 0x0

    move/from16 v0, v18

    invoke-virtual {v1, v4, v0}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->linesize(II)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    goto/16 :goto_0

    .line 978
    .end local v2    # "width":I
    .end local v3    # "height":I
    .end local v13    # "data":Lcom/googlecode/javacpp/BytePointer;
    .end local v16    # "start":J
    .end local v18    # "step":I
    :cond_11
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-static {v1}, Lcom/googlecode/javacv/cpp/avcodec;->av_init_packet(Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)V

    .line 979
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->flags()I

    move-result v4

    or-int/lit8 v4, v4, 0x1

    invoke-virtual {v1, v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->flags(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 980
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->index()I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->stream_index(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 981
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    new-instance v4, Lcom/googlecode/javacpp/BytePointer;

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-direct {v4, v5}, Lcom/googlecode/javacpp/BytePointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    invoke-virtual {v1, v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->data(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 982
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    const-class v4, Lcom/googlecode/javacv/cpp/avcodec$AVPicture;

    invoke-static {v4}, Lcom/googlecode/javacpp/Loader;->sizeof(Ljava/lang/Class;)I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->size(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 1012
    :goto_4
    if-nez p3, :cond_12

    .line 1013
    invoke-direct/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->writeVideoFrame()I

    .line 1015
    :cond_12
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->key_frame()I

    move-result v1

    if-eqz v1, :cond_1a

    const/4 v1, 0x1

    goto/16 :goto_1

    .line 986
    :cond_13
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-static {v1}, Lcom/googlecode/javacv/cpp/avcodec;->av_init_packet(Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)V

    .line 987
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf:Lcom/googlecode/javacpp/BytePointer;

    invoke-virtual {v1, v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->data(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 988
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf_size:I

    invoke-virtual {v1, v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->size(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 989
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->global_quality()I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->quality(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 990
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v16

    .line 991
    .restart local v16    # "start":J
    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    if-nez p1, :cond_14

    const/4 v1, 0x0

    :goto_5
    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->got_video_packet:[I

    invoke-static {v4, v5, v1, v6}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_encode_video2(Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;Lcom/googlecode/javacv/cpp/avutil$AVFrame;[I)I

    move-result v15

    .local v15, "ret":I
    if-gez v15, :cond_15

    .line 992
    new-instance v1, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "avcodec_encode_video2() error "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ": Could not encode video packet."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v1

    .line 991
    .end local v15    # "ret":I
    :cond_14
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    goto :goto_5

    .line 994
    .restart local v15    # "ret":I
    :cond_15
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->pts()J

    move-result-wide v4

    const-wide/16 v6, 0x1

    add-long/2addr v4, v6

    invoke-virtual {v1, v4, v5}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->pts(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 997
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->got_video_packet:[I

    const/4 v4, 0x0

    aget v1, v1, v4

    if-eqz v1, :cond_19

    .line 998
    if-nez p3, :cond_18

    .line 999
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts()J

    move-result-wide v4

    sget-wide v6, Lcom/googlecode/javacv/cpp/avutil;->AV_NOPTS_VALUE:J

    cmp-long v1, v4, v6

    if-eqz v1, :cond_16

    .line 1000
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts()J

    move-result-wide v4

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v6}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    invoke-virtual {v7}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v7

    invoke-static {v4, v5, v6, v7}, Lcom/googlecode/javacv/cpp/avutil;->av_rescale_q(JLcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts(J)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 1002
    :cond_16
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->dts()J

    move-result-wide v4

    sget-wide v6, Lcom/googlecode/javacv/cpp/avutil;->AV_NOPTS_VALUE:J

    cmp-long v1, v4, v6

    if-eqz v1, :cond_17

    .line 1003
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->dts()J

    move-result-wide v4

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v6}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    invoke-virtual {v7}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v7

    invoke-static {v4, v5, v6, v7}, Lcom/googlecode/javacv/cpp/avutil;->av_rescale_q(JLcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->dts(J)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 1005
    :cond_17
    move-object/from16 v0, p0

    iget-object v1, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->index()I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->stream_index(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 1010
    :cond_18
    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoEncodeTime:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long v6, v6, v16

    add-long/2addr v4, v6

    move-object/from16 v0, p0

    iput-wide v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoEncodeTime:J

    goto/16 :goto_4

    .line 1008
    :cond_19
    const/4 v1, 0x0

    goto/16 :goto_1

    .line 1015
    .end local v15    # "ret":I
    .end local v16    # "start":J
    :cond_1a
    const/4 v1, 0x0

    goto/16 :goto_1
.end method

.method public varargs record([Ljava/nio/Buffer;)Z
    .locals 26
    .param p1, "samples"    # [Ljava/nio/Buffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    .line 1035
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    if-nez v2, :cond_0

    .line 1036
    new-instance v2, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v3, "No audio output stream (Is audioChannels > 0 and has start() been called?)"

    invoke-direct {v2, v3}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1038
    :cond_0
    const/4 v2, 0x1

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->hasData:Z

    .line 1041
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v24

    .line 1043
    .local v24, "start":J
    const/4 v2, 0x0

    aget-object v2, p1, v2

    invoke-virtual {v2}, Ljava/nio/Buffer;->limit()I

    move-result v2

    const/4 v3, 0x0

    aget-object v3, p1, v3

    invoke-virtual {v3}, Ljava/nio/Buffer;->position()I

    move-result v3

    sub-int v19, v2, v3

    .line 1045
    .local v19, "inputSize":I
    move-object/from16 v0, p1

    array-length v2, v0

    const/4 v3, 0x1

    if-le v2, v3, :cond_1

    const/16 v16, 0x1

    .line 1047
    .local v16, "inputChannels":I
    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->sample_fmt()I

    move-result v5

    .line 1048
    .local v5, "outputFormat":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    array-length v2, v2

    const/4 v3, 0x1

    if-le v2, v3, :cond_2

    const/16 v20, 0x1

    .line 1049
    .local v20, "outputChannels":I
    :goto_1
    invoke-static {v5}, Lcom/googlecode/javacv/cpp/avutil;->av_get_bytes_per_sample(I)I

    move-result v22

    .line 1050
    .local v22, "outputDepth":I
    const/4 v2, 0x0

    aget-object v2, p1, v2

    instance-of v2, v2, Ljava/nio/ByteBuffer;

    if-eqz v2, :cond_5

    .line 1051
    move-object/from16 v0, p1

    array-length v2, v0

    const/4 v3, 0x1

    if-le v2, v3, :cond_3

    const/4 v9, 0x5

    .line 1052
    .local v9, "inputFormat":I
    :goto_2
    const/16 v18, 0x1

    .line 1053
    .local v18, "inputDepth":I
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_3
    move-object/from16 v0, p1

    array-length v2, v0

    if-ge v15, v2, :cond_12

    .line 1054
    aget-object v13, p1, v15

    check-cast v13, Ljava/nio/ByteBuffer;

    .line 1055
    .local v13, "b":Ljava/nio/ByteBuffer;
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    instance-of v2, v2, Lcom/googlecode/javacpp/BytePointer;

    if-eqz v2, :cond_4

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    invoke-virtual {v2}, Lcom/googlecode/javacpp/Pointer;->capacity()I

    move-result v2

    move/from16 v0, v19

    if-lt v2, v0, :cond_4

    invoke-virtual {v13}, Ljava/nio/ByteBuffer;->hasArray()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1056
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    check-cast v2, Lcom/googlecode/javacpp/BytePointer;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/googlecode/javacpp/BytePointer;->position(I)Lcom/googlecode/javacpp/BytePointer;

    move-result-object v2

    invoke-virtual {v13}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v3

    invoke-virtual {v13}, Ljava/nio/ByteBuffer;->position()I

    move-result v4

    move/from16 v0, v19

    invoke-virtual {v2, v3, v4, v0}, Lcom/googlecode/javacpp/BytePointer;->put([BII)Lcom/googlecode/javacpp/BytePointer;

    .line 1053
    :goto_4
    add-int/lit8 v15, v15, 0x1

    goto :goto_3

    .line 1045
    .end local v5    # "outputFormat":I
    .end local v9    # "inputFormat":I
    .end local v13    # "b":Ljava/nio/ByteBuffer;
    .end local v15    # "i":I
    .end local v16    # "inputChannels":I
    .end local v18    # "inputDepth":I
    .end local v20    # "outputChannels":I
    .end local v22    # "outputDepth":I
    :cond_1
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioChannels:I

    move/from16 v16, v0

    goto :goto_0

    .line 1048
    .restart local v5    # "outputFormat":I
    .restart local v16    # "inputChannels":I
    :cond_2
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioChannels:I

    move/from16 v20, v0

    goto :goto_1

    .line 1051
    .restart local v20    # "outputChannels":I
    .restart local v22    # "outputDepth":I
    :cond_3
    const/4 v9, 0x0

    goto :goto_2

    .line 1058
    .restart local v9    # "inputFormat":I
    .restart local v13    # "b":Ljava/nio/ByteBuffer;
    .restart local v15    # "i":I
    .restart local v18    # "inputDepth":I
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    new-instance v3, Lcom/googlecode/javacpp/BytePointer;

    invoke-direct {v3, v13}, Lcom/googlecode/javacpp/BytePointer;-><init>(Ljava/nio/ByteBuffer;)V

    aput-object v3, v2, v15

    goto :goto_4

    .line 1061
    .end local v9    # "inputFormat":I
    .end local v13    # "b":Ljava/nio/ByteBuffer;
    .end local v15    # "i":I
    .end local v18    # "inputDepth":I
    :cond_5
    const/4 v2, 0x0

    aget-object v2, p1, v2

    instance-of v2, v2, Ljava/nio/ShortBuffer;

    if-eqz v2, :cond_8

    .line 1062
    move-object/from16 v0, p1

    array-length v2, v0

    const/4 v3, 0x1

    if-le v2, v3, :cond_6

    const/4 v9, 0x6

    .line 1063
    .restart local v9    # "inputFormat":I
    :goto_5
    const/16 v18, 0x2

    .line 1064
    .restart local v18    # "inputDepth":I
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_6
    move-object/from16 v0, p1

    array-length v2, v0

    if-ge v15, v2, :cond_12

    .line 1065
    aget-object v13, p1, v15

    check-cast v13, Ljava/nio/ShortBuffer;

    .line 1066
    .local v13, "b":Ljava/nio/ShortBuffer;
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    instance-of v2, v2, Lcom/googlecode/javacpp/ShortPointer;

    if-eqz v2, :cond_7

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    invoke-virtual {v2}, Lcom/googlecode/javacpp/Pointer;->capacity()I

    move-result v2

    move/from16 v0, v19

    if-lt v2, v0, :cond_7

    invoke-virtual {v13}, Ljava/nio/ShortBuffer;->hasArray()Z

    move-result v2

    if-eqz v2, :cond_7

    .line 1067
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    check-cast v2, Lcom/googlecode/javacpp/ShortPointer;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/googlecode/javacpp/ShortPointer;->position(I)Lcom/googlecode/javacpp/ShortPointer;

    move-result-object v2

    invoke-virtual {v13}, Ljava/nio/ShortBuffer;->array()[S

    move-result-object v3

    aget-object v4, p1, v15

    invoke-virtual {v4}, Ljava/nio/Buffer;->position()I

    move-result v4

    move/from16 v0, v19

    invoke-virtual {v2, v3, v4, v0}, Lcom/googlecode/javacpp/ShortPointer;->put([SII)Lcom/googlecode/javacpp/ShortPointer;

    .line 1064
    :goto_7
    add-int/lit8 v15, v15, 0x1

    goto :goto_6

    .line 1062
    .end local v9    # "inputFormat":I
    .end local v13    # "b":Ljava/nio/ShortBuffer;
    .end local v15    # "i":I
    .end local v18    # "inputDepth":I
    :cond_6
    const/4 v9, 0x1

    goto :goto_5

    .line 1069
    .restart local v9    # "inputFormat":I
    .restart local v13    # "b":Ljava/nio/ShortBuffer;
    .restart local v15    # "i":I
    .restart local v18    # "inputDepth":I
    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    new-instance v3, Lcom/googlecode/javacpp/ShortPointer;

    invoke-direct {v3, v13}, Lcom/googlecode/javacpp/ShortPointer;-><init>(Ljava/nio/ShortBuffer;)V

    aput-object v3, v2, v15

    goto :goto_7

    .line 1072
    .end local v9    # "inputFormat":I
    .end local v13    # "b":Ljava/nio/ShortBuffer;
    .end local v15    # "i":I
    .end local v18    # "inputDepth":I
    :cond_8
    const/4 v2, 0x0

    aget-object v2, p1, v2

    instance-of v2, v2, Ljava/nio/IntBuffer;

    if-eqz v2, :cond_b

    .line 1073
    move-object/from16 v0, p1

    array-length v2, v0

    const/4 v3, 0x1

    if-le v2, v3, :cond_9

    const/4 v9, 0x7

    .line 1074
    .restart local v9    # "inputFormat":I
    :goto_8
    const/16 v18, 0x4

    .line 1075
    .restart local v18    # "inputDepth":I
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_9
    move-object/from16 v0, p1

    array-length v2, v0

    if-ge v15, v2, :cond_12

    .line 1076
    aget-object v13, p1, v15

    check-cast v13, Ljava/nio/IntBuffer;

    .line 1077
    .local v13, "b":Ljava/nio/IntBuffer;
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    instance-of v2, v2, Lcom/googlecode/javacpp/IntPointer;

    if-eqz v2, :cond_a

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    invoke-virtual {v2}, Lcom/googlecode/javacpp/Pointer;->capacity()I

    move-result v2

    move/from16 v0, v19

    if-lt v2, v0, :cond_a

    invoke-virtual {v13}, Ljava/nio/IntBuffer;->hasArray()Z

    move-result v2

    if-eqz v2, :cond_a

    .line 1078
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    check-cast v2, Lcom/googlecode/javacpp/IntPointer;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/googlecode/javacpp/IntPointer;->position(I)Lcom/googlecode/javacpp/IntPointer;

    move-result-object v2

    invoke-virtual {v13}, Ljava/nio/IntBuffer;->array()[I

    move-result-object v3

    aget-object v4, p1, v15

    invoke-virtual {v4}, Ljava/nio/Buffer;->position()I

    move-result v4

    move/from16 v0, v19

    invoke-virtual {v2, v3, v4, v0}, Lcom/googlecode/javacpp/IntPointer;->put([III)Lcom/googlecode/javacpp/IntPointer;

    .line 1075
    :goto_a
    add-int/lit8 v15, v15, 0x1

    goto :goto_9

    .line 1073
    .end local v9    # "inputFormat":I
    .end local v13    # "b":Ljava/nio/IntBuffer;
    .end local v15    # "i":I
    .end local v18    # "inputDepth":I
    :cond_9
    const/4 v9, 0x2

    goto :goto_8

    .line 1080
    .restart local v9    # "inputFormat":I
    .restart local v13    # "b":Ljava/nio/IntBuffer;
    .restart local v15    # "i":I
    .restart local v18    # "inputDepth":I
    :cond_a
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    new-instance v3, Lcom/googlecode/javacpp/IntPointer;

    invoke-direct {v3, v13}, Lcom/googlecode/javacpp/IntPointer;-><init>(Ljava/nio/IntBuffer;)V

    aput-object v3, v2, v15

    goto :goto_a

    .line 1083
    .end local v9    # "inputFormat":I
    .end local v13    # "b":Ljava/nio/IntBuffer;
    .end local v15    # "i":I
    .end local v18    # "inputDepth":I
    :cond_b
    const/4 v2, 0x0

    aget-object v2, p1, v2

    instance-of v2, v2, Ljava/nio/FloatBuffer;

    if-eqz v2, :cond_e

    .line 1084
    move-object/from16 v0, p1

    array-length v2, v0

    const/4 v3, 0x1

    if-le v2, v3, :cond_c

    const/16 v9, 0x8

    .line 1085
    .restart local v9    # "inputFormat":I
    :goto_b
    const/16 v18, 0x4

    .line 1086
    .restart local v18    # "inputDepth":I
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_c
    move-object/from16 v0, p1

    array-length v2, v0

    if-ge v15, v2, :cond_12

    .line 1087
    aget-object v13, p1, v15

    check-cast v13, Ljava/nio/FloatBuffer;

    .line 1088
    .local v13, "b":Ljava/nio/FloatBuffer;
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    instance-of v2, v2, Lcom/googlecode/javacpp/FloatPointer;

    if-eqz v2, :cond_d

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    invoke-virtual {v2}, Lcom/googlecode/javacpp/Pointer;->capacity()I

    move-result v2

    move/from16 v0, v19

    if-lt v2, v0, :cond_d

    invoke-virtual {v13}, Ljava/nio/FloatBuffer;->hasArray()Z

    move-result v2

    if-eqz v2, :cond_d

    .line 1089
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    check-cast v2, Lcom/googlecode/javacpp/FloatPointer;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/googlecode/javacpp/FloatPointer;->position(I)Lcom/googlecode/javacpp/FloatPointer;

    move-result-object v2

    invoke-virtual {v13}, Ljava/nio/FloatBuffer;->array()[F

    move-result-object v3

    invoke-virtual {v13}, Ljava/nio/FloatBuffer;->position()I

    move-result v4

    move/from16 v0, v19

    invoke-virtual {v2, v3, v4, v0}, Lcom/googlecode/javacpp/FloatPointer;->put([FII)Lcom/googlecode/javacpp/FloatPointer;

    .line 1086
    :goto_d
    add-int/lit8 v15, v15, 0x1

    goto :goto_c

    .line 1084
    .end local v9    # "inputFormat":I
    .end local v13    # "b":Ljava/nio/FloatBuffer;
    .end local v15    # "i":I
    .end local v18    # "inputDepth":I
    :cond_c
    const/4 v9, 0x3

    goto :goto_b

    .line 1091
    .restart local v9    # "inputFormat":I
    .restart local v13    # "b":Ljava/nio/FloatBuffer;
    .restart local v15    # "i":I
    .restart local v18    # "inputDepth":I
    :cond_d
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    new-instance v3, Lcom/googlecode/javacpp/FloatPointer;

    invoke-direct {v3, v13}, Lcom/googlecode/javacpp/FloatPointer;-><init>(Ljava/nio/FloatBuffer;)V

    aput-object v3, v2, v15

    goto :goto_d

    .line 1094
    .end local v9    # "inputFormat":I
    .end local v13    # "b":Ljava/nio/FloatBuffer;
    .end local v15    # "i":I
    .end local v18    # "inputDepth":I
    :cond_e
    const/4 v2, 0x0

    aget-object v2, p1, v2

    instance-of v2, v2, Ljava/nio/DoubleBuffer;

    if-eqz v2, :cond_11

    .line 1095
    move-object/from16 v0, p1

    array-length v2, v0

    const/4 v3, 0x1

    if-le v2, v3, :cond_f

    const/16 v9, 0x9

    .line 1096
    .restart local v9    # "inputFormat":I
    :goto_e
    const/16 v18, 0x8

    .line 1097
    .restart local v18    # "inputDepth":I
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_f
    move-object/from16 v0, p1

    array-length v2, v0

    if-ge v15, v2, :cond_12

    .line 1098
    aget-object v13, p1, v15

    check-cast v13, Ljava/nio/DoubleBuffer;

    .line 1099
    .local v13, "b":Ljava/nio/DoubleBuffer;
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    instance-of v2, v2, Lcom/googlecode/javacpp/DoublePointer;

    if-eqz v2, :cond_10

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    invoke-virtual {v2}, Lcom/googlecode/javacpp/Pointer;->capacity()I

    move-result v2

    move/from16 v0, v19

    if-lt v2, v0, :cond_10

    invoke-virtual {v13}, Ljava/nio/DoubleBuffer;->hasArray()Z

    move-result v2

    if-eqz v2, :cond_10

    .line 1100
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    check-cast v2, Lcom/googlecode/javacpp/DoublePointer;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/googlecode/javacpp/DoublePointer;->position(I)Lcom/googlecode/javacpp/DoublePointer;

    move-result-object v2

    invoke-virtual {v13}, Ljava/nio/DoubleBuffer;->array()[D

    move-result-object v3

    invoke-virtual {v13}, Ljava/nio/DoubleBuffer;->position()I

    move-result v4

    move/from16 v0, v19

    invoke-virtual {v2, v3, v4, v0}, Lcom/googlecode/javacpp/DoublePointer;->put([DII)Lcom/googlecode/javacpp/DoublePointer;

    .line 1097
    :goto_10
    add-int/lit8 v15, v15, 0x1

    goto :goto_f

    .line 1095
    .end local v9    # "inputFormat":I
    .end local v13    # "b":Ljava/nio/DoubleBuffer;
    .end local v15    # "i":I
    .end local v18    # "inputDepth":I
    :cond_f
    const/4 v9, 0x4

    goto :goto_e

    .line 1102
    .restart local v9    # "inputFormat":I
    .restart local v13    # "b":Ljava/nio/DoubleBuffer;
    .restart local v15    # "i":I
    .restart local v18    # "inputDepth":I
    :cond_10
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    new-instance v3, Lcom/googlecode/javacpp/DoublePointer;

    invoke-direct {v3, v13}, Lcom/googlecode/javacpp/DoublePointer;-><init>(Ljava/nio/DoubleBuffer;)V

    aput-object v3, v2, v15

    goto :goto_10

    .line 1106
    .end local v9    # "inputFormat":I
    .end local v13    # "b":Ljava/nio/DoubleBuffer;
    .end local v15    # "i":I
    .end local v18    # "inputDepth":I
    :cond_11
    new-instance v2, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Audio samples Buffer has unsupported type: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1109
    .restart local v9    # "inputFormat":I
    .restart local v15    # "i":I
    .restart local v18    # "inputDepth":I
    :cond_12
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_convert_ctx:Lcom/googlecode/javacv/cpp/swresample$SwrContext;

    if-nez v2, :cond_14

    .line 1110
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v3}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->channel_layout()J

    move-result-wide v3

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v6}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->sample_rate()I

    move-result v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v7}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->channel_layout()J

    move-result-wide v7

    move-object/from16 v0, p0

    iget-object v10, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v10}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->sample_rate()I

    move-result v10

    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-static/range {v2 .. v12}, Lcom/googlecode/javacv/cpp/swresample;->swr_alloc_set_opts(Lcom/googlecode/javacv/cpp/swresample$SwrContext;JIIJIIILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacv/cpp/swresample$SwrContext;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_convert_ctx:Lcom/googlecode/javacv/cpp/swresample$SwrContext;

    .line 1113
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_convert_ctx:Lcom/googlecode/javacv/cpp/swresample$SwrContext;

    if-nez v2, :cond_13

    .line 1114
    new-instance v2, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v3, "swr_alloc_set_opts() error: Cannot allocate the conversion context."

    invoke-direct {v2, v3}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1115
    :cond_13
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_convert_ctx:Lcom/googlecode/javacv/cpp/swresample$SwrContext;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/swresample;->swr_init(Lcom/googlecode/javacv/cpp/swresample$SwrContext;)I

    move-result v23

    .local v23, "ret":I
    if-gez v23, :cond_14

    .line 1116
    new-instance v2, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "swr_init() error "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, v23

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": Cannot initialize the conversion context."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1120
    .end local v23    # "ret":I
    :cond_14
    const/4 v15, 0x0

    :goto_11
    move-object/from16 v0, p1

    array-length v2, v0

    if-ge v15, v2, :cond_16

    .line 1121
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v3, v3, v15

    invoke-virtual {v3}, Lcom/googlecode/javacpp/Pointer;->position()I

    move-result v3

    mul-int v3, v3, v18

    invoke-virtual {v2, v3}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v3, v3, v15

    invoke-virtual {v3}, Lcom/googlecode/javacpp/Pointer;->position()I

    move-result v3

    add-int v3, v3, v19

    mul-int v3, v3, v18

    invoke-virtual {v2, v3}, Lcom/googlecode/javacpp/Pointer;->limit(I)Lcom/googlecode/javacpp/Pointer;

    .line 1120
    add-int/lit8 v15, v15, 0x1

    goto :goto_11

    .line 1157
    .local v14, "count":I
    .local v17, "inputCount":I
    .local v21, "outputCount":I
    .restart local v23    # "ret":I
    :cond_15
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v3}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->global_quality()I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->quality(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 1158
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/SwVineFrameRecorder;->record(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)Z

    .line 1124
    .end local v14    # "count":I
    .end local v17    # "inputCount":I
    .end local v21    # "outputCount":I
    .end local v23    # "ret":I
    :cond_16
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    const/4 v3, 0x0

    aget-object v2, v2, v3

    invoke-virtual {v2}, Lcom/googlecode/javacpp/Pointer;->position()I

    move-result v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    const/4 v4, 0x0

    aget-object v3, v3, v4

    invoke-virtual {v3}, Lcom/googlecode/javacpp/Pointer;->limit()I

    move-result v3

    if-ge v2, v3, :cond_1e

    .line 1125
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    const/4 v3, 0x0

    aget-object v2, v2, v3

    invoke-virtual {v2}, Lcom/googlecode/javacpp/Pointer;->limit()I

    move-result v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    const/4 v4, 0x0

    aget-object v3, v3, v4

    invoke-virtual {v3}, Lcom/googlecode/javacpp/Pointer;->position()I

    move-result v3

    sub-int/2addr v2, v3

    mul-int v3, v16, v18

    div-int v17, v2, v3

    .line 1126
    .restart local v17    # "inputCount":I
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    const/4 v3, 0x0

    aget-object v2, v2, v3

    invoke-virtual {v2}, Lcom/googlecode/javacpp/BytePointer;->limit()I

    move-result v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    const/4 v4, 0x0

    aget-object v3, v3, v4

    invoke-virtual {v3}, Lcom/googlecode/javacpp/BytePointer;->position()I

    move-result v3

    sub-int/2addr v2, v3

    mul-int v3, v20, v22

    div-int v21, v2, v3

    .line 1127
    .restart local v21    # "outputCount":I
    move/from16 v0, v17

    move/from16 v1, v21

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v14

    .line 1128
    .restart local v14    # "count":I
    const/4 v15, 0x0

    :goto_12
    move-object/from16 v0, p1

    array-length v2, v0

    if-ge v15, v2, :cond_17

    .line 1129
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in_ptr:Lcom/googlecode/javacpp/PointerPointer;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v3, v3, v15

    invoke-virtual {v2, v15, v3}, Lcom/googlecode/javacpp/PointerPointer;->put(ILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/PointerPointer;

    .line 1128
    add-int/lit8 v15, v15, 0x1

    goto :goto_12

    .line 1131
    :cond_17
    const/4 v15, 0x0

    :goto_13
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    array-length v2, v2

    if-ge v15, v2, :cond_18

    .line 1132
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out_ptr:Lcom/googlecode/javacpp/PointerPointer;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    aget-object v3, v3, v15

    invoke-virtual {v2, v15, v3}, Lcom/googlecode/javacpp/PointerPointer;->put(ILcom/googlecode/javacpp/Pointer;)Lcom/googlecode/javacpp/PointerPointer;

    .line 1131
    add-int/lit8 v15, v15, 0x1

    goto :goto_13

    .line 1134
    :cond_18
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_convert_ctx:Lcom/googlecode/javacv/cpp/swresample$SwrContext;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out_ptr:Lcom/googlecode/javacpp/PointerPointer;

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in_ptr:Lcom/googlecode/javacpp/PointerPointer;

    invoke-static {v2, v3, v14, v4, v14}, Lcom/googlecode/javacv/cpp/swresample;->swr_convert(Lcom/googlecode/javacv/cpp/swresample$SwrContext;Lcom/googlecode/javacpp/PointerPointer;ILcom/googlecode/javacpp/PointerPointer;I)I

    move-result v23

    .restart local v23    # "ret":I
    if-gez v23, :cond_19

    .line 1135
    new-instance v2, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "swr_convert() error "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, v23

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": Cannot convert audio samples."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v2

    .line 1137
    :cond_19
    const/4 v15, 0x0

    :goto_14
    move-object/from16 v0, p1

    array-length v2, v0

    if-ge v15, v2, :cond_1a

    .line 1138
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v2, v2, v15

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    aget-object v3, v3, v15

    invoke-virtual {v3}, Lcom/googlecode/javacpp/Pointer;->position()I

    move-result v3

    mul-int v4, v23, v16

    mul-int v4, v4, v18

    add-int/2addr v3, v4

    invoke-virtual {v2, v3}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    .line 1137
    add-int/lit8 v15, v15, 0x1

    goto :goto_14

    .line 1140
    :cond_1a
    const/4 v15, 0x0

    :goto_15
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    array-length v2, v2

    if-ge v15, v2, :cond_1b

    .line 1141
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    aget-object v2, v2, v15

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    aget-object v3, v3, v15

    invoke-virtual {v3}, Lcom/googlecode/javacpp/BytePointer;->position()I

    move-result v3

    mul-int v4, v23, v20

    mul-int v4, v4, v22

    add-int/2addr v3, v4

    invoke-virtual {v2, v3}, Lcom/googlecode/javacpp/BytePointer;->position(I)Lcom/googlecode/javacpp/BytePointer;

    .line 1140
    add-int/lit8 v15, v15, 0x1

    goto :goto_15

    .line 1144
    :cond_1b
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    const/4 v3, 0x0

    aget-object v2, v2, v3

    invoke-virtual {v2}, Lcom/googlecode/javacpp/BytePointer;->position()I

    move-result v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    const/4 v4, 0x0

    aget-object v3, v3, v4

    invoke-virtual {v3}, Lcom/googlecode/javacpp/BytePointer;->limit()I

    move-result v3

    if-lt v2, v3, :cond_16

    .line 1145
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_input_frame_size:I

    invoke-virtual {v2, v3}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->nb_samples(I)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 1146
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->isVorbis:Z

    if-eqz v2, :cond_1c

    .line 1147
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-object/from16 v0, p0

    iget-wide v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_clock:J

    const-wide/16 v6, 0x3e8

    mul-long/2addr v3, v6

    move-object/from16 v0, p0

    iget v6, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleRate:I

    int-to-long v6, v6

    div-long/2addr v3, v6

    invoke-virtual {v2, v3, v4}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->pts(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 1149
    :cond_1c
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-eqz v2, :cond_1d

    .line 1150
    move-object/from16 v0, p0

    iget-wide v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_clock:J

    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_input_frame_size:I

    int-to-long v6, v4

    add-long/2addr v2, v6

    move-object/from16 v0, p0

    iput-wide v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_clock:J

    .line 1152
    :cond_1d
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->channels()I

    move-result v4

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    const/4 v6, 0x0

    aget-object v6, v2, v6

    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    const/4 v7, 0x0

    aget-object v2, v2, v7

    invoke-virtual {v2}, Lcom/googlecode/javacpp/BytePointer;->limit()I

    move-result v7

    const/4 v8, 0x0

    invoke-static/range {v3 .. v8}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_fill_audio_frame(Lcom/googlecode/javacv/cpp/avutil$AVFrame;IILcom/googlecode/javacpp/BytePointer;II)I

    .line 1153
    const/4 v15, 0x0

    :goto_16
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    array-length v2, v2

    if-ge v15, v2, :cond_15

    .line 1154
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    aget-object v3, v3, v15

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/googlecode/javacpp/BytePointer;->position(I)Lcom/googlecode/javacpp/BytePointer;

    move-result-object v3

    invoke-virtual {v2, v15, v3}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->data(ILcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 1155
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    aget-object v3, v3, v15

    invoke-virtual {v3}, Lcom/googlecode/javacpp/BytePointer;->limit()I

    move-result v3

    invoke-virtual {v2, v15, v3}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->linesize(II)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 1153
    add-int/lit8 v15, v15, 0x1

    goto :goto_16

    .line 1162
    .end local v14    # "count":I
    .end local v17    # "inputCount":I
    .end local v21    # "outputCount":I
    .end local v23    # "ret":I
    :cond_1e
    move-object/from16 v0, p0

    iget-wide v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioRecordTime:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long v6, v6, v24

    add-long/2addr v2, v6

    move-object/from16 v0, p0

    iput-wide v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioRecordTime:J

    .line 1164
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->key_frame()I

    move-result v2

    if-eqz v2, :cond_1f

    const/4 v2, 0x1

    :goto_17
    return v2

    :cond_1f
    const/4 v2, 0x0

    goto :goto_17
.end method

.method public release()V
    .locals 7

    .prologue
    const-wide/16 v5, 0x0

    .line 299
    sget-boolean v2, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v2, :cond_3

    iget-boolean v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->isReleased:Z

    if-nez v2, :cond_3

    .line 300
    iget-wide v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoScaleTime:J

    cmp-long v2, v2, v5

    if-lez v2, :cond_0

    .line 301
    const-string v2, "Video Scale: {}."

    iget-wide v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoScaleTime:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 303
    :cond_0
    iget-wide v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoEncodeTime:J

    cmp-long v2, v2, v5

    if-lez v2, :cond_1

    .line 304
    const-string v2, "Video Encode: {}."

    iget-wide v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoEncodeTime:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 306
    :cond_1
    iget-wide v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoWriteTime:J

    cmp-long v2, v2, v5

    if-lez v2, :cond_2

    .line 307
    const-string v2, "Video Write: {}."

    iget-wide v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoWriteTime:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 309
    :cond_2
    iget-wide v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioRecordTime:J

    cmp-long v2, v2, v5

    if-lez v2, :cond_3

    .line 310
    const-string v2, "Audio Record: {}."

    iget-wide v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioRecordTime:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 313
    :cond_3
    const/4 v2, 0x1

    iput-boolean v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->isReleased:Z

    .line 314
    sget-object v3, Lco/vine/android/recorder/SwVineFrameRecorder;->LOCK:[I

    monitor-enter v3

    .line 316
    :try_start_0
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    if-eqz v2, :cond_4

    .line 317
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_close(Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;)I

    .line 318
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 320
    :cond_4
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    if-eqz v2, :cond_5

    .line 321
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_close(Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;)I

    .line 322
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 324
    :cond_5
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture_buf:Lcom/googlecode/javacpp/BytePointer;

    if-eqz v2, :cond_6

    .line 325
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture_buf:Lcom/googlecode/javacpp/BytePointer;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avutil;->av_free(Lcom/googlecode/javacpp/Pointer;)V

    .line 326
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture_buf:Lcom/googlecode/javacpp/BytePointer;

    .line 328
    :cond_6
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-eqz v2, :cond_7

    .line 329
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_free_frame(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)V

    .line 330
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 332
    :cond_7
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->tmp_picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-eqz v2, :cond_8

    .line 333
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->tmp_picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_free_frame(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)V

    .line 334
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->tmp_picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 336
    :cond_8
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf:Lcom/googlecode/javacpp/BytePointer;

    if-eqz v2, :cond_9

    .line 337
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf:Lcom/googlecode/javacpp/BytePointer;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avutil;->av_free(Lcom/googlecode/javacpp/Pointer;)V

    .line 338
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf:Lcom/googlecode/javacpp/BytePointer;

    .line 340
    :cond_9
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-eqz v2, :cond_a

    .line 341
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_free_frame(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)V

    .line 342
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 344
    :cond_a
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    if-eqz v2, :cond_c

    .line 345
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    array-length v2, v2

    if-ge v0, v2, :cond_b

    .line 346
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    aget-object v2, v2, v0

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/googlecode/javacpp/BytePointer;->position(I)Lcom/googlecode/javacpp/BytePointer;

    move-result-object v2

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avutil;->av_free(Lcom/googlecode/javacpp/Pointer;)V

    .line 345
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 348
    :cond_b
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    .line 350
    .end local v0    # "i":I
    :cond_c
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf:Lcom/googlecode/javacpp/BytePointer;

    if-eqz v2, :cond_d

    .line 351
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf:Lcom/googlecode/javacpp/BytePointer;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avutil;->av_free(Lcom/googlecode/javacpp/Pointer;)V

    .line 352
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf:Lcom/googlecode/javacpp/BytePointer;

    .line 354
    :cond_d
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    .line 355
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    .line 357
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    if-eqz v2, :cond_f

    .line 359
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;->nb_streams()I

    move-result v1

    .line 360
    .local v1, "nb_streams":I
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_1
    if-ge v0, v1, :cond_e

    .line 361
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    invoke-virtual {v2, v0}, Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;->streams(I)Lcom/googlecode/javacv/cpp/avformat$AVStream;

    move-result-object v2

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->codec()Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-result-object v2

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avutil;->av_free(Lcom/googlecode/javacpp/Pointer;)V

    .line 362
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    invoke-virtual {v2, v0}, Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;->streams(I)Lcom/googlecode/javacv/cpp/avformat$AVStream;

    move-result-object v2

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avutil;->av_free(Lcom/googlecode/javacpp/Pointer;)V

    .line 360
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 366
    :cond_e
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/avutil;->av_free(Lcom/googlecode/javacpp/Pointer;)V

    .line 367
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    .line 370
    .end local v0    # "i":I
    .end local v1    # "nb_streams":I
    :cond_f
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->img_convert_ctx:Lcom/googlecode/javacv/cpp/swscale$SwsContext;

    if-eqz v2, :cond_10

    .line 371
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->img_convert_ctx:Lcom/googlecode/javacv/cpp/swscale$SwsContext;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/swscale;->sws_freeContext(Lcom/googlecode/javacv/cpp/swscale$SwsContext;)V

    .line 372
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->img_convert_ctx:Lcom/googlecode/javacv/cpp/swscale$SwsContext;

    .line 375
    :cond_10
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_convert_ctx:Lcom/googlecode/javacv/cpp/swresample$SwrContext;

    if-eqz v2, :cond_11

    .line 376
    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_convert_ctx:Lcom/googlecode/javacv/cpp/swresample$SwrContext;

    invoke-static {v2}, Lcom/googlecode/javacv/cpp/swresample;->swr_free(Lcom/googlecode/javacv/cpp/swresample$SwrContext;)V

    .line 377
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_convert_ctx:Lcom/googlecode/javacv/cpp/swresample$SwrContext;

    .line 379
    :cond_11
    monitor-exit v3

    .line 380
    return-void

    .line 379
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public setAudioCodec(I)V
    .locals 0
    .param p1, "audioCodec"    # I

    .prologue
    .line 1237
    iput p1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioCodec:I

    .line 1238
    return-void
.end method

.method public setAudioCodecName(Ljava/lang/String;)V
    .locals 0
    .param p1, "audioCodecName"    # Ljava/lang/String;

    .prologue
    .line 1031
    iput-object p1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioCodecName:Ljava/lang/String;

    .line 1032
    return-void
.end method

.method public setFormat(Ljava/lang/String;)V
    .locals 0
    .param p1, "format"    # Ljava/lang/String;

    .prologue
    .line 1217
    iput-object p1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->format:Ljava/lang/String;

    .line 1218
    return-void
.end method

.method public setFrameNumber(I)V
    .locals 3
    .param p1, "frameNumber"    # I

    .prologue
    .line 420
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-nez v0, :cond_0

    .line 421
    iput p1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->frameNumber:I

    .line 425
    :goto_0
    return-void

    .line 423
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    int-to-long v1, p1

    invoke-virtual {v0, v1, v2}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->pts(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    goto :goto_0
.end method

.method public setFrameRate(D)V
    .locals 0
    .param p1, "frameRate"    # D

    .prologue
    .line 1229
    iput-wide p1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->frameRate:D

    .line 1230
    return-void
.end method

.method public setSampleFormat(I)V
    .locals 0
    .param p1, "sampleFormat"    # I

    .prologue
    .line 1233
    iput p1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleFormat:I

    .line 1234
    return-void
.end method

.method public setSampleRate(I)V
    .locals 0
    .param p1, "sampleRate"    # I

    .prologue
    .line 1241
    iput p1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleRate:I

    .line 1242
    return-void
.end method

.method public setTimestamp(J)V
    .locals 4
    .param p1, "timestamp"    # J

    .prologue
    .line 442
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-eqz v0, :cond_0

    .line 443
    long-to-double v0, p1

    invoke-virtual {p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->getFrameRate()D

    move-result-wide v2

    mul-double/2addr v0, v2

    const-wide v2, 0x412e848000000000L    # 1000000.0

    div-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    long-to-int v0, v0

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/SwVineFrameRecorder;->setFrameNumber(I)V

    .line 445
    :cond_0
    return-void
.end method

.method public setTimestampAndGetFrameNumber(J)I
    .locals 5
    .param p1, "timestamp"    # J

    .prologue
    .line 436
    long-to-double v1, p1

    invoke-virtual {p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->getFrameRate()D

    move-result-wide v3

    mul-double/2addr v1, v3

    const-wide v3, 0x412e848000000000L    # 1000000.0

    div-double/2addr v1, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->round(D)J

    move-result-wide v1

    long-to-int v0, v1

    .line 437
    .local v0, "fn":I
    invoke-virtual {p0, v0}, Lco/vine/android/recorder/SwVineFrameRecorder;->setFrameNumber(I)V

    .line 438
    return v0
.end method

.method public setVideoCodec(I)V
    .locals 0
    .param p1, "videoCodec"    # I

    .prologue
    .line 1221
    iput p1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoCodec:I

    .line 1222
    return-void
.end method

.method public setVideoCodecName(Ljava/lang/String;)V
    .locals 0
    .param p1, "videoCodecName"    # Ljava/lang/String;

    .prologue
    .line 1023
    iput-object p1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoCodecName:Ljava/lang/String;

    .line 1024
    return-void
.end method

.method public start()V
    .locals 23
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    .line 463
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 464
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->tmp_picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 465
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->picture_buf:Lcom/googlecode/javacpp/BytePointer;

    .line 466
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 467
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf:Lcom/googlecode/javacpp/BytePointer;

    .line 468
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf:Lcom/googlecode/javacpp/BytePointer;

    .line 469
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    .line 470
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 471
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 472
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    .line 473
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    .line 474
    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [I

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->got_video_packet:[I

    .line 475
    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [I

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->got_audio_packet:[I

    .line 476
    const-wide/16 v18, 0x0

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/recorder/SwVineFrameRecorder;->videoEncodeTime:J

    .line 477
    const-wide/16 v18, 0x0

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/recorder/SwVineFrameRecorder;->videoWriteTime:J

    .line 478
    const-wide/16 v18, 0x0

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/recorder/SwVineFrameRecorder;->videoScaleTime:J

    .line 479
    const-wide/16 v18, 0x0

    move-wide/from16 v0, v18

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/recorder/SwVineFrameRecorder;->audioRecordTime:J

    .line 482
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->format:Ljava/lang/String;

    move-object/from16 v18, v0

    if-eqz v18, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->format:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->length()I

    move-result v18

    if-nez v18, :cond_2

    :cond_0
    const/4 v5, 0x0

    .line 483
    .local v5, "format_name":Ljava/lang/String;
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-static {v5, v0, v1}, Lcom/googlecode/javacv/cpp/avformat;->av_guess_format(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    if-nez v18, :cond_3

    .line 484
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    move-object/from16 v18, v0

    const-string v19, "://"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v14

    .line 485
    .local v14, "proto":I
    if-lez v14, :cond_1

    .line 486
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v0, v1, v14}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    .line 488
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-static {v5, v0, v1}, Lcom/googlecode/javacv/cpp/avformat;->av_guess_format(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    if-nez v18, :cond_3

    .line 489
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "av_guess_format() error: Could not guess output format for \""

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, "\" and "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->format:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " format."

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 482
    .end local v5    # "format_name":Ljava/lang/String;
    .end local v14    # "proto":I
    :cond_2
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->format:Ljava/lang/String;

    goto/16 :goto_0

    .line 492
    .restart local v5    # "format_name":Ljava/lang/String;
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->name()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacpp/BytePointer;->getString()Ljava/lang/String;

    move-result-object v5

    .line 495
    invoke-static {}, Lcom/googlecode/javacv/cpp/avformat;->avformat_alloc_context()Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    if-nez v18, :cond_4

    .line 496
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v19, "avformat_alloc_context() error: Could not allocate format context"

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 499
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;->oformat(Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;)Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    .line 500
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;->filename()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacpp/BytePointer;->putString(Ljava/lang/String;)Lcom/googlecode/javacpp/BytePointer;

    .line 505
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageWidth:I

    move/from16 v18, v0

    if-lez v18, :cond_11

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageHeight:I

    move/from16 v18, v0

    if-lez v18, :cond_11

    .line 506
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoCodec:I

    move/from16 v18, v0

    if-eqz v18, :cond_6

    .line 507
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoCodec:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->video_codec(I)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    .line 519
    :cond_5
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoCodecName:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_find_encoder_by_name(Ljava/lang/String;)Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-result-object v10

    move-object/from16 v0, p0

    iput-object v10, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    .line 520
    .local v10, "namedCodec":Lcom/googlecode/javacv/cpp/avcodec$AVCodec;
    if-nez v10, :cond_a

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->video_codec()I

    move-result v18

    invoke-static/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_find_encoder(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->video_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    if-nez v18, :cond_a

    .line 522
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 523
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v19, "avcodec_find_encoder() error: Video codec not found."

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 508
    .end local v10    # "namedCodec":Lcom/googlecode/javacv/cpp/avcodec$AVCodec;
    :cond_6
    const-string v18, "flv"

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_7

    .line 509
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    const/16 v19, 0x16

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->video_codec(I)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    goto :goto_1

    .line 510
    :cond_7
    const-string v18, "mp4"

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_8

    .line 511
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    const/16 v19, 0xd

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->video_codec(I)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    goto :goto_1

    .line 512
    :cond_8
    const-string v18, "3gp"

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_9

    .line 513
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    const/16 v19, 0x5

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->video_codec(I)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    goto :goto_1

    .line 514
    :cond_9
    const-string v18, "avi"

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_5

    .line 515
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    const/16 v19, 0x1a

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->video_codec(I)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    goto/16 :goto_1

    .line 525
    .restart local v10    # "namedCodec":Lcom/googlecode/javacv/cpp/avcodec$AVCodec;
    :cond_a
    if-eqz v10, :cond_b

    .line 526
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodec;->id()I

    move-result v19

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->video_codec(I)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    .line 529
    :cond_b
    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->frameRate:D

    move-wide/from16 v18, v0

    const v20, 0xf4628

    invoke-static/range {v18 .. v20}, Lcom/googlecode/javacv/cpp/avutil;->av_d2q(DI)Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v6

    .line 530
    .local v6, "frame_rate":Lcom/googlecode/javacv/cpp/avutil$AVRational;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodec;->supported_framerates()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v17

    .line 531
    .local v17, "supported_framerates":Lcom/googlecode/javacv/cpp/avutil$AVRational;
    if-eqz v17, :cond_c

    .line 532
    move-object/from16 v0, v17

    invoke-static {v6, v0}, Lcom/googlecode/javacv/cpp/avutil;->av_find_nearest_q_idx(Lcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)I

    move-result v9

    .line 533
    .local v9, "idx":I
    move-object/from16 v0, v17

    invoke-virtual {v0, v9}, Lcom/googlecode/javacv/cpp/avutil$AVRational;->position(I)Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v6

    .line 537
    .end local v9    # "idx":I
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-object/from16 v19, v0

    invoke-static/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat;->avformat_new_stream(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacv/cpp/avcodec$AVCodec;)Lcom/googlecode/javacv/cpp/avformat$AVStream;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    if-nez v18, :cond_d

    .line 538
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 539
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v19, "avformat_new_stream() error: Could not allocate video stream."

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 541
    :cond_d
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->codec()Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 542
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->video_codec()I

    move-result v19

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 543
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_type(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 546
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoBitrate:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->bit_rate(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 548
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageWidth:I

    move/from16 v19, v0

    add-int/lit8 v19, v19, 0xf

    div-int/lit8 v19, v19, 0x10

    mul-int/lit8 v19, v19, 0x10

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 549
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageHeight:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 554
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-static {v6}, Lcom/googlecode/javacv/cpp/avutil;->av_inv_q(Lcom/googlecode/javacv/cpp/avutil$AVRational;)Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->time_base(Lcom/googlecode/javacv/cpp/avutil$AVRational;)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 555
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0xc

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->gop_size(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 556
    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoQuality:D

    move-wide/from16 v18, v0

    const-wide/16 v20, 0x0

    cmpl-double v18, v18, v20

    if-ltz v18, :cond_e

    .line 557
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->flags()I

    move-result v19

    or-int/lit8 v19, v19, 0x2

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->flags(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 558
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const-wide v19, 0x405d800000000000L    # 118.0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoQuality:D

    move-wide/from16 v21, v0

    mul-double v19, v19, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/Math;->round(D)J

    move-result-wide v19

    move-wide/from16 v0, v19

    long-to-int v0, v0

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->global_quality(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 561
    :cond_e
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->pixelFormat:I

    move/from16 v18, v0

    const/16 v19, -0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_13

    .line 562
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->pixelFormat:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->pix_fmt(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 570
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id()I

    move-result v18

    const/16 v19, 0x2

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_16

    .line 572
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x2

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->max_b_frames(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 598
    :cond_f
    :goto_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->flags()I

    move-result v18

    and-int/lit8 v18, v18, 0x40

    if-eqz v18, :cond_10

    .line 599
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->flags()I

    move-result v19

    const/high16 v20, 0x400000

    or-int v19, v19, v20

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->flags(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 602
    :cond_10
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodec;->capabilities()I

    move-result v18

    move/from16 v0, v18

    and-int/lit16 v0, v0, 0x200

    move/from16 v18, v0

    if-eqz v18, :cond_11

    .line 603
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, -0x2

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->strict_std_compliance(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 610
    .end local v6    # "frame_rate":Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .end local v10    # "namedCodec":Lcom/googlecode/javacv/cpp/avcodec$AVCodec;
    .end local v17    # "supported_framerates":Lcom/googlecode/javacv/cpp/avutil$AVRational;
    :cond_11
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioChannels:I

    move/from16 v18, v0

    if-lez v18, :cond_28

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioBitrate:I

    move/from16 v18, v0

    if-lez v18, :cond_28

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleRate:I

    move/from16 v18, v0

    if-lez v18, :cond_28

    .line 611
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioCodec:I

    move/from16 v18, v0

    if-eqz v18, :cond_1d

    .line 612
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioCodec:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->audio_codec(I)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    .line 620
    :cond_12
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioCodecName:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_find_encoder_by_name(Ljava/lang/String;)Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    if-nez v18, :cond_20

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->audio_codec()I

    move-result v18

    invoke-static/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_find_encoder(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    if-nez v18, :cond_20

    .line 622
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 623
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v19, "avcodec_find_encoder() error: Audio codec not found."

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 563
    .restart local v6    # "frame_rate":Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .restart local v10    # "namedCodec":Lcom/googlecode/javacv/cpp/avcodec$AVCodec;
    .restart local v17    # "supported_framerates":Lcom/googlecode/javacv/cpp/avutil$AVRational;
    :cond_13
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id()I

    move-result v18

    const/16 v19, 0xe

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_14

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id()I

    move-result v18

    const/16 v19, 0x3e

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_14

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id()I

    move-result v18

    const/16 v19, 0x1a

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_14

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id()I

    move-result v18

    const/16 v19, 0x22

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_15

    .line 565
    :cond_14
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    sget v19, Lcom/googlecode/javacv/cpp/avutil;->AV_PIX_FMT_RGB32:I

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->pix_fmt(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_2

    .line 567
    :cond_15
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->pix_fmt(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_2

    .line 573
    :cond_16
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id()I

    move-result v18

    const/16 v19, 0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_17

    .line 577
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x2

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->mb_decision(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_3

    .line 578
    :cond_17
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id()I

    move-result v18

    const/16 v19, 0x5

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_1c

    .line 580
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageWidth:I

    move/from16 v18, v0

    const/16 v19, 0x80

    move/from16 v0, v18

    move/from16 v1, v19

    if-gt v0, v1, :cond_18

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageHeight:I

    move/from16 v18, v0

    const/16 v19, 0x60

    move/from16 v0, v18

    move/from16 v1, v19

    if-gt v0, v1, :cond_18

    .line 581
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x80

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-result-object v18

    const/16 v19, 0x60

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_3

    .line 582
    :cond_18
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageWidth:I

    move/from16 v18, v0

    const/16 v19, 0xb0

    move/from16 v0, v18

    move/from16 v1, v19

    if-gt v0, v1, :cond_19

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageHeight:I

    move/from16 v18, v0

    const/16 v19, 0x90

    move/from16 v0, v18

    move/from16 v1, v19

    if-gt v0, v1, :cond_19

    .line 583
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0xb0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-result-object v18

    const/16 v19, 0x90

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_3

    .line 584
    :cond_19
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageWidth:I

    move/from16 v18, v0

    const/16 v19, 0x160

    move/from16 v0, v18

    move/from16 v1, v19

    if-gt v0, v1, :cond_1a

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageHeight:I

    move/from16 v18, v0

    const/16 v19, 0x120

    move/from16 v0, v18

    move/from16 v1, v19

    if-gt v0, v1, :cond_1a

    .line 585
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x160

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-result-object v18

    const/16 v19, 0x120

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_3

    .line 586
    :cond_1a
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageWidth:I

    move/from16 v18, v0

    const/16 v19, 0x2c0

    move/from16 v0, v18

    move/from16 v1, v19

    if-gt v0, v1, :cond_1b

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->imageHeight:I

    move/from16 v18, v0

    const/16 v19, 0x240

    move/from16 v0, v18

    move/from16 v1, v19

    if-gt v0, v1, :cond_1b

    .line 587
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x2c0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-result-object v18

    const/16 v19, 0x240

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_3

    .line 589
    :cond_1b
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x580

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-result-object v18

    const/16 v19, 0x480

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_3

    .line 591
    :cond_1c
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id()I

    move-result v18

    const/16 v19, 0x1c

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_f

    .line 594
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x242

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->profile(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_3

    .line 613
    .end local v6    # "frame_rate":Lcom/googlecode/javacv/cpp/avutil$AVRational;
    .end local v10    # "namedCodec":Lcom/googlecode/javacv/cpp/avcodec$AVCodec;
    .end local v17    # "supported_framerates":Lcom/googlecode/javacv/cpp/avutil$AVRational;
    :cond_1d
    const-string v18, "flv"

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-nez v18, :cond_1e

    const-string v18, "mp4"

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-nez v18, :cond_1e

    const-string v18, "3gp"

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_1f

    .line 614
    :cond_1e
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    const v19, 0x15002

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->audio_codec(I)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    goto/16 :goto_4

    .line 615
    :cond_1f
    const-string v18, "avi"

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_12

    .line 616
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    const/high16 v19, 0x10000

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->audio_codec(I)Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    goto/16 :goto_4

    .line 626
    :cond_20
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-object/from16 v19, v0

    invoke-static/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avformat;->avformat_new_stream(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacv/cpp/avcodec$AVCodec;)Lcom/googlecode/javacv/cpp/avformat$AVStream;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    if-nez v18, :cond_21

    .line 627
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 628
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v19, "avformat_new_stream() error: Could not allocate audio stream."

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 631
    :cond_21
    const-string v18, "libvorbis"

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioCodecName:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->isVorbis:Z

    .line 633
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->codec()Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 634
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->audio_codec()I

    move-result v19

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 635
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x1

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_type(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 638
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioBitrate:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->bit_rate(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 639
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleRate:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->sample_rate(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 640
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioChannels:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->channels(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 641
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioChannels:I

    move/from16 v19, v0

    invoke-static/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avutil;->av_get_default_channel_layout(I)J

    move-result-wide v19

    invoke-virtual/range {v18 .. v20}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->channel_layout(J)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 642
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleFormat:I

    move/from16 v18, v0

    const/16 v19, -0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_22

    .line 643
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleFormat:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->sample_fmt(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 650
    :goto_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v18

    const/16 v19, 0x1

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avutil$AVRational;->num(I)Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v18

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleRate:I

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avutil$AVRational;->den(I)Lcom/googlecode/javacv/cpp/avutil$AVRational;

    .line 651
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->sample_fmt()I

    move-result v18

    packed-switch v18, :pswitch_data_0

    .line 673
    sget-boolean v18, Lco/vine/android/recorder/SwVineFrameRecorder;->$assertionsDisabled:Z

    if-nez v18, :cond_25

    new-instance v18, Ljava/lang/AssertionError;

    invoke-direct/range {v18 .. v18}, Ljava/lang/AssertionError;-><init>()V

    throw v18

    .line 644
    :cond_22
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->isVorbis:Z

    move/from16 v18, v0

    if-nez v18, :cond_23

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id()I

    move-result v18

    const v19, 0x15002

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_24

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodec;->capabilities()I

    move-result v18

    move/from16 v0, v18

    and-int/lit16 v0, v0, 0x200

    move/from16 v18, v0

    if-eqz v18, :cond_24

    .line 646
    :cond_23
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x8

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->sample_fmt(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto :goto_5

    .line 648
    :cond_24
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x1

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->sample_fmt(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto :goto_5

    .line 654
    :pswitch_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x8

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->bits_per_raw_sample(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 675
    :cond_25
    :goto_6
    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioQuality:D

    move-wide/from16 v18, v0

    const-wide/16 v20, 0x0

    cmpl-double v18, v18, v20

    if-ltz v18, :cond_26

    .line 676
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->flags()I

    move-result v19

    or-int/lit8 v19, v19, 0x2

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->flags(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 677
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const-wide v19, 0x405d800000000000L    # 118.0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioQuality:D

    move-wide/from16 v21, v0

    mul-double v19, v19, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/Math;->round(D)J

    move-result-wide v19

    move-wide/from16 v0, v19

    long-to-int v0, v0

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->global_quality(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 681
    :cond_26
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->flags()I

    move-result v18

    and-int/lit8 v18, v18, 0x40

    if-eqz v18, :cond_27

    .line 682
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->flags()I

    move-result v19

    const/high16 v20, 0x400000

    or-int v19, v19, v20

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->flags(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 685
    :cond_27
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodec;->capabilities()I

    move-result v18

    move/from16 v0, v18

    and-int/lit16 v0, v0, 0x200

    move/from16 v18, v0

    if-eqz v18, :cond_28

    .line 686
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, -0x2

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->strict_std_compliance(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    .line 690
    :cond_28
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    move-object/from16 v20, v0

    const/16 v21, 0x1

    invoke-static/range {v18 .. v21}, Lcom/googlecode/javacv/cpp/avformat;->av_dump_format(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;ILjava/lang/String;I)V

    .line 694
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    move-object/from16 v18, v0

    if-eqz v18, :cond_2f

    .line 695
    new-instance v11, Lcom/googlecode/javacv/cpp/avutil$AVDictionary;

    const/16 v18, 0x0

    move-object/from16 v0, v18

    invoke-direct {v11, v0}, Lcom/googlecode/javacv/cpp/avutil$AVDictionary;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    .line 696
    .local v11, "options":Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoQuality:D

    move-wide/from16 v18, v0

    const-wide/16 v20, 0x0

    cmpl-double v18, v18, v20

    if-ltz v18, :cond_29

    .line 697
    const-string v18, "crf"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, ""

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoQuality:D

    move-wide/from16 v20, v0

    invoke-virtual/range {v19 .. v21}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    const/16 v20, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-static {v11, v0, v1, v2}, Lcom/googlecode/javacv/cpp/avutil;->av_dict_set(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Ljava/lang/String;Ljava/lang/String;I)I

    .line 699
    :cond_29
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->videoOptions:Ljava/util/HashMap;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v18

    invoke-interface/range {v18 .. v18}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_7
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_2a

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 700
    .local v4, "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/String;

    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/String;

    const/16 v20, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-static {v11, v0, v1, v2}, Lcom/googlecode/javacv/cpp/avutil;->av_dict_set(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Ljava/lang/String;Ljava/lang/String;I)I

    goto :goto_7

    .line 658
    .end local v4    # "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v11    # "options":Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
    :pswitch_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x10

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->bits_per_raw_sample(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_6

    .line 662
    :pswitch_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x20

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->bits_per_raw_sample(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_6

    .line 666
    :pswitch_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x20

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->bits_per_raw_sample(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_6

    .line 670
    :pswitch_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    const/16 v19, 0x40

    invoke-virtual/range {v18 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->bits_per_raw_sample(I)Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    goto/16 :goto_6

    .line 702
    .restart local v8    # "i$":Ljava/util/Iterator;
    .restart local v11    # "options":Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
    :cond_2a
    sget-object v19, Lco/vine/android/recorder/SwVineFrameRecorder;->LOCK:[I

    monitor-enter v19

    .line 704
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-object/from16 v20, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-static {v0, v1, v11}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_open2(Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;Lcom/googlecode/javacv/cpp/avcodec$AVCodec;Lcom/googlecode/javacv/cpp/avutil$AVDictionary;)I

    move-result v15

    .local v15, "ret":I
    if-gez v15, :cond_2b

    .line 705
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 706
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const-string v21, "avcodec_open2() error "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, ": Could not open video codec."

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 708
    .end local v15    # "ret":I
    :catchall_0
    move-exception v18

    monitor-exit v19
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v18

    .restart local v15    # "ret":I
    :cond_2b
    :try_start_1
    monitor-exit v19
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 709
    invoke-static {v11}, Lcom/googlecode/javacv/cpp/avutil;->av_dict_free(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;)V

    .line 711
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf:Lcom/googlecode/javacpp/BytePointer;

    .line 712
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->flags()I

    move-result v18

    and-int/lit8 v18, v18, 0x20

    if-nez v18, :cond_2c

    .line 719
    const/high16 v18, 0x40000

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width()I

    move-result v19

    mul-int/lit8 v19, v19, 0x8

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height()I

    move-result v20

    mul-int v19, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/Math;->max(II)I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf_size:I

    .line 720
    new-instance v18, Lcom/googlecode/javacpp/BytePointer;

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf_size:I

    move/from16 v19, v0

    move/from16 v0, v19

    int-to-long v0, v0

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Lcom/googlecode/javacv/cpp/avutil;->av_malloc(J)Lcom/googlecode/javacpp/Pointer;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Lcom/googlecode/javacpp/BytePointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf:Lcom/googlecode/javacpp/BytePointer;

    .line 724
    :cond_2c
    invoke-static {}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_alloc_frame()Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-nez v18, :cond_2d

    .line 725
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 726
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v19, "avcodec_alloc_frame() error: Could not allocate picture."

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 728
    :cond_2d
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-object/from16 v18, v0

    const-wide/16 v19, 0x0

    invoke-virtual/range {v18 .. v20}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->pts(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 730
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->pix_fmt()I

    move-result v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->width()I

    move-result v19

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->height()I

    move-result v20

    invoke-static/range {v18 .. v20}, Lcom/googlecode/javacv/cpp/avcodec;->avpicture_get_size(III)I

    move-result v16

    .line 731
    .local v16, "size":I
    new-instance v18, Lcom/googlecode/javacpp/BytePointer;

    move/from16 v0, v16

    int-to-long v0, v0

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Lcom/googlecode/javacv/cpp/avutil;->av_malloc(J)Lcom/googlecode/javacpp/Pointer;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Lcom/googlecode/javacpp/BytePointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->picture_buf:Lcom/googlecode/javacpp/BytePointer;

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacpp/BytePointer;->isNull()Z

    move-result v18

    if-eqz v18, :cond_2e

    .line 732
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 733
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v19, "av_malloc() error: Could not allocate picture buffer."

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 738
    :cond_2e
    invoke-static {}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_alloc_frame()Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->tmp_picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-nez v18, :cond_2f

    .line 739
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 740
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v19, "avcodec_alloc_frame() error: Could not allocate temporary picture."

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 744
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v11    # "options":Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
    .end local v15    # "ret":I
    .end local v16    # "size":I
    :cond_2f
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    move-object/from16 v18, v0

    if-eqz v18, :cond_36

    .line 745
    new-instance v11, Lcom/googlecode/javacv/cpp/avutil$AVDictionary;

    const/16 v18, 0x0

    move-object/from16 v0, v18

    invoke-direct {v11, v0}, Lcom/googlecode/javacv/cpp/avutil$AVDictionary;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    .line 746
    .restart local v11    # "options":Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioQuality:D

    move-wide/from16 v18, v0

    const-wide/16 v20, 0x0

    cmpl-double v18, v18, v20

    if-ltz v18, :cond_30

    .line 747
    const-string v18, "crf"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, ""

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioQuality:D

    move-wide/from16 v20, v0

    invoke-virtual/range {v19 .. v21}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    const/16 v20, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-static {v11, v0, v1, v2}, Lcom/googlecode/javacv/cpp/avutil;->av_dict_set(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Ljava/lang/String;Ljava/lang/String;I)I

    .line 749
    :cond_30
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audioOptions:Ljava/util/HashMap;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v18

    invoke-interface/range {v18 .. v18}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .restart local v8    # "i$":Ljava/util/Iterator;
    :goto_8
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_31

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 750
    .restart local v4    # "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Ljava/lang/String;

    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Ljava/lang/String;

    const/16 v20, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move/from16 v2, v20

    invoke-static {v11, v0, v1, v2}, Lcom/googlecode/javacv/cpp/avutil;->av_dict_set(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;Ljava/lang/String;Ljava/lang/String;I)I

    goto :goto_8

    .line 753
    .end local v4    # "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_31
    sget-object v19, Lco/vine/android/recorder/SwVineFrameRecorder;->LOCK:[I

    monitor-enter v19

    .line 755
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_codec:Lcom/googlecode/javacv/cpp/avcodec$AVCodec;

    move-object/from16 v20, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-static {v0, v1, v11}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_open2(Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;Lcom/googlecode/javacv/cpp/avcodec$AVCodec;Lcom/googlecode/javacv/cpp/avutil$AVDictionary;)I

    move-result v15

    .restart local v15    # "ret":I
    if-gez v15, :cond_32

    .line 756
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 757
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const-string v21, "avcodec_open2() error "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, ": Could not open audio codec."

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 759
    .end local v15    # "ret":I
    :catchall_1
    move-exception v18

    monitor-exit v19
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v18

    .restart local v15    # "ret":I
    :cond_32
    :try_start_3
    monitor-exit v19
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 760
    invoke-static {v11}, Lcom/googlecode/javacv/cpp/avutil;->av_dict_free(Lcom/googlecode/javacv/cpp/avutil$AVDictionary;)V

    .line 762
    const/high16 v18, 0x40000

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf_size:I

    .line 763
    new-instance v18, Lcom/googlecode/javacpp/BytePointer;

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf_size:I

    move/from16 v19, v0

    move/from16 v0, v19

    int-to-long v0, v0

    move-wide/from16 v19, v0

    invoke-static/range {v19 .. v20}, Lcom/googlecode/javacv/cpp/avutil;->av_malloc(J)Lcom/googlecode/javacpp/Pointer;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Lcom/googlecode/javacpp/BytePointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf:Lcom/googlecode/javacpp/BytePointer;

    .line 767
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->frame_size()I

    move-result v18

    const/16 v19, 0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-gt v0, v1, :cond_33

    .line 768
    const/16 v18, 0x4000

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf_size:I

    .line 769
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_outbuf_size:I

    move/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->channels()I

    move-result v19

    div-int v18, v18, v19

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_input_frame_size:I

    .line 770
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->codec_id()I

    move-result v18

    packed-switch v18, :pswitch_data_1

    .line 784
    :goto_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->sample_fmt()I

    move-result v18

    invoke-static/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avutil;->av_sample_fmt_is_planar(I)I

    move-result v18

    if-eqz v18, :cond_34

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->channels()I

    move-result v13

    .line 785
    .local v13, "planes":I
    :goto_a
    const/16 v18, 0x0

    check-cast v18, Lcom/googlecode/javacpp/IntPointer;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->channels()I

    move-result v19

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_input_frame_size:I

    move/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->sample_fmt()I

    move-result v21

    const/16 v22, 0x1

    invoke-static/range {v18 .. v22}, Lcom/googlecode/javacv/cpp/avutil;->av_samples_get_buffer_size(Lcom/googlecode/javacpp/IntPointer;IIII)I

    move-result v18

    div-int v3, v18, v13

    .line 787
    .local v3, "data_size":I
    new-array v0, v13, [Lcom/googlecode/javacpp/BytePointer;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    .line 788
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v18, v0

    move/from16 v0, v18

    if-ge v7, v0, :cond_35

    .line 789
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out:[Lcom/googlecode/javacpp/BytePointer;

    move-object/from16 v18, v0

    new-instance v19, Lcom/googlecode/javacpp/BytePointer;

    int-to-long v0, v3

    move-wide/from16 v20, v0

    invoke-static/range {v20 .. v21}, Lcom/googlecode/javacv/cpp/avutil;->av_malloc(J)Lcom/googlecode/javacpp/Pointer;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Lcom/googlecode/javacpp/BytePointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    move-object/from16 v0, v19

    invoke-virtual {v0, v3}, Lcom/googlecode/javacpp/BytePointer;->capacity(I)Lcom/googlecode/javacpp/BytePointer;

    move-result-object v19

    aput-object v19, v18, v7

    .line 788
    add-int/lit8 v7, v7, 0x1

    goto :goto_b

    .line 775
    .end local v3    # "data_size":I
    .end local v7    # "i":I
    .end local v13    # "planes":I
    :pswitch_5
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_input_frame_size:I

    move/from16 v18, v0

    shr-int/lit8 v18, v18, 0x1

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_input_frame_size:I

    goto/16 :goto_9

    .line 781
    :cond_33
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->frame_size()I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_input_frame_size:I

    goto/16 :goto_9

    .line 784
    :cond_34
    const/4 v13, 0x1

    goto :goto_a

    .line 791
    .restart local v3    # "data_size":I
    .restart local v7    # "i":I
    .restart local v13    # "planes":I
    :cond_35
    const/16 v18, 0x8

    move/from16 v0, v18

    new-array v0, v0, [Lcom/googlecode/javacpp/Pointer;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in:[Lcom/googlecode/javacpp/Pointer;

    .line 792
    new-instance v18, Lcom/googlecode/javacpp/PointerPointer;

    const/16 v19, 0x8

    invoke-direct/range {v18 .. v19}, Lcom/googlecode/javacpp/PointerPointer;-><init>(I)V

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_in_ptr:Lcom/googlecode/javacpp/PointerPointer;

    .line 793
    new-instance v18, Lcom/googlecode/javacpp/PointerPointer;

    const/16 v19, 0x8

    invoke-direct/range {v18 .. v19}, Lcom/googlecode/javacpp/PointerPointer;-><init>(I)V

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->samples_out_ptr:Lcom/googlecode/javacpp/PointerPointer;

    .line 796
    invoke-static {}, Lcom/googlecode/javacv/cpp/avcodec;->avcodec_alloc_frame()Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwVineFrameRecorder;->frame:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    if-nez v18, :cond_36

    .line 797
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 798
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    const-string v19, "avcodec_alloc_frame() error: Could not allocate audio frame."

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 802
    .end local v3    # "data_size":I
    .end local v7    # "i":I
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v11    # "options":Lcom/googlecode/javacv/cpp/avutil$AVDictionary;
    .end local v13    # "planes":I
    .end local v15    # "ret":I
    :cond_36
    new-instance v18, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-direct/range {v18 .. v19}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static/range {v18 .. v18}, Lco/vine/android/util/SystemUtil;->quietlyEnsureParentExists(Ljava/io/File;)V

    .line 805
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->flags()I

    move-result v18

    and-int/lit8 v18, v18, 0x1

    if-nez v18, :cond_38

    .line 806
    new-instance v12, Lcom/googlecode/javacv/cpp/avformat$AVIOContext;

    const/16 v18, 0x0

    move-object/from16 v0, v18

    invoke-direct {v12, v0}, Lcom/googlecode/javacv/cpp/avformat$AVIOContext;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    .line 807
    .local v12, "pb":Lcom/googlecode/javacv/cpp/avformat$AVIOContext;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    move-object/from16 v18, v0

    const/16 v19, 0x2

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-static {v12, v0, v1}, Lcom/googlecode/javacv/cpp/avformat;->avio_open(Lcom/googlecode/javacv/cpp/avformat$AVIOContext;Ljava/lang/String;I)I

    move-result v15

    .restart local v15    # "ret":I
    if-gez v15, :cond_37

    .line 808
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 809
    new-instance v18, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "BAD avio_open error() error "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, ": Could not open \'"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->filename:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Lco/vine/android/recorder/SwVineFrameRecorder$Exception;-><init>(Ljava/lang/String;)V

    throw v18

    .line 811
    :cond_37
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v0, v12}, Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;->pb(Lcom/googlecode/javacv/cpp/avformat$AVIOContext;)Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    .line 815
    .end local v12    # "pb":Lcom/googlecode/javacv/cpp/avformat$AVIOContext;
    .end local v15    # "ret":I
    :cond_38
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    move-object/from16 v19, v0

    const/16 v18, 0x0

    check-cast v18, Lcom/googlecode/javacpp/PointerPointer;

    move-object/from16 v0, v19

    move-object/from16 v1, v18

    invoke-static {v0, v1}, Lcom/googlecode/javacv/cpp/avformat;->avformat_write_header(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacpp/PointerPointer;)I

    .line 816
    return-void

    .line 651
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch

    .line 770
    :pswitch_data_1
    .packed-switch 0x10000
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
    .end packed-switch
.end method

.method public stop()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 829
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    if-eqz v0, :cond_3

    .line 832
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    if-eqz v0, :cond_1

    const/4 v0, -0x1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v0, v2}, Lco/vine/android/recorder/SwVineFrameRecorder;->record(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;IZ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 833
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    if-eqz v0, :cond_2

    move-object v0, v1

    check-cast v0, Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/SwVineFrameRecorder;->record(Lcom/googlecode/javacv/cpp/avutil$AVFrame;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 835
    :cond_2
    iget-boolean v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->interleaved:Z

    if-eqz v0, :cond_4

    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    if-eqz v0, :cond_4

    .line 836
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    invoke-static {v0, v1}, Lcom/googlecode/javacv/cpp/avformat;->av_interleaved_write_frame(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)I

    .line 841
    :goto_0
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    iget-wide v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->audio_clock:J

    const-wide/16 v3, 0x3e8

    mul-long/2addr v1, v3

    iget v3, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->sampleRate:I

    int-to-long v3, v3

    div-long/2addr v1, v3

    invoke-virtual {v0, v1, v2}, Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;->duration(J)Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    .line 844
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    invoke-static {v0}, Lcom/googlecode/javacv/cpp/avformat;->av_write_trailer(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;)I

    .line 846
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->flags()I

    move-result v0

    and-int/lit8 v0, v0, 0x1

    if-nez v0, :cond_3

    .line 848
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;->pb()Lcom/googlecode/javacv/cpp/avformat$AVIOContext;

    move-result-object v0

    invoke-static {v0}, Lcom/googlecode/javacv/cpp/avformat;->avio_close(Lcom/googlecode/javacv/cpp/avformat$AVIOContext;)I

    .line 851
    :cond_3
    invoke-virtual {p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 852
    return-void

    .line 838
    :cond_4
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    invoke-static {v0, v1}, Lcom/googlecode/javacv/cpp/avformat;->av_write_frame(Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)I

    goto :goto_0
.end method

.method public stopEncoding()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    .line 819
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    if-eqz v0, :cond_0

    .line 820
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oformat:Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/avformat$AVOutputFormat;->flags()I

    move-result v0

    and-int/lit8 v0, v0, 0x1

    if-nez v0, :cond_0

    .line 822
    iget-object v0, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->oc:Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;

    invoke-virtual {v0}, Lcom/googlecode/javacv/cpp/avformat$AVFormatContext;->pb()Lcom/googlecode/javacv/cpp/avformat$AVIOContext;

    move-result-object v0

    invoke-static {v0}, Lcom/googlecode/javacv/cpp/avformat;->avio_close(Lcom/googlecode/javacv/cpp/avformat$AVIOContext;)I

    .line 825
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 826
    return-void
.end method

.method public writeEncodedImage([BIIZ)V
    .locals 6
    .param p1, "data"    # [B
    .param p2, "start"    # I
    .param p3, "length"    # I
    .param p4, "keyFrame"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    .line 875
    const/4 v1, 0x1

    iput-boolean v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->hasData:Z

    .line 876
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-static {v1}, Lcom/googlecode/javacv/cpp/avcodec;->av_init_packet(Lcom/googlecode/javacv/cpp/avcodec$AVPacket;)V

    .line 877
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_outbuf:Lcom/googlecode/javacpp/BytePointer;

    invoke-virtual {v1, v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->data(Lcom/googlecode/javacpp/BytePointer;)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 878
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->data()Lcom/googlecode/javacpp/BytePointer;

    move-result-object v0

    .line 879
    .local v0, "pData":Lcom/googlecode/javacpp/BytePointer;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/googlecode/javacpp/BytePointer;->position(I)Lcom/googlecode/javacpp/BytePointer;

    .line 880
    invoke-virtual {v0, p1, p2, p3}, Lcom/googlecode/javacpp/BytePointer;->put([BII)Lcom/googlecode/javacpp/BytePointer;

    .line 881
    invoke-virtual {v0, p3}, Lcom/googlecode/javacpp/BytePointer;->limit(I)Lcom/googlecode/javacpp/BytePointer;

    .line 882
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v1, p3}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->size(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 883
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->pts()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts(J)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 884
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->dts(J)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 885
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->picture:Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->pts()J

    move-result-wide v2

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Lcom/googlecode/javacv/cpp/avutil$AVFrame;->pts(J)Lcom/googlecode/javacv/cpp/avutil$AVFrame;

    .line 886
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts()J

    move-result-wide v1

    sget-wide v3, Lcom/googlecode/javacv/cpp/avutil;->AV_NOPTS_VALUE:J

    cmp-long v1, v1, v3

    if-eqz v1, :cond_0

    .line 887
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts()J

    move-result-wide v2

    iget-object v4, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    invoke-virtual {v5}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v5

    invoke-static {v2, v3, v4, v5}, Lcom/googlecode/javacv/cpp/avutil;->av_rescale_q(JLcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->pts(J)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 889
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v1}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->dts()J

    move-result-wide v1

    sget-wide v3, Lcom/googlecode/javacv/cpp/avutil;->AV_NOPTS_VALUE:J

    cmp-long v1, v1, v3

    if-eqz v1, :cond_1

    .line 890
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->dts()J

    move-result-wide v2

    iget-object v4, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_c:Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;

    invoke-virtual {v4}, Lcom/googlecode/javacv/cpp/avcodec$AVCodecContext;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    invoke-virtual {v5}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->time_base()Lcom/googlecode/javacv/cpp/avutil$AVRational;

    move-result-object v5

    invoke-static {v2, v3, v4, v5}, Lcom/googlecode/javacv/cpp/avutil;->av_rescale_q(JLcom/googlecode/javacv/cpp/avutil$AVRational;Lcom/googlecode/javacv/cpp/avutil$AVRational;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->dts(J)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 892
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_st:Lcom/googlecode/javacv/cpp/avformat$AVStream;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avformat$AVStream;->index()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->stream_index(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 893
    if-eqz p4, :cond_2

    .line 894
    iget-object v1, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    iget-object v2, p0, Lco/vine/android/recorder/SwVineFrameRecorder;->video_pkt:Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    invoke-virtual {v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->flags()I

    move-result v2

    or-int/lit8 v2, v2, 0x1

    invoke-virtual {v1, v2}, Lcom/googlecode/javacv/cpp/avcodec$AVPacket;->flags(I)Lcom/googlecode/javacv/cpp/avcodec$AVPacket;

    .line 896
    :cond_2
    invoke-direct {p0}, Lco/vine/android/recorder/SwVineFrameRecorder;->writeVideoFrame()I

    .line 897
    return-void
.end method
