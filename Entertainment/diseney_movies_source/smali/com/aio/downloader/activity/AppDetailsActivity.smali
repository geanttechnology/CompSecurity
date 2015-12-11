.class public Lcom/aio/downloader/activity/AppDetailsActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "AppDetailsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/facebook/ads/AdListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;,
        Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;,
        Lcom/aio/downloader/activity/AppDetailsActivity$Myagv;,
        Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;,
        Lcom/aio/downloader/activity/AppDetailsActivity$Myagv2;
    }
.end annotation


# static fields
.field public static cookieManager:Ljava/net/CookieManager; = null

.field public static final secret:Ljava/lang/String; = "this_is_mobile_2014"


# instance fields
.field private final ACTION_NAME_UPDATE_UPDATE:Ljava/lang/String;

.field private AIOBATTERY:Ljava/io/File;

.field private AIOBATTERYAPK:Ljava/io/File;

.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private AIOCRUSHAPK:Ljava/io/File;

.field private AIOCRUSHSWF:Ljava/io/File;

.field private AIOFREE:Ljava/io/File;

.field private AIOFREEAPK:Ljava/io/File;

.field private final PDTPAUSE:Ljava/lang/String;

.field private final PDTSTART:Ljava/lang/String;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private adView:Lcom/facebook/ads/AdView;

.field private adapter:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private appIcon2:Landroid/graphics/drawable/Drawable;

.field private appName:Ljava/lang/String;

.field private app_ratingbar:Landroid/widget/RatingBar;

.field private appauthortitle:Landroid/widget/TextView;

.field private appdetail:Landroid/content/BroadcastReceiver;

.field private appdetailauthortitle:Landroid/widget/TextView;

.field private appdetaildown:Lcom/aio/downloader/views/LImageButton;

.field private appdetailgv:Landroid/widget/GridView;

.field private appdetailgvwyc1:Lcom/aio/downloader/views/MyGridView;

.field private appdetailgvwyc2:Lcom/aio/downloader/views/MyGridView;

.field private appdetailicon:Landroid/widget/ImageView;

.field private appdetailicon1:Landroid/widget/ImageView;

.field private appdetailratingbar:Landroid/widget/RatingBar;

.field private appdetailsearch:Lcom/aio/downloader/views/LImageButton;

.field private appdetailtitle:Landroid/widget/TextView;

.field private appdetailtitle1:Landroid/widget/TextView;

.field private appdetailtop:Landroid/widget/RelativeLayout;

.field private appicon:Landroid/widget/ImageView;

.field private apptitle:Landroid/widget/TextView;

.field private badgedownimg:Lcom/aio/downloader/views/BadgeView;

.field private banner:Landroid/widget/LinearLayout;

.field private banner_type_name:Ljava/lang/String;

.field private bt_caller:Landroid/widget/Button;

.field private bt_dea_download:Landroid/widget/Button;

.field private caocao:I

.field private date:Landroid/widget/TextView;

.field private db:Lnet/tsz/afinal/FinalDBChen;

.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

.field private default_options:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private delete:Landroid/content/BroadcastReceiver;

.field private desctv:Landroid/widget/TextView;

.field private detail:Landroid/widget/TextView;

.field private detailfan:Lcom/aio/downloader/views/LImageButton;

.field private detailline:Landroid/widget/LinearLayout;

.field private detaillinewyc1:Landroid/widget/LinearLayout;

.field private detaillinewyc2:Landroid/widget/LinearLayout;

.field private detailplaytop:Landroid/widget/ImageView;

.field private detailscroll:Landroid/widget/ScrollView;

.field private detailtogift:Landroid/widget/ImageView;

.field private detailtopre2:Landroid/widget/RelativeLayout;

.field private detailtoprel:Landroid/widget/RelativeLayout;

.field private device:Landroid/widget/TextView;

.field private downloadapk:Landroid/widget/TextView;

.field private downloadapk1:Landroid/widget/TextView;

.field private downloadapk_install:Landroid/widget/TextView;

.field private downloadapk_start:Landroid/widget/TextView;

.field private downloads:Landroid/widget/TextView;

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

.field private gvlist:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private gvlist1:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private gvlist2:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field handler:Landroid/os/Handler;

.field private hidegvappdetail:Landroid/content/BroadcastReceiver;

.field private id:Ljava/lang/String;

.field private imbdownurl:Ljava/lang/String;

.field private inflate:Landroid/view/LayoutInflater;

.field private inmobtop:Landroid/widget/RelativeLayout;

.field private intent_pause:Landroid/content/BroadcastReceiver;

.field private intent_start:Landroid/content/BroadcastReceiver;

.field private isfbshow:Z

.field private isshowinmobi:Z

.field private iv_del_fb_yuansheng:Landroid/widget/ImageView;

.field private iv_del_fb_yuansheng1:Landroid/widget/ImageView;

.field private linkurl1:Ljava/lang/String;

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

.field private ll_dea_download:Landroid/widget/LinearLayout;

.field private ll_dea_sh:Landroid/widget/LinearLayout;

.field private ll_free:Landroid/widget/RelativeLayout;

.field private ll_gall:Landroid/widget/LinearLayout;

.field private mAnimImageView:Landroid/widget/ImageView;

.field private mAnimation:Landroid/view/animation/Animation;

.field private mRandom:I

.field private model:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field private myUpver:Ljava/lang/String;

.field private myVer:Ljava/lang/String;

.field private mygallery:Lcom/aio/downloader/views/HorizontalListView;

.field private myjpush:I

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private nativeAdfb:Lcom/facebook/ads/NativeAd;

.field packageInfo:Landroid/content/pm/PackageInfo;

.field private pdt_del:Landroid/content/BroadcastReceiver;

.field private pdt_failure:Landroid/content/BroadcastReceiver;

.field private pdt_pro:I

.field private pdt_pro_cru:I

.field private pdt_progressBar1:Landroid/widget/ProgressBar;

.field private progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private rl_sad:Landroid/widget/RelativeLayout;

.field private rl_yuancheng:Landroid/widget/RelativeLayout;

.field private shoufengqing:Z

.field private showgvappdetail:Landroid/content/BroadcastReceiver;

.field private sp_config:Landroid/content/SharedPreferences;

.field private spnetworkre:Landroid/content/SharedPreferences;

.field private stringExtra:Ljava/lang/String;

.field private successful:Landroid/content/BroadcastReceiver;

.field private timer2:Ljava/util/Timer;

.field private topredetail:Landroid/widget/RelativeLayout;

.field private topredetailwyc1:Landroid/widget/RelativeLayout;

.field private topredetailwyc2:Landroid/widget/RelativeLayout;

.field private tuijianboolean:Ljava/lang/Boolean;

.field private tv_price:Landroid/widget/TextView;

.field private tv_rating_count:Landroid/widget/TextView;

.field private tv_readmore:Landroid/widget/TextView;

.field private tv_short_desc:Landroid/widget/TextView;

.field private typeFace:Landroid/graphics/Typeface;

.field private typeFace2:Landroid/graphics/Typeface;

.field private version:Landroid/widget/TextView;

.field private view1:Landroid/view/View;

.field private view2:Landroid/view/View;

.field private view3:Landroid/view/View;

.field private view4:Landroid/view/View;

.field private widgetdetailfan:Z

.field private wocao:I

