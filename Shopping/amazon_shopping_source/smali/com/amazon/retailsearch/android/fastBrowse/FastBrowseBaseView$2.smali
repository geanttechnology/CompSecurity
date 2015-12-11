.class Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;
.super Ljava/lang/Object;
.source "FastBrowseBaseView.java"

# interfaces
.implements Landroid/support/v4/widget/DrawerLayout$DrawerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->onCreateListView()V
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
    .line 160
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDrawerClosed(Landroid/view/View;)V
    .locals 1
    .param p1, "drawerView"    # Landroid/view/View;

    .prologue
    .line 164
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;->onUnblockGno()V

    .line 166
    :cond_0
    return-void
.end method

.method public onDrawerOpened(Landroid/view/View;)V
    .locals 1
    .param p1, "drawerView"    # Landroid/view/View;

    .prologue
    .line 172
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 173
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;->onBlockGno()V

    .line 175
    :cond_0
    return-void
.end method

.method public onDrawerSlide(Landroid/view/View;F)V
    .locals 2
    .param p1, "drawerView"    # Landroid/view/View;
    .param p2, "slideOffset"    # F

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconLeft:Landroid/view/View;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$100(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 181
    return-void
.end method

.method public onDrawerStateChanged(I)V
    .locals 2
    .param p1, "state"    # I

    .prologue
    .line 186
    if-nez p1, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->isDrawerVisible(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconLeft:Landroid/view/View;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$100(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 188
    :cond_0
    return-void
.end method
