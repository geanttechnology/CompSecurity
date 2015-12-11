.class Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;
.super Ljava/lang/Object;
.source "SlideMenuClickListener.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 195
    return-void
.end method

.method public onResult(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 12
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    const/4 v11, -0x1

    const/4 v10, 0x0

    .line 147
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SearchResult;->getRefinements()Lcom/amazon/searchapp/retailsearch/model/Refinements;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SearchResult;->getRefinements()Lcom/amazon/searchapp/retailsearch/model/Refinements;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v4

    if-nez v4, :cond_1

    .line 150
    :cond_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->navMenuIcons:Landroid/content/res/TypedArray;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/content/res/TypedArray;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/TypedArray;->recycle()V

    .line 151
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->onRefresh()V

    .line 190
    :goto_0
    return-void

    .line 155
    :cond_1
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # setter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    invoke-static {v4, p1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$102(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;Lcom/amazon/searchapp/retailsearch/model/SearchResult;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .line 156
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$100(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SearchResult;->getRefinements()Lcom/amazon/searchapp/retailsearch/model/Refinements;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Department;->getCategories()Ljava/util/List;

    move-result-object v1

    .line 157
    .local v1, "categories":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$100(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SearchResult;->getRefinements()Lcom/amazon/searchapp/retailsearch/model/Refinements;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v0

    .line 160
    .local v0, "ancestry":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseItems:Ljava/util/ArrayList;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    .line 162
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseItems:Ljava/util/ArrayList;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/util/ArrayList;

    move-result-object v4

    new-instance v5, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    iget-object v6, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v6, v6, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->allDepartments:Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$300(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v7, "/s/browse/categories"

    const-string/jumbo v8, "/s/browse/categories"

    iget-object v9, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v9, v9, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->navMenuIcons:Landroid/content/res/TypedArray;
    invoke-static {v9}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/content/res/TypedArray;

    move-result-object v9

    invoke-virtual {v9, v10, v11}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v9

    invoke-direct {v5, v6, v7, v8, v9}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 165
    if-eqz v0, :cond_2

    .line 167
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 169
    .local v3, "refinement":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseItems:Ljava/util/ArrayList;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/util/ArrayList;

    move-result-object v4

    new-instance v5, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getUrl()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getBrowseUrl()Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v9, v9, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->navMenuIcons:Landroid/content/res/TypedArray;
    invoke-static {v9}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/content/res/TypedArray;

    move-result-object v9

    invoke-virtual {v9, v10, v11}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v9

    invoke-direct {v5, v6, v7, v8, v9}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 175
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "refinement":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    :cond_2
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$400(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v5, v5, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseItems:Ljava/util/ArrayList;
    invoke-static {v5}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->setCurrentLayer(I)V

    .line 176
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$400(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->getCurrentLayer()I

    move-result v4

    if-nez v4, :cond_3

    .line 178
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseItems:Ljava/util/ArrayList;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v5, v5, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->shopByDepartments:Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$500(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->setTitle(Ljava/lang/String;)V

    .line 180
    :cond_3
    if-eqz v1, :cond_4

    .line 182
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 184
    .restart local v3    # "refinement":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseItems:Ljava/util/ArrayList;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$200(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/util/ArrayList;

    move-result-object v4

    new-instance v5, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getUrl()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getBrowseUrl()Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v9, v9, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->navMenuIcons:Landroid/content/res/TypedArray;
    invoke-static {v9}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/content/res/TypedArray;

    move-result-object v9

    invoke-virtual {v9, v10, v11}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v9

    invoke-direct {v5, v6, v7, v8, v9}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 188
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "refinement":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    :cond_4
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->navMenuIcons:Landroid/content/res/TypedArray;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$000(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/content/res/TypedArray;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/TypedArray;->recycle()V

    .line 189
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->onRefresh()V

    goto/16 :goto_0
.end method
