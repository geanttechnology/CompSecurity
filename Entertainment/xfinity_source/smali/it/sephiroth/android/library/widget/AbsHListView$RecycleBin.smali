.class public Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;
.super Ljava/lang/Object;
.source "AbsHListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AbsHListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "RecycleBin"
.end annotation


# instance fields
.field private mActiveViews:[Landroid/view/View;

.field private mCurrentScrap:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mFirstActivePosition:I

.field private mRecyclerListener:Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;

.field private mScrapViews:[Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mSkippedScrap:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/SparseArrayCompat",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mViewTypeCount:I

.field final synthetic this$0:Lit/sephiroth/android/library/widget/AbsHListView;


# direct methods
.method public constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 1

    .prologue
    .line 5457
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 5471
    const/4 v0, 0x0

    new-array v0, v0, [Landroid/view/View;

    iput-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mActiveViews:[Landroid/view/View;

    return-void
.end method

.method static synthetic access$2202(Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;)Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;
    .param p1, "x1"    # Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;

    .prologue
    .line 5457
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mRecyclerListener:Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;

    return-object p1
.end method

.method private pruneScrapViews()V
    .locals 13
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 5766
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mActiveViews:[Landroid/view/View;

    array-length v3, v10

    .line 5767
    .local v3, "maxViews":I
    iget v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    .line 5768
    .local v9, "viewTypeCount":I
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mScrapViews:[Ljava/util/ArrayList;

    .line 5769
    .local v5, "scrapViews":[Ljava/util/ArrayList;, "[Ljava/util/ArrayList<Landroid/view/View;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v9, :cond_1

    .line 5770
    aget-object v4, v5, v1

    .line 5771
    .local v4, "scrapPile":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v6

    .line 5772
    .local v6, "size":I
    sub-int v0, v6, v3

    .line 5773
    .local v0, "extras":I
    add-int/lit8 v6, v6, -0x1

    .line 5774
    const/4 v2, 0x0

    .local v2, "j":I
    move v7, v6

    .end local v6    # "size":I
    .local v7, "size":I
    :goto_1
    if-ge v2, v0, :cond_0

    .line 5775
    iget-object v11, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    add-int/lit8 v6, v7, -0x1

    .end local v7    # "size":I
    .restart local v6    # "size":I
    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/view/View;

    const/4 v12, 0x0

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->removeDetachedView(Landroid/view/View;Z)V
    invoke-static {v11, v10, v12}, Lit/sephiroth/android/library/widget/AbsHListView;->access$2700(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Z)V

    .line 5774
    add-int/lit8 v2, v2, 0x1

    move v7, v6

    .end local v6    # "size":I
    .restart local v7    # "size":I
    goto :goto_1

    .line 5769
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 5779
    .end local v0    # "extras":I
    .end local v2    # "j":I
    .end local v4    # "scrapPile":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v7    # "size":I
    :cond_1
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v10, :cond_3

    .line 5780
    const/4 v1, 0x0

    :goto_2
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v10}, Landroid/support/v4/util/SparseArrayCompat;->size()I

    move-result v10

    if-ge v1, v10, :cond_3

    .line 5781
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v10, v1}, Landroid/support/v4/util/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/view/View;

    .line 5784
    .local v8, "v":Landroid/view/View;
    invoke-virtual {v8}, Landroid/view/View;->hasTransientState()Z

    move-result v10

    if-nez v10, :cond_2

    .line 5785
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v10, v1}, Landroid/support/v4/util/SparseArrayCompat;->removeAt(I)V

    .line 5786
    add-int/lit8 v1, v1, -0x1

    .line 5780
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 5790
    .end local v8    # "v":Landroid/view/View;
    :cond_3
    return-void
.end method


# virtual methods
.method public addScrapView(Landroid/view/View;I)V
    .locals 5
    .param p1, "scrap"    # Landroid/view/View;
    .param p2, "position"    # I
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 5645
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 5646
    .local v0, "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    if-nez v0, :cond_1

    .line 5689
    :cond_0
    :goto_0
    return-void

    .line 5650
    :cond_1
    iput p2, v0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->scrappedFromPosition:I

    .line 5654
    iget v2, v0, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    .line 5656
    .local v2, "viewType":I
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x10

    if-lt v3, v4, :cond_7

    invoke-virtual {p1}, Landroid/view/View;->hasTransientState()Z

    move-result v1

    .line 5658
    .local v1, "scrapHasTransientState":Z
    :goto_1
    invoke-virtual {p0, v2}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->shouldRecycleViewType(I)Z

    move-result v3

    if-eqz v3, :cond_2

    if-eqz v1, :cond_8

    .line 5659
    :cond_2
    const/4 v3, -0x2

    if-ne v2, v3, :cond_3

    if-eqz v1, :cond_5

    .line 5660
    :cond_3
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mSkippedScrap:Ljava/util/ArrayList;

    if-nez v3, :cond_4

    .line 5661
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mSkippedScrap:Ljava/util/ArrayList;

    .line 5663
    :cond_4
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mSkippedScrap:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 5665
    :cond_5
    if-eqz v1, :cond_0

    .line 5666
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    if-nez v3, :cond_6

    .line 5667
    new-instance v3, Landroid/support/v4/util/SparseArrayCompat;

    invoke-direct {v3}, Landroid/support/v4/util/SparseArrayCompat;-><init>()V

    iput-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    .line 5669
    :cond_6
    invoke-virtual {p1}, Landroid/view/View;->onStartTemporaryDetach()V

    .line 5670
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v3, p2, p1}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    goto :goto_0

    .line 5656
    .end local v1    # "scrapHasTransientState":Z
    :cond_7
    const/4 v1, 0x0

    goto :goto_1

    .line 5675
    .restart local v1    # "scrapHasTransientState":Z
    :cond_8
    invoke-virtual {p1}, Landroid/view/View;->onStartTemporaryDetach()V

    .line 5676
    iget v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_a

    .line 5677
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mCurrentScrap:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 5682
    :goto_2
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xe

    if-lt v3, v4, :cond_9

    .line 5683
    const/4 v3, 0x0

    invoke-virtual {p1, v3}, Landroid/view/View;->setAccessibilityDelegate(Landroid/view/View$AccessibilityDelegate;)V

    .line 5686
    :cond_9
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mRecyclerListener:Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;

    if-eqz v3, :cond_0

    .line 5687
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mRecyclerListener:Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;

    invoke-interface {v3, p1}, Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;->onMovedToScrapHeap(Landroid/view/View;)V

    goto :goto_0

    .line 5679
    :cond_a
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mScrapViews:[Ljava/util/ArrayList;

    aget-object v3, v3, v2

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2
.end method

.method public clear()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 5534
    iget v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 5535
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mCurrentScrap:Ljava/util/ArrayList;

    .line 5536
    .local v2, "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 5537
    .local v3, "scrapCount":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_2

    .line 5538
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    add-int/lit8 v5, v3, -0x1

    sub-int/2addr v5, v0

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/View;

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->removeDetachedView(Landroid/view/View;Z)V
    invoke-static {v6, v5, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->access$2300(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Z)V

    .line 5537
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 5541
    .end local v0    # "i":I
    .end local v2    # "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v3    # "scrapCount":I
    :cond_0
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    .line 5542
    .local v4, "typeCount":I
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_1
    if-ge v0, v4, :cond_2

    .line 5543
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mScrapViews:[Ljava/util/ArrayList;

    aget-object v2, v5, v0

    .line 5544
    .restart local v2    # "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 5545
    .restart local v3    # "scrapCount":I
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_2
    if-ge v1, v3, :cond_1

    .line 5546
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    add-int/lit8 v5, v3, -0x1

    sub-int/2addr v5, v1

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/View;

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->removeDetachedView(Landroid/view/View;Z)V
    invoke-static {v6, v5, v7}, Lit/sephiroth/android/library/widget/AbsHListView;->access$2400(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Z)V

    .line 5545
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 5542
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 5550
    .end local v1    # "j":I
    .end local v2    # "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v3    # "scrapCount":I
    .end local v4    # "typeCount":I
    :cond_2
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v5, :cond_3

    .line 5551
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v5}, Landroid/support/v4/util/SparseArrayCompat;->clear()V

    .line 5553
    :cond_3
    return-void
.end method

.method clearTransientStateViews()V
    .locals 1

    .prologue
    .line 5617
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v0, :cond_0

    .line 5618
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v0}, Landroid/support/v4/util/SparseArrayCompat;->clear()V

    .line 5620
    :cond_0
    return-void
.end method

.method public fillActiveViews(II)V
    .locals 6
    .param p1, "childCount"    # I
    .param p2, "firstActivePosition"    # I

    .prologue
    .line 5564
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mActiveViews:[Landroid/view/View;

    array-length v4, v4

    if-ge v4, p1, :cond_0

    .line 5565
    new-array v4, p1, [Landroid/view/View;

    iput-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mActiveViews:[Landroid/view/View;

    .line 5567
    :cond_0
    iput p2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mFirstActivePosition:I

    .line 5569
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mActiveViews:[Landroid/view/View;

    .line 5570
    .local v0, "activeViews":[Landroid/view/View;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, p1, :cond_2

    .line 5571
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v4, v2}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 5572
    .local v1, "child":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 5574
    .local v3, "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    if-eqz v3, :cond_1

    iget v4, v3, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    const/4 v5, -0x2

    if-eq v4, v5, :cond_1

    .line 5577
    aput-object v1, v0, v2

    .line 5570
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 5580
    .end local v1    # "child":Landroid/view/View;
    .end local v3    # "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    :cond_2
    return-void
.end method

.method public getActiveView(I)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I

    .prologue
    const/4 v3, 0x0

    .line 5590
    iget v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mFirstActivePosition:I

    sub-int v1, p1, v4

    .line 5591
    .local v1, "index":I
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mActiveViews:[Landroid/view/View;

    .line 5592
    .local v0, "activeViews":[Landroid/view/View;
    if-ltz v1, :cond_0

    array-length v4, v0

    if-ge v1, v4, :cond_0

    .line 5593
    aget-object v2, v0, v1

    .line 5594
    .local v2, "match":Landroid/view/View;
    aput-object v3, v0, v1

    .line 5597
    .end local v2    # "match":Landroid/view/View;
    :goto_0
    return-object v2

    :cond_0
    move-object v2, v3

    goto :goto_0
.end method

.method getScrapView(I)Landroid/view/View;
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 5626
    iget v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 5627
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mCurrentScrap:Ljava/util/ArrayList;

    invoke-static {v1, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->retrieveFromScrap(Ljava/util/ArrayList;I)Landroid/view/View;

    move-result-object v1

    .line 5634
    :goto_0
    return-object v1

    .line 5629
    :cond_0
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v1, v1, Lit/sephiroth/android/library/widget/AbsHListView;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v1, p1}, Landroid/widget/ListAdapter;->getItemViewType(I)I

    move-result v0

    .line 5630
    .local v0, "whichScrap":I
    if-ltz v0, :cond_1

    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mScrapViews:[Ljava/util/ArrayList;

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 5631
    iget-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mScrapViews:[Ljava/util/ArrayList;

    aget-object v1, v1, v0

    invoke-static {v1, p1}, Lit/sephiroth/android/library/widget/AbsHListView;->retrieveFromScrap(Ljava/util/ArrayList;I)Landroid/view/View;

    move-result-object v1

    goto :goto_0

    .line 5634
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method getTransientStateView(I)Landroid/view/View;
    .locals 3
    .param p1, "position"    # I

    .prologue
    const/4 v1, 0x0

    .line 5601
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    if-nez v2, :cond_1

    .line 5610
    :cond_0
    :goto_0
    return-object v1

    .line 5604
    :cond_1
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v2, p1}, Landroid/support/v4/util/SparseArrayCompat;->indexOfKey(I)I

    move-result v0

    .line 5605
    .local v0, "index":I
    if-ltz v0, :cond_0

    .line 5608
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v2, v0}, Landroid/support/v4/util/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    .line 5609
    .local v1, "result":Landroid/view/View;
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v2, v0}, Landroid/support/v4/util/SparseArrayCompat;->removeAt(I)V

    goto :goto_0
.end method

.method public markChildrenDirty()V
    .locals 8

    .prologue
    .line 5502
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    const/4 v7, 0x1

    if-ne v6, v7, :cond_0

    .line 5503
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mCurrentScrap:Ljava/util/ArrayList;

    .line 5504
    .local v3, "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 5505
    .local v4, "scrapCount":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v4, :cond_2

    .line 5506
    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->forceLayout()V

    .line 5505
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 5509
    .end local v1    # "i":I
    .end local v3    # "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v4    # "scrapCount":I
    :cond_0
    iget v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    .line 5510
    .local v5, "typeCount":I
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_1
    if-ge v1, v5, :cond_2

    .line 5511
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mScrapViews:[Ljava/util/ArrayList;

    aget-object v3, v6, v1

    .line 5512
    .restart local v3    # "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 5513
    .restart local v4    # "scrapCount":I
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_2
    if-ge v2, v4, :cond_1

    .line 5514
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->forceLayout()V

    .line 5513
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 5510
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 5518
    .end local v2    # "j":I
    .end local v3    # "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v4    # "scrapCount":I
    .end local v5    # "typeCount":I
    :cond_2
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    if-eqz v6, :cond_3

    .line 5519
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v6}, Landroid/support/v4/util/SparseArrayCompat;->size()I

    move-result v0

    .line 5520
    .local v0, "count":I
    const/4 v1, 0x0

    :goto_3
    if-ge v1, v0, :cond_3

    .line 5521
    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v6, v1}, Landroid/support/v4/util/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->forceLayout()V

    .line 5520
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 5524
    .end local v0    # "count":I
    :cond_3
    return-void
.end method

.method public removeSkippedScrap()V
    .locals 5

    .prologue
    .line 5695
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mSkippedScrap:Ljava/util/ArrayList;

    if-nez v2, :cond_0

    .line 5703
    :goto_0
    return-void

    .line 5698
    :cond_0
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mSkippedScrap:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 5699
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v0, :cond_1

    .line 5700
    iget-object v3, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mSkippedScrap:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    const/4 v4, 0x0

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->removeDetachedView(Landroid/view/View;Z)V
    invoke-static {v3, v2, v4}, Lit/sephiroth/android/library/widget/AbsHListView;->access$2500(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Z)V

    .line 5699
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 5702
    :cond_1
    iget-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mSkippedScrap:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    goto :goto_0
.end method

.method public scrapActiveViews()V
    .locals 14
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v13, 0x0

    const/4 v10, 0x1

    const/4 v11, 0x0

    .line 5710
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mActiveViews:[Landroid/view/View;

    .line 5711
    .local v0, "activeViews":[Landroid/view/View;
    iget-object v12, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mRecyclerListener:Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;

    if-eqz v12, :cond_5

    move v2, v10

    .line 5712
    .local v2, "hasListener":Z
    :goto_0
    iget v12, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    if-le v12, v10, :cond_6

    move v5, v10

    .line 5714
    .local v5, "multipleScraps":Z
    :goto_1
    iget-object v7, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mCurrentScrap:Ljava/util/ArrayList;

    .line 5715
    .local v7, "scrapViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    array-length v1, v0

    .line 5716
    .local v1, "count":I
    add-int/lit8 v3, v1, -0x1

    .local v3, "i":I
    :goto_2
    if-ltz v3, :cond_b

    .line 5717
    aget-object v8, v0, v3

    .line 5718
    .local v8, "victim":Landroid/view/View;
    if-eqz v8, :cond_4

    .line 5719
    invoke-virtual {v8}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;

    .line 5720
    .local v4, "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    iget v9, v4, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->viewType:I

    .line 5722
    .local v9, "whichScrap":I
    aput-object v13, v0, v3

    .line 5724
    sget v10, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v12, 0x10

    if-lt v10, v12, :cond_7

    invoke-virtual {v8}, Landroid/view/View;->hasTransientState()Z

    move-result v6

    .line 5725
    .local v6, "scrapHasTransientState":Z
    :goto_3
    invoke-virtual {p0, v9}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->shouldRecycleViewType(I)Z

    move-result v10

    if-eqz v10, :cond_0

    if-eqz v6, :cond_8

    .line 5727
    :cond_0
    const/4 v10, -0x2

    if-ne v9, v10, :cond_1

    if-eqz v6, :cond_2

    .line 5729
    :cond_1
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    # invokes: Lit/sephiroth/android/library/widget/AbsHListView;->removeDetachedView(Landroid/view/View;Z)V
    invoke-static {v10, v8, v11}, Lit/sephiroth/android/library/widget/AbsHListView;->access$2600(Lit/sephiroth/android/library/widget/AbsHListView;Landroid/view/View;Z)V

    .line 5731
    :cond_2
    if-eqz v6, :cond_4

    .line 5732
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    if-nez v10, :cond_3

    .line 5733
    new-instance v10, Landroid/support/v4/util/SparseArrayCompat;

    invoke-direct {v10}, Landroid/support/v4/util/SparseArrayCompat;-><init>()V

    iput-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    .line 5735
    :cond_3
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mTransientStateViews:Landroid/support/v4/util/SparseArrayCompat;

    iget v12, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mFirstActivePosition:I

    add-int/2addr v12, v3

    invoke-virtual {v10, v12, v8}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    .line 5716
    .end local v4    # "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    .end local v6    # "scrapHasTransientState":Z
    .end local v9    # "whichScrap":I
    :cond_4
    :goto_4
    add-int/lit8 v3, v3, -0x1

    goto :goto_2

    .end local v1    # "count":I
    .end local v2    # "hasListener":Z
    .end local v3    # "i":I
    .end local v5    # "multipleScraps":Z
    .end local v7    # "scrapViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v8    # "victim":Landroid/view/View;
    :cond_5
    move v2, v11

    .line 5711
    goto :goto_0

    .restart local v2    # "hasListener":Z
    :cond_6
    move v5, v11

    .line 5712
    goto :goto_1

    .restart local v1    # "count":I
    .restart local v3    # "i":I
    .restart local v4    # "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    .restart local v5    # "multipleScraps":Z
    .restart local v7    # "scrapViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .restart local v8    # "victim":Landroid/view/View;
    .restart local v9    # "whichScrap":I
    :cond_7
    move v6, v11

    .line 5724
    goto :goto_3

    .line 5740
    .restart local v6    # "scrapHasTransientState":Z
    :cond_8
    if-eqz v5, :cond_9

    .line 5741
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mScrapViews:[Ljava/util/ArrayList;

    aget-object v7, v10, v9

    .line 5743
    :cond_9
    invoke-virtual {v8}, Landroid/view/View;->onStartTemporaryDetach()V

    .line 5744
    iget v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mFirstActivePosition:I

    add-int/2addr v10, v3

    iput v10, v4, Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;->scrappedFromPosition:I

    .line 5745
    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 5747
    sget v10, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v12, 0xe

    if-lt v10, v12, :cond_a

    .line 5748
    invoke-virtual {v8, v13}, Landroid/view/View;->setAccessibilityDelegate(Landroid/view/View$AccessibilityDelegate;)V

    .line 5751
    :cond_a
    if-eqz v2, :cond_4

    .line 5752
    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mRecyclerListener:Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;

    invoke-interface {v10, v8}, Lit/sephiroth/android/library/widget/AbsHListView$RecyclerListener;->onMovedToScrapHeap(Landroid/view/View;)V

    goto :goto_4

    .line 5757
    .end local v4    # "lp":Lit/sephiroth/android/library/widget/AbsHListView$LayoutParams;
    .end local v6    # "scrapHasTransientState":Z
    .end local v8    # "victim":Landroid/view/View;
    .end local v9    # "whichScrap":I
    :cond_b
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->pruneScrapViews()V

    .line 5758
    return-void
.end method

.method setCacheColorHint(I)V
    .locals 10
    .param p1, "color"    # I

    .prologue
    .line 5815
    iget v8, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    const/4 v9, 0x1

    if-ne v8, v9, :cond_0

    .line 5816
    iget-object v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mCurrentScrap:Ljava/util/ArrayList;

    .line 5817
    .local v4, "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 5818
    .local v5, "scrapCount":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v5, :cond_2

    .line 5819
    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/view/View;

    invoke-virtual {v8, p1}, Landroid/view/View;->setDrawingCacheBackgroundColor(I)V

    .line 5818
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 5822
    .end local v2    # "i":I
    .end local v4    # "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v5    # "scrapCount":I
    :cond_0
    iget v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    .line 5823
    .local v6, "typeCount":I
    const/4 v2, 0x0

    .restart local v2    # "i":I
    :goto_1
    if-ge v2, v6, :cond_2

    .line 5824
    iget-object v8, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mScrapViews:[Ljava/util/ArrayList;

    aget-object v4, v8, v2

    .line 5825
    .restart local v4    # "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 5826
    .restart local v5    # "scrapCount":I
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_2
    if-ge v3, v5, :cond_1

    .line 5827
    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/view/View;

    invoke-virtual {v8, p1}, Landroid/view/View;->setDrawingCacheBackgroundColor(I)V

    .line 5826
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 5823
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 5832
    .end local v3    # "j":I
    .end local v4    # "scrap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v5    # "scrapCount":I
    .end local v6    # "typeCount":I
    :cond_2
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mActiveViews:[Landroid/view/View;

    .line 5833
    .local v0, "activeViews":[Landroid/view/View;
    array-length v1, v0

    .line 5834
    .local v1, "count":I
    const/4 v2, 0x0

    :goto_3
    if-ge v2, v1, :cond_4

    .line 5835
    aget-object v7, v0, v2

    .line 5836
    .local v7, "victim":Landroid/view/View;
    if-eqz v7, :cond_3

    .line 5837
    invoke-virtual {v7, p1}, Landroid/view/View;->setDrawingCacheBackgroundColor(I)V

    .line 5834
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 5840
    .end local v7    # "victim":Landroid/view/View;
    :cond_4
    return-void
.end method

.method public setViewTypeCount(I)V
    .locals 4
    .param p1, "viewTypeCount"    # I

    .prologue
    .line 5488
    const/4 v2, 0x1

    if-ge p1, v2, :cond_0

    .line 5489
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Can\'t have a viewTypeCount < 1"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 5492
    :cond_0
    new-array v1, p1, [Ljava/util/ArrayList;

    .line 5493
    .local v1, "scrapViews":[Ljava/util/ArrayList;, "[Ljava/util/ArrayList<Landroid/view/View;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p1, :cond_1

    .line 5494
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    aput-object v2, v1, v0

    .line 5493
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 5496
    :cond_1
    iput p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mViewTypeCount:I

    .line 5497
    const/4 v2, 0x0

    aget-object v2, v1, v2

    iput-object v2, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mCurrentScrap:Ljava/util/ArrayList;

    .line 5498
    iput-object v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$RecycleBin;->mScrapViews:[Ljava/util/ArrayList;

    .line 5499
    return-void
.end method

.method public shouldRecycleViewType(I)Z
    .locals 1
    .param p1, "viewType"    # I

    .prologue
    .line 5527
    if-ltz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
