.class final Lcom/mobeta/android/dslv/p;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private a:Z

.field private b:J

.field private c:J

.field private d:I

.field private e:F

.field private f:J

.field private g:I

.field private h:F

.field private i:Z

.field private synthetic j:Lcom/mobeta/android/dslv/DragSortListView;


# direct methods
.method public constructor <init>(Lcom/mobeta/android/dslv/DragSortListView;)V
    .locals 1

    .prologue
    .line 2835
    iput-object p1, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2822
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mobeta/android/dslv/p;->i:Z

    .line 2836
    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 2

    .prologue
    .line 2839
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/p;->i:Z

    if-nez v0, :cond_0

    .line 2841
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mobeta/android/dslv/p;->a:Z

    .line 2842
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mobeta/android/dslv/p;->i:Z

    .line 2843
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/mobeta/android/dslv/p;->f:J

    .line 2844
    iget-wide v0, p0, Lcom/mobeta/android/dslv/p;->f:J

    iput-wide v0, p0, Lcom/mobeta/android/dslv/p;->b:J

    .line 2845
    iput p1, p0, Lcom/mobeta/android/dslv/p;->g:I

    .line 2846
    iget-object v0, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v0, p0}, Lcom/mobeta/android/dslv/DragSortListView;->post(Ljava/lang/Runnable;)Z

    .line 2848
    :cond_0
    return-void
.end method

.method public final a(Z)V
    .locals 1

    .prologue
    .line 2851
    iget-object v0, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v0, p0}, Lcom/mobeta/android/dslv/DragSortListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 2853
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mobeta/android/dslv/p;->i:Z

    .line 2855
    return-void
.end method

.method public final a()Z
    .locals 1

    .prologue
    .line 2828
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/p;->i:Z

    return v0
.end method

