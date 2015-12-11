.class public Lcom/nostra13/universalimageloader/core/display/FadeInBitmapDisplayer;
.super Ljava/lang/Object;
.source "FadeInBitmapDisplayer.java"

# interfaces
.implements Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;


# instance fields
.field private final durationMillis:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "durationMillis"    # I

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput p1, p0, Lcom/nostra13/universalimageloader/core/display/FadeInBitmapDisplayer;->durationMillis:I

    .line 35
    return-void
.end method

.method public static animate(Landroid/widget/ImageView;I)V
    .locals 3
    .param p0, "imageView"    # Landroid/widget/ImageView;
    .param p1, "durationMillis"    # I

    .prologue
    .line 53
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/4 v1, 0x0

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-direct {v0, v1, v2}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 54
    .local v0, "fadeImage":Landroid/view/animation/AlphaAnimation;
    int-to-long v1, p1

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/AlphaAnimation;->setDuration(J)V

    .line 55
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/animation/AlphaAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 56
    invoke-virtual {p0, v0}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 57
    return-void
.end method


# virtual methods
.method public display(Landroid/graphics/Bitmap;Landroid/widget/ImageView;)Landroid/graphics/Bitmap;
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .param p2, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 39
    invoke-virtual {p2, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 41
    iget v0, p0, Lcom/nostra13/universalimageloader/core/display/FadeInBitmapDisplayer;->durationMillis:I

    invoke-static {p2, v0}, Lcom/nostra13/universalimageloader/core/display/FadeInBitmapDisplayer;->animate(Landroid/widget/ImageView;I)V

    .line 43
    return-object p1
.end method
