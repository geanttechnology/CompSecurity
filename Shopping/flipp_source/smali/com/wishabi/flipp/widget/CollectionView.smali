.class public Lcom/wishabi/flipp/widget/CollectionView;
.super Landroid/widget/ScrollView;
.source "SourceFile"


# static fields
.field private static final l:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/wishabi/flipp/widget/o;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field a:Lcom/wishabi/flipp/widget/s;

.field b:I

.field c:Landroid/view/ActionMode;

.field d:Lcom/wishabi/flipp/widget/q;

.field final e:Landroid/util/SparseBooleanArray;

.field private f:Lcom/wishabi/flipp/widget/n;

.field private g:Landroid/view/View;

.field private h:Landroid/widget/ListAdapter;

.field private i:Lcom/wishabi/flipp/widget/r;

.field private j:Lcom/wishabi/flipp/widget/t;

.field private final k:Lcom/wishabi/flipp/widget/j;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 1078
    new-instance v0, Lcom/wishabi/flipp/widget/i;

    invoke-direct {v0}, Lcom/wishabi/flipp/widget/i;-><init>()V

    sput-object v0, Lcom/wishabi/flipp/widget/CollectionView;->l:Ljava/util/Comparator;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 592
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/CollectionView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 593
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 612
    const v0, 0x1010080

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/CollectionView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 613
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 629
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 837
    new-instance v0, Landroid/util/SparseBooleanArray;

    invoke-direct {v0}, Landroid/util/SparseBooleanArray;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    .line 631
    new-instance v0, Lcom/wishabi/flipp/widget/j;

    invoke-direct {v0, p0, p1}, Lcom/wishabi/flipp/widget/j;-><init>(Lcom/wishabi/flipp/widget/CollectionView;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->k:Lcom/wishabi/flipp/widget/j;

    .line 632
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->k:Lcom/wishabi/flipp/widget/j;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CollectionView;->addView(Landroid/view/View;)V

    .line 633
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/CollectionView;)Landroid/view/ActionMode;
    .locals 1

    .prologue
    .line 33
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/widget/CollectionView;)Landroid/util/SparseBooleanArray;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    return-object v0
.end method

.method static synthetic b()Ljava/util/Comparator;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/wishabi/flipp/widget/CollectionView;->l:Ljava/util/Comparator;

    return-object v0
.end method

.method private c()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 1064
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->g:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 1065
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->h:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->h:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1066
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1071
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->h:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->h:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1072
    :cond_2
    invoke-virtual {p0, v2}, Lcom/wishabi/flipp/widget/CollectionView;->setVisibility(I)V

    .line 1075
    :goto_1
    return-void

    .line 1068
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 1074
    :cond_4
    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->setVisibility(I)V

    goto :goto_1
.end method

.method static synthetic c(Lcom/wishabi/flipp/widget/CollectionView;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CollectionView;->c()V

    return-void
.end method

.method static synthetic d(Lcom/wishabi/flipp/widget/CollectionView;)Lcom/wishabi/flipp/widget/n;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->f:Lcom/wishabi/flipp/widget/n;

    return-object v0
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 265
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    if-eqz v0, :cond_0

    .line 266
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    invoke-virtual {v0}, Landroid/view/ActionMode;->finish()V

    .line 267
    :cond_0
    return-void
.end method

.method public final a(IZ)V
    .locals 7

    .prologue
    const/4 v3, 0x3

    const/4 v2, 0x1

    .line 478
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    if-nez v0, :cond_0

    .line 516
    :goto_0
    return-void

    .line 481
    :cond_0
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    if-ne v0, v3, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    if-nez v0, :cond_2

    .line 483
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->d:Lcom/wishabi/flipp/widget/q;

    if-nez v0, :cond_1

    .line 484
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "CollectionView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 489
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->d:Lcom/wishabi/flipp/widget/q;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CollectionView;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    .line 492
    :cond_2
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_3

    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    if-ne v0, v3, :cond_7

    .line 495
    :cond_3
    if-eqz p2, :cond_6

    .line 496
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, p1, v2}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 500
    :goto_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    if-eqz v0, :cond_4

    .line 501
    iget-object v1, p0, Lcom/wishabi/flipp/widget/CollectionView;->d:Lcom/wishabi/flipp/widget/q;

    iget-object v2, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->h:Landroid/widget/ListAdapter;

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    move v3, p1

    move v6, p2

    invoke-virtual/range {v1 .. v6}, Lcom/wishabi/flipp/widget/q;->a(Landroid/view/ActionMode;IJZ)V

    .line 512
    :cond_4
    :goto_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->k:Lcom/wishabi/flipp/widget/j;

    if-eqz v0, :cond_5

    .line 513
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->k:Lcom/wishabi/flipp/widget/j;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/j;->a()V

    .line 515
    :cond_5
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CollectionView;->requestLayout()V

    goto :goto_0

    .line 498
    :cond_6
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseBooleanArray;->delete(I)V

    goto :goto_1

    .line 505
    :cond_7
    if-nez p2, :cond_8

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 506
    :cond_8
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->clear()V

    .line 508
    :cond_9
    if-eqz p2, :cond_4

    .line 509
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, p1, v2}, Landroid/util/SparseBooleanArray;->put(IZ)V

    goto :goto_2
