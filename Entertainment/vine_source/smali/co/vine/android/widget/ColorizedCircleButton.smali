.class public Lco/vine/android/widget/ColorizedCircleButton;
.super Landroid/widget/ImageView;
.source "ColorizedCircleButton.java"


# static fields
.field public static final PRESSED:I = 0x2

.field public static final UNPRESSED:I = 0x1


# instance fields
.field private mColor:I

.field private final mGray:I

.field private mIcon:Landroid/graphics/drawable/Drawable;

.field private mState:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/widget/ColorizedCircleButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

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

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/ColorizedCircleButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 38
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 40
    invoke-virtual {p0}, Lco/vine/android/widget/ColorizedCircleButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 42
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f090019

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    iput v1, p0, Lco/vine/android/widget/ColorizedCircleButton;->mGray:I

    .line 44
    iget v1, p0, Lco/vine/android/widget/ColorizedCircleButton;->mGray:I

    iput v1, p0, Lco/vine/android/widget/ColorizedCircleButton;->mColor:I

    .line 46
    invoke-virtual {p0}, Lco/vine/android/widget/ColorizedCircleButton;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/widget/ColorizedCircleButton;->mIcon:Landroid/graphics/drawable/Drawable;

    .line 47
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 52
    invoke-virtual {p0}, Lco/vine/android/widget/ColorizedCircleButton;->isPressed()Z

    move-result v0

    if-nez v0, :cond_0

    iget v0, p0, Lco/vine/android/widget/ColorizedCircleButton;->mState:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 53
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/ColorizedCircleButton;->mIcon:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Lco/vine/android/widget/ColorizedCircleButton;->mColor:I

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 57
    :goto_0
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 58
    return-void

    .line 55
    :cond_1
    iget-object v0, p0, Lco/vine/android/widget/ColorizedCircleButton;->mIcon:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Lco/vine/android/widget/ColorizedCircleButton;->mGray:I

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    goto :goto_0
.end method

.method public setColor(I)V
    .locals 0
    .param p1, "color"    # I

    .prologue
    .line 61
    iput p1, p0, Lco/vine/android/widget/ColorizedCircleButton;->mColor:I

    .line 62
    invoke-virtual {p0}, Lco/vine/android/widget/ColorizedCircleButton;->invalidate()V

    .line 63
    return-void
.end method

.method public setSelected(Z)V
    .locals 1
    .param p1, "selected"    # Z

    .prologue
    .line 71
    if-eqz p1, :cond_0

    const/4 v0, 0x2

    :goto_0
    invoke-virtual {p0, v0}, Lco/vine/android/widget/ColorizedCircleButton;->setState(I)V

    .line 72
    invoke-super {p0, p1}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 73
    return-void

    .line 71
    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setState(I)V
    .locals 0
    .param p1, "state"    # I

    .prologue
    .line 66
    iput p1, p0, Lco/vine/android/widget/ColorizedCircleButton;->mState:I

    .line 67
    return-void
.end method
