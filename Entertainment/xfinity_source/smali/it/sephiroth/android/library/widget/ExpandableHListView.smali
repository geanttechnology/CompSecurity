.class public Lit/sephiroth/android/library/widget/ExpandableHListView;
.super Lit/sephiroth/android/library/widget/HListView;
.source "ExpandableHListView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lit/sephiroth/android/library/widget/ExpandableHListView$1;,
        Lit/sephiroth/android/library/widget/ExpandableHListView$SavedState;,
        Lit/sephiroth/android/library/widget/ExpandableHListView$ExpandableListContextMenuInfo;,
        Lit/sephiroth/android/library/widget/ExpandableHListView$OnChildClickListener;,
        Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupClickListener;,
        Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupExpandListener;,
        Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupCollapseListener;
    }
.end annotation


# static fields
.field private static final CHILD_LAST_STATE_SET:[I

.field private static final EMPTY_STATE_SET:[I

.field private static final GROUP_EMPTY_STATE_SET:[I

.field private static final GROUP_EXPANDED_EMPTY_STATE_SET:[I

.field private static final GROUP_EXPANDED_STATE_SET:[I

.field private static final GROUP_STATE_SETS:[[I


# instance fields
.field private mAdapter:Landroid/widget/ExpandableListAdapter;

.field private mChildDivider:Landroid/graphics/drawable/Drawable;

.field private mChildIndicator:Landroid/graphics/drawable/Drawable;

.field private mChildIndicatorGravity:I

.field private mChildIndicatorHeight:I

.field private mChildIndicatorLeft:I

.field private mChildIndicatorTop:I

.field private mChildIndicatorWidth:I

.field private mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

.field private mGroupIndicator:Landroid/graphics/drawable/Drawable;

.field private mGroupIndicatorHeight:I

.field private mGroupIndicatorWidth:I

.field private mIndicatorGravity:I

.field private mIndicatorLeft:I

.field private final mIndicatorRect:Landroid/graphics/Rect;

.field private mIndicatorTop:I

.field private mOnChildClickListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnChildClickListener;

.field private mOnGroupClickListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupClickListener;

.field private mOnGroupCollapseListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupCollapseListener;

.field private mOnGroupExpandListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupExpandListener;

.field private final mTempRect:Landroid/graphics/Rect;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v2, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 172
    new-array v0, v3, [I

    sput-object v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->EMPTY_STATE_SET:[I

    .line 175
    new-array v0, v4, [I

    const v1, 0x10100a8

    aput v1, v0, v3

    sput-object v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->GROUP_EXPANDED_STATE_SET:[I

    .line 178
    new-array v0, v4, [I

    const v1, 0x10100a9

    aput v1, v0, v3

    sput-object v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->GROUP_EMPTY_STATE_SET:[I

    .line 181
    new-array v0, v2, [I

    fill-array-data v0, :array_0

    sput-object v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->GROUP_EXPANDED_EMPTY_STATE_SET:[I

    .line 184
    const/4 v0, 0x4

    new-array v0, v0, [[I

    sget-object v1, Lit/sephiroth/android/library/widget/ExpandableHListView;->EMPTY_STATE_SET:[I

    aput-object v1, v0, v3

    sget-object v1, Lit/sephiroth/android/library/widget/ExpandableHListView;->GROUP_EXPANDED_STATE_SET:[I

    aput-object v1, v0, v4

    sget-object v1, Lit/sephiroth/android/library/widget/ExpandableHListView;->GROUP_EMPTY_STATE_SET:[I

    aput-object v1, v0, v2

    const/4 v1, 0x3

    sget-object v2, Lit/sephiroth/android/library/widget/ExpandableHListView;->GROUP_EXPANDED_EMPTY_STATE_SET:[I

    aput-object v2, v0, v1

    sput-object v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->GROUP_STATE_SETS:[[I

    .line 191
    new-array v0, v4, [I

    const v1, 0x10100a6

    aput v1, v0, v3

    sput-object v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->CHILD_LAST_STATE_SET:[I

    return-void

    .line 181
    :array_0
    .array-data 4
        0x10100a8
        0x10100a9
    .end array-data
.end method

.method private getAbsoluteFlatPosition(I)I
    .locals 1
    .param p1, "flatListPosition"    # I

    .prologue
    .line 539
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getHeaderViewsCount()I

    move-result v0

    add-int/2addr v0, p1

    return v0
.end method

.method private getChildOrGroupId(Lit/sephiroth/android/library/widget/ExpandableHListPosition;)J
    .locals 3
    .param p1, "position"    # Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    .prologue
    .line 1033
    iget v0, p1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 1034
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mAdapter:Landroid/widget/ExpandableListAdapter;

    iget v1, p1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget v2, p1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    invoke-interface {v0, v1, v2}, Landroid/widget/ExpandableListAdapter;->getChildId(II)J

    move-result-wide v0

    .line 1037
    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mAdapter:Landroid/widget/ExpandableListAdapter;

    iget v1, p1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    invoke-interface {v0, v1}, Landroid/widget/ExpandableListAdapter;->getGroupId(I)J

    move-result-wide v0

    goto :goto_0
.end method

.method private getFlatPositionForConnector(I)I
    .locals 1
    .param p1, "flatListPosition"    # I

    .prologue
    .line 528
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getHeaderViewsCount()I

    move-result v0

    sub-int v0, p1, v0

    return v0
.end method

.method private getIndicator(Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;)Landroid/graphics/drawable/Drawable;
    .locals 9
    .param p1, "pos"    # Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 381
    iget-object v7, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v7, v7, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    if-ne v7, v6, :cond_5

    .line 382
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicator:Landroid/graphics/drawable/Drawable;

    .line 384
    .local v0, "indicator":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 388
    iget-object v7, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    if-eqz v7, :cond_0

    iget-object v7, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    iget v7, v7, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    iget-object v8, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    iget v8, v8, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    if-ne v7, v8, :cond_3

    :cond_0
    move v1, v5

    .line 390
    .local v1, "isEmpty":Z
    :goto_0
    invoke-virtual {p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->isExpanded()Z

    move-result v7

    if-eqz v7, :cond_4

    :goto_1
    if-eqz v1, :cond_1

    move v4, v6

    :cond_1
    or-int v3, v5, v4

    .line 392
    .local v3, "stateSetIndex":I
    sget-object v4, Lit/sephiroth/android/library/widget/ExpandableHListView;->GROUP_STATE_SETS:[[I

    aget-object v4, v4, v3

    invoke-virtual {v0, v4}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 405
    .end local v1    # "isEmpty":Z
    .end local v3    # "stateSetIndex":I
    :cond_2
    :goto_2
    return-object v0

    :cond_3
    move v1, v4

    .line 388
    goto :goto_0

    .restart local v1    # "isEmpty":Z
    :cond_4
    move v5, v4

    .line 390
    goto :goto_1

    .line 396
    .end local v0    # "indicator":Landroid/graphics/drawable/Drawable;
    .end local v1    # "isEmpty":Z
    :cond_5
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicator:Landroid/graphics/drawable/Drawable;

    .line 398
    .restart local v0    # "indicator":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 400
    iget-object v4, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v4, v4, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->flatListPos:I

    iget-object v5, p1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    iget v5, v5, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    if-ne v4, v5, :cond_6

    sget-object v2, Lit/sephiroth/android/library/widget/ExpandableHListView;->CHILD_LAST_STATE_SET:[I

    .line 401
    .local v2, "stateSet":[I
    :goto_3
    invoke-virtual {v0, v2}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    goto :goto_2

    .line 400
    .end local v2    # "stateSet":[I
    :cond_6
    sget-object v2, Lit/sephiroth/android/library/widget/ExpandableHListView;->EMPTY_STATE_SET:[I

    goto :goto_3
.end method

.method public static getPackedPositionChild(J)I
    .locals 8
    .param p0, "packedPosition"    # J

    .prologue
    const-wide v6, 0xffffffffL

    const-wide/high16 v4, -0x8000000000000000L

    const/4 v0, -0x1

    .line 964
    cmp-long v1, p0, v6

    if-nez v1, :cond_1

    .line 969
    :cond_0
    :goto_0
    return v0

    .line 967
    :cond_1
    and-long v2, p0, v4

    cmp-long v1, v2, v4

    if-nez v1, :cond_0

    .line 969
    and-long v0, p0, v6

    long-to-int v0, v0

    goto :goto_0
.end method

.method public static getPackedPositionGroup(J)I
    .locals 4
    .param p0, "packedPosition"    # J

    .prologue
    .line 945
    const-wide v0, 0xffffffffL

    cmp-long v0, p0, v0

    if-nez v0, :cond_0

    const/4 v0, -0x1

    .line 947
    :goto_0
    return v0

    :cond_0
    const-wide v0, 0x7fffffff00000000L

    and-long/2addr v0, p0

    const/16 v2, 0x20

    shr-long/2addr v0, v2

    long-to-int v0, v0

    goto :goto_0
.end method

.method public static getPackedPositionType(J)I
    .locals 4
    .param p0, "packedPosition"    # J

    .prologue
    const-wide/high16 v2, -0x8000000000000000L

    .line 927
    const-wide v0, 0xffffffffL

    cmp-long v0, p0, v0

    if-nez v0, :cond_0

    .line 928
    const/4 v0, 0x2

    .line 931
    :goto_0
    return v0

    :cond_0
    and-long v0, p0, v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isHeaderOrFooterPosition(I)Z
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 516
    iget v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mItemCount:I

    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getFooterViewsCount()I

    move-result v2

    sub-int v0, v1, v2

    .line 517
    .local v0, "footerViewsStart":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getHeaderViewsCount()I

    move-result v1

    if-lt p1, v1, :cond_0

    if-lt p1, v0, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private resolveChildIndicator()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 260
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicator:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 261
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorWidth:I

    .line 262
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorHeight:I

    .line 268
    :goto_0
    return-void

    .line 265
    :cond_0
    iput v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorWidth:I

    .line 266
    iput v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorHeight:I

    goto :goto_0
.end method

.method private resolveIndicator()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 245
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicator:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 246
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicatorWidth:I

    .line 247
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicatorHeight:I

    .line 253
    :goto_0
    return-void

    .line 250
    :cond_0
    iput v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicatorWidth:I

    .line 251
    iput v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicatorHeight:I

    goto :goto_0
.end method


# virtual methods
.method createContextMenuInfo(Landroid/view/View;IJ)Landroid/view/ContextMenu$ContextMenuInfo;
    .locals 9
    .param p1, "view"    # Landroid/view/View;
    .param p2, "flatListPosition"    # I
    .param p3, "id"    # J

    .prologue
    .line 1007
    invoke-direct {p0, p2}, Lit/sephiroth/android/library/widget/ExpandableHListView;->isHeaderOrFooterPosition(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1009
    new-instance v0, Lit/sephiroth/android/library/widget/AdapterView$AdapterContextMenuInfo;

    invoke-direct {v0, p1, p2, p3, p4}, Lit/sephiroth/android/library/widget/AdapterView$AdapterContextMenuInfo;-><init>(Landroid/view/View;IJ)V

    .line 1021
    :goto_0
    return-object v0

    .line 1012
    :cond_0
    invoke-direct {p0, p2}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getFlatPositionForConnector(I)I

    move-result v6

    .line 1013
    .local v6, "adjustedPosition":I
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    invoke-virtual {v0, v6}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v7

    .line 1014
    .local v7, "pm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    iget-object v8, v7, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    .line 1016
    .local v8, "pos":Lit/sephiroth/android/library/widget/ExpandableHListPosition;
    invoke-direct {p0, v8}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getChildOrGroupId(Lit/sephiroth/android/library/widget/ExpandableHListPosition;)J

    move-result-wide p3

    .line 1017
    invoke-virtual {v8}, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->getPackedPosition()J

    move-result-wide v2

    .line 1019
    .local v2, "packedPosition":J
    invoke-virtual {v7}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    .line 1021
    new-instance v0, Lit/sephiroth/android/library/widget/ExpandableHListView$ExpandableListContextMenuInfo;

    move-object v1, p1

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lit/sephiroth/android/library/widget/ExpandableHListView$ExpandableListContextMenuInfo;-><init>(Landroid/view/View;JJ)V

    goto :goto_0
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 22
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 274
    invoke-super/range {p0 .. p1}, Lit/sephiroth/android/library/widget/HListView;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 277
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicator:Landroid/graphics/drawable/Drawable;

    move-object/from16 v18, v0

    if-nez v18, :cond_1

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicator:Landroid/graphics/drawable/Drawable;

    move-object/from16 v18, v0

    if-nez v18, :cond_1

    .line 368
    :cond_0
    return-void

    .line 281
    :cond_1
    const/16 v17, 0x0

    .line 283
    .local v17, "saveCount":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getHeaderViewsCount()I

    move-result v6

    .line 285
    .local v6, "headerViewsCount":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mItemCount:I

    move/from16 v18, v0

    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getFooterViewsCount()I

    move-result v19

    sub-int v18, v18, v19

    sub-int v18, v18, v6

    add-int/lit8 v11, v18, -0x1

    .line 287
    .local v11, "lastChildFlPos":I
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getRight()I

    move-result v14

    .line 295
    .local v14, "myRight":I
    const/4 v12, -0x4

    .line 297
    .local v12, "lastItemType":I
    move-object/from16 v0, p0

    iget-object v9, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mIndicatorRect:Landroid/graphics/Rect;

    .line 302
    .local v9, "indicatorRect":Landroid/graphics/Rect;
    invoke-virtual/range {p0 .. p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getChildCount()I

    move-result v4

    .line 303
    .local v4, "childCount":I
    const/4 v7, 0x0

    .local v7, "i":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mFirstPosition:I

    move/from16 v18, v0

    sub-int v5, v18, v6

    .local v5, "childFlPos":I
    :goto_0
    if-ge v7, v4, :cond_0

    .line 305
    if-gez v5, :cond_3

    .line 303
    :cond_2
    :goto_1
    add-int/lit8 v7, v7, 0x1

    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 309
    :cond_3
    if-gt v5, v11, :cond_0

    .line 314
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v10

    .line 315
    .local v10, "item":Landroid/view/View;
    invoke-virtual {v10}, Landroid/view/View;->getLeft()I

    move-result v13

    .line 316
    .local v13, "left":I
    invoke-virtual {v10}, Landroid/view/View;->getRight()I

    move-result v16

    .line 319
    .local v16, "right":I
    if-ltz v16, :cond_2

    if-gt v13, v14, :cond_2

    .line 322
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v15

    .line 326
    .local v15, "pos":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    iget-object v0, v15, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    move/from16 v18, v0

    move/from16 v0, v18

    if-eq v0, v12, :cond_4

    .line 327
    iget-object v0, v15, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    move/from16 v18, v0

    const/16 v19, 0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_6

    .line 328
    invoke-virtual {v10}, Landroid/view/View;->getTop()I

    move-result v18

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorTop:I

    move/from16 v19, v0

    add-int v18, v18, v19

    move/from16 v0, v18

    iput v0, v9, Landroid/graphics/Rect;->top:I

    .line 329
    invoke-virtual {v10}, Landroid/view/View;->getBottom()I

    move-result v18

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorTop:I

    move/from16 v19, v0

    add-int v18, v18, v19

    move/from16 v0, v18

    iput v0, v9, Landroid/graphics/Rect;->bottom:I

    .line 336
    :goto_2
    iget-object v0, v15, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget v12, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    .line 339
    :cond_4
    iget v0, v9, Landroid/graphics/Rect;->top:I

    move/from16 v18, v0

    iget v0, v9, Landroid/graphics/Rect;->bottom:I

    move/from16 v19, v0

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_5

    .line 340
    iget-object v0, v15, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    move/from16 v18, v0

    const/16 v19, 0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_7

    .line 341
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorLeft:I

    move/from16 v18, v0

    add-int v18, v18, v13

    move/from16 v0, v18

    iput v0, v9, Landroid/graphics/Rect;->left:I

    .line 342
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorLeft:I

    move/from16 v18, v0

    add-int v18, v18, v16

    move/from16 v0, v18

    iput v0, v9, Landroid/graphics/Rect;->right:I

    .line 351
    :goto_3
    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getIndicator(Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    .line 352
    .local v8, "indicator":Landroid/graphics/drawable/Drawable;
    if-eqz v8, :cond_5

    .line 354
    iget-object v0, v15, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    move/from16 v18, v0

    const/16 v19, 0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_8

    .line 355
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorGravity:I

    move/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorWidth:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicatorHeight:I

    move/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mTempRect:Landroid/graphics/Rect;

    move-object/from16 v21, v0

    move/from16 v0, v18

    move/from16 v1, v19

    move/from16 v2, v20

    move-object/from16 v3, v21

    invoke-static {v0, v1, v2, v9, v3}, Landroid/view/Gravity;->apply(IIILandroid/graphics/Rect;Landroid/graphics/Rect;)V

    .line 362
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mTempRect:Landroid/graphics/Rect;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v8, v0}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 363
    move-object/from16 v0, p1

    invoke-virtual {v8, v0}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 366
    .end local v8    # "indicator":Landroid/graphics/drawable/Drawable;
    :cond_5
    invoke-virtual {v15}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    goto/16 :goto_1

    .line 332
    :cond_6
    invoke-virtual {v10}, Landroid/view/View;->getTop()I

    move-result v18

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mIndicatorTop:I

    move/from16 v19, v0

    add-int v18, v18, v19

    move/from16 v0, v18

    iput v0, v9, Landroid/graphics/Rect;->top:I

    .line 333
    invoke-virtual {v10}, Landroid/view/View;->getBottom()I

    move-result v18

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mIndicatorTop:I

    move/from16 v19, v0

    add-int v18, v18, v19

    move/from16 v0, v18

    iput v0, v9, Landroid/graphics/Rect;->bottom:I

    goto/16 :goto_2

    .line 345
    :cond_7
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mIndicatorLeft:I

    move/from16 v18, v0

    add-int v18, v18, v13

    move/from16 v0, v18

    iput v0, v9, Landroid/graphics/Rect;->left:I

    .line 346
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mIndicatorLeft:I

    move/from16 v18, v0

    add-int v18, v18, v16

    move/from16 v0, v18

    iput v0, v9, Landroid/graphics/Rect;->right:I

    goto/16 :goto_3

    .line 358
    .restart local v8    # "indicator":Landroid/graphics/drawable/Drawable;
    :cond_8
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mIndicatorGravity:I

    move/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicatorWidth:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicatorHeight:I

    move/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mTempRect:Landroid/graphics/Rect;

    move-object/from16 v21, v0

    move/from16 v0, v18

    move/from16 v1, v19

    move/from16 v2, v20

    move-object/from16 v3, v21

    invoke-static {v0, v1, v2, v9, v3}, Landroid/view/Gravity;->apply(IIILandroid/graphics/Rect;Landroid/graphics/Rect;)V

    goto :goto_4
.end method

.method drawDivider(Landroid/graphics/Canvas;Landroid/graphics/Rect;I)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "bounds"    # Landroid/graphics/Rect;
    .param p3, "childIndex"    # I

    .prologue
    .line 421
    iget v4, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mFirstPosition:I

    add-int v2, p3, v4

    .line 425
    .local v2, "flatListPosition":I
    if-ltz v2, :cond_2

    .line 426
    invoke-direct {p0, v2}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getFlatPositionForConnector(I)I

    move-result v0

    .line 427
    .local v0, "adjustedPosition":I
    iget-object v4, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    invoke-virtual {v4, v0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v3

    .line 429
    .local v3, "pos":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    iget-object v4, v3, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v4, v4, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v5, 0x1

    if-eq v4, v5, :cond_0

    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->isExpanded()Z

    move-result v4

    if-eqz v4, :cond_1

    iget-object v4, v3, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    iget v4, v4, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->lastChildFlPos:I

    iget-object v5, v3, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->groupMetadata:Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;

    iget v5, v5, Lit/sephiroth/android/library/widget/ExpandableHListConnector$GroupMetadata;->flPos:I

    if-eq v4, v5, :cond_1

    .line 431
    :cond_0
    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildDivider:Landroid/graphics/drawable/Drawable;

    .line 432
    .local v1, "divider":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1, p2}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 433
    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 434
    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    .line 442
    .end local v0    # "adjustedPosition":I
    .end local v1    # "divider":Landroid/graphics/drawable/Drawable;
    .end local v3    # "pos":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    :goto_0
    return-void

    .line 437
    .restart local v0    # "adjustedPosition":I
    .restart local v3    # "pos":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    :cond_1
    invoke-virtual {v3}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    .line 441
    .end local v0    # "adjustedPosition":I
    .end local v3    # "pos":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    :cond_2
    invoke-super {p0, p1, p2, v2}, Lit/sephiroth/android/library/widget/HListView;->drawDivider(Landroid/graphics/Canvas;Landroid/graphics/Rect;I)V

    goto :goto_0
.end method

.method public bridge synthetic getAdapter()Landroid/widget/Adapter;
    .locals 1

    .prologue
    .line 88
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    return-object v0
.end method

.method public getAdapter()Landroid/widget/ListAdapter;
    .locals 1

    .prologue
    .line 465
    invoke-super {p0}, Lit/sephiroth/android/library/widget/HListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    return-object v0
.end method

.method public getExpandableListAdapter()Landroid/widget/ExpandableListAdapter;
    .locals 1

    .prologue
    .line 508
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mAdapter:Landroid/widget/ExpandableListAdapter;

    return-object v0
.end method

.method public getExpandableListPosition(I)J
    .locals 5
    .param p1, "flatListPosition"    # I

    .prologue
    .line 784
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListView;->isHeaderOrFooterPosition(I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 785
    const-wide v2, 0xffffffffL

    .line 792
    :goto_0
    return-wide v2

    .line 788
    :cond_0
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getFlatPositionForConnector(I)I

    move-result v0

    .line 789
    .local v0, "adjustedPosition":I
    iget-object v4, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    invoke-virtual {v4, v0}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v1

    .line 790
    .local v1, "pm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    iget-object v4, v1, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    invoke-virtual {v4}, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->getPackedPosition()J

    move-result-wide v2

    .line 791
    .local v2, "packedPos":J
    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    goto :goto_0
.end method

.method public getSelectedId()J
    .locals 6

    .prologue
    .line 838
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getSelectedPosition()J

    move-result-wide v2

    .line 839
    .local v2, "packedPos":J
    const-wide v4, 0xffffffffL

    cmp-long v1, v2, v4

    if-nez v1, :cond_0

    const-wide/16 v4, -0x1

    .line 849
    :goto_0
    return-wide v4

    .line 841
    :cond_0
    invoke-static {v2, v3}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getPackedPositionGroup(J)I

    move-result v0

    .line 843
    .local v0, "groupPos":I
    invoke-static {v2, v3}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getPackedPositionType(J)I

    move-result v1

    if-nez v1, :cond_1

    .line 845
    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mAdapter:Landroid/widget/ExpandableListAdapter;

    invoke-interface {v1, v0}, Landroid/widget/ExpandableListAdapter;->getGroupId(I)J

    move-result-wide v4

    goto :goto_0

    .line 849
    :cond_1
    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mAdapter:Landroid/widget/ExpandableListAdapter;

    invoke-static {v2, v3}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getPackedPositionChild(J)I

    move-result v4

    invoke-interface {v1, v0, v4}, Landroid/widget/ExpandableListAdapter;->getChildId(II)J

    move-result-wide v4

    goto :goto_0
.end method

.method public getSelectedPosition()J
    .locals 4

    .prologue
    .line 824
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getSelectedItemPosition()I

    move-result v0

    .line 827
    .local v0, "selectedPos":I
    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getExpandableListPosition(I)J

    move-result-wide v2

    return-wide v2
.end method

.method handleItemClick(Landroid/view/View;IJ)Z
    .locals 13
    .param p1, "v"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "id"    # J

    .prologue
    .line 564
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    invoke-virtual {v0, p2}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getUnflattenedPos(I)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v10

    .line 566
    .local v10, "posMetadata":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    iget-object v0, v10, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    invoke-direct {p0, v0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getChildOrGroupId(Lit/sephiroth/android/library/widget/ExpandableHListPosition;)J

    move-result-wide p3

    .line 569
    iget-object v0, v10, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v0, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->type:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_4

    .line 573
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnGroupClickListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupClickListener;

    if-eqz v0, :cond_0

    .line 574
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnGroupClickListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupClickListener;

    iget-object v1, v10, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v3, v1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    move-object v1, p0

    move-object v2, p1

    move-wide/from16 v4, p3

    invoke-interface/range {v0 .. v5}, Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupClickListener;->onGroupClick(Lit/sephiroth/android/library/widget/ExpandableHListView;Landroid/view/View;IJ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 575
    invoke-virtual {v10}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    .line 576
    const/4 v11, 0x1

    .line 621
    :goto_0
    return v11

    .line 580
    :cond_0
    invoke-virtual {v10}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->isExpanded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 582
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    invoke-virtual {v0, v10}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->collapseGroup(Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;)Z

    .line 584
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->playSoundEffect(I)V

    .line 586
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnGroupCollapseListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupCollapseListener;

    if-eqz v0, :cond_1

    .line 587
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnGroupCollapseListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupCollapseListener;

    iget-object v1, v10, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v1, v1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    invoke-interface {v0, v1}, Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupCollapseListener;->onGroupCollapse(I)V

    .line 607
    :cond_1
    :goto_1
    const/4 v11, 0x1

    .line 619
    .local v11, "returnValue":Z
    :goto_2
    invoke-virtual {v10}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    goto :goto_0

    .line 592
    .end local v11    # "returnValue":Z
    :cond_2
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    invoke-virtual {v0, v10}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->expandGroup(Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;)Z

    .line 594
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->playSoundEffect(I)V

    .line 596
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnGroupExpandListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupExpandListener;

    if-eqz v0, :cond_3

    .line 597
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnGroupExpandListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupExpandListener;

    iget-object v1, v10, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v1, v1, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    invoke-interface {v0, v1}, Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupExpandListener;->onGroupExpand(I)V

    .line 600
    :cond_3
    iget-object v0, v10, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v9, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    .line 601
    .local v9, "groupPos":I
    iget-object v0, v10, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v8, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->flatListPos:I

    .line 603
    .local v8, "groupFlatPos":I
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getHeaderViewsCount()I

    move-result v0

    add-int v12, v8, v0

    .line 604
    .local v12, "shiftedGroupPosition":I
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mAdapter:Landroid/widget/ExpandableListAdapter;

    invoke-interface {v0, v9}, Landroid/widget/ExpandableListAdapter;->getChildrenCount(I)I

    move-result v0

    add-int/2addr v0, v12

    invoke-virtual {p0, v0, v12}, Lit/sephiroth/android/library/widget/ExpandableHListView;->smoothScrollToPosition(II)V

    goto :goto_1

    .line 611
    .end local v8    # "groupFlatPos":I
    .end local v9    # "groupPos":I
    .end local v12    # "shiftedGroupPosition":I
    :cond_4
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnChildClickListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnChildClickListener;

    if-eqz v0, :cond_5

    .line 612
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->playSoundEffect(I)V

    .line 613
    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnChildClickListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnChildClickListener;

    iget-object v0, v10, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v4, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->groupPos:I

    iget-object v0, v10, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v5, v0, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->childPos:I

    move-object v2, p0

    move-object v3, p1

    move-wide/from16 v6, p3

    invoke-interface/range {v1 .. v7}, Lit/sephiroth/android/library/widget/ExpandableHListView$OnChildClickListener;->onChildClick(Lit/sephiroth/android/library/widget/ExpandableHListView;Landroid/view/View;IIJ)Z

    move-result v11

    goto :goto_0

    .line 616
    :cond_5
    const/4 v11, 0x0

    .restart local v11    # "returnValue":Z
    goto :goto_2
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .prologue
    .line 1163
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 1164
    const-class v0, Lit/sephiroth/android/library/widget/ExpandableHListView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 1165
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 1
    .param p1, "info"    # Landroid/view/accessibility/AccessibilityNodeInfo;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 1170
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 1171
    const-class v0, Lit/sephiroth/android/library/widget/ExpandableHListView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    .line 1172
    return-void
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 3
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    .line 1148
    instance-of v1, p1, Lit/sephiroth/android/library/widget/ExpandableHListView$SavedState;

    if-nez v1, :cond_1

    .line 1149
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 1159
    :cond_0
    :goto_0
    return-void

    :cond_1
    move-object v0, p1

    .line 1153
    check-cast v0, Lit/sephiroth/android/library/widget/ExpandableHListView$SavedState;

    .line 1154
    .local v0, "ss":Lit/sephiroth/android/library/widget/ExpandableHListView$SavedState;
    invoke-virtual {v0}, Lit/sephiroth/android/library/widget/ExpandableHListView$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Lit/sephiroth/android/library/widget/HListView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 1156
    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    if-eqz v1, :cond_0

    iget-object v1, v0, Lit/sephiroth/android/library/widget/ExpandableHListView$SavedState;->expandedGroupMetadataList:Ljava/util/ArrayList;

    if-eqz v1, :cond_0

    .line 1157
    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    iget-object v2, v0, Lit/sephiroth/android/library/widget/ExpandableHListView$SavedState;->expandedGroupMetadataList:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->setExpandedGroupMetadataList(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public onRtlPropertiesChanged(I)V
    .locals 0
    .param p1, "layoutDirection"    # I

    .prologue
    .line 236
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->resolveIndicator()V

    .line 237
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->resolveChildIndicator()V

    .line 238
    return-void
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .prologue
    .line 1142
    invoke-super {p0}, Lit/sephiroth/android/library/widget/HListView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    .line 1143
    .local v0, "superState":Landroid/os/Parcelable;
    new-instance v2, Lit/sephiroth/android/library/widget/ExpandableHListView$SavedState;

    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getExpandedGroupMetadataList()Ljava/util/ArrayList;

    move-result-object v1

    :goto_0
    invoke-direct {v2, v0, v1}, Lit/sephiroth/android/library/widget/ExpandableHListView$SavedState;-><init>(Landroid/os/Parcelable;Ljava/util/ArrayList;)V

    return-object v2

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public performItemClick(Landroid/view/View;IJ)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "id"    # J

    .prologue
    .line 545
    invoke-direct {p0, p2}, Lit/sephiroth/android/library/widget/ExpandableHListView;->isHeaderOrFooterPosition(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 547
    invoke-super {p0, p1, p2, p3, p4}, Lit/sephiroth/android/library/widget/HListView;->performItemClick(Landroid/view/View;IJ)Z

    move-result v1

    .line 552
    :goto_0
    return v1

    .line 551
    :cond_0
    invoke-direct {p0, p2}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getFlatPositionForConnector(I)I

    move-result v0

    .line 552
    .local v0, "adjustedPosition":I
    invoke-virtual {p0, p1, v0, p3, p4}, Lit/sephiroth/android/library/widget/ExpandableHListView;->handleItemClick(Landroid/view/View;IJ)Z

    move-result v1

    goto :goto_0
.end method

.method public bridge synthetic setAdapter(Landroid/widget/Adapter;)V
    .locals 0
    .param p1, "x0"    # Landroid/widget/Adapter;

    .prologue
    .line 88
    check-cast p1, Landroid/widget/ListAdapter;

    .end local p1    # "x0":Landroid/widget/Adapter;
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListView;->setAdapter(Landroid/widget/ListAdapter;)V

    return-void
.end method

.method public setAdapter(Landroid/widget/ExpandableListAdapter;)V
    .locals 1
    .param p1, "adapter"    # Landroid/widget/ExpandableListAdapter;

    .prologue
    .line 488
    iput-object p1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mAdapter:Landroid/widget/ExpandableListAdapter;

    .line 490
    if-eqz p1, :cond_0

    .line 492
    new-instance v0, Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    invoke-direct {v0, p1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;-><init>(Landroid/widget/ExpandableListAdapter;)V

    iput-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    .line 499
    :goto_0
    iget-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    invoke-super {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 500
    return-void

    .line 495
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    goto :goto_0
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 2
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 452
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setChildDivider(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "childDivider"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 416
    iput-object p1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildDivider:Landroid/graphics/drawable/Drawable;

    .line 417
    return-void
.end method

.method public setChildIndicator(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "childIndicator"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 1049
    iput-object p1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mChildIndicator:Landroid/graphics/drawable/Drawable;

    .line 1050
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->resolveChildIndicator()V

    .line 1051
    return-void
.end method

.method public setGroupIndicator(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "groupIndicator"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 1062
    iput-object p1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mGroupIndicator:Landroid/graphics/drawable/Drawable;

    .line 1063
    invoke-direct {p0}, Lit/sephiroth/android/library/widget/ExpandableHListView;->resolveIndicator()V

    .line 1064
    return-void
.end method

.method public setOnChildClickListener(Lit/sephiroth/android/library/widget/ExpandableHListView$OnChildClickListener;)V
    .locals 0
    .param p1, "onChildClickListener"    # Lit/sephiroth/android/library/widget/ExpandableHListView$OnChildClickListener;

    .prologue
    .line 766
    iput-object p1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnChildClickListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnChildClickListener;

    .line 767
    return-void
.end method

.method public setOnGroupClickListener(Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupClickListener;)V
    .locals 0
    .param p1, "onGroupClickListener"    # Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupClickListener;

    .prologue
    .line 739
    iput-object p1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnGroupClickListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupClickListener;

    .line 740
    return-void
.end method

.method public setOnGroupCollapseListener(Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupCollapseListener;)V
    .locals 0
    .param p1, "onGroupCollapseListener"    # Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupCollapseListener;

    .prologue
    .line 696
    iput-object p1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnGroupCollapseListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupCollapseListener;

    .line 697
    return-void
.end method

.method public setOnGroupExpandListener(Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupExpandListener;)V
    .locals 0
    .param p1, "onGroupExpandListener"    # Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupExpandListener;

    .prologue
    .line 714
    iput-object p1, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mOnGroupExpandListener:Lit/sephiroth/android/library/widget/ExpandableHListView$OnGroupExpandListener;

    .line 715
    return-void
.end method

.method public setOnItemClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;)V
    .locals 0
    .param p1, "l"    # Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;

    .prologue
    .line 478
    invoke-super {p0, p1}, Lit/sephiroth/android/library/widget/HListView;->setOnItemClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;)V

    .line 479
    return-void
.end method

.method public setSelectedGroup(I)V
    .locals 4
    .param p1, "groupPosition"    # I

    .prologue
    .line 859
    invoke-static {p1}, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->obtainGroupPosition(I)Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    move-result-object v1

    .line 860
    .local v1, "elGroupPos":Lit/sephiroth/android/library/widget/ExpandableHListPosition;
    iget-object v3, p0, Lit/sephiroth/android/library/widget/ExpandableHListView;->mConnector:Lit/sephiroth/android/library/widget/ExpandableHListConnector;

    invoke-virtual {v3, v1}, Lit/sephiroth/android/library/widget/ExpandableHListConnector;->getFlattenedPos(Lit/sephiroth/android/library/widget/ExpandableHListPosition;)Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;

    move-result-object v2

    .line 861
    .local v2, "pm":Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;
    invoke-virtual {v1}, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->recycle()V

    .line 862
    iget-object v3, v2, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->position:Lit/sephiroth/android/library/widget/ExpandableHListPosition;

    iget v3, v3, Lit/sephiroth/android/library/widget/ExpandableHListPosition;->flatListPos:I

    invoke-direct {p0, v3}, Lit/sephiroth/android/library/widget/ExpandableHListView;->getAbsoluteFlatPosition(I)I

    move-result v0

    .line 863
    .local v0, "absoluteFlatPosition":I
    invoke-super {p0, v0}, Lit/sephiroth/android/library/widget/HListView;->setSelection(I)V

    .line 864
    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/ExpandableHListConnector$PositionMetadata;->recycle()V

    .line 865
    return-void
.end method
