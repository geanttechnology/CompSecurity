.class public final Lcom/wishabi/flipp/widget/dw;
.super Landroid/view/View;
.source "SourceFile"


# instance fields
.field a:F

.field b:F

.field public c:Lcom/a/b/ad;

.field public final d:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/wishabi/flipp/widget/dy;",
            "Lcom/wishabi/flipp/widget/dx;",
            ">;"
        }
    .end annotation
.end field

.field public final e:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/wishabi/flipp/widget/dy;",
            "Lcom/wishabi/flipp/widget/dx;",
            ">;"
        }
    .end annotation
.end field

.field public final f:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Lcom/wishabi/flipp/widget/dx;",
            ">;"
        }
    .end annotation
.end field

.field private g:[F

.field private h:Ljava/lang/String;

.field private i:Z

.field private j:F

.field private k:F

.field private l:F

.field private final m:Landroid/graphics/RectF;

.field private final n:Lcom/wishabi/flipp/widget/dy;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 113
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 30
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dw;->m:Landroid/graphics/RectF;

    .line 32
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dw;->d:Ljava/util/Map;

    .line 33
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dw;->e:Ljava/util/Map;

    .line 34
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dw;->f:Ljava/util/Stack;

    .line 35
    new-instance v0, Lcom/wishabi/flipp/widget/dy;

    invoke-direct {v0, v1, v1, v1}, Lcom/wishabi/flipp/widget/dy;-><init>(III)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dw;->n:Lcom/wishabi/flipp/widget/dy;

    .line 114
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/dw;->isInEditMode()Z

    move-result v0

    if-nez v0, :cond_0

    .line 115
    invoke-static {p1}, Lcom/a/b/ad;->a(Landroid/content/Context;)Lcom/a/b/ad;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dw;->c:Lcom/a/b/ad;

    .line 116
    :cond_0
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/dw;)Ljava/util/Map;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dw;->d:Ljava/util/Map;

    return-object v0
.end method

