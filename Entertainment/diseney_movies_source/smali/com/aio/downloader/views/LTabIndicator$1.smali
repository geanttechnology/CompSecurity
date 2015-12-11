.class Lcom/aio/downloader/views/LTabIndicator$1;
.super Ljava/lang/Object;
.source "LTabIndicator.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/views/LTabIndicator;->addTab(ILjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/LTabIndicator;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/LTabIndicator;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/LTabIndicator$1;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    iput p2, p0, Lcom/aio/downloader/views/LTabIndicator$1;->val$position:I

    .line 233
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 236
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$1;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    # getter for: Lcom/aio/downloader/views/LTabIndicator;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v1}, Lcom/aio/downloader/views/LTabIndicator;->access$6(Lcom/aio/downloader/views/LTabIndicator;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    .line 237
    .local v0, "oldSelected":I
    iget v1, p0, Lcom/aio/downloader/views/LTabIndicator$1;->val$position:I

    if-eq v0, v1, :cond_0

    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$1;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    # getter for: Lcom/aio/downloader/views/LTabIndicator;->mTabSelectedListener:Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;
    invoke-static {v1}, Lcom/aio/downloader/views/LTabIndicator;->access$8(Lcom/aio/downloader/views/LTabIndicator;)Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 238
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$1;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    # getter for: Lcom/aio/downloader/views/LTabIndicator;->mTabSelectedListener:Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;
    invoke-static {v1}, Lcom/aio/downloader/views/LTabIndicator;->access$8(Lcom/aio/downloader/views/LTabIndicator;)Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/views/LTabIndicator$1;->val$position:I

    invoke-interface {v1, v2}, Lcom/aio/downloader/views/LTabIndicator$OnTabSelectedListener;->onTabSelected(I)V

    .line 241
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$1;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    # getter for: Lcom/aio/downloader/views/LTabIndicator;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v1}, Lcom/aio/downloader/views/LTabIndicator;->access$6(Lcom/aio/downloader/views/LTabIndicator;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/views/LTabIndicator$1;->val$position:I

    iget-object v3, p0, Lcom/aio/downloader/views/LTabIndicator$1;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    # getter for: Lcom/aio/downloader/views/LTabIndicator;->viewPagerScrollWithAnimation:Z
    invoke-static {v3}, Lcom/aio/downloader/views/LTabIndicator;->access$9(Lcom/aio/downloader/views/LTabIndicator;)Z

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/view/ViewPager;->setCurrentItem(IZ)V

    .line 242
    return-void
.end method
