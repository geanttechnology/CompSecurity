.class public abstract Lcom/amazon/retailsearch/android/ui/results/views/price/Price;
.super Landroid/widget/LinearLayout;
.source "Price.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;",
        ">;"
    }
.end annotation


# static fields
.field private static final ATTR_HIDE_BADGES:Ljava/lang/String; = "Rs.Results.Price.HideBadges"

.field private static final ATTR_SHOW_LIST_PRICE:Ljava/lang/String; = "Rs.Results.Price.ShowListPrice"

.field private static final ATTR_SHOW_SOME_PRIME:Ljava/lang/String; = "Rs.Results.Price.ShowSomePrimeMsg"


# instance fields
.field private context:Landroid/content/Context;

.field private hideBadges:Z

.field private model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

.field protected priceLineList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/widget/TextView;",
            ">;"
        }
    .end annotation
.end field

.field private res:Landroid/content/res/Resources;

.field retailSearchDataProvider:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private showListPrice:Z

.field private showSomePrime:Z

.field protected somePrimeLine:Landroid/widget/TextView;

.field protected sponsoredProductLine:Landroid/widget/TextView;

.field private viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    .line 74
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 46
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x3

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->priceLineList:Ljava/util/List;

    .line 75
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->context:Landroid/content/Context;

    .line 76
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->res:Landroid/content/res/Resources;

    .line 77
    const-string/jumbo v0, "Rs.Results.Price.ShowListPrice"

    invoke-static {p2, v0, v2}, Lcom/amazon/retailsearch/android/util/ResUtils;->getAttributeBooleanValue(Landroid/util/AttributeSet;Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->showListPrice:Z

    .line 78
    const-string/jumbo v0, "Rs.Results.Price.ShowSomePrimeMsg"

    invoke-static {p2, v0, v2}, Lcom/amazon/retailsearch/android/util/ResUtils;->getAttributeBooleanValue(Landroid/util/AttributeSet;Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->showSomePrime:Z

    .line 79
    const-string/jumbo v0, "Rs.Results.Price.HideBadges"

    invoke-static {p2, v0, v2}, Lcom/amazon/retailsearch/android/util/ResUtils;->getAttributeBooleanValue(Landroid/util/AttributeSet;Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->hideBadges:Z

    .line 80
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 81
    return-void
.end method

.method private buildAdditionalPriceMsgs()V
    .locals 4

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 142
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->somePrimeLine:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getSomePrimeMsg()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 146
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->somePrimeLine:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getSomePrimeMsg()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 147
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->somePrimeLine:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 156
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->sponsoredProductLine:Landroid/widget/TextView;

    if-eqz v0, :cond_1

    .line 158
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getSponsoredPriceMsg()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 160
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->sponsoredProductLine:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getSponsoredPriceMsg()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 161
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->sponsoredProductLine:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 168
    :cond_1
    :goto_1
    return-void

    .line 151
    :cond_2
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->somePrimeLine:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 165
    :cond_3
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->sponsoredProductLine:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method private buildEditionsPrices()V
    .locals 9

    .prologue
    .line 223
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v7}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getEditions()Ljava/util/List;

    move-result-object v1

    .line 226
    .local v1, "editions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->priceLineList:Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-ge v2, v7, :cond_2

    .line 228
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->priceLineList:Ljava/util/List;

    invoke-interface {v7, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 229
    .local v6, "textView":Landroid/widget/TextView;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    if-lt v2, v7, :cond_1

    .line 232
    :cond_0
    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 226
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 236
    :cond_1
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;

    .line 237
    .local v0, "edition":Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;->getPrice()Ljava/lang/String;

    move-result-object v4

    .line 238
    .local v4, "priceStr":Ljava/lang/String;
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;->getLabel()Ljava/lang/String;

    move-result-object v3

    .line 240
    .local v3, "linkText":Ljava/lang/String;
    new-instance v5, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->context:Landroid/content/Context;

    invoke-direct {v5, v7, v8}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 241
    .local v5, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, " "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$style;->Results_PriceSpan:I

    invoke-virtual {v5, v7, v8}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 242
    sget v7, Lcom/amazon/retailsearch/R$style;->Results_EditionPriceLabelSpan:I

    invoke-virtual {v5, v3, v7}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 243
    invoke-direct {p0, v6, v5}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->setText(Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;)V

    goto :goto_1

    .line 245
    .end local v0    # "edition":Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel$UIPriceInfo;
    .end local v3    # "linkText":Ljava/lang/String;
    .end local v4    # "priceStr":Ljava/lang/String;
    .end local v5    # "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    .end local v6    # "textView":Landroid/widget/TextView;
    :cond_2
    return-void
.end method

.method private buildRegularPrices(Landroid/widget/TextView;)V
    .locals 5
    .param p1, "textView"    # Landroid/widget/TextView;

    .prologue
    .line 176
    new-instance v1, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->context:Landroid/content/Context;

    invoke-direct {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 179
    .local v1, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getMapTextId()Ljava/lang/Integer;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 182
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->res:Landroid/content/res/Resources;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getMapTextId()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Results_MapPriceSpan:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 210
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getBadgeId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-boolean v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->hideBadges:Z

    if-nez v2, :cond_1

    .line 212
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getBadgeId()Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Results_PriceBadgeSpan:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->appendBadge(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 215
    :cond_1
    invoke-direct {p0, p1, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->setText(Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;)V

    .line 216
    return-void

    .line 186
    :cond_2
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getPrice()Ljava/lang/String;

    move-result-object v0

    .line 187
    .local v0, "priceStr":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 190
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Results_PriceSpan:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 193
    :cond_3
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getUnitOrIssuePrice()Ljava/lang/String;

    move-result-object v0

    .line 194
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 197
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Results_UnitPriceSpan:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 201
    :cond_4
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getListPrice()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 203
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getListPrice()Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Results_ListPriceSpan:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 205
    const-string/jumbo v2, " "

    sget v3, Lcom/amazon/retailsearch/R$style;->Results_PriceSpan:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    goto/16 :goto_0
.end method

.method private setText(Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;)V
    .locals 1
    .param p1, "textView"    # Landroid/widget/TextView;
    .param p2, "ssb"    # Landroid/text/SpannableStringBuilder;

    .prologue
    .line 255
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 257
    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 263
    :goto_0
    return-void

    .line 261
    :cond_0
    sget-object v0, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p1, p2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 262
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 4
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 107
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 109
    :cond_0
    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->setVisibility(I)V

    .line 133
    :goto_0
    return-void

    .line 112
    :cond_1
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->model:Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    .line 113
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 115
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;->getUseEditions()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 117
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->buildEditionsPrices()V

    .line 130
    :cond_2
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->buildAdditionalPriceMsgs()V

    .line 132
    invoke-virtual {p0, v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->setVisibility(I)V

    goto :goto_0

    .line 122
    :cond_3
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->priceLineList:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->buildRegularPrices(Landroid/widget/TextView;)V

    .line 124
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->priceLineList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 126
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->priceLineList:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 124
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 38
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/PriceModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method

.method public getShowListPrice()Z
    .locals 1

    .prologue
    .line 270
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->showListPrice:Z

    return v0
.end method

.method public getShowSomePrime()Z
    .locals 1

    .prologue
    .line 278
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->showSomePrime:Z

    return v0
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 90
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 91
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->postInflate()V

    .line 92
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_results_price_sponsored_msg:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/Price;->sponsoredProductLine:Landroid/widget/TextView;

    .line 93
    return-void
.end method

.method protected abstract postInflate()V
.end method
