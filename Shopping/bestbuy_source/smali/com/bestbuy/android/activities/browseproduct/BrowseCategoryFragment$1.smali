.class Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    const v5, 0x7f0c0033

    const/4 v4, 0x1

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;->getHeader()Ljava/util/List;

    move-result-object v0

    add-int/lit8 v1, p3, -0x2

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/browse/Category;

    .line 128
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 130
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 131
    sget-object v2, Llu;->bo:Ljava/lang/String;

    const-string v3, "browse,deptCat"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    sget-object v2, Llu;->bp:Ljava/lang/String;

    const-string v3, "PRD"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->b(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 134
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "group"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 136
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getGroups()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getGroups()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_3

    .line 137
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->c(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Z

    move-result v2

    invoke-direct {v1, v0, v2}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;-><init>(Lcom/bestbuy/android/api/lib/models/browse/Category;Z)V

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v0, :cond_1

    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 175
    :cond_0
    :goto_0
    return-void

    .line 142
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0

    .line 144
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->d(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "BrowseSuperSubCategoryFragment"

    invoke-virtual {v0, v5, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_0

    .line 148
    :cond_3
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getSearchPath()Ljava/lang/String;

    move-result-object v1

    .line 149
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 151
    const-string v2, "query"

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 153
    const-string v2, "query="

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 154
    const-string v2, "="

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 155
    const-string v2, "="

    invoke-virtual {v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 156
    const/4 v2, 0x0

    aget-object v1, v1, v2

    .line 158
    :cond_4
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v1, v4, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V

    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_6

    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v0, :cond_5

    .line 161
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    move-object v0, v1

    .line 168
    :goto_1
    invoke-virtual {v0, v2, v4}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0

    .line 164
    :cond_5
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v1, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>(Z)V

    .line 165
    invoke-virtual {v2, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(Z)V

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->d(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v3, "PLPFragmentContainer"

    invoke-virtual {v0, v5, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    move-object v0, v1

    goto :goto_1

    .line 170
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->d(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "PLPFragment"

    invoke-virtual {v0, v5, v2, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto/16 :goto_0
.end method
