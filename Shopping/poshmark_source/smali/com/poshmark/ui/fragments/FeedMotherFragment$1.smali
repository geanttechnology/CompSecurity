.class Lcom/poshmark/ui/fragments/FeedMotherFragment$1;
.super Landroid/support/v4/view/ViewPager$SimpleOnPageChangeListener;
.source "FeedMotherFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FeedMotherFragment;->setupViewPager()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FeedMotherFragment;)V
    .locals 0

    .prologue
    .line 136
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$1;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    invoke-direct {p0}, Landroid/support/v4/view/ViewPager$SimpleOnPageChangeListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageSelected(I)V
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 141
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$1;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # getter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$000(Lcom/poshmark/ui/fragments/FeedMotherFragment;)Landroid/widget/TabHost;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/TabHost;->getCurrentTab()I

    move-result v0

    .line 142
    .local v0, "currentTab":I
    if-eq v0, p1, :cond_0

    .line 143
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$1;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # getter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$000(Lcom/poshmark/ui/fragments/FeedMotherFragment;)Landroid/widget/TabHost;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/widget/TabHost;->setCurrentTab(I)V

    .line 144
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$1;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # setter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I
    invoke-static {v1, p1}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$102(Lcom/poshmark/ui/fragments/FeedMotherFragment;I)I

    .line 146
    :cond_0
    return-void
.end method
