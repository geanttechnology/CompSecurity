.class public Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponse;
.super Ljava/lang/Object;
.source "GetOneClickBasicInfoResponse.java"


# instance fields
.field private city:Ljava/lang/String;

.field private fullName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponse;->city:Ljava/lang/String;

    return-object v0
.end method

.method public getFullName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponse;->fullName:Ljava/lang/String;

    return-object v0
.end method

.method public setCity(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponse;->city:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setFullName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponse;->fullName:Ljava/lang/String;

    .line 27
    return-void
.end method
