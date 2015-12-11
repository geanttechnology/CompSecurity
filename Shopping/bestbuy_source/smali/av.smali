.class public final Lav;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Ljava/util/concurrent/ScheduledExecutorService;

.field private final c:Ljava/lang/Thread$UncaughtExceptionHandler;

.field private volatile d:Lao;

.field private final e:Laz;

.field private final f:Lba;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Thread$UncaughtExceptionHandler;)V
    .locals 1

    .prologue
    .line 47
    sget-object v0, Laz;->a:Laz;

    invoke-direct {p0, p1, p2, p3, v0}, Lav;-><init>(Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Thread$UncaughtExceptionHandler;Laz;)V

    .line 48
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Thread$UncaughtExceptionHandler;Laz;)V
    .locals 2

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lav;->a:Landroid/content/Context;

    .line 39
    iput-object p2, p0, Lav;->b:Ljava/util/concurrent/ScheduledExecutorService;

    .line 40
    iput-object p3, p0, Lav;->c:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 41
    iput-object p4, p0, Lav;->e:Laz;

    .line 42
    new-instance v0, Lba;

    const/16 v1, 0x63

    invoke-direct {v0, v1}, Lba;-><init>(I)V

    iput-object v0, p0, Lav;->f:Lba;

    .line 43
    return-void
.end method

