.class public Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;
.super Ljava/util/TimerTask;
.source "FeaturedTimerTask.java"


# instance fields
.field gallery:Landroid/support/v4/view/ViewPager;

.field private handler:Landroid/os/Handler;

.field position:I


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 19
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask$1;-><init>(Lcom/xfinity/playerlib/view/featured/FeaturedTimerTask;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 40
    return-void
.end method
