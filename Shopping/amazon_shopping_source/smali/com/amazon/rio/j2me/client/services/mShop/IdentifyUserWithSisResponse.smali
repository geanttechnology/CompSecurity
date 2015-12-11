.class public Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisResponse;
.super Ljava/lang/Object;
.source "IdentifyUserWithSisResponse.java"


# instance fields
.field private calledSisSuccessfully:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setCalledSisSuccessfully(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 22
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisResponse;->calledSisSuccessfully:Z

    .line 23
    return-void
.end method
