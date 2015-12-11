.class public Lds;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Landroid/view/LayoutInflater;

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 28
    const v0, 0x7f030053

    invoke-direct {p0, p1, v0, p2}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 29
    iput-object p1, p0, Lds;->a:Landroid/app/Activity;

    .line 30
    iput-object p2, p0, Lds;->c:Ljava/util/ArrayList;

    .line 31
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lds;->b:Landroid/view/LayoutInflater;

    .line 32
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)I
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lds;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public getCount()I
    .locals 2

    .prologue
    const/4 v0, 0x3

    .line 36
    iget-object v1, p0, Lds;->c:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v1, v0, :cond_0

    .line 37
    iget-object v0, p0, Lds;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 39
    :cond_0
    return v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 21
    check-cast p1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {p0, p1}, Lds;->a(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8

    .prologue
    const v5, 0x7f080068

    const/4 v3, 0x0

    .line 51
    if-nez p2, :cond_6

    .line 52
    iget-object v0, p0, Lds;->b:Landroid/view/LayoutInflater;

    const v1, 0x7f030053

    invoke-virtual {v0, v1, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 53
    new-instance v1, Ldt;

    invoke-direct {v1}, Ldt;-><init>()V

    .line 54
    const v0, 0x7f0c012e

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Ldt;->a:Landroid/widget/ImageView;

    .line 55
    const v0, 0x7f0c012f

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Ldt;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 56
    const v0, 0x7f0c00cd

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Ldt;->c:Landroid/widget/LinearLayout;

    .line 57
    iget-object v0, v1, Ldt;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 58
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 59
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v7, v1

    .line 63
    :goto_0
    iget-object v0, p0, Lds;->c:Ljava/util/ArrayList;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lds;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 64
    iget-object v0, p0, Lds;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 65
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v2

    .line 66
    const-string v0, ""

    .line 67
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 68
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 69
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 70
    :cond_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_1

    iget-object v4, p0, Lds;->a:Landroid/app/Activity;

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 71
    :cond_1
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 72
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 74
    :cond_2
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_3

    iget-object v4, p0, Lds;->a:Landroid/app/Activity;

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 75
    :cond_3
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 76
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 79
    :cond_4
    iget-object v4, v7, Ldt;->a:Landroid/widget/ImageView;

    invoke-static {v0, v4, v3}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 80
    iget-object v0, v7, Ldt;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 81
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    .line 82
    if-eqz v0, :cond_5

    .line 83
    iget-object v0, p0, Lds;->a:Landroid/app/Activity;

    const/4 v2, 0x1

    const/4 v4, 0x0

    const-string v6, ""

    move v5, v3

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 84
    if-eqz v0, :cond_5

    .line 85
    iget-object v1, v7, Ldt;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 86
    iget-object v1, v7, Ldt;->c:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 90
    :cond_5
    return-object p2

    .line 61
    :cond_6
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ldt;

    move-object v7, v0

    goto/16 :goto_0
.end method
