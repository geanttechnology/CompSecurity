.class public Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;
.super Ljava/lang/Object;
.source "ClientMetrics.java"


# instance fields
.field private clickedSlots:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private exposedSlots:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private logInfo:Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;

.field private metrics:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getClickedSlots()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->clickedSlots:Ljava/util/List;

    return-object v0
.end method

.method public getExposedSlots()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->exposedSlots:Ljava/util/List;

    return-object v0
.end method

.method public getLogInfo()Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->logInfo:Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;

    return-object v0
.end method

.method public getMetrics()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->metrics:Ljava/util/List;

    return-object v0
.end method

.method public setClickedSlots(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 54
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->clickedSlots:Ljava/util/List;

    .line 55
    return-void
.end method

.method public setExposedSlots(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 41
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->exposedSlots:Ljava/util/List;

    .line 42
    return-void
.end method

.method public setLogInfo(Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->logInfo:Lcom/amazon/rio/j2me/client/services/mShop/ClientLogInfo;

    .line 68
    return-void
.end method

.method public setMetrics(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;->metrics:Ljava/util/List;

    .line 29
    return-void
.end method
