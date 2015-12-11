.class public Lcom/aio/downloader/adapter/UndateAdapter;
.super Landroid/widget/BaseAdapter;
.source "UndateAdapter.java"

# interfaces
.implements Lcom/aio/downloader/mydownload/ContentValue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private ctx:Landroid/content/Context;

.field holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

.field private list_update:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private typeFace:Landroid/graphics/Typeface;

.field private typeFace2:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/ArrayList;)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "list_update":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v0, 0x0

    .line 30
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 27
    iput-object v0, p0, Lcom/aio/downloader/adapter/UndateAdapter;->typeFace:Landroid/graphics/Typeface;

    iput-object v0, p0, Lcom/aio/downloader/adapter/UndateAdapter;->typeFace2:Landroid/graphics/Typeface;

    .line 28
    iput-object v0, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    .line 31
    iput-object p1, p0, Lcom/aio/downloader/adapter/UndateAdapter;->ctx:Landroid/content/Context;

    .line 32
    iput-object p2, p0, Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;

    .line 34
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 35
    const-string v1, "Roboto-Light.ttf"

    .line 34
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/UndateAdapter;->typeFace:Landroid/graphics/Typeface;

    .line 36
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 37
    const-string v1, "Roboto-Condensed.ttf"

    .line 36
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/UndateAdapter;->typeFace2:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 40
    :goto_0
    return-void

    .line 38
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/UndateAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/aio/downloader/adapter/UndateAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/adapter/UndateAdapter;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "arg0"    # I

    .prologue
    .line 51
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "arg0"    # I

    .prologue
    .line 57
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 64
    if-nez p2, :cond_0

    .line 65
    new-instance v5, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    invoke-direct {v5, p0}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/UndateAdapter;)V

    iput-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    .line 66
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->ctx:Landroid/content/Context;

    const v6, 0x7f0300b9

    const/4 v7, 0x0

    invoke-static {v5, v6, v7}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 67
    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    .line 68
    const v5, 0x7f0703e4

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    .line 67
    invoke-static {v6, v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 69
    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    .line 70
    const v5, 0x7f0703e5

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 69
    invoke-static {v6, v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 71
    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    .line 72
    const v5, 0x7f0703e6

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 71
    invoke-static {v6, v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 73
    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    .line 74
    const v5, 0x7f0703e7

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 73
    invoke-static {v6, v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$3(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 75
    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    .line 76
    const v5, 0x7f0703e8

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 75
    invoke-static {v6, v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 77
    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    .line 78
    const v5, 0x7f0703e9

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 77
    invoke-static {v6, v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 80
    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    .line 81
    const v5, 0x7f0703e3

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    .line 80
    invoke-static {v6, v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;Landroid/widget/RelativeLayout;)V

    .line 82
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    const v6, 0x7f0702f8

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;Landroid/view/View;)V

    .line 83
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    invoke-virtual {p2, v5}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 88
    :goto_0
    if-nez p1, :cond_1

    .line 89
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->view_up:Landroid/view/View;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/view/View;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/view/View;->setVisibility(I)V

    .line 93
    :goto_1
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->name:Landroid/widget/TextView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 94
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->tv_current_version_list:Landroid/widget/TextView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->typeFace2:Landroid/graphics/Typeface;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 95
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->tv_updata_version_list:Landroid/widget/TextView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$11(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->typeFace2:Landroid/graphics/Typeface;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 96
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->tv_uninstall_size:Landroid/widget/TextView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$12(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v5

    iget-object v6, p0, Lcom/aio/downloader/adapter/UndateAdapter;->typeFace2:Landroid/graphics/Typeface;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 98
    new-instance v1, Lcom/aio/downloader/utils/MyAppInfo;

    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->ctx:Landroid/content/Context;

    invoke-direct {v1, v5}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 100
    .local v1, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_0
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 101
    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v5

    .line 100
    invoke-virtual {v1, v5}, Lcom/aio/downloader/utils/MyAppInfo;->getAppName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 102
    .local v2, "appName":Ljava/lang/String;
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 103
    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v5

    .line 102
    invoke-virtual {v1, v5}, Lcom/aio/downloader/utils/MyAppInfo;->getAppVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 104
    .local v3, "appVersion":Ljava/lang/String;
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 105
    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v5

    .line 104
    invoke-virtual {v1, v5}, Lcom/aio/downloader/utils/MyAppInfo;->getAppIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 107
    .local v0, "appIcon":Landroid/graphics/drawable/Drawable;
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->icon:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$13(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v5, v0}, Landroid/widget/ImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 108
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->name:Landroid/widget/TextView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v5

    invoke-virtual {v5, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 109
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->tv_current_version_list:Landroid/widget/TextView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$10(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v5

    invoke-virtual {v5, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 110
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->tv_updata_version_list:Landroid/widget/TextView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$11(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 111
    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getVersion()Ljava/lang/String;

    move-result-object v5

    .line 110
    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 112
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->tv_uninstall_size:Landroid/widget/TextView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$12(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v6

    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->list_update:Ljava/util/ArrayList;

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 113
    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSize()Ljava/lang/String;

    move-result-object v5

    .line 112
    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 119
    .end local v0    # "appIcon":Landroid/graphics/drawable/Drawable;
    .end local v2    # "appName":Ljava/lang/String;
    .end local v3    # "appVersion":Ljava/lang/String;
    :goto_2
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->rl_update:Landroid/widget/RelativeLayout;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$14(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/RelativeLayout;

    move-result-object v5

    new-instance v6, Lcom/aio/downloader/adapter/UndateAdapter$1;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/UndateAdapter$1;-><init>(Lcom/aio/downloader/adapter/UndateAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 135
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->tv_uninstall1:Landroid/widget/TextView;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$15(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v5

    new-instance v6, Lcom/aio/downloader/adapter/UndateAdapter$2;

    invoke-direct {v6, p0, p1}, Lcom/aio/downloader/adapter/UndateAdapter$2;-><init>(Lcom/aio/downloader/adapter/UndateAdapter;I)V

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 151
    return-object p2

    .line 86
    .end local v1    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    iput-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    goto/16 :goto_0

    .line 91
    :cond_1
    iget-object v5, p0, Lcom/aio/downloader/adapter/UndateAdapter;->holder:Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->view_up:Landroid/view/View;
    invoke-static {v5}, Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/UndateAdapter$ViewHolder;)Landroid/view/View;

    move-result-object v5

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 115
    .restart local v1    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :catch_0
    move-exception v4

    .line 117
    .local v4, "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2
.end method
