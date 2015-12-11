.class public final Lcom/a/a/a/c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Closeable;


# static fields
.field static final a:Ljava/util/regex/Pattern;

.field private static final p:Ljava/io/OutputStream;


# instance fields
.field final b:Ljava/util/concurrent/ThreadPoolExecutor;

.field private final c:Ljava/io/File;

.field private final d:Ljava/io/File;

.field private final e:Ljava/io/File;

.field private final f:Ljava/io/File;

.field private final g:I

.field private h:J

.field private final i:I

.field private j:J

.field private k:Ljava/io/Writer;

.field private final l:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/a/a/a/h;",
            ">;"
        }
    .end annotation
.end field

.field private m:I

.field private n:J

.field private final o:Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 95
    const-string v0, "[a-z0-9_-]{1,64}"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/a/a/a/c;->a:Ljava/util/regex/Pattern;

    .line 709
    new-instance v0, Lcom/a/a/a/e;

    invoke-direct {v0}, Lcom/a/a/a/e;-><init>()V

    sput-object v0, Lcom/a/a/a/c;->p:Ljava/io/OutputStream;

    return-void
.end method

.method private constructor <init>(Ljava/io/File;J)V
    .locals 8

    .prologue
    const-wide/16 v4, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 180
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 148
    iput-wide v4, p0, Lcom/a/a/a/c;->j:J

    .line 150
    new-instance v0, Ljava/util/LinkedHashMap;

    const/high16 v1, 0x3f400000    # 0.75f

    invoke-direct {v0, v2, v1, v3}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    iput-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    .line 159
    iput-wide v4, p0, Lcom/a/a/a/c;->n:J

    .line 162
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v4, 0x3c

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v7}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v1 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    iput-object v1, p0, Lcom/a/a/a/c;->b:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 164
    new-instance v0, Lcom/a/a/a/d;

    invoke-direct {v0, p0}, Lcom/a/a/a/d;-><init>(Lcom/a/a/a/c;)V

    iput-object v0, p0, Lcom/a/a/a/c;->o:Ljava/util/concurrent/Callable;

    .line 181
    iput-object p1, p0, Lcom/a/a/a/c;->c:Ljava/io/File;

    .line 182
    const v0, 0x31191

    iput v0, p0, Lcom/a/a/a/c;->g:I

    .line 183
    new-instance v0, Ljava/io/File;

    const-string v1, "journal"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/a/a/a/c;->d:Ljava/io/File;

    .line 184
    new-instance v0, Ljava/io/File;

    const-string v1, "journal.tmp"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/a/a/a/c;->e:Ljava/io/File;

    .line 185
    new-instance v0, Ljava/io/File;

    const-string v1, "journal.bkp"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/a/a/a/c;->f:Ljava/io/File;

    .line 186
    const/4 v0, 0x2

    iput v0, p0, Lcom/a/a/a/c;->i:I

    .line 187
    iput-wide p2, p0, Lcom/a/a/a/c;->h:J

    .line 188
    return-void
.end method

