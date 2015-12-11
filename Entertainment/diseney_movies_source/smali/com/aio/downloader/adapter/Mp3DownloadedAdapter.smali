.class public Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;
.super Landroid/widget/BaseAdapter;
.source "Mp3DownloadedAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private ctx:Landroid/content/Context;

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
    .line 27
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->ctx:Landroid/content/Context;

    .line 29
    iput-object p2, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->list:Ljava/util/List;

    .line 31
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 36
    :goto_0
    return-void

    .line 33
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 42
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 44
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
    .line 52
    iget-object v0, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 58
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 63
    const/4 v0, 0x0

    .line 64
    .local v0, "holder":Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;
    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 65
    .local v1, "in_fo":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    if-nez p2, :cond_0

    .line 66
    new-instance v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;

    .end local v0    # "holder":Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;
    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;)V

    .line 67
    .restart local v0    # "holder":Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;
    iget-object v2, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->ctx:Landroid/content/Context;

    .line 68
    const v3, 0x7f03007b

    const/4 v4, 0x0

    .line 67
    invoke-static {v2, v3, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 70
    const v2, 0x7f0702e8

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 69
    iput-object v2, v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;->my_delete_movie:Landroid/widget/ImageView;

    .line 72
    const v2, 0x7f0702e9

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 71
    iput-object v2, v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;->my_test_head_image:Landroid/widget/ImageView;

    .line 74
    const v2, 0x7f0702ea

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 73
    iput-object v2, v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;->my_movie_name_item:Landroid/widget/TextView;

    .line 76
    const v2, 0x7f0702eb

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 75
    iput-object v2, v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;->my_totalsize:Landroid/widget/TextView;

    .line 78
    const v2, 0x7f0702ec

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 77
    iput-object v2, v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/Button;

    .line 79
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 84
    :goto_0
    :try_start_0
    iget-object v2, v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;->my_totalsize:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFileSize()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/text/format/Formatter;->formatFileSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 89
    :goto_1
    iget-object v2, v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;->my_movie_name_item:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 95
    iget-object v2, v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;->my_stop_download_bt:Landroid/widget/Button;

    new-instance v3, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$1;

    invoke-direct {v3, p0, v1}, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$1;-><init>(Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 112
    iget-object v2, v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;->my_delete_movie:Landroid/widget/ImageView;

    new-instance v3, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$2;

    invoke-direct {v3, p0, p1}, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$2;-><init>(Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;I)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    return-object p2

    .line 81
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "holder":Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;
    check-cast v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;

    .restart local v0    # "holder":Lcom/aio/downloader/adapter/Mp3DownloadedAdapter$ViewHolder;
    goto :goto_0

    .line 85
    :catch_0
    move-exception v2

    goto :goto_1
.end method
