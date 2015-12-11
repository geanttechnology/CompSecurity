.class public Lfe;
.super Landroid/widget/BaseExpandableListAdapter;
.source "SourceFile"


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation
.end field

.field private b:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;>;"
        }
    .end annotation
.end field

.field private c:Landroid/view/LayoutInflater;

.field private d:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

.field private e:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
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

.field private h:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;Ljava/util/ArrayList;Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 36
    invoke-direct {p0}, Landroid/widget/BaseExpandableListAdapter;-><init>()V

    .line 33
    iput-object v0, p0, Lfe;->g:Ljava/util/List;

    .line 34
    iput-object v0, p0, Lfe;->h:Ljava/util/Map;

    .line 37
    iput-object p3, p0, Lfe;->a:Ljava/util/ArrayList;

    .line 38
    iput-object p4, p0, Lfe;->b:Ljava/util/Map;

    .line 39
    iput-object p2, p0, Lfe;->d:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    .line 40
    invoke-virtual {p2}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lfe;->e:Ljava/util/Map;

    .line 41
    invoke-virtual {p2}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->c()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lfe;->h:Ljava/util/Map;

    .line 42
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lfe;->c:Landroid/view/LayoutInflater;

    .line 43
    return-void
.end method

.method private a(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lfe;->h:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 65
    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private a(Ljava/util/List;Ljava/lang/String;)Z
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 55
    move v1, v2

    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 56
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 57
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFilterQuery()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 58
    const/4 v2, 0x1

    .line 60
    :cond_0
    return v2

    .line 55
    :cond_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0
.end method


# virtual methods
.method public a(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lfe;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    .line 134
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public a()V
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lfe;->d:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lfe;->e:Ljava/util/Map;

    .line 207
    invoke-virtual {p0}, Lfe;->notifyDataSetChanged()V

    .line 208
    return-void
.end method

.method public getChild(II)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 46
    iget-object v1, p0, Lfe;->b:Ljava/util/Map;

    iget-object v0, p0, Lfe;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 47
    return-object v0
.end method

.method public getChildId(II)J
    .locals 2

    .prologue
    .line 51
    int-to-long v0, p2

    return-wide v0
.end method

.method public getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 9

    .prologue
    const/16 v8, 0x8

    const/4 v4, 0x0

    .line 69
    .line 70
    invoke-virtual {p0, p1, p2}, Lfe;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 71
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getDisplayText()Ljava/lang/String;

    move-result-object v6

    .line 72
    iget-object v1, p0, Lfe;->e:Ljava/util/Map;

    invoke-virtual {p0, p1}, Lfe;->a(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 73
    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFilterQuery()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lfe;->a(Ljava/util/List;Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 74
    :cond_0
    const/4 v2, 0x1

    move v3, v2

    .line 79
    :goto_0
    iget-object v2, p0, Lfe;->f:Ljava/util/HashMap;

    if-eqz v2, :cond_1

    .line 80
    iget-object v2, p0, Lfe;->f:Ljava/util/HashMap;

    invoke-virtual {p0, p1}, Lfe;->a(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    iput-object v2, p0, Lfe;->g:Ljava/util/List;

    .line 83
    :cond_1
    if-nez p4, :cond_3

    .line 84
    iget-object v2, p0, Lfe;->c:Landroid/view/LayoutInflater;

    const v5, 0x7f0300be

    invoke-virtual {v2, v5, p5, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p4

    .line 85
    new-instance v5, Lff;

    invoke-direct {v5}, Lff;-><init>()V

    .line 86
    const v2, 0x7f0c030a

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v2, v5, Lff;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 87
    const v2, 0x7f0c030b

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v5, Lff;->c:Landroid/widget/ImageView;

    .line 88
    const v2, 0x7f0c0309

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, v5, Lff;->d:Landroid/widget/RelativeLayout;

    .line 89
    const v2, 0x7f0c030c

    invoke-virtual {p4, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, v5, Lff;->b:Landroid/view/View;

    .line 90
    invoke-virtual {p4, v5}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v2, v5

    .line 94
    :goto_1
    if-eqz v1, :cond_4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFilterQuery()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v1, v5}, Lfe;->a(Ljava/util/List;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 95
    iget-object v5, v2, Lff;->c:Landroid/widget/ImageView;

    invoke-virtual {v5, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 100
    :goto_2
    iget-object v5, p0, Lfe;->h:Ljava/util/Map;

    if-eqz v5, :cond_5

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getDisplayText()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lfe;->a(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    if-eqz v3, :cond_5

    .line 102
    iget-object v0, v2, Lff;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 113
    :goto_3
    add-int/lit8 v0, p2, 0x1

    invoke-virtual {p0, p1}, Lfe;->getChildrenCount(I)I

    move-result v1

    if-ne v0, v1, :cond_7

    .line 114
    iget-object v0, v2, Lff;->d:Landroid/widget/RelativeLayout;

    const v1, 0x7f02002a

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 115
    iget-object v0, v2, Lff;->b:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 120
    :goto_4
    return-object p4

    :cond_2
    move v3, v4

    .line 76
    goto/16 :goto_0

    .line 92
    :cond_3
    invoke-virtual {p4}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lff;

    goto :goto_1

    .line 98
    :cond_4
    iget-object v5, v2, Lff;->c:Landroid/widget/ImageView;

    invoke-virtual {v5, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_2

    .line 105
    :cond_5
    iget-object v3, v2, Lff;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v5, 0x67

    const/16 v7, 0xaf

    invoke-static {v4, v5, v7}, Landroid/graphics/Color;->rgb(III)I

    move-result v5

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 106
    if-eqz v1, :cond_6

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFilterQuery()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v1, v0}, Lfe;->a(Ljava/util/List;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 107
    iget-object v0, v2, Lff;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 111
    :goto_5
    iget-object v0, v2, Lff;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Active"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTag(Ljava/lang/Object;)V

    goto :goto_3

    .line 109
    :cond_6
    iget-object v0, v2, Lff;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_5

    .line 117
    :cond_7
    iget-object v0, v2, Lff;->d:Landroid/widget/RelativeLayout;

    const v1, 0x7f0b0063

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 118
    iget-object v0, v2, Lff;->b:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->setVisibility(I)V

    goto :goto_4
.end method

.method public getChildrenCount(I)I
    .locals 2

    .prologue
    .line 124
    iget-object v1, p0, Lfe;->b:Ljava/util/Map;

    iget-object v0, p0, Lfe;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getGroup(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lfe;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    .line 129
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getGroupCount()I
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lfe;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getGroupId(I)J
    .locals 2

    .prologue
    .line 141
    int-to-long v0, p1

    return-wide v0
.end method

.method public getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 145
    invoke-virtual {p0, p1}, Lfe;->getGroup(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 147
    if-nez p3, :cond_0

    .line 148
    iget-object v1, p0, Lfe;->c:Landroid/view/LayoutInflater;

    const v2, 0x7f0300bd

    invoke-virtual {v1, v2, p4, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p3

    .line 149
    new-instance v2, Lfg;

    invoke-direct {v2}, Lfg;-><init>()V

    .line 150
    const v1, 0x7f0c0306

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v1, v2, Lfg;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 151
    const v1, 0x7f0c0305

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, v2, Lfg;->d:Landroid/widget/RelativeLayout;

    .line 152
    const v1, 0x7f0c0307

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, v2, Lfg;->b:Landroid/widget/ImageView;

    .line 153
    const v1, 0x7f0c0308

    invoke-virtual {p3, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, v2, Lfg;->c:Landroid/view/View;

    .line 154
    invoke-virtual {p3, v2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v1, v2

    .line 158
    :goto_0
    if-eqz p2, :cond_1

    .line 159
    iget-object v2, v1, Lfg;->d:Landroid/widget/RelativeLayout;

    const v3, 0x7f0200ce

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 160
    iget-object v2, v1, Lfg;->b:Landroid/widget/ImageView;

    const v3, 0x7f0201b6

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 161
    iget-object v2, v1, Lfg;->c:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 171
    :goto_1
    iget-object v1, v1, Lfg;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 172
    return-object p3

    .line 156
    :cond_0
    invoke-virtual {p3}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lfg;

    goto :goto_0

    .line 163
    :cond_1
    iget-object v2, v1, Lfg;->d:Landroid/widget/RelativeLayout;

    const v3, 0x7f020029

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 164
    iget-object v2, p0, Lfe;->e:Ljava/util/Map;

    invoke-virtual {p0, p1}, Lfe;->a(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 165
    iget-object v2, v1, Lfg;->b:Landroid/widget/ImageView;

    const v3, 0x7f020077

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 169
    :goto_2
    iget-object v2, v1, Lfg;->c:Landroid/view/View;

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1

    .line 167
    :cond_2
    iget-object v2, v1, Lfg;->b:Landroid/widget/ImageView;

    const v3, 0x7f0200b6

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_2
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 176
    const/4 v0, 0x1

    return v0
.end method

.method public isChildSelectable(II)Z
    .locals 1

    .prologue
    .line 180
    const/4 v0, 0x1

    return v0
.end method
