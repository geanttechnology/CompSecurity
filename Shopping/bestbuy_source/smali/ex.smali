.class public Lex;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/view/LayoutInflater;

.field private c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/app/Activity;ILjava/util/List;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "I",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 24
    iput-object p3, p0, Lex;->a:Ljava/util/List;

    .line 25
    iput-object p4, p0, Lex;->c:Ljava/lang/String;

    .line 26
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lex;->b:Landroid/view/LayoutInflater;

    .line 27
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/solr/SortOption;)I
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lex;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lex;->c:Ljava/lang/String;

    .line 55
    invoke-virtual {p0}, Lex;->notifyDataSetChanged()V

    .line 56
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lex;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 16
    check-cast p1, Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-virtual {p0, p1}, Lex;->a(Lcom/bestbuy/android/api/lib/models/solr/SortOption;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 42
    new-instance v1, Ley;

    invoke-direct {v1}, Ley;-><init>()V

    .line 43
    iget-object v0, p0, Lex;->b:Landroid/view/LayoutInflater;

    const v2, 0x7f0300c2

    invoke-virtual {v0, v2, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 44
    const v0, 0x7f0c0315

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Ley;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 45
    const v0, 0x7f0c0316

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Ley;->b:Landroid/widget/ImageView;

    .line 46
    iget-object v3, v1, Ley;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Lex;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 47
    iget-object v3, p0, Lex;->c:Ljava/lang/String;

    iget-object v0, p0, Lex;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 48
    iget-object v0, v1, Ley;->b:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 50
    :cond_0
    return-object v2
.end method
