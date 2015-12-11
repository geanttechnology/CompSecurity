.class public Lcom/amazon/rio/j2me/client/services/mShop/Date;
.super Ljava/lang/Object;
.source "Date.java"


# instance fields
.field private day:I

.field private month:I

.field private year:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDay()I
    .locals 1

    .prologue
    .line 39
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Date;->day:I

    return v0
.end method

.method public getMonth()I
    .locals 1

    .prologue
    .line 29
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Date;->month:I

    return v0
.end method

.method public getYear()I
    .locals 1

    .prologue
    .line 19
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Date;->year:I

    return v0
.end method

.method public setDay(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 44
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Date;->day:I

    .line 45
    return-void
.end method

.method public setMonth(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 34
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Date;->month:I

    .line 35
    return-void
.end method

.method public setYear(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 24
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Date;->year:I

    .line 25
    return-void
.end method
