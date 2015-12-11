.class final Landroid/support/v4/app/m;
.super Landroid/support/v4/app/o;
.source "SourceFile"


# instance fields
.field private a:Landroid/support/v4/app/db;


# direct methods
.method public constructor <init>(Landroid/support/v4/app/db;)V
    .locals 0

    .prologue
    .line 222
    invoke-direct {p0}, Landroid/support/v4/app/o;-><init>()V

    .line 223
    iput-object p1, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/db;

    .line 224
    return-void
.end method


# virtual methods
.method public final a(Landroid/view/View;Landroid/graphics/Matrix;Landroid/graphics/RectF;)Landroid/os/Parcelable;
    .locals 6

    .prologue
    .line 253
    iget-object v1, p0, Landroid/support/v4/app/m;->a:Landroid/support/v4/app/db;

    invoke-virtual {p3}, Landroid/graphics/RectF;->width()F

    move-result v0

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v2

    invoke-virtual {p3}, Landroid/graphics/RectF;->height()F

    move-result v0

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v3

    const/4 v0, 0x0

    if-lez v2, :cond_1

    if-lez v3, :cond_1

    iget-object v0, v1, Landroid/support/v4/app/db;->a:Landroid/graphics/Matrix;

    if-nez v0, :cond_0

    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, v1, Landroid/support/v4/app/db;->a:Landroid/graphics/Matrix;

    :cond_0
    iget-object v0, v1, Landroid/support/v4/app/db;->a:Landroid/graphics/Matrix;

    invoke-virtual {v0, p2}, Landroid/graphics/Matrix;->set(Landroid/graphics/Matrix;)V

    iget-object v0, v1, Landroid/support/v4/app/db;->a:Landroid/graphics/Matrix;

    iget v4, p3, Landroid/graphics/RectF;->left:F

    neg-float v4, v4

    iget v5, p3, Landroid/graphics/RectF;->top:F

    neg-float v5, v5

    invoke-virtual {v0, v4, v5}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    sget-object v0, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v2, v3, v0}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    new-instance v2, Landroid/graphics/Canvas;

    invoke-direct {v2, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    iget-object v1, v1, Landroid/support/v4/app/db;->a:Landroid/graphics/Matrix;

    invoke-virtual {v2, v1}, Landroid/graphics/Canvas;->concat(Landroid/graphics/Matrix;)V

    invoke-virtual {p1, v2}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    :cond_1
    return-object v0
.end method

.method public final a(Landroid/content/Context;Landroid/os/Parcelable;)Landroid/view/View;
    .locals 2

    .prologue
    .line 259
    const/4 v0, 0x0

    instance-of v1, p2, Landroid/graphics/Bitmap;

    if-eqz v1, :cond_0

    check-cast p2, Landroid/graphics/Bitmap;

    new-instance v0, Landroid/widget/ImageView;

    invoke-direct {v0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, p2}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    :cond_0
    return-object v0
.end method
