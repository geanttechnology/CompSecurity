.class abstract Lcom/a/b/d;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field protected static final a:I

.field private static final o:Ljava/lang/Object;


# instance fields
.field final b:Lcom/a/b/ad;

.field final c:Lcom/a/b/n;

.field final d:Lcom/a/b/h;

.field final e:Lcom/a/b/as;

.field final f:Ljava/lang/String;

.field final g:Lcom/a/b/ao;

.field final h:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/a/b/a;",
            ">;"
        }
    .end annotation
.end field

.field final i:Z

.field j:Landroid/graphics/Bitmap;

.field k:Ljava/util/concurrent/Future;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/Future",
            "<*>;"
        }
    .end annotation
.end field

.field l:Lcom/a/b/aj;

.field m:Ljava/lang/Exception;

.field n:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/a/b/d;->o:Ljava/lang/Object;

    .line 47
    const/16 v0, 0x16

    sput v0, Lcom/a/b/d;->a:I

    return-void
.end method

.method constructor <init>(Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V
    .locals 2

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    iput-object p1, p0, Lcom/a/b/d;->b:Lcom/a/b/ad;

    .line 67
    iput-object p2, p0, Lcom/a/b/d;->c:Lcom/a/b/n;

    .line 68
    iput-object p3, p0, Lcom/a/b/d;->d:Lcom/a/b/h;

    .line 69
    iput-object p4, p0, Lcom/a/b/d;->e:Lcom/a/b/as;

    .line 70
    iget-object v0, p5, Lcom/a/b/a;->h:Ljava/lang/String;

    iput-object v0, p0, Lcom/a/b/d;->f:Ljava/lang/String;

    .line 71
    iget-object v0, p5, Lcom/a/b/a;->b:Lcom/a/b/ao;

    iput-object v0, p0, Lcom/a/b/d;->g:Lcom/a/b/ao;

    .line 72
    iget-boolean v0, p5, Lcom/a/b/a;->d:Z

    iput-boolean v0, p0, Lcom/a/b/d;->i:Z

    .line 73
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/a/b/d;->h:Ljava/util/List;

    .line 74
    invoke-virtual {p0, p5}, Lcom/a/b/d;->a(Lcom/a/b/a;)V

    .line 75
    return-void
.end method

.method private static a(Ljava/util/List;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/a/b/ay;",
            ">;",
            "Landroid/graphics/Bitmap;",
            ")",
            "Landroid/graphics/Bitmap;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 239
    const/4 v0, 0x0

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v4

    move v3, v0

    move-object v2, p1

    :goto_0
    if-ge v3, v4, :cond_4

    .line 240
    invoke-interface {p0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/b/ay;

    .line 241
    invoke-interface {v0}, Lcom/a/b/ay;->a()Landroid/graphics/Bitmap;

    move-result-object p1

    .line 243
    if-nez p1, :cond_1

    .line 244
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "Transformation "

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v0}, Lcom/a/b/ay;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " returned null after "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " previous transformation(s).\n\nTransformation list:\n"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 250
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/b/ay;

    .line 251
    invoke-interface {v0}, Lcom/a/b/ay;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v4, 0xa

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 253
    :cond_0
    sget-object v0, Lcom/a/b/ad;->a:Landroid/os/Handler;

    new-instance v3, Lcom/a/b/e;

    invoke-direct {v3, v2}, Lcom/a/b/e;-><init>(Ljava/lang/StringBuilder;)V

    invoke-virtual {v0, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    move-object v0, v1

    .line 286
    :goto_2
    return-object v0

    .line 261
    :cond_1
    if-ne p1, v2, :cond_2

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 262
    sget-object v2, Lcom/a/b/ad;->a:Landroid/os/Handler;

    new-instance v3, Lcom/a/b/f;

    invoke-direct {v3, v0}, Lcom/a/b/f;-><init>(Lcom/a/b/ay;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    move-object v0, v1

    .line 269
    goto :goto_2

    .line 273
    :cond_2
    if-eq p1, v2, :cond_3

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v2

    if-nez v2, :cond_3

    .line 274
    sget-object v2, Lcom/a/b/ad;->a:Landroid/os/Handler;

    new-instance v3, Lcom/a/b/g;

    invoke-direct {v3, v0}, Lcom/a/b/g;-><init>(Lcom/a/b/ay;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    move-object v0, v1

    .line 281
    goto :goto_2

    .line 239
    :cond_3
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    move-object v2, p1

    goto/16 :goto_0

    :cond_4
    move-object v0, v2

    .line 286
    goto :goto_2
.end method

.method static a(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;Lcom/a/b/s;)Lcom/a/b/d;
    .locals 7

    .prologue
    .line 195
    iget-object v0, p5, Lcom/a/b/a;->b:Lcom/a/b/ao;

    iget v0, v0, Lcom/a/b/ao;->b:I

    if-eqz v0, :cond_0

    .line 196
    new-instance v0, Lcom/a/b/ar;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/a/b/ar;-><init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    .line 217
    :goto_0
    return-object v0

    .line 198
    :cond_0
    iget-object v0, p5, Lcom/a/b/a;->b:Lcom/a/b/ao;

    iget-object v0, v0, Lcom/a/b/ao;->a:Landroid/net/Uri;

    .line 199
    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    .line 200
    const-string v2, "content"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 201
    sget-object v1, Landroid/provider/ContactsContract$Contacts;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v1

    const-string v2, "photo"

    invoke-interface {v1, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 203
    new-instance v0, Lcom/a/b/k;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/a/b/k;-><init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    goto :goto_0

    .line 204
    :cond_1
    const-string v1, "media"

    invoke-virtual {v0}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 205
    new-instance v0, Lcom/a/b/z;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/a/b/z;-><init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    goto :goto_0

    .line 207
    :cond_2
    new-instance v0, Lcom/a/b/l;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/a/b/l;-><init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    goto :goto_0

    .line 209
    :cond_3
    const-string v2, "file"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 210
    invoke-virtual {v0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_4

    const-string v1, "android_asset"

    invoke-virtual {v0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 211
    new-instance v0, Lcom/a/b/c;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/a/b/c;-><init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    goto/16 :goto_0

    .line 213
    :cond_4
    new-instance v0, Lcom/a/b/v;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/a/b/v;-><init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    goto/16 :goto_0

    .line 214
    :cond_5
    const-string v0, "android.resource"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 215
    new-instance v0, Lcom/a/b/ar;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/a/b/ar;-><init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    goto/16 :goto_0

    .line 217
    :cond_6
    new-instance v0, Lcom/a/b/ab;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v6}, Lcom/a/b/ab;-><init>(Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;Lcom/a/b/s;)V

    goto/16 :goto_0
.end method

.method static a(IIIILandroid/graphics/BitmapFactory$Options;)V
    .locals 3

    .prologue
    .line 227
    const/4 v0, 0x1

    .line 228
    if-gt p3, p1, :cond_0

    if-le p2, p0, :cond_1

    .line 229
    :cond_0
    int-to-float v0, p3

    int-to-float v1, p1

    div-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    .line 230
    int-to-float v1, p2

    int-to-float v2, p0

    div-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    .line 231
    if-ge v0, v1, :cond_2

    .line 234
    :cond_1
    :goto_0
    iput v0, p4, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 235
    const/4 v0, 0x0

    iput-boolean v0, p4, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 236
    return-void

    :cond_2
    move v0, v1

    .line 231
    goto :goto_0
.end method

.method static a(IILandroid/graphics/BitmapFactory$Options;)V
    .locals 2

    .prologue
    .line 222
    iget v0, p2, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    iget v1, p2, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    invoke-static {p0, p1, v0, v1, p2}, Lcom/a/b/d;->a(IIIILandroid/graphics/BitmapFactory$Options;)V

    .line 223
    return-void
.end method

.method private c()Landroid/graphics/Bitmap;
    .locals 14

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 116
    iget-boolean v0, p0, Lcom/a/b/d;->i:Z

    if-nez v0, :cond_1

    .line 117
    iget-object v0, p0, Lcom/a/b/d;->d:Lcom/a/b/h;

    iget-object v3, p0, Lcom/a/b/d;->f:Ljava/lang/String;

    invoke-interface {v0, v3}, Lcom/a/b/h;->a(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 118
    if-eqz v0, :cond_1

    .line 119
    iget-object v1, p0, Lcom/a/b/d;->e:Lcom/a/b/as;

    invoke-virtual {v1}, Lcom/a/b/as;->a()V

    .line 120
    sget-object v1, Lcom/a/b/aj;->a:Lcom/a/b/aj;

    iput-object v1, p0, Lcom/a/b/d;->l:Lcom/a/b/aj;

    .line 142
    :cond_0
    :goto_0
    return-object v0

    .line 125
    :cond_1
    iget-object v0, p0, Lcom/a/b/d;->g:Lcom/a/b/ao;

    invoke-virtual {p0, v0}, Lcom/a/b/d;->a(Lcom/a/b/ao;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 127
    if-eqz v0, :cond_0

    .line 128
    iget-object v3, p0, Lcom/a/b/d;->e:Lcom/a/b/as;

    const/4 v4, 0x2

    invoke-virtual {v3, v0, v4}, Lcom/a/b/as;->a(Landroid/graphics/Bitmap;I)V

    .line 129
    iget-object v3, p0, Lcom/a/b/d;->g:Lcom/a/b/ao;

    invoke-virtual {v3}, Lcom/a/b/ao;->b()Z

    move-result v4

    if-nez v4, :cond_2

    invoke-virtual {v3}, Lcom/a/b/ao;->c()Z

    move-result v3

    if-eqz v3, :cond_9

    :cond_2
    :goto_1
    if-nez v1, :cond_3

    iget v1, p0, Lcom/a/b/d;->n:I

    if-eqz v1, :cond_0

    .line 130
    :cond_3
    sget-object v7, Lcom/a/b/d;->o:Ljava/lang/Object;

    monitor-enter v7

    .line 131
    :try_start_0
    iget-object v1, p0, Lcom/a/b/d;->g:Lcom/a/b/ao;

    invoke-virtual {v1}, Lcom/a/b/ao;->b()Z

    move-result v1

    if-nez v1, :cond_4

    iget v1, p0, Lcom/a/b/d;->n:I

    if-eqz v1, :cond_7

    .line 132
    :cond_4
    iget-object v1, p0, Lcom/a/b/d;->g:Lcom/a/b/ao;

    iget v8, p0, Lcom/a/b/d;->n:I

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    new-instance v5, Landroid/graphics/Matrix;

    invoke-direct {v5}, Landroid/graphics/Matrix;-><init>()V

    invoke-virtual {v1}, Lcom/a/b/ao;->b()Z

    move-result v6

    if-eqz v6, :cond_10

    iget v6, v1, Lcom/a/b/ao;->d:I

    iget v9, v1, Lcom/a/b/ao;->e:I

    iget v10, v1, Lcom/a/b/ao;->h:F

    const/4 v11, 0x0

    cmpl-float v11, v10, v11

    if-eqz v11, :cond_5

    iget-boolean v11, v1, Lcom/a/b/ao;->k:Z

    if-eqz v11, :cond_a

    iget v11, v1, Lcom/a/b/ao;->i:F

    iget v12, v1, Lcom/a/b/ao;->j:F

    invoke-virtual {v5, v10, v11, v12}, Landroid/graphics/Matrix;->setRotate(FFF)V

    :cond_5
    :goto_2
    iget-boolean v10, v1, Lcom/a/b/ao;->f:Z

    if-eqz v10, :cond_c

    int-to-float v1, v6

    int-to-float v6, v3

    div-float/2addr v1, v6

    int-to-float v6, v9

    int-to-float v9, v4

    div-float/2addr v6, v9

    cmpl-float v9, v1, v6

    if-lez v9, :cond_b

    int-to-float v9, v4

    div-float/2addr v6, v1

    mul-float/2addr v6, v9

    float-to-double v10, v6

    invoke-static {v10, v11}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v10

    double-to-int v6, v10

    sub-int/2addr v4, v6

    div-int/lit8 v4, v4, 0x2

    move v13, v1

    move v1, v2

    move v2, v4

    move v4, v6

    move v6, v13

    :goto_3
    invoke-virtual {v5, v6, v6}, Landroid/graphics/Matrix;->preScale(FF)Z

    :goto_4
    if-eqz v8, :cond_6

    int-to-float v6, v8

    invoke-virtual {v5, v6}, Landroid/graphics/Matrix;->preRotate(F)Z

    :cond_6
    const/4 v6, 0x1

    invoke-static/range {v0 .. v6}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v1

    if-eq v1, v0, :cond_7

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    move-object v0, v1

    .line 134
    :cond_7
    iget-object v1, p0, Lcom/a/b/d;->g:Lcom/a/b/ao;

    invoke-virtual {v1}, Lcom/a/b/ao;->c()Z

    move-result v1

    if-eqz v1, :cond_8

    .line 135
    iget-object v1, p0, Lcom/a/b/d;->g:Lcom/a/b/ao;

    iget-object v1, v1, Lcom/a/b/ao;->c:Ljava/util/List;

    invoke-static {v1, v0}, Lcom/a/b/d;->a(Ljava/util/List;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 137
    :cond_8
    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 138
    iget-object v1, p0, Lcom/a/b/d;->e:Lcom/a/b/as;

    const/4 v2, 0x3

    invoke-virtual {v1, v0, v2}, Lcom/a/b/as;->a(Landroid/graphics/Bitmap;I)V

    goto/16 :goto_0

    :cond_9
    move v1, v2

    .line 129
    goto/16 :goto_1

    .line 132
    :cond_a
    :try_start_1
    invoke-virtual {v5, v10}, Landroid/graphics/Matrix;->setRotate(F)V

    goto :goto_2

    .line 137
    :catchall_0
    move-exception v0

    monitor-exit v7
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 132
    :cond_b
    int-to-float v9, v3

    div-float/2addr v1, v6

    mul-float/2addr v1, v9

    float-to-double v10, v1

    :try_start_2
    invoke-static {v10, v11}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v10

    double-to-int v1, v10

    sub-int/2addr v3, v1

    div-int/lit8 v3, v3, 0x2

    move v13, v1

    move v1, v3

    move v3, v13

    goto :goto_3

    :cond_c
    iget-boolean v1, v1, Lcom/a/b/ao;->g:Z

    if-eqz v1, :cond_e

    int-to-float v1, v6

    int-to-float v6, v3

    div-float/2addr v1, v6

    int-to-float v6, v9

    int-to-float v9, v4

    div-float/2addr v6, v9

    cmpg-float v9, v1, v6

    if-gez v9, :cond_d

    :goto_5
    invoke-virtual {v5, v1, v1}, Landroid/graphics/Matrix;->preScale(FF)Z

    move v1, v2

    goto :goto_4

    :cond_d
    move v1, v6

    goto :goto_5

    :cond_e
    if-eqz v6, :cond_10

    if-eqz v9, :cond_10

    if-ne v6, v3, :cond_f

    if-eq v9, v4, :cond_10

    :cond_f
    int-to-float v1, v6

    int-to-float v6, v3

    div-float/2addr v1, v6

    int-to-float v6, v9

    int-to-float v9, v4

    div-float/2addr v6, v9

    invoke-virtual {v5, v1, v6}, Landroid/graphics/Matrix;->preScale(FF)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :cond_10
    move v1, v2

    goto :goto_4
.end method


# virtual methods
.method abstract a(Lcom/a/b/ao;)Landroid/graphics/Bitmap;
.end method

.method a()Lcom/a/b/aj;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/a/b/d;->l:Lcom/a/b/aj;

    return-object v0
.end method

.method final a(Lcom/a/b/a;)V
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/a/b/d;->h:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 147
    return-void
.end method

.method a(Landroid/net/NetworkInfo;)Z
    .locals 1

    .prologue
    .line 166
    const/4 v0, 0x0

    return v0
.end method

.method final b()Z
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/a/b/d;->k:Ljava/util/concurrent/Future;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/b/d;->k:Ljava/util/concurrent/Future;

    invoke-interface {v0}, Ljava/util/concurrent/Future;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public run()V
    .locals 6

    .prologue
    .line 83
    :try_start_0
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v0, "Picasso-"

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/a/b/d;->g:Lcom/a/b/ao;

    iget-object v3, v0, Lcom/a/b/ao;->a:Landroid/net/Uri;

    if-eqz v3, :cond_0

    iget-object v0, v0, Lcom/a/b/ao;->a:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/Thread;->setName(Ljava/lang/String;)V

    .line 85
    invoke-direct {p0}, Lcom/a/b/d;->c()Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/a/b/d;->j:Landroid/graphics/Bitmap;

    .line 87
    iget-object v0, p0, Lcom/a/b/d;->j:Landroid/graphics/Bitmap;

    if-nez v0, :cond_1

    .line 88
    iget-object v0, p0, Lcom/a/b/d;->c:Lcom/a/b/n;

    invoke-virtual {v0, p0}, Lcom/a/b/n;->a(Lcom/a/b/d;)V
    :try_end_0
    .catch Lcom/a/b/u; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 107
    :goto_1
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    const-string v1, "Picasso-Idle"

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setName(Ljava/lang/String;)V

    .line 108
    :goto_2
    return-void

    .line 83
    :cond_0
    :try_start_1
    iget v0, v0, Lcom/a/b/ao;->b:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 90
    :cond_1
    iget-object v0, p0, Lcom/a/b/d;->c:Lcom/a/b/n;

    iget-object v1, v0, Lcom/a/b/n;->f:Landroid/os/Handler;

    iget-object v0, v0, Lcom/a/b/n;->f:Landroid/os/Handler;

    const/4 v2, 0x4

    invoke-virtual {v0, v2, p0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_1
    .catch Lcom/a/b/u; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 92
    :catch_0
    move-exception v0

    .line 93
    :try_start_2
    iput-object v0, p0, Lcom/a/b/d;->m:Ljava/lang/Exception;

    .line 94
    iget-object v0, p0, Lcom/a/b/d;->c:Lcom/a/b/n;

    invoke-virtual {v0, p0}, Lcom/a/b/n;->a(Lcom/a/b/d;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 107
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    const-string v1, "Picasso-Idle"

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setName(Ljava/lang/String;)V

    goto :goto_2

    .line 95
    :catch_1
    move-exception v0

    .line 96
    :try_start_3
    iput-object v0, p0, Lcom/a/b/d;->m:Ljava/lang/Exception;

    .line 97
    iget-object v0, p0, Lcom/a/b/d;->c:Lcom/a/b/n;

    iget-object v1, v0, Lcom/a/b/n;->f:Landroid/os/Handler;

    iget-object v0, v0, Lcom/a/b/n;->f:Landroid/os/Handler;

    const/4 v2, 0x5

    invoke-virtual {v0, v2, p0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    const-wide/16 v2, 0x1f4

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 107
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    const-string v1, "Picasso-Idle"

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setName(Ljava/lang/String;)V

    goto :goto_2

    .line 98
    :catch_2
    move-exception v0

    .line 99
    :try_start_4
    new-instance v1, Ljava/io/StringWriter;

    invoke-direct {v1}, Ljava/io/StringWriter;-><init>()V

    .line 100
    iget-object v2, p0, Lcom/a/b/d;->e:Lcom/a/b/as;

    invoke-virtual {v2}, Lcom/a/b/as;->b()Lcom/a/b/av;

    move-result-object v2

    new-instance v3, Ljava/io/PrintWriter;

    invoke-direct {v3, v1}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    const-string v4, "===============BEGIN PICASSO STATS ==============="

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    const-string v4, "Memory Cache Stats"

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    const-string v4, "  Max Cache Size: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v4, v2, Lcom/a/b/av;->a:I

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->println(I)V

    const-string v4, "  Cache Size: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v4, v2, Lcom/a/b/av;->b:I

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->println(I)V

    const-string v4, "  Cache % Full: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v4, v2, Lcom/a/b/av;->b:I

    int-to-float v4, v4

    iget v5, v2, Lcom/a/b/av;->a:I

    int-to-float v5, v5

    div-float/2addr v4, v5

    const/high16 v5, 0x42c80000    # 100.0f

    mul-float/2addr v4, v5

    float-to-double v4, v4

    invoke-static {v4, v5}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v4

    double-to-int v4, v4

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->println(I)V

    const-string v4, "  Cache Hits: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-wide v4, v2, Lcom/a/b/av;->c:J

    invoke-virtual {v3, v4, v5}, Ljava/io/PrintWriter;->println(J)V

    const-string v4, "  Cache Misses: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-wide v4, v2, Lcom/a/b/av;->d:J

    invoke-virtual {v3, v4, v5}, Ljava/io/PrintWriter;->println(J)V

    const-string v4, "Bitmap Stats"

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    const-string v4, "  Total Bitmaps Decoded: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v4, v2, Lcom/a/b/av;->i:I

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->println(I)V

    const-string v4, "  Total Bitmap Size: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-wide v4, v2, Lcom/a/b/av;->e:J

    invoke-virtual {v3, v4, v5}, Ljava/io/PrintWriter;->println(J)V

    const-string v4, "  Total Transformed Bitmaps: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v4, v2, Lcom/a/b/av;->j:I

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->println(I)V

    const-string v4, "  Total Transformed Bitmap Size: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-wide v4, v2, Lcom/a/b/av;->f:J

    invoke-virtual {v3, v4, v5}, Ljava/io/PrintWriter;->println(J)V

    const-string v4, "  Average Bitmap Size: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-wide v4, v2, Lcom/a/b/av;->g:J

    invoke-virtual {v3, v4, v5}, Ljava/io/PrintWriter;->println(J)V

    const-string v4, "  Average Transformed Bitmap Size: "

    invoke-virtual {v3, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-wide v4, v2, Lcom/a/b/av;->h:J

    invoke-virtual {v3, v4, v5}, Ljava/io/PrintWriter;->println(J)V

    const-string v2, "===============END PICASSO STATS ==============="

    invoke-virtual {v3, v2}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/PrintWriter;->flush()V

    .line 101
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-virtual {v1}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    iput-object v2, p0, Lcom/a/b/d;->m:Ljava/lang/Exception;

    .line 102
    iget-object v0, p0, Lcom/a/b/d;->c:Lcom/a/b/n;

    invoke-virtual {v0, p0}, Lcom/a/b/n;->a(Lcom/a/b/d;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 107
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    const-string v1, "Picasso-Idle"

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setName(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 103
    :catch_3
    move-exception v0

    .line 104
    :try_start_5
    iput-object v0, p0, Lcom/a/b/d;->m:Ljava/lang/Exception;

    .line 105
    iget-object v0, p0, Lcom/a/b/d;->c:Lcom/a/b/n;

    invoke-virtual {v0, p0}, Lcom/a/b/n;->a(Lcom/a/b/d;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 107
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    const-string v1, "Picasso-Idle"

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setName(Ljava/lang/String;)V

    goto/16 :goto_2

    :catchall_0
    move-exception v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    const-string v2, "Picasso-Idle"

    invoke-virtual {v1, v2}, Ljava/lang/Thread;->setName(Ljava/lang/String;)V

    throw v0
.end method
