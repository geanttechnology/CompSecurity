.class public Lcom/aio/downloader/adapter/AppDownloadedAdapter;
.super Landroid/widget/BaseAdapter;
.source "AppDownloadedAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private final ACTION_NAME_VER:Ljava/lang/String;

.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private ctx:Landroid/content/Context;

.field holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

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

.field private mBroadcastReceiver:Landroid/content/BroadcastReceiver;

.field private myVer:Ljava/lang/String;

.field private packageInfo:Landroid/content/pm/PackageInfo;

.field private typeFace:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v1, 0x0

    .line 46
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 40
    iput-object v1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 41
    iput-object v1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->typeFace:Landroid/graphics/Typeface;

    .line 43
    const-string v0, "wocaonima"

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ACTION_NAME_VER:Ljava/lang/String;

    .line 44
    iput-object v1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    .line 343
    new-instance v0, Lcom/aio/downloader/adapter/AppDownloadedAdapter$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$1;-><init>(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    .line 47
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;

    .line 48
    iput-object p2, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->list:Ljava/util/List;

    .line 51
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 56
    :goto_0
    :try_start_1
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 57
    const-string v1, "Roboto-Light.ttf"

    .line 56
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->typeFace:Landroid/graphics/Typeface;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 62
    :goto_1
    return-void

    .line 59
    :catch_0
    move-exception v0

    goto :goto_1

    .line 52
    :catch_1
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/AppDownloadedAdapter;Landroid/content/pm/PackageInfo;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)Landroid/content/pm/PackageInfo;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;

    return-object v0
.end method

.method public static bitmapToDrawble(Landroid/graphics/Bitmap;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;
    .param p1, "mcontext"    # Landroid/content/Context;

    .prologue
    .line 339
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 340
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 70
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 78
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 84
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 12
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v11, 0x0

    const/16 v10, 0x6e

    .line 90
    const-string v6, "oiu"

    const-string v7, "cccccccccc"

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 92
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v6, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 93
    .local v4, "in_fo":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    if-nez p2, :cond_5

    .line 94
    new-instance v6, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    invoke-direct {v6, p0}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/AppDownloadedAdapter;)V

    iput-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    .line 95
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;

    const v7, 0x7f030015

    invoke-static {v6, v7, v11}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 97
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    .line 98
    const v6, 0x7f0700ee

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageView;

    .line 97
    invoke-static {v7, v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 99
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    .line 100
    const v6, 0x7f0700ef

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageView;

    .line 99
    invoke-static {v7, v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 101
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    .line 102
    const v6, 0x7f0700f0

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 101
    invoke-static {v7, v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$3(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 103
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    .line 104
    const v6, 0x7f0700f1

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 103
    invoke-static {v7, v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 105
    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    .line 106
    const v6, 0x7f0700f2

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 105
    invoke-static {v7, v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 107
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    invoke-virtual {p2, v6}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 112
    :goto_0
    :try_start_0
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_totalsize:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;

    .line 113
    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFileSize()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v8

    .line 112
    invoke-static {v7, v8, v9}, Landroid/text/format/Formatter;->formatFileSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_4

    .line 118
    :goto_1
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_movie_name_item:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 121
    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v6

    if-eq v6, v10, :cond_0

    .line 123
    :try_start_1
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v7

    .line 124
    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_test_head_image:Landroid/widget/ImageView;
    invoke-static {v8}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v8

    .line 123
    invoke-virtual {v6, v7, v8}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    .line 132
    :cond_0
    :goto_2
    :try_start_2
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 133
    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    .line 132
    invoke-virtual {v6, v7, v8}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v6

    iput-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;
    :try_end_2
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_2 .. :try_end_2} :catch_0

    .line 140
    :goto_3
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;

    if-eqz v6, :cond_6

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v6

    if-eq v6, v10, :cond_6

    .line 142
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "Open"

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 147
    :goto_4
    const-string v6, "qwa"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "in_fo.getSerial()="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 148
    const-string v8, "in_fo.getFile_id()="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "packageInfo="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 149
    iget-object v8, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 147
    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 150
    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v6

    if-ne v6, v10, :cond_1

    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;

    if-eqz v6, :cond_1

    .line 151
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "Update"

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 152
    new-instance v1, Lcom/aio/downloader/utils/MyAppInfo;

    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-direct {v1, v6}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 154
    .local v1, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_3
    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Lcom/aio/downloader/utils/MyAppInfo;->getAppIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 155
    .local v0, "appIcon":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v6}, Lcom/aio/downloader/utils/MyAppInfo;->getAppVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->myVer:Ljava/lang/String;

    .line 156
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_test_head_image:Landroid/widget/ImageView;
    invoke-static {v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v6

    invoke-virtual {v6, v0}, Landroid/widget/ImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    :try_end_3
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_3 .. :try_end_3} :catch_1

    .line 163
    .end local v0    # "appIcon":Landroid/graphics/drawable/Drawable;
    .end local v1    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :cond_1
    :goto_5
    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v6

    const-string v7, "mp3"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v6

    const-string v7, "video"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 164
    :cond_2
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "Play"

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 172
    :cond_3
    new-instance v5, Landroid/content/IntentFilter;

    invoke-direct {v5}, Landroid/content/IntentFilter;-><init>()V

    .line 173
    .local v5, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v6, "wocaonima"

    invoke-virtual {v5, v6}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 175
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->ctx:Landroid/content/Context;

    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->mBroadcastReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v6, v7, v5}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 177
    :try_start_4
    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->myVer:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 178
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;

    if-eqz v6, :cond_4

    .line 180
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "Open"

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    .line 187
    :cond_4
    :goto_6
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    new-instance v7, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;

    invoke-direct {v7, p0, v4}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$2;-><init>(Lcom/aio/downloader/adapter/AppDownloadedAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 312
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_delete_movie:Landroid/widget/ImageView;
    invoke-static {v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v6

    new-instance v7, Lcom/aio/downloader/adapter/AppDownloadedAdapter$3;

    invoke-direct {v7, p0, p1}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$3;-><init>(Lcom/aio/downloader/adapter/AppDownloadedAdapter;I)V

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 325
    return-object p2

    .line 109
    .end local v5    # "myIntentFilter":Landroid/content/IntentFilter;
    :cond_5
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    iput-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    goto/16 :goto_0

    .line 134
    :catch_0
    move-exception v3

    .line 135
    .local v3, "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v6, "qwa"

    const-string v7, "catch"

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 136
    iput-object v11, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->packageInfo:Landroid/content/pm/PackageInfo;

    .line 137
    invoke-virtual {v3}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_3

    .line 145
    .end local v3    # "e1":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_6
    iget-object v6, p0, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/AppDownloadedAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "Install"

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_4

    .line 157
    .restart local v1    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_1
    move-exception v2

    .line 159
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_5

    .line 182
    .end local v1    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v2    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v5    # "myIntentFilter":Landroid/content/IntentFilter;
    :catch_2
    move-exception v6

    goto :goto_6

    .line 125
    .end local v5    # "myIntentFilter":Landroid/content/IntentFilter;
    :catch_3
    move-exception v6

    goto/16 :goto_2

    .line 114
    :catch_4
    move-exception v6

    goto/16 :goto_1
.end method
