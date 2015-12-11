.class public Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;
.super Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;
.source "PlayerEpisodeListTalkListHelper.java"


# instance fields
.field private tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Landroid/content/Context;)V
    .locals 17
    .param p1, "tvSeriesFacade"    # Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 20
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/alt/PlayerDefaultTalkListHelper;-><init>(Landroid/content/Context;)V

    .line 22
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    .line 23
    const/4 v11, 0x0

    move-object/from16 v0, p0

    iput v11, v0, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->lastListItemIndex:I

    .line 24
    const/4 v11, 0x1

    move-object/from16 v0, p0

    iput-boolean v11, v0, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->moreOrLess:Z

    .line 26
    const/4 v7, 0x0

    .line 30
    .local v7, "i":I
    const/4 v2, -0x2

    .line 32
    .local v2, "currentSeasonNumber":I
    if-nez p1, :cond_1

    .line 79
    :cond_0
    return-void

    .line 37
    :cond_1
    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getSeasonNumberToEpisodeMap()Ljava/util/Map;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :cond_2
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_0

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 39
    .local v3, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Integer;Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;>;"
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    .line 41
    .local v9, "seasonLabel":Ljava/lang/StringBuilder;
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/Integer;

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    if-lez v11, :cond_7

    .line 42
    sget v11, Lcom/xfinity/playerlib/R$string;->speech_list_season_x:I

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v15

    aput-object v15, v13, v14

    move-object/from16 v0, p2

    invoke-virtual {v0, v11, v13}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 47
    :cond_3
    :goto_0
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 49
    .local v6, "episodes":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :goto_1
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_2

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 50
    .local v10, "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 51
    .local v8, "sb":Ljava/lang/StringBuilder;
    add-int/lit8 v7, v7, 0x1

    .line 53
    add-int/lit8 v11, v7, -0x1

    rem-int/lit8 v11, v11, 0x5

    if-eqz v11, :cond_4

    invoke-interface {v10}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    if-eq v2, v11, :cond_5

    .line 54
    :cond_4
    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v8, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 55
    const-string v11, " "

    invoke-virtual {v8, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 58
    :cond_5
    invoke-interface {v10}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 60
    const-string v4, ""

    .line 61
    .local v4, "episodeLabel":Ljava/lang/String;
    const-string v5, ""

    .line 63
    .local v5, "episodeNumber":Ljava/lang/String;
    invoke-interface {v10}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    const/4 v14, 0x1

    if-lt v11, v14, :cond_6

    .line 64
    const/4 v11, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->getItemTypeQuantity(I)Ljava/lang/String;

    move-result-object v4

    .line 65
    invoke-interface {v10}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v5

    .line 68
    :cond_6
    sget v14, Lcom/xfinity/playerlib/R$string;->speech_list_episode_list_row:I

    const/4 v11, 0x5

    new-array v15, v11, [Ljava/lang/Object;

    const/4 v11, 0x0

    .line 69
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v16

    aput-object v16, v15, v11

    const/4 v11, 0x1

    aput-object v4, v15, v11

    const/4 v11, 0x2

    aput-object v5, v15, v11

    const/16 v16, 0x3

    .line 72
    invoke-interface {v10}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->isNew()Z

    move-result v11

    if-eqz v11, :cond_8

    sget v11, Lcom/xfinity/playerlib/R$string;->speech_list_is_new:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v11

    :goto_2
    aput-object v11, v15, v16

    const/4 v11, 0x4

    .line 73
    invoke-interface {v10}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v16

    aput-object v16, v15, v11

    .line 68
    move-object/from16 v0, p2

    invoke-virtual {v0, v14, v15}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v8, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 76
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->results:Ljava/util/List;

    new-instance v14, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v14, v15, v10}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v11, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 43
    .end local v4    # "episodeLabel":Ljava/lang/String;
    .end local v5    # "episodeNumber":Ljava/lang/String;
    .end local v6    # "episodes":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    .end local v8    # "sb":Ljava/lang/StringBuilder;
    .end local v10    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :cond_7
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/Integer;

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    const/4 v13, -0x1

    if-ne v11, v13, :cond_3

    .line 44
    sget v11, Lcom/xfinity/playerlib/R$string;->speech_list_other_videos:I

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_0

    .line 72
    .restart local v4    # "episodeLabel":Ljava/lang/String;
    .restart local v5    # "episodeNumber":Ljava/lang/String;
    .restart local v6    # "episodes":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    .restart local v8    # "sb":Ljava/lang/StringBuilder;
    .restart local v10    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :cond_8
    const-string v11, ""

    goto :goto_2
.end method


# virtual methods
.method protected getItemTypeQuantity(I)Ljava/lang/String;
    .locals 2
    .param p1, "quantity"    # I

    .prologue
    .line 111
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$plurals;->speech_episode:I

    invoke-virtual {v0, v1, p1}, Landroid/content/res/Resources;->getQuantityString(II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getResultRowDescriptions(Ljava/lang/StringBuilder;)V
    .locals 3
    .param p1, "sb"    # Ljava/lang/StringBuilder;

    .prologue
    .line 97
    iget v2, p0, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->lastListItemIndex:I

    mul-int/lit8 v0, v2, 0x5

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 99
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->results:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .line 100
    .local v1, "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    iget-object v2, v1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 101
    const-string v2, ". "

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 103
    iget v2, p0, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->lastListItemIndex:I

    mul-int/lit8 v2, v2, 0x5

    add-int/lit8 v2, v2, 0x4

    if-ne v0, v2, :cond_1

    .line 107
    .end local v1    # "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    :cond_0
    return-void

    .line 97
    .restart local v1    # "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public speakResults()Ljava/lang/String;
    .locals 2

    .prologue
    .line 84
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 86
    .local v0, "sb":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 87
    const-string v1, ". "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 89
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->buildSpeechResponse(Ljava/lang/StringBuilder;)V

    .line 91
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
