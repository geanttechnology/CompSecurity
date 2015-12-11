.class public Lcom/amazon/mShop/opl/PurchaseParams;
.super Ljava/lang/Object;
.source "PurchaseParams.java"


# instance fields
.field private mAsin:Ljava/lang/String;

.field private mCheckoutUrl:Ljava/lang/String;

.field private mClickStreamOrigin:Ljava/lang/String;

.field private mDealId:Ljava/lang/String;

.field private mIsCartPurchase:Z

.field private mListId:Ljava/lang/String;

.field private mListItemId:Ljava/lang/String;

.field private mOfferId:Ljava/lang/String;

.field private mOneClickShippingSpeed:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "offerId"    # Ljava/lang/String;
    .param p3, "listId"    # Ljava/lang/String;
    .param p4, "listItemId"    # Ljava/lang/String;
    .param p5, "dealId"    # Ljava/lang/String;
    .param p6, "oneClickShippingSpeed"    # Ljava/lang/String;
    .param p7, "clickStreamOrigin"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p1, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mAsin:Ljava/lang/String;

    .line 38
    iput-object p2, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mOfferId:Ljava/lang/String;

    .line 39
    iput-object p3, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mListId:Ljava/lang/String;

    .line 40
    iput-object p4, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mListItemId:Ljava/lang/String;

    .line 41
    iput-object p5, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mDealId:Ljava/lang/String;

    .line 42
    iput-object p6, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mOneClickShippingSpeed:Ljava/lang/String;

    .line 43
    iput-object p7, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mClickStreamOrigin:Ljava/lang/String;

    .line 44
    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mAsin:Ljava/lang/String;

    return-object v0
.end method

.method public getCheckoutUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mCheckoutUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mClickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getListId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mListId:Ljava/lang/String;

    return-object v0
.end method

.method public getListItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mListItemId:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mOfferId:Ljava/lang/String;

    return-object v0
.end method

.method public getOneClickShippingSpeed()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mOneClickShippingSpeed:Ljava/lang/String;

    return-object v0
.end method

.method public isCartPurchase()Z
    .locals 1

    .prologue
    .line 114
    iget-boolean v0, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mIsCartPurchase:Z

    return v0
.end method

.method public setCheckoutUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "checkoutUrl"    # Ljava/lang/String;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mCheckoutUrl:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public setIsCartPurchase(Z)V
    .locals 0
    .param p1, "isCartPurchase"    # Z

    .prologue
    .line 118
    iput-boolean p1, p0, Lcom/amazon/mShop/opl/PurchaseParams;->mIsCartPurchase:Z

    .line 119
    return-void
.end method
