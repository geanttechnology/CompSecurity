.class final Lcom/wishabi/flipp/widget/ee;
.super Landroid/widget/LinearLayout;
.source "SourceFile"


# instance fields
.field a:I

.field b:F

.field c:Lcom/wishabi/flipp/widget/ed;

.field final d:Lcom/wishabi/flipp/widget/ef;

.field private final e:I

.field private final f:Landroid/graphics/Paint;

.field private final g:I

.field private final h:Landroid/graphics/Paint;

.field private final i:I

.field private final j:Landroid/graphics/Paint;

.field private final k:F


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 58
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ee;-><init>(Landroid/content/Context;B)V

    .line 59
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 62
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 63
    invoke-virtual {p0, v5}, Lcom/wishabi/flipp/widget/ee;->setWillNotDraw(Z)V

    .line 65
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ee;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    .line 67
    new-instance v1, Landroid/util/TypedValue;

    invoke-direct {v1}, Landroid/util/TypedValue;-><init>()V

    .line 68
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v2

    const v3, 0x1010030

    invoke-virtual {v2, v3, v1, v6}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 69
    iget v1, v1, Landroid/util/TypedValue;->data:I

    .line 71
    const/16 v2, 0x26

    invoke-static {v1, v2}, Lcom/wishabi/flipp/widget/ee;->a(IB)I

    move-result v2

    iput v2, p0, Lcom/wishabi/flipp/widget/ee;->i:I

    .line 74
    new-instance v2, Lcom/wishabi/flipp/widget/ef;

    invoke-direct {v2, v5}, Lcom/wishabi/flipp/widget/ef;-><init>(B)V

    iput-object v2, p0, Lcom/wishabi/flipp/widget/ee;->d:Lcom/wishabi/flipp/widget/ef;

    .line 75
    iget-object v2, p0, Lcom/wishabi/flipp/widget/ee;->d:Lcom/wishabi/flipp/widget/ef;

    new-array v3, v6, [I

    const v4, -0xcc4a1b

    aput v4, v3, v5

    iput-object v3, v2, Lcom/wishabi/flipp/widget/ef;->a:[I

    .line 76
    iget-object v2, p0, Lcom/wishabi/flipp/widget/ee;->d:Lcom/wishabi/flipp/widget/ef;

    new-array v3, v6, [I

    const/16 v4, 0x20

    invoke-static {v1, v4}, Lcom/wishabi/flipp/widget/ee;->a(IB)I

    move-result v1

    aput v1, v3, v5

    iput-object v3, v2, Lcom/wishabi/flipp/widget/ef;->b:[I

    .line 79
    const/high16 v1, 0x40000000    # 2.0f

    mul-float/2addr v1, v0

    float-to-int v1, v1

    iput v1, p0, Lcom/wishabi/flipp/widget/ee;->e:I

    .line 80
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/wishabi/flipp/widget/ee;->f:Landroid/graphics/Paint;

    .line 81
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ee;->f:Landroid/graphics/Paint;

    iget v2, p0, Lcom/wishabi/flipp/widget/ee;->i:I

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 83
    const/high16 v1, 0x41000000    # 8.0f

    mul-float/2addr v1, v0

    float-to-int v1, v1

    iput v1, p0, Lcom/wishabi/flipp/widget/ee;->g:I

    .line 84
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/wishabi/flipp/widget/ee;->h:Landroid/graphics/Paint;

    .line 86
    const/high16 v1, 0x3f000000    # 0.5f

    iput v1, p0, Lcom/wishabi/flipp/widget/ee;->k:F

    .line 87
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/wishabi/flipp/widget/ee;->j:Landroid/graphics/Paint;

    .line 88
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ee;->j:Landroid/graphics/Paint;

    const/high16 v2, 0x3f800000    # 1.0f

    mul-float/2addr v0, v2

    float-to-int v0, v0

    int-to-float v0, v0

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 89
    return-void
.end method

.method private static a(IB)I
    .locals 3

    .prologue
    .line 173
    invoke-static {p0}, Landroid/graphics/Color;->red(I)I

    move-result v0

    invoke-static {p0}, Landroid/graphics/Color;->green(I)I

    move-result v1

    invoke-static {p0}, Landroid/graphics/Color;->blue(I)I

    move-result v2

    invoke-static {p1, v0, v1, v2}, Landroid/graphics/Color;->argb(IIII)I

    move-result v0

    return v0
.end method


# virtual methods
.method protected final onDraw(Landroid/graphics/Canvas;)V
    .locals 14

    .prologue
    .line 122
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ee;->getHeight()I

    move-result v6

    .line 123
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ee;->getChildCount()I

    move-result v8

    .line 124
    const/4 v0, 0x0

    iget v1, p0, Lcom/wishabi/flipp/widget/ee;->k:F

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-static {v0, v1}, Ljava/lang/Math;->min(FF)F

    move-result v0

    int-to-float v1, v6

    mul-float/2addr v0, v1

    float-to-int v9, v0

    .line 125
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ee;->c:Lcom/wishabi/flipp/widget/ed;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ee;->c:Lcom/wishabi/flipp/widget/ed;

    move-object v7, v0

    .line 130
    :goto_0
    if-lez v8, :cond_1

    .line 131
    iget v0, p0, Lcom/wishabi/flipp/widget/ee;->a:I

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ee;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 132
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v2

    .line 133
    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v1

    .line 134
    iget v0, p0, Lcom/wishabi/flipp/widget/ee;->a:I

    invoke-interface {v7, v0}, Lcom/wishabi/flipp/widget/ed;->a(I)I

    move-result v0

    .line 136
    iget v3, p0, Lcom/wishabi/flipp/widget/ee;->b:F

    const/4 v4, 0x0

    cmpl-float v3, v3, v4

    if-lez v3, :cond_4

    iget v3, p0, Lcom/wishabi/flipp/widget/ee;->a:I

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ee;->getChildCount()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-ge v3, v4, :cond_4

    .line 137
    iget v3, p0, Lcom/wishabi/flipp/widget/ee;->a:I

    add-int/lit8 v3, v3, 0x1

    invoke-interface {v7, v3}, Lcom/wishabi/flipp/widget/ed;->a(I)I

    move-result v3

    .line 138
    if-eq v0, v3, :cond_0

    .line 139
    iget v4, p0, Lcom/wishabi/flipp/widget/ee;->b:F

    const/high16 v5, 0x3f800000    # 1.0f

    sub-float/2addr v5, v4

    invoke-static {v3}, Landroid/graphics/Color;->red(I)I

    move-result v10

    int-to-float v10, v10

    mul-float/2addr v10, v4

    invoke-static {v0}, Landroid/graphics/Color;->red(I)I

    move-result v11

    int-to-float v11, v11

    mul-float/2addr v11, v5

    add-float/2addr v10, v11

    invoke-static {v3}, Landroid/graphics/Color;->green(I)I

    move-result v11

    int-to-float v11, v11

    mul-float/2addr v11, v4

    invoke-static {v0}, Landroid/graphics/Color;->green(I)I

    move-result v12

    int-to-float v12, v12

    mul-float/2addr v12, v5

    add-float/2addr v11, v12

    invoke-static {v3}, Landroid/graphics/Color;->blue(I)I

    move-result v3

    int-to-float v3, v3

    mul-float/2addr v3, v4

    invoke-static {v0}, Landroid/graphics/Color;->blue(I)I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v5

    add-float/2addr v0, v3

    float-to-int v3, v10

    float-to-int v4, v11

    float-to-int v0, v0

    invoke-static {v3, v4, v0}, Landroid/graphics/Color;->rgb(III)I

    move-result v0

    .line 143
    :cond_0
    iget v3, p0, Lcom/wishabi/flipp/widget/ee;->a:I

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {p0, v3}, Lcom/wishabi/flipp/widget/ee;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 144
    iget v4, p0, Lcom/wishabi/flipp/widget/ee;->b:F

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v4, v5

    const/high16 v5, 0x3f800000    # 1.0f

    iget v10, p0, Lcom/wishabi/flipp/widget/ee;->b:F

    sub-float/2addr v5, v10

    int-to-float v2, v2

    mul-float/2addr v2, v5

    add-float/2addr v2, v4

    float-to-int v2, v2

    .line 146
    iget v4, p0, Lcom/wishabi/flipp/widget/ee;->b:F

    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v3

    int-to-float v3, v3

    mul-float/2addr v3, v4

    const/high16 v4, 0x3f800000    # 1.0f

    iget v5, p0, Lcom/wishabi/flipp/widget/ee;->b:F

    sub-float/2addr v4, v5

    int-to-float v1, v1

    mul-float/2addr v1, v4

    add-float/2addr v1, v3

    float-to-int v1, v1

    move v13, v1

    move v1, v2

    move v2, v0

    move v0, v13

    .line 150
    :goto_1
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ee;->h:Landroid/graphics/Paint;

    invoke-virtual {v3, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 152
    int-to-float v1, v1

    iget v2, p0, Lcom/wishabi/flipp/widget/ee;->g:I

    sub-int v2, v6, v2

    int-to-float v2, v2

    int-to-float v3, v0

    int-to-float v4, v6

    iget-object v5, p0, Lcom/wishabi/flipp/widget/ee;->h:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 157
    :cond_1
    const/4 v1, 0x0

    iget v0, p0, Lcom/wishabi/flipp/widget/ee;->e:I

    sub-int v0, v6, v0

    int-to-float v2, v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ee;->getWidth()I

    move-result v0

    int-to-float v3, v0

    int-to-float v4, v6

    iget-object v5, p0, Lcom/wishabi/flipp/widget/ee;->f:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 160
    sub-int v0, v6, v9

    div-int/lit8 v10, v0, 0x2

    .line 161
    const/4 v0, 0x0

    move v6, v0

    :goto_2
    add-int/lit8 v0, v8, -0x1

    if-ge v6, v0, :cond_3

    .line 162
    invoke-virtual {p0, v6}, Lcom/wishabi/flipp/widget/ee;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 163
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ee;->j:Landroid/graphics/Paint;

    invoke-interface {v7, v6}, Lcom/wishabi/flipp/widget/ed;->b(I)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 164
    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v1

    int-to-float v1, v1

    int-to-float v2, v10

    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v0

    int-to-float v3, v0

    add-int v0, v10, v9

    int-to-float v4, v0

    iget-object v5, p0, Lcom/wishabi/flipp/widget/ee;->j:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 161
    add-int/lit8 v0, v6, 0x1

    move v6, v0

    goto :goto_2

    .line 125
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ee;->d:Lcom/wishabi/flipp/widget/ef;

    move-object v7, v0

    goto/16 :goto_0

    .line 167
    :cond_3
    return-void

    :cond_4
    move v13, v1

    move v1, v2

    move v2, v0

    move v0, v13

    goto :goto_1
.end method
