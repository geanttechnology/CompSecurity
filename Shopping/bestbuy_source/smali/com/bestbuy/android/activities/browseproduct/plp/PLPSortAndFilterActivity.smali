.class public Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lca;


# instance fields
.field private a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;"
        }
    .end annotation
.end field

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;"
        }
    .end annotation
.end field

.field private d:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private e:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;"
        }
    .end annotation
.end field

.field private f:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;"
        }
    .end annotation
.end field

.field private g:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

.field private h:I

.field private i:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private k:Ljava/lang/String;

.field private l:Lnb;

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 31
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 34
    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    .line 35
    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    .line 36
    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->d:Ljava/util/HashMap;

    .line 37
    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    .line 38
    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    .line 39
    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->g:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    .line 40
    const/4 v0, 0x0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->h:I

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->j:Ljava/util/ArrayList;

    return-void
.end method

.method private a()V
    .locals 4

    .prologue
    .line 183
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 184
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 184
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 187
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    .line 188
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 189
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 192
    :cond_2
    return-void
.end method

.method private a(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Value;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 240
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Value;

    .line 241
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 243
    :cond_0
    return-void
.end method

.method private b()V
    .locals 12

    .prologue
    const/4 v4, 0x0

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_7

    .line 196
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 197
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    .line 200
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 201
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getValues()Ljava/util/ArrayList;

    move-result-object v3

    .line 202
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 203
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_1
    move v3, v4

    .line 207
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v3, v0, :cond_7

    .line 208
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    .line 210
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v8, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 211
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getValues()Ljava/util/ArrayList;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->a(Ljava/util/ArrayList;)V

    .line 207
    :cond_2
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_1

    .line 213
    :cond_3
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v8, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    .line 214
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getValues()Ljava/util/ArrayList;

    move-result-object v9

    move v5, v4

    .line 215
    :goto_2
    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v5, v0, :cond_2

    .line 217
    invoke-virtual {v9, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Value;

    move v6, v4

    move v7, v4

    .line 218
    :goto_3
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v6, v2, :cond_5

    .line 219
    invoke-virtual {v1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/api/lib/models/solr/Value;

    .line 220
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_4

    .line 221
    invoke-virtual {v9, v5, v2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 222
    const/4 v7, 0x1

    .line 218
    :cond_4
    add-int/lit8 v2, v6, 0x1

    move v6, v2

    goto :goto_3

    .line 225
    :cond_5
    if-nez v7, :cond_6

    .line 227
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 215
    :cond_6
    add-int/lit8 v0, v5, 0x1

    move v5, v0

    goto :goto_2

    .line 237
    :cond_7
    return-void
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 144
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 145
    const-string v1, "SELECTED_FACETS"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 146
    const-string v1, "SORT_ORDER"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 147
    const/4 v1, -0x1

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->setResult(ILandroid/content/Intent;)V

    .line 148
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->finish()V

    .line 149
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->overridePendingTransition(II)V

    .line 150
    return-void
.end method

.method public a(Z)V
    .locals 2

    .prologue
    const v0, 0x7f0c02f6

    .line 175
    if-eqz p1, :cond_0

    .line 176
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 180
    :goto_0
    return-void

    .line 178
    :cond_0
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    const v5, 0x7f040008

    const v4, 0x7f040005

    const/4 v3, -0x1

    .line 128
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c02f5

    if-ne v0, v1, :cond_1

    .line 129
    const/4 v0, 0x0

    invoke-virtual {p0, v3, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->setResult(ILandroid/content/Intent;)V

    .line 130
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->finish()V

    .line 131
    invoke-virtual {p0, v4, v5}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->overridePendingTransition(II)V

    .line 140
    :cond_0
    :goto_0
    return-void

    .line 132
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c02f6

    if-ne v0, v1, :cond_0

    .line 133
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 134
    const-string v1, "CLEAR_ALL"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 135
    const-string v1, "SORT_ORDER"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->i:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 136
    invoke-virtual {p0, v3, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->setResult(ILandroid/content/Intent;)V

    .line 137
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->finish()V

    .line 138
    invoke-virtual {p0, v4, v5}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 11

    .prologue
    const/4 v1, -0x1

    const v3, 0x7f0c02f6

    .line 50
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 51
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 52
    const v0, 0x7f0300b9

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->setContentView(I)V

    .line 53
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setLayout(II)V

    .line 54
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 55
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->l:Lnb;

    .line 56
    const-string v0, "isSearch"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 57
    const-string v0, "SOLR_RESPONSE"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 58
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "SOLR_RESPONSE"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    .line 59
    if-eqz v0, :cond_1

    .line 60
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getFacets()Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    .line 61
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getSortOptions()Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    .line 62
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 63
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->getRequestedFacets()Ljava/util/HashMap;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->d:Ljava/util/HashMap;

    .line 64
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->getSortOption()Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->g:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    .line 66
    :cond_0
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getTotalCount()I

    move-result v2

    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->h:I

    .line 67
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->getQueryString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->k:Ljava/lang/String;

    .line 68
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->l:Lnb;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getCategoryMap()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v2, v0}, Lnb;->a(Ljava/util/HashMap;)V

    .line 71
    :cond_1
    const-string v0, "SELECTED_CATEGORY"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 72
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->m:Ljava/lang/String;

    .line 74
    :cond_2
    const-string v0, "BASE_FACETS"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "BASE_FACETS"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 75
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "BASE_FACETS"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    .line 77
    :cond_3
    const-string v0, "BASE_SORT_OPTIONS"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "BASE_SORT_OPTIONS"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 78
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "BASE_SORT_OPTIONS"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    .line 80
    :cond_4
    const-string v0, "IS_OUTLET_ITEMS"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 81
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "IS_OUTLET_ITEMS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->n:Ljava/lang/String;

    .line 83
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    if-nez v0, :cond_6

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    .line 86
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    if-nez v0, :cond_7

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    .line 90
    :cond_7
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->b()V

    .line 91
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->a()V

    .line 92
    const v0, 0x7f0c02f4

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 93
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "<span class=\'bold\'>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->h:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " </span>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "Results"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 95
    :try_start_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v2, 0x12c

    invoke-static {p0, v1, v0, v2}, Llt;->a(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->g:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->g:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getValue()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Best-Selling"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->d:Ljava/util/HashMap;

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->d:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_a

    .line 101
    :cond_9
    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 105
    :goto_1
    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 106
    const v0, 0x7f0c02f5

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->d:Ljava/util/HashMap;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->g:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->k:Ljava/lang/String;

    iget-object v8, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->j:Ljava/util/ArrayList;

    iget-object v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->m:Ljava/lang/String;

    iget-object v10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->n:Ljava/lang/String;

    invoke-direct/range {v0 .. v10}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;-><init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/HashMap;Lcom/bestbuy/android/api/lib/models/solr/SortOption;Ljava/util/List;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->i:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    .line 108
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 109
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 110
    const v1, 0x7f0c02f7

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->i:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    const-string v3, "PLPNarrowResultsFilterFragment"

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 111
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 112
    return-void

    .line 96
    :catch_0
    move-exception v0

    .line 97
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 103
    :cond_a
    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 122
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 123
    invoke-static {}, Llu;->a()V

    .line 124
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 116
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 117
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 118
    return-void
.end method
