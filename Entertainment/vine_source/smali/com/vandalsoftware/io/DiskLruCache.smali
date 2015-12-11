.class public final Lcom/vandalsoftware/io/DiskLruCache;
.super Ljava/lang/Object;
.source "DiskLruCache.java"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/vandalsoftware/io/DiskLruCache$Entry;,
        Lcom/vandalsoftware/io/DiskLruCache$Editor;,
        Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
    }
.end annotation


# static fields
.field private static final CLEAN:I = 0x1

.field private static final DIRTY:I = 0x2

.field private static final JOURNAL_FILE:Ljava/lang/String; = "journal"

.field private static final JOURNAL_FILE_TMP:Ljava/lang/String; = "journal.tmp"

.field private static final MAGIC:J = -0x7eb5b3baf2f5e5f6L

.field private static final READ:I = 0x4

.field private static final REDUNDANT_OP_COMPACT_THRESHOLD:I = 0x7d0

.field private static final REMOVE:I = 0x3

.field private static final VERSION:I = 0x2


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

.field private journalStream:Ljava/io/DataOutputStream;

.field private final lruEntries:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/vandalsoftware/io/DiskLruCache$Entry;",
            ">;"
        }
    .end annotation
.end field

.field private final maxSize:J

.field private redundantOpCount:I

.field private size:J

.field private final valueCount:I


# direct methods
.method private constructor <init>(Ljava/io/File;IIJ)V
    .locals 7
    .param p1, "directory"    # Ljava/io/File;
    .param p2, "appVersion"    # I
    .param p3, "valueCount"    # I
    .param p4, "maxSize"    # J

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 158
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 132
    new-instance v0, Ljava/util/LinkedHashMap;

    const/high16 v3, 0x3f400000    # 0.75f

    invoke-direct {v0, v1, v3, v2}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    iput-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    .line 137
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v3, 0x3c

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    iput-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    .line 139
    new-instance v0, Lcom/vandalsoftware/io/DiskLruCache$1;

    invoke-direct {v0, p0}, Lcom/vandalsoftware/io/DiskLruCache$1;-><init>(Lcom/vandalsoftware/io/DiskLruCache;)V

    iput-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    .line 154
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->size:J

    .line 159
    iput-object p1, p0, Lcom/vandalsoftware/io/DiskLruCache;->directory:Ljava/io/File;

    .line 160
    iput p2, p0, Lcom/vandalsoftware/io/DiskLruCache;->appVersion:I

    .line 161
    new-instance v0, Ljava/io/File;

    const-string v1, "journal"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalFile:Ljava/io/File;

    .line 162
    new-instance v0, Ljava/io/File;

    const-string v1, "journal.tmp"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalFileTmp:Ljava/io/File;

    .line 163
    iput p3, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    .line 164
    iput-wide p4, p0, Lcom/vandalsoftware/io/DiskLruCache;->maxSize:J

    .line 165
    return-void
.end method

.method static synthetic access$000(Lcom/vandalsoftware/io/DiskLruCache;)Ljava/io/DataOutputStream;
    .locals 1
    .param p0, "x0"    # Lcom/vandalsoftware/io/DiskLruCache;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    return-object v0
.end method

.method static synthetic access$100(Lcom/vandalsoftware/io/DiskLruCache;)V
    .locals 0
    .param p0, "x0"    # Lcom/vandalsoftware/io/DiskLruCache;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 80
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->trimToSize()V

    return-void
.end method

