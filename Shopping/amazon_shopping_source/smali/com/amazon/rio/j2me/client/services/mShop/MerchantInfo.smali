.class public Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
.super Ljava/lang/Object;
.source "MerchantInfo.java"


# instance fields
.field private isAmazon:Ljava/lang/Boolean;

.field private logo:Ljava/lang/String;

.field private merchantId:Ljava/lang/String;

.field private merchantName:Ljava/lang/String;

.field private sellerDetailsPageUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getIsAmazon()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->isAmazon:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getMerchantId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->merchantId:Ljava/lang/String;

    return-object v0
.end method

.method public getMerchantName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->merchantName:Ljava/lang/String;

    return-object v0
.end method

.method public setIsAmazon(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->isAmazon:Ljava/lang/Boolean;

    .line 76
    return-void
.end method

.method public setLogo(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->logo:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setMerchantId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->merchantId:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setMerchantName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->merchantName:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setSellerDetailsPageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->sellerDetailsPageUrl:Ljava/lang/String;

    .line 63
    return-void
.end method
