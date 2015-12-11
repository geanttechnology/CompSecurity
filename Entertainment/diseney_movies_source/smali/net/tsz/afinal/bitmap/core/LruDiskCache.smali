.class public final Lnet/tsz/afinal/bitmap/core/LruDiskCache;
.super Ljava/lang/Object;
.source "LruDiskCache.java"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;,
        Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;,
        Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    }
.end annotation


# static fields
.field static final ANY_SEQUENCE_NUMBER:J = -0x1L

.field private static final CLEAN:Ljava/lang/String; = "CLEAN"

.field private static final DIRTY:Ljava/lang/String; = "DIRTY"

.field private static final IO_BUFFER_SIZE:I = 0x2000

.field static final JOURNAL_FILE:Ljava/lang/String; = "journal"

.field static final JOURNAL_FILE_TMP:Ljava/lang/String; = "journal.tmp"

.field static final MAGIC:Ljava/lang/String; = "libcore.io.DiskLruCache"

.field private static final READ:Ljava/lang/String; = "READ"

.field private static final REMOVE:Ljava/lang/String; = "REMOVE"

.field private static final UTF_8:Ljava/nio/charset/Charset;

.field static final VERSION_1:Ljava/lang/String; = "1"


# instance fields
.field private final appVersion:I

.field private final cleanupCallable:Ljava/util/concurrent/Callable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Callable",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field

.field private final directory:Ljava/io/File;

.field private final executorService:Ljava/util/concurrent/ExecutorService;

.field private final journalFile:Ljava/io/File;

.field private final journalFileTmp:Ljava/io/File;

.field private journalWriter:Ljava/io/Writer;

.field private final lruEntries:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;",
            ">;"
        }
    .end annotation
.end field

.field private final maxSize:J

.field private nextSequenceNumber:J

.field private redundantOpCount:I

.field private size:J

.field private final valueCount:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 104
    const-string v0, "UTF-8"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->UTF_8:Ljava/nio/charset/Charset;

    .line 105
    return-void
.end method

.method private constructor <init>(Ljava/io/File;IIJ)V
    .locals 7
    .param p1, "directory"    # Ljava/io/File;
    .param p2, "appVersion"    # I
    .param p3, "valueCount"    # I
    .param p4, "maxSize"    # J

    .prologue
    const-wide/16 v4, 0x0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 282
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 153
    iput-wide v4, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->size:J

    .line 156
    new-instance v0, Ljava/util/LinkedHashMap;

    const/high16 v3, 0x3f400000    # 0.75f

    invoke-direct {v0, v1, v3, v2}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    iput-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    .line 164
    iput-wide v4, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->nextSequenceNumber:J

    .line 264
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    .line 265
    const-wide/16 v3, 0x3c

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    iput-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->executorService:Ljava/util/concurrent/ExecutorService;

    .line 266
    new-instance v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;

    invoke-direct {v0, p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$1;-><init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)V

    iput-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    .line 283
    iput-object p1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->directory:Ljava/io/File;

    .line 284
    iput p2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->appVersion:I

    .line 285
    new-instance v0, Ljava/io/File;

    const-string v1, "journal"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalFile:Ljava/io/File;

    .line 286
    new-instance v0, Ljava/io/File;

    const-string v1, "journal.tmp"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalFileTmp:Ljava/io/File;

    .line 287
    iput p3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    .line 288
    iput-wide p4, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->maxSize:J

    .line 289
    return-void
.end method

.method static synthetic access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)Ljava/io/Writer;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    return-object v0
.end method

.method static synthetic access$1(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 693
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->trimToSize()V

    return-void
.end method

.method static synthetic access$10(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)Ljava/io/File;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->directory:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)Z
    .locals 1

    .prologue
    .line 614
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalRebuildRequired()Z

    move-result v0

    return v0
.end method

