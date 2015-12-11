.class public Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;
.super Landroid/widget/ExpandableListView;
.source "SourceFile"


# static fields
.field private static final a:[I

.field private static final b:[I

.field private static final c:[I

.field private static final d:[I

.field private static final e:[[I


# instance fields
.field private A:Ljava/lang/Runnable;

.field private B:Ljava/lang/Runnable;

.field private final C:Landroid/graphics/Rect;

.field private f:Lfd;

.field private g:Landroid/database/DataSetObserver;

.field private h:Landroid/widget/AbsListView$OnScrollListener;

.field private i:Z

.field private j:Landroid/view/View;

.field private k:I

.field private l:I

.field private m:Lbz;

.field private n:Landroid/widget/ExpandableListView$OnGroupClickListener;

.field private o:I

.field private p:Ljava/lang/Object;

.field private q:Z

.field private r:Z

.field private s:Ljava/lang/Runnable;

.field private t:Landroid/view/GestureDetector;

.field private u:Z

.field private v:Z

.field private w:Z

.field private x:Landroid/graphics/drawable/Drawable;

.field private y:I

.field private final z:Landroid/graphics/Rect;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 29
    new-array v0, v2, [I

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a:[I

    .line 32
    new-array v0, v3, [I

    const v1, 0x10100a8

    aput v1, v0, v2

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->b:[I

    .line 35
    new-array v0, v3, [I

    const v1, 0x10100a9

    aput v1, v0, v2

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c:[I

    .line 38
    new-array v0, v4, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->d:[I

    .line 41
    const/4 v0, 0x4

    new-array v0, v0, [[I

    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a:[I

    aput-object v1, v0, v2

    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->b:[I

    aput-object v1, v0, v3

    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c:[I

    aput-object v1, v0, v4

    const/4 v1, 0x3

    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->d:[I

    aput-object v2, v0, v1

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->e:[[I

    return-void

    .line 38
    nop

    :array_0
    .array-data 4
        0x10100a8
        0x10100a9
    .end array-data
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 81
    invoke-direct {p0, p1}, Landroid/widget/ExpandableListView;-><init>(Landroid/content/Context;)V

    .line 53
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->i:Z

    .line 74
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->z:Landroid/graphics/Rect;

    .line 78
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->C:Landroid/graphics/Rect;

    .line 82
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a()V

    .line 83
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 86
    invoke-direct {p0, p1, p2}, Landroid/widget/ExpandableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 53
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->i:Z

    .line 74
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->z:Landroid/graphics/Rect;

    .line 78
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->C:Landroid/graphics/Rect;

    .line 87
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a()V

    .line 88
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 91
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ExpandableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 53
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->i:Z

    .line 74
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->z:Landroid/graphics/Rect;

    .line 78
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->C:Landroid/graphics/Rect;

    .line 92
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a()V

    .line 93
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;Landroid/view/View;)Landroid/view/View;
    .locals 0

    .prologue
    .line 27
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/widget/AbsListView$OnScrollListener;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->h:Landroid/widget/AbsListView$OnScrollListener;

    return-object v0
.end method

.method private a()V
    .locals 3

    .prologue
    .line 96
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V

    invoke-super {p0, v0}, Landroid/widget/ExpandableListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 117
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->s:Ljava/lang/Runnable;

    .line 139
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$3;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->A:Ljava/lang/Runnable;

    .line 151
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$4;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$4;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->B:Ljava/lang/Runnable;

    .line 163
    new-instance v0, Landroid/view/GestureDetector;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getContext()Landroid/content/Context;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V

    invoke-direct {v0, v1, v2}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->t:Landroid/view/GestureDetector;

    .line 174
    return-void
.end method

.method private a(I)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    const v5, 0x7f0c0008

    const/4 v2, 0x0

    .line 361
    iput-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    .line 362
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getExpandableListPosition(I)J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPackedPositionGroup(J)I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    move v1, v2

    .line 364
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getChildCount()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 365
    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 366
    invoke-virtual {v3, v5}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object v0

    .line 367
    instance-of v4, v0, Ljava/lang/Boolean;

    if-eqz v4, :cond_0

    .line 368
    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 369
    if-eqz v0, :cond_0

    .line 370
    invoke-virtual {v3, v2}, Landroid/view/View;->setVisibility(I)V

    .line 371
    invoke-virtual {v3, v5, v7}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 364
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 376
    :cond_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->i:Z

    if-nez v0, :cond_3

    .line 458
    :cond_2
    :goto_1
    return-void

    .line 380
    :cond_3
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPackedPositionForGroup(I)J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getFlatListPosition(J)I

    move-result v0

    .line 381
    sub-int/2addr v0, p1

    .line 383
    if-ltz v0, :cond_4

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_4

    .line 384
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 386
    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingTop()I

    move-result v3

    if-ge v1, v3, :cond_2

    .line 388
    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingTop()I

    move-result v3

    if-ge v1, v3, :cond_4

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-nez v1, :cond_4

    .line 389
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 390
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v5, v1}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 394
    :cond_4
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    if-ltz v0, :cond_5

    .line 395
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    iget v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    iget v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    invoke-virtual {v3, v4}, Lfd;->a(I)Z

    move-result v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v0, v1, v3, v4, p0}, Lfd;->getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    .line 397
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->isClickable()Z

    move-result v0

    if-nez v0, :cond_8

    .line 398
    iput-boolean v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->u:Z

    .line 399
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$7;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$7;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 410
    :goto_2
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->b()V

    .line 411
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Landroid/view/View;)V

    .line 414
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 418
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/AbsListView$LayoutParams;

    .line 419
    if-nez v0, :cond_6

    .line 420
    new-instance v0, Landroid/widget/AbsListView$LayoutParams;

    const/4 v1, -0x1

    const/4 v3, -0x2

    invoke-direct {v0, v1, v3, v2}, Landroid/widget/AbsListView$LayoutParams;-><init>(III)V

    .line 421
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 424
    :cond_6
    iget v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->o:I

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingLeft()I

    move-result v3

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingRight()I

    move-result v4

    add-int/2addr v3, v4

    iget v4, v0, Landroid/widget/AbsListView$LayoutParams;->width:I

    invoke-static {v1, v3, v4}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v1

    .line 425
    iget v0, v0, Landroid/widget/AbsListView$LayoutParams;->height:I

    .line 427
    if-lez v0, :cond_9

    .line 428
    const/high16 v3, 0x40000000    # 2.0f

    invoke-static {v0, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 433
    :goto_3
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v3, v1, v0}, Landroid/view/View;->measure(II)V

    .line 437
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    add-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPackedPositionForGroup(I)J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getFlatListPosition(J)I

    move-result v0

    .line 438
    sub-int/2addr v0, p1

    .line 440
    if-ltz v0, :cond_7

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_7

    .line 441
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 443
    if-eqz v0, :cond_7

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingTop()I

    move-result v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    add-int/2addr v3, v4

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getDividerHeight()I

    move-result v4

    add-int/2addr v3, v4

    if-ge v1, v3, :cond_7

    .line 444
    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingTop()I

    move-result v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    add-int/2addr v1, v2

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getDividerHeight()I

    move-result v2

    add-int/2addr v1, v2

    sub-int v2, v0, v1

    .line 448
    :cond_7
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingLeft()I

    move-result v0

    .line 449
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingTop()I

    move-result v1

    add-int/2addr v1, v2

    .line 450
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    add-int/2addr v3, v0

    .line 451
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    add-int/2addr v4, v1

    .line 452
    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v5, v0, v1, v3, v4}, Landroid/view/View;->layout(IIII)V

    .line 454
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->l:I

    .line 455
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->m:Lbz;

    if-eqz v0, :cond_2

    .line 456
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->m:Lbz;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->l:I

    invoke-interface {v0, v1, v2}, Lbz;->a(Landroid/view/View;I)V

    goto/16 :goto_1

    .line 407
    :cond_8
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->u:Z

    goto/16 :goto_2

    .line 430
    :cond_9
    invoke-static {v2, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    goto/16 :goto_3
.end method

.method private a(Landroid/graphics/Canvas;)V
    .locals 2

    .prologue
    .line 496
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->y:I

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getFirstVisiblePosition()I

    move-result v1

    sub-int/2addr v0, v1

    .line 498
    if-ltz v0, :cond_1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->z:Landroid/graphics/Rect;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->z:Landroid/graphics/Rect;

    invoke-virtual {v0}, Landroid/graphics/Rect;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 499
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPackedPositionForGroup(I)J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getFlatListPosition(J)I

    move-result v0

    .line 500
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    if-eqz v1, :cond_0

    iget v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->y:I

    if-eq v1, v0, :cond_1

    .line 501
    :cond_0
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c(Landroid/graphics/Canvas;)V

    .line 504
    :cond_1
    return-void
.end method

.method private a(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 467
    if-nez p1, :cond_1

    .line 479
    :cond_0
    return-void

    .line 470
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->p:Ljava/lang/Object;

    if-eqz v0, :cond_2

    .line 471
    const-class v0, Landroid/view/View;

    const-string v1, "mAttachInfo"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->p:Ljava/lang/Object;

    invoke-static {v0, v1, p1, v2}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 473
    :cond_2
    instance-of v0, p1, Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    .line 474
    check-cast p1, Landroid/view/ViewGroup;

    .line 475
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 476
    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Landroid/view/View;)V

    .line 475
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;I)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(I)V

    return-void
.end method

.method private b()V
    .locals 2

    .prologue
    .line 461
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->p:Ljava/lang/Object;

    if-nez v0, :cond_0

    .line 462
    const-class v0, Landroid/view/View;

    const-string v1, "mAttachInfo"

    invoke-static {v0, v1, p0}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->p:Ljava/lang/Object;

    .line 464
    :cond_0
    return-void
.end method

.method private b(Landroid/graphics/Canvas;)V
    .locals 5

    .prologue
    .line 507
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->z:Landroid/graphics/Rect;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->z:Landroid/graphics/Rect;

    invoke-virtual {v0}, Landroid/graphics/Rect;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 508
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPackedPositionForGroup(I)J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getFlatListPosition(J)I

    move-result v0

    .line 509
    iget v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->y:I

    if-ne v1, v0, :cond_0

    .line 510
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->z:Landroid/graphics/Rect;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getBottom()I

    move-result v4

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;->set(IIII)V

    .line 511
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c(Landroid/graphics/Canvas;)V

    .line 514
    :cond_0
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->i:Z

    return v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Lfd;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    return-object v0
.end method

.method private c()V
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 482
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->v:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 483
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_1

    .line 484
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPackedPositionForGroup(I)J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getFlatListPosition(J)I

    move-result v0

    .line 485
    const-class v1, Landroid/widget/AbsListView;

    const-string v2, "positionSelector"

    new-array v3, v7, [Ljava/lang/Class;

    sget-object v4, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v4, v3, v5

    const-class v4, Landroid/view/View;

    aput-object v4, v3, v6

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v4, v5

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    aput-object v0, v4, v6

    invoke-static {v1, v2, v3, p0, v4}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 489
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->invalidate()V

    .line 491
    :cond_0
    iput-boolean v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->v:Z

    .line 492
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->A:Ljava/lang/Runnable;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 493
    return-void

    .line 487
    :cond_1
    const-class v0, Landroid/widget/AbsListView;

    const-string v1, "positionSelector"

    new-array v2, v6, [Ljava/lang/Class;

    const-class v3, Landroid/view/View;

    aput-object v3, v2, v5

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    aput-object v4, v3, v5

    invoke-static {v0, v1, v2, p0, v3}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private c(Landroid/graphics/Canvas;)V
    .locals 5

    .prologue
    .line 517
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 518
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingRight()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getHeight()I

    move-result v3

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingBottom()I

    move-result v4

    sub-int/2addr v3, v4

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 519
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->isPressed()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 520
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->x:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 524
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->x:Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->z:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 525
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->x:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 526
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 527
    return-void

    .line 522
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->x:Landroid/graphics/drawable/Drawable;

    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a:[I

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    goto :goto_0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/widget/ExpandableListView$OnGroupClickListener;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->n:Landroid/widget/ExpandableListView$OnGroupClickListener;

    return-object v0
.end method

.method private d(Landroid/graphics/Canvas;)V
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 530
    const-class v0, Landroid/widget/ExpandableListView;

    const-string v1, "mGroupIndicator"

    invoke-static {v0, v1, p0}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/Drawable;

    .line 531
    if-eqz v0, :cond_1

    .line 532
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    iget v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    invoke-virtual {v1, v3}, Lfd;->a(I)Z

    move-result v1

    if-eqz v1, :cond_2

    const/4 v1, 0x1

    :goto_0
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    iget v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    invoke-virtual {v3, v4}, Lfd;->getChildrenCount(I)I

    move-result v3

    if-lez v3, :cond_0

    const/4 v2, 0x2

    :cond_0
    or-int/2addr v1, v2

    .line 535
    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->e:[[I

    aget-object v1, v2, v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 537
    const-class v1, Landroid/widget/ExpandableListView;

    const-string v2, "mIndicatorLeft"

    invoke-static {v1, v2, p0}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 538
    const-class v1, Landroid/widget/ExpandableListView;

    const-string v3, "mIndicatorRight"

    invoke-static {v1, v3, p0}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 540
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xe

    if-lt v3, v4, :cond_3

    .line 541
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->C:Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingLeft()I

    move-result v4

    add-int/2addr v2, v4

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getTop()I

    move-result v4

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingLeft()I

    move-result v5

    add-int/2addr v1, v5

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v5

    invoke-virtual {v3, v2, v4, v1, v5}, Landroid/graphics/Rect;->set(IIII)V

    .line 546
    :goto_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->C:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 547
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 549
    :cond_1
    return-void

    :cond_2
    move v1, v2

    .line 532
    goto :goto_0

    .line 543
    :cond_3
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->C:Landroid/graphics/Rect;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getTop()I

    move-result v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v5

    invoke-virtual {v3, v2, v4, v1, v5}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_1
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/view/View;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    return-object v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)I
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->k:I

    return v0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c()V

    return-void
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->s:Ljava/lang/Runnable;

    return-object v0
.end method


# virtual methods
.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 5

    .prologue
    .line 195
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_4

    .line 196
    const-class v0, Landroid/widget/AbsListView;

    const-string v1, "mSelectorPosition"

    invoke-static {v0, v1, p0}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->y:I

    .line 201
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->z:Landroid/graphics/Rect;

    const-class v0, Landroid/widget/AbsListView;

    const-string v2, "mSelectorRect"

    invoke-static {v0, v2, p0}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Rect;

    invoke-virtual {v1, v0}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 203
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->w:Z

    if-nez v0, :cond_0

    .line 204
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Landroid/graphics/Canvas;)V

    .line 207
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/ExpandableListView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 209
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->i:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    if-eqz v0, :cond_3

    .line 210
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->w:Z

    if-nez v0, :cond_1

    .line 211
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->b(Landroid/graphics/Canvas;)V

    .line 214
    :cond_1
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 215
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingRight()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getHeight()I

    move-result v3

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getPaddingBottom()I

    move-result v4

    sub-int/2addr v3, v4

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->clipRect(IIII)Z

    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_2

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getDrawingTime()J

    move-result-wide v2

    invoke-virtual {p0, p1, v0, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    .line 219
    :cond_2
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->d(Landroid/graphics/Canvas;)V

    .line 220
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 222
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->w:Z

    if-eqz v0, :cond_3

    .line 223
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Landroid/graphics/Canvas;)V

    .line 224
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->b(Landroid/graphics/Canvas;)V

    .line 227
    :cond_3
    return-void

    .line 198
    :cond_4
    const-class v0, Landroid/widget/AbsListView;

    const-string v1, "mMotionPosition"

    invoke-static {v0, v1, p0}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->y:I

    goto :goto_0
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v0, 0x1

    .line 231
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    and-int/lit16 v1, v1, 0xff

    .line 233
    if-eqz v1, :cond_0

    const/4 v2, 0x3

    if-ne v1, v2, :cond_1

    .line 234
    :cond_0
    iput-boolean v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->q:Z

    .line 235
    iput-boolean v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->r:Z

    .line 236
    iput-boolean v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->v:Z

    .line 240
    :cond_1
    iget-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->q:Z

    if-nez v2, :cond_4

    iget-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->r:Z

    if-nez v2, :cond_4

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    if-eqz v2, :cond_4

    .line 241
    const/4 v2, 0x2

    new-array v2, v2, [I

    .line 242
    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->getLocationInWindow([I)V

    .line 243
    new-instance v3, Landroid/graphics/RectF;

    aget v4, v2, v7

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getLeft()I

    move-result v5

    add-int/2addr v4, v5

    int-to-float v4, v4

    aget v5, v2, v0

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getTop()I

    move-result v6

    add-int/2addr v5, v6

    int-to-float v5, v5

    aget v6, v2, v7

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v7}, Landroid/view/View;->getRight()I

    move-result v7

    add-int/2addr v6, v7

    int-to-float v6, v6

    aget v2, v2, v0

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v7}, Landroid/view/View;->getBottom()I

    move-result v7

    add-int/2addr v2, v7

    int-to-float v2, v2

    invoke-direct {v3, v4, v5, v6, v2}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 245
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v4

    invoke-virtual {v3, v2, v4}, Landroid/graphics/RectF;->contains(FF)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 246
    iget-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->u:Z

    if-eqz v2, :cond_2

    .line 247
    packed-switch v1, :pswitch_data_0

    .line 267
    :cond_2
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v1, p1}, Landroid/view/View;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 268
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->t:Landroid/view/GestureDetector;

    invoke-virtual {v1, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 269
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    .line 275
    :goto_1
    return v0

    .line 249
    :pswitch_0
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->v:Z

    .line 250
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->A:Ljava/lang/Runnable;

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 251
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->A:Ljava/lang/Runnable;

    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {p0, v1, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 254
    :pswitch_1
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c()V

    .line 255
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->setPressed(Z)V

    .line 256
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    if-eqz v1, :cond_3

    .line 257
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->j:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->setPressed(Z)V

    .line 260
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->B:Ljava/lang/Runnable;

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 261
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->B:Ljava/lang/Runnable;

    invoke-static {}, Landroid/view/ViewConfiguration;->getPressedStateDuration()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {p0, v1, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 275
    :cond_4
    invoke-super {p0, p1}, Landroid/widget/ExpandableListView;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_1

    .line 247
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 178
    invoke-super {p0}, Landroid/widget/ExpandableListView;->onDetachedFromWindow()V

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->g:Landroid/database/DataSetObserver;

    if-eqz v0, :cond_0

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->g:Landroid/database/DataSetObserver;

    invoke-virtual {v0, v1}, Lfd;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 182
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->g:Landroid/database/DataSetObserver;

    .line 184
    :cond_0
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 280
    invoke-super {p0, p1}, Landroid/widget/ExpandableListView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->q:Z

    .line 281
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->q:Z

    return v0
.end method

.method protected onMeasure(II)V
    .locals 0

    .prologue
    .line 188
    invoke-super {p0, p1, p2}, Landroid/widget/ExpandableListView;->onMeasure(II)V

    .line 189
    iput p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->o:I

    .line 190
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 286
    invoke-super {p0, p1}, Landroid/widget/ExpandableListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->r:Z

    .line 287
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->r:Z

    return v0
.end method

.method public setAdapter(Landroid/widget/ExpandableListAdapter;)V
    .locals 2

    .prologue
    .line 309
    instance-of v0, p1, Lfd;

    if-nez v0, :cond_0

    .line 310
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The adapter must be an instance of WrapperExpandableListAdapter"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 312
    :cond_0
    check-cast p1, Lfd;

    invoke-virtual {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->setAdapter(Lfd;)V

    .line 313
    return-void
.end method

.method public setAdapter(Lfd;)V
    .locals 2

    .prologue
    .line 316
    invoke-super {p0, p1}, Landroid/widget/ExpandableListView;->setAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 318
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->g:Landroid/database/DataSetObserver;

    if-eqz v0, :cond_0

    .line 319
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->g:Landroid/database/DataSetObserver;

    invoke-virtual {v0, v1}, Lfd;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 320
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->g:Landroid/database/DataSetObserver;

    .line 323
    :cond_0
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    .line 325
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->g:Landroid/database/DataSetObserver;

    if-nez v0, :cond_1

    .line 326
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$6;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$6;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->g:Landroid/database/DataSetObserver;

    .line 337
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f:Lfd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->g:Landroid/database/DataSetObserver;

    invoke-virtual {v0, v1}, Lfd;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 339
    :cond_1
    return-void
.end method

.method public setDrawSelectorOnTop(Z)V
    .locals 0

    .prologue
    .line 303
    invoke-super {p0, p1}, Landroid/widget/ExpandableListView;->setDrawSelectorOnTop(Z)V

    .line 304
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->w:Z

    .line 305
    return-void
.end method

.method public setOnGroupClickListener(Landroid/widget/ExpandableListView$OnGroupClickListener;)V
    .locals 0

    .prologue
    .line 348
    invoke-super {p0, p1}, Landroid/widget/ExpandableListView;->setOnGroupClickListener(Landroid/widget/ExpandableListView$OnGroupClickListener;)V

    .line 349
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->n:Landroid/widget/ExpandableListView$OnGroupClickListener;

    .line 350
    return-void
.end method

.method public setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V
    .locals 0

    .prologue
    .line 343
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->h:Landroid/widget/AbsListView$OnScrollListener;

    .line 344
    return-void
.end method

.method public setOnScrollStickyGroupListener(Lbz;)V
    .locals 0

    .prologue
    .line 357
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->m:Lbz;

    .line 358
    return-void
.end method

.method public setSelector(Landroid/graphics/drawable/Drawable;)V
    .locals 2

    .prologue
    .line 292
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-super {p0, v0}, Landroid/widget/ExpandableListView;->setSelector(Landroid/graphics/drawable/Drawable;)V

    .line 293
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->x:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 294
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->x:Landroid/graphics/drawable/Drawable;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 295
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->x:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->unscheduleDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 297
    :cond_0
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->x:Landroid/graphics/drawable/Drawable;

    .line 298
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->x:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 299
    return-void
.end method

.method public setStickyGroupEnabled(Z)V
    .locals 0

    .prologue
    .line 353
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->i:Z

    .line 354
    return-void
.end method
