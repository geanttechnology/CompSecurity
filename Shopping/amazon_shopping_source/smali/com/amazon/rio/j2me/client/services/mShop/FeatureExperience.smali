.class public Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;
.super Ljava/lang/Object;
.source "FeatureExperience.java"


# instance fields
.field private cacheStamp:Ljava/lang/Integer;

.field private featureName:Ljava/lang/String;

.field private treatment:Ljava/lang/String;


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
    .line 48
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->cacheStamp:Ljava/lang/Integer;

    return-object v0
.end method

.method public getFeatureName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->featureName:Ljava/lang/String;

    return-object v0
.end method

.method public getTreatment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->treatment:Ljava/lang/String;

    return-object v0
.end method

.method public setCacheStamp(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->cacheStamp:Ljava/lang/Integer;

    .line 54
    return-void
.end method

.method public setFeatureName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->featureName:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setTreatment(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;->treatment:Ljava/lang/String;

    .line 41
    return-void
.end method
