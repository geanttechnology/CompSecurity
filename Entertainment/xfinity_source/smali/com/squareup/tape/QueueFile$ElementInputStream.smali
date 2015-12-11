.class final Lcom/squareup/tape/QueueFile$ElementInputStream;
.super Ljava/io/InputStream;
.source "QueueFile.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/tape/QueueFile;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "ElementInputStream"
.end annotation


# instance fields
.field private position:I

.field private remaining:I

.field final synthetic this$0:Lcom/squareup/tape/QueueFile;


# direct methods
.method private constructor <init>(Lcom/squareup/tape/QueueFile;Lcom/squareup/tape/QueueFile$Element;)V
    .locals 1
    .param p2, "element"    # Lcom/squareup/tape/QueueFile$Element;

    .prologue
    .line 452
    iput-object p1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->this$0:Lcom/squareup/tape/QueueFile;

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 453
    iget v0, p2, Lcom/squareup/tape/QueueFile$Element;->position:I

    add-int/lit8 v0, v0, 0x4

    # invokes: Lcom/squareup/tape/QueueFile;->wrapPosition(I)I
    invoke-static {p1, v0}, Lcom/squareup/tape/QueueFile;->access$100(Lcom/squareup/tape/QueueFile;I)I

    move-result v0

    iput v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->position:I

    .line 454
    iget v0, p2, Lcom/squareup/tape/QueueFile$Element;->length:I

    iput v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->remaining:I

    .line 455
    return-void
.end method

.method synthetic constructor <init>(Lcom/squareup/tape/QueueFile;Lcom/squareup/tape/QueueFile$Element;Lcom/squareup/tape/QueueFile$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/squareup/tape/QueueFile;
    .param p2, "x1"    # Lcom/squareup/tape/QueueFile$Element;
    .param p3, "x2"    # Lcom/squareup/tape/QueueFile$1;

    .prologue
    .line 448
    invoke-direct {p0, p1, p2}, Lcom/squareup/tape/QueueFile$ElementInputStream;-><init>(Lcom/squareup/tape/QueueFile;Lcom/squareup/tape/QueueFile$Element;)V

    return-void
.end method


# virtual methods
.method public read()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 474
    iget v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->remaining:I

    if-nez v1, :cond_0

    const/4 v0, -0x1

    .line 479
    :goto_0
    return v0

    .line 475
    :cond_0
    iget-object v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->this$0:Lcom/squareup/tape/QueueFile;

    iget-object v1, v1, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    iget v2, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->position:I

    int-to-long v2, v2

    invoke-virtual {v1, v2, v3}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 476
    iget-object v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->this$0:Lcom/squareup/tape/QueueFile;

    iget-object v1, v1, Lcom/squareup/tape/QueueFile;->raf:Ljava/io/RandomAccessFile;

    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->read()I

    move-result v0

    .line 477
    .local v0, "b":I
    iget-object v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->this$0:Lcom/squareup/tape/QueueFile;

    iget v2, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->position:I

    add-int/lit8 v2, v2, 0x1

    # invokes: Lcom/squareup/tape/QueueFile;->wrapPosition(I)I
    invoke-static {v1, v2}, Lcom/squareup/tape/QueueFile;->access$100(Lcom/squareup/tape/QueueFile;I)I

    move-result v1

    iput v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->position:I

    .line 478
    iget v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->remaining:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->remaining:I

    goto :goto_0
.end method

.method public read([BII)I
    .locals 2
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 458
    const-string v0, "buffer"

    # invokes: Lcom/squareup/tape/QueueFile;->nonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    invoke-static {p1, v0}, Lcom/squareup/tape/QueueFile;->access$200(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 459
    or-int v0, p2, p3

    if-ltz v0, :cond_0

    array-length v0, p1

    sub-int/2addr v0, p2

    if-le p3, v0, :cond_1

    .line 460
    :cond_0
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    .line 462
    :cond_1
    iget v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->remaining:I

    if-lez v0, :cond_3

    .line 463
    iget v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->remaining:I

    if-le p3, v0, :cond_2

    iget p3, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->remaining:I

    .line 464
    :cond_2
    iget-object v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->this$0:Lcom/squareup/tape/QueueFile;

    iget v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->position:I

    # invokes: Lcom/squareup/tape/QueueFile;->ringRead(I[BII)V
    invoke-static {v0, v1, p1, p2, p3}, Lcom/squareup/tape/QueueFile;->access$300(Lcom/squareup/tape/QueueFile;I[BII)V

    .line 465
    iget-object v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->this$0:Lcom/squareup/tape/QueueFile;

    iget v1, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->position:I

    add-int/2addr v1, p3

    # invokes: Lcom/squareup/tape/QueueFile;->wrapPosition(I)I
    invoke-static {v0, v1}, Lcom/squareup/tape/QueueFile;->access$100(Lcom/squareup/tape/QueueFile;I)I

    move-result v0

    iput v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->position:I

    .line 466
    iget v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->remaining:I

    sub-int/2addr v0, p3

    iput v0, p0, Lcom/squareup/tape/QueueFile$ElementInputStream;->remaining:I

    move v0, p3

    .line 469
    :goto_0
    return v0

    :cond_3
    const/4 v0, -0x1

    goto :goto_0
.end method
