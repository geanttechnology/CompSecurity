.class public Lcom/poshmark/data_model/models/PMBundle;
.super Lcom/poshmark/data_model/models/PMData;
.source "PMBundle.java"


# instance fields
.field discount_message:Ljava/lang/String;

.field discount_percent:I

.field posts:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummary;",
            ">;"
        }
    .end annotation
.end field

.field seller:Lcom/poshmark/data_model/models/inner_models/UserReference;

.field total_discount:Ljava/math/BigDecimal;

.field total_discount_title:Ljava/lang/String;

.field total_original_price:Ljava/math/BigDecimal;

.field total_price:Ljava/math/BigDecimal;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/poshmark/data_model/models/PMData;-><init>()V

    .line 18
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->posts:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 5
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    const/4 v4, 0x0

    .line 32
    iget-object v2, p0, Lcom/poshmark/data_model/models/PMBundle;->posts:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 33
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 34
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSummary;

    .line 35
    .local v1, "listing":Lcom/poshmark/data_model/models/ListingSummary;
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    const/4 v3, 0x1

    aput-object v1, v2, v3

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_0

    .line 37
    .end local v1    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_0
    return-void
.end method

.method public getBundleDiscountMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->discount_message:Ljava/lang/String;

    return-object v0
.end method

.method public getFinalPriceAsString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 57
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->total_price:Ljava/math/BigDecimal;

    if-eqz v0, :cond_0

    .line 58
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMBundle;->total_price:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 61
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummary;",
            ">;"
        }
    .end annotation

    .prologue
    .line 28
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->posts:Ljava/util/List;

    return-object v0
.end method

.method public getListOfPostsInBundle()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 93
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 94
    .local v0, "ids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/poshmark/data_model/models/PMBundle;->posts:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 95
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 96
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/ListingSummary;

    .line 97
    .local v2, "listing":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v3, v2, Lcom/poshmark/data_model/models/ListingSummary;->inventory:Lcom/poshmark/data_model/models/inner_models/Inventory;

    if-eqz v3, :cond_0

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->isAvailableForPurchase()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 98
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 101
    .end local v2    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_1
    return-object v0
.end method

.method public getSavingsAsString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 65
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->total_discount:Ljava/math/BigDecimal;

    if-eqz v0, :cond_0

    .line 66
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/PMBundle;->total_discount:Ljava/math/BigDecimal;

    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 69
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSellerAvataar()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->seller:Lcom/poshmark/data_model/models/inner_models/UserReference;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSellerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->seller:Lcom/poshmark/data_model/models/inner_models/UserReference;

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->seller:Lcom/poshmark/data_model/models/inner_models/UserReference;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserId()Ljava/lang/String;

    move-result-object v0

    .line 76
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSellerUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->seller:Lcom/poshmark/data_model/models/inner_models/UserReference;

    if-eqz v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->seller:Lcom/poshmark/data_model/models/inner_models/UserReference;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserName()Ljava/lang/String;

    move-result-object v0

    .line 85
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getTotalDiscountTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/poshmark/data_model/models/PMBundle;->total_discount_title:Ljava/lang/String;

    return-object v0
.end method

.method public removeUnavailableItems()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummary;",
            ">;"
        }
    .end annotation

    .prologue
    .line 40
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 41
    .local v2, "unavailableItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    iget-object v3, p0, Lcom/poshmark/data_model/models/PMBundle;->posts:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 42
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 43
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSummary;

    .line 44
    .local v1, "listing":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v3, v1, Lcom/poshmark/data_model/models/ListingSummary;->inventory:Lcom/poshmark/data_model/models/inner_models/Inventory;

    if-eqz v3, :cond_0

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->isAvailableForPurchase()Z

    move-result v3

    if-nez v3, :cond_0

    .line 45
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 46
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 49
    .end local v1    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_1
    return-object v2
.end method
