.class public Lcom/mobeta/android/dslv/DragSortListView;
.super Landroid/widget/ListView;
.source "SourceFile"


# instance fields
.field private A:F

.field private B:F

.field private C:I

.field private D:I

.field private E:F

.field private F:F

.field private G:F

.field private H:F

.field private I:F

.field private J:Lcom/mobeta/android/dslv/o;

.field private K:I

.field private L:I

.field private M:I

.field private N:I

.field private O:Z

.field private P:Z

.field private Q:Lcom/mobeta/android/dslv/l;

.field private R:Landroid/view/MotionEvent;

.field private S:I

.field private T:F

.field private U:F

.field private V:Lcom/mobeta/android/dslv/h;

.field private W:Z

.field private Z:Lcom/mobeta/android/dslv/f;

.field private a:Landroid/view/View;

.field private aa:Z

.field private ab:Z

.field private ac:Lcom/mobeta/android/dslv/d;

.field private ad:Lcom/mobeta/android/dslv/b;

.field private ae:Lcom/mobeta/android/dslv/m;

.field private af:Z

.field private ag:F

.field private ah:Z

.field private b:Landroid/graphics/Point;

.field private c:Landroid/graphics/Point;

.field private d:I

.field private e:Z

.field private f:Landroid/database/DataSetObserver;

.field private g:F

.field private h:F

.field private i:I

.field private j:I

.field private k:I

.field private l:Z

.field private m:I

.field private n:I

.field private o:I

.field private p:Lcom/mobeta/android/dslv/j;

.field private q:Lcom/mobeta/android/dslv/i;

.field private r:Lcom/mobeta/android/dslv/r;

.field private s:Z

.field private t:I

.field private u:I

.field private v:I

.field private w:I

.field private x:I

