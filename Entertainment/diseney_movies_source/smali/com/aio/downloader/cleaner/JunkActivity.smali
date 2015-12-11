.class public Lcom/aio/downloader/cleaner/JunkActivity;
.super Landroid/app/Activity;
.source "JunkActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/wjj/utils/StickyLayout$OnGiveUpTouchEventListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/cleaner/JunkActivity$GroupClickListener;
    }
.end annotation


# static fields
.field protected static final APK_EVERY_COUNT:I = 0x7

.field protected static final SEARCH_APK_SUCCESS:I = 0x3ba


# instance fields
.field private adapter:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

.field private allapksize:J

.field private allboostsize:J

.field private allcachesize:J

.field private allcanliusize:J

.field private allok:I

.field private apk_num:Landroid/widget/TextView;

.field private apkadapter:Lcom/wjj/adapter/base/ApkSoftAdapter;

.field private apkdata:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/SoftApk;",
            ">;"
        }
    .end annotation
.end field

.field private apkpath:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private boostadapter:Lcom/wjj/adapter/base/JunkBoostAdapter;

.field private bost_num:Landroid/widget/TextView;

.field private bt_clean:Landroid/widget/Button;

.field private bt_cleaning:Landroid/widget/Button;

.field private bt_stop:Landroid/widget/Button;

.field private cache_num:Landroid/widget/TextView;

.field private cacheadapter:Lcom/wjj/adapter/base/JunkCacheAdapter;

.field private cachelist:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RubSoftware;",
            ">;"
        }
    .end annotation
.end field

.field private cachelistener:Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;

.field private canliuAdapter:Lcom/wjj/adapter/base/JunkCanliuAdapter;

.field private canliu_num:Landroid/widget/TextView;

.field private cllist:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/Canliu;",
            ">;"
        }
    .end annotation
.end field

.field private content_one:Landroid/widget/LinearLayout;

.field private content_two:Landroid/widget/LinearLayout;

.field private emptyfile:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation
.end field

.field private er:I

.field private expandFlag:I

.field private explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;

.field private four:I

