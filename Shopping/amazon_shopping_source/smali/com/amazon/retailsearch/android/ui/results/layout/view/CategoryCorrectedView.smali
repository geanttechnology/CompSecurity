.class public Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;
.super Landroid/widget/LinearLayout;
.source "CategoryCorrectedView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;",
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
    .line 34
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 35
    sget v0, Lcom/amazon/retailsearch/R$layout;->rs_corrections_spell_corrected:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 36
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_spell_corrected_text:I

    invoke-static {p0, v0}, Lcom/amazon/retailsearch/android/ui/ViewHolder;->get(Landroid/view/View;I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;->header:Landroid/widget/TextView;

    .line 37
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 38
    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V
    .locals 5
    .param p1, "categoryCorrected"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .prologue
    .line 43
    const/16 v3, 0x8

    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;->setVisibility(I)V

    .line 44
    if-nez p1, :cond_1

    .line 74
    :cond_0
    :goto_0
    return-void

    .line 49
    :cond_1
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;->getStyledText()Ljava/util/List;

    move-result-object v2

    .line 50
    .local v2, "styledTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;->getSeeMoreLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v0

    .line 52
    .local v0, "seeMoreLink":Lcom/amazon/searchapp/retailsearch/model/Link;
    if-nez v2, :cond_2

    if-eqz v0, :cond_2

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 56
    new-instance v1, Lcom/amazon/searchapp/retailsearch/entity/StyledTextEntity;

    invoke-direct {v1}, Lcom/amazon/searchapp/retailsearch/entity/StyledTextEntity;-><init>()V

    .line 57
    .local v1, "styledText":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    sget-object v3, Lcom/amazon/retailsearch/android/ui/results/RetailSearchResultStyles;->STYLE_LINK:Ljava/lang/String;

    invoke-interface {v1, v3}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->setStyle(Ljava/lang/String;)V

    .line 58
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->setText(Ljava/lang/String;)V

    .line 59
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->setUrl(Ljava/lang/String;)V

    .line 60
    new-instance v2, Ljava/util/ArrayList;

    .end local v2    # "styledTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 61
    .restart local v2    # "styledTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 64
    .end local v1    # "styledText":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    :cond_2
    if-eqz v2, :cond_0

    .line 69
    new-instance v1, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v1, v3, v4}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 70
    .local v1, "styledText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    sget v3, Lcom/amazon/retailsearch/R$style;->Rs:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 71
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;->header:Landroid/widget/TextView;

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 72
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;->header:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 73
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic build(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 27
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/CategoryCorrectedView;->build(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V

    return-void
.end method
