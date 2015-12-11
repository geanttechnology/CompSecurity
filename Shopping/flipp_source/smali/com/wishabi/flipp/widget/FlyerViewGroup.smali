.class public Lcom/wishabi/flipp/widget/FlyerViewGroup;
.super Landroid/view/ViewGroup;
.source "SourceFile"


# instance fields
.field public final a:Lcom/wishabi/flipp/widget/dw;

.field public final b:Lcom/wishabi/flipp/widget/bo;

.field public final c:Lcom/wishabi/flipp/widget/bv;

.field public final d:Lcom/wishabi/flipp/widget/bn;

.field public e:I

.field public f:I

.field private final g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;"
        }
    .end annotation
.end field

.field private final h:Landroid/view/View;

.field private final i:Lcom/wishabi/flipp/widget/bp;

.field private j:Lcom/wishabi/flipp/widget/bt;

.field private k:F

.field private l:F

.field private m:F

.field private n:Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;

.field private final o:Landroid/view/ScaleGestureDetector;

.field private final p:Landroid/view/GestureDetector;

.field private final q:Landroid/widget/OverScroller;

.field private r:Z

.field private s:Landroid/graphics/RectF;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 146
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 147
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 150
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 151
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2

    .prologue
    const/high16 v1, 0x3f800000    # 1.0f

    .line 154
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 51
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->g:Ljava/util/List;

    .line 99
    iput v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    .line 100
    iput v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    .line 101
    iput v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->m:F

    .line 157
    const/4 v0, 0x1

    invoke-static {p0, v0}, Landroid/support/v4/view/ap;->c(Landroid/view/View;I)V

    .line 160
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setWillNotDraw(Z)V

    .line 162
    new-instance v0, Landroid/view/View;

    invoke-direct {v0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->h:Landroid/view/View;

    .line 163
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->h:Landroid/view/View;

    const v1, 0x7f020072

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    .line 164
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->h:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->addView(Landroid/view/View;)V

    .line 166
    new-instance v0, Lcom/wishabi/flipp/widget/dw;

    invoke-direct {v0, p1}, Lcom/wishabi/flipp/widget/dw;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a:Lcom/wishabi/flipp/widget/dw;

    .line 167
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a:Lcom/wishabi/flipp/widget/dw;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->addView(Landroid/view/View;)V

    .line 169
    new-instance v0, Lcom/wishabi/flipp/widget/bv;

    invoke-direct {v0, p1}, Lcom/wishabi/flipp/widget/bv;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c:Lcom/wishabi/flipp/widget/bv;

    .line 170
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c:Lcom/wishabi/flipp/widget/bv;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->addView(Landroid/view/View;)V

    .line 172
    new-instance v0, Lcom/wishabi/flipp/widget/bo;

    invoke-direct {v0, p1}, Lcom/wishabi/flipp/widget/bo;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b:Lcom/wishabi/flipp/widget/bo;

    .line 173
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b:Lcom/wishabi/flipp/widget/bo;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->addView(Landroid/view/View;)V

    .line 175
    new-instance v0, Lcom/wishabi/flipp/widget/bn;

    invoke-direct {v0, p1}, Lcom/wishabi/flipp/widget/bn;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    .line 176
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->addView(Landroid/view/View;)V

    .line 178
    new-instance v0, Lcom/wishabi/flipp/widget/bp;

    invoke-direct {v0, p1}, Lcom/wishabi/flipp/widget/bp;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->i:Lcom/wishabi/flipp/widget/bp;

    .line 179
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->i:Lcom/wishabi/flipp/widget/bp;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->addView(Landroid/view/View;)V

    .line 181
    new-instance v0, Landroid/view/ScaleGestureDetector;

    new-instance v1, Lcom/wishabi/flipp/widget/bq;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/bq;-><init>(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V

    invoke-direct {v0, p1, v1}, Landroid/view/ScaleGestureDetector;-><init>(Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->o:Landroid/view/ScaleGestureDetector;

    .line 245
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->o:Landroid/view/ScaleGestureDetector;

    invoke-static {v0}, Landroid/support/v4/view/af;->a(Ljava/lang/Object;)V

    .line 248
    new-instance v0, Landroid/view/GestureDetector;

    new-instance v1, Lcom/wishabi/flipp/widget/br;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/widget/br;-><init>(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V

    invoke-direct {v0, p1, v1}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->p:Landroid/view/GestureDetector;

    .line 362
    new-instance v0, Landroid/widget/OverScroller;

    invoke-direct {v0, p1}, Landroid/widget/OverScroller;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    .line 363
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    const v1, 0x3cf5c28f    # 0.03f

    invoke-virtual {v0, v1}, Landroid/widget/OverScroller;->setFriction(F)V

    .line 364
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F
    .locals 1

    .prologue
    .line 34
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    return v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/FlyerViewGroup;II)V
    .locals 11

    .prologue
    const/4 v5, 0x0

    .line 34
    iget v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/OverScroller;->forceFinished(Z)V

    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v3

    float-to-int v1, v1

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v2

    int-to-float v2, v2

    mul-float/2addr v2, v3

    float-to-int v2, v2

    iget v4, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    int-to-float v4, v4

    mul-float/2addr v4, v3

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v6

    int-to-float v6, v6

    sub-float/2addr v4, v6

    float-to-int v6, v4

    iget v4, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f:I

    int-to-float v4, v4

    mul-float/2addr v3, v4

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v4

    int-to-float v4, v4

    sub-float/2addr v3, v4

    float-to-int v8, v3

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v3

    div-int/lit8 v9, v3, 0x4

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v3

    div-int/lit8 v10, v3, 0x2

    move v3, p1

    move v4, p2

    move v7, v5

    invoke-virtual/range {v0 .. v10}, Landroid/widget/OverScroller;->fling(IIIIIIIIII)V

    invoke-static {p0}, Landroid/support/v4/view/ap;->d(Landroid/view/View;)V

    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/dw;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a:Lcom/wishabi/flipp/widget/dw;

    return-object v0
.end method

.method private b()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 371
    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v1

    int-to-float v1, v1

    iget v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    int-to-float v2, v2

    iget v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    mul-float/2addr v2, v3

    sub-float/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    float-to-int v0, v0

    div-int/lit8 v0, v0, 0x2

    .line 372
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v1

    .line 373
    add-int v2, v1, v0

    .line 374
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v3

    .line 375
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v4

    add-int/2addr v4, v1

    .line 376
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v5

    add-int/2addr v5, v1

    sub-int v0, v5, v0

    .line 377
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v5

    add-int/2addr v5, v3

    .line 378
    iget-object v6, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->h:Landroid/view/View;

    iget v7, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    iget v8, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f:I

    invoke-virtual {v6, v9, v9, v7, v8}, Landroid/view/View;->layout(IIII)V

    .line 379
    iget-object v6, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a:Lcom/wishabi/flipp/widget/dw;

    invoke-virtual {v6, v2, v3, v0, v5}, Lcom/wishabi/flipp/widget/dw;->layout(IIII)V

    .line 380
    iget-object v6, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b:Lcom/wishabi/flipp/widget/bo;

    invoke-virtual {v6, v2, v3, v0, v5}, Lcom/wishabi/flipp/widget/bo;->layout(IIII)V

    .line 381
    iget-object v6, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c:Lcom/wishabi/flipp/widget/bv;

    invoke-virtual {v6, v2, v3, v0, v5}, Lcom/wishabi/flipp/widget/bv;->layout(IIII)V

    .line 382
    iget-object v6, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    invoke-virtual {v6, v2, v3, v0, v5}, Lcom/wishabi/flipp/widget/bn;->layout(IIII)V

    .line 383
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->i:Lcom/wishabi/flipp/widget/bp;

    invoke-virtual {v0, v1, v3, v4, v5}, Lcom/wishabi/flipp/widget/bp;->layout(IIII)V

    .line 384
    return-void
.end method

.method static synthetic c(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I
    .locals 1

    .prologue
    .line 34
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    return v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/widget/FlyerViewGroup;)I
    .locals 1

    .prologue
    .line 34
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f:I

    return v0
.end method

.method static synthetic e(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bt;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    return-object v0
.end method

.method static synthetic f(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bp;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->i:Lcom/wishabi/flipp/widget/bp;

    return-object v0
.end method

.method static synthetic g(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Landroid/widget/OverScroller;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    return-object v0
.end method

.method static synthetic h(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Lcom/wishabi/flipp/widget/bn;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    return-object v0
.end method

.method static synthetic i(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Ljava/util/List;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->g:Ljava/util/List;

    return-object v0
.end method

.method static synthetic j(Lcom/wishabi/flipp/widget/FlyerViewGroup;)F
    .locals 1

    .prologue
    .line 34
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    return v0
.end method

.method static synthetic k(Lcom/wishabi/flipp/widget/FlyerViewGroup;)Z
    .locals 1

    .prologue
    .line 34
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->r:Z

    return v0
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 498
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/wishabi/flipp/widget/bn;->f:Z

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bn;->invalidate()V

    .line 499
    return-void
.end method

.method public final a(JLandroid/graphics/RectF;)V
    .locals 7

    .prologue
    .line 470
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b:Lcom/wishabi/flipp/widget/bo;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bo;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    if-eqz v1, :cond_0

    const v2, 0x7f020006

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eqz v1, :cond_0

    iget v2, p3, Landroid/graphics/RectF;->left:F

    float-to-int v2, v2

    iget v3, p3, Landroid/graphics/RectF;->top:F

    float-to-int v3, v3

    iget v4, p3, Landroid/graphics/RectF;->right:F

    float-to-int v4, v4

    iget v5, p3, Landroid/graphics/RectF;->bottom:F

    float-to-int v5, v5

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    iget-object v2, v0, Lcom/wishabi/flipp/widget/bo;->c:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bo;->invalidate()V

    .line 471
    :cond_0
    return-void
.end method

.method public final a(Landroid/graphics/RectF;)V
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 513
    new-instance v0, Landroid/graphics/RectF;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v4

    int-to-float v4, v4

    iget v5, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    div-float/2addr v4, v5

    add-float/2addr v3, v4

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v4

    int-to-float v4, v4

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v5

    int-to-float v5, v5

    iget v6, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    div-float/2addr v5, v6

    add-float/2addr v4, v5

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 517
    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v1

    iget v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    mul-float/2addr v1, v2

    invoke-virtual {v0}, Landroid/graphics/RectF;->width()F

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    move-result v1

    .line 519
    new-instance v2, Landroid/graphics/RectF;

    invoke-direct {v2}, Landroid/graphics/RectF;-><init>()V

    .line 520
    const/4 v3, 0x0

    iput v3, v2, Landroid/graphics/RectF;->top:F

    .line 521
    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v3

    iput v3, v2, Landroid/graphics/RectF;->bottom:F

    .line 522
    iget v3, p1, Landroid/graphics/RectF;->left:F

    iput v3, v2, Landroid/graphics/RectF;->left:F

    .line 523
    iget v3, p1, Landroid/graphics/RectF;->right:F

    iput v3, v2, Landroid/graphics/RectF;->right:F

    .line 524
    iget v3, p1, Landroid/graphics/RectF;->right:F

    iget v4, v0, Landroid/graphics/RectF;->right:F

    cmpl-float v3, v3, v4

    if-lez v3, :cond_1

    .line 525
    iget v0, v2, Landroid/graphics/RectF;->left:F

    add-float/2addr v0, v1

    iput v0, v2, Landroid/graphics/RectF;->right:F

    .line 529
    :cond_0
    :goto_0
    invoke-virtual {p0, v2, v7, v7}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Landroid/graphics/RectF;ZZ)V

    .line 533
    return-void

    .line 527
    :cond_1
    iget v3, p1, Landroid/graphics/RectF;->left:F

    iget v0, v0, Landroid/graphics/RectF;->left:F

    cmpg-float v0, v3, v0

    if-gez v0, :cond_0

    .line 528
    iget v0, v2, Landroid/graphics/RectF;->right:F

    sub-float/2addr v0, v1

    iput v0, v2, Landroid/graphics/RectF;->left:F

    goto :goto_0
.end method

.method public final a(Landroid/graphics/RectF;ZZ)V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/high16 v6, 0x40000000    # 2.0f

    const/4 v5, 0x0

    .line 541
    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v0

    cmpl-float v0, v0, v5

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v0

    cmpl-float v0, v0, v5

    if-nez v0, :cond_1

    .line 644
    :cond_0
    :goto_0
    return-void

    .line 545
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v1

    div-float/2addr v0, v1

    .line 546
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v2

    div-float/2addr v1, v2

    .line 549
    invoke-static {v0, v1}, Ljava/lang/Math;->min(FF)F

    move-result v0

    .line 550
    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->m:F

    invoke-static {v0, v1}, Ljava/lang/Math;->min(FF)F

    move-result v0

    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    .line 553
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v1, v0

    .line 554
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v2

    int-to-float v2, v2

    div-float/2addr v2, v0

    .line 557
    if-eqz p3, :cond_2

    .line 558
    invoke-virtual {p1}, Landroid/graphics/RectF;->centerX()F

    move-result v3

    div-float v4, v1, v6

    sub-float/2addr v3, v4

    iput v3, p1, Landroid/graphics/RectF;->left:F

    .line 559
    invoke-virtual {p1}, Landroid/graphics/RectF;->centerY()F

    move-result v3

    div-float v4, v2, v6

    sub-float/2addr v3, v4

    iput v3, p1, Landroid/graphics/RectF;->top:F

    .line 560
    invoke-virtual {p1}, Landroid/graphics/RectF;->centerX()F

    move-result v3

    div-float v4, v1, v6

    add-float/2addr v3, v4

    iput v3, p1, Landroid/graphics/RectF;->right:F

    .line 561
    invoke-virtual {p1}, Landroid/graphics/RectF;->centerY()F

    move-result v3

    div-float v4, v2, v6

    add-float/2addr v3, v4

    iput v3, p1, Landroid/graphics/RectF;->bottom:F

    .line 582
    :cond_2
    iget v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    int-to-float v3, v3

    invoke-static {v3, v1}, Ljava/lang/Math;->max(FF)F

    move-result v1

    float-to-int v1, v1

    .line 584
    iget v3, p1, Landroid/graphics/RectF;->left:F

    cmpg-float v3, v3, v5

    if-gez v3, :cond_5

    .line 585
    iget v1, p1, Landroid/graphics/RectF;->left:F

    sub-float v1, v5, v1

    invoke-virtual {p1, v1, v5}, Landroid/graphics/RectF;->offset(FF)V

    .line 592
    :cond_3
    :goto_1
    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f:I

    int-to-float v1, v1

    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    move-result v1

    float-to-int v1, v1

    .line 594
    iget v2, p1, Landroid/graphics/RectF;->top:F

    cmpg-float v2, v2, v5

    if-gez v2, :cond_6

    .line 595
    iget v1, p1, Landroid/graphics/RectF;->top:F

    sub-float v1, v5, v1

    invoke-virtual {p1, v5, v1}, Landroid/graphics/RectF;->offset(FF)V

    .line 601
    :cond_4
    :goto_2
    iget-object v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    invoke-virtual {v1, v7}, Landroid/widget/OverScroller;->forceFinished(Z)V

    .line 603
    if-nez p2, :cond_7

    .line 606
    iget v1, p1, Landroid/graphics/RectF;->left:F

    float-to-int v1, v1

    iget v2, p1, Landroid/graphics/RectF;->top:F

    float-to-int v2, v2

    invoke-virtual {p0, v1, v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->scrollTo(II)V

    .line 607
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setZoomScale(F)V

    .line 609
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    if-eqz v0, :cond_0

    .line 610
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    invoke-interface {v0, p0}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V

    goto/16 :goto_0

    .line 587
    :cond_5
    iget v3, p1, Landroid/graphics/RectF;->right:F

    int-to-float v4, v1

    cmpl-float v3, v3, v4

    if-lez v3, :cond_3

    .line 588
    int-to-float v1, v1

    iget v3, p1, Landroid/graphics/RectF;->right:F

    sub-float/2addr v1, v3

    invoke-virtual {p1, v1, v5}, Landroid/graphics/RectF;->offset(FF)V

    goto :goto_1

    .line 597
    :cond_6
    iget v2, p1, Landroid/graphics/RectF;->bottom:F

    int-to-float v3, v1

    cmpl-float v2, v2, v3

    if-lez v2, :cond_4

    .line 598
    int-to-float v1, v1

    iget v2, p1, Landroid/graphics/RectF;->bottom:F

    sub-float/2addr v1, v2

    invoke-virtual {p1, v5, v1}, Landroid/graphics/RectF;->offset(FF)V

    goto :goto_2

    .line 614
    :cond_7
    new-instance v1, Lcom/wishabi/flipp/a/a;

    invoke-direct {v1}, Lcom/wishabi/flipp/a/a;-><init>()V

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getVisibleRect()Landroid/graphics/RectF;

    move-result-object v4

    aput-object v4, v2, v3

    aput-object p1, v2, v7

    invoke-static {v1, v2}, Landroid/animation/ValueAnimator;->ofObject(Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/ValueAnimator;

    move-result-object v1

    .line 616
    const-wide/16 v2, 0x190

    invoke-virtual {v1, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 617
    new-instance v2, Lcom/wishabi/flipp/widget/bs;

    invoke-direct {v2, p0, p1, v0}, Lcom/wishabi/flipp/widget/bs;-><init>(Lcom/wishabi/flipp/widget/FlyerViewGroup;Landroid/graphics/RectF;F)V

    invoke-virtual {v1, v2}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 642
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a:Lcom/wishabi/flipp/widget/dw;

    invoke-virtual {v0, v7}, Lcom/wishabi/flipp/widget/dw;->setZooming(Z)V

    .line 643
    invoke-virtual {v1}, Landroid/animation/ValueAnimator;->start()V

    goto/16 :goto_0
.end method

.method protected computeHorizontalScrollExtent()I
    .locals 2

    .prologue
    .line 653
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v0

    int-to-float v0, v0

    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method

.method protected computeHorizontalScrollOffset()I
    .locals 1

    .prologue
    .line 658
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v0

    return v0
.end method

.method protected computeHorizontalScrollRange()I
    .locals 1

    .prologue
    .line 648
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    return v0
.end method

.method public computeScroll()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 678
    invoke-super {p0}, Landroid/view/ViewGroup;->computeScroll()V

    .line 680
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    invoke-virtual {v0}, Landroid/widget/OverScroller;->computeScrollOffset()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 681
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    .line 682
    iget-object v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    invoke-virtual {v1}, Landroid/widget/OverScroller;->getCurrX()I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v1, v0

    float-to-int v1, v1

    .line 683
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    invoke-virtual {v2}, Landroid/widget/OverScroller;->getCurrY()I

    move-result v2

    int-to-float v2, v2

    div-float v0, v2, v0

    float-to-int v0, v0

    .line 685
    if-gez v1, :cond_0

    .line 686
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->i:Lcom/wishabi/flipp/widget/bp;

    iget-object v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    invoke-virtual {v3}, Landroid/widget/OverScroller;->getCurrVelocity()F

    move-result v3

    float-to-int v3, v3

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->a:Landroid/widget/EdgeEffect;

    invoke-virtual {v4}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v4

    if-eqz v4, :cond_0

    iget-boolean v4, v2, Lcom/wishabi/flipp/widget/bp;->e:Z

    if-nez v4, :cond_0

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->a:Landroid/widget/EdgeEffect;

    invoke-virtual {v4, v3}, Landroid/widget/EdgeEffect;->onAbsorb(I)V

    iput-boolean v6, v2, Lcom/wishabi/flipp/widget/bp;->e:Z

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/bp;->invalidate()V

    .line 687
    :cond_0
    int-to-float v2, v1

    iget v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    int-to-float v3, v3

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v4

    int-to-float v4, v4

    iget v5, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v4, v5

    sub-float/2addr v3, v4

    cmpl-float v2, v2, v3

    if-lez v2, :cond_1

    .line 688
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->i:Lcom/wishabi/flipp/widget/bp;

    iget-object v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    invoke-virtual {v3}, Landroid/widget/OverScroller;->getCurrVelocity()F

    move-result v3

    float-to-int v3, v3

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->b:Landroid/widget/EdgeEffect;

    invoke-virtual {v4}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v4

    if-eqz v4, :cond_1

    iget-boolean v4, v2, Lcom/wishabi/flipp/widget/bp;->f:Z

    if-nez v4, :cond_1

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->b:Landroid/widget/EdgeEffect;

    invoke-virtual {v4, v3}, Landroid/widget/EdgeEffect;->onAbsorb(I)V

    iput-boolean v6, v2, Lcom/wishabi/flipp/widget/bp;->f:Z

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/bp;->invalidate()V

    .line 689
    :cond_1
    if-gez v0, :cond_2

    iget v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    iget v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    cmpl-float v2, v2, v3

    if-lez v2, :cond_2

    .line 690
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->i:Lcom/wishabi/flipp/widget/bp;

    iget-object v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    invoke-virtual {v3}, Landroid/widget/OverScroller;->getCurrVelocity()F

    move-result v3

    float-to-int v3, v3

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->c:Landroid/widget/EdgeEffect;

    invoke-virtual {v4}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v4

    if-eqz v4, :cond_2

    iget-boolean v4, v2, Lcom/wishabi/flipp/widget/bp;->g:Z

    if-nez v4, :cond_2

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->c:Landroid/widget/EdgeEffect;

    invoke-virtual {v4, v3}, Landroid/widget/EdgeEffect;->onAbsorb(I)V

    iput-boolean v6, v2, Lcom/wishabi/flipp/widget/bp;->g:Z

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/bp;->invalidate()V

    .line 691
    :cond_2
    int-to-float v2, v0

    iget v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f:I

    int-to-float v3, v3

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v4

    int-to-float v4, v4

    iget v5, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v4, v5

    sub-float/2addr v3, v4

    cmpl-float v2, v2, v3

    if-lez v2, :cond_3

    iget v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    iget v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    cmpl-float v2, v2, v3

    if-lez v2, :cond_3

    .line 693
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->i:Lcom/wishabi/flipp/widget/bp;

    iget-object v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->q:Landroid/widget/OverScroller;

    invoke-virtual {v3}, Landroid/widget/OverScroller;->getCurrVelocity()F

    move-result v3

    float-to-int v3, v3

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->d:Landroid/widget/EdgeEffect;

    invoke-virtual {v4}, Landroid/widget/EdgeEffect;->isFinished()Z

    move-result v4

    if-eqz v4, :cond_3

    iget-boolean v4, v2, Lcom/wishabi/flipp/widget/bp;->h:Z

    if-nez v4, :cond_3

    iget-object v4, v2, Lcom/wishabi/flipp/widget/bp;->d:Landroid/widget/EdgeEffect;

    invoke-virtual {v4, v3}, Landroid/widget/EdgeEffect;->onAbsorb(I)V

    iput-boolean v6, v2, Lcom/wishabi/flipp/widget/bp;->h:Z

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/bp;->invalidate()V

    .line 695
    :cond_3
    int-to-float v1, v1

    iget v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    int-to-float v2, v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v3

    int-to-float v3, v3

    iget v4, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v3, v4

    sub-float/2addr v2, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->min(FF)F

    move-result v1

    invoke-static {v7, v1}, Ljava/lang/Math;->max(FF)F

    move-result v1

    float-to-int v1, v1

    int-to-float v0, v0

    iget v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f:I

    int-to-float v2, v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v3

    int-to-float v3, v3

    iget v4, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v3, v4

    sub-float/2addr v2, v3

    invoke-static {v0, v2}, Ljava/lang/Math;->min(FF)F

    move-result v0

    invoke-static {v7, v0}, Ljava/lang/Math;->max(FF)F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {p0, v1, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->scrollTo(II)V

    .line 701
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    if-eqz v0, :cond_4

    .line 702
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    invoke-interface {v0, p0}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V

    .line 704
    :cond_4
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->awakenScrollBars()Z

    move-result v0

    if-nez v0, :cond_5

    .line 705
    invoke-static {p0}, Landroid/support/v4/view/ap;->d(Landroid/view/View;)V

    .line 707
    :cond_5
    return-void
.end method

.method protected computeVerticalScrollExtent()I
    .locals 2

    .prologue
    .line 668
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v0

    int-to-float v0, v0

    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method

.method protected computeVerticalScrollOffset()I
    .locals 1

    .prologue
    .line 673
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v0

    return v0
.end method

.method protected computeVerticalScrollRange()I
    .locals 1

    .prologue
    .line 663
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f:I

    return v0
.end method

.method public getHighlightAnnotations()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;"
        }
    .end annotation

    .prologue
    .line 67
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c:Lcom/wishabi/flipp/widget/bv;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bv;->getHighlightAnnotations()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getMinZoomScale()F
    .locals 1

    .prologue
    .line 142
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    return v0
.end method

.method public getVisibleHighlightAnnotations()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;"
        }
    .end annotation

    .prologue
    .line 71
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 72
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c:Lcom/wishabi/flipp/widget/bv;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bv;->getHighlightAnnotations()Ljava/util/List;

    move-result-object v0

    .line 74
    if-nez v0, :cond_0

    move-object v0, v1

    .line 86
    :goto_0
    return-object v0

    .line 78
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getVisibleRect()Landroid/graphics/RectF;

    move-result-object v2

    .line 79
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bi;

    .line 80
    iget-object v4, v0, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v4, v4, Landroid/graphics/RectF;->right:F

    iget v5, v2, Landroid/graphics/RectF;->left:F

    cmpl-float v4, v4, v5

    if-ltz v4, :cond_1

    iget-object v4, v0, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v4, v4, Landroid/graphics/RectF;->left:F

    iget v5, v2, Landroid/graphics/RectF;->right:F

    cmpg-float v4, v4, v5

    if-gtz v4, :cond_1

    .line 82
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_2
    move-object v0, v1

    .line 86
    goto :goto_0
.end method

.method public getVisibleRect()Landroid/graphics/RectF;
    .locals 7

    .prologue
    .line 506
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Landroid/graphics/RectF;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v2

    int-to-float v2, v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v3

    int-to-float v3, v3

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v4

    int-to-float v4, v4

    iget v5, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v4, v5

    add-float/2addr v3, v4

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v4

    int-to-float v4, v4

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v5

    int-to-float v5, v5

    iget v6, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v5, v6

    add-float/2addr v4, v5

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/RectF;-><init>(FFFF)V

    goto :goto_0
.end method

.method public getZoomScale()F
    .locals 1

    .prologue
    .line 138
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    return v0
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 4

    .prologue
    .line 726
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 732
    invoke-static {p1}, Landroid/support/v4/view/a/a;->a(Landroid/view/accessibility/AccessibilityEvent;)Landroid/support/v4/view/a/ag;

    move-result-object v0

    .line 733
    const-class v1, Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Landroid/support/v4/view/a/ag;->a:Landroid/support/v4/view/a/aj;

    iget-object v3, v0, Landroid/support/v4/view/a/ag;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v1}, Landroid/support/v4/view/a/aj;->a(Ljava/lang/Object;Ljava/lang/CharSequence;)V

    .line 734
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/a/ag;->a(Z)V

    .line 735
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v1

    sget-object v2, Landroid/support/v4/view/a/ag;->a:Landroid/support/v4/view/a/aj;

    iget-object v3, v0, Landroid/support/v4/view/a/ag;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v1}, Landroid/support/v4/view/a/aj;->d(Ljava/lang/Object;I)V

    .line 736
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v1

    sget-object v2, Landroid/support/v4/view/a/ag;->a:Landroid/support/v4/view/a/aj;

    iget-object v3, v0, Landroid/support/v4/view/a/ag;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v1}, Landroid/support/v4/view/a/aj;->c(Ljava/lang/Object;I)V

    .line 737
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->computeHorizontalScrollRange()I

    move-result v1

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->computeHorizontalScrollExtent()I

    move-result v2

    sub-int/2addr v1, v2

    sget-object v2, Landroid/support/v4/view/a/ag;->a:Landroid/support/v4/view/a/aj;

    iget-object v3, v0, Landroid/support/v4/view/a/ag;->b:Ljava/lang/Object;

    invoke-interface {v2, v3, v1}, Landroid/support/v4/view/a/aj;->g(Ljava/lang/Object;I)V

    .line 739
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->computeVerticalScrollRange()I

    move-result v1

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->computeVerticalScrollExtent()I

    move-result v2

    sub-int/2addr v1, v2

    sget-object v2, Landroid/support/v4/view/a/ag;->a:Landroid/support/v4/view/a/aj;

    iget-object v0, v0, Landroid/support/v4/view/a/ag;->b:Ljava/lang/Object;

    invoke-interface {v2, v0, v1}, Landroid/support/v4/view/a/aj;->f(Ljava/lang/Object;I)V

    .line 741
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 2

    .prologue
    .line 712
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 714
    new-instance v0, Landroid/support/v4/view/a/e;

    invoke-direct {v0, p1}, Landroid/support/v4/view/a/e;-><init>(Ljava/lang/Object;)V

    .line 717
    const-class v1, Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/a/e;->a(Ljava/lang/CharSequence;)V

    .line 718
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/a/e;->a(Z)V

    .line 719
    const/16 v1, 0x2000

    invoke-virtual {v0, v1}, Landroid/support/v4/view/a/e;->a(I)V

    .line 720
    const/16 v1, 0x1000

    invoke-virtual {v0, v1}, Landroid/support/v4/view/a/e;->a(I)V

    .line 721
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x0

    const v3, 0x3d4ccccd    # 0.05f

    .line 388
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b()V

    .line 390
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->n:Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;

    if-eqz v0, :cond_2

    .line 391
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->n:Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;

    iget v0, v0, Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;->a:I

    .line 392
    iget-object v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->n:Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;

    iget v1, v1, Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;->b:I

    .line 393
    sub-int/2addr v1, v0

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    .line 394
    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setZoomScale(F)V

    .line 395
    const-wide/16 v2, 0x0

    int-to-double v0, v0

    const-wide/high16 v4, 0x3fe0000000000000L    # 0.5

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v6

    int-to-double v6, v6

    mul-double/2addr v4, v6

    iget v6, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    float-to-double v6, v6

    div-double/2addr v4, v6

    sub-double/2addr v0, v4

    iget v4, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    int-to-float v4, v4

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v5

    int-to-float v5, v5

    iget v6, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v5, v6

    sub-float/2addr v4, v5

    float-to-double v4, v4

    invoke-static {v0, v1, v4, v5}, Ljava/lang/Math;->min(DD)D

    move-result-wide v0

    invoke-static {v2, v3, v0, v1}, Ljava/lang/Math;->max(DD)D

    move-result-wide v0

    double-to-int v0, v0

    invoke-virtual {p0, v0, v8}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->scrollTo(II)V

    .line 400
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    if-eqz v0, :cond_0

    .line 401
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    invoke-interface {v0, p0}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V

    .line 403
    :cond_0
    iput-object v9, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->n:Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;

    .line 411
    :cond_1
    :goto_0
    return-void

    .line 404
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->s:Landroid/graphics/RectF;

    if-eqz v0, :cond_1

    .line 405
    new-instance v0, Landroid/graphics/RectF;

    iget-object v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->s:Landroid/graphics/RectF;

    invoke-direct {v0, v1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    .line 406
    invoke-virtual {v0}, Landroid/graphics/RectF;->width()F

    move-result v1

    neg-float v1, v1

    mul-float/2addr v1, v3

    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v2

    neg-float v2, v2

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/RectF;->inset(FF)V

    .line 408
    iput-object v9, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->s:Landroid/graphics/RectF;

    .line 409
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v8, v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Landroid/graphics/RectF;ZZ)V

    goto :goto_0
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 1

    .prologue
    .line 745
    check-cast p1, Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;

    .line 746
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/view/ViewGroup;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 747
    iput-object p1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->n:Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;

    .line 748
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->requestLayout()V

    .line 749
    return-void
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .locals 6

    .prologue
    .line 753
    invoke-super {p0}, Landroid/view/ViewGroup;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    .line 754
    new-instance v1, Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v3

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v4

    int-to-float v4, v4

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getZoomScale()F

    move-result v5

    div-float/2addr v4, v5

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    float-to-int v4, v4

    add-int/2addr v3, v4

    invoke-direct {v1, v0, v2, v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup$SavedState;-><init>(Landroid/os/Parcelable;II)V

    return-object v1
.end method

.method protected onScrollChanged(IIII)V
    .locals 3

    .prologue
    .line 113
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->onScrollChanged(IIII)V

    .line 114
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a:Lcom/wishabi/flipp/widget/dw;

    int-to-float v1, p1

    int-to-float v2, p2

    iput v1, v0, Lcom/wishabi/flipp/widget/dw;->a:F

    iput v2, v0, Lcom/wishabi/flipp/widget/dw;->b:F

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/dw;->invalidate()V

    .line 115
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b:Lcom/wishabi/flipp/widget/bo;

    iput v1, v0, Lcom/wishabi/flipp/widget/bo;->a:F

    iput v2, v0, Lcom/wishabi/flipp/widget/bo;->b:F

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bo;->invalidate()V

    .line 116
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c:Lcom/wishabi/flipp/widget/bv;

    iput v1, v0, Lcom/wishabi/flipp/widget/bv;->c:F

    iput v2, v0, Lcom/wishabi/flipp/widget/bv;->d:F

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bv;->invalidate()V

    .line 117
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    iput v1, v0, Lcom/wishabi/flipp/widget/bn;->a:F

    iput v2, v0, Lcom/wishabi/flipp/widget/bn;->b:F

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bn;->invalidate()V

    .line 118
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b()V

    .line 119
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 423
    const/high16 v0, 0x3f800000    # 1.0f

    .line 424
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 425
    if-eqz v1, :cond_0

    .line 426
    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    .line 428
    :cond_0
    int-to-float v1, p2

    iget v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    iput v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    .line 429
    iput v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->m:F

    .line 430
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setZoomScale(F)V

    .line 431
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollX()I

    move-result v0

    int-to-float v0, v0

    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    int-to-float v1, v1

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getWidth()I

    move-result v2

    int-to-float v2, v2

    iget v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v2, v3

    sub-float/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->min(FF)F

    move-result v0

    invoke-static {v5, v0}, Ljava/lang/Math;->max(FF)F

    move-result v0

    float-to-int v0, v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getScrollY()I

    move-result v1

    int-to-float v1, v1

    iget v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f:I

    int-to-float v2, v2

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getHeight()I

    move-result v3

    int-to-float v3, v3

    iget v4, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    div-float/2addr v3, v4

    sub-float/2addr v2, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->min(FF)F

    move-result v1

    invoke-static {v5, v1}, Ljava/lang/Math;->max(FF)F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->scrollTo(II)V

    .line 437
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    if-eqz v0, :cond_1

    .line 438
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    invoke-interface {v0, p0}, Lcom/wishabi/flipp/widget/bt;->a(Lcom/wishabi/flipp/widget/FlyerViewGroup;)V

    .line 439
    :cond_1
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 443
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->o:Landroid/view/ScaleGestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 444
    iget-object v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->p:Landroid/view/GestureDetector;

    invoke-virtual {v3, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v3

    if-nez v3, :cond_0

    if-eqz v0, :cond_4

    :cond_0
    move v0, v2

    .line 446
    :goto_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    if-ne v3, v2, :cond_1

    iget-boolean v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->r:Z

    if-eqz v3, :cond_1

    .line 447
    iget-object v3, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    invoke-interface {v3}, Lcom/wishabi/flipp/widget/bt;->a()V

    .line 449
    :cond_1
    if-nez v0, :cond_2

    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_2
    move v1, v2

    :cond_3
    return v1

    :cond_4
    move v0, v1

    .line 444
    goto :goto_0
.end method

.method public setFlyerViewListener(Lcom/wishabi/flipp/widget/bt;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->j:Lcom/wishabi/flipp/widget/bt;

    .line 49
    return-void
.end method

.method public setHighlightAnnotations(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c:Lcom/wishabi/flipp/widget/bv;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/bv;->setHighlightAnnotations(Ljava/util/List;)V

    .line 64
    return-void
.end method

.method public setInitialRect(Landroid/graphics/RectF;)V
    .locals 1

    .prologue
    .line 367
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, p1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->s:Landroid/graphics/RectF;

    .line 368
    return-void
.end method

.method public setTapAnnotations(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 54
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->g:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 55
    if-nez p1, :cond_1

    .line 60
    :cond_0
    return-void

    .line 58
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bi;

    .line 59
    iget-object v2, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->g:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public setZoomScale(F)V
    .locals 2

    .prologue
    .line 129
    iget v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->l:F

    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->m:F

    invoke-static {p1, v1}, Ljava/lang/Math;->min(FF)F

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    .line 130
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a:Lcom/wishabi/flipp/widget/dw;

    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/dw;->setZoomScale(F)V

    .line 131
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b:Lcom/wishabi/flipp/widget/bo;

    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/bo;->setZoomScale(F)V

    .line 132
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c:Lcom/wishabi/flipp/widget/bv;

    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/bv;->setZoomScale(F)V

    .line 133
    iget-object v0, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    iget v1, p0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->k:F

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/bn;->setZoomScale(F)V

    .line 134
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b()V

    .line 135
    return-void
.end method
