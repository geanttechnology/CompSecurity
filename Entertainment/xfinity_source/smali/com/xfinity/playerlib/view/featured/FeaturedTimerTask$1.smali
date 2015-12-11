.class Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;
.super Ljava/lang/Object;
.source "FeaturedTimerTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 22
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget v1, v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->position:I

    if-gez v1, :cond_0

    .line 23
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->gallery:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    iput v2, v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->position:I

    .line 26
    :cond_0
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget v1, v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->position:I

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->gallery:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/view/PagerAdapter;->getCount()I

    move-result v2

    if-lt v1, v2, :cond_1

    .line 27
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->gallery:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/view/PagerAdapter;->getCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    iput v2, v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->position:I

    .line 29
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget v1, v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->position:I

    if-eqz v1, :cond_2

    const/4 v0, 0x1

    .line 30
    .local v0, "smoothScroll":Z
    :cond_2
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->gallery:Landroid/support/v4/view/ViewPager;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget v2, v2, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->position:I

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/view/ViewPager;->setCurrentItem(IZ)V

    .line 31
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget v2, v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->position:I

    add-int/lit8 v2, v2, 0x1

    iput v2, v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->position:I

    .line 32
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget v1, v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->position:I

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->gallery:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/view/PagerAdapter;->getCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-le v1, v2, :cond_3

    .line 33
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;

    const/4 v2, 0x0

    iput v2, v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->position:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 38
    .end local v0    # "smoothScroll":Z
    :cond_3
    :goto_0
    return-void

    .line 36
    :catch_0
    move-exception v1

    goto :goto_0
.end method
