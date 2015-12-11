.class public Lcom/codebutler/android_websockets/HybiParser;
.super Ljava/lang/Object;
.source "HybiParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;,
        Lcom/codebutler/android_websockets/HybiParser$ProtocolError;
    }
.end annotation


# static fields
.field private static final BYTE:I = 0xff

.field private static final FIN:I = 0x80

.field private static final FRAGMENTED_OPCODES:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final LENGTH:I = 0x7f

.field private static final MASK:I = 0x80

.field private static final MODE_BINARY:I = 0x2

.field private static final MODE_TEXT:I = 0x1

.field private static final OPCODE:I = 0xf

.field private static final OPCODES:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final OP_BINARY:I = 0x2

.field private static final OP_CLOSE:I = 0x8

.field private static final OP_CONTINUATION:I = 0x0

.field private static final OP_PING:I = 0x9

.field private static final OP_PONG:I = 0xa

.field private static final OP_TEXT:I = 0x1

.field private static final RSV1:I = 0x40

.field private static final RSV2:I = 0x20

.field private static final RSV3:I = 0x10

.field private static final TAG:Ljava/lang/String; = "HybiParser"


# instance fields
.field private mBuffer:Ljava/io/ByteArrayOutputStream;

.field private mClient:Lcom/codebutler/android_websockets/WebSocketClient;

.field private mClosed:Z

.field private mFinal:Z

.field private mLength:I

.field private mLengthSize:I

