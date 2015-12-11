.class public Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;
.super Landroid/widget/LinearLayout;
.source "WordSplitterView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;",
        ">;"
    }
.end annotation


# instance fields
.field private header:Landroid/widget/TextView;

.field preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    sget v0, Lcom/amazon/retailsearch/R$layout;->rs_corrections_spell_corrected:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 28
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_spell_corrected_text:I

    invoke-static {p0, v0}, Lcom/amazon/retailsearch/android/ui/ViewHolder;->get(Landroid/view/View;I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;->header:Landroid/widget/TextView;

    .line 29
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 30
    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 3
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 35
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getStyledText()Ljava/util/List;

    move-result-object v1

    if-nez v1, :cond_1

    .line 37
    :cond_0
    const/16 v1, 0x8

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;->setVisibility(I)V

    .line 45
    :goto_0
    return-void

    .line 41
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 42
    .local v0, "styledText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getStyledText()Ljava/util/List;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$style;->Rs:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 43
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;->header:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 44
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic build(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 18
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/WordSplitterView;->build(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V

    return-void
.end method
