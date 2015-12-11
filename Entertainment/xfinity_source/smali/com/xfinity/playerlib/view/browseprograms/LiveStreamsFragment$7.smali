.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$7;
.super Ljava/lang/Object;
.source "LiveStreamsFragment.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->displayLiveFeaturedContent()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

.field final synthetic val$viewTreeObserver:Landroid/view/ViewTreeObserver;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Landroid/view/ViewTreeObserver;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 543
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$7;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$7;->val$viewTreeObserver:Landroid/view/ViewTreeObserver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 2

    .prologue
    .line 548
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$7;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getMeasuredWidth()I

    move-result v0

    if-lez v0, :cond_0

    .line 549
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$7;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # invokes: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->transformCarouselItems()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1900(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    .line 552
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$7;->val$viewTreeObserver:Landroid/view/ViewTreeObserver;

    invoke-virtual {v0}, Landroid/view/ViewTreeObserver;->isAlive()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 553
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_1

    .line 554
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$7;->val$viewTreeObserver:Landroid/view/ViewTreeObserver;

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 561
    :cond_0
    :goto_0
    return-void

    .line 557
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$7;->val$viewTreeObserver:Landroid/view/ViewTreeObserver;

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_0
.end method
