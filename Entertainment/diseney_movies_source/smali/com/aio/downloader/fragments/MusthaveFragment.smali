.class public Lcom/aio/downloader/fragments/MusthaveFragment;
.super Landroid/support/v4/app/Fragment;
.source "MusthaveFragment.java"

# interfaces
.implements Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;
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
        Lcom/aio/downloader/fragments/MusthaveFragment$Mya1;,
        Lcom/aio/downloader/fragments/MusthaveFragment$Mya3;
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

    .line 45
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 48
    new-instance v0, Lcom/aio/downloader/fragments/MusthaveFragment$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/MusthaveFragment$1;-><init>(Lcom/aio/downloader/fragments/MusthaveFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->showapp1:Landroid/content/BroadcastReceiver;

    .line 57
    new-instance v0, Lcom/aio/downloader/fragments/MusthaveFragment$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/MusthaveFragment$2;-><init>(Lcom/aio/downloader/fragments/MusthaveFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->hideapp1:Landroid/content/BroadcastReceiver;

    .line 67
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->list:Ljava/util/ArrayList;

    .line 69
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 70
    iput v2, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->page:I

    .line 71
    iput v2, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->next:I

    .line 80
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->list_fun:Ljava/util/ArrayList;

    .line 85
    iput-boolean v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->isfa:Z

    .line 86
    iput-boolean v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->isshow:Z

    .line 45
    return-void
.end method

.method private ApppopulistViewbottom()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 255
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    .line 256
    invoke-virtual {v1}, Lcom/aio/downloader/refresh/PullableListView_load;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 255
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 257
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x42480000    # 50.0f

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 258
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/refresh/PullableListView_load;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 260
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    .line 237
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->list:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parsefeatured(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 239
    new-instance v0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->list:Ljava/util/ArrayList;

    .line 240
    const-string v3, "appfeatured"

    iget-object v4, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->list_fun:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 239
    iput-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->adapter:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    .line 241
    iget v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->page:I

    if-ne v0, v5, :cond_0

    .line 243
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 244
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->adapter:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    invoke-direct {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 243
    iput-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 245
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 246
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView_load;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 248
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v5}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 249
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 250
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->adapter:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->notifyDataSetChanged()V

    .line 252
    return-void
.end method

.method private ShowResult1(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 316
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->list_fun:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->fun_appList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 317
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/MusthaveFragment;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/MusthaveFragment;)I
    .locals 1

    .prologue
    .line 70
    iget v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->page:I

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/MusthaveFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 236
    invoke-direct {p0, p1}, Lcom/aio/downloader/fragments/MusthaveFragment;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/fragments/MusthaveFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 314
    invoke-direct {p0, p1}, Lcom/aio/downloader/fragments/MusthaveFragment;->ShowResult1(Ljava/lang/String;)V

    return-void
.end method

.method private facebookad()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 354
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f03003e

    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 356
    .local v2, "viewtop":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v5, v4}, Lcom/aio/downloader/refresh/PullableListView_load;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 358
    const v3, 0x7f0701a6

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 357
    check-cast v1, Landroid/widget/ImageView;

    .line 360
    .local v1, "iv_fb_fragment":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 361
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 363
    iget-object v3, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 365
    return-void
.end method

.method private facebookbanner()V
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 117
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f03003d

    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 120
    .local v0, "viewtop":Landroid/view/View;
    const v1, 0x7f0701a5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 119
    iput-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->facebookbanner:Landroid/widget/LinearLayout;

    .line 121
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v3, v2}, Lcom/aio/downloader/refresh/PullableListView_load;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 123
    :try_start_0
    new-instance v1, Lcom/facebook/ads/AdView;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    .line 124
    const-string v3, "340186902832477_408407326010434"

    .line 125
    sget-object v4, Lcom/facebook/ads/AdSize;->RECTANGLE_HEIGHT_250:Lcom/facebook/ads/AdSize;

    invoke-direct {v1, v2, v3, v4}, Lcom/facebook/ads/AdView;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/ads/AdSize;)V

    .line 123
    iput-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->adView:Lcom/facebook/ads/AdView;

    .line 127
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->facebookbanner:Landroid/widget/LinearLayout;

    iget-object v2, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->adView:Lcom/facebook/ads/AdView;

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 129
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->adView:Lcom/facebook/ads/AdView;

    new-instance v2, Lcom/aio/downloader/fragments/MusthaveFragment$3;

    invoke-direct {v2, p0}, Lcom/aio/downloader/fragments/MusthaveFragment$3;-><init>(Lcom/aio/downloader/fragments/MusthaveFragment;)V

    invoke-virtual {v1, v2}, Lcom/facebook/ads/AdView;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 152
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->adView:Lcom/facebook/ads/AdView;

    invoke-virtual {v1}, Lcom/facebook/ads/AdView;->loadAd()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 158
    :goto_0
    return-void

    .line 154
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

    .line 187
    const v0, 0x7f070072

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 188
    const v0, 0x7f07006f

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/refresh/PullableListView_load;

    iput-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    .line 189
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/refresh/PullableListView_load;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;)V

    .line 190
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 192
    new-instance v0, Lcom/aio/downloader/fragments/MusthaveFragment$Mya3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/MusthaveFragment$Mya3;-><init>(Lcom/aio/downloader/fragments/MusthaveFragment;)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/fragments/MusthaveFragment$Mya3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 193
    new-instance v0, Lcom/aio/downloader/fragments/MusthaveFragment$Mya1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/MusthaveFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/MusthaveFragment;)V

    new-array v1, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/fragments/MusthaveFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 195
    return-void
