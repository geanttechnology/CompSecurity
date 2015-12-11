.class final Lcom/a/b/ab;
.super Lcom/a/b/d;
.source "SourceFile"


# instance fields
.field o:I

.field private final p:Lcom/a/b/s;


# direct methods
.method public constructor <init>(Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;Lcom/a/b/s;)V
    .locals 1

    .prologue
    .line 40
    invoke-direct/range {p0 .. p5}, Lcom/a/b/d;-><init>(Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    .line 41
    iput-object p6, p0, Lcom/a/b/ab;->p:Lcom/a/b/s;

    .line 42
    const/4 v0, 0x2

    iput v0, p0, Lcom/a/b/ab;->o:I

    .line 43
    return-void
.end method

.method private static a(Ljava/io/InputStream;Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    .locals 7

    .prologue
    const/16 v5, 0xb

    const/4 v3, 0x1

    const/4 v1, 0x0

    .line 78
    if-nez p0, :cond_1

    .line 115
    :cond_0
    :goto_0
    return-object v1

    .line 81
    :cond_1
    iget-object v0, p1, Lcom/a/b/ao;->l:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 82
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v2, v5, :cond_4

    if-eqz v0, :cond_4

    .line 84
    iget v2, p1, Lcom/a/b/ao;->n:I

    iget-object v3, p1, Lcom/a/b/ao;->o:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v3

    if-ne v2, v3, :cond_0

    .line 87
    iget-object v2, p1, Lcom/a/b/ao;->o:Ljava/util/concurrent/atomic/AtomicInteger;

    monitor-enter v2

    .line 88
    :try_start_0
    iget v3, p1, Lcom/a/b/ao;->n:I

    iget-object v4, p1, Lcom/a/b/ao;->o:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v4

    if-eq v3, v4, :cond_2

    .line 89
    monitor-exit v2

    goto :goto_0

    .line 97
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 91
    :cond_2
    :try_start_1
    new-instance v1, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v1}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 92
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    invoke-static {v3, v4, v1}, Lcom/a/b/ab;->a(IILandroid/graphics/BitmapFactory$Options;)V

    .line 94
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v3, v5, :cond_3

    iput-object v0, v1, Landroid/graphics/BitmapFactory$Options;->inBitmap:Landroid/graphics/Bitmap;

    const/4 v3, 0x1

    iput-boolean v3, v1, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v0

    iput-object v0, v1, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x13

    if-gt v0, v3, :cond_3

    const/4 v0, 0x1

    iput v0, v1, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 95
    :cond_3
    iget-object v0, p1, Lcom/a/b/ao;->m:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    iput-object v0, v1, Landroid/graphics/BitmapFactory$Options;->inTempStorage:[B

    .line 96
    const/4 v0, 0x0

    invoke-static {p0, v0, v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 99
    :cond_4
    new-instance v2, Lcom/a/b/y;

    invoke-direct {v2, p0}, Lcom/a/b/y;-><init>(Ljava/io/InputStream;)V

    .line 102
    const/high16 v0, 0x10000

    invoke-virtual {v2, v0}, Lcom/a/b/y;->a(I)J

    move-result-wide v4

    .line 105
    invoke-virtual {p1}, Lcom/a/b/ao;->a()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 106
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 107
    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 109
    invoke-static {v2, v1, v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 110
    iget v3, p1, Lcom/a/b/ao;->d:I

    iget v6, p1, Lcom/a/b/ao;->e:I

    invoke-static {v3, v6, v0}, Lcom/a/b/ab;->a(IILandroid/graphics/BitmapFactory$Options;)V

    .line 112
    invoke-virtual {v2, v4, v5}, Lcom/a/b/y;->a(J)V

    .line 115
    :goto_1
    invoke-static {v2, v1, v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    goto/16 :goto_0

    :cond_5
    move-object v0, v1

    goto :goto_1
.end method


# virtual methods
.method final a(Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    .locals 3

    .prologue
    .line 46
    iget v0, p0, Lcom/a/b/ab;->o:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    .line 48
    :goto_0
    iget-object v1, p0, Lcom/a/b/ab;->p:Lcom/a/b/s;

    iget-object v2, p1, Lcom/a/b/ao;->a:Landroid/net/Uri;

    invoke-interface {v1, v2, v0}, Lcom/a/b/s;->a(Landroid/net/Uri;Z)Lcom/a/b/t;

    move-result-object v1

    .line 49
    iget-boolean v0, v1, Lcom/a/b/t;->c:Z

    if-eqz v0, :cond_1

    sget-object v0, Lcom/a/b/aj;->b:Lcom/a/b/aj;

    :goto_1
    iput-object v0, p0, Lcom/a/b/ab;->l:Lcom/a/b/aj;

    .line 55
    iget-object v0, v1, Lcom/a/b/t;->b:Landroid/graphics/Bitmap;

    .line 56
    if-eqz v0, :cond_2

    .line 64
    :goto_2
    return-object v0

    .line 46
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 49
    :cond_1
    sget-object v0, Lcom/a/b/aj;->c:Lcom/a/b/aj;

    goto :goto_1

    .line 60
    :cond_2
    iget-object v1, v1, Lcom/a/b/t;->a:Ljava/io/InputStream;

    .line 62
    :try_start_0
    invoke-static {v1, p1}, Lcom/a/b/ab;->a(Ljava/io/InputStream;Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 64
    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    goto :goto_2

    :catchall_0
    move-exception v0

    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    throw v0
.end method

.method final a(Landroid/net/NetworkInfo;)Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 69
    iget v2, p0, Lcom/a/b/ab;->o:I

    if-lez v2, :cond_1

    move v2, v1

    .line 70
    :goto_0
    if-nez v2, :cond_2

    .line 74
    :cond_0
    :goto_1
    return v0

    :cond_1
    move v2, v0

    .line 69
    goto :goto_0

    .line 73
    :cond_2
    iget v2, p0, Lcom/a/b/ab;->o:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/a/b/ab;->o:I

    .line 74
    if-eqz p1, :cond_3

    invoke-virtual {p1}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_3
    move v0, v1

    goto :goto_1
.end method
