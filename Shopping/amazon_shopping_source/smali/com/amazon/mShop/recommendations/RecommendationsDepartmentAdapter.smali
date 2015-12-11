.class public Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;
.super Landroid/widget/BaseAdapter;
.source "RecommendationsDepartmentAdapter.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Landroid/widget/ListAdapter;


# instance fields
.field private mCurrentPosition:I

.field private final mDefaultCategory:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

.field private mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

.field private mList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;",
            ">;"
        }
    .end annotation
.end field

.field private final mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V
    .locals 3
    .param p1, "resultsView"    # Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .prologue
    .line 33
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .line 35
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mDefaultCategory:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mDefaultCategory:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {p1}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->search_all_departments:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->setDisplayName(Ljava/lang/String;)V

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mList:Ljava/util/List;

    .line 38
    return-void
.end method


# virtual methods
.method public bindAmazonAlertDialog(Lcom/amazon/mShop/AmazonAlertDialog;)V
    .locals 0
    .param p1, "dialog"    # Lcom/amazon/mShop/AmazonAlertDialog;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    .line 119
    return-void
.end method

.method public clear()V
    .locals 2

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 51
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mList:Ljava/util/List;

    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mDefaultCategory:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 52
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mList:Ljava/util/List;

    if-nez v0, :cond_0

    .line 57
    const/4 v0, 0x0

    .line 58
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method public getItem(I)Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    return-object v0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 25
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->getItem(I)Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 89
    int-to-long v0, p1

    return-wide v0
.end method

.method public getSelectedPosition()I
    .locals 1

    .prologue
    .line 122
    iget v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mCurrentPosition:I

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v7, 0x0

    .line 64
    if-nez p2, :cond_0

    .line 65
    iget-object v5, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    invoke-virtual {v5}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 66
    .local v2, "layoutInflater":Landroid/view/LayoutInflater;
    sget v5, Lcom/amazon/mShop/android/lib/R$layout;->search_refine_item:I

    const/4 v6, 0x0

    invoke-virtual {v2, v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 70
    .end local v2    # "layoutInflater":Landroid/view/LayoutInflater;
    .local v1, "itemView":Landroid/view/View;
    :goto_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->getItem(I)Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    move-result-object v3

    .line 71
    .local v3, "result":Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->item_name:I

    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 72
    .local v4, "title":Landroid/widget/TextView;
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->getDisplayName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 73
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->check_mark:I

    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 74
    .local v0, "checkmark":Landroid/widget/ImageView;
    iget v5, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mCurrentPosition:I

    if-ne p1, v5, :cond_1

    .line 75
    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 79
    :goto_1
    return-object v1

    .line 68
    .end local v0    # "checkmark":Landroid/widget/ImageView;
    .end local v1    # "itemView":Landroid/view/View;
    .end local v3    # "result":Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    .end local v4    # "title":Landroid/widget/TextView;
    :cond_0
    move-object v1, p2

    .restart local v1    # "itemView":Landroid/view/View;
    goto :goto_0

    .line 77
    .restart local v0    # "checkmark":Landroid/widget/ImageView;
    .restart local v3    # "result":Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    .restart local v4    # "title":Landroid/widget/TextView;
    :cond_1
    const/4 v5, 0x4

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
    .param p2, "itemView"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "viewId"    # J
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
    .line 95
    .local p1, "parentView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mCurrentPosition:I

    if-eq v3, p3, :cond_3

    .line 96
    iput p3, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mCurrentPosition:I

    .line 97
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    invoke-virtual {v3}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->getBrowser()Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    move-result-object v0

    .line 98
    .local v0, "browser":Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;
    invoke-virtual {p0, p3}, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->getItem(I)Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    move-result-object v1

    .line 99
    .local v1, "result":Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    if-nez v1, :cond_1

    .line 115
    .end local v0    # "browser":Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;
    .end local v1    # "result":Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    :cond_0
    :goto_0
    return-void

    .line 101
    .restart local v0    # "browser":Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;
    .restart local v1    # "result":Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mDefaultCategory:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    if-ne v3, v1, :cond_2

    invoke-virtual {v0}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->hasCategoryResult()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 102
    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "_"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 104
    .local v2, "userKey":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->sendRecsRatingsForUser(Ljava/lang/String;)V

    .line 105
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    invoke-virtual {v3, v1}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->refine(Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;)V

    .line 108
    const-string/jumbo v3, "recs_dept"

    invoke-static {v3}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 112
    .end local v0    # "browser":Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;
    .end local v1    # "result":Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    .end local v2    # "userKey":Ljava/lang/String;
    :cond_3
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    if-eqz v3, :cond_0

    .line 113
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    goto :goto_0
.end method

.method public update(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 41
    .local p1, "refinements":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->clear()V

    .line 42
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 43
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    .line 44
    .local v1, "result":Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    iget-object v2, p0, Lcom/amazon/mShop/recommendations/RecommendationsDepartmentAdapter;->mList:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 47
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "result":Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;
    :cond_0
    return-void
.end method