.field private wycmyid:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 91
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 93
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 94
    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "freestore.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOFREE:Ljava/io/File;

    .line 95
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 96
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 97
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 98
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "freestore.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOFREEAPK:Ljava/io/File;

    .line 100
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 101
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 102
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 103
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCALLERDOWN:Ljava/io/File;

    .line 104
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 105
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 106
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 107
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCALLERAPK:Ljava/io/File;

    .line 109
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 110
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 111
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 112
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHSWF:Ljava/io/File;

    .line 114
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 115
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 116
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 117
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "crush.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHAPK:Ljava/io/File;

    .line 120
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 121
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 122
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 123
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOBATTERY:Ljava/io/File;

    .line 124
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 125
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 126
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 127
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "battery.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOBATTERYAPK:Ljava/io/File;

    .line 129
    iput v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mRandom:I

    .line 131
    const-string v0, "pdtpause"

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PDTPAUSE:Ljava/lang/String;

    .line 132
    const-string v0, "pdtstart"

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PDTSTART:Ljava/lang/String;

    .line 133
    const/16 v0, 0x5a

    iput v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_pro:I

    .line 134
    iput v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_pro_cru:I

    .line 138
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$1;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->showgvappdetail:Landroid/content/BroadcastReceiver;

    .line 146
    const-string v0, "setbroadUpdate"

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ACTION_NAME_UPDATE_UPDATE:Ljava/lang/String;

    .line 148
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$2;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->hidegvappdetail:Landroid/content/BroadcastReceiver;

    .line 156
    iput-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 163
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$3;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->successful:Landroid/content/BroadcastReceiver;

    .line 177
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$4;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$4;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->delete:Landroid/content/BroadcastReceiver;

    .line 192
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$5;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$5;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_del:Landroid/content/BroadcastReceiver;

    .line 205
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$6;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$6;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_failure:Landroid/content/BroadcastReceiver;

    .line 218
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$7;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$7;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->intent_start:Landroid/content/BroadcastReceiver;

    .line 226
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$8;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$8;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->intent_pause:Landroid/content/BroadcastReceiver;

    .line 235
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$9;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$9;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetail:Landroid/content/BroadcastReceiver;

    .line 267
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$10;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$10;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->handler:Landroid/os/Handler;

    .line 386
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->tuijianboolean:Ljava/lang/Boolean;

    .line 389
    iput-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 394
    iput-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 403
    iput-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->sp_config:Landroid/content/SharedPreferences;

    .line 413
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->shoufengqing:Z

    .line 422
    iput-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->typeFace:Landroid/graphics/Typeface;

    .line 428
    iput-boolean v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->widgetdetailfan:Z

    .line 430
    iput-boolean v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->isfbshow:Z

    .line 438
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 439
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

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PRO_DIR_FOME:Ljava/io/File;

    .line 440
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 441
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

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PRO_DIR_TO:Ljava/io/File;

    .line 442
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 443
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

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PRO_DIR:Ljava/io/File;

    .line 2272
    iput-boolean v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->isshowinmobi:Z

    .line 2307
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->linkurl1:Ljava/lang/String;

    .line 2309
    iput v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->wocao:I

    .line 91
    return-void
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 2019
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 2020
    const v1, 0x7f0b0034

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 2021
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 2022
    const-string v1, "Ok"

    .line 2023
    new-instance v2, Lcom/aio/downloader/activity/AppDetailsActivity$32;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$32;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    .line 2022
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 2029
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 2031
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 2250
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist:Ljava/util/ArrayList;

    .line 2251
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseApplist(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 2252
    new-instance v0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist:Ljava/util/ArrayList;

    .line 2253
    const-string v3, "appdetail"

    invoke-direct {v0, v1, v2, v3}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V

    .line 2252
    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->adapter:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    .line 2254
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailgv:Landroid/widget/GridView;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->adapter:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    invoke-virtual {v0, v1}, Landroid/widget/GridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 2262
    return-void
.end method

.method private ShowResult1(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 2235
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist1:Ljava/util/ArrayList;

    .line 2236
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist1:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseApplist(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 2237
    new-instance v0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist1:Ljava/util/ArrayList;

    .line 2238
    const-string v3, "appdetail"

    invoke-direct {v0, v1, v2, v3}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V

    .line 2237
    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->adapter:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    .line 2239
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailgvwyc1:Lcom/aio/downloader/views/MyGridView;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->adapter:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/MyGridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 2247
    return-void
.end method

.method private ShowResult2(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 2220
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist2:Ljava/util/ArrayList;

    .line 2221
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist2:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseApplist(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 2222
    new-instance v0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist2:Ljava/util/ArrayList;

    .line 2223
    const-string v3, "appdetail"

    invoke-direct {v0, v1, v2, v3}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V

    .line 2222
    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->adapter:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    .line 2224
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailgvwyc2:Lcom/aio/downloader/views/MyGridView;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->adapter:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/MyGridView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 2232
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 384
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 162
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->stringExtra:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/AppDetailsActivity;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 393
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 396
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ds:Ljava/util/List;

    return-void
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 396
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ds:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 405
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mAnimImageView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/view/animation/Animation;
    .locals 1

    .prologue
    .line 407
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mAnimation:Landroid/view/animation/Animation;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/views/BadgeView;
    .locals 1

    .prologue
    .line 408
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 2018
    invoke-direct {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->Mydialog()V

    return-void
.end method

.method static synthetic access$17(Lcom/aio/downloader/activity/AppDetailsActivity;)I
    .locals 1

    .prologue
    .line 2309
    iget v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->wocao:I

    return v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .locals 1

    .prologue
    .line 377
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 388
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_install:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 419
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailtogift:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$21(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 385
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->id:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$22(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 379
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->list:Ljava/util/ArrayList;

    return-void
.end method

.method static synthetic access$23(Lcom/aio/downloader/activity/AppDetailsActivity;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 377
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-void
.end method

.method static synthetic access$24(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 379
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$25(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 2305
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->rl_sad:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$26(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 394
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 2308
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$28(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appName:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$29(Lcom/aio/downloader/activity/AppDetailsActivity;Landroid/graphics/drawable/Drawable;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appIcon2:Landroid/graphics/drawable/Drawable;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 388
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk1:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$30(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 2310
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->myUpver:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$31(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appIcon2:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$32(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 2284
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->bt_dea_download:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$33(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 2302
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ll_dea_sh:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$34(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/views/HorizontalListView;
    .locals 1

    .prologue
    .line 383
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mygallery:Lcom/aio/downloader/views/HorizontalListView;

    return-object v0
.end method

.method static synthetic access$35(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 2313
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ll_gall:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$36(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/view/View;
    .locals 1

    .prologue
    .line 427
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->view1:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$37(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/view/View;
    .locals 1

    .prologue
    .line 427
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->view2:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$38(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 2282
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->tv_readmore:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$39(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 2318
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->rl_yuancheng:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 2314
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$40(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 2288
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ll_free:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$41(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ScrollView;
    .locals 1

    .prologue
    .line 421
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailscroll:Landroid/widget/ScrollView;

    return-object v0
.end method

.method static synthetic access$42(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 378
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method static synthetic access$43(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 364
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailicon:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$44(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 365
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailicon1:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$45(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 366
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailtitle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$46(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 367
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailtitle1:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$47(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 370
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailauthortitle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$48(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RatingBar;
    .locals 1

    .prologue
    .line 371
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailratingbar:Landroid/widget/RatingBar;

    return-object v0
.end method

.method static synthetic access$49(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 372
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->version:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 425
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailtopre2:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$50(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->date:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$51(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 373
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->device:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$52(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 375
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloads:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$53(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 376
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detail:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$54(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 2276
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->tv_rating_count:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$55(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 2280
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->tv_short_desc:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$56(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/graphics/Typeface;
    .locals 1

    .prologue
    .line 422
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->typeFace:Landroid/graphics/Typeface;

    return-object v0
.end method

.method static synthetic access$57(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/graphics/Typeface;
    .locals 1

    .prologue
    .line 422
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->typeFace2:Landroid/graphics/Typeface;

    return-object v0
.end method

.method static synthetic access$58(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 2278
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->tv_price:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$59(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 369
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailplaytop:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 424
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailtoprel:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$60(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 387
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$61(Lcom/aio/downloader/activity/AppDetailsActivity;Landroid/view/LayoutInflater;)V
    .locals 0

    .prologue
    .line 136
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->inflate:Landroid/view/LayoutInflater;

    return-void
.end method

.method static synthetic access$62(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/view/LayoutInflater;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->inflate:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method static synthetic access$63(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2249
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$64(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 426
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailline:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$65(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2234
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity;->ShowResult1(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$66(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 2290
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detaillinewyc1:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$67(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2219
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity;->ShowResult2(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$68(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 2296
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detaillinewyc2:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$69(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 380
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$70(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 381
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist1:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$71(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 382
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->gvlist2:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$72(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$73(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHSWF:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$74(Lcom/aio/downloader/activity/AppDetailsActivity;)I
    .locals 1

    .prologue
    .line 2311
    iget v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->caocao:I

    return v0
.end method

.method static synthetic access$75(Lcom/aio/downloader/activity/AppDetailsActivity;)I
    .locals 1

    .prologue
    .line 2317
    iget v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->myjpush:I

    return v0
.end method

.method static synthetic access$76(Lcom/aio/downloader/activity/AppDetailsActivity;)I
    .locals 1

    .prologue
    .line 134
    iget v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_pro_cru:I

    return v0
.end method

.method static synthetic access$77(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/util/Timer;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;

    return-void
.end method

.method static synthetic access$78(Lcom/aio/downloader/activity/AppDetailsActivity;)I
    .locals 1

    .prologue
    .line 133
    iget v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_pro:I

    return v0
.end method

.method static synthetic access$79(Lcom/aio/downloader/activity/AppDetailsActivity;I)V
    .locals 0

    .prologue
    .line 134
    iput p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_pro_cru:I

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 388
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_start:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$80(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2315
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->myVer:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$81(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->stringExtra:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$82(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 2315
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->myVer:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$83(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 2307
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->linkurl1:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$84(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 395
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->spnetworkre:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$85(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 1988
    invoke-direct {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->downwifi()V

    return-void
.end method

.method static synthetic access$86(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 392
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->default_options:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$87(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 389
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method static synthetic access$88(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 440
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$89(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 438
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/AppDetailsActivity;Lnet/tsz/afinal/FinalDBChen;)V
    .locals 0

    .prologue
    .line 393
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    return-void
.end method

.method static synthetic access$90(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 442
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PRO_DIR:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$91(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$92(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$93(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOBATTERY:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$94(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOBATTERYAPK:Ljava/io/File;

    return-object v0
.end method

.method private apprecentlistViewbottom()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 2640
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailscroll:Landroid/widget/ScrollView;

    .line 2641
    invoke-virtual {v1}, Landroid/widget/ScrollView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 2640
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 2643
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const/high16 v2, 0x42480000    # 50.0f

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    .line 2642
    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 2644
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailscroll:Landroid/widget/ScrollView;

    invoke-virtual {v1, v0}, Landroid/widget/ScrollView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 2646
    return-void
.end method

.method private buildListener()V
    .locals 2

    .prologue
    .line 1540
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->topredetail:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1541
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailtogift:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1542
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailsearch:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1543
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetaildown:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1544
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->topredetailwyc1:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1545
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->topredetailwyc2:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1547
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mAnimation:Landroid/view/animation/Animation;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$28;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$28;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 1568
    return-void
.end method

.method private downwifi()V
    .locals 4

    .prologue
    .line 1989
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    .line 1990
    const v3, 0x7f0c000e

    .line 1989
    invoke-direct {v0, p0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 1991
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 1992
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 1993
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 1994
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 1995
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/activity/AppDetailsActivity$30;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity$30;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2004
    new-instance v3, Lcom/aio/downloader/activity/AppDetailsActivity$31;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity$31;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2015
    return-void
.end method

.method public static drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 7
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v6, 0x0

    .line 2881
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v3

    .line 2883
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v4

    .line 2885
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v2

    const/4 v5, -0x1

    if-eq v2, v5, :cond_0

    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    .line 2879
    :goto_0
    invoke-static {v3, v4, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 2889
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 2893
    .local v1, "canvas":Landroid/graphics/Canvas;
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 2894
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v3

    .line 2893
    invoke-virtual {p0, v6, v6, v2, v3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 2896
    invoke-virtual {p0, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 2898
    return-object v0

    .line 2887
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "canvas":Landroid/graphics/Canvas;
    :cond_0
    sget-object v2, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    goto :goto_0
.end method

.method private facebookad()V
    .locals 2

    .prologue
    .line 446
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailtogift:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 447
    return-void
.end method

.method private facebookad_free()V
    .locals 3

    .prologue
    .line 484
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v1}, Lcom/facebook/ads/NativeAd;->getAdCoverImage()Lcom/facebook/ads/NativeAd$Image;

    move-result-object v0

    .line 485
    .local v0, "adCover":Lcom/facebook/ads/NativeAd$Image;
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->iv_del_fb_yuansheng:Landroid/widget/ImageView;

    invoke-static {v0, v1}, Lcom/facebook/ads/NativeAd;->downloadAndDisplayImage(Lcom/facebook/ads/NativeAd$Image;Landroid/widget/ImageView;)V

    .line 487
    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->iv_del_fb_yuansheng:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Lcom/facebook/ads/NativeAd;->registerViewForInteraction(Landroid/view/View;)V

    .line 489
    return-void
.end method

.method private failfile()V
    .locals 1

    .prologue
    .line 323
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$11;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$11;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->app_detail_handler:Landroid/os/Handler;

    .line 362
    return-void
.end method

.method private init()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 791
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "widgetdetailfan"

    invoke-virtual {v0, v1, v6}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->widgetdetailfan:Z

    .line 792
    const v0, 0x7f0700a2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailtoprel:Landroid/widget/RelativeLayout;

    .line 793
    const v0, 0x7f0700ac

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailtopre2:Landroid/widget/RelativeLayout;

    .line 794
    const v0, 0x7f0700c8

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailline:Landroid/widget/LinearLayout;

    .line 795
    const v0, 0x7f0700df

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->desctv:Landroid/widget/TextView;

    .line 796
    const v0, 0x7f0700b4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->view1:Landroid/view/View;

    .line 797
    const v0, 0x7f0700d7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->view2:Landroid/view/View;

    .line 798
    const v0, 0x7f0700de

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->view3:Landroid/view/View;

    .line 799
    const v0, 0x7f0700e1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->view4:Landroid/view/View;

    .line 800
    const v0, 0x7f0700b8

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ll_gall:Landroid/widget/LinearLayout;

    .line 802
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->desctv:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 803
    const v0, 0x7f0700c9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->topredetail:Landroid/widget/RelativeLayout;

    .line 804
    const v0, 0x7f07009b

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailtogift:Landroid/widget/ImageView;

    .line 805
    const v0, 0x7f07009d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailscroll:Landroid/widget/ScrollView;

    .line 806
    const v0, 0x7f0700cc

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/GridView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailgv:Landroid/widget/GridView;

    .line 808
    const v0, 0x7f07009a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailsearch:Lcom/aio/downloader/views/LImageButton;

    .line 809
    const v0, 0x7f07009c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetaildown:Lcom/aio/downloader/views/LImageButton;

    .line 810
    const v0, 0x7f070073

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mAnimImageView:Landroid/widget/ImageView;

    .line 811
    const v0, 0x7f0700c2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->inmobtop:Landroid/widget/RelativeLayout;

    .line 812
    const v0, 0x7f0700c4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->apptitle:Landroid/widget/TextView;

    .line 813
    const v0, 0x7f0700c6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appauthortitle:Landroid/widget/TextView;

    .line 814
    const v0, 0x7f0700c3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appicon:Landroid/widget/ImageView;

    .line 815
    const v0, 0x7f0700be

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->app_ratingbar:Landroid/widget/RatingBar;

    .line 816
    const v0, 0x7f0700a1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->rl_sad:Landroid/widget/RelativeLayout;

    .line 819
    const v0, 0x7f040007

    .line 818
    invoke-static {p0, v0}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mAnimation:Landroid/view/animation/Animation;

    .line 820
    new-instance v0, Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetaildown:Lcom/aio/downloader/views/LImageButton;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/views/BadgeView;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    .line 822
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p0}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 824
    const v0, 0x7f070098

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailfan:Lcom/aio/downloader/views/LImageButton;

    .line 825
    const v0, 0x7f070059

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->banner:Landroid/widget/LinearLayout;

    .line 826
    const-string v0, "banner_type"

    invoke-virtual {p0, v0, v6}, Lcom/aio/downloader/activity/AppDetailsActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->sp_config:Landroid/content/SharedPreferences;

    .line 831
    const v0, 0x7f07009f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->iv_del_fb_yuansheng:Landroid/widget/ImageView;

    .line 832
    const v0, 0x7f07009e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->rl_yuancheng:Landroid/widget/RelativeLayout;

    .line 833
    const v0, 0x7f0700a0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->iv_del_fb_yuansheng1:Landroid/widget/ImageView;

    .line 835
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->iv_del_fb_yuansheng1:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$18;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$18;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 897
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailfan:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$19;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$19;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 937
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->default_options:Ljava/util/HashMap;

    .line 938
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 939
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 940
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 941
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 943
    :try_start_0
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 944
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 943
    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 945
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 946
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 945
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ds:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 952
    :goto_0
    const-string v0, "network"

    invoke-virtual {p0, v0, v6}, Lcom/aio/downloader/activity/AppDetailsActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->spnetworkre:Landroid/content/SharedPreferences;

    .line 955
    :try_start_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 956
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 962
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 963
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 964
    const v0, 0x7f0700a3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailicon:Landroid/widget/ImageView;

    .line 965
    const v0, 0x7f0700ad

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailicon1:Landroid/widget/ImageView;

    .line 966
    const v0, 0x7f0700a4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailtitle:Landroid/widget/TextView;

    .line 967
    const v0, 0x7f0700ae

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailtitle1:Landroid/widget/TextView;

    .line 968
    const v0, 0x7f0700a5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailplaytop:Landroid/widget/ImageView;

    .line 969
    const v0, 0x7f0700a9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->device:Landroid/widget/TextView;

    .line 970
    const v0, 0x7f0700a6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailauthortitle:Landroid/widget/TextView;

    .line 971
    const v0, 0x7f0700a7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailratingbar:Landroid/widget/RatingBar;

    .line 972
    const v0, 0x7f0700d9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->version:Landroid/widget/TextView;

    .line 973
    const v0, 0x7f0700da

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->date:Landroid/widget/TextView;

    .line 974
    const v0, 0x7f0700dc

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloads:Landroid/widget/TextView;

    .line 975
    const v0, 0x7f0700e0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detail:Landroid/widget/TextView;

    .line 976
    const v0, 0x7f0700b9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/HorizontalListView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mygallery:Lcom/aio/downloader/views/HorizontalListView;

    .line 977
    const v0, 0x7f0700aa

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk:Landroid/widget/TextView;

    .line 978
    const v0, 0x7f0700b1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk1:Landroid/widget/TextView;

    .line 979
    const v0, 0x7f0700b2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_start:Landroid/widget/TextView;

    .line 980
    const v0, 0x7f0700b3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_install:Landroid/widget/TextView;

    .line 981
    const v0, 0x7f0700a8

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->tv_rating_count:Landroid/widget/TextView;

    .line 982
    const v0, 0x7f0700ab

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->tv_price:Landroid/widget/TextView;

    .line 983
    const v0, 0x7f0700b6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->tv_short_desc:Landroid/widget/TextView;

    .line 984
    const v0, 0x7f0700e3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->bt_dea_download:Landroid/widget/Button;

    .line 985
    const v0, 0x7f0700e2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ll_dea_download:Landroid/widget/LinearLayout;

    .line 986
    const v0, 0x7f0700cd

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detaillinewyc1:Landroid/widget/LinearLayout;

    .line 987
    const v0, 0x7f0700ce

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->topredetailwyc1:Landroid/widget/RelativeLayout;

    .line 988
    const v0, 0x7f0700d1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/MyGridView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailgvwyc1:Lcom/aio/downloader/views/MyGridView;

    .line 989
    const v0, 0x7f0700d2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detaillinewyc2:Landroid/widget/LinearLayout;

    .line 990
    const v0, 0x7f0700d3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->topredetailwyc2:Landroid/widget/RelativeLayout;

    .line 991
    const v0, 0x7f0700d6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/MyGridView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailgvwyc2:Lcom/aio/downloader/views/MyGridView;

    .line 992
    const v0, 0x7f0700b5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ll_dea_sh:Landroid/widget/LinearLayout;

    .line 993
    const v0, 0x7f0700ba

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ll_free:Landroid/widget/RelativeLayout;

    .line 994
    const v0, 0x7f0700bf

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->bt_caller:Landroid/widget/Button;

    .line 995
    const v0, 0x7f0700af

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_progressBar1:Landroid/widget/ProgressBar;

    .line 996
    const v0, 0x7f0700cb

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 997
    const v0, 0x7f0700d0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 998
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk1:Landroid/widget/TextView;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$20;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$20;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1015
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_start:Landroid/widget/TextView;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$21;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$21;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1055
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_install:Landroid/widget/TextView;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$22;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$22;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1119
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->bt_caller:Landroid/widget/Button;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$23;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$23;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1184
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ll_free:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$24;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$24;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1253
    const v0, 0x7f0700b7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->tv_readmore:Landroid/widget/TextView;

    .line 1254
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->tv_readmore:Landroid/widget/TextView;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$25;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$25;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1271
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->bt_dea_download:Landroid/widget/Button;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$26;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$26;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1405
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk:Landroid/widget/TextView;

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$27;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$27;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1536
    const v0, 0x7f070097

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailtop:Landroid/widget/RelativeLayout;

    .line 1537
    return-void

    .line 958
    :catch_0
    move-exception v0

    goto/16 :goto_1

    .line 948
    :catch_1
    move-exception v0

    goto/16 :goto_0
.end method

.method private installApk()V
    .locals 3

    .prologue
    .line 2728
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2730
    .local v0, "aa":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "cleaner.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 2731
    const-string v2, "application/vnd.android.package-archive"

    .line 2729
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 2732
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    .line 2733
    return-void
.end method


# virtual methods
.method public MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 10
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I

    .prologue
    const/4 v9, 0x0

    .line 1817
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 1819
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 1820
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 1822
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1824
    const-string v0, "Failed to connect server. Please try again."

    .line 1823
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 1825
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 1985
    :goto_0
    return-void

    .line 1828
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$29;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/activity/AppDetailsActivity$29;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 1982
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$29;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public MydownloadApk_Update(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/graphics/Bitmap;)V
    .locals 10
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I
    .param p5, "mIcon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 2737
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 2739
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 2740
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 2742
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2744
    const-string v0, "Failed to connect server. Please try again."

    .line 2745
    const/4 v1, 0x0

    .line 2743
    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 2745
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 2875
    :goto_0
    return-void

    .line 2748
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$38;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    move-object v9, p5

    invoke-direct/range {v0 .. v9}, Lcom/aio/downloader/activity/AppDetailsActivity$38;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILandroid/graphics/Bitmap;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 2873
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$38;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
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
    .line 2716
    const-wide/16 v1, 0x0

    .line 2717
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2718
    const/4 v0, 0x0

    .line 2719
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 2720
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 2724
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 2722
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public initView()V
    .locals 6

    .prologue
    .line 1574
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->initView()V

    .line 1577
    :try_start_0
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    new-instance v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 1578
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 1577
    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1583
    :goto_0
    return-void

    .line 1579
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onAdClicked(Lcom/facebook/ads/Ad;)V
    .locals 5
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 2668
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 2669
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v3, 0x7530

    add-long/2addr v1, v3

    .line 2668
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 2670
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailtogift:Landroid/widget/ImageView;

    const v1, 0x7f0200d7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 2671
    return-void
.end method

.method public onAdLoaded(Lcom/facebook/ads/Ad;)V
    .locals 3
    .param p1, "ad"    # Lcom/facebook/ads/Ad;

    .prologue
    .line 2675
    const-string v0, "qwer"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Ad="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2676
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_2

    .line 2677
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    if-eq v0, p1, :cond_1

    .line 2702
    :cond_0
    :goto_0
    return-void

    .line 2680
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 2681
    invoke-direct {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->facebookad()V

    .line 2682
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->isfbshow:Z

    .line 2683
    const-string v0, "qwer"

    const-string v1, "onAdLoaded"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2685
    const-string v0, "qwer"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "nativeAd="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 2686
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_0

    .line 2687
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    if-ne v0, p1, :cond_0

    .line 2692
    const-string v0, "qwer"

    const-string v1, "onAdLoaded_nativeAd"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2693
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    invoke-virtual {v0}, Lcom/facebook/ads/NativeAd;->unregisterView()V

    .line 2694
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->iv_del_fb_yuansheng:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2695
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->iv_del_fb_yuansheng1:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2696
    invoke-direct {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->facebookad_free()V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 2323
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v4

    sparse-switch v4, :sswitch_data_0

    .line 2637
    :cond_0
    :goto_0
    return-void

    .line 2325
    :sswitch_0
    new-instance v4, Landroid/content/Intent;

    .line 2326
    const-class v5, Lcom/aio/downloader/activity/AppRecommendKeywordsActivity;

    invoke-direct {v4, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2325
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    .line 2327
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->finish()V

    goto :goto_0

    .line 2332
    :sswitch_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 2333
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x7530

    add-long/2addr v5, v7

    .line 2332
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 2334
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->detailtogift:Landroid/widget/ImageView;

    const v5, 0x7f0200d7

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 2335
    iget-boolean v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->isfbshow:Z

    if-eqz v4, :cond_1

    .line 2336
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "facebook"

    const/4 v6, 0x1

    invoke-static {v4, v5, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 2338
    :cond_1
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v4

    const-wide/high16 v6, 0x4010000000000000L    # 4.0

    mul-double/2addr v4, v6

    double-to-int v4, v4

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mRandom:I

    .line 2339
    iget v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mRandom:I

    const/4 v5, 0x1

    if-ne v4, v5, :cond_5

    .line 2342
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 2344
    const-string v5, "com.evzapp.cleanmaster"

    const/4 v6, 0x0

    .line 2343
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    .line 2342
    iput-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 2348
    :goto_1
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_4

    .line 2349
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PRO_DIR_FOME:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 2350
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2352
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 2353
    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 2354
    const-string v5, "cleaner.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 2352
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 2355
    const-string v5, "application/vnd.android.package-archive"

    .line 2351
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 2356
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2357
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2345
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_0
    move-exception v1

    .line 2346
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 2358
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->PRO_DIR_TO:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 2359
    new-instance v4, Lcom/aio/downloader/activity/AppDetailsActivity$34;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$34;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 2385
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppDetailsActivity$34;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 2387
    :cond_3
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 2388
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 2387
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2389
    .local v2, "intent":Landroid/content/Intent;
    const-string v4, "myid"

    .line 2390
    const-string v5, "com.evzapp.cleanmaster"

    .line 2389
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2391
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2392
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2395
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_4
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 2397
    const-string v5, "com.evzapp.cleanmaster"

    .line 2396
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 2398
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2399
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2401
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_5
    iget v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mRandom:I

    const/4 v5, 0x2

    if-ne v4, v5, :cond_9

    .line 2403
    :try_start_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 2404
    const-string v5, "com.freepezzle.hexcrush"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    .line 2403
    iput-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 2408
    :goto_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_8

    .line 2410
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 2411
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_6

    .line 2412
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2414
    .restart local v0    # "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHAPK:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 2415
    const-string v5, "application/vnd.android.package-archive"

    .line 2413
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 2416
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_0

    .line 2445
    .end local v0    # "aa":Landroid/content/Intent;
    :catch_1
    move-exception v1

    .line 2446
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 2405
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 2406
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 2417
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_6
    :try_start_3
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 2418
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCRUSHSWF:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x19ee4c

    cmp-long v4, v4, v6

    if-ltz v4, :cond_7

    .line 2419
    new-instance v4, Lcom/aio/downloader/activity/AppDetailsActivity$35;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$35;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 2437
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppDetailsActivity$35;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 2439
    :cond_7
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 2440
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 2439
    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2441
    .restart local v0    # "aa":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.freepezzle.hexcrush"

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2442
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_0

    .line 2449
    .end local v0    # "aa":Landroid/content/Intent;
    :cond_8
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 2451
    const-string v5, "com.freepezzle.hexcrush"

    .line 2450
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    .line 2452
    .local v3, "intent5":Landroid/content/Intent;
    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2456
    .end local v3    # "intent5":Landroid/content/Intent;
    :cond_9
    iget v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mRandom:I

    const/4 v5, 0x3

    if-ne v4, v5, :cond_d

    .line 2458
    :try_start_4
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 2459
    const-string v5, "com.allinone.callerid"

    const/4 v6, 0x0

    .line 2458
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_4

    .line 2463
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_c

    .line 2465
    :try_start_5
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_a

    .line 2466
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_a

    .line 2467
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2469
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCALLERAPK:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 2470
    const-string v5, "application/vnd.android.package-archive"

    .line 2468
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 2471
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2472
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto/16 :goto_0

    .line 2508
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_3
    move-exception v1

    .line 2510
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 2460
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v1

    .line 2461
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_3

    .line 2473
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_a
    :try_start_6
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_b

    .line 2474
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOCALLERDOWN:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x357458

    cmp-long v4, v4, v6

    if-ltz v4, :cond_b

    .line 2476
    new-instance v4, Lcom/aio/downloader/activity/AppDetailsActivity$36;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$36;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 2499
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppDetailsActivity$36;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 2502
    :cond_b
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 2503
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 2502
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2504
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.allinone.callerid"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2505
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2506
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto/16 :goto_0

    .line 2513
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_c
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 2514
    const-string v5, "com.allinone.callerid"

    .line 2513
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 2515
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2516
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2518
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_d
    iget v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->mRandom:I

    const/4 v5, 0x4

    if-ne v4, v5, :cond_0

    .line 2520
    :try_start_7
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 2521
    const-string v5, "com.aioapp.battery"

    const/4 v6, 0x0

    .line 2520
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_6

    .line 2525
    :goto_4
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->packageInfo:Landroid/content/pm/PackageInfo;

    if-nez v4, :cond_10

    .line 2527
    :try_start_8
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_e

    .line 2528
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_e

    .line 2529
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v2, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2531
    .restart local v2    # "intent":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOBATTERYAPK:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 2532
    const-string v5, "application/vnd.android.package-archive"

    .line 2530
    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 2533
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2534
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_0

    .line 2566
    .end local v2    # "intent":Landroid/content/Intent;
    :catch_5
    move-exception v1

    .line 2568
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 2522
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v1

    .line 2523
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_4

    .line 2535
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_e
    :try_start_9
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_f

    .line 2536
    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->AIOBATTERY:Ljava/io/File;

    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    const-wide/32 v6, 0x377eff

    cmp-long v4, v4, v6

    if-ltz v4, :cond_f

    .line 2537
    new-instance v4, Lcom/aio/downloader/activity/AppDetailsActivity$37;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$37;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Void;

    .line 2557
    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/AppDetailsActivity$37;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 2559
    :cond_f
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 2560
    const-class v5, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 2559
    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2561
    .restart local v2    # "intent":Landroid/content/Intent;
    const-string v4, "myid"

    const-string v5, "com.aioapp.battery"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2563
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2564
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto/16 :goto_0

    .line 2571
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_10
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 2572
    const-string v5, "com.aioapp.battery"

    .line 2571
    invoke-virtual {v4, v5}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    .line 2573
    .restart local v2    # "intent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 2574
    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2604
    .end local v2    # "intent":Landroid/content/Intent;
    :sswitch_2
    new-instance v4, Landroid/content/Intent;

    .line 2605
    const-class v5, Lcom/aio/downloader/activity/AppActivity1;

    invoke-direct {v4, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2604
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2609
    :sswitch_3
    new-instance v4, Landroid/content/Intent;

    .line 2610
    const-class v5, Lcom/aio/downloader/activity/DownloadAppManager;

    invoke-direct {v4, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2609
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    .line 2611
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->finish()V

    goto/16 :goto_0

    .line 2615
    :sswitch_4
    new-instance v4, Landroid/content/Intent;

    .line 2616
    const-class v5, Lcom/aio/downloader/activity/MusthaveActivity;

    invoke-direct {v4, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2615
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2619
    :sswitch_5
    new-instance v4, Landroid/content/Intent;

    .line 2620
    const-class v5, Lcom/aio/downloader/activity/PaidforFreeActivity1;

    invoke-direct {v4, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2619
    invoke-virtual {p0, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 2323
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f07009a -> :sswitch_0
        0x7f07009b -> :sswitch_1
        0x7f07009c -> :sswitch_3
        0x7f0700c9 -> :sswitch_2
        0x7f0700cb -> :sswitch_5
        0x7f0700d0 -> :sswitch_4
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 22
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 493
    invoke-super/range {p0 .. p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 494
    const v18, 0x7f030011

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->setContentView(I)V

    .line 495
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->setmContext(Landroid/content/Context;)V

    .line 496
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    const-string v18, "app_detail"

    sput-object v18, Lcom/aio/downloader/utils/Myutils;->type_current:Ljava/lang/String;

    .line 502
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "linkurl"

    invoke-virtual/range {v18 .. v19}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->linkurl1:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_9

    .line 508
    :goto_0
    :try_start_1
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "myid"

    invoke-virtual/range {v18 .. v19}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_8

    .line 514
    :goto_1
    :try_start_2
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "myupver"

    invoke-virtual/range {v18 .. v19}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->myUpver:Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_7

    .line 519
    :goto_2
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "wocao"

    const/16 v20, 0x0

    invoke-virtual/range {v18 .. v20}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->wocao:I

    .line 520
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "caocao"

    const/16 v20, 0x0

    invoke-virtual/range {v18 .. v20}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->caocao:I

    .line 521
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "myjpush"

    const/16 v20, 0x0

    invoke-virtual/range {v18 .. v20}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->myjpush:I

    .line 524
    new-instance v7, Landroid/content/IntentFilter;

    invoke-direct {v7}, Landroid/content/IntentFilter;-><init>()V

    .line 525
    .local v7, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v18, "appdetail"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 526
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetail:Landroid/content/BroadcastReceiver;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 530
    new-instance v8, Landroid/content/IntentFilter;

    invoke-direct {v8}, Landroid/content/IntentFilter;-><init>()V

    .line 531
    .local v8, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v18, "showgvappdetail"

    move-object/from16 v0, v18

    invoke-virtual {v8, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 532
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->showgvappdetail:Landroid/content/BroadcastReceiver;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 534
    new-instance v9, Landroid/content/IntentFilter;

    invoke-direct {v9}, Landroid/content/IntentFilter;-><init>()V

    .line 535
    .local v9, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v18, "hidegvappdetail"

    move-object/from16 v0, v18

    invoke-virtual {v9, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 536
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->hidegvappdetail:Landroid/content/BroadcastReceiver;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v9}, Lcom/aio/downloader/activity/AppDetailsActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 539
    new-instance v15, Landroid/content/IntentFilter;

    invoke-direct {v15}, Landroid/content/IntentFilter;-><init>()V

    .line 540
    .local v15, "myIntentFilter_success":Landroid/content/IntentFilter;
    const-string v18, "successful"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 541
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->successful:Landroid/content/BroadcastReceiver;

    move-object/from16 v19, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v0, v1, v15}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 545
    new-instance v14, Landroid/content/IntentFilter;

    invoke-direct {v14}, Landroid/content/IntentFilter;-><init>()V

    .line 546
    .local v14, "myIntentFilter_pdtdet":Landroid/content/IntentFilter;
    const-string v18, "pdt_del"

    move-object/from16 v0, v18

    invoke-virtual {v14, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 547
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    .line 548
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_del:Landroid/content/BroadcastReceiver;

    move-object/from16 v19, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v0, v1, v14}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 551
    new-instance v12, Landroid/content/IntentFilter;

    invoke-direct {v12}, Landroid/content/IntentFilter;-><init>()V

    .line 552
    .local v12, "myIntentFilter_intent_start":Landroid/content/IntentFilter;
    const-string v18, "intent_start"

    move-object/from16 v0, v18

    invoke-virtual {v12, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 553
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->intent_start:Landroid/content/BroadcastReceiver;

    move-object/from16 v19, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v0, v1, v12}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 557
    new-instance v11, Landroid/content/IntentFilter;

    invoke-direct {v11}, Landroid/content/IntentFilter;-><init>()V

    .line 558
    .local v11, "myIntentFilter_intent_pause":Landroid/content/IntentFilter;
    const-string v18, "intent_pause"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 559
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->intent_pause:Landroid/content/BroadcastReceiver;

    move-object/from16 v19, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v0, v1, v11}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 563
    new-instance v10, Landroid/content/IntentFilter;

    invoke-direct {v10}, Landroid/content/IntentFilter;-><init>()V

    .line 564
    .local v10, "myIntentFilter_delete":Landroid/content/IntentFilter;
    const-string v18, "delete"

    move-object/from16 v0, v18

    invoke-virtual {v10, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 565
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->delete:Landroid/content/BroadcastReceiver;

    move-object/from16 v19, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v0, v1, v10}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 568
    new-instance v13, Landroid/content/IntentFilter;

    invoke-direct {v13}, Landroid/content/IntentFilter;-><init>()V

    .line 569
    .local v13, "myIntentFilter_pdt_failure":Landroid/content/IntentFilter;
    const-string v18, "pdt_failure"

    move-object/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 570
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->pdt_failure:Landroid/content/BroadcastReceiver;

    move-object/from16 v19, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v0, v1, v13}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 573
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->init()V

    .line 574
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->buildListener()V

    .line 578
    :try_start_3
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->initView()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 583
    :goto_3
    :try_start_4
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "myid"

    invoke-virtual/range {v18 .. v19}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->id:Ljava/lang/String;

    .line 584
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "tuijianboolean"

    .line 585
    const/16 v20, 0x0

    .line 584
    invoke-virtual/range {v18 .. v20}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v18

    invoke-static/range {v18 .. v18}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->tuijianboolean:Ljava/lang/Boolean;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_6

    .line 589
    :goto_4
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/aio/downloader/utils/publicTools;->isNetworkAvailable(Landroid/content/Context;)Z

    move-result v18

    if-eqz v18, :cond_0

    .line 591
    :try_start_5
    new-instance v18, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    const/16 v19, 0x0

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 592
    new-instance v18, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv2;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv2;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    const/16 v19, 0x0

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 593
    new-instance v18, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    const/16 v19, 0x0

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 594
    new-instance v18, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    const/16 v19, 0x0

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Lcom/aio/downloader/activity/AppDetailsActivity$Myagv;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0

    .line 600
    :cond_0
    :goto_5
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->failfile()V

    .line 604
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->sp_config:Landroid/content/SharedPreferences;

    move-object/from16 v18, v0

    const-string v19, "banner_type"

    const-string v20, "admob"

    invoke-interface/range {v18 .. v20}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->banner_type_name:Ljava/lang/String;

    .line 606
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->banner_type_name:Ljava/lang/String;

    move-object/from16 v18, v0

    const-string v19, "admob"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_1

    .line 607
    new-instance v5, Lcom/google/ads/AdView;

    .line 609
    sget-object v18, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 610
    const-string v19, "ca-app-pub-2192624499353475/5842010949"

    .line 607
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-direct {v5, v0, v1, v2}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 611
    .local v5, "adView":Lcom/google/ads/AdView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->banner:Landroid/widget/LinearLayout;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 612
    new-instance v18, Lcom/google/ads/AdRequest;

    invoke-direct/range {v18 .. v18}, Lcom/google/ads/AdRequest;-><init>()V

    move-object/from16 v0, v18

    invoke-virtual {v5, v0}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 616
    .end local v5    # "adView":Lcom/google/ads/AdView;
    :cond_1
    :try_start_6
    new-instance v18, Lcom/facebook/ads/AdView;

    .line 617
    const-string v19, "340186902832477_407365439447956"

    sget-object v20, Lcom/facebook/ads/AdSize;->BANNER_HEIGHT_50:Lcom/facebook/ads/AdSize;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    move-object/from16 v3, v20

    invoke-direct {v0, v1, v2, v3}, Lcom/facebook/ads/AdView;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/ads/AdSize;)V

    .line 616
    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->adView:Lcom/facebook/ads/AdView;

    .line 619
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->banner:Landroid/widget/LinearLayout;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->adView:Lcom/facebook/ads/AdView;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 621
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->adView:Lcom/facebook/ads/AdView;

    move-object/from16 v18, v0

    new-instance v19, Lcom/aio/downloader/activity/AppDetailsActivity$12;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$12;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual/range {v18 .. v19}, Lcom/facebook/ads/AdView;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 644
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->adView:Lcom/facebook/ads/AdView;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/facebook/ads/AdView;->loadAd()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_5

    .line 648
    :goto_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->mygallery:Lcom/aio/downloader/views/HorizontalListView;

    move-object/from16 v18, v0

    new-instance v19, Lcom/aio/downloader/activity/AppDetailsActivity$13;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$13;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual/range {v18 .. v19}, Lcom/aio/downloader/views/HorizontalListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 662
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailgv:Landroid/widget/GridView;

    move-object/from16 v18, v0

    new-instance v19, Lcom/aio/downloader/activity/AppDetailsActivity$14;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$14;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual/range {v18 .. v19}, Landroid/widget/GridView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 675
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailgvwyc1:Lcom/aio/downloader/views/MyGridView;

    move-object/from16 v18, v0

    new-instance v19, Lcom/aio/downloader/activity/AppDetailsActivity$15;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$15;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual/range {v18 .. v19}, Lcom/aio/downloader/views/MyGridView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 688
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailgvwyc2:Lcom/aio/downloader/views/MyGridView;

    move-object/from16 v18, v0

    new-instance v19, Lcom/aio/downloader/activity/AppDetailsActivity$16;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$16;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    invoke-virtual/range {v18 .. v19}, Lcom/aio/downloader/views/MyGridView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 702
    new-instance v18, Lcom/facebook/ads/NativeAd;

    const-string v19, "340186902832477_401790893338744"

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    .line 703
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 704
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAdfb:Lcom/facebook/ads/NativeAd;

    move-object/from16 v18, v0

    sget-object v19, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual/range {v18 .. v19}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 706
    new-instance v18, Lcom/facebook/ads/NativeAd;

    .line 707
    const-string v19, "340186902832477_411793712338462"

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/facebook/ads/NativeAd;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 706
    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 708
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lcom/facebook/ads/NativeAd;->setAdListener(Lcom/facebook/ads/AdListener;)V

    .line 709
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->nativeAd:Lcom/facebook/ads/NativeAd;

    move-object/from16 v18, v0

    sget-object v19, Lcom/facebook/ads/NativeAd$MediaCacheFlag;->ALL:Ljava/util/EnumSet;

    invoke-virtual/range {v18 .. v19}, Lcom/facebook/ads/NativeAd;->loadAd(Ljava/util/EnumSet;)V

    .line 713
    :try_start_7
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v18

    const-string v19, "Roboto-Light.ttf"

    .line 712
    invoke-static/range {v18 .. v19}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->typeFace:Landroid/graphics/Typeface;

    .line 716
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v18

    .line 717
    const-string v19, "Roboto-Condensed.ttf"

    .line 716
    invoke-static/range {v18 .. v19}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v18

    .line 715
    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/activity/AppDetailsActivity;->typeFace2:Landroid/graphics/Typeface;
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_4

    .line 722
    :goto_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->tv_short_desc:Landroid/widget/TextView;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->typeFace:Landroid/graphics/Typeface;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 723
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v18

    const-string v19, "xiazaidianchi"

    const/16 v20, 0x0

    invoke-virtual/range {v18 .. v20}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v17

    .line 724
    .local v17, "xiazaibiaoshi":I
    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_3

    .line 726
    const/16 v16, 0x0

    .line 728
    .local v16, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_8
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v18

    .line 729
    const-string v19, "com.aioapp.battery"

    const/16 v20, 0x0

    invoke-virtual/range {v18 .. v20}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_8
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_8 .. :try_end_8} :catch_1
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_2

    move-result-object v16

    .line 733
    :goto_8
    if-nez v16, :cond_3

    .line 735
    :try_start_9
    new-instance v18, Lcom/aio/downloader/activity/AppDetailsActivity$17;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$17;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    const/16 v19, 0x0

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Void;

    move-object/from16 v19, v0

    .line 757
    invoke-virtual/range {v18 .. v19}, Lcom/aio/downloader/activity/AppDetailsActivity$17;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 759
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->spnetworkre:Landroid/content/SharedPreferences;

    move-object/from16 v18, v0

    const-string v19, "isopen"

    const/16 v20, 0x0

    invoke-interface/range {v18 .. v20}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v18

    if-eqz v18, :cond_4

    .line 761
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/aio/downloader/utils/NetWorkUtil;->getAPNType(Landroid/content/Context;)I

    move-result v18

    const/16 v19, 0x1

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_4

    .line 762
    invoke-direct/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->downwifi()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_2

    .line 786
    .end local v16    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_2
    :goto_9
    return-void

    .line 595
    .end local v17    # "xiazaibiaoshi":I
    :catch_0
    move-exception v6

    .line 597
    .local v6, "e":Ljava/lang/Exception;
    const-string v18, "gak"

    const-string v19, "catch!!!"

    invoke-static/range {v18 .. v19}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_5

    .line 730
    .end local v6    # "e":Ljava/lang/Exception;
    .restart local v16    # "packageInfo":Landroid/content/pm/PackageInfo;
    .restart local v17    # "xiazaibiaoshi":I
    :catch_1
    move-exception v6

    .line 731
    .local v6, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :try_start_a
    invoke-virtual {v6}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_2

    goto :goto_8

    .line 779
    .end local v6    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_2
    move-exception v18

    .line 783
    .end local v16    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_3
    :goto_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->ll_free:Landroid/widget/RelativeLayout;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v18

    if-nez v18, :cond_2

    .line 784
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    const-string v19, "pdt_caller"

    invoke-static/range {v18 .. v19}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_9

    .line 767
    .restart local v16    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_4
    :try_start_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    move-object/from16 v18, v0

    const-string v19, "com.freeapp.batterysaver"

    invoke-virtual/range {v18 .. v19}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v18

    if-nez v18, :cond_3

    .line 769
    const-string v18, "com.freeapp.batterysaver"

    .line 770
    const-string v19, "Battery Saver"

    .line 771
    const-string v20, "https://lh6.ggpht.com/ydrkz1lV1GLQHwjwcyabk6TDxOdpi3MHlv-hl1kU1SP5eQqZ304XoY5rq_2ECjJwNxs=w300"

    .line 772
    const v21, 0x123983

    .line 768
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    move-object/from16 v3, v20

    move/from16 v4, v21

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_2

    goto :goto_a

    .line 579
    .end local v16    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v17    # "xiazaibiaoshi":I
    :catch_3
    move-exception v18

    goto/16 :goto_3

    .line 719
    :catch_4
    move-exception v18

    goto/16 :goto_7

    .line 645
    :catch_5
    move-exception v18

    goto/16 :goto_6

    .line 586
    :catch_6
    move-exception v18

    goto/16 :goto_4

    .line 515
    .end local v7    # "myIntentFilter":Landroid/content/IntentFilter;
    .end local v8    # "myIntentFilter2":Landroid/content/IntentFilter;
    .end local v9    # "myIntentFilter3":Landroid/content/IntentFilter;
    .end local v10    # "myIntentFilter_delete":Landroid/content/IntentFilter;
    .end local v11    # "myIntentFilter_intent_pause":Landroid/content/IntentFilter;
    .end local v12    # "myIntentFilter_intent_start":Landroid/content/IntentFilter;
    .end local v13    # "myIntentFilter_pdt_failure":Landroid/content/IntentFilter;
    .end local v14    # "myIntentFilter_pdtdet":Landroid/content/IntentFilter;
    .end local v15    # "myIntentFilter_success":Landroid/content/IntentFilter;
    :catch_7
    move-exception v18

    goto/16 :goto_2

    .line 510
    :catch_8
    move-exception v18

    goto/16 :goto_1

    .line 504
    :catch_9
    move-exception v18

    goto/16 :goto_0
.end method

.method public onError(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V
    .locals 2
    .param p1, "arg0"    # Lcom/facebook/ads/Ad;
    .param p2, "arg1"    # Lcom/facebook/ads/AdError;

    .prologue
    .line 2706
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->inmobtop:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2711
    const-string v0, "qwer"

    const-string v1, "onError"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2712
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v2, 0x1

    .line 2650
    const/4 v1, 0x4

    if-ne p1, v1, :cond_2

    .line 2652
    iget-boolean v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->widgetdetailfan:Z

    if-eqz v1, :cond_0

    sget-boolean v1, Lcom/aio/downloader/utils/Myutils;->detail_save:Z

    if-eqz v1, :cond_1

    :cond_0
    iget v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->caocao:I

    if-eq v1, v2, :cond_1

    .line 2653
    iget v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->myjpush:I

    if-ne v1, v2, :cond_3

    .line 2654
    :cond_1
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 2655
    const-class v2, Lcom/aio/downloader/activity/MyMainActivity;

    .line 2654
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2656
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "acquire_url_start"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 2657
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->startActivity(Landroid/content/Intent;)V

    .line 2658
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->finish()V

    .line 2663
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_2
    :goto_0
    invoke-super {p0, p1, p2}, Lcom/aio/downloader/mydownload/BaseActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v1

    return v1

    .line 2660
    :cond_3
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->finish()V

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 2266
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 2267
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 2269
    return-void
.end method

.method protected onResume()V
    .locals 11

    .prologue
    .line 2058
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onResume()V

    .line 2061
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 2063
    const/4 v10, 0x0

    .line 2065
    .local v10, "packageInfo_myid":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v10

    .line 2070
    :goto_0
    new-instance v6, Lcom/aio/downloader/utils/MyAppInfo;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v6, v2}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 2072
    .local v6, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_1
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;

    invoke-virtual {v6, v2}, Lcom/aio/downloader/utils/MyAppInfo;->getAppVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->myVer:Ljava/lang/String;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    .line 2077
    :goto_1
    if-nez v10, :cond_2

    .line 2078
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_install:Landroid/widget/TextView;

    const-string v3, "Install"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 2082
    :goto_2
    iget v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->wocao:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 2084
    :try_start_2
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->myUpver:Ljava/lang/String;

    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->myVer:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    if-eqz v10, :cond_3

    .line 2085
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_install:Landroid/widget/TextView;

    const-string v3, "Open"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 2096
    :cond_0
    :goto_3
    :try_start_3
    new-instance v2, Lnet/tsz/afinal/FinalDBChen;

    .line 2097
    const-string v3, "download2.db"

    .line 2096
    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetailsActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    .line 2097
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 2096
    iput-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 2098
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 2099
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 2098
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ds:Ljava/util/List;

    .line 2100
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->ds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v9

    .line 2101
    .local v9, "number":I
    if-eqz v9, :cond_4

    .line 2103
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-static {v9}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 2104
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->show()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 2113
    .end local v9    # "number":I
    :cond_1
    :goto_4
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 2114
    .local v0, "timer":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$33;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$33;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V

    .line 2126
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0xbb8

    const-wide/16 v4, 0x2710

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 2127
    return-void

    .line 2066
    .end local v0    # "timer":Ljava/util/Timer;
    .end local v1    # "task":Ljava/util/TimerTask;
    .end local v6    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_0
    move-exception v8

    .line 2067
    .local v8, "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v10, 0x0

    .line 2068
    invoke-virtual {v8}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0

    .line 2073
    .end local v8    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v6    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_1
    move-exception v7

    .line 2075
    .local v7, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v7}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 2080
    .end local v7    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_2
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_install:Landroid/widget/TextView;

    const-string v3, "Open"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 2087
    :cond_3
    :try_start_4
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk_install:Landroid/widget/TextView;

    const-string v3, "Update"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_3

    .line 2089
    :catch_2
    move-exception v2

    goto :goto_3

    .line 2105
    .restart local v9    # "number":I
    :cond_4
    if-nez v9, :cond_1

    .line 2107
    :try_start_5
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->badgedownimg:Lcom/aio/downloader/views/BadgeView;

    invoke-virtual {v2}, Lcom/aio/downloader/views/BadgeView;->hide()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto :goto_4

    .line 2110
    .end local v9    # "number":I
    :catch_3
    move-exception v2

    goto :goto_4
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 2036
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 2037
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 2038
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "download_aio"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 2041
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 2042
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 2043
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 2041
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 2044
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 2046
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 2052
    :goto_0
    return-void

    .line 2049
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 2050
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 2049
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
