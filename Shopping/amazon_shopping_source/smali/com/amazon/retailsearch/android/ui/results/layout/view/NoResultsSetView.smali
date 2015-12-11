.class public Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;
.super Landroid/widget/LinearLayout;
.source "NoResultsSetView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;",
        ">;"
    }
.end annotation


# instance fields
.field private final header:Landroid/widget/TextView;

.field private final label:Landroid/widget/TextView;

.field preferenceManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;
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
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->setOrientation(I)V

    .line 37
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 38
    sget v0, Lcom/amazon/retailsearch/R$layout;->rs_corrections_no_results:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 39
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_no_result_header:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->header:Landroid/widget/TextView;

    .line 40
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_no_result_label:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->label:Landroid/widget/TextView;

    .line 41
    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
    .locals 5
    .param p1, "model"    # Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 46
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;->getLabel()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;->getStyledText()Ljava/util/List;

    move-result-object v1

    if-nez v1, :cond_1

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;->getStyledText()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 49
    :cond_0
    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->setVisibility(I)V

    .line 75
    :goto_0
    return-void

    .line 52
    :cond_1
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->setVisibility(I)V

    .line 54
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->preferenceManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 55
    .local v0, "styledText":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;->getStyledText()Ljava/util/List;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$style;->Rs:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 56
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 58
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->header:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 59
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->header:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 66
    :goto_1
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;->getLabel()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 68
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->label:Landroid/widget/TextView;

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;->getLabel()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 69
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->label:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 63
    :cond_2
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->header:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 73
    :cond_3
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->label:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic build(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 27
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView;->build(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V

    return-void
.end method
