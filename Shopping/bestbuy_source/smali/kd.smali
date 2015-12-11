.class public Lkd;
.super Landroid/support/v4/view/PagerAdapter;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation
.end field

.field private c:I

.field private d:Landroid/content/Context;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;Landroid/content/Context;Landroid/support/v4/view/ViewPager;Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/support/v4/view/ViewPager;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 82
    iput-object p1, p0, Lkd;->a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    .line 83
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 84
    iput-object p2, p0, Lkd;->d:Landroid/content/Context;

    move-object v0, p4

    .line 85
    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lkd;->b:Ljava/util/ArrayList;

    .line 86
    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x2

    iput v0, p0, Lkd;->c:I

    .line 88
    invoke-interface {p4, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    .line 89
    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {p4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    .line 90
    invoke-interface {p4, v2, v1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 91
    invoke-interface {p4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 93
    new-instance v0, Lkd$1;

    invoke-direct {v0, p0, p1, p3}, Lkd$1;-><init>(Lkd;Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;Landroid/support/v4/view/ViewPager;)V

    invoke-virtual {p3, v0}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 115
    return-void
.end method


# virtual methods
.method public destroyItem(Landroid/view/View;ILjava/lang/Object;)V
    .locals 0

    .prologue
    .line 127
    check-cast p1, Landroid/support/v4/view/ViewPager;

    check-cast p3, Landroid/view/View;

    invoke-virtual {p1, p3}, Landroid/support/v4/view/ViewPager;->removeView(Landroid/view/View;)V

    .line 128
    return-void
.end method

.method public finishUpdate(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 132
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 118
    iget v0, p0, Lkd;->c:I

    return v0
.end method

.method public instantiateItem(Landroid/view/View;I)Ljava/lang/Object;
    .locals 3

    .prologue
    .line 122
    iget-object v0, p0, Lkd;->a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    iget-object v1, p0, Lkd;->d:Landroid/content/Context;

    iget-object v2, p0, Lkd;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, v1, p1, p2, v2}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->a(Landroid/content/Context;Landroid/view/View;ILjava/util/List;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1

    .prologue
    .line 136
    check-cast p2, Landroid/view/View;

    if-ne p1, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public restoreState(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V
    .locals 0

    .prologue
    .line 141
    return-void
.end method

.method public saveState()Landroid/os/Parcelable;
    .locals 1

    .prologue
    .line 145
    const/4 v0, 0x0

    return-object v0
.end method

.method public startUpdate(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 150
    return-void
.end method
