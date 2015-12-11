.class public abstract Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;
.super Ljava/lang/Object;
.source "PredictiveScrollListener.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private firstRun:Z

.field private final interval:I

.field private final maxPositions:I

.field private final maxResources:I

.field private final minPriority:I

.field private prevFirst:I

.field private prevTime:J

.field private prevTop:I

.field private final resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

.field private final useInterval:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/ResourceProvider;)V
    .locals 7
    .param p1, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;

    .prologue
    const/4 v2, 0x1

    .line 45
    const/16 v3, 0x1f4

    const/16 v4, 0x14

    const/16 v5, 0xa

    move-object v0, p0

    move-object v1, p1

    move v6, v2

    invoke-direct/range {v0 .. v6}, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;-><init>(Lcom/amazon/ansel/fetch/ResourceProvider;ZIIII)V

    .line 46
    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/ResourceProvider;ZIIII)V
    .locals 2
    .param p1, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;
    .param p2, "useInterval"    # Z
    .param p3, "interval"    # I
    .param p4, "maxResources"    # I
    .param p5, "maxPositions"    # I
    .param p6, "minPriority"    # I

    .prologue
    const/4 v1, -0x1

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->firstRun:Z

    .line 30
    iput v1, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevFirst:I

    .line 31
    iput v1, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevTop:I

    .line 36
    iput-object p1, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 37
    iput-boolean p2, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->useInterval:Z

    .line 38
    iput p3, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->interval:I

    .line 39
    iput p4, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->maxResources:I

    .line 40
    iput p5, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->maxPositions:I

    .line 41
    iput p6, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->minPriority:I

    .line 42
    return-void
.end method

