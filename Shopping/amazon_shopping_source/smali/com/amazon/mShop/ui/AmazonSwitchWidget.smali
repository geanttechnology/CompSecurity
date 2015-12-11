.class public Lcom/amazon/mShop/ui/AmazonSwitchWidget;
.super Landroid/widget/CompoundButton;
.source "AmazonSwitchWidget.java"


# static fields
.field private static final CHECKED_STATE_SET:[I


# instance fields
.field private final mMinFlingVelocity:I

.field private mOffLayout:Landroid/text/Layout;

.field private mOnLayout:Landroid/text/Layout;

.field private mSwitchBottom:I

.field private mSwitchHeight:I

.field private mSwitchLeft:I

.field private final mSwitchMaxWidth:I

.field private final mSwitchPadding:I

.field private mSwitchRight:I

.field private mSwitchTop:I

.field private mSwitchWidth:I

.field private final mTempRect:Landroid/graphics/Rect;

.field private mTextColors:Landroid/content/res/ColorStateList;

.field private mTextOff:Ljava/lang/CharSequence;

.field private mTextOn:Ljava/lang/CharSequence;

.field private final mTextPaint:Landroid/text/TextPaint;

.field private final mThumbDrawable:Landroid/graphics/drawable/Drawable;

.field private final mThumbMargin:I

.field private mThumbPosition:F

.field private final mThumbTextPadding:I

.field private mThumbWidth:I

.field private mTouchMode:I

.field private final mTouchSlop:I

.field private mTouchX:F

.field private mTouchY:F

.field private final mTrackDrawable:Landroid/graphics/drawable/Drawable;

.field private final mVelocityTracker:Landroid/view/VelocityTracker;

.field private final mVelocityUnit:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 92
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x10100a0

    aput v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->CHECKED_STATE_SET:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 100
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 101
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 111
    sget v0, Lcom/amazon/mShop/android/lib/R$attr;->AmazonSwitchStyle:I

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 112
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 124
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/CompoundButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 71
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 72
    const/16 v4, 0x3e8

    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mVelocityUnit:I

    .line 90
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4}, Landroid/graphics/Rect;-><init>()V

    iput-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    .line 126
    new-instance v4, Landroid/text/TextPaint;

    invoke-direct {v4, v7}, Landroid/text/TextPaint;-><init>(I)V

    iput-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    .line 127
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 128
    .local v3, "res":Landroid/content/res/Resources;
    iget-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v5, v5, Landroid/util/DisplayMetrics;->density:F

    iput v5, v4, Landroid/text/TextPaint;->density:F

    .line 130
    sget-object v4, Lcom/amazon/mShop/android/lib/R$styleable;->AmazonSwitch:[I

    invoke-virtual {p1, p2, v4, p3, v6}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 132
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v6}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    .line 133
    invoke-virtual {v0, v7}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    .line 134
    const/4 v4, 0x2

    invoke-virtual {v0, v4}, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOn:Ljava/lang/CharSequence;

    .line 135
    const/4 v4, 0x3

    invoke-virtual {v0, v4}, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOff:Ljava/lang/CharSequence;

    .line 136
    const/4 v4, 0x4

    invoke-virtual {v0, v4, v6}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v4

    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbTextPadding:I

    .line 137
    const/4 v4, 0x6

    invoke-virtual {v0, v4, v6}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v4

    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchMaxWidth:I

    .line 138
    const/4 v4, 0x7

    invoke-virtual {v0, v4, v6}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v4

    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchPadding:I

    .line 139
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$dimen;->switch_thumb_margin:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbMargin:I

    .line 140
    const/4 v4, 0x5

    invoke-virtual {v0, v4, v6}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    .line 141
    .local v1, "appearance":I
    if-eqz v1, :cond_0

    .line 142
    invoke-virtual {p0, p1, v1}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setSwitchTextAppearance(Landroid/content/Context;I)V

    .line 144
    :cond_0
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 146
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v2

    .line 147
    .local v2, "config":Landroid/view/ViewConfiguration;
    invoke-virtual {v2}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v4

    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchSlop:I

    .line 148
    invoke-virtual {v2}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    move-result v4

    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mMinFlingVelocity:I

    .line 151
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->refreshDrawableState()V

    .line 152
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->isChecked()Z

    move-result v4

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setChecked(Z)V

    .line 153
    return-void
.end method

.method private animateThumbToCheckedState(Z)V
    .locals 0
    .param p1, "newCheckedState"    # Z

    .prologue
    .line 486
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setChecked(Z)V

    .line 487
    return-void