.end method

.method public final a(Landroid/view/View;I)V
    .locals 4

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 90
    .line 92
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    if-eqz v0, :cond_a

    .line 95
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    const/4 v3, 0x2

    if-eq v0, v3, :cond_0

    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    const/4 v3, 0x3

    if-ne v0, v3, :cond_5

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    if-eqz v0, :cond_5

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    if-eqz v0, :cond_9

    move v0, v1

    .line 102
    :goto_0
    iget-object v3, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v3, p2, v1}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v3

    if-nez v3, :cond_4

    move v3, v2

    .line 103
    :goto_1
    invoke-virtual {p0, p2, v3}, Lcom/wishabi/flipp/widget/CollectionView;->a(IZ)V

    :goto_2
    move v3, v2

    .line 114
    :goto_3
    if-eqz v3, :cond_1

    .line 115
    iget-object v3, p0, Lcom/wishabi/flipp/widget/CollectionView;->k:Lcom/wishabi/flipp/widget/j;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/j;->a()V

    .line 118
    :cond_1
    :goto_4
    if-eqz v0, :cond_3

    .line 119
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->i:Lcom/wishabi/flipp/widget/r;

    if-eqz v0, :cond_3

    .line 120
    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->playSoundEffect(I)V

    .line 121
    if-eqz p1, :cond_2

    .line 122
    invoke-virtual {p1, v2}, Landroid/view/View;->sendAccessibilityEvent(I)V

    .line 124
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->i:Lcom/wishabi/flipp/widget/r;

    invoke-interface {v0, p0, p2}, Lcom/wishabi/flipp/widget/r;->a(Lcom/wishabi/flipp/widget/CollectionView;I)V

    .line 127
    :cond_3
    return-void

    :cond_4
    move v3, v1

    .line 102
    goto :goto_1

    .line 104
    :cond_5
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    if-ne v0, v2, :cond_8

    .line 106
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, p2, v1}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v0

    if-nez v0, :cond_7

    move v0, v2

    .line 107
    :goto_5
    if-eqz v0, :cond_6

    .line 108
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->clear()V

    .line 109
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, p2, v2}, Landroid/util/SparseBooleanArray;->put(IZ)V

    :cond_6
    move v0, v2

    goto :goto_2

    :cond_7
    move v0, v1

    .line 106
    goto :goto_5

    :cond_8
    move v3, v1

    move v0, v2

    goto :goto_3

    :cond_9
    move v0, v2

    goto :goto_0

    :cond_a
    move v0, v2

    goto :goto_4
.end method

.method public getActivatedItemCount()I
    .locals 1

    .prologue
    .line 573
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->size()I

    move-result v0

    return v0
.end method

.method public getActivatedItemPosition()I
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 543
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->size()I

    move-result v0

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public getActivatedItemPositions()Landroid/util/SparseBooleanArray;
    .locals 1

    .prologue
    .line 557
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getActiveViews()Landroid/util/SparseArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation

    .prologue
    .line 582
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->k:Lcom/wishabi/flipp/widget/j;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/j;->a(Lcom/wishabi/flipp/widget/j;)Landroid/util/SparseArray;

    move-result-object v0

    return-object v0
.end method

.method public getAdapter()Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 667
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->h:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method public getEmptyView()Landroid/view/View;
    .locals 1

    .prologue
    .line 643
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->g:Landroid/view/View;

    return-object v0
.end method

.method public getLayout()Lcom/wishabi/flipp/widget/n;
    .locals 1

    .prologue
    .line 744
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->f:Lcom/wishabi/flipp/widget/n;

    return-object v0
