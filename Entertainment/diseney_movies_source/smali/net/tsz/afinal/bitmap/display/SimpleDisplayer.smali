.class public Lnet/tsz/afinal/bitmap/display/SimpleDisplayer;
.super Ljava/lang/Object;
.source "SimpleDisplayer.java"

# interfaces
.implements Lnet/tsz/afinal/bitmap/display/Displayer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private animationDisplay(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 62
    if-eqz p3, :cond_0

    .line 63
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    move-result-wide v0

    invoke-virtual {p3, v0, v1}, Landroid/view/animation/Animation;->setStartTime(J)V

    .line 64
    invoke-virtual {p1, p3}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 66
    :cond_0
    invoke-virtual {p1, p2}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 67
    return-void
.end method

.method private fadeInDisplay(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V
    .locals 5
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 52
    new-instance v0, Landroid/graphics/drawable/TransitionDrawable;

    const/4 v1, 0x2

    new-array v1, v1, [Landroid/graphics/drawable/Drawable;

    const/4 v2, 0x0

    .line 53
    new-instance v3, Landroid/graphics/drawable/ColorDrawable;

    const v4, 0x106000d

    invoke-direct {v3, v4}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    aput-object v3, v1, v2

    const/4 v2, 0x1

    .line 54
    new-instance v3, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p1}, Landroid/widget/ImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-direct {v3, v4, p2}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    aput-object v3, v1, v2

    .line 52
    invoke-direct {v0, v1}, Landroid/graphics/drawable/TransitionDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    .line 56
    .local v0, "td":Landroid/graphics/drawable/TransitionDrawable;
    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 57
    const/16 v1, 0x12c

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/TransitionDrawable;->startTransition(I)V

    .line 58
    return-void
.end method


# virtual methods
.method public loadCompletedisplay(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;)V
    .locals 1
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "config"    # Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .prologue
    .line 31
    invoke-virtual {p3}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getAnimationType()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 41
    :goto_0
    return-void

    .line 33
    :pswitch_0
    invoke-direct {p0, p1, p2}, Lnet/tsz/afinal/bitmap/display/SimpleDisplayer;->fadeInDisplay(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 36
    :pswitch_1
    invoke-virtual {p3}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lnet/tsz/afinal/bitmap/display/SimpleDisplayer;->animationDisplay(Landroid/widget/ImageView;Landroid/graphics/Bitmap;Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 31
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public loadFailDisplay(Landroid/widget/ImageView;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 45
    invoke-virtual {p1, p2}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 46
    return-void
.end method