.end method

.method private cancelSuperTouch(Landroid/view/MotionEvent;)V
    .locals 2
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 452
    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v0

    .line 453
    .local v0, "cancel":Landroid/view/MotionEvent;
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/view/MotionEvent;->setAction(I)V

    .line 454
    invoke-super {p0, v0}, Landroid/widget/CompoundButton;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 455
    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    .line 456
    return-void
.end method

.method private getTargetCheckedState()Z
    .locals 2

    .prologue
    .line 490
    iget v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbPosition:F

    invoke-direct {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getThumbScrollRange()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getThumbScrollRange()I
    .locals 2

    .prologue
    .line 588
    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-nez v0, :cond_0

    .line 589
    const/4 v0, 0x0

    .line 592
    :goto_0
    return v0

    .line 591
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 592
    iget v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchWidth:I

    iget v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbWidth:I

    sub-int/2addr v0, v1

    iget-object v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->left:I

    sub-int/2addr v0, v1

    iget-object v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->right:I

    sub-int/2addr v0, v1

    goto :goto_0
.end method

.method private hitThumb(FF)Z
    .locals 7
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 368
    iget-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    iget-object v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {v4, v5}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 369
    iget v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchTop:I

    iget v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchSlop:I

    sub-int v3, v4, v5

    .line 370
    .local v3, "thumbTop":I
    iget v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchLeft:I

    iget v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbPosition:F

    const/high16 v6, 0x3f000000    # 0.5f

    add-float/2addr v5, v6

    float-to-int v5, v5

    add-int/2addr v4, v5

    iget v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchSlop:I

    sub-int v1, v4, v5

    .line 371
    .local v1, "thumbLeft":I
    iget v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbWidth:I

    add-int/2addr v4, v1

    iget-object v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->left:I

    add-int/2addr v4, v5

    iget-object v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v5, v5, Landroid/graphics/Rect;->right:I

    add-int/2addr v4, v5

    iget v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchSlop:I

    add-int v2, v4, v5

    .line 372
    .local v2, "thumbRight":I
    iget v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchBottom:I

    iget v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchSlop:I

    add-int v0, v4, v5

    .line 373
    .local v0, "thumbBottom":I
    int-to-float v4, v1

    cmpl-float v4, p1, v4

    if-lez v4, :cond_0

    int-to-float v4, v2

    cmpg-float v4, p1, v4

    if-gez v4, :cond_0

    int-to-float v4, v3

    cmpl-float v4, p2, v4

    if-lez v4, :cond_0

    int-to-float v4, v0

    cmpg-float v4, p2, v4

    if-gez v4, :cond_0

    const/4 v4, 0x1

    :goto_0
    return v4

    :cond_0
    const/4 v4, 0x0

    goto :goto_0
.end method

.method private makeLayout(Ljava/lang/CharSequence;)Landroid/text/Layout;
    .locals 8
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    const/16 v5, 0x21

    const/4 v4, 0x0

    .line 353
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1, p1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 354
    .local v1, "spanned":Landroid/text/SpannableStringBuilder;
    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOn:Ljava/lang/CharSequence;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOn:Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 355
    new-instance v0, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$color;->white:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-direct {v0, v2}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    iget-object v2, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOn:Ljava/lang/CharSequence;

    invoke-interface {v2}, Ljava/lang/CharSequence;->length()I

    move-result v2

    invoke-virtual {v1, v0, v4, v2, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 361
    :cond_0
    :goto_0
    new-instance v0, Landroid/text/StaticLayout;

    iget-object v2, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    iget-object v3, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    invoke-static {v1, v3}, Landroid/text/Layout;->getDesiredWidth(Ljava/lang/CharSequence;Landroid/text/TextPaint;)F

    move-result v3

    float-to-double v3, v3

    invoke-static {v3, v4}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v3

    double-to-int v3, v3

    sget-object v4, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v6, 0x0

    const/4 v7, 0x1

    invoke-direct/range {v0 .. v7}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    return-object v0

    .line 357
    :cond_1
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOff:Ljava/lang/CharSequence;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOff:Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 358
    new-instance v0, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$color;->dark_gray:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-direct {v0, v2}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    iget-object v2, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOff:Ljava/lang/CharSequence;

    invoke-interface {v2}, Ljava/lang/CharSequence;->length()I

    move-result v2

    invoke-virtual {v1, v0, v4, v2, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0
.end method

.method private setSwitchTypefaceByIndex(II)V
    .locals 1
    .param p1, "typefaceIndex"    # I
    .param p2, "styleIndex"    # I

    .prologue
    .line 192
    const/4 v0, 0x0

    .line 193
    .local v0, "tf":Landroid/graphics/Typeface;
    packed-switch p1, :pswitch_data_0

    .line 207
    :goto_0
    invoke-virtual {p0, v0, p2}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setSwitchTypeface(Landroid/graphics/Typeface;I)V

    .line 208
    return-void

    .line 195
    :pswitch_0
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    .line 196
    goto :goto_0

    .line 199
    :pswitch_1
    sget-object v0, Landroid/graphics/Typeface;->SERIF:Landroid/graphics/Typeface;

    .line 200
    goto :goto_0

    .line 203
    :pswitch_2
    sget-object v0, Landroid/graphics/Typeface;->MONOSPACE:Landroid/graphics/Typeface;

    goto :goto_0

    .line 193
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private stopDrag(Landroid/view/MotionEvent;)V
    .locals 7
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 464
    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchMode:I

    .line 466
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v5

    if-ne v5, v3, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->isEnabled()Z

    move-result v5

    if-eqz v5, :cond_0

    move v0, v3

    .line 468
    .local v0, "commitChange":Z
    :goto_0
    invoke-direct {p0, p1}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->cancelSuperTouch(Landroid/view/MotionEvent;)V

    .line 470
    if-eqz v0, :cond_3

    .line 472
    iget-object v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mVelocityTracker:Landroid/view/VelocityTracker;

    const/16 v6, 0x3e8

    invoke-virtual {v5, v6}, Landroid/view/VelocityTracker;->computeCurrentVelocity(I)V

    .line 473
    iget-object v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v5}, Landroid/view/VelocityTracker;->getXVelocity()F

    move-result v2

    .line 474
    .local v2, "xvel":F
    invoke-static {v2}, Ljava/lang/Math;->abs(F)F

    move-result v5

    iget v6, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mMinFlingVelocity:I

    int-to-float v6, v6

    cmpl-float v5, v5, v6

    if-lez v5, :cond_2

    .line 475
    const/4 v5, 0x0

    cmpl-float v5, v2, v5

    if-lez v5, :cond_1

    move v1, v3

    .line 479
    .local v1, "newState":Z
    :goto_1
    invoke-direct {p0, v1}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->animateThumbToCheckedState(Z)V

    .line 483
    .end local v1    # "newState":Z
    .end local v2    # "xvel":F
    :goto_2
    return-void

    .end local v0    # "commitChange":Z
    :cond_0
    move v0, v4

    .line 466
    goto :goto_0

    .restart local v0    # "commitChange":Z
    .restart local v2    # "xvel":F
    :cond_1
    move v1, v4

    .line 475
    goto :goto_1

    .line 477
    :cond_2
    invoke-direct {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getTargetCheckedState()Z

    move-result v1

    .restart local v1    # "newState":Z
    goto :goto_1

    .line 481
    .end local v1    # "newState":Z
    .end local v2    # "xvel":F
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->isChecked()Z

    move-result v3

    invoke-direct {p0, v3}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->animateThumbToCheckedState(Z)V

    goto :goto_2
.end method


# virtual methods
.method protected drawableStateChanged()V
    .locals 2

    .prologue
    .line 606
    invoke-super {p0}, Landroid/widget/CompoundButton;->drawableStateChanged()V

    .line 608
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getDrawableState()[I

    move-result-object v0

    .line 612
    .local v0, "myDrawableState":[I
    iget-object v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 613
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 615
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->invalidate()V

    .line 616
    return-void
.end method

.method public getCompoundPaddingRight()I
    .locals 3

    .prologue
    .line 580
    invoke-super {p0}, Landroid/widget/CompoundButton;->getCompoundPaddingRight()I

    move-result v1

    iget v2, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchWidth:I

    add-int v0, v1, v2

    .line 581
    .local v0, "padding":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 582
    iget v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchPadding:I

    add-int/2addr v0, v1

    .line 584
    :cond_0
    return v0
.end method

.method public getTextOff()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 274
    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOff:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getTextOn()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 259
    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOn:Ljava/lang/CharSequence;

    return-object v0
.end method

.method protected onCreateDrawableState(I)[I
    .locals 2
    .param p1, "extraSpace"    # I

    .prologue
    .line 597
    add-int/lit8 v1, p1, 0x1

    invoke-super {p0, v1}, Landroid/widget/CompoundButton;->onCreateDrawableState(I)[I

    move-result-object v0

    .line 598
    .local v0, "drawableState":[I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->isChecked()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 599
    sget-object v1, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->CHECKED_STATE_SET:[I

    invoke-static {v0, v1}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mergeDrawableStates([I[I)[I

    .line 601
    :cond_0
    return-object v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 17
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 536
    invoke-super/range {p0 .. p1}, Landroid/widget/CompoundButton;->onDraw(Landroid/graphics/Canvas;)V

    .line 539
    move-object/from16 v0, p0

    iget v6, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchLeft:I

    .line 540
    .local v6, "switchLeft":I
    move-object/from16 v0, p0

    iget v9, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchTop:I

    .line 541
    .local v9, "switchTop":I
    move-object/from16 v0, p0

    iget v7, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchRight:I

    .line 542
    .local v7, "switchRight":I
    move-object/from16 v0, p0

    iget v1, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchBottom:I

    .line 544
    .local v1, "switchBottom":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v13, v6, v9, v7, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 545
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    move-object/from16 v0, p1

    invoke-virtual {v13, v0}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 547
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->save()I

    .line 549
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {v13, v14}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 550
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v13, v13, Landroid/graphics/Rect;->left:I

    add-int v3, v6, v13

    .line 551
    .local v3, "switchInnerLeft":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v13, v13, Landroid/graphics/Rect;->top:I

    add-int v5, v9, v13

    .line 552
    .local v5, "switchInnerTop":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v13, v13, Landroid/graphics/Rect;->right:I

    sub-int v4, v7, v13

    .line 553
    .local v4, "switchInnerRight":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v13, v13, Landroid/graphics/Rect;->bottom:I

    sub-int v2, v1, v13

    .line 554
    .local v2, "switchInnerBottom":I
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v9, v4, v1}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 556
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {v13, v14}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 557
    move-object/from16 v0, p0

    iget v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbPosition:F

    const/high16 v14, 0x3f000000    # 0.5f

    add-float/2addr v13, v14

    float-to-int v11, v13

    .line 558
    .local v11, "thumbPos":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v13, v13, Landroid/graphics/Rect;->left:I

    sub-int v13, v3, v13

    add-int v10, v13, v11

    .line 559
    .local v10, "thumbLeft":I
    add-int v13, v3, v11

    move-object/from16 v0, p0

    iget v14, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbWidth:I

    add-int/2addr v13, v14

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v14, v14, Landroid/graphics/Rect;->right:I

    add-int v12, v13, v14

    .line 561
    .local v12, "thumbRight":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    move-object/from16 v0, p0

    iget v14, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbMargin:I

    add-int/2addr v14, v10

    move-object/from16 v0, p0

    iget v15, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbMargin:I

    sub-int v15, v12, v15

    invoke-virtual {v13, v14, v9, v15, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 562
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    move-object/from16 v0, p1

    invoke-virtual {v13, v0}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 565
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextColors:Landroid/content/res/ColorStateList;

    if-eqz v13, :cond_0

    .line 566
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextColors:Landroid/content/res/ColorStateList;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getDrawableState()[I

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextColors:Landroid/content/res/ColorStateList;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v16

    invoke-virtual/range {v14 .. v16}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v14

    invoke-virtual {v13, v14}, Landroid/text/TextPaint;->setColor(I)V

    .line 568
    :cond_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getDrawableState()[I

    move-result-object v14

    iput-object v14, v13, Landroid/text/TextPaint;->drawableState:[I

    .line 570
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getTargetCheckedState()Z

    move-result v13

    if-eqz v13, :cond_1

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mOnLayout:Landroid/text/Layout;

    .line 572
    .local v8, "switchText":Landroid/text/Layout;
    :goto_0
    add-int v13, v10, v12

    div-int/lit8 v13, v13, 0x2

    invoke-virtual {v8}, Landroid/text/Layout;->getWidth()I

    move-result v14

    div-int/lit8 v14, v14, 0x2

    sub-int/2addr v13, v14

    int-to-float v13, v13

    add-int v14, v5, v2

    div-int/lit8 v14, v14, 0x2

    invoke-virtual {v8}, Landroid/text/Layout;->getHeight()I

    move-result v15

    div-int/lit8 v15, v15, 0x2

    sub-int/2addr v14, v15

    int-to-float v14, v14

    move-object/from16 v0, p1

    invoke-virtual {v0, v13, v14}, Landroid/graphics/Canvas;->translate(FF)V

    .line 573
    move-object/from16 v0, p1

    invoke-virtual {v8, v0}, Landroid/text/Layout;->draw(Landroid/graphics/Canvas;)V

    .line 575
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Canvas;->restore()V

    .line 576
    return-void

    .line 570
    .end local v8    # "switchText":Landroid/text/Layout;
    :cond_1
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mOffLayout:Landroid/text/Layout;

    goto :goto_0
.end method

.method protected onLayout(ZIIII)V
    .locals 6
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 502
    invoke-super/range {p0 .. p5}, Landroid/widget/CompoundButton;->onLayout(ZIIII)V

    .line 504
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->isChecked()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-direct {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getThumbScrollRange()I

    move-result v4

    int-to-float v4, v4

    :goto_0
    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbPosition:F

    .line 506
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getWidth()I

    move-result v4

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getPaddingRight()I

    move-result v5

    sub-int v2, v4, v5

    .line 507
    .local v2, "switchRight":I
    iget v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchWidth:I

    sub-int v1, v2, v4

    .line 508
    .local v1, "switchLeft":I
    const/4 v3, 0x0

    .line 509
    .local v3, "switchTop":I
    const/4 v0, 0x0

    .line 510
    .local v0, "switchBottom":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getGravity()I

    move-result v4

    and-int/lit8 v4, v4, 0x70

    sparse-switch v4, :sswitch_data_0

    .line 513
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getPaddingTop()I

    move-result v3

    .line 514
    iget v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchHeight:I

    add-int v0, v3, v4

    .line 528
    :goto_1
    iput v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchLeft:I

    .line 529
    iput v3, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchTop:I

    .line 530
    iput v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchBottom:I

    .line 531
    iput v2, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchRight:I

    .line 532
    return-void

    .line 504
    .end local v0    # "switchBottom":I
    .end local v1    # "switchLeft":I
    .end local v2    # "switchRight":I
    .end local v3    # "switchTop":I
    :cond_0
    const/4 v4, 0x0

    goto :goto_0

    .line 518
    .restart local v0    # "switchBottom":I
    .restart local v1    # "switchLeft":I
    .restart local v2    # "switchRight":I
    .restart local v3    # "switchTop":I
    :sswitch_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getPaddingTop()I

    move-result v4

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getHeight()I

    move-result v5

    add-int/2addr v4, v5

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getPaddingBottom()I

    move-result v5

    sub-int/2addr v4, v5

    div-int/lit8 v4, v4, 0x2

    iget v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchHeight:I

    div-int/lit8 v5, v5, 0x2

    sub-int v3, v4, v5

    .line 519
    iget v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchHeight:I

    add-int v0, v3, v4

    .line 520
    goto :goto_1

    .line 523
    :sswitch_1
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getHeight()I

    move-result v4

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getPaddingBottom()I

    move-result v5

    sub-int v0, v4, v5

    .line 524
    iget v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchHeight:I

    sub-int v3, v0, v4

    goto :goto_1

    .line 510
    :sswitch_data_0
    .sparse-switch
        0x10 -> :sswitch_0
        0x50 -> :sswitch_1
    .end sparse-switch
.end method

.method public onMeasure(II)V
    .locals 11
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 287
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v6

    .line 288
    .local v6, "widthMode":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v0

    .line 289
    .local v0, "heightMode":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v7

    .line 290
    .local v7, "widthSize":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    .line 293
    .local v1, "heightSize":I
    iget-object v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mOnLayout:Landroid/text/Layout;

    if-nez v8, :cond_0

    .line 294
    iget-object v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOn:Ljava/lang/CharSequence;

    invoke-direct {p0, v8}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->makeLayout(Ljava/lang/CharSequence;)Landroid/text/Layout;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mOnLayout:Landroid/text/Layout;

    .line 296
    :cond_0
    iget-object v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mOffLayout:Landroid/text/Layout;

    if-nez v8, :cond_1

    .line 297
    iget-object v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOff:Ljava/lang/CharSequence;

    invoke-direct {p0, v8}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->makeLayout(Ljava/lang/CharSequence;)Landroid/text/Layout;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mOffLayout:Landroid/text/Layout;

    .line 300
    :cond_1
    iget-object v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    iget-object v9, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    invoke-virtual {v8, v9}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 301
    iget-object v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mOnLayout:Landroid/text/Layout;

    invoke-virtual {v8}, Landroid/text/Layout;->getWidth()I

    move-result v8

    iget-object v9, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mOffLayout:Landroid/text/Layout;

    invoke-virtual {v9}, Landroid/text/Layout;->getWidth()I

    move-result v9

    invoke-static {v8, v9}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 302
    .local v2, "maxTextWidth":I
    iget v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchMaxWidth:I

    mul-int/lit8 v9, v2, 0x2

    iget v10, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbTextPadding:I

    mul-int/lit8 v10, v10, 0x4

    add-int/2addr v9, v10

    iget-object v10, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->left:I

    add-int/2addr v9, v10

    iget-object v10, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTempRect:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->right:I

    add-int/2addr v9, v10

    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 303
    .local v5, "switchWidth":I
    iget-object v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v8}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v4

    .line 305
    .local v4, "switchHeight":I
    iget v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbTextPadding:I

    mul-int/lit8 v8, v8, 0x2

    add-int/2addr v8, v2

    iput v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbWidth:I

    .line 307
    sparse-switch v6, :sswitch_data_0

    .line 321
    :goto_0
    sparse-switch v0, :sswitch_data_1

    .line 335
    :goto_1
    iput v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchWidth:I

    .line 336
    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mSwitchHeight:I

    .line 338
    invoke-super {p0, p1, p2}, Landroid/widget/CompoundButton;->onMeasure(II)V

    .line 339
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getMeasuredHeight()I

    move-result v3

    .line 340
    .local v3, "measuredHeight":I
    if-ge v3, v4, :cond_2

    .line 344
    sget v8, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v9, 0xb

    if-lt v8, v9, :cond_3

    .line 345
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getMeasuredWidthAndState()I

    move-result v8

    invoke-virtual {p0, v8, v4}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setMeasuredDimension(II)V

    .line 350
    :cond_2
    :goto_2
    return-void

    .line 309
    .end local v3    # "measuredHeight":I
    :sswitch_0
    invoke-static {v7, v5}, Ljava/lang/Math;->min(II)I

    move-result v7

    .line 310
    goto :goto_0

    .line 313
    :sswitch_1
    move v7, v5

    .line 314
    goto :goto_0

    .line 323
    :sswitch_2
    invoke-static {v1, v4}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 324
    goto :goto_1

    .line 327
    :sswitch_3
    move v1, v4

    .line 328
    goto :goto_1

    .line 347
    .restart local v3    # "measuredHeight":I
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getMeasuredWidth()I

    move-result v8

    invoke-virtual {p0, v8, v4}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setMeasuredDimension(II)V

    goto :goto_2

    .line 307
    :sswitch_data_0
    .sparse-switch
        -0x80000000 -> :sswitch_0
        0x0 -> :sswitch_1
    .end sparse-switch

    .line 321
    :sswitch_data_1
    .sparse-switch
        -0x80000000 -> :sswitch_2
        0x0 -> :sswitch_3
    .end sparse-switch
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 9
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v8, 0x2

    const/4 v5, 0x1

    .line 378
    iget-object v6, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v6, p1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 384
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v7, 0x7

    if-le v6, v7, :cond_2

    .line 385
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    .line 390
    .local v0, "action":I
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 448
    :cond_0
    :goto_1
    :pswitch_0
    invoke-super {p0, p1}, Landroid/widget/CompoundButton;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v5

    :cond_1
    :goto_2
    return v5

    .line 387
    .end local v0    # "action":I
    :cond_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .restart local v0    # "action":I
    goto :goto_0

    .line 392
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    .line 393
    .local v3, "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    .line 394
    .local v4, "y":F
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->isEnabled()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-direct {p0, v3, v4}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->hitThumb(FF)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 395
    iput v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchMode:I

    .line 396
    iput v3, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchX:F

    .line 397
    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchY:F

    goto :goto_1

    .line 403
    .end local v3    # "x":F
    .end local v4    # "y":F
    :pswitch_2
    iget v6, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchMode:I

    packed-switch v6, :pswitch_data_1

    goto :goto_1

    .line 409
    :pswitch_3
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    .line 410
    .restart local v3    # "x":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    .line 411
    .restart local v4    # "y":F
    iget v6, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchX:F

    sub-float v6, v3, v6

    invoke-static {v6}, Ljava/lang/Math;->abs(F)F

    move-result v6

    iget v7, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchSlop:I

    int-to-float v7, v7

    cmpl-float v6, v6, v7

    if-gtz v6, :cond_3

    iget v6, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchY:F

    sub-float v6, v4, v6

    invoke-static {v6}, Ljava/lang/Math;->abs(F)F

    move-result v6

    iget v7, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchSlop:I

    int-to-float v7, v7

    cmpl-float v6, v6, v7

    if-lez v6, :cond_0

    .line 412
    :cond_3
    iput v8, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchMode:I

    .line 413
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getParent()Landroid/view/ViewParent;

    move-result-object v6

    invoke-interface {v6, v5}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 414
    iput v3, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchX:F

    .line 415
    iput v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchY:F

    goto :goto_2

    .line 422
    .end local v3    # "x":F
    .end local v4    # "y":F
    :pswitch_4
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    .line 423
    .restart local v3    # "x":F
    iget v6, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchX:F

    sub-float v1, v3, v6

    .line 424
    .local v1, "dx":F
    const/4 v6, 0x0

    iget v7, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbPosition:F

    add-float/2addr v7, v1

    invoke-direct {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getThumbScrollRange()I

    move-result v8

    int-to-float v8, v8

    invoke-static {v7, v8}, Ljava/lang/Math;->min(FF)F

    move-result v7

    invoke-static {v6, v7}, Ljava/lang/Math;->max(FF)F

    move-result v2

    .line 425
    .local v2, "newPos":F
    iget v6, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbPosition:F

    cmpl-float v6, v2, v6

    if-eqz v6, :cond_1

    .line 426
    iput v2, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbPosition:F

    .line 427
    iput v3, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchX:F

    .line 428
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->invalidate()V

    goto/16 :goto_2

    .line 438
    .end local v1    # "dx":F
    .end local v2    # "newPos":F
    .end local v3    # "x":F
    :pswitch_5
    iget v6, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchMode:I

    if-ne v6, v8, :cond_4

    .line 439
    invoke-direct {p0, p1}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->stopDrag(Landroid/view/MotionEvent;)V

    goto/16 :goto_2

    .line 442
    :cond_4
    const/4 v5, 0x0

    iput v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTouchMode:I

    .line 443
    iget-object v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mVelocityTracker:Landroid/view/VelocityTracker;

    invoke-virtual {v5}, Landroid/view/VelocityTracker;->clear()V

    goto/16 :goto_1

    .line 390
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_5
        :pswitch_2
        :pswitch_5
    .end packed-switch

    .line 403
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public setChecked(Z)V
    .locals 1
    .param p1, "checked"    # Z

    .prologue
    .line 495
    invoke-super {p0, p1}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 496
    if-eqz p1, :cond_0

    invoke-direct {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getThumbScrollRange()I

    move-result v0

    int-to-float v0, v0

    :goto_0
    iput v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbPosition:F

    .line 497
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->invalidate()V

    .line 498
    return-void

    .line 496
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setSwitchTextAppearance(Landroid/content/Context;I)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resid"    # I

    .prologue
    const/4 v6, 0x0

    const/4 v7, -0x1

    .line 160
    sget-object v5, Lcom/amazon/mShop/android/lib/R$styleable;->AmazonTextAppearance:[I

    invoke-virtual {p1, p2, v5}, Landroid/content/Context;->obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 165
    .local v0, "appearance":Landroid/content/res/TypedArray;
    const/4 v5, 0x3

    invoke-virtual {v0, v5}, Landroid/content/res/TypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v1

    .line 166
    .local v1, "colors":Landroid/content/res/ColorStateList;
    if-eqz v1, :cond_1

    .line 167
    iput-object v1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextColors:Landroid/content/res/ColorStateList;

    .line 173
    :goto_0
    invoke-virtual {v0, v6, v6}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    .line 174
    .local v3, "ts":I
    if-eqz v3, :cond_0

    .line 175
    int-to-float v5, v3

    iget-object v6, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v6}, Landroid/text/TextPaint;->getTextSize()F

    move-result v6

    cmpl-float v5, v5, v6

    if-eqz v5, :cond_0

    .line 176
    iget-object v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    int-to-float v6, v3

    invoke-virtual {v5, v6}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 177
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->requestLayout()V

    .line 183
    :cond_0
    const/4 v5, 0x1

    invoke-virtual {v0, v5, v7}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v4

    .line 184
    .local v4, "typefaceIndex":I
    const/4 v5, 0x2

    invoke-virtual {v0, v5, v7}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    .line 186
    .local v2, "styleIndex":I
    invoke-direct {p0, v4, v2}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setSwitchTypefaceByIndex(II)V

    .line 188
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 189
    return-void

    .line 170
    .end local v2    # "styleIndex":I
    .end local v3    # "ts":I
    .end local v4    # "typefaceIndex":I
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextColors:Landroid/content/res/ColorStateList;

    goto :goto_0
.end method

.method public setSwitchTypeface(Landroid/graphics/Typeface;)V
    .locals 1
    .param p1, "tf"    # Landroid/graphics/Typeface;

    .prologue
    .line 247
    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v0}, Landroid/text/TextPaint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v0

    if-eq v0, p1, :cond_0

    .line 248
    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v0, p1}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 250
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->requestLayout()V

    .line 251
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->invalidate()V

    .line 253
    :cond_0
    return-void
.end method

.method public setSwitchTypeface(Landroid/graphics/Typeface;I)V
    .locals 6
    .param p1, "tf"    # Landroid/graphics/Typeface;
    .param p2, "style"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 217
    if-lez p2, :cond_4

    .line 218
    if-nez p1, :cond_1

    .line 219
    invoke-static {p2}, Landroid/graphics/Typeface;->defaultFromStyle(I)Landroid/graphics/Typeface;

    move-result-object p1

    .line 224
    :goto_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setSwitchTypeface(Landroid/graphics/Typeface;)V

    .line 226
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Landroid/graphics/Typeface;->getStyle()I

    move-result v1

    .line 227
    .local v1, "typefaceStyle":I
    :goto_1
    xor-int/lit8 v4, v1, -0x1

    and-int v0, p2, v4

    .line 228
    .local v0, "need":I
    iget-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    and-int/lit8 v5, v0, 0x1

    if-eqz v5, :cond_0

    const/4 v2, 0x1

    :cond_0
    invoke-virtual {v4, v2}, Landroid/text/TextPaint;->setFakeBoldText(Z)V

    .line 229
    iget-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    and-int/lit8 v2, v0, 0x2

    if-eqz v2, :cond_3

    const/high16 v2, -0x41800000    # -0.25f

    :goto_2
    invoke-virtual {v4, v2}, Landroid/text/TextPaint;->setTextSkewX(F)V

    .line 235
    .end local v0    # "need":I
    .end local v1    # "typefaceStyle":I
    :goto_3
    return-void

    .line 221
    :cond_1
    invoke-static {p1, p2}, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;

    move-result-object p1

    goto :goto_0

    :cond_2
    move v1, v2

    .line 226
    goto :goto_1

    .restart local v0    # "need":I
    .restart local v1    # "typefaceStyle":I
    :cond_3
    move v2, v3

    .line 229
    goto :goto_2

    .line 231
    .end local v0    # "need":I
    .end local v1    # "typefaceStyle":I
    :cond_4
    iget-object v4, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v4, v2}, Landroid/text/TextPaint;->setFakeBoldText(Z)V

    .line 232
    iget-object v2, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextPaint:Landroid/text/TextPaint;

    invoke-virtual {v2, v3}, Landroid/text/TextPaint;->setTextSkewX(F)V

    .line 233
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->setSwitchTypeface(Landroid/graphics/Typeface;)V

    goto :goto_3
.end method

.method public setTextOff(Ljava/lang/CharSequence;)V
    .locals 0
    .param p1, "textOff"    # Ljava/lang/CharSequence;

    .prologue
    .line 281
    iput-object p1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOff:Ljava/lang/CharSequence;

    .line 282
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->requestLayout()V

    .line 283
    return-void
.end method

.method public setTextOn(Ljava/lang/CharSequence;)V
    .locals 0
    .param p1, "textOn"    # Ljava/lang/CharSequence;

    .prologue
    .line 266
    iput-object p1, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTextOn:Ljava/lang/CharSequence;

    .line 267
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->requestLayout()V

    .line 268
    return-void
.end method

.method protected verifyDrawable(Landroid/graphics/drawable/Drawable;)Z
    .locals 1
    .param p1, "who"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 620
    invoke-super {p0, p1}, Landroid/widget/CompoundButton;->verifyDrawable(Landroid/graphics/drawable/Drawable;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mThumbDrawable:Landroid/graphics/drawable/Drawable;

    if-eq p1, v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/ui/AmazonSwitchWidget;->mTrackDrawable:Landroid/graphics/drawable/Drawable;

    if-ne p1, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
