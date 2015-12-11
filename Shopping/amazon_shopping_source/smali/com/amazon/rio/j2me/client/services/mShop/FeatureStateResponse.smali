.class public Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;
.super Ljava/lang/Object;
.source "FeatureStateResponse.java"


# instance fields
.field private featureStates:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Feature;",
            ">;"
        }
    .end annotation
.end field

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
.method public getFeatureStates()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Feature;",
            ">;"
        }
    .end annotation

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;->featureStates:Ljava/util/List;

    return-object v0
.end method

.method public setFeatureStates(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Feature;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 26
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Feature;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;->featureStates:Ljava/util/List;

    .line 27
    return-void
.end method

.method public setSessionId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponse;->sessionId:Ljava/lang/String;

    .line 40
    return-void
.end method
