.class public Ldj;
.super Landroid/widget/BaseExpandableListAdapter;
.source "SourceFile"


# instance fields
.field private a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/FacetValues;",
            ">;>;"
        }
    .end annotation
.end field

.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;"
        }
    .end annotation
.end field

.field private c:Landroid/view/LayoutInflater;

.field private d:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

.field private e:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private f:Ljava/util/HashMap;
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

.field private g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private h:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private i:Ljava/lang/String;

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


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/FacetValues;",
            ">;>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 35
    invoke-direct {p0}, Landroid/widget/BaseExpandableListAdapter;-><init>()V

    .line 30
    iput-object v0, p0, Ldj;->g:Ljava/util/List;

    .line 31
    iput-object v0, p0, Ldj;->h:Ljava/util/ArrayList;

    .line 33
    iput-object v0, p0, Ldj;->j:Ljava/util/ArrayList;

    .line 36
    iput-object p4, p0, Ldj;->a:Ljava/util/Map;

    .line 37
    iput-object p3, p0, Ldj;->b:Ljava/util/List;

    .line 38
    iput-object p2, p0, Ldj;->d:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    .line 39
    iput-object p5, p0, Ldj;->i:Ljava/lang/String;

    .line 40
    invoke-virtual {p2}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Ldj;->e:Ljava/util/Map;

    .line 41
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Ldj;->c:Landroid/view/LayoutInflater;

    .line 42
    return-void
.end method