.field private y:[Landroid/view/View;

.field private z:Lcom/mobeta/android/dslv/p;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 15

    .prologue
    .line 442
    invoke-direct/range {p0 .. p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 74
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    iput-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    .line 76
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    iput-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->c:Landroid/graphics/Point;

    .line 86
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->e:Z

    .line 97
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->g:F

    .line 98
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->h:F

    .line 123
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->l:Z

    .line 179
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->s:Z

    .line 190
    const/4 v1, 0x0

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    .line 197
    const/4 v1, 0x1

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->u:I

    .line 213
    const/4 v1, 0x0

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->x:I

    .line 219
    const/4 v1, 0x1

    new-array v1, v1, [Landroid/view/View;

    iput-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->y:[Landroid/view/View;

    .line 231
    const v1, 0x3eaaaaab

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->A:F

    .line 238
    const v1, 0x3eaaaaab

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->B:F

    .line 262
    const/high16 v1, 0x3f000000    # 0.5f

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->I:F

    .line 270
    new-instance v1, Lcom/mobeta/android/dslv/o;

    invoke-direct {v1, p0}, Lcom/mobeta/android/dslv/o;-><init>(Lcom/mobeta/android/dslv/DragSortListView;)V

    iput-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->J:Lcom/mobeta/android/dslv/o;

    .line 334
    const/4 v1, 0x0

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->N:I

    .line 340
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->O:Z

    .line 345
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->P:Z

    .line 350
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->Q:Lcom/mobeta/android/dslv/l;

    .line 370
    const/4 v1, 0x0

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->S:I

    .line 377
    const/high16 v1, 0x3e800000    # 0.25f

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->T:F

    .line 386
    const/4 v1, 0x0

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->U:F

    .line 399
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->W:Z

    .line 409
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->aa:Z

    .line 416
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->ab:Z

    .line 430
    new-instance v1, Lcom/mobeta/android/dslv/d;

    const/4 v2, 0x3

    invoke-direct {v1, p0, v2}, Lcom/mobeta/android/dslv/d;-><init>(Lcom/mobeta/android/dslv/DragSortListView;I)V

    iput-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->ac:Lcom/mobeta/android/dslv/d;

    .line 439
    const/4 v1, 0x0

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->ag:F

    .line 1694
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->ah:Z

    .line 2176
    const/16 v2, 0x96

    .line 446
    const/16 v1, 0x96

    .line 448
    if-eqz p2, :cond_2

    .line 449
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/mobeta/android/dslv/q;->DragSortListView:[I

    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v1, v0, v2, v3, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v10

    .line 452
    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {v10, v2, v3}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->u:I

    .line 455
    const/4 v1, 0x5

    const/4 v2, 0x0

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->W:Z

    .line 458
    iget-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->W:Z

    if-eqz v1, :cond_0

    .line 459
    new-instance v1, Lcom/mobeta/android/dslv/f;

    invoke-direct {v1, p0}, Lcom/mobeta/android/dslv/f;-><init>(Lcom/mobeta/android/dslv/DragSortListView;)V

    iput-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->Z:Lcom/mobeta/android/dslv/f;

    .line 463
    :cond_0
    const/4 v1, 0x6

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->g:F

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->g:F

    .line 464
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->g:F

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->h:F

    .line 466
    const/16 v1, 0xa

    iget-boolean v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->s:Z

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->s:Z

    .line 468
    const/4 v1, 0x0

    const/high16 v2, 0x3f800000    # 1.0f

    const/high16 v3, 0x3f800000    # 1.0f

    const/4 v4, 0x7

    const/high16 v5, 0x3f400000    # 0.75f

    invoke-virtual {v10, v4, v5}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v4

    sub-float/2addr v3, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->min(FF)F

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    move-result v1

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->T:F

    .line 473
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->T:F

    const/4 v2, 0x0

    cmpl-float v1, v1, v2

    if-lez v1, :cond_5

    const/4 v1, 0x1

    :goto_0
    iput-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->l:Z

    .line 475
    const/4 v1, 0x1

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->A:F

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    .line 479
    invoke-virtual {p0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->setDragScrollStart(F)V

    .line 481
    const/4 v1, 0x2

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->I:F

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->I:F

    .line 485
    const/16 v1, 0x8

    const/16 v2, 0x96

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v9

    .line 489
    const/16 v1, 0x9

    const/16 v2, 0x96

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v8

    .line 493
    const/16 v1, 0x11

    const/4 v2, 0x1

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    .line 497
    if-eqz v1, :cond_1

    .line 498
    const/16 v1, 0xc

    const/4 v2, 0x0

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v11

    .line 501
    const/4 v1, 0x4

    const/4 v2, 0x1

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v5

    .line 504
    const/16 v1, 0xb

    const/4 v2, 0x1

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v12

    .line 507
    const/16 v1, 0xd

    const/4 v2, 0x0

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v4

    .line 510
    const/16 v1, 0xe

    const/4 v2, 0x0

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    .line 513
    const/16 v1, 0xf

    const/4 v2, 0x0

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v7

    .line 516
    const/16 v1, 0x10

    const/4 v2, 0x0

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v6

    .line 519
    const/4 v1, 0x3

    const/high16 v2, -0x1000000

    invoke-virtual {v10, v1, v2}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v13

    .line 523
    new-instance v1, Lcom/mobeta/android/dslv/c;

    move-object v2, p0

    invoke-direct/range {v1 .. v7}, Lcom/mobeta/android/dslv/c;-><init>(Lcom/mobeta/android/dslv/DragSortListView;IIIII)V

    .line 526
    invoke-virtual {v1, v11}, Lcom/mobeta/android/dslv/c;->b(Z)V

    .line 527
    invoke-virtual {v1, v12}, Lcom/mobeta/android/dslv/c;->a(Z)V

    .line 528
    invoke-virtual {v1, v13}, Lcom/mobeta/android/dslv/c;->d(I)V

    .line 530
    iput-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->Q:Lcom/mobeta/android/dslv/l;

    .line 531
    invoke-virtual {p0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 534
    :cond_1
    invoke-virtual {v10}, Landroid/content/res/TypedArray;->recycle()V

    move v1, v8

    move v2, v9

    .line 537
    :cond_2
    new-instance v3, Lcom/mobeta/android/dslv/p;

    invoke-direct {v3, p0}, Lcom/mobeta/android/dslv/p;-><init>(Lcom/mobeta/android/dslv/DragSortListView;)V

    iput-object v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->z:Lcom/mobeta/android/dslv/p;

    .line 539
    if-lez v2, :cond_3

    .line 541
    new-instance v3, Lcom/mobeta/android/dslv/b;

    const/high16 v4, 0x3f000000    # 0.5f

    invoke-direct {v3, p0, v4, v2}, Lcom/mobeta/android/dslv/b;-><init>(Lcom/mobeta/android/dslv/DragSortListView;FI)V

    iput-object v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->ad:Lcom/mobeta/android/dslv/b;

    .line 544
    :cond_3
    if-lez v1, :cond_4

    .line 545
    new-instance v2, Lcom/mobeta/android/dslv/m;

    const/high16 v3, 0x3f000000    # 0.5f

    invoke-direct {v2, p0, v3, v1}, Lcom/mobeta/android/dslv/m;-><init>(Lcom/mobeta/android/dslv/DragSortListView;FI)V

    iput-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->ae:Lcom/mobeta/android/dslv/m;

    .line 548
    :cond_4
    const-wide/16 v1, 0x0

    const-wide/16 v3, 0x0

    const/4 v5, 0x3

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    invoke-static/range {v1 .. v14}, Landroid/view/MotionEvent;->obtain(JJIFFFFIFFII)Landroid/view/MotionEvent;

    move-result-object v1

    iput-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->R:Landroid/view/MotionEvent;

    .line 552
    new-instance v1, Lcom/mobeta/android/dslv/k;

    invoke-direct {v1, p0}, Lcom/mobeta/android/dslv/k;-><init>(Lcom/mobeta/android/dslv/DragSortListView;)V

    iput-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->f:Landroid/database/DataSetObserver;

    .line 569
    return-void

    .line 473
    :cond_5
    const/4 v1, 0x0

    goto/16 :goto_0
.end method

.method static synthetic a(Lcom/mobeta/android/dslv/DragSortListView;)F
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->I:F

    return v0
.end method

.method static synthetic a(Lcom/mobeta/android/dslv/DragSortListView;F)F
    .locals 0

    .prologue
    .line 59
    iput p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->ag:F

    return p1
.end method

.method private a(II)I
    .locals 6

    .prologue
    .line 916
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeaderViewsCount()I

    move-result v0

    .line 917
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFooterViewsCount()I

    move-result v1

    .line 923
    if-le p1, v0, :cond_0

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getCount()I

    move-result v0

    sub-int/2addr v0, v1

    if-lt p1, v0, :cond_1

    :cond_0
    move v0, p2

    .line 970
    :goto_0
    return v0

    .line 927
    :cond_1
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getDividerHeight()I

    move-result v0

    .line 931
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->u:I

    sub-int/2addr v1, v2

    .line 932
    invoke-direct {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->d(I)I

    move-result v2

    .line 933
    invoke-direct {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->b(I)I

    move-result v3

    .line 938
    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    iget v5, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-gt v4, v5, :cond_5

    .line 941
    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-ne p1, v4, :cond_4

    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    iget v5, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-eq v4, v5, :cond_4

    .line 942
    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-ne p1, v4, :cond_3

    .line 943
    add-int v1, p2, v3

    iget v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    sub-int p2, v1, v3

    .line 964
    :cond_2
    :goto_1
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-gt p1, v1, :cond_7

    .line 965
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    sub-int v0, v1, v0

    add-int/lit8 v1, p1, -0x1

    invoke-direct {p0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->d(I)I

    move-result v1

    sub-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x2

    add-int/2addr v0, p2

    goto :goto_0

    .line 945
    :cond_3
    sub-int/2addr v3, v2

    .line 946
    add-int/2addr v3, p2

    sub-int p2, v3, v1

    .line 947
    goto :goto_1

    .line 948
    :cond_4
    iget v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-le p1, v3, :cond_2

    iget v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-gt p1, v3, :cond_2

    .line 949
    sub-int/2addr p2, v1

    goto :goto_1

    .line 955
    :cond_5
    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-le p1, v4, :cond_6

    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    if-gt p1, v4, :cond_6

    .line 956
    add-int/2addr p2, v1

    goto :goto_1

    .line 957
    :cond_6
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-ne p1, v1, :cond_2

    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-eq v1, v4, :cond_2

    .line 958
    sub-int v1, v3, v2

    .line 959
    add-int/2addr p2, v1

    goto :goto_1

    .line 967
    :cond_7
    sub-int v0, v2, v0

    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    sub-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x2

    add-int/2addr v0, p2

    goto :goto_0
.end method

.method static synthetic a(Lcom/mobeta/android/dslv/DragSortListView;I)I
    .locals 0

    .prologue
    .line 59
    iput p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    return p1
.end method

.method static synthetic a(Lcom/mobeta/android/dslv/DragSortListView;II)I
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0, p1, p2}, Lcom/mobeta/android/dslv/DragSortListView;->a(II)I

    move-result v0

    return v0
.end method

.method private a(IF)V
    .locals 3

    .prologue
    const/4 v2, 0x4

    .line 1414
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    if-ne v0, v2, :cond_3

    .line 1416
    :cond_0
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    if-nez v0, :cond_1

    .line 1418
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeaderViewsCount()I

    move-result v0

    add-int/2addr v0, p1

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    .line 1419
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    .line 1420
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    .line 1421
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->i:I

    .line 1422
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v1

    sub-int/2addr v0, v1

    invoke-virtual {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 1423
    if-eqz v0, :cond_1

    .line 1424
    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 1428
    :cond_1
    const/4 v0, 0x1

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    .line 1429
    iput p2, p0, Lcom/mobeta/android/dslv/DragSortListView;->ag:F

    .line 1431
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->P:Z

    if-eqz v0, :cond_2

    .line 1432
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->S:I

    packed-switch v0, :pswitch_data_0

    .line 1442
    :cond_2
    :goto_0
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ad:Lcom/mobeta/android/dslv/b;

    if-eqz v0, :cond_4

    .line 1443
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ad:Lcom/mobeta/android/dslv/b;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/b;->c()V

    .line 1448
    :cond_3
    :goto_1
    return-void

    .line 1434
    :pswitch_0
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->R:Landroid/view/MotionEvent;

    invoke-super {p0, v0}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    goto :goto_0

    .line 1437
    :pswitch_1
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->R:Landroid/view/MotionEvent;

    invoke-super {p0, v0}, Landroid/widget/ListView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    goto :goto_0

    .line 1445
    :cond_4
    invoke-direct {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->c(I)V

    goto :goto_1

    .line 1432
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private a(ILandroid/graphics/Canvas;)V
    .locals 7

    .prologue
    .line 752
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getDivider()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 753
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getDividerHeight()I

    move-result v3

    .line 756
    if-eqz v2, :cond_0

    if-eqz v3, :cond_0

    .line 757
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v0

    sub-int v0, p1, v0

    invoke-virtual {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 759
    if-eqz v0, :cond_0

    .line 760
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingLeft()I

    move-result v4

    .line 761
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getWidth()I

    move-result v1

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingRight()I

    move-result v5

    sub-int v5, v1, v5

    .line 765
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    move-result v1

    .line 767
    iget v6, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-le p1, v6, :cond_1

    .line 768
    invoke-virtual {v0}, Landroid/view/ViewGroup;->getTop()I

    move-result v0

    add-int/2addr v1, v0

    .line 769
    add-int v0, v1, v3

    .line 777
    :goto_0
    invoke-virtual {p2}, Landroid/graphics/Canvas;->save()I

    .line 778
    invoke-virtual {p2, v4, v1, v5, v0}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 779
    invoke-virtual {v2, v4, v1, v5, v0}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 780
    invoke-virtual {v2, p2}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 781
    invoke-virtual {p2}, Landroid/graphics/Canvas;->restore()V

    .line 784
    :cond_0
    return-void

    .line 771
    :cond_1
    invoke-virtual {v0}, Landroid/view/ViewGroup;->getBottom()I

    move-result v0

    sub-int/2addr v0, v1

    .line 772
    sub-int v1, v0, v3

    goto :goto_0
.end method

.method private a(ILandroid/view/View;Z)V
    .locals 3

    .prologue
    .line 1886
    invoke-virtual {p2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 1888
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-eq p1, v0, :cond_5

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    if-eq p1, v0, :cond_5

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-eq p1, v0, :cond_5

    .line 1889
    const/4 v0, -0x2

    .line 1894
    :goto_0
    iget v2, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-eq v0, v2, :cond_0

    .line 1895
    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 1896
    invoke-virtual {p2, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1900
    :cond_0
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    if-eq p1, v0, :cond_1

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-ne p1, v0, :cond_2

    .line 1901
    :cond_1
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-ge p1, v0, :cond_6

    move-object v0, p2

    .line 1902
    check-cast v0, Lcom/mobeta/android/dslv/DragSortItemView;

    const/16 v1, 0x50

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/DragSortItemView;->setGravity(I)V

    .line 1910
    :cond_2
    :goto_1
    invoke-virtual {p2}, Landroid/view/View;->getVisibility()I

    move-result v1

    .line 1911
    const/4 v0, 0x0

    .line 1913
    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-ne p1, v2, :cond_3

    iget-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    if-eqz v2, :cond_3

    .line 1914
    const/4 v0, 0x4

    .line 1917
    :cond_3
    if-eq v0, v1, :cond_4

    .line 1918
    invoke-virtual {p2, v0}, Landroid/view/View;->setVisibility(I)V

    .line 1920
    :cond_4
    return-void

    .line 1891
    :cond_5
    invoke-direct {p0, p1, p2, p3}, Lcom/mobeta/android/dslv/DragSortListView;->b(ILandroid/view/View;Z)I

    move-result v0

    invoke-direct {p0, p1, v0}, Lcom/mobeta/android/dslv/DragSortListView;->b(II)I

    move-result v0

    goto :goto_0

    .line 1903
    :cond_6
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-le p1, v0, :cond_2

    move-object v0, p2

    .line 1904
    check-cast v0, Lcom/mobeta/android/dslv/DragSortItemView;

    const/16 v1, 0x30

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/DragSortItemView;->setGravity(I)V

    goto :goto_1
.end method

.method private a(Landroid/view/MotionEvent;)V
    .locals 2

    .prologue
    .line 1675
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    and-int/lit16 v0, v0, 0xff

    .line 1676
    if-eqz v0, :cond_0

    .line 1677
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->L:I

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->M:I

    .line 1680
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    float-to-int v1, v1

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->K:I

    .line 1681
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    float-to-int v1, v1

    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->L:I

    .line 1682
    if-nez v0, :cond_1

    .line 1683
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->L:I

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->M:I

    .line 1686
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    .line 1687
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    .line 1688
    return-void
.end method

.method private a(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 2097
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 2098
    if-nez v0, :cond_0

    .line 2099
    new-instance v0, Landroid/widget/AbsListView$LayoutParams;

    const/4 v1, -0x1

    const/4 v2, -0x2

    invoke-direct {v0, v1, v2}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    .line 2100
    invoke-virtual {p1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 2102
    :cond_0
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->x:I

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getListPaddingLeft()I

    move-result v2

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getListPaddingRight()I

    move-result v3

    add-int/2addr v2, v3

    iget v3, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    invoke-static {v1, v2, v3}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v1

    .line 2105
    iget v2, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-lez v2, :cond_1

    .line 2106
    iget v0, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    const/high16 v2, 0x40000000    # 2.0f

    invoke-static {v0, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 2110
    :goto_0
    invoke-virtual {p1, v1, v0}, Landroid/view/View;->measure(II)V

    .line 2111
    return-void

    .line 2108
    :cond_1
    invoke-static {v4, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    goto :goto_0
.end method

.method static synthetic a(Lcom/mobeta/android/dslv/DragSortListView;ILandroid/view/View;Z)V
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/mobeta/android/dslv/DragSortListView;->a(ILandroid/view/View;Z)V

    return-void
.end method

.method static synthetic a(Lcom/mobeta/android/dslv/DragSortListView;Z)V
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->a(Z)V

    return-void
.end method

.method private a(Z)V
    .locals 2

    .prologue
    .line 2306
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v0

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getChildCount()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    .line 2307
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getChildCount()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    invoke-virtual {p0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 2309
    if-nez v1, :cond_0

    .line 2314
    :goto_0
    return-void

    .line 2313
    :cond_0
    invoke-direct {p0, v0, v1, p1}, Lcom/mobeta/android/dslv/DragSortListView;->c(ILandroid/view/View;Z)V

    goto :goto_0
.end method

.method static synthetic b(Lcom/mobeta/android/dslv/DragSortListView;F)F
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ag:F

    add-float/2addr v0, p1

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ag:F

    return v0
.end method

.method private b(I)I
    .locals 1

    .prologue
    .line 834
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v0

    sub-int v0, p1, v0

    invoke-virtual {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 836
    if-eqz v0, :cond_0

    .line 838
    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    .line 842
    :goto_0
    return v0

    :cond_0
    invoke-direct {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->d(I)I

    move-result v0

    invoke-direct {p0, p1, v0}, Lcom/mobeta/android/dslv/DragSortListView;->b(II)I

    move-result v0

    goto :goto_0
.end method

.method private b(II)I
    .locals 4

    .prologue
    .line 2009
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getDividerHeight()I

    .line 2011
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->l:Z

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-eq v0, v1, :cond_1

    const/4 v0, 0x1

    .line 2012
    :goto_0
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->u:I

    sub-int/2addr v1, v2

    .line 2013
    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->U:F

    int-to-float v3, v1

    mul-float/2addr v2, v3

    float-to-int v2, v2

    .line 2017
    iget v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-ne p1, v3, :cond_5

    .line 2018
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    iget v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    if-ne v1, v3, :cond_3

    .line 2019
    if-eqz v0, :cond_2

    .line 2020
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->u:I

    add-int p2, v2, v0

    .line 2043
    :cond_0
    :goto_1
    return p2

    .line 2011
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 2022
    :cond_2
    iget p2, p0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    goto :goto_1

    .line 2024
    :cond_3
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-ne v0, v1, :cond_4

    .line 2026
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    sub-int p2, v0, v2

    goto :goto_1

    .line 2028
    :cond_4
    iget p2, p0, Lcom/mobeta/android/dslv/DragSortListView;->u:I

    goto :goto_1

    .line 2030
    :cond_5
    iget v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    if-ne p1, v3, :cond_7

    .line 2031
    if-eqz v0, :cond_6

    .line 2032
    add-int/2addr p2, v2

    goto :goto_1

    .line 2034
    :cond_6
    add-int/2addr p2, v1

    goto :goto_1

    .line 2036
    :cond_7
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-ne p1, v0, :cond_0

    .line 2038
    add-int v0, p2, v1

    sub-int p2, v0, v2

    goto :goto_1
.end method

.method private b(ILandroid/view/View;Z)I
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 1974
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-ne p1, v1, :cond_1

    .line 2000
    :cond_0
    :goto_0
    return v0

    .line 1979
    :cond_1
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeaderViewsCount()I

    move-result v1

    if-lt p1, v1, :cond_2

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getCount()I

    move-result v1

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFooterViewsCount()I

    move-result v2

    sub-int/2addr v1, v2

    if-lt p1, v1, :cond_3

    .line 1985
    :cond_2
    :goto_1
    invoke-virtual {p2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 1987
    if-eqz v0, :cond_4

    .line 1988
    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-lez v1, :cond_4

    .line 1989
    iget v0, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_0

    .line 1982
    :cond_3
    check-cast p2, Landroid/view/ViewGroup;

    invoke-virtual {p2, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object p2

    goto :goto_1

    .line 1993
    :cond_4
    invoke-virtual {p2}, Landroid/view/View;->getHeight()I

    move-result v0

    .line 1995
    if-eqz v0, :cond_5

    if-eqz p3, :cond_0

    .line 1996
    :cond_5
    invoke-direct {p0, p2}, Lcom/mobeta/android/dslv/DragSortListView;->a(Landroid/view/View;)V

    .line 1997
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    goto :goto_0
.end method

.method static synthetic b(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    return v0
.end method

.method static synthetic b(Lcom/mobeta/android/dslv/DragSortListView;I)I
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->b(I)I

    move-result v0

    return v0
.end method

.method static synthetic b(Lcom/mobeta/android/dslv/DragSortListView;ILandroid/view/View;Z)I
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/mobeta/android/dslv/DragSortListView;->b(ILandroid/view/View;Z)I

    move-result v0

    return v0
.end method

.method static synthetic b(Lcom/mobeta/android/dslv/DragSortListView;Z)Z
    .locals 0

    .prologue
    .line 59
    iput-boolean p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->aa:Z

    return p1
.end method

.method private b(ZF)Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 1587
    iget-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    if-eqz v1, :cond_3

    .line 1588
    iget-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->z:Lcom/mobeta/android/dslv/p;

    invoke-virtual {v1, v0}, Lcom/mobeta/android/dslv/p;->a(Z)V

    .line 1590
    if-eqz p1, :cond_1

    .line 1591
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeaderViewsCount()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-direct {p0, v1, p2}, Lcom/mobeta/android/dslv/DragSortListView;->a(IF)V

    .line 1600
    :goto_0
    iget-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->W:Z

    if-eqz v1, :cond_0

    .line 1601
    iget-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->Z:Lcom/mobeta/android/dslv/f;

    invoke-virtual {v1}, Lcom/mobeta/android/dslv/f;->c()V

    .line 1607
    :cond_0
    :goto_1
    return v0

    .line 1593
    :cond_1
    iget-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->ae:Lcom/mobeta/android/dslv/m;

    if-eqz v1, :cond_2

    .line 1594
    iget-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->ae:Lcom/mobeta/android/dslv/m;

    invoke-virtual {v1}, Lcom/mobeta/android/dslv/m;->c()V

    goto :goto_0

    .line 1596
    :cond_2
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->e()V

    goto :goto_0

    .line 1607
    :cond_3
    const/4 v0, 0x0

    goto :goto_1
.end method

.method static synthetic c(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->w:I

    return v0
.end method

.method static synthetic c(Lcom/mobeta/android/dslv/DragSortListView;I)I
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->d(I)I

    move-result v0

    return v0
.end method

.method private c(I)V
    .locals 1

    .prologue
    .line 1528
    const/4 v0, 0x1

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    .line 1531
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->k()V

    .line 1537
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->f()V

    .line 1538
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->d()V

    .line 1541
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->P:Z

    if-eqz v0, :cond_0

    .line 1542
    const/4 v0, 0x3

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    .line 1546
    :goto_0
    return-void

    .line 1544
    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    goto :goto_0
.end method

.method private c(ILandroid/view/View;Z)V
    .locals 17

    .prologue
    .line 2317
    const/4 v2, 0x1

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->aa:Z

    .line 2319
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->Q:Lcom/mobeta/android/dslv/l;

    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->c:Landroid/graphics/Point;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->K:I

    move-object/from16 v0, p0

    iget v4, v0, Lcom/mobeta/android/dslv/DragSortListView;->L:I

    invoke-virtual {v2, v3, v4}, Landroid/graphics/Point;->set(II)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->Q:Lcom/mobeta/android/dslv/l;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    invoke-virtual {v2, v3}, Lcom/mobeta/android/dslv/l;->a(Landroid/graphics/Point;)V

    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->x:I

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iget v4, v3, Landroid/graphics/Point;->y:I

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingLeft()I

    move-result v3

    move-object/from16 v0, p0

    iget v5, v0, Lcom/mobeta/android/dslv/DragSortListView;->N:I

    and-int/lit8 v5, v5, 0x1

    if-nez v5, :cond_f

    if-le v2, v3, :cond_f

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iput v3, v2, Landroid/graphics/Point;->x:I

    :cond_1
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeaderViewsCount()I

    move-result v3

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFooterViewsCount()I

    move-result v5

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v6

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getLastVisiblePosition()I

    move-result v7

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingTop()I

    move-result v2

    if-ge v6, v3, :cond_2

    sub-int v2, v3, v6

    add-int/lit8 v2, v2, -0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v2

    :cond_2
    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->N:I

    and-int/lit8 v3, v3, 0x8

    if-nez v3, :cond_3

    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-gt v6, v3, :cond_3

    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    sub-int/2addr v3, v6

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v3

    invoke-static {v3, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    :cond_3
    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeight()I

    move-result v3

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingBottom()I

    move-result v8

    sub-int/2addr v3, v8

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getCount()I

    move-result v8

    sub-int/2addr v8, v5

    add-int/lit8 v8, v8, -0x1

    if-lt v7, v8, :cond_4

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getCount()I

    move-result v3

    sub-int/2addr v3, v5

    add-int/lit8 v3, v3, -0x1

    sub-int/2addr v3, v6

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getBottom()I

    move-result v3

    :cond_4
    move-object/from16 v0, p0

    iget v5, v0, Lcom/mobeta/android/dslv/DragSortListView;->N:I

    and-int/lit8 v5, v5, 0x4

    if-nez v5, :cond_5

    move-object/from16 v0, p0

    iget v5, v0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-lt v7, v5, :cond_5

    move-object/from16 v0, p0

    iget v5, v0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    sub-int/2addr v5, v6

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v5

    invoke-static {v5, v3}, Ljava/lang/Math;->min(II)I

    move-result v3

    :cond_5
    if-ge v4, v2, :cond_10

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iput v2, v3, Landroid/graphics/Point;->y:I

    :cond_6
    :goto_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->w:I

    add-int/2addr v2, v3

    move-object/from16 v0, p0

    iput v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    .line 2321
    move-object/from16 v0, p0

    iget v9, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    .line 2322
    move-object/from16 v0, p0

    iget v10, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    .line 2324
    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v4

    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    sub-int v2, v3, v4

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    if-nez v2, :cond_7

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getChildCount()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    add-int v3, v4, v2

    sub-int v2, v3, v4

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    :cond_7
    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v5

    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    move-result v2

    move-object/from16 v0, p0

    invoke-direct {v0, v3, v5}, Lcom/mobeta/android/dslv/DragSortListView;->a(II)I

    move-result v4

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getDividerHeight()I

    move-result v7

    move-object/from16 v0, p0

    iget v6, v0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    if-ge v6, v4, :cond_12

    move v2, v3

    move v3, v4

    :goto_2
    if-ltz v2, :cond_8

    add-int/lit8 v2, v2, -0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/mobeta/android/dslv/DragSortListView;->b(I)I

    move-result v4

    if-nez v2, :cond_11

    sub-int/2addr v5, v7

    sub-int v4, v5, v4

    :cond_8
    :goto_3
    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeaderViewsCount()I

    move-result v5

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFooterViewsCount()I

    move-result v7

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget v8, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    move-object/from16 v0, p0

    iget v11, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    move-object/from16 v0, p0

    iget v12, v0, Lcom/mobeta/android/dslv/DragSortListView;->U:F

    move-object/from16 v0, p0

    iget-boolean v13, v0, Lcom/mobeta/android/dslv/DragSortListView;->l:Z

    if-eqz v13, :cond_17

    sub-int v13, v4, v3

    invoke-static {v13}, Ljava/lang/Math;->abs(I)I

    move-result v13

    move-object/from16 v0, p0

    iget v14, v0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    if-ge v14, v4, :cond_14

    :goto_4
    const/high16 v14, 0x3f000000    # 0.5f

    move-object/from16 v0, p0

    iget v15, v0, Lcom/mobeta/android/dslv/DragSortListView;->T:F

    mul-float/2addr v14, v15

    int-to-float v13, v13

    mul-float/2addr v13, v14

    float-to-int v13, v13

    int-to-float v14, v13

    add-int/2addr v3, v13

    sub-int v13, v4, v13

    move-object/from16 v0, p0

    iget v15, v0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    if-ge v15, v3, :cond_15

    add-int/lit8 v4, v2, -0x1

    move-object/from16 v0, p0

    iput v4, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    move-object/from16 v0, p0

    iput v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    const/high16 v4, 0x3f000000    # 0.5f

    move-object/from16 v0, p0

    iget v13, v0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    sub-int/2addr v3, v13

    int-to-float v3, v3

    mul-float/2addr v3, v4

    div-float/2addr v3, v14

    move-object/from16 v0, p0

    iput v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->U:F

    :goto_5
    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    if-ge v3, v5, :cond_18

    move-object/from16 v0, p0

    iput v5, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    move-object/from16 v0, p0

    iput v5, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    move v2, v5

    :cond_9
    :goto_6
    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    if-ne v3, v8, :cond_a

    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-ne v3, v11, :cond_a

    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->U:F

    cmpl-float v3, v3, v12

    if-eqz v3, :cond_21

    :cond_a
    const/4 v3, 0x1

    :goto_7
    move-object/from16 v0, p0

    iget v4, v0, Lcom/mobeta/android/dslv/DragSortListView;->i:I

    if-eq v2, v4, :cond_20

    move-object/from16 v0, p0

    iput v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->i:I

    const/4 v3, 0x1

    move v8, v3

    .line 2326
    :goto_8
    if-eqz v8, :cond_c

    .line 2327
    invoke-direct/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->i()V

    .line 2328
    const/4 v6, 0x0

    invoke-direct/range {p0 .. p1}, Lcom/mobeta/android/dslv/DragSortListView;->d(I)I

    move-result v4

    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getHeight()I

    move-result v3

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v0, v1, v4}, Lcom/mobeta/android/dslv/DragSortListView;->b(II)I

    move-result v5

    move-object/from16 v0, p0

    iget v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    move/from16 v0, p1

    if-eq v0, v2, :cond_1f

    sub-int v2, v3, v4

    sub-int v4, v5, v4

    :goto_9
    move-object/from16 v0, p0

    iget v7, v0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    move-object/from16 v0, p0

    iget v11, v0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    move-object/from16 v0, p0

    iget v12, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    if-eq v11, v12, :cond_b

    move-object/from16 v0, p0

    iget v11, v0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    move-object/from16 v0, p0

    iget v12, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    if-eq v11, v12, :cond_b

    move-object/from16 v0, p0

    iget v11, v0, Lcom/mobeta/android/dslv/DragSortListView;->u:I

    sub-int/2addr v7, v11

    :cond_b
    move/from16 v0, p1

    if-gt v0, v9, :cond_19

    move-object/from16 v0, p0

    iget v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    move/from16 v0, p1

    if-le v0, v2, :cond_1e

    sub-int v2, v7, v4

    add-int/lit8 v2, v2, 0x0

    .line 2331
    :goto_a
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTop()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingTop()I

    move-result v3

    sub-int/2addr v2, v3

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-virtual {v0, v1, v2}, Lcom/mobeta/android/dslv/DragSortListView;->setSelectionFromTop(II)V

    .line 2332
    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->layoutChildren()V

    .line 2335
    :cond_c
    if-nez v8, :cond_d

    if-eqz p3, :cond_e

    .line 2336
    :cond_d
    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->invalidate()V

    .line 2339
    :cond_e
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->aa:Z

    .line 2340
    return-void

    .line 2319
    :cond_f
    move-object/from16 v0, p0

    iget v5, v0, Lcom/mobeta/android/dslv/DragSortListView;->N:I

    and-int/lit8 v5, v5, 0x2

    if-nez v5, :cond_1

    if-ge v2, v3, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iput v3, v2, Landroid/graphics/Point;->x:I

    goto/16 :goto_0

    :cond_10
    move-object/from16 v0, p0

    iget v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    add-int/2addr v2, v4

    if-le v2, v3, :cond_6

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    move-object/from16 v0, p0

    iget v4, v0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    sub-int/2addr v3, v4

    iput v3, v2, Landroid/graphics/Point;->y:I

    goto/16 :goto_1

    .line 2324
    :cond_11
    add-int/2addr v4, v7

    sub-int/2addr v5, v4

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v5}, Lcom/mobeta/android/dslv/DragSortListView;->a(II)I

    move-result v4

    move-object/from16 v0, p0

    iget v6, v0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    if-ge v6, v4, :cond_8

    move v3, v4

    goto/16 :goto_2

    :cond_12
    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getCount()I

    move-result v8

    move v6, v5

    move v5, v2

    move v2, v3

    move v3, v4

    :goto_b
    if-ge v2, v8, :cond_8

    add-int/lit8 v4, v8, -0x1

    if-ne v2, v4, :cond_13

    add-int v4, v6, v7

    add-int/2addr v4, v5

    goto/16 :goto_3

    :cond_13
    add-int v4, v7, v5

    add-int/2addr v6, v4

    add-int/lit8 v4, v2, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/mobeta/android/dslv/DragSortListView;->b(I)I

    move-result v5

    add-int/lit8 v4, v2, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v6}, Lcom/mobeta/android/dslv/DragSortListView;->a(II)I

    move-result v4

    move-object/from16 v0, p0

    iget v11, v0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    if-lt v11, v4, :cond_8

    add-int/lit8 v2, v2, 0x1

    move v3, v4

    goto :goto_b

    :cond_14
    move/from16 v16, v3

    move v3, v4

    move/from16 v4, v16

    goto/16 :goto_4

    :cond_15
    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    if-ge v3, v13, :cond_16

    move-object/from16 v0, p0

    iput v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    move-object/from16 v0, p0

    iput v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    goto/16 :goto_5

    :cond_16
    move-object/from16 v0, p0

    iput v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    add-int/lit8 v3, v2, 0x1

    move-object/from16 v0, p0

    iput v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    const/high16 v3, 0x3f000000    # 0.5f

    const/high16 v13, 0x3f800000    # 1.0f

    move-object/from16 v0, p0

    iget v15, v0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    sub-int/2addr v4, v15

    int-to-float v4, v4

    div-float/2addr v4, v14

    add-float/2addr v4, v13

    mul-float/2addr v3, v4

    move-object/from16 v0, p0

    iput v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->U:F

    goto/16 :goto_5

    :cond_17
    move-object/from16 v0, p0

    iput v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    move-object/from16 v0, p0

    iput v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    goto/16 :goto_5

    :cond_18
    move-object/from16 v0, p0

    iget v3, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getCount()I

    move-result v4

    sub-int/2addr v4, v7

    if-lt v3, v4, :cond_9

    invoke-virtual/range {p0 .. p0}, Lcom/mobeta/android/dslv/DragSortListView;->getCount()I

    move-result v2

    sub-int/2addr v2, v7

    add-int/lit8 v2, v2, -0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    move-object/from16 v0, p0

    iput v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    goto/16 :goto_6

    .line 2328
    :cond_19
    move/from16 v0, p1

    if-ne v0, v10, :cond_1c

    move-object/from16 v0, p0

    iget v4, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    move/from16 v0, p1

    if-gt v0, v4, :cond_1a

    sub-int/2addr v2, v7

    add-int/lit8 v2, v2, 0x0

    goto/16 :goto_a

    :cond_1a
    move-object/from16 v0, p0

    iget v4, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    move/from16 v0, p1

    if-ne v0, v4, :cond_1b

    sub-int v2, v3, v5

    add-int/lit8 v2, v2, 0x0

    goto/16 :goto_a

    :cond_1b
    add-int/lit8 v2, v2, 0x0

    goto/16 :goto_a

    :cond_1c
    move-object/from16 v0, p0

    iget v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    move/from16 v0, p1

    if-gt v0, v2, :cond_1d

    rsub-int/lit8 v2, v7, 0x0

    goto/16 :goto_a

    :cond_1d
    move-object/from16 v0, p0

    iget v2, v0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    move/from16 v0, p1

    if-ne v0, v2, :cond_1e

    rsub-int/lit8 v2, v4, 0x0

    goto/16 :goto_a

    :cond_1e
    move v2, v6

    goto/16 :goto_a

    :cond_1f
    move v2, v3

    move v4, v5

    goto/16 :goto_9

    :cond_20
    move v8, v3

    goto/16 :goto_8

    :cond_21
    move v3, v6

    goto/16 :goto_7
.end method

.method static synthetic c(Lcom/mobeta/android/dslv/DragSortListView;ILandroid/view/View;Z)V
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/mobeta/android/dslv/DragSortListView;->c(ILandroid/view/View;Z)V

    return-void
.end method

.method private d(I)I
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    .line 1923
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-ne p1, v1, :cond_1

    .line 1969
    :cond_0
    :goto_0
    return v0

    .line 1927
    :cond_1
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v1

    sub-int v1, p1, v1

    invoke-virtual {p0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1929
    if-eqz v1, :cond_2

    .line 1932
    invoke-direct {p0, p1, v1, v0}, Lcom/mobeta/android/dslv/DragSortListView;->b(ILandroid/view/View;Z)I

    move-result v0

    goto :goto_0

    .line 1936
    :cond_2
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ac:Lcom/mobeta/android/dslv/d;

    invoke-virtual {v0, p1}, Lcom/mobeta/android/dslv/d;->a(I)I

    move-result v0

    .line 1937
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 1942
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 1943
    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->getItemViewType(I)I

    move-result v1

    .line 1946
    invoke-interface {v0}, Landroid/widget/ListAdapter;->getViewTypeCount()I

    move-result v2

    .line 1947
    iget-object v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->y:[Landroid/view/View;

    array-length v3, v3

    if-eq v2, v3, :cond_3

    .line 1948
    new-array v2, v2, [Landroid/view/View;

    iput-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->y:[Landroid/view/View;

    .line 1951
    :cond_3
    if-ltz v1, :cond_5

    .line 1952
    iget-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->y:[Landroid/view/View;

    aget-object v2, v2, v1

    if-nez v2, :cond_4

    .line 1953
    invoke-interface {v0, p1, v4, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 1954
    iget-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->y:[Landroid/view/View;

    aput-object v0, v2, v1

    .line 1964
    :goto_1
    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->b(ILandroid/view/View;Z)I

    move-result v0

    .line 1967
    iget-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->ac:Lcom/mobeta/android/dslv/d;

    invoke-virtual {v1, p1, v0}, Lcom/mobeta/android/dslv/d;->a(II)V

    goto :goto_0

    .line 1956
    :cond_4
    iget-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->y:[Landroid/view/View;

    aget-object v1, v2, v1

    invoke-interface {v0, p1, v1, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    goto :goto_1

    .line 1960
    :cond_5
    invoke-interface {v0, p1, v4, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    goto :goto_1
.end method

.method static synthetic d(Lcom/mobeta/android/dslv/DragSortListView;)Landroid/graphics/Point;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    return-object v0
.end method

.method private d()V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 1488
    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    .line 1489
    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    .line 1490
    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    .line 1491
    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->i:I

    .line 1492
    return-void
.end method

.method static synthetic e(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->L:I

    return v0
.end method

.method private e()V
    .locals 4

    .prologue
    .line 1497
    const/4 v0, 0x2

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    .line 1499
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->q:Lcom/mobeta/android/dslv/i;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->i:I

    if-ltz v0, :cond_0

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->i:I

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getCount()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 1500
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeaderViewsCount()I

    move-result v0

    .line 1501
    iget-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->q:Lcom/mobeta/android/dslv/i;

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    sub-int/2addr v2, v0

    iget v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->i:I

    sub-int v0, v3, v0

    invoke-interface {v1, v2, v0}, Lcom/mobeta/android/dslv/i;->drop(II)V

    .line 1504
    :cond_0
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->k()V

    .line 1506
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->f()V

    .line 1507
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->d()V

    .line 1508
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->i()V

    .line 1511
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->P:Z

    if-eqz v0, :cond_1

    .line 1512
    const/4 v0, 0x3

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    .line 1516
    :goto_0
    return-void

    .line 1514
    :cond_1
    const/4 v0, 0x0

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    goto :goto_0
.end method

.method static synthetic f(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->i:I

    return v0
.end method

.method private f()V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 1549
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v1

    .line 1551
    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-ge v2, v1, :cond_1

    .line 1554
    invoke-virtual {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 1556
    if-eqz v2, :cond_0

    .line 1557
    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v0

    .line 1560
    :cond_0
    add-int/lit8 v1, v1, -0x1

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingTop()I

    move-result v2

    sub-int/2addr v0, v2

    invoke-virtual {p0, v1, v0}, Lcom/mobeta/android/dslv/DragSortListView;->setSelectionFromTop(II)V

    .line 1562
    :cond_1
    return-void
.end method

.method static synthetic g(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    return v0
.end method

.method private g()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1664
    iput v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->S:I

    .line 1665
    iput-boolean v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->P:Z

    .line 1666
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    .line 1667
    iput v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    .line 1669
    :cond_0
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->g:F

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->h:F

    .line 1670
    iput-boolean v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->ah:Z

    .line 1671
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ac:Lcom/mobeta/android/dslv/d;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/d;->a()V

    .line 1672
    return-void
.end method

.method static synthetic h(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->u:I

    return v0
.end method

.method private h()V
    .locals 6

    .prologue
    .line 1836
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingTop()I

    move-result v0

    .line 1837
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeight()I

    move-result v1

    sub-int/2addr v1, v0

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingBottom()I

    move-result v2

    sub-int/2addr v1, v2

    .line 1838
    int-to-float v2, v1

    .line 1840
    int-to-float v3, v0

    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->A:F

    mul-float/2addr v4, v2

    add-float/2addr v3, v4

    iput v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->F:F

    .line 1841
    int-to-float v3, v0

    const/high16 v4, 0x3f800000    # 1.0f

    iget v5, p0, Lcom/mobeta/android/dslv/DragSortListView;->B:F

    sub-float/2addr v4, v5

    mul-float/2addr v2, v4

    add-float/2addr v2, v3

    iput v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->E:F

    .line 1843
    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->F:F

    float-to-int v2, v2

    iput v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->C:I

    .line 1844
    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->E:F

    float-to-int v2, v2

    iput v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->D:I

    .line 1846
    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->F:F

    int-to-float v3, v0

    sub-float/2addr v2, v3

    iput v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->G:F

    .line 1847
    add-int/2addr v0, v1

    int-to-float v0, v0

    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->E:F

    sub-float/2addr v0, v1

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->H:F

    .line 1848
    return-void
.end method

.method static synthetic i(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    return v0
.end method

.method private i()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 1857
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v1

    .line 1858
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getLastVisiblePosition()I

    move-result v2

    .line 1860
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeaderViewsCount()I

    move-result v0

    sub-int/2addr v0, v1

    invoke-static {v5, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 1861
    sub-int/2addr v2, v1

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFooterViewsCount()I

    move-result v4

    sub-int/2addr v3, v4

    sub-int/2addr v3, v1

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 1863
    :goto_0
    if-gt v0, v2, :cond_1

    .line 1864
    invoke-virtual {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 1865
    if-eqz v3, :cond_0

    .line 1866
    add-int v4, v1, v0

    invoke-direct {p0, v4, v3, v5}, Lcom/mobeta/android/dslv/DragSortListView;->a(ILandroid/view/View;Z)V

    .line 1863
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1869
    :cond_1
    return-void
.end method

.method private j()V
    .locals 1

    .prologue
    .line 2114
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 2115
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-direct {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->a(Landroid/view/View;)V

    .line 2116
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    .line 2117
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->v:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->w:I

    .line 2119
    :cond_0
    return-void
.end method

.method static synthetic j(Lcom/mobeta/android/dslv/DragSortListView;)V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->e()V

    return-void
.end method

.method static synthetic k(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    return v0
.end method

.method private k()V
    .locals 2

    .prologue
    .line 2408
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 2409
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 2410
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->Q:Lcom/mobeta/android/dslv/l;

    if-eqz v0, :cond_0

    .line 2411
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->Q:Lcom/mobeta/android/dslv/l;

    iget-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/l;->a(Landroid/view/View;)V

    .line 2413
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    .line 2414
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->invalidate()V

    .line 2416
    :cond_1
    return-void
.end method

.method static synthetic l(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    return v0
.end method

.method static synthetic m(Lcom/mobeta/android/dslv/DragSortListView;)Z
    .locals 1

    .prologue
    .line 59
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->af:Z

    return v0
.end method

.method static synthetic n(Lcom/mobeta/android/dslv/DragSortListView;)F
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ag:F

    return v0
.end method

.method static synthetic o(Lcom/mobeta/android/dslv/DragSortListView;)V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->k()V

    return-void
.end method

.method static synthetic p(Lcom/mobeta/android/dslv/DragSortListView;)V
    .locals 2

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeaderViewsCount()I

    move-result v1

    sub-int/2addr v0, v1

    invoke-direct {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->c(I)V

    return-void
.end method

.method static synthetic q(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    return v0
.end method

.method static synthetic r(Lcom/mobeta/android/dslv/DragSortListView;)F
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->F:F

    return v0
.end method

.method static synthetic s(Lcom/mobeta/android/dslv/DragSortListView;)F
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->G:F

    return v0
.end method

.method static synthetic t(Lcom/mobeta/android/dslv/DragSortListView;)Lcom/mobeta/android/dslv/o;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->J:Lcom/mobeta/android/dslv/o;

    return-object v0
.end method

.method static synthetic u(Lcom/mobeta/android/dslv/DragSortListView;)F
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->E:F

    return v0
.end method

.method static synthetic v(Lcom/mobeta/android/dslv/DragSortListView;)F
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->H:F

    return v0
.end method

.method static synthetic w(Lcom/mobeta/android/dslv/DragSortListView;)I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->M:I

    return v0
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 1473
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 1474
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->z:Lcom/mobeta/android/dslv/p;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/p;->a(Z)V

    .line 1475
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->k()V

    .line 1476
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->d()V

    .line 1477
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->i()V

    .line 1479
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->P:Z

    if-eqz v0, :cond_1

    .line 1480
    const/4 v0, 0x3

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    .line 1485
    :cond_0
    :goto_0
    return-void

    .line 1482
    :cond_1
    const/4 v0, 0x0

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    goto :goto_0
.end method

.method public final a(I)V
    .locals 1

    .prologue
    .line 1402
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->af:Z

    .line 1403
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/mobeta/android/dslv/DragSortListView;->a(IF)V

    .line 1404
    return-void
.end method

.method public final a(IIII)Z
    .locals 5

    .prologue
    const/4 v4, 0x4

    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 2206
    iget-boolean v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->P:Z

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->Q:Lcom/mobeta/android/dslv/l;

    if-nez v2, :cond_1

    .line 2215
    :cond_0
    :goto_0
    return v0

    .line 2210
    :cond_1
    iget-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->Q:Lcom/mobeta/android/dslv/l;

    invoke-virtual {v2, p1}, Lcom/mobeta/android/dslv/l;->c(I)Landroid/view/View;

    move-result-object v2

    .line 2212
    if-eqz v2, :cond_0

    .line 2215
    iget v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    if-nez v3, :cond_0

    iget-boolean v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->P:Z

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    if-nez v3, :cond_0

    if-eqz v2, :cond_0

    iget-boolean v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->s:Z

    if-eqz v3, :cond_0

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    if-eqz v3, :cond_2

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    invoke-interface {v3, v1}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    :cond_2
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeaderViewsCount()I

    move-result v3

    add-int/2addr v3, p1

    iput v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    iput v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    iput v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    iput v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->i:I

    iput v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->N:I

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->N:I

    or-int/2addr v0, p2

    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->N:I

    iput-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->j()V

    iput p3, p0, Lcom/mobeta/android/dslv/DragSortListView;->n:I

    iput p4, p0, Lcom/mobeta/android/dslv/DragSortListView;->o:I

    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->K:I

    iget v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->n:I

    sub-int/2addr v2, v3

    iput v2, v0, Landroid/graphics/Point;->x:I

    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->L:I

    iget v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->o:I

    sub-int/2addr v2, v3

    iput v2, v0, Landroid/graphics/Point;->y:I

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v2

    sub-int/2addr v0, v2

    invoke-virtual {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    :cond_3
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->W:Z

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->Z:Lcom/mobeta/android/dslv/f;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/f;->a()V

    :cond_4
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->S:I

    packed-switch v0, :pswitch_data_0

    :goto_1
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->requestLayout()V

    move v0, v1

    goto :goto_0

    :pswitch_0
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->R:Landroid/view/MotionEvent;

    invoke-super {p0, v0}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    goto :goto_1

    :pswitch_1
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->R:Landroid/view/MotionEvent;

    invoke-super {p0, v0}, Landroid/widget/ListView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    goto :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final a(ZF)Z
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 1582
    iput-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->af:Z

    .line 1583
    invoke-direct {p0, v0, p2}, Lcom/mobeta/android/dslv/DragSortListView;->b(ZF)Z

    move-result v0

    return v0
.end method

.method public final b()Z
    .locals 1

    .prologue
    .line 1691
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ah:Z

    return v0
.end method

.method public final c()Z
    .locals 1

    .prologue
    .line 2494
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->s:Z

    return v0
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v1, 0x0

    .line 788
    invoke-super {p0, p1}, Landroid/widget/ListView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 790
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    if-eqz v0, :cond_1

    .line 792
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-eq v0, v2, :cond_0

    .line 793
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    invoke-direct {p0, v0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->a(ILandroid/graphics/Canvas;)V

    .line 795
    :cond_0
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->j:I

    if-eq v0, v2, :cond_1

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->m:I

    if-eq v0, v2, :cond_1

    .line 796
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->k:I

    invoke-direct {p0, v0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->a(ILandroid/graphics/Canvas;)V

    .line 800
    :cond_1
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    if-eqz v0, :cond_3

    .line 802
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v2

    .line 803
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v4

    .line 805
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iget v0, v0, Landroid/graphics/Point;->x:I

    .line 807
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getWidth()I

    move-result v3

    .line 808
    if-gez v0, :cond_2

    .line 809
    neg-int v0, v0

    .line 811
    :cond_2
    if-ge v0, v3, :cond_4

    .line 812
    sub-int v0, v3, v0

    int-to-float v0, v0

    int-to-float v3, v3

    div-float/2addr v0, v3

    .line 813
    mul-float/2addr v0, v0

    .line 818
    :goto_0
    const/high16 v3, 0x437f0000    # 255.0f

    iget v5, p0, Lcom/mobeta/android/dslv/DragSortListView;->h:F

    mul-float/2addr v3, v5

    mul-float/2addr v0, v3

    float-to-int v5, v0

    .line 820
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 822
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iget v0, v0, Landroid/graphics/Point;->x:I

    int-to-float v0, v0

    iget-object v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->y:I

    int-to-float v3, v3

    invoke-virtual {p1, v0, v3}, Landroid/graphics/Canvas;->translate(FF)V

    .line 823
    invoke-virtual {p1, v6, v6, v2, v4}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 826
    int-to-float v3, v2

    int-to-float v4, v4

    const/16 v6, 0x1f

    move-object v0, p1

    move v2, v1

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Canvas;->saveLayerAlpha(FFFFII)I

    .line 827
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    .line 828
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 829
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 831
    :cond_3
    return-void

    :cond_4
    move v0, v1

    .line 815
    goto :goto_0
.end method

.method protected layoutChildren()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 2136
    invoke-super {p0}, Landroid/widget/ListView;->layoutChildren()V

    .line 2138
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 2139
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->isLayoutRequested()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->e:Z

    if-nez v0, :cond_0

    .line 2143
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->j()V

    .line 2145
    :cond_0
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    iget-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    iget-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    invoke-virtual {v0, v3, v3, v1, v2}, Landroid/view/View;->layout(IIII)V

    .line 2146
    iput-boolean v3, p0, Lcom/mobeta/android/dslv/DragSortListView;->e:Z

    .line 2148
    :cond_1
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 1

    .prologue
    .line 1124
    invoke-super {p0, p1}, Landroid/widget/ListView;->onDraw(Landroid/graphics/Canvas;)V

    .line 1126
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->W:Z

    if-eqz v0, :cond_0

    .line 1127
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->Z:Lcom/mobeta/android/dslv/f;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/f;->b()V

    .line 1129
    :cond_0
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v0, 0x1

    .line 1698
    iget-boolean v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->s:Z

    if-nez v1, :cond_0

    .line 1699
    invoke-super {p0, p1}, Landroid/widget/ListView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 1746
    :goto_0
    return v0

    .line 1702
    :cond_0
    invoke-direct {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->a(Landroid/view/MotionEvent;)V

    .line 1703
    iput-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->O:Z

    .line 1705
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    and-int/lit16 v3, v1, 0xff

    .line 1707
    if-nez v3, :cond_2

    .line 1708
    iget v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    if-eqz v1, :cond_1

    .line 1710
    iput-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ab:Z

    goto :goto_0

    .line 1713
    :cond_1
    iput-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->P:Z

    .line 1719
    :cond_2
    iget-object v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    if-eqz v1, :cond_5

    move v1, v0

    .line 1742
    :goto_1
    if-eq v3, v0, :cond_3

    const/4 v0, 0x3

    if-ne v3, v0, :cond_4

    .line 1743
    :cond_3
    iput-boolean v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->P:Z

    :cond_4
    move v0, v1

    .line 1746
    goto :goto_0

    .line 1723
    :cond_5
    invoke-super {p0, p1}, Landroid/widget/ListView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 1724
    iput-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ah:Z

    move v1, v0

    .line 1728
    :goto_2
    packed-switch v3, :pswitch_data_0

    .line 1734
    :pswitch_0
    if-eqz v1, :cond_6

    .line 1735
    iput v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->S:I

    goto :goto_1

    .line 1731
    :pswitch_1
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->g()V

    goto :goto_1

    .line 1737
    :cond_6
    const/4 v4, 0x2

    iput v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->S:I

    goto :goto_1

    :cond_7
    move v1, v2

    goto :goto_2

    .line 1728
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected onMeasure(II)V
    .locals 1

    .prologue
    .line 2123
    invoke-super {p0, p1, p2}, Landroid/widget/ListView;->onMeasure(II)V

    .line 2125
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 2126
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->isLayoutRequested()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2127
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->j()V

    .line 2129
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->e:Z

    .line 2131
    :cond_1
    iput p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->x:I

    .line 2132
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 0

    .prologue
    .line 1852
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ListView;->onSizeChanged(IIII)V

    .line 1853
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->h()V

    .line 1854
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 7

    .prologue
    const/4 v6, -0x1

    const/4 v3, 0x4

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 1613
    iget-boolean v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->ab:Z

    if-eqz v2, :cond_1

    .line 1614
    iput-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->ab:Z

    .line 1660
    :cond_0
    :goto_0
    return v0

    .line 1618
    :cond_1
    iget-boolean v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->s:Z

    if-nez v2, :cond_2

    .line 1619
    invoke-super {p0, p1}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    .line 1624
    :cond_2
    iget-boolean v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->O:Z

    .line 1625
    iput-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->O:Z

    .line 1627
    if-nez v2, :cond_3

    .line 1628
    invoke-direct {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->a(Landroid/view/MotionEvent;)V

    .line 1632
    :cond_3
    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    if-ne v2, v3, :cond_b

    .line 1633
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    and-int/lit16 v2, v2, 0xff

    packed-switch v2, :pswitch_data_0

    :cond_4
    :goto_1
    move v0, v1

    .line 1634
    goto :goto_0

    .line 1633
    :pswitch_0
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    if-ne v0, v3, :cond_5

    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->a()V

    :cond_5
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->g()V

    goto :goto_1

    :pswitch_1
    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    if-ne v2, v3, :cond_6

    iput-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->af:Z

    const/4 v2, 0x0

    invoke-direct {p0, v0, v2}, Lcom/mobeta/android/dslv/DragSortListView;->b(ZF)Z

    :cond_6
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->g()V

    goto :goto_1

    :pswitch_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    float-to-int v2, v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    float-to-int v3, v3

    iget-object v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iget v5, p0, Lcom/mobeta/android/dslv/DragSortListView;->n:I

    sub-int/2addr v2, v5

    iput v2, v4, Landroid/graphics/Point;->x:I

    iget-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->b:Landroid/graphics/Point;

    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->o:I

    sub-int v4, v3, v4

    iput v4, v2, Landroid/graphics/Point;->y:I

    invoke-direct {p0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->a(Z)V

    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->w:I

    add-int/2addr v2, v4

    invoke-static {v3, v2}, Ljava/lang/Math;->min(II)I

    move-result v2

    iget v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->d:I

    iget v5, p0, Lcom/mobeta/android/dslv/DragSortListView;->w:I

    sub-int/2addr v4, v5

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    iget-object v4, p0, Lcom/mobeta/android/dslv/DragSortListView;->z:Lcom/mobeta/android/dslv/p;

    invoke-virtual {v4}, Lcom/mobeta/android/dslv/p;->b()I

    move-result v4

    iget v5, p0, Lcom/mobeta/android/dslv/DragSortListView;->M:I

    if-le v2, v5, :cond_8

    iget v5, p0, Lcom/mobeta/android/dslv/DragSortListView;->D:I

    if-le v2, v5, :cond_8

    if-eq v4, v1, :cond_8

    if-eq v4, v6, :cond_7

    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->z:Lcom/mobeta/android/dslv/p;

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/p;->a(Z)V

    :cond_7
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->z:Lcom/mobeta/android/dslv/p;

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/p;->a(I)V

    goto :goto_1

    :cond_8
    iget v5, p0, Lcom/mobeta/android/dslv/DragSortListView;->M:I

    if-ge v3, v5, :cond_a

    iget v5, p0, Lcom/mobeta/android/dslv/DragSortListView;->C:I

    if-ge v3, v5, :cond_a

    if-eqz v4, :cond_a

    if-eq v4, v6, :cond_9

    iget-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->z:Lcom/mobeta/android/dslv/p;

    invoke-virtual {v2, v1}, Lcom/mobeta/android/dslv/p;->a(Z)V

    :cond_9
    iget-object v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->z:Lcom/mobeta/android/dslv/p;

    invoke-virtual {v2, v0}, Lcom/mobeta/android/dslv/p;->a(I)V

    goto :goto_1

    :cond_a
    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->C:I

    if-lt v3, v0, :cond_4

    iget v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->D:I

    if-gt v2, v0, :cond_4

    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->z:Lcom/mobeta/android/dslv/p;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/p;->a()Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->z:Lcom/mobeta/android/dslv/p;

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/p;->a(Z)V

    goto/16 :goto_1

    .line 1640
    :cond_b
    iget v2, p0, Lcom/mobeta/android/dslv/DragSortListView;->t:I

    if-nez v2, :cond_c

    .line 1641
    invoke-super {p0, p1}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v2

    if-eqz v2, :cond_c

    move v0, v1

    .line 1646
    :cond_c
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    and-int/lit16 v2, v2, 0xff

    .line 1648
    packed-switch v2, :pswitch_data_1

    .line 1654
    :pswitch_3
    if-eqz v0, :cond_0

    .line 1655
    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->S:I

    goto/16 :goto_0

    .line 1651
    :pswitch_4
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->g()V

    goto/16 :goto_0

    .line 1633
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
    .end packed-switch

    .line 1648
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_4
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public requestLayout()V
    .locals 1

    .prologue
    .line 2048
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->aa:Z

    if-nez v0, :cond_0

    .line 2049
    invoke-super {p0}, Landroid/widget/ListView;->requestLayout()V

    .line 2051
    :cond_0
    return-void
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0

    .prologue
    .line 59
    check-cast p1, Landroid/widget/ListAdapter;

    invoke-virtual {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 1

    .prologue
    .line 606
    if-eqz p1, :cond_3

    .line 607
    new-instance v0, Lcom/mobeta/android/dslv/h;

    invoke-direct {v0, p0, p1}, Lcom/mobeta/android/dslv/h;-><init>(Lcom/mobeta/android/dslv/DragSortListView;Landroid/widget/ListAdapter;)V

    iput-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->V:Lcom/mobeta/android/dslv/h;

    .line 608
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->f:Landroid/database/DataSetObserver;

    invoke-interface {p1, v0}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 610
    instance-of v0, p1, Lcom/mobeta/android/dslv/i;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 611
    check-cast v0, Lcom/mobeta/android/dslv/i;

    invoke-virtual {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->setDropListener(Lcom/mobeta/android/dslv/i;)V

    .line 613
    :cond_0
    instance-of v0, p1, Lcom/mobeta/android/dslv/j;

    if-eqz v0, :cond_1

    move-object v0, p1

    .line 614
    check-cast v0, Lcom/mobeta/android/dslv/j;

    invoke-virtual {p0, v0}, Lcom/mobeta/android/dslv/DragSortListView;->setDragListener(Lcom/mobeta/android/dslv/j;)V

    .line 616
    :cond_1
    instance-of v0, p1, Lcom/mobeta/android/dslv/r;

    if-eqz v0, :cond_2

    .line 617
    check-cast p1, Lcom/mobeta/android/dslv/r;

    invoke-virtual {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->setRemoveListener(Lcom/mobeta/android/dslv/r;)V

    .line 623
    :cond_2
    :goto_0
    iget-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->V:Lcom/mobeta/android/dslv/h;

    invoke-super {p0, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 624
    return-void

    .line 620
    :cond_3
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mobeta/android/dslv/DragSortListView;->V:Lcom/mobeta/android/dslv/h;

    goto :goto_0
.end method

.method public setDragEnabled(Z)V
    .locals 0

    .prologue
    .line 2490
    iput-boolean p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->s:Z

    .line 2491
    return-void
.end method

.method public setDragListener(Lcom/mobeta/android/dslv/j;)V
    .locals 0

    .prologue
    .line 2476
    iput-object p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->p:Lcom/mobeta/android/dslv/j;

    .line 2477
    return-void
.end method

.method public setDragScrollProfile(Lcom/mobeta/android/dslv/o;)V
    .locals 0

    .prologue
    .line 2573
    if-eqz p1, :cond_0

    .line 2574
    iput-object p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->J:Lcom/mobeta/android/dslv/o;

    .line 2576
    :cond_0
    return-void
.end method

.method public setDragScrollStart(F)V
    .locals 0

    .prologue
    .line 1758
    invoke-virtual {p0, p1, p1}, Lcom/mobeta/android/dslv/DragSortListView;->setDragScrollStarts(FF)V

    .line 1759
    return-void
.end method

.method public setDragScrollStarts(FF)V
    .locals 2

    .prologue
    const/high16 v1, 0x3f000000    # 0.5f

    .line 1772
    cmpl-float v0, p2, v1

    if-lez v0, :cond_1

    .line 1773
    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->B:F

    .line 1778
    :goto_0
    cmpl-float v0, p1, v1

    if-lez v0, :cond_2

    .line 1779
    iput v1, p0, Lcom/mobeta/android/dslv/DragSortListView;->A:F

    .line 1784
    :goto_1
    invoke-virtual {p0}, Lcom/mobeta/android/dslv/DragSortListView;->getHeight()I

    move-result v0

    if-eqz v0, :cond_0

    .line 1785
    invoke-direct {p0}, Lcom/mobeta/android/dslv/DragSortListView;->h()V

    .line 1787
    :cond_0
    return-void

    .line 1775
    :cond_1
    iput p2, p0, Lcom/mobeta/android/dslv/DragSortListView;->B:F

    goto :goto_0

    .line 1781
    :cond_2
    iput p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->A:F

    goto :goto_1
.end method

.method public setDragSortListener(Lcom/mobeta/android/dslv/g;)V
    .locals 0

    .prologue
    .line 2560
    invoke-virtual {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->setDropListener(Lcom/mobeta/android/dslv/i;)V

    .line 2561
    invoke-virtual {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->setDragListener(Lcom/mobeta/android/dslv/j;)V

    .line 2562
    invoke-virtual {p0, p1}, Lcom/mobeta/android/dslv/DragSortListView;->setRemoveListener(Lcom/mobeta/android/dslv/r;)V

    .line 2563
    return-void
.end method

.method public setDropListener(Lcom/mobeta/android/dslv/i;)V
    .locals 0

    .prologue
    .line 2510
    iput-object p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->q:Lcom/mobeta/android/dslv/i;

    .line 2511
    return-void
.end method

.method public setFloatAlpha(F)V
    .locals 0

    .prologue
    .line 577
    iput p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->h:F

    .line 578
    return-void
.end method

.method public setFloatViewManager(Lcom/mobeta/android/dslv/l;)V
    .locals 0

    .prologue
    .line 2472
    iput-object p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->Q:Lcom/mobeta/android/dslv/l;

    .line 2473
    return-void
.end method

.method public setMaxScrollSpeed(F)V
    .locals 0

    .prologue
    .line 591
    iput p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->I:F

    .line 592
    return-void
.end method

.method public setRemoveListener(Lcom/mobeta/android/dslv/r;)V
    .locals 0

    .prologue
    .line 2524
    iput-object p1, p0, Lcom/mobeta/android/dslv/DragSortListView;->r:Lcom/mobeta/android/dslv/r;

    .line 2525
    return-void
.end method
