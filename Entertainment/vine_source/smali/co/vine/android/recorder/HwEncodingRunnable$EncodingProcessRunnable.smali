.class Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;
.super Ljava/lang/Object;
.source "HwEncodingRunnable.java"

# interfaces
.implements Ljava/lang/Runnable;
.implements Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/HwEncodingRunnable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "EncodingProcessRunnable"
.end annotation


# instance fields
.field private final LOCK:[I

.field private mBufferedVideoData:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lco/vine/android/recorder/VideoData;",
            ">;"
        }
    .end annotation
.end field

.field private mByteBuffer:Ljava/nio/ByteBuffer;

.field private mErrorCount:I

.field private mLast:Lco/vine/android/recorder/VideoData;

.field private mLastSegment:Lco/vine/android/recorder/RecordSegment;

.field private mReceived:I

.field public mRun:Z

.field private notFirst:Z

.field final synthetic this$0:Lco/vine/android/recorder/HwEncodingRunnable;

.field private totalSizeToWait:I


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/HwEncodingRunnable;Ljava/nio/ByteBuffer;)V
    .locals 1
    .param p2, "buffer"    # Ljava/nio/ByteBuffer;

    .prologue
    .line 97
    iput-object p1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    const/4 v0, 0x0

    new-array v0, v0, [I

    iput-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->LOCK:[I

    .line 90
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    .line 98
    iput-object p2, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mByteBuffer:Ljava/nio/ByteBuffer;

    .line 99
    invoke-direct {p0}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->makeNewEncoder()V

    .line 100
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mBufferedVideoData:Ljava/util/LinkedList;

    .line 101
    return-void
.end method

.method private doVideoFrameEncoded(Ljava/nio/ByteBuffer;)Z
    .locals 4
    .param p1, "byteBuffer"    # Ljava/nio/ByteBuffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    .line 157
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mBufferedVideoData:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/VideoData;

    .line 158
    .local v0, "data":Lco/vine/android/recorder/VideoData;
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/HwVineFrameRecorder;
    invoke-static {v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$500(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/HwVineFrameRecorder;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferMax:[B
    invoke-static {v2}, Lco/vine/android/recorder/HwEncodingRunnable;->access$300(Lco/vine/android/recorder/HwEncodingRunnable;)[B

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferPosition:I
    invoke-static {v3}, Lco/vine/android/recorder/HwEncodingRunnable;->access$400(Lco/vine/android/recorder/HwEncodingRunnable;)I

    move-result v3

    invoke-virtual {v1, p1, v2, v3}, Lco/vine/android/recorder/HwVineFrameRecorder;->putEncodedData(Ljava/nio/ByteBuffer;[BI)I

    move-result v1

    iput v1, v0, Lco/vine/android/recorder/VideoData;->size:I

    .line 159
    invoke-direct {p0, v0}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->putVideoFrame(Lco/vine/android/recorder/VideoData;)Z

    move-result v1

    return v1
.end method

.method private doVideoFrameRaw([BZZ)Z
    .locals 5
    .param p1, "image"    # [B
    .param p2, "newSegment"    # Z
    .param p3, "lastFrame"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 163
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/HwVineFrameRecorder;
    invoke-static {v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$500(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/HwVineFrameRecorder;

    move-result-object v1

    if-nez v1, :cond_0

    .line 164
    invoke-direct {p0}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->makeNewEncoder()V

    .line 172
    :goto_0
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # operator++ for: Lco/vine/android/recorder/HwEncodingRunnable;->mTotalProcessed:I
    invoke-static {v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$608(Lco/vine/android/recorder/HwEncodingRunnable;)I

    .line 174
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-ge v1, v2, :cond_2

    .line 175
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/HwVineFrameRecorder;
    invoke-static {v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$500(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/HwVineFrameRecorder;

    move-result-object v1

    invoke-static {p1}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferMax:[B
    invoke-static {v3}, Lco/vine/android/recorder/HwEncodingRunnable;->access$300(Lco/vine/android/recorder/HwEncodingRunnable;)[B

    move-result-object v3

    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferPosition:I
    invoke-static {v4}, Lco/vine/android/recorder/HwEncodingRunnable;->access$400(Lco/vine/android/recorder/HwEncodingRunnable;)I

    move-result v4

    invoke-virtual {v1, v2, v3, v4, p3}, Lco/vine/android/recorder/HwVineFrameRecorder;->encode(Ljava/nio/ByteBuffer;[BIZ)I

    .line 176
    const/4 v1, 0x0

    .line 181
    :goto_1
    return v1

    .line 166
    :cond_0
    if-eqz p2, :cond_1

    iget-boolean v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->notFirst:Z

    if-eqz v1, :cond_1

    .line 167
    invoke-direct {p0, v2}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->stopEncoder(I)V

    .line 168
    invoke-direct {p0}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->makeNewEncoder()V

    .line 170
    :cond_1
    iput-boolean v2, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->notFirst:Z

    goto :goto_0

    .line 178
    :cond_2
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mBufferedVideoData:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/VideoData;

    .line 179
    .local v0, "data":Lco/vine/android/recorder/VideoData;
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/HwVineFrameRecorder;
    invoke-static {v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$500(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/HwVineFrameRecorder;

    move-result-object v1

    invoke-static {p1}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferMax:[B
    invoke-static {v3}, Lco/vine/android/recorder/HwEncodingRunnable;->access$300(Lco/vine/android/recorder/HwEncodingRunnable;)[B

    move-result-object v3

    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferPosition:I
    invoke-static {v4}, Lco/vine/android/recorder/HwEncodingRunnable;->access$400(Lco/vine/android/recorder/HwEncodingRunnable;)I

    move-result v4

    invoke-virtual {v1, v2, v3, v4, p3}, Lco/vine/android/recorder/HwVineFrameRecorder;->encode(Ljava/nio/ByteBuffer;[BIZ)I

    move-result v1

    iput v1, v0, Lco/vine/android/recorder/VideoData;->size:I

    .line 180
    const-string v1, "onFrameAvailable Write video frame size {}. Total processed {}, last Frame? {}."

    iget v2, v0, Lco/vine/android/recorder/VideoData;->size:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mTotalProcessed:I
    invoke-static {v3}, Lco/vine/android/recorder/HwEncodingRunnable;->access$600(Lco/vine/android/recorder/HwEncodingRunnable;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v1, v2, v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 181
    invoke-direct {p0, v0}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->putVideoFrame(Lco/vine/android/recorder/VideoData;)Z

    move-result v1

    goto :goto_1
.end method

.method private makeNewEncoder()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 199
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # setter for: Lco/vine/android/recorder/HwEncodingRunnable;->mTotalProcessed:I
    invoke-static {v0, v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$602(Lco/vine/android/recorder/HwEncodingRunnable;I)I

    .line 200
    iput v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mReceived:I

    .line 201
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$800(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/content/Context;

    move-result-object v1

    const/4 v2, 0x0

    iget-object v3, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mRecorderFrameRate:I
    invoke-static {v3}, Lco/vine/android/recorder/HwEncodingRunnable;->access$900(Lco/vine/android/recorder/HwEncodingRunnable;)I

    move-result v3

    invoke-static {v1, v2, v3}, Lco/vine/android/recorder/RecordConfigUtils;->newVideoRecorder(Landroid/content/Context;Ljava/lang/String;I)Lco/vine/android/recorder/HwVineFrameRecorder;

    move-result-object v1

    # setter for: Lco/vine/android/recorder/HwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/HwVineFrameRecorder;
    invoke-static {v0, v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$502(Lco/vine/android/recorder/HwEncodingRunnable;Lco/vine/android/recorder/HwVineFrameRecorder;)Lco/vine/android/recorder/HwVineFrameRecorder;

    .line 202
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-ge v0, v1, :cond_0

    .line 203
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/HwVineFrameRecorder;
    invoke-static {v0}, Lco/vine/android/recorder/HwEncodingRunnable;->access$500(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/HwVineFrameRecorder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lco/vine/android/recorder/HwVineFrameRecorder;->setDataListener(Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;)V

    .line 205
    :cond_0
    return-void
.end method

.method private putVideoFrame(Lco/vine/android/recorder/VideoData;)Z
    .locals 3
    .param p1, "data"    # Lco/vine/android/recorder/VideoData;

    .prologue
    .line 186
    iget v0, p1, Lco/vine/android/recorder/VideoData;->size:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 187
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferPosition:I
    invoke-static {v0}, Lco/vine/android/recorder/HwEncodingRunnable;->access$400(Lco/vine/android/recorder/HwEncodingRunnable;)I

    move-result v0

    iput v0, p1, Lco/vine/android/recorder/VideoData;->start:I

    .line 188
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mMaxEncodedSize:I
    invoke-static {v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$700(Lco/vine/android/recorder/HwEncodingRunnable;)I

    move-result v1

    iget v2, p1, Lco/vine/android/recorder/VideoData;->size:I

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    # setter for: Lco/vine/android/recorder/HwEncodingRunnable;->mMaxEncodedSize:I
    invoke-static {v0, v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$702(Lco/vine/android/recorder/HwEncodingRunnable;I)I

    .line 189
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    iget v1, p1, Lco/vine/android/recorder/VideoData;->size:I

    # += operator for: Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferPosition:I
    invoke-static {v0, v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$412(Lco/vine/android/recorder/HwEncodingRunnable;I)I

    .line 190
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mBufferedVideoData:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->pop()Ljava/lang/Object;

    .line 191
    const/4 v0, 0x1

    .line 194
    :goto_0
    return v0

    .line 193
    :cond_0
    const-string v0, "******Image was buffered to the next frame.********"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 194
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private stopEncoder(I)V
    .locals 4
    .param p1, "maxBufferCount"    # I

    .prologue
    .line 209
    :try_start_0
    const-string v1, "Stopping encoder. Error count: {}."

    iget v2, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mErrorCount:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 210
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/HwVineFrameRecorder;
    invoke-static {v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$500(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/HwVineFrameRecorder;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/recorder/HwVineFrameRecorder;->stopEncoding()V

    .line 211
    const-string v1, "Frames left? {}, allowed? {}."

    iget-object v2, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mBufferedVideoData:Ljava/util/LinkedList;

    invoke-virtual {v2}, Ljava/util/LinkedList;->size()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 212
    :goto_0
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mBufferedVideoData:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->size()I
    :try_end_0
    .catch Lco/vine/android/recorder/HwVineFrameRecorder$Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result v1

    if-le v1, p1, :cond_0

    .line 214
    const-wide/16 v1, 0xa

    :try_start_1
    invoke-static {v1, v2}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lco/vine/android/recorder/HwVineFrameRecorder$Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 215
    :catch_0
    move-exception v0

    .line 216
    .local v0, "e":Ljava/lang/InterruptedException;
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V
    :try_end_2
    .catch Lco/vine/android/recorder/HwVineFrameRecorder$Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 220
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catch_1
    move-exception v0

    .line 221
    .local v0, "e":Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
    const-string v1, "Error flushing..."

    invoke-static {v1, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 223
    .end local v0    # "e":Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
    :goto_1
    return-void

    .line 219
    :cond_0
    const/4 v1, 0x0

    :try_start_3
    iput v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mErrorCount:I
    :try_end_3
    .catch Lco/vine/android/recorder/HwVineFrameRecorder$Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1
.end method


# virtual methods
.method public add(Lco/vine/android/recorder/VideoData;)[B
    .locals 4
    .param p1, "next"    # Lco/vine/android/recorder/VideoData;

    .prologue
    .line 226
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->LOCK:[I

    monitor-enter v1

    .line 227
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Added to the queue. "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 228
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;
    invoke-static {v0}, Lco/vine/android/recorder/HwEncodingRunnable;->access$000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/ByteBufferQueue;

    move-result-object v0

    new-instance v2, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;

    iget-object v3, p1, Lco/vine/android/recorder/VideoData;->data:[B

    invoke-direct {v2, v3, p1}, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;-><init>([BLjava/lang/Object;)V

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/ByteBufferQueue;->put(Lco/vine/android/recorder/ByteBufferQueue$QueueItem;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 229
    const-string v0, "Not enough memory left. (BufferOverflow)"

    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 231
    :cond_0
    iget-object v0, p1, Lco/vine/android/recorder/VideoData;->data:[B

    monitor-exit v1

    return-object v0

    .line 232
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public onComplete()V
    .locals 0

    .prologue
    .line 305
    return-void
.end method

.method public onError(Ljava/lang/Exception;I)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "code"    # I

    .prologue
    .line 309
    const-string v0, "Encoding error: {}."

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v0, v1, p1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V

    .line 310
    iget v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mErrorCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mErrorCount:I

    .line 311
    return-void
.end method

.method public onFrameAvailable(Ljava/nio/ByteBuffer;)V
    .locals 3
    .param p1, "byteBuffer"    # Ljava/nio/ByteBuffer;

    .prologue
    .line 297
    iget v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mReceived:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mReceived:I

    .line 298
    const-string v0, "Got Frame! Processed: {}, Received: {}."

    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mTotalProcessed:I
    invoke-static {v1}, Lco/vine/android/recorder/HwEncodingRunnable;->access$600(Lco/vine/android/recorder/HwEncodingRunnable;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iget v2, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mReceived:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 299
    invoke-direct {p0, p1}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->doVideoFrameEncoded(Ljava/nio/ByteBuffer;)Z

    .line 300
    return-void
.end method

.method public processVideoData(Lco/vine/android/recorder/VideoData;Z)[B
    .locals 21
    .param p1, "next"    # Lco/vine/android/recorder/VideoData;
    .param p2, "lastFrame"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/HwVineFrameRecorder$Exception;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 236
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLastSegment:Lco/vine/android/recorder/RecordSegment;

    move-object/from16 v17, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    if-eq v0, v1, :cond_1

    const/4 v11, 0x1

    .line 237
    .local v11, "newSegment":Z
    :goto_0
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLastSegment:Lco/vine/android/recorder/RecordSegment;

    .line 238
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/PictureConverter;

    move-result-object v17

    move-object/from16 v0, v17

    iget-object v0, v0, Lco/vine/android/recorder/PictureConverter;->LOCK:[I

    move-object/from16 v18, v0

    monitor-enter v18

    .line 239
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v14

    .line 240
    .local v14, "startTime":J
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lco/vine/android/recorder/RecordSegment;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v4

    .line 241
    .local v4, "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/PictureConverter;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Lco/vine/android/recorder/PictureConverter;->updateSettingsIfNeeded(Lco/vine/android/recorder/CameraSetting;)Z

    move-result v10

    .line 243
    .local v10, "hasChanged":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/PictureConverter;

    move-result-object v17

    iget v0, v4, Lco/vine/android/recorder/CameraSetting;->degrees:I

    move/from16 v19, v0

    const/16 v20, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/PictureConverter;->giveMatrixNewValuesWithScaleIfDegreeHasChangedWithKnownConfigs(IZ)V

    .line 246
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/PictureConverter;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    invoke-virtual {v0, v4, v1, v10}, Lco/vine/android/recorder/PictureConverter;->convert(Lco/vine/android/recorder/CameraSetting;Lco/vine/android/recorder/VideoData;Z)Z

    .line 248
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v19

    sub-long v19, v19, v14

    move-object/from16 v0, v17

    move-wide/from16 v1, v19

    # += operator for: Lco/vine/android/recorder/HwEncodingRunnable;->timeToRGB:J
    invoke-static {v0, v1, v2}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1114(Lco/vine/android/recorder/HwEncodingRunnable;J)J

    .line 249
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v14

    .line 253
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/PictureConverter;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v19, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mMatrixCanvas:Landroid/graphics/Canvas;
    invoke-static/range {v19 .. v19}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1200(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Canvas;

    move-result-object v19

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/PictureConverter;->draw(Landroid/graphics/Canvas;)V

    .line 255
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v19

    sub-long v19, v19, v14

    move-object/from16 v0, v17

    move-wide/from16 v1, v19

    # += operator for: Lco/vine/android/recorder/HwEncodingRunnable;->timeToMatrix:J
    invoke-static {v0, v1, v2}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1314(Lco/vine/android/recorder/HwEncodingRunnable;J)J

    .line 256
    monitor-exit v18
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 259
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mByteBuffer:Ljava/nio/ByteBuffer;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    .line 260
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mMatrixBitmap:Landroid/graphics/Bitmap;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1400(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Bitmap;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mByteBuffer:Ljava/nio/ByteBuffer;

    move-object/from16 v18, v0

    invoke-virtual/range {v17 .. v18}, Landroid/graphics/Bitmap;->copyPixelsToBuffer(Ljava/nio/Buffer;)V

    .line 262
    if-eqz v11, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mTerminateImmediately:Z
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1500(Lco/vine/android/recorder/HwEncodingRunnable;)Z

    move-result v17

    if-nez v17, :cond_0

    .line 263
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/PictureConverter;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v18, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mThumbnailCanvas:Landroid/graphics/Canvas;
    invoke-static/range {v18 .. v18}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1600(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Canvas;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v19, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mMatrixBitmap:Landroid/graphics/Bitmap;
    invoke-static/range {v19 .. v19}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1400(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Bitmap;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v20, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mThumbnailMatrix:Landroid/graphics/Matrix;
    invoke-static/range {v20 .. v20}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1700(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Matrix;

    move-result-object v20

    invoke-virtual/range {v17 .. v20}, Lco/vine/android/recorder/PictureConverter;->drawGeneric(Landroid/graphics/Canvas;Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V

    .line 264
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v18, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mOutput:Ljava/lang/String;
    invoke-static/range {v18 .. v18}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1800(Lco/vine/android/recorder/HwEncodingRunnable;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "."

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v18

    invoke-virtual/range {v17 .. v19}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, ".jpg"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 265
    .local v13, "path":Ljava/lang/String;
    move-object/from16 v0, p1

    iget-object v0, v0, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v13}, Lco/vine/android/recorder/RecordSegment;->setThumbnailPath(Ljava/lang/String;)V

    .line 266
    new-instance v8, Ljava/io/File;

    invoke-direct {v8, v13}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 267
    .local v8, "f":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v12

    .line 269
    .local v12, "parentFile":Ljava/io/File;
    :try_start_1
    new-instance v3, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v3}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 270
    .local v3, "bos":Ljava/io/ByteArrayOutputStream;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mThumbnailBitmap:Landroid/graphics/Bitmap;
    invoke-static/range {v17 .. v17}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1900(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Bitmap;

    move-result-object v17

    sget-object v18, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v19, 0x64

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 271
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v5

    .line 272
    .local v5, "compressed":[B
    new-instance v9, Ljava/io/FileOutputStream;

    invoke-direct {v9, v8}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 273
    .local v9, "fos":Ljava/io/FileOutputStream;
    invoke-virtual {v9, v5}, Ljava/io/FileOutputStream;->write([B)V

    .line 274
    invoke-virtual {v9}, Ljava/io/FileOutputStream;->close()V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    .line 286
    .end local v3    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "compressed":[B
    .end local v8    # "f":Ljava/io/File;
    .end local v9    # "fos":Ljava/io/FileOutputStream;
    .end local v12    # "parentFile":Ljava/io/File;
    .end local v13    # "path":Ljava/lang/String;
    :cond_0
    :goto_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v14

    .line 287
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mBufferedVideoData:Ljava/util/LinkedList;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 288
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mByteBuffer:Ljava/nio/ByteBuffer;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move/from16 v2, p2

    invoke-direct {v0, v1, v11, v2}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->doVideoFrameRaw([BZZ)Z

    .line 289
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v18

    sub-long v18, v18, v14

    # += operator for: Lco/vine/android/recorder/HwEncodingRunnable;->timeToRecord:J
    invoke-static/range {v17 .. v19}, Lco/vine/android/recorder/HwEncodingRunnable;->access$2014(Lco/vine/android/recorder/HwEncodingRunnable;J)J

    .line 290
    move-object/from16 v0, p1

    iget-object v6, v0, Lco/vine/android/recorder/VideoData;->data:[B

    .line 291
    .local v6, "data":[B
    const/16 v17, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    iput-object v0, v1, Lco/vine/android/recorder/VideoData;->data:[B

    .line 292
    return-object v6

    .line 236
    .end local v4    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .end local v6    # "data":[B
    .end local v10    # "hasChanged":Z
    .end local v11    # "newSegment":Z
    .end local v14    # "startTime":J
    :cond_1
    const/4 v11, 0x0

    goto/16 :goto_0

    .line 256
    .restart local v11    # "newSegment":Z
    :catchall_0
    move-exception v17

    :try_start_2
    monitor-exit v18
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v17

    .line 275
    .restart local v4    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .restart local v8    # "f":Ljava/io/File;
    .restart local v10    # "hasChanged":Z
    .restart local v12    # "parentFile":Ljava/io/File;
    .restart local v13    # "path":Ljava/lang/String;
    .restart local v14    # "startTime":J
    :catch_0
    move-exception v7

    .line 276
    .local v7, "e":Ljava/lang/Throwable;
    invoke-static {v12}, Lco/vine/android/recorder/RecordSessionManager;->wasSessionJustDeleted(Ljava/io/File;)Z

    move-result v16

    .line 277
    .local v16, "wasSessionJustDeleted":Z
    if-eqz v16, :cond_2

    .line 278
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    move-object/from16 v17, v0

    const/16 v18, 0x1

    # setter for: Lco/vine/android/recorder/HwEncodingRunnable;->mTerminateImmediately:Z
    invoke-static/range {v17 .. v18}, Lco/vine/android/recorder/HwEncodingRunnable;->access$1502(Lco/vine/android/recorder/HwEncodingRunnable;Z)Z

    .line 279
    invoke-static {v7}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 281
    :cond_2
    throw v7
.end method

.method public run()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 105
    const/16 v4, 0x13

    invoke-static {v4}, Landroid/os/Process;->setThreadPriority(I)V

    .line 106
    iput-object v9, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLastSegment:Lco/vine/android/recorder/RecordSegment;

    .line 107
    const-string v4, "EncodingProcessRunnable started."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 108
    :goto_0
    iget-boolean v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mRun:Z

    if-eqz v4, :cond_6

    .line 109
    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;
    invoke-static {v4}, Lco/vine/android/recorder/HwEncodingRunnable;->access$000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/ByteBufferQueue;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/recorder/ByteBufferQueue;->get()Lco/vine/android/recorder/ByteBufferQueue$QueueItem;

    move-result-object v0

    .line 110
    .local v0, "data":Lco/vine/android/recorder/ByteBufferQueue$QueueItem;
    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mProducer:Lco/vine/android/recorder/RecordController;
    invoke-static {v4}, Lco/vine/android/recorder/HwEncodingRunnable;->access$100(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/RecordController;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v4

    if-nez v4, :cond_1

    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;
    invoke-static {v4}, Lco/vine/android/recorder/HwEncodingRunnable;->access$200(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/BaseFinishProcessTask;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 111
    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;
    invoke-static {v4}, Lco/vine/android/recorder/HwEncodingRunnable;->access$000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/ByteBufferQueue;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/recorder/ByteBufferQueue;->size()I

    move-result v3

    .line 112
    .local v3, "size":I
    invoke-static {v3, v5}, Ljava/lang/Math;->max(II)I

    move-result v3

    .line 113
    iget v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    const/4 v7, -0x1

    if-ne v4, v7, :cond_0

    .line 114
    iput v3, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    .line 115
    const/4 v4, -0x8

    invoke-static {v4}, Landroid/os/Process;->setThreadPriority(I)V

    .line 116
    const-string v4, "Size to wait: {}."

    iget v7, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-static {v4, v7}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 118
    :cond_0
    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;
    invoke-static {v4}, Lco/vine/android/recorder/HwEncodingRunnable;->access$200(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/BaseFinishProcessTask;

    move-result-object v4

    iget v7, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    sub-int/2addr v7, v3

    mul-int/lit8 v7, v7, 0x5a

    iget v8, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    div-int/2addr v7, v8

    invoke-virtual {v4, v7}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    .line 120
    .end local v3    # "size":I
    :cond_1
    if-eqz v0, :cond_4

    .line 121
    const-string v4, "Got data. {}"

    invoke-static {v4, p0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 122
    iget-object v2, v0, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;->tag:Ljava/lang/Object;

    check-cast v2, Lco/vine/android/recorder/VideoData;

    .line 123
    .local v2, "next":Lco/vine/android/recorder/VideoData;
    iget-object v4, v0, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;->bytes:[B

    iput-object v4, v2, Lco/vine/android/recorder/VideoData;->data:[B

    .line 124
    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLast:Lco/vine/android/recorder/VideoData;

    if-eqz v4, :cond_2

    .line 126
    :try_start_0
    iget-object v7, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLast:Lco/vine/android/recorder/VideoData;

    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLast:Lco/vine/android/recorder/VideoData;

    iget-object v4, v4, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    iget-object v8, v2, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    if-eq v4, v8, :cond_3

    move v4, v5

    :goto_1
    invoke-virtual {p0, v7, v4}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->processVideoData(Lco/vine/android/recorder/VideoData;Z)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 130
    iput-object v9, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLast:Lco/vine/android/recorder/VideoData;

    .line 132
    :cond_2
    iput-object v2, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLast:Lco/vine/android/recorder/VideoData;

    goto :goto_0

    :cond_3
    move v4, v6

    .line 126
    goto :goto_1

    .line 127
    :catch_0
    move-exception v1

    .line 128
    .local v1, "e":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/RuntimeException;

    invoke-direct {v4, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v4

    .line 134
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "next":Lco/vine/android/recorder/VideoData;
    :cond_4
    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->this$0:Lco/vine/android/recorder/HwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/HwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;
    invoke-static {v4}, Lco/vine/android/recorder/HwEncodingRunnable;->access$000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/ByteBufferQueue;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/recorder/ByteBufferQueue;->isEndOfPut()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 135
    iput-boolean v6, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mRun:Z

    goto/16 :goto_0

    .line 138
    :cond_5
    const-wide/16 v7, 0x64

    :try_start_1
    invoke-static {v7, v8}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    .line 139
    :catch_1
    move-exception v1

    .line 140
    .local v1, "e":Ljava/lang/InterruptedException;
    const-string v4, "Interrupted."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 145
    .end local v0    # "data":Lco/vine/android/recorder/ByteBufferQueue$QueueItem;
    .end local v1    # "e":Ljava/lang/InterruptedException;
    :cond_6
    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLast:Lco/vine/android/recorder/VideoData;

    if-eqz v4, :cond_7

    .line 147
    :try_start_2
    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLast:Lco/vine/android/recorder/VideoData;

    const/4 v5, 0x1

    invoke-virtual {p0, v4, v5}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->processVideoData(Lco/vine/android/recorder/VideoData;Z)[B
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 151
    iput-object v9, p0, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mLast:Lco/vine/android/recorder/VideoData;

    .line 153
    :cond_7
    invoke-direct {p0, v6}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->stopEncoder(I)V

    .line 154
    return-void

    .line 148
    :catch_2
    move-exception v1

    .line 149
    .local v1, "e":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/RuntimeException;

    invoke-direct {v4, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v4
.end method
