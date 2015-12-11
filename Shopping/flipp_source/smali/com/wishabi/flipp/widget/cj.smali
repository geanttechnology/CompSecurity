.class public final Lcom/wishabi/flipp/widget/cj;
.super Lcom/wishabi/flipp/widget/eh;
.source "SourceFile"


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Lcom/wishabi/flipp/widget/CollectionView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/wishabi/flipp/widget/CollectionView;)V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/eh;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/wishabi/flipp/widget/cj;->a:Landroid/content/Context;

    .line 20
    iput-object p2, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    .line 21
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ci;

    .line 26
    if-nez v0, :cond_0

    .line 27
    const/4 v0, 0x0

    .line 29
    :goto_0
    return v0

    :cond_0
    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ci;->b()I

    move-result v0

    goto :goto_0
.end method

.method public final a(I)I
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ci;

    .line 35
    if-nez v0, :cond_0

    .line 36
    const/4 v0, 0x0

    .line 38
    :goto_0
    return v0

    :cond_0
    iget-object v0, v0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v0

    goto :goto_0
.end method

.method public final a(II)I
    .locals 10

    .prologue
    const/4 v2, 0x0

    .line 136
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ci;

    .line 137
    if-nez v0, :cond_0

    .line 159
    :goto_0
    return v2

    .line 140
    :cond_0
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ci;->c(I)I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 162
    :pswitch_0
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "bad section id for search"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 144
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredHeight()I

    move-result v0

    const/16 v1, 0x30

    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v1

    sub-int/2addr v0, v1

    const/16 v1, 0xf0

    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v2

    goto :goto_0

    .line 148
    :pswitch_2
    const/4 v0, 0x1

    const/high16 v1, 0x43340000    # 180.0f

    iget-object v2, p0, Lcom/wishabi/flipp/widget/cj;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v0, v1, v2}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v2, v0

    goto :goto_0

    .line 152
    :pswitch_3
    const/16 v1, 0xa

    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v3

    .line 153
    const/16 v1, 0xf

    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v4

    .line 154
    const/16 v1, 0x32

    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v5

    .line 155
    iget-object v1, v0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v1, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v1

    iget v1, v1, Lcom/wishabi/flipp/util/o;->b:I

    packed-switch v1, :pswitch_data_1

    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "invalid section index"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_4
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Search Layout is asking for ratio for a non-item."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_5
    new-instance v1, Lcom/wishabi/flipp/content/ad;

    iget-object v6, v0, Lcom/wishabi/flipp/widget/ci;->b:Landroid/database/Cursor;

    iget-object v7, v0, Lcom/wishabi/flipp/widget/ci;->c:Lcom/wishabi/flipp/content/ae;

    invoke-direct {v1, v6, v7, p2}, Lcom/wishabi/flipp/content/ad;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/ae;I)V

    invoke-virtual {v1}, Lcom/wishabi/flipp/content/ad;->b()I

    move-result v6

    invoke-virtual {v1}, Lcom/wishabi/flipp/content/ad;->a()I

    move-result v7

    sub-int/2addr v6, v7

    int-to-float v6, v6

    invoke-virtual {v1}, Lcom/wishabi/flipp/content/ad;->d()I

    move-result v7

    invoke-virtual {v1}, Lcom/wishabi/flipp/content/ad;->c()I

    move-result v1

    sub-int v1, v7, v1

    int-to-float v1, v1

    div-float v1, v6, v1

    :goto_1
    const v6, 0x3f8ccccd    # 1.1f

    invoke-static {v1, v6}, Ljava/lang/Math;->min(FF)F

    move-result v6

    .line 156
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/cj;->c(I)I

    move-result v1

    sub-int/2addr v1, v3

    int-to-float v3, v1

    .line 157
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ci;->b(I)I

    move-result v1

    packed-switch v1, :pswitch_data_2

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Requesting matchup for section that doesn\'t support matchups"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 155
    :pswitch_6
    invoke-virtual {v0, p1, p2}, Lcom/wishabi/flipp/widget/ci;->a(II)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/content/ai;

    iget-object v6, v1, Lcom/wishabi/flipp/content/ai;->e:Landroid/graphics/RectF;

    invoke-virtual {v6}, Landroid/graphics/RectF;->height()F

    move-result v6

    iget-object v1, v1, Lcom/wishabi/flipp/content/ai;->e:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->width()F

    move-result v1

    div-float v1, v6, v1

    goto :goto_1

    .line 157
    :pswitch_7
    iget-object v1, v0, Lcom/wishabi/flipp/widget/ci;->d:Ljava/util/HashMap;

    if-eqz v1, :cond_1

    iget-object v1, v0, Lcom/wishabi/flipp/widget/ci;->a:Ljava/util/List;

    if-nez v1, :cond_2

    :cond_1
    move v0, v2

    :goto_2
    if-eqz v0, :cond_5

    const/16 v0, 0x37

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 159
    :goto_3
    mul-float v1, v3, v6

    float-to-int v1, v1

    invoke-static {v1, v5}, Ljava/lang/Math;->max(II)I

    move-result v1

    add-int/2addr v1, v4

    add-int v2, v1, v0

    goto/16 :goto_0

    .line 157
    :cond_2
    new-instance v1, Lcom/wishabi/flipp/content/ad;

    iget-object v7, v0, Lcom/wishabi/flipp/widget/ci;->b:Landroid/database/Cursor;

    iget-object v8, v0, Lcom/wishabi/flipp/widget/ci;->c:Lcom/wishabi/flipp/content/ae;

    invoke-direct {v1, v7, v8, p2}, Lcom/wishabi/flipp/content/ad;-><init>(Landroid/database/Cursor;Lcom/wishabi/flipp/content/ae;I)V

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ci;->d:Ljava/util/HashMap;

    invoke-virtual {v1}, Lcom/wishabi/flipp/content/ad;->e()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/aw;->a(Ljava/util/ArrayList;)Z

    move-result v0

    goto :goto_2

    :pswitch_8
    iget-object v1, v0, Lcom/wishabi/flipp/widget/ci;->d:Ljava/util/HashMap;

    if-eqz v1, :cond_3

    iget-object v1, v0, Lcom/wishabi/flipp/widget/ci;->a:Ljava/util/List;

    if-nez v1, :cond_4

    :cond_3
    move v0, v2

    goto :goto_2

    :cond_4
    iget-object v1, v0, Lcom/wishabi/flipp/widget/ci;->a:Ljava/util/List;

    invoke-interface {v1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/content/ai;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ci;->d:Ljava/util/HashMap;

    iget-wide v8, v1, Lcom/wishabi/flipp/content/ai;->a:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/aw;->a(Ljava/util/ArrayList;)Z

    move-result v0

    goto :goto_2

    :cond_5
    move v0, v2

    goto :goto_3

    .line 140
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_3
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch

    .line 155
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_4
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch

    .line 157
    :pswitch_data_2
    .packed-switch 0x2
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public final a(ILandroid/graphics/Rect;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 68
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ci;

    .line 70
    iget-object v1, p0, Lcom/wishabi/flipp/widget/cj;->a:Landroid/content/Context;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 71
    :cond_0
    invoke-virtual {p2, v2, v2, v2, v2}, Landroid/graphics/Rect;->set(IIII)V

    .line 84
    :goto_0
    return-void

    .line 75
    :cond_1
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ci;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 86
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section id for search"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 77
    :pswitch_0
    invoke-virtual {p2, v2, v2, v2, v2}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_0

    .line 82
    :pswitch_1
    const/4 v0, 0x5

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 83
    invoke-virtual {p2, v0, v2, v0, v0}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_0

    .line 75
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method public final b(I)I
    .locals 8

    .prologue
    .line 43
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ci;

    .line 44
    if-nez v0, :cond_0

    .line 45
    const/4 v0, 0x0

    .line 60
    :goto_0
    return v0

    .line 47
    :cond_0
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    .line 48
    invoke-virtual {p0, p1, v1}, Lcom/wishabi/flipp/widget/cj;->a(ILandroid/graphics/Rect;)V

    .line 50
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ci;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 62
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section id for search"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :pswitch_0
    const/4 v0, 0x1

    goto :goto_0

    .line 54
    :pswitch_1
    const/16 v0, 0x7b

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 55
    iget-object v2, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredWidth()I

    move-result v2

    int-to-double v2, v2

    const-wide/high16 v4, 0x4000000000000000L    # 2.0

    iget v1, v1, Landroid/graphics/Rect;->left:I

    int-to-double v6, v1

    mul-double/2addr v4, v6

    sub-double/2addr v2, v4

    int-to-double v0, v0

    div-double v0, v2, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v0

    double-to-int v0, v0

    goto :goto_0

    .line 59
    :pswitch_2
    const/16 v0, 0xb4

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 60
    iget-object v1, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredWidth()I

    move-result v1

    div-int v0, v1, v0

    const/4 v1, 0x2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    goto :goto_0

    .line 50
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_2
    .end packed-switch
.end method

.method public final b(II)I
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ci;

    .line 169
    if-nez v0, :cond_0

    .line 170
    const/4 v0, 0x0

    .line 172
    :goto_0
    return v0

    :cond_0
    invoke-virtual {v0, p1, p2}, Lcom/wishabi/flipp/widget/ci;->b(II)I

    move-result v0

    goto :goto_0
.end method

.method public final c(I)I
    .locals 3

    .prologue
    .line 92
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 93
    invoke-virtual {p0, p1, v0}, Lcom/wishabi/flipp/widget/cj;->a(ILandroid/graphics/Rect;)V

    .line 94
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/cj;->b(I)I

    move-result v1

    .line 95
    iget-object v2, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredWidth()I

    move-result v2

    iget v0, v0, Landroid/graphics/Rect;->left:I

    mul-int/lit8 v0, v0, 0x2

    sub-int v0, v2, v0

    div-int/2addr v0, v1

    return v0
.end method

.method public final d(I)I
    .locals 2

    .prologue
    .line 100
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ci;

    .line 101
    if-nez v0, :cond_0

    .line 102
    const/4 v0, 0x0

    .line 110
    :goto_0
    return v0

    .line 104
    :cond_0
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ci;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 112
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid section id for search"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 106
    :pswitch_0
    const/16 v0, 0x30

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 110
    :pswitch_1
    const/16 v0, 0x1a

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 104
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method public final e(I)I
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 118
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ci;

    .line 119
    if-nez v0, :cond_0

    move v0, v1

    .line 128
    :goto_0
    return v0

    .line 122
    :cond_0
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ci;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 130
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid section id for search"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 124
    :pswitch_0
    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 128
    :pswitch_1
    const/4 v0, 0x5

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 122
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method public final f(I)I
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ci;

    .line 178
    if-nez v0, :cond_0

    .line 179
    const/4 v0, 0x0

    .line 181
    :goto_0
    return v0

    :cond_0
    iget-object v0, v0, Lcom/wishabi/flipp/widget/ci;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->c()I

    move-result v0

    add-int/2addr v0, p1

    goto :goto_0
.end method

.method public final g(I)Z
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 196
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cj;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ci;

    .line 197
    if-nez v0, :cond_0

    move v0, v1

    .line 206
    :goto_0
    return v0

    .line 200
    :cond_0
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ci;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 208
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid section id for search"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 202
    :pswitch_0
    const/4 v0, 0x0

    goto :goto_0

    :pswitch_1
    move v0, v1

    .line 206
    goto :goto_0

    .line 200
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method
