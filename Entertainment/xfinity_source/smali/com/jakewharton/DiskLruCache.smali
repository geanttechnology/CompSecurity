.class public final Lcom/jakewharton/DiskLruCache;
.super Ljava/lang/Object;
.source "DiskLruCache.java"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jakewharton/DiskLruCache$Entry;,
        Lcom/jakewharton/DiskLruCache$Editor;,
        Lcom/jakewharton/DiskLruCache$Snapshot;
    }
.end annotation


# static fields
.field static final LEGAL_KEY_PATTERN:Ljava/util/regex/Pattern;

.field private static final NULL_OUTPUT_STREAM:Ljava/io/OutputStream;


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

.field final executorService:Ljava/util/concurrent/ThreadPoolExecutor;

.field private final journalFile:Ljava/io/File;

.field private final journalFileTmp:Ljava/io/File;

.field private journalWriter:Ljava/io/Writer;

.field private final lruEntries:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/jakewharton/DiskLruCache$Entry;",
            ">;"
        }
    .end annotation
.end field

.field private maxSize:J

.field private nextSequenceNumber:J

.field private redundantOpCount:I

.field private size:J

.field private final valueCount:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 95
    const-string v0, "[a-z0-9_-]{1,64}"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/jakewharton/DiskLruCache;->LEGAL_KEY_PATTERN:Ljava/util/regex/Pattern;

    .line 695
    new-instance v0, Lcom/jakewharton/DiskLruCache$2;

    invoke-direct {v0}, Lcom/jakewharton/DiskLruCache$2;-><init>()V

    sput-object v0, Lcom/jakewharton/DiskLruCache;->NULL_OUTPUT_STREAM:Ljava/io/OutputStream;

    return-void
.end method

.method private constructor <init>(Ljava/io/File;IIJ)V
    .locals 8
    .param p1, "directory"    # Ljava/io/File;
    .param p2, "appVersion"    # I
    .param p3, "valueCount"    # I
    .param p4, "maxSize"    # J

    .prologue
    const-wide/16 v4, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 179
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 147
    iput-wide v4, p0, Lcom/jakewharton/DiskLruCache;->size:J

    .line 149
    new-instance v0, Ljava/util/LinkedHashMap;

    const/high16 v1, 0x3f400000    # 0.75f

    invoke-direct {v0, v2, v1, v3}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    iput-object v0, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    .line 158
    iput-wide v4, p0, Lcom/jakewharton/DiskLruCache;->nextSequenceNumber:J

    .line 161
    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v4, 0x3c

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v7, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v7}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v1 .. v7}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    iput-object v1, p0, Lcom/jakewharton/DiskLruCache;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 163
    new-instance v0, Lcom/jakewharton/DiskLruCache$1;

    invoke-direct {v0, p0}, Lcom/jakewharton/DiskLruCache$1;-><init>(Lcom/jakewharton/DiskLruCache;)V

    iput-object v0, p0, Lcom/jakewharton/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    .line 180
    iput-object p1, p0, Lcom/jakewharton/DiskLruCache;->directory:Ljava/io/File;

    .line 181
    iput p2, p0, Lcom/jakewharton/DiskLruCache;->appVersion:I

    .line 182
    new-instance v0, Ljava/io/File;

    const-string v1, "journal"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/jakewharton/DiskLruCache;->journalFile:Ljava/io/File;

    .line 183
    new-instance v0, Ljava/io/File;

    const-string v1, "journal.tmp"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/jakewharton/DiskLruCache;->journalFileTmp:Ljava/io/File;

    .line 184
    iput p3, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    .line 185
    iput-wide p4, p0, Lcom/jakewharton/DiskLruCache;->maxSize:J

    .line 186
    return-void
.end method

.method static synthetic access$000(Lcom/jakewharton/DiskLruCache;)Ljava/io/Writer;
    .locals 1
    .param p0, "x0"    # Lcom/jakewharton/DiskLruCache;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    return-object v0
.end method

.method static synthetic access$100(Lcom/jakewharton/DiskLruCache;)V
    .locals 0
    .param p0, "x0"    # Lcom/jakewharton/DiskLruCache;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 89
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->trimToSize()V

    return-void
.end method

.method static synthetic access$1800(Lcom/jakewharton/DiskLruCache;)I
    .locals 1
    .param p0, "x0"    # Lcom/jakewharton/DiskLruCache;

    .prologue
    .line 89
    iget v0, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    return v0
.end method

.method static synthetic access$1900(Lcom/jakewharton/DiskLruCache;)Ljava/io/File;
    .locals 1
    .param p0, "x0"    # Lcom/jakewharton/DiskLruCache;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/jakewharton/DiskLruCache;->directory:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$200(Lcom/jakewharton/DiskLruCache;)Z
    .locals 1
    .param p0, "x0"    # Lcom/jakewharton/DiskLruCache;

    .prologue
    .line 89
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->journalRebuildRequired()Z

    move-result v0

    return v0
.end method

.method static synthetic access$2000()Ljava/io/OutputStream;
    .locals 1

    .prologue
    .line 89
    sget-object v0, Lcom/jakewharton/DiskLruCache;->NULL_OUTPUT_STREAM:Ljava/io/OutputStream;

    return-object v0
.end method

