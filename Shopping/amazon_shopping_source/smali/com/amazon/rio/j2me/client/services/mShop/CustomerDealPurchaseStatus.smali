.class public Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;
.super Ljava/lang/Object;
.source "CustomerDealPurchaseStatus.java"


# instance fields
.field private msToExpiry:Ljava/lang/Integer;

.field private state:Ljava/lang/String;

.field private waitListStatus:Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealWaitListStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setMsToExpiry(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;->msToExpiry:Ljava/lang/Integer;

    .line 41
    return-void
.end method

.method public setState(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;->state:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setWaitListStatus(Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealWaitListStatus;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealWaitListStatus;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;->waitListStatus:Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealWaitListStatus;

    .line 54
    return-void
.end method
