.class Lcom/a/b/l;
.super Lcom/a/b/d;
.source "SourceFile"


# instance fields
.field final o:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V
    .locals 6

    .prologue
    .line 32
    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-direct/range {v0 .. v5}, Lcom/a/b/d;-><init>(Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    .line 33
    iput-object p1, p0, Lcom/a/b/l;->o:Landroid/content/Context;

    .line 34
    return-void
.end method

.method private b(Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 46
    iget-object v0, p0, Lcom/a/b/l;->o:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    .line 48
    invoke-virtual {p1}, Lcom/a/b/ao;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 49
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 50
    const/4 v3, 0x1

    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 53
    :try_start_0
    iget-object v3, p1, Lcom/a/b/ao;->a:Landroid/net/Uri;

    invoke-virtual {v2, v3}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    .line 54
    const/4 v3, 0x0

    invoke-static {v1, v3, v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 56
    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    .line 58
    iget v1, p1, Lcom/a/b/ao;->d:I

    iget v3, p1, Lcom/a/b/ao;->e:I

    invoke-static {v1, v3, v0}, Lcom/a/b/l;->a(IILandroid/graphics/BitmapFactory$Options;)V

    .line 60
    :goto_0
    iget-object v1, p1, Lcom/a/b/ao;->a:Landroid/net/Uri;

    invoke-virtual {v2, v1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    .line 62
    const/4 v2, 0x0

    :try_start_1
    invoke-static {v1, v2, v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 64
    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    return-object v0

    .line 56
    :catchall_0
    move-exception v0

    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    throw v0

    .line 64
    :catchall_1
    move-exception v0

    invoke-static {v1}, Lcom/a/b/ba;->a(Ljava/io/InputStream;)V

    throw v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method


# virtual methods
.method a(Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0, p1}, Lcom/a/b/l;->b(Lcom/a/b/ao;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method final a()Lcom/a/b/aj;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Lcom/a/b/aj;->b:Lcom/a/b/aj;

    return-object v0
.end method
