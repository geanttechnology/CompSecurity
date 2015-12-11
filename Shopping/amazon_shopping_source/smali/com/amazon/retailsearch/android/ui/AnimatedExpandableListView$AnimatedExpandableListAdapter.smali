.class public abstract Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;
.super Landroid/widget/BaseExpandableListAdapter;
.source "AnimatedExpandableListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "AnimatedExpandableListAdapter"
.end annotation


# static fields
.field private static final STATE_COLLAPSING:I = 0x2

.field private static final STATE_EXPANDING:I = 0x1

.field private static final STATE_IDLE:I


# instance fields
.field private groupInfo:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;",
            ">;"
        }
    .end annotation
.end field

.field private parent:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 240
    invoke-direct {p0}, Landroid/widget/BaseExpandableListAdapter;-><init>()V

    .line 241
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->groupInfo:Landroid/util/SparseArray;

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;
    .param p1, "x1"    # Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;

    .prologue
    .line 240
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->setParent(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;II)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;
    .param p1, "x1"    # I
    .param p2, "x2"    # I

    .prologue
    .line 240
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->startExpandAnimation(II)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;II)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;
    .param p1, "x1"    # I
    .param p2, "x2"    # I

    .prologue
    .line 240
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->startCollapseAnimation(II)V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;I)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;
    .param p1, "x1"    # I

    .prologue
    .line 240
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->stopAnimation(I)V

    return-void
.end method

