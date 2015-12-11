.class public Lcom/aio/downloader/cleaner/RubActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "RubActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;,
        Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;,
        Lcom/aio/downloader/cleaner/RubActivity$memInfo;
    }
.end annotation


# static fields
.field private static final LOAD_FINISH:I = 0x1

.field private static cont:D

.field private static flag:Z


# instance fields
.field MymemorySize:I

.field private PRO_DIR:Ljava/io/File;

.field private activityManager:Landroid/app/ActivityManager;

.field private adapter:Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;

.field private availMemory:Ljava/lang/String;

.field bean:Lcom/aio/downloader/cleaner/Bean;

.field private bt_process_clear:Landroid/widget/Button;

.field private bt_process_finish_rub:Landroid/widget/Button;

.field private bt_process_ing:Landroid/widget/Button;

.field private btnfinish:Landroid/widget/Button;

.field private cacheMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private cb_process_state:Landroid/widget/CheckBox;

.field private cishu:I

.field private cleanSize:Ljava/lang/String;

.field private cont_clean:D

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

.field editor:Landroid/content/SharedPreferences$Editor;

.field private flag_cilcle:Z

.field private flag_clean:Z

.field private getmem_SY:J

.field handler:Landroid/os/Handler;

.field private handler2:Landroid/os/Handler;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "HandlerLeak"
        }
    .end annotation
.end field

.field private header_left_fanghui1:Landroid/widget/ImageView;

.field private header_left_showclean2_rub:Landroid/widget/ImageView;

.field i:I

.field private iv_bg:Landroid/widget/ImageView;

.field private iv_ok1:Landroid/widget/ImageView;

.field list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/cleaner/Bean;",
            ">;"
        }
    .end annotation
.end field

.field private lv_process_list:Landroid/widget/ListView;

.field private memory:Ljava/lang/String;

.field private memorySize:I

.field private pb:Landroid/widget/ProgressBar;

.field private pm:Landroid/content/pm/PackageManager;

.field private pos:I

.field private progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private progress_wheel_wyc:Lcom/aio/downloader/utils/ProgressWheel;

.field private progress_wheel_wyc_rub1:Lcom/aio/downloader/utils/ProgressWheel;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private releasedtime:Landroid/widget/TextView;

.field private roundDouble:Ljava/lang/Double;

.field private rp_chuang1:Lcom/aio/downloader/views/RoundProgressBar;

.field private runningAppProcessInfos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/app/ActivityManager$RunningAppProcessInfo;",
            ">;"
        }
    .end annotation
.end field

.field private scanningtv:Landroid/widget/TextView;

.field sharedPreferences:Landroid/content/SharedPreferences;

.field private sp:Landroid/content/SharedPreferences;

.field private spnetworkre:Landroid/content/SharedPreferences;

.field private systemTaskInfos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/cleaner/TaskInfo;",
            ">;"
        }
    .end annotation
.end field

.field private taskInfoProvider:Lcom/aio/downloader/cleaner/TaskInfoProvider;

.field private taskInfos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/cleaner/TaskInfo;",
            ">;"
        }
    .end annotation
.end field

.field private totalMemory:Ljava/lang/String;

.field total_show:J

.field total_wyc:J

.field private tv_best:Landroid/widget/TextView;

.field private tv_danwei:Landroid/widget/TextView;

.field private tv_jieguo_rub:Landroid/widget/TextView;

.field private tv_neicun:Landroid/widget/TextView;

.field private tv_status:Landroid/widget/TextView;

.field private tv_zhuantai:Landroid/widget/TextView;

.field private userTaskInfos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/cleaner/TaskInfo;",
            ">;"
        }
    .end annotation
.end field

