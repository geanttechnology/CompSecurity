.class public Lcom/aio/downloader/adapter/TodaypickListviewAdapter;
.super Landroid/widget/BaseAdapter;
.source "TodaypickListviewAdapter.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;
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

    .line 188
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 49
    new-instance v0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$1;-><init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->handler:Landroid/os/Handler;

    .line 95
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->istag:Ljava/lang/Boolean;

    .line 181
    iput-object v2, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 183
    iput-object v2, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 186
    iput-object v2, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->typeFace:Landroid/graphics/Typeface;

    .line 190
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;

    .line 191
    iput-object p2, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->list:Ljava/util/List;

    .line 192
    iput-object p3, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->apptag:Ljava/lang/String;

    .line 194
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 196
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->initView()V

    .line 197
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p1}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 198
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->headers:Ljava/util/HashMap;

    .line 199
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->headers:Ljava/util/HashMap;

    const-string v1, "AIOD"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 200
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->headers:Ljava/util/HashMap;

    const-string v1, "Referer"

    invoke-static {}, Lcom/aio/downloader/utils/publicTools;->get_a_random_user_webview()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 202
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->default_options:Ljava/util/HashMap;

    .line 203
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 204
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 205
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 206
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 208
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 209
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p1}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 211
    :cond_0
    const-string v0, "network"

    .line 212
    const/4 v1, 0x0

    .line 211
    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;

    .line 214
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 215
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 214
    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 216
    const-string v0, "name"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->sp2:Landroid/content/SharedPreferences;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 220
    :goto_0
    :try_start_1
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "Roboto-Light.ttf"

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->typeFace:Landroid/graphics/Typeface;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 227
    :goto_1
    return-void

    .line 224
    :catch_0
    move-exception v0

    goto :goto_1

    .line 217
    :catch_1
    move-exception v0

    goto :goto_0
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 612
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 613
    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;

    const v2, 0x7f0b0034

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 614
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 615
    const-string v1, "Ok"

    .line 616
    new-instance v2, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$6;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$6;-><init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)V

    .line 615
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 622
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 624
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)V
    .locals 0

    .prologue
    .line 611
    invoke-direct {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->Mydialog()V

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->istag:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->sp2:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)V
    .locals 0

    .prologue
    .line 581
    invoke-direct {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->downwifi()V

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->apptag:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->default_options:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 181
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method private downwifi()V
    .locals 5

    .prologue
    .line 582
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    iget-object v3, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;

    .line 583
    const v4, 0x7f0c000e

    .line 582
    invoke-direct {v0, v3, v4}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 584
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 585
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 586
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 587
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 588
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$4;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$4;-><init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 597
    new-instance v3, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$5;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$5;-><init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 608
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

    .line 430
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 432
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 433
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 434
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, "rfrf"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "111111"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 435
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 436
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;

    const-string v1, "Failed to connect server. Please try again."

    invoke-static {v0, v1, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 437
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 578
    :goto_0
    return-void

    .line 440
    :cond_0
    new-instance v0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;-><init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 575
    invoke-virtual {v0, v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

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
    .line 241
    .local p1, "model":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 242
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->notifyDataSetChanged()V

    .line 243
    return-void
.end method

.method public getBooleanValueByConfigFile(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 124
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 233
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 235
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getEdit()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method public getIntegerValueByConfigFile(Ljava/lang/String;)I
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 120
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->getSp()Landroid/content/SharedPreferences;

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
    .line 248
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 254
    int-to-long v0, p1

    return-wide v0
.end method

.method public getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method public getSp()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->sp:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public getStringValueByConfigFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->sp:Landroid/content/SharedPreferences;

    const-string v1, ""

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 259
    const/4 v1, 0x0

    .line 260
    .local v1, "holder":Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;
    iget-object v6, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v6, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 261
    .local v2, "in_fo":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    if-nez p2, :cond_2

    .line 262
    new-instance v1, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;

    .end local v1    # "holder":Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;
    invoke-direct {v1, p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)V

    .line 263
    .restart local v1    # "holder":Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;
    iget-object v6, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;

    const v7, 0x7f0300b4

    const/4 v8, 0x0

    invoke-static {v6, v7, v8}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 265
    const v6, 0x7f0703d7

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 264
    invoke-static {v1, v6}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 267
    const v6, 0x7f0703d2

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 266
    invoke-static {v1, v6}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 269
    const v6, 0x7f0703d4

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 268
    invoke-static {v1, v6}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 271
    const v6, 0x7f0703d0

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageView;

    .line 270
    invoke-static {v1, v6}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$3(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 273
    const v6, 0x7f0703d3

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/RatingBar;

    .line 272
    invoke-static {v1, v6}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/RatingBar;)V

    .line 275
    const v6, 0x7f0703d5

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/Button;

    .line 274
    invoke-static {v1, v6}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/Button;)V

    .line 276
    const v6, 0x7f0703d6

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    invoke-static {v1, v6}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 277
    const v6, 0x7f0703d1

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageView;

    invoke-static {v1, v6}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 278
    const v6, 0x7f0703cf

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/LinearLayout;

    invoke-static {v1, v6}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;Landroid/widget/LinearLayout;)V

    .line 279
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 284
    :goto_0
    if-nez p1, :cond_3

    .line 285
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->ll_today_top_title:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/LinearLayout;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 290
    :goto_1
    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getCreate_time()Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    const-wide/16 v8, 0x3e8

    mul-long v4, v6, v8

    .line 291
    .local v4, "time":J
    const-string v6, "MM"

    invoke-static {v6, v4, v5}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 292
    .local v3, "month":Ljava/lang/String;
    const-string v6, "01"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 293
    const-string v3, "Jan"

    .line 319
    :cond_0
    :goto_2
    :try_start_0
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaytime:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 320
    const-string v8, " dd, yyyy"

    invoke-static {v8, v4, v5}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 319
    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 323
    :goto_3
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaytitletv:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$11(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 324
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->tv_desc:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$12(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getPpshort_desc()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 325
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaytitletv:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$11(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    iget-object v7, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 326
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todayhits:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$13(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "("

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSetCount()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 327
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todayratingbar:Landroid/widget/RatingBar;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$14(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/RatingBar;

    move-result-object v6

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getRating()Ljava/lang/Float;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v7

    invoke-virtual {v6, v7}, Landroid/widget/RatingBar;->setRating(F)V

    .line 329
    :try_start_1
    iget-object v6, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v7

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todayimg:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$15(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage1(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 330
    iget-object v6, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v7

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->iv_today_icon:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$16(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 336
    :goto_4
    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_apk()Ljava/lang/String;

    move-result-object v0

    .line 337
    .local v0, "has_apk":Ljava/lang/String;
    const-string v6, "1"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_f

    .line 338
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaydownload_bt:Landroid/widget/Button;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$17(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/Button;

    move-result-object v6

    .line 339
    const v7, 0x7f020006

    invoke-virtual {v6, v7}, Landroid/widget/Button;->setBackgroundResource(I)V

    .line 346
    :cond_1
    :goto_5
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaydownload_bt:Landroid/widget/Button;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$17(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/Button;

    move-result-object v6

    new-instance v7, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$2;

    invoke-direct {v7, p0, v2, v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$2;-><init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;Ljava/lang/String;)V

    invoke-virtual {v6, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 404
    return-object p2

    .line 281
    .end local v0    # "has_apk":Ljava/lang/String;
    .end local v3    # "month":Ljava/lang/String;
    .end local v4    # "time":J
    :cond_2
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "holder":Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;
    check-cast v1, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;

    .restart local v1    # "holder":Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;
    goto/16 :goto_0

    .line 287
    :cond_3
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->ll_today_top_title:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/LinearLayout;

    move-result-object v6

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_1

    .line 294
    .restart local v3    # "month":Ljava/lang/String;
    .restart local v4    # "time":J
    :cond_4
    const-string v6, "02"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 295
    const-string v3, "Feb"

    .line 296
    goto/16 :goto_2

    :cond_5
    const-string v6, "03"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 297
    const-string v3, "March"

    .line 298
    goto/16 :goto_2

    :cond_6
    const-string v6, "04"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 299
    const-string v3, "Apr"

    .line 300
    goto/16 :goto_2

    :cond_7
    const-string v6, "05"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_8

    .line 301
    const-string v3, "May"

    .line 302
    goto/16 :goto_2

    :cond_8
    const-string v6, "06"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 303
    const-string v3, "June"

    .line 304
    goto/16 :goto_2

    :cond_9
    const-string v6, "07"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_a

    .line 305
    const-string v3, "July"

    .line 306
    goto/16 :goto_2

    :cond_a
    const-string v6, "08"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_b

    .line 307
    const-string v3, "Aug"

    .line 308
    goto/16 :goto_2

    :cond_b
    const-string v6, "09"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_c

    .line 309
    const-string v3, "Sept"

    .line 310
    goto/16 :goto_2

    :cond_c
    const-string v6, "10"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_d

    .line 311
    const-string v3, "Oct"

    .line 312
    goto/16 :goto_2

    :cond_d
    const-string v6, "11"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_e

    .line 313
    const-string v3, "Nov"

    .line 314
    goto/16 :goto_2

    :cond_e
    const-string v6, "12"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 315
    const-string v3, "Dec"

    goto/16 :goto_2

    .line 341
    .restart local v0    # "has_apk":Ljava/lang/String;
    :cond_f
    const-string v6, "0"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 342
    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->todaydownload_bt:Landroid/widget/Button;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;->access$17(Lcom/aio/downloader/adapter/TodaypickListviewAdapter$ViewHolder;)Landroid/widget/Button;

    move-result-object v6

    .line 343
    const v7, 0x7f0200b4

    invoke-virtual {v6, v7}, Landroid/widget/Button;->setBackgroundResource(I)V

    goto/16 :goto_5

    .line 331
    .end local v0    # "has_apk":Ljava/lang/String;
    :catch_0
    move-exception v6

    goto/16 :goto_4

    .line 321
    :catch_1
    move-exception v6

    goto/16 :goto_3
.end method

.method public getmContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public initView()V
    .locals 4

    .prologue
    .line 130
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 131
    .local v0, "app":Lcom/aio/downloader/mydownload/MyApplcation;
    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;

    const-string v2, "config"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->setSp(Landroid/content/SharedPreferences;)V

    .line 132
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 133
    invoke-virtual {p0, v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 138
    .end local v0    # "app":Lcom/aio/downloader/mydownload/MyApplcation;
    :goto_0
    return-void

    .line 134
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public putBooleanValueToConfigFile(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 110
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 111
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 112
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;I)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 104
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 105
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 106
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 98
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 99
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 100
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public setEdit(Landroid/content/SharedPreferences$Editor;)V
    .locals 0
    .param p1, "edit"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 169
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 170
    return-void
.end method

.method public setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    .locals 0
    .param p1, "myApp"    # Lcom/aio/downloader/mydownload/MyApplcation;

    .prologue
    .line 161
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 162
    return-void
.end method

.method public setSp(Landroid/content/SharedPreferences;)V
    .locals 0
    .param p1, "sp"    # Landroid/content/SharedPreferences;

    .prologue
    .line 153
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->sp:Landroid/content/SharedPreferences;

    .line 154
    return-void
.end method

.method public setmContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 145
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->mContext:Landroid/content/Context;

    .line 146
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 410
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 411
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 412
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const-string v2, "download_aio"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 415
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 416
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 417
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 415
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 418
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 420
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 426
    :goto_0
    return-void

    .line 423
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 424
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 423
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
