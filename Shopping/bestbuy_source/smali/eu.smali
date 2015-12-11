.class public Leu;
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
            "Lcom/bestbuy/android/api/lib/models/solr/Value;",
            ">;>;"
        }
    .end annotation
.end field

.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;"
        }
    .end annotation
.end field

.field private c:Landroid/view/LayoutInflater;

.field private d:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

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
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Value;",
            ">;>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 37
    invoke-direct {p0}, Landroid/widget/BaseExpandableListAdapter;-><init>()V

    .line 32
    iput-object v0, p0, Leu;->g:Ljava/util/List;

    .line 33
    iput-object v0, p0, Leu;->h:Ljava/util/ArrayList;

    .line 35
    iput-object v0, p0, Leu;->j:Ljava/util/ArrayList;

    .line 38
    iput-object p4, p0, Leu;->a:Ljava/util/Map;

    .line 39
    iput-object p3, p0, Leu;->b:Ljava/util/List;

    .line 40
    iput-object p2, p0, Leu;->d:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    .line 41
    iput-object p5, p0, Leu;->i:Ljava/lang/String;

    .line 42
    invoke-virtual {p2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Leu;->e:Ljava/util/Map;

    .line 43
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Leu;->c:Landroid/view/LayoutInflater;

    .line 44
    return-void
.end method


# virtual methods
.method public a(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Leu;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    .line 140
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getFacetField()Ljava/lang/String;

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
    .line 217
    iput-object p1, p0, Leu;->j:Ljava/util/ArrayList;

    .line 218
    iget-object v0, p0, Leu;->d:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Leu;->e:Ljava/util/Map;

    .line 219
    iget-object v0, p0, Leu;->d:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->c()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Leu;->h:Ljava/util/ArrayList;

    .line 220
    invoke-virtual {p0}, Leu;->notifyDataSetChanged()V

    .line 221
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
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Value;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 208
    iput-object p3, p0, Leu;->a:Ljava/util/Map;

    .line 209
    iput-object p2, p0, Leu;->b:Ljava/util/List;

    .line 210
    iput-object p1, p0, Leu;->f:Ljava/util/HashMap;

    .line 211
    iget-object v0, p0, Leu;->d:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Leu;->e:Ljava/util/Map;

    .line 212
    iget-object v0, p0, Leu;->d:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->c()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Leu;->h:Ljava/util/ArrayList;

    .line 213
    invoke-virtual {p0}, Leu;->notifyDataSetChanged()V

    .line 214
    return-void
.end method

.method public getChild(II)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 47
    iget-object v1, p0, Leu;->a:Ljava/util/Map;

    iget-object v0, p0, Leu;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Value;

    .line 48
    return-object v0
.end method

.method public getChildId(II)J
    .locals 2

    .prologue
    .line 52
    int-to-long v0, p2

    return-wide v0
.end method

.method public getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8

    .prologue
    .line 56
    .line 57
    invoke-virtual {p0, p1, p2}, Leu;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Value;

    .line 58
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v5

    .line 59
    iget-object v1, p0, Leu;->e:Ljava/util/Map;

    invoke-virtual {p0, p1}, Leu;->a(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 60
    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 61
    :cond_0
    const/4 v2, 0x1

    move v3, v2

    .line 66
    :goto_0
    iget-object v2, p0, Leu;->f:Ljava/util/HashMap;

    if-eqz v2, :cond_1

    .line 67
    iget-object v2, p0, Leu;->f:Ljava/util/HashMap;

    invoke-virtual {p0, p1}, Leu;->a(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    iput-object v2, p0, Leu;->g:Ljava/util/List;

    .line 70
    :cond_1
    if-nez p4, :cond_3

    .line 71
    iget-object v2, p0, Leu;->c:Landroid/view/LayoutInflater;

    const v4, 0x7f0300be

    const/4 v6, 0x0

    invoke-virtual {v2, v4, p5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 72
    new-instance v4, Lev;

    invoke-direct {v4}, Lev;-><init>()V

    .line 73
    const v2, 0x7f0c030a

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v2, v4, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 74
    const v2, 0x7f0c030b

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v4, Lev;->c:Landroid/widget/ImageView;

    .line 75
    const v2, 0x7f0c0309

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, v4, Lev;->d:Landroid/widget/RelativeLayout;

    .line 76
    const v2, 0x7f0c030c

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, v4, Lev;->b:Landroid/view/View;

    .line 77
    invoke-virtual {p4, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v2, v4

    .line 81
    :goto_1
    if-eqz v1, :cond_4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 82
    iget-object v4, v2, Lev;->c:Landroid/widget/ImageView;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 87
    :goto_2
    invoke-virtual {p0, p1}, Leu;->a(I)Ljava/lang/String;

    move-result-object v4

    .line 88
    iget-object v6, p0, Leu;->j:Ljava/util/ArrayList;

    if-eqz v6, :cond_7

    iget-object v6, p0, Leu;->j:Ljava/util/ArrayList;

    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 89
    if-eqz v1, :cond_6

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 90
    iget-object v3, v2, Lev;->c:Landroid/widget/ImageView;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 91
    iget-object v3, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    const/16 v6, 0x67

    const/16 v7, 0xaf

    invoke-static {v4, v6, v7}, Landroid/graphics/Color;->rgb(III)I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 92
    if-eqz v1, :cond_5

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 93
    iget-object v1, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 97
    :goto_3
    iget-object v0, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Active"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTag(Ljava/lang/Object;)V

    .line 119
    :goto_4
    add-int/lit8 v0, p2, 0x1

    invoke-virtual {p0, p1}, Leu;->getChildrenCount(I)I

    move-result v1

    if-ne v0, v1, :cond_a

    .line 120
    iget-object v0, v2, Lev;->d:Landroid/widget/RelativeLayout;

    const v1, 0x7f02002a

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 121
    iget-object v0, v2, Lev;->b:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 126
    :goto_5
    return-object p4

    .line 63
    :cond_2
    const/4 v2, 0x0

    move v3, v2

    goto/16 :goto_0

    .line 79
    :cond_3
    invoke-virtual {p4}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lev;

    goto :goto_1

    .line 84
    :cond_4
    iget-object v4, v2, Lev;->c:Landroid/widget/ImageView;

    const/16 v6, 0x8

    invoke-virtual {v4, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_2

    .line 95
    :cond_5
    iget-object v0, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_3

    .line 100
    :cond_6
    iget-object v1, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v3, 0x0

    const/16 v4, 0x67

    const/16 v5, 0xaf

    invoke-static {v3, v4, v5}, Landroid/graphics/Color;->rgb(III)I

    move-result v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 101
    iget-object v1, v2, Lev;->c:Landroid/widget/ImageView;

    const/16 v3, 0x8

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 102
    iget-object v1, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 103
    iget-object v0, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Active"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTag(Ljava/lang/Object;)V

    goto :goto_4

    .line 106
    :cond_7
    iget-object v4, p0, Leu;->h:Ljava/util/ArrayList;

    if-eqz v4, :cond_8

    iget-object v4, p0, Leu;->h:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    if-eqz v3, :cond_8

    .line 108
    iget-object v1, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_4

    .line 111
    :cond_8
    iget-object v3, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    const/16 v6, 0x67

    const/16 v7, 0xaf

    invoke-static {v4, v6, v7}, Landroid/graphics/Color;->rgb(III)I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 112
    if-eqz v1, :cond_9

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 113
    iget-object v1, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 116
    :goto_6
    iget-object v0, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Active"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTag(Ljava/lang/Object;)V

    goto/16 :goto_4

    .line 115
    :cond_9
    iget-object v0, v2, Lev;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_6

    .line 123
    :cond_a
    iget-object v0, v2, Lev;->d:Landroid/widget/RelativeLayout;

    const v1, 0x7f0b0063

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 124
    iget-object v0, v2, Lev;->b:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_5
.end method

.method public getChildrenCount(I)I
    .locals 2

    .prologue
    .line 130
    iget-object v1, p0, Leu;->a:Ljava/util/Map;

    iget-object v0, p0, Leu;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getDisplayName()Ljava/lang/String;

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
    .line 134
    iget-object v0, p0, Leu;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    .line 135
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getGroupCount()I
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Leu;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getGroupId(I)J
    .locals 2

    .prologue
    .line 147
    int-to-long v0, p1

    return-wide v0
.end method

.method public getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 151
    invoke-virtual {p0, p1}, Leu;->getGroup(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 154
    if-nez p3, :cond_0

    .line 155
    iget-object v1, p0, Leu;->c:Landroid/view/LayoutInflater;

    const v2, 0x7f0300bd

    invoke-virtual {v1, v2, p4, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p3

    .line 156
    new-instance v2, Lew;

    invoke-direct {v2}, Lew;-><init>()V

    .line 157
    const v1, 0x7f0c0306

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v1, v2, Lew;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 158
    const v1, 0x7f0c0305

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, v2, Lew;->d:Landroid/widget/RelativeLayout;

    .line 159
    const v1, 0x7f0c0307

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, v2, Lew;->b:Landroid/widget/ImageView;

    .line 160
    const v1, 0x7f0c0308

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, v2, Lew;->c:Landroid/view/View;

    .line 161
    invoke-virtual {p3, v2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v1, v2

    .line 165
    :goto_0
    if-eqz p2, :cond_1

    .line 169
    iget-object v2, v1, Lew;->d:Landroid/widget/RelativeLayout;

    const v3, 0x7f0200ce

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 170
    iget-object v2, v1, Lew;->b:Landroid/widget/ImageView;

    const v3, 0x7f0201b6

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 171
    iget-object v2, v1, Lew;->c:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 180
    :goto_1
    iget-object v2, v1, Lew;->c:Landroid/view/View;

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 181
    iget-object v1, v1, Lew;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 182
    return-object p3

    .line 163
    :cond_0
    invoke-virtual {p3}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lew;

    goto :goto_0

    .line 173
    :cond_1
    iget-object v2, v1, Lew;->d:Landroid/widget/RelativeLayout;

    const v3, 0x7f020029

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 174
    iget-object v2, p0, Leu;->e:Ljava/util/Map;

    invoke-virtual {p0, p1}, Leu;->a(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 175
    iget-object v2, v1, Lew;->b:Landroid/widget/ImageView;

    const v3, 0x7f020077

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 177
    :cond_2
    iget-object v2, v1, Lew;->b:Landroid/widget/ImageView;

    const v3, 0x7f0200b6

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 186
    const/4 v0, 0x1

    return v0
.end method

.method public isChildSelectable(II)Z
    .locals 1

    .prologue
    .line 190
    const/4 v0, 0x1

    return v0
.end method
