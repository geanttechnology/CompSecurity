.class public Lcom/aio/downloader/utils/ProgressWheel;
.super Landroid/view/View;
.source "ProgressWheel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private barColor:I

.field private barExtraLength:F

.field private barGrowingFromFront:Z

.field private final barLength:I

.field private final barMaxLength:I

.field private barPaint:Landroid/graphics/Paint;

.field private barSpinCycleTime:D

.field private barWidth:I

.field private circleBounds:Landroid/graphics/RectF;

.field private circleRadius:I

.field private fillRadius:Z

.field private isSpinning:Z

.field private lastTimeAnimated:J

.field private linearProgress:Z

.field private mProgress:F

.field private mTargetProgress:F

.field private final pauseGrowingTime:J

.field private pausedTimeWithoutGrowing:J

.field private rimColor:I

.field private rimPaint:Landroid/graphics/Paint;

.field private rimWidth:I

.field private spinSpeed:F

.field private timeStartGrowing:D


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/aio/downloader/utils/ProgressWheel;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/utils/ProgressWheel;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const-wide/16 v4, 0x0

    const/4 v1, 0x4

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 92
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 32
    const/16 v0, 0x1c

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    .line 33
    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    .line 34
    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    .line 36
    const/16 v0, 0x10

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barLength:I

    .line 37
    const/16 v0, 0x10e

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barMaxLength:I

    .line 39
    iput-boolean v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->fillRadius:Z

    .line 41
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->timeStartGrowing:D

    .line 42
    const-wide v0, 0x407cc00000000000L    # 460.0

    iput-wide v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barSpinCycleTime:D

    .line 43
    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barExtraLength:F

    .line 44
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barGrowingFromFront:Z

    .line 46
    iput-wide v4, p0, Lcom/aio/downloader/utils/ProgressWheel;->pausedTimeWithoutGrowing:J

    .line 47
    const-wide/16 v0, 0xc8

    iput-wide v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->pauseGrowingTime:J

    .line 50
    const/high16 v0, -0x56000000

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barColor:I

    .line 51
    const v0, 0xffffff

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimColor:I

    .line 54
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barPaint:Landroid/graphics/Paint;

    .line 55
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimPaint:Landroid/graphics/Paint;

    .line 58
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleBounds:Landroid/graphics/RectF;

    .line 62
    const/high16 v0, 0x43660000    # 230.0f

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->spinSpeed:F

    .line 65
    iput-wide v4, p0, Lcom/aio/downloader/utils/ProgressWheel;->lastTimeAnimated:J

    .line 69
    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 70
    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    .line 71
    iput-boolean v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    .line 93
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const-wide/16 v4, 0x0

    const/4 v1, 0x4

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 80
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 32
    const/16 v0, 0x1c

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    .line 33
    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    .line 34
    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    .line 36
    const/16 v0, 0x10

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barLength:I

    .line 37
    const/16 v0, 0x10e

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barMaxLength:I

    .line 39
    iput-boolean v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->fillRadius:Z

    .line 41
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->timeStartGrowing:D

    .line 42
    const-wide v0, 0x407cc00000000000L    # 460.0

    iput-wide v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barSpinCycleTime:D

    .line 43
    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barExtraLength:F

    .line 44
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barGrowingFromFront:Z

    .line 46
    iput-wide v4, p0, Lcom/aio/downloader/utils/ProgressWheel;->pausedTimeWithoutGrowing:J

    .line 47
    const-wide/16 v0, 0xc8

    iput-wide v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->pauseGrowingTime:J

    .line 50
    const/high16 v0, -0x56000000

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barColor:I

    .line 51
    const v0, 0xffffff

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimColor:I

    .line 54
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barPaint:Landroid/graphics/Paint;

    .line 55
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimPaint:Landroid/graphics/Paint;

    .line 58
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleBounds:Landroid/graphics/RectF;

    .line 62
    const/high16 v0, 0x43660000    # 230.0f

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->spinSpeed:F

    .line 65
    iput-wide v4, p0, Lcom/aio/downloader/utils/ProgressWheel;->lastTimeAnimated:J

    .line 69
    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 70
    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    .line 71
    iput-boolean v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    .line 83
    sget-object v0, Lcom/aio/downloader/R$styleable;->ProgressWheel:[I

    .line 82
    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/aio/downloader/utils/ProgressWheel;->parseAttributes(Landroid/content/res/TypedArray;)V

    .line 84
    return-void
.end method

.method private parseAttributes(Landroid/content/res/TypedArray;)V
    .locals 7
    .param p1, "a"    # Landroid/content/res/TypedArray;

    .prologue
    const/high16 v4, 0x43b40000    # 360.0f

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 210
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 211
    .local v1, "metrics":Landroid/util/DisplayMetrics;
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    int-to-float v2, v2

    invoke-static {v6, v2, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    .line 212
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    int-to-float v2, v2

    invoke-static {v6, v2, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    .line 213
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    int-to-float v2, v2

    invoke-static {v6, v2, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    .line 215
    const/4 v2, 0x6

    iget v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    int-to-float v3, v3

    invoke-virtual {p1, v2, v3}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    .line 217
    const/4 v2, 0x7

    invoke-virtual {p1, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    iput-boolean v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->fillRadius:Z

    .line 219
    const/16 v2, 0x8

    iget v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    int-to-float v3, v3

    invoke-virtual {p1, v2, v3}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    .line 221
    const/4 v2, 0x3

    iget v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    int-to-float v3, v3

    invoke-virtual {p1, v2, v3}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v2

    float-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    .line 223
    const/4 v2, 0x4

    iget v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->spinSpeed:F

    div-float/2addr v3, v4

    invoke-virtual {p1, v2, v3}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v0

    .line 224
    .local v0, "baseSpinSpeed":F
    mul-float v2, v0, v4

    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->spinSpeed:F

    .line 226
    const/4 v2, 0x5

    iget-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->barSpinCycleTime:D

    double-to-int v3, v3

    invoke-virtual {p1, v2, v3}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    int-to-double v2, v2

    iput-wide v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barSpinCycleTime:D

    .line 228
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barColor:I

    invoke-virtual {p1, v6, v2}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barColor:I

    .line 230
    const/4 v2, 0x2

    iget v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimColor:I

    invoke-virtual {p1, v2, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v2

    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimColor:I

    .line 232
    const/16 v2, 0x9

    invoke-virtual {p1, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    iput-boolean v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->linearProgress:Z

    .line 234
    invoke-virtual {p1, v5, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 235
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->spin()V

    .line 239
    :cond_0
    invoke-virtual {p1}, Landroid/content/res/TypedArray;->recycle()V

    .line 240
    return-void
.end method

.method private setupBounds(II)V
    .locals 14
    .param p1, "layout_width"    # I
    .param p2, "layout_height"    # I

    .prologue
    .line 175
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->getPaddingTop()I

    move-result v5

    .line 176
    .local v5, "paddingTop":I
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->getPaddingBottom()I

    move-result v2

    .line 177
    .local v2, "paddingBottom":I
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->getPaddingLeft()I

    move-result v3

    .line 178
    .local v3, "paddingLeft":I
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->getPaddingRight()I

    move-result v4

    .line 180
    .local v4, "paddingRight":I
    iget-boolean v8, p0, Lcom/aio/downloader/utils/ProgressWheel;->fillRadius:Z

    if-nez v8, :cond_0

    .line 182
    sub-int v8, p1, v3

    sub-int/2addr v8, v4

    .line 183
    sub-int v9, p2, v2

    sub-int/2addr v9, v5

    .line 182
    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 185
    .local v1, "minValue":I
    iget v8, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    mul-int/lit8 v8, v8, 0x2

    iget v9, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    mul-int/lit8 v9, v9, 0x2

    sub-int/2addr v8, v9

    invoke-static {v1, v8}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 188
    .local v0, "circleDiameter":I
    sub-int v8, p1, v3

    sub-int/2addr v8, v4

    sub-int/2addr v8, v0

    div-int/lit8 v8, v8, 0x2

    add-int v6, v8, v3

    .line 189
    .local v6, "xOffset":I
    sub-int v8, p2, v5

    sub-int/2addr v8, v2

    sub-int/2addr v8, v0

    div-int/lit8 v8, v8, 0x2

    add-int v7, v8, v5

    .line 191
    .local v7, "yOffset":I
    new-instance v8, Landroid/graphics/RectF;

    iget v9, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    add-int/2addr v9, v6

    int-to-float v9, v9

    .line 192
    iget v10, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    add-int/2addr v10, v7

    int-to-float v10, v10

    .line 193
    add-int v11, v6, v0

    iget v12, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    sub-int/2addr v11, v12

    int-to-float v11, v11

    .line 194
    add-int v12, v7, v0

    iget v13, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    sub-int/2addr v12, v13

    int-to-float v12, v12

    invoke-direct {v8, v9, v10, v11, v12}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 191
    iput-object v8, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleBounds:Landroid/graphics/RectF;

    .line 201
    .end local v0    # "circleDiameter":I
    .end local v1    # "minValue":I
    .end local v6    # "xOffset":I
    .end local v7    # "yOffset":I
    :goto_0
    return-void

    .line 196
    :cond_0
    new-instance v8, Landroid/graphics/RectF;

    iget v9, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    add-int/2addr v9, v3

    int-to-float v9, v9

    .line 197
    iget v10, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    add-int/2addr v10, v5

    int-to-float v10, v10

    .line 198
    sub-int v11, p1, v4

    iget v12, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    sub-int/2addr v11, v12

    int-to-float v11, v11

    .line 199
    sub-int v12, p2, v2

    iget v13, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    sub-int/2addr v12, v13

    int-to-float v12, v12

    invoke-direct {v8, v9, v10, v11, v12}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 196
    iput-object v8, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleBounds:Landroid/graphics/RectF;

    goto :goto_0
.end method

.method private setupPaints()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 160
    iget-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barPaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->barColor:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 161
    iget-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 162
    iget-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 163
    iget-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barPaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 165
    iget-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimPaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimColor:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 166
    iget-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 167
    iget-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 168
    iget-object v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimPaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 169
    return-void
.end method

.method private updateBarLength(J)V
    .locals 7
    .param p1, "deltaTimeInMilliSeconds"    # J

    .prologue
    .line 302
    iget-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->pausedTimeWithoutGrowing:J

    const-wide/16 v5, 0xc8

    cmp-long v3, v3, v5

    if-ltz v3, :cond_3

    .line 303
    iget-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->timeStartGrowing:D

    long-to-double v5, p1

    add-double/2addr v3, v5

    iput-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->timeStartGrowing:D

    .line 305
    iget-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->timeStartGrowing:D

    iget-wide v5, p0, Lcom/aio/downloader/utils/ProgressWheel;->barSpinCycleTime:D

    cmpl-double v3, v3, v5

    if-lez v3, :cond_0

    .line 308
    iget-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->timeStartGrowing:D

    iget-wide v5, p0, Lcom/aio/downloader/utils/ProgressWheel;->barSpinCycleTime:D

    sub-double/2addr v3, v5

    iput-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->timeStartGrowing:D

    .line 310
    const-wide/16 v3, 0x0

    iput-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->pausedTimeWithoutGrowing:J

    .line 312
    iget-boolean v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->barGrowingFromFront:Z

    if-eqz v3, :cond_1

    const/4 v3, 0x0

    :goto_0
    iput-boolean v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->barGrowingFromFront:Z

    .line 315
    :cond_0
    iget-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->timeStartGrowing:D

    iget-wide v5, p0, Lcom/aio/downloader/utils/ProgressWheel;->barSpinCycleTime:D

    div-double/2addr v3, v5

    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    add-double/2addr v3, v5

    const-wide v5, 0x400921fb54442d18L    # Math.PI

    mul-double/2addr v3, v5

    invoke-static {v3, v4}, Ljava/lang/Math;->cos(D)D

    move-result-wide v3

    double-to-float v3, v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    const/high16 v4, 0x3f000000    # 0.5f

    add-float v1, v3, v4

    .line 316
    .local v1, "distance":F
    const/high16 v0, 0x437e0000    # 254.0f

    .line 318
    .local v0, "destLength":F
    iget-boolean v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->barGrowingFromFront:Z

    if-eqz v3, :cond_2

    .line 319
    mul-float v3, v1, v0

    iput v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->barExtraLength:F

    .line 328
    .end local v0    # "destLength":F
    .end local v1    # "distance":F
    :goto_1
    return-void

    .line 312
    :cond_1
    const/4 v3, 0x1

    goto :goto_0

    .line 321
    .restart local v0    # "destLength":F
    .restart local v1    # "distance":F
    :cond_2
    const/high16 v3, 0x3f800000    # 1.0f

    sub-float/2addr v3, v1

    mul-float v2, v0, v3

    .line 322
    .local v2, "newLength":F
    iget v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    iget v4, p0, Lcom/aio/downloader/utils/ProgressWheel;->barExtraLength:F

    sub-float/2addr v4, v2

    add-float/2addr v3, v4

    iput v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 323
    iput v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barExtraLength:F

    goto :goto_1

    .line 326
    .end local v0    # "destLength":F
    .end local v1    # "distance":F
    .end local v2    # "newLength":F
    :cond_3
    iget-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->pausedTimeWithoutGrowing:J

    add-long/2addr v3, p1

    iput-wide v3, p0, Lcom/aio/downloader/utils/ProgressWheel;->pausedTimeWithoutGrowing:J

    goto :goto_1
.end method


# virtual methods
.method public getBarColor()I
    .locals 1

    .prologue
    .line 535
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barColor:I

    return v0
.end method

.method public getBarWidth()I
    .locals 1

    .prologue
    .line 517
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    return v0
.end method

.method public getCircleRadius()I
    .locals 1

    .prologue
    .line 499
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    return v0
.end method

.method public getProgress()F
    .locals 2

    .prologue
    .line 481
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    if-eqz v0, :cond_0

    const/high16 v0, -0x40800000    # -1.0f

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    const/high16 v1, 0x43b40000    # 360.0f

    div-float/2addr v0, v1

    goto :goto_0
.end method

.method public getRimColor()I
    .locals 1

    .prologue
    .line 554
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimColor:I

    return v0
.end method

.method public getRimWidth()I
    .locals 1

    .prologue
    .line 593
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    return v0
.end method

.method public getSpinSpeed()F
    .locals 2

    .prologue
    .line 575
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->spinSpeed:F

    const/high16 v1, 0x43b40000    # 360.0f

    div-float/2addr v0, v1

    return v0
.end method

.method public isSpinning()Z
    .locals 1

    .prologue
    .line 335
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    return v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 17
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 247
    invoke-super/range {p0 .. p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 249
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/utils/ProgressWheel;->circleBounds:Landroid/graphics/RectF;

    const/high16 v3, 0x43b40000    # 360.0f

    const/high16 v4, 0x43b40000    # 360.0f

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/utils/ProgressWheel;->rimPaint:Landroid/graphics/Paint;

    move-object/from16 v1, p1

    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    .line 251
    const/4 v15, 0x0

    .line 253
    .local v15, "mustInvalidate":Z
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    if-eqz v1, :cond_2

    .line 255
    const/4 v15, 0x1

    .line 257
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v1

    move-object/from16 v0, p0

    iget-wide v5, v0, Lcom/aio/downloader/utils/ProgressWheel;->lastTimeAnimated:J

    sub-long v12, v1, v5

    .line 258
    .local v12, "deltaTime":J
    long-to-float v1, v12

    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/utils/ProgressWheel;->spinSpeed:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x447a0000    # 1000.0f

    div-float v11, v1, v2

    .line 260
    .local v11, "deltaNormalized":F
    move-object/from16 v0, p0

    invoke-direct {v0, v12, v13}, Lcom/aio/downloader/utils/ProgressWheel;->updateBarLength(J)V

    .line 262
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    add-float/2addr v1, v11

    move-object/from16 v0, p0

    iput v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 263
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    const/high16 v2, 0x43b40000    # 360.0f

    cmpl-float v1, v1, v2

    if-lez v1, :cond_0

    .line 264
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    const/high16 v2, 0x43b40000    # 360.0f

    sub-float/2addr v1, v2

    move-object/from16 v0, p0

    iput v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 266
    :cond_0
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v1

    move-object/from16 v0, p0

    iput-wide v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->lastTimeAnimated:J

    .line 268
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    const/high16 v2, 0x42b40000    # 90.0f

    sub-float v3, v1, v2

    .line 269
    .local v3, "from":F
    const/high16 v1, 0x41800000    # 16.0f

    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/utils/ProgressWheel;->barExtraLength:F

    add-float v4, v1, v2

    .line 271
    .local v4, "length":F
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/aio/downloader/utils/ProgressWheel;->circleBounds:Landroid/graphics/RectF;

    const/4 v5, 0x0

    .line 272
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/utils/ProgressWheel;->barPaint:Landroid/graphics/Paint;

    move-object/from16 v1, p1

    .line 271
    invoke-virtual/range {v1 .. v6}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    .line 296
    .end local v3    # "from":F
    .end local v4    # "length":F
    .end local v11    # "deltaNormalized":F
    .end local v12    # "deltaTime":J
    :goto_0
    if-eqz v15, :cond_1

    .line 297
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 299
    :cond_1
    return-void

    .line 274
    :cond_2
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    cmpl-float v1, v1, v2

    if-eqz v1, :cond_3

    .line 276
    const/4 v15, 0x1

    .line 278
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v1

    move-object/from16 v0, p0

    iget-wide v5, v0, Lcom/aio/downloader/utils/ProgressWheel;->lastTimeAnimated:J

    sub-long/2addr v1, v5

    long-to-float v1, v1

    const/high16 v2, 0x447a0000    # 1000.0f

    div-float v12, v1, v2

    .line 279
    .local v12, "deltaTime":F
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->spinSpeed:F

    mul-float v11, v12, v1

    .line 281
    .restart local v11    # "deltaNormalized":F
    move-object/from16 v0, p0

    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    add-float/2addr v1, v11

    move-object/from16 v0, p0

    iget v2, v0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    invoke-static {v1, v2}, Ljava/lang/Math;->min(FF)F

    move-result v1

    move-object/from16 v0, p0

    iput v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 282
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v1

    move-object/from16 v0, p0

    iput-wide v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->lastTimeAnimated:J

    .line 285
    .end local v11    # "deltaNormalized":F
    .end local v12    # "deltaTime":F
    :cond_3
    const/16 v16, 0x0

    .line 286
    .local v16, "offset":F
    move-object/from16 v0, p0

    iget v8, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 287
    .local v8, "progress":F
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/aio/downloader/utils/ProgressWheel;->linearProgress:Z

    if-nez v1, :cond_4

    .line 288
    const/high16 v14, 0x40000000    # 2.0f

    .line 289
    .local v14, "factor":F
    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    const/high16 v5, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v6, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    const/high16 v7, 0x43b40000    # 360.0f

    div-float/2addr v6, v7

    sub-float/2addr v5, v6

    float-to-double v5, v5

    const/high16 v7, 0x40000000    # 2.0f

    mul-float/2addr v7, v14

    float-to-double v9, v7

    invoke-static {v5, v6, v9, v10}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v5

    sub-double/2addr v1, v5

    double-to-float v1, v1

    const/high16 v2, 0x43b40000    # 360.0f

    mul-float v16, v1, v2

    .line 290
    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    const/high16 v5, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v6, v0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    const/high16 v7, 0x43b40000    # 360.0f

    div-float/2addr v6, v7

    sub-float/2addr v5, v6

    float-to-double v5, v5

    float-to-double v9, v14

    invoke-static {v5, v6, v9, v10}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v5

    sub-double/2addr v1, v5

    double-to-float v1, v1

    const/high16 v2, 0x43b40000    # 360.0f

    mul-float v8, v1, v2

    .line 293
    .end local v14    # "factor":F
    :cond_4
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/utils/ProgressWheel;->circleBounds:Landroid/graphics/RectF;

    const/high16 v1, 0x42b40000    # 90.0f

    sub-float v7, v16, v1

    const/4 v9, 0x0

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/aio/downloader/utils/ProgressWheel;->barPaint:Landroid/graphics/Paint;

    move-object/from16 v5, p1

    invoke-virtual/range {v5 .. v10}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    goto/16 :goto_0
.end method

.method protected onMeasure(II)V
    .locals 12
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/high16 v11, -0x80000000

    const/high16 v10, 0x40000000    # 2.0f

    .line 101
    invoke-super {p0, p1, p2}, Landroid/view/View;->onMeasure(II)V

    .line 103
    iget v8, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->getPaddingLeft()I

    move-result v9

    add-int/2addr v8, v9

    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->getPaddingRight()I

    move-result v9

    add-int v4, v8, v9

    .line 104
    .local v4, "viewWidth":I
    iget v8, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->getPaddingTop()I

    move-result v9

    add-int/2addr v8, v9

    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->getPaddingBottom()I

    move-result v9

    add-int v3, v8, v9

    .line 106
    .local v3, "viewHeight":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v6

    .line 107
    .local v6, "widthMode":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v7

    .line 108
    .local v7, "widthSize":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    .line 109
    .local v1, "heightMode":I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    .line 115
    .local v2, "heightSize":I
    if-ne v6, v10, :cond_1

    .line 117
    move v5, v7

    .line 127
    .local v5, "width":I
    :goto_0
    if-eq v1, v10, :cond_0

    if-ne v6, v10, :cond_3

    .line 129
    :cond_0
    move v0, v2

    .line 138
    .local v0, "height":I
    :goto_1
    invoke-virtual {p0, v5, v0}, Lcom/aio/downloader/utils/ProgressWheel;->setMeasuredDimension(II)V

    .line 139
    return-void

    .line 118
    .end local v0    # "height":I
    .end local v5    # "width":I
    :cond_1
    if-ne v6, v11, :cond_2

    .line 120
    invoke-static {v4, v7}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 121
    .restart local v5    # "width":I
    goto :goto_0

    .line 123
    .end local v5    # "width":I
    :cond_2
    move v5, v4

    .restart local v5    # "width":I
    goto :goto_0

    .line 130
    :cond_3
    if-ne v1, v11, :cond_4

    .line 132
    invoke-static {v3, v2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 133
    .restart local v0    # "height":I
    goto :goto_1

    .line 135
    .end local v0    # "height":I
    :cond_4
    move v0, v3

    .restart local v0    # "height":I
    goto :goto_1
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 2
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    .line 451
    instance-of v1, p1, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;

    if-nez v1, :cond_0

    .line 452
    invoke-super {p0, p1}, Landroid/view/View;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 470
    :goto_0
    return-void

    :cond_0
    move-object v0, p1

    .line 456
    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;

    .line 457
    .local v0, "ss":Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;
    invoke-virtual {v0}, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Landroid/view/View;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 459
    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->mProgress:F

    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 460
    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->mTargetProgress:F

    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    .line 461
    iget-boolean v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->isSpinning:Z

    iput-boolean v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    .line 462
    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->spinSpeed:F

    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->spinSpeed:F

    .line 463
    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->barWidth:I

    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    .line 464
    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->barColor:I

    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->barColor:I

    .line 465
    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->rimWidth:I

    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    .line 466
    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->rimColor:I

    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimColor:I

    .line 467
    iget v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->circleRadius:I

    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    .line 468
    iget-boolean v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->linearProgress:Z

    iput-boolean v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->linearProgress:Z

    .line 469
    iget-boolean v1, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->fillRadius:Z

    iput-boolean v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->fillRadius:Z

    goto :goto_0
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .prologue
    .line 429
    invoke-super {p0}, Landroid/view/View;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    .line 431
    .local v1, "superState":Landroid/os/Parcelable;
    new-instance v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;

    invoke-direct {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;-><init>(Landroid/os/Parcelable;)V

    .line 434
    .local v0, "ss":Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    iput v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->mProgress:F

    .line 435
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    iput v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->mTargetProgress:F

    .line 436
    iget-boolean v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    iput-boolean v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->isSpinning:Z

    .line 437
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->spinSpeed:F

    iput v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->spinSpeed:F

    .line 438
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    iput v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->barWidth:I

    .line 439
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->barColor:I

    iput v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->barColor:I

    .line 440
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    iput v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->rimWidth:I

    .line 441
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimColor:I

    iput v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->rimColor:I

    .line 442
    iget v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    iput v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->circleRadius:I

    .line 443
    iget-boolean v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->linearProgress:Z

    iput-boolean v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->linearProgress:Z

    .line 444
    iget-boolean v2, p0, Lcom/aio/downloader/utils/ProgressWheel;->fillRadius:Z

    iput-boolean v2, v0, Lcom/aio/downloader/utils/ProgressWheel$WheelSavedState;->fillRadius:Z

    .line 446
    return-object v0
.end method

.method protected onSizeChanged(IIII)V
    .locals 0
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 148
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/View;->onSizeChanged(IIII)V

    .line 150
    invoke-direct {p0, p1, p2}, Lcom/aio/downloader/utils/ProgressWheel;->setupBounds(II)V

    .line 151
    invoke-direct {p0}, Lcom/aio/downloader/utils/ProgressWheel;->setupPaints()V

    .line 152
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 153
    return-void
.end method

.method public resetCount()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 342
    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 343
    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    .line 344
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 345
    return-void
.end method

.method public setBarColor(I)V
    .locals 1
    .param p1, "barColor"    # I

    .prologue
    .line 543
    iput p1, p0, Lcom/aio/downloader/utils/ProgressWheel;->barColor:I

    .line 544
    invoke-direct {p0}, Lcom/aio/downloader/utils/ProgressWheel;->setupPaints()V

    .line 545
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    if-nez v0, :cond_0

    .line 546
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 548
    :cond_0
    return-void
.end method

.method public setBarWidth(I)V
    .locals 1
    .param p1, "barWidth"    # I

    .prologue
    .line 525
    iput p1, p0, Lcom/aio/downloader/utils/ProgressWheel;->barWidth:I

    .line 526
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    if-nez v0, :cond_0

    .line 527
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 529
    :cond_0
    return-void
.end method

.method public setCircleRadius(I)V
    .locals 1
    .param p1, "circleRadius"    # I

    .prologue
    .line 507
    iput p1, p0, Lcom/aio/downloader/utils/ProgressWheel;->circleRadius:I

    .line 508
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    if-nez v0, :cond_0

    .line 509
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 511
    :cond_0
    return-void
.end method

.method public setInstantProgress(F)V
    .locals 4
    .param p1, "progress"    # F

    .prologue
    const/high16 v3, 0x43b40000    # 360.0f

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v1, 0x0

    .line 405
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    if-eqz v0, :cond_0

    .line 406
    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 407
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    .line 410
    :cond_0
    cmpl-float v0, p1, v2

    if-lez v0, :cond_2

    .line 411
    sub-float/2addr p1, v2

    .line 416
    :cond_1
    :goto_0
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    cmpl-float v0, p1, v0

    if-nez v0, :cond_3

    .line 424
    :goto_1
    return-void

    .line 412
    :cond_2
    cmpg-float v0, p1, v1

    if-gez v0, :cond_1

    .line 413
    const/4 p1, 0x0

    goto :goto_0

    .line 420
    :cond_3
    mul-float v0, p1, v3

    invoke-static {v0, v3}, Ljava/lang/Math;->min(FF)F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    .line 421
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 422
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->lastTimeAnimated:J

    .line 423
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    goto :goto_1
.end method

.method public setLinearProgress(Z)V
    .locals 1
    .param p1, "isLinear"    # Z

    .prologue
    .line 489
    iput-boolean p1, p0, Lcom/aio/downloader/utils/ProgressWheel;->linearProgress:Z

    .line 490
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    if-nez v0, :cond_0

    .line 491
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 493
    :cond_0
    return-void
.end method

.method public setProgress(F)V
    .locals 4
    .param p1, "progress"    # F

    .prologue
    const/high16 v3, 0x43b40000    # 360.0f

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v1, 0x0

    .line 372
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    if-eqz v0, :cond_0

    .line 373
    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 374
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    .line 377
    :cond_0
    cmpl-float v0, p1, v2

    if-lez v0, :cond_2

    .line 378
    sub-float/2addr p1, v2

    .line 383
    :cond_1
    :goto_0
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    cmpl-float v0, p1, v0

    if-nez v0, :cond_3

    .line 397
    :goto_1
    return-void

    .line 379
    :cond_2
    cmpg-float v0, p1, v1

    if-gez v0, :cond_1

    .line 380
    const/4 p1, 0x0

    goto :goto_0

    .line 390
    :cond_3
    iget v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    iget v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    cmpl-float v0, v0, v1

    if-nez v0, :cond_4

    .line 391
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->lastTimeAnimated:J

    .line 394
    :cond_4
    mul-float v0, p1, v3

    invoke-static {v0, v3}, Ljava/lang/Math;->min(FF)F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    .line 396
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    goto :goto_1
.end method

.method public setRimColor(I)V
    .locals 1
    .param p1, "rimColor"    # I

    .prologue
    .line 562
    iput p1, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimColor:I

    .line 563
    invoke-direct {p0}, Lcom/aio/downloader/utils/ProgressWheel;->setupPaints()V

    .line 564
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    if-nez v0, :cond_0

    .line 565
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 567
    :cond_0
    return-void
.end method

.method public setRimWidth(I)V
    .locals 1
    .param p1, "rimWidth"    # I

    .prologue
    .line 601
    iput p1, p0, Lcom/aio/downloader/utils/ProgressWheel;->rimWidth:I

    .line 602
    iget-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    if-nez v0, :cond_0

    .line 603
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 605
    :cond_0
    return-void
.end method

.method public setSpinSpeed(F)V
    .locals 1
    .param p1, "spinSpeed"    # F

    .prologue
    .line 586
    const/high16 v0, 0x43b40000    # 360.0f

    mul-float/2addr v0, p1

    iput v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->spinSpeed:F

    .line 587
    return-void
.end method

.method public spin()V
    .locals 2

    .prologue
    .line 361
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->lastTimeAnimated:J

    .line 362
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    .line 363
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 364
    return-void
.end method

.method public stopSpinning()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 351
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/utils/ProgressWheel;->isSpinning:Z

    .line 352
    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->mProgress:F

    .line 353
    iput v1, p0, Lcom/aio/downloader/utils/ProgressWheel;->mTargetProgress:F

    .line 354
    invoke-virtual {p0}, Lcom/aio/downloader/utils/ProgressWheel;->invalidate()V

    .line 355
    return-void
.end method
