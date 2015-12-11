.class public Lcom/bestbuy/android/api/lib/models/pdpaccessories/SuggestedAccessories;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

.field private summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SuggestedAccessories;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    return-object v0
.end method

.method public getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SuggestedAccessories;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    return-object v0
.end method

.method public setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SuggestedAccessories;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    .line 33
    return-void
.end method

.method public setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SuggestedAccessories;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    .line 25
    return-void
.end method
