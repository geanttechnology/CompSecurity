.class public Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
.super Landroid/widget/BaseAdapter;
.source "RingtoneListviewAdapter.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;
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

.field private myApp:Lcom/aio/downloader/mydownload/MyApplcation;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private ringtonetag:Ljava/lang/String;

.field private sp:Landroid/content/SharedPreferences;

.field private sp2:Landroid/content/SharedPreferences;

.field private spnetworkre:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V
    .locals 3
    .param p1, "ctx"    # Landroid/content/Context;
    .param p3, "ringtonetag"    # Ljava/lang/String;
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

    .line 139
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 132
    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 136
    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 140
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    .line 141
    iput-object p2, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->list:Ljava/util/List;

    .line 142
    iput-object p3, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ringtonetag:Ljava/lang/String;

    .line 144
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 147
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->initView()V

    .line 148
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p1}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 149
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->default_options:Ljava/util/HashMap;

    .line 150
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 151
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 152
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 153
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 155
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 156
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p1}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 158
    :cond_0
    const-string v0, "network"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;

    .line 159
    const-string v0, "name"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->sp2:Landroid/content/SharedPreferences;

    .line 160
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 161
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 160
    iput-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 165
    :goto_0
    return-void

    .line 162
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 419
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 420
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    const v2, 0x7f0b0034

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 421
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 422
    const-string v1, "Ok"

    .line 423
    new-instance v2, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$4;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$4;-><init>(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)V

    .line 422
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 429
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 431
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)V
    .locals 0

    .prologue
    .line 388
    invoke-direct {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->downwifi()V

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ringtonetag:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)V
    .locals 0

    .prologue
    .line 418
    invoke-direct {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->Mydialog()V

    return-void
.end method

.method private downwifi()V
    .locals 5

    .prologue
    .line 389
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    .line 390
    const v4, 0x7f0c000e

    .line 389
    invoke-direct {v0, v3, v4}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 391
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 392
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 393
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 394
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 395
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$2;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$2;-><init>(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 404
    new-instance v3, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$3;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$3;-><init>(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 415
    return-void
.end method


# virtual methods
.method public MydownloadMp3AndRingtone(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "url"    # Ljava/lang/String;

    .prologue
    .line 358
    new-instance v6, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 360
    .local v6, "d":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "file_id"

    .line 361
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    move-object v2, p1

    .line 360
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 361
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 362
    invoke-direct {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->Mydialog()V

    .line 385
    :goto_0
    return-void

    .line 364
    :cond_0
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 365
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 366
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, ".mp3"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 364
    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 366
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v7

    .line 368
    .local v7, "path":Ljava/lang/String;
    invoke-virtual {v6, p3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 369
    const-string v0, "olol"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "ringtone="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 370
    invoke-virtual {v6, v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 371
    const/4 v0, 0x4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 372
    invoke-virtual {v6, p2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 373
    invoke-virtual {v6, p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 374
    const-string v0, "http://android.downloadatoz.com/_201409/market/img/ringtone.png"

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 375
    const-string v0, "app"

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 376
    const-string v0, "mp3"

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCat(Ljava/lang/String;)V

    .line 377
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 378
    invoke-virtual {p0, v6}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 379
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    invoke-interface {v0, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 380
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    .line 381
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

    .line 382
    const/4 v2, 0x0

    .line 380
    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 382
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0
.end method

.method public addItem(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 179
    .local p1, "model":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 180
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->notifyDataSetChanged()V

    .line 181
    return-void
.end method

.method public getBooleanValueByConfigFile(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 78
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 171
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 173
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getEdit()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method public getIntegerValueByConfigFile(Ljava/lang/String;)I
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 74
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->getSp()Landroid/content/SharedPreferences;

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
    .line 186
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 192
    int-to-long v0, p1

    return-wide v0
.end method

.method public getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method public getSp()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->sp:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public getStringValueByConfigFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->sp:Landroid/content/SharedPreferences;

    const-string v1, ""

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const v6, 0x7f020106

    .line 197
    const/4 v0, 0x0

    .line 198
    .local v0, "holder":Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 199
    .local v1, "in_fo":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    if-nez p2, :cond_0

    .line 200
    new-instance v0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;

    .end local v0    # "holder":Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;
    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;)V

    .line 201
    .restart local v0    # "holder":Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    const v4, 0x7f0300a9

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 204
    const v3, 0x7f070393

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 203
    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 206
    const v3, 0x7f070394

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 205
    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 208
    const v3, 0x7f070395

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RatingBar;

    .line 207
    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;Landroid/widget/RatingBar;)V

    .line 210
    const v3, 0x7f070396

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 209
    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$3(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;Landroid/widget/Button;)V

    .line 212
    const v3, 0x7f0702ed

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 211
    invoke-static {v0, v3}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;Landroid/widget/RelativeLayout;)V

    .line 213
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 218
    :goto_0
    const/4 v2, -0x1

    .line 220
    .local v2, "selector":I
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    const-string v4, "ringtone_recent_data"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    .line 221
    const-string v4, "ringtone_recent_selector"

    const/4 v5, -0x1

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    .line 224
    :goto_1
    if-ne v2, p1, :cond_1

    .line 225
    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->list_bg:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/RelativeLayout;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 229
    :goto_2
    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtonetitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 230
    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtonecat:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getCat()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 231
    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtone_ratingbar:Landroid/widget/RatingBar;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/RatingBar;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getRating()Ljava/lang/Float;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/RatingBar;->setRating(F)V

    .line 232
    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->ringtone_download_bt:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/Button;

    move-result-object v3

    new-instance v4, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;

    invoke-direct {v4, p0, v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$1;-><init>(Lcom/aio/downloader/adapter/RingtoneListviewAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 341
    return-object p2

    .line 215
    .end local v2    # "selector":I
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "holder":Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;
    check-cast v0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;

    .restart local v0    # "holder":Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;
    goto :goto_0

    .line 227
    .restart local v2    # "selector":I
    :cond_1
    # getter for: Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->list_bg:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/RingtoneListviewAdapter$ViewHolder;)Landroid/widget/RelativeLayout;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto :goto_2

    .line 222
    :catch_0
    move-exception v3

    goto :goto_1
.end method

.method public getmContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public initView()V
    .locals 4

    .prologue
    .line 83
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 84
    .local v0, "app":Lcom/aio/downloader/mydownload/MyApplcation;
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    const-string v2, "config"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->setSp(Landroid/content/SharedPreferences;)V

    .line 85
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 86
    invoke-virtual {p0, v0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 90
    .end local v0    # "app":Lcom/aio/downloader/mydownload/MyApplcation;
    :goto_0
    return-void

    .line 87
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public putBooleanValueToConfigFile(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 65
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 66
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;I)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 58
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 59
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 60
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 52
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 53
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 54
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public setEdit(Landroid/content/SharedPreferences$Editor;)V
    .locals 0
    .param p1, "edit"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 121
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 122
    return-void
.end method

.method public setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    .locals 0
    .param p1, "myApp"    # Lcom/aio/downloader/mydownload/MyApplcation;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 114
    return-void
.end method

.method public setSp(Landroid/content/SharedPreferences;)V
    .locals 0
    .param p1, "sp"    # Landroid/content/SharedPreferences;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->sp:Landroid/content/SharedPreferences;

    .line 106
    return-void
.end method

.method public setmContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->mContext:Landroid/content/Context;

    .line 98
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 435
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 436
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 437
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->ctx:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const-string v2, "download_aio"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 438
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

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
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 449
    :goto_0
    return-void

    .line 446
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

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
