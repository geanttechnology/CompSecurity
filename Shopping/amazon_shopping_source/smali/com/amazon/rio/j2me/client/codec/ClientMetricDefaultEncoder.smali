.class public Lcom/amazon/rio/j2me/client/codec/ClientMetricDefaultEncoder;
.super Ljava/lang/Object;
.source "ClientMetricDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;Ljava/io/DataOutputStream;)V
    .locals 10
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/32 v8, 0x7fffffff

    const-wide/32 v6, -0x80000000

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 20
    move-object v1, p1

    .line 25
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 29
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getTime()Ljava/lang/Integer;

    move-result-object v4

    if-nez v4, :cond_4

    move v0, v2

    .line 30
    .local v0, "isAbsent":Z
    :goto_0
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 31
    if-nez v0, :cond_0

    .line 33
    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getTime()Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 37
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getCount()Ljava/lang/Integer;

    move-result-object v4

    if-nez v4, :cond_5

    move v0, v2

    .line 38
    :goto_1
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 39
    if-nez v0, :cond_1

    .line 41
    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getCount()Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 45
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getSize()Ljava/lang/Integer;

    move-result-object v4

    if-nez v4, :cond_6

    move v0, v2

    .line 46
    :goto_2
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 47
    if-nez v0, :cond_2

    .line 49
    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getSize()Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 53
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getInfo()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_7

    move v0, v2

    .line 54
    :goto_3
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 55
    if-nez v0, :cond_3

    .line 57
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getInfo()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 59
    :cond_3
    return-void

    .end local v0    # "isAbsent":Z
    :cond_4
    move v0, v3

    .line 29
    goto :goto_0

    .restart local v0    # "isAbsent":Z
    :cond_5
    move v0, v3

    .line 37
    goto :goto_1

    :cond_6
    move v0, v3

    .line 45
    goto :goto_2

    :cond_7
    move v0, v3

    .line 53
    goto :goto_3
.end method

.method public bridge synthetic encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 16
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/ClientMetricDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;Ljava/io/DataOutputStream;)V

    return-void
.end method