# virtual methods
.method public a(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Ldj;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    .line 138
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getFacetField()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 1
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
    .line 215
    iput-object p1, p0, Ldj;->j:Ljava/util/ArrayList;

    .line 216
    iget-object v0, p0, Ldj;->d:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Ldj;->e:Ljava/util/Map;

    .line 217
    iget-object v0, p0, Ldj;->d:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Ldj;->h:Ljava/util/ArrayList;

    .line 218
    invoke-virtual {p0}, Ldj;->notifyDataSetChanged()V

    .line 219
    return-void
.end method

.method public a(Ljava/util/HashMap;Ljava/util/List;Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/FacetValues;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 206
    iput-object p3, p0, Ldj;->a:Ljava/util/Map;

    .line 207
    iput-object p2, p0, Ldj;->b:Ljava/util/List;

    .line 208
    iput-object p1, p0, Ldj;->f:Ljava/util/HashMap;

    .line 209
    iget-object v0, p0, Ldj;->d:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Ldj;->e:Ljava/util/Map;

    .line 210
    iget-object v0, p0, Ldj;->d:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Ldj;->h:Ljava/util/ArrayList;

    .line 211
    invoke-virtual {p0}, Ldj;->notifyDataSetChanged()V

    .line 212
    return-void
.end method

.method public getChild(II)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 45
    iget-object v1, p0, Ldj;->a:Ljava/util/Map;

    iget-object v0, p0, Ldj;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    .line 46
    return-object v0
.end method

.method public getChildId(II)J
    .locals 2

    .prologue
    .line 50
    int-to-long v0, p2

    return-wide v0
.end method

.method public getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8

    .prologue
    .line 54
    .line 55
    invoke-virtual {p0, p1, p2}, Ldj;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    .line 56
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v5

    .line 57
    iget-object v1, p0, Ldj;->e:Ljava/util/Map;

    invoke-virtual {p0, p1}, Ldj;->a(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 58
    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 59
    :cond_0
    const/4 v2, 0x1

    move v3, v2

    .line 64
    :goto_0
    iget-object v2, p0, Ldj;->f:Ljava/util/HashMap;

    if-eqz v2, :cond_1

    .line 65
    iget-object v2, p0, Ldj;->f:Ljava/util/HashMap;

    invoke-virtual {p0, p1}, Ldj;->a(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    iput-object v2, p0, Ldj;->g:Ljava/util/List;

    .line 68
    :cond_1
    if-nez p4, :cond_6

    .line 69
    iget-object v2, p0, Ldj;->c:Landroid/view/LayoutInflater;

    const v4, 0x7f0300be

    const/4 v6, 0x0

    invoke-virtual {v2, v4, p5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 70
    new-instance v4, Ldk;

    invoke-direct {v4}, Ldk;-><init>()V

    .line 71
    const v2, 0x7f0c030a

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v2, v4, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 72
    const v2, 0x7f0c030b

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v4, Ldk;->c:Landroid/widget/ImageView;

    .line 73
    const v2, 0x7f0c0309

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, v4, Ldk;->d:Landroid/widget/RelativeLayout;

    .line 74
    const v2, 0x7f0c030c

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, v4, Ldk;->b:Landroid/view/View;

    .line 75
    invoke-virtual {p4, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v2, v4

    .line 79
    :goto_1
    if-eqz v1, :cond_7

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getCategoryPath()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 80
    :cond_2
    iget-object v4, v2, Ldk;->c:Landroid/widget/ImageView;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 85
    :goto_2
    invoke-virtual {p0, p1}, Ldj;->a(I)Ljava/lang/String;

    move-result-object v4

    .line 86
    iget-object v6, p0, Ldj;->j:Ljava/util/ArrayList;

    if-eqz v6, :cond_a

    iget-object v6, p0, Ldj;->j:Ljava/util/ArrayList;

    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_a

    .line 87
    if-eqz v1, :cond_9

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getCategoryPath()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 88
    :cond_3
    iget-object v3, v2, Ldk;->c:Landroid/widget/ImageView;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 89
    iget-object v3, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    const/16 v6, 0x67

    const/16 v7, 0xaf

    invoke-static {v4, v6, v7}, Landroid/graphics/Color;->rgb(III)I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 90
    if-eqz v1, :cond_8

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getCategoryPath()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 91
    :cond_4
    iget-object v1, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 95
    :goto_3
    iget-object v0, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Active"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTag(Ljava/lang/Object;)V

    .line 117
    :goto_4
    add-int/lit8 v0, p2, 0x1

    invoke-virtual {p0, p1}, Ldj;->getChildrenCount(I)I

    move-result v1

    if-ne v0, v1, :cond_e

    .line 118
    iget-object v0, v2, Ldk;->d:Landroid/widget/RelativeLayout;

    const v1, 0x7f02002a

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 119
    iget-object v0, v2, Ldk;->b:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 124
    :goto_5
    return-object p4

    .line 61
    :cond_5
    const/4 v2, 0x0

    move v3, v2

    goto/16 :goto_0

    .line 77
    :cond_6
    invoke-virtual {p4}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ldk;

    goto/16 :goto_1

    .line 82
    :cond_7
    iget-object v4, v2, Ldk;->c:Landroid/widget/ImageView;

    const/16 v6, 0x8

    invoke-virtual {v4, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 93
    :cond_8
    iget-object v0, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_3

    .line 98
    :cond_9
    iget-object v1, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v3, 0x0

    const/16 v4, 0x67

    const/16 v5, 0xaf

    invoke-static {v3, v4, v5}, Landroid/graphics/Color;->rgb(III)I

    move-result v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 99
    iget-object v1, v2, Ldk;->c:Landroid/widget/ImageView;

    const/16 v3, 0x8

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 100
    iget-object v1, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 101
    iget-object v0, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Active"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTag(Ljava/lang/Object;)V

    goto :goto_4

    .line 104
    :cond_a
    iget-object v4, p0, Ldj;->h:Ljava/util/ArrayList;

    if-eqz v4, :cond_b

    iget-object v4, p0, Ldj;->h:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_b

    if-eqz v3, :cond_b

    .line 106
    iget-object v1, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_4

    .line 109
    :cond_b
    iget-object v3, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    const/16 v6, 0x67

    const/16 v7, 0xaf

    invoke-static {v4, v6, v7}, Landroid/graphics/Color;->rgb(III)I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 110
    if-eqz v1, :cond_d

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getCategoryPath()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 111
    :cond_c
    iget-object v1, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 114
    :goto_6
    iget-object v0, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Active"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTag(Ljava/lang/Object;)V

    goto/16 :goto_4

    .line 113
    :cond_d
    iget-object v0, v2, Ldk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_6

    .line 121
    :cond_e
    iget-object v0, v2, Ldk;->d:Landroid/widget/RelativeLayout;

    const v1, 0x7f0b0063

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 122
    iget-object v0, v2, Ldk;->b:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_5
.end method

.method public getChildrenCount(I)I
    .locals 2

    .prologue
    .line 128
    iget-object v1, p0, Ldj;->a:Ljava/util/Map;

    iget-object v0, p0, Ldj;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getGroup(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Ldj;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    .line 133
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getGroupCount()I
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Ldj;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getGroupId(I)J
    .locals 2

    .prologue
    .line 145
    int-to-long v0, p1

    return-wide v0
.end method

.method public getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 149
    invoke-virtual {p0, p1}, Ldj;->getGroup(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 152
    if-nez p3, :cond_0

    .line 153
    iget-object v1, p0, Ldj;->c:Landroid/view/LayoutInflater;

    const v2, 0x7f0300bd

    invoke-virtual {v1, v2, p4, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p3

    .line 154
    new-instance v2, Ldl;

    invoke-direct {v2}, Ldl;-><init>()V

    .line 155
    const v1, 0x7f0c0306

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v1, v2, Ldl;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 156
    const v1, 0x7f0c0305

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, v2, Ldl;->d:Landroid/widget/RelativeLayout;

    .line 157
    const v1, 0x7f0c0307

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, v2, Ldl;->b:Landroid/widget/ImageView;

    .line 158
    const v1, 0x7f0c0308

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, v2, Ldl;->c:Landroid/view/View;

    .line 159
    invoke-virtual {p3, v2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v1, v2

    .line 163
    :goto_0
    if-eqz p2, :cond_1

    .line 167
    iget-object v2, v1, Ldl;->d:Landroid/widget/RelativeLayout;

    const v3, 0x7f0200ce

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 168
    iget-object v2, v1, Ldl;->b:Landroid/widget/ImageView;

    const v3, 0x7f0201b6

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 169
    iget-object v2, v1, Ldl;->c:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 178
    :goto_1
    iget-object v2, v1, Ldl;->c:Landroid/view/View;

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 179
    iget-object v1, v1, Ldl;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 180
    return-object p3

    .line 161
    :cond_0
    invoke-virtual {p3}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ldl;

    goto :goto_0

    .line 171
    :cond_1
    iget-object v2, v1, Ldl;->d:Landroid/widget/RelativeLayout;

    const v3, 0x7f020029

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 172
    iget-object v2, p0, Ldj;->e:Ljava/util/Map;

    invoke-virtual {p0, p1}, Ldj;->a(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 173
    iget-object v2, v1, Ldl;->b:Landroid/widget/ImageView;

    const v3, 0x7f020077

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 175
    :cond_2
    iget-object v2, v1, Ldl;->b:Landroid/widget/ImageView;

    const v3, 0x7f0200b6

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 184
    const/4 v0, 0x1

    return v0
.end method

.method public isChildSelectable(II)Z
    .locals 1

    .prologue
    .line 188
    const/4 v0, 0x1

    return v0
.end method
