.class public Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;
.super Landroid/widget/BaseAdapter;
.source "ApprecommendkeywordAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private ctx:Landroid/content/Context;

.field private i:I

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/SearchkeywordModel;",
            ">;"
        }
    .end annotation
.end field

.field private x1:I

.field private x2:I


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
            "Lcom/aio/downloader/model/SearchkeywordModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/SearchkeywordModel;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 20
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->i:I

    .line 25
    iput-object p1, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->ctx:Landroid/content/Context;

    .line 26
    iput-object p2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->list:Ljava/util/List;

    .line 28
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 3

    .prologue
    .line 32
    iget-object v0, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 33
    const-string v0, "sda"

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->list:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 34
    iget-object v0, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 36
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
    .line 43
    iget-object v0, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 49
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "arg2"    # Landroid/view/ViewGroup;

    .prologue
    .line 54
    iget-object v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/SearchkeywordModel;

    .line 55
    .local v1, "model":Lcom/aio/downloader/model/SearchkeywordModel;
    const/4 v0, 0x0

    .line 56
    .local v0, "holder":Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;
    if-nez p2, :cond_2

    .line 57
    new-instance v0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;

    .end local v0    # "holder":Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;
    invoke-direct {v0, p0}, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;)V

    .line 59
    .restart local v0    # "holder":Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;
    iget-object v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->ctx:Landroid/content/Context;

    const v3, 0x7f0300ad

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 61
    const v2, 0x7f0703b7

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 60
    invoke-static {v0, v2}, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 62
    const v2, 0x7f0700c1

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    invoke-static {v0, v2}, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 63
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 67
    :goto_0
    # getter for: Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;->searchtitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v2

    invoke-virtual {v1}, Lcom/aio/downloader/model/SearchkeywordModel;->getKeyword()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 68
    iget v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->i:I

    if-nez v2, :cond_0

    .line 69
    iget v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->i:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->i:I

    .line 70
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    iget-object v4, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->list:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    int-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->x1:I

    .line 71
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    iget-object v4, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->list:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    int-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->x2:I

    .line 72
    iget v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->x1:I

    iget v3, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->x2:I

    if-ne v2, v3, :cond_0

    .line 73
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v2

    iget-object v4, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->list:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    int-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-int v2, v2

    iput v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->x2:I

    .line 77
    :cond_0
    iget v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->x1:I

    if-eq p1, v2, :cond_1

    iget v2, p0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter;->x2:I

    if-ne p1, v2, :cond_3

    .line 78
    :cond_1
    # getter for: Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;->searchtitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v2

    const/high16 v3, -0x10000

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 98
    :goto_1
    return-object p2

    .line 65
    :cond_2
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "holder":Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;
    check-cast v0, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;

    .restart local v0    # "holder":Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;
    goto :goto_0

    .line 80
    :cond_3
    # getter for: Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;->searchtitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/ApprecommendkeywordAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v2

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1
.end method