.method public final b()I
    .locals 1

    .prologue
    .line 2832
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/p;->i:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/mobeta/android/dslv/p;->g:I

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public final run()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 2863
    iget-boolean v0, p0, Lcom/mobeta/android/dslv/p;->a:Z

    if-eqz v0, :cond_0

    .line 2864
    iput-boolean v9, p0, Lcom/mobeta/android/dslv/p;->i:Z

    .line 2949
    :goto_0
    return-void

    .line 2870
    :cond_0
    iget-object v0, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/DragSortListView;->getFirstVisiblePosition()I

    move-result v1

    .line 2871
    iget-object v0, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v0}, Lcom/mobeta/android/dslv/DragSortListView;->getLastVisiblePosition()I

    move-result v0

    .line 2872
    iget-object v2, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v2}, Lcom/mobeta/android/dslv/DragSortListView;->getCount()I

    move-result v3

    .line 2873
    iget-object v2, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v2}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingTop()I

    move-result v2

    .line 2874
    iget-object v4, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v4}, Lcom/mobeta/android/dslv/DragSortListView;->getHeight()I

    move-result v4

    sub-int/2addr v4, v2

    iget-object v5, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v5}, Lcom/mobeta/android/dslv/DragSortListView;->getPaddingBottom()I

    move-result v5

    sub-int/2addr v4, v5

    .line 2876
    iget-object v5, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v5}, Lcom/mobeta/android/dslv/DragSortListView;->e(Lcom/mobeta/android/dslv/DragSortListView;)I

    move-result v5

    iget-object v6, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v6}, Lcom/mobeta/android/dslv/DragSortListView;->q(Lcom/mobeta/android/dslv/DragSortListView;)I

    move-result v6

    iget-object v7, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v7}, Lcom/mobeta/android/dslv/DragSortListView;->c(Lcom/mobeta/android/dslv/DragSortListView;)I

    move-result v7

    add-int/2addr v6, v7

    invoke-static {v5, v6}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 2877
    iget-object v6, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v6}, Lcom/mobeta/android/dslv/DragSortListView;->e(Lcom/mobeta/android/dslv/DragSortListView;)I

    move-result v6

    iget-object v7, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v7}, Lcom/mobeta/android/dslv/DragSortListView;->q(Lcom/mobeta/android/dslv/DragSortListView;)I

    move-result v7

    iget-object v8, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v8}, Lcom/mobeta/android/dslv/DragSortListView;->c(Lcom/mobeta/android/dslv/DragSortListView;)I

    move-result v8

    sub-int/2addr v7, v8

    invoke-static {v6, v7}, Ljava/lang/Math;->max(II)I

    move-result v6

    .line 2879
    iget v7, p0, Lcom/mobeta/android/dslv/p;->g:I

    if-nez v7, :cond_4

    .line 2880
    iget-object v3, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v3, v9}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 2882
    if-nez v3, :cond_1

    .line 2883
    iput-boolean v9, p0, Lcom/mobeta/android/dslv/p;->i:Z

    goto :goto_0

    .line 2886
    :cond_1
    if-nez v1, :cond_2

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v3

    if-ne v3, v2, :cond_2

    .line 2887
    iput-boolean v9, p0, Lcom/mobeta/android/dslv/p;->i:Z

    goto :goto_0

    .line 2891
    :cond_2
    iget-object v3, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v3}, Lcom/mobeta/android/dslv/DragSortListView;->t(Lcom/mobeta/android/dslv/DragSortListView;)Lcom/mobeta/android/dslv/o;

    move-result-object v3

    iget-object v5, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v5}, Lcom/mobeta/android/dslv/DragSortListView;->r(Lcom/mobeta/android/dslv/DragSortListView;)F

    move-result v5

    int-to-float v6, v6

    sub-float/2addr v5, v6

    iget-object v6, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v6}, Lcom/mobeta/android/dslv/DragSortListView;->s(Lcom/mobeta/android/dslv/DragSortListView;)F

    move-result v6

    div-float/2addr v5, v6

    invoke-virtual {v3, v5}, Lcom/mobeta/android/dslv/o;->a(F)F

    move-result v3

    iput v3, p0, Lcom/mobeta/android/dslv/p;->h:F

    .line 2908
    :goto_1
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v5

    iput-wide v5, p0, Lcom/mobeta/android/dslv/p;->c:J

    .line 2909
    iget-wide v5, p0, Lcom/mobeta/android/dslv/p;->c:J

    iget-wide v7, p0, Lcom/mobeta/android/dslv/p;->b:J

    sub-long/2addr v5, v7

    long-to-float v3, v5

    iput v3, p0, Lcom/mobeta/android/dslv/p;->e:F

    .line 2915
    iget v3, p0, Lcom/mobeta/android/dslv/p;->h:F

    iget v5, p0, Lcom/mobeta/android/dslv/p;->e:F

    mul-float/2addr v3, v5

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    iput v3, p0, Lcom/mobeta/android/dslv/p;->d:I

    .line 2918
    iget v3, p0, Lcom/mobeta/android/dslv/p;->d:I

    if-ltz v3, :cond_7

    .line 2919
    iget v0, p0, Lcom/mobeta/android/dslv/p;->d:I

    invoke-static {v4, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    iput v0, p0, Lcom/mobeta/android/dslv/p;->d:I

    move v0, v1

    .line 2926
    :goto_2
    iget-object v3, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    sub-int v1, v0, v1

    invoke-virtual {v3, v1}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 2927
    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v1

    iget v4, p0, Lcom/mobeta/android/dslv/p;->d:I

    add-int/2addr v1, v4

    .line 2929
    if-nez v0, :cond_3

    if-le v1, v2, :cond_3

    move v1, v2

    .line 2934
    :cond_3
    iget-object v4, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    const/4 v5, 0x1

    invoke-static {v4, v5}, Lcom/mobeta/android/dslv/DragSortListView;->b(Lcom/mobeta/android/dslv/DragSortListView;Z)Z

    .line 2936
    iget-object v4, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    sub-int/2addr v1, v2

    invoke-virtual {v4, v0, v1}, Lcom/mobeta/android/dslv/DragSortListView;->setSelectionFromTop(II)V

    .line 2937
    iget-object v1, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v1}, Lcom/mobeta/android/dslv/DragSortListView;->layoutChildren()V

    .line 2938
    iget-object v1, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v1}, Lcom/mobeta/android/dslv/DragSortListView;->invalidate()V

    .line 2940
    iget-object v1, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v1, v9}, Lcom/mobeta/android/dslv/DragSortListView;->b(Lcom/mobeta/android/dslv/DragSortListView;Z)Z

    .line 2943
    iget-object v1, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v1, v0, v3, v9}, Lcom/mobeta/android/dslv/DragSortListView;->c(Lcom/mobeta/android/dslv/DragSortListView;ILandroid/view/View;Z)V

    .line 2945
    iget-wide v0, p0, Lcom/mobeta/android/dslv/p;->c:J

    iput-wide v0, p0, Lcom/mobeta/android/dslv/p;->b:J

    .line 2948
    iget-object v0, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v0, p0}, Lcom/mobeta/android/dslv/DragSortListView;->post(Ljava/lang/Runnable;)Z

    goto/16 :goto_0

    .line 2894
    :cond_4
    iget-object v6, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    sub-int v7, v0, v1

    invoke-virtual {v6, v7}, Lcom/mobeta/android/dslv/DragSortListView;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    .line 2895
    if-nez v6, :cond_5

    .line 2896
    iput-boolean v9, p0, Lcom/mobeta/android/dslv/p;->i:Z

    goto/16 :goto_0

    .line 2899
    :cond_5
    add-int/lit8 v3, v3, -0x1

    if-ne v0, v3, :cond_6

    invoke-virtual {v6}, Landroid/view/View;->getBottom()I

    move-result v3

    add-int v6, v4, v2

    if-gt v3, v6, :cond_6

    .line 2900
    iput-boolean v9, p0, Lcom/mobeta/android/dslv/p;->i:Z

    goto/16 :goto_0

    .line 2904
    :cond_6
    iget-object v3, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v3}, Lcom/mobeta/android/dslv/DragSortListView;->t(Lcom/mobeta/android/dslv/DragSortListView;)Lcom/mobeta/android/dslv/o;

    move-result-object v3

    int-to-float v5, v5

    iget-object v6, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v6}, Lcom/mobeta/android/dslv/DragSortListView;->u(Lcom/mobeta/android/dslv/DragSortListView;)F

    move-result v6

    sub-float/2addr v5, v6

    iget-object v6, p0, Lcom/mobeta/android/dslv/p;->j:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-static {v6}, Lcom/mobeta/android/dslv/DragSortListView;->v(Lcom/mobeta/android/dslv/DragSortListView;)F

    move-result v6

    div-float/2addr v5, v6

    invoke-virtual {v3, v5}, Lcom/mobeta/android/dslv/o;->a(F)F

    move-result v3

    neg-float v3, v3

    iput v3, p0, Lcom/mobeta/android/dslv/p;->h:F

    goto/16 :goto_1

    .line 2922
    :cond_7
    neg-int v3, v4

    iget v4, p0, Lcom/mobeta/android/dslv/p;->d:I

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    iput v3, p0, Lcom/mobeta/android/dslv/p;->d:I

    goto/16 :goto_2
.end method
