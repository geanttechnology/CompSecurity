.class public Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;
.super Landroid/widget/TextView;
.source "ForcedPrime.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/TextView;",
        "Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;",
        ">;"
    }
.end annotation


# static fields
.field private static final NEW_LINE:Ljava/lang/String;

.field private static final PRICE_STYLED_TEXT:Ljava/lang/String; = "HIGHLIGHT"


# instance fields
.field private model:Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-string/jumbo v0, "line.separator"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->NEW_LINE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 48
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 49
    return-void
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 5
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 57
    if-nez p1, :cond_0

    .line 59
    const/16 v3, 0x8

    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->setVisibility(I)V

    .line 86
    :goto_0
    return-void

    .line 62
    :cond_0
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;

    .line 64
    new-instance v1, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v1, p2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 65
    .local v1, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->getLowerPriceMessage()Ljava/lang/String;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$style;->Results_ForcedPrimeLowerPriceLink:I

    invoke-virtual {v1, v3, v4}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 67
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->getPriceAndLabel()Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_2

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->getPriceAndLabel()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_2

    .line 69
    sget-object v3, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->NEW_LINE:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    .line 70
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->getPriceAndLabel()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/searchapp/retailsearch/model/StyledText;

    .line 72
    .local v2, "styledText":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    const-string/jumbo v3, "HIGHLIGHT"

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getStyle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 75
    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getText()Ljava/lang/String;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$style;->Results_ForcedPrimePrice:I

    invoke-virtual {v1, v3, v4}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    goto :goto_1

    .line 79
    :cond_1
    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    goto :goto_1

    .line 84
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "styledText":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    :cond_2
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->setText(Ljava/lang/CharSequence;)V

    .line 85
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 29
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method

.method public getView()Landroid/view/View;
    .locals 0

    .prologue
    .line 110
    return-object p0
.end method

.method public handleSingleTap()V
    .locals 5

    .prologue
    .line 95
    new-instance v1, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;-><init>()V

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->getAsin()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->getUrl()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrimeModel;->getProductGroup()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;->build(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    move-result-object v0

    .line 101
    .local v0, "resultItem":Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/ForcedPrime;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    sget-object v2, Lcom/amazon/retailsearch/metrics/DetailPageType;->FORCED_PRIME:Lcom/amazon/retailsearch/metrics/DetailPageType;

    invoke-interface {v1, v0, v2}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->resultItemSelected(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;Lcom/amazon/retailsearch/metrics/DetailPageType;)V

    .line 102
    return-void
.end method
