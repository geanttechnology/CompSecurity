.class public Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;
.super Ljava/lang/Object;
.source "AbsHListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/AbsHListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PositionScroller"
.end annotation


# instance fields
.field private mBoundPos:I

.field private final mExtraScroll:I

.field private mLastSeenPos:I

.field private mMode:I

.field private mOffsetFromLeft:I

.field private mScrollDuration:I

.field private mTargetPos:I

.field final synthetic this$0:Lit/sephiroth/android/library/widget/AbsHListView;


# direct methods
.method constructor <init>(Lit/sephiroth/android/library/widget/AbsHListView;)V
    .locals 1

    .prologue
    .line 3927
    iput-object p1, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3928
    invoke-virtual {p1}, Lit/sephiroth/android/library/widget/AbsHListView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledFadingEdgeLength()I

    move-result v0

    iput v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mExtraScroll:I

    .line 3929
    return-void
.end method


# virtual methods
.method public run()V
    .locals 35

    .prologue
    .line 4178
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v18

    .line 4179
    .local v18, "listWidth":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget v8, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 4181
    .local v8, "firstPos":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mMode:I

    move/from16 v31, v0

    packed-switch v31, :pswitch_data_0

    .line 4349
    :cond_0
    :goto_0
    return-void

    .line 4183
    :pswitch_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v31

    add-int/lit8 v13, v31, -0x1

    .line 4184
    .local v13, "lastViewIndex":I
    add-int v11, v8, v13

    .line 4186
    .local v11, "lastPos":I
    if-ltz v13, :cond_0

    .line 4190
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    move/from16 v31, v0

    move/from16 v0, v31

    if-ne v11, v0, :cond_1

    .line 4192
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 4196
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    invoke-virtual {v0, v13}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v12

    .line 4197
    .local v12, "lastView":Landroid/view/View;
    invoke-virtual {v12}, Landroid/view/View;->getWidth()I

    move-result v17

    .line 4198
    .local v17, "lastViewWidth":I
    invoke-virtual {v12}, Landroid/view/View;->getLeft()I

    move-result v14

    .line 4199
    .local v14, "lastViewLeft":I
    sub-int v15, v18, v14

    .line 4200
    .local v15, "lastViewPixelsShowing":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    move/from16 v31, v0

    add-int/lit8 v31, v31, -0x1

    move/from16 v0, v31

    if-ge v11, v0, :cond_2

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v31, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mExtraScroll:I

    move/from16 v32, v0

    invoke-static/range {v31 .. v32}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 4202
    .local v7, "extraScroll":I
    :goto_1
    sub-int v31, v17, v15

    add-int v28, v31, v7

    .line 4203
    .local v28, "scrollBy":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    move/from16 v32, v0

    const/16 v33, 0x1

    move-object/from16 v0, v31

    move/from16 v1, v28

    move/from16 v2, v32

    move/from16 v3, v33

    invoke-virtual {v0, v1, v2, v3}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(IIZ)V

    .line 4205
    move-object/from16 v0, p0

    iput v11, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    .line 4206
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mTargetPos:I

    move/from16 v31, v0

    move/from16 v0, v31

    if-ge v11, v0, :cond_0

    .line 4207
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 4200
    .end local v7    # "extraScroll":I
    .end local v28    # "scrollBy":I
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget v7, v0, Landroid/graphics/Rect;->right:I

    goto :goto_1

    .line 4213
    .end local v11    # "lastPos":I
    .end local v12    # "lastView":Landroid/view/View;
    .end local v13    # "lastViewIndex":I
    .end local v14    # "lastViewLeft":I
    .end local v15    # "lastViewPixelsShowing":I
    .end local v17    # "lastViewWidth":I
    :pswitch_1
    const/16 v22, 0x1

    .line 4214
    .local v22, "nextViewIndex":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v4

    .line 4216
    .local v4, "childCount":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mBoundPos:I

    move/from16 v31, v0

    move/from16 v0, v31

    if-eq v8, v0, :cond_0

    const/16 v31, 0x1

    move/from16 v0, v31

    if-le v4, v0, :cond_0

    add-int v31, v8, v4

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v32, v0

    move-object/from16 v0, v32

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mItemCount:I

    move/from16 v32, v0

    move/from16 v0, v31

    move/from16 v1, v32

    if-ge v0, v1, :cond_0

    .line 4220
    add-int/lit8 v20, v8, 0x1

    .line 4222
    .local v20, "nextPos":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    move/from16 v31, v0

    move/from16 v0, v20

    move/from16 v1, v31

    if-ne v0, v1, :cond_3

    .line 4224
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 4228
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    const/16 v32, 0x1

    invoke-virtual/range {v31 .. v32}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v21

    .line 4229
    .local v21, "nextView":Landroid/view/View;
    invoke-virtual/range {v21 .. v21}, Landroid/view/View;->getWidth()I

    move-result v24

    .line 4230
    .local v24, "nextViewWidth":I
    invoke-virtual/range {v21 .. v21}, Landroid/view/View;->getLeft()I

    move-result v23

    .line 4231
    .local v23, "nextViewLeft":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v31, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mExtraScroll:I

    move/from16 v32, v0

    invoke-static/range {v31 .. v32}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 4232
    .restart local v7    # "extraScroll":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mBoundPos:I

    move/from16 v31, v0

    move/from16 v0, v20

    move/from16 v1, v31

    if-ge v0, v1, :cond_4

    .line 4233
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    add-int v33, v24, v23

    sub-int v33, v33, v7

    invoke-static/range {v32 .. v33}, Ljava/lang/Math;->max(II)I

    move-result v32

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    move/from16 v33, v0

    const/16 v34, 0x1

    invoke-virtual/range {v31 .. v34}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(IIZ)V

    .line 4235
    move/from16 v0, v20

    move-object/from16 v1, p0

    iput v0, v1, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    .line 4237
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 4239
    :cond_4
    move/from16 v0, v23

    if-le v0, v7, :cond_0

    .line 4240
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    sub-int v32, v23, v7

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    move/from16 v33, v0

    const/16 v34, 0x1

    invoke-virtual/range {v31 .. v34}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(IIZ)V

    goto/16 :goto_0

    .line 4247
    .end local v4    # "childCount":I
    .end local v7    # "extraScroll":I
    .end local v20    # "nextPos":I
    .end local v21    # "nextView":Landroid/view/View;
    .end local v22    # "nextViewIndex":I
    .end local v23    # "nextViewLeft":I
    .end local v24    # "nextViewWidth":I
    :pswitch_2
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    move/from16 v31, v0

    move/from16 v0, v31

    if-ne v8, v0, :cond_5

    .line 4249
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 4253
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    const/16 v32, 0x0

    invoke-virtual/range {v31 .. v32}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v9

    .line 4254
    .local v9, "firstView":Landroid/view/View;
    if-eqz v9, :cond_0

    .line 4257
    invoke-virtual {v9}, Landroid/view/View;->getLeft()I

    move-result v10

    .line 4258
    .local v10, "firstViewLeft":I
    if-lez v8, :cond_6

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mExtraScroll:I

    move/from16 v31, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v32, v0

    move-object/from16 v0, v32

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v32, v0

    move-object/from16 v0, v32

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v32, v0

    invoke-static/range {v31 .. v32}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 4260
    .restart local v7    # "extraScroll":I
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    sub-int v32, v10, v7

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    move/from16 v33, v0

    const/16 v34, 0x1

    invoke-virtual/range {v31 .. v34}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(IIZ)V

    .line 4262
    move-object/from16 v0, p0

    iput v8, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    .line 4264
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mTargetPos:I

    move/from16 v31, v0

    move/from16 v0, v31

    if-le v8, v0, :cond_0

    .line 4265
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 4258
    .end local v7    # "extraScroll":I
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget v7, v0, Landroid/graphics/Rect;->left:I

    goto :goto_2

    .line 4271
    .end local v9    # "firstView":Landroid/view/View;
    .end local v10    # "firstViewLeft":I
    :pswitch_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v31

    add-int/lit8 v13, v31, -0x2

    .line 4272
    .restart local v13    # "lastViewIndex":I
    if-ltz v13, :cond_0

    .line 4275
    add-int v11, v8, v13

    .line 4277
    .restart local v11    # "lastPos":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    move/from16 v31, v0

    move/from16 v0, v31

    if-ne v11, v0, :cond_7

    .line 4279
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 4283
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    invoke-virtual {v0, v13}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v12

    .line 4284
    .restart local v12    # "lastView":Landroid/view/View;
    invoke-virtual {v12}, Landroid/view/View;->getWidth()I

    move-result v17

    .line 4285
    .restart local v17    # "lastViewWidth":I
    invoke-virtual {v12}, Landroid/view/View;->getLeft()I

    move-result v14

    .line 4286
    .restart local v14    # "lastViewLeft":I
    sub-int v15, v18, v14

    .line 4287
    .restart local v15    # "lastViewPixelsShowing":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v31, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mExtraScroll:I

    move/from16 v32, v0

    invoke-static/range {v31 .. v32}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 4288
    .restart local v7    # "extraScroll":I
    move-object/from16 v0, p0

    iput v11, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    .line 4289
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mBoundPos:I

    move/from16 v31, v0

    move/from16 v0, v31

    if-le v11, v0, :cond_8

    .line 4290
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    sub-int v32, v15, v7

    move/from16 v0, v32

    neg-int v0, v0

    move/from16 v32, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    move/from16 v33, v0

    const/16 v34, 0x1

    invoke-virtual/range {v31 .. v34}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(IIZ)V

    .line 4291
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 4293
    :cond_8
    sub-int v26, v18, v7

    .line 4294
    .local v26, "right":I
    add-int v16, v14, v17

    .line 4295
    .local v16, "lastViewRight":I
    move/from16 v0, v26

    move/from16 v1, v16

    if-le v0, v1, :cond_0

    .line 4296
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    sub-int v32, v26, v16

    move/from16 v0, v32

    neg-int v0, v0

    move/from16 v32, v0

    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    move/from16 v33, v0

    const/16 v34, 0x1

    invoke-virtual/range {v31 .. v34}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(IIZ)V

    goto/16 :goto_0

    .line 4303
    .end local v7    # "extraScroll":I
    .end local v11    # "lastPos":I
    .end local v12    # "lastView":Landroid/view/View;
    .end local v13    # "lastViewIndex":I
    .end local v14    # "lastViewLeft":I
    .end local v15    # "lastViewPixelsShowing":I
    .end local v16    # "lastViewRight":I
    .end local v17    # "lastViewWidth":I
    .end local v26    # "right":I
    :pswitch_4
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    move/from16 v31, v0

    move/from16 v0, v31

    if-ne v0, v8, :cond_9

    .line 4305
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 4309
    :cond_9
    move-object/from16 v0, p0

    iput v8, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    .line 4311
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v4

    .line 4312
    .restart local v4    # "childCount":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mTargetPos:I

    move/from16 v25, v0

    .line 4313
    .local v25, "position":I
    add-int v31, v8, v4

    add-int/lit8 v11, v31, -0x1

    .line 4315
    .restart local v11    # "lastPos":I
    const/16 v30, 0x0

    .line 4316
    .local v30, "viewTravelCount":I
    move/from16 v0, v25

    if-ge v0, v8, :cond_b

    .line 4317
    sub-int v31, v8, v25

    add-int/lit8 v30, v31, 0x1

    .line 4323
    :cond_a
    :goto_3
    move/from16 v0, v30

    int-to-float v0, v0

    move/from16 v31, v0

    int-to-float v0, v4

    move/from16 v32, v0

    div-float v27, v31, v32

    .line 4325
    .local v27, "screenTravelCount":F
    invoke-static/range {v27 .. v27}, Ljava/lang/Math;->abs(F)F

    move-result v31

    const/high16 v32, 0x3f800000    # 1.0f

    invoke-static/range {v31 .. v32}, Ljava/lang/Math;->min(FF)F

    move-result v19

    .line 4326
    .local v19, "modifier":F
    move/from16 v0, v25

    if-ge v0, v8, :cond_c

    .line 4327
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v31

    move/from16 v0, v31

    neg-int v0, v0

    move/from16 v31, v0

    move/from16 v0, v31

    int-to-float v0, v0

    move/from16 v31, v0

    mul-float v31, v31, v19

    move/from16 v0, v31

    float-to-int v5, v0

    .line 4328
    .local v5, "distance":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    move/from16 v31, v0

    move/from16 v0, v31

    int-to-float v0, v0

    move/from16 v31, v0

    mul-float v31, v31, v19

    move/from16 v0, v31

    float-to-int v6, v0

    .line 4329
    .local v6, "duration":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    const/16 v32, 0x1

    move-object/from16 v0, v31

    move/from16 v1, v32

    invoke-virtual {v0, v5, v6, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(IIZ)V

    .line 4330
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 4318
    .end local v5    # "distance":I
    .end local v6    # "duration":I
    .end local v19    # "modifier":F
    .end local v27    # "screenTravelCount":F
    :cond_b
    move/from16 v0, v25

    if-le v0, v11, :cond_a

    .line 4319
    sub-int v30, v25, v11

    goto :goto_3

    .line 4331
    .restart local v19    # "modifier":F
    .restart local v27    # "screenTravelCount":F
    :cond_c
    move/from16 v0, v25

    if-le v0, v11, :cond_d

    .line 4332
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v31

    move/from16 v0, v31

    int-to-float v0, v0

    move/from16 v31, v0

    mul-float v31, v31, v19

    move/from16 v0, v31

    float-to-int v5, v0

    .line 4333
    .restart local v5    # "distance":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    move/from16 v31, v0

    move/from16 v0, v31

    int-to-float v0, v0

    move/from16 v31, v0

    mul-float v31, v31, v19

    move/from16 v0, v31

    float-to-int v6, v0

    .line 4334
    .restart local v6    # "duration":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    const/16 v32, 0x1

    move-object/from16 v0, v31

    move/from16 v1, v32

    invoke-virtual {v0, v5, v6, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(IIZ)V

    .line 4335
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto/16 :goto_0

    .line 4338
    .end local v5    # "distance":I
    .end local v6    # "duration":I
    :cond_d
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    sub-int v32, v25, v8

    invoke-virtual/range {v31 .. v32}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v31

    invoke-virtual/range {v31 .. v31}, Landroid/view/View;->getLeft()I

    move-result v29

    .line 4339
    .local v29, "targetLeft":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mOffsetFromLeft:I

    move/from16 v31, v0

    sub-int v5, v29, v31

    .line 4340
    .restart local v5    # "distance":I
    move-object/from16 v0, p0

    iget v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    move/from16 v31, v0

    move/from16 v0, v31

    int-to-float v0, v0

    move/from16 v31, v0

    invoke-static {v5}, Ljava/lang/Math;->abs(I)I

    move-result v32

    move/from16 v0, v32

    int-to-float v0, v0

    move/from16 v32, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v33, v0

    invoke-virtual/range {v33 .. v33}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v33

    move/from16 v0, v33

    int-to-float v0, v0

    move/from16 v33, v0

    div-float v32, v32, v33

    mul-float v31, v31, v32

    move/from16 v0, v31

    float-to-int v6, v0

    .line 4341
    .restart local v6    # "duration":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move-object/from16 v31, v0

    const/16 v32, 0x1

    move-object/from16 v0, v31

    move/from16 v1, v32

    invoke-virtual {v0, v5, v6, v1}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(IIZ)V

    goto/16 :goto_0

    .line 4181
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method scrollToVisible(III)V
    .locals 17
    .param p1, "targetPos"    # I
    .param p2, "boundPos"    # I
    .param p3, "duration"    # I

    .prologue
    .line 4123
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v6, v14, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 4124
    .local v6, "firstPos":I
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v14}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v5

    .line 4125
    .local v5, "childCount":I
    add-int v14, v6, v5

    add-int/lit8 v7, v14, -0x1

    .line 4126
    .local v7, "lastPos":I
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v14, v14, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v8, v14, Landroid/graphics/Rect;->left:I

    .line 4127
    .local v8, "paddedLeft":I
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v14}, Lit/sephiroth/android/library/widget/AbsHListView;->getWidth()I

    move-result v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v15, v15, Lit/sephiroth/android/library/widget/AbsHListView;->mListPadding:Landroid/graphics/Rect;

    iget v15, v15, Landroid/graphics/Rect;->right:I

    sub-int v9, v14, v15

    .line 4129
    .local v9, "paddedRight":I
    move/from16 v0, p1

    if-lt v0, v6, :cond_0

    move/from16 v0, p1

    if-le v0, v7, :cond_1

    .line 4130
    :cond_0
    const-string v14, "AbsListView"

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "scrollToVisible called with targetPos "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move/from16 v0, p1

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, " not visible ["

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, ", "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "]"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 4133
    :cond_1
    move/from16 v0, p2

    if-lt v0, v6, :cond_2

    move/from16 v0, p2

    if-le v0, v7, :cond_3

    .line 4135
    :cond_2
    const/16 p2, -0x1

    .line 4138
    :cond_3
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    sub-int v15, p1, v6

    invoke-virtual {v14, v15}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v11

    .line 4139
    .local v11, "targetChild":Landroid/view/View;
    invoke-virtual {v11}, Landroid/view/View;->getLeft()I

    move-result v12

    .line 4140
    .local v12, "targetLeft":I
    invoke-virtual {v11}, Landroid/view/View;->getRight()I

    move-result v13

    .line 4141
    .local v13, "targetRight":I
    const/4 v10, 0x0

    .line 4143
    .local v10, "scrollBy":I
    if-le v13, v9, :cond_4

    .line 4144
    sub-int v10, v13, v9

    .line 4146
    :cond_4
    if-ge v12, v8, :cond_5

    .line 4147
    sub-int v10, v12, v8

    .line 4150
    :cond_5
    if-nez v10, :cond_6

    .line 4170
    :goto_0
    return-void

    .line 4154
    :cond_6
    if-ltz p2, :cond_7

    .line 4155
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    sub-int v15, p2, v6

    invoke-virtual {v14, v15}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 4156
    .local v2, "boundChild":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getLeft()I

    move-result v3

    .line 4157
    .local v3, "boundLeft":I
    invoke-virtual {v2}, Landroid/view/View;->getRight()I

    move-result v4

    .line 4158
    .local v4, "boundRight":I
    invoke-static {v10}, Ljava/lang/Math;->abs(I)I

    move-result v1

    .line 4160
    .local v1, "absScroll":I
    if-gez v10, :cond_8

    add-int v14, v4, v1

    if-le v14, v9, :cond_8

    .line 4162
    const/4 v14, 0x0

    sub-int v15, v4, v9

    invoke-static {v14, v15}, Ljava/lang/Math;->max(II)I

    move-result v10

    .line 4169
    .end local v1    # "absScroll":I
    .end local v2    # "boundChild":Landroid/view/View;
    .end local v3    # "boundLeft":I
    .end local v4    # "boundRight":I
    :cond_7
    :goto_1
    move-object/from16 v0, p0

    iget-object v14, v0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    move/from16 v0, p3

    invoke-virtual {v14, v10, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->smoothScrollBy(II)V

    goto :goto_0

    .line 4163
    .restart local v1    # "absScroll":I
    .restart local v2    # "boundChild":Landroid/view/View;
    .restart local v3    # "boundLeft":I
    .restart local v4    # "boundRight":I
    :cond_8
    if-lez v10, :cond_7

    sub-int v14, v3, v1

    if-ge v14, v8, :cond_7

    .line 4165
    const/4 v14, 0x0

    sub-int v15, v3, v8

    invoke-static {v14, v15}, Ljava/lang/Math;->min(II)I

    move-result v10

    goto :goto_1
.end method

.method start(I)V
    .locals 9
    .param p1, "position"    # I

    .prologue
    const/16 v8, 0xc8

    const/4 v7, -0x1

    .line 3932
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 3934
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-boolean v5, v5, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    if-eqz v5, :cond_1

    .line 3936
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    new-instance v6, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller$1;

    invoke-direct {v6, p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller$1;-><init>(Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;I)V

    iput-object v6, v5, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScrollAfterLayout:Ljava/lang/Runnable;

    .line 3978
    :cond_0
    :goto_0
    return-void

    .line 3946
    :cond_1
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v5}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v0

    .line 3947
    .local v0, "childCount":I
    if-eqz v0, :cond_0

    .line 3952
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v2, v5, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 3953
    .local v2, "firstPos":I
    add-int v5, v2, v0

    add-int/lit8 v3, v5, -0x1

    .line 3956
    .local v3, "lastPos":I
    const/4 v5, 0x0

    iget-object v6, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v6}, Lit/sephiroth/android/library/widget/AbsHListView;->getCount()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-static {v6, p1}, Ljava/lang/Math;->min(II)I

    move-result v6

    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 3957
    .local v1, "clampedPosition":I
    if-ge v1, v2, :cond_2

    .line 3958
    sub-int v5, v2, v1

    add-int/lit8 v4, v5, 0x1

    .line 3959
    .local v4, "viewTravelCount":I
    const/4 v5, 0x2

    iput v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mMode:I

    .line 3968
    :goto_1
    if-lez v4, :cond_4

    .line 3969
    div-int v5, v8, v4

    iput v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    .line 3973
    :goto_2
    iput v1, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mTargetPos:I

    .line 3974
    iput v7, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mBoundPos:I

    .line 3975
    iput v7, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    .line 3977
    iget-object v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v5, v5, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v5, p0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 3960
    .end local v4    # "viewTravelCount":I
    :cond_2
    if-le v1, v3, :cond_3

    .line 3961
    sub-int v5, v1, v3

    add-int/lit8 v4, v5, 0x1

    .line 3962
    .restart local v4    # "viewTravelCount":I
    const/4 v5, 0x1

    iput v5, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mMode:I

    goto :goto_1

    .line 3964
    .end local v4    # "viewTravelCount":I
    :cond_3
    invoke-virtual {p0, v1, v7, v8}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->scrollToVisible(III)V

    goto :goto_0

    .line 3971
    .restart local v4    # "viewTravelCount":I
    :cond_4
    iput v8, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    goto :goto_2
