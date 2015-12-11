.class public final Lcom/a/b/aq;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:Lcom/a/b/ad;

.field public final b:Lcom/a/b/ap;

.field public c:Z

.field public d:Z

.field public e:I

.field private f:Z

.field private g:Landroid/graphics/drawable/Drawable;

.field private h:I

.field private i:Landroid/graphics/drawable/Drawable;


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    iput-object v1, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    .line 58
    new-instance v0, Lcom/a/b/ap;

    invoke-direct {v0, v1}, Lcom/a/b/ap;-><init>(Landroid/net/Uri;)V

    iput-object v0, p0, Lcom/a/b/aq;->b:Lcom/a/b/ap;

    .line 59
    return-void
.end method

.method constructor <init>(Lcom/a/b/ad;Landroid/net/Uri;)V
    .locals 2

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iget-boolean v0, p1, Lcom/a/b/ad;->k:Z

    if-eqz v0, :cond_0

    .line 49
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Picasso instance already shut down. Cannot submit new requests."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_0
    iput-object p1, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    .line 53
    new-instance v0, Lcom/a/b/ap;

    invoke-direct {v0, p2}, Lcom/a/b/ap;-><init>(Landroid/net/Uri;)V

    iput-object v0, p0, Lcom/a/b/aq;->b:Lcom/a/b/ap;

    .line 54
    return-void
.end method


# virtual methods
.method public final a(Landroid/widget/ImageView;Lcom/a/b/j;)V
    .locals 10

    .prologue
    .line 343
    if-nez p1, :cond_0

    .line 344
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Target must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 347
    :cond_0
    iget-object v0, p0, Lcom/a/b/aq;->b:Lcom/a/b/ap;

    invoke-virtual {v0}, Lcom/a/b/ap;->a()Z

    move-result v0

    if-nez v0, :cond_2

    .line 348
    iget-object v0, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    invoke-virtual {v0, p1}, Lcom/a/b/ad;->a(Ljava/lang/Object;)V

    .line 349
    iget v0, p0, Lcom/a/b/aq;->e:I

    iget-object v1, p0, Lcom/a/b/aq;->g:Landroid/graphics/drawable/Drawable;

    invoke-static {p1, v0, v1}, Lcom/a/b/am;->a(Landroid/widget/ImageView;ILandroid/graphics/drawable/Drawable;)V

    .line 390
    :cond_1
    :goto_0
    return-void

    .line 353
    :cond_2
    iget-boolean v0, p0, Lcom/a/b/aq;->d:Z

    if-eqz v0, :cond_7

    .line 354
    iget-object v0, p0, Lcom/a/b/aq;->b:Lcom/a/b/ap;

    iget v0, v0, Lcom/a/b/ap;->a:I

    if-eqz v0, :cond_3

    const/4 v0, 0x1

    :goto_1
    if-eqz v0, :cond_4

    .line 355
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Fit cannot be used with resize."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 354
    :cond_3
    const/4 v0, 0x0

    goto :goto_1

    .line 357
    :cond_4
    invoke-virtual {p1}, Landroid/widget/ImageView;->getMeasuredWidth()I

    move-result v0

    .line 358
    invoke-virtual {p1}, Landroid/widget/ImageView;->getMeasuredHeight()I

    move-result v1

    .line 359
    if-eqz v0, :cond_5

    if-nez v1, :cond_6

    .line 360
    :cond_5
    iget v0, p0, Lcom/a/b/aq;->e:I

    iget-object v1, p0, Lcom/a/b/aq;->g:Landroid/graphics/drawable/Drawable;

    invoke-static {p1, v0, v1}, Lcom/a/b/am;->a(Landroid/widget/ImageView;ILandroid/graphics/drawable/Drawable;)V

    .line 361
    iget-object v0, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    new-instance v1, Lcom/a/b/m;

    invoke-direct {v1, p0, p1, p2}, Lcom/a/b/m;-><init>(Lcom/a/b/aq;Landroid/widget/ImageView;Lcom/a/b/j;)V

    iget-object v0, v0, Lcom/a/b/ad;->h:Ljava/util/Map;

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 364
    :cond_6
    iget-object v2, p0, Lcom/a/b/aq;->b:Lcom/a/b/ap;

    invoke-virtual {v2, v0, v1}, Lcom/a/b/ap;->a(II)Lcom/a/b/ap;

    .line 367
    :cond_7
    iget-object v0, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    iget-object v1, p0, Lcom/a/b/aq;->b:Lcom/a/b/ap;

    invoke-virtual {v1}, Lcom/a/b/ap;->b()Lcom/a/b/ao;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/a/b/ad;->a(Lcom/a/b/ao;)Lcom/a/b/ao;

    move-result-object v3

    .line 368
    invoke-static {v3}, Lcom/a/b/ba;->a(Lcom/a/b/ao;)Ljava/lang/String;

    move-result-object v8

    .line 370
    iget-boolean v0, p0, Lcom/a/b/aq;->c:Z

    if-nez v0, :cond_8

    .line 371
    iget-object v0, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    invoke-virtual {v0, v8}, Lcom/a/b/ad;->b(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 372
    if-eqz v2, :cond_8

    .line 373
    iget-object v0, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    invoke-virtual {v0, p1}, Lcom/a/b/ad;->a(Ljava/lang/Object;)V

    .line 374
    iget-object v0, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    iget-object v1, v0, Lcom/a/b/ad;->c:Landroid/content/Context;

    sget-object v3, Lcom/a/b/aj;->a:Lcom/a/b/aj;

    iget-boolean v4, p0, Lcom/a/b/aq;->f:Z

    iget-object v0, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    iget-boolean v5, v0, Lcom/a/b/ad;->j:Z

    move-object v0, p1

    invoke-static/range {v0 .. v5}, Lcom/a/b/am;->a(Landroid/widget/ImageView;Landroid/content/Context;Landroid/graphics/Bitmap;Lcom/a/b/aj;ZZ)V

    .line 376
    if-eqz p2, :cond_1

    .line 377
    invoke-interface {p2}, Lcom/a/b/j;->a()V

    goto :goto_0

    .line 383
    :cond_8
    iget v0, p0, Lcom/a/b/aq;->e:I

    iget-object v1, p0, Lcom/a/b/aq;->g:Landroid/graphics/drawable/Drawable;

    invoke-static {p1, v0, v1}, Lcom/a/b/am;->a(Landroid/widget/ImageView;ILandroid/graphics/drawable/Drawable;)V

    .line 385
    new-instance v0, Lcom/a/b/w;

    iget-object v1, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    iget-boolean v4, p0, Lcom/a/b/aq;->c:Z

    iget-boolean v5, p0, Lcom/a/b/aq;->f:Z

    iget v6, p0, Lcom/a/b/aq;->h:I

    iget-object v7, p0, Lcom/a/b/aq;->i:Landroid/graphics/drawable/Drawable;

    move-object v2, p1

    move-object v9, p2

    invoke-direct/range {v0 .. v9}, Lcom/a/b/w;-><init>(Lcom/a/b/ad;Landroid/widget/ImageView;Lcom/a/b/ao;ZZILandroid/graphics/drawable/Drawable;Ljava/lang/String;Lcom/a/b/j;)V

    .line 389
    iget-object v1, p0, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    invoke-virtual {v1, v0}, Lcom/a/b/ad;->a(Lcom/a/b/a;)V

    goto/16 :goto_0
.end method
