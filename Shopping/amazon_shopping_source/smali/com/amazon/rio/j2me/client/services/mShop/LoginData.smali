.class public Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
.super Ljava/lang/Object;
.source "LoginData.java"


# instance fields
.field private dob:Lcom/amazon/rio/j2me/client/services/mShop/Date;

.field private fullName:Ljava/lang/String;

.field private givenName:Ljava/lang/String;

.field private isPrimeFunnelEligible:Ljava/lang/Boolean;

.field private primeFunnelUrl:Ljava/lang/String;

.field private primeOneClickStatus:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDob()Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->dob:Lcom/amazon/rio/j2me/client/services/mShop/Date;

    return-object v0
.end method

.method public getFullName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->fullName:Ljava/lang/String;

    return-object v0
.end method

.method public getIsPrimeFunnelEligible()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->isPrimeFunnelEligible:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getPrimeFunnelUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->primeFunnelUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->primeOneClickStatus:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    return-object v0
.end method

.method public setDob(Lcom/amazon/rio/j2me/client/services/mShop/Date;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Date;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->dob:Lcom/amazon/rio/j2me/client/services/mShop/Date;

    .line 64
    return-void
.end method

.method public setFullName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->fullName:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setGivenName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->givenName:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setIsPrimeFunnelEligible(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->isPrimeFunnelEligible:Ljava/lang/Boolean;

    .line 77
    return-void
.end method

.method public setPrimeFunnelUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->primeFunnelUrl:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->primeOneClickStatus:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    .line 28
    return-void
.end method
