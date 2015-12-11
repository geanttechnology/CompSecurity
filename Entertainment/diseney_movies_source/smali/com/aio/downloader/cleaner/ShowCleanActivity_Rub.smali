.class public Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "ShowCleanActivity_Rub.java"


# instance fields
.field private btnfinish:Landroid/widget/Button;

.field private cleanSize:Ljava/lang/String;

.field private cont:D

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

.field private flag:Z

.field handler:Landroid/os/Handler;

.field private handlerdonghua:Landroid/os/Handler;

.field private header_left_showclean:Landroid/widget/ImageView;

.field private progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private relaquan:Landroid/widget/RelativeLayout;

.field private roundDouble1:Ljava/lang/Double;

.field private spnetworkre:Landroid/content/SharedPreferences;

.field private tv_jieguo:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 57
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 59
    new-instance v0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$1;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->handler:Landroid/os/Handler;

    .line 96
    iput-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 100
    iput-object v1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 104
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->flag:Z

    .line 105
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->cont:D

    .line 106
    new-instance v0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$2;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->handlerdonghua:Landroid/os/Handler;

    .line 57
    return-void
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 515
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 516
    const v1, 0x7f0b0034

    invoke-virtual {p0, v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 517
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 518
    const-string v1, "Ok"

    .line 519
    new-instance v2, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$11;

    invoke-direct {v2, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$11;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V

    .line 518
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 530
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 532
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V
    .locals 0

    .prologue
    .line 514
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->Mydialog()V

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->relaquan:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;Z)V
    .locals 0

    .prologue
    .line 104
    iput-boolean p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->flag:Z

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->handlerdonghua:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->default_options:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method static synthetic access$15(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->spnetworkre:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V
    .locals 0

    .prologue
    .line 484
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->downwifi()V

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Z
    .locals 1

    .prologue
    .line 104
    iget-boolean v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->flag:Z

    return v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)D
    .locals 2

    .prologue
    .line 105
    iget-wide v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->cont:D

    return-wide v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;D)V
    .locals 0

    .prologue
    .line 105
    iput-wide p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->cont:D

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->tv_jieguo:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Ljava/lang/Double;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->roundDouble1:Ljava/lang/Double;

    return-object v0
.end method

.method private downwifi()V
    .locals 4

    .prologue
    .line 485
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    .line 486
    const v3, 0x7f0c000e

    .line 485
    invoke-direct {v0, p0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 487
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 488
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 489
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 490
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 491
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$9;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$9;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 500
    new-instance v3, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$10;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$10;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 511
    return-void
.end method

.method private init()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 272
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 273
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p0}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 274
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->default_options:Ljava/util/HashMap;

    .line 275
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 276
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 277
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    :try_start_0
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 281
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 280
    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 282
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 283
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 282
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->ds:Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 288
    :goto_0
    const-string v0, "network"

    invoke-virtual {p0, v0, v6}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->spnetworkre:Landroid/content/SharedPreferences;

    .line 291
    :try_start_1
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 292
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 298
    :cond_0
    :goto_1
    return-void

    .line 294
    :catch_0
    move-exception v0

    goto :goto_1

    .line 285
    :catch_1
    move-exception v0

    goto :goto_0
.end method

.method public static roundDouble(DI)Ljava/lang/Double;
    .locals 8
    .param p0, "val"    # D
    .param p2, "precision"    # I

    .prologue
    .line 301
    const/4 v3, 0x0

    .line 303
    .local v3, "ret":Ljava/lang/Double;
    const-wide/high16 v4, 0x4024000000000000L    # 10.0

    int-to-double v6, p2

    :try_start_0
    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v1

    .line 304
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

    .line 308
    .end local v1    # "factor":D
    :goto_0
    return-object v3

    .line 305
    :catch_0
    move-exception v0

    .line 306
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

    .line 339
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 341
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 342
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 344
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 346
    const-string v0, "Failed to connect server. Please try again."

    .line 345
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 347
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 481
    :goto_0
    return-void

    .line 350
    :cond_0
    new-instance v0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$8;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$8;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 478
    invoke-virtual {v0, v1}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$8;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public initView()V
    .locals 6

    .prologue
    .line 325
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->initView()V

    .line 328
    :try_start_0
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    new-instance v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 329
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 328
    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 335
    :goto_0
    return-void

    .line 330
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 123
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->requestWindowFeature(I)Z

    .line 124
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 126
    const v2, 0x7f0300b1

    invoke-virtual {p0, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->setContentView(I)V

    .line 127
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->init()V

    .line 128
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->initView()V

    .line 129
    const v2, 0x7f0703cb

    invoke-virtual {p0, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->relaquan:Landroid/widget/RelativeLayout;

    .line 131
    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->relaquan:Landroid/widget/RelativeLayout;

    new-instance v3, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;

    invoke-direct {v3, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$3;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 187
    const v2, 0x7f0703b5

    invoke-virtual {p0, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->btnfinish:Landroid/widget/Button;

    .line 189
    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->btnfinish:Landroid/widget/Button;

    new-instance v3, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$4;

    invoke-direct {v3, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$4;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 199
    const v2, 0x7f0703b0

    invoke-virtual {p0, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->header_left_showclean:Landroid/widget/ImageView;

    .line 200
    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->header_left_showclean:Landroid/widget/ImageView;

    new-instance v3, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$5;

    invoke-direct {v3, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$5;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 211
    const v2, 0x7f0703b4

    invoke-virtual {p0, v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->tv_jieguo:Landroid/widget/TextView;

    .line 213
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "clean"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->cleanSize:Ljava/lang/String;

    .line 214
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "juti"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    .line 216
    .local v1, "juti":I
    int-to-double v2, v1

    const-wide/high16 v4, 0x4090000000000000L    # 1024.0

    div-double/2addr v2, v4

    const/4 v4, 0x2

    invoke-static {v2, v3, v4}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->roundDouble(DI)Ljava/lang/Double;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->roundDouble1:Ljava/lang/Double;

    .line 217
    const-string v2, "fff"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->roundDouble1:Ljava/lang/Double;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "------"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 218
    new-instance v2, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;

    invoke-direct {v2, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V

    .line 246
    invoke-virtual {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$6;->start()V

    .line 249
    const v2, 0x7f040020

    .line 248
    invoke-static {p0, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 250
    .local v0, "animation":Landroid/view/animation/Animation;
    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->relaquan:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v0}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 251
    new-instance v2, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$7;

    invoke-direct {v2, p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$7;-><init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V

    .line 266
    invoke-virtual {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$7;->start()V

    .line 268
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 314
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 315
    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 314
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 316
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->startActivity(Landroid/content/Intent;)V

    .line 317
    const/4 v1, 0x0

    sput-boolean v1, Lcom/aio/downloader/utils/publicTools;->cleanertag:Z

    .line 318
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->finish()V

    .line 319
    invoke-super {p0, p1, p2}, Lcom/aio/downloader/mydownload/BaseActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v1

    return v1
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 537
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 538
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 539
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "download"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->sendBroadcast(Landroid/content/Intent;)V

    .line 542
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 543
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 544
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 542
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 545
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 547
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 553
    :goto_0
    return-void

    .line 550
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 551
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 550
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
