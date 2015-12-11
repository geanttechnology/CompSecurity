.class public Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
.super Ljava/lang/Object;
.source "ClientMetric.java"


# instance fields
.field private count:Ljava/lang/Integer;

.field private info:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private size:Ljava/lang/Integer;

.field private time:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->count:Ljava/lang/Integer;

    return-object v0
.end method

.method public getInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->info:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->size:Ljava/lang/Integer;

    return-object v0
.end method

.method public getTime()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->time:Ljava/lang/Integer;

    return-object v0
.end method

.method public setCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->count:Ljava/lang/Integer;

    .line 53
    return-void
.end method

.method public setInfo(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->info:Ljava/lang/String;

    .line 79
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->name:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setTime(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->time:Ljava/lang/Integer;

    .line 40
    return-void
.end method
