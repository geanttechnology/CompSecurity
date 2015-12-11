.class Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;
.super Ljava/io/InputStream;
.source "InputStreamMessageImpl.java"

# interfaces
.implements Lcom/amazon/communication/BetterInputStream;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/communication/InputStreamMessageImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PayloadInputStream"
.end annotation


# instance fields
.field private mEndOfStream:Z

.field private final mPrependedDataArray:[Ljava/nio/ByteBuffer;

.field private mPrependedReadIndex:I

.field final synthetic this$0:Lcom/amazon/communication/InputStreamMessageImpl;


# direct methods
.method constructor <init>(Lcom/amazon/communication/InputStreamMessageImpl;)V
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 43
    iput-object p1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->this$0:Lcom/amazon/communication/InputStreamMessageImpl;

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 44
    iput v0, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    .line 45
    iput-boolean v0, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mEndOfStream:Z

    .line 46
    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->mPrependedData:Ljava/util/List;
    invoke-static {p1}, Lcom/amazon/communication/InputStreamMessageImpl;->access$000(Lcom/amazon/communication/InputStreamMessageImpl;)Ljava/util/List;

    move-result-object v0

    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->mPrependedData:Ljava/util/List;
    invoke-static {p1}, Lcom/amazon/communication/InputStreamMessageImpl;->access$000(Lcom/amazon/communication/InputStreamMessageImpl;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [Ljava/nio/ByteBuffer;

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/nio/ByteBuffer;

    iput-object v0, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedDataArray:[Ljava/nio/ByteBuffer;

    .line 47
    return-void
.end method

.method private readFromPrepends([BII)I
    .locals 10
    .param p1, "array"    # [B
    .param p2, "offset"    # I
    .param p3, "maxBytesToRead"    # I

    .prologue
    .line 157
    move v2, p2

    .line 158
    .local v2, "currentOffset":I
    const/4 v0, 0x0

    .line 160
    .local v0, "bytesRead":I
    :goto_0
    if-ge v0, p3, :cond_2

    iget v4, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    iget-object v5, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedDataArray:[Ljava/nio/ByteBuffer;

    array-length v5, v5

    if-ge v4, v5, :cond_2

    .line 161
    iget-object v4, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedDataArray:[Ljava/nio/ByteBuffer;

    iget v5, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    aget-object v1, v4, v5

    .line 162
    .local v1, "currentBuffer":Ljava/nio/ByteBuffer;
    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 163
    sub-int v3, p3, v0

    .line 164
    .local v3, "toBeRead":I
    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v4

    if-le v3, v4, :cond_0

    .line 165
    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v3

    .line 167
    :cond_0
    invoke-virtual {v1, p1, v2, v3}, Ljava/nio/ByteBuffer;->get([BII)Ljava/nio/ByteBuffer;

    .line 168
    add-int/2addr v2, v3

    .line 169
    add-int/2addr v0, v3

    .line 170
    goto :goto_0

    .line 171
    .end local v3    # "toBeRead":I
    :cond_1
    iget v4, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    goto :goto_0

    .line 174
    .end local v1    # "currentBuffer":Ljava/nio/ByteBuffer;
    :cond_2
    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/communication/InputStreamMessageImpl;->access$200()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v4

    const-string/jumbo v5, "readFromPrepends"

    const-string/jumbo v6, "final"

    const/4 v7, 0x6

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    const-string/jumbo v9, "maxBytesToRead"

    aput-object v9, v7, v8

    const/4 v8, 0x1

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x2

    const-string/jumbo v9, "currentOffset"

    aput-object v9, v7, v8

    const/4 v8, 0x3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x4

    const-string/jumbo v9, "bytesRead"

    aput-object v9, v7, v8

    const/4 v8, 0x5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 178
    return v0
.end method


# virtual methods
.method public available()I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 128
    const/4 v0, 0x0

    .line 130
    .local v0, "availableData":I
    iget-boolean v2, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mEndOfStream:Z

    if-nez v2, :cond_2

    .line 131
    iget v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedDataArray:[Ljava/nio/ByteBuffer;

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 132
    iget-object v2, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedDataArray:[Ljava/nio/ByteBuffer;

    aget-object v2, v2, v1

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v2

    add-int/2addr v0, v2

    .line 131
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 134
    :cond_0
    iget-object v2, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->this$0:Lcom/amazon/communication/InputStreamMessageImpl;

    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->mInputStream:Ljava/io/InputStream;
    invoke-static {v2}, Lcom/amazon/communication/InputStreamMessageImpl;->access$100(Lcom/amazon/communication/InputStreamMessageImpl;)Ljava/io/InputStream;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/InputStream;->available()I

    move-result v2

    add-int/2addr v0, v2

    .line 139
    iget-object v2, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->this$0:Lcom/amazon/communication/InputStreamMessageImpl;

    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->mInputStream:Ljava/io/InputStream;
    invoke-static {v2}, Lcom/amazon/communication/InputStreamMessageImpl;->access$100(Lcom/amazon/communication/InputStreamMessageImpl;)Ljava/io/InputStream;

    move-result-object v2

    instance-of v2, v2, Lcom/amazon/communication/BetterInputStream;

    if-nez v2, :cond_1

    .line 140
    if-nez v0, :cond_1

    const/4 v0, 0x1

    .line 145
    .end local v1    # "i":I
    :cond_1
    :goto_1
    return v0

    .line 143
    :cond_2
    const/4 v0, 0x1

    goto :goto_1
.end method

.method public close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 153
    iget-object v0, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->this$0:Lcom/amazon/communication/InputStreamMessageImpl;

    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->mInputStream:Ljava/io/InputStream;
    invoke-static {v0}, Lcom/amazon/communication/InputStreamMessageImpl;->access$100(Lcom/amazon/communication/InputStreamMessageImpl;)Ljava/io/InputStream;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 154
    return-void
.end method

.method public read()I
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 51
    const/4 v0, -0x1

    .line 52
    .local v0, "data":I
    iget-boolean v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mEndOfStream:Z

    if-nez v1, :cond_1

    .line 53
    iget v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    iget-object v3, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedDataArray:[Ljava/nio/ByteBuffer;

    array-length v3, v3

    if-ge v1, v3, :cond_3

    .line 55
    :goto_0
    iget v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    iget-object v3, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedDataArray:[Ljava/nio/ByteBuffer;

    array-length v3, v3

    if-ge v1, v3, :cond_0

    iget-object v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedDataArray:[Ljava/nio/ByteBuffer;

    iget v3, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    aget-object v1, v1, v3

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v1

    if-nez v1, :cond_0

    .line 56
    iget v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    goto :goto_0

    .line 58
    :cond_0
    iget v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    iget-object v3, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedDataArray:[Ljava/nio/ByteBuffer;

    array-length v3, v3

    if-ge v1, v3, :cond_2

    .line 59
    iget-object v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedDataArray:[Ljava/nio/ByteBuffer;

    iget v3, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mPrependedReadIndex:I

    aget-object v1, v1, v3

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->get()B

    move-result v1

    and-int/lit16 v0, v1, 0xff

    .line 68
    :goto_1
    const/4 v1, -0x1

    if-ne v0, v1, :cond_4

    const/4 v1, 0x1

    :goto_2
    iput-boolean v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mEndOfStream:Z

    .line 73
    :cond_1
    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/communication/InputStreamMessageImpl;->access$200()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v1

    const-string/jumbo v3, "read"

    const-string/jumbo v4, "single-byte read; too many invocations may indicate inefficiency, and that bulk read operations should be used"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v1, v3, v4, v2}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 74
    return v0

    .line 62
    :cond_2
    iget-object v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->this$0:Lcom/amazon/communication/InputStreamMessageImpl;

    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->mInputStream:Ljava/io/InputStream;
    invoke-static {v1}, Lcom/amazon/communication/InputStreamMessageImpl;->access$100(Lcom/amazon/communication/InputStreamMessageImpl;)Ljava/io/InputStream;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/InputStream;->read()I

    move-result v0

    goto :goto_1

    .line 65
    :cond_3
    iget-object v1, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->this$0:Lcom/amazon/communication/InputStreamMessageImpl;

    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->mInputStream:Ljava/io/InputStream;
    invoke-static {v1}, Lcom/amazon/communication/InputStreamMessageImpl;->access$100(Lcom/amazon/communication/InputStreamMessageImpl;)Ljava/io/InputStream;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/InputStream;->read()I

    move-result v0

    goto :goto_1

    :cond_4
    move v1, v2

    .line 68
    goto :goto_2
.end method

.method public read([B)I
    .locals 2
    .param p1, "array"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 117
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->read([BII)I

    move-result v0

    return v0
.end method

.method public read([BII)I
    .locals 12
    .param p1, "array"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x4

    const/4 v9, 0x3

    const/4 v10, 0x2

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 79
    if-nez p1, :cond_0

    .line 80
    new-instance v2, Ljava/lang/NullPointerException;

    const-string/jumbo v3, "Array cannot be null"

    invoke-direct {v2, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 81
    :cond_0
    if-ltz p2, :cond_1

    array-length v4, p1

    if-ge p2, v4, :cond_1

    if-ltz p3, :cond_1

    add-int v4, p2, p3

    array-length v5, p1

    if-le v4, v5, :cond_2

    .line 83
    :cond_1
    new-instance v4, Ljava/lang/IndexOutOfBoundsException;

    const-string/jumbo v5, "read"

    const-string/jumbo v6, "array index out of bounds"

    const/4 v7, 0x6

    new-array v7, v7, [Ljava/lang/Object;

    const-string/jumbo v8, "array.length"

    aput-object v8, v7, v3

    array-length v3, p1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v7, v2

    const-string/jumbo v2, "offset"

    aput-object v2, v7, v10

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v7, v9

    const-string/jumbo v2, "length"

    aput-object v2, v7, v11

    const/4 v2, 0x5

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v7, v2

    invoke-static {v5, v6, v7}, Lcom/amazon/dp/logger/DPFormattedMessage;->toDPFormat(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v4, v2}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 84
    :cond_2
    if-nez p3, :cond_3

    .line 112
    :goto_0
    return v3

    .line 88
    :cond_3
    const/4 v0, -0x1

    .line 89
    .local v0, "bytesRead":I
    iget-boolean v4, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mEndOfStream:Z

    if-nez v4, :cond_5

    .line 90
    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/communication/InputStreamMessageImpl;->access$200()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v4

    const-string/jumbo v5, "read"

    const-string/jumbo v6, "reading with offset"

    const/4 v7, 0x6

    new-array v7, v7, [Ljava/lang/Object;

    const-string/jumbo v8, "array.length"

    aput-object v8, v7, v3

    array-length v8, p1

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v2

    const-string/jumbo v8, "length"

    aput-object v8, v7, v10

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v9

    const-string/jumbo v8, "offset"

    aput-object v8, v7, v11

    const/4 v8, 0x5

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 95
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->readFromPrepends([BII)I

    move-result v0

    .line 96
    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/communication/InputStreamMessageImpl;->access$200()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v4

    const-string/jumbo v5, "read"

    const-string/jumbo v6, "finished reading with offset"

    new-array v7, v10, [Ljava/lang/Object;

    const-string/jumbo v8, "bytesRead"

    aput-object v8, v7, v3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v2

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 98
    if-ge v0, p3, :cond_4

    .line 99
    iget-object v4, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->this$0:Lcom/amazon/communication/InputStreamMessageImpl;

    # getter for: Lcom/amazon/communication/InputStreamMessageImpl;->mInputStream:Ljava/io/InputStream;
    invoke-static {v4}, Lcom/amazon/communication/InputStreamMessageImpl;->access$100(Lcom/amazon/communication/InputStreamMessageImpl;)Ljava/io/InputStream;

    move-result-object v4

    add-int v5, p2, v0

    sub-int v6, p3, v0

    invoke-virtual {v4, p1, v5, v6}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    .line 102
    .local v1, "bytesReadFromStream":I
    const/4 v4, -0x1

    if-ne v1, v4, :cond_6

    :goto_1
    iput-boolean v2, p0, Lcom/amazon/communication/InputStreamMessageImpl$PayloadInputStream;->mEndOfStream:Z

    .line 103
    if-lez v1, :cond_4

    .line 104
    add-int/2addr v0, v1

    .line 108
    .end local v1    # "bytesReadFromStream":I
    :cond_4
    if-nez v0, :cond_5

    .line 109
    const/4 v0, -0x1

    :cond_5
    move v3, v0

    .line 112
    goto :goto_0

    .restart local v1    # "bytesReadFromStream":I
    :cond_6
    move v2, v3

    .line 102
    goto :goto_1
.end method