.end method

.method private inmobibanner()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 161
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f03005a

    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 162
    .local v0, "viewtop":Landroid/view/View;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getResources()Landroid/content/res/Resources;

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

    .line 163
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget-object v1, v1, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    .line 164
    const-string v2, "ID"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 170
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v3, v2}, Lcom/aio/downloader/refresh/PullableListView_load;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 171
    const v1, 0x7f070247

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->inmobbanner:Landroid/widget/LinearLayout;

    .line 173
    const v1, 0x7f070248

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 172
    iput-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->imginmobibanner:Landroid/widget/ImageView;

    .line 176
    :cond_1
    return-void
.end method


# virtual methods
.method public getHeight(II)I
    .locals 1
    .param p1, "with"    # I
    .param p2, "height"    # I

    .prologue
    .line 180
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

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
    .line 323
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 329
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 344
    :cond_0
    :goto_0
    return-void

    .line 334
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 338
    :try_start_0
    invoke-direct {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->facebookad()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 342
    :goto_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->isfa:Z

    goto :goto_0

    .line 339
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
    .line 91
    const v3, 0x7f030013

    const/4 v4, 0x0

    .line 92
    const/4 v5, 0x0

    .line 91
    invoke-virtual {p1, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 93
    .local v2, "view":Landroid/view/View;
    invoke-direct {p0, v2}, Lcom/aio/downloader/fragments/MusthaveFragment;->init(Landroid/view/View;)V

    .line 96
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 97
    .local v0, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v3, "showappfeatured"

    invoke-virtual {v0, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 98
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->showapp1:Landroid/content/BroadcastReceiver;

    invoke-virtual {v3, v4, v0}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 100
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 101
    .local v1, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v3, "hideappfeatured"

    invoke-virtual {v1, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 102
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->hideapp1:Landroid/content/BroadcastReceiver;

    invoke-virtual {v3, v4, v1}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 108
    new-instance v3, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    const-string v5, "340186902832477_388101491374351"

    invoke-direct {v3, v4, v5}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 109
    iget-object v3, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 110
    iget-object v3, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v4, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v3, v4}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 112
    return-object v2
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 279
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroy()V

    .line 280
    return-void
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 199
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 371
    return-void
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView_load;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView_load;

    .prologue
    const/4 v3, 0x0

    .line 377
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 378
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 379
    .local v0, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_next_page()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->next:I

    .line 381
    .end local v0    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 382
    iget v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->page:I

    .line 383
    new-instance v1, Lcom/aio/downloader/fragments/MusthaveFragment$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/MusthaveFragment$Mya1;-><init>(Lcom/aio/downloader/fragments/MusthaveFragment;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/MusthaveFragment$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 388
    :goto_0
    return-void

    .line 385
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/fragments/MusthaveFragment;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 272
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 273
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 274
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 265
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 266
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MusthaveFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 267
    return-void
.end method