.method static synthetic access$1300(Lcom/vandalsoftware/io/DiskLruCache;Lcom/vandalsoftware/io/DiskLruCache$Editor;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/vandalsoftware/io/DiskLruCache;
    .param p1, "x1"    # Lcom/vandalsoftware/io/DiskLruCache$Editor;
    .param p2, "x2"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 80
    invoke-direct {p0, p1, p2}, Lcom/vandalsoftware/io/DiskLruCache;->completeEdit(Lcom/vandalsoftware/io/DiskLruCache$Editor;Z)V

    return-void
.end method

.method static synthetic access$1500(Lcom/vandalsoftware/io/DiskLruCache;)I
    .locals 1
    .param p0, "x0"    # Lcom/vandalsoftware/io/DiskLruCache;

    .prologue
    .line 80
    iget v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    return v0
.end method

.method static synthetic access$1600(Lcom/vandalsoftware/io/DiskLruCache;)Ljava/io/File;
    .locals 1
    .param p0, "x0"    # Lcom/vandalsoftware/io/DiskLruCache;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->directory:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$200(Lcom/vandalsoftware/io/DiskLruCache;)Z
    .locals 1
    .param p0, "x0"    # Lcom/vandalsoftware/io/DiskLruCache;

    .prologue
    .line 80
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->journalRebuildRequired()Z

    move-result v0

    return v0
.end method

.method static synthetic access$300(Lcom/vandalsoftware/io/DiskLruCache;)V
    .locals 0
    .param p0, "x0"    # Lcom/vandalsoftware/io/DiskLruCache;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 80
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->rebuildJournal()V

    return-void
.end method

.method private checkNotClosed()V
    .locals 2

    .prologue
    .line 552
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    if-nez v0, :cond_0

    .line 553
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "cache is closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 555
    :cond_0
    return-void
.end method

.method private declared-synchronized completeEdit(Lcom/vandalsoftware/io/DiskLruCache$Editor;Z)V
    .locals 12
    .param p1, "editor"    # Lcom/vandalsoftware/io/DiskLruCache$Editor;
    .param p2, "success"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 457
    monitor-enter p0

    :try_start_0
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Editor;->entry:Lcom/vandalsoftware/io/DiskLruCache$Entry;
    invoke-static {p1}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->access$1100(Lcom/vandalsoftware/io/DiskLruCache$Editor;)Lcom/vandalsoftware/io/DiskLruCache$Entry;

    move-result-object v2

    .line 458
    .local v2, "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$600(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    move-result-object v8

    if-eq v8, p1, :cond_0

    .line 459
    new-instance v8, Ljava/lang/IllegalStateException;

    invoke-direct {v8}, Ljava/lang/IllegalStateException;-><init>()V

    throw v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 457
    .end local v2    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    :catchall_0
    move-exception v8

    monitor-exit p0

    throw v8

    .line 463
    .restart local v2    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    :cond_0
    if-eqz p2, :cond_2

    :try_start_1
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->readable:Z
    invoke-static {v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$500(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 464
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    iget v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    if-ge v3, v8, :cond_2

    .line 465
    invoke-virtual {v2, v3}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v8

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_1

    .line 466
    invoke-virtual {p1}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->abort()V

    .line 467
    new-instance v8, Ljava/lang/IllegalStateException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "edit didn\'t create file "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 464
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 472
    .end local v3    # "i":I
    :cond_2
    const/4 v3, 0x0

    .restart local v3    # "i":I
    :goto_1
    iget v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    if-ge v3, v8, :cond_5

    .line 473
    invoke-virtual {v2, v3}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v1

    .line 474
    .local v1, "dirty":Ljava/io/File;
    if-eqz p2, :cond_4

    .line 475
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_3

    .line 476
    invoke-virtual {v2, v3}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v0

    .line 477
    .local v0, "clean":Ljava/io/File;
    invoke-static {v1, v0}, Lcom/vandalsoftware/io/IoUtils;->renameFileOrThrow(Ljava/io/File;Ljava/io/File;)V

    .line 478
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->lengths:[J
    invoke-static {v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$700(Lcom/vandalsoftware/io/DiskLruCache$Entry;)[J

    move-result-object v8

    aget-wide v6, v8, v3

    .line 479
    .local v6, "oldLength":J
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v4

    .line 480
    .local v4, "newLength":J
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->lengths:[J
    invoke-static {v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$700(Lcom/vandalsoftware/io/DiskLruCache$Entry;)[J

    move-result-object v8

    aput-wide v4, v8, v3

    .line 481
    iget-wide v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->size:J

    sub-long/2addr v8, v6

    add-long/2addr v8, v4

    iput-wide v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->size:J

    .line 472
    .end local v0    # "clean":Ljava/io/File;
    .end local v4    # "newLength":J
    .end local v6    # "oldLength":J
    :cond_3
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 484
    :cond_4
    invoke-static {v1}, Lcom/vandalsoftware/io/DiskLruCache;->deleteIfExists(Ljava/io/File;)Z

    goto :goto_2

    .line 488
    .end local v1    # "dirty":Ljava/io/File;
    :cond_5
    iget v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v8, v8, 0x1

    iput v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->redundantOpCount:I

    .line 489
    const/4 v8, 0x0

    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v2, v8}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$602(Lcom/vandalsoftware/io/DiskLruCache$Entry;Lcom/vandalsoftware/io/DiskLruCache$Editor;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    .line 490
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->readable:Z
    invoke-static {v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$500(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Z

    move-result v8

    or-int/2addr v8, p2

    if-eqz v8, :cond_8

    .line 491
    const/4 v8, 0x1

    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->readable:Z
    invoke-static {v2, v8}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$502(Lcom/vandalsoftware/io/DiskLruCache$Entry;Z)Z

    .line 492
    iget-object v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    invoke-direct {p0, v8, v2}, Lcom/vandalsoftware/io/DiskLruCache;->writeCleanEntry(Ljava/io/DataOutput;Lcom/vandalsoftware/io/DiskLruCache$Entry;)V

    .line 498
    :goto_3
    iget-wide v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->size:J

    iget-wide v10, p0, Lcom/vandalsoftware/io/DiskLruCache;->maxSize:J

    cmp-long v8, v8, v10

    if-gtz v8, :cond_6

    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->journalRebuildRequired()Z

    move-result v8

    if-eqz v8, :cond_7

    .line 499
    :cond_6
    iget-object v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v9, p0, Lcom/vandalsoftware/io/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v8, v9}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 501
    :cond_7
    monitor-exit p0

    return-void

    .line 494
    :cond_8
    :try_start_2
    iget-object v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->key:Ljava/lang/String;
    invoke-static {v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$900(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 495
    iget-object v8, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    const/4 v9, 0x3

    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->key:Ljava/lang/String;
    invoke-static {v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$900(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v8, v9, v10}, Lcom/vandalsoftware/io/DiskLruCache;->writeEntryKey(Ljava/io/DataOutput;ILjava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_3
.end method

.method private static deleteIfExists(Ljava/io/File;)Z
    .locals 1
    .param p0, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 213
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private journalRebuildRequired()Z
    .locals 2

    .prologue
    .line 508
    iget v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->redundantOpCount:I

    const/16 v1, 0x7d0

    if-lt v0, v1, :cond_0

    iget v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->redundantOpCount:I

    iget-object v1, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

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

.method public static open(Ljava/io/File;IIJ)Lcom/vandalsoftware/io/DiskLruCache;
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
    .line 178
    const-wide/16 v1, 0x0

    cmp-long v1, p3, v1

    if-gtz v1, :cond_0

    .line 179
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "maxSize <= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 181
    :cond_0
    if-gtz p2, :cond_1

    .line 182
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "valueCount <= 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 186
    :cond_1
    new-instance v0, Lcom/vandalsoftware/io/DiskLruCache;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/vandalsoftware/io/DiskLruCache;-><init>(Ljava/io/File;IIJ)V

    .line 187
    .local v0, "cache":Lcom/vandalsoftware/io/DiskLruCache;
    iget-object v1, v0, Lcom/vandalsoftware/io/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 189
    :try_start_0
    invoke-direct {v0}, Lcom/vandalsoftware/io/DiskLruCache;->readJournal()I

    move-result v7

    .line 190
    .local v7, "journalEntries":I
    invoke-direct {v0}, Lcom/vandalsoftware/io/DiskLruCache;->processJournal()V

    .line 191
    new-instance v1, Ljava/io/DataOutputStream;

    new-instance v2, Ljava/io/BufferedOutputStream;

    new-instance v3, Ljava/io/FileOutputStream;

    iget-object v4, v0, Lcom/vandalsoftware/io/DiskLruCache;->journalFile:Ljava/io/File;

    const/4 v5, 0x1

    invoke-direct {v3, v4, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    invoke-direct {v2, v3}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    invoke-direct {v1, v2}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    iput-object v1, v0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    .line 193
    iget-object v1, v0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->size()I

    move-result v1

    sub-int v1, v7, v1

    iput v1, v0, Lcom/vandalsoftware/io/DiskLruCache;->redundantOpCount:I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v6, v0

    .line 206
    .end local v0    # "cache":Lcom/vandalsoftware/io/DiskLruCache;
    .end local v7    # "journalEntries":I
    .local v6, "cache":Ljava/lang/Object;
    :goto_0
    return-object v6

    .line 195
    .end local v6    # "cache":Ljava/lang/Object;
    .restart local v0    # "cache":Lcom/vandalsoftware/io/DiskLruCache;
    :catch_0
    move-exception v8

    .line 196
    .local v8, "journalIsCorrupt":Ljava/io/IOException;
    const-string v1, "DiskLruCache"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " is corrupt: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v8}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", removing"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 198
    invoke-virtual {v0}, Lcom/vandalsoftware/io/DiskLruCache;->delete()V

    .line 203
    .end local v8    # "journalIsCorrupt":Ljava/io/IOException;
    :cond_2
    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    move-result v1

    if-nez v1, :cond_3

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 204
    :cond_3
    new-instance v0, Lcom/vandalsoftware/io/DiskLruCache;

    .end local v0    # "cache":Lcom/vandalsoftware/io/DiskLruCache;
    move-object v1, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/vandalsoftware/io/DiskLruCache;-><init>(Ljava/io/File;IIJ)V

    .line 205
    .restart local v0    # "cache":Lcom/vandalsoftware/io/DiskLruCache;
    invoke-direct {v0}, Lcom/vandalsoftware/io/DiskLruCache;->rebuildJournal()V

    move-object v6, v0

    .line 206
    .restart local v6    # "cache":Ljava/lang/Object;
    goto :goto_0

    .line 208
    .end local v6    # "cache":Ljava/lang/Object;
    :cond_4
    new-instance v1, Ljava/io/FileNotFoundException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "directory not found "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private processJournal()V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 294
    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalFileTmp:Ljava/io/File;

    invoke-static {v3}, Lcom/vandalsoftware/io/DiskLruCache;->deleteIfExists(Ljava/io/File;)Z

    .line 295
    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/vandalsoftware/io/DiskLruCache$Entry;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 296
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/vandalsoftware/io/DiskLruCache$Entry;

    .line 297
    .local v0, "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$600(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    move-result-object v3

    if-nez v3, :cond_1

    .line 298
    const/4 v2, 0x0

    .local v2, "t":I
    :goto_1
    iget v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    if-ge v2, v3, :cond_0

    .line 299
    iget-wide v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->size:J

    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->lengths:[J
    invoke-static {v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$700(Lcom/vandalsoftware/io/DiskLruCache$Entry;)[J

    move-result-object v5

    aget-wide v5, v5, v2

    add-long/2addr v3, v5

    iput-wide v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->size:J

    .line 298
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 302
    .end local v2    # "t":I
    :cond_1
    const/4 v3, 0x0

    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v0, v3}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$602(Lcom/vandalsoftware/io/DiskLruCache$Entry;Lcom/vandalsoftware/io/DiskLruCache$Editor;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    .line 303
    const/4 v2, 0x0

    .restart local v2    # "t":I
    :goto_2
    iget v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    if-ge v2, v3, :cond_2

    .line 304
    invoke-virtual {v0, v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lcom/vandalsoftware/io/DiskLruCache;->deleteIfExists(Ljava/io/File;)Z

    .line 305
    invoke-virtual {v0, v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v3

    invoke-static {v3}, Lcom/vandalsoftware/io/DiskLruCache;->deleteIfExists(Ljava/io/File;)Z

    .line 303
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 307
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 310
    .end local v0    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    .end local v2    # "t":I
    :cond_3
    return-void
.end method

.method private readJournal()I
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 223
    new-instance v8, Ljava/io/DataInputStream;

    new-instance v9, Ljava/io/BufferedInputStream;

    new-instance v10, Ljava/io/FileInputStream;

    iget-object v11, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-direct {v10, v11}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v9, v10}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v8, v9}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 226
    .local v8, "in":Ljava/io/DataInputStream;
    :try_start_0
    invoke-virtual {v8}, Ljava/io/DataInputStream;->readLong()J

    move-result-wide v4

    .line 227
    .local v4, "fileMagic":J
    invoke-virtual {v8}, Ljava/io/DataInputStream;->readUnsignedByte()I

    move-result v7

    .line 228
    .local v7, "fileVersion":I
    invoke-virtual {v8}, Ljava/io/DataInputStream;->readInt()I

    move-result v3

    .line 229
    .local v3, "fileAppVersion":I
    invoke-virtual {v8}, Ljava/io/DataInputStream;->readInt()I

    move-result v6

    .line 230
    .local v6, "fileValueCount":I
    invoke-virtual {v8}, Ljava/io/DataInputStream;->readByte()B

    move-result v0

    .line 231
    .local v0, "blank":B
    const-wide v9, -0x7eb5b3baf2f5e5f6L

    cmp-long v9, v9, v4

    if-nez v9, :cond_0

    const/4 v9, 0x2

    if-ne v9, v7, :cond_0

    iget v9, p0, Lcom/vandalsoftware/io/DiskLruCache;->appVersion:I

    if-ne v9, v3, :cond_0

    iget v9, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    if-ne v9, v6, :cond_0

    const/16 v9, 0xa

    if-eq v0, v9, :cond_1

    .line 236
    :cond_0
    new-instance v9, Ljava/io/IOException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "unexpected journal header: ["

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ", "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ", "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ", "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "]"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 251
    .end local v0    # "blank":B
    .end local v3    # "fileAppVersion":I
    .end local v4    # "fileMagic":J
    .end local v6    # "fileValueCount":I
    .end local v7    # "fileVersion":I
    :catchall_0
    move-exception v9

    invoke-static {v8}, Lcom/vandalsoftware/io/IoUtils;->closeQuietly(Ljava/io/Closeable;)V

    throw v9

    .line 240
    .restart local v0    # "blank":B
    .restart local v3    # "fileAppVersion":I
    .restart local v4    # "fileMagic":J
    .restart local v6    # "fileValueCount":I
    .restart local v7    # "fileVersion":I
    :cond_1
    const/4 v2, 0x0

    .line 243
    .local v2, "entries":I
    :goto_0
    :try_start_1
    invoke-direct {p0, v8}, Lcom/vandalsoftware/io/DiskLruCache;->readJournalLine(Ljava/io/DataInput;)V
    :try_end_1
    .catch Ljava/io/EOFException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 244
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 245
    :catch_0
    move-exception v1

    .line 251
    .local v1, "endOfJournal":Ljava/io/EOFException;
    invoke-static {v8}, Lcom/vandalsoftware/io/IoUtils;->closeQuietly(Ljava/io/Closeable;)V

    return v2
.end method

.method private readJournalLine(Ljava/io/DataInput;)V
    .locals 11
    .param p1, "in"    # Ljava/io/DataInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    const/4 v8, 0x0

    const/16 v7, 0xa

    .line 256
    invoke-interface {p1}, Ljava/io/DataInput;->readUnsignedByte()I

    move-result v3

    .line 257
    .local v3, "op":I
    invoke-interface {p1}, Ljava/io/DataInput;->readUTF()Ljava/lang/String;

    move-result-object v2

    .line 258
    .local v2, "key":Ljava/lang/String;
    const/4 v5, 0x3

    if-ne v3, v5, :cond_1

    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v5

    if-ne v5, v7, :cond_1

    .line 259
    iget-object v5, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v5, v2}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 287
    :cond_0
    :goto_0
    return-void

    .line 263
    :cond_1
    iget-object v5, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v5, v2}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/vandalsoftware/io/DiskLruCache$Entry;

    .line 264
    .local v0, "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    if-nez v0, :cond_2

    .line 265
    new-instance v0, Lcom/vandalsoftware/io/DiskLruCache$Entry;

    .end local v0    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    invoke-direct {v0, p0, v2, v8}, Lcom/vandalsoftware/io/DiskLruCache$Entry;-><init>(Lcom/vandalsoftware/io/DiskLruCache;Ljava/lang/String;Lcom/vandalsoftware/io/DiskLruCache$1;)V

    .line 266
    .restart local v0    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    iget-object v5, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v5, v2, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 269
    :cond_2
    if-ne v3, v10, :cond_5

    .line 270
    iget v5, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    new-array v4, v5, [J

    .line 271
    .local v4, "temp":[J
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget v5, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    if-ge v1, v5, :cond_3

    .line 272
    invoke-interface {p1}, Ljava/io/DataInput;->readLong()J

    move-result-wide v5

    aput-wide v5, v4, v1

    .line 271
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 274
    :cond_3
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v5

    if-eq v5, v7, :cond_4

    .line 275
    new-instance v5, Ljava/io/IOException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "unexpected journal entry: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 277
    :cond_4
    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->readable:Z
    invoke-static {v0, v10}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$502(Lcom/vandalsoftware/io/DiskLruCache$Entry;Z)Z

    .line 278
    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v0, v8}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$602(Lcom/vandalsoftware/io/DiskLruCache$Entry;Lcom/vandalsoftware/io/DiskLruCache$Editor;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    .line 279
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->lengths:[J
    invoke-static {v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$700(Lcom/vandalsoftware/io/DiskLruCache$Entry;)[J

    move-result-object v5

    iget v6, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    invoke-static {v4, v9, v5, v9, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_0

    .line 280
    .end local v1    # "i":I
    .end local v4    # "temp":[J
    :cond_5
    const/4 v5, 0x2

    if-ne v3, v5, :cond_6

    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v5

    if-ne v5, v7, :cond_6

    .line 281
    new-instance v5, Lcom/vandalsoftware/io/DiskLruCache$Editor;

    invoke-direct {v5, p0, v0, v8}, Lcom/vandalsoftware/io/DiskLruCache$Editor;-><init>(Lcom/vandalsoftware/io/DiskLruCache;Lcom/vandalsoftware/io/DiskLruCache$Entry;Lcom/vandalsoftware/io/DiskLruCache$1;)V

    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v0, v5}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$602(Lcom/vandalsoftware/io/DiskLruCache$Entry;Lcom/vandalsoftware/io/DiskLruCache$Editor;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    goto :goto_0

    .line 282
    :cond_6
    const/4 v5, 0x4

    if-ne v3, v5, :cond_7

    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v5

    if-eq v5, v7, :cond_0

    .line 285
    :cond_7
    new-instance v5, Ljava/io/IOException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "unexpected journal entry: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v5
.end method

.method private declared-synchronized rebuildJournal()V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 317
    monitor-enter p0

    :try_start_0
    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    if-eqz v3, :cond_0

    .line 318
    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    invoke-virtual {v3}, Ljava/io/DataOutputStream;->close()V

    .line 321
    :cond_0
    new-instance v2, Ljava/io/DataOutputStream;

    new-instance v3, Ljava/io/BufferedOutputStream;

    new-instance v4, Ljava/io/FileOutputStream;

    iget-object v5, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalFileTmp:Ljava/io/File;

    invoke-direct {v4, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v3, v4}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    invoke-direct {v2, v3}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 324
    .local v2, "out":Ljava/io/DataOutputStream;
    const-wide v3, -0x7eb5b3baf2f5e5f6L

    :try_start_1
    invoke-virtual {v2, v3, v4}, Ljava/io/DataOutputStream;->writeLong(J)V

    .line 325
    const/4 v3, 0x2

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeByte(I)V

    .line 326
    iget v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->appVersion:I

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 327
    iget v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 328
    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Ljava/io/DataOutputStream;->writeByte(I)V

    .line 330
    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

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

    check-cast v0, Lcom/vandalsoftware/io/DiskLruCache$Entry;

    .line 331
    .local v0, "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$600(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 332
    const/4 v3, 0x2

    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->key:Ljava/lang/String;
    invoke-static {v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$900(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v2, v3, v4}, Lcom/vandalsoftware/io/DiskLruCache;->writeEntryKey(Ljava/io/DataOutput;ILjava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 338
    .end local v0    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v3

    :try_start_2
    invoke-virtual {v2}, Ljava/io/DataOutputStream;->close()V

    throw v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 317
    .end local v2    # "out":Ljava/io/DataOutputStream;
    :catchall_1
    move-exception v3

    monitor-exit p0

    throw v3

    .line 334
    .restart local v0    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "out":Ljava/io/DataOutputStream;
    :cond_1
    :try_start_3
    invoke-direct {p0, v2, v0}, Lcom/vandalsoftware/io/DiskLruCache;->writeCleanEntry(Ljava/io/DataOutput;Lcom/vandalsoftware/io/DiskLruCache$Entry;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 338
    .end local v0    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    :cond_2
    :try_start_4
    invoke-virtual {v2}, Ljava/io/DataOutputStream;->close()V

    .line 340
    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalFileTmp:Ljava/io/File;

    iget-object v4, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalFile:Ljava/io/File;

    invoke-static {v3, v4}, Lcom/vandalsoftware/io/IoUtils;->renameFileOrThrow(Ljava/io/File;Ljava/io/File;)V

    .line 341
    new-instance v3, Ljava/io/DataOutputStream;

    new-instance v4, Ljava/io/BufferedOutputStream;

    new-instance v5, Ljava/io/FileOutputStream;

    iget-object v6, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalFile:Ljava/io/File;

    const/4 v7, 0x1

    invoke-direct {v5, v6, v7}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    invoke-direct {v4, v5}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    invoke-direct {v3, v4}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    iput-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    .line 343
    const/4 v3, 0x0

    iput v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->redundantOpCount:I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 344
    monitor-exit p0

    return-void
.end method

.method private trimToSize()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 584
    :goto_0
    iget-wide v1, p0, Lcom/vandalsoftware/io/DiskLruCache;->size:J

    iget-wide v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->maxSize:J

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    .line 585
    iget-object v1, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 586
    .local v0, "toEvict":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/vandalsoftware/io/DiskLruCache$Entry;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p0, v1}, Lcom/vandalsoftware/io/DiskLruCache;->remove(Ljava/lang/String;)Z

    goto :goto_0

    .line 588
    .end local v0    # "toEvict":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/vandalsoftware/io/DiskLruCache$Entry;>;"
    :cond_0
    return-void
.end method

.method private validateKey(Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 602
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

    .line 603
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "keys must not contain spaces or newlines: \""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 606
    :cond_1
    return-void
.end method

.method private writeCleanEntry(Ljava/io/DataOutput;Lcom/vandalsoftware/io/DiskLruCache$Entry;)V
    .locals 6
    .param p1, "out"    # Ljava/io/DataOutput;
    .param p2, "entry"    # Lcom/vandalsoftware/io/DiskLruCache$Entry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 353
    const/4 v5, 0x1

    invoke-interface {p1, v5}, Ljava/io/DataOutput;->writeByte(I)V

    .line 354
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->key:Ljava/lang/String;
    invoke-static {p2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$900(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {p1, v5}, Ljava/io/DataOutput;->writeUTF(Ljava/lang/String;)V

    .line 355
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->lengths:[J
    invoke-static {p2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$700(Lcom/vandalsoftware/io/DiskLruCache$Entry;)[J

    move-result-object v0

    .local v0, "arr$":[J
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v4, :cond_0

    aget-wide v2, v0, v1

    .line 356
    .local v2, "len":J
    invoke-interface {p1, v2, v3}, Ljava/io/DataOutput;->writeLong(J)V

    .line 355
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 358
    .end local v2    # "len":J
    :cond_0
    const/16 v5, 0xa

    invoke-interface {p1, v5}, Ljava/io/DataOutput;->writeByte(I)V

    .line 359
    return-void
.end method

.method private writeEntryKey(Ljava/io/DataOutput;ILjava/lang/String;)V
    .locals 1
    .param p1, "out"    # Ljava/io/DataOutput;
    .param p2, "s"    # I
    .param p3, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 347
    invoke-interface {p1, p2}, Ljava/io/DataOutput;->writeByte(I)V

    .line 348
    invoke-interface {p1, p3}, Ljava/io/DataOutput;->writeUTF(Ljava/lang/String;)V

    .line 349
    const/16 v0, 0xa

    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeByte(I)V

    .line 350
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
    .line 570
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v2, :cond_0

    .line 581
    :goto_0
    monitor-exit p0

    return-void

    .line 573
    :cond_0
    :try_start_1
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

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

    check-cast v0, Lcom/vandalsoftware/io/DiskLruCache$Entry;

    .line 574
    .local v0, "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$600(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 575
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$600(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    move-result-object v2

    invoke-virtual {v2}, Lcom/vandalsoftware/io/DiskLruCache$Editor;->abort()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 570
    .end local v0    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 578
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_2
    :try_start_2
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->trimToSize()V

    .line 579
    iget-object v2, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    invoke-virtual {v2}, Ljava/io/DataOutputStream;->close()V

    .line 580
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;
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
    .line 595
    invoke-virtual {p0}, Lcom/vandalsoftware/io/DiskLruCache;->close()V

    .line 596
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->directory:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 597
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->directory:Ljava/io/File;

    invoke-static {v0}, Lcom/vandalsoftware/io/IoUtils;->deleteContents(Ljava/io/File;)V

    .line 599
    :cond_0
    return-void
.end method

.method public declared-synchronized edit(Ljava/lang/String;)Lcom/vandalsoftware/io/DiskLruCache$Editor;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 415
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->checkNotClosed()V

    .line 416
    invoke-direct {p0, p1}, Lcom/vandalsoftware/io/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 417
    iget-object v2, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/vandalsoftware/io/DiskLruCache$Entry;

    .line 418
    .local v1, "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    if-nez v1, :cond_1

    .line 419
    new-instance v1, Lcom/vandalsoftware/io/DiskLruCache$Entry;

    .end local v1    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    const/4 v2, 0x0

    invoke-direct {v1, p0, p1, v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;-><init>(Lcom/vandalsoftware/io/DiskLruCache;Ljava/lang/String;Lcom/vandalsoftware/io/DiskLruCache$1;)V

    .line 420
    .restart local v1    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    iget-object v2, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v2, p1, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 425
    :cond_0
    new-instance v0, Lcom/vandalsoftware/io/DiskLruCache$Editor;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v2}, Lcom/vandalsoftware/io/DiskLruCache$Editor;-><init>(Lcom/vandalsoftware/io/DiskLruCache;Lcom/vandalsoftware/io/DiskLruCache$Entry;Lcom/vandalsoftware/io/DiskLruCache$1;)V

    .line 426
    .local v0, "editor":Lcom/vandalsoftware/io/DiskLruCache$Editor;
    # setter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v1, v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$602(Lcom/vandalsoftware/io/DiskLruCache$Entry;Lcom/vandalsoftware/io/DiskLruCache$Editor;)Lcom/vandalsoftware/io/DiskLruCache$Editor;

    .line 429
    iget-object v2, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    const/4 v3, 0x2

    invoke-direct {p0, v2, v3, p1}, Lcom/vandalsoftware/io/DiskLruCache;->writeEntryKey(Ljava/io/DataOutput;ILjava/lang/String;)V

    .line 430
    iget-object v2, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    invoke-virtual {v2}, Ljava/io/DataOutputStream;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 431
    .end local v0    # "editor":Lcom/vandalsoftware/io/DiskLruCache$Editor;
    :goto_0
    monitor-exit p0

    return-object v0

    .line 421
    :cond_1
    :try_start_1
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v1}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$600(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Lcom/vandalsoftware/io/DiskLruCache$Editor;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v2

    if-eqz v2, :cond_0

    goto :goto_0

    .line 415
    .end local v1    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 561
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->checkNotClosed()V

    .line 562
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->trimToSize()V

    .line 563
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    invoke-virtual {v0}, Ljava/io/DataOutputStream;->flush()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 564
    monitor-exit p0

    return-void

    .line 561
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized get(Ljava/lang/String;)Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 408
    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    invoke-virtual {p0, p1, v0}, Lcom/vandalsoftware/io/DiskLruCache;->get(Ljava/lang/String;Z)Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized get(Ljava/lang/String;Z)Lcom/vandalsoftware/io/DiskLruCache$Snapshot;
    .locals 8
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "peek"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 366
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->checkNotClosed()V

    .line 367
    invoke-direct {p0, p1}, Lcom/vandalsoftware/io/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 368
    iget-object v7, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v7, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/vandalsoftware/io/DiskLruCache$Entry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 369
    .local v1, "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    if-nez v1, :cond_1

    .line 404
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v6

    .line 373
    :cond_1
    :try_start_1
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->readable:Z
    invoke-static {v1}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$500(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 382
    iget v7, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    new-array v4, v7, [Ljava/io/InputStream;

    .line 383
    .local v4, "ins":[Ljava/io/InputStream;
    iget v7, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    new-array v5, v7, [Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 386
    .local v5, "paths":[Ljava/lang/String;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    :try_start_2
    iget v7, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    if-ge v3, v7, :cond_2

    .line 387
    invoke-virtual {v1, v3}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v2

    .line 388
    .local v2, "file":Ljava/io/File;
    new-instance v7, Ljava/io/FileInputStream;

    invoke-direct {v7, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    aput-object v7, v4, v3

    .line 389
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v3
    :try_end_2
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 386
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 391
    .end local v2    # "file":Ljava/io/File;
    :catch_0
    move-exception v0

    .line 393
    .local v0, "e":Ljava/io/FileNotFoundException;
    goto :goto_0

    .line 396
    .end local v0    # "e":Ljava/io/FileNotFoundException;
    :cond_2
    if-nez p2, :cond_3

    .line 397
    :try_start_3
    iget v6, p0, Lcom/vandalsoftware/io/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v6, v6, 0x1

    iput v6, p0, Lcom/vandalsoftware/io/DiskLruCache;->redundantOpCount:I

    .line 398
    iget-object v6, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    const/4 v7, 0x4

    invoke-direct {p0, v6, v7, p1}, Lcom/vandalsoftware/io/DiskLruCache;->writeEntryKey(Ljava/io/DataOutput;ILjava/lang/String;)V

    .line 399
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->journalRebuildRequired()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 400
    iget-object v6, p0, Lcom/vandalsoftware/io/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v7, p0, Lcom/vandalsoftware/io/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v6, v7}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    .line 404
    :cond_3
    new-instance v6, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;

    const/4 v7, 0x0

    invoke-direct {v6, v4, v5, v7}, Lcom/vandalsoftware/io/DiskLruCache$Snapshot;-><init>([Ljava/io/InputStream;[Ljava/lang/String;Lcom/vandalsoftware/io/DiskLruCache$1;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 366
    .end local v1    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    .end local v3    # "i":I
    .end local v4    # "ins":[Ljava/io/InputStream;
    .end local v5    # "paths":[Ljava/lang/String;
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6
.end method

.method public getDirectory()Ljava/io/File;
    .locals 1

    .prologue
    .line 438
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->directory:Ljava/io/File;

    return-object v0
.end method

.method public getLruEntries()Ljava/util/LinkedHashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/vandalsoftware/io/DiskLruCache$Entry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 609
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    return-object v0
.end method

.method public isClosed()Z
    .locals 1

    .prologue
    .line 548
    iget-object v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

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
    .line 445
    iget-wide v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->maxSize:J

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
    .line 519
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->checkNotClosed()V

    .line 520
    invoke-direct {p0, p1}, Lcom/vandalsoftware/io/DiskLruCache;->validateKey(Ljava/lang/String;)V

    .line 521
    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/vandalsoftware/io/DiskLruCache$Entry;

    .line 522
    .local v0, "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    if-eqz v0, :cond_0

    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->currentEditor:Lcom/vandalsoftware/io/DiskLruCache$Editor;
    invoke-static {v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$600(Lcom/vandalsoftware/io/DiskLruCache$Entry;)Lcom/vandalsoftware/io/DiskLruCache$Editor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    if-eqz v3, :cond_1

    .line 523
    :cond_0
    const/4 v3, 0x0

    .line 541
    :goto_0
    monitor-exit p0

    return v3

    .line 526
    :cond_1
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    :try_start_1
    iget v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->valueCount:I

    if-ge v2, v3, :cond_2

    .line 527
    invoke-virtual {v0, v2}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v1

    .line 528
    .local v1, "file":Ljava/io/File;
    invoke-static {v1}, Lcom/vandalsoftware/io/IoUtils;->deleteFileOrThrow(Ljava/io/File;)V

    .line 529
    iget-wide v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->size:J

    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->lengths:[J
    invoke-static {v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$700(Lcom/vandalsoftware/io/DiskLruCache$Entry;)[J

    move-result-object v5

    aget-wide v5, v5, v2

    sub-long/2addr v3, v5

    iput-wide v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->size:J

    .line 530
    # getter for: Lcom/vandalsoftware/io/DiskLruCache$Entry;->lengths:[J
    invoke-static {v0}, Lcom/vandalsoftware/io/DiskLruCache$Entry;->access$700(Lcom/vandalsoftware/io/DiskLruCache$Entry;)[J

    move-result-object v3

    const-wide/16 v4, 0x0

    aput-wide v4, v3, v2

    .line 526
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 533
    .end local v1    # "file":Ljava/io/File;
    :cond_2
    iget v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->redundantOpCount:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->redundantOpCount:I

    .line 534
    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->journalStream:Ljava/io/DataOutputStream;

    const/4 v4, 0x3

    invoke-direct {p0, v3, v4, p1}, Lcom/vandalsoftware/io/DiskLruCache;->writeEntryKey(Ljava/io/DataOutput;ILjava/lang/String;)V

    .line 535
    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->lruEntries:Ljava/util/LinkedHashMap;

    invoke-virtual {v3, p1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 537
    invoke-direct {p0}, Lcom/vandalsoftware/io/DiskLruCache;->journalRebuildRequired()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 538
    iget-object v3, p0, Lcom/vandalsoftware/io/DiskLruCache;->executorService:Ljava/util/concurrent/ExecutorService;

    iget-object v4, p0, Lcom/vandalsoftware/io/DiskLruCache;->cleanupCallable:Ljava/util/concurrent/Callable;

    invoke-interface {v3, v4}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 541
    :cond_3
    const/4 v3, 0x1

    goto :goto_0

    .line 519
    .end local v0    # "entry":Lcom/vandalsoftware/io/DiskLruCache$Entry;
    .end local v2    # "i":I
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized size()J
    .locals 2

    .prologue
    .line 453
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/vandalsoftware/io/DiskLruCache;->size:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
