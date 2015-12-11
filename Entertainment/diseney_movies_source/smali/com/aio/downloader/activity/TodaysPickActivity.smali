.class public Lcom/aio/downloader/activity/TodaysPickActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "TodaysPickActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Lcom/aio/downloader/mydownload/ContentValue;
.implements Lcom/facebook/ads/AdListener;
.implements Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;
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

.field private adapter:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

.field private adulttopgift:Landroid/widget/ImageView;

.field private adulttopsearch:Lcom/aio/downloader/views/LImageButton;

.field private apptodown:Lcom/aio/downloader/views/LImageButton;

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

.field private handler:Landroid/os/Handler;

.field private hidetodayapp:Landroid/content/BroadcastReceiver;

.field private isfa:Z

.field private isfbshow:Z

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

.field private mRandom:I

.field private myjpush:I

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private nativeAdfb:Lcom/facebook/ads/NativeAd;

.field private next:I

.field packageInfo:Landroid/content/pm/PackageInfo;

.field private page:I

.field private progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private showtodayapp:Landroid/content/BroadcastReceiver;

.field private swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

.field private todayboolean:Ljava/lang/Boolean;

.field private todayfan:Lcom/aio/downloader/views/LImageButton;

.field private todayid:Ljava/lang/String;

.field private todaypicklv:Lcom/aio/downloader/refresh/PullableListView_load;


# direct methods
.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 54
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 57
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 58
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

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->PRO_DIR_FOME:Ljava/io/File;

    .line 59
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 60
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

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->PRO_DIR_TO:Ljava/io/File;

    .line 61
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 62
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

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->PRO_DIR:Ljava/io/File;

    .line 65
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 66
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 67
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 68
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCALLERDOWN:Ljava/io/File;

    .line 69
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 70
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 71
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 72
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCALLERAPK:Ljava/io/File;

    .line 74
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 75
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 76
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 77
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCRUSHSWF:Ljava/io/File;

    .line 78
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 79
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 80
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 81
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCRUSHAPK:Ljava/io/File;

    .line 84
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 85
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 86
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 87
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOBATTERY:Ljava/io/File;

    .line 88
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 89
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 90
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 91
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOBATTERYAPK:Ljava/io/File;

    .line 93
    iput v3, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->mRandom:I

    .line 94
    iput-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 98
    iput-object v5, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 99
    iput v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->page:I

    .line 100
    iput v4, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->next:I

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->list:Ljava/util/ArrayList;

    .line 106
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todayboolean:Ljava/lang/Boolean;

    .line 111
    iput-boolean v3, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->isfbshow:Z

    .line 116
    iput-boolean v3, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->isfa:Z

    .line 117
    iput-boolean v3, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->isshow:Z

    .line 121
    new-instance v0, Lcom/aio/downloader/activity/TodaysPickActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$1;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->handler:Landroid/os/Handler;

    .line 140
    new-instance v0, Lcom/aio/downloader/activity/TodaysPickActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$2;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->showtodayapp:Landroid/content/BroadcastReceiver;

    .line 148
    new-instance v0, Lcom/aio/downloader/activity/TodaysPickActivity$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$3;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->hidetodayapp:Landroid/content/BroadcastReceiver;

    .line 54
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    .line 560
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->list:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parsetodaypick(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 561
    iget v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->page:I

    if-ne v0, v3, :cond_0

    .line 562
    new-instance v0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    .line 563
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->list:Ljava/util/ArrayList;

    const-string v2, "todaypick"

    invoke-direct {v0, p0, v1, v2}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V

    .line 562
    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->adapter:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    .line 565
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 566
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->adapter:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    invoke-direct {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 565
    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 567
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todaypicklv:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 568
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todaypicklv:Lcom/aio/downloader/refresh/PullableListView_load;

    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView_load;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 571
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todaypicklv:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 572
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 573
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->adapter:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->notifyDataSetChanged()V

    .line 574
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/TodaysPickActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->adulttopgift:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/TodaysPickActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/activity/TodaysPickActivity;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todayid:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/TodaysPickActivity;)I
    .locals 1

    .prologue
    .line 99
    iget v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->page:I

    return v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/TodaysPickActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 559
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/TodaysPickActivity;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/TodaysPickActivity;)Z
    .locals 1

    .prologue
    .line 111
    iget-boolean v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->isfbshow:Z

    return v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/TodaysPickActivity;I)V
    .locals 0

    .prologue
    .line 93
    iput p1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->mRandom:I

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/TodaysPickActivity;)I
    .locals 1

    .prologue
    .line 93
    iget v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->mRandom:I

    return v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method private buildListener()V
    .locals 1

    .prologue
    .line 498
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todayfan:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 500
    return-void
