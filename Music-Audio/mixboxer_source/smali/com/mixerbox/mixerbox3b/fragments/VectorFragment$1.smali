.class Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 12

    .prologue
    .line 91
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorPageType:I

    const/4 v1, 0x3

    if-eq v0, v1, :cond_1

    .line 92
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, p3}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/MyItem;

    .line 93
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-interface {v0}, Lcom/mixerbox/mixerbox3b/classes/MyItem;->getMyJSONObject()Lorg/json/JSONObject;

    move-result-object v0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {v1, v0, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle;->onClick(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Landroid/view/View;)V

    .line 171
    :cond_0
    :goto_0
    return-void

    .line 97
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, p3}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/MyItem;

    .line 98
    invoke-interface {v0}, Lcom/mixerbox/mixerbox3b/classes/MyItem;->getMyJSONObject()Lorg/json/JSONObject;

    move-result-object v5

    .line 99
    const-string v1, "type"

    invoke-virtual {v5, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_16

    const-string v1, "type"

    invoke-virtual {v5, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "music"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_16

    .line 100
    const-string v4, ""

    .line 101
    const-string v3, ""

    .line 102
    const-string v2, ""

    .line 103
    const-string v1, ""

    .line 104
    const-string v7, ""

    .line 105
    const/4 v6, 0x1

    .line 106
    const-string v0, "f"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 107
    const-string v0, "f"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 108
    :cond_2
    const-string v0, "tm"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_d

    .line 109
    const-string v0, "tm"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 112
    :cond_3
    :goto_1
    const-string v0, "tt"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_e

    .line 113
    const-string v0, "tt"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 116
    :cond_4
    :goto_2
    const-string v0, "_id"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 117
    const-string v0, "_id"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 118
    :cond_5
    const-string v0, "thumbnail"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 119
    const-string v0, "thumbnail"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 120
    :cond_6
    const-string v0, "source"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 121
    const/4 v6, 0x1

    .line 128
    :cond_7
    :goto_3
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    .line 129
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 130
    const/4 v5, 0x0

    move-object v8, v7

    move v7, v6

    move v6, v5

    move-object v5, v4

    move-object v4, v3

    move-object v3, v2

    move-object v2, v1

    :goto_4
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v6, v1, :cond_15

    .line 131
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    invoke-interface {v1, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/MyItem;

    invoke-interface {v1}, Lcom/mixerbox/mixerbox3b/classes/MyItem;->getMyJSONObject()Lorg/json/JSONObject;

    move-result-object v1

    .line 132
    const-string v10, "f"

    invoke-virtual {v1, v10}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_8

    .line 133
    const-string v5, "f"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 134
    :cond_8
    const-string v10, "tm"

    invoke-virtual {v1, v10}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_11

    .line 135
    const-string v4, "tm"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 138
    :cond_9
    :goto_5
    const-string v10, "tt"

    invoke-virtual {v1, v10}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_12

    .line 139
    const-string v3, "tt"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 142
    :cond_a
    :goto_6
    const-string v10, "_id"

    invoke-virtual {v1, v10}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_b

    .line 143
    const-string v2, "_id"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 144
    :cond_b
    const-string v10, "source"

    invoke-virtual {v1, v10}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_13

    .line 145
    const/4 v7, 0x1

    .line 154
    :cond_c
    :goto_7
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-direct/range {v1 .. v8}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    invoke-virtual {v9, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 130
    add-int/lit8 v6, v6, 0x1

    goto :goto_4

    .line 110
    :cond_d
    const-string v0, "duration"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 111
    const-string v0, "duration"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_1

    .line 114
    :cond_e
    const-string v0, "title"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 115
    const-string v0, "title"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_2

    .line 122
    :cond_f
    const-string v0, "source"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v8, "youtube"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 123
    const/4 v6, 0x1

    goto/16 :goto_3

    .line 124
    :cond_10
    const-string v0, "source"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v8, "soundcloud"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 125
    const/4 v6, 0x3

    .line 126
    const-string v0, "trackId"

    invoke-virtual {v5, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_3

    .line 136
    :cond_11
    const-string v10, "duration"

    invoke-virtual {v1, v10}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_9

    .line 137
    const-string v4, "duration"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_5

    .line 140
    :cond_12
    const-string v10, "title"

    invoke-virtual {v1, v10}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_a

    .line 141
    const-string v3, "title"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_6

    .line 146
    :cond_13
    const-string v10, "source"

    invoke-virtual {v1, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    const-string v11, "youtube"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_14

    .line 147
    const/4 v7, 0x1

    goto/16 :goto_7

    .line 148
    :cond_14
    const-string v10, "source"

    invoke-virtual {v1, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    const-string v11, "soundcloud"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_c

    .line 149
    const/4 v7, 0x3

    .line 150
    const-string v5, "trackId"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 151
    const-string v10, "thumbnail"

    invoke-virtual {v1, v10}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_c

    .line 152
    const-string v8, "thumbnail"

    invoke-virtual {v1, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    goto/16 :goto_7

    .line 156
    :cond_15
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object v9, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    .line 157
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 158
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 159
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    add-int/lit8 v1, p3, -0x1

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 160
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 166
    :catch_0
    move-exception v0

    .line 167
    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    goto/16 :goto_0

    .line 162
    :cond_16
    :try_start_1
    const-string v1, "type"

    invoke-virtual {v5, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "type"

    invoke-virtual {v5, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "playlist"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 163
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-interface {v0}, Lcom/mixerbox/mixerbox3b/classes/MyItem;->getMyJSONObject()Lorg/json/JSONObject;

    move-result-object v0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {v1, v0, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle;->onClick(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Landroid/view/View;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method
