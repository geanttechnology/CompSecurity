.class public Lcom/aio/downloader/service/ServiceUpdate;
.super Landroid/app/Service;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/service/ServiceUpdate$Mya5;,
        Lcom/aio/downloader/service/ServiceUpdate$Mya7;
    }
.end annotation


# static fields
.field protected static final STATUS_BAR_COVER_CLICK_UPDATE:Ljava/lang/String; = "update"

.field protected static final STATUS_BAR_COVER_PAID:Ljava/lang/String; = "paid"

.field protected static final STATUS_BAR_COVER_PICK:Ljava/lang/String; = "pick"

.field protected static final STATUS_BAR_COVER_PICK_BIG:Ljava/lang/String; = "pick_big"

.field protected static final STATUS_BAR_DOWNLOAD_INSTALL:Ljava/lang/String; = "status_bar_download_install"

.field protected static final STATUS_BAR_DOWNLOAD_SUCCESS:Ljava/lang/String; = "status_bar_download_success"

.field public static mNotificationManager3:Landroid/app/NotificationManager;


# instance fields
.field private final ACTION_NAME_UPDATE:Ljava/lang/String;

.field private final ACTION_NAME_UPDATE_FLAG:Ljava/lang/String;

.field private final ACTION_NAME_UPDATE_UPDATE:Ljava/lang/String;

.field private AIOCALLERAPK:Ljava/io/File;

.field private AIOCALLERDOWN:Ljava/io/File;

.field private final DOWNLOADINSTALL:Ljava/lang/String;

.field private final DOWNLOADSUCCESS:Ljava/lang/String;

.field private final MEIRI:Ljava/lang/String;

.field private final MEIRIBIG:Ljava/lang/String;

.field private final PAIDPPP:Ljava/lang/String;

.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private appHandler:Landroid/os/Handler;

.field appIcon:Landroid/graphics/drawable/Drawable;

.field appIcondown:Landroid/graphics/drawable/Drawable;

.field appIconinstall:Landroid/graphics/drawable/Drawable;

.field appName:Ljava/lang/String;

.field appNamedown:Ljava/lang/String;

.field appNameinstall:Ljava/lang/String;

.field appVersion:Ljava/lang/String;

.field appid:Ljava/lang/String;

.field private appid_down:Ljava/lang/String;

.field private appidinstall:Ljava/lang/String;

.field private appurl:Ljava/lang/String;

.field private appversion2:Ljava/lang/String;

.field private callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;

.field private clean_box:I

.field private cleanerUpdateDialog:Lcom/aio/downloader/dialog/CleanerUpdateDialog;

.field private cleanermusterDialog:Lcom/aio/downloader/dialog/CleanermusterDialog;

.field private cleanertoolboxDialog:Lcom/aio/downloader/dialog/CleanertoolboxDialog;

.field private cleanerupdate:I

.field private dEVICE_ID:Ljava/lang/String;

.field private dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;

.field private filepathdown:Ljava/lang/String;

.field private handler:Landroid/os/Handler;

.field private icon_pick:Ljava/lang/String;

.field private icon_pick1:Ljava/lang/String;

.field private id_meiri:Ljava/lang/String;

.field private id_meiribig:Ljava/lang/String;

.field private iddown:Ljava/lang/String;

.field private img_pick:Ljava/lang/String;

.field private itemsOnClick4:Landroid/view/View$OnClickListener;

.field private jsonArray:Lorg/json/JSONArray;

.field list_pick:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field list_update:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private mBroadcastReceiver:Landroid/content/BroadcastReceiver;

.field public mListInfo:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/AppInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mNotificationManager1:Landroid/app/NotificationManager;

.field private mNotificationManager2:Landroid/app/NotificationManager;

.field private mNotificationManager4:Landroid/app/NotificationManager;

.field private mNotificationManager8:Landroid/app/NotificationManager;

.field private mNotificationManager9:Landroid/app/NotificationManager;

.field private notification_down:Landroid/app/Notification;

.field private notification_i:Landroid/app/Notification;

.field private notification_install:Landroid/app/Notification;

.field private notification_ram:Landroid/app/Notification;

