.class final Lcom/a/b/ar;
.super Lcom/a/b/d;
.source "SourceFile"


# instance fields
.field private final o:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V
    .locals 6

    .prologue
    .line 31
    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-direct/range {v0 .. v5}, Lcom/a/b/d;-><init>(Lcom/a/b/ad;Lcom/a/b/n;Lcom/a/b/h;Lcom/a/b/as;Lcom/a/b/a;)V

    .line 32
    iput-object p1, p0, Lcom/a/b/ar;->o:Landroid/content/Context;

    .line 33
    return-void
.end method


# virtual methods
.method final a(Lcom/a/b/ao;)Landroid/graphics/Bitmap;
    .locals 5

    .prologue
    .line 36
    iget-object v0, p0, Lcom/a/b/ar;->o:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v2, p1, Lcom/a/b/ao;->b:I

    const/4 v0, 0x0

    invoke-virtual {p1}, Lcom/a/b/ao;->a()Z

    move-result v3

    if-eqz v3, :cond_0

    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    const/4 v3, 0x1

    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    invoke-static {v1, v2, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    iget v3, p1, Lcom/a/b/ao;->d:I

    iget v4, p1, Lcom/a/b/ao;->e:I

    invoke-static {v3, v4, v0}, Lcom/a/b/ar;->a(IILandroid/graphics/BitmapFactory$Options;)V

    :cond_0
    invoke-static {v1, v2, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method final a()Lcom/a/b/aj;
    .locals 1

    .prologue
    .line 40
    sget-object v0, Lcom/a/b/aj;->b:Lcom/a/b/aj;

    return-object v0
.end method
