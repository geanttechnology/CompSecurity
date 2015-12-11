.class public final Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;
.super Ljava/lang/Object;
.source "ConsumableVideoListHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method


# virtual methods
.method public populateConsumableVideoList(Landroid/app/Activity;Landroid/widget/ListView;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/comcast/cim/utils/UIUtil;Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;Ljava/lang/Long;Ljava/lang/Long;ZLcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/util/Map;Z)Lcom/comcast/cim/cmasl/utils/container/Tuple;
    .locals 30
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "videoList"    # Landroid/widget/ListView;
    .param p3, "tvSeriesFacade"    # Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    .param p4, "selectedWatchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p5, "uiUtil"    # Lcom/comcast/cim/utils/UIUtil;
    .param p6, "clickListenerFactory"    # Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;
    .param p7, "currentWatchNonEpisodeVideoId"    # Ljava/lang/Long;
    .param p8, "companyId"    # Ljava/lang/Long;
    .param p9, "wantsSubscriptionOnly"    # Z
    .param p10, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p12, "shouldCheckItems"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Landroid/widget/ListView;",
            "Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;",
            "Lcom/comcast/cim/utils/UIUtil;",
            "Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            "Z",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;Z)",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;",
            ">;",
            "Lcom/commonsware/MergeAdapter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 47
    .local p11, "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    const-string v3, "layout_inflater"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/view/LayoutInflater;

    .line 48
    .local v6, "vi":Landroid/view/LayoutInflater;
    new-instance v20, Lcom/commonsware/MergeAdapter;

    invoke-direct/range {v20 .. v20}, Lcom/commonsware/MergeAdapter;-><init>()V

    .line 52
    .local v20, "videoAdapter":Lcom/commonsware/MergeAdapter;
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 53
    .local v9, "bookmarkWatchableMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    new-instance v11, Ljava/util/HashMap;

    invoke-direct {v11}, Ljava/util/HashMap;-><init>()V

    .line 55
    .local v11, "bookmarkVideoIdMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    const/16 v18, 0x0

    .line 56
    .local v18, "selectedWatchableIndex":I
    const/4 v14, 0x0

    .line 57
    .local v14, "found":Z
    invoke-interface/range {p11 .. p11}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 58
    .local v19, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual/range {v19 .. v19}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v26

    invoke-static/range {v26 .. v27}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    move-object/from16 v0, p11

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    invoke-interface {v11, v4, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    invoke-virtual/range {v19 .. v19}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    move-object/from16 v0, p11

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    invoke-interface {v9, v4, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 62
    .end local v19    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_0
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v13

    .line 63
    .local v13, "episodeAdapters":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;>;"
    invoke-virtual/range {p3 .. p3}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getSeasonNumberToEpisodeMap()Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v25

    :cond_1
    :goto_1
    invoke-interface/range {v25 .. v25}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_e

    invoke-interface/range {v25 .. v25}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/Map$Entry;

    .line 64
    .local v12, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;>;"
    invoke-interface {v12}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    .line 66
    .local v5, "watchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    if-nez p8, :cond_2

    if-eqz p9, :cond_8

    .line 67
    :cond_2
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v24

    .line 68
    .local v24, "watchableIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    :cond_3
    :goto_2
    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_8

    .line 69
    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 71
    .local v23, "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    invoke-interface/range {v23 .. v23}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getVideos()Ljava/util/Set;

    move-result-object v22

    .line 72
    .local v22, "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    if-eqz v22, :cond_7

    .line 73
    invoke-interface/range {v22 .. v22}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v21

    .line 74
    .local v21, "videoFacadeIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    :cond_4
    :goto_3
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 75
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 76
    .restart local v19    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    if-eqz p8, :cond_6

    .line 77
    invoke-virtual/range {v19 .. v19}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    if-eqz v3, :cond_5

    invoke-virtual/range {v19 .. v19}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v26

    invoke-virtual/range {p8 .. p8}, Ljava/lang/Long;->longValue()J

    move-result-wide v28

    cmp-long v3, v26, v28

    if-eqz v3, :cond_4

    .line 78
    :cond_5
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->remove()V

    goto :goto_3

    .line 80
    :cond_6
    if-eqz p9, :cond_4

    .line 81
    invoke-virtual/range {v19 .. v19}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProviderCode()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p10

    invoke-virtual {v0, v3}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 82
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->remove()V

    goto :goto_3

    .line 88
    .end local v19    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v21    # "videoFacadeIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    :cond_7
    invoke-interface/range {v22 .. v22}, Ljava/util/Set;->size()I

    move-result v3

    if-nez v3, :cond_3

    .line 89
    invoke-interface/range {v24 .. v24}, Ljava/util/Iterator;->remove()V

    goto :goto_2

    .line 94
    .end local v22    # "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    .end local v23    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .end local v24    # "watchableIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    :cond_8
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_1

    .line 98
    const-string v17, "Other Seasons"

    .line 99
    .local v17, "seasonLabel":Ljava/lang/String;
    invoke-interface {v12}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-lez v3, :cond_c

    .line 100
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Season "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v12}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 105
    :cond_9
    :goto_4
    sget v3, Lcom/xfinity/playerlib/R$layout;->series_video_list_season_header:I

    const/4 v4, 0x0

    invoke-virtual {v6, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v15

    .line 107
    .local v15, "headerView":Landroid/view/View;
    sget v3, Lcom/xfinity/playerlib/R$id;->label:I

    invoke-virtual {v15, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 108
    invoke-virtual {v15}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->content_description_episode_item_season_heading:I

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v17, v7, v8

    invoke-virtual {v3, v4, v7}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v15, v3}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 111
    const/4 v3, 0x1

    move-object/from16 v0, v20

    invoke-virtual {v0, v15, v3}, Lcom/commonsware/MergeAdapter;->addView(Landroid/view/View;Z)V

    .line 113
    new-instance v2, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    const/4 v4, 0x0

    const/4 v10, 0x0

    move-object/from16 v3, p1

    move-object/from16 v7, p5

    move-object/from16 v8, p7

    invoke-direct/range {v2 .. v10}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;-><init>(Landroid/app/Activity;ILjava/util/List;Landroid/view/LayoutInflater;Lcom/comcast/cim/utils/UIUtil;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;)V

    .line 117
    .local v2, "consumableEpisodeAdapter":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
    move-object/from16 v0, p6

    invoke-interface {v0, v2}, Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;->create(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;)Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->setOnInfoClickListener(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;)V

    .line 119
    move-object/from16 v0, v20

    invoke-virtual {v0, v2}, Lcom/commonsware/MergeAdapter;->addAdapter(Landroid/widget/ListAdapter;)V

    .line 121
    move-object/from16 v0, p4

    invoke-interface {v5, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v16

    .line 122
    .local v16, "index":I
    if-ltz v16, :cond_d

    .line 123
    add-int v18, v18, v16

    .line 124
    const/4 v14, 0x1

    .line 129
    :cond_a
    :goto_5
    if-eqz p4, :cond_b

    if-eqz p12, :cond_b

    .line 130
    move-object/from16 v0, p4

    invoke-interface {v5, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->setCheckedPos(I)V

    .line 133
    :cond_b
    invoke-interface {v13, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 101
    .end local v2    # "consumableEpisodeAdapter":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
    .end local v15    # "headerView":Landroid/view/View;
    .end local v16    # "index":I
    :cond_c
    invoke-interface {v12}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    const/4 v4, -0x1

    if-ne v3, v4, :cond_9

    .line 102
    const-string v17, "Other Videos"

    goto :goto_4

    .line 125
    .restart local v2    # "consumableEpisodeAdapter":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
    .restart local v15    # "headerView":Landroid/view/View;
    .restart local v16    # "index":I
    :cond_d
    if-nez v14, :cond_a

    .line 126
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v3

    add-int v18, v18, v3

    goto :goto_5

    .line 136
    .end local v2    # "consumableEpisodeAdapter":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
    .end local v5    # "watchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    .end local v12    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;>;"
    .end local v15    # "headerView":Landroid/view/View;
    .end local v16    # "index":I
    .end local v17    # "seasonLabel":Ljava/lang/String;
    :cond_e
    move-object/from16 v0, p2

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 137
    move-object/from16 v0, p2

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 139
    new-instance v3, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-object/from16 v0, v20

    invoke-direct {v3, v13, v0}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v3
.end method
