.class public Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealWaitListStatus;
.super Ljava/lang/Object;
.source "CustomerDealWaitListStatus.java"


# instance fields
.field private inCartIndicator:Ljava/lang/String;

.field private position:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setInCartIndicator(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealWaitListStatus;->inCartIndicator:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setPosition(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealWaitListStatus;->position:Ljava/lang/Integer;

    .line 40
    return-void
.end method
