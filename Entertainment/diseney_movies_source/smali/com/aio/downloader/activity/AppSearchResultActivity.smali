.class public Lcom/aio/downloader/activity/AppSearchResultActivity;
.super Landroid/app/Activity;
.source "AppSearchResultActivity.java"

# interfaces
.implements Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Landroid/view/View$OnClickListener;
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;
    }
.end annotation


# instance fields
.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private adapter:Lcom/aio/downloader/adapter/AppListviewAdapter;

.field private appsearchtop:Landroid/widget/RelativeLayout;

.field private badgedownimg:Lcom/aio/downloader/views/BadgeView;

.field private db:Lnet/tsz/afinal/FinalDBChen;

.field private ds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private hideappsearch:Landroid/content/BroadcastReceiver;

.field private imbdownurl:Ljava/lang/String;

.field private isfbshow:Z

.field private isshowinmobi:Z

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

.field private listView:Lcom/aio/downloader/refresh/PullableListView_load;

.field private mAnimImageView:Landroid/widget/ImageView;

.field private mAnimation:Landroid/view/animation/Animation;

.field private mRandom:I

.field private nativeAdfb:Lcom/facebook/ads/NativeAd;

.field private next:I

.field packageInfo:Landroid/content/pm/PackageInfo;

.field private page:I

.field private progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private resultsearchimg:Lcom/aio/downloader/views/LImageButton;

.field private resulttodown:Lcom/aio/downloader/views/LImageButton;

.field private resulttopgift:Landroid/widget/ImageView;

.field private searchfan:Landroid/widget/ImageView;

.field private searchkeywords:Ljava/lang/String;

.field private searchtitle:Landroid/widget/TextView;

.field private showappsearch:Landroid/content/BroadcastReceiver;

.field private swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;


# direct methods
.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 54
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 58
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 59
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->PRO_DIR_FOME:Ljava/io/File;

    .line 60
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 61
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->PRO_DIR_TO:Ljava/io/File;

    .line 62
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 63
    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->PRO_DIR:Ljava/io/File;

    .line 66
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 67
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 68
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 69
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCALLERDOWN:Ljava/io/File;

    .line 70
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 71
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 72
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 73
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCALLERAPK:Ljava/io/File;

    .line 75
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 76
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 77
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 78
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCRUSHSWF:Ljava/io/File;

    .line 79
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 80
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 81
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 82
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCRUSHAPK:Ljava/io/File;

    .line 85
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 86
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 87
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 88
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOBATTERY:Ljava/io/File;

    .line 89
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 90
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 91
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 92
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOBATTERYAPK:Ljava/io/File;

    .line 94
    iput v3, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mRandom:I

    .line 95
    iput-object v5, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 97
    new-instance v0, Lcom/aio/downloader/activity/AppSearchResultActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppSearchResultActivity$1;-><init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->showappsearch:Landroid/content/BroadcastReceiver;

    .line 106
    new-instance v0, Lcom/aio/downloader/activity/AppSearchResultActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppSearchResultActivity$2;-><init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->hideappsearch:Landroid/content/BroadcastReceiver;

    .line 146
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->list:Ljava/util/ArrayList;

    .line 148
    iput-object v5, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 149
    iput v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->page:I

    .line 150
    iput v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->next:I

    .line 151
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->searchkeywords:Ljava/lang/String;

    .line 166
    iput-boolean v3, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->isfbshow:Z

    .line 619
    iput-boolean v3, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->isshowinmobi:Z

    .line 54
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 305
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->list:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseApplist(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 306
    iget v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->page:I

    if-ne v0, v4, :cond_0

    .line 307
    new-instance v0, Lcom/aio/downloader/adapter/AppListviewAdapter;

    .line 308
    iget-object v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->list:Ljava/util/ArrayList;

    const-string v2, "appsearch"

    iget-object v3, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-direct {v0, p0, v1, v2, v3}, Lcom/aio/downloader/adapter/AppListviewAdapter;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lcom/facebook/ads/NativeAd;)V

    .line 307
    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->adapter:Lcom/aio/downloader/adapter/AppListviewAdapter;

    .line 310
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 311
    iget-object v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->adapter:Lcom/aio/downloader/adapter/AppListviewAdapter;

    invoke-direct {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 310
    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 312
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 313
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView_load;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 316
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v4}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 317
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 318
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->adapter:Lcom/aio/downloader/adapter/AppListviewAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->notifyDataSetChanged()V

    .line 320
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AppSearchResultActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/AppSearchResultActivity;Lnet/tsz/afinal/FinalDBChen;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/AppSearchResultActivity;)I
    .locals 1

    .prologue
    .line 149
    iget v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->page:I

    return v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/AppSearchResultActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 303
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/AppSearchResultActivity;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/AppSearchResultActivity;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$21(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/AppSearchResultActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 163
    iput-object p1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->ds:Ljava/util/List;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->ds:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/AppSearchResultActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mAnimImageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/AppSearchResultActivity;)Landroid/view/animation/Animation;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mAnimation:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/AppSearchResultActivity;)Lcom/aio/downloader/views/BadgeView;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/AppSearchResultActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->searchkeywords:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/AppSearchResultActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 151
    iput-object p1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->searchkeywords:Ljava/lang/String;

    return-void
