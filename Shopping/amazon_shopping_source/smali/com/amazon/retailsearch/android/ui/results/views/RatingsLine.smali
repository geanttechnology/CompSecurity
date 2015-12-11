.class public Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;
.super Landroid/widget/TextView;
.source "RatingsLine.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/TextView;",
        "Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 34
    return-void
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 4
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 42
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 44
    :cond_0
    const/16 v1, 0x8

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;->setVisibility(I)V

    .line 57
    :goto_0
    return-void

    .line 48
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p2, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 50
    .local v0, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->getStarsDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->getAccessibilityText()Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Results_Ratings:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->appendImage(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 52
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->getReviewCountText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$style;->Results_Ratings:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 54
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;->setText(Ljava/lang/CharSequence;)V

    .line 56
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 24
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLine;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method
