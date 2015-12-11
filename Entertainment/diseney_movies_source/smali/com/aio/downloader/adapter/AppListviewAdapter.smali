.class public Lcom/aio/downloader/adapter/AppListviewAdapter;
.super Landroid/widget/BaseAdapter;
.source "AppListviewAdapter.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private app_ratingbar_fb:Landroid/widget/RatingBar;

.field private appauthortitle_fb:Landroid/widget/TextView;

.field private appicon_fb:Landroid/widget/ImageView;

.field private apptag:Ljava/lang/String;

.field private apptitle_fb:Landroid/widget/TextView;

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

.field private dip2px:I

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

.field private holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

.field private inmobtop:Landroid/widget/RelativeLayout;

.field private inmobtop_fb:Landroid/widget/RelativeLayout;

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

.field private nativeAd:Lcom/facebook/ads/NativeAd;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private sp:Landroid/content/SharedPreferences;

.field private sp2:Landroid/content/SharedPreferences;

.field private sp3:Landroid/content/SharedPreferences;

.field private spnetworkre:Landroid/content/SharedPreferences;

.field private typeFace:Landroid/graphics/Typeface;

.field private typeFace2:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lcom/facebook/ads/NativeAd;)V
    .locals 3
    .param p1, "ctx"    # Landroid/content/Context;
    .param p3, "apptag"    # Ljava/lang/String;
    .param p4, "nativeAd"    # Lcom/facebook/ads/NativeAd;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/facebook/ads/NativeAd;",
            ")V"
        }
    .end annotation

    .prologue
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 238
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 61
    new-instance v0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/AppListviewAdapter$1;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->handler:Landroid/os/Handler;

    .line 133
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->istag:Ljava/lang/Boolean;

    .line 222
    iput-object v2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 224
    iput-object v2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 227
    iput-object v2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->typeFace:Landroid/graphics/Typeface;

    .line 228
    iput-object v2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    .line 241
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 242
    const-string v1, "Roboto-Light.ttf"

    .line 241
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->typeFace:Landroid/graphics/Typeface;

    .line 244
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 245
    const-string v1, "Roboto-Condensed.ttf"

    .line 244
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->typeFace2:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 251
    :goto_0
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    .line 252
    iput-object p2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;

    .line 253
    iput-object p3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;

    .line 254
    iput-object p4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->nativeAd:Lcom/facebook/ads/NativeAd;

    .line 255
    const-string v0, "www"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "ex="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 257
    :try_start_1
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 258
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->initView()V

    .line 259
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p1}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 260
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->headers:Ljava/util/HashMap;

    .line 261
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->headers:Ljava/util/HashMap;

    const-string v1, "AIOD"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 262
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->headers:Ljava/util/HashMap;

    const-string v1, "Referer"

    invoke-static {}, Lcom/aio/downloader/utils/publicTools;->get_a_random_user_webview()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 264
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->default_options:Ljava/util/HashMap;

    .line 265
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 266
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 267
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 268
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 270
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 271
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p1}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 273
    :cond_0
    const-string v0, "network"

    .line 274
    const/4 v1, 0x0

    .line 273
    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;

    .line 276
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 277
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 276
    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 278
    const-string v0, "name"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->sp2:Landroid/content/SharedPreferences;

    .line 279
    const-string v0, "appid"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->sp3:Landroid/content/SharedPreferences;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 282
    :goto_1
    return-void

    .line 280
    :catch_0
    move-exception v0

    goto :goto_1

    .line 247
    :catch_1
    move-exception v0

    goto/16 :goto_0
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 986
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 987
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    const v2, 0x7f0b0034

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 988
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 989
    const-string v1, "Ok"

    .line 990
    new-instance v2, Lcom/aio/downloader/adapter/AppListviewAdapter$9;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/AppListviewAdapter$9;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter;)V

    .line 989
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 996
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 998
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/AppListviewAdapter;)V
    .locals 0

    .prologue
    .line 985
    invoke-direct {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->Mydialog()V

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/adapter/AppListviewAdapter;)V
    .locals 0

    .prologue
    .line 955
    invoke-direct {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->downwifi()V

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/adapter/AppListviewAdapter;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 220
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->default_options:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/adapter/AppListviewAdapter;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method static synthetic access$14(Lcom/aio/downloader/adapter/AppListviewAdapter;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/AppListviewAdapter;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 133
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->istag:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->sp2:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->sp3:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/adapter/AppListviewAdapter;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 527
    invoke-direct {p0, p1, p2}, Lcom/aio/downloader/adapter/AppListviewAdapter;->popuWindow(ILjava/lang/String;)V

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/widget/PopupWindow;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->mWindow:Landroid/widget/PopupWindow;

    return-object v0
.end method

.method static synthetic access$8(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/util/List;
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->spnetworkre:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public static dip2px(Landroid/content/Context;F)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dpValue"    # F

    .prologue
    .line 677
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v0, v1, Landroid/util/DisplayMetrics;->density:F

    .line 679
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
    .line 956
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    .line 957
    const v4, 0x7f0c000e

    .line 956
    invoke-direct {v0, v3, v4}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 958
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 959
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 960
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 961
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 962
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/adapter/AppListviewAdapter$7;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/AppListviewAdapter$7;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 971
    new-instance v3, Lcom/aio/downloader/adapter/AppListviewAdapter$8;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/adapter/AppListviewAdapter$8;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 982
    return-void
.end method

.method private popuWindow(ILjava/lang/String;)V
    .locals 9
    .param p1, "myPosition"    # I
    .param p2, "mHas_apk"    # Ljava/lang/String;

    .prologue
    const/4 v8, -0x2

    .line 529
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    invoke-static {v6}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 530
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const v6, 0x7f03009a

    const/4 v7, 0x0

    invoke-virtual {v1, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 532
    .local v5, "view":Landroid/view/View;
    const v6, 0x7f070359

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 531
    check-cast v2, Lcom/aio/downloader/views/LFrameLayout;

    .line 534
    .local v2, "rl_download":Lcom/aio/downloader/views/LFrameLayout;
    const v6, 0x7f07035a

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/views/LFrameLayout;

    .line 536
    .local v3, "rl_share":Lcom/aio/downloader/views/LFrameLayout;
    const v6, 0x7f07035b

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 535
    check-cast v4, Lcom/aio/downloader/views/LFrameLayout;

    .line 538
    .local v4, "rl_viewdetail":Lcom/aio/downloader/views/LFrameLayout;
    new-instance v6, Lcom/aio/downloader/adapter/AppListviewAdapter$3;

    invoke-direct {v6, p0, p1, p2}, Lcom/aio/downloader/adapter/AppListviewAdapter$3;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter;ILjava/lang/String;)V

    invoke-virtual {v2, v6}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 612
    new-instance v6, Lcom/aio/downloader/adapter/AppListviewAdapter$4;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/AppListviewAdapter$4;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter;I)V

    invoke-virtual {v3, v6}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 637
    new-instance v6, Lcom/aio/downloader/adapter/AppListviewAdapter$5;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/AppListviewAdapter$5;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter;I)V

    invoke-virtual {v4, v6}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 658
    new-instance v6, Landroid/widget/PopupWindow;

    invoke-direct {v6, v5}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;)V

    iput-object v6, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->mWindow:Landroid/widget/PopupWindow;

    .line 665
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    const/high16 v7, 0x43280000    # 168.0f

    invoke-static {v6, v7}, Lcom/aio/downloader/adapter/AppListviewAdapter;->dip2px(Landroid/content/Context;F)I

    move-result v6

    iput v6, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->dip2px:I

    .line 666
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v6, v8}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 667
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v6, v8}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 669
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->mWindow:Landroid/widget/PopupWindow;

    const/4 v7, 0x1

    invoke-virtual {v6, v7}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 671
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    const/4 v6, 0x0

    invoke-direct {v0, v6}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 672
    .local v0, "dw":Landroid/graphics/drawable/ColorDrawable;
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v6, v0}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 673
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

    .line 705
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 707
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 708
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 709
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

    .line 710
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 711
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    const-string v1, "Failed to connect server. Please try again."

    invoke-static {v0, v1, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 712
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 952
    :goto_0
    return-void

    .line 715
    :cond_0
    new-instance v0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/adapter/AppListviewAdapter$6;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 949
    invoke-virtual {v0, v1}, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

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
    .line 296
    .local p1, "model":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 297
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->notifyDataSetChanged()V

    .line 298
    return-void
.end method

.method public getBooleanValueByConfigFile(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 165
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 288
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 290
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getEdit()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method public getIntegerValueByConfigFile(Ljava/lang/String;)I
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 161
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->getSp()Landroid/content/SharedPreferences;

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
    .line 303
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 309
    int-to-long v0, p1

    return-wide v0
.end method

.method public getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    return-object v0
.end method

.method public getSp()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->sp:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public getStringValueByConfigFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 157
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->sp:Landroid/content/SharedPreferences;

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
    const/4 v6, 0x0

    .line 315
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 316
    .local v1, "in_fo":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    if-nez p2, :cond_1

    .line 317
    new-instance v3, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    invoke-direct {v3, p0}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter;)V

    iput-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    .line 318
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    const v4, 0x7f030016

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 319
    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    const v3, 0x7f0700c3

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 320
    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    .line 321
    const v3, 0x7f0700c4

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 320
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 324
    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    const v3, 0x7f0700c5

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 325
    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    .line 326
    const v3, 0x7f0700c0

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 325
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$3(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 327
    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    .line 328
    const v3, 0x7f0700c6

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 327
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 329
    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    .line 330
    const v3, 0x7f0700be

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RatingBar;

    .line 329
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/RatingBar;)V

    .line 331
    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    .line 332
    const v3, 0x7f0700c7

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/views/LImageButton;

    .line 331
    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Lcom/aio/downloader/views/LImageButton;)V

    .line 333
    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    const v3, 0x7f0700c1

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    invoke-static {v4, v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 349
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    invoke-virtual {p2, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 353
    :goto_0
    const-string v3, "www"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "ex="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 354
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;

    const-string v4, "appsearch"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 355
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->apptitle:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 356
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->apptitle:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 362
    :goto_1
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appauthortitle:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getAuthor_title()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 363
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appauthortitle:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->typeFace2:Landroid/graphics/Typeface;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 364
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appprice:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getPrice()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 365
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->app_ratingbar:Landroid/widget/RatingBar;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$11(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/RatingBar;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getRating()Ljava/lang/Float;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/RatingBar;->setRating(F)V

    .line 367
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appicon:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$12(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 381
    :goto_2
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getPrice()Ljava/lang/String;

    move-result-object v3

    const-string v4, "FREE"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 382
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appprice:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getPrice()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 383
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appprice:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    const/high16 v4, -0x1000000

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 384
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appprice:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/text/TextPaint;->setFlags(I)V

    .line 391
    :goto_3
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_apk()Ljava/lang/String;

    move-result-object v0

    .line 393
    .local v0, "has_apk":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIs_official()Ljava/lang/String;

    move-result-object v2

    .line 395
    .local v2, "is_official":Ljava/lang/String;
    const-string v3, "1"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 396
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->playtop:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$13(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 435
    :cond_0
    :goto_4
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->app_download_bt:Lcom/aio/downloader/views/LImageButton;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$14(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Lcom/aio/downloader/views/LImageButton;

    move-result-object v3

    new-instance v4, Lcom/aio/downloader/adapter/AppListviewAdapter$2;

    invoke-direct {v4, p0, p1, v0}, Lcom/aio/downloader/adapter/AppListviewAdapter$2;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter;ILjava/lang/String;)V

    invoke-virtual {v3, v4}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 523
    return-object p2

    .line 351
    .end local v0    # "has_apk":Ljava/lang/String;
    .end local v2    # "is_official":Ljava/lang/String;
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    iput-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    goto/16 :goto_0

    .line 358
    :cond_2
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->apptitle:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    add-int/lit8 v5, p1, 0x1

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, ". "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 359
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->apptitle:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    goto/16 :goto_1

    .line 386
    :cond_3
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appprice:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getPrice()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 387
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appprice:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    const/high16 v4, -0x10000

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 388
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->appprice:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v3

    const/16 v4, 0x10

    invoke-virtual {v3, v4}, Landroid/text/TextPaint;->setFlags(I)V

    goto/16 :goto_3

    .line 398
    .restart local v0    # "has_apk":Ljava/lang/String;
    .restart local v2    # "is_official":Ljava/lang/String;
    :cond_4
    const-string v3, "0"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 399
    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->holder:Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->playtop:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;->access$13(Lcom/aio/downloader/adapter/AppListviewAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_4

    .line 368
    .end local v0    # "has_apk":Ljava/lang/String;
    .end local v2    # "is_official":Ljava/lang/String;
    :catch_0
    move-exception v3

    goto/16 :goto_2
.end method

.method public getmContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public initView()V
    .locals 4

    .prologue
    .line 171
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    .line 172
    .local v0, "app":Lcom/aio/downloader/mydownload/MyApplcation;
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    const-string v2, "config"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->setSp(Landroid/content/SharedPreferences;)V

    .line 173
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 174
    invoke-virtual {p0, v0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 179
    .end local v0    # "app":Lcom/aio/downloader/mydownload/MyApplcation;
    :goto_0
    return-void

    .line 175
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public putBooleanValueToConfigFile(Ljava/lang/String;Z)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 151
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 152
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 153
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;I)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 145
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 146
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 147
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public putStringValueToConfigFile(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 139
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->getSp()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 140
    .local v0, "e":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 141
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    return v1
.end method

.method public setEdit(Landroid/content/SharedPreferences$Editor;)V
    .locals 0
    .param p1, "edit"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 210
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->edit:Landroid/content/SharedPreferences$Editor;

    .line 211
    return-void
.end method

.method public setMyApp(Lcom/aio/downloader/mydownload/MyApplcation;)V
    .locals 0
    .param p1, "myApp"    # Lcom/aio/downloader/mydownload/MyApplcation;

    .prologue
    .line 202
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->myApp:Lcom/aio/downloader/mydownload/MyApplcation;

    .line 203
    return-void
.end method

.method public setSp(Landroid/content/SharedPreferences;)V
    .locals 0
    .param p1, "sp"    # Landroid/content/SharedPreferences;

    .prologue
    .line 194
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->sp:Landroid/content/SharedPreferences;

    .line 195
    return-void
.end method

.method public setmContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 186
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->mContext:Landroid/content/Context;

    .line 187
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 685
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 686
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 687
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const-string v2, "download_aio"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 690
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 691
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 692
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 690
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 693
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 695
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 701
    :goto_0
    return-void

    .line 698
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 699
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 698
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
