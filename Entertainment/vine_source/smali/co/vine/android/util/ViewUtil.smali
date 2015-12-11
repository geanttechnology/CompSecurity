.class public Lco/vine/android/util/ViewUtil;
.super Ljava/lang/Object;
.source "ViewUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/ViewUtil$ResizeAnimationType;
    }
.end annotation


# static fields
.field public static final EMPTY_VIEW_CLICK_LISTENER:Landroid/view/View$OnClickListener;

.field private static sActionBarHeight:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const/4 v0, -0x1

    sput v0, Lco/vine/android/util/ViewUtil;->sActionBarHeight:I

    .line 32
    new-instance v0, Lco/vine/android/util/ViewUtil$1;

    invoke-direct {v0}, Lco/vine/android/util/ViewUtil$1;-><init>()V

    sput-object v0, Lco/vine/android/util/ViewUtil;->EMPTY_VIEW_CLICK_LISTENER:Landroid/view/View$OnClickListener;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 149
    return-void
.end method

.method public static fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V
    .locals 2
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "color"    # I
    .param p2, "resId"    # I
    .param p3, "v"    # Landroid/view/View;

    .prologue
    .line 140
    instance-of v1, p3, Landroid/widget/ImageView;

    if-eqz v1, :cond_0

    .line 141
    check-cast p3, Landroid/widget/ImageView;

    .end local p3    # "v":Landroid/view/View;
    sget-object v1, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {p3, p1, v1}, Landroid/widget/ImageView;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 147
    :goto_0
    return-void

    .line 143
    .restart local p3    # "v":Landroid/view/View;
    :cond_0
    invoke-virtual {p0, p2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 144
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    sget-object v1, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, p1, v1}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 145
    invoke-static {p3, v0}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public static getActionBarHeight(Landroid/content/Context;)I
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v4, 0x0

    .line 39
    sget v1, Lco/vine/android/util/ViewUtil;->sActionBarHeight:I

    if-gez v1, :cond_0

    .line 40
    invoke-virtual {p0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [I

    const v3, 0x10102eb

    aput v3, v2, v4

    invoke-virtual {v1, v2}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 42
    .local v0, "styledAttributes":Landroid/content/res/TypedArray;
    const/high16 v1, -0x40800000    # -1.0f

    invoke-virtual {v0, v4, v1}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v1

    float-to-int v1, v1

    sput v1, Lco/vine/android/util/ViewUtil;->sActionBarHeight:I

    .line 43
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 45
    .end local v0    # "styledAttributes":Landroid/content/res/TypedArray;
    :cond_0
    sget v1, Lco/vine/android/util/ViewUtil;->sActionBarHeight:I

    return v1
.end method

.method public static getFontScale(Landroid/content/Context;)F
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 52
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->fontScale:F

    return v0
.end method

.method public static getPecentageColor(FI)I
    .locals 1
    .param p0, "percent"    # F
    .param p1, "color"    # I

    .prologue
    .line 87
    const/high16 v0, 0x437f0000    # 255.0f

    mul-float/2addr v0, p0

    float-to-int v0, v0

    shl-int/lit8 v0, v0, 0x18

    or-int/2addr v0, p1

    return v0
.end method

.method public static makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;I)Landroid/view/animation/Animation;
    .locals 2
    .param p0, "type"    # Lco/vine/android/util/ViewUtil$ResizeAnimationType;
    .param p1, "v"    # Landroid/view/View;
    .param p2, "targetSize"    # I

    .prologue
    .line 158
    const/4 v0, -0x1

    const/4 v1, 0x0

    invoke-static {p0, p1, p2, v0, v1}, Lco/vine/android/util/ViewUtil;->makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;IILandroid/view/animation/Animation$AnimationListener;)Landroid/view/animation/Animation;

    move-result-object v0

    return-object v0
.end method

