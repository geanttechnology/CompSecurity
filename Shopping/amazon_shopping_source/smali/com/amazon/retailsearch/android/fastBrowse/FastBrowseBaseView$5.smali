.class Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;
.super Ljava/lang/Object;
.source "FastBrowseBaseView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->onRefresh()V
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
    .line 321
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    .prologue
    const/4 v11, 0x0

    const/4 v10, 0x5

    .line 325
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$300(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/SearchResult;->getRefinements()Lcom/amazon/searchapp/retailsearch/model/Refinements;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Department;->getCategories()Ljava/util/List;

    move-result-object v0

    .line 326
    .local v0, "categories":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 328
    .local v2, "refinement":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$400(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Ljava/util/ArrayList;

    move-result-object v3

    new-instance v4, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getUrl()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getBrowseUrl()Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->navMenuIcons:Landroid/content/res/TypedArray;
    invoke-static {v8}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$600(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/content/res/TypedArray;

    move-result-object v8

    const/4 v9, -0x1

    invoke-virtual {v8, v11, v9}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v8

    invoke-direct {v4, v5, v6, v7, v8}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 331
    .end local v2    # "refinement":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    :cond_0
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->navMenuIcons:Landroid/content/res/TypedArray;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$600(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/content/res/TypedArray;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/TypedArray;->recycle()V

    .line 332
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$700(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->notifyDataSetChanged()V

    .line 335
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$drawable;->drawer_shadow:I

    invoke-virtual {v3, v4, v10}, Landroid/support/v4/widget/DrawerLayout;->setDrawerShadow(II)V

    .line 336
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->setIconListner()V

    .line 338
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconRight:Landroid/view/View;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$1000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/view/View;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 339
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v3

    invoke-virtual {v3, v11, v10}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    .line 343
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$1100(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->hide()V

    .line 344
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v3

    invoke-virtual {v3, v10}, Landroid/support/v4/widget/DrawerLayout;->openDrawer(I)V

    .line 345
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v3

    const/4 v4, 0x2

    invoke-virtual {v3, v4, v10}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    .line 346
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 348
    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;->onCloseGno()V

    .line 350
    :cond_1
    return-void
.end method
