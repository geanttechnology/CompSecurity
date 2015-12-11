.class final Lcom/a/b/c;
.super Lcom/a/b/d;
.source "SourceFile"


# instance fields
.field private o:Landroid/content/res/AssetManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V
    .locals 6

    .prologue
    .line 17
    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-direct/range {v0 .. v5}, Lcom/a/b/d;-><init>(Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    .line 18
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    iput-object v0, p0, Lcom/a/b/c;->o:Landroid/content/res/AssetManager;

    .line 19
    return-void
.end method

.method private a(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 31
    .line 32
    iget-object v0, p0, Lcom/a/b/c;->g:Lcom/a/b/ao;

    invoke-virtual {v0}, Lcom/a/b/ao;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 33
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 34
    const/4 v2, 0x1

    iput-boolean v2, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 37
    :try_start_0
    iget-object v2, p0, Lcom/a/b/c;->o:Landroid/content/res/AssetManager;

    invoke-virtual {v2, p1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    .line 38
    const/4 v2, 0x0

    invoke-static {v1, v2, v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 40
    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    .line 42
    iget-object v1, p0, Lcom/a/b/c;->g:Lcom/a/b/ao;

    iget v1, v1, Lcom/a/b/ao;->d:I

    iget-object v2, p0, Lcom/a/b/c;->g:Lcom/a/b/ao;

    iget v2, v2, Lcom/a/b/ao;->e:I

    invoke-static {v1, v2, v0}, Lcom/a/b/c;->a(IILandroid/graphics/BitmapFactory$Options;)V

    .line 44
    :goto_0
    iget-object v1, p0, Lcom/a/b/c;->o:Landroid/content/res/AssetManager;

    invoke-virtual {v1, p1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    .line 46
    const/4 v2, 0x0

    :try_start_1
    invoke-static {v1, v2, v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 48
    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    return-object v0

    .line 40
    :catchall_0
    move-exception v0

    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    throw v0

    .line 48
    :catchall_1
    move-exception v0

    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    throw v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method


# virtual methods
.method final a(Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    .locals 2

    .prologue
    .line 22
    iget-object v0, p1, Lcom/a/b/ao;->a:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    sget v1, Lcom/a/b/c;->a:I

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 23
    invoke-direct {p0, v0}, Lcom/a/b/c;->a(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method final a()Lcom/a/b/aj;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/a/b/aj;->b:Lcom/a/b/aj;

    return-object v0
.end method