.field private mMask:[B

.field private mMasked:Z

.field private mMasking:Z

.field private mMode:I

.field private mOpcode:I

.field private mPayload:[B

.field private mStage:I


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 81
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/Integer;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v3

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v4

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v5

    const/16 v1, 0x8

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v6

    const/4 v1, 0x4

    const/16 v2, 0x9

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const/16 v2, 0xa

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/codebutler/android_websockets/HybiParser;->OPCODES:Ljava/util/List;

    .line 90
    new-array v0, v6, [Ljava/lang/Integer;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v3

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v4

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v0, v5

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/codebutler/android_websockets/HybiParser;->FRAGMENTED_OPCODES:Ljava/util/List;

    return-void
.end method

.method public constructor <init>(Lcom/codebutler/android_websockets/WebSocketClient;)V
    .locals 2
    .param p1, "client"    # Lcom/codebutler/android_websockets/WebSocketClient;

    .prologue
    const/4 v1, 0x0

    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mMasking:Z

    .line 55
    new-array v0, v1, [B

    iput-object v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mMask:[B

    .line 56
    new-array v0, v1, [B

    iput-object v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mPayload:[B

    .line 58
    iput-boolean v1, p0, Lcom/codebutler/android_websockets/HybiParser;->mClosed:Z

    .line 60
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    iput-object v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mBuffer:Ljava/io/ByteArrayOutputStream;

    .line 95
    iput-object p1, p0, Lcom/codebutler/android_websockets/HybiParser;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    .line 96
    return-void
.end method

.method private static byteArrayToLong([BII)J
    .locals 6
    .param p0, "b"    # [B
    .param p1, "offset"    # I
    .param p2, "length"    # I

    .prologue
    .line 347
    array-length v4, p0

    if-ge v4, p2, :cond_0

    .line 348
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "length must be less than or equal to b.length"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 350
    :cond_0
    const-wide/16 v2, 0x0

    .line 351
    .local v2, "value":J
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p2, :cond_1

    .line 352
    add-int/lit8 v4, p2, -0x1

    sub-int/2addr v4, v0

    mul-int/lit8 v1, v4, 0x8

    .line 353
    .local v1, "shift":I
    add-int v4, v0, p1

    aget-byte v4, p0, v4

    and-int/lit16 v4, v4, 0xff

    shl-int/2addr v4, v1

    int-to-long v4, v4

    add-long/2addr v2, v4

    .line 351
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 355
    .end local v1    # "shift":I
    :cond_1
    return-wide v2
.end method

.method private decode(Ljava/lang/String;)[B
    .locals 2
    .param p1, "string"    # Ljava/lang/String;

    .prologue
    .line 322
    :try_start_0
    const-string v1, "UTF-8"

    invoke-virtual {p1, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    .line 323
    :catch_0
    move-exception v0

    .line 324
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private emitFrame()V
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v10, 0xa

    const/4 v0, 0x0

    const/4 v9, 0x1

    const/4 v8, 0x2

    .line 254
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mPayload:[B

    iget-object v7, p0, Lcom/codebutler/android_websockets/HybiParser;->mMask:[B

    invoke-static {v6, v7, v0}, Lcom/codebutler/android_websockets/HybiParser;->mask([B[BI)[B

    move-result-object v4

    .line 255
    .local v4, "payload":[B
    iget v3, p0, Lcom/codebutler/android_websockets/HybiParser;->mOpcode:I

    .line 257
    .local v3, "opcode":I
    if-nez v3, :cond_3

    .line 258
    iget v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mMode:I

    if-nez v6, :cond_0

    .line 259
    new-instance v6, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;

    const-string v7, "Mode was not set."

    invoke-direct {v6, v7}, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;-><init>(Ljava/lang/String;)V

    throw v6

    .line 261
    :cond_0
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mBuffer:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v6, v4}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 262
    iget-boolean v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mFinal:Z

    if-eqz v6, :cond_1

    .line 263
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mBuffer:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v6}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    .line 264
    .local v1, "message":[B
    iget v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mMode:I

    if-ne v6, v9, :cond_2

    .line 265
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    invoke-virtual {v6}, Lcom/codebutler/android_websockets/WebSocketClient;->getListener()Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v6

    invoke-direct {p0, v1}, Lcom/codebutler/android_websockets/HybiParser;->encode([B)Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onMessage(Ljava/lang/String;)V

    .line 269
    :goto_0
    invoke-direct {p0}, Lcom/codebutler/android_websockets/HybiParser;->reset()V

    .line 305
    .end local v1    # "message":[B
    :cond_1
    :goto_1
    return-void

    .line 267
    .restart local v1    # "message":[B
    :cond_2
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    invoke-virtual {v6}, Lcom/codebutler/android_websockets/WebSocketClient;->getListener()Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v6

    invoke-interface {v6, v1}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onMessage([B)V

    goto :goto_0

    .line 272
    .end local v1    # "message":[B
    :cond_3
    if-ne v3, v9, :cond_5

    .line 273
    iget-boolean v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mFinal:Z

    if-eqz v6, :cond_4

    .line 274
    invoke-direct {p0, v4}, Lcom/codebutler/android_websockets/HybiParser;->encode([B)Ljava/lang/String;

    move-result-object v2

    .line 275
    .local v2, "messageText":Ljava/lang/String;
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    invoke-virtual {v6}, Lcom/codebutler/android_websockets/WebSocketClient;->getListener()Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v6

    invoke-interface {v6, v2}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onMessage(Ljava/lang/String;)V

    goto :goto_1

    .line 277
    .end local v2    # "messageText":Ljava/lang/String;
    :cond_4
    iput v9, p0, Lcom/codebutler/android_websockets/HybiParser;->mMode:I

    .line 278
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mBuffer:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v6, v4}, Ljava/io/ByteArrayOutputStream;->write([B)V

    goto :goto_1

    .line 281
    :cond_5
    if-ne v3, v8, :cond_7

    .line 282
    iget-boolean v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mFinal:Z

    if-eqz v6, :cond_6

    .line 283
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    invoke-virtual {v6}, Lcom/codebutler/android_websockets/WebSocketClient;->getListener()Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v6

    invoke-interface {v6, v4}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onMessage([B)V

    goto :goto_1

    .line 285
    :cond_6
    iput v8, p0, Lcom/codebutler/android_websockets/HybiParser;->mMode:I

    .line 286
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mBuffer:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v6, v4}, Ljava/io/ByteArrayOutputStream;->write([B)V

    goto :goto_1

    .line 289
    :cond_7
    const/16 v6, 0x8

    if-ne v3, v6, :cond_a

    .line 290
    array-length v6, v4

    if-lt v6, v8, :cond_8

    aget-byte v6, v4, v0

    mul-int/lit16 v6, v6, 0x100

    aget-byte v7, v4, v9

    add-int v0, v6, v7

    .line 291
    .local v0, "code":I
    :cond_8
    array-length v6, v4

    if-le v6, v8, :cond_9

    invoke-direct {p0, v4, v8}, Lcom/codebutler/android_websockets/HybiParser;->slice([BI)[B

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/codebutler/android_websockets/HybiParser;->encode([B)Ljava/lang/String;

    move-result-object v5

    .line 292
    .local v5, "reason":Ljava/lang/String;
    :goto_2
    const-string v6, "HybiParser"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Got close op! "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 293
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    invoke-virtual {v6}, Lcom/codebutler/android_websockets/WebSocketClient;->getListener()Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v6

    invoke-interface {v6, v0, v5}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onDisconnect(ILjava/lang/String;)V

    goto/16 :goto_1

    .line 291
    .end local v5    # "reason":Ljava/lang/String;
    :cond_9
    const/4 v5, 0x0

    goto :goto_2

    .line 295
    .end local v0    # "code":I
    :cond_a
    const/16 v6, 0x9

    if-ne v3, v6, :cond_c

    .line 296
    array-length v6, v4

    const/16 v7, 0x7d

    if-le v6, v7, :cond_b

    new-instance v6, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;

    const-string v7, "Ping payload too large"

    invoke-direct {v6, v7}, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;-><init>(Ljava/lang/String;)V

    throw v6

    .line 297
    :cond_b
    const-string v6, "HybiParser"

    const-string v7, "Sending pong!!"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 298
    iget-object v6, p0, Lcom/codebutler/android_websockets/HybiParser;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    const/4 v7, -0x1

    invoke-direct {p0, v4, v10, v7}, Lcom/codebutler/android_websockets/HybiParser;->frame([BII)[B

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/codebutler/android_websockets/WebSocketClient;->sendFrame([B)V

    goto/16 :goto_1

    .line 300
    :cond_c
    if-ne v3, v10, :cond_1

    .line 301
    invoke-direct {p0, v4}, Lcom/codebutler/android_websockets/HybiParser;->encode([B)Ljava/lang/String;

    move-result-object v1

    .line 303
    .local v1, "message":Ljava/lang/String;
    const-string v6, "HybiParser"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Got pong! "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1
.end method

.method private encode([B)Ljava/lang/String;
    .locals 3
    .param p1, "buffer"    # [B

    .prologue
    .line 314
    :try_start_0
    new-instance v1, Ljava/lang/String;

    const-string v2, "UTF-8"

    invoke-direct {v1, p1, v2}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 315
    :catch_0
    move-exception v0

    .line 316
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private frame(Ljava/lang/Object;II)[B
    .locals 16
    .param p1, "data"    # Ljava/lang/Object;
    .param p2, "opcode"    # I
    .param p3, "errorCode"    # I

    .prologue
    .line 193
    move-object/from16 v0, p0

    iget-boolean v9, v0, Lcom/codebutler/android_websockets/HybiParser;->mClosed:Z

    if-eqz v9, :cond_1

    const/4 v2, 0x0

    .line 240
    .end local p1    # "data":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-object v2

    .line 195
    .restart local p1    # "data":Ljava/lang/Object;
    :cond_1
    const-string v9, "HybiParser"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Creating frame for: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    move-object/from16 v0, p1

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " op: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    move/from16 v0, p2

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " err: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    move/from16 v0, p3

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 197
    move-object/from16 v0, p1

    instance-of v9, v0, Ljava/lang/String;

    if-eqz v9, :cond_3

    check-cast p1, Ljava/lang/String;

    .end local p1    # "data":Ljava/lang/Object;
    invoke-direct/range {p0 .. p1}, Lcom/codebutler/android_websockets/HybiParser;->decode(Ljava/lang/String;)[B

    move-result-object v1

    .line 198
    .local v1, "buffer":[B
    :goto_1
    if-lez p3, :cond_4

    const/4 v4, 0x2

    .line 199
    .local v4, "insert":I
    :goto_2
    array-length v9, v1

    add-int v5, v9, v4

    .line 200
    .local v5, "length":I
    const/16 v9, 0x7d

    if-gt v5, v9, :cond_5

    const/4 v3, 0x2

    .line 201
    .local v3, "header":I
    :goto_3
    move-object/from16 v0, p0

    iget-boolean v9, v0, Lcom/codebutler/android_websockets/HybiParser;->mMasking:Z

    if-eqz v9, :cond_7

    const/4 v9, 0x4

    :goto_4
    add-int v8, v3, v9

    .line 202
    .local v8, "offset":I
    move-object/from16 v0, p0

    iget-boolean v9, v0, Lcom/codebutler/android_websockets/HybiParser;->mMasking:Z

    if-eqz v9, :cond_8

    const/16 v7, 0x80

    .line 203
    .local v7, "masked":I
    :goto_5
    add-int v9, v5, v8

    new-array v2, v9, [B

    .line 205
    .local v2, "frame":[B
    const/4 v9, 0x0

    move/from16 v0, p2

    int-to-byte v10, v0

    or-int/lit8 v10, v10, -0x80

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 207
    const/16 v9, 0x7d

    if-gt v5, v9, :cond_9

    .line 208
    const/4 v9, 0x1

    or-int v10, v7, v5

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 225
    :goto_6
    if-lez p3, :cond_2

    .line 226
    move/from16 v0, p3

    div-int/lit16 v9, v0, 0x100

    int-to-double v9, v9

    invoke-static {v9, v10}, Ljava/lang/Math;->floor(D)D

    move-result-wide v9

    double-to-int v9, v9

    and-int/lit16 v9, v9, 0xff

    int-to-byte v9, v9

    aput-byte v9, v2, v8

    .line 227
    add-int/lit8 v9, v8, 0x1

    move/from16 v0, p3

    and-int/lit16 v10, v0, 0xff

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 229
    :cond_2
    const/4 v9, 0x0

    add-int v10, v8, v4

    array-length v11, v1

    invoke-static {v1, v9, v2, v10, v11}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 231
    move-object/from16 v0, p0

    iget-boolean v9, v0, Lcom/codebutler/android_websockets/HybiParser;->mMasking:Z

    if-eqz v9, :cond_0

    .line 232
    const/4 v9, 0x4

    new-array v6, v9, [B

    const/4 v9, 0x0

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v10

    const-wide/high16 v12, 0x4070000000000000L    # 256.0

    mul-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    int-to-byte v10, v10

    aput-byte v10, v6, v9

    const/4 v9, 0x1

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v10

    const-wide/high16 v12, 0x4070000000000000L    # 256.0

    mul-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    int-to-byte v10, v10

    aput-byte v10, v6, v9

    const/4 v9, 0x2

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v10

    const-wide/high16 v12, 0x4070000000000000L    # 256.0

    mul-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    int-to-byte v10, v10

    aput-byte v10, v6, v9

    const/4 v9, 0x3

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v10

    const-wide/high16 v12, 0x4070000000000000L    # 256.0

    mul-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    int-to-byte v10, v10

    aput-byte v10, v6, v9

    .line 236
    .local v6, "mask":[B
    const/4 v9, 0x0

    array-length v10, v6

    invoke-static {v6, v9, v2, v3, v10}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 237
    invoke-static {v2, v6, v8}, Lcom/codebutler/android_websockets/HybiParser;->mask([B[BI)[B

    goto/16 :goto_0

    .line 197
    .end local v1    # "buffer":[B
    .end local v2    # "frame":[B
    .end local v3    # "header":I
    .end local v4    # "insert":I
    .end local v5    # "length":I
    .end local v6    # "mask":[B
    .end local v7    # "masked":I
    .end local v8    # "offset":I
    .restart local p1    # "data":Ljava/lang/Object;
    :cond_3
    check-cast p1, [B

    .end local p1    # "data":Ljava/lang/Object;
    check-cast p1, [B

    move-object/from16 v1, p1

    goto/16 :goto_1

    .line 198
    .restart local v1    # "buffer":[B
    :cond_4
    const/4 v4, 0x0

    goto/16 :goto_2

    .line 200
    .restart local v4    # "insert":I
    .restart local v5    # "length":I
    :cond_5
    const v9, 0xffff

    if-gt v5, v9, :cond_6

    const/4 v3, 0x4

    goto/16 :goto_3

    :cond_6
    const/16 v3, 0xa

    goto/16 :goto_3

    .line 201
    .restart local v3    # "header":I
    :cond_7
    const/4 v9, 0x0

    goto/16 :goto_4

    .line 202
    .restart local v8    # "offset":I
    :cond_8
    const/4 v7, 0x0

    goto/16 :goto_5

    .line 209
    .restart local v2    # "frame":[B
    .restart local v7    # "masked":I
    :cond_9
    const v9, 0xffff

    if-gt v5, v9, :cond_a

    .line 210
    const/4 v9, 0x1

    or-int/lit8 v10, v7, 0x7e

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 211
    const/4 v9, 0x2

    div-int/lit16 v10, v5, 0x100

    int-to-double v10, v10

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 212
    const/4 v9, 0x3

    and-int/lit16 v10, v5, 0xff

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    goto/16 :goto_6

    .line 214
    :cond_a
    const/4 v9, 0x1

    or-int/lit8 v10, v7, 0x7f

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 215
    const/4 v9, 0x2

    int-to-double v10, v5

    const-wide/high16 v12, 0x4000000000000000L    # 2.0

    const-wide/high16 v14, 0x404c000000000000L    # 56.0

    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v12

    div-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    and-int/lit16 v10, v10, 0xff

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 216
    const/4 v9, 0x3

    int-to-double v10, v5

    const-wide/high16 v12, 0x4000000000000000L    # 2.0

    const-wide/high16 v14, 0x4048000000000000L    # 48.0

    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v12

    div-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    and-int/lit16 v10, v10, 0xff

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 217
    const/4 v9, 0x4

    int-to-double v10, v5

    const-wide/high16 v12, 0x4000000000000000L    # 2.0

    const-wide/high16 v14, 0x4044000000000000L    # 40.0

    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v12

    div-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    and-int/lit16 v10, v10, 0xff

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 218
    const/4 v9, 0x5

    int-to-double v10, v5

    const-wide/high16 v12, 0x4000000000000000L    # 2.0

    const-wide/high16 v14, 0x4040000000000000L    # 32.0

    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v12

    div-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    and-int/lit16 v10, v10, 0xff

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 219
    const/4 v9, 0x6

    int-to-double v10, v5

    const-wide/high16 v12, 0x4000000000000000L    # 2.0

    const-wide/high16 v14, 0x4038000000000000L    # 24.0

    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v12

    div-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    and-int/lit16 v10, v10, 0xff

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 220
    const/4 v9, 0x7

    int-to-double v10, v5

    const-wide/high16 v12, 0x4000000000000000L    # 2.0

    const-wide/high16 v14, 0x4030000000000000L    # 16.0

    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v12

    div-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    and-int/lit16 v10, v10, 0xff

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 221
    const/16 v9, 0x8

    int-to-double v10, v5

    const-wide/high16 v12, 0x4000000000000000L    # 2.0

    const-wide/high16 v14, 0x4020000000000000L    # 8.0

    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v12

    div-double/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v10, v10

    and-int/lit16 v10, v10, 0xff

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    .line 222
    const/16 v9, 0x9

    and-int/lit16 v10, v5, 0xff

    int-to-byte v10, v10

    aput-byte v10, v2, v9

    goto/16 :goto_6
.end method

.method private frame(Ljava/lang/String;II)[B
    .locals 1
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "opcode"    # I
    .param p3, "errorCode"    # I

    .prologue
    .line 189
    invoke-direct {p0, p1, p2, p3}, Lcom/codebutler/android_websockets/HybiParser;->frame(Ljava/lang/Object;II)[B

    move-result-object v0

    return-object v0
.end method

.method private frame([BII)[B
    .locals 1
    .param p1, "data"    # [B
    .param p2, "opcode"    # I
    .param p3, "errorCode"    # I

    .prologue
    .line 185
    invoke-direct {p0, p1, p2, p3}, Lcom/codebutler/android_websockets/HybiParser;->frame(Ljava/lang/Object;II)[B

    move-result-object v0

    return-object v0
.end method

.method private getInteger([B)I
    .locals 5
    .param p1, "bytes"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/codebutler/android_websockets/HybiParser$ProtocolError;
        }
    .end annotation

    .prologue
    .line 329
    const/4 v2, 0x0

    array-length v3, p1

    invoke-static {p1, v2, v3}, Lcom/codebutler/android_websockets/HybiParser;->byteArrayToLong([BII)J

    move-result-wide v0

    .line 330
    .local v0, "i":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-ltz v2, :cond_0

    const-wide/32 v2, 0x7fffffff

    cmp-long v2, v0, v2

    if-lez v2, :cond_1

    .line 331
    :cond_0
    new-instance v2, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Bad integer: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;-><init>(Ljava/lang/String;)V

    throw v2

    .line 333
    :cond_1
    long-to-int v2, v0

    return v2
.end method

.method private static mask([B[BI)[B
    .locals 4
    .param p0, "payload"    # [B
    .param p1, "mask"    # [B
    .param p2, "offset"    # I

    .prologue
    .line 99
    array-length v1, p1

    if-nez v1, :cond_1

    .line 104
    :cond_0
    return-object p0

    .line 101
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p0

    sub-int/2addr v1, p2

    if-ge v0, v1, :cond_0

    .line 102
    add-int v1, p2, v0

    add-int v2, p2, v0

    aget-byte v2, p0, v2

    rem-int/lit8 v3, v0, 0x4

    aget-byte v3, p1, v3

    xor-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, p0, v1

    .line 101
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private parseExtendedLength([B)V
    .locals 1
    .param p1, "buffer"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/codebutler/android_websockets/HybiParser$ProtocolError;
        }
    .end annotation

    .prologue
    .line 172
    invoke-direct {p0, p1}, Lcom/codebutler/android_websockets/HybiParser;->getInteger([B)I

    move-result v0

    iput v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mLength:I

    .line 173
    iget-boolean v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mMasked:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x3

    :goto_0
    iput v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mStage:I

    .line 174
    return-void

    .line 173
    :cond_0
    const/4 v0, 0x4

    goto :goto_0
.end method

.method private parseLength(B)V
    .locals 3
    .param p1, "data"    # B

    .prologue
    const/4 v1, 0x2

    .line 160
    and-int/lit16 v0, p1, 0x80

    const/16 v2, 0x80

    if-ne v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mMasked:Z

    .line 161
    and-int/lit8 v0, p1, 0x7f

    iput v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mLength:I

    .line 163
    iget v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mLength:I

    if-ltz v0, :cond_2

    iget v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mLength:I

    const/16 v2, 0x7d

    if-gt v0, v2, :cond_2

    .line 164
    iget-boolean v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mMasked:Z

    if-eqz v0, :cond_1

    const/4 v0, 0x3

    :goto_1
    iput v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mStage:I

    .line 169
    :goto_2
    return-void

    .line 160
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 164
    :cond_1
    const/4 v0, 0x4

    goto :goto_1

    .line 166
    :cond_2
    iget v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mLength:I

    const/16 v2, 0x7e

    if-ne v0, v2, :cond_3

    move v0, v1

    :goto_3
    iput v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mLengthSize:I

    .line 167
    iput v1, p0, Lcom/codebutler/android_websockets/HybiParser;->mStage:I

    goto :goto_2

    .line 166
    :cond_3
    const/16 v0, 0x8

    goto :goto_3
.end method

.method private parseOpcode(B)V
    .locals 7
    .param p1, "data"    # B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/codebutler/android_websockets/HybiParser$ProtocolError;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 135
    and-int/lit8 v3, p1, 0x40

    const/16 v6, 0x40

    if-ne v3, v6, :cond_1

    move v0, v4

    .line 136
    .local v0, "rsv1":Z
    :goto_0
    and-int/lit8 v3, p1, 0x20

    const/16 v6, 0x20

    if-ne v3, v6, :cond_2

    move v1, v4

    .line 137
    .local v1, "rsv2":Z
    :goto_1
    and-int/lit8 v3, p1, 0x10

    const/16 v6, 0x10

    if-ne v3, v6, :cond_3

    move v2, v4

    .line 139
    .local v2, "rsv3":Z
    :goto_2
    if-nez v0, :cond_0

    if-nez v1, :cond_0

    if-eqz v2, :cond_4

    .line 140
    :cond_0
    new-instance v3, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;

    const-string v4, "RSV not zero"

    invoke-direct {v3, v4}, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;-><init>(Ljava/lang/String;)V

    throw v3

    .end local v0    # "rsv1":Z
    .end local v1    # "rsv2":Z
    .end local v2    # "rsv3":Z
    :cond_1
    move v0, v5

    .line 135
    goto :goto_0

    .restart local v0    # "rsv1":Z
    :cond_2
    move v1, v5

    .line 136
    goto :goto_1

    .restart local v1    # "rsv2":Z
    :cond_3
    move v2, v5

    .line 137
    goto :goto_2

    .line 143
    .restart local v2    # "rsv3":Z
    :cond_4
    and-int/lit16 v3, p1, 0x80

    const/16 v6, 0x80

    if-ne v3, v6, :cond_5

    move v3, v4

    :goto_3
    iput-boolean v3, p0, Lcom/codebutler/android_websockets/HybiParser;->mFinal:Z

    .line 144
    and-int/lit8 v3, p1, 0xf

    iput v3, p0, Lcom/codebutler/android_websockets/HybiParser;->mOpcode:I

    .line 145
    new-array v3, v5, [B

    iput-object v3, p0, Lcom/codebutler/android_websockets/HybiParser;->mMask:[B

    .line 146
    new-array v3, v5, [B

    iput-object v3, p0, Lcom/codebutler/android_websockets/HybiParser;->mPayload:[B

    .line 148
    sget-object v3, Lcom/codebutler/android_websockets/HybiParser;->OPCODES:Ljava/util/List;

    iget v5, p0, Lcom/codebutler/android_websockets/HybiParser;->mOpcode:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v3, v5}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    .line 149
    new-instance v3, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;

    const-string v4, "Bad opcode"

    invoke-direct {v3, v4}, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;-><init>(Ljava/lang/String;)V

    throw v3

    :cond_5
    move v3, v5

    .line 143
    goto :goto_3

    .line 152
    :cond_6
    sget-object v3, Lcom/codebutler/android_websockets/HybiParser;->FRAGMENTED_OPCODES:Ljava/util/List;

    iget v5, p0, Lcom/codebutler/android_websockets/HybiParser;->mOpcode:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v3, v5}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_7

    iget-boolean v3, p0, Lcom/codebutler/android_websockets/HybiParser;->mFinal:Z

    if-nez v3, :cond_7

    .line 153
    new-instance v3, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;

    const-string v4, "Expected non-final packet"

    invoke-direct {v3, v4}, Lcom/codebutler/android_websockets/HybiParser$ProtocolError;-><init>(Ljava/lang/String;)V

    throw v3

    .line 156
    :cond_7
    iput v4, p0, Lcom/codebutler/android_websockets/HybiParser;->mStage:I

    .line 157
    return-void
.end method

.method private reset()V
    .locals 1

    .prologue
    .line 308
    const/4 v0, 0x0

    iput v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mMode:I

    .line 309
    iget-object v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mBuffer:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->reset()V

    .line 310
    return-void
.end method

.method private slice([BI)[B
    .locals 1
    .param p1, "array"    # [B
    .param p2, "start"    # I

    .prologue
    .line 337
    array-length v0, p1

    invoke-static {p1, p2, v0}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public close(ILjava/lang/String;)V
    .locals 2
    .param p1, "code"    # I
    .param p2, "reason"    # Ljava/lang/String;

    .prologue
    .line 248
    iget-boolean v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mClosed:Z

    if-eqz v0, :cond_0

    .line 251
    :goto_0
    return-void

    .line 249
    :cond_0
    iget-object v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    const/16 v1, 0x8

    invoke-direct {p0, p2, v1, p1}, Lcom/codebutler/android_websockets/HybiParser;->frame(Ljava/lang/String;II)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/codebutler/android_websockets/WebSocketClient;->send([B)V

    .line 250
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mClosed:Z

    goto :goto_0
.end method

.method public frame(Ljava/lang/String;)[B
    .locals 2
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 177
    const/4 v0, 0x1

    const/4 v1, -0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/codebutler/android_websockets/HybiParser;->frame(Ljava/lang/String;II)[B

    move-result-object v0

    return-object v0
.end method

.method public frame([B)[B
    .locals 2
    .param p1, "data"    # [B

    .prologue
    .line 181
    const/4 v0, 0x2

    const/4 v1, -0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/codebutler/android_websockets/HybiParser;->frame([BII)[B

    move-result-object v0

    return-object v0
.end method

.method public ping(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 244
    iget-object v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    const/16 v1, 0x9

    const/4 v2, -0x1

    invoke-direct {p0, p1, v1, v2}, Lcom/codebutler/android_websockets/HybiParser;->frame(Ljava/lang/String;II)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/codebutler/android_websockets/WebSocketClient;->send([B)V

    .line 245
    return-void
.end method

.method public start(Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;)V
    .locals 4
    .param p1, "stream"    # Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x4

    const/4 v2, 0x0

    .line 109
    :goto_0
    invoke-virtual {p1}, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;->available()I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 131
    iget-object v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mClient:Lcom/codebutler/android_websockets/WebSocketClient;

    invoke-virtual {v0}, Lcom/codebutler/android_websockets/WebSocketClient;->getListener()Lcom/codebutler/android_websockets/WebSocketClient$Listener;

    move-result-object v0

    const-string v1, "EOF"

    invoke-interface {v0, v2, v1}, Lcom/codebutler/android_websockets/WebSocketClient$Listener;->onDisconnect(ILjava/lang/String;)V

    .line 132
    return-void

    .line 110
    :cond_0
    iget v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mStage:I

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    .line 112
    :pswitch_0
    invoke-virtual {p1}, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;->readByte()B

    move-result v0

    invoke-direct {p0, v0}, Lcom/codebutler/android_websockets/HybiParser;->parseOpcode(B)V

    goto :goto_0

    .line 115
    :pswitch_1
    invoke-virtual {p1}, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;->readByte()B

    move-result v0

    invoke-direct {p0, v0}, Lcom/codebutler/android_websockets/HybiParser;->parseLength(B)V

    goto :goto_0

    .line 118
    :pswitch_2
    iget v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mLengthSize:I

    invoke-virtual {p1, v0}, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;->readBytes(I)[B

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/codebutler/android_websockets/HybiParser;->parseExtendedLength([B)V

    goto :goto_0

    .line 121
    :pswitch_3
    invoke-virtual {p1, v3}, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;->readBytes(I)[B

    move-result-object v0

    iput-object v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mMask:[B

    .line 122
    iput v3, p0, Lcom/codebutler/android_websockets/HybiParser;->mStage:I

    goto :goto_0

    .line 125
    :pswitch_4
    iget v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mLength:I

    invoke-virtual {p1, v0}, Lcom/codebutler/android_websockets/HybiParser$HappyDataInputStream;->readBytes(I)[B

    move-result-object v0

    iput-object v0, p0, Lcom/codebutler/android_websockets/HybiParser;->mPayload:[B

    .line 126
    invoke-direct {p0}, Lcom/codebutler/android_websockets/HybiParser;->emitFrame()V

    .line 127
    iput v2, p0, Lcom/codebutler/android_websockets/HybiParser;->mStage:I

    goto :goto_0

    .line 110
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method
