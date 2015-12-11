.class public Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;
.super Ljava/lang/Object;
.source "KiangUpdateRequest.java"


# instance fields
.field private applicationState:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;

.field private security:Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getApplicationState()Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;->applicationState:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;

    return-object v0
.end method

.method public getSecurity()Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;->security:Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;

    return-object v0
.end method

.method public setApplicationState(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;->applicationState:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;

    .line 37
    return-void
.end method

.method public setSecurity(Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;->security:Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;

    .line 27
    return-void
.end method
