.class public Lcom/aio/downloader/adapter/AppGridviewAdapter;
.super Landroid/widget/BaseAdapter;
.source "AppGridviewAdapter.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private apptag:Ljava/lang/String;

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

.field handler:Landroid/os/Handler;

.field private headers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private istag:Ljava/lang/Boolean;

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

.field private myApp:Lcom/aio/downloader/mydownload/MyApplcation;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private sp:Landroid/content/SharedPreferences;

.field private sp2:Landroid/content/SharedPreferences;

.field private spnetworkre:Landroid/content/SharedPreferences;

.field private typeFace:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)V
    .locals 3
    .param p1, "ctx"    # Landroid/content/Context;
    .param p3, "apptag"    # Ljava/lang/String;
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
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 184
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 46
    new-instance v0, Lcom/aio/downloader/adapter/AppGridviewAdapter$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter$1;-><init>(Lcom/aio/downloader/adapter/AppGridviewAdapter;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->handler:Landroid/os/Handler;

    .line 91
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->istag:Ljava/lang/Boolean;

    .line 177
    iput-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 179
    iput-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 182
    iput-object v2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->typeFace:Landroid/graphics/Typeface;

    .line 187
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "Roboto-Light.ttf"

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->typeFace:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 194
    :goto_0
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;

    .line 195
    iput-object p2, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->list:Ljava/util/List;

    .line 196
    iput-object p3, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->apptag:Ljava/lang/String;

    .line 198
    :try_start_1
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 200
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->initView()V

    .line 201
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p1}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 202
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->headers:Ljava/util/HashMap;

    .line 203
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->headers:Ljava/util/HashMap;

    const-string v1, "AIOD"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 204
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->headers:Ljava/util/HashMap;

    const-string v1, "Referer"

    invoke-static {}, Lcom/aio/downloader/utils/publicTools;->get_a_random_user_webview()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 206
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->default_options:Ljava/util/HashMap;

    .line 207
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 208
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 209
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 210
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 212
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 213
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p1}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 215
    :cond_0
    const-string v0, "network"

    .line 216
    const/4 v1, 0x0

    .line 215
    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;

    .line 218
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 219
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 218
    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 220
    const-string v0, "name"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->sp2:Landroid/content/SharedPreferences;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 223
    :goto_1
    return-void

    .line 221
    :catch_0
    move-exception v0

    goto :goto_1

    .line 191
    :catch_1
    move-exception v0

    goto/16 :goto_0
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 564
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 565
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;

    const v2, 0x7f0b0034

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 566
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 567
    const-string v1, "Ok"

    .line 568
    new-instance v2, Lcom/aio/downloader/adapter/AppGridviewAdapter$6;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter$6;-><init>(Lcom/aio/downloader/adapter/AppGridviewAdapter;)V

    .line 567
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 574
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 576
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/AppGridviewAdapter;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->istag:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->sp2:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 181
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->apptag:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/AppGridviewAdapter;)V
    .locals 0

    .prologue
    .line 533
    invoke-direct {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->downwifi()V

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->default_options:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/AppGridviewAdapter;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method private downwifi()V
    .locals 5

    .prologue
    .line 534
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    iget-object v3, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;

    .line 535
    const v4, 0x7f0c000e

    .line 534
    invoke-direct {v0, v3, v4}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 536
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 537
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 538
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 539
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 540
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/adapter/AppGridviewAdapter$4;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/AppGridviewAdapter$4;-><init>(Lcom/aio/downloader/adapter/AppGridviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 549
    new-instance v3, Lcom/aio/downloader/adapter/AppGridviewAdapter$5;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/AppGridviewAdapter$5;-><init>(Lcom/aio/downloader/adapter/AppGridviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 560
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

    .line 372
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 373
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 374
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 377
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 378
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;

    const-string v1, "Failed to connect server. Please try again."

    invoke-static {v0, v1, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 530
    :goto_0
    return-void

    .line 381
    :cond_0
    new-instance v0, Lcom/aio/downloader/adapter/AppGridviewAdapter$3;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/adapter/AppGridviewAdapter$3;-><init>(Lcom/aio/downloader/adapter/AppGridviewAdapter;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 527
    invoke-virtual {v0, v1}, Lcom/aio/downloader/adapter/AppGridviewAdapter$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
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
    .line 237
    .local p1, "model":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 238
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->notifyDataSetChanged()V

    .line 239
    return-void
.end method

.method public getBooleanValueByConfigFile(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 120
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 228
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 231
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getEdit()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method public getIntegerValueByConfigFile(Ljava/lang/String;)I
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 116
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->getSp()Landroid/content/SharedPreferences;

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
    .line 244
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 250
    int-to-long v0, p1

    return-wide v0
.end method

.method public getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method public getSp()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->sp:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public getStringValueByConfigFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 112
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->sp:Landroid/content/SharedPreferences;

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
    .line 255
    const/4 v1, 0x0

    .line 256
    .local v1, "holder":Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->list:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 257
    .local v2, "in_fo":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    if-nez p2, :cond_1

    .line 258
    new-instance v1, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;

    .end local v1    # "holder":Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;
    invoke-direct {v1, p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/AppGridviewAdapter;)V

    .line 259
    .restart local v1    # "holder":Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;

    const v4, 0x7f030054

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 260
    const v3, 0x7f07021c

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    invoke-static {v1, v3}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 261
    const v3, 0x7f07021f

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    invoke-static {v1, v3}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 263
    const v3, 0x7f07021e

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    invoke-static {v1, v3}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 264
    const v3, 0x7f070221

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RatingBar;

    invoke-static {v1, v3}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$3(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;Landroid/widget/RatingBar;)V

    .line 265
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 269
    :goto_0
    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->gvtitle:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 270
    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->gvtitle:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 271
    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->gvratingbar:Landroid/widget/RatingBar;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;)Landroid/widget/RatingBar;

    move-result-object v3

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getRating()Ljava/lang/Float;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/RatingBar;->setRating(F)V

    .line 273
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v4

    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->gvimg:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 278
    :goto_1
    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_apk()Ljava/lang/String;

    move-result-object v0

    .line 279
    .local v0, "has_apk":Ljava/lang/String;
    const-string v3, "1"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 280
    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->gvdown:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v3

    const v4, 0x7f020006

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 284
    :cond_0
    :goto_2
    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->gvdown:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v3

    new-instance v4, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;

    invoke-direct {v4, p0, v2, v0}, Lcom/aio/downloader/adapter/AppGridviewAdapter$2;-><init>(Lcom/aio/downloader/adapter/AppGridviewAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 347
    return-object p2

    .line 267
    .end local v0    # "has_apk":Ljava/lang/String;
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "holder":Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;
    check-cast v1, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;

    .restart local v1    # "holder":Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;
    goto :goto_0

    .line 281
    .restart local v0    # "has_apk":Ljava/lang/String;
    :cond_2
    const-string v3, "0"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 282
    # getter for: Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->gvdown:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/AppGridviewAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v3

    const v4, 0x7f0200b4

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    goto :goto_2

    .line 274
    .end local v0    # "has_apk":Ljava/lang/String;
    :catch_0
    move-exception v3

    goto :goto_1
.end method

.method public getmContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public initView()V
    .locals 4

    .prologue
    .line 126
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 127
    .local v0, "app":Lcom/aio/downloader/mydownload/MyApplcation;
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;

    const-string v2, "config"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->setSp(Landroid/content/SharedPreferences;)V

    .line 128
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 129
    invoke-virtual {p0, v0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 134
    .end local v0    # "app":Lcom/aio/downloader/mydownload/MyApplcation;
    :goto_0
    return-void

    .line 130
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public putBooleanValueToConfigFile(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 107
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 108
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;I)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 100
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 101
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 102
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 94
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 95
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 96
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public setEdit(Landroid/content/SharedPreferences$Editor;)V
    .locals 0
    .param p1, "edit"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 165
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 166
    return-void
.end method

.method public setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    .locals 0
    .param p1, "myApp"    # Lcom/aio/downloader/mydownload/MyApplcation;

    .prologue
    .line 157
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 158
    return-void
.end method

.method public setSp(Landroid/content/SharedPreferences;)V
    .locals 0
    .param p1, "sp"    # Landroid/content/SharedPreferences;

    .prologue
    .line 149
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->sp:Landroid/content/SharedPreferences;

    .line 150
    return-void
.end method

.method public setmContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->mContext:Landroid/content/Context;

    .line 142
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 353
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 354
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppGridviewAdapter;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 355
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->ctx:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const-string v2, "download_aio"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 358
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 359
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 360
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 358
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 361
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 363
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 369
    :goto_0
    return-void

    .line 366
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppGridviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 367
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 366
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
