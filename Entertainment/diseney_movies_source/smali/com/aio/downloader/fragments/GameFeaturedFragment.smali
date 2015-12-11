.class public Lcom/aio/downloader/fragments/GameFeaturedFragment;
.super Landroid/support/v4/app/Fragment;
.source "GameFeaturedFragment.java"

# interfaces
.implements Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya1;,
        Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya3;
    }
.end annotation


# instance fields
.field private adView:Lcom/facebook/ads/AdView;

.field private adapter:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

.field private bitmap:Landroid/graphics/Bitmap;

.field private facebookbanner:Landroid/widget/LinearLayout;

.field private h:I

.field private hideapp1:Landroid/content/BroadcastReceiver;

.field private imginmobibanner:Landroid/widget/ImageView;

.field private inmobbanner:Landroid/widget/LinearLayout;

.field private isfa:Z

.field private isshow:Z

.field private list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;>;"
        }
    .end annotation
.end field

.field private listView:Lcom/aio/downloader/refresh/PullableListView_load;

.field list_fun:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/Fun_appModel;",
            ">;"
        }
    .end annotation
.end field

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private next:I

.field private page:I

.field private progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private showapp1:Landroid/content/BroadcastReceiver;

.field private swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

.field private w:I


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 44
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 46
    new-instance v0, Lcom/aio/downloader/fragments/GameFeaturedFragment$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment$1;-><init>(Lcom/aio/downloader/fragments/GameFeaturedFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->showapp1:Landroid/content/BroadcastReceiver;

    .line 55
    new-instance v0, Lcom/aio/downloader/fragments/GameFeaturedFragment$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment$2;-><init>(Lcom/aio/downloader/fragments/GameFeaturedFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->hideapp1:Landroid/content/BroadcastReceiver;

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->list:Ljava/util/ArrayList;

    .line 67
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 68
    iput v2, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->page:I

    .line 69
    iput v2, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->next:I

    .line 77
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->list_fun:Ljava/util/ArrayList;

    .line 82
    iput-boolean v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->isfa:Z

    .line 83
    iput-boolean v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->isshow:Z

    .line 44
    return-void
.end method

.method private ApppopulistViewbottom()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 251
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    .line 252
    invoke-virtual {v1}, Lcom/aio/downloader/refresh/PullableListView_load;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 251
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 253
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x42480000    # 50.0f

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 254
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/refresh/PullableListView_load;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 256
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    .line 233
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->list:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parsefeatured(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 235
    new-instance v0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->list:Ljava/util/ArrayList;

    .line 236
    const-string v3, "gamefeatured"

    iget-object v4, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->list_fun:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 235
    iput-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->adapter:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    .line 237
    iget v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->page:I

    if-ne v0, v5, :cond_0

    .line 239
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 240
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->adapter:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    invoke-direct {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 239
    iput-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 241
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 242
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView_load;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 244
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v5}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 245
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 246
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->adapter:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->notifyDataSetChanged()V

    .line 248
    return-void
.end method

.method private ShowResult1(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 311
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->list_fun:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->fun_appList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 312
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/GameFeaturedFragment;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/GameFeaturedFragment;)I
    .locals 1

    .prologue
    .line 68
    iget v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->page:I

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/GameFeaturedFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 232
    invoke-direct {p0, p1}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/fragments/GameFeaturedFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 309
    invoke-direct {p0, p1}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->ShowResult1(Ljava/lang/String;)V

    return-void
.end method

.method private facebookad()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 343
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f03003e

    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 345
    .local v2, "viewtop":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v5, v4}, Lcom/aio/downloader/refresh/PullableListView_load;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 347
    const v3, 0x7f0701a6

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 346
    check-cast v1, Landroid/widget/ImageView;

    .line 349
    .local v1, "iv_fb_fragment":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 350
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 352
    iget-object v3, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 354
    return-void
.end method

.method private facebookbanner()V
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 115
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f03003d

    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 118
    .local v0, "viewtop":Landroid/view/View;
    const v1, 0x7f0701a5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 117
    iput-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->facebookbanner:Landroid/widget/LinearLayout;

    .line 119
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v3, v2}, Lcom/aio/downloader/refresh/PullableListView_load;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 122
    :try_start_0
    new-instance v1, Lcom/facebook/ads/AdView;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    .line 123
    const-string v3, "340186902832477_408407326010434"

    .line 124
    sget-object v4, Lcom/facebook/ads/AdSize;->RECTANGLE_HEIGHT_250:Lcom/facebook/ads/AdSize;

    invoke-direct {v1, v2, v3, v4}, Lcom/facebook/ads/AdView;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/ads/AdSize;)V

    .line 122
    iput-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->adView:Lcom/facebook/ads/AdView;

    .line 126
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->facebookbanner:Landroid/widget/LinearLayout;

    iget-object v2, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->adView:Lcom/facebook/ads/AdView;

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 128
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->adView:Lcom/facebook/ads/AdView;

    new-instance v2, Lcom/aio/downloader/fragments/GameFeaturedFragment$3;

    invoke-direct {v2, p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment$3;-><init>(Lcom/aio/downloader/fragments/GameFeaturedFragment;)V

    invoke-virtual {v1, v2}, Lcom/facebook/ads/AdView;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 151
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->adView:Lcom/facebook/ads/AdView;

    invoke-virtual {v1}, Lcom/facebook/ads/AdView;->loadAd()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 156
    :goto_0
    return-void

    .line 153
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private init(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 186
    const v0, 0x7f070072

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 187
    const v0, 0x7f07006f

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/refresh/PullableListView_load;

    iput-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    .line 188
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/refresh/PullableListView_load;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;)V

    .line 189
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 191
    new-instance v0, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya3;-><init>(Lcom/aio/downloader/fragments/GameFeaturedFragment;)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 192
    new-instance v0, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/GameFeaturedFragment;)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 194
    return-void
