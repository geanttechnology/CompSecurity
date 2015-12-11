.class public Lco/vine/android/widget/ColorPickerCircle;
.super Landroid/widget/ImageView;
.source "ColorPickerCircle.java"


# instance fields
.field private mIndex:I

.field private mSelected:Z

.field private mWhiteCircle:Landroid/graphics/drawable/Drawable;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/widget/ColorPickerCircle;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 34
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/ColorPickerCircle;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .prologue
    .line 38
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 39
    invoke-virtual {p0}, Lco/vine/android/widget/ColorPickerCircle;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 40
    .local v1, "res":Landroid/content/res/Resources;
    sget-object v2, Lco/vine/android/R$styleable;->ColorPickerCircle:[I

    const/4 v3, 0x0

    invoke-virtual {p1, p2, v2, p3, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 42
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 43
    const v2, 0x7f0200f8

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/widget/ColorPickerCircle;->mWhiteCircle:Landroid/graphics/drawable/Drawable;

    .line 44
    return-void
.end method


# virtual methods
.method public getIndex()I
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lco/vine/android/widget/ColorPickerCircle;->mIndex:I

    return v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 48
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 49
    iget-boolean v1, p0, Lco/vine/android/widget/ColorPickerCircle;->mSelected:Z

    if-eqz v1, :cond_0

    .line 50
    invoke-virtual {p0}, Lco/vine/android/widget/ColorPickerCircle;->getWidth()I

    move-result v0

    .line 51
    .local v0, "width":I
    iget-object v1, p0, Lco/vine/android/widget/ColorPickerCircle;->mWhiteCircle:Landroid/graphics/drawable/Drawable;

    div-int/lit8 v2, v0, 0x4

    div-int/lit8 v3, v0, 0x4

    mul-int/lit8 v4, v0, 0x3

    div-int/lit8 v4, v4, 0x4

    mul-int/lit8 v5, v0, 0x3

    div-int/lit8 v5, v5, 0x4

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 52
    iget-object v1, p0, Lco/vine/android/widget/ColorPickerCircle;->mWhiteCircle:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 54
    .end local v0    # "width":I
    :cond_0
    return-void
.end method

.method public setIndex(I)V
    .locals 3
    .param p1, "index"    # I

    .prologue
    .line 64
    iput p1, p0, Lco/vine/android/widget/ColorPickerCircle;->mIndex:I

    .line 65
    invoke-virtual {p0}, Lco/vine/android/widget/ColorPickerCircle;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200f7

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 66
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    sget-object v1, Lco/vine/android/Settings;->PROFILE_BACKGROUND_COLORS:[I

    aget v1, v1, p1

    const/high16 v2, -0x1000000

    or-int/2addr v1, v2

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 68
    invoke-static {p0, v0}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 69
    invoke-virtual {p0}, Lco/vine/android/widget/ColorPickerCircle;->invalidate()V

    .line 70
    return-void
.end method

.method public setSelected(Z)V
    .locals 0
    .param p1, "selected"    # Z

    .prologue
    .line 58
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 59
    iput-boolean p1, p0, Lco/vine/android/widget/ColorPickerCircle;->mSelected:Z

    .line 60
    invoke-virtual {p0}, Lco/vine/android/widget/ColorPickerCircle;->invalidate()V

    .line 61
    return-void
.end method
