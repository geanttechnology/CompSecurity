.class public Lcom/amazon/rio/j2me/client/services/mShop/Feature;
.super Ljava/lang/Object;
.source "Feature.java"


# instance fields
.field private cacheStamp:Ljava/lang/Integer;

.field private clientTreatmentPath:Ljava/lang/String;

.field private featureName:Ljava/lang/String;

.field private sendTrigger:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCacheStamp()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->cacheStamp:Ljava/lang/Integer;

    return-object v0
.end method

.method public getClientTreatmentPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->clientTreatmentPath:Ljava/lang/String;

    return-object v0
.end method

.method public getFeatureName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->featureName:Ljava/lang/String;

    return-object v0
.end method

.method public getSendTrigger()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->sendTrigger:Ljava/lang/Boolean;

    return-object v0
.end method

.method public setCacheStamp(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->cacheStamp:Ljava/lang/Integer;

    .line 68
    return-void
.end method

.method public setClientTreatmentPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->clientTreatmentPath:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setFeatureName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->featureName:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setSendTrigger(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Feature;->sendTrigger:Ljava/lang/Boolean;

    .line 55
    return-void
.end method
