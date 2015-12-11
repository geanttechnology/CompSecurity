.class public Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;
.super Ljava/lang/Object;
.source "KiangUpdateResponse.java"


# instance fields
.field private resetRegistration:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResetRegistration()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;->resetRegistration:Ljava/lang/Boolean;

    return-object v0
.end method

.method public setResetRegistration(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;->resetRegistration:Ljava/lang/Boolean;

    .line 26
    return-void
.end method
