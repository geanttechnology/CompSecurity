.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$5;
.super Ljava/lang/Object;
.source "LiveStreamsFragment.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->initFeaturedCarousel()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 422
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 1
    .param p1, "state"    # I

    .prologue
    .line 436
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$200(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/view/PagerContainer;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/PagerContainer;->onPageScrollStateChanged(I)V

    .line 437
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 1
    .param p1, "i"    # I
    .param p2, "v"    # F
    .param p3, "i2"    # I

    .prologue
    .line 425
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$200(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/view/PagerContainer;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/xfinity/playerlib/view/PagerContainer;->onPageScrolled(IFI)V

    .line 426
    return-void
.end method

.method public onPageSelected(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 430
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$200(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/view/PagerContainer;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/PagerContainer;->onPageSelected(I)V

    .line 431
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # setter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselIndex:I
    invoke-static {v0, p1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$802(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;I)I

    .line 432
    return-void
.end method
