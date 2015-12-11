.class public Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;
.super Ljava/lang/Object;
.source "LogoutResponse.java"


# instance fields
.field private failureMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getFailureMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;->failureMessage:Ljava/lang/String;

    return-object v0
.end method

.method public setFailureMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;->failureMessage:Ljava/lang/String;

    .line 26
    return-void
.end method
