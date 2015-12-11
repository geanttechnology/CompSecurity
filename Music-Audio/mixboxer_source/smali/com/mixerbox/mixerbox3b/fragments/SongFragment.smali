.class public Lcom/mixerbox/mixerbox3b/fragments/SongFragment;
.super Landroid/support/v4/app/Fragment;
.source "SourceFile"


# instance fields
.field public adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

.field array:Ljava/util/ArrayList;

.field btnAdd:Landroid/widget/TextView;

.field btnShare:Landroid/widget/TextView;

.field btnSubs:Landroid/widget/TextView;

.field public currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

.field i:Landroid/widget/ImageView;

.field ivAdd:Landroid/widget/ImageView;

.field llAdd:Landroid/widget/LinearLayout;

.field llMain:Landroid/widget/LinearLayout;

.field llSubs:Landroid/widget/LinearLayout;

.field public lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

.field rl:Landroid/widget/RelativeLayout;

.field public subsCnt:I

.field t:Landroid/widget/TextView;

.field tvHeader:Landroid/widget/TextView;

.field view:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 10

    .prologue
    const/4 v8, 0x0

    .line 43
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 58
    iput v8, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->subsCnt:I

    .line 59
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v1, ""

    const-string v2, ""

    const-string v3, ""

    const-string v4, ""

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    move v9, v8

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    return-void
.end method


# virtual methods
.method public loadContent()V
    .locals 9

    .prologue
    const v8, 0x7f080097

    const/4 v7, 0x5

    const/4 v6, 0x4

    const/4 v5, 0x0

    const/16 v4, 0x8

    .line 69
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_1

    .line 134
    :cond_0
    :goto_0
    return-void

    .line 71
    :cond_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->array:Ljava/util/ArrayList;

    .line 72
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->array:Ljava/util/ArrayList;

    if-nez v0, :cond_2

    .line 73
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->t:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 74
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0, v4}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setVisibility(I)V

    goto :goto_0

    .line 78
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->array:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_4

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    if-ne v0, v6, :cond_4

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v0

    const-string v1, "0"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 80
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->t:Landroid/widget/TextView;

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 81
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0, v4}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setVisibility(I)V

    .line 82
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->i:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 83
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnShare:Landroid/widget/TextView;

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 84
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->menu:Lcom/actionbarsherlock/view/Menu;

    const/16 v1, 0xb

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 96
    :goto_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 98
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    const/4 v1, 0x6

    if-eq v0, v1, :cond_3

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    if-ne v0, v4, :cond_5

    .line 99
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->llMain:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 114
    :goto_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistSubsCount()Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistSubsCount()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_9

    .line 115
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->llSubs:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 116
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnSubs:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistSubsCount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 120
    :goto_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->array:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_a

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    if-ne v0, v6, :cond_a

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v0

    const-string v1, "0"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 122
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstEmptyPlaylist(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 123
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-array v1, v5, [Z

    invoke-virtual {v0, v7, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    goto/16 :goto_0

    .line 86
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->t:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 87
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0, v5}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setVisibility(I)V

    .line 89
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->tvHeader:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 91
    new-instance v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->array:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    .line 92
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 93
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->i:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_1

    .line 100
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    if-ne v0, v7, :cond_6

    .line 101
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnAdd:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 102
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->ivAdd:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 103
    :cond_6
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 104
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnAdd:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->ivAdd:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 106
    :cond_7
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 107
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnAdd:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800e8

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 108
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->ivAdd:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 110
    :cond_8
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnAdd:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800e7

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 111
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->ivAdd:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 118
    :cond_9
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->llSubs:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_3

    .line 125
    :cond_a
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    if-ne v0, v6, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->array:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v0

    const-string v1, "0"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 129
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstNonEmptyPlaylist(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 130
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/16 v1, 0x9

    new-array v2, v5, [Z

    invoke-virtual {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    goto/16 :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 65
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 66
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10

    .prologue
    const/4 v5, 0x0

    .line 139
    const v0, 0x7f030036

    invoke-virtual {p1, v0, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v8

    .line 141
    const v0, 0x7f070088

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->rl:Landroid/widget/RelativeLayout;

    .line 142
    const v0, 0x7f0700a9

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    .line 143
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 144
    const v1, 0x7f03003c

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->view:Landroid/view/View;

    .line 145
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->view:Landroid/view/View;

    const v1, 0x7f0700b0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->tvHeader:Landroid/widget/TextView;

    .line 146
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->view:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 148
    const v0, 0x7f0700a1

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->i:Landroid/widget/ImageView;

    .line 149
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->i:Landroid/widget/ImageView;

    const v1, 0x7f0200c9

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 150
    const v0, 0x7f0700a0

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->t:Landroid/widget/TextView;

    .line 152
    const v0, 0x7f0700a5

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnAdd:Landroid/widget/TextView;

    .line 153
    const v0, 0x7f0700a7

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnSubs:Landroid/widget/TextView;

    .line 154
    const v0, 0x7f0700a8

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnShare:Landroid/widget/TextView;

    .line 155
    const v0, 0x7f0700a4

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->ivAdd:Landroid/widget/ImageView;

    .line 156
    const v0, 0x7f0700a6

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->llSubs:Landroid/widget/LinearLayout;

    .line 157
    const v0, 0x7f0700a3

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->llAdd:Landroid/widget/LinearLayout;

    .line 158
    const v0, 0x7f0700a2

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->llMain:Landroid/widget/LinearLayout;

    .line 160
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 182
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800dd

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setPullLabel(Ljava/lang/CharSequence;)V

    .line 183
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800b6

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setReleaseLabel(Ljava/lang/CharSequence;)V

    .line 184
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080074

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setRefreshingLabel(Ljava/lang/CharSequence;)V

    .line 186
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnRefreshListener(Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnRefreshListener;)V

    .line 216
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->array:Ljava/util/ArrayList;

    .line 217
    iget-object v9, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->array:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const-string v1, ""

    const-string v2, ""

    const-string v3, ""

    const-string v4, ""

    const/4 v6, 0x1

    const-string v7, ""

    invoke-direct/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 218
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->array:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v4}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 220
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_1

    .line 221
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setRefreshing()V

    .line 225
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->llAdd:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$3;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 259
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->llSubs:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$4;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$4;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 270
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->btnShare:Landroid/widget/TextView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment$5;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 301
    return-object v8

    .line 223
    :cond_1
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->loadContent()V

    goto :goto_0
.end method