.method static synthetic access$2200(Lcom/jakewharton/DiskLruCache;Lcom/jakewharton/DiskLruCache$Editor;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/jakewharton/DiskLruCache;
    .param p1, "x1"    # Lcom/jakewharton/DiskLruCache$Editor;
    .param p2, "x2"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 89
    invoke-direct {p0, p1, p2}, Lcom/jakewharton/DiskLruCache;->completeEdit(Lcom/jakewharton/DiskLruCache$Editor;Z)V

    return-void
.end method

.method static synthetic access$300(Lcom/jakewharton/DiskLruCache;)V
    .locals 0
    .param p0, "x0"    # Lcom/jakewharton/DiskLruCache;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 89
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->rebuildJournal()V

    return-void
.end method

.method static synthetic access$402(Lcom/jakewharton/DiskLruCache;I)I
    .locals 0
    .param p0, "x0"    # Lcom/jakewharton/DiskLruCache;
    .param p1, "x1"    # I

    .prologue
    .line 89
    iput p1, p0, Lcom/jakewharton/DiskLruCache;->redundantOpCount:I

    return p1
.end method

.method private checkNotClosed()V
    .locals 2

    .prologue
    .line 582
    iget-object v0, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    if-nez v0, :cond_0

    .line 583
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "cache is closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 585
    :cond_0
    return-void
.end method

.method private declared-synchronized completeEdit(Lcom/jakewharton/DiskLruCache$Editor;Z)V
    .locals 12
    .param p1, "editor"    # Lcom/jakewharton/DiskLruCache$Editor;
    .param p2, "success"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 477
    monitor-enter p0

    :try_start_0
    # getter for: Lcom/jakewharton/DiskLruCache$Editor;->entry:Lcom/jakewharton/DiskLruCache$Entry;
    invoke-static {p1}, Lcom/jakewharton/DiskLruCache$Editor;->access$1400(Lcom/jakewharton/DiskLruCache$Editor;)Lcom/jakewharton/DiskLruCache$Entry;

    move-result-object v2

    .line 478
    .local v2, "entry":Lcom/jakewharton/DiskLruCache$Entry;
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v2}, Lcom/jakewharton/DiskLruCache$Entry;->access$700(Lcom/jakewharton/DiskLruCache$Entry;)Lcom/jakewharton/DiskLruCache$Editor;

    move-result-object v8

    if-eq v8, p1, :cond_0

    .line 479
    new-instance v8, Ljava/lang/IllegalStateException;

    invoke-direct {v8}, Ljava/lang/IllegalStateException;-><init>()V

    throw v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 477
    .end local v2    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    :catchall_0
    move-exception v8

    monitor-exit p0

    throw v8

    .line 483
    .restart local v2    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    :cond_0
    if-eqz p2, :cond_4

    :try_start_1
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->readable:Z
    invoke-static {v2}, Lcom/jakewharton/DiskLruCache$Entry;->access$600(Lcom/jakewharton/DiskLruCache$Entry;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 484
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    iget v8, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    if-ge v3, v8, :cond_4

    .line 485
    # getter for: Lcom/jakewharton/DiskLruCache$Editor;->written:[Z
    invoke-static {p1}, Lcom/jakewharton/DiskLruCache$Editor;->access$1500(Lcom/jakewharton/DiskLruCache$Editor;)[Z

    move-result-object v8

    aget-boolean v8, v8, v3

    if-nez v8, :cond_1

    .line 486
    invoke-virtual {p1}, Lcom/jakewharton/DiskLruCache$Editor;->abort()V

    .line 487
    new-instance v8, Ljava/lang/IllegalStateException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Newly created entry didn\'t create value for index "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 489
    :cond_1
    invoke-virtual {v2, v3}, Lcom/jakewharton/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v8

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_3

    .line 490
    invoke-virtual {p1}, Lcom/jakewharton/DiskLruCache$Editor;->abort()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 528
    :cond_2
    :goto_1
    monitor-exit p0

    return-void

    .line 484
    :cond_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 496
    .end local v3    # "i":I
    :cond_4
    const/4 v3, 0x0

    .restart local v3    # "i":I
    :goto_2
    :try_start_2
    iget v8, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    if-ge v3, v8, :cond_7

    .line 497
    invoke-virtual {v2, v3}, Lcom/jakewharton/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v1

    .line 498
    .local v1, "dirty":Ljava/io/File;
    if-eqz p2, :cond_6

    .line 499
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_5

    .line 500
    invoke-virtual {v2, v3}, Lcom/jakewharton/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v0

    .line 501
    .local v0, "clean":Ljava/io/File;
    invoke-virtual {v1, v0}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 502
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->lengths:[J
    invoke-static {v2}, Lcom/jakewharton/DiskLruCache$Entry;->access$1000(Lcom/jakewharton/DiskLruCache$Entry;)[J

    move-result-object v8

    aget-wide v6, v8, v3

    .line 503
    .local v6, "oldLength":J
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v4

    .line 504
    .local v4, "newLength":J
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->lengths:[J
    invoke-static {v2}, Lcom/jakewharton/DiskLruCache$Entry;->access$1000(Lcom/jakewharton/DiskLruCache$Entry;)[J

    move-result-object v8

    aput-wide v4, v8, v3

    .line 505
    iget-wide v8, p0, Lcom/jakewharton/DiskLruCache;->size:J

    sub-long/2addr v8, v6

    add-long/2addr v8, v4

    iput-wide v8, p0, Lcom/jakewharton/DiskLruCache;->size:J

    .line 496
    .end local v0    # "clean":Ljava/io/File;
    .end local v4    # "newLength":J
    .end local v6    # "oldLength":J
    :cond_5
    :goto_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 508
    :cond_6
    invoke-static {v1}, Lcom/jakewharton/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    goto :goto_3

    .line 512
    .end local v1    # "dirty":Ljava/io/File;
    :cond_7
    iget v8, p0, Lcom/jakewharton/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v8, v8, 0x1

    iput v8, p0, Lcom/jakewharton/DiskLruCache;->redundantOpCount:I

    .line 513
    const/4 v8, 0x0

    # setter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v2, v8}, Lcom/jakewharton/DiskLruCache$Entry;->access$702(Lcom/jakewharton/DiskLruCache$Entry;Lcom/jakewharton/DiskLruCache$Editor;)Lcom/jakewharton/DiskLruCache$Editor;

    .line 514
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->readable:Z
    invoke-static {v2}, Lcom/jakewharton/DiskLruCache$Entry;->access$600(Lcom/jakewharton/DiskLruCache$Entry;)Z

    move-result v8

    or-int/2addr v8, p2

    if-eqz v8, :cond_a

    .line 515
    const/4 v8, 0x1

    # setter for: Lcom/jakewharton/DiskLruCache$Entry;->readable:Z
    invoke-static {v2, v8}, Lcom/jakewharton/DiskLruCache$Entry;->access$602(Lcom/jakewharton/DiskLruCache$Entry;Z)Z

    .line 516
    iget-object v8, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "CLEAN "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->key:Ljava/lang/String;
    invoke-static {v2}, Lcom/jakewharton/DiskLruCache$Entry;->access$1100(Lcom/jakewharton/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v2}, Lcom/jakewharton/DiskLruCache$Entry;->getLengths()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const/16 v10, 0xa

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 517
    if-eqz p2, :cond_8

    .line 518
    iget-wide v8, p0, Lcom/jakewharton/DiskLruCache;->nextSequenceNumber:J

    const-wide/16 v10, 0x1

    add-long/2addr v10, v8

    iput-wide v10, p0, Lcom/jakewharton/DiskLruCache;->nextSequenceNumber:J

    # setter for: Lcom/jakewharton/DiskLruCache$Entry;->sequenceNumber:J
    invoke-static {v2, v8, v9}, Lcom/jakewharton/DiskLruCache$Entry;->access$1202(Lcom/jakewharton/DiskLruCache$Entry;J)J

    .line 525
    :cond_8
    :goto_4
    iget-wide v8, p0, Lcom/jakewharton/DiskLruCache;->size:J

    iget-wide v10, p0, Lcom/jakewharton/DiskLruCache;->maxSize:J

    cmp-long v8, v8, v10

    if-gtz v8, :cond_9

    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->journalRebuildRequired()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 526
    :cond_9
    iget-object v8, p0, Lcom/jakewharton/DiskLruCache;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    iget-object v9, p0, Lcom/jakewharton/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-virtual {v8, v9}, Ljava/util/concurrent/ThreadPoolExecutor;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    goto/16 :goto_1

    .line 521
    :cond_a
    iget-object v8, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->key:Ljava/lang/String;
    invoke-static {v2}, Lcom/jakewharton/DiskLruCache$Entry;->access$1100(Lcom/jakewharton/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 522
    iget-object v8, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "REMOVE "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->key:Ljava/lang/String;
    invoke-static {v2}, Lcom/jakewharton/DiskLruCache$Entry;->access$1100(Lcom/jakewharton/DiskLruCache$Entry;)Ljava/lang/String;

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

    goto :goto_4
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
    .line 365
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result v0

    if-nez v0, :cond_0

    .line 366
    new-instance v0, Ljava/io/IOException;

    invoke-direct {v0}, Ljava/io/IOException;-><init>()V

    throw v0

    .line 368
    :cond_0
    return-void
.end method

.method private declared-synchronized edit(Ljava/lang/String;J)Lcom/jakewharton/DiskLruCache$Editor;
    .locals 6
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "expectedSequenceNumber"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 420
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->checkNotClosed()V

    .line 421
    invoke-direct {p0, p1}, Lcom/jakewharton/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 422
    iget-object v2, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/jakewharton/DiskLruCache$Entry;

    .line 423
    .local v1, "entry":Lcom/jakewharton/DiskLruCache$Entry;
    const-wide/16 v2, -0x1

    cmp-long v2, p2, v2

    if-eqz v2, :cond_1

    if-eqz v1, :cond_0

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->sequenceNumber:J
    invoke-static {v1}, Lcom/jakewharton/DiskLruCache$Entry;->access$1200(Lcom/jakewharton/DiskLruCache$Entry;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v2

    cmp-long v2, v2, p2

    if-eqz v2, :cond_1

    .line 440
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v0

    .line 427
    :cond_1
    if-nez v1, :cond_3

    .line 428
    :try_start_1
    new-instance v1, Lcom/jakewharton/DiskLruCache$Entry;

    .end local v1    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    const/4 v2, 0x0

    invoke-direct {v1, p0, p1, v2}, Lcom/jakewharton/DiskLruCache$Entry;-><init>(Lcom/jakewharton/DiskLruCache;Ljava/lang/String;Lcom/jakewharton/DiskLruCache$1;)V

    .line 429
    .restart local v1    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    iget-object v2, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 434
    :cond_2
    new-instance v0, Lcom/jakewharton/DiskLruCache$Editor;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v2}, Lcom/jakewharton/DiskLruCache$Editor;-><init>(Lcom/jakewharton/DiskLruCache;Lcom/jakewharton/DiskLruCache$Entry;Lcom/jakewharton/DiskLruCache$1;)V

    .line 435
    .local v0, "editor":Lcom/jakewharton/DiskLruCache$Editor;
    # setter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v1, v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$702(Lcom/jakewharton/DiskLruCache$Entry;Lcom/jakewharton/DiskLruCache$Editor;)Lcom/jakewharton/DiskLruCache$Editor;

    .line 438
    iget-object v2, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "DIRTY "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 439
    iget-object v2, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v2}, Ljava/io/Writer;->flush()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 420
    .end local v0    # "editor":Lcom/jakewharton/DiskLruCache$Editor;
    .end local v1    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 430
    .restart local v1    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    :cond_3
    :try_start_2
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v1}, Lcom/jakewharton/DiskLruCache$Entry;->access$700(Lcom/jakewharton/DiskLruCache$Entry;)Lcom/jakewharton/DiskLruCache$Editor;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v2

    if-eqz v2, :cond_2

    goto :goto_0
.end method

.method private journalRebuildRequired()Z
    .locals 3

    .prologue
    .line 535
    const/16 v0, 0x7d0

    .line 536
    .local v0, "REDUNDANT_OP_COMPACT_THRESHOLD":I
    iget v1, p0, Lcom/jakewharton/DiskLruCache;->redundantOpCount:I

    const/16 v2, 0x7d0

    if-lt v1, v2, :cond_0

    iget v1, p0, Lcom/jakewharton/DiskLruCache;->redundantOpCount:I

    iget-object v2, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2}, Ljava/util/LinkedHashMap;->size()I

    move-result v2

    if-lt v1, v2, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static open(Ljava/io/File;IIJ)Lcom/jakewharton/DiskLruCache;
    .locals 9
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
    .line 200
    const-wide/16 v2, 0x0

    cmp-long v1, p3, v2

    if-gtz v1, :cond_0

    .line 201
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "maxSize <= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 203
    :cond_0
    if-gtz p2, :cond_1

    .line 204
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "valueCount <= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 208
    :cond_1
    new-instance v0, Lcom/jakewharton/DiskLruCache;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/jakewharton/DiskLruCache;-><init>(Ljava/io/File;IIJ)V

    .line 209
    .local v0, "cache":Lcom/jakewharton/DiskLruCache;
    iget-object v1, v0, Lcom/jakewharton/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 211
    :try_start_0
    invoke-direct {v0}, Lcom/jakewharton/DiskLruCache;->readJournal()V

    .line 212
    invoke-direct {v0}, Lcom/jakewharton/DiskLruCache;->processJournal()V

    .line 213
    new-instance v1, Ljava/io/BufferedWriter;

    new-instance v2, Ljava/io/FileWriter;

    iget-object v3, v0, Lcom/jakewharton/DiskLruCache;->journalFile:Ljava/io/File;

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Ljava/io/FileWriter;-><init>(Ljava/io/File;Z)V

    invoke-direct {v1, v2}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    iput-object v1, v0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v6, v0

    .line 226
    .end local v0    # "cache":Lcom/jakewharton/DiskLruCache;
    .local v6, "cache":Ljava/lang/Object;
    :goto_0
    return-object v6

    .line 215
    .end local v6    # "cache":Ljava/lang/Object;
    .restart local v0    # "cache":Lcom/jakewharton/DiskLruCache;
    :catch_0
    move-exception v7

    .line 216
    .local v7, "journalIsCorrupt":Ljava/io/IOException;
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "DiskLruCache "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is corrupt: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v7}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", removing"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 218
    invoke-virtual {v0}, Lcom/jakewharton/DiskLruCache;->delete()V

    .line 223
    .end local v7    # "journalIsCorrupt":Ljava/io/IOException;
    :cond_2
    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    .line 224
    new-instance v0, Lcom/jakewharton/DiskLruCache;

    .end local v0    # "cache":Lcom/jakewharton/DiskLruCache;
    move-object v1, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/jakewharton/DiskLruCache;-><init>(Ljava/io/File;IIJ)V

    .line 225
    .restart local v0    # "cache":Lcom/jakewharton/DiskLruCache;
    invoke-direct {v0}, Lcom/jakewharton/DiskLruCache;->rebuildJournal()V

    move-object v6, v0

    .line 226
    .restart local v6    # "cache":Ljava/lang/Object;
    goto :goto_0
.end method

.method private processJournal()V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 306
    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->journalFileTmp:Ljava/io/File;

    invoke-static {v3}, Lcom/jakewharton/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    .line 307
    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/jakewharton/DiskLruCache$Entry;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 308
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jakewharton/DiskLruCache$Entry;

    .line 309
    .local v0, "entry":Lcom/jakewharton/DiskLruCache$Entry;
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$700(Lcom/jakewharton/DiskLruCache$Entry;)Lcom/jakewharton/DiskLruCache$Editor;

    move-result-object v3

    if-nez v3, :cond_1

    .line 310
    const/4 v2, 0x0

    .local v2, "t":I
    :goto_1
    iget v3, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    if-ge v2, v3, :cond_0

    .line 311
    iget-wide v4, p0, Lcom/jakewharton/DiskLruCache;->size:J

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->lengths:[J
    invoke-static {v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$1000(Lcom/jakewharton/DiskLruCache$Entry;)[J

    move-result-object v3

    aget-wide v6, v3, v2

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/jakewharton/DiskLruCache;->size:J

    .line 310
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 314
    .end local v2    # "t":I
    :cond_1
    const/4 v3, 0x0

    # setter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v0, v3}, Lcom/jakewharton/DiskLruCache$Entry;->access$702(Lcom/jakewharton/DiskLruCache$Entry;Lcom/jakewharton/DiskLruCache$Editor;)Lcom/jakewharton/DiskLruCache$Editor;

    .line 315
    const/4 v2, 0x0

    .restart local v2    # "t":I
    :goto_2
    iget v3, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    if-ge v2, v3, :cond_2

    .line 316
    invoke-virtual {v0, v2}, Lcom/jakewharton/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lcom/jakewharton/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    .line 317
    invoke-virtual {v0, v2}, Lcom/jakewharton/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lcom/jakewharton/DiskLruCache;->deleteIfExists(Ljava/io/File;)V

    .line 315
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 319
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 322
    .end local v0    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    .end local v2    # "t":I
    :cond_3
    return-void
.end method

.method private readJournal()V
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 230
    new-instance v5, Lcom/jakewharton/StrictLineReader;

    new-instance v8, Ljava/io/FileInputStream;

    iget-object v9, p0, Lcom/jakewharton/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-direct {v8, v9}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    sget-object v9, Lcom/jakewharton/Charsets;->US_ASCII:Ljava/nio/charset/Charset;

    invoke-direct {v5, v8, v9}, Lcom/jakewharton/StrictLineReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    .line 233
    .local v5, "reader":Lcom/jakewharton/StrictLineReader;
    :try_start_0
    invoke-virtual {v5}, Lcom/jakewharton/StrictLineReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .line 234
    .local v4, "magic":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/jakewharton/StrictLineReader;->readLine()Ljava/lang/String;

    move-result-object v7

    .line 235
    .local v7, "version":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/jakewharton/StrictLineReader;->readLine()Ljava/lang/String;

    move-result-object v0

    .line 236
    .local v0, "appVersionString":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/jakewharton/StrictLineReader;->readLine()Ljava/lang/String;

    move-result-object v6

    .line 237
    .local v6, "valueCountString":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/jakewharton/StrictLineReader;->readLine()Ljava/lang/String;

    move-result-object v1

    .line 238
    .local v1, "blank":Ljava/lang/String;
    const-string v8, "libcore.io.DiskLruCache"

    invoke-virtual {v8, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    const-string v8, "1"

    invoke-virtual {v8, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    iget v8, p0, Lcom/jakewharton/DiskLruCache;->appVersion:I

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    iget v8, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    const-string v8, ""

    invoke-virtual {v8, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 243
    :cond_0
    new-instance v8, Ljava/io/IOException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "unexpected journal header: ["

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ", "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ", "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ", "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "]"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 258
    .end local v0    # "appVersionString":Ljava/lang/String;
    .end local v1    # "blank":Ljava/lang/String;
    .end local v4    # "magic":Ljava/lang/String;
    .end local v6    # "valueCountString":Ljava/lang/String;
    .end local v7    # "version":Ljava/lang/String;
    :catchall_0
    move-exception v8

    invoke-static {v5}, Lcom/jakewharton/IoUtils;->closeQuietly(Ljava/io/Closeable;)V

    throw v8

    .line 247
    .restart local v0    # "appVersionString":Ljava/lang/String;
    .restart local v1    # "blank":Ljava/lang/String;
    .restart local v4    # "magic":Ljava/lang/String;
    .restart local v6    # "valueCountString":Ljava/lang/String;
    .restart local v7    # "version":Ljava/lang/String;
    :cond_1
    const/4 v3, 0x0

    .line 250
    .local v3, "lineCount":I
    :goto_0
    :try_start_1
    invoke-virtual {v5}, Lcom/jakewharton/StrictLineReader;->readLine()Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v8}, Lcom/jakewharton/DiskLruCache;->readJournalLine(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/EOFException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 251
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 252
    :catch_0
    move-exception v2

    .line 256
    .local v2, "endOfJournal":Ljava/io/EOFException;
    :try_start_2
    iget-object v8, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v8}, Ljava/util/LinkedHashMap;->size()I

    move-result v8

    sub-int v8, v3, v8

    iput v8, p0, Lcom/jakewharton/DiskLruCache;->redundantOpCount:I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 258
    invoke-static {v5}, Lcom/jakewharton/IoUtils;->closeQuietly(Ljava/io/Closeable;)V

    .line 260
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
    const/16 v6, 0x20

    const/4 v8, 0x0

    const/4 v7, -0x1

    .line 263
    invoke-virtual {p1, v6}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 264
    .local v1, "firstSpace":I
    if-ne v1, v7, :cond_0

    .line 265
    new-instance v6, Ljava/io/IOException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "unexpected journal line: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 268
    :cond_0
    add-int/lit8 v3, v1, 0x1

    .line 269
    .local v3, "keyBegin":I
    invoke-virtual {p1, v6, v3}, Ljava/lang/String;->indexOf(II)I

    move-result v5

    .line 271
    .local v5, "secondSpace":I
    if-ne v5, v7, :cond_2

    .line 272
    invoke-virtual {p1, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    .line 273
    .local v2, "key":Ljava/lang/String;
    const-string v6, "REMOVE"

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-ne v1, v6, :cond_3

    const-string v6, "REMOVE"

    invoke-virtual {p1, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 274
    iget-object v6, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v6, v2}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 299
    :cond_1
    :goto_0
    return-void

    .line 278
    .end local v2    # "key":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1, v3, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 281
    .restart local v2    # "key":Ljava/lang/String;
    :cond_3
    iget-object v6, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v6, v2}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jakewharton/DiskLruCache$Entry;

    .line 282
    .local v0, "entry":Lcom/jakewharton/DiskLruCache$Entry;
    if-nez v0, :cond_4

    .line 283
    new-instance v0, Lcom/jakewharton/DiskLruCache$Entry;

    .end local v0    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    invoke-direct {v0, p0, v2, v8}, Lcom/jakewharton/DiskLruCache$Entry;-><init>(Lcom/jakewharton/DiskLruCache;Ljava/lang/String;Lcom/jakewharton/DiskLruCache$1;)V

    .line 284
    .restart local v0    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    iget-object v6, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v6, v2, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 287
    :cond_4
    if-eq v5, v7, :cond_5

    const-string v6, "CLEAN"

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-ne v1, v6, :cond_5

    const-string v6, "CLEAN"

    invoke-virtual {p1, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 288
    add-int/lit8 v6, v5, 0x1

    invoke-virtual {p1, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 289
    .local v4, "parts":[Ljava/lang/String;
    const/4 v6, 0x1

    # setter for: Lcom/jakewharton/DiskLruCache$Entry;->readable:Z
    invoke-static {v0, v6}, Lcom/jakewharton/DiskLruCache$Entry;->access$602(Lcom/jakewharton/DiskLruCache$Entry;Z)Z

    .line 290
    # setter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v0, v8}, Lcom/jakewharton/DiskLruCache$Entry;->access$702(Lcom/jakewharton/DiskLruCache$Entry;Lcom/jakewharton/DiskLruCache$Editor;)Lcom/jakewharton/DiskLruCache$Editor;

    .line 291
    # invokes: Lcom/jakewharton/DiskLruCache$Entry;->setLengths([Ljava/lang/String;)V
    invoke-static {v0, v4}, Lcom/jakewharton/DiskLruCache$Entry;->access$800(Lcom/jakewharton/DiskLruCache$Entry;[Ljava/lang/String;)V

    goto :goto_0

    .line 292
    .end local v4    # "parts":[Ljava/lang/String;
    :cond_5
    if-ne v5, v7, :cond_6

    const-string v6, "DIRTY"

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-ne v1, v6, :cond_6

    const-string v6, "DIRTY"

    invoke-virtual {p1, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 293
    new-instance v6, Lcom/jakewharton/DiskLruCache$Editor;

    invoke-direct {v6, p0, v0, v8}, Lcom/jakewharton/DiskLruCache$Editor;-><init>(Lcom/jakewharton/DiskLruCache;Lcom/jakewharton/DiskLruCache$Entry;Lcom/jakewharton/DiskLruCache$1;)V

    # setter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v0, v6}, Lcom/jakewharton/DiskLruCache$Entry;->access$702(Lcom/jakewharton/DiskLruCache$Entry;Lcom/jakewharton/DiskLruCache$Editor;)Lcom/jakewharton/DiskLruCache$Editor;

    goto :goto_0

    .line 294
    :cond_6
    if-ne v5, v7, :cond_7

    const-string v6, "READ"

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-ne v1, v6, :cond_7

    const-string v6, "READ"

    invoke-virtual {p1, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 297
    :cond_7
    new-instance v6, Ljava/io/IOException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "unexpected journal line: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6
.end method

.method private declared-synchronized rebuildJournal()V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 329
    monitor-enter p0

    :try_start_0
    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    if-eqz v3, :cond_0

    .line 330
    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v3}, Ljava/io/Writer;->close()V

    .line 333
    :cond_0
    new-instance v2, Ljava/io/BufferedWriter;

    new-instance v3, Ljava/io/FileWriter;

    iget-object v4, p0, Lcom/jakewharton/DiskLruCache;->journalFileTmp:Ljava/io/File;

    invoke-direct {v3, v4}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    invoke-direct {v2, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    .line 334
    .local v2, "writer":Ljava/io/Writer;
    const-string v3, "libcore.io.DiskLruCache"

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 335
    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 336
    const-string v3, "1"

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 337
    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 338
    iget v3, p0, Lcom/jakewharton/DiskLruCache;->appVersion:I

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 339
    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 340
    iget v3, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 341
    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 342
    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 344
    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jakewharton/DiskLruCache$Entry;

    .line 345
    .local v0, "entry":Lcom/jakewharton/DiskLruCache$Entry;
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$700(Lcom/jakewharton/DiskLruCache$Entry;)Lcom/jakewharton/DiskLruCache$Editor;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 346
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "DIRTY "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->key:Ljava/lang/String;
    invoke-static {v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$1100(Lcom/jakewharton/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 329
    .end local v0    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "writer":Ljava/io/Writer;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 348
    .restart local v0    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "writer":Ljava/io/Writer;
    :cond_1
    :try_start_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "CLEAN "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->key:Ljava/lang/String;
    invoke-static {v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$1100(Lcom/jakewharton/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/jakewharton/DiskLruCache$Entry;->getLengths()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 352
    .end local v0    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    :cond_2
    invoke-virtual {v2}, Ljava/io/Writer;->close()V

    .line 353
    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->journalFileTmp:Ljava/io/File;

    iget-object v4, p0, Lcom/jakewharton/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-virtual {v3, v4}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 354
    new-instance v3, Ljava/io/BufferedWriter;

    new-instance v4, Ljava/io/FileWriter;

    iget-object v5, p0, Lcom/jakewharton/DiskLruCache;->journalFile:Ljava/io/File;

    const/4 v6, 0x1

    invoke-direct {v4, v5, v6}, Ljava/io/FileWriter;-><init>(Ljava/io/File;Z)V

    invoke-direct {v3, v4}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V

    iput-object v3, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 355
    monitor-exit p0

    return-void
.end method

.method private trimToSize()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 614
    :goto_0
    iget-wide v2, p0, Lcom/jakewharton/DiskLruCache;->size:J

    iget-wide v4, p0, Lcom/jakewharton/DiskLruCache;->maxSize:J

    cmp-long v1, v2, v4

    if-lez v1, :cond_0

    .line 615
    iget-object v1, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 616
    .local v0, "toEvict":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/jakewharton/DiskLruCache$Entry;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p0, v1}, Lcom/jakewharton/DiskLruCache;->remove(Ljava/lang/String;)Z

    goto :goto_0

    .line 618
    .end local v0    # "toEvict":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/jakewharton/DiskLruCache$Entry;>;"
    :cond_0
    return-void
.end method

.method private validateKey(Ljava/lang/String;)V
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 631
    sget-object v1, Lcom/jakewharton/DiskLruCache;->LEGAL_KEY_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 632
    .local v0, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    if-nez v1, :cond_0

    .line 633
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "keys must match regex [a-z0-9_-]{1,64}: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 636
    :cond_0
    return-void
.end method


# virtual methods
.method public declared-synchronized close()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 600
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v2, :cond_0

    .line 611
    :goto_0
    monitor-exit p0

    return-void

    .line 603
    :cond_0
    :try_start_1
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jakewharton/DiskLruCache$Entry;

    .line 604
    .local v0, "entry":Lcom/jakewharton/DiskLruCache$Entry;
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$700(Lcom/jakewharton/DiskLruCache$Entry;)Lcom/jakewharton/DiskLruCache$Editor;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 605
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$700(Lcom/jakewharton/DiskLruCache$Entry;)Lcom/jakewharton/DiskLruCache$Editor;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jakewharton/DiskLruCache$Editor;->abort()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 600
    .end local v0    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 608
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_2
    :try_start_2
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->trimToSize()V

    .line 609
    iget-object v2, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v2}, Ljava/io/Writer;->close()V

    .line 610
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public delete()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 626
    invoke-virtual {p0}, Lcom/jakewharton/DiskLruCache;->close()V

    .line 627
    iget-object v0, p0, Lcom/jakewharton/DiskLruCache;->directory:Ljava/io/File;

    invoke-static {v0}, Lcom/jakewharton/IoUtils;->deleteContents(Ljava/io/File;)V

    .line 628
    return-void
.end method

.method public edit(Ljava/lang/String;)Lcom/jakewharton/DiskLruCache$Editor;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 416
    const-wide/16 v0, -0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/jakewharton/DiskLruCache;->edit(Ljava/lang/String;J)Lcom/jakewharton/DiskLruCache$Editor;

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
    .line 591
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->checkNotClosed()V

    .line 592
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->trimToSize()V

    .line 593
    iget-object v0, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    invoke-virtual {v0}, Ljava/io/Writer;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 594
    monitor-exit p0

    return-void

    .line 591
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized get(Ljava/lang/String;)Lcom/jakewharton/DiskLruCache$Snapshot;
    .locals 11
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 376
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->checkNotClosed()V

    .line 377
    invoke-direct {p0, p1}, Lcom/jakewharton/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 378
    iget-object v2, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/jakewharton/DiskLruCache$Entry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 379
    .local v9, "entry":Lcom/jakewharton/DiskLruCache$Entry;
    if-nez v9, :cond_1

    .line 408
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v1

    .line 383
    :cond_1
    :try_start_1
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->readable:Z
    invoke-static {v9}, Lcom/jakewharton/DiskLruCache$Entry;->access$600(Lcom/jakewharton/DiskLruCache$Entry;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 392
    iget v2, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    new-array v6, v2, [Ljava/io/InputStream;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 394
    .local v6, "ins":[Ljava/io/InputStream;
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_1
    :try_start_2
    iget v2, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    if-ge v10, v2, :cond_2

    .line 395
    new-instance v2, Ljava/io/FileInputStream;

    invoke-virtual {v9, v10}, Lcom/jakewharton/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    aput-object v2, v6, v10
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 394
    add-int/lit8 v10, v10, 0x1

    goto :goto_1

    .line 397
    :catch_0
    move-exception v0

    .line 399
    .local v0, "e":Ljava/io/FileNotFoundException;
    goto :goto_0

    .line 402
    .end local v0    # "e":Ljava/io/FileNotFoundException;
    :cond_2
    :try_start_3
    iget v1, p0, Lcom/jakewharton/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/jakewharton/DiskLruCache;->redundantOpCount:I

    .line 403
    iget-object v1, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "READ "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 404
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->journalRebuildRequired()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 405
    iget-object v1, p0, Lcom/jakewharton/DiskLruCache;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    iget-object v2, p0, Lcom/jakewharton/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-virtual {v1, v2}, Ljava/util/concurrent/ThreadPoolExecutor;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 408
    :cond_3
    new-instance v1, Lcom/jakewharton/DiskLruCache$Snapshot;

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->sequenceNumber:J
    invoke-static {v9}, Lcom/jakewharton/DiskLruCache$Entry;->access$1200(Lcom/jakewharton/DiskLruCache$Entry;)J

    move-result-wide v4

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->lengths:[J
    invoke-static {v9}, Lcom/jakewharton/DiskLruCache$Entry;->access$1000(Lcom/jakewharton/DiskLruCache$Entry;)[J

    move-result-object v7

    const/4 v8, 0x0

    move-object v2, p0

    move-object v3, p1

    invoke-direct/range {v1 .. v8}, Lcom/jakewharton/DiskLruCache$Snapshot;-><init>(Lcom/jakewharton/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;[JLcom/jakewharton/DiskLruCache$1;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 376
    .end local v6    # "ins":[Ljava/io/InputStream;
    .end local v9    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    .end local v10    # "i":I
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized remove(Ljava/lang/String;)Z
    .locals 8
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 547
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->checkNotClosed()V

    .line 548
    invoke-direct {p0, p1}, Lcom/jakewharton/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 549
    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jakewharton/DiskLruCache$Entry;

    .line 550
    .local v0, "entry":Lcom/jakewharton/DiskLruCache$Entry;
    if-eqz v0, :cond_0

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->currentEditor:Lcom/jakewharton/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$700(Lcom/jakewharton/DiskLruCache$Entry;)Lcom/jakewharton/DiskLruCache$Editor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    if-eqz v3, :cond_1

    .line 551
    :cond_0
    const/4 v3, 0x0

    .line 571
    :goto_0
    monitor-exit p0

    return v3

    .line 554
    :cond_1
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    :try_start_1
    iget v3, p0, Lcom/jakewharton/DiskLruCache;->valueCount:I

    if-ge v2, v3, :cond_3

    .line 555
    invoke-virtual {v0, v2}, Lcom/jakewharton/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v1

    .line 556
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_2

    .line 557
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "failed to delete "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 547
    .end local v0    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    .end local v1    # "file":Ljava/io/File;
    .end local v2    # "i":I
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 559
    .restart local v0    # "entry":Lcom/jakewharton/DiskLruCache$Entry;
    .restart local v1    # "file":Ljava/io/File;
    .restart local v2    # "i":I
    :cond_2
    :try_start_2
    iget-wide v4, p0, Lcom/jakewharton/DiskLruCache;->size:J

    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->lengths:[J
    invoke-static {v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$1000(Lcom/jakewharton/DiskLruCache$Entry;)[J

    move-result-object v3

    aget-wide v6, v3, v2

    sub-long/2addr v4, v6

    iput-wide v4, p0, Lcom/jakewharton/DiskLruCache;->size:J

    .line 560
    # getter for: Lcom/jakewharton/DiskLruCache$Entry;->lengths:[J
    invoke-static {v0}, Lcom/jakewharton/DiskLruCache$Entry;->access$1000(Lcom/jakewharton/DiskLruCache$Entry;)[J

    move-result-object v3

    const-wide/16 v4, 0x0

    aput-wide v4, v3, v2

    .line 554
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 563
    .end local v1    # "file":Ljava/io/File;
    :cond_3
    iget v3, p0, Lcom/jakewharton/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/jakewharton/DiskLruCache;->redundantOpCount:I

    .line 564
    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->journalWriter:Ljava/io/Writer;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "REMOVE "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v5, 0xa

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    .line 565
    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, p1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 567
    invoke-direct {p0}, Lcom/jakewharton/DiskLruCache;->journalRebuildRequired()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 568
    iget-object v3, p0, Lcom/jakewharton/DiskLruCache;->executorService:Ljava/util/concurrent/ThreadPoolExecutor;

    iget-object v4, p0, Lcom/jakewharton/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-virtual {v3, v4}, Ljava/util/concurrent/ThreadPoolExecutor;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 571
    :cond_4
    const/4 v3, 0x1

    goto :goto_0
.end method