.method private load(Landroid/widget/AdapterView;IJ)V
    .locals 28
    .param p2, "direction"    # I
    .param p3, "time"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;IJ)V"
        }
    .end annotation

    .prologue
    .line 134
    .local p1, "view":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    if-nez p1, :cond_1

    .line 250
    :cond_0
    return-void

    .line 137
    :cond_1
    invoke-virtual/range {p1 .. p1}, Landroid/widget/AdapterView;->getCount()I

    move-result v4

    .line 138
    .local v4, "count":I
    invoke-virtual/range {p1 .. p1}, Landroid/widget/AdapterView;->getFirstVisiblePosition()I

    move-result v6

    .line 139
    .local v6, "first":I
    invoke-virtual/range {p1 .. p1}, Landroid/widget/AdapterView;->getLastVisiblePosition()I

    move-result v11

    .line 140
    .local v11, "last":I
    const/16 v24, 0x1

    sub-int v25, v11, v6

    add-int/lit8 v25, v25, 0x1

    invoke-static/range {v24 .. v25}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 146
    .local v15, "pageSize":I
    const/4 v3, 0x1

    .line 149
    .local v3, "backSize":I
    const/16 v24, 0x2

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->maxPositions:I

    move/from16 v25, v0

    div-int/lit8 v25, v25, 0x2

    move/from16 v0, v25

    invoke-static {v15, v0}, Ljava/lang/Math;->max(II)I

    move-result v25

    invoke-static/range {v24 .. v25}, Ljava/lang/Math;->max(II)I

    move-result v19

    .line 151
    .local v19, "segmentSize":I
    const/16 v24, -0x1

    move/from16 v0, p2

    move/from16 v1, v24

    if-ne v0, v1, :cond_a

    move/from16 v21, v11

    .line 152
    .local v21, "start":I
    :goto_0
    const/16 v17, 0x0

    .line 153
    .local v17, "posCount":I
    const/4 v2, 0x0

    .line 154
    .local v2, "backCount":I
    new-instance v20, Ljava/util/ArrayList;

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->maxPositions:I

    move/from16 v24, v0

    move-object/from16 v0, v20

    move/from16 v1, v24

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 158
    .local v20, "sequence":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->maxPositions:I

    move/from16 v24, v0

    move/from16 v0, v17

    move/from16 v1, v24

    if-ge v0, v1, :cond_3

    .line 159
    if-lez v7, :cond_2

    rem-int v24, v7, v19

    if-nez v24, :cond_2

    if-ge v2, v3, :cond_2

    .line 160
    add-int/lit8 v2, v2, 0x1

    .line 161
    const/16 v24, -0x1

    move/from16 v0, p2

    move/from16 v1, v24

    if-ne v0, v1, :cond_b

    add-int v16, v21, v2

    .line 163
    .local v16, "pos":I
    :goto_2
    if-ltz v16, :cond_2

    move/from16 v0, v16

    if-ge v0, v4, :cond_2

    .line 164
    invoke-static/range {v16 .. v16}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v24

    move-object/from16 v0, v20

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 165
    add-int/lit8 v17, v17, 0x1

    .line 169
    .end local v16    # "pos":I
    :cond_2
    const/16 v24, -0x1

    move/from16 v0, p2

    move/from16 v1, v24

    if-ne v0, v1, :cond_c

    sub-int v16, v21, v7

    .line 171
    .restart local v16    # "pos":I
    :goto_3
    if-ltz v16, :cond_3

    move/from16 v0, v16

    if-lt v0, v4, :cond_d

    .line 180
    .end local v16    # "pos":I
    :cond_3
    :goto_4
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->maxPositions:I

    move/from16 v24, v0

    move/from16 v0, v17

    move/from16 v1, v24

    if-ge v0, v1, :cond_4

    .line 181
    const/16 v24, -0x1

    move/from16 v0, p2

    move/from16 v1, v24

    if-ne v0, v1, :cond_e

    add-int v24, v21, v17

    add-int v16, v24, v2

    .line 183
    .restart local v16    # "pos":I
    :goto_5
    if-ltz v16, :cond_4

    move/from16 v0, v16

    if-lt v0, v4, :cond_f

    .line 192
    .end local v16    # "pos":I
    :cond_4
    const/4 v7, 0x0

    .line 193
    move-wide/from16 v22, p3

    .line 194
    .local v22, "startPriority":J
    const/16 v18, 0x0

    .line 195
    .local v18, "resCount":I
    new-instance v10, Ljava/util/HashSet;

    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->size()I

    move-result v24

    move/from16 v0, v24

    invoke-direct {v10, v0}, Ljava/util/HashSet;-><init>(I)V

    .line 196
    .local v10, "keys":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/Object;>;"
    new-instance v13, Ljava/util/ArrayList;

    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->size()I

    move-result v24

    move/from16 v0, v24

    invoke-direct {v13, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 198
    .local v13, "loaderList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;"
    invoke-virtual/range {v20 .. v20}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_5
    :goto_6
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v24

    if-eqz v24, :cond_10

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/Integer;

    .line 199
    .local v16, "pos":Ljava/lang/Integer;
    invoke-virtual/range {v16 .. v16}, Ljava/lang/Integer;->intValue()I

    move-result v24

    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->getLoadersFor(I)Ljava/util/List;

    move-result-object v14

    .line 201
    .local v14, "loaders":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;>;"
    if-eqz v14, :cond_5

    .line 205
    invoke-interface {v14}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :cond_6
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v24

    if-eqz v24, :cond_9

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/ansel/fetch/tools/collection/Factory;

    .line 206
    .local v5, "factory":Lcom/amazon/ansel/fetch/tools/collection/Factory;, "Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;"
    invoke-interface {v5}, Lcom/amazon/ansel/fetch/tools/collection/Factory;->get()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/ansel/fetch/ResourceLoader;

    .line 207
    .local v12, "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<*>;"
    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->minPriority:I

    move/from16 v24, v0

    move/from16 v0, v24

    int-to-long v0, v0

    move-wide/from16 v24, v0

    int-to-long v0, v7

    move-wide/from16 v26, v0

    sub-long v26, v22, v26

    add-long v24, v24, v26

    move-wide/from16 v0, v24

    invoke-virtual {v12, v0, v1}, Lcom/amazon/ansel/fetch/ResourceLoader;->setPriority(J)V

    .line 209
    sget-object v24, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->TAG:Ljava/lang/String;

    const/16 v25, 0x2

    invoke-static/range {v24 .. v25}, Lcom/amazon/ansel/fetch/log/AppLog;->isLoggable(Ljava/lang/String;I)Z

    move-result v24

    if-eqz v24, :cond_7

    .line 210
    sget-object v24, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->TAG:Ljava/lang/String;

    new-instance v25, Ljava/lang/StringBuilder;

    invoke-direct/range {v25 .. v25}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v26, "Adding "

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    move-object/from16 v0, v25

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v25

    const-string/jumbo v26, " at position "

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v25

    const-string/jumbo v26, " with priority "

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual {v12}, Lcom/amazon/ansel/fetch/ResourceLoader;->getPriority()J

    move-result-wide v26

    invoke-virtual/range {v25 .. v27}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v24 .. v25}, Lcom/amazon/ansel/fetch/log/AppLog;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 214
    :cond_7
    invoke-virtual {v13, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 216
    invoke-virtual {v12}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceKey()Ljava/lang/Object;

    move-result-object v24

    if-eqz v24, :cond_8

    .line 217
    invoke-virtual {v12}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceKey()Ljava/lang/Object;

    move-result-object v24

    move-object/from16 v0, v24

    invoke-virtual {v10, v0}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 220
    :cond_8
    add-int/lit8 v18, v18, 0x1

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->maxResources:I

    move/from16 v24, v0

    move/from16 v0, v18

    move/from16 v1, v24

    if-lt v0, v1, :cond_6

    .line 225
    .end local v5    # "factory":Lcom/amazon/ansel/fetch/tools/collection/Factory;, "Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;"
    .end local v12    # "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<*>;"
    :cond_9
    add-int/lit8 v7, v7, 0x1

    .line 226
    goto/16 :goto_6

    .end local v2    # "backCount":I
    .end local v7    # "i":I
    .end local v9    # "i$":Ljava/util/Iterator;
    .end local v10    # "keys":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/Object;>;"
    .end local v13    # "loaderList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;"
    .end local v14    # "loaders":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/collection/Factory<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;>;"
    .end local v16    # "pos":Ljava/lang/Integer;
    .end local v17    # "posCount":I
    .end local v18    # "resCount":I
    .end local v20    # "sequence":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    .end local v21    # "start":I
    .end local v22    # "startPriority":J
    :cond_a
    move/from16 v21, v6

    .line 151
    goto/16 :goto_0

    .line 161
    .restart local v2    # "backCount":I
    .restart local v7    # "i":I
    .restart local v17    # "posCount":I
    .restart local v20    # "sequence":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    .restart local v21    # "start":I
    :cond_b
    sub-int v16, v21, v2

    goto/16 :goto_2

    .line 169
    :cond_c
    add-int v16, v21, v7

    goto/16 :goto_3

    .line 175
    .local v16, "pos":I
    :cond_d
    invoke-static/range {v16 .. v16}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v24

    move-object/from16 v0, v20

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 158
    add-int/lit8 v7, v7, 0x1

    add-int/lit8 v17, v17, 0x1

    goto/16 :goto_1

    .line 181
    .end local v16    # "pos":I
    :cond_e
    sub-int v24, v21, v17

    sub-int v16, v24, v2

    goto/16 :goto_5

    .line 187
    .restart local v16    # "pos":I
    :cond_f
    invoke-static/range {v16 .. v16}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v24

    move-object/from16 v0, v20

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 180
    add-int/lit8 v17, v17, 0x1

    goto/16 :goto_4

    .line 228
    .end local v16    # "pos":I
    .restart local v10    # "keys":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/Object;>;"
    .restart local v13    # "loaderList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/ansel/fetch/ResourceLoader<*>;>;"
    .restart local v18    # "resCount":I
    .restart local v22    # "startPriority":J
    :cond_10
    invoke-virtual {v13}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_7
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v24

    if-eqz v24, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/ansel/fetch/ResourceLoader;

    .line 229
    .restart local v12    # "loader":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<*>;"
    sget-object v24, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->TAG:Ljava/lang/String;

    const/16 v25, 0x2

    invoke-static/range {v24 .. v25}, Lcom/amazon/ansel/fetch/log/AppLog;->isLoggable(Ljava/lang/String;I)Z

    move-result v24

    if-eqz v24, :cond_11

    .line 230
    sget-object v24, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->TAG:Ljava/lang/String;

    new-instance v25, Ljava/lang/StringBuilder;

    invoke-direct/range {v25 .. v25}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v26, "Loading "

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    move-object/from16 v0, v25

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v25

    const-string/jumbo v26, " with priority "

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual {v12}, Lcom/amazon/ansel/fetch/ResourceLoader;->getPriority()J

    move-result-wide v26

    invoke-virtual/range {v25 .. v27}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v24 .. v25}, Lcom/amazon/ansel/fetch/log/AppLog;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 233
    :cond_11
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    invoke-virtual {v0, v12}, Lcom/amazon/ansel/fetch/ResourceProvider;->execute(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    goto :goto_7
.end method

.method private processViewInternal(Landroid/widget/AdapterView;Z)V
    .locals 12
    .param p2, "forceLoad"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;Z)V"
        }
    .end annotation

    .prologue
    .local p1, "view":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v6, 0x0

    const/4 v11, -0x1

    .line 81
    if-nez p1, :cond_1

    .line 125
    :cond_0
    :goto_0
    return-void

    .line 85
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 87
    .local v3, "time":J
    if-nez p2, :cond_2

    iget-boolean v7, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->useInterval:Z

    if-eqz v7, :cond_2

    iget-wide v7, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevTime:J

    const-wide/16 v9, 0x0

    cmp-long v7, v7, v9

    if-lez v7, :cond_2

    iget-wide v7, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevTime:J

    sub-long v7, v3, v7

    iget v9, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->interval:I

    int-to-long v9, v9

    cmp-long v7, v7, v9

    if-ltz v7, :cond_0

    .line 91
    :cond_2
    invoke-virtual {p1}, Landroid/widget/AdapterView;->getFirstVisiblePosition()I

    move-result v2

    .line 92
    .local v2, "first":I
    invoke-virtual {p1}, Landroid/widget/AdapterView;->getChildCount()I

    move-result v7

    if-lez v7, :cond_5

    invoke-virtual {p1, v6}, Landroid/widget/AdapterView;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    invoke-virtual {v7}, Landroid/view/View;->getTop()I

    move-result v5

    .line 93
    .local v5, "top":I
    :goto_1
    const/4 v1, 0x0

    .line 95
    .local v1, "direction":I
    iget v7, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevFirst:I

    if-ne v7, v11, :cond_6

    .line 96
    const/4 v1, 0x0

    .line 111
    :goto_2
    if-nez v1, :cond_3

    iget-boolean v7, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->firstRun:Z

    if-nez v7, :cond_3

    if-eqz p2, :cond_0

    .line 112
    :cond_3
    if-ne v1, v11, :cond_c

    move v0, v1

    .line 114
    .local v0, "dir":I
    :goto_3
    sget-object v7, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->TAG:Ljava/lang/String;

    const/4 v8, 0x2

    invoke-static {v7, v8}, Lcom/amazon/ansel/fetch/log/AppLog;->isLoggable(Ljava/lang/String;I)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 115
    sget-object v7, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Scroll direction: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/amazon/ansel/fetch/log/AppLog;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 118
    :cond_4
    invoke-direct {p0, p1, v0, v3, v4}, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->load(Landroid/widget/AdapterView;IJ)V

    .line 120
    iput-wide v3, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevTime:J

    .line 121
    iput v2, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevFirst:I

    .line 122
    iput v5, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevTop:I

    .line 123
    iput-boolean v6, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->firstRun:Z

    goto :goto_0

    .end local v0    # "dir":I
    .end local v1    # "direction":I
    .end local v5    # "top":I
    :cond_5
    move v5, v6

    .line 92
    goto :goto_1

    .line 97
    .restart local v1    # "direction":I
    .restart local v5    # "top":I
    :cond_6
    iget v7, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevFirst:I

    if-le v2, v7, :cond_7

    .line 98
    const/4 v1, 0x1

    goto :goto_2

    .line 99
    :cond_7
    iget v7, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevFirst:I

    if-ge v2, v7, :cond_8

    .line 100
    const/4 v1, -0x1

    goto :goto_2

    .line 101
    :cond_8
    iget v7, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevTop:I

    if-ne v7, v11, :cond_9

    .line 102
    const/4 v1, 0x0

    goto :goto_2

    .line 103
    :cond_9
    iget v7, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevTop:I

    if-le v5, v7, :cond_a

    .line 104
    const/4 v1, 0x1

    goto :goto_2

    .line 105
    :cond_a
    iget v7, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->prevTop:I

    if-ge v5, v7, :cond_b

    .line 106
    const/4 v1, -0x1

    goto :goto_2

    .line 108
    :cond_b
    const/4 v1, 0x0

    goto :goto_2

    .line 112
    :cond_c
    const/4 v0, 0x1

    goto :goto_3