.end method

.method private buildListener()V
    .locals 1

    .prologue
    .line 626
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->searchfan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 628
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->resultsearchimg:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 629
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->resulttopgift:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 630
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->resulttodown:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 632
    return-void
.end method

.method private facebookad()V
    .locals 2

    .prologue
    .line 169
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->resulttopgift:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 170
    return-void
.end method

.method private init()V
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 200
    const v0, 0x7f070073

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mAnimImageView:Landroid/widget/ImageView;

    .line 201
    const v0, 0x7f0703c1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->resulttodown:Lcom/aio/downloader/views/LImageButton;

    .line 203
    const v0, 0x7f040007

    .line 202
    invoke-static {p0, v0}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mAnimation:Landroid/view/animation/Animation;

    .line 204
    new-instance v0, Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->resulttodown:Lcom/aio/downloader/views/LImageButton;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    .line 206
    const v0, 0x7f0703b7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->searchtitle:Landroid/widget/TextView;

    .line 207
    const v0, 0x7f0702db

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->searchfan:Landroid/widget/ImageView;

    .line 209
    const v0, 0x7f0703bf

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->resultsearchimg:Lcom/aio/downloader/views/LImageButton;

    .line 210
    const v0, 0x7f0703c0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->resulttopgift:Landroid/widget/ImageView;

    .line 212
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "searchkeywords"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->searchkeywords:Ljava/lang/String;

    .line 213
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->searchtitle:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->searchkeywords:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 214
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 215
    const v0, 0x7f07006f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/refresh/PullableListView_load;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    .line 216
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/refresh/PullableListView_load;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;)V

    .line 217
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 218
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mAnimation:Landroid/view/animation/Animation;

    new-instance v1, Lcom/aio/downloader/activity/AppSearchResultActivity$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppSearchResultActivity$3;-><init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 239
    new-instance v0, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;-><init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V

    new-array v1, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 241
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    new-instance v1, Lcom/aio/downloader/activity/AppSearchResultActivity$4;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppSearchResultActivity$4;-><init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView_load;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 253
    const v0, 0x7f0701d9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->appsearchtop:Landroid/widget/RelativeLayout;

    .line 254
    return-void
.end method


