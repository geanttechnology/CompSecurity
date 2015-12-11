.class public final Lcom/wishabi/flipp/widget/ax;
.super Lcom/wishabi/flipp/widget/eh;
.source "SourceFile"


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Lcom/wishabi/flipp/widget/CollectionView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/wishabi/flipp/widget/CollectionView;)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/eh;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ax;->a:Landroid/content/Context;

    .line 18
    iput-object p2, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    .line 19
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 24
    if-nez v0, :cond_0

    .line 25
    const/4 v0, 0x0

    .line 27
    :goto_0
    return v0

    :cond_0
    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bw;->b()I

    move-result v0

    goto :goto_0
.end method

.method public final a(I)I
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 33
    if-nez v0, :cond_0

    .line 34
    const/4 v0, 0x0

    .line 36
    :goto_0
    return v0

    :cond_0
    iget-object v0, v0, Lcom/wishabi/flipp/widget/bw;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/by;

    iget v0, v0, Lcom/wishabi/flipp/widget/by;->b:I

    goto :goto_0
.end method

.method public final a(II)I
    .locals 2

    .prologue
    .line 153
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 154
    if-nez v0, :cond_0

    .line 155
    const/4 v0, 0x0

    .line 169
    :goto_0
    return v0

    .line 157
    :cond_0
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/bw;->b(I)I

    move-result v0

    .line 160
    sget-object v1, Lcom/wishabi/flipp/widget/ay;->a:[I

    add-int/lit8 v0, v0, -0x1

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    .line 166
    const/16 v0, 0xb4

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 163
    :pswitch_0
    const/16 v0, 0xd2

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 160
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method public final a(ILandroid/graphics/Rect;)V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 76
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 77
    if-nez v0, :cond_0

    .line 91
    :goto_0
    return-void

    .line 80
    :cond_0
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/bw;->b(I)I

    move-result v0

    .line 82
    sget-object v2, Lcom/wishabi/flipp/widget/ay;->a:[I

    add-int/lit8 v0, v0, -0x1

    aget v0, v2, v0

    packed-switch v0, :pswitch_data_0

    .line 86
    const/4 v0, 0x1

    const/high16 v2, 0x40a00000    # 5.0f

    iget-object v3, p0, Lcom/wishabi/flipp/widget/ax;->a:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    invoke-static {v0, v2, v3}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v0, v0

    .line 90
    :goto_1
    invoke-virtual {p2, v0, v1, v0, v0}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_0

    :pswitch_0
    move v0, v1

    .line 84
    goto :goto_1

    .line 82
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public final b(I)I
    .locals 12

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    const/4 v1, -0x1

    const-wide/high16 v10, 0x4000000000000000L    # 2.0

    const/4 v2, 0x5

    .line 41
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 42
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/bw;->b(I)I

    .line 45
    sget-object v5, Lcom/wishabi/flipp/widget/ay;->a:[I

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/bw;->b(I)I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    aget v0, v5, v0

    packed-switch v0, :pswitch_data_0

    move v0, v3

    .line 64
    :goto_0
    return v0

    .line 47
    :pswitch_0
    const/4 v0, 0x3

    .line 48
    goto :goto_0

    .line 50
    :pswitch_1
    const/16 v0, 0x12c

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 51
    invoke-static {v2}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v1

    .line 52
    iget-object v2, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredWidth()I

    move-result v2

    int-to-double v2, v2

    int-to-double v6, v1

    mul-double/2addr v6, v10

    sub-double/2addr v2, v6

    int-to-double v0, v0

    div-double v0, v2, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-int v0, v0

    .line 54
    invoke-static {v0, v4}, Ljava/lang/Math;->max(II)I

    move-result v0

    goto :goto_0

    .line 58
    :pswitch_2
    const/16 v0, 0x7b

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 59
    invoke-static {v2}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v5

    .line 60
    iget-object v6, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v6}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredWidth()I

    move-result v6

    int-to-double v6, v6

    int-to-double v8, v5

    mul-double/2addr v8, v10

    sub-double/2addr v6, v8

    int-to-double v8, v0

    div-double/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-int v5, v6

    .line 62
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v6

    if-nez v6, :cond_2

    :goto_2
    if-lt v0, v1, :cond_0

    move v3, v4

    :cond_0
    if-eqz v3, :cond_3

    move v0, v2

    .line 63
    :goto_3
    invoke-static {v5, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    goto :goto_0

    .line 62
    :cond_1
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    goto :goto_1

    :cond_2
    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    goto :goto_2

    :cond_3
    const/16 v0, 0x9

    goto :goto_3

    .line 45
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final b(II)I
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 176
    if-nez v0, :cond_0

    .line 177
    const/4 v0, -0x1

    .line 179
    :goto_0
    return v0

    :cond_0
    invoke-virtual {v0, p1, p2}, Lcom/wishabi/flipp/widget/bw;->a(II)I

    move-result v0

    goto :goto_0
.end method

.method public final c(I)I
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 95
    const/high16 v0, 0x40a00000    # 5.0f

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ax;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {v3, v0, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v0, v0

    .line 97
    const/high16 v1, 0x41200000    # 10.0f

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ax;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v3, v1, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v1

    float-to-int v1, v1

    .line 99
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/ax;->b(I)I

    move-result v2

    .line 100
    iget-object v3, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredWidth()I

    move-result v3

    mul-int/lit8 v0, v0, 0x2

    sub-int v0, v3, v0

    add-int/lit8 v3, v2, -0x1

    mul-int/2addr v1, v3

    sub-int/2addr v0, v1

    div-int/2addr v0, v2

    return v0
.end method

.method public final d(I)I
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v1, 0x0

    .line 108
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 109
    if-nez v0, :cond_0

    .line 124
    :goto_0
    return v1

    .line 112
    :cond_0
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/bw;->b(I)I

    move-result v2

    .line 115
    sget-object v3, Lcom/wishabi/flipp/widget/ay;->a:[I

    add-int/lit8 v2, v2, -0x1

    aget v2, v3, v2

    packed-switch v2, :pswitch_data_0

    .line 120
    iget-boolean v0, v0, Lcom/wishabi/flipp/widget/bw;->b:Z

    if-eqz v0, :cond_1

    if-eq p1, v4, :cond_2

    :cond_1
    if-nez p1, :cond_3

    .line 121
    :cond_2
    const/16 v0, 0x1a

    .line 124
    :goto_1
    int-to-float v0, v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ax;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {v4, v0, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v1, v0

    goto :goto_0

    .line 117
    :pswitch_0
    const/16 v0, 0x30

    .line 118
    goto :goto_1

    :cond_3
    move v0, v1

    goto :goto_1

    .line 115
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public final e(I)I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 131
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 132
    if-nez v0, :cond_0

    .line 147
    :goto_0
    return v1

    .line 135
    :cond_0
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/bw;->b(I)I

    move-result v0

    .line 138
    sget-object v2, Lcom/wishabi/flipp/widget/ay;->a:[I

    add-int/lit8 v0, v0, -0x1

    aget v0, v2, v0

    packed-switch v0, :pswitch_data_0

    .line 144
    const/4 v0, 0x5

    .line 147
    :goto_1
    const/4 v1, 0x1

    int-to-float v0, v0

    iget-object v2, p0, Lcom/wishabi/flipp/widget/ax;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v1, v0, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v1, v0

    goto :goto_0

    :pswitch_0
    move v0, v1

    .line 142
    goto :goto_1

    .line 138
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public final f(I)I
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 186
    if-nez v0, :cond_0

    .line 187
    const/4 v0, -0x1

    .line 189
    :goto_0
    return v0

    :cond_0
    iget v0, v0, Lcom/wishabi/flipp/widget/da;->j:I

    add-int/2addr v0, p1

    goto :goto_0
.end method

.method public final g(I)Z
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 194
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ax;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bw;

    .line 195
    if-nez v0, :cond_0

    move v0, v1

    .line 203
    :goto_0
    return v0

    .line 198
    :cond_0
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/bw;->b(I)I

    .line 200
    iget-boolean v0, v0, Lcom/wishabi/flipp/widget/bw;->b:Z

    if-eqz v0, :cond_1

    if-nez p1, :cond_1

    .line 201
    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    move v0, v1

    .line 203
    goto :goto_0
.end method
