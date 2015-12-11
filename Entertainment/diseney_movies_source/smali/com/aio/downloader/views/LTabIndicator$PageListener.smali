.class Lcom/aio/downloader/views/LTabIndicator$PageListener;
.super Ljava/lang/Object;
.source "LTabIndicator.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/LTabIndicator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PageListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/LTabIndicator;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/views/LTabIndicator;)V
    .locals 0

    .prologue
    .line 341
    iput-object p1, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/views/LTabIndicator;Lcom/aio/downloader/views/LTabIndicator$PageListener;)V
    .locals 0

    .prologue
    .line 341
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/LTabIndicator$PageListener;-><init>(Lcom/aio/downloader/views/LTabIndicator;)V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 3
    .param p1, "state"    # I

    .prologue
    .line 362
    if-nez p1, :cond_0

    .line 363
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    # getter for: Lcom/aio/downloader/views/LTabIndicator;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v1}, Lcom/aio/downloader/views/LTabIndicator;->access$6(Lcom/aio/downloader/views/LTabIndicator;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    const/4 v2, 0x0

    # invokes: Lcom/aio/downloader/views/LTabIndicator;->scrollToChild(II)V
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/views/LTabIndicator;->access$5(Lcom/aio/downloader/views/LTabIndicator;II)V

    .line 366
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    iget-object v0, v0, Lcom/aio/downloader/views/LTabIndicator;->mOnPageChangeListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    if-eqz v0, :cond_1

    .line 367
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    iget-object v0, v0, Lcom/aio/downloader/views/LTabIndicator;->mOnPageChangeListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    invoke-interface {v0, p1}, Landroid/support/v4/view/ViewPager$OnPageChangeListener;->onPageScrollStateChanged(I)V

    .line 369
    :cond_1
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "positionOffsetPixels"    # I

    .prologue
    .line 346
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    invoke-static {v0, p1}, Lcom/aio/downloader/views/LTabIndicator;->access$2(Lcom/aio/downloader/views/LTabIndicator;I)V

    .line 347
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    invoke-static {v0, p2}, Lcom/aio/downloader/views/LTabIndicator;->access$3(Lcom/aio/downloader/views/LTabIndicator;F)V

    .line 349
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    # getter for: Lcom/aio/downloader/views/LTabIndicator;->mTabsContainer:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/views/LTabIndicator;->access$4(Lcom/aio/downloader/views/LTabIndicator;)Landroid/widget/LinearLayout;

    move-result-object v1

    .line 350
    invoke-virtual {v1, p1}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, p2

    float-to-int v1, v1

    .line 349
    # invokes: Lcom/aio/downloader/views/LTabIndicator;->scrollToChild(II)V
    invoke-static {v0, p1, v1}, Lcom/aio/downloader/views/LTabIndicator;->access$5(Lcom/aio/downloader/views/LTabIndicator;II)V

    .line 352
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    invoke-virtual {v0}, Lcom/aio/downloader/views/LTabIndicator;->invalidate()V

    .line 354
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    iget-object v0, v0, Lcom/aio/downloader/views/LTabIndicator;->mOnPageChangeListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    if-eqz v0, :cond_0

    .line 355
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    iget-object v0, v0, Lcom/aio/downloader/views/LTabIndicator;->mOnPageChangeListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    invoke-interface {v0, p1, p2, p3}, Landroid/support/v4/view/ViewPager$OnPageChangeListener;->onPageScrolled(IFI)V

    .line 358
    :cond_0
    return-void
.end method

.method public onPageSelected(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 373
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    # invokes: Lcom/aio/downloader/views/LTabIndicator;->tabSelect(I)V
    invoke-static {v0, p1}, Lcom/aio/downloader/views/LTabIndicator;->access$7(Lcom/aio/downloader/views/LTabIndicator;I)V

    .line 375
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    iget-object v0, v0, Lcom/aio/downloader/views/LTabIndicator;->mOnPageChangeListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    if-eqz v0, :cond_0

    .line 376
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$PageListener;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    iget-object v0, v0, Lcom/aio/downloader/views/LTabIndicator;->mOnPageChangeListener:Landroid/support/v4/view/ViewPager$OnPageChangeListener;

    invoke-interface {v0, p1}, Landroid/support/v4/view/ViewPager$OnPageChangeListener;->onPageSelected(I)V

    .line 378
    :cond_0
    return-void
.end method
