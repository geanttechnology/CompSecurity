.class public Lcom/aio/downloader/activity/FloatCleanerMaster;
.super Landroid/app/Activity;
.source "FloatCleanerMaster.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/facebook/ads/AdListener;


# instance fields
.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;

.field private CVlistener:Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private adulttopgift:Landroid/widget/ImageView;

.field private bglistener:Landroid/view/View$OnClickListener;

.field private cWidth:I

.field private clear_count:Landroid/widget/TextView;

.field private cm:Landroid/net/ConnectivityManager;

.field private current:I

.field private cv:Lcom/aio/downloader/views/ClearView;

.field private float_search_view:Lcom/aio/downloader/views/DeletableEditText;

.field private float_searchimg:Lcom/aio/downloader/views/LImageButton;

.field private hSpacing:I

.field private infos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Programe;",
            ">;"
        }
    .end annotation
.end field

.field private isfbshow:Z

.field private iv_airplane:Landroid/widget/ImageView;

.field private iv_auto_rotate:Landroid/widget/ImageView;

.field private iv_brightness:Landroid/widget/ImageView;

.field private iv_buletooth:Landroid/widget/ImageView;

.field private iv_cricle:Landroid/widget/ImageView;

.field private iv_flash:Landroid/widget/ImageView;

.field private iv_float_set:Landroid/widget/ImageView;

.field private iv_gps:Landroid/widget/ImageView;

.field private iv_sleep:Landroid/widget/ImageView;

.field private iv_vibaration:Landroid/widget/ImageView;

.field private iv_wifi:Landroid/widget/ImageView;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Programe;",
            ">;"
        }
    .end annotation
.end field

.field private ll_auto_rotate:Landroid/widget/LinearLayout;

.field private ll_brightness:Landroid/widget/LinearLayout;

.field private ll_flash:Landroid/widget/LinearLayout;

.field private ll_float_fun:Landroid/widget/LinearLayout;

.field private ll_float_gift:Landroid/widget/LinearLayout;

.field private ll_gps:Landroid/widget/LinearLayout;

.field private ll_sleep:Landroid/widget/LinearLayout;

.field private ll_wifi:Landroid/widget/LinearLayout;

.field private lv_float_recenct_app:Lcom/aio/downloader/views/HorizontalListView;

.field private mAudioManager:Landroid/media/AudioManager;

.field private mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

.field private mGridView:Landroid/widget/GridView;

.field private mRandom:I

.field private mScrollView:Landroid/widget/HorizontalScrollView;

.field private max:I

.field private nativeAdfb:Lcom/facebook/ads/NativeAd;

.field packageInfo:Landroid/content/pm/PackageInfo;

.field private state_blue:I

.field private tv_airplane:Landroid/widget/TextView;

.field private tv_auto_rotate:Landroid/widget/TextView;

.field private tv_buletooth:Landroid/widget/TextView;

.field private tv_flash:Landroid/widget/TextView;

.field private tv_gps:Landroid/widget/TextView;

.field private tv_vibaration:Landroid/widget/TextView;

.field private tv_wifi:Landroid/widget/TextView;

.field private wm:Landroid/net/wifi/WifiManager;

.field private y:I


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 73
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 76
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 77
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

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->PRO_DIR_FOME:Ljava/io/File;

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

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->PRO_DIR_TO:Ljava/io/File;

    .line 80
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 81
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

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->PRO_DIR:Ljava/io/File;

    .line 83
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 84
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 85
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 86
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCALLERDOWN:Ljava/io/File;

    .line 87
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 88
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 89
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 90
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCALLERAPK:Ljava/io/File;

    .line 92
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 93
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 94
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 95
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHSWF:Ljava/io/File;

    .line 96
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 97
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 98
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 99
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHAPK:Ljava/io/File;

    .line 102
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 103
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 104
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 105
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOBATTERY:Ljava/io/File;

    .line 106
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 107
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 108
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 109
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOBATTERYAPK:Ljava/io/File;

    .line 110
    iput v3, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mRandom:I

    .line 111
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 139
    iput v3, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->y:I

    .line 156
    const/16 v0, 0x78

    iput v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->cWidth:I

    .line 160
    const/16 v0, 0xa

    iput v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->hSpacing:I

    .line 162
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->infos:Ljava/util/List;

    .line 169
    iput-boolean v3, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->isfbshow:Z

    .line 1192
    new-instance v0, Lcom/aio/downloader/activity/FloatCleanerMaster$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster$1;-><init>(Lcom/aio/downloader/activity/FloatCleanerMaster;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->CVlistener:Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;

    .line 1272
    new-instance v0, Lcom/aio/downloader/activity/FloatCleanerMaster$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster$2;-><init>(Lcom/aio/downloader/activity/FloatCleanerMaster;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->bglistener:Landroid/view/View$OnClickListener;

    .line 73
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FloatCleanerMaster;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->clear_count:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/FloatCleanerMaster;)Lcom/aio/downloader/views/ClearView;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->cv:Lcom/aio/downloader/views/ClearView;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/util/List;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->list:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/FloatCleanerMaster;Landroid/content/Context;)I
    .locals 1

    .prologue
    .line 1206
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->formatMemory(Landroid/content/Context;)I

    move-result v0

    return v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/FloatCleanerMaster;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->adulttopgift:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/FloatCleanerMaster;)Z
    .locals 1

    .prologue
    .line 169
    iget-boolean v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->isfbshow:Z

    return v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/FloatCleanerMaster;I)V
    .locals 0

    .prologue
    .line 110
    iput p1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mRandom:I

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/FloatCleanerMaster;)I
    .locals 1

    .prologue
    .line 110
    iget v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mRandom:I

    return v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/FloatCleanerMaster;)Ljava/io/File;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method private dip2px(Landroid/content/Context;F)I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dpValue"    # F

    .prologue
    .line 1051
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v0, v1, Landroid/util/DisplayMetrics;->density:F

    .line 1052
    .local v0, "scale":F
    mul-float v1, p2, v0

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v1, v1

    return v1
.end method

.method private facebookad()V
    .locals 2

    .prologue
    .line 1310
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->adulttopgift:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 1311
    return-void
.end method

