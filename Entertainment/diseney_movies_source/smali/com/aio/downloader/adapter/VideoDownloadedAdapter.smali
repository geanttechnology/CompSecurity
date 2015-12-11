.class public Lcom/aio/downloader/adapter/VideoDownloadedAdapter;
.super Landroid/widget/BaseAdapter;
.source "VideoDownloadedAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field ctx:Landroid/content/Context;

.field private holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

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


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;)V
    .locals 1
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
    .line 28
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 23
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    .line 29
    iput-object p1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->ctx:Landroid/content/Context;

    .line 30
    iput-object p2, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->list:Ljava/util/List;

    .line 32
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 37
    :goto_0
    return-void

    .line 34
    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 45
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
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 59
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 65
    iget-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 66
    .local v0, "in_fo":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    if-nez p2, :cond_0

    .line 67
    new-instance v1, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    invoke-direct {v1, p0}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/VideoDownloadedAdapter;)V

    iput-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    .line 68
    iget-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->ctx:Landroid/content/Context;

    .line 69
    const v2, 0x7f0300bb

    const/4 v3, 0x0

    .line 68
    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 70
    iget-object v2, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    .line 71
    const v1, 0x7f0703ee

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 70
    iput-object v1, v2, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;->my_delete_movie:Landroid/widget/ImageView;

    .line 72
    iget-object v2, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    .line 73
    const v1, 0x7f0703ef

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 72
    iput-object v1, v2, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;->my_test_head_image:Landroid/widget/ImageView;

    .line 74
    iget-object v2, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    .line 75
    const v1, 0x7f0703f0

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 74
    iput-object v1, v2, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;->my_movie_name_item:Landroid/widget/TextView;

    .line 76
    iget-object v2, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    .line 77
    const v1, 0x7f0703f1

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 76
    iput-object v1, v2, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;->my_totalsize:Landroid/widget/TextView;

    .line 78
    iget-object v2, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    .line 79
    const v1, 0x7f0703f2

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 78
    iput-object v1, v2, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/Button;

    .line 80
    iget-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 86
    :goto_0
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    iget-object v1, v1, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;->my_totalsize:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFileSize()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    invoke-static {v2, v3, v4}, Landroid/text/format/Formatter;->formatFileSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 90
    :goto_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    iget-object v1, v1, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;->my_movie_name_item:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    :try_start_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    iget-object v3, v3, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;->my_test_head_image:Landroid/widget/ImageView;

    invoke-virtual {v1, v2, v3}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 101
    :goto_2
    iget-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    iget-object v1, v1, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/Button;

    new-instance v2, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$1;

    invoke-direct {v2, p0, v0}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$1;-><init>(Lcom/aio/downloader/adapter/VideoDownloadedAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 116
    iget-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    iget-object v1, v1, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;->my_delete_movie:Landroid/widget/ImageView;

    new-instance v2, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$2;

    invoke-direct {v2, p0, p1}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$2;-><init>(Lcom/aio/downloader/adapter/VideoDownloadedAdapter;I)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 128
    return-object p2

    .line 82
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    iput-object v1, p0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->holder:Lcom/aio/downloader/adapter/VideoDownloadedAdapter$ViewHolder;

    goto :goto_0

    .line 93
    :catch_0
    move-exception v1

    goto :goto_2

    .line 87
    :catch_1
    move-exception v1

    goto :goto_1
.end method
