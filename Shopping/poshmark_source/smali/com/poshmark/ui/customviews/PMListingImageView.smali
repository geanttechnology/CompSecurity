.class public Lcom/poshmark/ui/customviews/PMListingImageView;
.super Lcom/poshmark/ui/customviews/PMImageView;
.source "PMListingImageView.java"


# static fields
.field static final LEFT:I = 0x1

.field static final MY_BUNDLES_ROW_IMAGE_1:I = 0x5

.field static final MY_BUNDLES_ROW_IMAGE_2:I = 0x6

.field static final MY_BUNDLES_ROW_IMAGE_3:I = 0x7

.field static final ONE_THIRD:I = 0x4

.field static final QUAD:I = 0x3

.field static final SQUARE:I = 0x0

.field static final TOP:I = 0x2


# instance fields
.field bHeightWidthSet:Z

.field height:I

.field layoutType:I

.field width:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v3, 0x0

    .line 25
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/PMImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 22
    iput-boolean v3, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->bHeightWidthSet:Z

    .line 26
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMListingImageView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/poshmark/app/R$styleable;->PMCovershotImageView:[I

    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 27
    .local v0, "array":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v3, v3}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    iput v1, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->layoutType:I

    .line 28
    return-void
.end method


# virtual methods
.method public launchFragmentOnClick()V
    .locals 0

    .prologue
    .line 76
    return-void
.end method

.method protected onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 32
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->bHeightWidthSet:Z

    if-nez v0, :cond_0

    .line 33
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMListingImageView;->getSuggestedMinimumWidth()I

    move-result v0

    invoke-static {v0, p1}, Lcom/poshmark/ui/customviews/PMListingImageView;->getDefaultSize(II)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    .line 34
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->layoutType:I

    packed-switch v0, :pswitch_data_0

    .line 54
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMListingImageView;->getSuggestedMinimumWidth()I

    move-result v0

    invoke-static {v0, p1}, Lcom/poshmark/ui/customviews/PMListingImageView;->getDefaultSize(II)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    .line 57
    :goto_0
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->height:I

    .line 58
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    iget v1, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->height:I

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/customviews/PMListingImageView;->setMeasuredDimension(II)V

    .line 59
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->bHeightWidthSet:Z

    .line 67
    :goto_1
    return-void

    .line 36
    :pswitch_0
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    iget v1, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    div-int/lit8 v1, v1, 0x3

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    goto :goto_0

    .line 39
    :pswitch_1
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    goto :goto_0

    .line 42
    :pswitch_2
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    goto :goto_0

    .line 45
    :pswitch_3
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    div-int/lit8 v0, v0, 0x3

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    goto :goto_0

    .line 48
    :pswitch_4
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    div-int/lit8 v0, v0, 0x3

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    goto :goto_0

    .line 51
    :pswitch_5
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    goto :goto_0

    .line 61
    :cond_0
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->layoutType:I

    if-nez v0, :cond_1

    .line 62
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMListingImageView;->getSuggestedMinimumWidth()I

    move-result v0

    invoke-static {v0, p1}, Lcom/poshmark/ui/customviews/PMListingImageView;->getDefaultSize(II)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    .line 63
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    iput v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->height:I

    .line 65
    :cond_1
    iget v0, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->width:I

    iget v1, p0, Lcom/poshmark/ui/customviews/PMListingImageView;->height:I

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/customviews/PMListingImageView;->setMeasuredDimension(II)V

    goto :goto_1

    .line 34
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method protected onSizeChanged(IIII)V
    .locals 0
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 72
    return-void
.end method
