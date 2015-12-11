.class public Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcb;


# instance fields
.field private a:Lnb;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation
.end field

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
            ">;"
        }
    .end annotation
.end field

.field private d:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

.field private e:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation
.end field

.field private f:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation
.end field

.field private g:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;

.field private j:D

.field private k:D

.field private l:I

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->b:Ljava/util/ArrayList;

    return-void
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 142
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 143
    const-string v1, "SELECTED_FACETS"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 144
    const-string v1, "SORT_ORDER"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 145
    const-string v1, "BASE_FACETS"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 146
    const/4 v1, -0x1

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->setResult(ILandroid/content/Intent;)V

    .line 147
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->finish()V

    .line 148
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->overridePendingTransition(II)V

    .line 149
    return-void
.end method

.method public a(Z)V
    .locals 2

    .prologue
    const v0, 0x7f0c02f6

    .line 119
    if-eqz p1, :cond_0

    .line 120
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 124
    :goto_0
    return-void

    .line 122
    :cond_0
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->findViewById(I)Landroid/view/View;

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

    .line 127
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c02f5

    if-ne v0, v1, :cond_1

    .line 128
    const/4 v0, 0x0

    invoke-virtual {p0, v3, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->setResult(ILandroid/content/Intent;)V

    .line 129
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->finish()V

    .line 130
    invoke-virtual {p0, v4, v5}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->overridePendingTransition(II)V

    .line 138
    :cond_0
    :goto_0
    return-void

    .line 131
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c02f6

    if-ne v0, v1, :cond_0

    .line 132
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 133
    const-string v1, "CLEAR_ALL"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 134
    invoke-virtual {p0, v3, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->setResult(ILandroid/content/Intent;)V

    .line 135
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->finish()V

    .line 136
    invoke-virtual {p0, v4, v5}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 15

    .prologue
    .line 48
    invoke-super/range {p0 .. p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 49
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 50
    const v0, 0x7f0300b9

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->setContentView(I)V

    .line 51
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, -0x1

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Landroid/view/Window;->setLayout(II)V

    .line 52
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 53
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->a:Lnb;

    .line 54
    if-eqz v1, :cond_0

    .line 55
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "STORE_ID"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->h:Ljava/lang/String;

    .line 56
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "LAT"

    const-wide/16 v4, 0x0

    invoke-virtual {v0, v2, v4, v5}, Landroid/content/Intent;->getDoubleExtra(Ljava/lang/String;D)D

    move-result-wide v2

    iput-wide v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->j:D

    .line 57
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "LNG"

    const-wide/16 v4, 0x0

    invoke-virtual {v0, v2, v4, v5}, Landroid/content/Intent;->getDoubleExtra(Ljava/lang/String;D)D

    move-result-wide v2

    iput-wide v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->k:D

    .line 58
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "RADIUS"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->l:I

    .line 59
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "DNM_TYPE"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->m:Ljava/lang/String;

    .line 60
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "SEARCH_QUERY"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->o:Ljava/lang/String;

    .line 61
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "SELECTED_SORT_OPTION"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->n:Ljava/lang/String;

    .line 63
    :cond_0
    if-eqz v1, :cond_2

    const-string v0, "DNM_RESPONSE"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 64
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "DNM_RESPONSE"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->p:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->p:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getFacetsFilters()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->f:Ljava/util/ArrayList;

    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->p:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getSortOptions()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->c:Ljava/util/ArrayList;

    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->p:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getSelectedFilters()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->g:Ljava/util/ArrayList;

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->g:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 69
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "SELECTED_FACETS"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->g:Ljava/util/ArrayList;

    .line 72
    :cond_2
    if-eqz v1, :cond_3

    const-string v0, "DNM_BASE_FACETS"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 73
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "DNM_BASE_FACETS"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->e:Ljava/util/ArrayList;

    .line 75
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->n:Ljava/lang/String;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->n:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->n:Ljava/lang/String;

    const v1, 0x7f080068

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 76
    :cond_4
    const-string v0, "rating"

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->n:Ljava/lang/String;

    .line 77
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->g:Ljava/util/ArrayList;

    if-eqz v0, :cond_8

    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_6
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 79
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFacetTitle()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_6

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFacetTitle()Ljava/lang/String;

    move-result-object v1

    const-string v3, "Store"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->p:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getDnmProducts()Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_6

    .line 81
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->p:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getDnmProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 82
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getStoreName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->i:Ljava/lang/String;

    .line 85
    :cond_7
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->i:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->setDisplayText(Ljava/lang/String;)V

    goto :goto_0

    .line 89
    :cond_8
    new-instance v6, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-direct {v6}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;-><init>()V

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_9
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    .line 91
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->getValue()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->n:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    move-object v6, v0

    .line 96
    :cond_a
    const v0, 0x7f0c02f6

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 97
    const v0, 0x7f0c02f5

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 98
    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->e:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->f:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->c:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->g:Ljava/util/ArrayList;

    iget-object v7, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->h:Ljava/lang/String;

    iget-wide v8, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->j:D

    iget-wide v10, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->k:D

    iget v12, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->l:I

    iget-object v13, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->m:Ljava/lang/String;

    iget-object v14, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->o:Ljava/lang/String;

    invoke-direct/range {v1 .. v14}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;-><init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->d:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    .line 99
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 100
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 101
    const v1, 0x7f0c02f7

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;->d:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    const-string v3, "PLPNarrowResultsFilterFragment"

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 102
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 103
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 113
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 114
    invoke-static {}, Llu;->a()V

    .line 115
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 107
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 108
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 109
    return-void
.end method
