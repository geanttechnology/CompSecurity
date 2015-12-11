.class public Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;
.super Landroid/widget/ArrayAdapter;
.source "MetaItemSpinAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/poshmark/data_model/models/MetaItem;",
        ">;"
    }
.end annotation


# instance fields
.field private context:Landroid/content/Context;

.field private hintString:Ljava/lang/String;

.field private showCustomOption:Z

.field private values:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;ILjava/util/List;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "textViewResourceId"    # I
    .param p4, "hint"    # Ljava/lang/String;
    .param p5, "customOption"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 25
    .local p3, "values":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 26
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->context:Landroid/content/Context;

    .line 27
    iput-object p3, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    .line 28
    iput-object p4, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->hintString:Ljava/lang/String;

    .line 29
    iput-boolean p5, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->showCustomOption:Z

    .line 30
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 2

    .prologue
    .line 33
    const/4 v0, 0x0

    .line 34
    .local v0, "count":I
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    if-eqz v1, :cond_0

    .line 35
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    .line 36
    :cond_0
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->hintString:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 37
    add-int/lit8 v0, v0, 0x1

    .line 38
    :cond_1
    iget-boolean v1, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->showCustomOption:Z

    if-eqz v1, :cond_2

    .line 39
    add-int/lit8 v0, v0, 0x1

    .line 41
    :cond_2
    return v0
.end method

.method public getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 86
    new-instance v1, Landroid/widget/TextView;

    iget-object v3, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->context:Landroid/content/Context;

    invoke-direct {v1, v3}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 87
    .local v1, "label":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090015

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 88
    invoke-virtual {p0}, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090035

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 89
    const/high16 v3, 0x41500000    # 13.0f

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setTextSize(F)V

    .line 92
    invoke-virtual {p0}, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->getContext()Landroid/content/Context;

    move-result-object v3

    const/high16 v4, 0x41200000    # 10.0f

    invoke-static {v3, v4}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v3

    float-to-int v2, v3

    .line 93
    .local v2, "padding":I
    invoke-virtual {v1, v2, v2, v2, v2}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 94
    move v0, p1

    .line 95
    .local v0, "index":I
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->hintString:Ljava/lang/String;

    if-eqz v3, :cond_0

    .line 96
    add-int/lit8 v0, v0, -0x1

    .line 97
    :cond_0
    if-nez p1, :cond_1

    .line 98
    const-string v3, ""

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 106
    :goto_0
    return-object v1

    .line 100
    :cond_1
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ge v0, v3, :cond_2

    .line 101
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 104
    :cond_2
    const-string v3, ""

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public getItem(I)Lcom/poshmark/data_model/models/MetaItem;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 45
    move v0, p1

    .line 46
    .local v0, "index":I
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->hintString:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 47
    add-int/lit8 v0, v0, -0x1

    .line 48
    :cond_0
    if-ltz v0, :cond_1

    iget-object v1, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 49
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/MetaItem;

    .line 51
    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 18
    invoke-virtual {p0, p1}, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->getItem(I)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 57
    new-instance v1, Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->context:Landroid/content/Context;

    invoke-direct {v1, v2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 58
    .local v1, "label":Landroid/widget/TextView;
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 59
    const/high16 v2, 0x41500000    # 13.0f

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextSize(F)V

    .line 60
    move v0, p1

    .line 61
    .local v0, "index":I
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->hintString:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 62
    add-int/lit8 v0, v0, -0x1

    .line 64
    :cond_0
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->hintString:Ljava/lang/String;

    if-eqz v2, :cond_2

    if-nez p1, :cond_2

    .line 65
    invoke-virtual {p0}, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090039

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 67
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->hintString:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 79
    :cond_1
    :goto_0
    return-object v1

    .line 69
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090035

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 70
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 72
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/MetaItemSpinAdapter;->values:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