.method public static makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;II)Landroid/view/animation/Animation;
    .locals 1
    .param p0, "type"    # Lco/vine/android/util/ViewUtil$ResizeAnimationType;
    .param p1, "v"    # Landroid/view/View;
    .param p2, "targetSize"    # I
    .param p3, "duration"    # I

    .prologue
    .line 163
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, p3, v0}, Lco/vine/android/util/ViewUtil;->makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;IILandroid/view/animation/Animation$AnimationListener;)Landroid/view/animation/Animation;

    move-result-object v0

    return-object v0
.end method

.method public static makeResizeAnimation(Lco/vine/android/util/ViewUtil$ResizeAnimationType;Landroid/view/View;IILandroid/view/animation/Animation$AnimationListener;)Landroid/view/animation/Animation;
    .locals 8
    .param p0, "type"    # Lco/vine/android/util/ViewUtil$ResizeAnimationType;
    .param p1, "v"    # Landroid/view/View;
    .param p2, "targetSize"    # I
    .param p3, "duration"    # I
    .param p4, "listener"    # Landroid/view/animation/Animation$AnimationListener;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 170
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 171
    .local v2, "params":Landroid/view/ViewGroup$LayoutParams;
    sget-object v7, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->EXPAND_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    if-eq p0, v7, :cond_0

    sget-object v7, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->COLLAPSE_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    if-ne p0, v7, :cond_3

    :cond_0
    move v4, v6

    .line 173
    .local v4, "typeWidth":Z
    :goto_0
    sget-object v7, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->EXPAND_WIDTH:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    if-eq p0, v7, :cond_1

    sget-object v7, Lco/vine/android/util/ViewUtil$ResizeAnimationType;->EXPAND_HEIGHT:Lco/vine/android/util/ViewUtil$ResizeAnimationType;

    if-ne p0, v7, :cond_4

    :cond_1
    move v3, v6

    .line 175
    .local v3, "typeExpand":Z
    :goto_1
    if-eqz v3, :cond_6

    .line 176
    if-eqz v4, :cond_5

    .line 177
    iput v5, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 181
    :goto_2
    invoke-virtual {p1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 182
    new-instance v0, Lco/vine/android/util/ViewUtil$3;

    invoke-direct {v0, v4, v2, p2, p1}, Lco/vine/android/util/ViewUtil$3;-><init>(ZLandroid/view/ViewGroup$LayoutParams;ILandroid/view/View;)V

    .line 224
    .local v0, "animation":Landroid/view/animation/Animation;
    :goto_3
    if-lez p3, :cond_2

    .line 225
    int-to-long v5, p3

    invoke-virtual {v0, v5, v6}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 227
    :cond_2
    invoke-virtual {v0, p4}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 228
    return-object v0

    .end local v0    # "animation":Landroid/view/animation/Animation;
    .end local v3    # "typeExpand":Z
    .end local v4    # "typeWidth":Z
    :cond_3
    move v4, v5

    .line 171
    goto :goto_0

    .restart local v4    # "typeWidth":Z
    :cond_4
    move v3, v5

    .line 173
    goto :goto_1

    .line 179
    .restart local v3    # "typeExpand":Z
    :cond_5
    iput v5, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_2

    .line 201
    :cond_6
    if-eqz v4, :cond_7

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 202
    .local v1, "initialSize":I
    :goto_4
    new-instance v0, Lco/vine/android/util/ViewUtil$4;

    invoke-direct {v0, p1, v4, v2, v1}, Lco/vine/android/util/ViewUtil$4;-><init>(Landroid/view/View;ZLandroid/view/ViewGroup$LayoutParams;I)V

    .restart local v0    # "animation":Landroid/view/animation/Animation;
    goto :goto_3

    .line 201
    .end local v0    # "animation":Landroid/view/animation/Animation;
    .end local v1    # "initialSize":I
    :cond_7
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    goto :goto_4
.end method

.method public static varargs reduceTextSizeViaFontScaleIfNeeded(Landroid/content/Context;FF[Landroid/widget/TextView;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "maxScaleToStart"    # F
    .param p2, "maxStepDown"    # F
    .param p3, "textViews"    # [Landroid/widget/TextView;

    .prologue
    .line 63
    invoke-static {p0}, Lco/vine/android/util/ViewUtil;->getFontScale(Landroid/content/Context;)F

    move-result v1

    .line 64
    .local v1, "fontScale":F
    cmpl-float v5, v1, p1

    if-lez v5, :cond_0

    .line 65
    move-object v0, p3

    .local v0, "arr$":[Landroid/widget/TextView;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v4, v0, v2

    .line 66
    .local v4, "textView":Landroid/widget/TextView;
    invoke-static {v4, v1, p2}, Lco/vine/android/util/ViewUtil;->stepDownViaFontScale(Landroid/widget/TextView;FF)V

    .line 65
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 69
    .end local v0    # "arr$":[Landroid/widget/TextView;
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    .end local v4    # "textView":Landroid/widget/TextView;
    :cond_0
    return-void
.end method

.method public static setActionBarHeight(Landroid/support/v7/app/ActionBarActivity;Landroid/view/View;)V
    .locals 2
    .param p0, "actionBarActivity"    # Landroid/support/v7/app/ActionBarActivity;
    .param p1, "viewToSet"    # Landroid/view/View;

    .prologue
    .line 94
    invoke-static {p0}, Lco/vine/android/util/ViewUtil;->getActionBarHeight(Landroid/content/Context;)I

    move-result v0

    .line 95
    .local v0, "height":I
    if-lez v0, :cond_0

    .line 96
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 100
    :goto_0
    return-void

    .line 98
    :cond_0
    invoke-static {p0, p1}, Lco/vine/android/util/ViewUtil;->setActionBarHeightWhenReady(Landroid/support/v7/app/ActionBarActivity;Landroid/view/View;)V

    goto :goto_0
.end method

.method public static setActionBarHeightWhenReady(Landroid/support/v7/app/ActionBarActivity;Landroid/view/View;)V
    .locals 2
    .param p0, "actionBarActivity"    # Landroid/support/v7/app/ActionBarActivity;
    .param p1, "viewToSet"    # Landroid/view/View;

    .prologue
    .line 103
    invoke-virtual {p1}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 104
    .local v0, "observer":Landroid/view/ViewTreeObserver;
    if-eqz v0, :cond_0

    .line 105
    new-instance v1, Lco/vine/android/util/ViewUtil$2;

    invoke-direct {v1, p0, p1, v0}, Lco/vine/android/util/ViewUtil$2;-><init>(Landroid/support/v7/app/ActionBarActivity;Landroid/view/View;Landroid/view/ViewTreeObserver;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 123
    :cond_0
    return-void
.end method

.method public static setBackground(Landroid/content/res/Resources;Landroid/view/View;Landroid/graphics/Bitmap;)V
    .locals 1
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "view"    # Landroid/view/View;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 135
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v0, p0, p2}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 136
    .local v0, "d":Landroid/graphics/drawable/BitmapDrawable;
    invoke-static {p1, v0}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 137
    return-void
.end method

.method public static setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    .locals 2
    .param p0, "view"    # Landroid/view/View;
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 127
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 128
    invoke-virtual {p0, p1}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 132
    :goto_0
    return-void

    .line 130
    :cond_0
    invoke-virtual {p0, p1}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public static stepDownViaFontScale(Landroid/widget/TextView;FF)V
    .locals 11
    .param p0, "textView"    # Landroid/widget/TextView;
    .param p1, "fontScale"    # F
    .param p2, "maxStepDown"    # F

    .prologue
    .line 78
    invoke-virtual {p0}, Landroid/widget/TextView;->getTextSize()F

    move-result v0

    .line 79
    .local v0, "size":F
    float-to-double v1, v0

    float-to-double v3, p2

    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    const-wide/high16 v7, 0x3ff8000000000000L    # 1.5

    float-to-double v9, p1

    sub-double/2addr v7, v9

    sub-double/2addr v5, v7

    mul-double/2addr v3, v5

    sub-double/2addr v1, v3

    double-to-float v0, v1

    .line 80
    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 81
    return-void
.end method
