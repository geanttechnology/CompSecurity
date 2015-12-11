.class final Lcom/google/analytics/tracking/android/ae;
.super Ljava/lang/Thread;
.source "SourceFile"

# interfaces
.implements Lcom/google/analytics/tracking/android/h;


# static fields
.field private static g:Lcom/google/analytics/tracking/android/ae;


# instance fields
.field private final a:Ljava/util/concurrent/LinkedBlockingQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/LinkedBlockingQueue",
            "<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field

.field private volatile b:Z

.field private volatile c:Z

.field private volatile d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/analytics/internal/Command;",
            ">;"
        }
    .end annotation
.end field

.field private volatile e:Ljava/lang/String;

.field private volatile f:Ljava/lang/String;

.field private volatile h:Lcom/google/analytics/tracking/android/aw;

.field private final i:Landroid/content/Context;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 67
    const-string v0, "GAThread"

    invoke-direct {p0, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    .line 45
    new-instance v0, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v0}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ae;->a:Ljava/util/concurrent/LinkedBlockingQueue;

    .line 48
    iput-boolean v1, p0, Lcom/google/analytics/tracking/android/ae;->b:Z

    .line 49
    iput-boolean v1, p0, Lcom/google/analytics/tracking/android/ae;->c:Z

    .line 68
    if-eqz p1, :cond_0

    .line 69
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ae;->i:Landroid/content/Context;

    .line 73
    :goto_0
    invoke-virtual {p0}, Lcom/google/analytics/tracking/android/ae;->start()V

    .line 74
    return-void

    .line 71
    :cond_0
    iput-object p1, p0, Lcom/google/analytics/tracking/android/ae;->i:Landroid/content/Context;

    goto :goto_0
.end method

.method static a(Landroid/content/Context;)Lcom/google/analytics/tracking/android/ae;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/google/analytics/tracking/android/ae;->g:Lcom/google/analytics/tracking/android/ae;

    if-nez v0, :cond_0

    .line 60
    new-instance v0, Lcom/google/analytics/tracking/android/ae;

    invoke-direct {v0, p0}, Lcom/google/analytics/tracking/android/ae;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/google/analytics/tracking/android/ae;->g:Lcom/google/analytics/tracking/android/ae;

    .line 62
    :cond_0
    sget-object v0, Lcom/google/analytics/tracking/android/ae;->g:Lcom/google/analytics/tracking/android/ae;

    return-object v0
.end method

