.class public Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;
.super Landroid/app/Activity;
.source "AppRecommendKeywordsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;,
        Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;,
        Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadpromittv;
    }
.end annotation


# static fields
.field public static search1:I


# instance fields
.field private adapter:Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

.field private adapterpromit:Lcom/aio/downloader/adapter/AppsearchpromitAdapter;

.field private adapterresult:Lcom/aio/downloader/adapter/AppListviewAdapter;

.field private appkeywords:Ljava/lang/String;

.field private biaoshi:I

.field private hideappsearch:Landroid/content/BroadcastReceiver;

.field private isfa:Z

.field private lib_refresh:Landroid/widget/TextView;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/SearchkeywordModel;",
            ">;"
        }
    .end annotation
.end field

.field private list2:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/SearcherPromitModel;",
            ">;"
        }
    .end annotation
.end field

.field private listView:Lcom/aio/downloader/refresh/PullableListView_load;

.field private listresult:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private ll_serch_refresh:Landroid/widget/LinearLayout;

.field private myjpush:I

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private next:I

.field private page:I

.field private pomitlv:Landroid/widget/ListView;

.field private progressheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private pulltoresult:Lcom/aio/downloader/refresh/PullToRefreshLayout;

.field private search_view:Lcom/aio/downloader/views/DeletableEditText;

.field private searchfan:Lcom/aio/downloader/views/LImageButton;

.field private searchid:Ljava/lang/String;

.field private searchimg:Lcom/aio/downloader/views/LImageButton;

.field private serchgridview:Landroid/widget/GridView;

.field private showappsearch:Landroid/content/BroadcastReceiver;

.field private swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 106
    const/4 v0, 0x0

    sput v0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search1:I

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 59
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 62
    new-instance v0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$1;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->showappsearch:Landroid/content/BroadcastReceiver;

    .line 71
    new-instance v0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$2;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->hideappsearch:Landroid/content/BroadcastReceiver;

    .line 86
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->appkeywords:Ljava/lang/String;

    .line 93
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;

    .line 96
    iput v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->page:I

    .line 97
    iput v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->next:I

    .line 99
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->isfa:Z

    .line 107
    iput v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->biaoshi:I

    .line 59
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 774
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseApplist(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 775
    iget v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->page:I

    if-ne v0, v4, :cond_0

    .line 776
    new-instance v0, Lcom/aio/downloader/adapter/AppListviewAdapter;

    .line 777
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;

    const-string v2, "appsearch"

    .line 778
    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-direct {v0, p0, v1, v2, v3}, Lcom/aio/downloader/adapter/AppListviewAdapter;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lcom/facebook/ads/NativeAd;)V

    .line 776
    iput-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapterresult:Lcom/aio/downloader/adapter/AppListviewAdapter;

    .line 780
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 781
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapterresult:Lcom/aio/downloader/adapter/AppListviewAdapter;

    invoke-direct {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 780
    iput-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 782
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 783
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView_load;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 787
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v4}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 788
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapterresult:Lcom/aio/downloader/adapter/AppListviewAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->notifyDataSetChanged()V

    .line 789
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->progressheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 791
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->progressheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/views/DeletableEditText;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapter:Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)I
    .locals 1

    .prologue
    .line 110
    iget v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->myjpush:I

    return v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->ll_serch_refresh:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/refresh/PullToRefreshLayout;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pulltoresult:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->appkeywords:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->appkeywords:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)I
    .locals 1

    .prologue
    .line 96
    iget v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->page:I

    return v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 772
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$18(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/refresh/PullableListView_load;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Z
    .locals 1

    .prologue
    .line 99
    iget-boolean v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->isfa:Z

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list2:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$21(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)I
    .locals 1

    .prologue
    .line 107
    iget v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->biaoshi:I

    return v0
.end method

.method static synthetic access$22(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;I)V
    .locals 0

    .prologue
    .line 107
    iput p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->biaoshi:I

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Lcom/aio/downloader/adapter/AppsearchpromitAdapter;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapterpromit:Lcom/aio/downloader/adapter/AppsearchpromitAdapter;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Lcom/aio/downloader/adapter/AppsearchpromitAdapter;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapterpromit:Lcom/aio/downloader/adapter/AppsearchpromitAdapter;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list:Ljava/util/List;

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->adapter:Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;

    return-void
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)Landroid/widget/GridView;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->serchgridview:Landroid/widget/GridView;

    return-object v0
