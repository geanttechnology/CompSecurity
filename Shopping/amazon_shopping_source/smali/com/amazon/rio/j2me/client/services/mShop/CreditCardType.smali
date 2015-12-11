.class public Lcom/amazon/rio/j2me/client/services/mShop/CreditCardType;
.super Ljava/lang/Object;
.source "CreditCardType.java"


# instance fields
.field private name:Ljava/lang/String;

.field private typeKey:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CreditCardType;->name:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setTypeKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CreditCardType;->typeKey:Ljava/lang/String;

    .line 34
    return-void
.end method
