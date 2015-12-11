.class public Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;
.super Landroid/support/v4/app/Fragment;
.source "SourceFile"


# instance fields
.field array:Ljava/util/ArrayList;

.field arrayMP3:Ljava/util/ArrayList;

.field arraySubs:Ljava/util/ArrayList;

.field public lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

.field v:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    return-void
.end method


# virtual methods
.method public loadContent()V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 49
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_1

    .line 88
    :cond_0
    :goto_0
    return-void

    .line 52
    :cond_1
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-nez v0, :cond_2

    .line 53
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->parseDBMyPlaylists()V

    .line 54
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->parseDefaultSubsPlaylists()V

    .line 56
    :cond_2
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    if-eqz v0, :cond_8

    .line 57
    new-instance v1, Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->array:Ljava/util/ArrayList;

    .line 60
    :goto_1
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    if-eqz v0, :cond_9

    .line 61
    new-instance v1, Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->arraySubs:Ljava/util/ArrayList;

    .line 64
    :goto_2
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMP3:Ljava/util/ArrayList;

    if-eqz v0, :cond_a

    .line 65
    new-instance v1, Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMP3:Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->arrayMP3:Ljava/util/ArrayList;

    .line 69
    :goto_3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "  "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080079

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 70
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08007a

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 71
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "  "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080128

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 73
    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/SectionAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/mixerbox/mixerbox3b/classes/SectionAdapter;-><init>(Landroid/content/Context;)V

    .line 74
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->array:Ljava/util/ArrayList;

    if-eqz v4, :cond_3

    .line 75
    new-instance v4, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->array:Ljava/util/ArrayList;

    invoke-direct {v4, v5, v6}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    invoke-virtual {v3, v0, v4}, Lcom/mixerbox/mixerbox3b/classes/SectionAdapter;->addSection(Ljava/lang/String;Landroid/widget/Adapter;)V

    .line 76
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->arraySubs:Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    .line 77
    new-instance v0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->arraySubs:Ljava/util/ArrayList;

    invoke-direct {v0, v4, v5}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    invoke-virtual {v3, v1, v0}, Lcom/mixerbox/mixerbox3b/classes/SectionAdapter;->addSection(Ljava/lang/String;Landroid/widget/Adapter;)V

    .line 78
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->arrayMP3:Ljava/util/ArrayList;

    if-eqz v0, :cond_5

    .line 79
    new-instance v0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->arrayMP3:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v4}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;)V

    invoke-virtual {v3, v2, v0}, Lcom/mixerbox/mixerbox3b/classes/SectionAdapter;->addSection(Ljava/lang/String;Landroid/widget/Adapter;)V

    .line 81
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->array:Ljava/util/ArrayList;

    if-nez v0, :cond_6

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->arraySubs:Ljava/util/ArrayList;

    if-nez v0, :cond_6

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->arrayMP3:Ljava/util/ArrayList;

    if-eqz v0, :cond_7

    :cond_6
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    if-eqz v0, :cond_7

    .line 82
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0, v3}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 84
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getOnboardingFinish(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 85
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->array:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, 0x2

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    goto/16 :goto_0

    .line 59
    :cond_8
    iput-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->array:Ljava/util/ArrayList;

    goto/16 :goto_1

    .line 63
    :cond_9
    iput-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->arraySubs:Ljava/util/ArrayList;

    goto/16 :goto_2

    .line 67
    :cond_a
    iput-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->arrayMP3:Ljava/util/ArrayList;

    goto/16 :goto_3
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 45
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 46
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 93
    const v0, 0x7f030033

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->v:Landroid/view/View;

    .line 94
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->v:Landroid/view/View;

    const v1, 0x7f07008d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    .line 95
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800dd

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setPullLabel(Ljava/lang/CharSequence;)V

    .line 96
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800b6

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setReleaseLabel(Ljava/lang/CharSequence;)V

    .line 97
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080074

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setRefreshingLabel(Ljava/lang/CharSequence;)V

    .line 99
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_0

    .line 100
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnRefreshListener(Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnRefreshListener;)V

    .line 170
    :cond_0
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    .line 172
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 212
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->v:Landroid/view/View;

    return-object v0
.end method
