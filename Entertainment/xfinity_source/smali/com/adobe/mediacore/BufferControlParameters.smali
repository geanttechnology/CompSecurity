.class public final Lcom/adobe/mediacore/BufferControlParameters;
.super Ljava/lang/Object;


# instance fields
.field private _initialBufferTime:J

.field private _playBufferTime:J


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createDual(JJ)Lcom/adobe/mediacore/BufferControlParameters;
    .locals 4

    const-wide/16 v2, 0x0

    cmp-long v0, p0, v2

    if-lez v0, :cond_0

    cmp-long v0, p2, v2

    if-gtz v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The initial buffer time and the play buffer time must be bigger than zero."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    cmp-long v0, p0, p2

    if-lez v0, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The initial buffer time can\'t be bigger than the play buffer time."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    new-instance v0, Lcom/adobe/mediacore/BufferControlParameters;

    invoke-direct {v0}, Lcom/adobe/mediacore/BufferControlParameters;-><init>()V

    iput-wide p0, v0, Lcom/adobe/mediacore/BufferControlParameters;->_initialBufferTime:J

    iput-wide p2, v0, Lcom/adobe/mediacore/BufferControlParameters;->_playBufferTime:J

    return-object v0
.end method

.method public static createSimple(J)Lcom/adobe/mediacore/BufferControlParameters;
    .locals 2

    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    if-gtz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The buffer time must be bigger than zero."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    new-instance v0, Lcom/adobe/mediacore/BufferControlParameters;

    invoke-direct {v0}, Lcom/adobe/mediacore/BufferControlParameters;-><init>()V

    iput-wide p0, v0, Lcom/adobe/mediacore/BufferControlParameters;->_initialBufferTime:J

    iput-wide p0, v0, Lcom/adobe/mediacore/BufferControlParameters;->_playBufferTime:J

    return-object v0
.end method


# virtual methods
.method public getInitialBufferTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/BufferControlParameters;->_initialBufferTime:J

    return-wide v0
.end method

.method public getPlayBufferTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/BufferControlParameters;->_playBufferTime:J

    return-wide v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "BufferControlParameters { _initialBufferTime="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/adobe/mediacore/BufferControlParameters;->_initialBufferTime:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", _playBufferTime="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/adobe/mediacore/BufferControlParameters;->_playBufferTime:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
