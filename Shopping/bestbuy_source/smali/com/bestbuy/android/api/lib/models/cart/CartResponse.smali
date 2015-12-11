.class public Lcom/bestbuy/android/api/lib/models/cart/CartResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private cartId:Ljava/lang/String;

.field private commerceItemId:Ljava/lang/String;

.field private cookieHeaders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private error:Z

.field private isHaccs:Z

.field private isICR:Z

.field private msg:Ljava/lang/String;

.field private productId:Ljava/lang/String;

.field private quantity:I

.field private skuId:Ljava/lang/String;

.field private tryagainMsg:Z

.field private userId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCartId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->cartId:Ljava/lang/String;

    return-object v0
.end method

.method public getCommerceItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->commerceItemId:Ljava/lang/String;

    return-object v0
.end method

.method public getCookieHeaders()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->cookieHeaders:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->msg:Ljava/lang/String;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getQuantity()I
    .locals 1

    .prologue
    .line 51
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->quantity:I

    return v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->userId:Ljava/lang/String;

    return-object v0
.end method

.method public isError()Z
    .locals 1

    .prologue
    .line 43
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->error:Z

    return v0
.end method

.method public isHaccs()Z
    .locals 1

    .prologue
    .line 107
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->isHaccs:Z

    return v0
.end method

.method public isICR()Z
    .locals 1

    .prologue
    .line 115
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->isICR:Z

    return v0
.end method

.method public isTryagainMsg()Z
    .locals 1

    .prologue
    .line 75
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->tryagainMsg:Z

    return v0
.end method

.method public setCartId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->cartId:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setCommerceItemId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->commerceItemId:Ljava/lang/String;

    .line 96
    return-void
.end method

.method public setCookieHeaders(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->cookieHeaders:Ljava/util/ArrayList;

    .line 40
    return-void
.end method

.method public setError(Z)V
    .locals 0

    .prologue
    .line 47
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->error:Z

    .line 48
    return-void
.end method

.method public setIsHaccs(Z)V
    .locals 0

    .prologue
    .line 111
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->isHaccs:Z

    .line 112
    return-void
.end method

.method public setIsICR(Z)V
    .locals 0

    .prologue
    .line 119
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->isICR:Z

    .line 120
    return-void
.end method

.method public setMsg(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->msg:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setProductId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 103
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->productId:Ljava/lang/String;

    .line 104
    return-void
.end method

.method public setQuantity(I)V
    .locals 0

    .prologue
    .line 55
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->quantity:I

    .line 56
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->skuId:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setTryagainMsg(Z)V
    .locals 0

    .prologue
    .line 79
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->tryagainMsg:Z

    .line 80
    return-void
.end method

.method public setUserId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;->userId:Ljava/lang/String;

    .line 72
    return-void
.end method
