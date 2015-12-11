.class public Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;
.super Landroid/widget/LinearLayout;
.source "SpellCorrectedHeader.java"

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
.field private final details:Landroid/widget/TextView;

.field private final header:Landroid/widget/TextView;

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
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->setOrientation(I)V

    .line 28
    sget v0, Lcom/amazon/retailsearch/R$layout;->rs_corrections_spell_corrected:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 29
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_spell_corrected_text:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->header:Landroid/widget/TextView;

    .line 30
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_spell_corrected_detail:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->details:Landroid/widget/TextView;

    .line 31
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 32
    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 6
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    const/16 v5, 0x8

    const/4 v4, 0x0

    .line 37
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getStyledText()Ljava/util/List;

    move-result-object v2

    if-nez v2, :cond_1

    .line 39
    :cond_0
    invoke-virtual {p0, v5}, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->setVisibility(I)V

    .line 59
    :goto_0
    return-void

    .line 42
    :cond_1
    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->setVisibility(I)V

    .line 44
    new-instance v1, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 45
    .local v1, "headerText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getStyledText()Ljava/util/List;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Rs:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 46
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->header:Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 48
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getDetailedStyledText()Ljava/util/List;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 50
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 51
    .local v0, "detailText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;->getDetailedStyledText()Ljava/util/List;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Rs:I

    invoke-virtual {v0, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 52
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->details:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 53
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->details:Landroid/widget/TextView;

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 57
    .end local v0    # "detailText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    :cond_2
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->details:Landroid/widget/TextView;

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic build(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 17
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/SpellCorrectedHeader;->build(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V

    return-void
.end method
