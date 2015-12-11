.class public Lcom/aio/downloader/fragments/AdultGamesFragment;
.super Landroid/support/v4/app/Fragment;
.source "AdultGamesFragment.java"

# interfaces
.implements Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ValidFragment"
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/fragments/AdultGamesFragment$Mya1;
    }
.end annotation


# instance fields
.field private adapter:Lcom/aio/downloader/adapter/AppListviewAdapter;

.field private hideadult2:Landroid/content/BroadcastReceiver;

.field private isfa:Z

.field private isshow:Z

.field private list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private listView:Lcom/aio/downloader/refresh/PullableListView;

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private next:I

.field private page:I

.field private progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private showadult2:Landroid/content/BroadcastReceiver;

.field private swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 47
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 49
    new-instance v0, Lcom/aio/downloader/fragments/AdultGamesFragment$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/AdultGamesFragment$1;-><init>(Lcom/aio/downloader/fragments/AdultGamesFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->showadult2:Landroid/content/BroadcastReceiver;

    .line 58
    new-instance v0, Lcom/aio/downloader/fragments/AdultGamesFragment$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/AdultGamesFragment$2;-><init>(Lcom/aio/downloader/fragments/AdultGamesFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->hideadult2:Landroid/content/BroadcastReceiver;

    .line 107
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->list:Ljava/util/ArrayList;

    .line 109
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 110
    iput v2, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->page:I

    .line 111
    iput v2, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->next:I

    .line 127
    iput-boolean v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->isfa:Z

    .line 128
    iput-boolean v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->isshow:Z

    .line 47
    return-void
.end method

.method private ApppopulistViewbottom()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 391
    iget-object v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 392
    invoke-virtual {v1}, Lcom/aio/downloader/refresh/PullableListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 391
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 394
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/AdultGamesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x42480000    # 50.0f

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 395
    iget-object v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/refresh/PullableListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 397
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    .line 374
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->list:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseApplist(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 375
    iget v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->page:I

    if-ne v0, v5, :cond_0

    .line 376
    new-instance v0, Lcom/aio/downloader/adapter/AppListviewAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/AdultGamesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->list:Ljava/util/ArrayList;

    const-string v3, "adult2"

    .line 377
    iget-object v4, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/aio/downloader/adapter/AppListviewAdapter;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lcom/facebook/ads/NativeAd;)V

    .line 376
    iput-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->adapter:Lcom/aio/downloader/adapter/AppListviewAdapter;

    .line 378
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    iget-object v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->adapter:Lcom/aio/downloader/adapter/AppListviewAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 379
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 380
    iget-object v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->adapter:Lcom/aio/downloader/adapter/AppListviewAdapter;

    invoke-direct {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 379
    iput-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 381
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    iget-object v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 382
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    iget-object v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 385
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v5}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 386
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 387
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->adapter:Lcom/aio/downloader/adapter/AppListviewAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->notifyDataSetChanged()V

    .line 388
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/AdultGamesFragment;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/AdultGamesFragment;)I
    .locals 1

    .prologue
    .line 110
    iget v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->page:I

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/AdultGamesFragment;Z)V
    .locals 0

    .prologue
    .line 128
    iput-boolean p1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->isshow:Z

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/fragments/AdultGamesFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 372
    invoke-direct {p0, p1}, Lcom/aio/downloader/fragments/AdultGamesFragment;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/fragments/AdultGamesFragment;)Z
    .locals 1

    .prologue
    .line 127
    iget-boolean v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->isfa:Z

    return v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/fragments/AdultGamesFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method private facebookad()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 241
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/AdultGamesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f03003e

    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 243
    .local v2, "viewtop":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v5, v4}, Lcom/aio/downloader/refresh/PullableListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 245
    const v3, 0x7f0701a6

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 244
    check-cast v1, Landroid/widget/ImageView;

    .line 272
    .local v1, "iv_fb_fragment":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 273
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 275
    iget-object v3, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 277
    return-void
.end method

.method private failfile()V
    .locals 1

    .prologue
    .line 67
    new-instance v0, Lcom/aio/downloader/fragments/AdultGamesFragment$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/AdultGamesFragment$3;-><init>(Lcom/aio/downloader/fragments/AdultGamesFragment;)V

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->app_popular_handler:Landroid/os/Handler;

    .line 103
    return-void
.end method

.method private init(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 283
    const v0, 0x7f070072

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 284
    const v0, 0x7f07006f

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/refresh/PullableListView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 285
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/refresh/PullableListView;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;)V

    .line 286
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 287
    new-instance v0, Lcom/aio/downloader/fragments/AdultGamesFragment$Mya1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/AdultGamesFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/AdultGamesFragment;)V

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/fragments/AdultGamesFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 289
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    new-instance v1, Lcom/aio/downloader/fragments/AdultGamesFragment$4;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/AdultGamesFragment$4;-><init>(Lcom/aio/downloader/fragments/AdultGamesFragment;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 314
    return-void
.end method


# virtual methods
.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 417
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "ad"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 421
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 439
    :cond_0
    :goto_0
    return-void

    .line 426
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 431
    :try_start_0
    iget-boolean v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->isshow:Z

    if-eqz v0, :cond_2

    .line 433
    invoke-direct {p0}, Lcom/aio/downloader/fragments/AdultGamesFragment;->facebookad()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 438
    :cond_2
    :goto_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->isfa:Z

    goto :goto_0

    .line 435
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 133
    const v3, 0x7f030012

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {p1, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 135
    .local v2, "view":Landroid/view/View;
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    const-string v3, "app_popular"

    sput-object v3, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 136
    invoke-direct {p0, v2}, Lcom/aio/downloader/fragments/AdultGamesFragment;->init(Landroid/view/View;)V

    .line 138
    invoke-direct {p0}, Lcom/aio/downloader/fragments/AdultGamesFragment;->failfile()V

    .line 141
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 142
    .local v0, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v3, "showadult2"

    invoke-virtual {v0, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 143
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/AdultGamesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->showadult2:Landroid/content/BroadcastReceiver;

    invoke-virtual {v3, v4, v0}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 145
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 146
    .local v1, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v3, "hideadult2"

    invoke-virtual {v1, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 147
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/AdultGamesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->hideadult2:Landroid/content/BroadcastReceiver;

    invoke-virtual {v3, v4, v1}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 194
    new-instance v3, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/AdultGamesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    .line 195
    const-string v5, "340186902832477_388101491374351"

    invoke-direct {v3, v4, v5}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 194
    iput-object v3, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 197
    iget-object v3, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 198
    iget-object v3, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v4, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v3, v4}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 199
    return-object v2
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 318
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 445
    return-void
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView;

    .prologue
    const/4 v3, 0x0

    .line 323
    iget-object v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 324
    iget-object v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 325
    .local v0, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_next_page()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->next:I

    .line 329
    .end local v0    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 330
    iget v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->page:I

    .line 331
    new-instance v1, Lcom/aio/downloader/fragments/AdultGamesFragment$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/AdultGamesFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/AdultGamesFragment;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/AdultGamesFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 337
    :goto_0
    return-void

    .line 333
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/fragments/AdultGamesFragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 409
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 410
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/AdultGamesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 411
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 402
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 403
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/AdultGamesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 404
    return-void
.end method
