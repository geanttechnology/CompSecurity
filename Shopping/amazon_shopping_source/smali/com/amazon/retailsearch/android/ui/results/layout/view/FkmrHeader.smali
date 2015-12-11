.class public Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;
.super Landroid/widget/LinearLayout;
.source "FkmrHeader.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/FKMR;",
        ">;"
    }
.end annotation


# static fields
.field private static final HIGHLIGHT:Ljava/lang/String; = "HIGHLIGHT"


# instance fields
.field private final keywords:Landroid/widget/TextView;

.field private final link:Landroid/widget/TextView;

.field private final noResultHeader:Landroid/widget/TextView;

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
    .line 35
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 36
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 38
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->setOrientation(I)V

    .line 39
    sget v0, Lcom/amazon/retailsearch/R$layout;->rs_corrections_fkmr_header:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 40
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_fkmr_no_results:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->noResultHeader:Landroid/widget/TextView;

    .line 41
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_fkmr_keywords:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->keywords:Landroid/widget/TextView;

    .line 42
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_fkmr_see_all:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->link:Landroid/widget/TextView;

    .line 43
    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V
    .locals 9
    .param p1, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;

    .prologue
    const/16 v7, 0x8

    const/4 v8, 0x0

    .line 48
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getKeywords()Ljava/util/List;

    move-result-object v6

    if-nez v6, :cond_1

    .line 50
    :cond_0
    invoke-virtual {p0, v7}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->setVisibility(I)V

    .line 104
    :goto_0
    return-void

    .line 53
    :cond_1
    invoke-virtual {p0, v8}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->setVisibility(I)V

    .line 56
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getStyledText()Ljava/util/List;

    move-result-object v6

    if-eqz v6, :cond_2

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getStyledText()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_2

    .line 58
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->noResultHeader:Landroid/widget/TextView;

    invoke-virtual {v6, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 59
    new-instance v1, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v6

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-direct {v1, v6, v7}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 60
    .local v1, "headerText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getStyledText()Ljava/util/List;

    move-result-object v6

    sget v7, Lcom/amazon/retailsearch/R$style;->Rs:I

    invoke-virtual {v1, v6, v7}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 61
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->noResultHeader:Landroid/widget/TextView;

    invoke-virtual {v6, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 69
    .end local v1    # "headerText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    :goto_1
    new-instance v4, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v6

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-direct {v4, v6, v7}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 70
    .local v4, "keywordText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getKeywords()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/searchapp/retailsearch/model/StyledText;

    .line 72
    .local v3, "keyword":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    const-string/jumbo v6, "HIGHLIGHT"

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getStyle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 74
    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getText()Ljava/lang/String;

    move-result-object v6

    sget v7, Lcom/amazon/retailsearch/R$style;->Rs_Corrections_FKMR_Keywords_Span:I

    invoke-virtual {v4, v6, v7}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    goto :goto_2

    .line 65
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "keyword":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    .end local v4    # "keywordText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    :cond_2
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->noResultHeader:Landroid/widget/TextView;

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 78
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v3    # "keyword":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    .restart local v4    # "keywordText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    :cond_3
    sget v6, Lcom/amazon/retailsearch/R$style;->Rs:I

    invoke-virtual {v4, v3, v6}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Lcom/amazon/searchapp/retailsearch/model/StyledText;I)V

    goto :goto_2

    .line 81
    .end local v3    # "keyword":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    :cond_4
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->keywords:Landroid/widget/TextView;

    invoke-virtual {v6, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 84
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getSeeAllLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v6

    if-eqz v6, :cond_5

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getSeeAllLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_5

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getSeeAllLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 87
    :cond_5
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->link:Landroid/widget/TextView;

    const-string/jumbo v7, ""

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 91
    :cond_6
    new-instance v5, Landroid/text/SpannableStringBuilder;

    invoke-direct {v5}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 92
    .local v5, "linkText":Landroid/text/SpannableStringBuilder;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/FKMR;->getSeeAllLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 93
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader$1;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-direct {v0, p0, v6, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader$1;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;Landroid/content/res/Resources;Lcom/amazon/searchapp/retailsearch/model/FKMR;)V

    .line 101
    .local v0, "clickSpan":Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;
    invoke-virtual {v5}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v6

    invoke-virtual {v5, v0, v8, v6, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 102
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->link:Landroid/widget/TextView;

    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 103
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->link:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    goto/16 :goto_0
.end method

.method public bridge synthetic build(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 24
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/FKMR;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/FkmrHeader;->build(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V

    return-void
.end method
