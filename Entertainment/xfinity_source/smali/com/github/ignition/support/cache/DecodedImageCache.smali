.class public Lcom/github/ignition/support/cache/DecodedImageCache;
.super Lcom/github/ignition/support/cache/AbstractImageCache;
.source "DecodedImageCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/github/ignition/support/cache/AbstractImageCache",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private final bitmapOptions:Landroid/graphics/BitmapFactory$Options;


# direct methods
.method public constructor <init>(IIJI)V
    .locals 7
    .param p1, "initialCapacity"    # I
    .param p2, "maximumCapacity"    # I
    .param p3, "expirationInMinutes"    # J
    .param p5, "maxConcurrentThreads"    # I

    .prologue
    .line 16
    const-string v1, "DecodedImageCache"

    move-object v0, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    move v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/github/ignition/support/cache/AbstractImageCache;-><init>(Ljava/lang/String;IIJI)V

    .line 8
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    iput-object v0, p0, Lcom/github/ignition/support/cache/DecodedImageCache;->bitmapOptions:Landroid/graphics/BitmapFactory$Options;

    .line 17
    invoke-direct {p0}, Lcom/github/ignition/support/cache/DecodedImageCache;->initBitmapOptions()V

    .line 18
    return-void
.end method

.method private initBitmapOptions()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 21
    iget-object v0, p0, Lcom/github/ignition/support/cache/DecodedImageCache;->bitmapOptions:Landroid/graphics/BitmapFactory$Options;

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inPurgeable:Z

    .line 22
    iget-object v0, p0, Lcom/github/ignition/support/cache/DecodedImageCache;->bitmapOptions:Landroid/graphics/BitmapFactory$Options;

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inInputShareable:Z

    .line 23
    iget-object v0, p0, Lcom/github/ignition/support/cache/DecodedImageCache;->bitmapOptions:Landroid/graphics/BitmapFactory$Options;

    sget-object v1, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    iput-object v1, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    .line 24
    return-void
.end method


# virtual methods
.method public decodeToBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .locals 0
    .param p1, "imageData"    # Landroid/graphics/Bitmap;

    .prologue
    .line 36
    return-object p1
.end method

.method public bridge synthetic decodeToBitmap(Ljava/lang/Object;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 6
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/github/ignition/support/cache/DecodedImageCache;->decodeToBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getBitmap(Ljava/lang/Object;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "elementKey"    # Ljava/lang/Object;

    .prologue
    .line 27
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p1}, Lcom/github/ignition/support/cache/AbstractImageCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getBitmapFromMemory(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "elementKey"    # Ljava/lang/String;

    .prologue
    .line 31
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p1}, Lcom/github/ignition/support/cache/AbstractImageCache;->getFromMemory(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected parse([B)Landroid/graphics/Bitmap;
    .locals 3
    .param p1, "imageData"    # [B

    .prologue
    .line 41
    if-nez p1, :cond_0

    .line 42
    const/4 v0, 0x0

    .line 44
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    array-length v1, p1

    iget-object v2, p0, Lcom/github/ignition/support/cache/DecodedImageCache;->bitmapOptions:Landroid/graphics/BitmapFactory$Options;

    invoke-static {p1, v0, v1, v2}, Landroid/graphics/BitmapFactory;->decodeByteArray([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_0
.end method

.method protected bridge synthetic parse(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 6
    check-cast p1, [B

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/github/ignition/support/cache/DecodedImageCache;->parse([B)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method
