.class public Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
.super Landroid/widget/BaseAdapter;
.source "Home_Gridview_Adapter.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;
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

.field holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

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

.field private mWindow:Landroid/widget/PopupWindow;

.field private myApp:Lcom/aio/downloader/mydownload/MyApplcation;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private rl_share:Lcom/aio/downloader/views/LFrameLayout;

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

    .line 210
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 57
    new-instance v0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->handler:Landroid/os/Handler;

    .line 112
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->istag:Ljava/lang/Boolean;

    .line 200
    iput-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 202
    iput-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 205
    iput-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->typeFace:Landroid/graphics/Typeface;

    .line 206
    iput-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    .line 213
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 214
    const-string v1, "Roboto-Light.ttf"

    .line 213
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->typeFace:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 219
    :goto_0
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    .line 220
    iput-object p2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    .line 221
    iput-object p3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->apptag:Ljava/lang/String;

    .line 223
    :try_start_1
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 225
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->initView()V

    .line 226
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p1}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 227
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->headers:Ljava/util/HashMap;

    .line 228
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->headers:Ljava/util/HashMap;

    const-string v1, "AIOD"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 229
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->headers:Ljava/util/HashMap;

    const-string v1, "Referer"

    invoke-static {}, Lcom/aio/downloader/utils/publicTools;->get_a_random_user_webview()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 231
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->default_options:Ljava/util/HashMap;

    .line 232
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 233
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 234
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 235
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 237
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 238
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p1}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 240
    :cond_0
    const-string v0, "network"

    .line 241
    const/4 v1, 0x0

    .line 240
    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->spnetworkre:Landroid/content/SharedPreferences;

    .line 243
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 244
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 243
    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 245
    const-string v0, "name"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->sp2:Landroid/content/SharedPreferences;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 248
    :goto_1
    return-void

    .line 246
    :catch_0
    move-exception v0

    goto :goto_1

    .line 216
    :catch_1
    move-exception v0

    goto/16 :goto_0
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 625
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 626
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    const v2, 0x7f0b0034

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 627
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 628
    const-string v1, "Ok"

    .line 629
    new-instance v2, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$6;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$6;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)V

    .line 628
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 635
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 637
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 193
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 112
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->istag:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->spnetworkre:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)V
    .locals 0

    .prologue
    .line 594
    invoke-direct {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->downwifi()V

    return-void
.end method

.method static synthetic access$12(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->sp2:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->apptag:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 648
    invoke-direct {p0, p1, p2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->popuWindow(ILjava/lang/String;)V

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/widget/PopupWindow;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->default_options:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 200
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/util/List;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    return-object v0
.end method

.method public static dip2px(Landroid/content/Context;F)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dpValue"    # F

    .prologue
    .line 808
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v0, v1, Landroid/util/DisplayMetrics;->density:F

    .line 810
    .local v0, "scale":F
    mul-float v1, p1, v0

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v1, v1

    return v1
.end method

.method private downwifi()V
    .locals 5

    .prologue
    .line 595
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    .line 596
    const v4, 0x7f0c000e

    .line 595
    invoke-direct {v0, v3, v4}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 597
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 598
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 599
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 600
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 601
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$4;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$4;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 610
    new-instance v3, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$5;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$5;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 621
    return-void
.end method

.method private popuWindow(ILjava/lang/String;)V
    .locals 10
    .param p1, "myPosition"    # I
    .param p2, "mHas_apk"    # Ljava/lang/String;

    .prologue
    const/4 v9, -0x2

    .line 650
    iget-object v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    invoke-static {v6}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 651
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const v6, 0x7f03009a

    const/4 v7, 0x0

    invoke-virtual {v2, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 653
    .local v5, "view":Landroid/view/View;
    const v6, 0x7f070359

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 652
    check-cast v3, Lcom/aio/downloader/views/LFrameLayout;

    .line 654
    .local v3, "rl_download":Lcom/aio/downloader/views/LFrameLayout;
    const v6, 0x7f07035a

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/aio/downloader/views/LFrameLayout;

    iput-object v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->rl_share:Lcom/aio/downloader/views/LFrameLayout;

    .line 656
    const v6, 0x7f07035b

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 655
    check-cast v4, Lcom/aio/downloader/views/LFrameLayout;

    .line 658
    .local v4, "rl_viewdetail":Lcom/aio/downloader/views/LFrameLayout;
    new-instance v6, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;

    invoke-direct {v6, p0, p1, p2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$7;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;ILjava/lang/String;)V

    invoke-virtual {v3, v6}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 738
    iget-object v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->rl_share:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v7, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;

    invoke-direct {v7, p0, p1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$8;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;I)V

    invoke-virtual {v6, v7}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 768
    new-instance v6, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$9;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;I)V

    invoke-virtual {v4, v6}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 789
    new-instance v6, Landroid/widget/PopupWindow;

    invoke-direct {v6, v5}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;)V

    iput-object v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;

    .line 796
    iget-object v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    const/high16 v7, 0x43280000    # 168.0f

    invoke-static {v6, v7}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->dip2px(Landroid/content/Context;F)I

    move-result v0

    .line 797
    .local v0, "dip2px":I
    const-string v6, "qwer"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "dip2px="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 798
    iget-object v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v6, v9}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 799
    iget-object v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v6, v9}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 800
    iget-object v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;

    const/4 v7, 0x1

    invoke-virtual {v6, v7}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 802
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const/4 v6, 0x0

    invoke-direct {v1, v6}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 803
    .local v1, "dw":Landroid/graphics/drawable/ColorDrawable;
    iget-object v6, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v6, v1}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 804
    return-void