.field private groupData:[Ljava/lang/String;

.field private groupsize:[Ljava/lang/String;

.field private handler:Landroid/os/Handler;

.field private header_left_back:Lcom/aio/downloader/views/LImageButton;

.field private iv_apkall:Landroid/widget/ImageView;

.field private iv_cacheall:Landroid/widget/ImageView;

.field private iv_canliuall:Landroid/widget/ImageView;

.field private iv_ncall:Landroid/widget/ImageView;

.field private l:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RuningApp;",
            ">;"
        }
    .end annotation
.end field

.field private lv_apk:Lcom/wjj/utils/MyListView;

.field private lv_canliu:Lcom/wjj/utils/MyListView;

.field private lv_huancun:Lcom/wjj/utils/MyListView;

.field private lv_neicun:Lcom/wjj/utils/MyListView;

.field private nc_pb:Landroid/widget/ProgressBar;

.field private newapkpath:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private num2:I

.field private one:I

.field private pb_apk:Landroid/widget/ProgressBar;

.field private pb_canliu:Landroid/widget/ProgressBar;

.field private progressBarcache:Landroid/widget/ProgressBar;

.field private rub_center:Landroid/widget/TextView;

.field private rub_total:Landroid/widget/TextView;

.field private rubmamager:Lcom/wjj/manager/RubSoftwareManager;

.field private runappmana:Lcom/wjj/manager/RuningAppManager;

.field private runlistener:Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;

.field private sm:Lcom/wjj/manager/SoftApkManager;

.field private smListener:Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;

.field private stickyLayout:Lcom/wjj/utils/StickyLayout;

.field sticky_content:Landroid/widget/ScrollView;

.field private sticky_header:Landroid/widget/RelativeLayout;

.field private three:I

.field private tv_scan:Landroid/widget/TextView;

.field private two:I

.field private urm:Lcom/wjj/manager/UnloadingResidueManager;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x4

    .line 54
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 81
    new-instance v0, Lcom/aio/downloader/cleaner/JunkActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/JunkActivity$1;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;

    .line 213
    new-array v0, v1, [Ljava/lang/String;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->groupData:[Ljava/lang/String;

    .line 214
    new-array v0, v1, [Ljava/lang/String;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->groupsize:[Ljava/lang/String;

    .line 215
    const/4 v0, -0x1

    iput v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->expandFlag:I

    .line 258
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->num2:I

    .line 259
    new-instance v0, Lcom/aio/downloader/cleaner/JunkActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/JunkActivity$2;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->l:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

    .line 333
    new-instance v0, Lcom/aio/downloader/cleaner/JunkActivity$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/JunkActivity$3;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->smListener:Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;

    .line 506
    new-instance v0, Lcom/aio/downloader/cleaner/JunkActivity$4;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/JunkActivity$4;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->runlistener:Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;

    .line 537
    new-instance v0, Lcom/aio/downloader/cleaner/JunkActivity$5;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/JunkActivity$5;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cachelistener:Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;

    .line 54
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->list:Ljava/util/List;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->nc_pb:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/cleaner/JunkActivity;)J
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J

    return-wide v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/cleaner/JunkActivity;)J
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J

    return-wide v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/cleaner/JunkActivity;)J
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J

    return-wide v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->tv_scan:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cachelist:Ljava/util/List;

    return-void
.end method

.method static synthetic access$15(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/adapter/base/JunkCacheAdapter;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cacheadapter:Lcom/wjj/adapter/base/JunkCacheAdapter;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cachelist:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->progressBarcache:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->iv_cacheall:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/cleaner/JunkActivity;I)V
    .locals 0

    .prologue
    .line 80
    iput p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->two:I

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->iv_ncall:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/cleaner/JunkActivity;J)V
    .locals 0

    .prologue
    .line 71
    iput-wide p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J

    return-void
.end method

.method static synthetic access$21(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cache_num:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$22(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 201
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->emptyfile:Ljava/util/List;

    return-void
.end method

.method static synthetic access$23(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->emptyfile:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$24(Lcom/aio/downloader/cleaner/JunkActivity;J)V
    .locals 0

    .prologue
    .line 71
    iput-wide p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J

    return-void
.end method

.method static synthetic access$25(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->canliu_num:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$26(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cllist:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$27(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/adapter/base/JunkCanliuAdapter;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->canliuAdapter:Lcom/wjj/adapter/base/JunkCanliuAdapter;

    return-object v0
.end method

.method static synthetic access$28(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->pb_canliu:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$29(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->iv_canliuall:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/cleaner/JunkActivity;)I
    .locals 1

    .prologue
    .line 80
    iget v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allok:I

    return v0
.end method

.method static synthetic access$30(Lcom/aio/downloader/cleaner/JunkActivity;I)V
    .locals 0

    .prologue
    .line 80
    iput p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->three:I

    return-void
.end method

.method static synthetic access$31(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkpath:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$32(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->newapkpath:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$33(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkdata:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$34(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/SoftApkManager;
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->sm:Lcom/wjj/manager/SoftApkManager;

    return-object v0
.end method

.method static synthetic access$35(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;
    .locals 1

    .prologue
    .line 333
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->smListener:Lcom/wjj/manager/SoftApkManager$SoftApkManagerListener2;

    return-object v0
.end method

.method static synthetic access$36(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/adapter/base/ApkSoftAdapter;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkadapter:Lcom/wjj/adapter/base/ApkSoftAdapter;

    return-object v0
.end method

.method static synthetic access$37(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->pb_apk:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$38(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->iv_apkall:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$39(Lcom/aio/downloader/cleaner/JunkActivity;I)V
    .locals 0

    .prologue
    .line 80
    iput p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->four:I

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/cleaner/JunkActivity;I)V
    .locals 0

    .prologue
    .line 80
    iput p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allok:I

    return-void
.end method

.method static synthetic access$40(Lcom/aio/downloader/cleaner/JunkActivity;J)V
    .locals 0

    .prologue
    .line 71
    iput-wide p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J

    return-void
.end method

.method static synthetic access$41(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apk_num:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$42(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bt_stop:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$43(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bt_clean:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$44(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->rub_center:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$45(Lcom/aio/downloader/cleaner/JunkActivity;)[Ljava/lang/String;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->groupsize:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$46(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->content_two:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$47(Lcom/aio/downloader/cleaner/JunkActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->list:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$48(Lcom/aio/downloader/cleaner/JunkActivity;)[Ljava/lang/String;
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->groupData:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$49(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/view/PinnedHeaderExpandableListView;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/cleaner/JunkActivity;I)V
    .locals 0

    .prologue
    .line 80
    iput p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->one:I

    return-void
.end method

.method static synthetic access$50(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;
    .locals 1

    .prologue
    .line 259
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->l:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

    return-object v0
.end method

.method static synthetic access$51(Lcom/aio/downloader/cleaner/JunkActivity;Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)V
    .locals 0

    .prologue
    .line 216
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->adapter:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    return-void
.end method

.method static synthetic access$52(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->adapter:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    return-object v0
.end method

.method static synthetic access$53(Lcom/aio/downloader/cleaner/JunkActivity;I)V
    .locals 0

    .prologue
    .line 258
    iput p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->num2:I

    return-void
.end method

.method static synthetic access$54(Lcom/aio/downloader/cleaner/JunkActivity;)I
    .locals 1

    .prologue
    .line 258
    iget v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->num2:I

    return v0
.end method

.method static synthetic access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$56(Lcom/aio/downloader/cleaner/JunkActivity;)I
    .locals 1

    .prologue
    .line 215
    iget v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->expandFlag:I

    return v0
.end method

.method static synthetic access$57(Lcom/aio/downloader/cleaner/JunkActivity;I)V
    .locals 0

    .prologue
    .line 215
    iput p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->expandFlag:I

    return-void
.end method

.method static synthetic access$58(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/io/File;[Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 373
    invoke-direct {p0, p1, p2}, Lcom/aio/downloader/cleaner/JunkActivity;->search(Ljava/io/File;[Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$59(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/UnloadingResidueManager;
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->urm:Lcom/wjj/manager/UnloadingResidueManager;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/cleaner/JunkActivity;)J
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J

    return-wide v0
.end method

.method static synthetic access$60(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/RuningAppManager;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->runappmana:Lcom/wjj/manager/RuningAppManager;

    return-object v0
.end method

.method static synthetic access$61(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;
    .locals 1

    .prologue
    .line 506
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->runlistener:Lcom/wjj/manager/RuningAppManager$RuningAppManagerListener;

    return-object v0
.end method

.method static synthetic access$62(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/RubSoftwareManager;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->rubmamager:Lcom/wjj/manager/RubSoftwareManager;

    return-object v0
.end method

.method static synthetic access$63(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;
    .locals 1

    .prologue
    .line 537
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cachelistener:Lcom/wjj/manager/RubSoftwareManager$RubSoftwareManagerListener;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/cleaner/JunkActivity;J)V
    .locals 0

    .prologue
    .line 71
    iput-wide p1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bost_num:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->rub_total:Landroid/widget/TextView;

    return-object v0
.end method

.method private initData()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 287
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->groupData:[Ljava/lang/String;

    const-string v1, "Memory boost"

    aput-object v1, v0, v4

    .line 288
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->groupData:[Ljava/lang/String;

    const/4 v1, 0x1

    const-string v2, "Cache junk"

    aput-object v2, v0, v1

    .line 289
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->groupData:[Ljava/lang/String;

    const/4 v1, 0x2

    const-string v2, "Residual fils"

    aput-object v2, v0, v1

    .line 290
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->groupData:[Ljava/lang/String;

    const/4 v1, 0x3

    const-string v2, "APK files"

    aput-object v2, v0, v1

    .line 293
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v1

    .line 294
    const v2, 0x7f03003c

    iget-object v3, p0, Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;

    .line 293
    invoke-virtual {v1, v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaos/view/PinnedHeaderExpandableListView;->setHeaderView(Landroid/view/View;)V

    .line 303
    return-void
.end method

.method private initView()V
    .locals 1

    .prologue
    .line 279
    const v0, 0x7f07004e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/xiaos/view/PinnedHeaderExpandableListView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->explistview:Lcom/xiaos/view/PinnedHeaderExpandableListView;

    .line 280
    return-void
.end method

.method private search(Ljava/io/File;[Ljava/lang/String;)V
    .locals 4
    .param p1, "file"    # Ljava/io/File;
    .param p2, "ext"    # [Ljava/lang/String;

    .prologue
    .line 374
    if-eqz p1, :cond_0

    .line 375
    invoke-virtual {p1}, Ljava/io/File;->isDirectory()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 376
    invoke-virtual {p1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    .line 377
    .local v2, "listFile":[Ljava/io/File;
    if-eqz v2, :cond_0

    .line 378
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, v2

    if-lt v1, v3, :cond_1

    .line 392
    .end local v1    # "i":I
    .end local v2    # "listFile":[Ljava/io/File;
    :cond_0
    :goto_1
    return-void

    .line 379
    .restart local v1    # "i":I
    .restart local v2    # "listFile":[Ljava/io/File;
    :cond_1
    aget-object v3, v2, v1

    invoke-direct {p0, v3, p2}, Lcom/aio/downloader/cleaner/JunkActivity;->search(Ljava/io/File;[Ljava/lang/String;)V

    .line 378
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 383
    .end local v1    # "i":I
    .end local v2    # "listFile":[Ljava/io/File;
    :cond_2
    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 384
    .local v0, "filename":Ljava/lang/String;
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_2
    array-length v3, p2

    if-ge v1, v3, :cond_0

    .line 385
    aget-object v3, p2, v1

    invoke-virtual {v0, v3}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 386
    iget-object v3, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkpath:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 384
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_2
.end method

.method private showNormal3()V
    .locals 4

    .prologue
    .line 611
    const-string v0, "Are you sure to stop scanning ?"

    .line 612
    .local v0, "message":Ljava/lang/String;
    new-instance v1, Lcom/aio/downloader/views/LAlertDialog$Builder;

    invoke-direct {v1, p0}, Lcom/aio/downloader/views/LAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 613
    const-string v2, "Notice"

    invoke-virtual {v1, v2}, Lcom/aio/downloader/views/LAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/aio/downloader/views/LAlertDialog$Builder;

    move-result-object v1

    .line 614
    invoke-virtual {v1, v0}, Lcom/aio/downloader/views/LAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/aio/downloader/views/LAlertDialog$Builder;

    move-result-object v1

    .line 615
    const-string v2, "Cancel"

    .line 616
    new-instance v3, Lcom/aio/downloader/cleaner/JunkActivity$10;

    invoke-direct {v3, p0}, Lcom/aio/downloader/cleaner/JunkActivity$10;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    .line 615
    invoke-virtual {v1, v2, v3}, Lcom/aio/downloader/views/LAlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Lcom/aio/downloader/views/LAlertDialog$Builder;

    move-result-object v1

    .line 623
    const-string v2, "Stop"

    .line 624
    new-instance v3, Lcom/aio/downloader/cleaner/JunkActivity$11;

    invoke-direct {v3, p0}, Lcom/aio/downloader/cleaner/JunkActivity$11;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    .line 623
    invoke-virtual {v1, v2, v3}, Lcom/aio/downloader/views/LAlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Lcom/aio/downloader/views/LAlertDialog$Builder;

    move-result-object v1

    .line 653
    invoke-virtual {v1}, Lcom/aio/downloader/views/LAlertDialog$Builder;->show()Lcom/aio/downloader/views/LAlertDialog;

    .line 654
    return-void
.end method


# virtual methods
.method public AsncyApk()V
    .locals 2

    .prologue
    .line 361
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/cleaner/JunkActivity$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/JunkActivity$6;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 369
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 370
    return-void
.end method

.method public AsyncDataEmpty()V
    .locals 1

    .prologue
    .line 410
    new-instance v0, Lcom/aio/downloader/cleaner/JunkActivity$7;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/JunkActivity$7;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    .line 421
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/JunkActivity$7;->start()V

    .line 422
    return-void
.end method

.method public giveUpTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/16 v1, 0x8

    .line 662
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_neicun:Lcom/wjj/utils/MyListView;

    invoke-virtual {v0}, Lcom/wjj/utils/MyListView;->getVisibility()I

    move-result v0

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_huancun:Lcom/wjj/utils/MyListView;

    invoke-virtual {v0}, Lcom/wjj/utils/MyListView;->getVisibility()I

    move-result v0

    if-ne v0, v1, :cond_0

    .line 663
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_canliu:Lcom/wjj/utils/MyListView;

    invoke-virtual {v0}, Lcom/wjj/utils/MyListView;->getVisibility()I

    move-result v0

    if-ne v0, v1, :cond_0

    .line 664
    const/4 v0, 0x1

    .line 666
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public init()V
    .locals 2

    .prologue
    .line 425
    const v0, 0x7f070033

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->rub_center:Landroid/widget/TextView;

    .line 426
    const v0, 0x7f070051

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bt_cleaning:Landroid/widget/Button;

    .line 427
    const v0, 0x7f07004f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bt_stop:Landroid/widget/Button;

    .line 428
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bt_stop:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 429
    const v0, 0x7f070032

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->tv_scan:Landroid/widget/TextView;

    .line 431
    const v0, 0x7f07003e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cache_num:Landroid/widget/TextView;

    .line 432
    const v0, 0x7f070039

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bost_num:Landroid/widget/TextView;

    .line 434
    const v0, 0x7f070041

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wjj/utils/MyListView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_huancun:Lcom/wjj/utils/MyListView;

    .line 435
    new-instance v0, Lcom/wjj/adapter/base/JunkCacheAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wjj/adapter/base/JunkCacheAdapter;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cacheadapter:Lcom/wjj/adapter/base/JunkCacheAdapter;

    .line 436
    new-instance v0, Lcom/wjj/manager/RubSoftwareManager;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wjj/manager/RubSoftwareManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->rubmamager:Lcom/wjj/manager/RubSoftwareManager;

    .line 437
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_huancun:Lcom/wjj/utils/MyListView;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cacheadapter:Lcom/wjj/adapter/base/JunkCacheAdapter;

    invoke-virtual {v0, v1}, Lcom/wjj/utils/MyListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 439
    const v0, 0x7f07002f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->header_left_back:Lcom/aio/downloader/views/LImageButton;

    .line 440
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->header_left_back:Lcom/aio/downloader/views/LImageButton;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 441
    const v0, 0x7f070050

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bt_clean:Landroid/widget/Button;

    .line 442
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bt_clean:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 443
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->list:Ljava/util/List;

    .line 444
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cachelist:Ljava/util/List;

    .line 445
    new-instance v0, Lcom/wjj/manager/RuningAppManager;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wjj/manager/RuningAppManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->runappmana:Lcom/wjj/manager/RuningAppManager;

    .line 447
    new-instance v0, Lcom/wjj/adapter/base/JunkBoostAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wjj/adapter/base/JunkBoostAdapter;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->boostadapter:Lcom/wjj/adapter/base/JunkBoostAdapter;

    .line 448
    const v0, 0x7f070030

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->rub_total:Landroid/widget/TextView;

    .line 449
    const v0, 0x7f07003c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wjj/utils/MyListView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_neicun:Lcom/wjj/utils/MyListView;

    .line 450
    const v0, 0x7f07003b

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->iv_ncall:Landroid/widget/ImageView;

    .line 451
    const v0, 0x7f070040

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->iv_cacheall:Landroid/widget/ImageView;

    .line 452
    const v0, 0x7f07003a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->nc_pb:Landroid/widget/ProgressBar;

    .line 453
    const v0, 0x7f07003f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->progressBarcache:Landroid/widget/ProgressBar;

    .line 454
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_neicun:Lcom/wjj/utils/MyListView;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->boostadapter:Lcom/wjj/adapter/base/JunkBoostAdapter;

    invoke-virtual {v0, v1}, Lcom/wjj/utils/MyListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 455
    return-void
.end method

.method public initBoostData()V
    .locals 1

    .prologue
    .line 458
    new-instance v0, Lcom/aio/downloader/cleaner/JunkActivity$8;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/JunkActivity$8;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    .line 468
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/JunkActivity$8;->start()V

    .line 469
    return-void
.end method

.method public initCache()V
    .locals 1

    .prologue
    .line 488
    new-instance v0, Lcom/aio/downloader/cleaner/JunkActivity$9;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/JunkActivity$9;-><init>(Lcom/aio/downloader/cleaner/JunkActivity;)V

    .line 501
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/JunkActivity$9;->start()V

    .line 503
    return-void
.end method

.method public initEmptyFile()V
    .locals 2

    .prologue
    .line 396
    const v0, 0x7f070043

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->canliu_num:Landroid/widget/TextView;

    .line 397
    const v0, 0x7f070045

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->iv_canliuall:Landroid/widget/ImageView;

    .line 398
    const v0, 0x7f070044

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->pb_canliu:Landroid/widget/ProgressBar;

    .line 399
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cllist:Ljava/util/List;

    .line 400
    const v0, 0x7f070046

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wjj/utils/MyListView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_canliu:Lcom/wjj/utils/MyListView;

    .line 401
    new-instance v0, Lcom/wjj/adapter/base/JunkCanliuAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wjj/adapter/base/JunkCanliuAdapter;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->canliuAdapter:Lcom/wjj/adapter/base/JunkCanliuAdapter;

    .line 402
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_canliu:Lcom/wjj/utils/MyListView;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->canliuAdapter:Lcom/wjj/adapter/base/JunkCanliuAdapter;

    invoke-virtual {v0, v1}, Lcom/wjj/utils/MyListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 404
    new-instance v0, Lcom/wjj/manager/UnloadingResidueManager;

    invoke-direct {v0, p0}, Lcom/wjj/manager/UnloadingResidueManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->urm:Lcom/wjj/manager/UnloadingResidueManager;

    .line 405
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->emptyfile:Ljava/util/List;

    .line 406
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->AsyncDataEmpty()V

    .line 407
    return-void
.end method

.method public initapk()V
    .locals 2

    .prologue
    .line 345
    const v0, 0x7f07004d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->content_two:Landroid/widget/LinearLayout;

    .line 346
    const v0, 0x7f070035

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->content_one:Landroid/widget/LinearLayout;

    .line 347
    new-instance v0, Lcom/wjj/adapter/base/ApkSoftAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wjj/adapter/base/ApkSoftAdapter;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkadapter:Lcom/wjj/adapter/base/ApkSoftAdapter;

    .line 348
    const v0, 0x7f07004c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wjj/utils/MyListView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_apk:Lcom/wjj/utils/MyListView;

    .line 349
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->lv_apk:Lcom/wjj/utils/MyListView;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkadapter:Lcom/wjj/adapter/base/ApkSoftAdapter;

    invoke-virtual {v0, v1}, Lcom/wjj/utils/MyListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 350
    const v0, 0x7f07004a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->iv_apkall:Landroid/widget/ImageView;

    .line 351
    const v0, 0x7f070049

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->pb_apk:Landroid/widget/ProgressBar;

    .line 352
    const v0, 0x7f070048

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apk_num:Landroid/widget/TextView;

    .line 353
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkdata:Ljava/util/List;

    .line 354
    new-instance v0, Lcom/wjj/manager/SoftApkManager;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/wjj/manager/SoftApkManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->sm:Lcom/wjj/manager/SoftApkManager;

    .line 355
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkpath:Ljava/util/List;

    .line 356
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->newapkpath:Ljava/util/List;

    .line 357
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->AsncyApk()V

    .line 358
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 11
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 550
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v5

    sparse-switch v5, :sswitch_data_0

    .line 607
    :goto_0
    return-void

    .line 555
    :sswitch_0
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bt_clean:Landroid/widget/Button;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setVisibility(I)V

    .line 556
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->bt_cleaning:Landroid/widget/Button;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setVisibility(I)V

    .line 558
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->list:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    if-lt v1, v5, :cond_0

    .line 564
    const/4 v1, 0x0

    :goto_2
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cachelist:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-lt v1, v5, :cond_2

    .line 571
    const/4 v1, 0x0

    :goto_3
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cllist:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-lt v1, v5, :cond_4

    .line 578
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 579
    .local v4, "newdata":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/SoftApk;>;"
    const/4 v1, 0x0

    :goto_4
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkdata:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-lt v1, v5, :cond_6

    .line 590
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 591
    const-class v6, Lcom/aio/downloader/cleaner/ShowCleanActivity1;

    .line 590
    invoke-direct {v2, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 592
    .local v2, "intent":Landroid/content/Intent;
    iget-wide v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J

    iget-wide v7, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J

    add-long/2addr v5, v7

    iget-wide v7, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J

    add-long/2addr v5, v7

    iget-wide v7, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J

    add-long/2addr v5, v7

    const-wide/16 v7, 0x400

    div-long/2addr v5, v7

    long-to-int v3, v5

    .line 593
    .local v3, "juti":I
    const-string v5, "juti"

    invoke-virtual {v2, v5, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 594
    const-string v5, "junk"

    const/4 v6, 0x1

    invoke-virtual {v2, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 595
    const-string v5, "fff"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "===="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-wide v7, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allboostsize:J

    iget-wide v9, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allcachesize:J

    add-long/2addr v7, v9

    .line 596
    iget-wide v9, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allcanliusize:J

    add-long/2addr v7, v9

    iget-wide v9, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J

    add-long/2addr v7, v9

    invoke-virtual {v6, v7, v8}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 595
    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 597
    invoke-virtual {p0, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->startActivity(Landroid/content/Intent;)V

    .line 598
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->finish()V

    goto/16 :goto_0

    .line 559
    .end local v2    # "intent":Landroid/content/Intent;
    .end local v3    # "juti":I
    .end local v4    # "newdata":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/SoftApk;>;"
    :cond_0
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->list:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/wjj/eneity/RuningApp;

    iget-boolean v5, v5, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    if-eqz v5, :cond_1

    .line 560
    iget-object v6, p0, Lcom/aio/downloader/cleaner/JunkActivity;->runappmana:Lcom/wjj/manager/RuningAppManager;

    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->list:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/wjj/eneity/RuningApp;

    iget-object v5, v5, Lcom/wjj/eneity/RuningApp;->packname:Ljava/lang/String;

    invoke-virtual {v6, v5}, Lcom/wjj/manager/RuningAppManager;->Killprogress(Ljava/lang/String;)V

    .line 558
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_1

    .line 565
    :cond_2
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cachelist:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/wjj/eneity/RubSoftware;

    iget-boolean v5, v5, Lcom/wjj/eneity/RubSoftware;->ischecked:Z

    if-eqz v5, :cond_3

    .line 566
    new-instance v6, Ljava/io/File;

    .line 567
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cachelist:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/wjj/eneity/RubSoftware;

    iget-object v5, v5, Lcom/wjj/eneity/RubSoftware;->cachepath:Ljava/lang/String;

    .line 566
    invoke-direct {v6, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v6}, Lcom/wjj/manager/RubSoftwareManager;->delFile(Ljava/io/File;)V

    .line 564
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_2

    .line 572
    :cond_4
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cllist:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/wjj/eneity/Canliu;

    iget-boolean v5, v5, Lcom/wjj/eneity/Canliu;->ischecked:Z

    if-eqz v5, :cond_5

    .line 573
    new-instance v6, Ljava/io/File;

    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->cllist:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/wjj/eneity/Canliu;

    iget-object v5, v5, Lcom/wjj/eneity/Canliu;->path:Ljava/lang/String;

    invoke-direct {v6, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/io/File;->delete()Z

    .line 571
    :cond_5
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_3

    .line 580
    .restart local v4    # "newdata":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/SoftApk;>;"
    :cond_6
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkdata:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/wjj/eneity/SoftApk;

    iget-boolean v5, v5, Lcom/wjj/eneity/SoftApk;->ischecked:Z

    if-eqz v5, :cond_7

    .line 581
    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkdata:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/wjj/eneity/SoftApk;

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 582
    iget-wide v6, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J

    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->apkdata:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/wjj/eneity/SoftApk;

    iget-wide v8, v5, Lcom/wjj/eneity/SoftApk;->apksize:J

    sub-long v5, v6, v8

    iput-wide v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allapksize:J

    .line 583
    new-instance v0, Ljava/io/File;

    iget-object v5, p0, Lcom/aio/downloader/cleaner/JunkActivity;->newapkpath:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-direct {v0, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 584
    .local v0, "df":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 579
    .end local v0    # "df":Ljava/io/File;
    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_4

    .line 601
    .end local v1    # "i":I
    .end local v4    # "newdata":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/SoftApk;>;"
    :sswitch_1
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->finish()V

    goto/16 :goto_0

    .line 604
    :sswitch_2
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->showNormal3()V

    goto/16 :goto_0

    .line 550
    :sswitch_data_0
    .sparse-switch
        0x7f07002f -> :sswitch_1
        0x7f07004f -> :sswitch_2
        0x7f070050 -> :sswitch_0
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, 0x0

    .line 220
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 221
    const v0, 0x7f030006

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->setContentView(I)V

    .line 224
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->init()V

    .line 236
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->initBoostData()V

    .line 238
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->initCache()V

    .line 240
    const v0, 0x7f070034

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->sticky_content:Landroid/widget/ScrollView;

    .line 241
    const v0, 0x7f07002e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/JunkActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity;->sticky_header:Landroid/widget/RelativeLayout;

    .line 243
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->initEmptyFile()V

    .line 244
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->initapk()V

    .line 246
    iput v1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->allok:I

    .line 247
    iput v1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->one:I

    .line 248
    iput v1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->two:I

    .line 249
    iput v1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->three:I

    .line 250
    iput v1, p0, Lcom/aio/downloader/cleaner/JunkActivity;->four:I

    .line 252
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->initView()V

    .line 253
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/JunkActivity;->initData()V

    .line 255
    return-void
.end method
