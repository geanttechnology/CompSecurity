.class public final Lcom/wishabi/flipp/widget/eg;
.super Lcom/wishabi/flipp/widget/n;
.source "SourceFile"


# instance fields
.field public b:Lcom/wishabi/flipp/widget/eh;

.field private c:I

.field private d:I

.field private final e:Z

.field private final f:Landroid/graphics/Rect;

.field private final g:Landroid/graphics/Rect;

.field private h:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/wishabi/flipp/widget/o;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 58
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/n;-><init>()V

    .line 54
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/eg;->f:Landroid/graphics/Rect;

    .line 55
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/eg;->g:Landroid/graphics/Rect;

    .line 59
    const-string v0, "accessibility"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/accessibility/AccessibilityManager;

    .line 61
    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityManager;->isTouchExplorationEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/wishabi/flipp/widget/eg;->e:Z

    .line 63
    return-void

    .line 61
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 74
    iget v0, p0, Lcom/wishabi/flipp/widget/eg;->c:I

    return v0
.end method

.method public final a(I)Lcom/wishabi/flipp/widget/o;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/wishabi/flipp/widget/eg;->h:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/o;

    return-object v0
.end method

.method public final a(III)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(III)",
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/widget/o;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 89
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 91
    iget-object v4, p0, Lcom/wishabi/flipp/widget/eg;->h:Landroid/util/SparseArray;

    .line 92
    invoke-virtual {v4}, Landroid/util/SparseArray;->size()I

    move-result v5

    move v1, v2

    :goto_0
    if-ge v1, v5, :cond_2

    .line 93
    invoke-virtual {v4, v1}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/o;

    .line 94
    iget-object v6, v0, Lcom/wishabi/flipp/widget/o;->b:Landroid/graphics/Rect;

    .line 95
    if-eqz v6, :cond_0

    iget-boolean v6, p0, Lcom/wishabi/flipp/widget/eg;->e:Z

    if-eqz v6, :cond_0

    .line 96
    iget-object v6, v0, Lcom/wishabi/flipp/widget/o;->a:Landroid/graphics/Rect;

    .line 97
    iget v7, v6, Landroid/graphics/Rect;->left:I

    iget-object v8, v0, Lcom/wishabi/flipp/widget/o;->b:Landroid/graphics/Rect;

    iget v8, v8, Landroid/graphics/Rect;->top:I

    iget-object v9, v0, Lcom/wishabi/flipp/widget/o;->c:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->top:I

    invoke-static {p1, v9}, Ljava/lang/Math;->max(II)I

    move-result v9

    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    move-result v8

    invoke-virtual {v6, v7, v8}, Landroid/graphics/Rect;->offsetTo(II)V

    .line 102
    :cond_0
    iget-object v6, v0, Lcom/wishabi/flipp/widget/o;->a:Landroid/graphics/Rect;

    invoke-virtual {v6, v2, p1, p2, p3}, Landroid/graphics/Rect;->intersects(IIII)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 103
    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 92
    :cond_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 106
    :cond_2
    return-object v3
.end method

.method public final b()I
    .locals 1

    .prologue
    .line 78
    iget v0, p0, Lcom/wishabi/flipp/widget/eg;->d:I

    return v0
.end method

