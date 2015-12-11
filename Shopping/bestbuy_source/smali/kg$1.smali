.class Lkg$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkg;-><init>(Lcom/bestbuy/android/bbyobjects/BBYPromoPager;Landroid/content/Context;Landroid/support/v4/view/ViewPager;Ljava/util/List;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

.field final synthetic b:Landroid/content/Context;

.field final synthetic c:Landroid/support/v4/view/ViewPager;

.field final synthetic d:Lkg;


# direct methods
.method constructor <init>(Lkg;Lcom/bestbuy/android/bbyobjects/BBYPromoPager;Landroid/content/Context;Landroid/support/v4/view/ViewPager;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lkg$1;->d:Lkg;

    iput-object p2, p0, Lkg$1;->a:Lcom/bestbuy/android/bbyobjects/BBYPromoPager;

    iput-object p3, p0, Lkg$1;->b:Landroid/content/Context;

    iput-object p4, p0, Lkg$1;->c:Landroid/support/v4/view/ViewPager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 109
    iget-object v0, p0, Lkg$1;->b:Landroid/content/Context;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_1

    .line 110
    if-nez p1, :cond_3

    .line 111
    iget-object v0, p0, Lkg$1;->c:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    .line 112
    iget-object v1, p0, Lkg$1;->c:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/PagerAdapter;->getCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x2

    .line 113
    if-nez v0, :cond_2

    .line 114
    iget-object v0, p0, Lkg$1;->c:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/view/ViewPager;->setCurrentItem(IZ)V

    .line 118
    :cond_0
    :goto_0
    iget-object v0, p0, Lkg$1;->b:Landroid/content/Context;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->reEnablePullDown()V

    .line 124
    :cond_1
    :goto_1
    return-void

    .line 115
    :cond_2
    if-le v0, v1, :cond_0

    .line 116
    iget-object v0, p0, Lkg$1;->c:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v3, v2}, Landroid/support/v4/view/ViewPager;->setCurrentItem(IZ)V

    goto :goto_0

    .line 119
    :cond_3
    if-ne p1, v3, :cond_1

    .line 120
    invoke-static {v2}, Lcom/bestbuy/android/bbyobjects/BBYPromoPager;->a(Z)Z

    .line 121
    iget-object v0, p0, Lkg$1;->b:Landroid/content/Context;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->disablePullDown()V

    goto :goto_1
.end method

.method public onPageScrolled(IFI)V
    .locals 0

    .prologue
    .line 106
    return-void
.end method

.method public onPageSelected(I)V
    .locals 0

    .prologue
    .line 103
    return-void
.end method
