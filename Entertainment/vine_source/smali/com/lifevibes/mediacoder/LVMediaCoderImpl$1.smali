.class Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;
.super Ljava/lang/Object;
.source "LVMediaCoderImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeVideoAsyncPull()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;


# direct methods
.method constructor <init>(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)V
    .locals 0

    .prologue
    .line 429
    iput-object p1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 431
    const/4 v2, 0x0

    .line 432
    .local v2, "i":I
    const/4 v1, 0x1

    .line 433
    .local v1, "first":Z
    const-string v4, "[LVMediaCoderImpl] PULLER +++++++++++++++++++++++++++++++++++++++++++++++++++++++++"

    invoke-static {v4, v7}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 434
    :goto_0
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->pullerFlagExit:Z
    invoke-static {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$000(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 437
    :try_start_0
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoder:Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;
    invoke-static {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$200(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderSFVideoEncoder;->pollEncoderForOutput()Ljava/nio/ByteBuffer;

    move-result-object v4

    # setter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->outData:Ljava/nio/ByteBuffer;
    invoke-static {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$102(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;

    .line 438
    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->outData:Ljava/nio/ByteBuffer;
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$100()Ljava/nio/ByteBuffer;

    move-result-object v4

    if-nez v4, :cond_1

    .line 440
    const-string v4, "[LVMediaCoderImpl] Puller: Encoder output is null ##########"

    const/4 v5, 0x0

    invoke-static {v4, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 469
    :cond_0
    :goto_1
    const-wide/16 v4, 0xa

    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 470
    :catch_0
    move-exception v0

    .line 471
    .local v0, "e":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] encodeVideoPoll(): returned: Exception: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v8}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 472
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # invokes: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->cancelEncodingICS()V
    invoke-static {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$700(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)V

    .line 473
    new-instance v4, Ljava/lang/IllegalStateException;

    invoke-direct {v4, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v4

    .line 445
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    if-ne v1, v8, :cond_2

    .line 447
    const/4 v1, 0x0

    .line 448
    :try_start_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] Puller: Length of Encoder output (DSI): "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I
    invoke-static {v5}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$300(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " DSI ##########"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->outData:Ljava/nio/ByteBuffer;
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$100()Ljava/nio/ByteBuffer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v5

    array-length v5, v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v4, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    goto :goto_1

    .line 451
    :cond_2
    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->outData:Ljava/nio/ByteBuffer;
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$100()Ljava/nio/ByteBuffer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v3

    .line 454
    .local v3, "startCode":[B
    array-length v4, v3

    if-le v4, v9, :cond_3

    .line 455
    const/4 v4, 0x4

    aget-byte v4, v3, v4

    const/16 v5, 0xa

    if-eq v4, v5, :cond_0

    .line 456
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoderListener:Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;
    invoke-static {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$400(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;

    move-result-object v4

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->outData:Ljava/nio/ByteBuffer;
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$100()Ljava/nio/ByteBuffer;

    move-result-object v5

    invoke-interface {v4, v5}, Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;->onFrameAvailable(Ljava/nio/ByteBuffer;)V

    .line 457
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # operator++ for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I
    invoke-static {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$308(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)I

    .line 458
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "[LVMediaCoderImpl] Puller: Length of Encoder output: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I
    invoke-static {v5}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$300(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " ##########"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->outData:Ljava/nio/ByteBuffer;
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$100()Ljava/nio/ByteBuffer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v5

    array-length v5, v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v4, v5}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 460
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isEndOfStream:Z
    invoke-static {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$500(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mRetrievedEncodedFrameCount:I
    invoke-static {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$300(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)I

    move-result v4

    iget-object v5, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mSuppliedEncodedFrameCount:I
    invoke-static {v5}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$600(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)I

    move-result v5

    if-ne v4, v5, :cond_0

    .line 461
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoderListener:Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;
    invoke-static {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$400(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;

    move-result-object v4

    invoke-interface {v4}, Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;->onComplete()V

    goto/16 :goto_1

    .line 465
    :cond_3
    iget-object v4, p0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl$1;->this$0:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    # getter for: Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->mICSVideoEncoderListener:Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;
    invoke-static {v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->access$400(Lcom/lifevibes/mediacoder/LVMediaCoderImpl;)Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;

    move-result-object v4

    new-instance v5, Ljava/lang/Exception;

    const-string v6, "Black frame encountered"

    invoke-direct {v5, v6}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    const/4 v6, -0x1

    invoke-interface {v4, v5, v6}, Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;->onError(Ljava/lang/Exception;I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 476
    .end local v3    # "startCode":[B
    :cond_4
    const-string v4, "[LVMediaCoderImpl] STOP DONE ----------------------------"

    invoke-static {v4, v7}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 477
    return-void
.end method
