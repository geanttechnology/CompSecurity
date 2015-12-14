.class public Lcom/livemixtapes/ProfileFragment;
.super Landroid/app/Fragment;
.source "ProfileFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/ProfileFragment$LoadDownloadData;,
        Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;
    }
.end annotation


# instance fields
.field activity:Lcom/livemixtapes/ProfileActivity;

.field downloadList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field imageLoader:Lcom/livemixtapes/ImageLoader;

.field listView:Landroid/widget/ListView;

.field logoutText:Landroid/widget/TextView;

.field playlistList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field profileList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field profileListAdapter:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

.field rootView:Landroid/view/View;

.field textViewTitle:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 38
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/ProfileFragment;->profileList:Ljava/util/ArrayList;

    .line 44
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/ProfileFragment;->playlistList:Ljava/util/ArrayList;

    .line 45
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/ProfileFragment;->downloadList:Ljava/util/ArrayList;

    .line 49
    iput-object v1, p0, Lcom/livemixtapes/ProfileFragment;->logoutText:Landroid/widget/TextView;

    .line 50
    iput-object v1, p0, Lcom/livemixtapes/ProfileFragment;->textViewTitle:Landroid/widget/TextView;

    .line 38
    return-void
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 60
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->rootView:Landroid/view/View;

    if-nez v6, :cond_1

    .line 61
    const v6, 0x7f030030

    invoke-virtual {p1, v6, p2, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    iput-object v6, p0, Lcom/livemixtapes/ProfileFragment;->rootView:Landroid/view/View;

    .line 63
    invoke-virtual {p0}, Lcom/livemixtapes/ProfileFragment;->getActivity()Landroid/app/Activity;

    move-result-object v6

    check-cast v6, Lcom/livemixtapes/ProfileActivity;

    iput-object v6, p0, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    .line 65
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->rootView:Landroid/view/View;

    const v7, 0x7f0800ea

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    iput-object v6, p0, Lcom/livemixtapes/ProfileFragment;->logoutText:Landroid/widget/TextView;

    .line 66
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->rootView:Landroid/view/View;

    const v7, 0x7f08006c

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    iput-object v6, p0, Lcom/livemixtapes/ProfileFragment;->textViewTitle:Landroid/widget/TextView;

    .line 67
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->rootView:Landroid/view/View;

    const v7, 0x7f0800eb

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ListView;

    iput-object v6, p0, Lcom/livemixtapes/ProfileFragment;->listView:Landroid/widget/ListView;

    .line 68
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->listView:Landroid/widget/ListView;

    invoke-virtual {v6, v8}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 69
    new-instance v6, Lcom/livemixtapes/ImageLoader;

    iget-object v7, p0, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    invoke-direct {v6, v7}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    iput-object v6, p0, Lcom/livemixtapes/ProfileFragment;->imageLoader:Lcom/livemixtapes/ImageLoader;

    .line 71
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p0, Lcom/livemixtapes/ProfileFragment;->profileList:Ljava/util/ArrayList;

    .line 72
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->profileList:Ljava/util/ArrayList;

    const-string v7, "Playlists"

    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 73
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->profileList:Ljava/util/ArrayList;

    const-string v7, "Downloads"

    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 74
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->profileList:Ljava/util/ArrayList;

    const-string v7, "Favorites"

    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 76
    invoke-static {}, Lcom/livemixtapes/User;->isLogged()Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 77
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v6

    iget-object v6, v6, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_2

    .line 80
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->textViewTitle:Landroid/widget/TextView;

    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v7

    iget-object v7, v7, Lcom/livemixtapes/User$UserData;->userName:Ljava/lang/String;

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    :cond_0
    new-instance v6, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    iget-object v7, p0, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    invoke-direct {v6, p0, v7}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;-><init>(Lcom/livemixtapes/ProfileFragment;Lcom/livemixtapes/ui/BaseActivity;)V

    iput-object v6, p0, Lcom/livemixtapes/ProfileFragment;->profileListAdapter:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    .line 84
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->listView:Landroid/widget/ListView;

    iget-object v7, p0, Lcom/livemixtapes/ProfileFragment;->profileListAdapter:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    invoke-virtual {v6, v7}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 92
    const/4 v1, 0x0

    .line 93
    .local v1, "json":Lorg/json/JSONObject;
    const/4 v3, 0x0

    .line 95
    .local v3, "json_tape":Lorg/json/JSONObject;
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    sget-object v6, Lcom/livemixtapes/App;->DefaultTape:Ljava/lang/String;

    invoke-direct {v2, v6}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 96
    .end local v1    # "json":Lorg/json/JSONObject;
    .local v2, "json":Lorg/json/JSONObject;
    :try_start_1
    const-string v6, "mixtape"

    invoke-virtual {v2, v6}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v3

    move-object v1, v2

    .line 103
    .end local v2    # "json":Lorg/json/JSONObject;
    .restart local v1    # "json":Lorg/json/JSONObject;
    :goto_1
    invoke-static {v3}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v5

    .line 105
    .local v5, "mixtape":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v6, Lcom/livemixtapes/App;->didLoad:Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    if-nez v6, :cond_1

    .line 107
    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    sput-object v6, Lcom/livemixtapes/App;->didLoad:Ljava/lang/Boolean;

    .line 108
    sput-boolean v9, Lcom/livemixtapes/MainActivity;->firstLoad:Z

    .line 109
    const-string v6, "tracks"

    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/ArrayList;

    sput-object v6, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    .line 110
    sput-object v5, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    .line 111
    const/4 v6, 0x0

    sput-object v6, Lcom/livemixtapes/NowPlayingActivity;->playList:Ljava/util/Map;

    .line 112
    sput v8, Lcom/livemixtapes/NowPlayingActivity;->position:I

    .line 113
    sput v9, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    .line 115
    new-instance v6, Landroid/content/Intent;

    iget-object v7, p0, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    const-class v8, Lcom/livemixtapes/NowPlayingActivity;

    invoke-direct {v6, v7, v8}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v6}, Lcom/livemixtapes/ProfileFragment;->startActivity(Landroid/content/Intent;)V

    .line 122
    .end local v1    # "json":Lorg/json/JSONObject;
    .end local v3    # "json_tape":Lorg/json/JSONObject;
    .end local v5    # "mixtape":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_1
    iget-object v6, p0, Lcom/livemixtapes/ProfileFragment;->rootView:Landroid/view/View;

    return-object v6

    .line 77
    :cond_2
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    .line 78
    .local v4, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v7, p0, Lcom/livemixtapes/ProfileFragment;->playlistList:Ljava/util/ArrayList;

    invoke-virtual {v7, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 98
    .end local v4    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local v1    # "json":Lorg/json/JSONObject;
    .restart local v3    # "json_tape":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 100
    .local v0, "e":Ljava/lang/Exception;
    :goto_2
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 98
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "json":Lorg/json/JSONObject;
    .restart local v2    # "json":Lorg/json/JSONObject;
    :catch_1
    move-exception v0

    move-object v1, v2

    .end local v2    # "json":Lorg/json/JSONObject;
    .restart local v1    # "json":Lorg/json/JSONObject;
    goto :goto_2
.end method

.method public onResume()V
    .locals 6

    .prologue
    .line 333
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 335
    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment;->logoutText:Landroid/widget/TextView;

    const-string v4, "Logout"

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 336
    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment;->logoutText:Landroid/widget/TextView;

    new-instance v4, Lcom/livemixtapes/ProfileFragment$1;

    invoke-direct {v4, p0}, Lcom/livemixtapes/ProfileFragment$1;-><init>(Lcom/livemixtapes/ProfileFragment;)V

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 352
    const-string v5, "LOGGING PROFILE ACTIVITY"

    aput-object v5, v3, v4

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 353
    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    invoke-virtual {v3}, Lcom/livemixtapes/ProfileActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/App;

    .line 355
    .local v0, "application":Lcom/livemixtapes/App;
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v3

    const-string v4, "Image~ProfileActivity"

    invoke-virtual {v3, v4}, Lcom/google/android/gms/analytics/Tracker;->setScreenName(Ljava/lang/String;)V

    .line 357
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v3

    new-instance v4, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;

    invoke-direct {v4}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;-><init>()V

    invoke-virtual {v4}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;->build()Ljava/util/Map;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/google/android/gms/analytics/Tracker;->send(Ljava/util/Map;)V

    .line 360
    invoke-static {}, Lcom/livemixtapes/User;->isLogged()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 361
    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment;->playlistList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 362
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v3

    iget-object v3, v3, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_1

    .line 367
    :cond_0
    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    invoke-static {v3}, Lcom/livemixtapes/database/DBHelper;->sharedInstance(Landroid/content/Context;)Lcom/livemixtapes/database/DBHelper;

    move-result-object v1

    .line 368
    .local v1, "dbHelper":Lcom/livemixtapes/database/DBHelper;
    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment;->downloadList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 369
    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment;->downloadList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Lcom/livemixtapes/database/DBHelper;->getDownloadsGroupedByAlbum()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 370
    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment;->profileListAdapter:Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;

    invoke-virtual {v3}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->notifyDataSetChanged()V

    .line 371
    return-void

    .line 362
    .end local v1    # "dbHelper":Lcom/livemixtapes/database/DBHelper;
    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    .line 363
    .local v2, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v4, p0, Lcom/livemixtapes/ProfileFragment;->playlistList:Ljava/util/ArrayList;

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method openSeeAllFragment(I)V
    .locals 5
    .param p1, "flag"    # I

    .prologue
    .line 390
    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    invoke-virtual {v3}, Lcom/livemixtapes/ProfileActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 391
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v2, Lcom/livemixtapes/profile/SeeAllList;

    invoke-direct {v2}, Lcom/livemixtapes/profile/SeeAllList;-><init>()V

    .line 392
    .local v2, "seeAllFragment":Lcom/livemixtapes/profile/SeeAllList;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 393
    .local v0, "extras":Landroid/os/Bundle;
    const-string v3, "flag"

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 394
    invoke-virtual {v2, v0}, Lcom/livemixtapes/profile/SeeAllList;->setArguments(Landroid/os/Bundle;)V

    .line 395
    const v3, 0x7f0800cc

    const-string v4, "SEEALL"

    invoke-virtual {v1, v3, v2, v4}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 396
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 397
    return-void
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
    .line 376
    .local p2, "obj":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    invoke-virtual {v3}, Lcom/livemixtapes/ProfileActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 377
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v2, Lcom/livemixtapes/Mixtape;

    invoke-direct {v2}, Lcom/livemixtapes/Mixtape;-><init>()V

    .line 378
    .local v2, "mixtapeFragment":Lcom/livemixtapes/Mixtape;
    const v3, 0x7f0800cc

    const-string v4, "MIXTAPE"

    invoke-virtual {v1, v3, v2, v4}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 379
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 380
    .local v0, "extras":Landroid/os/Bundle;
    const-string v3, "mixtapeData"

    invoke-virtual {v0, v3, p2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 381
    const-string v3, "backScreenTitle"

    const-string v4, "Profile"

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 382
    invoke-virtual {v2, v0}, Lcom/livemixtapes/Mixtape;->setArguments(Landroid/os/Bundle;)V

    .line 383
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 384
    return-void
.end method
