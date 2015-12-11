.class final Lcom/a/a/a/a/l;
.super Lcom/a/a/a/a;
.source "SourceFile"


# static fields
.field private static final b:[B

.field private static final c:[B

.field private static final d:[B


# instance fields
.field private final e:[B

.field private final f:Ljava/io/OutputStream;

.field private final g:I

.field private final h:Ljava/io/ByteArrayOutputStream;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 268
    const/4 v0, 0x2

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/a/a/a/a/l;->b:[B

    .line 269
    const/16 v0, 0x10

    new-array v0, v0, [B

    fill-array-data v0, :array_1

    sput-object v0, Lcom/a/a/a/a/l;->c:[B

    .line 272
    const/4 v0, 0x5

    new-array v0, v0, [B

    fill-array-data v0, :array_2

    sput-object v0, Lcom/a/a/a/a/l;->d:[B

    return-void

    .line 268
    :array_0
    .array-data 1
        0xdt
        0xat
    .end array-data

    .line 269
    nop

    :array_1
    .array-data 1
        0x30t
        0x31t
        0x32t
        0x33t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x61t
        0x62t
        0x63t
        0x64t
        0x65t
        0x66t
    .end array-data

    .line 272
    :array_2
    .array-data 1
        0x30t
        0xdt
        0xat
        0xdt
        0xat
    .end array-data
.end method

.method private constructor <init>(Ljava/io/OutputStream;I)V
    .locals 3

    .prologue
    .line 281
    invoke-direct {p0}, Lcom/a/a/a/a;-><init>()V

    .line 275
    const/16 v0, 0xa

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    iput-object v0, p0, Lcom/a/a/a/a/l;->e:[B

    .line 282
    iput-object p1, p0, Lcom/a/a/a/a/l;->f:Ljava/io/OutputStream;

    .line 283
    const/4 v2, 0x1

    const/4 v1, 0x4

    add-int/lit8 v0, p2, -0x4

    :goto_0
    if-lez v0, :cond_0

    add-int/lit8 v1, v1, 0x1

    shr-int/lit8 v0, v0, 0x4

    goto :goto_0

    :cond_0
    sub-int v0, p2, v1

    invoke-static {v2, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Lcom/a/a/a/a/l;->g:I

    .line 284
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0, p2}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    iput-object v0, p0, Lcom/a/a/a/a/l;->h:Ljava/io/ByteArrayOutputStream;

    .line 285
    return-void

    .line 275
    nop

    :array_0
    .array-data 1
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0xdt
        0xat
    .end array-data
.end method

.method synthetic constructor <init>(Ljava/io/OutputStream;IB)V
    .locals 0

    .prologue
    .line 267
    invoke-direct {p0, p1, p2}, Lcom/a/a/a/a/l;-><init>(Ljava/io/OutputStream;I)V

    return-void
.end method

.method private a(I)V
    .locals 4

    .prologue
    .line 334
    const/16 v0, 0x8

    .line 336
    :cond_0
    iget-object v1, p0, Lcom/a/a/a/a/l;->e:[B

    add-int/lit8 v0, v0, -0x1

    sget-object v2, Lcom/a/a/a/a/l;->c:[B

    and-int/lit8 v3, p1, 0xf

    aget-byte v2, v2, v3

    aput-byte v2, v1, v0

    .line 337
    ushr-int/lit8 p1, p1, 0x4

    if-nez p1, :cond_0

    .line 338
    iget-object v1, p0, Lcom/a/a/a/a/l;->f:Ljava/io/OutputStream;

    iget-object v2, p0, Lcom/a/a/a/a/l;->e:[B

    iget-object v3, p0, Lcom/a/a/a/a/l;->e:[B

    array-length v3, v3

    sub-int/2addr v3, v0

    invoke-virtual {v1, v2, v0, v3}, Ljava/io/OutputStream;->write([BII)V

    .line 339
    return-void
.end method

.method private b()V
    .locals 2

    .prologue
    .line 359
    iget-object v0, p0, Lcom/a/a/a/a/l;->h:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v0

    .line 360
    if-gtz v0, :cond_0

    .line 368
    :goto_0
    return-void

    .line 364
    :cond_0
    invoke-direct {p0, v0}, Lcom/a/a/a/a/l;->a(I)V

    .line 365
    iget-object v0, p0, Lcom/a/a/a/a/l;->h:Ljava/io/ByteArrayOutputStream;

    iget-object v1, p0, Lcom/a/a/a/a/l;->f:Ljava/io/OutputStream;

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->writeTo(Ljava/io/OutputStream;)V

    .line 366
    iget-object v0, p0, Lcom/a/a/a/a/l;->h:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->reset()V

    .line 367
    iget-object v0, p0, Lcom/a/a/a/a/l;->f:Ljava/io/OutputStream;

    sget-object v1, Lcom/a/a/a/a/l;->b:[B

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write([B)V

    goto :goto_0
.end method


# virtual methods
.method public final declared-synchronized close()V
    .locals 2

    .prologue
    .line 350
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/a/a/a/a/l;->a:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 356
    :goto_0
    monitor-exit p0

    return-void

    .line 353
    :cond_0
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lcom/a/a/a/a/l;->a:Z

    .line 354
    invoke-direct {p0}, Lcom/a/a/a/a/l;->b()V

    .line 355
    iget-object v0, p0, Lcom/a/a/a/a/l;->f:Ljava/io/OutputStream;

    sget-object v1, Lcom/a/a/a/a/l;->d:[B

    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write([B)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 350
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized flush()V
    .locals 1

    .prologue
    .line 342
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/a/a/a/a/l;->a:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 347
    :goto_0
    monitor-exit p0

    return-void

    .line 345
    :cond_0
    :try_start_1
    invoke-direct {p0}, Lcom/a/a/a/a/l;->b()V

    .line 346
    iget-object v0, p0, Lcom/a/a/a/a/l;->f:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 342
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized write([BII)V
    .locals 3

    .prologue
    .line 302
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/a/a/a/a/l;->a()V

    .line 303
    array-length v0, p1

    invoke-static {v0, p2, p3}, Lcom/a/a/a/u;->a(III)V

    .line 305
    :goto_0
    if-lez p3, :cond_3

    .line 308
    iget-object v0, p0, Lcom/a/a/a/a/l;->h:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v0

    if-gtz v0, :cond_0

    iget v0, p0, Lcom/a/a/a/a/l;->g:I

    if-ge p3, v0, :cond_2

    .line 310
    :cond_0
    iget v0, p0, Lcom/a/a/a/a/l;->g:I

    iget-object v1, p0, Lcom/a/a/a/a/l;->h:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v1

    sub-int/2addr v0, v1

    invoke-static {p3, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 312
    iget-object v1, p0, Lcom/a/a/a/a/l;->h:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1, p1, p2, v0}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 313
    iget-object v1, p0, Lcom/a/a/a/a/l;->h:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v1

    iget v2, p0, Lcom/a/a/a/a/l;->g:I

    if-ne v1, v2, :cond_1

    .line 314
    invoke-direct {p0}, Lcom/a/a/a/a/l;->b()V

    .line 324
    :cond_1
    :goto_1
    add-int/2addr p2, v0

    .line 325
    sub-int/2addr p3, v0

    .line 326
    goto :goto_0

    .line 318
    :cond_2
    iget v0, p0, Lcom/a/a/a/a/l;->g:I

    .line 319
    invoke-direct {p0, v0}, Lcom/a/a/a/a/l;->a(I)V

    .line 320
    iget-object v1, p0, Lcom/a/a/a/a/l;->f:Ljava/io/OutputStream;

    invoke-virtual {v1, p1, p2, v0}, Ljava/io/OutputStream;->write([BII)V

    .line 321
    iget-object v1, p0, Lcom/a/a/a/a/l;->f:Ljava/io/OutputStream;

    sget-object v2, Lcom/a/a/a/a/l;->b:[B

    invoke-virtual {v1, v2}, Ljava/io/OutputStream;->write([B)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 302
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 327
    :cond_3
    monitor-exit p0

    return-void
.end method