.method public static a(Ljava/io/File;J)Lcom/a/a/a/c;
    .locals 7

    .prologue
    .line 201
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gtz v0, :cond_0

    .line 202
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "maxSize <= 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 204
    :cond_0
    new-instance v0, Ljava/io/File;

    const-string v1, "journal.bkp"

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 210
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 211
    new-instance v1, Ljava/io/File;

    const-string v2, "journal"

    invoke-direct {v1, p0, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 213
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 214
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 221
    :cond_1
    :goto_0
    new-instance v0, Lcom/a/a/a/c;

    invoke-direct {v0, p0, p1, p2}, Lcom/a/a/a/c;-><init>(Ljava/io/File;J)V

    .line 222
    iget-object v1, v0, Lcom/a/a/a/c;->d:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 224
    :try_start_0
    invoke-direct {v0}, Lcom/a/a/a/c;->b()V

    .line 225
    invoke-direct {v0}, Lcom/a/a/a/c;->c()V

    .line 226
    new-instance v1, Ljava/io/BufferedWriter;

    new-instance v2, Ljava/io/OutputStreamWriter;

    new-instance v3, Ljava/io/FileOutputStream;

    iget-object v4, v0, Lcom/a/a/a/c;->d:Ljava/io/File;

    const/4 v5, 0x1

    invoke-direct {v3, v4, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    sget-object v4, Lcom/a/a/a/u;->d:Ljava/nio/charset/Charset;

    invoke-direct {v2, v3, v4}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V

    invoke-direct {v1, v2}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    iput-object v1, v0, Lcom/a/a/a/c;->k:Ljava/io/Writer;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 240
    :goto_1
    return-object v0

    .line 216
    :cond_2
    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/a/a/a/c;->a(Ljava/io/File;Ljava/io/File;Z)V

    goto :goto_0

    .line 229
    :catch_0
    move-exception v1

    .line 230
    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "DiskLruCache "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is corrupt: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", removing"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/a/a/a/m;->a(Ljava/lang/String;)V

    .line 232
    invoke-virtual {v0}, Lcom/a/a/a/c;->close()V

    iget-object v0, v0, Lcom/a/a/a/c;->c:Ljava/io/File;

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/File;)V

    .line 237
    :cond_3
    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    .line 238
    new-instance v0, Lcom/a/a/a/c;

    invoke-direct {v0, p0, p1, p2}, Lcom/a/a/a/c;-><init>(Ljava/io/File;J)V

    .line 239
    invoke-direct {v0}, Lcom/a/a/a/c;->d()V

    goto :goto_1
.end method

.method public static synthetic a(Lcom/a/a/a/c;Ljava/lang/String;J)Lcom/a/a/a/f;
    .locals 2

    .prologue
    .line 88
    invoke-virtual {p0, p1, p2, p3}, Lcom/a/a/a/c;->a(Ljava/lang/String;J)Lcom/a/a/a/f;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a()Ljava/io/OutputStream;
    .locals 1

    .prologue
    .line 88
    sget-object v0, Lcom/a/a/a/c;->p:Ljava/io/OutputStream;

    return-object v0
.end method

.method static synthetic a(Lcom/a/a/a/c;)Ljava/io/Writer;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    return-object v0
.end method

.method static synthetic a(Lcom/a/a/a/c;Lcom/a/a/a/f;Z)V
    .locals 0

    .prologue
    .line 88
    invoke-direct {p0, p1, p2}, Lcom/a/a/a/c;->a(Lcom/a/a/a/f;Z)V

    return-void
.end method

.method private declared-synchronized a(Lcom/a/a/a/f;Z)V
    .locals 10

    .prologue
    const/4 v0, 0x0

    .line 505
    monitor-enter p0

    :try_start_0
    iget-object v2, p1, Lcom/a/a/a/f;->a:Lcom/a/a/a/h;

    .line 506
    iget-object v1, v2, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    if-eq v1, p1, :cond_0

    .line 507
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 505
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 511
    :cond_0
    if-eqz p2, :cond_4

    :try_start_1
    iget-boolean v1, v2, Lcom/a/a/a/h;->c:Z

    if-nez v1, :cond_4

    move v1, v0

    .line 512
    :goto_0
    iget v3, p0, Lcom/a/a/a/c;->i:I

    if-ge v1, v3, :cond_4

    .line 513
    iget-object v3, p1, Lcom/a/a/a/f;->b:[Z

    aget-boolean v3, v3, v1

    if-nez v3, :cond_1

    .line 514
    invoke-virtual {p1}, Lcom/a/a/a/f;->b()V

    .line 515
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Newly created entry didn\'t create value for index "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 517
    :cond_1
    invoke-virtual {v2, v1}, Lcom/a/a/a/h;->b(I)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-nez v3, :cond_3

    .line 518
    invoke-virtual {p1}, Lcom/a/a/a/f;->b()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 557
    :cond_2
    :goto_1
    monitor-exit p0

    return-void

    .line 512
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 524
    :cond_4
    :goto_2
    :try_start_2
    iget v1, p0, Lcom/a/a/a/c;->i:I

    if-ge v0, v1, :cond_7

    .line 525
    invoke-virtual {v2, v0}, Lcom/a/a/a/h;->b(I)Ljava/io/File;

    move-result-object v1

    .line 526
    if-eqz p2, :cond_6

    .line 527
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 528
    invoke-virtual {v2, v0}, Lcom/a/a/a/h;->a(I)Ljava/io/File;

    move-result-object v3

    .line 529
    invoke-virtual {v1, v3}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 530
    iget-object v1, v2, Lcom/a/a/a/h;->b:[J

    aget-wide v4, v1, v0

    .line 531
    invoke-virtual {v3}, Ljava/io/File;->length()J

    move-result-wide v6

    .line 532
    iget-object v1, v2, Lcom/a/a/a/h;->b:[J

    aput-wide v6, v1, v0

    .line 533
    iget-wide v8, p0, Lcom/a/a/a/c;->j:J

    sub-long v4, v8, v4

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/a/a/a/c;->j:J

    .line 524
    :cond_5
    :goto_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 536
    :cond_6
    invoke-static {v1}, Lcom/a/a/a/c;->a(Ljava/io/File;)V

    goto :goto_3

    .line 540
    :cond_7
    iget v0, p0, Lcom/a/a/a/c;->m:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/a/a/a/c;->m:I

    .line 541
    const/4 v0, 0x0

    iput-object v0, v2, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    .line 542
    iget-boolean v0, v2, Lcom/a/a/a/h;->c:Z

    or-int/2addr v0, p2

    if-eqz v0, :cond_a

    .line 543
    const/4 v0, 0x1

    iput-boolean v0, v2, Lcom/a/a/a/h;->c:Z

    .line 544
    iget-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "CLEAN "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, v2, Lcom/a/a/a/h;->a:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v2}, Lcom/a/a/a/h;->a()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v3, 0xa

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 545
    if-eqz p2, :cond_8

    .line 546
    iget-wide v0, p0, Lcom/a/a/a/c;->n:J

    const-wide/16 v4, 0x1

    add-long/2addr v4, v0

    iput-wide v4, p0, Lcom/a/a/a/c;->n:J

    iput-wide v0, v2, Lcom/a/a/a/h;->e:J

    .line 552
    :cond_8
    :goto_4
    iget-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    invoke-virtual {v0}, Ljava/io/Writer;->flush()V

    .line 554
    iget-wide v0, p0, Lcom/a/a/a/c;->j:J

    iget-wide v2, p0, Lcom/a/a/a/c;->h:J

    cmp-long v0, v0, v2

    if-gtz v0, :cond_9

    invoke-direct {p0}, Lcom/a/a/a/c;->e()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 555
    :cond_9
    iget-object v0, p0, Lcom/a/a/a/c;->b:Ljava/util/concurrent/ThreadPoolExecutor;

    iget-object v1, p0, Lcom/a/a/a/c;->o:Ljava/util/concurrent/Callable;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    goto/16 :goto_1

    .line 549
    :cond_a
    iget-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    iget-object v1, v2, Lcom/a/a/a/h;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 550
    iget-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "REMOVE "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, v2, Lcom/a/a/a/h;->a:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0xa

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_4
.end method

.method private static a(Ljava/io/File;)V
    .locals 1

    .prologue
    .line 381
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result v0

    if-nez v0, :cond_0

    .line 382
    new-instance v0, Ljava/io/IOException;

    invoke-direct {v0}, Ljava/io/IOException;-><init>()V

    throw v0

    .line 384
    :cond_0
    return-void
.end method

.method private static a(Ljava/io/File;Ljava/io/File;Z)V
    .locals 1

    .prologue
    .line 387
    if-eqz p2, :cond_0

    .line 388
    invoke-static {p1}, Lcom/a/a/a/c;->a(Ljava/io/File;)V

    .line 390
    :cond_0
    invoke-virtual {p0, p1}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 391
    new-instance v0, Ljava/io/IOException;

    invoke-direct {v0}, Ljava/io/IOException;-><init>()V

    throw v0

    .line 393
    :cond_1
    return-void
.end method

.method private b()V
    .locals 10

    .prologue
    const/4 v9, 0x5

    const/4 v0, 0x0

    const/4 v8, -0x1

    .line 244
    new-instance v3, Lcom/a/a/a/s;

    new-instance v1, Ljava/io/FileInputStream;

    iget-object v2, p0, Lcom/a/a/a/c;->d:Ljava/io/File;

    invoke-direct {v1, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    sget-object v2, Lcom/a/a/a/u;->d:Ljava/nio/charset/Charset;

    invoke-direct {v3, v1, v2}, Lcom/a/a/a/s;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    .line 246
    :try_start_0
    invoke-virtual {v3}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v1

    .line 247
    invoke-virtual {v3}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v2

    .line 248
    invoke-virtual {v3}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v4

    .line 249
    invoke-virtual {v3}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v5

    .line 250
    invoke-virtual {v3}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v6

    .line 251
    const-string v7, "libcore.io.DiskLruCache"

    invoke-virtual {v7, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    const-string v7, "1"

    invoke-virtual {v7, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    iget v7, p0, Lcom/a/a/a/c;->g:I

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget v4, p0, Lcom/a/a/a/c;->i:I

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    const-string v4, ""

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 256
    :cond_0
    new-instance v0, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v7, "unexpected journal header: ["

    invoke-direct {v4, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ", "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 271
    :catchall_0
    move-exception v0

    invoke-static {v3}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    throw v0

    :cond_1
    move v1, v0

    .line 263
    :goto_0
    :try_start_1
    invoke-virtual {v3}, Lcom/a/a/a/s;->a()Ljava/lang/String;

    move-result-object v4

    const/16 v0, 0x20

    invoke-virtual {v4, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v5

    if-ne v5, v8, :cond_2

    new-instance v0, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v5, "unexpected journal line: "

    invoke-direct {v2, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catch Ljava/io/EOFException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 266
    :catch_0
    move-exception v0

    :try_start_2
    iget-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->size()I

    move-result v0

    sub-int v0, v1, v0

    iput v0, p0, Lcom/a/a/a/c;->m:I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 271
    invoke-static {v3}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 272
    return-void

    .line 263
    :cond_2
    add-int/lit8 v0, v5, 0x1

    const/16 v2, 0x20

    :try_start_3
    invoke-virtual {v4, v2, v0}, Ljava/lang/String;->indexOf(II)I

    move-result v6

    if-ne v6, v8, :cond_4

    invoke-virtual {v4, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x6

    if-ne v5, v2, :cond_9

    const-string v2, "REMOVE"

    invoke-virtual {v4, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_9

    iget-object v2, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, v0}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 264
    :cond_3
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    .line 267
    goto :goto_0

    .line 263
    :cond_4
    invoke-virtual {v4, v0, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    move-object v2, v0

    :goto_2
    iget-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, v2}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/h;

    if-nez v0, :cond_5

    new-instance v0, Lcom/a/a/a/h;

    const/4 v7, 0x0

    invoke-direct {v0, p0, v2, v7}, Lcom/a/a/a/h;-><init>(Lcom/a/a/a/c;Ljava/lang/String;B)V

    iget-object v7, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v7, v2, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_5
    if-eq v6, v8, :cond_6

    if-ne v5, v9, :cond_6

    const-string v2, "CLEAN"

    invoke-virtual {v4, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    add-int/lit8 v2, v6, 0x1

    invoke-virtual {v4, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    const-string v4, " "

    invoke-virtual {v2, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x1

    iput-boolean v4, v0, Lcom/a/a/a/h;->c:Z

    const/4 v4, 0x0

    iput-object v4, v0, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    invoke-virtual {v0, v2}, Lcom/a/a/a/h;->a([Ljava/lang/String;)V

    goto :goto_1

    :cond_6
    if-ne v6, v8, :cond_7

    if-ne v5, v9, :cond_7

    const-string v2, "DIRTY"

    invoke-virtual {v4, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    new-instance v2, Lcom/a/a/a/f;

    const/4 v4, 0x0

    invoke-direct {v2, p0, v0, v4}, Lcom/a/a/a/f;-><init>(Lcom/a/a/a/c;Lcom/a/a/a/h;B)V

    iput-object v2, v0, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    goto :goto_1

    :cond_7
    if-ne v6, v8, :cond_8

    const/4 v0, 0x4

    if-ne v5, v0, :cond_8

    const-string v0, "READ"

    invoke-virtual {v4, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    :cond_8
    new-instance v0, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v5, "unexpected journal line: "

    invoke-direct {v2, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_3
    .catch Ljava/io/EOFException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :cond_9
    move-object v2, v0

    goto :goto_2
.end method

.method static synthetic b(Lcom/a/a/a/c;)V
    .locals 0

    .prologue
    .line 88
    invoke-direct {p0}, Lcom/a/a/a/c;->g()V

    return-void
.end method

.method private c()V
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 319
    iget-object v0, p0, Lcom/a/a/a/c;->e:Ljava/io/File;

    invoke-static {v0}, Lcom/a/a/a/c;->a(Ljava/io/File;)V

    .line 320
    iget-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 321
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/h;

    .line 322
    iget-object v1, v0, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    if-nez v1, :cond_1

    move v1, v2

    .line 323
    :goto_1
    iget v4, p0, Lcom/a/a/a/c;->i:I

    if-ge v1, v4, :cond_0

    .line 324
    iget-wide v4, p0, Lcom/a/a/a/c;->j:J

    iget-object v6, v0, Lcom/a/a/a/h;->b:[J

    aget-wide v6, v6, v1

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/a/a/a/c;->j:J

    .line 323
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 327
    :cond_1
    const/4 v1, 0x0

    iput-object v1, v0, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    move v1, v2

    .line 328
    :goto_2
    iget v4, p0, Lcom/a/a/a/c;->i:I

    if-ge v1, v4, :cond_2

    .line 329
    invoke-virtual {v0, v1}, Lcom/a/a/a/h;->a(I)Ljava/io/File;

    move-result-object v4

    invoke-static {v4}, Lcom/a/a/a/c;->a(Ljava/io/File;)V

    .line 330
    invoke-virtual {v0, v1}, Lcom/a/a/a/h;->b(I)Ljava/io/File;

    move-result-object v4

    invoke-static {v4}, Lcom/a/a/a/c;->a(Ljava/io/File;)V

    .line 328
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 332
    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 335
    :cond_3
    return-void
.end method

.method private static c(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 654
    sget-object v0, Lcom/a/a/a/c;->a:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 655
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-nez v0, :cond_0

    .line 656
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "keys must match regex [a-z0-9_-]{1,64}: \""

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 658
    :cond_0
    return-void
.end method

.method static synthetic c(Lcom/a/a/a/c;)Z
    .locals 1

    .prologue
    .line 88
    invoke-direct {p0}, Lcom/a/a/a/c;->e()Z

    move-result v0

    return v0
.end method

.method private declared-synchronized d()V
    .locals 5

    .prologue
    .line 342
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    if-eqz v0, :cond_0

    .line 343
    iget-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    invoke-virtual {v0}, Ljava/io/Writer;->close()V

    .line 346
    :cond_0
    new-instance v1, Ljava/io/BufferedWriter;

    new-instance v0, Ljava/io/OutputStreamWriter;

    new-instance v2, Ljava/io/FileOutputStream;

    iget-object v3, p0, Lcom/a/a/a/c;->e:Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    sget-object v3, Lcom/a/a/a/u;->d:Ljava/nio/charset/Charset;

    invoke-direct {v0, v2, v3}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V

    invoke-direct {v1, v0}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 349
    :try_start_1
    const-string v0, "libcore.io.DiskLruCache"

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 350
    const-string v0, "\n"

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 351
    const-string v0, "1"

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 352
    const-string v0, "\n"

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 353
    iget v0, p0, Lcom/a/a/a/c;->g:I

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 354
    const-string v0, "\n"

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 355
    iget v0, p0, Lcom/a/a/a/c;->i:I

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 356
    const-string v0, "\n"

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 357
    const-string v0, "\n"

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 359
    iget-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/h;

    .line 360
    iget-object v3, v0, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    if-eqz v3, :cond_1

    .line 361
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "DIRTY "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v0, v0, Lcom/a/a/a/h;->a:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v3, 0xa

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 367
    :catchall_0
    move-exception v0

    :try_start_2
    invoke-virtual {v1}, Ljava/io/Writer;->close()V

    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 342
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0

    .line 363
    :cond_1
    :try_start_3
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "CLEAN "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, v0, Lcom/a/a/a/h;->a:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/a/a/a/h;->a()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v3, 0xa

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 367
    :cond_2
    :try_start_4
    invoke-virtual {v1}, Ljava/io/Writer;->close()V

    .line 370
    iget-object v0, p0, Lcom/a/a/a/c;->d:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 371
    iget-object v0, p0, Lcom/a/a/a/c;->d:Ljava/io/File;

    iget-object v1, p0, Lcom/a/a/a/c;->f:Ljava/io/File;

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/a/a/a/c;->a(Ljava/io/File;Ljava/io/File;Z)V

    .line 373
    :cond_3
    iget-object v0, p0, Lcom/a/a/a/c;->e:Ljava/io/File;

    iget-object v1, p0, Lcom/a/a/a/c;->d:Ljava/io/File;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/a/a/a/c;->a(Ljava/io/File;Ljava/io/File;Z)V

    .line 374
    iget-object v0, p0, Lcom/a/a/a/c;->f:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 376
    new-instance v0, Ljava/io/BufferedWriter;

    new-instance v1, Ljava/io/OutputStreamWriter;

    new-instance v2, Ljava/io/FileOutputStream;

    iget-object v3, p0, Lcom/a/a/a/c;->d:Ljava/io/File;

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    sget-object v3, Lcom/a/a/a/u;->d:Ljava/nio/charset/Charset;

    invoke-direct {v1, v2, v3}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V

    invoke-direct {v0, v1}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    iput-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 378
    monitor-exit p0

    return-void
.end method

.method static synthetic d(Lcom/a/a/a/c;)V
    .locals 0

    .prologue
    .line 88
    invoke-direct {p0}, Lcom/a/a/a/c;->d()V

    return-void
.end method

.method static synthetic e(Lcom/a/a/a/c;)I
    .locals 1

    .prologue
    .line 88
    const/4 v0, 0x0

    iput v0, p0, Lcom/a/a/a/c;->m:I

    return v0
.end method

.method private e()Z
    .locals 2

    .prologue
    .line 564
    iget v0, p0, Lcom/a/a/a/c;->m:I

    const/16 v1, 0x7d0

    if-lt v0, v1, :cond_0

    iget v0, p0, Lcom/a/a/a/c;->m:I

    iget-object v1, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->size()I

    move-result v1

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic f(Lcom/a/a/a/c;)I
    .locals 1

    .prologue
    .line 88
    iget v0, p0, Lcom/a/a/a/c;->i:I

    return v0
.end method

.method private f()V
    .locals 2

    .prologue
    .line 609
    iget-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    if-nez v0, :cond_0

    .line 610
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "cache is closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 612
    :cond_0
    return-void
.end method

.method static synthetic g(Lcom/a/a/a/c;)Ljava/io/File;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/a/a/a/c;->c:Ljava/io/File;

    return-object v0
.end method

.method private g()V
    .locals 4

    .prologue
    .line 637
    :goto_0
    iget-wide v0, p0, Lcom/a/a/a/c;->j:J

    iget-wide v2, p0, Lcom/a/a/a/c;->h:J

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 638
    iget-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 639
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/a/a/a/c;->b(Ljava/lang/String;)Z

    goto :goto_0

    .line 641
    :cond_0
    return-void
.end method


# virtual methods
.method public final declared-synchronized a(Ljava/lang/String;J)Lcom/a/a/a/f;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 450
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/a/a/a/c;->f()V

    .line 451
    invoke-static {p1}, Lcom/a/a/a/c;->c(Ljava/lang/String;)V

    .line 452
    iget-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/h;

    .line 453
    const-wide/16 v2, -0x1

    cmp-long v2, p2, v2

    if-eqz v2, :cond_1

    if-eqz v0, :cond_0

    iget-wide v2, v0, Lcom/a/a/a/h;->e:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    cmp-long v2, v2, p2

    if-eqz v2, :cond_1

    :cond_0
    move-object v0, v1

    .line 470
    :goto_0
    monitor-exit p0

    return-object v0

    .line 457
    :cond_1
    if-nez v0, :cond_2

    .line 458
    :try_start_1
    new-instance v0, Lcom/a/a/a/h;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/a/a/a/h;-><init>(Lcom/a/a/a/c;Ljava/lang/String;B)V

    .line 459
    iget-object v1, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v1, v0

    .line 464
    :goto_1
    new-instance v0, Lcom/a/a/a/f;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v2}, Lcom/a/a/a/f;-><init>(Lcom/a/a/a/c;Lcom/a/a/a/h;B)V

    .line 465
    iput-object v0, v1, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    .line 468
    iget-object v1, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "DIRTY "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 469
    iget-object v1, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    invoke-virtual {v1}, Ljava/io/Writer;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 450
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 460
    :cond_2
    :try_start_2
    iget-object v2, v0, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    if-eqz v2, :cond_3

    move-object v0, v1

    .line 461
    goto :goto_0

    :cond_3
    move-object v1, v0

    goto :goto_1
.end method

.method public final declared-synchronized a(Ljava/lang/String;)Lcom/a/a/a/i;
    .locals 9

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 401
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/a/a/a/c;->f()V

    .line 402
    invoke-static {p1}, Lcom/a/a/a/c;->c(Ljava/lang/String;)V

    .line 403
    iget-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/h;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 404
    if-nez v0, :cond_1

    .line 438
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v1

    .line 408
    :cond_1
    :try_start_1
    iget-boolean v3, v0, Lcom/a/a/a/h;->c:Z

    if-eqz v3, :cond_0

    .line 415
    iget v3, p0, Lcom/a/a/a/c;->i:I

    new-array v6, v3, [Ljava/io/InputStream;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move v3, v2

    .line 417
    :goto_1
    :try_start_2
    iget v4, p0, Lcom/a/a/a/c;->i:I

    if-ge v3, v4, :cond_2

    .line 418
    new-instance v4, Ljava/io/FileInputStream;

    invoke-virtual {v0, v3}, Lcom/a/a/a/h;->a(I)Ljava/io/File;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    aput-object v4, v6, v3
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 417
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 422
    :catch_0
    move-exception v0

    move v0, v2

    :goto_2
    :try_start_3
    iget v2, p0, Lcom/a/a/a/c;->i:I

    if-ge v0, v2, :cond_0

    .line 423
    aget-object v2, v6, v0

    if-eqz v2, :cond_0

    .line 424
    aget-object v2, v6, v0

    invoke-static {v2}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 422
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 432
    :cond_2
    iget v1, p0, Lcom/a/a/a/c;->m:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/a/a/a/c;->m:I

    .line 433
    iget-object v1, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "READ "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 434
    invoke-direct {p0}, Lcom/a/a/a/c;->e()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 435
    iget-object v1, p0, Lcom/a/a/a/c;->b:Ljava/util/concurrent/ThreadPoolExecutor;

    iget-object v2, p0, Lcom/a/a/a/c;->o:Ljava/util/concurrent/Callable;

    invoke-virtual {v1, v2}, Ljava/util/concurrent/ThreadPoolExecutor;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 438
    :cond_3
    new-instance v1, Lcom/a/a/a/i;

    iget-wide v4, v0, Lcom/a/a/a/h;->e:J

    iget-object v7, v0, Lcom/a/a/a/h;->b:[J

    const/4 v8, 0x0

    move-object v2, p0

    move-object v3, p1

    invoke-direct/range {v1 .. v8}, Lcom/a/a/a/i;-><init>(Lcom/a/a/a/c;Ljava/lang/String;J[Ljava/io/InputStream;[JB)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 401
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized b(Ljava/lang/String;)Z
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 576
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/a/a/a/c;->f()V

    .line 577
    invoke-static {p1}, Lcom/a/a/a/c;->c(Ljava/lang/String;)V

    .line 578
    iget-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/h;

    .line 579
    if-eqz v0, :cond_0

    iget-object v2, v0, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v2, :cond_2

    :cond_0
    move v0, v1

    .line 600
    :goto_0
    monitor-exit p0

    return v0

    .line 588
    :cond_1
    :try_start_1
    iget-wide v2, p0, Lcom/a/a/a/c;->j:J

    iget-object v4, v0, Lcom/a/a/a/h;->b:[J

    aget-wide v4, v4, v1

    sub-long/2addr v2, v4

    iput-wide v2, p0, Lcom/a/a/a/c;->j:J

    .line 589
    iget-object v2, v0, Lcom/a/a/a/h;->b:[J

    const-wide/16 v4, 0x0

    aput-wide v4, v2, v1

    .line 583
    add-int/lit8 v1, v1, 0x1

    :cond_2
    iget v2, p0, Lcom/a/a/a/c;->i:I

    if-ge v1, v2, :cond_3

    .line 584
    invoke-virtual {v0, v1}, Lcom/a/a/a/h;->a(I)Ljava/io/File;

    move-result-object v2

    .line 585
    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_1

    .line 586
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "failed to delete "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 576
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 592
    :cond_3
    :try_start_2
    iget v0, p0, Lcom/a/a/a/c;->m:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/a/a/a/c;->m:I

    .line 593
    iget-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "REMOVE "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0xa

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 594
    iget-object v0, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v0, p1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 596
    invoke-direct {p0}, Lcom/a/a/a/c;->e()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 597
    iget-object v0, p0, Lcom/a/a/a/c;->b:Ljava/util/concurrent/ThreadPoolExecutor;

    iget-object v1, p0, Lcom/a/a/a/c;->o:Ljava/util/concurrent/Callable;

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 600
    :cond_4
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public final declared-synchronized close()V
    .locals 3

    .prologue
    .line 623
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    .line 634
    :goto_0
    monitor-exit p0

    return-void

    .line 626
    :cond_0
    :try_start_1
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/a/a/a/c;->l:Ljava/util/LinkedHashMap;

    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/a/a/h;

    .line 627
    iget-object v2, v0, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    if-eqz v2, :cond_1

    .line 628
    iget-object v0, v0, Lcom/a/a/a/h;->d:Lcom/a/a/a/f;

    invoke-virtual {v0}, Lcom/a/a/a/f;->b()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 623
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 631
    :cond_2
    :try_start_2
    invoke-direct {p0}, Lcom/a/a/a/c;->g()V

    .line 632
    iget-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;

    invoke-virtual {v0}, Ljava/io/Writer;->close()V

    .line 633
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/a/a/a/c;->k:Ljava/io/Writer;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method
