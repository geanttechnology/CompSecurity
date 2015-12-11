.class final Lcom/a/b/z;
.super Lcom/a/b/l;
.source "SourceFile"


# static fields
.field private static final p:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 37
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "orientation"

    aput-object v2, v0, v1

    sput-object v0, Lcom/a/b/z;->p:[Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V
    .locals 0

    .prologue
    .line 43
    invoke-direct/range {p0 .. p6}, Lcom/a/b/l;-><init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    .line 44
    return-void
.end method

.method private static a(Landroid/content/ContentResolver;Landroid/net/Uri;)I
    .locals 8

    .prologue
    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 84
    .line 86
    :try_start_0
    sget-object v2, Lcom/a/b/z;->p:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 87
    if-eqz v1, :cond_0

    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v0

    if-nez v0, :cond_3

    .line 88
    :cond_0
    if-eqz v1, :cond_1

    .line 96
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_1
    move v0, v6

    :cond_2
    :goto_0
    return v0

    .line 90
    :cond_3
    const/4 v0, 0x0

    :try_start_2
    invoke-interface {v1, v0}, Landroid/database/Cursor;->getInt(I)I
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result v0

    .line 95
    if-eqz v1, :cond_2

    .line 96
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 93
    :catch_0
    move-exception v0

    move-object v0, v7

    :goto_1
    if-eqz v0, :cond_4

    .line 96
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_4
    move v0, v6

    goto :goto_0

    .line 95
    :catchall_0
    move-exception v0

    move-object v1, v7

    :goto_2
    if-eqz v1, :cond_5

    .line 96
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v0

    .line 95
    :catchall_1
    move-exception v0

    goto :goto_2

    .line 93
    :catch_1
    move-exception v0

    move-object v0, v1

    goto :goto_1
.end method


# virtual methods
.method final a(Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    .locals 9

    .prologue
    .line 47
    iget-object v0, p0, Lcom/a/b/z;->o:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 48
    iget-object v0, p1, Lcom/a/b/ao;->a:Landroid/net/Uri;

    invoke-static {v1, v0}, Lcom/a/b/z;->a(Landroid/content/ContentResolver;Landroid/net/Uri;)I

    move-result v0

    iput v0, p0, Lcom/a/b/d;->n:I

    .line 50
    invoke-virtual {p1}, Lcom/a/b/ao;->a()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 51
    iget v0, p1, Lcom/a/b/ao;->d:I

    iget v2, p1, Lcom/a/b/ao;->e:I

    sget-object v3, Lcom/a/b/aa;->a:Lcom/a/b/aa;

    iget v3, v3, Lcom/a/b/aa;->e:I

    if-gt v0, v3, :cond_1

    sget-object v3, Lcom/a/b/aa;->a:Lcom/a/b/aa;

    iget v3, v3, Lcom/a/b/aa;->f:I

    if-gt v2, v3, :cond_1

    sget-object v0, Lcom/a/b/aa;->a:Lcom/a/b/aa;

    .line 52
    :goto_0
    sget-object v2, Lcom/a/b/aa;->c:Lcom/a/b/aa;

    if-ne v0, v2, :cond_3

    .line 53
    invoke-super {p0, p1}, Lcom/a/b/l;->a(Lcom/a/b/ao;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 71
    :cond_0
    :goto_1
    return-object v0

    .line 51
    :cond_1
    sget-object v3, Lcom/a/b/aa;->b:Lcom/a/b/aa;

    iget v3, v3, Lcom/a/b/aa;->e:I

    if-gt v0, v3, :cond_2

    sget-object v0, Lcom/a/b/aa;->b:Lcom/a/b/aa;

    iget v0, v0, Lcom/a/b/aa;->f:I

    if-gt v2, v0, :cond_2

    sget-object v0, Lcom/a/b/aa;->b:Lcom/a/b/aa;

    goto :goto_0

    :cond_2
    sget-object v0, Lcom/a/b/aa;->c:Lcom/a/b/aa;

    goto :goto_0

    .line 56
    :cond_3
    iget-object v2, p1, Lcom/a/b/ao;->a:Landroid/net/Uri;

    invoke-static {v2}, Landroid/content/ContentUris;->parseId(Landroid/net/Uri;)J

    move-result-wide v2

    .line 58
    new-instance v4, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v4}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 59
    const/4 v5, 0x1

    iput-boolean v5, v4, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 61
    iget v5, p1, Lcom/a/b/ao;->d:I

    iget v6, p1, Lcom/a/b/ao;->e:I

    iget v7, v0, Lcom/a/b/aa;->e:I

    iget v8, v0, Lcom/a/b/aa;->f:I

    invoke-static {v5, v6, v7, v8, v4}, Lcom/a/b/z;->a(IIIILandroid/graphics/BitmapFactory$Options;)V

    .line 64
    iget v0, v0, Lcom/a/b/aa;->d:I

    invoke-static {v1, v2, v3, v0, v4}, Landroid/provider/MediaStore$Images$Thumbnails;->getThumbnail(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 66
    if-nez v0, :cond_0

    .line 71
    :cond_4
    invoke-super {p0, p1}, Lcom/a/b/l;->a(Lcom/a/b/ao;)Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_1
.end method
