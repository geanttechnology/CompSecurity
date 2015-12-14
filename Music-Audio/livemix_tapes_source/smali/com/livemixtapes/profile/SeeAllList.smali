.class public Lcom/livemixtapes/profile/SeeAllList;
.super Landroid/app/Fragment;
.source "SeeAllList.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;,
        Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;,
        Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;,
        Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;
    }
.end annotation


# instance fields
.field adapter:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

.field dbHelper:Lcom/livemixtapes/database/DBHelper;

.field public flag:I

.field imageLoader:Lcom/livemixtapes/ImageLoader;

.field isAddTracksToPlayList:Z

.field isEditableMode:Z

.field layoutBack:Landroid/widget/LinearLayout;

.field mContext:Landroid/content/Context;

.field public playList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field playListView:Landroid/widget/ListView;

.field rootView:Landroid/view/View;

.field textViewAction:Landroid/widget/TextView;

.field textViewTitle:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method


# virtual methods
.method deleteDownload(Ljava/lang/String;)V
    .locals 2
    .param p1, "albumId"    # Ljava/lang/String;

    .prologue
    .line 508
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    invoke-virtual {p0}, Lcom/livemixtapes/profile/SeeAllList;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lcom/livemixtapes/database/DBHelper;->deleteDownloadsAlbum(Landroid/content/Context;Ljava/lang/String;)I

    .line 509
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 510
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    invoke-virtual {v1}, Lcom/livemixtapes/database/DBHelper;->getDownloadsGroupedByAlbum()Ljava/util/ArrayList;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 511
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList;->adapter:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    invoke-virtual {v0}, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->notifyDataSetChanged()V

    .line 512
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 69
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->rootView:Landroid/view/View;

    if-nez v1, :cond_3

    .line 70
    invoke-virtual {p0}, Lcom/livemixtapes/profile/SeeAllList;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iput-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->mContext:Landroid/content/Context;

    .line 71
    const v1, 0x7f03002e

    invoke-virtual {p1, v1, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->rootView:Landroid/view/View;

    .line 72
    invoke-virtual {p0}, Lcom/livemixtapes/profile/SeeAllList;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "flag"

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    .line 73
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->rootView:Landroid/view/View;

    const v2, 0x7f0800e5

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewAction:Landroid/widget/TextView;

    .line 75
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->rootView:Landroid/view/View;

    const v2, 0x7f08006c

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewTitle:Landroid/widget/TextView;

    .line 76
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->rootView:Landroid/view/View;

    const v2, 0x7f08006d

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->layoutBack:Landroid/widget/LinearLayout;

    .line 78
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->layoutBack:Landroid/widget/LinearLayout;

    new-instance v2, Lcom/livemixtapes/profile/SeeAllList$1;

    invoke-direct {v2, p0}, Lcom/livemixtapes/profile/SeeAllList$1;-><init>(Lcom/livemixtapes/profile/SeeAllList;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 88
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewAction:Landroid/widget/TextView;

    const-string v2, ""

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 89
    invoke-virtual {p0}, Lcom/livemixtapes/profile/SeeAllList;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "isAddTrackToPlaylist"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/livemixtapes/profile/SeeAllList;->isAddTracksToPlayList:Z

    .line 90
    iput-boolean v3, p0, Lcom/livemixtapes/profile/SeeAllList;->isEditableMode:Z

    .line 91
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    .line 92
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/livemixtapes/database/DBHelper;->sharedInstance(Landroid/content/Context;)Lcom/livemixtapes/database/DBHelper;

    move-result-object v1

    iput-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    .line 94
    iget-boolean v1, p0, Lcom/livemixtapes/profile/SeeAllList;->isAddTracksToPlayList:Z

    if-eqz v1, :cond_4

    .line 96
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewAction:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 97
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewAction:Landroid/widget/TextView;

    const-string v2, "Add"

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 98
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewAction:Landroid/widget/TextView;

    new-instance v2, Lcom/livemixtapes/profile/SeeAllList$2;

    invoke-direct {v2, p0}, Lcom/livemixtapes/profile/SeeAllList$2;-><init>(Lcom/livemixtapes/profile/SeeAllList;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    :cond_0
    :goto_0
    iget v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    if-ne v1, v4, :cond_7

    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v1

    if-eqz v1, :cond_7

    .line 124
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_6

    .line 135
    :cond_1
    :goto_2
    iget v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    if-ne v1, v4, :cond_9

    .line 136
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewTitle:Landroid/widget/TextView;

    const-string v2, "Playlists"

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 145
    :cond_2
    :goto_3
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->rootView:Landroid/view/View;

    const v2, 0x7f0800e6

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->playListView:Landroid/widget/ListView;

    .line 146
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->playListView:Landroid/widget/ListView;

    invoke-virtual {v1, v3}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 147
    new-instance v1, Lcom/livemixtapes/ImageLoader;

    iget-object v2, p0, Lcom/livemixtapes/profile/SeeAllList;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->imageLoader:Lcom/livemixtapes/ImageLoader;

    .line 148
    new-instance v1, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    invoke-virtual {p0}, Lcom/livemixtapes/profile/SeeAllList;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;-><init>(Lcom/livemixtapes/profile/SeeAllList;Landroid/app/Activity;)V

    iput-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->adapter:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    .line 149
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->playListView:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/livemixtapes/profile/SeeAllList;->adapter:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 151
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->playListView:Landroid/widget/ListView;

    new-instance v2, Lcom/livemixtapes/profile/SeeAllList$4;

    invoke-direct {v2, p0}, Lcom/livemixtapes/profile/SeeAllList$4;-><init>(Lcom/livemixtapes/profile/SeeAllList;)V

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 198
    :cond_3
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->rootView:Landroid/view/View;

    return-object v1

    .line 107
    :cond_4
    iget v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    if-eq v1, v4, :cond_5

    iget v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    if-ne v1, v5, :cond_0

    .line 109
    :cond_5
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewAction:Landroid/widget/TextView;

    const-string v2, "Edit"

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 110
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewAction:Landroid/widget/TextView;

    new-instance v2, Lcom/livemixtapes/profile/SeeAllList$3;

    invoke-direct {v2, p0}, Lcom/livemixtapes/profile/SeeAllList$3;-><init>(Lcom/livemixtapes/profile/SeeAllList;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 124
    :cond_6
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 125
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 126
    .end local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_7
    iget v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    if-ne v1, v5, :cond_8

    .line 127
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    iget-object v2, p0, Lcom/livemixtapes/profile/SeeAllList;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    invoke-virtual {v2}, Lcom/livemixtapes/database/DBHelper;->getDownloadsGroupedByAlbum()Ljava/util/ArrayList;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_2

    .line 129
    :cond_8
    iget v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    if-ne v1, v6, :cond_1

    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 131
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/User$UserData;->favoriteMixtapes:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 132
    .restart local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 138
    .end local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_9
    iget v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    if-ne v1, v5, :cond_a

    .line 139
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewTitle:Landroid/widget/TextView;

    const-string v2, "Downloads"

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_3

    .line 141
    :cond_a
    iget v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    if-ne v1, v6, :cond_2

    .line 142
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->textViewTitle:Landroid/widget/TextView;

    const-string v2, "Favorites"

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_3
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 204
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 205
    iget v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_2

    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 207
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 208
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 210
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->adapter:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    invoke-virtual {v1}, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->notifyDataSetChanged()V

    .line 220
    :cond_0
    :goto_1
    return-void

    .line 208
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 209
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 212
    .end local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_2
    iget v1, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    const/4 v2, 0x3

    if-ne v1, v2, :cond_0

    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 214
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 215
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/User$UserData;->favoriteMixtapes:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_3

    .line 218
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList;->adapter:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    invoke-virtual {v1}, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->notifyDataSetChanged()V

    goto :goto_1

    .line 215
    :cond_3
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 216
    .restart local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v2, p0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2
.end method

.method showMixtapeFragment(Landroid/content/Context;Ljava/util/HashMap;)V
    .locals 5
    .param p1, "ctx"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 347
    .local p2, "obj":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {p0}, Lcom/livemixtapes/profile/SeeAllList;->getActivity()Landroid/app/Activity;

    move-result-object v3

    check-cast v3, Lcom/livemixtapes/ui/BaseActivity;

    invoke-virtual {v3}, Lcom/livemixtapes/ui/BaseActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 348
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v2, Lcom/livemixtapes/Mixtape;

    invoke-direct {v2}, Lcom/livemixtapes/Mixtape;-><init>()V

    .line 349
    .local v2, "mixtapeFragment":Lcom/livemixtapes/Mixtape;
    const v3, 0x7f0800cc

    const-string v4, "MIXTAPE"

    invoke-virtual {v1, v3, v2, v4}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 350
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 351
    .local v0, "extras":Landroid/os/Bundle;
    const-string v3, "mixtapeData"

    invoke-virtual {v0, v3, p2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 352
    iget v3, p0, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    const/4 v4, 0x2

    if-ne v3, v4, :cond_0

    .line 353
    const-string v3, "backScreenTitle"

    const-string v4, "Downloads"

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    :goto_0
    invoke-virtual {v2, v0}, Lcom/livemixtapes/Mixtape;->setArguments(Landroid/os/Bundle;)V

    .line 359
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 360
    return-void

    .line 356
    :cond_0
    const-string v3, "backScreenTitle"

    const-string v4, "Favorites"

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
