.class Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;
.super Ljava/lang/Object;
.source "StackLayout.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AsinVisibilityReporter"
.end annotation


# instance fields
.field private final DEFAULT_REPORTER_INTERVAL_MS:J

.field private handler:Landroid/os/Handler;

.field private interval:J

.field private monitoring:Z

.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)V
    .locals 2

    .prologue
    .line 1304
    const-wide/16 v0, 0x0

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;J)V

    .line 1305
    return-void
.end method

.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;J)V
    .locals 5
    .param p2, "pollingInterval"    # J

    .prologue
    const-wide/16 v0, 0x1f4

    const-wide/16 v3, 0x0

    .line 1311
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1294
    iput-wide v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->DEFAULT_REPORTER_INTERVAL_MS:J

    .line 1295
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->handler:Landroid/os/Handler;

    .line 1296
    iput-wide v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->interval:J

    .line 1297
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->monitoring:Z

    .line 1312
    cmp-long v2, p2, v3

    if-gtz v2, :cond_0

    move-wide p2, v0

    .end local p2    # "pollingInterval":J
    :cond_0
    iput-wide p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->interval:J

    .line 1313
    return-void
.end method

.method private examineStackView()V
    .locals 24

    .prologue
    .line 1357
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->size()I

    move-result v22

    if-nez v22, :cond_1

    .line 1430
    :cond_0
    return-void

    .line 1361
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getFirstVisiblePosition()I

    move-result v7

    .line 1362
    .local v7, "firstVisiblePosition":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getLastVisiblePosition()I

    move-result v10

    .line 1363
    .local v10, "lastVisiblePosition":I
    sub-int v22, v10, v7

    add-int/lit8 v15, v22, 0x1

    .line 1366
    .local v15, "numVisibleItems":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->size()I

    move-result v22

    move/from16 v0, v22

    if-lt v10, v0, :cond_2

    .line 1368
    add-int/lit8 v15, v15, -0x1

    .line 1371
    :cond_2
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    if-ge v8, v15, :cond_0

    .line 1373
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-interface {v0, v8}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getChildAt(I)Landroid/view/View;

    move-result-object v18

    .line 1374
    .local v18, "view":Landroid/view/View;
    if-nez v18, :cond_4

    .line 1371
    :cond_3
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 1379
    :cond_4
    new-instance v4, Ljava/util/ArrayList;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->columns:I
    invoke-static/range {v22 .. v22}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1200(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I

    move-result v22

    move/from16 v0, v22

    invoke-direct {v4, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 1380
    .local v4, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    add-int v2, v7, v8

    .line 1381
    .local v2, "adapterIndex":I
    if-ltz v2, :cond_3

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->size()I

    move-result v22

    move/from16 v0, v22

    if-ge v2, v0, :cond_3

    .line 1385
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v0, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->get(I)Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;

    move-result-object v5

    .line 1386
    .local v5, "element":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;, "Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement<*>;"
    invoke-virtual {v5}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElement;->getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    move-result-object v6

    .line 1387
    .local v6, "elementModel":Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    invoke-interface {v6}, Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;->getAllModels()Ljava/util/List;

    move-result-object v22

    invoke-interface/range {v22 .. v22}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :cond_5
    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v22

    if-eqz v22, :cond_6

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    .line 1389
    .local v12, "model":Ljava/lang/Object;
    instance-of v0, v12, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;

    move/from16 v22, v0

    if-eqz v22, :cond_5

    .line 1391
    check-cast v12, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;

    .end local v12    # "model":Ljava/lang/Object;
    invoke-virtual {v12}, Lcom/amazon/searchapp/retailsearch/entity/ProductEntity;->getAsin()Ljava/lang/String;

    move-result-object v3

    .line 1392
    .local v3, "asin":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;
    invoke-static/range {v22 .. v22}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1300(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->wasAsinViewed(Ljava/lang/String;)Z

    move-result v22

    if-nez v22, :cond_5

    .line 1394
    invoke-interface {v4, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1399
    .end local v3    # "asin":Ljava/lang/String;
    :cond_6
    invoke-static {v4}, Lcom/amazon/retailsearch/util/Utils;->isEmpty(Ljava/util/Collection;)Z

    move-result v22

    if-nez v22, :cond_3

    .line 1405
    invoke-virtual/range {v18 .. v18}, Landroid/view/View;->getHeight()I

    move-result v20

    .line 1406
    .local v20, "viewHeight":I
    invoke-virtual/range {v18 .. v18}, Landroid/view/View;->getTop()I

    move-result v21

    .line 1407
    .local v21, "viewTop":I
    invoke-virtual/range {v18 .. v18}, Landroid/view/View;->getBottom()I

    move-result v19

    .line 1408
    .local v19, "viewBottom":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getHeight()I

    move-result v11

    .line 1409
    .local v11, "listHeight":I
    const/16 v16, 0x0

    .line 1410
    .local v16, "percentVisible":F
    if-ltz v21, :cond_8

    move/from16 v0, v19

    if-gt v0, v11, :cond_8

    .line 1412
    const/high16 v16, 0x3f800000    # 1.0f

    .line 1423
    :cond_7
    :goto_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v13

    .line 1424
    .local v13, "now":J
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_3
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v22

    if-eqz v22, :cond_3

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 1426
    .restart local v3    # "asin":Ljava/lang/String;
    new-instance v17, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;

    move-object/from16 v0, v17

    move/from16 v1, v16

    invoke-direct {v0, v3, v1, v13, v14}, Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;-><init>(Ljava/lang/String;FJ)V

    .line 1427
    .local v17, "snapshot":Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    move-object/from16 v22, v0

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;
    invoke-static/range {v22 .. v22}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1300(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;->evaluateByIncrementalSnapshot(Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;)V

    goto :goto_3

    .line 1414
    .end local v3    # "asin":Ljava/lang/String;
    .end local v13    # "now":J
    .end local v17    # "snapshot":Lcom/amazon/retailsearch/metrics/impressions/ProductViewSnapshot;
    :cond_8
    if-gez v21, :cond_9

    .line 1416
    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v22, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Math;->abs(I)I

    move-result v23

    move/from16 v0, v23

    int-to-float v0, v0

    move/from16 v23, v0

    sub-float v22, v22, v23

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v23, v0

    div-float v16, v22, v23

    goto :goto_2

    .line 1418
    :cond_9
    move/from16 v0, v19

    if-le v0, v11, :cond_7

    .line 1420
    int-to-float v0, v11

    move/from16 v22, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v23, v0

    sub-float v22, v22, v23

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v23, v0

    div-float v16, v22, v23

    goto :goto_2
.end method

.method private monitor()V
    .locals 3

    .prologue
    .line 1352
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->handler:Landroid/os/Handler;

    iget-wide v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->interval:J

    invoke-virtual {v0, p0, v1, v2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1353
    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 1340
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->examineStackView()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1347
    :goto_0
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->monitor()V

    .line 1348
    return-void

    .line 1342
    :catch_0
    move-exception v0

    .line 1345
    .local v0, "e":Ljava/lang/Exception;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$800(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v1

    const-string/jumbo v2, "Asin Impression Logger caused an exception "

    invoke-interface {v1, v2, v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method startMonitoring()V
    .locals 1

    .prologue
    .line 1317
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->monitoring:Z

    if-eqz v0, :cond_0

    .line 1323
    :goto_0
    return-void

    .line 1321
    :cond_0
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->monitor()V

    .line 1322
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->monitoring:Z

    goto :goto_0
.end method

.method stopMonitoring()V
    .locals 1

    .prologue
    .line 1327
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->monitoring:Z

    if-nez v0, :cond_0

    .line 1333
    :goto_0
    return-void

    .line 1331
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->handler:Landroid/os/Handler;

    invoke-virtual {v0, p0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1332
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$AsinVisibilityReporter;->monitoring:Z

    goto :goto_0
.end method
