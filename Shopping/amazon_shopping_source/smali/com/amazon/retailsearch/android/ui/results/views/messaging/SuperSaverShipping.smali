.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;
.super Landroid/widget/TextView;
.source "SuperSaverShipping.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/TextView;",
        "Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;",
        ">;"
    }
.end annotation


# instance fields
.field context:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 35
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;->context:Landroid/content/Context;

    .line 36
    return-void
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 4
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    const/16 v3, 0x8

    .line 44
    if-nez p1, :cond_0

    .line 46
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;->setVisibility(I)V

    .line 60
    :goto_0
    return-void

    .line 50
    :cond_0
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;->context:Landroid/content/Context;

    invoke-direct {v0, p2, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 51
    .local v0, "ss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;->getSuperSaverShippingStyledText()Ljava/util/List;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$style;->Results_SuperSaverShipping:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 52
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 54
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;->setVisibility(I)V

    goto :goto_0

    .line 58
    :cond_1
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;->setText(Ljava/lang/CharSequence;)V

    .line 59
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 23
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShipping;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method
