.class public Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;
.super Ljava/lang/Object;
.source "SpecialOffer.java"


# instance fields
.field private instructions:Ljava/lang/String;

.field private offer:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setInstructions(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;->instructions:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setOffer(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SpecialOffer;->offer:Ljava/lang/String;

    .line 24
    return-void
.end method