.end method

.method private buildListener()V
    .locals 2

    .prologue
    .line 307
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->searchfan:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 308
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->serchgridview:Landroid/widget/GridView;

    new-instance v1, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$6;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/GridView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 362
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;

    new-instance v1, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$7;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 394
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    new-instance v1, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$8;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/DeletableEditText;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 463
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->searchimg:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$9;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 510
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    new-instance v1, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$10;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/DeletableEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 550
    return-void
.end method

.method private facebookad()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 172
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f03003e

    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 175
    .local v2, "viewtop":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v5, v4}, Lcom/aio/downloader/refresh/PullableListView_load;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 177
    const v3, 0x7f0701a6

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 204
    .local v1, "iv_fb_fragment":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 205
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 207
    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 210
    return-void
.end method

.method private init()V
    .locals 6

    .prologue
    const/16 v5, 0x8

    const/4 v4, 0x0

    .line 213
    const v1, 0x7f0703bd

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;

    .line 214
    const v1, 0x7f0702db

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/LImageButton;

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->searchfan:Lcom/aio/downloader/views/LImageButton;

    .line 215
    const v1, 0x7f0702dd

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/GridView;

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->serchgridview:Landroid/widget/GridView;

    .line 216
    const v1, 0x7f070072

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->progressheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 217
    const v1, 0x7f0702dc

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/DeletableEditText;

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    .line 218
    const v1, 0x7f07015c

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/LImageButton;

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->searchimg:Lcom/aio/downloader/views/LImageButton;

    .line 220
    const v1, 0x7f070052

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/refresh/PullToRefreshLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pulltoresult:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    .line 221
    const v1, 0x7f07006f

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/refresh/PullableListView_load;

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    .line 223
    const v1, 0x7f0703bc

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->lib_refresh:Landroid/widget/TextView;

    .line 224
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->lib_refresh:Landroid/widget/TextView;

    new-instance v2, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$4;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$4;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 238
    const v1, 0x7f0703b8

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->ll_serch_refresh:Landroid/widget/LinearLayout;

    .line 239
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, p0}, Lcom/aio/downloader/refresh/PullableListView_load;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;)V

    .line 240
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, v4}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 242
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list2:Ljava/util/List;

    .line 243
    const v1, 0x7f0703b9

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 244
    const v1, 0x7f0703ba

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 245
    const v1, 0x7f0703bb

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 247
    iget v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->myjpush:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 248
    const-string v1, "jjj"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "searchid="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->searchid:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 250
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->searchid:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/aio/downloader/views/DeletableEditText;->setText(Ljava/lang/CharSequence;)V

    .line 251
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;

    invoke-virtual {v1, v4}, Landroid/widget/ListView;->setVisibility(I)V

    .line 252
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->serchgridview:Landroid/widget/GridView;

    invoke-virtual {v1, v5}, Landroid/widget/GridView;->setVisibility(I)V

    .line 253
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->ll_serch_refresh:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 257
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 262
    :goto_0
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    new-instance v2, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$5;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$5;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    .line 273
    const-wide/16 v3, 0x1f4

    .line 262
    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 279
    :try_start_1
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    invoke-virtual {v1}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 280
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->list:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/SearchkeywordModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/SearchkeywordModel;->getKeyword()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->appkeywords:Ljava/lang/String;

    .line 285
    :goto_1
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    .line 286
    const v2, 0x7f0701db

    invoke-virtual {v1, v2}, Lcom/aio/downloader/refresh/PullableListView_load;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 285
    check-cast v0, Landroid/widget/RelativeLayout;

    .line 287
    .local v0, "re":Landroid/widget/RelativeLayout;
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 288
    new-instance v1, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 303
    .end local v0    # "re":Landroid/widget/RelativeLayout;
    :cond_0
    :goto_2
    return-void

    .line 282
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    invoke-virtual {v1}, Lcom/aio/downloader/views/DeletableEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->appkeywords:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 297
    :catch_0
    move-exception v1

    goto :goto_2

    .line 259
    :catch_1
    move-exception v1

    goto :goto_0
.end method


