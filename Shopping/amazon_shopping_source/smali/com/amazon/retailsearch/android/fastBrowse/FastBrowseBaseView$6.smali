.class Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;
.super Ljava/lang/Object;
.source "FastBrowseBaseView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->onRefreshAfterInit()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V
    .locals 0

    .prologue
    .line 360
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x5

    .line 364
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$700(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->notifyDataSetChanged()V

    .line 365
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseList:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$1200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/widget/ListView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ListView;->setSelectionAfterHeaderView()V

    .line 366
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$1100(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->hide()V

    .line 367
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->browseUrl:Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$900(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    .line 369
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconRight:Landroid/view/View;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$1000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 370
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/support/v4/widget/DrawerLayout;->openDrawer(I)V

    .line 371
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    .line 376
    :goto_0
    return-void

    .line 374
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    goto :goto_0
.end method