.end method

.method public static px2dip(Landroid/content/Context;F)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "pxValue"    # F

    .prologue
    .line 816
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v0, v1, Landroid/util/DisplayMetrics;->density:F

    .line 818
    .local v0, "scale":F
    div-float v1, p1, v0

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v1, v1

    return v1
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

    .line 407
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 409
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 410
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 413
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 414
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    const-string v1, "Failed to connect server. Please try again."

    invoke-static {v0, v1, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 415
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 591
    :goto_0
    return-void

    .line 418
    :cond_0
    new-instance v0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$3;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$3;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 588
    invoke-virtual {v0, v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

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
    .line 262
    .local p1, "model":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 263
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->notifyDataSetChanged()V

    .line 264
    return-void
.end method

.method public getBooleanValueByConfigFile(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 143
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 253
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 256
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getEdit()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->edit:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method public getIntegerValueByConfigFile(Ljava/lang/String;)I
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 139
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->getSp()Landroid/content/SharedPreferences;

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
    .line 269
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 275
    int-to-long v0, p1

    return-wide v0
.end method

.method public getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method public getSp()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->sp:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public getStringValueByConfigFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 135
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->sp:Landroid/content/SharedPreferences;

    const-string v1, ""

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 281
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 282
    .local v1, "in_fo":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    if-nez p2, :cond_0

    .line 283
    new-instance v2, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)V

    iput-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    .line 284
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    const v3, 0x7f030054

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 285
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    const v2, 0x7f07021c

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    invoke-static {v3, v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 286
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    const v2, 0x7f07021f

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    invoke-static {v3, v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;Landroid/widget/TextView;)V

    .line 288
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    .line 289
    const v2, 0x7f07021e

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/LImageButton;

    .line 288
    invoke-static {v3, v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;Lcom/aio/downloader/views/LImageButton;)V

    .line 290
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    .line 291
    const v2, 0x7f070221

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RatingBar;

    .line 290
    invoke-static {v3, v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->access$3(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;Landroid/widget/RatingBar;)V

    .line 292
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    invoke-virtual {p2, v2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 296
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvtitle:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 297
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvratingbar:Landroid/widget/RatingBar;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;)Landroid/widget/RatingBar;

    move-result-object v3

    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getRating()Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-virtual {v3, v2}, Landroid/widget/RatingBar;->setRating(F)V

    .line 299
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvimg:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 304
    :goto_1
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_apk()Ljava/lang/String;

    move-result-object v0

    .line 311
    .local v0, "has_apk":Ljava/lang/String;
    iget-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->gvdown:Lcom/aio/downloader/views/LImageButton;
    invoke-static {v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;)Lcom/aio/downloader/views/LImageButton;

    move-result-object v2

    new-instance v3, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;

    invoke-direct {v3, p0, p1, v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$2;-><init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;ILjava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 381
    return-object p2

    .line 294
    .end local v0    # "has_apk":Ljava/lang/String;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    iput-object v2, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->holder:Lcom/aio/downloader/adapter/Home_Gridview_Adapter$ViewHolder;

    goto :goto_0

    .line 300
    :catch_0
    move-exception v2

    goto :goto_1
.end method

.method public getmContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public initView()V
    .locals 4

    .prologue
    .line 149
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 150
    .local v0, "app":Lcom/aio/downloader/mydownload/MyApplcation;
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    const-string v2, "config"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->setSp(Landroid/content/SharedPreferences;)V

    .line 151
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 152
    invoke-virtual {p0, v0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 157
    .end local v0    # "app":Lcom/aio/downloader/mydownload/MyApplcation;
    :goto_0
    return-void

    .line 153
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public putBooleanValueToConfigFile(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 129
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 130
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 131
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;I)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 123
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 124
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 125
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 117
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 118
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 119
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public setEdit(Landroid/content/SharedPreferences$Editor;)V
    .locals 0
    .param p1, "edit"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 188
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 189
    return-void
.end method

.method public setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    .locals 0
    .param p1, "myApp"    # Lcom/aio/downloader/mydownload/MyApplcation;

    .prologue
    .line 180
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 181
    return-void
.end method

.method public setSp(Landroid/content/SharedPreferences;)V
    .locals 0
    .param p1, "sp"    # Landroid/content/SharedPreferences;

    .prologue
    .line 172
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->sp:Landroid/content/SharedPreferences;

    .line 173
    return-void
.end method

.method public setmContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 164
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->mContext:Landroid/content/Context;

    .line 165
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 387
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 388
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 389
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const-string v2, "download_aio"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 392
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 393
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 394
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 392
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 395
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 397
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 403
    :goto_0
    return-void

    .line 400
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 401
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 400
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
