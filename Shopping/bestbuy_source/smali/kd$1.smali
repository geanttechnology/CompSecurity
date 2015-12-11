.class Lkd$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkd;-><init>(Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;Landroid/content/Context;Landroid/support/v4/view/ViewPager;Ljava/util/List;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

.field final synthetic b:Landroid/support/v4/view/ViewPager;

.field final synthetic c:Lkd;


# direct methods
.method constructor <init>(Lkd;Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;Landroid/support/v4/view/ViewPager;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lkd$1;->c:Lkd;

    iput-object p2, p0, Lkd$1;->a:Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;

    iput-object p3, p0, Lkd$1;->b:Landroid/support/v4/view/ViewPager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 102
    if-nez p1, :cond_2

    .line 103
    iget-object v0, p0, Lkd$1;->b:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    .line 104
    iget-object v1, p0, Lkd$1;->b:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/PagerAdapter;->getCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x2

    .line 105
    if-nez v0, :cond_1

    .line 106
    iget-object v0, p0, Lkd$1;->b:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/view/ViewPager;->setCurrentItem(IZ)V

    .line 113
    :cond_0
    :goto_0
    return-void

    .line 107
    :cond_1
    if-le v0, v1, :cond_0

    .line 108
    iget-object v0, p0, Lkd$1;->b:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v3, v2}, Landroid/support/v4/view/ViewPager;->setCurrentItem(IZ)V

    goto :goto_0

    .line 110
    :cond_2
    if-ne p1, v3, :cond_0

    .line 111
    invoke-static {v2}, Lcom/bestbuy/android/bbyobjects/BBYLEPromoPager;->a(Z)Z

    goto :goto_0
.end method

.method public onPageScrolled(IFI)V
    .locals 0

    .prologue
    .line 99
    return-void
.end method

.method public onPageSelected(I)V
    .locals 0

    .prologue
    .line 96
    return-void
.end method