.method private a(Landroid/graphics/Canvas;FFFFI)V
    .locals 24

    .prologue
    .line 193
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/dw;->g:[F

    aget v2, v2, p6

    .line 194
    const/high16 v3, 0x43800000    # 256.0f

    mul-float v19, v3, v2

    .line 195
    move-object/from16 v0, p0

    iget v2, v0, Lcom/wishabi/flipp/widget/dw;->l:F

    div-float v2, v2, v19

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    move/from16 v0, v19

    float-to-double v4, v0

    mul-double/2addr v2, v4

    move-object/from16 v0, p0

    iget v4, v0, Lcom/wishabi/flipp/widget/dw;->l:F

    float-to-double v4, v4

    sub-double/2addr v2, v4

    double-to-float v0, v2

    move/from16 v20, v0

    .line 197
    move-object/from16 v0, p0

    iget v2, v0, Lcom/wishabi/flipp/widget/dw;->l:F

    div-float v2, v2, v19

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v2, v2

    add-int/lit8 v21, v2, -0x1

    .line 198
    move-object/from16 v0, p0

    iget v2, v0, Lcom/wishabi/flipp/widget/dw;->k:F

    div-float v2, v2, v19

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v2, v2

    add-int/lit8 v2, v2, -0x1

    .line 200
    const-wide/16 v4, 0x0

    div-float v3, p3, v19

    float-to-double v6, v3

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(DD)D

    move-result-wide v4

    double-to-int v0, v4

    move/from16 v18, v0

    .line 201
    move/from16 v0, v21

    int-to-double v4, v0

    add-float v3, v20, p5

    div-float v3, v3, v19

    float-to-double v6, v3

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->min(DD)D

    move-result-wide v4

    double-to-int v0, v4

    move/from16 v22, v0

    .line 203
    const-wide/16 v4, 0x0

    div-float v3, p2, v19

    float-to-double v6, v3

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(DD)D

    move-result-wide v4

    double-to-int v5, v4

    .line 204
    int-to-double v2, v2

    div-float v4, p4, v19

    float-to-double v6, v4

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    invoke-static {v2, v3, v6, v7}, Ljava/lang/Math;->min(DD)D

    move-result-wide v2

    double-to-int v0, v2

    move/from16 v23, v0

    .line 206
    int-to-float v2, v5

    mul-float v7, v19, v2

    .line 207
    add-float v9, v7, v19

    .line 208
    :goto_0
    move/from16 v0, v23

    if-gt v5, v0, :cond_b

    .line 209
    move/from16 v0, v18

    int-to-float v2, v0

    mul-float v2, v2, v19

    sub-float v8, v2, v20

    .line 210
    add-float v10, v8, v19

    move/from16 v17, v18

    .line 211
    :goto_1
    move/from16 v0, v17

    move/from16 v1, v22

    if-gt v0, v1, :cond_a

    .line 212
    sub-int v4, v21, v17

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/dw;->n:Lcom/wishabi/flipp/widget/dy;

    move/from16 v0, p6

    invoke-virtual {v2, v4, v5, v0}, Lcom/wishabi/flipp/widget/dy;->a(III)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/dw;->d:Ljava/util/Map;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/widget/dw;->n:Lcom/wishabi/flipp/widget/dy;

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/widget/dx;

    if-eqz v2, :cond_1

    iget-object v2, v2, Lcom/wishabi/flipp/widget/dx;->c:Landroid/graphics/Bitmap;

    .line 214
    :goto_2
    if-eqz v2, :cond_0

    .line 215
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/widget/dw;->m:Landroid/graphics/RectF;

    invoke-virtual {v3, v7, v8, v9, v10}, Landroid/graphics/RectF;->set(FFFF)V

    .line 216
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/dw;->m:Landroid/graphics/RectF;

    const/4 v6, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    .line 219
    :cond_0
    add-float v8, v8, v19

    .line 220
    add-float v10, v10, v19

    .line 211
    add-int/lit8 v2, v17, 0x1

    move/from16 v17, v2

    goto :goto_1

    .line 212
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/dw;->e:Ljava/util/Map;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/widget/dw;->n:Lcom/wishabi/flipp/widget/dy;

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_7

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/dw;->f:Ljava/util/Stack;

    invoke-virtual {v2}, Ljava/util/Stack;->empty()Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v13, 0x0

    :goto_3
    if-nez v13, :cond_3

    new-instance v2, Lcom/wishabi/flipp/widget/dx;

    move-object/from16 v3, p0

    move/from16 v6, p6

    invoke-direct/range {v2 .. v10}, Lcom/wishabi/flipp/widget/dx;-><init>(Lcom/wishabi/flipp/widget/dw;IIIFFFF)V

    move-object v13, v2

    :goto_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/dw;->e:Ljava/util/Map;

    iget-object v3, v13, Lcom/wishabi/flipp/widget/dx;->b:Lcom/wishabi/flipp/widget/dy;

    invoke-interface {v2, v3, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/widget/dw;->h:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move/from16 v0, p6

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".jpg"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/widget/dw;->c:Lcom/a/b/ad;

    invoke-virtual {v3, v2}, Lcom/a/b/ad;->a(Ljava/lang/String;)Lcom/a/b/aq;

    move-result-object v2

    iget-object v3, v13, Lcom/wishabi/flipp/widget/dx;->c:Landroid/graphics/Bitmap;

    iget-object v4, v13, Lcom/wishabi/flipp/widget/dx;->d:[B

    iget-object v6, v13, Lcom/wishabi/flipp/widget/dx;->e:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v11, 0x1

    iput-boolean v11, v2, Lcom/a/b/aq;->c:Z

    iget-object v11, v2, Lcom/a/b/aq;->b:Lcom/a/b/ap;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    move-result v12

    iput-object v3, v11, Lcom/a/b/ap;->b:Landroid/graphics/Bitmap;

    iput-object v4, v11, Lcom/a/b/ap;->c:[B

    iput v12, v11, Lcom/a/b/ap;->d:I

    iput-object v6, v11, Lcom/a/b/ap;->e:Ljava/util/concurrent/atomic/AtomicInteger;

    if-nez v13, :cond_4

    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Target must not be null."

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/widget/dw;->f:Ljava/util/Stack;

    invoke-virtual {v2}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/widget/dx;

    move-object v13, v2

    goto :goto_3

    :cond_3
    move/from16 v0, p6

    iput v0, v13, Lcom/wishabi/flipp/widget/dx;->a:I

    iget-object v2, v13, Lcom/wishabi/flipp/widget/dx;->b:Lcom/wishabi/flipp/widget/dy;

    move/from16 v0, p6

    invoke-virtual {v2, v4, v5, v0}, Lcom/wishabi/flipp/widget/dy;->a(III)V

    iget-object v2, v13, Lcom/wishabi/flipp/widget/dx;->f:Landroid/graphics/RectF;

    invoke-virtual {v2, v7, v8, v9, v10}, Landroid/graphics/RectF;->set(FFFF)V

    goto :goto_4

    :cond_4
    iget-boolean v3, v2, Lcom/a/b/aq;->d:Z

    if-eqz v3, :cond_5

    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "Fit cannot be used with a Target."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_5
    iget v3, v2, Lcom/a/b/aq;->e:I

    if-eqz v3, :cond_6

    iget-object v3, v2, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    iget-object v3, v3, Lcom/a/b/ad;->c:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    iget v4, v2, Lcom/a/b/aq;->e:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    :cond_6
    iget-object v3, v2, Lcom/a/b/aq;->b:Lcom/a/b/ap;

    invoke-virtual {v3}, Lcom/a/b/ap;->a()Z

    move-result v3

    if-nez v3, :cond_8

    iget-object v2, v2, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    invoke-virtual {v2, v13}, Lcom/a/b/ad;->a(Ljava/lang/Object;)V

    :cond_7
    :goto_5
    const/4 v2, 0x0

    goto/16 :goto_2

    :cond_8
    iget-object v3, v2, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    iget-object v4, v2, Lcom/a/b/aq;->b:Lcom/a/b/ap;

    invoke-virtual {v4}, Lcom/a/b/ap;->b()Lcom/a/b/ao;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/a/b/ad;->a(Lcom/a/b/ao;)Lcom/a/b/ao;

    move-result-object v14

    invoke-static {v14}, Lcom/a/b/ba;->a(Lcom/a/b/ao;)Ljava/lang/String;

    move-result-object v16

    iget-boolean v3, v2, Lcom/a/b/aq;->c:Z

    if-nez v3, :cond_9

    iget-object v3, v2, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    move-object/from16 v0, v16

    invoke-virtual {v3, v0}, Lcom/a/b/ad;->b(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v3

    if-eqz v3, :cond_9

    iget-object v2, v2, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    invoke-virtual {v2, v13}, Lcom/a/b/ad;->a(Ljava/lang/Object;)V

    sget-object v2, Lcom/a/b/aj;->a:Lcom/a/b/aj;

    invoke-interface {v13}, Lcom/a/b/aw;->a()V

    goto :goto_5

    :cond_9
    new-instance v11, Lcom/a/b/ax;

    iget-object v12, v2, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    iget-boolean v15, v2, Lcom/a/b/aq;->c:Z

    invoke-direct/range {v11 .. v16}, Lcom/a/b/ax;-><init>(Lcom/a/b/ad;Lcom/a/b/aw;Lcom/a/b/ao;ZLjava/lang/String;)V

    iget-object v2, v2, Lcom/a/b/aq;->a:Lcom/a/b/ad;

    invoke-virtual {v2, v11}, Lcom/a/b/ad;->a(Lcom/a/b/a;)V

    goto :goto_5

    .line 222
    :cond_a
    add-float v7, v7, v19

    .line 223
    add-float v9, v9, v19

    .line 208
    add-int/lit8 v5, v5, 0x1

    goto/16 :goto_0

    .line 225
    :cond_b
    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/widget/dw;)Ljava/util/Map;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dw;->e:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/widget/dw;)Ljava/util/Stack;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dw;->f:Ljava/util/Stack;

    return-object v0
.end method

.method private getPreferredResolution()I
    .locals 10

    .prologue
    const/high16 v9, 0x43800000    # 256.0f

    const/4 v0, 0x0

    .line 147
    iget-object v1, p0, Lcom/wishabi/flipp/widget/dw;->g:[F

    if-nez v1, :cond_1

    .line 163
    :cond_0
    return v0

    .line 150
    :cond_1
    iget v1, p0, Lcom/wishabi/flipp/widget/dw;->j:F

    div-float v5, v9, v1

    .line 152
    const/high16 v3, 0x7f800000    # Float.POSITIVE_INFINITY

    .line 155
    iget-object v6, p0, Lcom/wishabi/flipp/widget/dw;->g:[F

    array-length v7, v6

    move v4, v0

    move v1, v0

    :goto_0
    if-ge v4, v7, :cond_0

    aget v2, v6, v4

    .line 156
    mul-float/2addr v2, v9

    sub-float/2addr v2, v5

    invoke-static {v2}, Ljava/lang/Math;->abs(F)F

    move-result v2

    .line 157
    cmpg-float v8, v2, v3

    if-gez v8, :cond_2

    move v0, v1

    .line 161
    :goto_1
    add-int/lit8 v3, v1, 0x1

    .line 155
    add-int/lit8 v1, v4, 0x1

    move v4, v1

    move v1, v3

    move v3, v2

    goto :goto_0

    :cond_2
    move v2, v3

    goto :goto_1
.end method


# virtual methods
.method public final a(Ljava/lang/String;[FFF)V
    .locals 2

    .prologue
    .line 139
    invoke-virtual {p2}, [F->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [F

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dw;->g:[F

    .line 140
    iput p3, p0, Lcom/wishabi/flipp/widget/dw;->k:F

    .line 141
    iput p4, p0, Lcom/wishabi/flipp/widget/dw;->l:F

    .line 142
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/wishabi/flipp/widget/dw;->j:F

    .line 143
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://f.wishabi.net/"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/dw;->h:Ljava/lang/String;

    .line 144
    return-void
.end method

.method protected final onDraw(Landroid/graphics/Canvas;)V
    .locals 14

    .prologue
    const/4 v6, 0x0

    const/high16 v5, 0x40800000    # 4.0f

    const/high16 v3, 0x40000000    # 2.0f

    .line 285
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 287
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/dw;->isInEditMode()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 317
    :goto_0
    return-void

    .line 290
    :cond_0
    iget v7, p0, Lcom/wishabi/flipp/widget/dw;->a:F

    .line 291
    iget v8, p0, Lcom/wishabi/flipp/widget/dw;->b:F

    .line 292
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/dw;->getWidth()I

    move-result v0

    int-to-float v0, v0

    iget v1, p0, Lcom/wishabi/flipp/widget/dw;->j:F

    div-float/2addr v0, v1

    .line 293
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/dw;->getHeight()I

    move-result v1

    int-to-float v1, v1

    iget v2, p0, Lcom/wishabi/flipp/widget/dw;->j:F

    div-float/2addr v1, v2

    .line 294
    add-float v9, v7, v0

    .line 295
    add-float v10, v8, v1

    .line 296
    mul-float v2, v3, v0

    sub-float v2, v7, v2

    .line 297
    mul-float/2addr v3, v1

    sub-float v3, v8, v3

    .line 298
    mul-float/2addr v0, v5

    add-float v4, v7, v0

    .line 299
    mul-float v0, v5, v1

    add-float v5, v8, v0

    .line 301
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v11

    .line 302
    iget v0, p0, Lcom/wishabi/flipp/widget/dw;->j:F

    iget v1, p0, Lcom/wishabi/flipp/widget/dw;->j:F

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->scale(FF)V

    .line 303
    iget v0, p0, Lcom/wishabi/flipp/widget/dw;->a:F

    neg-float v0, v0

    iget v1, p0, Lcom/wishabi/flipp/widget/dw;->b:F

    neg-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 305
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/dw;->i:Z

    if-nez v0, :cond_c

    .line 306
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/dw;->getPreferredResolution()I

    move-result v12

    .line 307
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dw;->d:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/dx;

    iget v13, v0, Lcom/wishabi/flipp/widget/dx;->a:I

    if-eqz v13, :cond_2

    iget v13, v0, Lcom/wishabi/flipp/widget/dx;->a:I

    if-ne v13, v12, :cond_4

    :cond_2
    iget-object v13, v0, Lcom/wishabi/flipp/widget/dx;->f:Landroid/graphics/RectF;

    invoke-virtual {v13, v7, v8, v9, v10}, Landroid/graphics/RectF;->intersects(FFFF)Z

    move-result v13

    if-nez v13, :cond_3

    iget v13, v0, Lcom/wishabi/flipp/widget/dx;->a:I

    if-eq v13, v12, :cond_4

    :cond_3
    iget-object v13, v0, Lcom/wishabi/flipp/widget/dx;->f:Landroid/graphics/RectF;

    invoke-virtual {v13, v2, v3, v4, v5}, Landroid/graphics/RectF;->intersects(FFFF)Z

    move-result v13

    if-nez v13, :cond_1

    iget v13, v0, Lcom/wishabi/flipp/widget/dx;->a:I

    if-nez v13, :cond_1

    :cond_4
    iget-object v13, p0, Lcom/wishabi/flipp/widget/dw;->f:Ljava/util/Stack;

    invoke-virtual {v13, v0}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_1

    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/widget/dw;->e:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_6
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/dx;

    iget v13, v0, Lcom/wishabi/flipp/widget/dx;->a:I

    if-eqz v13, :cond_7

    iget v13, v0, Lcom/wishabi/flipp/widget/dx;->a:I

    if-ne v13, v12, :cond_9

    :cond_7
    iget-object v13, v0, Lcom/wishabi/flipp/widget/dx;->f:Landroid/graphics/RectF;

    invoke-virtual {v13, v7, v8, v9, v10}, Landroid/graphics/RectF;->intersects(FFFF)Z

    move-result v13

    if-nez v13, :cond_8

    iget v13, v0, Lcom/wishabi/flipp/widget/dx;->a:I

    if-eq v13, v12, :cond_9

    :cond_8
    iget-object v13, v0, Lcom/wishabi/flipp/widget/dx;->f:Landroid/graphics/RectF;

    invoke-virtual {v13, v2, v3, v4, v5}, Landroid/graphics/RectF;->intersects(FFFF)Z

    move-result v13

    if-nez v13, :cond_6

    iget v13, v0, Lcom/wishabi/flipp/widget/dx;->a:I

    if-nez v13, :cond_6

    :cond_9
    iget-object v13, v0, Lcom/wishabi/flipp/widget/dx;->e:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v13}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    iget-object v13, p0, Lcom/wishabi/flipp/widget/dw;->c:Lcom/a/b/ad;

    invoke-virtual {v13, v0}, Lcom/a/b/ad;->a(Ljava/lang/Object;)V

    iget-object v13, p0, Lcom/wishabi/flipp/widget/dw;->f:Ljava/util/Stack;

    invoke-virtual {v13, v0}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_2

    :cond_a
    move-object v0, p0

    move-object v1, p1

    .line 309
    invoke-direct/range {v0 .. v6}, Lcom/wishabi/flipp/widget/dw;->a(Landroid/graphics/Canvas;FFFFI)V

    .line 310
    if-eqz v12, :cond_b

    move-object v0, p0

    move-object v1, p1

    move v2, v7

    move v3, v8

    move v4, v9

    move v5, v10

    move v6, v12

    .line 311
    invoke-direct/range {v0 .. v6}, Lcom/wishabi/flipp/widget/dw;->a(Landroid/graphics/Canvas;FFFFI)V

    .line 316
    :cond_b
    :goto_3
    invoke-virtual {p1, v11}, Landroid/graphics/Canvas;->restoreToCount(I)V

    goto/16 :goto_0

    :cond_c
    move-object v0, p0

    move-object v1, p1

    .line 313
    invoke-direct/range {v0 .. v6}, Lcom/wishabi/flipp/widget/dw;->a(Landroid/graphics/Canvas;FFFFI)V

    goto :goto_3
.end method

.method public final setZoomScale(F)V
    .locals 0

    .prologue
    .line 119
    iput p1, p0, Lcom/wishabi/flipp/widget/dw;->j:F

    .line 120
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/dw;->invalidate()V

    .line 121
    return-void
.end method

.method public final setZooming(Z)V
    .locals 1

    .prologue
    .line 124
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/dw;->i:Z

    if-ne v0, p1, :cond_0

    .line 129
    :goto_0
    return-void

    .line 127
    :cond_0
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/dw;->i:Z

    .line 128
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/dw;->invalidate()V

    goto :goto_0
.end method
