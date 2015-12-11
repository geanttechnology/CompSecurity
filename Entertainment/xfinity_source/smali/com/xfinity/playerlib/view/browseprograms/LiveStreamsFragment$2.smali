.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$2;
.super Ljava/lang/Object;
.source "LiveStreamsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
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
    .line 143
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 146
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 147
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/support/v4/view/ViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 148
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 149
    sget v1, Lcom/xfinity/playerlib/view/DimmingPageTransformer;->MAX_ALPHA:F

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 152
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    return-void
.end method
