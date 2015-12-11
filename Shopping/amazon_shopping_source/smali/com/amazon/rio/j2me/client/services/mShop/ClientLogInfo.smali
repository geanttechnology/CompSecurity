.class public Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;
.super Ljava/lang/Object;
.source "ClientLogInfo.java"


# instance fields
.field private features:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;",
            ">;"
        }
    .end annotation
.end field

.field private pageAssemblyType:Ljava/lang/String;

.field private pageType:Ljava/lang/String;

.field private relatedRequestId:Ljava/lang/String;

.field private sessionId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getFeatures()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;",
            ">;"
        }
    .end annotation

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->features:Ljava/util/List;

    return-object v0
.end method

.method public getPageAssemblyType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->pageAssemblyType:Ljava/lang/String;

    return-object v0
.end method

.method public getPageType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->pageType:Ljava/lang/String;

    return-object v0
.end method

.method public getRelatedRequestId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->relatedRequestId:Ljava/lang/String;

    return-object v0
.end method

.method public getSessionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->sessionId:Ljava/lang/String;

    return-object v0
.end method

.method public setFeatures(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 81
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/FeatureExperience;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->features:Ljava/util/List;

    .line 82
    return-void
.end method

.method public setPageAssemblyType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->pageAssemblyType:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setPageType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->pageType:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setRelatedRequestId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;->relatedRequestId:Ljava/lang/String;

    .line 43
    return-void
.end method
