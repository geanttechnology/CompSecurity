.class public Lcom/livemixtapes/ImageLoader;
.super Ljava/lang/Object;
.source "ImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/ImageLoader$BitmapDisplayer;,
        Lcom/livemixtapes/ImageLoader$PhotoToLoad;,
        Lcom/livemixtapes/ImageLoader$PhotosLoader;
    }
.end annotation


# static fields
.field static memoryCache:Lcom/livemixtapes/MemoryCache;


# instance fields
.field executorService:Ljava/util/concurrent/ExecutorService;

.field fileCache:Lcom/livemixtapes/FileCache;

.field handler:Landroid/os/Handler;

.field private imageViews:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Landroid/widget/ImageView;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final stub_id:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    new-instance v0, Lcom/livemixtapes/MemoryCache;

    invoke-direct {v0}, Lcom/livemixtapes/MemoryCache;-><init>()V

    sput-object v0, Lcom/livemixtapes/ImageLoader;->memoryCache:Lcom/livemixtapes/MemoryCache;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/ImageLoader;->imageViews:Ljava/util/Map;

    .line 33
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/ImageLoader;->handler:Landroid/os/Handler;

    .line 40
    const v0, 0x7f0200ec

    iput v0, p0, Lcom/livemixtapes/ImageLoader;->stub_id:I

    .line 36
    new-instance v0, Lcom/livemixtapes/FileCache;

    invoke-direct {v0, p1}, Lcom/livemixtapes/FileCache;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/ImageLoader;->fileCache:Lcom/livemixtapes/FileCache;

    .line 37
    const/4 v0, 0x5

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/ImageLoader;->executorService:Ljava/util/concurrent/ExecutorService;

    .line 38
    return-void
.end method

