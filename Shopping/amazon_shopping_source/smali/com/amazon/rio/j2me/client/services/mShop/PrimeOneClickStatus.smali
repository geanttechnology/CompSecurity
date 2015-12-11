.class public Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;
.super Ljava/lang/Object;
.source "PrimeOneClickStatus.java"


# instance fields
.field private isOneClickEnabled:Z

.field private isPrime:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getIsOneClickEnabled()Z
    .locals 1

    .prologue
    .line 28
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->isOneClickEnabled:Z

    return v0
.end method

.method public getIsPrime()Z
    .locals 1

    .prologue
    .line 18
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->isPrime:Z

    return v0
.end method

.method public setIsOneClickEnabled(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->isOneClickEnabled:Z

    .line 34
    return-void
.end method

.method public setIsPrime(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 23
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->isPrime:Z

    .line 24
    return-void
.end method