.end method

.method private inmobibanner()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 159
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f03005a

    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 161
    .local v0, "viewtop":Landroid/view/View;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget-object v1, v1, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    const-string v2, "US"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 162
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget-object v1, v1, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    .line 163
    const-string v2, "ID"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 169
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v3, v2}, Lcom/aio/downloader/refresh/PullableListView_load;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 170
    const v1, 0x7f070247

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->inmobbanner:Landroid/widget/LinearLayout;

    .line 172
    const v1, 0x7f070248

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 171
    iput-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->imginmobibanner:Landroid/widget/ImageView;

    .line 175
    :cond_1
    return-void
.end method


# virtual methods
.method public getHeight(II)I
    .locals 1
    .param p1, "with"    # I
    .param p2, "height"    # I

    .prologue
    .line 179
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    mul-int/2addr v0, p2

    div-int/2addr v0, p1

    return v0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 318
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 324
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 339
    :cond_0
    :goto_0
    return-void

    .line 329
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 333
    :try_start_0
    invoke-direct {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->facebookad()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 337
    :goto_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->isfa:Z

    goto :goto_0

    .line 334
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
    .line 88
    const v3, 0x7f030013

    const/4 v4, 0x0

    .line 89
    const/4 v5, 0x0

    .line 88
    invoke-virtual {p1, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 90
    .local v2, "view":Landroid/view/View;
    invoke-direct {p0, v2}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->init(Landroid/view/View;)V

    .line 93
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 94
    .local v0, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v3, "showgamefeatured"

    invoke-virtual {v0, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 95
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->showapp1:Landroid/content/BroadcastReceiver;

    invoke-virtual {v3, v4, v0}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 97
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 98
    .local v1, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v3, "hidegamefeatured"

    invoke-virtual {v1, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 99
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->hideapp1:Landroid/content/BroadcastReceiver;

    invoke-virtual {v3, v4, v1}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 106
    new-instance v3, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const-string v5, "340186902832477_388101491374351"

    invoke-direct {v3, v4, v5}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 107
    iget-object v3, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 108
    iget-object v3, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v4, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v3, v4}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 110
    return-object v2
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 274
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroy()V

    .line 275
    return-void
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 198
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 360
    return-void
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView_load;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView_load;

    .prologue
    const/4 v3, 0x0

    .line 366
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 367
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 368
    .local v0, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_next_page()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->next:I

    .line 370
    .end local v0    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 371
    iget v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->page:I

    .line 372
    new-instance v1, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/GameFeaturedFragment;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/GameFeaturedFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 377
    :goto_0
    return-void

    .line 374
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/fragments/GameFeaturedFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 268
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 269
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 270
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 261
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 262
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 263
    return-void
.end method
