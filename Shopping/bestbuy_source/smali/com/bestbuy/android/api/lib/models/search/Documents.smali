.class public Lcom/bestbuy/android/api/lib/models/search/Documents;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private availability:Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

.field private category:Ljava/lang/String;

.field private categoryid:Ljava/lang/String;

.field private condition:Ljava/lang/String;

.field private documenttype:Ljava/lang/String;

.field private priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

.field private skuId:Ljava/lang/String;

.field private skutype:Ljava/lang/String;

.field private summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->category:Ljava/lang/String;

    return-object v0
.end method

.method public getCategoryid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->categoryid:Ljava/lang/String;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getDocumenttype()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->documenttype:Ljava/lang/String;

    return-object v0
.end method

.method public getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    return-object v0
.end method

.method public getSkuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getSkutype()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->skutype:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreAvailability()Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->availability:Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    return-object v0
.end method

.method public getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    return-object v0
.end method

.method public setCategory(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 108
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->category:Ljava/lang/String;

    .line 109
    return-void
.end method

.method public setCategoryid(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 102
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->categoryid:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->condition:Ljava/lang/String;

    .line 115
    return-void
.end method

.method public setDocumenttype(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->documenttype:Ljava/lang/String;

    .line 91
    return-void
.end method

.method public setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->priceBlock:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    .line 131
    return-void
.end method

.method public setSkuid(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->skuId:Ljava/lang/String;

    .line 85
    return-void
.end method

.method public setSkutype(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->skutype:Ljava/lang/String;

    .line 97
    return-void
.end method

.method public setStoreAvailability(Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->availability:Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    .line 42
    return-void
.end method

.method public setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/search/Documents;->summary:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    .line 123
    return-void
.end method