.method public final c()V
    .locals 30

    .prologue
    .line 110
    const-string v4, "prepareLayout"

    invoke-static {v4}, Lcom/wishabi/flipp/c/a;->a(Ljava/lang/String;)V

    .line 111
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/n;->a:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v4}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredWidth()I

    move-result v14

    .line 112
    const/4 v7, 0x0

    .line 113
    new-instance v15, Landroid/util/SparseArray;

    invoke-direct {v15}, Landroid/util/SparseArray;-><init>()V

    .line 115
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/wishabi/flipp/widget/eg;->b:Lcom/wishabi/flipp/widget/eh;

    move-object/from16 v16, v0

    .line 117
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/widget/n;->a:Lcom/wishabi/flipp/widget/CollectionView;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/wishabi/flipp/widget/eg;->g:Landroid/graphics/Rect;

    invoke-virtual {v4, v5}, Lcom/wishabi/flipp/widget/CollectionView;->getDrawingRect(Landroid/graphics/Rect;)V

    .line 119
    const/4 v6, 0x0

    .line 120
    const/4 v5, 0x1

    .line 122
    const/4 v4, 0x0

    invoke-virtual/range {v16 .. v16}, Lcom/wishabi/flipp/widget/eh;->a()I

    move-result v17

    move v12, v4

    move v4, v5

    move-object v5, v6

    move v6, v7

    :goto_0
    move/from16 v0, v17

    if-ge v12, v0, :cond_7

    .line 123
    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Lcom/wishabi/flipp/widget/eh;->b(I)I

    move-result v8

    .line 124
    if-eqz v8, :cond_6

    .line 125
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/wishabi/flipp/widget/eg;->f:Landroid/graphics/Rect;

    move-object/from16 v0, v16

    invoke-virtual {v0, v12, v7}, Lcom/wishabi/flipp/widget/eh;->a(ILandroid/graphics/Rect;)V

    .line 128
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/wishabi/flipp/widget/eg;->f:Landroid/graphics/Rect;

    iget v0, v7, Landroid/graphics/Rect;->left:I

    move/from16 v18, v0

    .line 129
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/wishabi/flipp/widget/eg;->f:Landroid/graphics/Rect;

    iget v9, v7, Landroid/graphics/Rect;->top:I

    .line 130
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/wishabi/flipp/widget/eg;->f:Landroid/graphics/Rect;

    iget v7, v7, Landroid/graphics/Rect;->right:I

    .line 131
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/wishabi/flipp/widget/eg;->f:Landroid/graphics/Rect;

    iget v0, v10, Landroid/graphics/Rect;->bottom:I

    move/from16 v19, v0

    .line 133
    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Lcom/wishabi/flipp/widget/eh;->c(I)I

    move-result v20

    .line 134
    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Lcom/wishabi/flipp/widget/eh;->d(I)I

    move-result v10

    .line 135
    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Lcom/wishabi/flipp/widget/eh;->e(I)I

    move-result v13

    .line 139
    sub-int v11, v14, v18

    sub-int/2addr v11, v7

    .line 140
    const/4 v7, 0x0

    .line 141
    const/16 v21, 0x1

    move/from16 v0, v21

    if-le v8, v0, :cond_8

    .line 142
    int-to-float v7, v11

    mul-int v11, v8, v20

    int-to-float v11, v11

    sub-float/2addr v7, v11

    add-int/lit8 v11, v8, -0x1

    int-to-float v11, v11

    div-float/2addr v7, v11

    float-to-double v0, v7

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Math;->floor(D)D

    move-result-wide v22

    move-wide/from16 v0, v22

    double-to-int v7, v0

    move v11, v7

    .line 145
    :goto_1
    add-int v21, v20, v11

    .line 146
    add-int/2addr v6, v9

    .line 148
    if-lez v10, :cond_0

    .line 149
    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Lcom/wishabi/flipp/widget/eh;->f(I)I

    move-result v7

    .line 150
    const/4 v9, -0x1

    if-eq v7, v9, :cond_0

    .line 151
    new-instance v5, Lcom/wishabi/flipp/widget/o;

    invoke-direct {v5}, Lcom/wishabi/flipp/widget/o;-><init>()V

    .line 153
    const/4 v4, 0x1

    iput v4, v5, Lcom/wishabi/flipp/widget/o;->e:I

    .line 154
    new-instance v4, Landroid/graphics/Rect;

    const/4 v9, 0x0

    add-int v22, v6, v10

    move/from16 v0, v22

    invoke-direct {v4, v9, v6, v14, v0}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v4, v5, Lcom/wishabi/flipp/widget/o;->a:Landroid/graphics/Rect;

    .line 156
    new-instance v4, Landroid/graphics/Rect;

    const/4 v9, 0x0

    add-int v22, v6, v10

    move/from16 v0, v22

    invoke-direct {v4, v9, v6, v14, v0}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v4, v5, Lcom/wishabi/flipp/widget/o;->c:Landroid/graphics/Rect;

    .line 158
    iput v7, v5, Lcom/wishabi/flipp/widget/o;->d:I

    .line 159
    invoke-virtual {v15, v7, v5}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 160
    add-int v4, v10, v13

    add-int/2addr v6, v4

    .line 162
    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Lcom/wishabi/flipp/widget/eh;->g(I)Z

    move-result v4

    .line 166
    :cond_0
    new-array v0, v8, [I

    move-object/from16 v22, v0

    .line 167
    const/4 v7, 0x0

    :goto_2
    if-ge v7, v8, :cond_1

    .line 168
    aput v6, v22, v7

    .line 167
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    .line 170
    :cond_1
    const/4 v7, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Lcom/wishabi/flipp/widget/eh;->a(I)I

    move-result v23

    move v13, v7

    :goto_3
    move/from16 v0, v23

    if-ge v13, v0, :cond_4

    .line 185
    move-object/from16 v0, v16

    invoke-virtual {v0, v12, v13}, Lcom/wishabi/flipp/widget/eh;->a(II)I

    move-result v24

    .line 186
    if-eqz v24, :cond_3

    .line 187
    move-object/from16 v0, v16

    invoke-virtual {v0, v12, v13}, Lcom/wishabi/flipp/widget/eh;->b(II)I

    move-result v25

    .line 190
    const/4 v7, -0x1

    move/from16 v0, v25

    if-eq v0, v7, :cond_3

    .line 191
    const/4 v10, 0x0

    .line 194
    const v8, 0x7fffffff

    .line 195
    const/4 v9, 0x0

    move-object/from16 v0, v22

    array-length v0, v0

    move/from16 v26, v0

    :goto_4
    move/from16 v0, v26

    if-ge v9, v0, :cond_2

    .line 196
    aget v7, v22, v9

    .line 197
    if-ge v7, v8, :cond_9

    move v8, v9

    .line 195
    :goto_5
    add-int/lit8 v9, v9, 0x1

    move v10, v8

    move v8, v7

    goto :goto_4

    .line 203
    :cond_2
    mul-int v7, v21, v10

    add-int v7, v7, v18

    .line 204
    new-instance v9, Lcom/wishabi/flipp/widget/o;

    invoke-direct {v9}, Lcom/wishabi/flipp/widget/o;-><init>()V

    .line 206
    new-instance v26, Landroid/graphics/Rect;

    add-int v27, v7, v20

    add-int v28, v8, v24

    move-object/from16 v0, v26

    move/from16 v1, v27

    move/from16 v2, v28

    invoke-direct {v0, v7, v8, v1, v2}, Landroid/graphics/Rect;-><init>(IIII)V

    move-object/from16 v0, v26

    iput-object v0, v9, Lcom/wishabi/flipp/widget/o;->a:Landroid/graphics/Rect;

    .line 208
    move/from16 v0, v25

    iput v0, v9, Lcom/wishabi/flipp/widget/o;->d:I

    .line 209
    const/4 v7, 0x1

    iput-boolean v7, v9, Lcom/wishabi/flipp/widget/o;->f:Z

    .line 210
    move/from16 v0, v25

    invoke-virtual {v15, v0, v9}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 212
    aget v7, v22, v10

    add-int v8, v24, v11

    add-int/2addr v7, v8

    aput v7, v22, v10

    .line 184
    :cond_3
    add-int/lit8 v7, v13, 0x1

    move v13, v7

    goto :goto_3

    .line 215
    :cond_4
    move-object/from16 v0, v22

    array-length v8, v0

    const/4 v7, 0x0

    move/from16 v29, v7

    move v7, v6

    move/from16 v6, v29

    :goto_6
    if-ge v6, v8, :cond_5

    aget v9, v22, v6

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    .line 216
    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v9

    invoke-static {v7, v9}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 215
    add-int/lit8 v6, v6, 0x1

    goto :goto_6

    .line 217
    :cond_5
    add-int v6, v7, v19

    .line 220
    if-eqz v5, :cond_6

    move-object/from16 v0, p0

    iget-boolean v7, v0, Lcom/wishabi/flipp/widget/eg;->e:Z

    if-eqz v7, :cond_6

    if-eqz v4, :cond_6

    .line 235
    iget-object v7, v5, Lcom/wishabi/flipp/widget/o;->a:Landroid/graphics/Rect;

    .line 236
    invoke-virtual {v7}, Landroid/graphics/Rect;->height()I

    move-result v8

    sub-int v8, v6, v8

    .line 237
    new-instance v9, Landroid/graphics/Rect;

    iget v10, v7, Landroid/graphics/Rect;->left:I

    iget v11, v7, Landroid/graphics/Rect;->right:I

    invoke-virtual {v7}, Landroid/graphics/Rect;->height()I

    move-result v13

    add-int/2addr v13, v8

    invoke-direct {v9, v10, v8, v11, v13}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v9, v5, Lcom/wishabi/flipp/widget/o;->b:Landroid/graphics/Rect;

    .line 239
    iget v9, v7, Landroid/graphics/Rect;->left:I

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/wishabi/flipp/widget/eg;->g:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->top:I

    iget v11, v7, Landroid/graphics/Rect;->top:I

    invoke-static {v10, v11}, Ljava/lang/Math;->max(II)I

    move-result v10

    invoke-static {v8, v10}, Ljava/lang/Math;->min(II)I

    move-result v8

    invoke-virtual {v7, v9, v8}, Landroid/graphics/Rect;->offsetTo(II)V

    .line 122
    :cond_6
    add-int/lit8 v7, v12, 0x1

    move v12, v7

    goto/16 :goto_0

    .line 244
    :cond_7
    move-object/from16 v0, p0

    iput v14, v0, Lcom/wishabi/flipp/widget/eg;->c:I

    .line 245
    move-object/from16 v0, p0

    iput v6, v0, Lcom/wishabi/flipp/widget/eg;->d:I

    .line 246
    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/wishabi/flipp/widget/eg;->h:Landroid/util/SparseArray;

    .line 247
    invoke-static {}, Lcom/wishabi/flipp/c/a;->a()V

    .line 248
    return-void

    :cond_8
    move v11, v7

    goto/16 :goto_1

    :cond_9
    move v7, v8

    move v8, v10

    goto/16 :goto_5
.end method
