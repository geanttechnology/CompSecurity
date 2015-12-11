.class public Lcom/aio/downloader/adapter/ListAdapter;
.super Landroid/widget/BaseAdapter;
.source "ListAdapter.java"


# instance fields
.field context:Landroid/content/Context;

.field la:Landroid/view/LayoutInflater;

.field list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Programe;",
            ">;"
        }
    .end annotation
.end field

.field lp:Landroid/view/ViewGroup$LayoutParams;


# direct methods
.method public constructor <init>(Ljava/util/List;Landroid/content/Context;)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Programe;",
            ">;",
            "Landroid/content/Context;",
            ")V"
        }
    .end annotation

    .prologue
    .line 25
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/Programe;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/ListAdapter;->list:Ljava/util/List;

    .line 26
    iput-object p1, p0, Lcom/aio/downloader/adapter/ListAdapter;->list:Ljava/util/List;

    .line 27
    iput-object p2, p0, Lcom/aio/downloader/adapter/ListAdapter;->context:Landroid/content/Context;

    .line 28
    return-void
.end method

.method private dip2px(Landroid/content/Context;F)I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "dpValue"    # F

    .prologue
    .line 89
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v0, v1, Landroid/util/DisplayMetrics;->density:F

    .line 90
    .local v0, "scale":F
    mul-float v1, p2, v0

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v1, v1

    return v1
.end method


# virtual methods
.method public getCount()I
    .locals 2

    .prologue
    const/16 v0, 0x14

    .line 33
    iget-object v1, p0, Lcom/aio/downloader/adapter/ListAdapter;->list:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-le v1, v0, :cond_0

    .line 36
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/adapter/ListAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 44
    iget-object v0, p0, Lcom/aio/downloader/adapter/ListAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 50
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/high16 v5, 0x42200000    # 40.0f

    .line 56
    if-nez p2, :cond_0

    .line 57
    iget-object v2, p0, Lcom/aio/downloader/adapter/ListAdapter;->context:Landroid/content/Context;

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/adapter/ListAdapter;->la:Landroid/view/LayoutInflater;

    .line 58
    iget-object v2, p0, Lcom/aio/downloader/adapter/ListAdapter;->la:Landroid/view/LayoutInflater;

    const v3, 0x7f0300a3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 60
    new-instance v0, Lcom/aio/downloader/adapter/ViewHolder;

    invoke-direct {v0}, Lcom/aio/downloader/adapter/ViewHolder;-><init>()V

    .line 62
    .local v0, "holder":Lcom/aio/downloader/adapter/ViewHolder;
    const v2, 0x7f07037f

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 61
    iput-object v2, v0, Lcom/aio/downloader/adapter/ViewHolder;->imgage:Landroid/widget/ImageView;

    .line 64
    const v2, 0x7f070380

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 63
    iput-object v2, v0, Lcom/aio/downloader/adapter/ViewHolder;->text:Landroid/widget/TextView;

    .line 66
    iget-object v2, v0, Lcom/aio/downloader/adapter/ViewHolder;->imgage:Landroid/widget/ImageView;

    invoke-virtual {v2}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/adapter/ListAdapter;->lp:Landroid/view/ViewGroup$LayoutParams;

    .line 67
    iget-object v2, p0, Lcom/aio/downloader/adapter/ListAdapter;->lp:Landroid/view/ViewGroup$LayoutParams;

    iget-object v3, p0, Lcom/aio/downloader/adapter/ListAdapter;->context:Landroid/content/Context;

    invoke-direct {p0, v3, v5}, Lcom/aio/downloader/adapter/ListAdapter;->dip2px(Landroid/content/Context;F)I

    move-result v3

    iput v3, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 68
    iget-object v2, p0, Lcom/aio/downloader/adapter/ListAdapter;->lp:Landroid/view/ViewGroup$LayoutParams;

    iget-object v3, p0, Lcom/aio/downloader/adapter/ListAdapter;->context:Landroid/content/Context;

    invoke-direct {p0, v3, v5}, Lcom/aio/downloader/adapter/ListAdapter;->dip2px(Landroid/content/Context;F)I

    move-result v3

    iput v3, v2, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 69
    iget-object v2, v0, Lcom/aio/downloader/adapter/ViewHolder;->imgage:Landroid/widget/ImageView;

    iget-object v3, p0, Lcom/aio/downloader/adapter/ListAdapter;->lp:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 71
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 75
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/adapter/ListAdapter;->list:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/Programe;

    .line 77
    .local v1, "pr":Lcom/aio/downloader/model/Programe;
    iget-object v2, v0, Lcom/aio/downloader/adapter/ViewHolder;->imgage:Landroid/widget/ImageView;

    invoke-virtual {v1}, Lcom/aio/downloader/model/Programe;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 78
    const-string v2, "toggletag"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "toggletag="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/aio/downloader/model/Programe;->getPackagename()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 80
    iget-object v2, v0, Lcom/aio/downloader/adapter/ViewHolder;->text:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/aio/downloader/model/Programe;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 82
    return-object p2

    .line 73
    .end local v0    # "holder":Lcom/aio/downloader/adapter/ViewHolder;
    .end local v1    # "pr":Lcom/aio/downloader/model/Programe;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/adapter/ViewHolder;

    .restart local v0    # "holder":Lcom/aio/downloader/adapter/ViewHolder;
    goto :goto_0
.end method
