.class public Lcom/aio/downloader/views/LDrawerButton;
.super Lcom/aio/downloader/views/LButton;
.source "LDrawerButton.java"


# instance fields
.field private final TAG:Ljava/lang/String;

.field private mBaseDegrees:I

.field private mCenterX:I

.field private mCenterY:I

.field private mCurrentDegrees:I

.field private mIsLeftGravity:Z

.field private mLeftOffsetY:F

.field private mLine1TopBase:I

.field private mLine2TopBase:I

.field private mLine3TopBase:I

.field private mLineHalfWidth:I

.field private mLineLeftBase:I

.field private mLineLeftOffset:F

.field private mLinePaint:Landroid/graphics/Paint;

.field private mLineRightBase:I

.field private mLineSplit:I

.field private mRightOffsetY:F

.field private mSplitHalfHeight:I

.field private mStrokeWidth:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v5, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 35
    invoke-direct {p0, p1, p2}, Lcom/aio/downloader/views/LButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 12
    const-string v3, "LDrawerButton"

    iput-object v3, p0, Lcom/aio/downloader/views/LDrawerButton;->TAG:Ljava/lang/String;

    .line 14
    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    iput-object v3, p0, Lcom/aio/downloader/views/LDrawerButton;->mLinePaint:Landroid/graphics/Paint;

    .line 30
    iput v2, p0, Lcom/aio/downloader/views/LDrawerButton;->mCurrentDegrees:I

    .line 31
    iput-boolean v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mIsLeftGravity:Z

    .line 32
    iput v2, p0, Lcom/aio/downloader/views/LDrawerButton;->mBaseDegrees:I

    .line 36
    iget-object v3, p0, Lcom/aio/downloader/views/LDrawerButton;->mLinePaint:Landroid/graphics/Paint;

    const/4 v4, -0x1

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 37
    if-eqz p2, :cond_0

    .line 39
    sget-object v3, Lcom/aio/downloader/R$styleable;->LButtonStyle:[I

    .line 38
    invoke-virtual {p1, p2, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 40
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v3, 0x3

    invoke-virtual {v0, v3, v1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    .line 41
    if-eq v3, v5, :cond_1

    .line 40
    :goto_0
    iput-boolean v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mIsLeftGravity:Z

    .line 42
    invoke-virtual {v0, v5, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/views/LDrawerButton;->setDelayClick(Z)V

    .line 44
    iget-boolean v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mIsLeftGravity:Z

    if-eqz v1, :cond_2

    :goto_1
    iput v2, p0, Lcom/aio/downloader/views/LDrawerButton;->mBaseDegrees:I

    .line 45
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 48
    .end local v0    # "a":Landroid/content/res/TypedArray;
    :cond_0
    return-void

    .restart local v0    # "a":Landroid/content/res/TypedArray;
    :cond_1
    move v1, v2

    .line 41
    goto :goto_0

    .line 44
    :cond_2
    const/16 v2, 0xb4

    goto :goto_1
.end method

.method private initDrawer()V
    .locals 2

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/aio/downloader/views/LDrawerButton;->getWidth()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/aio/downloader/views/LDrawerButton;->getHeight()I

    move-result v0

    if-nez v0, :cond_1

    .line 66
    :cond_0
    :goto_0
    return-void

    .line 53
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/views/LDrawerButton;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterX:I

    .line 54
    invoke-virtual {p0}, Lcom/aio/downloader/views/LDrawerButton;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterY:I

    .line 55
    invoke-virtual {p0}, Lcom/aio/downloader/views/LDrawerButton;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x23

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mStrokeWidth:I

    .line 56
    iget-object v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLinePaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mStrokeWidth:I

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 57
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mStrokeWidth:I

    mul-int/lit8 v0, v0, 0x3

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineSplit:I

    .line 58
    invoke-virtual {p0}, Lcom/aio/downloader/views/LDrawerButton;->getHeight()I

    move-result v0

    int-to-float v0, v0

    const/high16 v1, 0x40900000    # 4.5f

    div-float/2addr v0, v1

    float-to-int v0, v0

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineHalfWidth:I

    .line 59
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterX:I

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineHalfWidth:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineLeftBase:I

    .line 60
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterX:I

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineHalfWidth:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineRightBase:I

    .line 62
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterY:I

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineSplit:I

    sub-int/2addr v0, v1

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mStrokeWidth:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine1TopBase:I

    .line 63
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterY:I

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine2TopBase:I

    .line 64
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterY:I

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineSplit:I

    add-int/2addr v0, v1

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mStrokeWidth:I

    add-int/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine3TopBase:I

    .line 65
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine3TopBase:I

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine2TopBase:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mSplitHalfHeight:I

    goto :goto_0
.end method


# virtual methods
.method public onDrag(ZF)V
    .locals 4
    .param p1, "isOpened"    # Z
    .param p2, "progress"    # F

    .prologue
    const/high16 v3, 0x3f800000    # 1.0f

    .line 87
    const/4 v1, 0x0

    cmpg-float v1, p2, v1

    if-gez v1, :cond_1

    .line 88
    const/4 p2, 0x0

    .line 92
    :cond_0
    :goto_0
    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineHalfWidth:I

    int-to-float v1, v1

    mul-float/2addr v1, p2

    iput v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineLeftOffset:F

    .line 93
    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mSplitHalfHeight:I

    int-to-float v1, v1

    const/high16 v2, 0x3fc00000    # 1.5f

    div-float/2addr v1, v2

    mul-float/2addr v1, p2

    iput v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLeftOffsetY:F

    .line 94
    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mSplitHalfHeight:I

    int-to-float v1, v1

    mul-float/2addr v1, p2

    iput v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mRightOffsetY:F

    .line 95
    if-eqz p1, :cond_2

    sub-float v0, v3, p2

    .line 96
    .local v0, "degreesProgress":F
    :goto_1
    const/high16 v1, 0x43340000    # 180.0f

    mul-float/2addr v1, v0

    float-to-int v2, v1

    if-eqz p1, :cond_3

    const/16 v1, 0xb4

    :goto_2
    add-int/2addr v1, v2

    .line 97
    iget v2, p0, Lcom/aio/downloader/views/LDrawerButton;->mBaseDegrees:I

    add-int/2addr v1, v2

    .line 96
    iput v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mCurrentDegrees:I

    .line 98
    invoke-virtual {p0}, Lcom/aio/downloader/views/LDrawerButton;->invalidate()V

    .line 99
    return-void

    .line 89
    .end local v0    # "degreesProgress":F
    :cond_1
    cmpl-float v1, p2, v3

    if-lez v1, :cond_0

    .line 90
    const/high16 p2, 0x3f800000    # 1.0f

    goto :goto_0

    :cond_2
    move v0, p2

    .line 95
    goto :goto_1

    .line 96
    .restart local v0    # "degreesProgress":F
    :cond_3
    const/4 v1, 0x0

    goto :goto_2
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 70
    invoke-super {p0, p1}, Lcom/aio/downloader/views/LButton;->onDraw(Landroid/graphics/Canvas;)V

    .line 71
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterX:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterY:I

    if-nez v0, :cond_1

    .line 72
    :cond_0
    invoke-direct {p0}, Lcom/aio/downloader/views/LDrawerButton;->initDrawer()V

    .line 74
    :cond_1
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mCurrentDegrees:I

    int-to-float v0, v0

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterX:I

    int-to-float v1, v1

    iget v2, p0, Lcom/aio/downloader/views/LDrawerButton;->mCenterY:I

    int-to-float v2, v2

    invoke-virtual {p1, v0, v1, v2}, Landroid/graphics/Canvas;->rotate(FFF)V

    .line 76
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineLeftBase:I

    int-to-float v0, v0

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineLeftOffset:F

    add-float/2addr v1, v0

    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine1TopBase:I

    int-to-float v0, v0

    .line 77
    iget v2, p0, Lcom/aio/downloader/views/LDrawerButton;->mLeftOffsetY:F

    sub-float v2, v0, v2

    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineRightBase:I

    int-to-float v3, v0

    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine1TopBase:I

    int-to-float v0, v0

    iget v4, p0, Lcom/aio/downloader/views/LDrawerButton;->mRightOffsetY:F

    add-float/2addr v4, v0

    .line 78
    iget-object v5, p0, Lcom/aio/downloader/views/LDrawerButton;->mLinePaint:Landroid/graphics/Paint;

    move-object v0, p1

    .line 76
    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 79
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineLeftBase:I

    int-to-float v0, v0

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineLeftOffset:F

    const/high16 v2, 0x40400000    # 3.0f

    div-float/2addr v1, v2

    add-float/2addr v1, v0

    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine2TopBase:I

    int-to-float v2, v0

    .line 80
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineRightBase:I

    int-to-float v3, v0

    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine2TopBase:I

    int-to-float v4, v0

    iget-object v5, p0, Lcom/aio/downloader/views/LDrawerButton;->mLinePaint:Landroid/graphics/Paint;

    move-object v0, p1

    .line 79
    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 81
    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineLeftBase:I

    int-to-float v0, v0

    iget v1, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineLeftOffset:F

    add-float/2addr v1, v0

    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine3TopBase:I

    int-to-float v0, v0

    .line 82
    iget v2, p0, Lcom/aio/downloader/views/LDrawerButton;->mLeftOffsetY:F

    add-float/2addr v2, v0

    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLineRightBase:I

    int-to-float v3, v0

    iget v0, p0, Lcom/aio/downloader/views/LDrawerButton;->mLine3TopBase:I

    int-to-float v0, v0

    iget v4, p0, Lcom/aio/downloader/views/LDrawerButton;->mRightOffsetY:F

    sub-float v4, v0, v4

    .line 83
    iget-object v5, p0, Lcom/aio/downloader/views/LDrawerButton;->mLinePaint:Landroid/graphics/Paint;

    move-object v0, p1

    .line 81
    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 84
    return-void
.end method
