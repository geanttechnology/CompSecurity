.class Lcom/poshmark/ui/MainActivity$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/MainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/MainActivity;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/MainActivity;)V
    .locals 0

    .prologue
    .line 784
    iput-object p1, p0, Lcom/poshmark/ui/MainActivity$2;->this$0:Lcom/poshmark/ui/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTabSelected(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 2
    .param p1, "tab"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 788
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity$2;->this$0:Lcom/poshmark/ui/MainActivity;

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMTabButton;->launchFragment(Lcom/poshmark/ui/PMActivity;)V

    .line 789
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity$2;->this$0:Lcom/poshmark/ui/MainActivity;

    const/4 v1, 0x0

    # setter for: Lcom/poshmark/ui/MainActivity;->isBacktracking:Z
    invoke-static {v0, v1}, Lcom/poshmark/ui/MainActivity;->access$002(Lcom/poshmark/ui/MainActivity;Z)Z

    .line 790
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity$2;->this$0:Lcom/poshmark/ui/MainActivity;

    invoke-virtual {v0, p1}, Lcom/poshmark/ui/MainActivity;->removeVisitedTabFromStack(Lcom/poshmark/ui/customviews/PMTabButton;)V

    .line 791
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity$2;->this$0:Lcom/poshmark/ui/MainActivity;

    iput-object p1, v0, Lcom/poshmark/ui/MainActivity;->currentTab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 792
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMTabButton;->setSelected(Z)V

    .line 794
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity$2;->this$0:Lcom/poshmark/ui/MainActivity;

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMTabButton;->getFragment()Lcom/poshmark/ui/fragments/RootTabFragment;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/ui/MainActivity;->currentActiveRootFragment:Lcom/poshmark/ui/fragments/RootTabFragment;

    .line 795
    return-void
.end method

.method public onTabUnselected(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 1
    .param p1, "tab"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 799
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity$2;->this$0:Lcom/poshmark/ui/MainActivity;

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMTabButton;->hideFragment(Lcom/poshmark/ui/PMActivity;)V

    .line 800
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMTabButton;->setSelected(Z)V

    .line 802
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity$2;->this$0:Lcom/poshmark/ui/MainActivity;

    # getter for: Lcom/poshmark/ui/MainActivity;->isBacktracking:Z
    invoke-static {v0}, Lcom/poshmark/ui/MainActivity;->access$000(Lcom/poshmark/ui/MainActivity;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 803
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity$2;->this$0:Lcom/poshmark/ui/MainActivity;

    invoke-virtual {v0}, Lcom/poshmark/ui/MainActivity;->pushCurrentTabToStack()V

    .line 805
    :cond_0
    return-void
.end method
