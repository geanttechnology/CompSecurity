.class public Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
.super Landroid/widget/BaseAdapter;
.source "Mp3ListviewAdapter.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private ctx:Landroid/content/Context;

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

.field private edit:Landroid/content/SharedPreferences$Editor;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private mContext:Landroid/content/Context;

.field private model:Lcom/aio/downloader/model/Model;

.field private mp3tag:Ljava/lang/String;

.field private myApp:Lcom/aio/downloader/mydownload/MyApplcation;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private sp:Landroid/content/SharedPreferences;

.field private sp2:Landroid/content/SharedPreferences;

.field private spnetworkre:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V
    .locals 3
    .param p1, "ctx"    # Landroid/content/Context;
    .param p3, "mp3tag"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v0, 0x0

    .line 136
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 126
    iput-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 131
    iput-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 137
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    .line 138
    iput-object p2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->list:Ljava/util/List;

    .line 139
    iput-object p3, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->mp3tag:Ljava/lang/String;

    .line 142
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 144
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->initView()V

    .line 145
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p1}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 146
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->default_options:Ljava/util/HashMap;

    .line 147
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 148
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 149
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 150
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 152
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 153
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p1}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 155
    :cond_0
    const-string v0, "network"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;

    .line 156
    const-string v0, "name"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->sp2:Landroid/content/SharedPreferences;

    .line 157
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 158
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 157
    iput-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 162
    :goto_0
    return-void

    .line 159
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 417
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 418
    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    const v2, 0x7f0b0034

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 419
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 420
    const-string v1, "Ok"

    .line 421
    new-instance v2, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$4;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$4;-><init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)V

    .line 420
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 427
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 429
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->sp2:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)V
    .locals 0

    .prologue
    .line 386
    invoke-direct {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->downwifi()V

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->mp3tag:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)Lcom/aio/downloader/model/Model;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->model:Lcom/aio/downloader/model/Model;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)V
    .locals 0

    .prologue
    .line 416
    invoke-direct {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->Mydialog()V

    return-void
.end method

.method private downwifi()V
    .locals 5

    .prologue
    .line 387
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    iget-object v3, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    .line 388
    const v4, 0x7f0c000e

    .line 387
    invoke-direct {v0, v3, v4}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 389
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 390
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 391
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 392
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 393
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$2;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$2;-><init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 402
    new-instance v3, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$3;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$3;-><init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 413
    return-void
.end method


# virtual methods
.method public MydownloadMp3(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "url"    # Ljava/lang/String;

    .prologue
    .line 356
    new-instance v6, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 358
    .local v6, "d":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "file_id"

    .line 359
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    move-object v2, p1

    .line 358
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 359
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 360
    invoke-direct {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->Mydialog()V

    .line 383
    :goto_0
    return-void

    .line 362
    :cond_0
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 363
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 364
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, ".mp3"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 362
    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 364
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v7

    .line 366
    .local v7, "path":Ljava/lang/String;
    invoke-virtual {v6, p3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 368
    const-string v0, "olol"

    invoke-static {v0, p3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 369
    invoke-virtual {v6, v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 370
    const/4 v0, 0x4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 371
    invoke-virtual {v6, p2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 372
    invoke-virtual {v6, p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 373
    const-string v0, "http://android.downloadatoz.com/_201409/market/img/mp3.png"

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 374
    const-string v0, "mp3"

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 375
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 376
    invoke-virtual {p0, v6}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 377
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    invoke-interface {v0, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 378
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    .line 379
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' is added to download queue."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 380
    const/4 v2, 0x0

    .line 378
    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 380
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0
.end method

.method public getBooleanValueByConfigFile(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 74
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 168
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 170
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getEdit()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method public getIntegerValueByConfigFile(Ljava/lang/String;)I
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 70
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, -0x1

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 183
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 189
    int-to-long v0, p1

    return-wide v0
.end method

.method public getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method public getSp()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->sp:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public getStringValueByConfigFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->sp:Landroid/content/SharedPreferences;

    const-string v1, ""

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 194
    const/4 v0, 0x0

    .line 195
    .local v0, "holder":Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;
    iget-object v3, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 196
    .local v1, "in_fo":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    if-nez p2, :cond_0

    .line 197
    new-instance v0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;

    .end local v0    # "holder":Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;
    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;)V

    .line 198
    .restart local v0    # "holder":Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;
    iget-object v3, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    const v4, 0x7f03007c

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 201
    const v3, 0x7f0702ee

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 200
    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 203
    const v3, 0x7f0702ef

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 202
    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 205
    const v3, 0x7f0702f0

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 204
    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 206
    const v3, 0x7f0702f1

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$3(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 209
    const v3, 0x7f0702f2

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 208
    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/Button;)V

    .line 211
    const v3, 0x7f0702ed

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 210
    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;Landroid/widget/RelativeLayout;)V

    .line 212
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 217
    :goto_0
    const/4 v2, -0x1

    .line 219
    .local v2, "selector":I
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    const-string v4, "mp3_recent_data"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    .line 220
    const-string v4, "mp3_recent_selector"

    const/4 v5, -0x1

    .line 219
    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    .line 223
    :goto_1
    if-ne v2, p1, :cond_1

    .line 224
    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->list_bg:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/RelativeLayout;

    move-result-object v3

    const v4, 0x7f020106

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 229
    :goto_2
    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3title:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 230
    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3album_title:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getAlbum_title()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 231
    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3artist_title:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getArtist_title()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 232
    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3size:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSize()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 235
    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->mp3_download_bt:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$11(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/Button;

    move-result-object v3

    new-instance v4, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;

    invoke-direct {v4, p0, v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$1;-><init>(Lcom/aio/downloader/adapter/Mp3ListviewAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 335
    return-object p2

    .line 214
    .end local v2    # "selector":I
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "holder":Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;
    check-cast v0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;

    .restart local v0    # "holder":Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;
    goto :goto_0

    .line 226
    .restart local v2    # "selector":I
    :cond_1
    # getter for: Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->list_bg:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/Mp3ListviewAdapter$ViewHolder;)Landroid/widget/RelativeLayout;

    move-result-object v3

    const v4, 0x7f020105

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto :goto_2

    .line 221
    :catch_0
    move-exception v3

    goto :goto_1
.end method

.method public getmContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public getmp3json(Ljava/lang/String;)V
    .locals 5
    .param p1, "mp3json"    # Ljava/lang/String;

    .prologue
    .line 340
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 341
    .local v1, "object":Lorg/json/JSONObject;
    const-string v2, "status"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 342
    new-instance v2, Lcom/aio/downloader/model/Model;

    invoke-direct {v2}, Lcom/aio/downloader/model/Model;-><init>()V

    iput-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->model:Lcom/aio/downloader/model/Model;

    .line 343
    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->model:Lcom/aio/downloader/model/Model;

    const-string v3, "url"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/model/Model;->setMp3url(Ljava/lang/String;)V

    .line 344
    const-string v2, "olol"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "utl="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "url"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 351
    .end local v1    # "object":Lorg/json/JSONObject;
    :cond_0
    :goto_0
    return-void

    .line 346
    :catch_0
    move-exception v0

    .line 348
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public initView()V
    .locals 4

    .prologue
    .line 79
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 80
    .local v0, "app":Lcom/aio/downloader/mydownload/MyApplcation;
    iget-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    const-string v2, "config"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->setSp(Landroid/content/SharedPreferences;)V

    .line 81
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 82
    invoke-virtual {p0, v0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 86
    .end local v0    # "app":Lcom/aio/downloader/mydownload/MyApplcation;
    :goto_0
    return-void

    .line 83
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public putBooleanValueToConfigFile(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 60
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 61
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 62
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;I)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 55
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 56
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 49
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 50
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public setEdit(Landroid/content/SharedPreferences$Editor;)V
    .locals 0
    .param p1, "edit"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 118
    return-void
.end method

.method public setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    .locals 0
    .param p1, "myApp"    # Lcom/aio/downloader/mydownload/MyApplcation;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 110
    return-void
.end method

.method public setSp(Landroid/content/SharedPreferences;)V
    .locals 0
    .param p1, "sp"    # Landroid/content/SharedPreferences;

    .prologue
    .line 101
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->sp:Landroid/content/SharedPreferences;

    .line 102
    return-void
.end method

.method public setmContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->mContext:Landroid/content/Context;

    .line 94
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 434
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 435
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 436
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->ctx:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const-string v2, "download_aio"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 438
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 439
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 440
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 438
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 441
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 443
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 449
    :goto_0
    return-void

    .line 446
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 447
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 446
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