.end method


# virtual methods
.method public getInterval()I
    .locals 1

    .prologue
    .line 53
    iget v0, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->interval:I

    return v0
.end method

.method protected abstract getLoadersFor(I)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/tools/collection/Factory",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;>;>;"
        }
    .end annotation
.end method

.method public getMaxPositions()I
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->maxPositions:I

    return v0
.end method

.method public getMaxResources()I
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->maxResources:I

    return v0
.end method

.method public getMinPriority()I
    .locals 1

    .prologue
    .line 65
    iget v0, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->minPriority:I

    return v0
.end method

.method public getUseInterval()Z
    .locals 1

    .prologue
    .line 49
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->useInterval:Z

    return v0
.end method

.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 268
    invoke-virtual {p0, p1}, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->process(Landroid/widget/AdapterView;)V

    .line 269
    return-void
.end method

.method public onScroll(Landroid/widget/AdapterView;III)V
    .locals 0
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;III)V"
        }
    .end annotation

    .prologue
    .line 276
    .local p1, "view":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p0, p1}, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->process(Landroid/widget/AdapterView;)V

    .line 277
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 263
    invoke-virtual {p0, p1}, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->process(Landroid/widget/AdapterView;)V

    .line 264
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AdapterView;I)V
    .locals 0
    .param p2, "scrollState"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;I)V"
        }
    .end annotation

    .prologue
    .line 272
    .local p1, "view":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p0, p1}, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->process(Landroid/widget/AdapterView;)V

    .line 273
    return-void
.end method

.method public process(Landroid/widget/AdapterView;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 69
    .local p1, "view":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->processView(Landroid/widget/AdapterView;Z)V

    .line 70
    return-void
.end method

.method public processView(Landroid/widget/AdapterView;Z)V
    .locals 3
    .param p2, "forceLoad"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;Z)V"
        }
    .end annotation

    .prologue
    .line 74
    .local p1, "view":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    :try_start_0
    invoke-direct {p0, p1, p2}, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->processViewInternal(Landroid/widget/AdapterView;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 78
    :goto_0
    return-void

    .line 75
    :catch_0
    move-exception v0

    .line 76
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Error"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