.field private widgetdetailfan:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 92
    const-wide/16 v0, 0x0

    sput-wide v0, Lcom/aio/downloader/cleaner/RubActivity;->cont:D

    .line 314
    const/4 v0, 0x1

    sput-boolean v0, Lcom/aio/downloader/cleaner/RubActivity;->flag:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 7

    .prologue
    const-wide/16 v5, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 71
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 86
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->list:Ljava/util/ArrayList;

    .line 87
    iput-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->bean:Lcom/aio/downloader/cleaner/Bean;

    .line 94
    iput v2, p0, Lcom/aio/downloader/cleaner/RubActivity;->i:I

    .line 95
    iput v2, p0, Lcom/aio/downloader/cleaner/RubActivity;->cishu:I

    .line 96
    iput v2, p0, Lcom/aio/downloader/cleaner/RubActivity;->MymemorySize:I

    .line 97
    iput-wide v5, p0, Lcom/aio/downloader/cleaner/RubActivity;->total_show:J

    .line 98
    iput-wide v5, p0, Lcom/aio/downloader/cleaner/RubActivity;->total_wyc:J

    .line 108
    new-instance v0, Lcom/aio/downloader/cleaner/RubActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/RubActivity$1;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->handler2:Landroid/os/Handler;

    .line 336
    iput-boolean v4, p0, Lcom/aio/downloader/cleaner/RubActivity;->flag_clean:Z

    .line 338
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->cont_clean:D

    .line 344
    iput-boolean v4, p0, Lcom/aio/downloader/cleaner/RubActivity;->flag_cilcle:Z

    .line 345
    iput v2, p0, Lcom/aio/downloader/cleaner/RubActivity;->pos:I

    .line 346
    new-instance v0, Lcom/aio/downloader/cleaner/RubActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/RubActivity$2;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->handler:Landroid/os/Handler;

    .line 383
    iput-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 387
    iput-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 388
    iput-boolean v2, p0, Lcom/aio/downloader/cleaner/RubActivity;->widgetdetailfan:Z

    .line 511
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 512
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

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->PRO_DIR:Ljava/io/File;

    .line 71
    return-void
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 1269
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 1270
    const v1, 0x7f0b0034

    invoke-virtual {p0, v1}, Lcom/aio/downloader/cleaner/RubActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1271
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1272
    const-string v1, "Ok"

    .line 1273
    new-instance v2, Lcom/aio/downloader/cleaner/RubActivity$13;

    invoke-direct {v2, p0}, Lcom/aio/downloader/cleaner/RubActivity$13;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    .line 1272
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1280
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 1282
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 316
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->progress_wheel_wyc:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->scanningtv:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 309
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/lang/Double;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->roundDouble:Ljava/lang/Double;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 342
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->iv_ok1:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->releasedtime:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 1319
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getAssetFile()Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 514
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/RubActivity;->installApk()V

    return-void
.end method

