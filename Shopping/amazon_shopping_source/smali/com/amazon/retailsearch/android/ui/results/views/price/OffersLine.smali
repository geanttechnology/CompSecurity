.class public Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;
.super Landroid/widget/TextView;
.source "OffersLine.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/TextView;",
        "Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;",
        ">;"
    }
.end annotation


# static fields
.field private static final ATTR_IS_PRICE_BACKUP:Ljava/lang/String; = "Rs.Results.Offers.IsPriceBackup"

.field private static final PRICE_STYLED_TEXT:Ljava/lang/String; = "HIGHLIGHT"


# instance fields
.field private final isPriceBackup:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 47
    const-string/jumbo v0, "Rs.Results.Offers.IsPriceBackup"

    const/4 v1, 0x0

    invoke-static {p2, v0, v1}, Lcom/amazon/retailsearch/android/util/ResUtils;->getAttributeBooleanValue(Landroid/util/AttributeSet;Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;->isPriceBackup:Z

    .line 48
    return-void
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 6
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    const/16 v5, 0x8

    .line 56
    if-nez p1, :cond_0

    .line 58
    invoke-virtual {p0, v5}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;->setVisibility(I)V

    .line 83
    :goto_0
    return-void

    .line 62
    :cond_0
    new-instance v1, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v1, p2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 63
    .local v1, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;->getStyledText()Ljava/util/List;

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

    .line 65
    .local v2, "styledText":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    const-string/jumbo v3, "HIGHLIGHT"

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getStyle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 68
    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getText()Ljava/lang/String;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$style;->Results_OffersPrice:I

    invoke-virtual {v1, v3, v4}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    goto :goto_1

    .line 72
    :cond_1
    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/StyledText;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    goto :goto_1

    .line 75
    .end local v2    # "styledText":Lcom/amazon/searchapp/retailsearch/model/StyledText;
    :cond_2
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 77
    invoke-virtual {p0, v5}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;->setVisibility(I)V

    goto :goto_0

    .line 81
    :cond_3
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;->setText(Ljava/lang/CharSequence;)V

    .line 82
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 24
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method

.method public getIsPriceBackup()Z
    .locals 1

    .prologue
    .line 36
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/OffersLine;->isPriceBackup:Z

    return v0
.end method
