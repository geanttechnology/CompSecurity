.class final Lcom/wishabi/flipp/widget/j;
.super Landroid/view/ViewGroup;
.source "SourceFile"


# static fields
.field static final synthetic g:Z


# instance fields
.field final a:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field final b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/util/Stack",
            "<",
            "Landroid/view/View;",
            ">;>;"
        }
    .end annotation
.end field

.field c:Landroid/widget/ListAdapter;

.field final d:Landroid/view/View$OnClickListener;

.field final e:Landroid/view/View$OnLongClickListener;

.field final f:Landroid/database/DataSetObserver;

.field final synthetic h:Lcom/wishabi/flipp/widget/CollectionView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 839
    const-class v0, Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/wishabi/flipp/widget/j;->g:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Lcom/wishabi/flipp/widget/CollectionView;Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 906
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/j;-><init>(Lcom/wishabi/flipp/widget/CollectionView;Landroid/content/Context;B)V

    .line 907
    return-void
.end method

.method private constructor <init>(Lcom/wishabi/flipp/widget/CollectionView;Landroid/content/Context;B)V
    .locals 1

    .prologue
    .line 910
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/j;-><init>(Lcom/wishabi/flipp/widget/CollectionView;Landroid/content/Context;C)V

    .line 911
    return-void
.end method

