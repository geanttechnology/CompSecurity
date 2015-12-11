.class public Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Ldm;


# instance fields
.field private a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;"
        }
    .end annotation
.end field

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/SortOptions;",
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
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;"
        }
    .end annotation
.end field

.field private f:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/SortOptions;",
            ">;"
        }
    .end annotation
.end field

.field private g:I

.field private h:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

.field private i:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private j:Ljava/lang/String;

.field private k:Lnb;

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Lcom/bestbuy/android/api/lib/models/search/Sort;

.field private o:Ljava/lang/String;

.field private p:Z

.field private q:Z

.field private r:Ljava/lang/String;

.field private s:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 34
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 37
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    .line 38
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    .line 39
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->d:Ljava/util/HashMap;

    .line 40
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    .line 41
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    .line 42
    const/4 v0, 0x0

    iput v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->g:I

    .line 44
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->i:Ljava/util/ArrayList;

    .line 49
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->n:Lcom/bestbuy/android/api/lib/models/search/Sort;

    .line 52
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->r:Ljava/lang/String;

    .line 53
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->s:Ljava/util/ArrayList;

    return-void
.end method

.method private a()V
    .locals 4

    .prologue
    .line 193
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    .line 195
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/SortOptions;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SortOptions;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 195
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 198
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/SortOptions;

    .line 200
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SortOptions;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 201
    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 206
    :cond_2
    return-void
.end method

