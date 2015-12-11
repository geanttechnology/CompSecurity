.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;
.super Ljava/lang/Object;
.source "LiveStreamsFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->initFeaturedCarousel()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field downX:I

.field downY:I

.field dragStarted:Z

.field dragThreshold:I

.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V
    .locals 1
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 319
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 322
    const/16 v0, 0x1e

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragThreshold:I

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 19
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 329
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v16

    packed-switch v16, :pswitch_data_0

    .line 418
    :cond_0
    :goto_0
    const/16 v16, 0x0

    return v16

    .line 331
    :pswitch_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->bodyContainer:Landroid/view/ViewGroup;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$700(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/view/ViewGroup;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v16

    const/16 v17, 0x0

    invoke-interface/range {v16 .. v17}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 332
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/support/v4/view/ViewPager;->getParent()Landroid/view/ViewParent;

    move-result-object v16

    const/16 v17, 0x0

    invoke-interface/range {v16 .. v17}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 333
    const/16 v16, 0x0

    move/from16 v0, v16

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragStarted:Z

    .line 334
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawX()F

    move-result v16

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    move-object/from16 v1, p0

    iput v0, v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->downX:I

    .line 335
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawY()F

    move-result v16

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    move-object/from16 v1, p0

    iput v0, v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->downY:I

    goto :goto_0

    .line 338
    :pswitch_1
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawX()F

    move-result v16

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->downX:I

    move/from16 v17, v0

    sub-int v16, v16, v17

    invoke-static/range {v16 .. v16}, Ljava/lang/Math;->abs(I)I

    move-result v4

    .line 339
    .local v4, "distanceX":I
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getRawY()F

    move-result v16

    move/from16 v0, v16

    float-to-int v0, v0

    move/from16 v16, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->downY:I

    move/from16 v17, v0

    sub-int v16, v16, v17

    invoke-static/range {v16 .. v16}, Ljava/lang/Math;->abs(I)I

    move-result v5

    .line 341
    .local v5, "distanceY":I
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragStarted:Z

    move/from16 v16, v0

    if-nez v16, :cond_0

    .line 344
    if-ne v4, v5, :cond_3

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragThreshold:I

    move/from16 v16, v0

    move/from16 v0, v16

    if-le v4, v0, :cond_3

    const/4 v6, 0x1

    .line 346
    .local v6, "dragDiagonal":Z
    :goto_1
    if-eqz v6, :cond_5

    .line 349
    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    .line 350
    .local v3, "carouselRect":Landroid/graphics/Rect;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Landroid/support/v4/view/ViewPager;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    .line 352
    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->downX:I

    move/from16 v16, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->downY:I

    move/from16 v17, v0

    move/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v3, v0, v1}, Landroid/graphics/Rect;->contains(II)Z

    move-result v7

    .line 353
    .local v7, "dragStartedInCarousel":Z
    if-nez v7, :cond_4

    const/4 v9, 0x1

    .line 354
    .local v9, "dragY":Z
    :goto_2
    move v8, v7

    .line 360
    .end local v3    # "carouselRect":Landroid/graphics/Rect;
    .end local v7    # "dragStartedInCarousel":Z
    .local v8, "dragX":Z
    :goto_3
    if-eqz v9, :cond_8

    .line 361
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/support/v4/view/ViewPager;->getParent()Landroid/view/ViewParent;

    move-result-object v16

    const/16 v17, 0x0

    invoke-interface/range {v16 .. v17}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 362
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->bodyContainer:Landroid/view/ViewGroup;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$700(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/view/ViewGroup;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v16

    const/16 v17, 0x1

    invoke-interface/range {v16 .. v17}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 368
    :cond_1
    :goto_4
    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragThreshold:I

    move/from16 v16, v0

    move/from16 v0, v16

    if-gt v4, v0, :cond_2

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragThreshold:I

    move/from16 v16, v0

    move/from16 v0, v16

    if-le v5, v0, :cond_9

    :cond_2
    const/16 v16, 0x1

    :goto_5
    move/from16 v0, v16

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragStarted:Z

    goto/16 :goto_0

    .line 344
    .end local v6    # "dragDiagonal":Z
    .end local v8    # "dragX":Z
    .end local v9    # "dragY":Z
    :cond_3
    const/4 v6, 0x0

    goto :goto_1

    .line 353
    .restart local v3    # "carouselRect":Landroid/graphics/Rect;
    .restart local v6    # "dragDiagonal":Z
    .restart local v7    # "dragStartedInCarousel":Z
    :cond_4
    const/4 v9, 0x0

    goto :goto_2

    .line 356
    .end local v3    # "carouselRect":Landroid/graphics/Rect;
    .end local v7    # "dragStartedInCarousel":Z
    :cond_5
    if-le v5, v4, :cond_6

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragThreshold:I

    move/from16 v16, v0

    move/from16 v0, v16

    if-le v5, v0, :cond_6

    const/4 v9, 0x1

    .line 357
    .restart local v9    # "dragY":Z
    :goto_6
    if-le v4, v5, :cond_7

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragThreshold:I

    move/from16 v16, v0

    move/from16 v0, v16

    if-le v4, v0, :cond_7

    const/4 v8, 0x1

    .restart local v8    # "dragX":Z
    :goto_7
    goto :goto_3

    .line 356
    .end local v8    # "dragX":Z
    .end local v9    # "dragY":Z
    :cond_6
    const/4 v9, 0x0

    goto :goto_6

    .line 357
    .restart local v9    # "dragY":Z
    :cond_7
    const/4 v8, 0x0

    goto :goto_7

    .line 363
    .restart local v8    # "dragX":Z
    :cond_8
    if-eqz v8, :cond_1

    .line 364
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/support/v4/view/ViewPager;->getParent()Landroid/view/ViewParent;

    move-result-object v16

    const/16 v17, 0x1

    invoke-interface/range {v16 .. v17}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 365
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->bodyContainer:Landroid/view/ViewGroup;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$700(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/view/ViewGroup;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v16

    const/16 v17, 0x0

    invoke-interface/range {v16 .. v17}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    goto :goto_4

    .line 368
    :cond_9
    const/16 v16, 0x0

    goto :goto_5

    .line 372
    .end local v4    # "distanceX":I
    .end local v5    # "distanceY":I
    .end local v6    # "dragDiagonal":Z
    .end local v8    # "dragX":Z
    .end local v9    # "dragY":Z
    :pswitch_2
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragStarted:Z

    move/from16 v16, v0

    if-nez v16, :cond_a

    .line 373
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v17, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static/range {v17 .. v17}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v17

    invoke-virtual/range {v16 .. v17}, Landroid/support/v4/view/ViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v15

    .line 374
    .local v15, "view":Landroid/view/View;
    sget v16, Lcom/xfinity/playerlib/view/DimmingPageTransformer;->MIN_ALPHA:F

    invoke-virtual/range {v15 .. v16}, Landroid/view/View;->setAlpha(F)V

    .line 376
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveFeaturedContentList:Ljava/util/List;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$000(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Ljava/util/List;

    move-result-object v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v17, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselIndex:I
    invoke-static/range {v17 .. v17}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$800(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I

    move-result v17

    invoke-interface/range {v16 .. v17}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    .line 377
    .local v13, "liveFeaturedContent":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;
    if-eqz v13, :cond_a

    .line 378
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getPackageName()Ljava/lang/String;

    move-result-object v16

    if-eqz v16, :cond_b

    .line 380
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->appLauncher:Lcom/comcast/cim/utils/AppLauncher;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$900(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/utils/AppLauncher;

    move-result-object v16

    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getPackageName()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v18

    invoke-virtual/range {v16 .. v18}, Lcom/comcast/cim/utils/AppLauncher;->startApplication(Ljava/lang/String;Landroid/app/Activity;)V

    .line 413
    .end local v13    # "liveFeaturedContent":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;
    .end local v15    # "view":Landroid/view/View;
    :cond_a
    :goto_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->bodyContainer:Landroid/view/ViewGroup;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$700(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/view/ViewGroup;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v16

    const/16 v17, 0x0

    invoke-interface/range {v16 .. v17}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 414
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Landroid/support/v4/view/ViewPager;->getParent()Landroid/view/ViewParent;

    move-result-object v16

    const/16 v17, 0x0

    invoke-interface/range {v16 .. v17}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 415
    const/16 v16, 0x0

    move/from16 v0, v16

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->dragStarted:Z

    goto/16 :goto_0

    .line 381
    .restart local v13    # "liveFeaturedContent":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;
    .restart local v15    # "view":Landroid/view/View;
    :cond_b
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getPlaybackLink()Ljava/lang/String;

    move-result-object v16

    if-eqz v16, :cond_e

    .line 382
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getPlaybackLink()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->length()I

    move-result v16

    if-lez v16, :cond_e

    .line 383
    const/4 v11, 0x0

    .line 384
    .local v11, "found":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreams:Ljava/util/List;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1000(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Ljava/util/List;

    move-result-object v16

    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :cond_c
    :goto_9
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_d

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .line 388
    .local v14, "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getSelfLink()Ljava/lang/String;

    move-result-object v17

    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getPlaybackLink()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_c

    .line 389
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v17, v0

    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getEventId()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    # invokes: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->launchLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V
    invoke-static {v0, v14, v1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1100(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V

    .line 390
    const/4 v11, 0x1

    goto :goto_9

    .line 394
    .end local v14    # "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    :cond_d
    if-nez v11, :cond_a

    .line 395
    const-string v16, "errorDlg"

    invoke-static/range {v16 .. v16}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v10

    .line 397
    .local v10, "errorDialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 398
    .local v2, "args":Landroid/os/Bundle;
    const-string v16, "description"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v17, v0

    sget v18, Lcom/xfinity/playerlib/R$string;->error_stream_not_available_text:I

    invoke-virtual/range {v17 .. v18}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getString(I)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-virtual {v2, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 400
    invoke-virtual {v10, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 401
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;
    invoke-static/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1200(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/content/DialogInterface$OnDismissListener;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v10, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 402
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v16

    const-string v17, "caldialogfragment"

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-virtual {v10, v0, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    goto/16 :goto_8

    .line 404
    .end local v2    # "args":Landroid/os/Bundle;
    .end local v10    # "errorDialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    .end local v11    # "found":Z
    :cond_e
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getWebsiteLink()Ljava/lang/String;

    move-result-object v16

    if-eqz v16, :cond_a

    .line 406
    new-instance v12, Landroid/content/Intent;

    const-string v16, "android.intent.action.VIEW"

    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getWebsiteLink()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v17

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-direct {v12, v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 407
    .local v12, "intent":Landroid/content/Intent;
    const/high16 v16, 0x10000000

    move/from16 v0, v16

    invoke-virtual {v12, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 408
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_8

    .line 329
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method