.method private constructor <init>(Lcom/wishabi/flipp/widget/CollectionView;Landroid/content/Context;C)V
    .locals 2

    .prologue
    .line 913
    iput-object p1, p0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    .line 914
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p2, v0, v1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 840
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/j;->a:Landroid/util/SparseArray;

    .line 841
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/j;->b:Ljava/util/List;

    .line 844
    new-instance v0, Lcom/wishabi/flipp/widget/k;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/widget/k;-><init>(Lcom/wishabi/flipp/widget/j;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/j;->d:Landroid/view/View$OnClickListener;

    .line 857
    new-instance v0, Lcom/wishabi/flipp/widget/l;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/widget/l;-><init>(Lcom/wishabi/flipp/widget/j;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/j;->e:Landroid/view/View$OnLongClickListener;

    .line 871
    new-instance v0, Lcom/wishabi/flipp/widget/m;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/widget/m;-><init>(Lcom/wishabi/flipp/widget/j;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/j;->f:Landroid/database/DataSetObserver;

    .line 915
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/j;)Landroid/util/SparseArray;
    .locals 1

    .prologue
    .line 839
    iget-object v0, p0, Lcom/wishabi/flipp/widget/j;->a:Landroid/util/SparseArray;

    return-object v0
.end method

.method private a(I)V
    .locals 13

    .prologue
    .line 972
    const-string v0, "layoutChildren"

    invoke-static {v0}, Lcom/wishabi/flipp/c/a;->a(Ljava/lang/String;)V

    .line 973
    iget-object v3, p0, Lcom/wishabi/flipp/widget/j;->c:Landroid/widget/ListAdapter;

    .line 974
    if-nez v3, :cond_0

    .line 1060
    :goto_0
    return-void

    .line 977
    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/j;->getWidth()I

    move-result v2

    .line 979
    iget-object v0, p0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getHeight()I

    move-result v0

    add-int v4, p1, v0

    .line 980
    iget-object v5, p0, Lcom/wishabi/flipp/widget/j;->a:Landroid/util/SparseArray;

    .line 981
    iget-object v6, p0, Lcom/wishabi/flipp/widget/j;->b:Ljava/util/List;

    .line 982
    iget-object v0, p0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/CollectionView;->d(Lcom/wishabi/flipp/widget/CollectionView;)Lcom/wishabi/flipp/widget/n;

    move-result-object v7

    .line 983
    iget-object v8, p0, Lcom/wishabi/flipp/widget/j;->d:Landroid/view/View$OnClickListener;

    .line 984
    iget-object v9, p0, Lcom/wishabi/flipp/widget/j;->e:Landroid/view/View$OnLongClickListener;

    .line 986
    const/4 v0, 0x0

    move v1, v0

    :goto_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/j;->getChildCount()I

    move-result v0

    if-ge v1, v0, :cond_5

    .line 987
    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/j;->getChildAt(I)Landroid/view/View;

    move-result-object v10

    .line 988
    sget-boolean v0, Lcom/wishabi/flipp/widget/j;->g:Z

    if-nez v0, :cond_1

    if-nez v10, :cond_1

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 990
    :cond_1
    invoke-virtual {v10}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/o;

    .line 992
    sget-boolean v11, Lcom/wishabi/flipp/widget/j;->g:Z

    if-nez v11, :cond_2

    if-nez v0, :cond_2

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 993
    :cond_2
    iget v0, v0, Lcom/wishabi/flipp/widget/o;->d:I

    .line 995
    invoke-virtual {v7, v0}, Lcom/wishabi/flipp/widget/n;->a(I)Lcom/wishabi/flipp/widget/o;

    move-result-object v11

    .line 997
    iget-object v11, v11, Lcom/wishabi/flipp/widget/o;->a:Landroid/graphics/Rect;

    const/4 v12, 0x0

    invoke-virtual {v11, v12, p1, v2, v4}, Landroid/graphics/Rect;->intersects(IIII)Z

    move-result v11

    if-nez v11, :cond_3

    .line 998
    invoke-virtual {v5, v0}, Landroid/util/SparseArray;->delete(I)V

    .line 999
    invoke-interface {v3, v0}, Landroid/widget/ListAdapter;->getItemViewType(I)I

    move-result v0

    .line 1000
    const/4 v11, -0x1

    if-eq v0, v11, :cond_4

    .line 1001
    invoke-interface {v6, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Stack;

    .line 1002
    invoke-virtual {v0, v10}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1008
    :cond_3
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    .line 1010
    goto :goto_1

    .line 1005
    :cond_4
    invoke-virtual {p0, v10}, Lcom/wishabi/flipp/widget/j;->removeViewInLayout(Landroid/view/View;)V

    goto :goto_1

    .line 1013
    :cond_5
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/j;->detachAllViewsFromParent()V

    .line 1016
    invoke-virtual {v7, p1, v2, v4}, Lcom/wishabi/flipp/widget/n;->a(III)Ljava/util/List;

    move-result-object v0

    .line 1018
    invoke-static {}, Lcom/wishabi/flipp/widget/CollectionView;->b()Ljava/util/Comparator;

    move-result-object v1

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 1022
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_6
    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Lcom/wishabi/flipp/widget/o;

    .line 1023
    iget v7, v1, Lcom/wishabi/flipp/widget/o;->d:I

    .line 1025
    invoke-virtual {v5, v7}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 1026
    if-eqz v0, :cond_7

    .line 1027
    const/4 v2, -0x1

    invoke-virtual {p0, v0, v2, v1}, Lcom/wishabi/flipp/widget/j;->attachViewToParent(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 1052
    :goto_3
    iget-object v1, v1, Lcom/wishabi/flipp/widget/o;->a:Landroid/graphics/Rect;

    .line 1053
    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v2

    const/high16 v10, 0x40000000    # 2.0f

    invoke-static {v2, v10}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v10

    const/high16 v11, 0x40000000    # 2.0f

    invoke-static {v10, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v10

    invoke-virtual {v0, v2, v10}, Landroid/view/View;->measure(II)V

    .line 1056
    iget v2, v1, Landroid/graphics/Rect;->left:I

    iget v10, v1, Landroid/graphics/Rect;->top:I

    iget v11, v1, Landroid/graphics/Rect;->right:I

    iget v1, v1, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v0, v2, v10, v11, v1}, Landroid/view/View;->layout(IIII)V

    .line 1057
    iget-object v1, p0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/CollectionView;->b(Lcom/wishabi/flipp/widget/CollectionView;)Landroid/util/SparseBooleanArray;

    move-result-object v1

    invoke-virtual {v1, v7}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    goto :goto_2

    .line 1029
    :cond_7
    invoke-interface {v3, v7}, Landroid/widget/ListAdapter;->getItemViewType(I)I

    move-result v2

    .line 1030
    const/4 v0, 0x0

    .line 1031
    const/4 v10, -0x1

    if-eq v2, v10, :cond_8

    .line 1032
    invoke-interface {v6, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Stack;

    .line 1033
    invoke-virtual {v0}, Ljava/util/Stack;->empty()Z

    move-result v2

    if-eqz v2, :cond_a

    const/4 v0, 0x0

    .line 1035
    :cond_8
    :goto_4
    invoke-interface {v3, v7, v0, p0}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 1036
    if-eqz v2, :cond_6

    .line 1037
    if-eq v2, v0, :cond_b

    .line 1040
    const/4 v0, -0x1

    invoke-virtual {p0, v2, v0, v1}, Lcom/wishabi/flipp/widget/j;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)Z

    .line 1042
    iget-boolean v0, v1, Lcom/wishabi/flipp/widget/o;->f:Z

    if-eqz v0, :cond_9

    .line 1043
    invoke-virtual {v2, v8}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1044
    invoke-virtual {v2, v9}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 1049
    :cond_9
    :goto_5
    invoke-virtual {v5, v7, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    move-object v0, v2

    goto :goto_3

    .line 1033
    :cond_a
    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    goto :goto_4

    .line 1047
    :cond_b
    const/4 v0, -0x1

    invoke-virtual {p0, v2, v0, v1}, Lcom/wishabi/flipp/widget/j;->attachViewToParent(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    goto :goto_5

    .line 1059
    :cond_c
    invoke-static {}, Lcom/wishabi/flipp/c/a;->a()V

    goto/16 :goto_0
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/j;I)V
    .locals 0

    .prologue
    .line 839
    invoke-direct {p0, p1}, Lcom/wishabi/flipp/widget/j;->a(I)V

    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/widget/j;)Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 839
    iget-object v0, p0, Lcom/wishabi/flipp/widget/j;->c:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/widget/j;)Ljava/util/List;
    .locals 1

    .prologue
    .line 839
    iget-object v0, p0, Lcom/wishabi/flipp/widget/j;->b:Ljava/util/List;

    return-object v0
.end method


# virtual methods
.method public final a()V
    .locals 5

    .prologue
    .line 918
    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/j;->getChildCount()I

    move-result v2

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_2

    .line 919
    invoke-virtual {p0, v1}, Lcom/wishabi/flipp/widget/j;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 920
    sget-boolean v0, Lcom/wishabi/flipp/widget/j;->g:Z

    if-nez v0, :cond_0

    if-nez v3, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 921
    :cond_0
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/o;

    .line 923
    sget-boolean v4, Lcom/wishabi/flipp/widget/j;->g:Z

    if-nez v4, :cond_1

    if-nez v0, :cond_1

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 924
    :cond_1
    iget v0, v0, Lcom/wishabi/flipp/widget/o;->d:I

    .line 925
    iget-object v4, p0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v4}, Lcom/wishabi/flipp/widget/CollectionView;->b(Lcom/wishabi/flipp/widget/CollectionView;)Landroid/util/SparseBooleanArray;

    move-result-object v4

    invoke-virtual {v4, v0}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v0

    invoke-virtual {v3, v0}, Landroid/view/View;->setActivated(Z)V

    .line 918
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 927
    :cond_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/j;->invalidate()V

    .line 928
    return-void
.end method

.method protected final onLayout(ZIIII)V
    .locals 1

    .prologue
    .line 968
    iget-object v0, p0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getScrollY()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/widget/j;->a(I)V

    .line 969
    return-void
.end method

.method protected final onMeasure(II)V
    .locals 2

    .prologue
    .line 957
    iget-object v0, p0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/CollectionView;->d(Lcom/wishabi/flipp/widget/CollectionView;)Lcom/wishabi/flipp/widget/n;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 958
    iget-object v0, p0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/CollectionView;->d(Lcom/wishabi/flipp/widget/CollectionView;)Lcom/wishabi/flipp/widget/n;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/n;->c()V

    .line 959
    iget-object v0, p0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/CollectionView;->d(Lcom/wishabi/flipp/widget/CollectionView;)Lcom/wishabi/flipp/widget/n;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/n;->a()I

    move-result v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/j;->h:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-static {v1}, Lcom/wishabi/flipp/widget/CollectionView;->d(Lcom/wishabi/flipp/widget/CollectionView;)Lcom/wishabi/flipp/widget/n;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/n;->b()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/widget/j;->setMeasuredDimension(II)V

    .line 964
    :goto_0
    return-void

    .line 961
    :cond_0
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/wishabi/flipp/widget/j;->setMeasuredDimension(II)V

    goto :goto_0
.end method