.method private b()V
    .locals 12

    .prologue
    const/4 v4, 0x0

    .line 209
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_7

    .line 210
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 211
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    .line 214
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 215
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getValues()Ljava/util/ArrayList;

    move-result-object v3

    .line 216
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 217
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_1
    move v3, v4

    .line 221
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v3, v0, :cond_7

    .line 222
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    .line 224
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v8, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 225
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getValues()Ljava/util/ArrayList;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b(Ljava/util/ArrayList;)V

    .line 221
    :cond_2
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_1

    .line 227
    :cond_3
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v8, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    .line 228
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getValues()Ljava/util/ArrayList;

    move-result-object v9

    move v5, v4

    .line 229
    :goto_2
    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v5, v0, :cond_2

    .line 231
    invoke-virtual {v9, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    move v6, v4

    move v7, v4

    .line 232
    :goto_3
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v6, v2, :cond_5

    .line 233
    invoke-virtual {v1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    .line 234
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_4

    .line 235
    invoke-virtual {v9, v5, v2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 236
    const/4 v7, 0x1

    .line 232
    :cond_4
    add-int/lit8 v2, v6, 0x1

    move v6, v2

    goto :goto_3

    .line 239
    :cond_5
    if-nez v7, :cond_6

    .line 241
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->i:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 229
    :cond_6
    add-int/lit8 v0, v5, 0x1

    move v5, v0

    goto :goto_2

    .line 251
    :cond_7
    return-void
.end method

.method private b(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/FacetValues;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 254
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    .line 255
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->i:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 257
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 260
    iput-object p1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->r:Ljava/lang/String;

    .line 261
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 264
    iput-object p1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->s:Ljava/util/ArrayList;

    .line 265
    return-void
.end method

.method public a(Ljava/util/ArrayList;Ljava/lang/String;)V
    .locals 3
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
    .line 152
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 153
    const-string v1, "SELECTED_FACETS"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 154
    const-string v1, "SORT_ORDER"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 155
    const-string v1, "Selected_Facets_For_Analytics"

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->s:Ljava/util/ArrayList;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putStringArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 156
    const-string v1, "Latest_Facet_Selected"

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->r:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 157
    const/4 v1, -0x1

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->setResult(ILandroid/content/Intent;)V

    .line 158
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->finish()V

    .line 159
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->overridePendingTransition(II)V

    .line 160
    return-void
.end method

.method public a(Z)V
    .locals 2

    .prologue
    const v0, 0x7f0c02f6

    .line 185
    if-eqz p1, :cond_0

    .line 186
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 190
    :goto_0
    return-void

    .line 188
    :cond_0
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

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

    .line 136
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c02f5

    if-ne v0, v1, :cond_1

    .line 137
    const/4 v0, 0x0

    invoke-virtual {p0, v3, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->setResult(ILandroid/content/Intent;)V

    .line 138
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->finish()V

    .line 139
    invoke-virtual {p0, v4, v5}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->overridePendingTransition(II)V

    .line 148
    :cond_0
    :goto_0
    return-void

    .line 140
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c02f6

    if-ne v0, v1, :cond_0

    .line 141
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 142
    const-string v1, "CLEAR_ALL"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 143
    const-string v1, "SORT_ORDER"

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->h:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 144
    invoke-virtual {p0, v3, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->setResult(ILandroid/content/Intent;)V

    .line 145
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->finish()V

    .line 146
    invoke-virtual {p0, v4, v5}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 11

    .prologue
    const/4 v1, -0x1

    const v3, 0x7f0c02f6

    .line 57
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 58
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 59
    const v0, 0x7f0300b9

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->setContentView(I)V

    .line 60
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setLayout(II)V

    .line 61
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 62
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->k:Lnb;

    .line 63
    const-string v0, "BreadCrumb"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->o:Ljava/lang/String;

    .line 64
    const-string v0, "isFacetsSearch"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->p:Z

    .line 65
    const-string v0, "isBrowseProduct"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->q:Z

    .line 67
    const-string v0, "SEARCH_RESPONSE"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "SEARCH_RESPONSE"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    .line 69
    if-eqz v0, :cond_0

    .line 70
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getFacets()Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    .line 71
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSortOptions()Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    .line 72
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestedFacets()Ljava/util/HashMap;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->d:Ljava/util/HashMap;

    .line 73
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/search/RequestInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->getSort()Lcom/bestbuy/android/api/lib/models/search/Sort;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->n:Lcom/bestbuy/android/api/lib/models/search/Sort;

    .line 74
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getTotal()I

    move-result v2

    iput v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->g:I

    .line 75
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/search/RequestInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->getQuery()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->j:Ljava/lang/String;

    .line 76
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->k:Lnb;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getCategoryMap()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v2, v0}, Lnb;->a(Ljava/util/HashMap;)V

    .line 79
    :cond_0
    const-string v0, "SELECTED_CATEGORY"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 80
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->l:Ljava/lang/String;

    .line 82
    :cond_1
    const-string v0, "SEARCH_BASE_FACETS"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "SEARCH_BASE_FACETS"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 83
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "SEARCH_BASE_FACETS"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    .line 85
    :cond_2
    const-string v0, "SEARCH_BASE_SORT_OPTIONS"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "SEARCH_BASE_SORT_OPTIONS"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 86
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "SEARCH_BASE_SORT_OPTIONS"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    .line 88
    :cond_3
    const-string v0, "IS_OUTLET_ITEMS"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 89
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "IS_OUTLET_ITEMS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->m:Ljava/lang/String;

    .line 91
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    if-nez v0, :cond_5

    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    .line 94
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    if-nez v0, :cond_6

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    .line 98
    :cond_6
    invoke-direct {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b()V

    .line 99
    invoke-direct {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->a()V

    .line 100
    const v0, 0x7f0c02f4

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 101
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "<span class=\'bold\'>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->g:I

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

    .line 103
    :try_start_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v2, 0x12c

    invoke-static {p0, v1, v0, v2}, Llt;->a(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 107
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->n:Lcom/bestbuy/android/api/lib/models/search/Sort;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->n:Lcom/bestbuy/android/api/lib/models/search/Sort;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Sort;->getValue()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Best-Selling"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->d:Ljava/util/HashMap;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->d:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_9

    .line 109
    :cond_8
    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 113
    :goto_1
    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 114
    const v0, 0x7f0c02f5

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 115
    new-instance v0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->e:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->f:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->b:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->d:Ljava/util/HashMap;

    iget-object v5, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->n:Lcom/bestbuy/android/api/lib/models/search/Sort;

    iget-object v6, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->c:Ljava/util/ArrayList;

    iget-object v7, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->j:Ljava/lang/String;

    iget-object v8, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->i:Ljava/util/ArrayList;

    iget-object v9, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->l:Ljava/lang/String;

    iget-object v10, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->m:Ljava/lang/String;

    invoke-direct/range {v0 .. v10}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;-><init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/HashMap;Lcom/bestbuy/android/api/lib/models/search/Sort;Ljava/util/List;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->h:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    .line 116
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 117
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 118
    const v1, 0x7f0c02f7

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->h:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    const-string v3, "SearchPLPNarrowResultsFilterFragment"

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 119
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 120
    return-void

    .line 104
    :catch_0
    move-exception v0

    .line 105
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 111
    :cond_9
    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 130
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 131
    invoke-static {}, Llu;->a()V

    .line 132
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 124
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 125
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 126
    return-void
.end method
