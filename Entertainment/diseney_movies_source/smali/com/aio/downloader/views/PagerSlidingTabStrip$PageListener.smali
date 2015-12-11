.class Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;
.super Ljava/lang/Object;
.source "PagerSlidingTabStrip.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/PagerSlidingTabStrip;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PageListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;)V
    .locals 0

    .prologue
    .line 511
    iput-object p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;)V
    .locals 0

    .prologue
    .line 511
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;-><init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;)V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 6
    .param p1, "state"    # I

    .prologue
    .line 530
    if-nez p1, :cond_0

    .line 531
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v4, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v4}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v4

    const/4 v5, 0x0

    # invokes: Lcom/aio/downloader/views/PagerSlidingTabStrip;->scrollToChild(II)V
    invoke-static {v3, v4, v5}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$12(Lcom/aio/downloader/views/PagerSlidingTabStrip;II)V

    .line 534
    :cond_0
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;
    invoke-static {v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$0(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/widget/LinearLayout;

    move-result-object v3

    .line 535
    iget-object v4, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v4}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 536
    .local v0, "currentTab":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # invokes: Lcom/aio/downloader/views/PagerSlidingTabStrip;->select(Landroid/view/View;)V
    invoke-static {v3, v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$15(Lcom/aio/downloader/views/PagerSlidingTabStrip;Landroid/view/View;)V

    .line 538
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-ltz v3, :cond_1

    .line 539
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;
    invoke-static {v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$0(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/widget/LinearLayout;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v4}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v4

    .line 540
    invoke-virtual {v4}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    .line 539
    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 541
    .local v2, "prevTab":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # invokes: Lcom/aio/downloader/views/PagerSlidingTabStrip;->unSelect(Landroid/view/View;)V
    invoke-static {v3, v2}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$16(Lcom/aio/downloader/views/PagerSlidingTabStrip;Landroid/view/View;)V

    .line 545
    .end local v2    # "prevTab":Landroid/view/View;
    :cond_1
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    iget-object v4, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v4}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/view/PagerAdapter;->getCount()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-gt v3, v4, :cond_2

    .line 546
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;
    invoke-static {v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$0(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/widget/LinearLayout;

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v4}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v4

    .line 547
    invoke-virtual {v4}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    .line 546
    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 548
    .local v1, "nextTab":Landroid/view/View;
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # invokes: Lcom/aio/downloader/views/PagerSlidingTabStrip;->unSelect(Landroid/view/View;)V
    invoke-static {v3, v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$16(Lcom/aio/downloader/views/PagerSlidingTabStrip;Landroid/view/View;)V

    .line 551
    .end local v1    # "nextTab":Landroid/view/View;
    :cond_2
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v3, v3, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDelegatePageListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    if-eqz v3, :cond_3

    .line 552
    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v3, v3, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDelegatePageListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    invoke-interface {v3, p1}, Landroid/support/v4/view/ViewPager$OnPageChangeListener;->onPageScrollStateChanged(I)V

    .line 554
    :cond_3
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "positionOffsetPixels"    # I

    .prologue
    .line 516
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-static {v1, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$9(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V

    .line 517
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-static {v1, p2}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$10(Lcom/aio/downloader/views/PagerSlidingTabStrip;F)V

    .line 518
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabCount:I
    invoke-static {v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$14(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I

    move-result v1

    if-lez v1, :cond_1

    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$0(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/widget/LinearLayout;

    move-result-object v1

    .line 519
    invoke-virtual {v1, p1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, p2

    float-to-int v0, v1

    .line 520
    .local v0, "offset":I
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # invokes: Lcom/aio/downloader/views/PagerSlidingTabStrip;->scrollToChild(II)V
    invoke-static {v1, p1, v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$12(Lcom/aio/downloader/views/PagerSlidingTabStrip;II)V

    .line 521
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->invalidate()V

    .line 522
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v1, v1, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDelegatePageListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    if-eqz v1, :cond_0

    .line 523
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v1, v1, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDelegatePageListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    invoke-interface {v1, p1, p2, p3}, Landroid/support/v4/view/ViewPager$OnPageChangeListener;->onPageScrolled(IFI)V

    .line 526
    :cond_0
    return-void

    .line 519
    .end local v0    # "offset":I
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onPageSelected(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 558
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # invokes: Lcom/aio/downloader/views/PagerSlidingTabStrip;->updateSelection(I)V
    invoke-static {v0, p1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$13(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V

    .line 559
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v0, v0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDelegatePageListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    if-eqz v0, :cond_0

    .line 560
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$PageListener;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v0, v0, Lcom/aio/downloader/views/PagerSlidingTabStrip;->mDelegatePageListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    invoke-interface {v0, p1}, Landroid/support/v4/view/ViewPager$OnPageChangeListener;->onPageSelected(I)V

    .line 562
    :cond_0
    return-void
.end method
