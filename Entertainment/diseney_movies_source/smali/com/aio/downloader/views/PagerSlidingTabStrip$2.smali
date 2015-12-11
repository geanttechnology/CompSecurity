.class Lcom/aio/downloader/views/PagerSlidingTabStrip$2;
.super Ljava/lang/Object;
.source "PagerSlidingTabStrip.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/views/PagerSlidingTabStrip;->addTab(ILjava/lang/CharSequence;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iput p2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->val$position:I

    .line 307
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 310
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->val$position:I

    if-eq v1, v2, :cond_1

    .line 311
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$0(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/widget/LinearLayout;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v2}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v2

    .line 312
    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v2

    .line 311
    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 313
    .local v0, "tab":Landroid/view/View;
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # invokes: Lcom/aio/downloader/views/PagerSlidingTabStrip;->unSelect(Landroid/view/View;)V
    invoke-static {v1, v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$16(Lcom/aio/downloader/views/PagerSlidingTabStrip;Landroid/view/View;)V

    .line 314
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->val$position:I

    invoke-virtual {v1, v2}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 318
    .end local v0    # "tab":Landroid/view/View;
    :cond_0
    :goto_0
    return-void

    .line 315
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabReselectedListener:Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;
    invoke-static {v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$17(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 316
    iget-object v1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabReselectedListener:Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;
    invoke-static {v1}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$17(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$2;->val$position:I

    invoke-interface {v1, v2}, Lcom/aio/downloader/views/PagerSlidingTabStrip$OnTabReselectedListener;->onTabReselected(I)V

    goto :goto_0
.end method