.method static synthetic access$16(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 1268
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/RubActivity;->Mydialog()V

    return-void
.end method

.method static synthetic access$17(Lcom/aio/downloader/cleaner/RubActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;

    return-void
.end method

.method static synthetic access$18(Lcom/aio/downloader/cleaner/RubActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->systemTaskInfos:Ljava/util/List;

    return-void
.end method

.method static synthetic access$19(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->taskInfos:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_clear:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$20(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->systemTaskInfos:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$22(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->sp:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$23(Lcom/aio/downloader/cleaner/RubActivity;Landroid/widget/CheckBox;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->cb_process_state:Landroid/widget/CheckBox;

    return-void
.end method

.method static synthetic access$24(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/CheckBox;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->cb_process_state:Landroid/widget/CheckBox;

    return-object v0
.end method

.method static synthetic access$25()Z
    .locals 1

    .prologue
    .line 314
    sget-boolean v0, Lcom/aio/downloader/cleaner/RubActivity;->flag:Z

    return v0
.end method

.method static synthetic access$26()D
    .locals 2

    .prologue
    .line 92
    sget-wide v0, Lcom/aio/downloader/cleaner/RubActivity;->cont:D

    return-wide v0
.end method

.method static synthetic access$27(Z)V
    .locals 0

    .prologue
    .line 314
    sput-boolean p0, Lcom/aio/downloader/cleaner/RubActivity;->flag:Z

    return-void
.end method

.method static synthetic access$28(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/content/pm/PackageManager;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->pm:Landroid/content/pm/PackageManager;

    return-object v0
.end method

.method static synthetic access$29(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->pb:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/cleaner/RubActivity;Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->adapter:Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;

    return-void
.end method

.method static synthetic access$30(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 307
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_status:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$31(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 805
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/RubActivity;->killTask()V

    return-void
.end method

.method static synthetic access$32(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 324
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_ing:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$33(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 330
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_finish_rub:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$34(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 334
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->progress_wheel_wyc_rub1:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$35(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 332
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_jieguo_rub:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$36(Lcom/aio/downloader/cleaner/RubActivity;)I
    .locals 1

    .prologue
    .line 322
    iget v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I

    return v0
.end method

.method static synthetic access$37(Lcom/aio/downloader/cleaner/RubActivity;Z)V
    .locals 0

    .prologue
    .line 344
    iput-boolean p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->flag_cilcle:Z

    return-void
.end method

.method static synthetic access$38(Lcom/aio/downloader/cleaner/RubActivity;)Z
    .locals 1

    .prologue
    .line 344
    iget-boolean v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->flag_cilcle:Z

    return v0
.end method

.method static synthetic access$39(Lcom/aio/downloader/cleaner/RubActivity;)I
    .locals 1

    .prologue
    .line 345
    iget v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->pos:I

    return v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->adapter:Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;

    return-object v0
.end method

.method static synthetic access$40(Lcom/aio/downloader/cleaner/RubActivity;I)V
    .locals 0

    .prologue
    .line 345
    iput p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->pos:I

    return-void
.end method

.method static synthetic access$41(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/views/RoundProgressBar;
    .locals 1

    .prologue
    .line 340
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->rp_chuang1:Lcom/aio/downloader/views/RoundProgressBar;

    return-object v0
.end method

.method static synthetic access$42(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->handler2:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$43(Lcom/aio/downloader/cleaner/RubActivity;Z)V
    .locals 0

    .prologue
    .line 336
    iput-boolean p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->flag_clean:Z

    return-void
.end method

.method static synthetic access$44(Lcom/aio/downloader/cleaner/RubActivity;)Z
    .locals 1

    .prologue
    .line 336
    iget-boolean v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->flag_clean:Z

    return v0
.end method

.method static synthetic access$45(Lcom/aio/downloader/cleaner/RubActivity;)D
    .locals 2

    .prologue
    .line 338
    iget-wide v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->cont_clean:D

    return-wide v0
.end method

.method static synthetic access$46(Lcom/aio/downloader/cleaner/RubActivity;D)V
    .locals 0

    .prologue
    .line 338
    iput-wide p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->cont_clean:D

    return-void
.end method

.method static synthetic access$47(Lcom/aio/downloader/cleaner/RubActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 318
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->cleanSize:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$48(Lcom/aio/downloader/cleaner/RubActivity;Lcom/aio/downloader/cleaner/TaskInfoProvider;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->taskInfoProvider:Lcom/aio/downloader/cleaner/TaskInfoProvider;

    return-void
.end method

.method static synthetic access$49(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/cleaner/TaskInfoProvider;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->taskInfoProvider:Lcom/aio/downloader/cleaner/TaskInfoProvider;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->lv_process_list:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$50(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->runningAppProcessInfos:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$51(Lcom/aio/downloader/cleaner/RubActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->taskInfos:Ljava/util/List;

    return-void
.end method

.method static synthetic access$52(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/app/ActivityManager;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->activityManager:Landroid/app/ActivityManager;

    return-object v0
.end method

.method static synthetic access$53(Lcom/aio/downloader/cleaner/RubActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->totalMemory:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$54(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 386
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$55(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 381
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->default_options:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$56(Lcom/aio/downloader/cleaner/RubActivity;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 387
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method static synthetic access$57(Lcom/aio/downloader/cleaner/RubActivity;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 382
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/cleaner/RubActivity;J)V
    .locals 0

    .prologue
    .line 91
    iput-wide p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->getmem_SY:J

    return-void
.end method

.method static synthetic access$7(D)V
    .locals 0

    .prologue
    .line 92
    sput-wide p0, Lcom/aio/downloader/cleaner/RubActivity;->cont:D

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 311
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_danwei:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/cleaner/RubActivity;Ljava/lang/Double;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity;->roundDouble:Ljava/lang/Double;

    return-void
.end method

.method private downwifi()V
    .locals 4

    .prologue
    .line 1239
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    .line 1240
    const v3, 0x7f0c000e

    .line 1239
    invoke-direct {v0, p0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 1241
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 1242
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 1243
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 1244
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 1245
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/cleaner/RubActivity$11;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/cleaner/RubActivity$11;-><init>(Lcom/aio/downloader/cleaner/RubActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1254
    new-instance v3, Lcom/aio/downloader/cleaner/RubActivity$12;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/cleaner/RubActivity$12;-><init>(Lcom/aio/downloader/cleaner/RubActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1265
    return-void
.end method

.method private getAssetFile()Ljava/io/File;
    .locals 10

    .prologue
    .line 1320
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 1321
    .local v0, "asset":Landroid/content/res/AssetManager;
    const/4 v3, 0x0

    .line 1323
    .local v3, "f":Ljava/io/File;
    :try_start_0
    iget-object v8, p0, Lcom/aio/downloader/cleaner/RubActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->mkdirs()Z

    .line 1324
    const-string v8, "cleaner.apk"

    invoke-virtual {v0, v8}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v6

    .line 1325
    .local v6, "is":Ljava/io/InputStream;
    new-instance v4, Ljava/io/File;

    iget-object v8, p0, Lcom/aio/downloader/cleaner/RubActivity;->PRO_DIR:Ljava/io/File;

    const-string v9, "cleaner.apk"

    invoke-direct {v4, v8, v9}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 1326
    .end local v3    # "f":Ljava/io/File;
    .local v4, "f":Ljava/io/File;
    :try_start_1
    invoke-virtual {v4}, Ljava/io/File;->createNewFile()Z

    .line 1327
    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 1328
    .local v5, "fOut":Ljava/io/FileOutputStream;
    const/16 v8, 0x400

    new-array v1, v8, [B

    .line 1329
    .local v1, "buffer":[B
    const/4 v7, 0x0

    .line 1330
    .local v7, "len":I
    :goto_0
    invoke-virtual {v6, v1}, Ljava/io/InputStream;->read([B)I

    move-result v7

    const/4 v8, -0x1

    if-ne v7, v8, :cond_0

    .line 1333
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->flush()V

    .line 1334
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V

    .line 1335
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->close()V

    move-object v3, v4

    .line 1340
    .end local v1    # "buffer":[B
    .end local v4    # "f":Ljava/io/File;
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v6    # "is":Ljava/io/InputStream;
    .end local v7    # "len":I
    .restart local v3    # "f":Ljava/io/File;
    :goto_1
    return-object v4

    .line 1331
    .end local v3    # "f":Ljava/io/File;
    .restart local v1    # "buffer":[B
    .restart local v4    # "f":Ljava/io/File;
    .restart local v5    # "fOut":Ljava/io/FileOutputStream;
    .restart local v6    # "is":Ljava/io/InputStream;
    .restart local v7    # "len":I
    :cond_0
    const/4 v8, 0x0

    invoke-virtual {v5, v1, v8, v7}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 1337
    .end local v1    # "buffer":[B
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v7    # "len":I
    :catch_0
    move-exception v2

    move-object v3, v4

    .line 1338
    .end local v4    # "f":Ljava/io/File;
    .end local v6    # "is":Ljava/io/InputStream;
    .local v2, "e":Ljava/io/IOException;
    .restart local v3    # "f":Ljava/io/File;
    :goto_2
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    .line 1340
    const/4 v4, 0x0

    goto :goto_1

    .line 1337
    .end local v2    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v2

    goto :goto_2
.end method

.method private getAvailMemory()Ljava/lang/String;
    .locals 4

    .prologue
    .line 792
    new-instance v0, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v0}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 794
    .local v0, "memoryInfo":Landroid/app/ActivityManager$MemoryInfo;
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->activityManager:Landroid/app/ActivityManager;

    invoke-virtual {v3, v0}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 796
    iget-wide v1, v0, Landroid/app/ActivityManager$MemoryInfo;->availMem:J

    .line 797
    .local v1, "size":J
    invoke-static {v1, v2}, Lcom/aio/downloader/cleaner/TextFormater;->dataSizeFormat(J)Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method private getRunningAppCount()I
    .locals 1

    .prologue
    .line 786
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->activityManager:Landroid/app/ActivityManager;

    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->runningAppProcessInfos:Ljava/util/List;

    .line 787
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->runningAppProcessInfos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public static getmem_TOLAL()J
    .locals 12

    .prologue
    .line 1014
    const-string v9, "/proc/meminfo"

    .line 1015
    .local v9, "path":Ljava/lang/String;
    const/4 v3, 0x0

    .line 1016
    .local v3, "content":Ljava/lang/String;
    const/4 v1, 0x0

    .line 1018
    .local v1, "br":Ljava/io/BufferedReader;
    :try_start_0
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v10, Ljava/io/FileReader;

    invoke-direct {v10, v9}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    const/16 v11, 0x8

    invoke-direct {v2, v10, v11}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1020
    .end local v1    # "br":Ljava/io/BufferedReader;
    .local v2, "br":Ljava/io/BufferedReader;
    :try_start_1
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_7
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v6

    .local v6, "line":Ljava/lang/String;
    if-eqz v6, :cond_0

    .line 1021
    move-object v3, v6

    .line 1028
    :cond_0
    if-eqz v2, :cond_3

    .line 1030
    :try_start_2
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_5

    move-object v1, v2

    .line 1037
    .end local v2    # "br":Ljava/io/BufferedReader;
    .end local v6    # "line":Ljava/lang/String;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    :cond_1
    :goto_0
    const/16 v10, 0x3a

    invoke-virtual {v3, v10}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 1039
    .local v0, "begin":I
    const/16 v10, 0x6b

    invoke-virtual {v3, v10}, Ljava/lang/String;->indexOf(I)I

    move-result v5

    .line 1042
    .local v5, "end":I
    add-int/lit8 v10, v0, 0x1

    invoke-virtual {v3, v10, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 1043
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    int-to-long v7, v10

    .line 1044
    .local v7, "mTotal":J
    return-wide v7

    .line 1023
    .end local v0    # "begin":I
    .end local v5    # "end":I
    .end local v7    # "mTotal":J
    :catch_0
    move-exception v4

    .line 1024
    .local v4, "e":Ljava/io/FileNotFoundException;
    :goto_1
    :try_start_3
    invoke-virtual {v4}, Ljava/io/FileNotFoundException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1028
    if-eqz v1, :cond_1

    .line 1030
    :try_start_4
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_0

    .line 1031
    :catch_1
    move-exception v4

    .line 1032
    .local v4, "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 1025
    .end local v4    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v4

    .line 1026
    .restart local v4    # "e":Ljava/io/IOException;
    :goto_2
    :try_start_5
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 1028
    if-eqz v1, :cond_1

    .line 1030
    :try_start_6
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3

    goto :goto_0

    .line 1031
    :catch_3
    move-exception v4

    .line 1032
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 1027
    .end local v4    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v10

    .line 1028
    :goto_3
    if-eqz v1, :cond_2

    .line 1030
    :try_start_7
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_4

    .line 1035
    :cond_2
    :goto_4
    throw v10

    .line 1031
    :catch_4
    move-exception v4

    .line 1032
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 1031
    .end local v1    # "br":Ljava/io/BufferedReader;
    .end local v4    # "e":Ljava/io/IOException;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    .restart local v6    # "line":Ljava/lang/String;
    :catch_5
    move-exception v4

    .line 1032
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .end local v4    # "e":Ljava/io/IOException;
    :cond_3
    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_0

    .line 1027
    .end local v1    # "br":Ljava/io/BufferedReader;
    .end local v6    # "line":Ljava/lang/String;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    :catchall_1
    move-exception v10

    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_3

    .line 1025
    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    :catch_6
    move-exception v4

    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_2

    .line 1023
    .end local v1    # "br":Ljava/io/BufferedReader;
    .restart local v2    # "br":Ljava/io/BufferedReader;
    :catch_7
    move-exception v4

    move-object v1, v2

    .end local v2    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "br":Ljava/io/BufferedReader;
    goto :goto_1
.end method

.method private init()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 524
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 526
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p0}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 527
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->default_options:Ljava/util/HashMap;

    .line 528
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 529
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 530
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 531
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 533
    :try_start_0
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/cleaner/RubActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 534
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 533
    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 535
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 536
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 535
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->ds:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 541
    :goto_0
    const-string v0, "network"

    invoke-virtual {p0, v0, v6}, Lcom/aio/downloader/cleaner/RubActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->spnetworkre:Landroid/content/SharedPreferences;

    .line 544
    :try_start_1
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 545
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 551
    :cond_0
    :goto_1
    return-void

    .line 547
    :catch_0
    move-exception v0

    goto :goto_1

    .line 538
    :catch_1
    move-exception v0

    goto :goto_0
.end method

.method private initData()V
    .locals 3

    .prologue
    .line 755
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->activityManager:Landroid/app/ActivityManager;

    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->runningAppProcessInfos:Ljava/util/List;

    .line 756
    const-string v0, "qwe"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "runningAppProcessInfos="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity;->runningAppProcessInfos:Ljava/util/List;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 757
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/cleaner/RubActivity$9;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/RubActivity$9;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 782
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 783
    return-void
.end method

.method private initTitle()V
    .locals 1

    .prologue
    .line 801
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getAvailMemory()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->availMemory:Ljava/lang/String;

    .line 803
    return-void
.end method

.method private installApk()V
    .locals 3

    .prologue
    .line 515
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 517
    .local v0, "aa":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity;->PRO_DIR:Ljava/io/File;

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

    .line 518
    const-string v2, "application/vnd.android.package-archive"

    .line 516
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 519
    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->startActivity(Landroid/content/Intent;)V

    .line 520
    return-void
.end method

.method private killTask()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    const/16 v7, 0x8

    .line 806
    const/4 v2, 0x0

    .line 807
    .local v2, "total":I
    iput v8, p0, Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I

    .line 808
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->systemTaskInfos:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_2

    .line 819
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_3

    .line 829
    const-string v3, "eee"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "memorySize="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v5, p0, Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 831
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;

    const/high16 v4, 0x41f00000    # 30.0f

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextSize(F)V

    .line 832
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Released:"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v5, p0, Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I

    int-to-long v5, v5

    invoke-static {v5, v6}, Lcom/aio/downloader/cleaner/TextFormater;->getSizeFromKB(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 833
    iget v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I

    int-to-long v3, v3

    invoke-static {v3, v4}, Lcom/aio/downloader/cleaner/TextFormater;->getSizeFromKB(J)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->memory:Ljava/lang/String;

    .line 834
    const-string v3, "www"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "memory="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity;->memory:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 835
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_danwei:Landroid/widget/TextView;

    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 836
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_zhuantai:Landroid/widget/TextView;

    invoke-virtual {v3, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 837
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_clear:Landroid/widget/Button;

    invoke-virtual {v3, v7}, Landroid/widget/Button;->setVisibility(I)V

    .line 838
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->rp_chuang1:Lcom/aio/downloader/views/RoundProgressBar;

    invoke-virtual {v3, v8}, Lcom/aio/downloader/views/RoundProgressBar;->setVisibility(I)V

    .line 840
    new-instance v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;

    invoke-direct {v3, p0}, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    iput-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->adapter:Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;

    .line 841
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 842
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->adapter:Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;

    .line 841
    invoke-direct {v0, v3}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 843
    .local v0, "swingBottomInAnimationAdapter":Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->lv_process_list:Landroid/widget/ListView;

    invoke-virtual {v0, v3}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 844
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity;->lv_process_list:Landroid/widget/ListView;

    invoke-virtual {v3, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 846
    return-void

    .line 808
    .end local v0    # "swingBottomInAnimationAdapter":Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;
    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/cleaner/TaskInfo;

    .line 809
    .local v1, "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->isCheck()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 811
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity;->activityManager:Landroid/app/ActivityManager;

    .line 812
    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    .line 811
    invoke-virtual {v4, v5}, Landroid/app/ActivityManager;->killBackgroundProcesses(Ljava/lang/String;)V

    .line 813
    add-int/lit8 v2, v2, 0x1

    .line 814
    iget v4, p0, Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->getMemory()I

    move-result v5

    add-int/2addr v4, v5

    iput v4, p0, Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I

    .line 815
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity;->taskInfos:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 819
    .end local v1    # "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/cleaner/TaskInfo;

    .line 820
    .restart local v1    # "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->isCheck()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 821
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity;->activityManager:Landroid/app/ActivityManager;

    .line 822
    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    .line 821
    invoke-virtual {v4, v5}, Landroid/app/ActivityManager;->killBackgroundProcesses(Ljava/lang/String;)V

    .line 823
    add-int/lit8 v2, v2, 0x1

    .line 824
    iget v4, p0, Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->getMemory()I

    move-result v5

    add-int/2addr v4, v5

    iput v4, p0, Lcom/aio/downloader/cleaner/RubActivity;->memorySize:I

    .line 825
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity;->taskInfos:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_1
.end method

.method public static roundDouble(DI)Ljava/lang/Double;
    .locals 8
    .param p0, "val"    # D
    .param p2, "precision"    # I

    .prologue
    .line 1067
    const/4 v3, 0x0

    .line 1069
    .local v3, "ret":Ljava/lang/Double;
    const-wide/high16 v4, 0x4024000000000000L    # 10.0

    int-to-double v6, p2

    :try_start_0
    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v1

    .line 1070
    .local v1, "factor":D
    mul-double v4, p0, v1

    const-wide/high16 v6, 0x3fe0000000000000L    # 0.5

    add-double/2addr v4, v6

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    div-double/2addr v4, v1

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 1074
    .end local v1    # "factor":D
    :goto_0
    return-object v3

    .line 1071
    :catch_0
    move-exception v0

    .line 1072
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
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

    .line 1093
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 1095
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 1096
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 1098
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1100
    const-string v0, "Failed to connect server. Please try again."

    .line 1099
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 1101
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 1235
    :goto_0
    return-void

    .line 1104
    :cond_0
    new-instance v0, Lcom/aio/downloader/cleaner/RubActivity$10;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/cleaner/RubActivity$10;-><init>(Lcom/aio/downloader/cleaner/RubActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 1232
    invoke-virtual {v0, v1}, Lcom/aio/downloader/cleaner/RubActivity$10;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public getCacheInfo(Ljava/lang/String;)V
    .locals 0
    .param p1, "packname"    # Ljava/lang/String;

    .prologue
    .line 1008
    return-void
.end method

.method public initView()V
    .locals 6

    .prologue
    .line 1079
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->initView()V

    .line 1082
    :try_start_0
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    new-instance v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 1083
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 1082
    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1089
    :goto_0
    return-void

    .line 1084
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 745
    invoke-super {p0, p1, p2, p3}, Lcom/aio/downloader/mydownload/BaseActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 747
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_0

    .line 748
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/RubActivity;->initData()V

    .line 750
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 555
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 741
    :goto_0
    return-void

    .line 557
    :pswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "Cleaning..."

    invoke-static {v0, v1, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 560
    :pswitch_1
    iget v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->i:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->i:I

    .line 561
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_clear:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 562
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_ing:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 563
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_danwei:Landroid/widget/TextView;

    const-string v1, "MB"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 565
    sput-boolean v3, Lcom/aio/downloader/cleaner/RubActivity;->flag:Z

    .line 566
    new-instance v0, Lcom/aio/downloader/cleaner/RubActivity$7;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/RubActivity$7;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    .line 600
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/RubActivity$7;->start()V

    .line 602
    new-instance v0, Lcom/aio/downloader/cleaner/RubActivity$8;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/RubActivity$8;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    new-array v1, v2, [Ljava/lang/Void;

    .line 736
    invoke-virtual {v0, v1}, Lcom/aio/downloader/cleaner/RubActivity$8;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 555
    :pswitch_data_0
    .packed-switch 0x7f0703ab
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 392
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 393
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->requestWindowFeature(I)Z

    .line 394
    invoke-virtual {p0, p0}, Lcom/aio/downloader/cleaner/RubActivity;->setmContext(Landroid/content/Context;)V

    .line 396
    const-string v0, "config"

    invoke-virtual {p0, v0, v3}, Lcom/aio/downloader/cleaner/RubActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->sp:Landroid/content/SharedPreferences;

    .line 398
    const-string v0, "activity"

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->activityManager:Landroid/app/ActivityManager;

    .line 399
    const v0, 0x7f0300ac

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->setContentView(I)V

    .line 400
    const v0, 0x7f0703b0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->header_left_showclean2_rub:Landroid/widget/ImageView;

    .line 401
    const v0, 0x7f0703b5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->btnfinish:Landroid/widget/Button;

    .line 403
    const v0, 0x7f0703b3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->releasedtime:Landroid/widget/TextView;

    .line 404
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->btnfinish:Landroid/widget/Button;

    new-instance v1, Lcom/aio/downloader/cleaner/RubActivity$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/RubActivity$3;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 415
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->header_left_showclean2_rub:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/cleaner/RubActivity$4;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/RubActivity$4;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 427
    const v0, 0x7f0703a3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->header_left_fanghui1:Landroid/widget/ImageView;

    .line 428
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->header_left_fanghui1:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/cleaner/RubActivity$5;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/RubActivity$5;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 442
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getAvailMemory()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->availMemory:Ljava/lang/String;

    .line 443
    new-instance v0, Lcom/aio/downloader/cleaner/Bean;

    invoke-direct {v0}, Lcom/aio/downloader/cleaner/Bean;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bean:Lcom/aio/downloader/cleaner/Bean;

    .line 444
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->pm:Landroid/content/pm/PackageManager;

    .line 446
    const v0, 0x7f070031

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->pb:Landroid/widget/ProgressBar;

    .line 448
    const v0, 0x7f0703a8

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->lv_process_list:Landroid/widget/ListView;

    .line 449
    const v0, 0x7f0703ab

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_clear:Landroid/widget/Button;

    .line 450
    const v0, 0x7f0703a7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_status:Landroid/widget/TextView;

    .line 451
    const v0, 0x7f0703a4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_neicun:Landroid/widget/TextView;

    .line 452
    const v0, 0x7f0703a5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_danwei:Landroid/widget/TextView;

    .line 453
    const v0, 0x7f0703a6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_zhuantai:Landroid/widget/TextView;

    .line 454
    const v0, 0x7f0703b4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_jieguo_rub:Landroid/widget/TextView;

    .line 455
    const v0, 0x7f0703aa

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->progress_wheel_wyc:Lcom/aio/downloader/utils/ProgressWheel;

    .line 456
    const v0, 0x7f0703ae

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->progress_wheel_wyc_rub1:Lcom/aio/downloader/utils/ProgressWheel;

    .line 457
    const v0, 0x7f0703b6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->scanningtv:Landroid/widget/TextView;

    .line 458
    const v0, 0x7f0703b1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/RoundProgressBar;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->rp_chuang1:Lcom/aio/downloader/views/RoundProgressBar;

    .line 459
    const v0, 0x7f0703b2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->iv_ok1:Landroid/widget/ImageView;

    .line 460
    const v0, 0x7f0703a2

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->iv_bg:Landroid/widget/ImageView;

    .line 461
    const v0, 0x7f0703ac

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_ing:Landroid/widget/Button;

    .line 462
    const v0, 0x7f0703ad

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_finish_rub:Landroid/widget/Button;

    .line 463
    const v0, 0x7f0703a9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->tv_best:Landroid/widget/TextView;

    .line 464
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->progress_wheel_wyc:Lcom/aio/downloader/utils/ProgressWheel;

    invoke-virtual {v0, v3}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 465
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->scanningtv:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 466
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_clear:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 467
    const-string v0, "eee"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u5185\u5b58"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getAvailMemory()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 471
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_clear:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 472
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->bt_process_ing:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 473
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/RubActivity;->initData()V

    .line 475
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->lv_process_list:Landroid/widget/ListView;

    new-instance v1, Lcom/aio/downloader/cleaner/RubActivity$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/RubActivity$6;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 506
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/RubActivity;->init()V

    .line 507
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/RubActivity;->initView()V

    .line 508
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "widgetdetailfan"

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->widgetdetailfan:Z

    .line 509
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 1315
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 1316
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 1317
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 1308
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onResume()V

    .line 1309
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 1310
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 1287
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 1288
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/RubActivity;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 1289
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "download"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/RubActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 1292
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 1293
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 1294
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 1292
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 1295
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 1297
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 1303
    :goto_0
    return-void

    .line 1300
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 1301
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 1300
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
