.class public Lkn;
.super Landroid/support/v4/view/PagerAdapter;
.source "SourceFile"


# instance fields
.field a:Landroid/content/Context;

.field b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic c:Lcom/bestbuy/android/bbyobjects/ProductImageGallery;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;Landroid/content/Context;Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 68
    iput-object p1, p0, Lkn;->c:Lcom/bestbuy/android/bbyobjects/ProductImageGallery;

    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 69
    iput-object p3, p0, Lkn;->b:Ljava/util/List;

    .line 70
    iput-object p2, p0, Lkn;->a:Landroid/content/Context;

    .line 71
    return-void
.end method


# virtual methods
.method public destroyItem(Landroid/view/View;ILjava/lang/Object;)V
    .locals 0

    .prologue
    .line 100
    check-cast p1, Landroid/support/v4/view/ViewPager;

    check-cast p3, Landroid/widget/RelativeLayout;

    invoke-virtual {p1, p3}, Landroid/support/v4/view/ViewPager;->removeView(Landroid/view/View;)V

    .line 101
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lkn;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public instantiateItem(Landroid/view/View;I)Ljava/lang/Object;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 80
    iget-object v0, p0, Lkn;->c:Lcom/bestbuy/android/bbyobjects/ProductImageGallery;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->a(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f030041

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 81
    const v1, 0x7f0c0109

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 82
    iget-object v2, p0, Lkn;->b:Ljava/util/List;

    invoke-interface {v2, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 83
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_0

    .line 84
    invoke-static {v2, v1, v4}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 86
    :cond_0
    new-instance v1, Lkn$1;

    invoke-direct {v1, p0, p2}, Lkn$1;-><init>(Lkn;I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 94
    check-cast p1, Landroid/support/v4/view/ViewPager;

    invoke-virtual {p1, v0, v4}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;I)V

    .line 95
    return-object v0
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1

    .prologue
    .line 105
    check-cast p2, Landroid/widget/RelativeLayout;

    if-ne p1, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public saveState()Landroid/os/Parcelable;
    .locals 1

    .prologue
    .line 110
    const/4 v0, 0x0

    return-object v0
.end method