# virtual methods
.method public getFileSizes(Ljava/io/File;)J
    .locals 4
    .param p1, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 696
    const-wide/16 v1, 0x0

    .line 697
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 698
    const/4 v0, 0x0

    .line 699
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 700
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 704
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 702
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 659
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "ad"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 663
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 669
    :cond_0
    :goto_0
    return-void

    .line 666
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 667
    invoke-direct {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->facebookad()V

    .line 668
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->isfbshow:Z

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 332
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v4

    sparse-switch v4, :sswitch_data_0

    .line 616
    :cond_0
    :goto_0
    return-void

    .line 334
    :sswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->finish()V

    goto :goto_0

    .line 338
    :sswitch_1
    new-instance v4, Landroid/content/Intent;

    .line 339
    const-class v5, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {v4, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 338
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 343
    :sswitch_2
    iget-boolean v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->isfbshow:Z

    if-eqz v4, :cond_1

    .line 344
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "facebook"

    const/4 v6, 0x1

    invoke-static {v4, v5, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 346
    :cond_1
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v4

    const-wide/high16 v6, 0x4010000000000000L    # 4.0

    mul-double/2addr v4, v6

    double-to-int v4, v4

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mRandom:I

    .line 347
    iget v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mRandom:I

    const/4 v5, 0x1

    if-ne v4, v5, :cond_5

    .line 350
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 352
    const-string v5, "com.evzapp.cleanmaster"

    const/4 v6, 0x0

    .line 351
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    .line 350
    iput-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 356
    :goto_1
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_4

    .line 357
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->PRO_DIR_FOME:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 358
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 360
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 361
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 362
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 360
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 363
    const-string v5, "application/vnd.android.package-archive"

    .line 359
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 364
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 365
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 353
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_0
    move-exception v1

    .line 354
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 366
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->PRO_DIR_TO:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 367
    new-instance v4, Lcom/aio/downloader/activity/AppSearchResultActivity$5;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppSearchResultActivity$5;-><init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 393
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppSearchResultActivity$5;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 395
    :cond_3
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 396
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 395
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 397
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 398
    const-string v5, "com.evzapp.cleanmaster"

    .line 397
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 399
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 400
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 403
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 405
    const-string v5, "com.evzapp.cleanmaster"

    .line 404
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 406
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 407
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 409
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_5
    iget v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mRandom:I

    const/4 v5, 0x2

    if-ne v4, v5, :cond_9

    .line 411
    :try_start_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 412
    const-string v5, "com.freepezzle.hexcrush"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    .line 411
    iput-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 416
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_8

    .line 418
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 419
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 420
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 422
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 423
    const-string v5, "application/vnd.android.package-archive"

    .line 421
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 424
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_0

    .line 453
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 454
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 413
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 414
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 425
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_6
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 426
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_7

    .line 427
    new-instance v4, Lcom/aio/downloader/activity/AppSearchResultActivity$6;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppSearchResultActivity$6;-><init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 445
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppSearchResultActivity$6;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 447
    :cond_7
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 448
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 447
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 449
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 450
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_0

    .line 457
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_8
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 459
    const-string v5, "com.freepezzle.hexcrush"

    .line 458
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 460
    .local v3, "intent5":Landroid/content/Intent;
    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 464
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_9
    iget v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mRandom:I

    const/4 v5, 0x3

    if-ne v4, v5, :cond_d

    .line 466
    :try_start_4
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 467
    const-string v5, "com.allinone.callerid"

    const/4 v6, 0x0

    .line 466
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 471
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_c

    .line 473
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 474
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 475
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 477
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 478
    const-string v5, "application/vnd.android.package-archive"

    .line 476
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 479
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 480
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_0

    .line 516
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 518
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 468
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 469
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 481
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_a
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_b

    .line 482
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_b

    .line 484
    new-instance v4, Lcom/aio/downloader/activity/AppSearchResultActivity$7;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppSearchResultActivity$7;-><init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 507
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppSearchResultActivity$7;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 510
    :cond_b
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 511
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 510
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 512
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.allinone.callerid"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 513
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 514
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_0

    .line 521
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 522
    const-string v5, "com.allinone.callerid"

    .line 521
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 523
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 524
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 526
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_d
    iget v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->mRandom:I

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 528
    :try_start_7
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 529
    const-string v5, "com.aioapp.battery"

    const/4 v6, 0x0

    .line 528
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 533
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_10

    .line 535
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 536
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 537
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 539
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 540
    const-string v5, "application/vnd.android.package-archive"

    .line 538
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 541
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 542
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_0

    .line 574
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 576
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 530
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 531
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 543
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_e
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_f

    .line 544
    iget-object v4, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_f

    .line 545
    new-instance v4, Lcom/aio/downloader/activity/AppSearchResultActivity$8;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppSearchResultActivity$8;-><init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 565
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppSearchResultActivity$8;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 567
    :cond_f
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 568
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 567
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 569
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.aioapp.battery"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 571
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 572
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_0

    .line 579
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_10
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 580
    const-string v5, "com.aioapp.battery"

    .line 579
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 581
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 582
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 611
    .end local v2    # "intent":Landroid/content/Intent;
    :sswitch_3
    new-instance v4, Landroid/content/Intent;

    .line 612
    const-class v5, Lcom/aio/downloader/activity/DownloadAppManager;

    invoke-direct {v4, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 611
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppSearchResultActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 332
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0702db -> :sswitch_0
        0x7f0703bf -> :sswitch_1
        0x7f0703c0 -> :sswitch_2
        0x7f0703c1 -> :sswitch_3
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 175
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 176
    const v2, 0x7f0300af

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity;->setContentView(I)V

    .line 178
    invoke-direct {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->init()V

    .line 181
    invoke-direct {p0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->buildListener()V

    .line 184
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 185
    .local v0, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v2, "showappsearch"

    invoke-virtual {v0, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 186
    iget-object v2, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->showappsearch:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v0}, Lcom/aio/downloader/activity/AppSearchResultActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 188
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 189
    .local v1, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v2, "hideappsearch"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 190
    iget-object v2, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->hideappsearch:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v1}, Lcom/aio/downloader/activity/AppSearchResultActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 192
    new-instance v2, Lcom/facebook/ads/NativeAd;

    .line 193
    const-string v3, "340186902832477_401790893338744"

    invoke-direct {v2, p0, v3}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 192
    iput-object v2, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    .line 194
    iget-object v2, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 195
    iget-object v2, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    sget-object v3, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v2, v3}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 196
    return-void
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 258
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 674
    return-void
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView_load;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView_load;

    .prologue
    const/4 v3, 0x0

    .line 680
    iget-object v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 681
    iget-object v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 682
    .local v0, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_next_page()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->next:I

    .line 686
    .end local v0    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 687
    iget v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->page:I

    .line 688
    new-instance v1, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;-><init>(Lcom/aio/downloader/activity/AppSearchResultActivity;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 693
    :goto_0
    return-void

    .line 690
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 325
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 326
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 327
    return-void
.end method

.method protected onResume()V
    .locals 7

    .prologue
    const/4 v1, 0x0

    .line 638
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 639
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 640
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 641
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    .line 642
    const-string v2, "download2.db"

    .line 641
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppSearchResultActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 642
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, p0, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 641
    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 643
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 644
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    move-object v2, v1

    move-object v5, v1

    .line 643
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->ds:Ljava/util/List;

    .line 645
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->ds:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v6

    .line 646
    .local v6, "number":I
    if-eqz v6, :cond_1

    .line 648
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 649
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 654
    :cond_0
    :goto_0
    return-void

    .line 650
    :cond_1
    if-nez v6, :cond_0

    .line 652
    iget-object v0, p0, Lcom/aio/downloader/activity/AppSearchResultActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/BadgeView;->hide()V

    goto :goto_0
.end method