.end method

.method public getMultiChoiceModeListener()Lcom/wishabi/flipp/widget/p;
    .locals 1

    .prologue
    .line 737
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->d:Lcom/wishabi/flipp/widget/q;

    return-object v0
.end method

.method public getOnItemClickListener()Lcom/wishabi/flipp/widget/r;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->i:Lcom/wishabi/flipp/widget/r;

    return-object v0
.end method

.method public getOnItemLongClickListener()Lcom/wishabi/flipp/widget/s;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->a:Lcom/wishabi/flipp/widget/s;

    return-object v0
.end method

.method public getOnScrollListener()Lcom/wishabi/flipp/widget/t;
    .locals 1

    .prologue
    .line 240
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->j:Lcom/wishabi/flipp/widget/t;

    return-object v0
.end method

.method protected onLayout(ZIIII)V
    .locals 2

    .prologue
    .line 462
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CollectionView;->getScrollY()I

    move-result v0

    .line 463
    invoke-super/range {p0 .. p5}, Landroid/widget/ScrollView;->onLayout(ZIIII)V

    .line 465
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CollectionView;->getScrollY()I

    move-result v1

    if-eq v0, v1, :cond_0

    if-eqz p1, :cond_0

    .line 466
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/CollectionView;->requestLayout()V

    .line 467
    :cond_0
    return-void
.end method

.method protected onScrollChanged(IIII)V
    .locals 1

    .prologue
    .line 774
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ScrollView;->onScrollChanged(IIII)V

    .line 775
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->k:Lcom/wishabi/flipp/widget/j;

    invoke-static {v0, p2}, Lcom/wishabi/flipp/widget/j;->a(Lcom/wishabi/flipp/widget/j;I)V

    .line 777
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->j:Lcom/wishabi/flipp/widget/t;

    if-eqz v0, :cond_0

    .line 778
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->j:Lcom/wishabi/flipp/widget/t;

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/t;->a()V

    .line 779
    :cond_0
    return-void
.end method

.method public requestLayout()V
    .locals 1

    .prologue
    .line 766
    invoke-super {p0}, Landroid/widget/ScrollView;->requestLayout()V

    .line 768
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->k:Lcom/wishabi/flipp/widget/j;

    if-eqz v0, :cond_0

    .line 769
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->k:Lcom/wishabi/flipp/widget/j;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/j;->requestLayout()V

    .line 770
    :cond_0
    return-void
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 5

    .prologue
    .line 677
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->h:Landroid/widget/ListAdapter;

    if-ne v0, p1, :cond_0

    .line 685
    :goto_0
    return-void

    .line 680
    :cond_0
    iput-object p1, p0, Lcom/wishabi/flipp/widget/CollectionView;->h:Landroid/widget/ListAdapter;

    .line 681
    iget-object v1, p0, Lcom/wishabi/flipp/widget/CollectionView;->k:Lcom/wishabi/flipp/widget/j;

    iget-object v0, v1, Lcom/wishabi/flipp/widget/j;->c:Landroid/widget/ListAdapter;

    if-eq v0, p1, :cond_2

    iget-object v0, v1, Lcom/wishabi/flipp/widget/j;->c:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_1

    iget-object v0, v1, Lcom/wishabi/flipp/widget/j;->c:Landroid/widget/ListAdapter;

    iget-object v2, v1, Lcom/wishabi/flipp/widget/j;->f:Landroid/database/DataSetObserver;

    invoke-interface {v0, v2}, Landroid/widget/ListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    :cond_1
    iput-object p1, v1, Lcom/wishabi/flipp/widget/j;->c:Landroid/widget/ListAdapter;

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/j;->removeAllViews()V

    iget-object v0, v1, Lcom/wishabi/flipp/widget/j;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, v1, Lcom/wishabi/flipp/widget/j;->a:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    iget-object v0, v1, Lcom/wishabi/flipp/widget/j;->c:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_2

    iget-object v0, v1, Lcom/wishabi/flipp/widget/j;->c:Landroid/widget/ListAdapter;

    iget-object v2, v1, Lcom/wishabi/flipp/widget/j;->f:Landroid/database/DataSetObserver;

    invoke-interface {v0, v2}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    iget-object v0, v1, Lcom/wishabi/flipp/widget/j;->c:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getViewTypeCount()I

    move-result v2

    const/4 v0, 0x0

    :goto_1
    if-ge v0, v2, :cond_2

    iget-object v3, v1, Lcom/wishabi/flipp/widget/j;->b:Ljava/util/List;

    new-instance v4, Ljava/util/Stack;

    invoke-direct {v4}, Ljava/util/Stack;-><init>()V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 682
    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->clear()V

    .line 684
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CollectionView;->c()V

    goto :goto_0
