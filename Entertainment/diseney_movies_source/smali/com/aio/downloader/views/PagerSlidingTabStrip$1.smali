.class Lcom/aio/downloader/views/PagerSlidingTabStrip$1;
.super Ljava/lang/Object;
.source "PagerSlidingTabStrip.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/PagerSlidingTabStrip;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/PagerSlidingTabStrip;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    .line 427
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private removeGlobalLayoutListenerJB()V
    .locals 1
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 461
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 462
    return-void
.end method

.method private removeGlobalLayoutListenerPreJB()V
    .locals 1

    .prologue
    .line 456
    iget-object v0, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {v0}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 457
    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 431
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mTabsContainer:Landroid/widget/LinearLayout;
    invoke-static {v2}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$0(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/widget/LinearLayout;

    move-result-object v2

    invoke-virtual {v2, v7}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 432
    .local v1, "view":Landroid/view/View;
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x10

    if-ge v2, v3, :cond_2

    .line 433
    invoke-direct {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->removeGlobalLayoutListenerPreJB()V

    .line 438
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->isPaddingMiddle:Z
    invoke-static {v2}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$1(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 439
    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v2

    div-int/lit8 v0, v2, 0x2

    .line 440
    .local v0, "mHalfWidthFirstTab":I
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v4, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {v4}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getWidth()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    .line 441
    sub-int/2addr v4, v0

    .line 440
    invoke-static {v3, v4}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$2(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V

    invoke-static {v2, v4}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$3(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V

    .line 444
    .end local v0    # "mHalfWidthFirstTab":I
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I
    invoke-static {v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$4(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I

    move-result v3

    iget-object v4, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {v4}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getPaddingTop()I

    move-result v4

    iget-object v5, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingRight:I
    invoke-static {v5}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$5(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I

    move-result v5

    .line 445
    iget-object v6, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {v6}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getPaddingBottom()I

    move-result v6

    .line 444
    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->setPadding(IIII)V

    .line 446
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mScrollOffset:I
    invoke-static {v2}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$6(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I

    move-result v2

    if-nez v2, :cond_1

    .line 447
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    invoke-virtual {v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    iget-object v4, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPaddingLeft:I
    invoke-static {v4}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$4(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I

    move-result v4

    sub-int/2addr v3, v4

    invoke-static {v2, v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$7(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V

    .line 448
    :cond_1
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$8(Lcom/aio/downloader/views/PagerSlidingTabStrip;)Landroid/support/v4/view/ViewPager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v3

    invoke-static {v2, v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$9(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V

    .line 449
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$10(Lcom/aio/downloader/views/PagerSlidingTabStrip;F)V

    .line 450
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I
    invoke-static {v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$11(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I

    move-result v3

    # invokes: Lcom/aio/downloader/views/PagerSlidingTabStrip;->scrollToChild(II)V
    invoke-static {v2, v3, v7}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$12(Lcom/aio/downloader/views/PagerSlidingTabStrip;II)V

    .line 451
    iget-object v2, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    iget-object v3, p0, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->this$0:Lcom/aio/downloader/views/PagerSlidingTabStrip;

    # getter for: Lcom/aio/downloader/views/PagerSlidingTabStrip;->mCurrentPosition:I
    invoke-static {v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$11(Lcom/aio/downloader/views/PagerSlidingTabStrip;)I

    move-result v3

    # invokes: Lcom/aio/downloader/views/PagerSlidingTabStrip;->updateSelection(I)V
    invoke-static {v2, v3}, Lcom/aio/downloader/views/PagerSlidingTabStrip;->access$13(Lcom/aio/downloader/views/PagerSlidingTabStrip;I)V

    .line 452
    return-void

    .line 435
    :cond_2
    invoke-direct {p0}, Lcom/aio/downloader/views/PagerSlidingTabStrip$1;->removeGlobalLayoutListenerJB()V

    goto/16 :goto_0
.end method
