.class Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$2;
.super Ljava/lang/Object;
.source "PhoneFeaturedFragment.java"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->prepareTabHost(Ljava/util/List;)V
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
    .line 102
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$2;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTabChanged(Ljava/lang/String;)V
    .locals 2
    .param p1, "tabId"    # Ljava/lang/String;

    .prologue
    .line 105
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$2;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->access$000(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)Landroid/widget/TabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/TabHost;->getCurrentTab()I

    move-result v0

    .line 106
    .local v0, "currentTab":I
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$2;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->viewPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->access$300(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 107
    return-void
.end method
