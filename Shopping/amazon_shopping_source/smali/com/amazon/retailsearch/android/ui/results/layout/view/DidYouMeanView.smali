.class public Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;
.super Landroid/widget/LinearLayout;
.source "DidYouMeanView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/DidYouMean;",
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

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 33
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->setOrientation(I)V

    .line 34
    sget v0, Lcom/amazon/retailsearch/R$layout;->rs_corrections_did_you_mean:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 35
    sget v0, Lcom/amazon/retailsearch/R$id;->did_you_mean_text:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->header:Landroid/widget/TextView;

    .line 36
    sget v0, Lcom/amazon/retailsearch/R$id;->did_you_mean_detailed_text:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->details:Landroid/widget/TextView;

    .line 37
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 38
    return-void
.end method

.method private highConfidence(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
    .locals 4
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    .line 103
    new-instance v1, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 104
    .local v1, "headerText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getFormattedLabel()Ljava/util/List;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Rs:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 105
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->header:Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 106
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->header:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 108
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getFormattedOriginalQueryLabel()Ljava/util/List;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getFormattedOriginalQueryLabel()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 110
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 111
    .local v0, "detailText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getFormattedOriginalQueryLabel()Ljava/util/List;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Rs:I

    invoke-virtual {v0, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 112
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->details:Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 113
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->details:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 114
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->details:Landroid/widget/TextView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 120
    .end local v0    # "detailText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    :goto_0
    return-void

    .line 118
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->details:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method private lowConfidence(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
    .locals 8
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 67
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getLabel()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getCorrectedQuery()Ljava/util/List;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getCorrectedQuery()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 70
    :cond_0
    invoke-virtual {p0, v7}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->setVisibility(I)V

    .line 94
    :goto_0
    return-void

    .line 74
    :cond_1
    new-instance v3, Landroid/text/SpannableStringBuilder;

    invoke-direct {v3}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 75
    .local v3, "ssb":Landroid/text/SpannableStringBuilder;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getLabel()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 76
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getCorrectedQuery()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 77
    .local v1, "correctedQuery":Lcom/amazon/searchapp/retailsearch/model/Link;
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$1;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-direct {v0, p0, v4, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView$1;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;Landroid/content/res/Resources;Lcom/amazon/searchapp/retailsearch/model/Link;)V

    .line 88
    .local v0, "clickSpan":Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "\""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "\""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 89
    .local v2, "correctedQueryText":Ljava/lang/String;
    invoke-virtual {v3, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 90
    invoke-virtual {v3}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v4

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    sub-int/2addr v4, v5

    invoke-virtual {v3}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v5

    invoke-virtual {v3, v0, v4, v5, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 91
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->header:Landroid/widget/TextView;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->header:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 93
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->details:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
    .locals 1
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    .line 43
    if-nez p1, :cond_0

    .line 45
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->setVisibility(I)V

    .line 58
    :goto_0
    return-void

    .line 48
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->setVisibility(I)V

    .line 50
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getFormattedLabel()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;->getFormattedLabel()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 52
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->highConfidence(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V

    goto :goto_0

    .line 56
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->lowConfidence(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V

    goto :goto_0
.end method

.method public bridge synthetic build(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 23
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/DidYouMeanView;->build(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V

    return-void
.end method
