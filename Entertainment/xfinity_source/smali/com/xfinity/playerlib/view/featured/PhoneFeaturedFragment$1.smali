.class Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$1;
.super Ljava/lang/Object;
.source "PhoneFeaturedFragment.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 0
    .param p1, "i"    # I

    .prologue
    .line 77
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0
    .param p1, "i"    # I
    .param p2, "v"    # F
    .param p3, "i2"    # I

    .prologue
    .line 63
    return-void
.end method

.method public onPageSelected(I)V
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 67
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->access$000(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)Landroid/widget/TabHost;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/TabHost;->setCurrentTab(I)V

    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->access$100(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->access$000(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)Landroid/widget/TabHost;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/TabHost;->getRootView()Landroid/view/View;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$id;->coverList:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->requestFocus()Z

    .line 72
    :cond_0
    return-void
.end method
