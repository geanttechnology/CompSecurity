.class public Lcom/bestbuy/android/bbyobjects/ProductImageGallery;
.super Landroid/widget/RelativeLayout;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# instance fields
.field private a:Lkl;

.field private b:Landroid/view/LayoutInflater;

.field private c:Landroid/support/v4/view/ViewPager;

.field private d:Lkm;

.field private e:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->e:Landroid/content/Context;

    .line 30
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->e:Landroid/content/Context;

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->e:Landroid/content/Context;

    .line 40
    return-void
.end method

.method public static synthetic a(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;)Landroid/view/LayoutInflater;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->b:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method public static synthetic b(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;)Lkm;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->d:Lkm;

    return-object v0
.end method

.method public static synthetic c(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;)Landroid/support/v4/view/ViewPager;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->c:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method


# virtual methods
.method public a(Landroid/content/Context;Ljava/util/List;Lkm;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lkm;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v1, -0x1

    const/4 v4, -0x2

    const/4 v3, 0x0

    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->e:Landroid/content/Context;

    .line 44
    iput-object p3, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->d:Lkm;

    .line 45
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->b:Landroid/view/LayoutInflater;

    .line 46
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 47
    new-instance v1, Landroid/support/v4/view/ViewPager;

    invoke-direct {v1, p1}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->c:Landroid/support/v4/view/ViewPager;

    .line 48
    new-instance v1, Lkn;

    invoke-direct {v1, p0, p1, p2}, Lkn;-><init>(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;Landroid/content/Context;Ljava/util/List;)V

    .line 50
    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->c:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 51
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->c:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1, v3}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 52
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->c:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1, p0}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 53
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->c:Landroid/support/v4/view/ViewPager;

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 54
    new-instance v0, Lkl;

    invoke-direct {v0, p0, p1}, Lkl;-><init>(Lcom/bestbuy/android/bbyobjects/ProductImageGallery;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->a:Lkl;

    .line 55
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v4, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 56
    const/16 v1, 0xe

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 57
    const/16 v1, 0xc

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 58
    const/16 v1, 0x1e

    const/4 v2, 0x5

    invoke-virtual {v0, v3, v1, v3, v2}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 59
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->a:Lkl;

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 60
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->a:Lkl;

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    invoke-virtual {v0, v1}, Lkl;->a(I)V

    .line 63
    :cond_0
    return-void
.end method

.method public onPageScrollStateChanged(I)V
    .locals 1

    .prologue
    .line 116
    if-nez p1, :cond_1

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->e:Landroid/content/Context;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->reEnablePullDown()V

    .line 121
    :cond_0
    :goto_0
    return-void

    .line 118
    :cond_1
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->e:Landroid/content/Context;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->disablePullDown()V

    goto :goto_0
.end method

.method public onPageScrolled(IFI)V
    .locals 0

    .prologue
    .line 126
    return-void
.end method

.method public onPageSelected(I)V
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/ProductImageGallery;->a:Lkl;

    invoke-virtual {v0, p1}, Lkl;->b(I)V

    .line 131
    return-void
.end method