.method private decodeFile(Ljava/io/File;)Landroid/graphics/Bitmap;
    .locals 13
    .param p1, "f"    # Ljava/io/File;

    .prologue
    const/16 v12, 0x190

    const/4 v10, 0x0

    .line 100
    :try_start_0
    new-instance v4, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v4}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 101
    .local v4, "o":Landroid/graphics/BitmapFactory$Options;
    const/4 v11, 0x1

    iput-boolean v11, v4, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 102
    new-instance v7, Ljava/io/FileInputStream;

    invoke-direct {v7, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 103
    .local v7, "stream1":Ljava/io/FileInputStream;
    const/4 v11, 0x0

    invoke-static {v7, v11, v4}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 104
    invoke-virtual {v7}, Ljava/io/FileInputStream;->close()V

    .line 107
    const/16 v0, 0x190

    .line 108
    .local v0, "REQUIRED_SIZE":I
    iget v9, v4, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    .local v9, "width_tmp":I
    iget v3, v4, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    .line 109
    .local v3, "height_tmp":I
    const/4 v6, 0x1

    .line 111
    .local v6, "scale":I
    :goto_0
    div-int/lit8 v11, v9, 0x2

    if-lt v11, v12, :cond_0

    .line 112
    div-int/lit8 v11, v3, 0x2

    if-ge v11, v12, :cond_1

    .line 120
    :cond_0
    new-instance v5, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v5}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 121
    .local v5, "o2":Landroid/graphics/BitmapFactory$Options;
    iput v6, v5, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 122
    new-instance v8, Ljava/io/FileInputStream;

    invoke-direct {v8, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 123
    .local v8, "stream2":Ljava/io/FileInputStream;
    const/4 v11, 0x0

    invoke-static {v8, v11, v5}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 124
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    invoke-virtual {v8}, Ljava/io/FileInputStream;->close()V

    .line 130
    .end local v0    # "REQUIRED_SIZE":I
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    .end local v3    # "height_tmp":I
    .end local v4    # "o":Landroid/graphics/BitmapFactory$Options;
    .end local v5    # "o2":Landroid/graphics/BitmapFactory$Options;
    .end local v6    # "scale":I
    .end local v7    # "stream1":Ljava/io/FileInputStream;
    .end local v8    # "stream2":Ljava/io/FileInputStream;
    .end local v9    # "width_tmp":I
    :goto_1
    return-object v1

    .line 114
    .restart local v0    # "REQUIRED_SIZE":I
    .restart local v3    # "height_tmp":I
    .restart local v4    # "o":Landroid/graphics/BitmapFactory$Options;
    .restart local v6    # "scale":I
    .restart local v7    # "stream1":Ljava/io/FileInputStream;
    .restart local v9    # "width_tmp":I
    :cond_1
    div-int/lit8 v9, v9, 0x2

    .line 115
    div-int/lit8 v3, v3, 0x2
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 116
    mul-int/lit8 v6, v6, 0x2

    .line 110
    goto :goto_0

    .line 127
    .end local v0    # "REQUIRED_SIZE":I
    .end local v3    # "height_tmp":I
    .end local v4    # "o":Landroid/graphics/BitmapFactory$Options;
    .end local v6    # "scale":I
    .end local v7    # "stream1":Ljava/io/FileInputStream;
    .end local v9    # "width_tmp":I
    :catch_0
    move-exception v2

    .line 128
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    .end local v2    # "e":Ljava/io/IOException;
    :goto_2
    move-object v1, v10

    .line 130
    goto :goto_1

    .line 126
    :catch_1
    move-exception v11

    goto :goto_2
.end method

.method private queuePhoto(Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 60
    new-instance v0, Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    invoke-direct {v0, p0, p1, p2}, Lcom/livemixtapes/ImageLoader$PhotoToLoad;-><init>(Lcom/livemixtapes/ImageLoader;Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 61
    .local v0, "p":Lcom/livemixtapes/ImageLoader$PhotoToLoad;
    iget-object v1, p0, Lcom/livemixtapes/ImageLoader;->executorService:Ljava/util/concurrent/ExecutorService;

    new-instance v2, Lcom/livemixtapes/ImageLoader$PhotosLoader;

    invoke-direct {v2, p0, v0}, Lcom/livemixtapes/ImageLoader$PhotosLoader;-><init>(Lcom/livemixtapes/ImageLoader;Lcom/livemixtapes/ImageLoader$PhotoToLoad;)V

    invoke-interface {v1, v2}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 62
    return-void
.end method


# virtual methods
.method public DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 43
    iget-object v1, p0, Lcom/livemixtapes/ImageLoader;->imageViews:Ljava/util/Map;

    invoke-interface {v1, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    sget-object v1, Lcom/livemixtapes/ImageLoader;->memoryCache:Lcom/livemixtapes/MemoryCache;

    invoke-virtual {v1, p1}, Lcom/livemixtapes/MemoryCache;->get(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 45
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 46
    invoke-virtual {p2, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 51
    :goto_0
    return-void

    .line 48
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/livemixtapes/ImageLoader;->queuePhoto(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 49
    const v1, 0x7f0200ec

    invoke-virtual {p2, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method

.method public DisplayImageWithoutCache(Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/livemixtapes/ImageLoader;->imageViews:Ljava/util/Map;

    invoke-interface {v0, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    invoke-direct {p0, p1, p2}, Lcom/livemixtapes/ImageLoader;->queuePhoto(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 56
    const v0, 0x7f0200ec

    invoke-virtual {p2, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 57
    return-void
.end method

.method public clearCache()V
    .locals 1

    .prologue
    .line 197
    sget-object v0, Lcom/livemixtapes/ImageLoader;->memoryCache:Lcom/livemixtapes/MemoryCache;

    invoke-virtual {v0}, Lcom/livemixtapes/MemoryCache;->clear()V

    .line 198
    iget-object v0, p0, Lcom/livemixtapes/ImageLoader;->fileCache:Lcom/livemixtapes/FileCache;

    invoke-virtual {v0}, Lcom/livemixtapes/FileCache;->clear()V

    .line 199
    return-void
.end method

.method public getBitmap(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 9
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 65
    iget-object v8, p0, Lcom/livemixtapes/ImageLoader;->fileCache:Lcom/livemixtapes/FileCache;

    invoke-virtual {v8, p1}, Lcom/livemixtapes/FileCache;->getFile(Ljava/lang/String;)Ljava/io/File;

    move-result-object v4

    .line 68
    .local v4, "f":Ljava/io/File;
    invoke-direct {p0, v4}, Lcom/livemixtapes/ImageLoader;->decodeFile(Ljava/io/File;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 69
    .local v0, "b":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 92
    .end local v0    # "b":Landroid/graphics/Bitmap;
    :goto_0
    return-object v0

    .line 74
    .restart local v0    # "b":Landroid/graphics/Bitmap;
    :cond_0
    const/4 v1, 0x0

    .line 75
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    :try_start_0
    new-instance v5, Ljava/net/URL;

    invoke-direct {v5, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 77
    .local v5, "imageUrl":Ljava/net/URL;
    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    .line 76
    check-cast v2, Ljava/net/HttpURLConnection;

    .line 78
    .local v2, "conn":Ljava/net/HttpURLConnection;
    const/16 v8, 0x7530

    invoke-virtual {v2, v8}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 79
    const/16 v8, 0x7530

    invoke-virtual {v2, v8}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 80
    const/4 v8, 0x1

    invoke-virtual {v2, v8}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 81
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v6

    .line 82
    .local v6, "is":Ljava/io/InputStream;
    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 83
    .local v7, "os":Ljava/io/OutputStream;
    invoke-static {v6, v7}, Lcom/livemixtapes/Utils;->CopyStream(Ljava/io/InputStream;Ljava/io/OutputStream;)V

    .line 84
    invoke-virtual {v7}, Ljava/io/OutputStream;->close()V

    .line 85
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 86
    invoke-direct {p0, v4}, Lcom/livemixtapes/ImageLoader;->decodeFile(Ljava/io/File;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    move-object v0, v1

    .line 87
    goto :goto_0

    .line 88
    .end local v2    # "conn":Ljava/net/HttpURLConnection;
    .end local v5    # "imageUrl":Ljava/net/URL;
    .end local v6    # "is":Ljava/io/InputStream;
    .end local v7    # "os":Ljava/io/OutputStream;
    :catch_0
    move-exception v3

    .line 89
    .local v3, "ex":Ljava/lang/Throwable;
    invoke-virtual {v3}, Ljava/lang/Throwable;->printStackTrace()V

    .line 90
    instance-of v8, v3, Ljava/lang/OutOfMemoryError;

    if-eqz v8, :cond_1

    .line 91
    sget-object v8, Lcom/livemixtapes/ImageLoader;->memoryCache:Lcom/livemixtapes/MemoryCache;

    invoke-virtual {v8}, Lcom/livemixtapes/MemoryCache;->clear()V

    .line 92
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method imageViewReused(Lcom/livemixtapes/ImageLoader$PhotoToLoad;)Z
    .locals 3
    .param p1, "photoToLoad"    # Lcom/livemixtapes/ImageLoader$PhotoToLoad;

    .prologue
    .line 169
    iget-object v1, p0, Lcom/livemixtapes/ImageLoader;->imageViews:Ljava/util/Map;

    iget-object v2, p1, Lcom/livemixtapes/ImageLoader$PhotoToLoad;->imageView:Landroid/widget/ImageView;

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 170
    .local v0, "tag":Ljava/lang/String;
    if-eqz v0, :cond_0

    iget-object v1, p1, Lcom/livemixtapes/ImageLoader$PhotoToLoad;->url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 171
    :cond_0
    const/4 v1, 0x1

    .line 172
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method
