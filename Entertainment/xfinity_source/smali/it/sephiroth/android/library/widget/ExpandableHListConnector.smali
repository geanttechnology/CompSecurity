.class Lit/sephiroth/android/library/widget/ExpandableHListConnector;
.super Landroid/widget/BaseAdapter;
.source "ExpandableHListConnector.java"

# interfaces
.implements Landroid/widget/Filterable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;,
        Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;,
        Lit/sephiroth/android/library/widget/ExpandableHListConnector$MyDataSetObserver;
    }
.end annotation


# instance fields
.field private final mDataSetObserver:Landroid/database/DataSetObserver;

.field private mExpGroupMetadataList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;",
            ">;"
        }
    .end annotation
.end field

.field private mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

.field private mMaxExpGroupCount:I

.field private mTotalExpChildrenCount:I


# direct methods
.method public constructor <init>(Landroid/widget/ExpandableListAdapter;)V
    .locals 1
    .param p1, "expandableListAdapter"    # Landroid/widget/ExpandableListAdapter;

    .prologue
    .line 76
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 68
    const v0, 0x7fffffff

    iput v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mMaxExpGroupCount:I

    .line 71
    new-instance v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$MyDataSetObserver;

    invoke-direct {v0, p0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$MyDataSetObserver;-><init>(Lit/sephiroth/android/library/widget/ExpandableHListConnector;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mDataSetObserver:Landroid/database/DataSetObserver;

    .line 77
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    .line 79
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->setExpandableListAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 80
    return-void
.end method

.method static synthetic access$000(Lit/sephiroth/android/library/widget/ExpandableHListConnector;ZZ)V
    .locals 0
    .param p0, "x0"    # Lit/sephiroth/android/library/widget/ExpandableHListConnector;
    .param p1, "x1"    # Z
    .param p2, "x2"    # Z

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->refreshExpGroupMetadataList(ZZ)V

    return-void
.end method

.method private refreshExpGroupMetadataList(ZZ)V
    .locals 13
    .param p1, "forceChildrenCountRefresh"    # Z
    .param p2, "syncGroupPositions"    # Z

    .prologue
    const/4 v12, -0x1

    .line 519
    iget-object v2, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    .line 520
    .local v2, "egml":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 521
    .local v3, "egmlSize":I
    const/4 v0, 0x0

    .line 524
    .local v0, "curFlPos":I
    const/4 v9, 0x0

    iput v9, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mTotalExpChildrenCount:I

    .line 526
    if-eqz p2, :cond_3

    .line 528
    const/4 v8, 0x0

    .line 530
    .local v8, "positionsChanged":Z
    add-int/lit8 v5, v3, -0x1

    .local v5, "i":I
    :goto_0
    if-ltz v5, :cond_2

    .line 531
    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .line 532
    .local v1, "curGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    iget-wide v10, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gId:J

    iget v9, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    invoke-virtual {p0, v10, v11, v9}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->findGroupPosition(JI)I

    move-result v7

    .line 533
    .local v7, "newGPos":I
    iget v9, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    if-eq v7, v9, :cond_1

    .line 534
    if-ne v7, v12, :cond_0

    .line 536
    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 537
    add-int/lit8 v3, v3, -0x1

    .line 540
    :cond_0
    iput v7, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    .line 541
    if-nez v8, :cond_1

    const/4 v8, 0x1

    .line 530
    :cond_1
    add-int/lit8 v5, v5, -0x1

    goto :goto_0

    .line 545
    .end local v1    # "curGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    .end local v7    # "newGPos":I
    :cond_2
    if-eqz v8, :cond_3

    .line 547
    invoke-static {v2}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 552
    .end local v5    # "i":I
    .end local v8    # "positionsChanged":Z
    :cond_3
    const/4 v6, 0x0

    .line 553
    .local v6, "lastGPos":I
    const/4 v5, 0x0

    .restart local v5    # "i":I
    :goto_1
    if-ge v5, v3, :cond_6

    .line 555
    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .line 561
    .restart local v1    # "curGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    iget v9, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    if-eq v9, v12, :cond_4

    if-eqz p1, :cond_5

    .line 562
    :cond_4
    iget-object v9, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget v10, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    invoke-interface {v9, v10}, Landroid/widget/ExpandableListAdapter;->getChildrenCount(I)I

    move-result v4

    .line 572
    .local v4, "gChildrenCount":I
    :goto_2
    iget v9, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mTotalExpChildrenCount:I

    add-int/2addr v9, v4

    iput v9, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mTotalExpChildrenCount:I

    .line 579
    iget v9, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    sub-int/2addr v9, v6

    add-int/2addr v0, v9

    .line 580
    iget v6, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    .line 583
    iput v0, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    .line 584
    add-int/2addr v0, v4

    .line 585
    iput v0, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    .line 553
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 568
    .end local v4    # "gChildrenCount":I
    :cond_5
    iget v9, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    iget v10, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    sub-int v4, v9, v10

    .restart local v4    # "gChildrenCount":I
    goto :goto_2

    .line 587
    .end local v1    # "curGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    .end local v4    # "gChildrenCount":I
    :cond_6
    return-void
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 365
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    invoke-interface {v0}, Landroid/widget/ExpandableListAdapter;->areAllItemsEnabled()Z

    move-result v0

    return v0
.end method

.method collapseGroup(I)Z
    .locals 5
    .param p1, "groupPos"    # I

    .prologue
    const/4 v4, -0x1

    .line 595
    const/4 v3, 0x2

    invoke-static {v3, p1, v4, v4}, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->obtain(IIII)Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    move-result-object v0

    .line 596
    .local v0, "elGroupPos":Lit/sephiroth/android/library/widget/ExpandableHListPosition;
    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getFlattenedPos(Lit/sephiroth/android/library/widget/ExpandableHListPosition;)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v1

    .line 597
    .local v1, "pm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->recycle()V

    .line 598
    if-nez v1, :cond_0

    const/4 v2, 0x0

    .line 602
    :goto_0
    return v2

    .line 600
    :cond_0
    invoke-virtual {p0, v1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->collapseGroup(Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;)Z

    move-result v2

    .line 601
    .local v2, "retValue":Z
    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    goto :goto_0
.end method

.method collapseGroup(Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;)Z
    .locals 3
    .param p1, "posMetadata"    # Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    .prologue
    const/4 v0, 0x0

    .line 615
    iget-object v1, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    if-nez v1, :cond_0

    .line 629
    :goto_0
    return v0

    .line 618
    :cond_0
    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    iget-object v2, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 621
    invoke-direct {p0, v0, v0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->refreshExpGroupMetadataList(ZZ)V

    .line 624
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->notifyDataSetChanged()V

    .line 627
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget-object v1, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    iget v1, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    invoke-interface {v0, v1}, Landroid/widget/ExpandableListAdapter;->onGroupCollapsed(I)V

    .line 629
    const/4 v0, 0x1

    goto :goto_0
.end method

.method expandGroup(Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;)Z
    .locals 9
    .param p1, "posMetadata"    # Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    .prologue
    const/4 v8, -0x1

    const/4 v3, 0x0

    .line 651
    iget-object v4, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v4, v4, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    if-gez v4, :cond_0

    .line 653
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Need group"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 656
    :cond_0
    iget v4, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mMaxExpGroupCount:I

    if-nez v4, :cond_2

    .line 694
    :cond_1
    :goto_0
    return v3

    .line 659
    :cond_2
    iget-object v4, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    if-nez v4, :cond_1

    .line 662
    iget-object v4, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    iget v5, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mMaxExpGroupCount:I

    if-lt v4, v5, :cond_3

    .line 666
    iget-object v4, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .line 668
    .local v0, "collapsedGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    iget-object v4, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 670
    .local v1, "collapsedIndex":I
    iget v4, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    invoke-virtual {p0, v4}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->collapseGroup(I)Z

    .line 673
    iget v4, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupInsertIndex:I

    if-le v4, v1, :cond_3

    .line 674
    iget v4, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupInsertIndex:I

    add-int/lit8 v4, v4, -0x1

    iput v4, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupInsertIndex:I

    .line 678
    .end local v0    # "collapsedGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    .end local v1    # "collapsedIndex":I
    :cond_3
    iget-object v4, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v4, v4, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget-object v5, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget-object v6, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v6, v6, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    invoke-interface {v5, v6}, Landroid/widget/ExpandableListAdapter;->getGroupId(I)J

    move-result-wide v6

    invoke-static {v8, v8, v4, v6, v7}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->obtain(IIIJ)Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    move-result-object v2

    .line 683
    .local v2, "expandedGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    iget-object v4, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    iget v5, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupInsertIndex:I

    invoke-virtual {v4, v5, v2}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 686
    invoke-direct {p0, v3, v3}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->refreshExpGroupMetadataList(ZZ)V

    .line 689
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->notifyDataSetChanged()V

    .line 692
    iget-object v3, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget v4, v2, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    invoke-interface {v3, v4}, Landroid/widget/ExpandableListAdapter;->onGroupExpanded(I)V

    .line 694
    const/4 v3, 0x1

    goto :goto_0
.end method

.method findGroupPosition(JI)I
    .locals 19
    .param p1, "groupIdToMatch"    # J
    .param p3, "seedGroupPosition"    # I

    .prologue
    .line 779
    move-object/from16 v0, p0

    iget-object v11, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    invoke-interface {v11}, Landroid/widget/ExpandableListAdapter;->getGroupCount()I

    move-result v3

    .line 781
    .local v3, "count":I
    if-nez v3, :cond_0

    .line 782
    const/4 v11, -0x1

    .line 852
    :goto_0
    return v11

    .line 786
    :cond_0
    const-wide/high16 v14, -0x8000000000000000L

    cmp-long v11, p1, v14

    if-nez v11, :cond_1

    .line 787
    const/4 v11, -0x1

    goto :goto_0

    .line 791
    :cond_1
    const/4 v11, 0x0

    move/from16 v0, p3

    invoke-static {v11, v0}, Ljava/lang/Math;->max(II)I

    move-result p3

    .line 792
    add-int/lit8 v11, v3, -0x1

    move/from16 v0, p3

    invoke-static {v11, v0}, Ljava/lang/Math;->min(II)I

    move-result p3

    .line 794
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v14

    const-wide/16 v16, 0x64

    add-long v4, v14, v16

    .line 799
    .local v4, "endTime":J
    move/from16 v6, p3

    .line 802
    .local v6, "first":I
    move/from16 v9, p3

    .line 805
    .local v9, "last":I
    const/4 v10, 0x0

    .line 815
    .local v10, "next":Z
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getAdapter()Landroid/widget/ExpandableListAdapter;

    move-result-object v2

    .line 816
    .local v2, "adapter":Landroid/widget/ExpandableListAdapter;
    if-nez v2, :cond_4

    .line 817
    const/4 v11, -0x1

    goto :goto_0

    .line 835
    .local v7, "hitFirst":Z
    .local v8, "hitLast":Z
    .local v12, "rowId":J
    :cond_2
    if-nez v7, :cond_3

    if-eqz v10, :cond_9

    if-nez v8, :cond_9

    .line 837
    :cond_3
    add-int/lit8 v9, v9, 0x1

    .line 838
    move/from16 p3, v9

    .line 840
    const/4 v10, 0x0

    .line 820
    .end local v7    # "hitFirst":Z
    .end local v8    # "hitLast":Z
    .end local v12    # "rowId":J
    :cond_4
    :goto_1
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v14

    cmp-long v11, v14, v4

    if-gtz v11, :cond_6

    .line 821
    move/from16 v0, p3

    invoke-interface {v2, v0}, Landroid/widget/ExpandableListAdapter;->getGroupId(I)J

    move-result-wide v12

    .line 822
    .restart local v12    # "rowId":J
    cmp-long v11, v12, p1

    if-nez v11, :cond_5

    move/from16 v11, p3

    .line 824
    goto :goto_0

    .line 827
    :cond_5
    add-int/lit8 v11, v3, -0x1

    if-ne v9, v11, :cond_7

    const/4 v8, 0x1

    .line 828
    .restart local v8    # "hitLast":Z
    :goto_2
    if-nez v6, :cond_8

    const/4 v7, 0x1

    .line 830
    .restart local v7    # "hitFirst":Z
    :goto_3
    if-eqz v8, :cond_2

    if-eqz v7, :cond_2

    .line 852
    .end local v7    # "hitFirst":Z
    .end local v8    # "hitLast":Z
    .end local v12    # "rowId":J
    :cond_6
    const/4 v11, -0x1

    goto :goto_0

    .line 827
    .restart local v12    # "rowId":J
    :cond_7
    const/4 v8, 0x0

    goto :goto_2

    .line 828
    .restart local v8    # "hitLast":Z
    :cond_8
    const/4 v7, 0x0

    goto :goto_3

    .line 842
    .restart local v7    # "hitFirst":Z
    :cond_9
    if-nez v8, :cond_a

    if-nez v10, :cond_4

    if-nez v7, :cond_4

    .line 844
    :cond_a
    add-int/lit8 v6, v6, -0x1

    .line 845
    move/from16 p3, v6

    .line 847
    const/4 v10, 0x1

    goto :goto_1
.end method

.method getAdapter()Landroid/widget/ExpandableListAdapter;
    .locals 1

    .prologue
    .line 724
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    return-object v0
.end method

.method public getCount()I
    .locals 2

    .prologue
    .line 393
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    invoke-interface {v0}, Landroid/widget/ExpandableListAdapter;->getGroupCount()I

    move-result v0

    iget v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mTotalExpChildrenCount:I

    add-int/2addr v0, v1

    return v0
.end method

.method getExpandedGroupMetadataList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;",
            ">;"
        }
    .end annotation

    .prologue
    .line 738
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 2

    .prologue
    .line 728
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getAdapter()Landroid/widget/ExpandableListAdapter;

    move-result-object v0

    .line 729
    .local v0, "adapter":Landroid/widget/ExpandableListAdapter;
    instance-of v1, v0, Landroid/widget/Filterable;

    if-eqz v1, :cond_0

    .line 730
    check-cast v0, Landroid/widget/Filterable;

    .end local v0    # "adapter":Landroid/widget/ExpandableListAdapter;
    invoke-interface {v0}, Landroid/widget/Filterable;->getFilter()Landroid/widget/Filter;

    move-result-object v1

    .line 733
    :goto_0
    return-object v1

    .restart local v0    # "adapter":Landroid/widget/ExpandableListAdapter;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method getFlattenedPos(Lit/sephiroth/android/library/widget/ExpandableHListPosition;)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    .locals 25
    .param p1, "pos"    # Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    .prologue
    .line 258
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    move-object/from16 v20, v0

    .line 259
    .local v20, "egml":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;>;"
    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->size()I

    move-result v23

    .line 262
    .local v23, "numExpGroups":I
    const/4 v13, 0x0

    .line 263
    .local v13, "leftExpGroupIndex":I
    add-int/lit8 v19, v23, -0x1

    .line 264
    .local v19, "rightExpGroupIndex":I
    const/16 v22, 0x0

    .line 267
    .local v22, "midExpGroupIndex":I
    if-nez v23, :cond_9

    .line 273
    move-object/from16 v0, p1

    iget v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    move-object/from16 v0, p1

    iget v3, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    move-object/from16 v0, p1

    iget v4, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    move-object/from16 v0, p1

    iget v5, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-static/range {v2 .. v7}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->obtain(IIIILit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v2

    move/from16 v7, v22

    .line 359
    .end local v22    # "midExpGroupIndex":I
    .local v7, "midExpGroupIndex":I
    :goto_0
    return-object v2

    .line 281
    :cond_0
    :goto_1
    move/from16 v0, v19

    if-gt v13, v0, :cond_5

    .line 282
    sub-int v2, v19, v13

    div-int/lit8 v2, v2, 0x2

    add-int v7, v2, v13

    .line 283
    move-object/from16 v0, v20

    invoke-virtual {v0, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .line 285
    .local v6, "midExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    move-object/from16 v0, p1

    iget v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget v3, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    if-le v2, v3, :cond_1

    .line 289
    add-int/lit8 v13, v7, 0x1

    goto :goto_1

    .line 291
    :cond_1
    move-object/from16 v0, p1

    iget v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget v3, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    if-ge v2, v3, :cond_2

    .line 295
    add-int/lit8 v19, v7, -0x1

    goto :goto_1

    .line 297
    :cond_2
    move-object/from16 v0, p1

    iget v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget v3, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    if-ne v2, v3, :cond_0

    .line 302
    move-object/from16 v0, p1

    iget v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_3

    .line 304
    iget v2, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    move-object/from16 v0, p1

    iget v3, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    move-object/from16 v0, p1

    iget v4, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    move-object/from16 v0, p1

    iget v5, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    invoke-static/range {v2 .. v7}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->obtain(IIIILit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v2

    goto :goto_0

    .line 306
    :cond_3
    move-object/from16 v0, p1

    iget v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_4

    .line 308
    iget v2, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    move-object/from16 v0, p1

    iget v3, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p1

    iget v3, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    move-object/from16 v0, p1

    iget v4, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    move-object/from16 v0, p1

    iget v5, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    invoke-static/range {v2 .. v7}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->obtain(IIIILit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v2

    goto :goto_0

    .line 311
    :cond_4
    const/4 v2, 0x0

    goto :goto_0

    .line 320
    .end local v6    # "midExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    :cond_5
    move-object/from16 v0, p1

    iget v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v3, 0x2

    if-eq v2, v3, :cond_6

    .line 322
    const/4 v2, 0x0

    goto :goto_0

    .line 330
    :cond_6
    if-le v13, v7, :cond_7

    .line 341
    add-int/lit8 v2, v13, -0x1

    move-object/from16 v0, v20

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .line 342
    .local v21, "leftExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    move-object/from16 v0, v21

    iget v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    move-object/from16 v0, p1

    iget v3, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    move-object/from16 v0, v21

    iget v4, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    sub-int/2addr v3, v4

    add-int v8, v2, v3

    .line 344
    .local v8, "flPos":I
    move-object/from16 v0, p1

    iget v9, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    move-object/from16 v0, p1

    iget v10, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    move-object/from16 v0, p1

    iget v11, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    const/4 v12, 0x0

    invoke-static/range {v8 .. v13}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->obtain(IIIILit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v2

    goto/16 :goto_0

    .line 346
    .end local v8    # "flPos":I
    .end local v21    # "leftExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    :cond_7
    move/from16 v0, v19

    if-ge v0, v7, :cond_8

    .line 354
    add-int/lit8 v19, v19, 0x1

    move-object/from16 v0, v20

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .line 355
    .local v24, "rightExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    move-object/from16 v0, v24

    iget v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    move-object/from16 v0, v24

    iget v3, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    move-object/from16 v0, p1

    iget v4, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    sub-int/2addr v3, v4

    sub-int v8, v2, v3

    .line 356
    .restart local v8    # "flPos":I
    move-object/from16 v0, p1

    iget v15, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    move-object/from16 v0, p1

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    move/from16 v16, v0

    move-object/from16 v0, p1

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    move/from16 v17, v0

    const/16 v18, 0x0

    move v14, v8

    invoke-static/range {v14 .. v19}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->obtain(IIIILit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v2

    goto/16 :goto_0

    .line 359
    .end local v8    # "flPos":I
    .end local v24    # "rightExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    :cond_8
    const/4 v2, 0x0

    goto/16 :goto_0

    .end local v7    # "midExpGroupIndex":I
    .restart local v22    # "midExpGroupIndex":I
    :cond_9
    move/from16 v7, v22

    .end local v22    # "midExpGroupIndex":I
    .restart local v7    # "midExpGroupIndex":I
    goto/16 :goto_1
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 5
    .param p1, "flatListPos"    # I

    .prologue
    .line 397
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v0

    .line 400
    .local v0, "posMetadata":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    iget-object v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v2, v2, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_0

    .line 401
    iget-object v2, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget-object v3, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v3, v3, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    invoke-interface {v2, v3}, Landroid/widget/ExpandableListAdapter;->getGroup(I)Ljava/lang/Object;

    move-result-object v1

    .line 411
    .local v1, "retValue":Ljava/lang/Object;
    :goto_0
    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    .line 413
    return-object v1

    .line 403
    .end local v1    # "retValue":Ljava/lang/Object;
    :cond_0
    iget-object v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v2, v2, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_1

    .line 404
    iget-object v2, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget-object v3, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v3, v3, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget-object v4, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v4, v4, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    invoke-interface {v2, v3, v4}, Landroid/widget/ExpandableListAdapter;->getChild(II)Ljava/lang/Object;

    move-result-object v1

    .restart local v1    # "retValue":Ljava/lang/Object;
    goto :goto_0

    .line 408
    .end local v1    # "retValue":Ljava/lang/Object;
    :cond_1
    new-instance v2, Ljava/lang/RuntimeException;

    const-string v3, "Flat list position is of unknown type"

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public getItemId(I)J
    .locals 10
    .param p1, "flatListPos"    # I

    .prologue
    .line 417
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v4

    .line 418
    .local v4, "posMetadata":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    iget-object v5, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget-object v8, v4, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v8, v8, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    invoke-interface {v5, v8}, Landroid/widget/ExpandableListAdapter;->getGroupId(I)J

    move-result-wide v2

    .line 421
    .local v2, "groupId":J
    iget-object v5, v4, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v5, v5, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v8, 0x2

    if-ne v5, v8, :cond_0

    .line 422
    iget-object v5, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    invoke-interface {v5, v2, v3}, Landroid/widget/ExpandableListAdapter;->getCombinedGroupId(J)J

    move-result-wide v6

    .line 433
    .local v6, "retValue":J
    :goto_0
    invoke-virtual {v4}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    .line 435
    return-wide v6

    .line 424
    .end local v6    # "retValue":J
    :cond_0
    iget-object v5, v4, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v5, v5, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v8, 0x1

    if-ne v5, v8, :cond_1

    .line 425
    iget-object v5, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget-object v8, v4, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v8, v8, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget-object v9, v4, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v9, v9, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    invoke-interface {v5, v8, v9}, Landroid/widget/ExpandableListAdapter;->getChildId(II)J

    move-result-wide v0

    .line 426
    .local v0, "childId":J
    iget-object v5, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    invoke-interface {v5, v2, v3, v0, v1}, Landroid/widget/ExpandableListAdapter;->getCombinedChildId(JJ)J

    move-result-wide v6

    .line 427
    .restart local v6    # "retValue":J
    goto :goto_0

    .line 430
    .end local v0    # "childId":J
    .end local v6    # "retValue":J
    :cond_1
    new-instance v5, Ljava/lang/RuntimeException;

    const-string v8, "Flat list position is of unknown type"

    invoke-direct {v5, v8}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v5
.end method

.method public getItemViewType(I)I
    .locals 7
    .param p1, "flatListPos"    # I

    .prologue
    const/4 v6, 0x2

    .line 462
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v2

    .line 463
    .local v2, "metadata":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    iget-object v3, v2, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    .line 466
    .local v3, "pos":Lit/sephiroth/android/library/widget/ExpandableHListPosition;
    iget-object v5, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    instance-of v5, v5, Landroid/widget/HeterogeneousExpandableList;

    if-eqz v5, :cond_1

    .line 467
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    check-cast v0, Landroid/widget/HeterogeneousExpandableList;

    .line 468
    .local v0, "adapter":Landroid/widget/HeterogeneousExpandableList;
    iget v5, v3, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    if-ne v5, v6, :cond_0

    .line 469
    iget v5, v3, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    invoke-interface {v0, v5}, Landroid/widget/HeterogeneousExpandableList;->getGroupType(I)I

    move-result v4

    .line 485
    .end local v0    # "adapter":Landroid/widget/HeterogeneousExpandableList;
    .local v4, "retValue":I
    :goto_0
    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    .line 487
    return v4

    .line 472
    .end local v4    # "retValue":I
    .restart local v0    # "adapter":Landroid/widget/HeterogeneousExpandableList;
    :cond_0
    iget v5, v3, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget v6, v3, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    invoke-interface {v0, v5, v6}, Landroid/widget/HeterogeneousExpandableList;->getChildType(II)I

    move-result v1

    .line 473
    .local v1, "childType":I
    invoke-interface {v0}, Landroid/widget/HeterogeneousExpandableList;->getGroupTypeCount()I

    move-result v5

    add-int v4, v5, v1

    .restart local v4    # "retValue":I
    goto :goto_0

    .line 477
    .end local v0    # "adapter":Landroid/widget/HeterogeneousExpandableList;
    .end local v1    # "childType":I
    .end local v4    # "retValue":I
    :cond_1
    iget v5, v3, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    if-ne v5, v6, :cond_2

    .line 478
    const/4 v4, 0x0

    .restart local v4    # "retValue":I
    goto :goto_0

    .line 481
    .end local v4    # "retValue":I
    :cond_2
    const/4 v4, 0x1

    .restart local v4    # "retValue":I
    goto :goto_0
.end method

.method getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    .locals 20
    .param p1, "flPos"    # I

    .prologue
    .line 110
    move-object/from16 v0, p0

    iget-object v13, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    .line 111
    .local v13, "egml":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;>;"
    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v17

    .line 114
    .local v17, "numExpGroups":I
    const/4 v15, 0x0

    .line 115
    .local v15, "leftExpGroupIndex":I
    add-int/lit8 v19, v17, -0x1

    .line 116
    .local v19, "rightExpGroupIndex":I
    const/16 v16, 0x0

    .line 119
    .local v16, "midExpGroupIndex":I
    if-nez v17, :cond_7

    .line 125
    const/4 v2, 0x2

    const/4 v4, -0x1

    const/4 v5, 0x0

    const/4 v6, 0x0

    move/from16 v1, p1

    move/from16 v3, p1

    invoke-static/range {v1 .. v6}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->obtain(IIIILit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v1

    move/from16 v6, v16

    .line 243
    .end local v16    # "midExpGroupIndex":I
    .local v6, "midExpGroupIndex":I
    :goto_0
    return-object v1

    .line 140
    :cond_0
    :goto_1
    move/from16 v0, v19

    if-gt v15, v0, :cond_4

    .line 141
    sub-int v1, v19, v15

    div-int/lit8 v1, v1, 0x2

    add-int v6, v1, v15

    .line 142
    invoke-virtual {v13, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .line 144
    .local v5, "midExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    iget v1, v5, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    move/from16 v0, p1

    if-le v0, v1, :cond_1

    .line 149
    add-int/lit8 v15, v6, 0x1

    goto :goto_1

    .line 151
    :cond_1
    iget v1, v5, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    move/from16 v0, p1

    if-ge v0, v1, :cond_2

    .line 156
    add-int/lit8 v19, v6, -0x1

    goto :goto_1

    .line 158
    :cond_2
    iget v1, v5, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    move/from16 v0, p1

    if-ne v0, v1, :cond_3

    .line 163
    const/4 v2, 0x2

    iget v3, v5, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    const/4 v4, -0x1

    move/from16 v1, p1

    invoke-static/range {v1 .. v6}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->obtain(IIIILit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v1

    goto :goto_0

    .line 165
    :cond_3
    iget v1, v5, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    move/from16 v0, p1

    if-gt v0, v1, :cond_0

    .line 175
    iget v1, v5, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    add-int/lit8 v1, v1, 0x1

    sub-int v4, p1, v1

    .line 176
    .local v4, "childPos":I
    const/4 v2, 0x1

    iget v3, v5, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    move/from16 v1, p1

    invoke-static/range {v1 .. v6}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->obtain(IIIILit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v1

    goto :goto_0

    .line 191
    .end local v4    # "childPos":I
    .end local v5    # "midExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    :cond_4
    const/4 v12, 0x0

    .line 194
    .local v12, "insertPosition":I
    const/4 v9, 0x0

    .line 201
    .local v9, "groupPos":I
    if-le v15, v6, :cond_5

    .line 209
    add-int/lit8 v1, v15, -0x1

    invoke-virtual {v13, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .line 211
    .local v14, "leftExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    move v12, v15

    .line 217
    iget v1, v14, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    sub-int v1, p1, v1

    iget v2, v14, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    add-int v9, v1, v2

    .line 243
    .end local v14    # "leftExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    :goto_2
    const/4 v8, 0x2

    const/4 v10, -0x1

    const/4 v11, 0x0

    move/from16 v7, p1

    invoke-static/range {v7 .. v12}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->obtain(IIIILit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v1

    goto :goto_0

    .line 219
    :cond_5
    move/from16 v0, v19

    if-ge v0, v6, :cond_6

    .line 226
    add-int/lit8 v19, v19, 0x1

    move/from16 v0, v19

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    .line 228
    .local v18, "rightExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    move/from16 v12, v19

    .line 236
    move-object/from16 v0, v18

    iget v1, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    move-object/from16 v0, v18

    iget v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    sub-int v2, v2, p1

    sub-int v9, v1, v2

    .line 237
    goto :goto_2

    .line 240
    .end local v18    # "rightExpGm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;
    :cond_6
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Unknown state"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .end local v6    # "midExpGroupIndex":I
    .end local v9    # "groupPos":I
    .end local v12    # "insertPosition":I
    .restart local v16    # "midExpGroupIndex":I
    :cond_7
    move/from16 v6, v16

    .end local v16    # "midExpGroupIndex":I
    .restart local v6    # "midExpGroupIndex":I
    goto/16 :goto_1
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "flatListPos"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v3, 0x1

    .line 439
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v6

    .line 442
    .local v6, "posMetadata":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    iget-object v0, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 443
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget-object v1, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v1, v1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->isExpanded()Z

    move-result v2

    invoke-interface {v0, v1, v2, p2, p3}, Landroid/widget/ExpandableListAdapter;->getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    .line 455
    .local v7, "retValue":Landroid/view/View;
    :goto_0
    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    .line 457
    return-object v7

    .line 445
    .end local v7    # "retValue":Landroid/view/View;
    :cond_0
    iget-object v0, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    if-ne v0, v3, :cond_2

    .line 446
    iget-object v0, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    if-ne v0, p1, :cond_1

    .line 448
    .local v3, "isLastChild":Z
    :goto_1
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget-object v1, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v1, v1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget-object v2, v6, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v2, v2, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    move-object v4, p2

    move-object v5, p3

    invoke-interface/range {v0 .. v5}, Landroid/widget/ExpandableListAdapter;->getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    .line 449
    .restart local v7    # "retValue":Landroid/view/View;
    goto :goto_0

    .line 446
    .end local v3    # "isLastChild":Z
    .end local v7    # "retValue":Landroid/view/View;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1

    .line 452
    :cond_2
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Flat list position is of unknown type"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getViewTypeCount()I
    .locals 3

    .prologue
    .line 492
    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    instance-of v1, v1, Landroid/widget/HeterogeneousExpandableList;

    if-eqz v1, :cond_0

    .line 493
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    check-cast v0, Landroid/widget/HeterogeneousExpandableList;

    .line 494
    .local v0, "adapter":Landroid/widget/HeterogeneousExpandableList;
    invoke-interface {v0}, Landroid/widget/HeterogeneousExpandableList;->getGroupTypeCount()I

    move-result v1

    invoke-interface {v0}, Landroid/widget/HeterogeneousExpandableList;->getChildTypeCount()I

    move-result v2

    add-int/2addr v1, v2

    .line 497
    .end local v0    # "adapter":Landroid/widget/HeterogeneousExpandableList;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x2

    goto :goto_0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 503
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    invoke-interface {v0}, Landroid/widget/ExpandableListAdapter;->hasStableIds()Z

    move-result v0

    return v0
.end method

.method public isEmpty()Z
    .locals 2

    .prologue
    .line 763
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getAdapter()Landroid/widget/ExpandableListAdapter;

    move-result-object v0

    .line 764
    .local v0, "adapter":Landroid/widget/ExpandableListAdapter;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/widget/ExpandableListAdapter;->isEmpty()Z

    move-result v1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public isEnabled(I)Z
    .locals 6
    .param p1, "flatListPos"    # I

    .prologue
    .line 370
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v0

    .line 371
    .local v0, "metadata":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    iget-object v1, v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    .line 374
    .local v1, "pos":Lit/sephiroth/android/library/widget/ExpandableHListPosition;
    iget v3, v1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 375
    iget-object v3, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget v4, v1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget v5, v1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    invoke-interface {v3, v4, v5}, Landroid/widget/ExpandableListAdapter;->isChildSelectable(II)Z

    move-result v2

    .line 382
    .local v2, "retValue":Z
    :goto_0
    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    .line 384
    return v2

    .line 379
    .end local v2    # "retValue":Z
    :cond_0
    const/4 v2, 0x1

    .restart local v2    # "retValue":Z
    goto :goto_0
.end method

.method public setExpandableListAdapter(Landroid/widget/ExpandableListAdapter;)V
    .locals 2
    .param p1, "expandableListAdapter"    # Landroid/widget/ExpandableListAdapter;

    .prologue
    .line 88
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mDataSetObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Landroid/widget/ExpandableListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 92
    :cond_0
    iput-object p1, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    .line 93
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mDataSetObserver:Landroid/database/DataSetObserver;

    invoke-interface {p1, v0}, Landroid/widget/ExpandableListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 94
    return-void
.end method

.method setExpandedGroupMetadataList(Ljava/util/ArrayList;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 743
    .local p1, "expandedGroupMetadataList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;>;"
    if-eqz p1, :cond_0

    iget-object v2, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    if-nez v2, :cond_1

    .line 759
    :cond_0
    :goto_0
    return-void

    .line 749
    :cond_1
    iget-object v2, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpandableListAdapter:Landroid/widget/ExpandableListAdapter;

    invoke-interface {v2}, Landroid/widget/ExpandableListAdapter;->getGroupCount()I

    move-result v1

    .line 750
    .local v1, "numGroups":I
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_1
    if-ltz v0, :cond_2

    .line 751
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    iget v2, v2, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->gPos:I

    if-ge v2, v1, :cond_0

    .line 750
    add-int/lit8 v0, v0, -0x1

    goto :goto_1

    .line 757
    :cond_2
    iput-object p1, p0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->mExpGroupMetadataList:Ljava/util/ArrayList;

    .line 758
    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-direct {p0, v2, v3}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->refreshExpGroupMetadataList(ZZ)V

    goto :goto_0
.end method