.end method

.method private facebookad()V
    .locals 2

    .prologue
    .line 686
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->adulttopgift:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 687
    return-void
.end method

.method private facebookad_today()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 670
    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 671
    const v4, 0x7f03003e

    .line 670
    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 673
    .local v2, "viewtop":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todaypicklv:Lcom/aio/downloader/refresh/PullableListView_load;

    const/4 v4, 0x0

    invoke-virtual {v3, v2, v5, v4}, Lcom/aio/downloader/refresh/PullableListView_load;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 675
    const v3, 0x7f0701a6

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 674
    check-cast v1, Landroid/widget/ImageView;

    .line 677
    .local v1, "iv_fb_fragment":Landroid/widget/ImageView;
    iget-object v3, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 678
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 680
    iget-object v3, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v3, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 682
    return-void
.end method

.method private init()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 210
    const v0, 0x7f070102

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    .line 211
    const v0, 0x7f07006a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->adulttopgift:Landroid/widget/ImageView;

    .line 212
    const v0, 0x7f070104

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->apptodown:Lcom/aio/downloader/views/LImageButton;

    .line 213
    new-instance v0, Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->apptodown:Lcom/aio/downloader/views/LImageButton;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    .line 214
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->apptodown:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/TodaysPickActivity$5;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$5;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 223
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->adulttopsearch:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/TodaysPickActivity$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$6;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 232
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->adulttopgift:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/TodaysPickActivity$7;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$7;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 488
    const v0, 0x7f0703cd

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todayfan:Lcom/aio/downloader/views/LImageButton;

    .line 489
    const v0, 0x7f0703ce

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/refresh/PullableListView_load;

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todaypicklv:Lcom/aio/downloader/refresh/PullableListView_load;

    .line 490
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 491
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todaypicklv:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/refresh/PullableListView_load;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;)V

    .line 492
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todaypicklv:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v0, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    .line 493
    new-instance v0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V

    new-array v1, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 495
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
    .line 731
    const-wide/16 v1, 0x0

    .line 732
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 733
    const/4 v0, 0x0

    .line 734
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 735
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 739
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 737
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 5
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 630
    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 631
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v3, 0x7530

    add-long/2addr v1, v3

    .line 630
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 632
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->adulttopgift:Landroid/widget/ImageView;

    const v1, 0x7f0200d7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 633
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 2
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    const/4 v1, 0x1

    .line 638
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_2

    .line 640
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 662
    :cond_0
    :goto_0
    return-void

    .line 643
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 644
    invoke-direct {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->facebookad()V

    .line 645
    iput-boolean v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->isfbshow:Z

    goto :goto_0

    .line 646
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_0

    .line 647
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_0

    .line 652
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 656
    :try_start_0
    invoke-direct {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->facebookad_today()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 660
    :goto_1
    iput-boolean v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->isfa:Z

    goto :goto_0

    .line 657
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 504
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 520
    :goto_0
    return-void

    .line 506
    :pswitch_0
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todayboolean:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_0

    iget v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->myjpush:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 507
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 508
    const-class v2, Lcom/aio/downloader/activity/MyMainActivity;

    .line 507
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 509
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "acquire_url_start"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 510
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V

    .line 511
    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->finish()V

    goto :goto_0

    .line 514
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->finish()V

    goto :goto_0

    .line 504
    :pswitch_data_0
    .packed-switch 0x7f0703cd
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x0

    .line 159
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 160
    const v2, 0x7f0300b3

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->setContentView(I)V

    .line 162
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "todayid"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todayid:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 166
    :goto_0
    :try_start_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "todayboolean"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todayboolean:Ljava/lang/Boolean;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 171
    :goto_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "myjpush"

    invoke-virtual {v2, v3, v5}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->myjpush:I

    .line 173
    invoke-direct {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->init()V

    .line 174
    invoke-direct {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->buildListener()V

    .line 176
    new-instance v2, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "340186902832477_401790893338744"

    invoke-direct {v2, v3, v4}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    .line 177
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 178
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    sget-object v3, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v2, v3}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 180
    new-instance v2, Lcom/facebook/ads/NativeAd;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "340186902832477_388101491374351"

    invoke-direct {v2, v3, v4}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 181
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v2, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 182
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    sget-object v3, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v2, v3}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 185
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 186
    .local v0, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v2, "showtodayapp"

    invoke-virtual {v0, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 187
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->showtodayapp:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 189
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 190
    .local v1, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v2, "hidetodayapp"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 191
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->hidetodayapp:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v1}, Lcom/aio/downloader/activity/TodaysPickActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 192
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todaypicklv:Lcom/aio/downloader/refresh/PullableListView_load;

    new-instance v3, Lcom/aio/downloader/activity/TodaysPickActivity$4;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$4;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V

    invoke-virtual {v2, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 206
    return-void

    .line 167
    .end local v0    # "myIntentFilter2":Landroid/content/IntentFilter;
    .end local v1    # "myIntentFilter3":Landroid/content/IntentFilter;
    :catch_0
    move-exception v2

    goto :goto_1

    .line 163
    :catch_1
    move-exception v2

    goto/16 :goto_0
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 579
    return-void
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 693
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 697
    const/4 v1, 0x4

    if-ne p1, v1, :cond_0

    .line 698
    iget v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->myjpush:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 699
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 700
    const-class v2, Lcom/aio/downloader/activity/MyMainActivity;

    .line 699
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 701
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "acquire_url_start"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 702
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->startActivity(Landroid/content/Intent;)V

    .line 703
    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->finish()V

    .line 708
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    :goto_0
    invoke-super {p0, p1, p2}, Lcom/aio/downloader/mydownload/BaseActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v1

    return v1

    .line 705
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->finish()V

    goto :goto_0
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView_load;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView_load;

    .prologue
    const/4 v3, 0x0

    .line 715
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 716
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 717
    .local v0, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_next_page()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->next:I

    .line 721
    .end local v0    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 722
    iget v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->page:I

    .line 723
    new-instance v1, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 728
    :goto_0
    return-void

    .line 725
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->todaypicklv:Lcom/aio/downloader/refresh/PullableListView_load;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 623
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 624
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 625
    return-void
.end method

.method protected onResume()V
    .locals 7

    .prologue
    .line 584
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onResume()V

    .line 585
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 587
    :try_start_0
    new-instance v2, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/TodaysPickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 588
    const-string v4, "download2.db"

    .line 587
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/TodaysPickActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v4

    .line 588
    invoke-virtual {v4}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 587
    iput-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 589
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 590
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 589
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->ds:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 595
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->ds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v6

    .line 596
    .local v6, "number":I
    if-eqz v6, :cond_1

    .line 598
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 599
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->show()V

    .line 604
    :cond_0
    :goto_1
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 605
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/activity/TodaysPickActivity$8;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/TodaysPickActivity$8;-><init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V

    .line 617
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0xbb8

    const-wide/16 v4, 0x2710

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 618
    return-void

    .line 600
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    :cond_1
    if-nez v6, :cond_0

    .line 602
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->hide()V

    goto :goto_1

    .line 591
    .end local v6    # "number":I
    :catch_0
    move-exception v2

    goto :goto_0
.end method