.method static synthetic access$3(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 421
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->rebuildJournal()V

    return-void
.end method

.method static synthetic access$4(Lnet/tsz/afinal/bitmap/core/LruDiskCache;I)V
    .locals 0

    .prologue
    .line 157
    iput p1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->redundantOpCount:I

    return-void
.end method

.method static synthetic access$5(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Ljava/lang/String;J)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 512
    invoke-direct {p0, p1, p2, p3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->edit(Ljava/lang/String;J)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$6(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 718
    invoke-static {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$7()Ljava/nio/charset/Charset;
    .locals 1

    .prologue
    .line 104
    sget-object v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->UTF_8:Ljava/nio/charset/Charset;

    return-object v0
.end method

.method static synthetic access$8(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Z)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 560
    invoke-direct {p0, p1, p2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->completeEdit(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Z)V

    return-void
.end method

.method static synthetic access$9(Lnet/tsz/afinal/bitmap/core/LruDiskCache;)I
    .locals 1

    .prologue
    .line 152
    iget v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    return v0
.end method

.method private checkNotClosed()V
    .locals 2

    .prologue
    .line 662
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    if-nez v0, :cond_0

    .line 663
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "cache is closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 665
    :cond_0
    return-void
.end method

.method public static closeQuietly(Ljava/io/Closeable;)V
    .locals 2
    .param p0, "closeable"    # Ljava/io/Closeable;

    .prologue
    .line 233
    if-eqz p0, :cond_0

    .line 235
    :try_start_0
    invoke-interface {p0}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 241
    :cond_0
    :goto_0
    return-void

    .line 236
    :catch_0
    move-exception v0

    .line 237
    .local v0, "rethrown":Ljava/lang/RuntimeException;
    throw v0

    .line 238
    .end local v0    # "rethrown":Ljava/lang/RuntimeException;
    :catch_1
    move-exception v1

    goto :goto_0
.end method

.method private declared-synchronized completeEdit(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;Z)V
    .locals 12
    .param p1, "editor"    # Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    .param p2, "success"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 561
    monitor-enter p0

    :try_start_0
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->entry:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    invoke-static {p1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->access$2(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    move-result-object v2

    .line 562
    .local v2, "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->currentEditor:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v8

    if-eq v8, p1, :cond_0

    .line 563
    new-instance v8, Ljava/lang/IllegalStateException;

    invoke-direct {v8}, Ljava/lang/IllegalStateException;-><init>()V

    throw v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 561
    .end local v2    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    :catchall_0
    move-exception v8

    monitor-exit p0

    throw v8

    .line 567
    .restart local v2    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    :cond_0
    if-eqz p2, :cond_1

    :try_start_1
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->readable:Z
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$1(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 568
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    iget v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    if-lt v3, v8, :cond_5

    .line 576
    .end local v3    # "i":I
    :cond_1
    const/4 v3, 0x0

    .restart local v3    # "i":I
    :goto_1
    iget v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    if-lt v3, v8, :cond_7

    .line 592
    iget v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->redundantOpCount:I

    add-int/lit8 v8, v8, 0x1

    iput v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->redundantOpCount:I

    .line 593
    const/4 v8, 0x0

    invoke-static {v2, v8}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$5(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;)V

    .line 594
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->readable:Z
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$1(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Z

    move-result v8

    or-int/2addr v8, p2

    if-eqz v8, :cond_a

    .line 595
    const/4 v8, 0x1

    invoke-static {v2, v8}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$4(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;Z)V

    .line 596
    iget-object v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "CLEAN "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->key:Ljava/lang/String;
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$2(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getLengths()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const/16 v10, 0xa

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 597
    if-eqz p2, :cond_2

    .line 598
    iget-wide v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->nextSequenceNumber:J

    const-wide/16 v10, 0x1

    add-long/2addr v10, v8

    iput-wide v10, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->nextSequenceNumber:J

    invoke-static {v2, v8, v9}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$9(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;J)V

    .line 605
    :cond_2
    :goto_2
    iget-wide v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->size:J

    iget-wide v10, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->maxSize:J

    cmp-long v8, v8, v10

    if-gtz v8, :cond_3

    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalRebuildRequired()Z

    move-result v8

    if-eqz v8, :cond_4

    .line 606
    :cond_3
    iget-object v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v9, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v8, v9}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 608
    :cond_4
    monitor-exit p0

    return-void

    .line 569
    :cond_5
    :try_start_2
    invoke-virtual {v2, v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v8

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_6

    .line 570
    invoke-virtual {p1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->abort()V

    .line 571
    new-instance v8, Ljava/lang/IllegalStateException;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "edit didn\'t create file "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 568
    :cond_6
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_0

    .line 577
    :cond_7
    invoke-virtual {v2, v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v1

    .line 578
    .local v1, "dirty":Ljava/io/File;
    if-eqz p2, :cond_9

    .line 579
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_8

    .line 580
    invoke-virtual {v2, v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v0

    .line 581
    .local v0, "clean":Ljava/io/File;
    invoke-virtual {v1, v0}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 582
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->lengths:[J
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$7(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)[J

    move-result-object v8

    aget-wide v6, v8, v3

    .line 583
    .local v6, "oldLength":J
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v4

    .line 584
    .local v4, "newLength":J
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->lengths:[J
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$7(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)[J

    move-result-object v8

    aput-wide v4, v8, v3

    .line 585
    iget-wide v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->size:J

    sub-long/2addr v8, v6

    add-long/2addr v8, v4

    iput-wide v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->size:J

    .line 576
    .end local v0    # "clean":Ljava/io/File;
    .end local v4    # "newLength":J
    .end local v6    # "oldLength":J
    :cond_8
    :goto_3
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_1

    .line 588
    :cond_9
    invoke-static {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->deleteIfExists(Ljava/io/File;)V

    goto :goto_3

    .line 601
    .end local v1    # "dirty":Ljava/io/File;
    :cond_a
    iget-object v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->key:Ljava/lang/String;
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$2(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 602
    iget-object v8, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "REMOVE "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->key:Ljava/lang/String;
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$2(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const/16 v10, 0xa

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_2
.end method

.method private static copyOfRange([Ljava/lang/Object;II)[Ljava/lang/Object;
    .locals 5
    .param p0, "original"    # [Ljava/lang/Object;
    .param p1, "start"    # I
    .param p2, "end"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;II)[TT;"
        }
    .end annotation

    .prologue
    .line 169
    array-length v1, p0

    .line 170
    .local v1, "originalLength":I
    if-le p1, p2, :cond_0

    .line 171
    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v4

    .line 173
    :cond_0
    if-ltz p1, :cond_1

    if-le p1, v1, :cond_2

    .line 174
    :cond_1
    new-instance v4, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v4}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v4

    .line 176
    :cond_2
    sub-int v3, p2, p1

    .line 177
    .local v3, "resultLength":I
    sub-int v4, v1, p1

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 179
    .local v0, "copyLength":I
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v4

    invoke-static {v4, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v2

    .line 178
    check-cast v2, [Ljava/lang/Object;

    .line 180
    .local v2, "result":[Ljava/lang/Object;
    const/4 v4, 0x0

    invoke-static {p0, p1, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 181
    return-object v2
.end method

.method public static deleteContents(Ljava/io/File;)V
    .locals 5
    .param p0, "dir"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 248
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v1

    .line 249
    .local v1, "files":[Ljava/io/File;
    if-nez v1, :cond_1

    .line 261
    :cond_0
    return-void

    .line 253
    :cond_1
    array-length v3, v1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v0, v1, v2

    .line 254
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 255
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->deleteContents(Ljava/io/File;)V

    .line 257
    :cond_2
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    move-result v4

    if-nez v4, :cond_3

    .line 258
    new-instance v2, Ljava/io/IOException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "failed to delete file: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 253
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private static deleteIfExists(Ljava/io/File;)V
    .locals 1
    .param p0, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 458
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result v0

    if-nez v0, :cond_0

    .line 459
    new-instance v0, Ljava/io/IOException;

    invoke-direct {v0}, Ljava/io/IOException;-><init>()V

    throw v0

    .line 461
    :cond_0
    return-void
.end method

.method private declared-synchronized edit(Ljava/lang/String;J)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    .locals 5
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "expectedSequenceNumber"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 513
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->checkNotClosed()V

    .line 514
    invoke-direct {p0, p1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->validateKey(Ljava/lang/String;)V

    .line 515
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    .line 516
    .local v1, "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    const-wide/16 v2, -0x1

    cmp-long v2, p2, v2

    if-eqz v2, :cond_1

    .line 517
    if-eqz v1, :cond_0

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->sequenceNumber:J
    invoke-static {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$8(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v2

    cmp-long v2, v2, p2

    if-eqz v2, :cond_1

    .line 533
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v0

    .line 520
    :cond_1
    if-nez v1, :cond_3

    .line 521
    :try_start_1
    new-instance v1, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    .end local v1    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    const/4 v2, 0x0

    invoke-direct {v1, p0, p1, v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;-><init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)V

    .line 522
    .restart local v1    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 527
    :cond_2
    new-instance v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;-><init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;)V

    .line 528
    .local v0, "editor":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    invoke-static {v1, v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$5(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;)V

    .line 531
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "DIRTY "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 532
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v2}, Ljava/io/Writer;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 513
    .end local v0    # "editor":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    .end local v1    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 523
    .restart local v1    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    :cond_3
    :try_start_2
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->currentEditor:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    invoke-static {v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v2

    if-eqz v2, :cond_2

    goto :goto_0
.end method

.method private static inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 2
    .param p0, "in"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 719
    new-instance v0, Ljava/io/InputStreamReader;

    sget-object v1, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v0, p0, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->readFully(Ljava/io/Reader;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private journalRebuildRequired()Z
    .locals 3

    .prologue
    .line 615
    const/16 v0, 0x7d0

    .line 616
    .local v0, "REDUNDANT_OP_COMPACT_THRESHOLD":I
    iget v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->redundantOpCount:I

    const/16 v2, 0x7d0

    if-lt v1, v2, :cond_0

    .line 617
    iget v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->redundantOpCount:I

    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2}, Ljava/util/LinkedHashMap;->size()I

    move-result v2

    .line 616
    if-lt v1, v2, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static open(Ljava/io/File;IIJ)Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    .locals 8
    .param p0, "directory"    # Ljava/io/File;
    .param p1, "appVersion"    # I
    .param p2, "valueCount"    # I
    .param p3, "maxSize"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 303
    const-wide/16 v1, 0x0

    cmp-long v1, p3, v1

    if-gtz v1, :cond_0

    .line 304
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "maxSize <= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 306
    :cond_0
    if-gtz p2, :cond_1

    .line 307
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "valueCount <= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 309
    :cond_1
    if-eqz p0, :cond_2

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_2

    .line 310
    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    .line 312
    :cond_2
    new-instance v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;-><init>(Ljava/io/File;IIJ)V

    .line 313
    .local v0, "cache":Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    iget-object v1, v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalFile:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 315
    :try_start_0
    invoke-direct {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->readJournal()V

    .line 316
    invoke-direct {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->processJournal()V

    .line 317
    new-instance v1, Ljava/io/BufferedWriter;

    new-instance v2, Ljava/io/FileWriter;

    iget-object v3, v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalFile:Ljava/io/File;

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Ljava/io/FileWriter;-><init>(Ljava/io/File;Z)V

    .line 318
    const/16 v3, 0x2000

    invoke-direct {v1, v2, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    .line 317
    iput-object v1, v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v6, v0

    .line 331
    .end local v0    # "cache":Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    .local v6, "cache":Ljava/lang/Object;
    :goto_0
    return-object v6

    .line 320
    .end local v6    # "cache":Ljava/lang/Object;
    .restart local v0    # "cache":Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    :catch_0
    move-exception v7

    .line 323
    .local v7, "journalIsCorrupt":Ljava/io/IOException;
    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->delete()V

    .line 328
    .end local v7    # "journalIsCorrupt":Ljava/io/IOException;
    :cond_3
    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    .line 329
    new-instance v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;

    .end local v0    # "cache":Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    move-object v1, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;-><init>(Ljava/io/File;IIJ)V

    .line 330
    .restart local v0    # "cache":Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    invoke-direct {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->rebuildJournal()V

    move-object v6, v0

    .line 331
    .restart local v6    # "cache":Ljava/lang/Object;
    goto :goto_0
.end method

.method private processJournal()V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 399
    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalFileTmp:Ljava/io/File;

    invoke-static {v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->deleteIfExists(Ljava/io/File;)V

    .line 400
    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 415
    return-void

    .line 401
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    .line 402
    .local v0, "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->currentEditor:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v3

    if-nez v3, :cond_2

    .line 403
    const/4 v2, 0x0

    .local v2, "t":I
    :goto_1
    iget v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    if-ge v2, v3, :cond_0

    .line 404
    iget-wide v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->size:J

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->lengths:[J
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$7(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)[J

    move-result-object v5

    aget-wide v5, v5, v2

    add-long/2addr v3, v5

    iput-wide v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->size:J

    .line 403
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 407
    .end local v2    # "t":I
    :cond_2
    const/4 v3, 0x0

    invoke-static {v0, v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$5(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;)V

    .line 408
    const/4 v2, 0x0

    .restart local v2    # "t":I
    :goto_2
    iget v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    if-lt v2, v3, :cond_3

    .line 412
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 409
    :cond_3
    invoke-virtual {v0, v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->deleteIfExists(Ljava/io/File;)V

    .line 410
    invoke-virtual {v0, v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->deleteIfExists(Ljava/io/File;)V

    .line 408
    add-int/lit8 v2, v2, 0x1

    goto :goto_2
.end method

.method public static readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 5
    .param p0, "in"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 211
    new-instance v2, Ljava/lang/StringBuilder;

    const/16 v3, 0x50

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 213
    .local v2, "result":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v0

    .line 214
    .local v0, "c":I
    const/4 v3, -0x1

    if-ne v0, v3, :cond_0

    .line 215
    new-instance v3, Ljava/io/EOFException;

    invoke-direct {v3}, Ljava/io/EOFException;-><init>()V

    throw v3

    .line 216
    :cond_0
    const/16 v3, 0xa

    if-ne v0, v3, :cond_2

    .line 222
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v1

    .line 223
    .local v1, "length":I
    if-lez v1, :cond_1

    add-int/lit8 v3, v1, -0x1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    const/16 v4, 0xd

    if-ne v3, v4, :cond_1

    .line 224
    add-int/lit8 v3, v1, -0x1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 226
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 220
    .end local v1    # "length":I
    :cond_2
    int-to-char v3, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method public static readFully(Ljava/io/Reader;)Ljava/lang/String;
    .locals 4
    .param p0, "reader"    # Ljava/io/Reader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 189
    :try_start_0
    new-instance v2, Ljava/io/StringWriter;

    invoke-direct {v2}, Ljava/io/StringWriter;-><init>()V

    .line 190
    .local v2, "writer":Ljava/io/StringWriter;
    const/16 v3, 0x400

    new-array v0, v3, [C

    .line 192
    .local v0, "buffer":[C
    :goto_0
    invoke-virtual {p0, v0}, Ljava/io/Reader;->read([C)I

    move-result v1

    .local v1, "count":I
    const/4 v3, -0x1

    if-ne v1, v3, :cond_0

    .line 195
    invoke-virtual {v2}, Ljava/io/StringWriter;->toString()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    .line 197
    invoke-virtual {p0}, Ljava/io/Reader;->close()V

    .line 195
    return-object v3

    .line 193
    :cond_0
    const/4 v3, 0x0

    :try_start_1
    invoke-virtual {v2, v0, v3, v1}, Ljava/io/StringWriter;->write([CII)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 196
    .end local v0    # "buffer":[C
    .end local v1    # "count":I
    .end local v2    # "writer":Ljava/io/StringWriter;
    :catchall_0
    move-exception v3

    .line 197
    invoke-virtual {p0}, Ljava/io/Reader;->close()V

    .line 198
    throw v3
.end method

.method private readJournal()V
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 335
    new-instance v2, Ljava/io/BufferedInputStream;

    new-instance v6, Ljava/io/FileInputStream;

    iget-object v7, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalFile:Ljava/io/File;

    invoke-direct {v6, v7}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    const/16 v7, 0x2000

    invoke-direct {v2, v6, v7}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    .line 337
    .local v2, "in":Ljava/io/InputStream;
    :try_start_0
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v3

    .line 338
    .local v3, "magic":Ljava/lang/String;
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v5

    .line 339
    .local v5, "version":Ljava/lang/String;
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    .line 340
    .local v0, "appVersionString":Ljava/lang/String;
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v4

    .line 341
    .local v4, "valueCountString":Ljava/lang/String;
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v1

    .line 342
    .local v1, "blank":Ljava/lang/String;
    const-string v6, "libcore.io.DiskLruCache"

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 343
    const-string v6, "1"

    invoke-virtual {v6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 344
    iget v6, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->appVersion:I

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 345
    iget v6, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    invoke-static {v6}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 346
    const-string v6, ""

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 347
    :cond_0
    new-instance v6, Ljava/io/IOException;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "unexpected journal header: ["

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 348
    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "]"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 347
    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 358
    .end local v0    # "appVersionString":Ljava/lang/String;
    .end local v1    # "blank":Ljava/lang/String;
    .end local v3    # "magic":Ljava/lang/String;
    .end local v4    # "valueCountString":Ljava/lang/String;
    .end local v5    # "version":Ljava/lang/String;
    :catchall_0
    move-exception v6

    .line 359
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 360
    throw v6

    .line 353
    .restart local v0    # "appVersionString":Ljava/lang/String;
    .restart local v1    # "blank":Ljava/lang/String;
    .restart local v3    # "magic":Ljava/lang/String;
    .restart local v4    # "valueCountString":Ljava/lang/String;
    .restart local v5    # "version":Ljava/lang/String;
    :cond_1
    :goto_0
    :try_start_1
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->readAsciiLine(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v6}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->readJournalLine(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/EOFException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 354
    :catch_0
    move-exception v6

    .line 359
    invoke-static {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 361
    return-void
.end method

.method private readJournalLine(Ljava/lang/String;)V
    .locals 9
    .param p1, "line"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    const/4 v6, 0x0

    const/4 v5, 0x2

    .line 364
    const-string v3, " "

    invoke-virtual {p1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 365
    .local v2, "parts":[Ljava/lang/String;
    array-length v3, v2

    if-ge v3, v5, :cond_0

    .line 366
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "unexpected journal line: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 369
    :cond_0
    aget-object v1, v2, v8

    .line 370
    .local v1, "key":Ljava/lang/String;
    aget-object v3, v2, v6

    const-string v4, "REMOVE"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    array-length v3, v2

    if-ne v3, v5, :cond_2

    .line 371
    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 392
    :cond_1
    :goto_0
    return-void

    .line 375
    :cond_2
    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    .line 376
    .local v0, "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    if-nez v0, :cond_3

    .line 377
    new-instance v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    .end local v0    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    invoke-direct {v0, p0, v1, v7}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;-><init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)V

    .line 378
    .restart local v0    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, v1, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 381
    :cond_3
    aget-object v3, v2, v6

    const-string v4, "CLEAN"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    array-length v3, v2

    iget v4, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    add-int/lit8 v4, v4, 0x2

    if-ne v3, v4, :cond_4

    .line 382
    invoke-static {v0, v8}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$4(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;Z)V

    .line 383
    invoke-static {v0, v7}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$5(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;)V

    .line 384
    array-length v3, v2

    invoke-static {v2, v5, v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->copyOfRange([Ljava/lang/Object;II)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    # invokes: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->setLengths([Ljava/lang/String;)V
    invoke-static {v0, v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$6(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;[Ljava/lang/String;)V

    goto :goto_0

    .line 385
    :cond_4
    aget-object v3, v2, v6

    const-string v4, "DIRTY"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    array-length v3, v2

    if-ne v3, v5, :cond_5

    .line 386
    new-instance v3, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    invoke-direct {v3, p0, v0, v7}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;-><init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;)V

    invoke-static {v0, v3}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$5(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;)V

    goto :goto_0

    .line 387
    :cond_5
    aget-object v3, v2, v6

    const-string v4, "READ"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    array-length v3, v2

    if-eq v3, v5, :cond_1

    .line 390
    :cond_6
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "unexpected journal line: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method private declared-synchronized rebuildJournal()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 422
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    if-eqz v2, :cond_0

    .line 423
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v2}, Ljava/io/Writer;->close()V

    .line 426
    :cond_0
    new-instance v1, Ljava/io/BufferedWriter;

    new-instance v2, Ljava/io/FileWriter;

    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalFileTmp:Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    const/16 v3, 0x2000

    invoke-direct {v1, v2, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    .line 427
    .local v1, "writer":Ljava/io/Writer;
    const-string v2, "libcore.io.DiskLruCache"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 428
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 429
    const-string v2, "1"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 430
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 431
    iget v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->appVersion:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 432
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 433
    iget v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 434
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 435
    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 437
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 445
    invoke-virtual {v1}, Ljava/io/Writer;->close()V

    .line 446
    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalFileTmp:Ljava/io/File;

    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalFile:Ljava/io/File;

    invoke-virtual {v2, v3}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 447
    new-instance v2, Ljava/io/BufferedWriter;

    new-instance v3, Ljava/io/FileWriter;

    iget-object v4, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalFile:Ljava/io/File;

    const/4 v5, 0x1

    invoke-direct {v3, v4, v5}, Ljava/io/FileWriter;-><init>(Ljava/io/File;Z)V

    const/16 v4, 0x2000

    invoke-direct {v2, v3, v4}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;I)V

    iput-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 448
    monitor-exit p0

    return-void

    .line 437
    :cond_1
    :try_start_1
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    .line 438
    .local v0, "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->currentEditor:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 439
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "DIRTY "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->key:Ljava/lang/String;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$2(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 422
    .end local v0    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    .end local v1    # "writer":Ljava/io/Writer;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 441
    .restart local v0    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    .restart local v1    # "writer":Ljava/io/Writer;
    :cond_2
    :try_start_2
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "CLEAN "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->key:Ljava/lang/String;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$2(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getLengths()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method private trimToSize()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 694
    :goto_0
    iget-wide v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->size:J

    iget-wide v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->maxSize:J

    cmp-long v1, v1, v3

    if-gtz v1, :cond_0

    .line 699
    return-void

    .line 696
    :cond_0
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 697
    .local v0, "toEvict":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p0, v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->remove(Ljava/lang/String;)Z

    goto :goto_0
.end method

.method private validateKey(Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 712
    const-string v0, " "

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "\n"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "\r"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 713
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 714
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "keys must not contain spaces or newlines: \""

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 713
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 716
    :cond_1
    return-void
.end method


# virtual methods
.method public declared-synchronized close()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 680
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v1, :cond_0

    .line 691
    :goto_0
    monitor-exit p0

    return-void

    .line 683
    :cond_0
    :try_start_1
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_2

    .line 688
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->trimToSize()V

    .line 689
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v1}, Ljava/io/Writer;->close()V

    .line 690
    const/4 v1, 0x0

    iput-object v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 680
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 683
    :cond_2
    :try_start_2
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    .line 684
    .local v0, "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->currentEditor:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 685
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->currentEditor:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v2

    invoke-virtual {v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;->abort()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public delete()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 707
    invoke-virtual {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->close()V

    .line 708
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->directory:Ljava/io/File;

    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->deleteContents(Ljava/io/File;)V

    .line 709
    return-void
.end method

.method public edit(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 509
    const-wide/16 v0, -0x1

    invoke-direct {p0, p1, v0, v1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->edit(Ljava/lang/String;J)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 671
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->checkNotClosed()V

    .line 672
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->trimToSize()V

    .line 673
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v0}, Ljava/io/Writer;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 674
    monitor-exit p0

    return-void

    .line 671
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized get(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    .locals 10
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 469
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->checkNotClosed()V

    .line 470
    invoke-direct {p0, p1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->validateKey(Ljava/lang/String;)V

    .line 471
    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 472
    .local v8, "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    if-nez v8, :cond_1

    .line 501
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v0

    .line 476
    :cond_1
    :try_start_1
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->readable:Z
    invoke-static {v8}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$1(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 485
    iget v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    new-array v5, v1, [Ljava/io/InputStream;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 487
    .local v5, "ins":[Ljava/io/InputStream;
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_1
    :try_start_2
    iget v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    if-lt v9, v1, :cond_3

    .line 495
    :try_start_3
    iget v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->redundantOpCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->redundantOpCount:I

    .line 496
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "READ "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0xa

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 497
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalRebuildRequired()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 498
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v1, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 501
    :cond_2
    new-instance v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->sequenceNumber:J
    invoke-static {v8}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$8(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)J

    move-result-wide v3

    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v6}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;-><init>(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Ljava/lang/String;J[Ljava/io/InputStream;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 469
    .end local v5    # "ins":[Ljava/io/InputStream;
    .end local v8    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    .end local v9    # "i":I
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 488
    .restart local v5    # "ins":[Ljava/io/InputStream;
    .restart local v8    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    .restart local v9    # "i":I
    :cond_3
    :try_start_4
    new-instance v1, Ljava/io/FileInputStream;

    invoke-virtual {v8, v9}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    aput-object v1, v5, v9
    :try_end_4
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 487
    add-int/lit8 v9, v9, 0x1

    goto :goto_1

    .line 490
    :catch_0
    move-exception v7

    .line 492
    .local v7, "e":Ljava/io/FileNotFoundException;
    goto :goto_0
.end method

.method public getDirectory()Ljava/io/File;
    .locals 1

    .prologue
    .line 540
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->directory:Ljava/io/File;

    return-object v0
.end method

.method public isClosed()Z
    .locals 1

    .prologue
    .line 658
    iget-object v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public maxSize()J
    .locals 2

    .prologue
    .line 548
    iget-wide v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->maxSize:J

    return-wide v0
.end method

.method public declared-synchronized remove(Ljava/lang/String;)Z
    .locals 7
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 627
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->checkNotClosed()V

    .line 628
    invoke-direct {p0, p1}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->validateKey(Ljava/lang/String;)V

    .line 629
    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;

    .line 630
    .local v0, "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    if-eqz v0, :cond_0

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->currentEditor:Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$0(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    if-eqz v3, :cond_1

    .line 631
    :cond_0
    const/4 v3, 0x0

    .line 651
    :goto_0
    monitor-exit p0

    return v3

    .line 634
    :cond_1
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    :try_start_1
    iget v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->valueCount:I

    if-lt v2, v3, :cond_3

    .line 643
    iget v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->redundantOpCount:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->redundantOpCount:I

    .line 644
    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalWriter:Ljava/io/Writer;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "REMOVE "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v5, 0xa

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 645
    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, p1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 647
    invoke-direct {p0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->journalRebuildRequired()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 648
    iget-object v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v4, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v3, v4}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 651
    :cond_2
    const/4 v3, 0x1

    goto :goto_0

    .line 635
    :cond_3
    invoke-virtual {v0, v2}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v1

    .line 636
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_4

    .line 637
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "failed to delete "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 627
    .end local v0    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "i":I
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 639
    .restart local v0    # "entry":Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "i":I
    :cond_4
    :try_start_2
    iget-wide v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->size:J

    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->lengths:[J
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$7(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)[J

    move-result-object v5

    aget-wide v5, v5, v2

    sub-long/2addr v3, v5

    iput-wide v3, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->size:J

    .line 640
    # getter for: Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->lengths:[J
    invoke-static {v0}, Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;->access$7(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)[J

    move-result-object v3

    const-wide/16 v4, 0x0

    aput-wide v4, v3, v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 634
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method public declared-synchronized size()J
    .locals 2

    .prologue
    .line 557
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lnet/tsz/afinal/bitmap/core/LruDiskCache;->size:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
