.class public Lcom/mixerbox/mixerbox3b/classes/DrawView;
.super Landroid/view/View;
.source "SourceFile"


# instance fields
.field h:I

.field r:I

.field str:Ljava/lang/String;

.field public t:I

.field w:I

.field x:I

.field y:I


# direct methods
.method public constructor <init>(Landroid/content/Context;IIIIIILjava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 27
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 18
    iput v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->w:I

    .line 19
    iput v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->h:I

    .line 20
    iput v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->x:I

    .line 21
    iput v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    .line 22
    iput v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    .line 23
    iput v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    .line 28
    iput p2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->w:I

    .line 29
    iput p3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->h:I

    .line 30
    iput p4, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->x:I

    .line 31
    iput p5, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    .line 32
    iput p6, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    .line 33
    iput p7, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    .line 34
    iput-object p8, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->str:Ljava/lang/String;

    .line 35
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 7

    .prologue
    .line 39
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 41
    new-instance v5, Landroid/graphics/Paint;

    invoke-direct {v5}, Landroid/graphics/Paint;-><init>()V

    .line 42
    const-string v0, "#000000"

    invoke-static {v0}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {v5, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 43
    const/16 v0, 0xc8

    invoke-virtual {v5, v0}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 44
    const/4 v0, 0x1

    invoke-virtual {v5, v0}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 45
    sget-object v0, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v5, v0}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 47
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    .line 48
    sget-object v1, Landroid/graphics/Path$FillType;->INVERSE_WINDING:Landroid/graphics/Path$FillType;

    invoke-virtual {v0, v1}, Landroid/graphics/Path;->setFillType(Landroid/graphics/Path$FillType;)V

    .line 49
    iget v1, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->x:I

    int-to-float v1, v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    int-to-float v2, v2

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    int-to-float v3, v3

    sget-object v4, Landroid/graphics/Path$Direction;->CCW:Landroid/graphics/Path$Direction;

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Path;->addCircle(FFFLandroid/graphics/Path$Direction;)V

    .line 51
    invoke-virtual {p1, v0, v5}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 53
    const/4 v1, 0x0

    const/4 v2, 0x0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->w:I

    int-to-float v3, v0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    sub-int/2addr v0, v4

    add-int/lit8 v0, v0, -0x2

    int-to-float v4, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 54
    const/4 v1, 0x0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v0, v2

    add-int/lit8 v0, v0, 0x2

    int-to-float v2, v0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->w:I

    int-to-float v3, v0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->h:I

    int-to-float v4, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 55
    const/4 v1, 0x0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    sub-int/2addr v0, v2

    add-int/lit8 v0, v0, -0x2

    int-to-float v2, v0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->x:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    sub-int/2addr v0, v3

    add-int/lit8 v0, v0, -0x2

    int-to-float v3, v0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v0, v4

    add-int/lit8 v0, v0, 0x2

    int-to-float v4, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 56
    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->x:I

    iget v1, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x2

    int-to-float v1, v0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    sub-int/2addr v0, v2

    add-int/lit8 v0, v0, -0x2

    int-to-float v2, v0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->w:I

    int-to-float v3, v0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v0, v4

    add-int/lit8 v0, v0, 0x2

    int-to-float v4, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 58
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .line 59
    sget-object v0, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v0}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 60
    const-string v0, "#37b9eb"

    invoke-static {v0}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {v2, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 61
    const/4 v0, 0x1

    invoke-virtual {v2, v0}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 63
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v1, v0, Landroid/util/DisplayMetrics;->density:F

    .line 64
    const/4 v0, 0x5

    .line 65
    float-to-double v3, v1

    const-wide/high16 v5, 0x3ff8000000000000L    # 1.5

    cmpg-double v1, v3, v5

    if-gtz v1, :cond_0

    .line 66
    const/4 v0, 0x3

    .line 68
    :cond_0
    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    .line 69
    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->x:I

    int-to-float v3, v3

    iget v4, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    int-to-float v4, v4

    iget v5, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v5, v1

    int-to-float v5, v5

    invoke-virtual {p1, v3, v4, v5, v2}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 70
    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->x:I

    int-to-float v3, v3

    iget v4, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    int-to-float v4, v4

    iget v5, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    mul-int/lit8 v6, v0, 0x4

    add-int/2addr v5, v6

    add-int/2addr v5, v1

    int-to-float v5, v5

    invoke-virtual {p1, v3, v4, v5, v2}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 68
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 73
    :cond_1
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 75
    new-instance v1, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 76
    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->w:I

    int-to-float v2, v2

    const/high16 v3, 0x42480000    # 50.0f

    sub-float/2addr v2, v3

    float-to-int v2, v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setWidth(I)V

    .line 77
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v3, -0x2

    const/4 v4, -0x1

    invoke-direct {v2, v3, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 78
    const/16 v3, 0x19

    const/4 v4, 0x0

    const/16 v5, 0x19

    const/4 v6, 0x0

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 79
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 80
    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v3, 0x4

    if-eq v2, v3, :cond_2

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v3, 0x9

    if-eq v2, v3, :cond_2

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v3, 0xa

    if-ne v2, v3, :cond_3

    .line 81
    :cond_2
    const/4 v2, 0x5

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setGravity(I)V

    .line 82
    :cond_3
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 83
    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 84
    const/high16 v2, 0x41880000    # 17.0f

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextSize(F)V

    .line 85
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->str:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 86
    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 87
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v2

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/widget/LinearLayout;->measure(II)V

    .line 88
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v4

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v5

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/widget/LinearLayout;->layout(IIII)V

    .line 90
    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_5

    .line 91
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    .line 120
    :cond_4
    :goto_1
    invoke-virtual {v0, p1}, Landroid/widget/LinearLayout;->draw(Landroid/graphics/Canvas;)V

    .line 121
    return-void

    .line 92
    :cond_5
    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_6

    .line 93
    const/4 v2, 0x0

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    sub-int/2addr v3, v4

    add-int/lit8 v3, v3, -0x32

    invoke-virtual {v1}, Landroid/widget/TextView;->getHeight()I

    move-result v1

    sub-int v1, v3, v1

    int-to-float v1, v1

    invoke-virtual {p1, v2, v1}, Landroid/graphics/Canvas;->translate(FF)V

    goto :goto_1

    .line 94
    :cond_6
    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v3, 0x3

    if-ne v2, v3, :cond_7

    .line 95
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto :goto_1

    .line 96
    :cond_7
    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v3, 0x4

    if-ne v2, v3, :cond_8

    .line 97
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto :goto_1

    .line 98
    :cond_8
    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v3, 0x5

    if-ne v2, v3, :cond_9

    .line 99
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto :goto_1

    .line 100
    :cond_9
    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v3, 0x6

    if-ne v2, v3, :cond_a

    .line 101
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto :goto_1

    .line 102
    :cond_a
    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/4 v3, 0x7

    if-ne v2, v3, :cond_b

    .line 103
    const/4 v2, 0x0

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    sub-int/2addr v3, v4

    add-int/lit8 v3, v3, -0x32

    invoke-virtual {v1}, Landroid/widget/TextView;->getHeight()I

    move-result v1

    sub-int v1, v3, v1

    int-to-float v1, v1

    invoke-virtual {p1, v2, v1}, Landroid/graphics/Canvas;->translate(FF)V

    goto :goto_1

    .line 104
    :cond_b
    iget v1, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v2, 0x8

    if-ne v1, v2, :cond_c

    .line 105
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto/16 :goto_1

    .line 106
    :cond_c
    iget v1, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v2, 0x9

    if-ne v1, v2, :cond_d

    .line 107
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto/16 :goto_1

    .line 108
    :cond_d
    iget v1, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v2, 0xa

    if-ne v1, v2, :cond_e

    .line 109
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto/16 :goto_1

    .line 110
    :cond_e
    iget v1, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v2, 0xb

    if-ne v1, v2, :cond_f

    .line 111
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto/16 :goto_1

    .line 112
    :cond_f
    iget v1, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v2, 0xc

    if-ne v1, v2, :cond_10

    .line 113
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto/16 :goto_1

    .line 114
    :cond_10
    iget v1, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v2, 0xd

    if-ne v1, v2, :cond_11

    .line 115
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto/16 :goto_1

    .line 116
    :cond_11
    iget v1, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->t:I

    const/16 v2, 0xe

    if-ne v1, v2, :cond_4

    .line 117
    const/4 v1, 0x0

    iget v2, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->y:I

    iget v3, p0, Lcom/mixerbox/mixerbox3b/classes/DrawView;->r:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x28

    int-to-float v2, v2

    invoke-virtual {p1, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    goto/16 :goto_1
.end method
