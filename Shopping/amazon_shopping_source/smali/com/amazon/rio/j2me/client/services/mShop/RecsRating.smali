.class public Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;
.super Ljava/lang/Object;
.source "RecsRating.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private number:Ljava/lang/Integer;

.field private type:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getNumber()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;->number:Ljava/lang/Integer;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 29
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;->type:I

    return v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;->asin:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setType(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 34
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;->type:I

    .line 35
    return-void
.end method
