.class public Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;
.super Ljava/lang/Object;
.source "KiangApplicationState.java"


# instance fields
.field private applicationInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

.field private applicationInstallId:Ljava/lang/String;

.field private applicationInstanceInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;

.field private pushInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;

.field private sequenceNumber:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getApplicationInformation()Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->applicationInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

    return-object v0
.end method

.method public getApplicationInstallId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->applicationInstallId:Ljava/lang/String;

    return-object v0
.end method

.method public getApplicationInstanceInformation()Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->applicationInstanceInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;

    return-object v0
.end method

.method public getPushInformation()Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->pushInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;

    return-object v0
.end method

.method public getSequenceNumber()I
    .locals 1

    .prologue
    .line 31
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->sequenceNumber:I

    return v0
.end method

.method public setApplicationInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->applicationInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

    .line 47
    return-void
.end method

.method public setApplicationInstallId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->applicationInstallId:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setApplicationInstanceInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->applicationInstanceInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;

    .line 57
    return-void
.end method

.method public setPushInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->pushInformation:Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;

    .line 70
    return-void
.end method

.method public setSequenceNumber(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 36
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->sequenceNumber:I

    .line 37
    return-void
.end method