# virtual methods
.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 797
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "ad"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 801
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 811
    :cond_0
    :goto_0
    return-void

    .line 806
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 809
    invoke-direct {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->facebookad()V

    .line 810
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->isfa:Z

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/16 v4, 0x8

    .line 653
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 696
    :goto_0
    return-void

    .line 656
    :sswitch_0
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    .line 657
    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 658
    const-string v3, "input_method"

    .line 657
    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 656
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 660
    .local v0, "inputManager":Landroid/view/inputmethod/InputMethodManager;
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    invoke-virtual {v2}, Lcom/aio/downloader/views/DeletableEditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    const/4 v3, 0x0

    .line 659
    invoke-virtual {v0, v2, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 666
    .end local v0    # "inputManager":Landroid/view/inputmethod/InputMethodManager;
    :goto_1
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pulltoresult:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    invoke-virtual {v2}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->getVisibility()I

    move-result v2

    if-nez v2, :cond_0

    .line 667
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pulltoresult:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    invoke-virtual {v2, v4}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->setVisibility(I)V

    .line 668
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;

    invoke-virtual {v2, v4}, Landroid/widget/ListView;->setVisibility(I)V

    .line 669
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    const-string v3, ""

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/DeletableEditText;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 671
    :cond_0
    iget v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->myjpush:I

    if-nez v2, :cond_1

    .line 672
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->finish()V

    goto :goto_0

    .line 674
    :cond_1
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 675
    const-class v3, Lcom/aio/downloader/activity/MyMainActivity;

    .line 674
    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 676
    .local v1, "intent":Landroid/content/Intent;
    const-string v2, "acquire_url_start"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 677
    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->startActivity(Landroid/content/Intent;)V

    .line 678
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->finish()V

    goto :goto_0

    .line 683
    .end local v1    # "intent":Landroid/content/Intent;
    :sswitch_1
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 684
    const-class v4, Lcom/aio/downloader/activity/GameActivity1;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 683
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 687
    :sswitch_2
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 688
    const-class v4, Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 687
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 691
    :sswitch_3
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 692
    const-class v4, Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 691
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 662
    :catch_0
    move-exception v2

    goto :goto_1

    .line 653
    :sswitch_data_0
    .sparse-switch
        0x7f0702db -> :sswitch_0
        0x7f0703b9 -> :sswitch_1
        0x7f0703ba -> :sswitch_2
        0x7f0703bb -> :sswitch_3
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 116
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 117
    const v2, 0x7f0300ae

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->setContentView(I)V

    .line 118
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "searchint"

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->myjpush:I

    .line 120
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "searchid"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->searchid:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 125
    :goto_0
    invoke-direct {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->init()V

    .line 126
    invoke-direct {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->buildListener()V

    .line 131
    new-instance v2, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    new-array v3, v4, [Ljava/lang/Void;

    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$loadingSearchKeywords;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 133
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    new-instance v3, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$3;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$3;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    invoke-virtual {v2, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 156
    new-instance v2, Lcom/facebook/ads/NativeAd;

    const-string v3, "340186902832477_418871114964055"

    invoke-direct {v2, p0, v3}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 158
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 159
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v3, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v2, v3}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 161
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 162
    .local v0, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v2, "showappsearch"

    invoke-virtual {v0, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 163
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->showappsearch:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 165
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 166
    .local v1, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v2, "hideappsearch"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 167
    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->hideappsearch:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v1}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 168
    return-void

    .line 121
    .end local v0    # "myIntentFilter2":Landroid/content/IntentFilter;
    .end local v1    # "myIntentFilter3":Landroid/content/IntentFilter;
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 716
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 817
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/16 v1, 0x8

    .line 822
    const/4 v0, 0x4

    if-ne p1, v0, :cond_1

    .line 823
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pulltoresult:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    invoke-virtual {v0}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 824
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pulltoresult:Lcom/aio/downloader/refresh/PullToRefreshLayout;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullToRefreshLayout;->setVisibility(I)V

    .line 825
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->pomitlv:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 826
    iget-object v0, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/DeletableEditText;->setText(Ljava/lang/CharSequence;)V

    .line 827
    const/4 v0, 0x1

    .line 833
    :goto_0
    return v0

    .line 830
    :cond_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->finish()V

    .line 833
    :cond_1
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView_load;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView_load;

    .prologue
    const/4 v3, 0x0

    .line 840
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 841
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listresult:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 842
    .local v0, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_next_page()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->next:I

    .line 846
    .end local v0    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 847
    iget v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->page:I

    .line 848
    new-instance v1, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;-><init>(Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 853
    :goto_0
    return-void

    .line 850
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 708
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 709
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 710
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 701
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 702
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 703
    return-void
.end method