.method static synthetic a(Lav;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lav;->a:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic a(Landroid/content/Context;)Ljava/io/File;
    .locals 1

    .prologue
    .line 26
    invoke-static {p0}, Lav;->b(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method private a(Lbd;)V
    .locals 6

    .prologue
    .line 152
    const-string v0, "bcs"

    invoke-virtual {p1, v0}, Lbd;->a(Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->f()Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->d()Lbd;

    .line 155
    const/4 v0, 0x0

    .line 156
    iget-object v1, p0, Lav;->f:Lba;

    invoke-virtual {v1}, Lba;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lat;

    .line 157
    if-eqz v1, :cond_0

    .line 158
    invoke-virtual {p1}, Lbd;->a()Lbd;

    .line 160
    :cond_0
    invoke-virtual {p1}, Lbd;->b()Lbd;

    move-result-object v1

    const-string v3, "ts"

    iget-wide v4, v0, Lat;->a:J

    invoke-virtual {v1, v3, v4, v5}, Lbd;->a(Ljava/lang/String;J)Lbd;

    move-result-object v1

    invoke-virtual {v1}, Lbd;->a()Lbd;

    move-result-object v1

    const-string v3, "text"

    iget-object v0, v0, Lat;->b:Ljava/lang/String;

    invoke-virtual {v1, v3, v0}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->c()Lbd;

    .line 165
    const/4 v0, 0x1

    move v1, v0

    goto :goto_0

    .line 167
    :cond_1
    invoke-virtual {p1}, Lbd;->e()Lbd;

    .line 168
    return-void
.end method

.method private static b(Landroid/content/Context;)Ljava/io/File;
    .locals 3

    .prologue
    .line 317
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/crash-reports"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method private static b(Lbd;)V
    .locals 3

    .prologue
    .line 172
    sget-object v0, Ll;->c:Ll;

    if-nez v0, :cond_1

    .line 192
    :cond_0
    :goto_0
    return-void

    .line 173
    :cond_1
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->o:La;

    invoke-virtual {v0}, La;->b()Ljava/util/Map;

    move-result-object v1

    .line 174
    if-eqz v1, :cond_0

    .line 176
    invoke-virtual {p0}, Lbd;->a()Lbd;

    .line 178
    const-string v0, "userdata"

    invoke-virtual {p0, v0}, Lbd;->a(Ljava/lang/String;)Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->f()Lbd;

    move-result-object v0

    invoke-virtual {v0}, Lbd;->b()Lbd;

    .line 182
    const/4 v0, 0x0

    .line 183
    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v1, v0

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 184
    if-eqz v1, :cond_2

    .line 185
    invoke-virtual {p0}, Lbd;->a()Lbd;

    .line 187
    :cond_2
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0, v1, v0}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    .line 188
    const/4 v0, 0x1

    move v1, v0

    goto :goto_1

    .line 191
    :cond_3
    invoke-virtual {p0}, Lbd;->c()Lbd;

    goto :goto_0
.end method


# virtual methods
.method public final a()I
    .locals 2

    .prologue
    .line 195
    iget-object v0, p0, Lav;->a:Landroid/content/Context;

    invoke-static {v0}, Lav;->b(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    .line 197
    new-instance v1, Lav$1;

    invoke-direct {v1, p0}, Lav$1;-><init>(Lav;)V

    invoke-virtual {v0, v1}, Ljava/io/File;->listFiles(Ljava/io/FilenameFilter;)[Ljava/io/File;

    move-result-object v0

    .line 204
    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    array-length v0, v0

    goto :goto_0
.end method

.method public final a(Lao;)V
    .locals 0

    .prologue
    .line 321
    iput-object p1, p0, Lav;->d:Lao;

    .line 322
    return-void
.end method

.method public final a(Lao;Lah;)V
    .locals 2

    .prologue
    .line 213
    iget-object v0, p0, Lav;->b:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v1, Law;

    invoke-direct {v1, p0, p1, p2}, Law;-><init>(Lav;Lao;Lah;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ScheduledExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 214
    return-void
.end method

.method public final uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 8

    .prologue
    .line 54
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v4

    .line 56
    :try_start_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Writing stack trace to disk from thread: ["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 57
    iget-object v0, p0, Lav;->a:Landroid/content/Context;

    invoke-static {v0}, Lav;->b(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_4

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v1

    if-nez v1, :cond_3

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unable to create output directory: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ". Not writing crash reports..."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 65
    :goto_0
    :try_start_2
    sget-object v0, Ll;->c:Ll;

    .line 66
    if-eqz v0, :cond_0

    .line 67
    invoke-virtual {v0}, Ll;->a()V

    .line 70
    :cond_0
    iget-object v0, p0, Lav;->d:Lao;

    if-eqz v0, :cond_1

    .line 71
    iget-object v0, p0, Lav;->d:Lao;

    invoke-virtual {v0}, Lao;->b()V

    .line 72
    iget-object v0, p0, Lav;->d:Lao;

    invoke-virtual {v0}, Lao;->e()V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 78
    :cond_1
    :goto_1
    iget-object v0, p0, Lav;->c:Ljava/lang/Thread$UncaughtExceptionHandler;

    if-eqz v0, :cond_2

    .line 79
    iget-object v0, p0, Lav;->c:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v0, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 82
    :cond_2
    return-void

    .line 57
    :cond_3
    :try_start_3
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Created output directory: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V

    :cond_4
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/crash-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v3

    const/4 v2, 0x0

    :try_start_4
    new-instance v1, Ljava/io/OutputStreamWriter;

    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-direct {v1, v0}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    :try_start_5
    new-instance v0, Lbd;

    invoke-direct {v0, v1}, Lbd;-><init>(Ljava/io/Writer;)V

    invoke-virtual {v0}, Lbd;->b()Lbd;

    move-result-object v2

    const-string v6, "type"

    const-string v7, "crash-report"

    invoke-virtual {v2, v6, v7}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v2

    invoke-virtual {v2}, Lbd;->a()Lbd;

    sget-object v2, Ll;->d:Lb$1;

    if-eqz v2, :cond_5

    sget-object v2, Ll;->d:Lb$1;

    invoke-virtual {v2}, Lb$1;->g()J

    move-result-wide v6

    const-string v2, "ec"

    invoke-virtual {v0, v2, v6, v7}, Lbd;->a(Ljava/lang/String;J)Lbd;

    move-result-object v2

    invoke-virtual {v2}, Lbd;->a()Lbd;

    :cond_5
    const-string v2, "Adding device specific information to json packet"

    invoke-static {v2}, Lbc;->a(Ljava/lang/String;)V

    sget-object v2, Ll;->c:Ll;

    if-eqz v2, :cond_6

    sget-object v2, Ll;->c:Ll;

    iget-object v2, v2, Ll;->n:Lam;

    invoke-virtual {v2, v0}, Lam;->a(Lbd;)V

    invoke-virtual {v0}, Lbd;->a()Lbd;

    sget-object v2, Ll;->c:Ll;

    iget-object v2, v2, Ll;->n:Lam;

    invoke-virtual {v2, v0}, Lam;->b(Lbd;)V

    invoke-virtual {v0}, Lbd;->a()Lbd;

    :cond_6
    const-string v2, "androidCrashReport"

    invoke-virtual {v0, v2}, Lbd;->a(Ljava/lang/String;)Lbd;

    move-result-object v2

    invoke-virtual {v2}, Lbd;->f()Lbd;

    invoke-virtual {v0}, Lbd;->b()Lbd;

    move-result-object v2

    const-string v6, "stackTrace"

    invoke-virtual {v2, v6}, Lbd;->a(Ljava/lang/String;)Lbd;

    move-result-object v2

    invoke-virtual {v2}, Lbd;->f()Lbd;

    move-result-object v2

    const/4 v6, 0x1

    invoke-virtual {v2, p2, v6}, Lbd;->a(Ljava/lang/Throwable;Z)Lbd;

    move-result-object v2

    invoke-virtual {v2}, Lbd;->a()Lbd;

    move-result-object v2

    const-string v6, "thread"

    invoke-virtual {p1}, Ljava/lang/Thread;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v6, v7}, Lbd;->a(Ljava/lang/String;Ljava/lang/String;)Lbd;

    move-result-object v2

    invoke-virtual {v2}, Lbd;->a()Lbd;

    move-result-object v2

    const-string v6, "time"

    invoke-virtual {v2, v6, v4, v5}, Lbd;->a(Ljava/lang/String;J)Lbd;

    move-result-object v2

    invoke-virtual {v2}, Lbd;->c()Lbd;

    move-result-object v2

    invoke-virtual {v2}, Lbd;->a()Lbd;

    invoke-direct {p0, v0}, Lav;->a(Lbd;)V

    invoke-static {v0}, Lav;->b(Lbd;)V

    invoke-virtual {v0}, Lbd;->c()Lbd;

    invoke-virtual {v1}, Ljava/io/OutputStreamWriter;->flush()V

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "Completed writing contents to file: "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    :try_start_6
    invoke-static {v1}, Lbc;->a(Ljava/io/Closeable;)V
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_0

    .line 60
    :catch_0
    move-exception v0

    .line 59
    :try_start_7
    const-string v1, "Error trying to write stacktrace to disk.."

    invoke-static {v1, v0}, Lbc;->a(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_0

    .line 78
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lav;->c:Ljava/lang/Thread$UncaughtExceptionHandler;

    if-eqz v1, :cond_7

    .line 79
    iget-object v1, p0, Lav;->c:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v1, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    :cond_7
    throw v0

    .line 57
    :catch_1
    move-exception v0

    move-object v1, v2

    :goto_2
    :try_start_8
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "Exception trying to write to file: "

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v0}, Lbc;->b(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    :try_start_9
    invoke-static {v1}, Lbc;->a(Ljava/io/Closeable;)V

    goto/16 :goto_0

    :catchall_1
    move-exception v0

    move-object v1, v2

    :goto_3
    invoke-static {v1}, Lbc;->a(Ljava/io/Closeable;)V

    throw v0
    :try_end_9
    .catch Ljava/lang/Throwable; {:try_start_9 .. :try_end_9} :catch_0
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 74
    :catch_2
    move-exception v0

    .line 75
    :try_start_a
    const-string v1, "Exception trying to clear up the beacon queue..."

    invoke-static {v1, v0}, Lbc;->b(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    goto/16 :goto_1

    .line 57
    :catchall_2
    move-exception v0

    goto :goto_3

    :catch_3
    move-exception v0

    goto :goto_2
.end method
