.class public Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;
.super Ljava/lang/Object;
.source "InterstitialCartItemsInfo.java"


# instance fields
.field private alertMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

.field private invalidThresholdItemMessage:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

.field private savedForLaterHeader:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

.field private savedForLaterMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

.field private thresholdDeficit:Ljava/lang/String;

.field private validCartSubtotal:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setAlertMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;->alertMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .line 31
    return-void
.end method

.method public setInvalidThresholdItemMessage(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;->invalidThresholdItemMessage:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 96
    return-void
.end method

.method public setSavedForLaterHeader(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;->savedForLaterHeader:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 44
    return-void
.end method

.method public setSavedForLaterMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;->savedForLaterMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .line 57
    return-void
.end method

.method public setThresholdDeficit(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;->thresholdDeficit:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public setValidCartSubtotal(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;->validCartSubtotal:Ljava/lang/String;

    .line 70
    return-void
.end method