.method static synthetic a(Lcom/google/analytics/tracking/android/ae;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->f:Ljava/lang/String;

    return-object v0
.end method

.method private static a(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 330
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 331
    new-instance v1, Ljava/io/PrintStream;

    invoke-direct {v1, v0}, Ljava/io/PrintStream;-><init>(Ljava/io/OutputStream;)V

    .line 332
    invoke-virtual {p0, v1}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintStream;)V

    .line 333
    invoke-virtual {v1}, Ljava/io/PrintStream;->flush()V

    .line 334
    new-instance v1, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/String;-><init>([B)V

    return-object v1
.end method

.method private a(Ljava/lang/Runnable;)V
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->a:Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/LinkedBlockingQueue;->add(Ljava/lang/Object;)Z

    .line 280
    return-void
.end method

.method static synthetic b(Lcom/google/analytics/tracking/android/ae;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->i:Landroid/content/Context;

    return-object v0
.end method

.method private static b(Landroid/content/Context;)Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 291
    :try_start_0
    const-string v1, "gaInstallData"

    invoke-virtual {p0, v1}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v1

    .line 296
    const/16 v2, 0x2000

    new-array v2, v2, [B

    .line 297
    const/4 v3, 0x0

    const/16 v4, 0x2000

    invoke-virtual {v1, v2, v3, v4}, Ljava/io/FileInputStream;->read([BII)I

    move-result v3

    .line 298
    invoke-virtual {v1}, Ljava/io/FileInputStream;->available()I

    move-result v4

    if-lez v4, :cond_0

    .line 301
    const-string v2, "Too much campaign data, ignoring it."

    invoke-static {v2}, Lcom/google/analytics/tracking/android/an;->a(Ljava/lang/String;)V

    .line 302
    invoke-virtual {v1}, Ljava/io/FileInputStream;->close()V

    .line 303
    const-string v1, "gaInstallData"

    invoke-virtual {p0, v1}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    .line 325
    :goto_0
    return-object v0

    .line 306
    :cond_0
    invoke-virtual {v1}, Ljava/io/FileInputStream;->close()V

    .line 307
    const-string v1, "gaInstallData"

    invoke-virtual {p0, v1}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    .line 308
    if-gtz v3, :cond_1

    .line 309
    const-string v1, "Campaign file is empty."

    invoke-static {v1}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 318
    :catch_0
    move-exception v1

    const-string v1, "No campaign data found."

    invoke-static {v1}, Lcom/google/analytics/tracking/android/an;->b(Ljava/lang/String;)V

    goto :goto_0

    .line 312
    :cond_1
    :try_start_1
    new-instance v1, Ljava/lang/String;

    const/4 v4, 0x0

    invoke-direct {v1, v2, v4, v3}, Ljava/lang/String;-><init>([BII)V

    .line 313
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Campaign found: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/google/analytics/tracking/android/an;->b(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v0, v1

    .line 314
    goto :goto_0

    .line 323
    :catch_1
    move-exception v1

    const-string v1, "Error reading campaign data."

    invoke-static {v1}, Lcom/google/analytics/tracking/android/an;->a(Ljava/lang/String;)V

    .line 324
    const-string v1, "gaInstallData"

    invoke-virtual {p0, v1}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    goto :goto_0
.end method

.method static synthetic b(Ljava/util/Map;)Z
    .locals 12

    .prologue
    const-wide/high16 v10, 0x4059000000000000L    # 100.0

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 28
    const-string v0, "&sf"

    invoke-interface {p0, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_3

    const-string v0, "&sf"

    invoke-interface {p0, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ba;->b(Ljava/lang/String;)D

    move-result-wide v6

    cmpl-double v0, v6, v10

    if-gez v0, :cond_3

    const-string v0, "&cid"

    invoke-interface {p0, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_4

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    move v4, v1

    move v1, v3

    :goto_0
    if-ltz v4, :cond_1

    invoke-virtual {v0, v4}, Ljava/lang/String;->charAt(I)C

    move-result v5

    shl-int/lit8 v1, v1, 0x6

    const v8, 0xfffffff

    and-int/2addr v1, v8

    add-int/2addr v1, v5

    shl-int/lit8 v5, v5, 0xe

    add-int/2addr v1, v5

    const/high16 v5, 0xfe00000

    and-int/2addr v5, v1

    if-eqz v5, :cond_0

    shr-int/lit8 v5, v5, 0x15

    xor-int/2addr v1, v5

    :cond_0
    add-int/lit8 v4, v4, -0x1

    goto :goto_0

    :cond_1
    move v0, v1

    :goto_1
    rem-int/lit16 v0, v0, 0x2710

    int-to-double v0, v0

    mul-double v4, v6, v10

    cmpl-double v0, v0, v4

    if-ltz v0, :cond_3

    const-string v0, "&t"

    invoke-interface {p0, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_2

    const-string v0, "unknown"

    :goto_2
    const-string v1, "%s hit sampled out"

    new-array v4, v2, [Ljava/lang/Object;

    aput-object v0, v4, v3

    invoke-static {v1, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->c(Ljava/lang/String;)V

    :goto_3
    return v2

    :cond_2
    const-string v0, "&t"

    invoke-interface {p0, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_2

    :cond_3
    move v2, v3

    goto :goto_3

    :cond_4
    move v0, v2

    goto :goto_1
.end method

.method static synthetic c(Lcom/google/analytics/tracking/android/ae;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->e:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Ljava/util/Map;)V
    .locals 3

    .prologue
    .line 28
    invoke-static {}, Lcom/google/analytics/tracking/android/i;->a()Lcom/google/analytics/tracking/android/i;

    move-result-object v0

    const-string v1, "&an"

    const-string v2, "&an"

    invoke-interface {v0, v2}, Lcom/google/analytics/tracking/android/o;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v1, v2}, Lcom/google/analytics/tracking/android/ba;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "&av"

    const-string v2, "&av"

    invoke-interface {v0, v2}, Lcom/google/analytics/tracking/android/o;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v1, v2}, Lcom/google/analytics/tracking/android/ba;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "&aid"

    const-string v2, "&aid"

    invoke-interface {v0, v2}, Lcom/google/analytics/tracking/android/o;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v1, v2}, Lcom/google/analytics/tracking/android/ba;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "&aiid"

    const-string v2, "&aiid"

    invoke-interface {v0, v2}, Lcom/google/analytics/tracking/android/o;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v1, v0}, Lcom/google/analytics/tracking/android/ba;->a(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "&v"

    const-string v1, "1"

    invoke-interface {p0, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method static synthetic d(Lcom/google/analytics/tracking/android/ae;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ae;->e:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Ljava/util/Map;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    const-string v0, "useSecure"

    invoke-interface {p0, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "useSecure"

    invoke-interface {p0, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ba;->c(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "http:"

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "https:"

    goto :goto_0
.end method

.method static synthetic e(Lcom/google/analytics/tracking/android/ae;)Ljava/util/List;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->d:Ljava/util/List;

    return-object v0
.end method

.method static synthetic f(Lcom/google/analytics/tracking/android/ae;)Lcom/google/analytics/tracking/android/aw;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->h:Lcom/google/analytics/tracking/android/aw;

    return-object v0
.end method


# virtual methods
.method public final a()V
    .locals 1

    .prologue
    .line 248
    new-instance v0, Lcom/google/analytics/tracking/android/ag;

    invoke-direct {v0, p0}, Lcom/google/analytics/tracking/android/ag;-><init>(Lcom/google/analytics/tracking/android/ae;)V

    invoke-direct {p0, v0}, Lcom/google/analytics/tracking/android/ae;->a(Ljava/lang/Runnable;)V

    .line 255
    return-void
.end method

.method public final a(Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 111
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1, p1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 116
    const-string v0, "&ht"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 117
    if-eqz v0, :cond_0

    .line 119
    :try_start_0
    invoke-static {v0}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 125
    :cond_0
    :goto_0
    if-nez v0, :cond_1

    .line 126
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 127
    const-string v0, "&ht"

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 129
    :cond_1
    new-instance v0, Lcom/google/analytics/tracking/android/af;

    invoke-direct {v0, p0, v1}, Lcom/google/analytics/tracking/android/af;-><init>(Lcom/google/analytics/tracking/android/ae;Ljava/util/Map;)V

    invoke-direct {p0, v0}, Lcom/google/analytics/tracking/android/ae;->a(Ljava/lang/Runnable;)V

    .line 161
    return-void

    .line 122
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final b()V
    .locals 1

    .prologue
    .line 269
    new-instance v0, Lcom/google/analytics/tracking/android/ah;

    invoke-direct {v0, p0}, Lcom/google/analytics/tracking/android/ah;-><init>(Lcom/google/analytics/tracking/android/ae;)V

    invoke-direct {p0, v0}, Lcom/google/analytics/tracking/android/ae;->a(Ljava/lang/Runnable;)V

    .line 275
    return-void
.end method

.method public final c()Ljava/util/concurrent/LinkedBlockingQueue;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/LinkedBlockingQueue",
            "<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 401
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->a:Ljava/util/concurrent/LinkedBlockingQueue;

    return-object v0
.end method

.method public final d()Ljava/lang/Thread;
    .locals 0

    .prologue
    .line 406
    return-object p0
.end method

.method public final run()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 346
    const-wide/16 v0, 0x1388

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_2

    .line 355
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->h:Lcom/google/analytics/tracking/android/aw;

    if-nez v0, :cond_0

    .line 356
    new-instance v0, Lcom/google/analytics/tracking/android/v;

    iget-object v1, p0, Lcom/google/analytics/tracking/android/ae;->i:Landroid/content/Context;

    invoke-direct {v0, v1, p0}, Lcom/google/analytics/tracking/android/v;-><init>(Landroid/content/Context;Lcom/google/analytics/tracking/android/h;)V

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ae;->h:Lcom/google/analytics/tracking/android/aw;

    .line 358
    :cond_0
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->h:Lcom/google/analytics/tracking/android/aw;

    invoke-interface {v0}, Lcom/google/analytics/tracking/android/aw;->e()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ae;->d:Ljava/util/List;

    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->d:Ljava/util/List;

    new-instance v1, Lcom/google/android/gms/analytics/internal/Command;

    const-string v2, "appendVersion"

    const-string v3, "&_v"

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    const-string v4, "ma3.0.1"

    invoke-direct {v1, v2, v3, v4}, Lcom/google/android/gms/analytics/internal/Command;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->d:Ljava/util/List;

    new-instance v1, Lcom/google/android/gms/analytics/internal/Command;

    const-string v2, "appendQueueTime"

    const-string v3, "&qt"

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-direct {v1, v2, v3, v4}, Lcom/google/android/gms/analytics/internal/Command;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->d:Ljava/util/List;

    new-instance v1, Lcom/google/android/gms/analytics/internal/Command;

    const-string v2, "appendCacheBuster"

    const-string v3, "&z"

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-direct {v1, v2, v3, v4}, Lcom/google/android/gms/analytics/internal/Command;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 367
    invoke-static {}, Lcom/google/analytics/tracking/android/k;->a()Lcom/google/analytics/tracking/android/k;

    move-result-object v0

    const-string v1, "&cid"

    invoke-virtual {v0, v1}, Lcom/google/analytics/tracking/android/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ae;->f:Ljava/lang/String;

    .line 368
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->i:Landroid/content/Context;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/analytics/tracking/android/ae;->e:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_3

    .line 376
    :cond_1
    :goto_1
    iget-boolean v0, p0, Lcom/google/analytics/tracking/android/ae;->c:Z

    if-nez v0, :cond_2

    .line 382
    :try_start_2
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ae;->a:Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-virtual {v0}, Ljava/util/concurrent/LinkedBlockingQueue;->take()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Runnable;

    .line 383
    iget-boolean v1, p0, Lcom/google/analytics/tracking/android/ae;->b:Z

    if-nez v1, :cond_1

    .line 384
    invoke-interface {v0}, Ljava/lang/Runnable;->run()V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 386
    :catch_0
    move-exception v0

    :try_start_3
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->b(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1

    .line 389
    :catch_1
    move-exception v0

    .line 390
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Error on GAThread: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->a(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->a(Ljava/lang/String;)V

    .line 393
    const-string v0, "Google Analytics is shutting down."

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->a(Ljava/lang/String;)V

    .line 394
    iput-boolean v5, p0, Lcom/google/analytics/tracking/android/ae;->b:Z

    goto :goto_1

    .line 349
    :catch_2
    move-exception v0

    const-string v0, "sleep interrupted in GAThread initialize"

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->d(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 369
    :catch_3
    move-exception v0

    .line 370
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Error initializing the GAThread: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->a(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->a(Ljava/lang/String;)V

    .line 373
    const-string v0, "Google Analytics will not start up."

    invoke-static {v0}, Lcom/google/analytics/tracking/android/an;->a(Ljava/lang/String;)V

    .line 374
    iput-boolean v5, p0, Lcom/google/analytics/tracking/android/ae;->b:Z

    goto :goto_1

    .line 397
    :cond_2
    return-void
.end method
