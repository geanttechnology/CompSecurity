.class public Lfj;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
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
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 24
    iput-object p3, p0, Lfj;->a:Ljava/util/List;

    .line 25
    iput-object p4, p0, Lfj;->c:Ljava/lang/String;

    .line 26
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lfj;->b:Landroid/view/LayoutInflater;

    .line 27
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;)I
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lfj;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lfj;->c:Ljava/lang/String;

    .line 61
    invoke-virtual {p0}, Lfj;->notifyDataSetChanged()V

    .line 62
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lfj;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 16
    check-cast p1, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-virtual {p0, p1}, Lfj;->a(Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 42
    if-nez p2, :cond_1

    .line 43
    new-instance v1, Lfk;

    invoke-direct {v1}, Lfk;-><init>()V

    .line 44
    iget-object v0, p0, Lfj;->b:Landroid/view/LayoutInflater;

    const v2, 0x7f0300c2

    invoke-virtual {v0, v2, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 45
    const v0, 0x7f0c0315

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 46
    const v0, 0x7f0c0316

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lfk;->b:Landroid/widget/ImageView;

    .line 47
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 51
    :goto_0
    iget-object v2, v1, Lfk;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Lfj;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 52
    iget-object v2, p0, Lfj;->c:Ljava/lang/String;

    iget-object v0, p0, Lfj;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, v1, Lfk;->b:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 56
    :cond_0
    return-object p2

    .line 49
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lfk;

    move-object v1, v0

    goto :goto_0
.end method
