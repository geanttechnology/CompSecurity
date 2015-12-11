.class final Lcom/mobeta/android/dslv/m;
.super Lcom/mobeta/android/dslv/e;
.source "SourceFile"


# instance fields
.field private b:I

.field private c:I

.field private d:F

.field private e:F

.field private synthetic f:Lcom/mobeta/android/dslv/DragSortListView;


# direct methods
.method public constructor <init>(Lcom/mobeta/android/dslv/DragSortListView;FI)V
    .locals 1

    .prologue
    .line 1241
    iput-object p1, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    .line 1242
    const/high16 v0, 0x3f000000    # 0.5f

    invoke-direct {p0, p1, v0, p3}, Lcom/mobeta/android/dslv/e;-><init>(Lcom/mobeta/android/dslv/DragSortListView;FI)V

    .line 1243
    return-void
.end method

.method private e()I
    .locals 4

    .prologue
    .line 1255
    iget-object v0, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v0

    .line 1256
    iget-object v1, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v1}, Lcom/mobeta/android/dslv/DragSortListView;->h(Lcom/mobeta/android/dslv/DragSortListView;)I

    move-result v1

    iget-object v2, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v2}, Lcom/mobeta/android/dslv/DragSortListView;->getDividerHeight()I

    move-result v2

    add-int/2addr v1, v2

    div-int/lit8 v1, v1, 0x2

    .line 1257
    iget-object v2, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    iget v3, p0, Lcom/mobeta/android/dslv/m;->b:I

    sub-int v0, v3, v0

    invoke-virtual {v2, v0}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 1258
    const/4 v0, -0x1

    .line 1259
    if-eqz v2, :cond_2

    .line 1260
    iget v0, p0, Lcom/mobeta/android/dslv/m;->b:I

    iget v3, p0, Lcom/mobeta/android/dslv/m;->c:I

    if-ne v0, v3, :cond_0

    .line 1261
    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v0

    .line 1274
    :goto_0
    return v0

    .line 1262
    :cond_0
    iget v0, p0, Lcom/mobeta/android/dslv/m;->b:I

    iget v3, p0, Lcom/mobeta/android/dslv/m;->c:I

    if-ge v0, v3, :cond_1

    .line 1264
    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v0

    sub-int/2addr v0, v1

    goto :goto_0

    .line 1267
    :cond_1
    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v0

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v1}, Lcom/mobeta/android/dslv/DragSortListView;->i(Lcom/mobeta/android/dslv/DragSortListView;)I

    move-result v1

    sub-int/2addr v0, v1

    goto :goto_0

    .line 1271
    :cond_2
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/m;->d()V

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 1247
    iget-object v0, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v0}, Lcom/mobeta/android/dslv/DragSortListView;->f(Lcom/mobeta/android/dslv/DragSortListView;)I

    move-result v0

    iput v0, p0, Lcom/mobeta/android/dslv/m;->b:I

    .line 1248
    iget-object v0, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v0}, Lcom/mobeta/android/dslv/DragSortListView;->g(Lcom/mobeta/android/dslv/DragSortListView;)I

    move-result v0

    iput v0, p0, Lcom/mobeta/android/dslv/m;->c:I

    .line 1249
    iget-object v0, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    const/4 v1, 0x2

    invoke-static {v0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->a(Lcom/mobeta/android/dslv/DragSortListView;I)I

    .line 1250
    iget-object v0, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v0}, Lcom/mobeta/android/dslv/DragSortListView;->d(Lcom/mobeta/android/dslv/DragSortListView;)Landroid/graphics/Point;

    move-result-object v0

    iget v0, v0, Landroid/graphics/Point;->y:I

    invoke-direct {p0}, Lcom/mobeta/android/dslv/m;->e()I

    move-result v1

    sub-int/2addr v0, v1

    int-to-float v0, v0

    iput v0, p0, Lcom/mobeta/android/dslv/m;->d:F

    .line 1251
    iget-object v0, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v0}, Lcom/mobeta/android/dslv/DragSortListView;->d(Lcom/mobeta/android/dslv/DragSortListView;)Landroid/graphics/Point;

    move-result-object v0

    iget v0, v0, Landroid/graphics/Point;->x:I

    iget-object v1, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v1}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingLeft()I

    move-result v1

    sub-int/2addr v0, v1

    int-to-float v0, v0

    iput v0, p0, Lcom/mobeta/android/dslv/m;->e:F

    .line 1252
    return-void
.end method

.method public final a(F)V
    .locals 5

    .prologue
    .line 1279
    invoke-direct {p0}, Lcom/mobeta/android/dslv/m;->e()I

    move-result v0

    .line 1280
    iget-object v1, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v1}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingLeft()I

    move-result v1

    .line 1281
    iget-object v2, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v2}, Lcom/mobeta/android/dslv/DragSortListView;->d(Lcom/mobeta/android/dslv/DragSortListView;)Landroid/graphics/Point;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Point;->y:I

    sub-int/2addr v2, v0

    int-to-float v2, v2

    .line 1282
    iget-object v3, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v3}, Lcom/mobeta/android/dslv/DragSortListView;->d(Lcom/mobeta/android/dslv/DragSortListView;)Landroid/graphics/Point;

    move-result-object v3

    iget v3, v3, Landroid/graphics/Point;->x:I

    sub-int v1, v3, v1

    int-to-float v1, v1

    .line 1283
    const/high16 v3, 0x3f800000    # 1.0f

    sub-float/2addr v3, p1

    .line 1284
    iget v4, p0, Lcom/mobeta/android/dslv/m;->d:F

    div-float/2addr v2, v4

    invoke-static {v2}, Ljava/lang/Math;->abs(F)F

    move-result v2

    cmpg-float v2, v3, v2

    if-ltz v2, :cond_0

    iget v2, p0, Lcom/mobeta/android/dslv/m;->e:F

    div-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result v1

    cmpg-float v1, v3, v1

    if-gez v1, :cond_1

    .line 1285
    :cond_0
    iget-object v1, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v1}, Lcom/mobeta/android/dslv/DragSortListView;->d(Lcom/mobeta/android/dslv/DragSortListView;)Landroid/graphics/Point;

    move-result-object v1

    iget v2, p0, Lcom/mobeta/android/dslv/m;->d:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    add-int/2addr v0, v2

    iput v0, v1, Landroid/graphics/Point;->y:I

    .line 1286
    iget-object v0, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v0}, Lcom/mobeta/android/dslv/DragSortListView;->d(Lcom/mobeta/android/dslv/DragSortListView;)Landroid/graphics/Point;

    move-result-object v0

    iget-object v1, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v1}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingLeft()I

    move-result v1

    iget v2, p0, Lcom/mobeta/android/dslv/m;->e:F

    mul-float/2addr v2, v3

    float-to-int v2, v2

    add-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Point;->x:I

    .line 1287
    iget-object v0, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->a(Lcom/mobeta/android/dslv/DragSortListView;Z)V

    .line 1289
    :cond_1
    return-void
.end method

.method public final b()V
    .locals 1

    .prologue
    .line 1293
    iget-object v0, p0, Lcom/mobeta/android/dslv/m;->f:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v0}, Lcom/mobeta/android/dslv/DragSortListView;->j(Lcom/mobeta/android/dslv/DragSortListView;)V

    .line 1294
    return-void
.end method