.method private findclick()V
    .locals 2

    .prologue
    .line 211
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_brightness:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 212
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_wifi:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 213
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_gps:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 214
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_flash:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 215
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_auto_rotate:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 216
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_sleep:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 218
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_float_fun:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 220
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->cv:Lcom/aio/downloader/views/ClearView;

    iget-object v1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->CVlistener:Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/ClearView;->SetonAngelchanged(Lcom/aio/downloader/views/ClearView$OnAngelChangeListener;)V

    .line 221
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->cv:Lcom/aio/downloader/views/ClearView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->formatMemory(Landroid/content/Context;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/ClearView;->setAngle(I)V

    .line 222
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->clear_count:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->bglistener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 224
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_float_set:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 226
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->adulttopgift:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/FloatCleanerMaster$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster$3;-><init>(Lcom/aio/downloader/activity/FloatCleanerMaster;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 499
    return-void
.end method

.method private formatMemory(Landroid/content/Context;)I
    .locals 8
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1208
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->totalMemory()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v4, v4, v6

    if-gez v4, :cond_0

    .line 1209
    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getTotalMemory2(Landroid/content/Context;)J

    move-result-wide v2

    .line 1213
    .local v2, "total":J
    :goto_0
    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getAvailMemory(Landroid/content/Context;)J

    move-result-wide v0

    .line 1214
    .local v0, "avail":J
    sub-long v4, v2, v0

    const-wide/16 v6, 0x168

    mul-long/2addr v4, v6

    div-long/2addr v4, v2

    long-to-int v4, v4

    return v4

    .line 1211
    .end local v0    # "avail":J
    .end local v2    # "total":J
    :cond_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->totalMemory()J

    move-result-wide v2

    .restart local v2    # "total":J
    goto :goto_0
.end method

.method public static getAirplaneMode(Landroid/content/Context;)Z
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1174
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string v4, "airplane_mode_on"

    .line 1173
    invoke-static {v3, v4, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    .line 1176
    .local v0, "isAirplaneMode":I
    if-ne v0, v1, :cond_0

    :goto_0
    return v1

    :cond_0
    move v1, v2

    goto :goto_0
.end method

.method private getScreenBrightness(Landroid/content/Context;)I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1106
    const/16 v0, 0xff

    .line 1109
    .local v0, "screenBrightness":I
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 1110
    const-string v2, "screen_brightness"

    .line 1108
    invoke-static {v1, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 1114
    :goto_0
    return v0

    .line 1111
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private getScreenMode(Landroid/content/Context;)I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1080
    const/4 v0, 0x0

    .line 1082
    .local v0, "screenMode":I
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 1083
    const-string v2, "screen_brightness_mode"

    .line 1082
    invoke-static {v1, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 1087
    :goto_0
    return v0

    .line 1084
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private getScreenOffTime(Landroid/content/Context;)I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1143
    const/4 v0, 0x0

    .line 1146
    .local v0, "screenOffTime":I
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 1147
    const-string v2, "screen_off_timeout"

    .line 1145
    invoke-static {v1, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 1151
    :goto_0
    return v0

    .line 1148
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private init()V
    .locals 2

    .prologue
    .line 503
    const v0, 0x7f0701b3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_brightness:Landroid/widget/ImageView;

    .line 504
    const v0, 0x7f0701b2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_brightness:Landroid/widget/LinearLayout;

    .line 505
    const v0, 0x7f0701b4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_wifi:Landroid/widget/LinearLayout;

    .line 506
    const v0, 0x7f0701b5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_wifi:Landroid/widget/ImageView;

    .line 507
    const v0, 0x7f0701b6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_wifi:Landroid/widget/TextView;

    .line 509
    const v0, 0x7f0701b7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_gps:Landroid/widget/LinearLayout;

    .line 510
    const v0, 0x7f0701b8

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_gps:Landroid/widget/ImageView;

    .line 511
    const v0, 0x7f0701b9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_gps:Landroid/widget/TextView;

    .line 513
    const v0, 0x7f0701ba

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_flash:Landroid/widget/LinearLayout;

    .line 514
    const v0, 0x7f0701bb

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_flash:Landroid/widget/ImageView;

    .line 515
    const v0, 0x7f0701bc

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_flash:Landroid/widget/TextView;

    .line 516
    const v0, 0x7f0701bd

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 517
    const v0, 0x7f0701be

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 519
    const v0, 0x7f0701bf

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_auto_rotate:Landroid/widget/LinearLayout;

    .line 520
    const v0, 0x7f0701c0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_auto_rotate:Landroid/widget/ImageView;

    .line 521
    const v0, 0x7f0701c1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_auto_rotate:Landroid/widget/TextView;

    .line 523
    const v0, 0x7f0701c2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_sleep:Landroid/widget/LinearLayout;

    .line 524
    const v0, 0x7f0701c3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    .line 526
    const v0, 0x7f0701c4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 527
    const v0, 0x7f0701c5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_vibaration:Landroid/widget/ImageView;

    .line 528
    const v0, 0x7f0701c6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_vibaration:Landroid/widget/TextView;

    .line 530
    const v0, 0x7f0701c7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 531
    const v0, 0x7f0701c8

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_airplane:Landroid/widget/ImageView;

    .line 532
    const v0, 0x7f0701c9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_airplane:Landroid/widget/TextView;

    .line 534
    const v0, 0x7f0701ca

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 535
    const v0, 0x7f0701cb

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_buletooth:Landroid/widget/ImageView;

    .line 536
    const v0, 0x7f0701cc

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_buletooth:Landroid/widget/TextView;

    .line 538
    const v0, 0x7f0701cd

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 540
    const v0, 0x7f0701af

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_float_fun:Landroid/widget/LinearLayout;

    .line 541
    const v0, 0x7f0701d3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/ClearView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->cv:Lcom/aio/downloader/views/ClearView;

    .line 542
    const v0, 0x7f0701d5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->clear_count:Landroid/widget/TextView;

    .line 544
    const v0, 0x7f0701cf

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 545
    const v0, 0x7f0701ce

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 546
    const v0, 0x7f0701d0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 548
    const v0, 0x7f0701d2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_float_set:Landroid/widget/ImageView;

    .line 549
    const v0, 0x7f0701d6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/HorizontalListView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->lv_float_recenct_app:Lcom/aio/downloader/views/HorizontalListView;

    .line 551
    const v0, 0x7f0701b0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->ll_float_gift:Landroid/widget/LinearLayout;

    .line 552
    const v0, 0x7f0701b1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->adulttopgift:Landroid/widget/ImageView;

    .line 553
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->adulttopgift:Landroid/widget/ImageView;

    const v1, 0x7f02008f

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 554
    const v0, 0x7f0701d4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_cricle:Landroid/widget/ImageView;

    .line 555
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_cricle:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->bglistener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 557
    const v0, 0x7f0701ad

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 558
    const v0, 0x7f0701ae

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 559
    return-void
.end method

.method private saveScreenBrightness(ILandroid/content/Context;)V
    .locals 3
    .param p1, "paramInt"    # I
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 1095
    :try_start_0
    invoke-virtual {p2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 1096
    const-string v2, "screen_brightness"

    .line 1095
    invoke-static {v1, v2, p1}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1100
    :goto_0
    return-void

    .line 1097
    :catch_0
    move-exception v0

    .line 1098
    .local v0, "localException":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private setScreenMode(ILandroid/content/Context;)V
    .locals 3
    .param p1, "paramInt"    # I
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 1068
    :try_start_0
    invoke-virtual {p2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 1069
    const-string v2, "screen_brightness_mode"

    .line 1068
    invoke-static {v1, v2, p1}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1073
    :goto_0
    return-void

    .line 1070
    :catch_0
    move-exception v0

    .line 1071
    .local v0, "localException":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private setScreenOffTime(ILandroid/content/Context;)V
    .locals 3
    .param p1, "paramInt"    # I
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 1159
    :try_start_0
    invoke-virtual {p2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 1160
    const-string v2, "screen_off_timeout"

    .line 1159
    invoke-static {v1, v2, p1}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1164
    :goto_0
    return-void

    .line 1161
    :catch_0
    move-exception v0

    .line 1162
    .local v0, "localException":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public clearMemory(Landroid/content/Context;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1260
    .line 1261
    const-string v3, "activity"

    invoke-virtual {p1, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 1260
    check-cast v0, Landroid/app/ActivityManager;

    .line 1262
    .local v0, "am":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v2

    .line 1263
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_1

    .line 1270
    return-void

    .line 1263
    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 1264
    .local v1, "app":Landroid/app/ActivityManager$RunningAppProcessInfo;
    iget v4, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I

    const/16 v5, 0x12c

    if-lt v4, v5, :cond_0

    .line 1265
    iget-object v4, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const-string v5, "com.evzapp.cleanmaster"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 1266
    iget-object v4, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 1267
    iget-object v4, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v0, v4}, Landroid/app/ActivityManager;->killBackgroundProcesses(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getAvailMemory(Landroid/content/Context;)J
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1251
    .line 1252
    const-string v2, "activity"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 1251
    check-cast v0, Landroid/app/ActivityManager;

    .line 1253
    .local v0, "am":Landroid/app/ActivityManager;
    new-instance v1, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v1}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 1254
    .local v1, "outInfo":Landroid/app/ActivityManager$MemoryInfo;
    invoke-virtual {v0, v1}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 1255
    iget-wide v2, v1, Landroid/app/ActivityManager$MemoryInfo;->availMem:J

    return-wide v2
.end method

.method public getFileSizes(Ljava/io/File;)J
    .locals 4
    .param p1, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 1181
    const-wide/16 v1, 0x0

    .line 1182
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1183
    const/4 v0, 0x0

    .line 1184
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 1185
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 1189
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 1187
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public getRunningProcess()Ljava/util/List;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Programe;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1002
    new-instance v4, Lcom/aio/downloader/model/PackagesInfo;

    invoke-direct {v4, p0}, Lcom/aio/downloader/model/PackagesInfo;-><init>(Landroid/content/Context;)V

    .line 1004
    .local v4, "pi":Lcom/aio/downloader/model/PackagesInfo;
    const-string v9, "activity"

    invoke-virtual {p0, v9}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 1006
    .local v0, "am":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v8

    .line 1008
    .local v8, "run":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 1009
    .local v5, "pm":Landroid/content/pm/PackageManager;
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 1011
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/Programe;>;"
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_1

    .line 1044
    return-object v3

    .line 1011
    :cond_1
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 1015
    .local v7, "ra":Landroid/app/ActivityManager$RunningAppProcessInfo;
    :try_start_0
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    .line 1016
    const/4 v11, 0x0

    .line 1015
    invoke-virtual {v5, v10, v11}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 1017
    .local v1, "appinfo":Landroid/content/pm/ApplicationInfo;
    iget v10, v1, Landroid/content/pm/ApplicationInfo;->flags:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    and-int/lit8 v10, v10, 0x1

    if-nez v10, :cond_0

    .line 1025
    .end local v1    # "appinfo":Landroid/content/pm/ApplicationInfo;
    :goto_1
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const-string v11, "system"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 1026
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const-string v11, "google"

    invoke-virtual {v10, v11}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 1027
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const-string v11, "android"

    invoke-virtual {v10, v11}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 1028
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    const-string v11, "com.android.phone"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 1029
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 1032
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v4, v10}, Lcom/aio/downloader/model/PackagesInfo;->getInfo(Ljava/lang/String;)Landroid/content/pm/ApplicationInfo;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 1035
    const-string v10, "toggletag"

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "toggletag="

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v12, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1036
    new-instance v6, Lcom/aio/downloader/model/Programe;

    invoke-direct {v6}, Lcom/aio/downloader/model/Programe;-><init>()V

    .line 1037
    .local v6, "pr":Lcom/aio/downloader/model/Programe;
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v4, v10}, Lcom/aio/downloader/model/PackagesInfo;->getInfo(Ljava/lang/String;)Landroid/content/pm/ApplicationInfo;

    move-result-object v10

    invoke-virtual {v10, v5}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v10

    invoke-virtual {v6, v10}, Lcom/aio/downloader/model/Programe;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 1038
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v4, v10}, Lcom/aio/downloader/model/PackagesInfo;->getInfo(Ljava/lang/String;)Landroid/content/pm/ApplicationInfo;

    move-result-object v10

    invoke-virtual {v10, v5}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v10

    invoke-interface {v10}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v10}, Lcom/aio/downloader/model/Programe;->setName(Ljava/lang/String;)V

    .line 1039
    iget-object v10, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v6, v10}, Lcom/aio/downloader/model/Programe;->setPackagename(Ljava/lang/String;)V

    .line 1040
    sget-object v10, Ljava/lang/System;->out:Ljava/io/PrintStream;

    iget-object v11, v7, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v4, v11}, Lcom/aio/downloader/model/PackagesInfo;->getInfo(Ljava/lang/String;)Landroid/content/pm/ApplicationInfo;

    move-result-object v11

    invoke-virtual {v11, v5}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v11

    .line 1041
    invoke-interface {v11}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v11

    .line 1040
    invoke-virtual {v10, v11}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 1042
    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 1020
    .end local v6    # "pr":Lcom/aio/downloader/model/Programe;
    :catch_0
    move-exception v2

    .line 1022
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_1
.end method

.method public getTotalMemory2(Landroid/content/Context;)J
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1241
    .line 1242
    const-string v2, "activity"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 1241
    check-cast v0, Landroid/app/ActivityManager;

    .line 1243
    .local v0, "activityManager":Landroid/app/ActivityManager;
    new-instance v1, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v1}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 1244
    .local v1, "memoryInfo":Landroid/app/ActivityManager$MemoryInfo;
    invoke-virtual {v0, v1}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 1246
    iget-wide v2, v1, Landroid/app/ActivityManager$MemoryInfo;->totalMem:J

    return-wide v2
.end method

.method public isOPen(Landroid/content/Context;)Z
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1124
    .line 1125
    const-string v3, "location"

    invoke-virtual {p1, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 1124
    check-cast v1, Landroid/location/LocationManager;

    .line 1128
    .local v1, "locationManager":Landroid/location/LocationManager;
    const-string v3, "gps"

    invoke-virtual {v1, v3}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    .line 1131
    .local v0, "gps":Z
    const-string v3, "network"

    invoke-virtual {v1, v3}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v2

    .line 1132
    .local v2, "network":Z
    if-nez v0, :cond_0

    if-eqz v2, :cond_1

    .line 1133
    :cond_0
    const/4 v3, 0x1

    .line 1136
    :goto_0
    return v3

    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 2
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 1294
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->adulttopgift:Landroid/widget/ImageView;

    const v1, 0x7f020090

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 1295
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 1
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 1300
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 1306
    :cond_0
    :goto_0
    return-void

    .line 1303
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 1304
    invoke-direct {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->facebookad()V

    .line 1305
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->isfbshow:Z

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 19
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 719
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getId()I

    move-result v15

    packed-switch v15, :pswitch_data_0

    .line 998
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 723
    :pswitch_1
    const-string v15, "floattag"

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "bright="

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 724
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 723
    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 725
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenMode(Landroid/content/Context;)I

    move-result v15

    const/16 v16, 0x1

    move/from16 v0, v16

    if-ne v15, v0, :cond_1

    .line 726
    const/4 v15, 0x0

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->setScreenMode(ILandroid/content/Context;)V

    .line 728
    const/16 v15, 0x3f

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->saveScreenBrightness(ILandroid/content/Context;)V

    .line 730
    :cond_1
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v15

    if-ltz v15, :cond_2

    .line 731
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v15

    const/16 v16, 0x40

    move/from16 v0, v16

    if-ge v15, v0, :cond_2

    .line 732
    const/16 v15, 0x40

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->saveScreenBrightness(ILandroid/content/Context;)V

    .line 733
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_brightness:Landroid/widget/ImageView;

    .line 734
    const v16, 0x7f0200a0

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto :goto_0

    .line 735
    :cond_2
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v15

    const/16 v16, 0x40

    move/from16 v0, v16

    if-lt v15, v0, :cond_3

    .line 736
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v15

    const/16 v16, 0x7f

    move/from16 v0, v16

    if-ge v15, v0, :cond_3

    .line 737
    const/16 v15, 0x7f

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->saveScreenBrightness(ILandroid/content/Context;)V

    .line 738
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_brightness:Landroid/widget/ImageView;

    .line 739
    const v16, 0x7f0200a1

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 740
    :cond_3
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v15

    const/16 v16, 0x7f

    move/from16 v0, v16

    if-lt v15, v0, :cond_4

    .line 741
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v15

    const/16 v16, 0xff

    move/from16 v0, v16

    if-ge v15, v0, :cond_4

    .line 742
    const/16 v15, 0xff

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->saveScreenBrightness(ILandroid/content/Context;)V

    .line 743
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_brightness:Landroid/widget/ImageView;

    .line 744
    const v16, 0x7f02009f

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 745
    :cond_4
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v15

    const/16 v16, 0xff

    move/from16 v0, v16

    if-ne v15, v0, :cond_0

    .line 746
    const/4 v15, 0x1

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->setScreenMode(ILandroid/content/Context;)V

    .line 747
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_brightness:Landroid/widget/ImageView;

    .line 748
    const v16, 0x7f0200a2

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 753
    :pswitch_2
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->wm:Landroid/net/wifi/WifiManager;

    invoke-virtual {v15}, Landroid/net/wifi/WifiManager;->getWifiState()I

    move-result v15

    const/16 v16, 0x1

    move/from16 v0, v16

    if-ne v15, v0, :cond_5

    .line 755
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->wm:Landroid/net/wifi/WifiManager;

    const/16 v16, 0x1

    invoke-virtual/range {v15 .. v16}, Landroid/net/wifi/WifiManager;->setWifiEnabled(Z)Z

    .line 756
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_wifi:Landroid/widget/ImageView;

    const v16, 0x7f0200b0

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 757
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_wifi:Landroid/widget/TextView;

    const v16, -0xde690d

    invoke-virtual/range {v15 .. v16}, Landroid/widget/TextView;->setTextColor(I)V

    .line 760
    :cond_5
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->wm:Landroid/net/wifi/WifiManager;

    invoke-virtual {v15}, Landroid/net/wifi/WifiManager;->getWifiState()I

    move-result v15

    const/16 v16, 0x3

    move/from16 v0, v16

    if-ne v15, v0, :cond_0

    .line 762
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->wm:Landroid/net/wifi/WifiManager;

    const/16 v16, 0x0

    invoke-virtual/range {v15 .. v16}, Landroid/net/wifi/WifiManager;->setWifiEnabled(Z)Z

    .line 763
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_wifi:Landroid/widget/ImageView;

    const v16, 0x7f0200af

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 764
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_wifi:Landroid/widget/TextView;

    const v16, -0x5e5049

    invoke-virtual/range {v15 .. v16}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 769
    :pswitch_3
    new-instance v7, Landroid/content/Intent;

    invoke-direct {v7}, Landroid/content/Intent;-><init>()V

    .line 770
    .local v7, "intent":Landroid/content/Intent;
    const-string v15, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-virtual {v7, v15}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 771
    const/high16 v15, 0x10000000

    invoke-virtual {v7, v15}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 773
    :try_start_0
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 775
    :catch_0
    move-exception v5

    .line 781
    .local v5, "ex":Landroid/content/ActivityNotFoundException;
    const-string v15, "android.settings.SETTINGS"

    invoke-virtual {v7, v15}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 783
    :try_start_1
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    .line 784
    :catch_1
    move-exception v15

    goto/16 :goto_0

    .line 789
    .end local v5    # "ex":Landroid/content/ActivityNotFoundException;
    .end local v7    # "intent":Landroid/content/Intent;
    :pswitch_4
    new-instance v11, Landroid/content/Intent;

    .line 790
    const-string v15, "android.settings.INTERNAL_STORAGE_SETTINGS"

    .line 789
    invoke-direct {v11, v15}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 791
    .local v11, "intent_flash":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v11}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 795
    .end local v11    # "intent_flash":Landroid/content/Intent;
    :pswitch_5
    :try_start_2
    new-instance v12, Landroid/content/Intent;

    invoke-direct {v12}, Landroid/content/Intent;-><init>()V

    .line 796
    .local v12, "intentcalculator":Landroid/content/Intent;
    const-string v15, "com.android.calculator2"

    .line 797
    const-string v16, "com.android.calculator2.Calculator"

    .line 796
    move-object/from16 v0, v16

    invoke-virtual {v12, v15, v0}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 798
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto/16 :goto_0

    .line 799
    .end local v12    # "intentcalculator":Landroid/content/Intent;
    :catch_2
    move-exception v4

    .line 801
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    .line 802
    const-string v16, "Your phone doesn\'t support."

    const/16 v17, 0x0

    .line 801
    invoke-static/range {v15 .. v17}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v15

    .line 803
    invoke-virtual {v15}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 808
    .end local v4    # "e":Ljava/lang/Exception;
    :pswitch_6
    new-instance v3, Landroid/content/Intent;

    const-string v15, "android.intent.action.SET_ALARM"

    invoke-direct {v3, v15}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 809
    .local v3, "alarms":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 813
    .end local v3    # "alarms":Landroid/content/Intent;
    :pswitch_7
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    .line 814
    invoke-virtual {v15}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v15

    .line 815
    const-string v16, "accelerometer_rotation"

    const/16 v17, 0x0

    .line 813
    invoke-static/range {v15 .. v17}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v15

    if-nez v15, :cond_6

    .line 816
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    .line 817
    invoke-virtual {v15}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v15

    .line 818
    const-string v16, "accelerometer_rotation"

    const/16 v17, 0x1

    .line 816
    invoke-static/range {v15 .. v17}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    .line 819
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_auto_rotate:Landroid/widget/ImageView;

    .line 820
    const v16, 0x7f0200a6

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 821
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_auto_rotate:Landroid/widget/TextView;

    const v16, -0xde690d

    invoke-virtual/range {v15 .. v16}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 823
    :cond_6
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    .line 824
    invoke-virtual {v15}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v15

    .line 825
    const-string v16, "accelerometer_rotation"

    const/16 v17, 0x0

    .line 823
    invoke-static/range {v15 .. v17}, Landroid/provider/Settings$System;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    .line 826
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_auto_rotate:Landroid/widget/ImageView;

    .line 827
    const v16, 0x7f0200a5

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 828
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_auto_rotate:Landroid/widget/TextView;

    const v16, -0x5e5049

    invoke-virtual/range {v15 .. v16}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 833
    :pswitch_8
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v15

    const v16, 0x927c0

    move/from16 v0, v16

    if-ne v15, v0, :cond_7

    .line 834
    const/16 v15, 0x3a98

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->setScreenOffTime(ILandroid/content/Context;)V

    .line 835
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v16, 0x7f0200a8

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 836
    :cond_7
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v15

    const/16 v16, 0x3a98

    move/from16 v0, v16

    if-ne v15, v0, :cond_8

    .line 837
    const/16 v15, 0x7530

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->setScreenOffTime(ILandroid/content/Context;)V

    .line 838
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v16, 0x7f0200ab

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 839
    :cond_8
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v15

    const/16 v16, 0x7530

    move/from16 v0, v16

    if-ne v15, v0, :cond_9

    .line 840
    const v15, 0xea60

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->setScreenOffTime(ILandroid/content/Context;)V

    .line 841
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v16, 0x7f0200a9

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 842
    :cond_9
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v15

    const v16, 0xea60

    move/from16 v0, v16

    if-ne v15, v0, :cond_a

    .line 843
    const v15, 0x1d4c0

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->setScreenOffTime(ILandroid/content/Context;)V

    .line 844
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v16, 0x7f0200aa

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 845
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v15

    const v16, 0x1d4c0

    move/from16 v0, v16

    if-ne v15, v0, :cond_b

    .line 846
    const v15, 0x493e0

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->setScreenOffTime(ILandroid/content/Context;)V

    .line 847
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v16, 0x7f0200ac

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 848
    :cond_b
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    move-object/from16 v0, p0

    invoke-direct {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v15

    const v16, 0x493e0

    move/from16 v0, v16

    if-ne v15, v0, :cond_0

    .line 849
    const v15, 0x927c0

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v15, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->setScreenOffTime(ILandroid/content/Context;)V

    .line 850
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v16, 0x7f0200a7

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 857
    :pswitch_9
    move-object/from16 v0, p0

    iget v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->y:I

    const/16 v16, 0x2

    move/from16 v0, v16

    if-ne v15, v0, :cond_c

    .line 858
    const/4 v15, 0x0

    move-object/from16 v0, p0

    iput v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->y:I

    .line 860
    :cond_c
    move-object/from16 v0, p0

    iget v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->y:I

    const/16 v16, 0x1

    move/from16 v0, v16

    if-ne v15, v0, :cond_d

    .line 861
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_vibaration:Landroid/widget/ImageView;

    .line 862
    const v16, 0x7f0200ae

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 863
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mAudioManager:Landroid/media/AudioManager;

    const/16 v16, 0x1

    invoke-virtual/range {v15 .. v16}, Landroid/media/AudioManager;->setRingerMode(I)V

    .line 864
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_vibaration:Landroid/widget/TextView;

    const v16, -0xde690d

    invoke-virtual/range {v15 .. v16}, Landroid/widget/TextView;->setTextColor(I)V

    .line 865
    const/4 v15, 0x2

    move-object/from16 v0, p0

    iput v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->y:I

    .line 867
    :cond_d
    move-object/from16 v0, p0

    iget v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->y:I

    if-nez v15, :cond_0

    .line 868
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_vibaration:Landroid/widget/ImageView;

    .line 869
    const v16, 0x7f0200ad

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 870
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mAudioManager:Landroid/media/AudioManager;

    const/16 v16, 0x2

    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->max:I

    move/from16 v17, v0

    .line 871
    move-object/from16 v0, p0

    iget v0, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->max:I

    move/from16 v18, v0

    .line 870
    invoke-virtual/range {v15 .. v18}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 872
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_vibaration:Landroid/widget/TextView;

    const v16, -0x5e5049

    invoke-virtual/range {v15 .. v16}, Landroid/widget/TextView;->setTextColor(I)V

    .line 873
    const/4 v15, 0x1

    move-object/from16 v0, p0

    iput v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->y:I

    goto/16 :goto_0

    .line 878
    :pswitch_a
    new-instance v10, Landroid/content/Intent;

    .line 879
    const-string v15, "android.settings.AIRPLANE_MODE_SETTINGS"

    .line 878
    invoke-direct {v10, v15}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 880
    .local v10, "intent_air":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 885
    .end local v10    # "intent_air":Landroid/content/Intent;
    :pswitch_b
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-nez v15, :cond_e

    .line 887
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    .line 888
    const-string v16, "This machine is not found bluetooth hardware or drivers\uff01"

    .line 889
    const/16 v17, 0x0

    .line 886
    invoke-static/range {v15 .. v17}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v15

    .line 889
    invoke-virtual {v15}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 891
    :cond_e
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v15}, Landroid/bluetooth/BluetoothAdapter;->getState()I

    move-result v14

    .line 892
    .local v14, "state_blue":I
    const/16 v15, 0xa

    if-ne v14, v15, :cond_f

    .line 893
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v15}, Landroid/bluetooth/BluetoothAdapter;->enable()Z

    .line 894
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_buletooth:Landroid/widget/ImageView;

    .line 895
    const v16, 0x7f02009e

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 896
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_buletooth:Landroid/widget/TextView;

    const v16, -0xde690d

    invoke-virtual/range {v15 .. v16}, Landroid/widget/TextView;->setTextColor(I)V

    .line 898
    :cond_f
    const/16 v15, 0xc

    if-ne v14, v15, :cond_0

    .line 899
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v15}, Landroid/bluetooth/BluetoothAdapter;->disable()Z

    .line 900
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_buletooth:Landroid/widget/ImageView;

    .line 901
    const v16, 0x7f02009d

    invoke-virtual/range {v15 .. v16}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 902
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_buletooth:Landroid/widget/TextView;

    const v16, -0x5e5049

    invoke-virtual/range {v15 .. v16}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 908
    .end local v14    # "state_blue":I
    :pswitch_c
    new-instance v6, Landroid/content/Intent;

    invoke-direct {v6}, Landroid/content/Intent;-><init>()V

    .line 909
    .local v6, "i":Landroid/content/Intent;
    const-string v15, "android.media.action.STILL_IMAGE_CAMERA"

    invoke-virtual {v6, v15}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 910
    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 917
    .end local v6    # "i":Landroid/content/Intent;
    :pswitch_d
    new-instance v15, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    .line 918
    const-class v17, Lcom/aio/downloader/cleaner/JunkActivity;

    invoke-direct/range {v15 .. v17}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 917
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 923
    :pswitch_e
    const/4 v13, 0x0

    .line 925
    .local v13, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_3
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v15

    .line 926
    const-string v16, "com.freepezzle.hexcrush"

    const/16 v17, 0x0

    invoke-virtual/range {v15 .. v17}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_3
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_3 .. :try_end_3} :catch_4

    move-result-object v13

    .line 930
    :goto_1
    if-nez v13, :cond_12

    .line 932
    :try_start_4
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v15}, Ljava/io/File;->exists()Z

    move-result v15

    if-eqz v15, :cond_10

    .line 933
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getFileSizes(Ljava/io/File;)J

    move-result-wide v15

    const-wide/32 v17, 0x19ee4c

    cmp-long v15, v15, v17

    if-ltz v15, :cond_10

    .line 934
    new-instance v2, Landroid/content/Intent;

    const-string v15, "android.intent.action.VIEW"

    invoke-direct {v2, v15}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 935
    .local v2, "aa":Landroid/content/Intent;
    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "file://"

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHAPK:Ljava/io/File;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v15

    .line 936
    const-string v16, "application/vnd.android.package-archive"

    .line 935
    move-object/from16 v0, v16

    invoke-virtual {v2, v15, v0}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 937
    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    goto/16 :goto_0

    .line 966
    .end local v2    # "aa":Landroid/content/Intent;
    :catch_3
    move-exception v4

    .line 967
    .restart local v4    # "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 927
    .end local v4    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v4

    .line 928
    .local v4, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v4}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 938
    .end local v4    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_10
    :try_start_5
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {v15}, Ljava/io/File;->exists()Z

    move-result v15

    if-eqz v15, :cond_11

    .line 939
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/activity/FloatCleanerMaster;->AIOCRUSHSWF:Ljava/io/File;

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getFileSizes(Ljava/io/File;)J

    move-result-wide v15

    const-wide/32 v17, 0x19ee4c

    cmp-long v15, v15, v17

    if-ltz v15, :cond_11

    .line 940
    new-instance v15, Lcom/aio/downloader/activity/FloatCleanerMaster$5;

    move-object/from16 v0, p0

    invoke-direct {v15, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster$5;-><init>(Lcom/aio/downloader/activity/FloatCleanerMaster;)V

    const/16 v16, 0x0

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v16, v0

    .line 958
    invoke-virtual/range {v15 .. v16}, Lcom/aio/downloader/activity/FloatCleanerMaster$5;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 960
    :cond_11
    new-instance v2, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    .line 961
    const-class v16, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 960
    move-object/from16 v0, v16

    invoke-direct {v2, v15, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 962
    .restart local v2    # "aa":Landroid/content/Intent;
    const-string v15, "myid"

    const-string v16, "com.freepezzle.hexcrush"

    move-object/from16 v0, v16

    invoke-virtual {v2, v15, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 963
    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_0

    .line 970
    .end local v2    # "aa":Landroid/content/Intent;
    :cond_12
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v15

    .line 971
    const-string v16, "com.freepezzle.hexcrush"

    .line 970
    invoke-virtual/range {v15 .. v16}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v9

    .line 972
    .local v9, "intent5":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 977
    .end local v9    # "intent5":Landroid/content/Intent;
    .end local v13    # "packageInfo":Landroid/content/pm/PackageInfo;
    :pswitch_f
    new-instance v15, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    .line 978
    const-class v17, Lcom/aio/downloader/activity/FunActivity1;

    invoke-direct/range {v15 .. v17}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 977
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 981
    :pswitch_10
    new-instance v15, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    .line 982
    const-class v17, Lcom/aio/downloader/activity/MySettingsActivity;

    invoke-direct/range {v15 .. v17}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 981
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 985
    :pswitch_11
    new-instance v8, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v15

    .line 986
    const-class v16, Lcom/aio/downloader/unstall/MyAppActivity;

    .line 985
    move-object/from16 v0, v16

    invoke-direct {v8, v15, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 987
    .local v8, "intent4":Landroid/content/Intent;
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 990
    .end local v8    # "intent4":Landroid/content/Intent;
    :pswitch_12
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->finish()V

    goto/16 :goto_0

    .line 993
    :pswitch_13
    new-instance v15, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v16

    const-class v17, Lcom/aio/downloader/activity/MySettingsActivity;

    invoke-direct/range {v15 .. v17}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/aio/downloader/activity/FloatCleanerMaster;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 719
    :pswitch_data_0
    .packed-switch 0x7f0701ad
        :pswitch_12
        :pswitch_13
        :pswitch_f
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_0
        :pswitch_0
        :pswitch_8
        :pswitch_0
        :pswitch_9
        :pswitch_0
        :pswitch_0
        :pswitch_a
        :pswitch_0
        :pswitch_0
        :pswitch_b
        :pswitch_0
        :pswitch_0
        :pswitch_c
        :pswitch_d
        :pswitch_11
        :pswitch_e
        :pswitch_0
        :pswitch_10
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x2

    .line 175
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 176
    const v0, 0x7f030042

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->setContentView(I)V

    .line 178
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "floatwindow_show"

    invoke-static {v0, v1}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 180
    invoke-direct {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->init()V

    .line 181
    invoke-direct {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->findclick()V

    .line 183
    new-instance v0, Lcom/facebook/ads/NativeAd;

    const-string v1, "340186902832477_401790893338744"

    invoke-direct {v0, p0, v1}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    .line 184
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0, p0}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 185
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    sget-object v1, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 188
    const-string v0, "wifi"

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->wm:Landroid/net/wifi/WifiManager;

    .line 189
    const-string v0, "connectivity"

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->cm:Landroid/net/ConnectivityManager;

    .line 192
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 193
    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .line 192
    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mAudioManager:Landroid/media/AudioManager;

    .line 194
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mAudioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v2}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->current:I

    .line 195
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mAudioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v2}, Landroid/media/AudioManager;->getStreamMaxVolume(I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->max:I

    .line 199
    :try_start_0
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    .line 200
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_0

    .line 201
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->mBluetoothAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->getState()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->state_blue:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 207
    :cond_0
    :goto_0
    return-void

    .line 203
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 1317
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 1058
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 1059
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 1060
    return-void
.end method

.method protected onResume()V
    .locals 13

    .prologue
    const/16 v12, 0x7f

    const/16 v11, 0x40

    const/4 v10, 0x1

    const v9, -0x5e5049

    const v8, -0xde690d

    .line 564
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 565
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 567
    const-string v5, "floattag"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "bright="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 568
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v5

    if-ne v5, v10, :cond_9

    .line 569
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_brightness:Landroid/widget/ImageView;

    .line 570
    const v6, 0x7f0200a2

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 586
    :cond_0
    :goto_0
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->wm:Landroid/net/wifi/WifiManager;

    invoke-virtual {v5}, Landroid/net/wifi/WifiManager;->getWifiState()I

    move-result v5

    if-ne v5, v10, :cond_1

    .line 588
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_wifi:Landroid/widget/ImageView;

    const v6, 0x7f0200af

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 589
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_wifi:Landroid/widget/TextView;

    invoke-virtual {v5, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 591
    :cond_1
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->wm:Landroid/net/wifi/WifiManager;

    invoke-virtual {v5}, Landroid/net/wifi/WifiManager;->getWifiState()I

    move-result v5

    const/4 v6, 0x3

    if-ne v5, v6, :cond_2

    .line 593
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_wifi:Landroid/widget/ImageView;

    const v6, 0x7f0200b0

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 594
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_wifi:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 598
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->isOPen(Landroid/content/Context;)Z

    move-result v5

    if-eqz v5, :cond_c

    .line 599
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_gps:Landroid/widget/ImageView;

    const v6, 0x7f020092

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 600
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_gps:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 608
    :goto_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    .line 609
    const-string v6, "accelerometer_rotation"

    const/4 v7, 0x0

    .line 607
    invoke-static {v5, v6, v7}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v5

    if-nez v5, :cond_d

    .line 610
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_auto_rotate:Landroid/widget/ImageView;

    .line 611
    const v6, 0x7f0200a5

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 612
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_auto_rotate:Landroid/widget/TextView;

    invoke-virtual {v5, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 619
    :goto_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v5

    const v6, 0x927c0

    if-ne v5, v6, :cond_e

    .line 620
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v6, 0x7f0200a7

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 633
    :cond_3
    :goto_3
    iget v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->current:I

    if-lez v5, :cond_4

    .line 634
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_vibaration:Landroid/widget/ImageView;

    .line 635
    const v6, 0x7f0200ad

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 636
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_vibaration:Landroid/widget/TextView;

    invoke-virtual {v5, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 638
    :cond_4
    iget v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->current:I

    if-nez v5, :cond_5

    .line 639
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_vibaration:Landroid/widget/ImageView;

    .line 640
    const v6, 0x7f0200ae

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 641
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_vibaration:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 644
    :cond_5
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getAirplaneMode(Landroid/content/Context;)Z

    move-result v5

    if-eqz v5, :cond_13

    .line 645
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_airplane:Landroid/widget/ImageView;

    .line 646
    const v6, 0x7f02009b

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 647
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_airplane:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 654
    :goto_4
    iget v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->state_blue:I

    const/16 v6, 0xa

    if-ne v5, v6, :cond_6

    .line 655
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_buletooth:Landroid/widget/ImageView;

    .line 656
    const v6, 0x7f02009d

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 657
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_buletooth:Landroid/widget/TextView;

    invoke-virtual {v5, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 659
    :cond_6
    iget v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->state_blue:I

    const/16 v6, 0xc

    if-ne v5, v6, :cond_7

    .line 660
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_buletooth:Landroid/widget/ImageView;

    .line 661
    const v6, 0x7f02009e

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 662
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_buletooth:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 665
    :cond_7
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getRunningProcess()Ljava/util/List;

    move-result-object v5

    iput-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->list:Ljava/util/List;

    .line 666
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->list:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-nez v5, :cond_8

    .line 667
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->infos:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 668
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 670
    .local v4, "pm":Landroid/content/pm/PackageManager;
    const/16 v5, 0x2000

    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v1

    .line 671
    .local v1, "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_5
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    if-lt v2, v5, :cond_14

    .line 685
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->infos:Ljava/util/List;

    iput-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->list:Ljava/util/List;

    .line 687
    .end local v1    # "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    .end local v2    # "i":I
    .end local v4    # "pm":Landroid/content/pm/PackageManager;
    :cond_8
    new-instance v0, Lcom/aio/downloader/adapter/ListAdapter;

    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->list:Ljava/util/List;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {v0, v5, v6}, Lcom/aio/downloader/adapter/ListAdapter;-><init>(Ljava/util/List;Landroid/content/Context;)V

    .line 688
    .local v0, "adapter":Lcom/aio/downloader/adapter/ListAdapter;
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->lv_float_recenct_app:Lcom/aio/downloader/views/HorizontalListView;

    invoke-virtual {v5, v0}, Lcom/aio/downloader/views/HorizontalListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 690
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->lv_float_recenct_app:Lcom/aio/downloader/views/HorizontalListView;

    new-instance v6, Lcom/aio/downloader/activity/FloatCleanerMaster$4;

    invoke-direct {v6, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster$4;-><init>(Lcom/aio/downloader/activity/FloatCleanerMaster;)V

    invoke-virtual {v5, v6}, Lcom/aio/downloader/views/HorizontalListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 714
    return-void

    .line 571
    .end local v0    # "adapter":Lcom/aio/downloader/adapter/ListAdapter;
    :cond_9
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v5

    if-lez v5, :cond_a

    .line 572
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v5

    if-gt v5, v11, :cond_a

    .line 573
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_brightness:Landroid/widget/ImageView;

    .line 574
    const v6, 0x7f0200a0

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 575
    :cond_a
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v5

    if-le v5, v11, :cond_b

    .line 576
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v5

    if-gt v5, v12, :cond_b

    .line 577
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_brightness:Landroid/widget/ImageView;

    .line 578
    const v6, 0x7f0200a1

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 579
    :cond_b
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v5

    if-le v5, v12, :cond_0

    .line 580
    invoke-direct {p0, p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenBrightness(Landroid/content/Context;)I

    move-result v5

    const/16 v6, 0xff

    if-gt v5, v6, :cond_0

    .line 581
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_brightness:Landroid/widget/ImageView;

    .line 582
    const v6, 0x7f02009f

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_0

    .line 602
    :cond_c
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_gps:Landroid/widget/ImageView;

    const v6, 0x7f020091

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 603
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_gps:Landroid/widget/TextView;

    invoke-virtual {v5, v9}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_1

    .line 614
    :cond_d
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_auto_rotate:Landroid/widget/ImageView;

    .line 615
    const v6, 0x7f0200a6

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 616
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_auto_rotate:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_2

    .line 621
    :cond_e
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v5

    const/16 v6, 0x3a98

    if-ne v5, v6, :cond_f

    .line 622
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v6, 0x7f0200a8

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 623
    :cond_f
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v5

    const/16 v6, 0x7530

    if-ne v5, v6, :cond_10

    .line 624
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v6, 0x7f0200ab

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 625
    :cond_10
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v5

    const v6, 0xea60

    if-ne v5, v6, :cond_11

    .line 626
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v6, 0x7f0200a9

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 627
    :cond_11
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v5

    const v6, 0x1d4c0

    if-ne v5, v6, :cond_12

    .line 628
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v6, 0x7f0200aa

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 629
    :cond_12
    invoke-virtual {p0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getScreenOffTime(Landroid/content/Context;)I

    move-result v5

    const v6, 0x493e0

    if-ne v5, v6, :cond_3

    .line 630
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_sleep:Landroid/widget/ImageView;

    const v6, 0x7f0200ac

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 649
    :cond_13
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->iv_airplane:Landroid/widget/ImageView;

    .line 650
    const v6, 0x7f02009a

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 651
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->tv_airplane:Landroid/widget/TextView;

    invoke-virtual {v5, v9}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_4

    .line 672
    .restart local v1    # "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    .restart local v2    # "i":I
    .restart local v4    # "pm":Landroid/content/pm/PackageManager;
    :cond_14
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/pm/ApplicationInfo;

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/pm/ApplicationInfo;

    iget v5, v5, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v5, v5, 0x1

    if-nez v5, :cond_15

    .line 673
    new-instance v3, Lcom/aio/downloader/model/Programe;

    invoke-direct {v3}, Lcom/aio/downloader/model/Programe;-><init>()V

    .line 674
    .local v3, "info":Lcom/aio/downloader/model/Programe;
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-interface {v5}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/aio/downloader/model/Programe;->setName(Ljava/lang/String;)V

    .line 675
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v5, v4}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/aio/downloader/model/Programe;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 676
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/pm/ApplicationInfo;

    iget-object v5, v5, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v3, v5}, Lcom/aio/downloader/model/Programe;->setPackagename(Ljava/lang/String;)V

    .line 677
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->infos:Ljava/util/List;

    invoke-interface {v5, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 678
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/pm/ApplicationInfo;

    iget-object v5, v5, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v6, "com.allinone.free"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_15

    .line 679
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/pm/ApplicationInfo;

    iget-object v5, v5, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    .line 680
    const-string v6, "com.aio.downloader"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_15

    .line 681
    iget-object v5, p0, Lcom/aio/downloader/activity/FloatCleanerMaster;->infos:Ljava/util/List;

    invoke-interface {v5, v3}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 671
    .end local v3    # "info":Lcom/aio/downloader/model/Programe;
    :cond_15
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_5
.end method

.method public totalMemory()J
    .locals 8

    .prologue
    .line 1219
    const/4 v0, 0x0

    .line 1221
    .local v0, "bf":Ljava/io/BufferedReader;
    :try_start_0
    new-instance v3, Ljava/io/FileReader;

    const-string v6, "/proc/meminfo"

    invoke-direct {v3, v6}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    .line 1222
    .local v3, "r":Ljava/io/FileReader;
    new-instance v1, Ljava/io/BufferedReader;

    invoke-direct {v1, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1223
    .end local v0    # "bf":Ljava/io/BufferedReader;
    .local v1, "bf":Ljava/io/BufferedReader;
    :try_start_1
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .line 1224
    .local v4, "re":Ljava/lang/String;
    const-string v6, "\\s+"

    invoke-virtual {v4, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 1225
    .local v5, "res":[Ljava/lang/String;
    const/4 v6, 0x1

    aget-object v6, v5, v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v6

    mul-int/lit16 v6, v6, 0x400

    int-to-long v6, v6

    .line 1229
    if-eqz v1, :cond_0

    .line 1231
    :try_start_2
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    :cond_0
    :goto_0
    move-object v0, v1

    .line 1237
    .end local v1    # "bf":Ljava/io/BufferedReader;
    .end local v3    # "r":Ljava/io/FileReader;
    .end local v4    # "re":Ljava/lang/String;
    .end local v5    # "res":[Ljava/lang/String;
    .restart local v0    # "bf":Ljava/io/BufferedReader;
    :goto_1
    return-wide v6

    .line 1232
    .end local v0    # "bf":Ljava/io/BufferedReader;
    .restart local v1    # "bf":Ljava/io/BufferedReader;
    .restart local v3    # "r":Ljava/io/FileReader;
    .restart local v4    # "re":Ljava/lang/String;
    .restart local v5    # "res":[Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 1233
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 1226
    .end local v1    # "bf":Ljava/io/BufferedReader;
    .end local v2    # "e":Ljava/io/IOException;
    .end local v3    # "r":Ljava/io/FileReader;
    .end local v4    # "re":Ljava/lang/String;
    .end local v5    # "res":[Ljava/lang/String;
    .restart local v0    # "bf":Ljava/io/BufferedReader;
    :catch_1
    move-exception v2

    .line 1227
    .restart local v2    # "e":Ljava/io/IOException;
    :goto_2
    :try_start_3
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1229
    if-eqz v0, :cond_1

    .line 1231
    :try_start_4
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 1237
    :cond_1
    :goto_3
    const-wide/16 v6, 0x0

    goto :goto_1

    .line 1232
    :catch_2
    move-exception v2

    .line 1233
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_3

    .line 1228
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v6

    .line 1229
    :goto_4
    if-eqz v0, :cond_2

    .line 1231
    :try_start_5
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 1236
    :cond_2
    :goto_5
    throw v6

    .line 1232
    :catch_3
    move-exception v2

    .line 1233
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_5

    .line 1228
    .end local v0    # "bf":Ljava/io/BufferedReader;
    .end local v2    # "e":Ljava/io/IOException;
    .restart local v1    # "bf":Ljava/io/BufferedReader;
    .restart local v3    # "r":Ljava/io/FileReader;
    :catchall_1
    move-exception v6

    move-object v0, v1

    .end local v1    # "bf":Ljava/io/BufferedReader;
    .restart local v0    # "bf":Ljava/io/BufferedReader;
    goto :goto_4

    .line 1226
    .end local v0    # "bf":Ljava/io/BufferedReader;
    .restart local v1    # "bf":Ljava/io/BufferedReader;
    :catch_4
    move-exception v2

    move-object v0, v1

    .end local v1    # "bf":Ljava/io/BufferedReader;
    .restart local v0    # "bf":Ljava/io/BufferedReader;
    goto :goto_2
.end method
