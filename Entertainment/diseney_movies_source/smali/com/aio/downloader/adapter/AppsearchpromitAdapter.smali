.class public Lcom/aio/downloader/adapter/AppsearchpromitAdapter;
.super Landroid/widget/BaseAdapter;
.source "AppsearchpromitAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private ctx:Landroid/content/Context;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/SearcherPromitModel;",
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
            "Lcom/aio/downloader/model/SearcherPromitModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 19
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/SearcherPromitModel;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;->ctx:Landroid/content/Context;

    .line 21
    iput-object p2, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;->list:Ljava/util/List;

    .line 22
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 27
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 29
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
    .line 35
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 41
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 46
    const/4 v0, 0x0

    .line 47
    .local v0, "holder":Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/SearcherPromitModel;

    .line 49
    .local v1, "in_fo":Lcom/aio/downloader/model/SearcherPromitModel;
    if-nez p2, :cond_0

    .line 50
    new-instance v0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;

    .end local v0    # "holder":Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;
    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/AppsearchpromitAdapter;)V

    .line 51
    .restart local v0    # "holder":Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;
    iget-object v2, p0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter;->ctx:Landroid/content/Context;

    const v3, 0x7f03001e

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 52
    const v2, 0x7f07011f

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    invoke-static {v0, v2}, Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 53
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 57
    :goto_0
    # getter for: Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;->keytv:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v1}, Lcom/aio/downloader/model/SearcherPromitModel;->getS()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 58
    return-object p2

    .line 55
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "holder":Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;
    check-cast v0, Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;

    .restart local v0    # "holder":Lcom/aio/downloader/adapter/AppsearchpromitAdapter$ViewHolder;
    goto :goto_0
.end method