.end method

.method public setChoiceMode(I)V
    .locals 2

    .prologue
    .line 700
    iput p1, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    .line 701
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    if-eqz v0, :cond_0

    .line 702
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    invoke-virtual {v0}, Landroid/view/ActionMode;->finish()V

    .line 703
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    .line 705
    :cond_0
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    .line 706
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->e:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->clear()V

    .line 707
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/CollectionView;->setLongClickable(Z)V

    .line 709
    :cond_1
    return-void
.end method

.method public setEmptyView(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 650
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->g:Landroid/view/View;

    if-ne v0, p1, :cond_0

    .line 659
    :goto_0
    return-void

    .line 653
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->g:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 654
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 656
    :cond_1
    iput-object p1, p0, Lcom/wishabi/flipp/widget/CollectionView;->g:Landroid/view/View;

    .line 658
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/CollectionView;->c()V

    goto :goto_0
.end method

.method public setLayout(Lcom/wishabi/flipp/widget/n;)V
    .locals 2

    .prologue
    .line 753
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->f:Lcom/wishabi/flipp/widget/n;

    if-ne v0, p1, :cond_0

    .line 761
    :goto_0
    return-void

    .line 756
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->f:Lcom/wishabi/flipp/widget/n;

    if-eqz v0, :cond_1

    .line 757
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->f:Lcom/wishabi/flipp/widget/n;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/wishabi/flipp/widget/n;->a:Lcom/wishabi/flipp/widget/CollectionView;

    .line 759
    :cond_1
    iput-object p1, p0, Lcom/wishabi/flipp/widget/CollectionView;->f:Lcom/wishabi/flipp/widget/n;

    .line 760
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->f:Lcom/wishabi/flipp/widget/n;

    iput-object p0, v0, Lcom/wishabi/flipp/widget/n;->a:Lcom/wishabi/flipp/widget/CollectionView;

    goto :goto_0
.end method

.method public setMultiChoiceModeListener(Lcom/wishabi/flipp/widget/p;)V
    .locals 2

    .prologue
    .line 721
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->d:Lcom/wishabi/flipp/widget/q;

    if-nez v0, :cond_0

    .line 722
    new-instance v0, Lcom/wishabi/flipp/widget/q;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/wishabi/flipp/widget/q;-><init>(Lcom/wishabi/flipp/widget/CollectionView;B)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->d:Lcom/wishabi/flipp/widget/q;

    .line 724
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->d:Lcom/wishabi/flipp/widget/q;

    iput-object p1, v0, Lcom/wishabi/flipp/widget/q;->a:Lcom/wishabi/flipp/widget/p;

    .line 725
    return-void
.end method

.method public setOnItemClickListener(Lcom/wishabi/flipp/widget/r;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/wishabi/flipp/widget/CollectionView;->i:Lcom/wishabi/flipp/widget/r;

    .line 70
    return-void
.end method

.method public setOnItemLongClickListener(Lcom/wishabi/flipp/widget/s;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/wishabi/flipp/widget/CollectionView;->a:Lcom/wishabi/flipp/widget/s;

    .line 161
    return-void
.end method

.method public setOnScrollListener(Lcom/wishabi/flipp/widget/t;)V
    .locals 0

    .prologue
    .line 232
    iput-object p1, p0, Lcom/wishabi/flipp/widget/CollectionView;->j:Lcom/wishabi/flipp/widget/t;

    .line 233
    return-void
.end method

.method public startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;
    .locals 2

    .prologue
    .line 246
    iget v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->b:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    if-nez v0, :cond_0

    .line 247
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->d:Lcom/wishabi/flipp/widget/q;

    invoke-super {p0, v0}, Landroid/widget/ScrollView;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    .line 255
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    if-eqz v0, :cond_1

    .line 256
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    invoke-virtual {v0}, Landroid/view/ActionMode;->invalidate()V

    .line 258
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/CollectionView;->c:Landroid/view/ActionMode;

    return-object v0
.end method
