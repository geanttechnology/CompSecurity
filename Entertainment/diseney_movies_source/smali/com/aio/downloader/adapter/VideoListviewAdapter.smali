.class public Lcom/aio/downloader/adapter/VideoListviewAdapter;
.super Landroid/widget/BaseAdapter;
.source "VideoListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field ctx:Landroid/content/Context;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/VideoModel;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;)V
    .locals 0
    .param p1, "ctx"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/VideoModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/VideoModel;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/aio/downloader/adapter/VideoListviewAdapter;->ctx:Landroid/content/Context;

    .line 24
    iput-object p2, p0, Lcom/aio/downloader/adapter/VideoListviewAdapter;->list:Ljava/util/List;

    .line 26
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/aio/downloader/adapter/VideoListviewAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/VideoListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 32
    iget-object v0, p0, Lcom/aio/downloader/adapter/VideoListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 34
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
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/adapter/VideoListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 48
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 53
    const/4 v0, 0x0

    .line 54
    .local v0, "holder":Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;
    iget-object v3, p0, Lcom/aio/downloader/adapter/VideoListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/VideoModel;

    .line 55
    .local v1, "in_fo":Lcom/aio/downloader/model/VideoModel;
    if-nez p2, :cond_1

    .line 56
    new-instance v0, Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;

    .end local v0    # "holder":Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;
    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/VideoListviewAdapter;)V

    .line 57
    .restart local v0    # "holder":Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;
    iget-object v3, p0, Lcom/aio/downloader/adapter/VideoListviewAdapter;->ctx:Landroid/content/Context;

    const v4, 0x7f0300ba

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 58
    const v3, 0x7f0703ea

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, v0, Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;->tv_format:Landroid/widget/TextView;

    .line 59
    const v3, 0x7f0703eb

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, v0, Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;->tv_type:Landroid/widget/TextView;

    .line 60
    const v3, 0x7f0703ec

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, v0, Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;->tv_size:Landroid/widget/TextView;

    .line 61
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 65
    :goto_0
    iget-object v3, v0, Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;->tv_format:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_format()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 66
    iget-object v3, v0, Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;->tv_type:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_type()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 68
    :try_start_0
    iget-object v3, p0, Lcom/aio/downloader/adapter/VideoListviewAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_size()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Landroid/text/format/Formatter;->formatFileSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v2

    .line 69
    .local v2, "video_size":Ljava/lang/String;
    const-string v3, "size"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_size()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 71
    invoke-virtual {v1}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_size()Ljava/lang/String;

    move-result-object v3

    const-string v4, "-1"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v1}, Lcom/aio/downloader/model/VideoModel;->getVideo_item_size()Ljava/lang/String;

    move-result-object v3

    const-string v4, "0"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 74
    iget-object v3, v0, Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;->tv_size:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Size: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    .end local v2    # "video_size":Ljava/lang/String;
    :cond_0
    :goto_1
    return-object p2

    .line 63
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "holder":Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;
    check-cast v0, Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;

    .restart local v0    # "holder":Lcom/aio/downloader/adapter/VideoListviewAdapter$ViewHolder;
    goto/16 :goto_0

    .line 77
    :catch_0
    move-exception v3

    goto :goto_1
.end method
