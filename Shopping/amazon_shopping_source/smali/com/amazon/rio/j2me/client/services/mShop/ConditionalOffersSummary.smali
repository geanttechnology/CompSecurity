.class public Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;
.super Ljava/lang/Object;
.source "ConditionalOffersSummary.java"


# instance fields
.field private condition:Ljava/lang/String;

.field private conditionType:Ljava/lang/String;

.field private summary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getConditionType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->conditionType:Ljava/lang/String;

    return-object v0
.end method

.method public getSummary()Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->summary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    return-object v0
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->condition:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setConditionType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->conditionType:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setSummary(Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ConditionalOffersSummary;->summary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    .line 45
    return-void
.end method