.end method

.method start(II)V
    .locals 11
    .param p1, "position"    # I
    .param p2, "boundPosition"    # I

    .prologue
    .line 3981
    invoke-virtual {p0}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->stop()V

    .line 3983
    const/4 v9, -0x1

    if-ne p2, v9, :cond_1

    .line 3984
    invoke-virtual {p0, p1}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->start(I)V

    .line 4058
    :cond_0
    :goto_0
    return-void

    .line 3988
    :cond_1
    iget-object v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-boolean v9, v9, Lit/sephiroth/android/library/widget/AbsHListView;->mDataChanged:Z

    if-eqz v9, :cond_2

    .line 3990
    iget-object v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    new-instance v10, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller$2;

    invoke-direct {v10, p0, p1, p2}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller$2;-><init>(Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;II)V

    iput-object v10, v9, Lit/sephiroth/android/library/widget/AbsHListView;->mPositionScrollAfterLayout:Ljava/lang/Runnable;

    goto :goto_0

    .line 4000
    :cond_2
    iget-object v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v9}, Lit/sephiroth/android/library/widget/AbsHListView;->getChildCount()I

    move-result v3

    .line 4001
    .local v3, "childCount":I
    if-eqz v3, :cond_0

    .line 4006
    iget-object v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget v5, v9, Lit/sephiroth/android/library/widget/AbsHListView;->mFirstPosition:I

    .line 4007
    .local v5, "firstPos":I
    add-int v9, v5, v3

    add-int/lit8 v6, v9, -0x1

    .line 4010
    .local v6, "lastPos":I
    const/4 v9, 0x0

    iget-object v10, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v10}, Lit/sephiroth/android/library/widget/AbsHListView;->getCount()I

    move-result v10

    add-int/lit8 v10, v10, -0x1

    invoke-static {v10, p1}, Ljava/lang/Math;->min(II)I

    move-result v10

    invoke-static {v9, v10}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 4011
    .local v4, "clampedPosition":I
    if-ge v4, v5, :cond_4

    .line 4012
    sub-int v1, v6, p2

    .line 4013
    .local v1, "boundPosFromLast":I
    const/4 v9, 0x1

    if-lt v1, v9, :cond_0

    .line 4018
    sub-int v9, v5, v4

    add-int/lit8 v7, v9, 0x1

    .line 4019
    .local v7, "posTravel":I
    add-int/lit8 v2, v1, -0x1

    .line 4020
    .local v2, "boundTravel":I
    if-ge v2, v7, :cond_3

    .line 4021
    move v8, v2

    .line 4022
    .local v8, "viewTravelCount":I
    const/4 v9, 0x4

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mMode:I

    .line 4048
    .end local v1    # "boundPosFromLast":I
    :goto_1
    if-lez v8, :cond_7

    .line 4049
    const/16 v9, 0xc8

    div-int/2addr v9, v8

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    .line 4053
    :goto_2
    iput v4, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mTargetPos:I

    .line 4054
    iput p2, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mBoundPos:I

    .line 4055
    const/4 v9, -0x1

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mLastSeenPos:I

    .line 4057
    iget-object v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    iget-object v9, v9, Lit/sephiroth/android/library/widget/AbsHListView;->mViewHelper:Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;

    invoke-virtual {v9, p0}, Lit/sephiroth/android/library/util/ViewHelperFactory$ViewHelper;->postOnAnimation(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 4024
    .end local v8    # "viewTravelCount":I
    .restart local v1    # "boundPosFromLast":I
    :cond_3
    move v8, v7

    .line 4025
    .restart local v8    # "viewTravelCount":I
    const/4 v9, 0x2

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mMode:I

    goto :goto_1

    .line 4027
    .end local v1    # "boundPosFromLast":I
    .end local v2    # "boundTravel":I
    .end local v7    # "posTravel":I
    .end local v8    # "viewTravelCount":I
    :cond_4
    if-le v4, v6, :cond_6

    .line 4028
    sub-int v0, p2, v5

    .line 4029
    .local v0, "boundPosFromFirst":I
    const/4 v9, 0x1

    if-lt v0, v9, :cond_0

    .line 4034
    sub-int v9, v4, v6

    add-int/lit8 v7, v9, 0x1

    .line 4035
    .restart local v7    # "posTravel":I
    add-int/lit8 v2, v0, -0x1

    .line 4036
    .restart local v2    # "boundTravel":I
    if-ge v2, v7, :cond_5

    .line 4037
    move v8, v2

    .line 4038
    .restart local v8    # "viewTravelCount":I
    const/4 v9, 0x3

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mMode:I

    goto :goto_1

    .line 4040
    .end local v8    # "viewTravelCount":I
    :cond_5
    move v8, v7

    .line 4041
    .restart local v8    # "viewTravelCount":I
    const/4 v9, 0x1

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mMode:I

    goto :goto_1

    .line 4044
    .end local v0    # "boundPosFromFirst":I
    .end local v2    # "boundTravel":I
    .end local v7    # "posTravel":I
    .end local v8    # "viewTravelCount":I
    :cond_6
    const/16 v9, 0xc8

    invoke-virtual {p0, v4, p2, v9}, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->scrollToVisible(III)V

    goto :goto_0

    .line 4051
    .restart local v2    # "boundTravel":I
    .restart local v7    # "posTravel":I
    .restart local v8    # "viewTravelCount":I
    :cond_7
    const/16 v9, 0xc8

    iput v9, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->mScrollDuration:I

    goto :goto_2
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 4173
    iget-object v0, p0, Lit/sephiroth/android/library/widget/AbsHListView$PositionScroller;->this$0:Lit/sephiroth/android/library/widget/AbsHListView;

    invoke-virtual {v0, p0}, Lit/sephiroth/android/library/widget/AbsHListView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 4174
    return-void
.end method
