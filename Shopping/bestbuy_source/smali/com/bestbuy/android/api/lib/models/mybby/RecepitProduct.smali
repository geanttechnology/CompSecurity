.class public Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;
.super Lcom/bestbuy/android/api/lib/models/mybby/Transaction;
.source "SourceFile"


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private category:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private productImage:Ljava/lang/String;

.field private productName:Ljava/lang/String;

.field private purchaseDate:Ljava/lang/String;

.field private sku:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;-><init>()V

    return-void
.end method


# virtual methods
.method public fetchImage(Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 97
    return-void
.end method

.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->category:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstDetail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    const/4 v0, 0x0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    const/4 v0, 0x0

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getProductImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->productImage:Ljava/lang/String;

    return-object v0
.end method

.method public getProductName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->productName:Ljava/lang/String;

    return-object v0
.end method

.method public getPurchaseDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->purchaseDate:Ljava/lang/String;

    return-object v0
.end method

.method public getSecondDetail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    const/4 v0, 0x0

    return-object v0
.end method

.method public getSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->sku:Ljava/lang/String;

    return-object v0
.end method

.method public setCategory(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->category:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setFirstDetail()V
    .locals 0

    .prologue
    .line 87
    return-void
.end method

.method public setName()V
    .locals 0

    .prologue
    .line 83
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->price:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setProductImage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->productImage:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setProductName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->productName:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setPurchaseDate(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->purchaseDate:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setSecondDetail()V
    .locals 0

    .prologue
    .line 91
    return-void
.end method

.method public setSku(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/RecepitProduct;->sku:Ljava/lang/String;

    .line 48
    return-void
.end method