.method private getGroupInfo(I)Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    .locals 2
    .param p1, "groupPosition"    # I

    .prologue
    .line 264
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->groupInfo:Landroid/util/SparseArray;

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    .line 265
    .local v0, "info":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    if-nez v0, :cond_0

    .line 266
    new-instance v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    .end local v0    # "info":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;-><init>(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$1;)V

    .line 267
    .restart local v0    # "info":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->groupInfo:Landroid/util/SparseArray;

    invoke-virtual {v1, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 269
    :cond_0
    return-object v0
.end method

.method private setParent(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;)V
    .locals 0
    .param p1, "parent"    # Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;

    .prologue
    .line 249
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->parent:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;

    .line 250
    return-void
.end method

.method private startCollapseAnimation(II)V
    .locals 2
    .param p1, "groupPosition"    # I
    .param p2, "firstChildPosition"    # I

    .prologue
    .line 285
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getGroupInfo(I)Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    move-result-object v0

    .line 286
    .local v0, "info":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->animating:Z

    .line 287
    iput p2, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->firstChildPosition:I

    .line 288
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->expanding:Z

    .line 289
    return-void
.end method

.method private startExpandAnimation(II)V
    .locals 2
    .param p1, "groupPosition"    # I
    .param p2, "firstChildPosition"    # I

    .prologue
    const/4 v1, 0x1

    .line 278
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getGroupInfo(I)Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    move-result-object v0

    .line 279
    .local v0, "info":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    iput-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->animating:Z

    .line 280
    iput p2, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->firstChildPosition:I

    .line 281
    iput-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->expanding:Z

    .line 282
    return-void
.end method

.method private stopAnimation(I)V
    .locals 2
    .param p1, "groupPosition"    # I

    .prologue
    .line 292
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getGroupInfo(I)Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    move-result-object v0

    .line 293
    .local v0, "info":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->animating:Z

    .line 294
    return-void
.end method


# virtual methods
.method public final getChildType(II)I
    .locals 2
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 301
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getGroupInfo(I)Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    move-result-object v0

    .line 302
    .local v0, "info":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    iget-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->animating:Z

    if-eqz v1, :cond_0

    .line 305
    const/4 v1, 0x0

    .line 310
    :goto_0
    return v1

    :cond_0
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getRealChildType(II)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public final getChildTypeCount()I
    .locals 1

    .prologue
    .line 320
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getRealChildTypeCount()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public final getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 28
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I
    .param p3, "isLastChild"    # Z
    .param p4, "convertView"    # Landroid/view/View;
    .param p5, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 328
    invoke-direct/range {p0 .. p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getGroupInfo(I)Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    move-result-object v10

    .line 330
    .local v10, "info":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    iget-boolean v3, v10, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->animating:Z

    if-eqz v3, :cond_9

    .line 332
    if-nez p4, :cond_0

    .line 333
    new-instance p4, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;

    .end local p4    # "convertView":Landroid/view/View;
    invoke-virtual/range {p5 .. p5}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v3

    move-object/from16 v0, p4

    invoke-direct {v0, v3}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;-><init>(Landroid/content/Context;)V

    .line 334
    .restart local p4    # "convertView":Landroid/view/View;
    new-instance v3, Landroid/widget/AbsListView$LayoutParams;

    const/4 v4, -0x1

    const/4 v7, 0x0

    invoke-direct {v3, v4, v7}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    move-object/from16 v0, p4

    invoke-virtual {v0, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 337
    :cond_0
    iget v3, v10, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->firstChildPosition:I

    move/from16 v0, p2

    if-ge v0, v3, :cond_1

    .line 357
    invoke-virtual/range {p4 .. p4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    const/4 v4, 0x0

    iput v4, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    move-object/from16 v3, p4

    .line 454
    :goto_0
    return-object v3

    :cond_1
    move-object/from16 v23, p5

    .line 361
    check-cast v23, Landroid/widget/ExpandableListView;

    .local v23, "listView":Landroid/widget/ExpandableListView;
    move-object/from16 v12, p4

    .line 363
    check-cast v12, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;

    .line 366
    .local v12, "dummyView":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;
    invoke-virtual {v12}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->clearViews()V

    .line 369
    invoke-virtual/range {v23 .. v23}, Landroid/widget/ExpandableListView;->getDivider()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual/range {p5 .. p5}, Landroid/view/ViewGroup;->getMeasuredWidth()I

    move-result v4

    invoke-virtual/range {v23 .. v23}, Landroid/widget/ExpandableListView;->getDividerHeight()I

    move-result v7

    invoke-virtual {v12, v3, v4, v7}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->setDivider(Landroid/graphics/drawable/Drawable;II)V

    .line 372
    invoke-virtual/range {p5 .. p5}, Landroid/view/ViewGroup;->getWidth()I

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v25

    .line 373
    .local v25, "measureSpecW":I
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {v3, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v24

    .line 375
    .local v24, "measureSpecH":I
    const/4 v9, 0x0

    .line 376
    .local v9, "totalHeight":I
    invoke-virtual/range {p5 .. p5}, Landroid/view/ViewGroup;->getHeight()I

    move-result v21

    .line 378
    .local v21, "clipHeight":I
    invoke-virtual/range {p0 .. p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getRealChildrenCount(I)I

    move-result v22

    .line 379
    .local v22, "len":I
    iget v5, v10, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->firstChildPosition:I

    .local v5, "i":I
    :goto_1
    move/from16 v0, v22

    if-ge v5, v0, :cond_4

    .line 380
    add-int/lit8 v3, v22, -0x1

    if-ne v5, v3, :cond_2

    const/4 v6, 0x1

    :goto_2
    const/4 v7, 0x0

    move-object/from16 v3, p0

    move/from16 v4, p1

    move-object/from16 v8, p5

    invoke-virtual/range {v3 .. v8}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getRealChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v20

    .line 381
    .local v20, "childView":Landroid/view/View;
    move-object/from16 v0, v20

    move/from16 v1, v25

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Landroid/view/View;->measure(II)V

    .line 382
    invoke-virtual/range {v20 .. v20}, Landroid/view/View;->getMeasuredHeight()I

    move-result v3

    add-int/2addr v9, v3

    .line 384
    move/from16 v0, v21

    if-ge v9, v0, :cond_3

    .line 386
    move-object/from16 v0, v20

    invoke-virtual {v12, v0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->addFakeView(Landroid/view/View;)V

    .line 379
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 380
    .end local v20    # "childView":Landroid/view/View;
    :cond_2
    const/4 v6, 0x0

    goto :goto_2

    .line 388
    .restart local v20    # "childView":Landroid/view/View;
    :cond_3
    move-object/from16 v0, v20

    invoke-virtual {v12, v0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->addFakeView(Landroid/view/View;)V

    .line 393
    add-int/lit8 v3, v5, 0x1

    div-int v19, v9, v3

    .line 394
    .local v19, "averageHeight":I
    sub-int v3, v22, v5

    add-int/lit8 v3, v3, -0x1

    mul-int v3, v3, v19

    add-int/2addr v9, v3

    .line 400
    .end local v19    # "averageHeight":I
    .end local v20    # "childView":Landroid/view/View;
    :cond_4
    invoke-virtual {v12}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->getTag()Ljava/lang/Object;

    move-result-object v26

    .local v26, "o":Ljava/lang/Object;
    if-nez v26, :cond_6

    const/16 v27, 0x0

    .line 402
    .end local v26    # "o":Ljava/lang/Object;
    .local v27, "state":I
    :goto_3
    iget-boolean v3, v10, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->expanding:Z

    if-eqz v3, :cond_7

    const/4 v3, 0x1

    move/from16 v0, v27

    if-eq v0, v3, :cond_7

    .line 403
    new-instance v6, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;

    const/4 v8, 0x0

    const/4 v11, 0x0

    move-object v7, v12

    invoke-direct/range {v6 .. v11}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;-><init>(Landroid/view/View;IILcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$1;)V

    .line 404
    .local v6, "ani":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->parent:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;

    # invokes: Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getAnimationDuration()I
    invoke-static {v3}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->access$500(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;)I

    move-result v3

    int-to-long v3, v3

    invoke-virtual {v6, v3, v4}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;->setDuration(J)V

    .line 405
    new-instance v3, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$1;

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v3, v0, v1, v12}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$1;-><init>(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;ILcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;)V

    invoke-virtual {v6, v3}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 421
    invoke-virtual {v12, v6}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 422
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v12, v3}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->setTag(Ljava/lang/Object;)V

    .end local v6    # "ani":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;
    :cond_5
    :goto_4
    move-object/from16 v3, p4

    .line 452
    goto/16 :goto_0

    .line 400
    .end local v27    # "state":I
    .restart local v26    # "o":Ljava/lang/Object;
    :cond_6
    check-cast v26, Ljava/lang/Integer;

    .end local v26    # "o":Ljava/lang/Object;
    invoke-virtual/range {v26 .. v26}, Ljava/lang/Integer;->intValue()I

    move-result v27

    goto :goto_3

    .line 423
    .restart local v27    # "state":I
    :cond_7
    iget-boolean v3, v10, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->expanding:Z

    if-nez v3, :cond_5

    const/4 v3, 0x2

    move/from16 v0, v27

    if-eq v0, v3, :cond_5

    .line 424
    iget v3, v10, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->dummyHeight:I

    const/4 v4, -0x1

    if-ne v3, v4, :cond_8

    .line 425
    iput v9, v10, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->dummyHeight:I

    .line 428
    :cond_8
    new-instance v6, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;

    iget v13, v10, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->dummyHeight:I

    const/4 v14, 0x0

    const/16 v16, 0x0

    move-object v11, v6

    move-object v15, v10

    invoke-direct/range {v11 .. v16}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;-><init>(Landroid/view/View;IILcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$1;)V

    .line 429
    .restart local v6    # "ani":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->parent:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;

    # invokes: Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getAnimationDuration()I
    invoke-static {v3}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->access$500(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;)I

    move-result v3

    int-to-long v3, v3

    invoke-virtual {v6, v3, v4}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;->setDuration(J)V

    .line 430
    new-instance v13, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;

    move-object/from16 v14, p0

    move/from16 v15, p1

    move-object/from16 v16, v23

    move-object/from16 v17, v10

    move-object/from16 v18, v12

    invoke-direct/range {v13 .. v18}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;-><init>(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;ILandroid/widget/ExpandableListView;Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;)V

    invoke-virtual {v6, v13}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 448
    invoke-virtual {v12, v6}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 449
    const/4 v3, 0x2

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v12, v3}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->setTag(Ljava/lang/Object;)V

    goto :goto_4

    .line 454
    .end local v5    # "i":I
    .end local v6    # "ani":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;
    .end local v9    # "totalHeight":I
    .end local v12    # "dummyView":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;
    .end local v21    # "clipHeight":I
    .end local v22    # "len":I
    .end local v23    # "listView":Landroid/widget/ExpandableListView;
    .end local v24    # "measureSpecH":I
    .end local v25    # "measureSpecW":I
    .end local v27    # "state":I
    :cond_9
    invoke-virtual/range {p0 .. p5}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getRealChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    goto/16 :goto_0
.end method

.method public final getChildrenCount(I)I
    .locals 2
    .param p1, "groupPosition"    # I

    .prologue
    .line 460
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getGroupInfo(I)Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    move-result-object v0

    .line 461
    .local v0, "info":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    iget-boolean v1, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->animating:Z

    if-eqz v1, :cond_0

    .line 462
    iget v1, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->firstChildPosition:I

    add-int/lit8 v1, v1, 0x1

    .line 464
    :goto_0
    return v1

    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getRealChildrenCount(I)I

    move-result v1

    goto :goto_0
.end method

.method public getRealChildType(II)I
    .locals 1
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 253
    const/4 v0, 0x0

    return v0
.end method

.method public getRealChildTypeCount()I
    .locals 1

    .prologue
    .line 257
    const/4 v0, 0x1

    return v0
.end method

.method public abstract getRealChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end method

.method public abstract getRealChildrenCount(I)I
.end method

.method public notifyGroupExpanded(I)V
    .locals 2
    .param p1, "groupPosition"    # I

    .prologue
    .line 273
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getGroupInfo(I)Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    move-result-object v0

    .line 274
    .local v0, "info":Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    const/4 v1, -0x1

    iput v1, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->dummyHeight:I

    .line 275
    return-void
.end method