.field onClickReceiver:Landroid/content/BroadcastReceiver;

.field private serial:I

.field sharedPreferences:Landroid/content/SharedPreferences;

.field private short_desc:Ljava/lang/String;

.field private short_desc1:Ljava/lang/String;

.field private title_pick:Ljava/lang/String;

.field private title_pick1:Ljava/lang/String;

.field private upJsonStr:Ljava/lang/String;

.field private url1:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 87
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 99
    const-string v0, "\u53d1\u9001\u5347\u7ea7\u5e7f\u64ad"

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->ACTION_NAME_UPDATE:Ljava/lang/String;

    .line 100
    const-string v0, "\u53d1\u9001\u5347\u7ea7\u5e7f\u64ad\u6807\u793a"

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->ACTION_NAME_UPDATE_FLAG:Ljava/lang/String;

    .line 101
    const-string v0, "setbroadUpdate"

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->ACTION_NAME_UPDATE_UPDATE:Ljava/lang/String;

    .line 102
    const-string v0, "meiri"

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->MEIRI:Ljava/lang/String;

    .line 103
    const-string v0, "meiribig"

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->MEIRIBIG:Ljava/lang/String;

    .line 104
    const-string v0, "paidppp"

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->PAIDPPP:Ljava/lang/String;

    .line 111
    const-string v0, "downloadsuccess"

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->DOWNLOADSUCCESS:Ljava/lang/String;

    .line 112
    const-string v0, "downloadinstall"

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->DOWNLOADINSTALL:Ljava/lang/String;

    .line 130
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 131
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

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->PRO_DIR_FOME:Ljava/io/File;

    .line 132
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 133
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

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->PRO_DIR_TO:Ljava/io/File;

    .line 134
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 135
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

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->PRO_DIR:Ljava/io/File;

    .line 147
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    .line 153
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->mListInfo:Ljava/util/List;

    .line 154
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->list_update:Ljava/util/ArrayList;

    .line 162
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 163
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 164
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 165
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->AIOCALLERDOWN:Ljava/io/File;

    .line 166
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 167
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 168
    const-string v2, "/AIOSWF"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 169
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "caller.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->AIOCALLERAPK:Ljava/io/File;

    .line 170
    iput v3, p0, Lcom/aio/downloader/service/ServiceUpdate;->clean_box:I

    .line 171
    iput v3, p0, Lcom/aio/downloader/service/ServiceUpdate;->cleanerupdate:I

    .line 178
    new-instance v0, Lcom/aio/downloader/service/ServiceUpdate$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/service/ServiceUpdate$1;-><init>(Lcom/aio/downloader/service/ServiceUpdate;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->appHandler:Landroid/os/Handler;

    .line 230
    new-instance v0, Lcom/aio/downloader/service/ServiceUpdate$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/service/ServiceUpdate$2;-><init>(Lcom/aio/downloader/service/ServiceUpdate;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->handler:Landroid/os/Handler;

    .line 1381
    new-instance v0, Lcom/aio/downloader/service/ServiceUpdate$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/service/ServiceUpdate$3;-><init>(Lcom/aio/downloader/service/ServiceUpdate;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->onClickReceiver:Landroid/content/BroadcastReceiver;

    .line 1457
    new-instance v0, Lcom/aio/downloader/service/ServiceUpdate$4;

    invoke-direct {v0, p0}, Lcom/aio/downloader/service/ServiceUpdate$4;-><init>(Lcom/aio/downloader/service/ServiceUpdate;)V

    iput-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 87
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceUpdate;)Lcom/aio/downloader/dialog/InstallfirstDialog;
    .locals 1

    .prologue
    .line 1904
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 148
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->icon_pick:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->icon_pick1:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->title_pick1:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->short_desc1:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->id_meiri:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->icon_pick:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->title_pick:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$16(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->short_desc:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$17(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->img_pick:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$18(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->id_meiribig:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$19(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->itemsOnClick4:Landroid/view/View$OnClickListener;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->title_pick:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$20(Lcom/aio/downloader/service/ServiceUpdate;Lcom/aio/downloader/dialog/CallerOutDialog1;)V
    .locals 0

    .prologue
    .line 174
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;

    return-void
.end method

.method static synthetic access$21(Lcom/aio/downloader/service/ServiceUpdate;)Lcom/aio/downloader/dialog/CallerOutDialog1;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;

    return-object v0
.end method

.method static synthetic access$22(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->appurl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$23(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->appversion2:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$24(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->filepathdown:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$25(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->appidinstall:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$26(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->appurl:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$27(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->appversion2:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$28(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/NotificationManager;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager1:Landroid/app/NotificationManager;

    return-void
.end method

.method static synthetic access$29(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/Notification;)V
    .locals 0

    .prologue
    .line 94
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->notification_ram:Landroid/app/Notification;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->short_desc:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$30(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->notification_ram:Landroid/app/Notification;

    return-object v0
.end method

.method static synthetic access$31(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/NotificationManager;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager1:Landroid/app/NotificationManager;

    return-object v0
.end method

.method static synthetic access$32(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/NotificationManager;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager8:Landroid/app/NotificationManager;

    return-void
.end method

.method static synthetic access$33(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/NotificationManager;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager8:Landroid/app/NotificationManager;

    return-object v0
.end method

.method static synthetic access$34(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/NotificationManager;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager9:Landroid/app/NotificationManager;

    return-void
.end method

.method static synthetic access$35(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/NotificationManager;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager9:Landroid/app/NotificationManager;

    return-object v0
.end method

.method static synthetic access$36(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/NotificationManager;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager2:Landroid/app/NotificationManager;

    return-void
.end method

.method static synthetic access$37(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/NotificationManager;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager2:Landroid/app/NotificationManager;

    return-object v0
.end method

.method static synthetic access$38(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->appid_down:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$39(Lcom/aio/downloader/service/ServiceUpdate;I)V
    .locals 0

    .prologue
    .line 141
    iput p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->serial:I

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->img_pick:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$40(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->filepathdown:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$41(Lcom/aio/downloader/service/ServiceUpdate;)I
    .locals 1

    .prologue
    .line 141
    iget v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->serial:I

    return v0
.end method

.method static synthetic access$42(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 144
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->iddown:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$43(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/Notification;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->notification_down:Landroid/app/Notification;

    return-void
.end method

.method static synthetic access$44(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->notification_down:Landroid/app/Notification;

    return-object v0
.end method

.method static synthetic access$45(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->iddown:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$46(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->appidinstall:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$47(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/NotificationManager;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager4:Landroid/app/NotificationManager;

    return-void
.end method

.method static synthetic access$48(Lcom/aio/downloader/service/ServiceUpdate;Landroid/app/Notification;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->notification_install:Landroid/app/Notification;

    return-void
.end method

.method static synthetic access$49(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/Notification;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->notification_install:Landroid/app/Notification;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 139
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->id_meiribig:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$50(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/app/NotificationManager;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->mNotificationManager4:Landroid/app/NotificationManager;

    return-object v0
.end method

.method static synthetic access$51(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->upJsonStr:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$52(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/io/File;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->AIOCALLERAPK:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$53(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/io/File;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->AIOCALLERDOWN:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$54(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 230
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$55(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 156
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->url1:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$56(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->url1:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$57(Lcom/aio/downloader/service/ServiceUpdate;)Lorg/json/JSONArray;
    .locals 1

    .prologue
    .line 1905
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->jsonArray:Lorg/json/JSONArray;

    return-object v0
.end method

.method static synthetic access$58(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->dEVICE_ID:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$59(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 151
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->upJsonStr:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->icon_pick1:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$60(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate;->appHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->title_pick1:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 159
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->short_desc1:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$9(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate;->id_meiri:Ljava/lang/String;

    return-void
.end method

.method public static drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 7
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v6, 0x0

    .line 1913
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v3

    .line 1915
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v4

    .line 1917
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v2

    const/4 v5, -0x1

    if-eq v2, v5, :cond_0

    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    .line 1911
    :goto_0
    invoke-static {v3, v4, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 1921
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 1925
    .local v1, "canvas":Landroid/graphics/Canvas;
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 1926
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v3

    .line 1925
    invoke-virtual {p0, v6, v6, v2, v3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1928
    invoke-virtual {p0, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1930
    return-object v0

    .line 1919
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "canvas":Landroid/graphics/Canvas;
    :cond_0
    sget-object v2, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    goto :goto_0
.end method

.method private getNewApps()V
    .locals 2

    .prologue
    .line 2018
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/service/ServiceUpdate$9;

    invoke-direct {v1, p0}, Lcom/aio/downloader/service/ServiceUpdate$9;-><init>(Lcom/aio/downloader/service/ServiceUpdate;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 2066
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 2067
    return-void
.end method


# virtual methods
.method public HttpGetData()Ljava/lang/String;
    .locals 7

    .prologue
    .line 2177
    const/4 v4, 0x0

    .line 2179
    .local v4, "rev":Ljava/lang/String;
    :try_start_0
    new-instance v2, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v2}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 2180
    .local v2, "httpclient":Lorg/apache/http/client/HttpClient;
    const-string v5, "http://127.0.0.0"

    .line 2181
    .local v5, "uri":Ljava/lang/String;
    new-instance v1, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v1, v5}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 2185
    .local v1, "get":Lorg/apache/http/client/methods/HttpGet;
    invoke-interface {v2, v1}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v3

    .line 2186
    .local v3, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v3}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v6

    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v0

    .line 2188
    .local v0, "code":I
    const/16 v6, 0xc8

    if-ne v0, v6, :cond_0

    .line 2190
    invoke-interface {v3}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v6

    invoke-static {v6}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 2195
    .end local v0    # "code":I
    .end local v1    # "get":Lorg/apache/http/client/methods/HttpGet;
    .end local v2    # "httpclient":Lorg/apache/http/client/HttpClient;
    .end local v3    # "response":Lorg/apache/http/HttpResponse;
    .end local v5    # "uri":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v4

    .line 2192
    :catch_0
    move-exception v6

    goto :goto_0
.end method

.method public getAllAppInfo()V
    .locals 20

    .prologue
    .line 1936
    invoke-virtual/range {p0 .. p0}, Lcom/aio/downloader/service/ServiceUpdate;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v14

    .line 1938
    .local v14, "pm":Landroid/content/pm/PackageManager;
    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v13

    .line 1940
    .local v13, "packs":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/PackageInfo;>;"
    const-string v15, "qew"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-interface {v13}, Ljava/util/List;->size()I

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v17

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1942
    new-instance v15, Lorg/json/JSONArray;

    invoke-direct {v15}, Lorg/json/JSONArray;-><init>()V

    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/aio/downloader/service/ServiceUpdate;->jsonArray:Lorg/json/JSONArray;

    .line 1944
    new-instance v5, Landroid/os/Build;

    invoke-direct {v5}, Landroid/os/Build;-><init>()V

    .line 1945
    .local v5, "bd":Landroid/os/Build;
    const/4 v8, 0x0

    .line 1946
    .local v8, "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v8, Ljava/util/HashMap;

    .end local v8    # "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 1947
    .restart local v8    # "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    invoke-interface {v13}, Ljava/util/List;->size()I

    move-result v15

    if-lt v7, v15, :cond_0

    .line 2011
    const-string v15, "qew"

    new-instance v16, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->mListInfo:Ljava/util/List;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ljava/util/List;->size()I

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v17

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2012
    const-string v15, "qew"

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "jsonArray="

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate;->jsonArray:Lorg/json/JSONArray;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2014
    return-void

    .line 1949
    :cond_0
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10}, Lorg/json/JSONObject;-><init>()V

    .line 1951
    .local v10, "object":Lorg/json/JSONObject;
    new-instance v9, Lcom/aio/downloader/model/AppInfo;

    invoke-direct {v9}, Lcom/aio/downloader/model/AppInfo;-><init>()V

    .line 1953
    .local v9, "info":Lcom/aio/downloader/model/AppInfo;
    invoke-interface {v13, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/content/pm/PackageInfo;

    .line 1955
    .local v11, "p":Landroid/content/pm/PackageInfo;
    iget-object v2, v11, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 1957
    .local v2, "app":Landroid/content/pm/ApplicationInfo;
    iget v15, v2, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v15, v15, 0x1

    if-gtz v15, :cond_1

    .line 1964
    invoke-virtual {v14, v2}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v15

    invoke-interface {v15}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1966
    .local v3, "appname":Ljava/lang/String;
    iget-object v12, v11, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    .line 1968
    .local v12, "packagename":Ljava/lang/String;
    iget-object v4, v11, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    .line 1970
    .local v4, "appversion":Ljava/lang/String;
    const-string v15, "appname"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v14, v2}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v16

    .line 1971
    iget-object v0, v11, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 1970
    invoke-static/range {v15 .. v16}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1973
    invoke-virtual {v9, v3}, Lcom/aio/downloader/model/AppInfo;->setAppname(Ljava/lang/String;)V

    .line 1975
    invoke-virtual {v9, v12}, Lcom/aio/downloader/model/AppInfo;->setP_name(Ljava/lang/String;)V

    .line 1977
    invoke-virtual {v14, v2}, Landroid/content/pm/PackageManager;->getApplicationIcon(Landroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;

    move-result-object v15

    invoke-virtual {v9, v15}, Lcom/aio/downloader/model/AppInfo;->setAvatar(Landroid/graphics/drawable/Drawable;)V

    .line 1979
    invoke-virtual {v9, v4}, Lcom/aio/downloader/model/AppInfo;->setVersion(Ljava/lang/String;)V

    .line 1993
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/service/ServiceUpdate;->mListInfo:Ljava/util/List;

    invoke-interface {v15, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1996
    :try_start_0
    const-string v15, "title"

    invoke-virtual {v10, v15, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1997
    const-string v15, "url_id"

    invoke-virtual {v10, v15, v12}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1998
    const-string v15, "version"

    invoke-virtual {v10, v15, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 1999
    const-string v15, "install_time"

    .line 2000
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v16

    const-wide/16 v18, 0x3e8

    div-long v16, v16, v18

    .line 1999
    move-wide/from16 v0, v16

    invoke-virtual {v10, v15, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 2006
    :goto_1
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/aio/downloader/service/ServiceUpdate;->jsonArray:Lorg/json/JSONArray;

    invoke-virtual {v15, v10}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 1947
    .end local v3    # "appname":Ljava/lang/String;
    .end local v4    # "appversion":Ljava/lang/String;
    .end local v12    # "packagename":Ljava/lang/String;
    :cond_1
    add-int/lit8 v7, v7, 0x1

    goto/16 :goto_0

    .line 2001
    .restart local v3    # "appname":Ljava/lang/String;
    .restart local v4    # "appversion":Ljava/lang/String;
    .restart local v12    # "packagename":Ljava/lang/String;
    :catch_0
    move-exception v6

    .line 2003
    .local v6, "e":Lorg/json/JSONException;
    invoke-virtual {v6}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
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
    .line 2165
    const-wide/16 v1, 0x0

    .line 2166
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2167
    const/4 v0, 0x0

    .line 2168
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 2169
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 2173
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 2171
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 1448
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 13

    .prologue
    const/4 v12, 0x0

    .line 416
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 418
    new-instance v2, Lcom/aio/downloader/service/ServiceUpdate$5;

    invoke-direct {v2, p0}, Lcom/aio/downloader/service/ServiceUpdate$5;-><init>(Lcom/aio/downloader/service/ServiceUpdate;)V

    iput-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate;->itemsOnClick4:Landroid/view/View$OnClickListener;

    .line 489
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 490
    .local v0, "time":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/service/ServiceUpdate$6;

    invoke-direct {v1, p0}, Lcom/aio/downloader/service/ServiceUpdate$6;-><init>(Lcom/aio/downloader/service/ServiceUpdate;)V

    .line 501
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3e8

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 504
    new-instance v2, Lcom/aio/downloader/service/ServiceUpdate$7;

    invoke-direct {v2, p0}, Lcom/aio/downloader/service/ServiceUpdate$7;-><init>(Lcom/aio/downloader/service/ServiceUpdate;)V

    .line 519
    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate$7;->start()V

    .line 521
    new-instance v2, Lcom/aio/downloader/service/ServiceUpdate$8;

    invoke-direct {v2, p0}, Lcom/aio/downloader/service/ServiceUpdate$8;-><init>(Lcom/aio/downloader/service/ServiceUpdate;)V

    .line 568
    invoke-virtual {v2}, Lcom/aio/downloader/service/ServiceUpdate$8;->start()V

    .line 570
    new-instance v7, Landroid/content/IntentFilter;

    invoke-direct {v7}, Landroid/content/IntentFilter;-><init>()V

    .line 572
    .local v7, "filter":Landroid/content/IntentFilter;
    const-string v2, "update"

    invoke-virtual {v7, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 573
    const-string v2, "pick"

    invoke-virtual {v7, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 574
    const-string v2, "pick_big"

    invoke-virtual {v7, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 575
    const-string v2, "paid"

    invoke-virtual {v7, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 576
    const-string v2, "status_bar_download_success"

    invoke-virtual {v7, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 577
    const-string v2, "status_bar_download_install"

    invoke-virtual {v7, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 578
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate;->onClickReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v7}, Lcom/aio/downloader/service/ServiceUpdate;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 580
    new-instance v9, Landroid/content/IntentFilter;

    invoke-direct {v9}, Landroid/content/IntentFilter;-><init>()V

    .line 581
    .local v9, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v2, "\u53d1\u9001\u5347\u7ea7\u5e7f\u64ad"

    invoke-virtual {v9, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 582
    const-string v2, "setbroadUpdate"

    invoke-virtual {v9, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 583
    const-string v2, "meiri"

    invoke-virtual {v9, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 584
    const-string v2, "meiribig"

    invoke-virtual {v9, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 585
    const-string v2, "paidppp"

    invoke-virtual {v9, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 586
    const-string v2, "downloadsuccess"

    invoke-virtual {v9, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 587
    const-string v2, "downloadinstall"

    invoke-virtual {v9, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 589
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v2, v9}, Lcom/aio/downloader/service/ServiceUpdate;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 591
    const-string v2, "countName_first"

    invoke-virtual {p0, v2, v12}, Lcom/aio/downloader/service/ServiceUpdate;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate;->sharedPreferences:Landroid/content/SharedPreferences;

    .line 593
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate;->sharedPreferences:Landroid/content/SharedPreferences;

    const-string v3, "iFirst1"

    invoke-interface {v2, v3, v12}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v8

    .line 594
    .local v8, "installFirst":I
    const-string v2, "qwa"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "installFirst="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 595
    const/4 v10, 0x0

    .line 597
    .local v10, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/service/ServiceUpdate;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 598
    const-string v3, "com.evzapp.cleanmaster"

    const/4 v4, 0x0

    .line 597
    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v10

    .line 1292
    :goto_0
    invoke-virtual {p0}, Lcom/aio/downloader/service/ServiceUpdate;->getAllAppInfo()V

    .line 1294
    const-string v2, "phone"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/service/ServiceUpdate;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v11

    .line 1293
    check-cast v11, Landroid/telephony/TelephonyManager;

    .line 1295
    .local v11, "tm":Landroid/telephony/TelephonyManager;
    invoke-virtual {v11}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/service/ServiceUpdate;->dEVICE_ID:Ljava/lang/String;

    .line 1296
    const-string v2, "gog"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "DEVICE_ID="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/aio/downloader/service/ServiceUpdate;->dEVICE_ID:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\u624b\u673a\u578b\u53f7\uff1a"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 1297
    sget-object v4, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1296
    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1299
    invoke-direct {p0}, Lcom/aio/downloader/service/ServiceUpdate;->getNewApps()V

    .line 1300
    return-void

    .line 599
    .end local v11    # "tm":Landroid/telephony/TelephonyManager;
    :catch_0
    move-exception v6

    .line 600
    .local v6, "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v10, 0x0

    .line 601
    invoke-virtual {v6}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 1454
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 1455
    return-void
.end method
