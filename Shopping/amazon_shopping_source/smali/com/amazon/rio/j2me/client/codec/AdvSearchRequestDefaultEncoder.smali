.class public Lcom/amazon/rio/j2me/client/codec/AdvSearchRequestDefaultEncoder;
.super Ljava/lang/Object;
.source "AdvSearchRequestDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;Ljava/io/DataOutputStream;)V
    .locals 10
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;
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

    .line 24
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getQuery()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_d

    move v0, v2

    .line 25
    .local v0, "isAbsent":Z
    :goto_0
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 26
    if-nez v0, :cond_0

    .line 28
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getQuery()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 32
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getOffset()Ljava/lang/Integer;

    move-result-object v4

    if-nez v4, :cond_e

    move v0, v2

    .line 33
    :goto_1
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 34
    if-nez v0, :cond_1

    .line 36
    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getOffset()Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 40
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getCount()Ljava/lang/Integer;

    move-result-object v4

    if-nez v4, :cond_f

    move v0, v2

    .line 41
    :goto_2
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 42
    if-nez v0, :cond_2

    .line 44
    invoke-static {v6, v7, v8, v9}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getCount()Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 48
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getFilters()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_10

    move v0, v2

    .line 49
    :goto_3
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 50
    if-nez v0, :cond_3

    .line 52
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getFilters()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 56
    :cond_3
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getToggleRefinements()Ljava/util/List;

    move-result-object v4

    if-nez v4, :cond_11

    move v0, v2

    .line 57
    :goto_4
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 58
    if-nez v0, :cond_4

    .line 60
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Encoder;)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getToggleRefinements()Ljava/util/List;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 64
    :cond_4
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getSortId()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_12

    move v0, v2

    .line 65
    :goto_5
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 66
    if-nez v0, :cond_5

    .line 68
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getSortId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 72
    :cond_5
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getReturnProducts()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_13

    move v0, v2

    .line 73
    :goto_6
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 74
    if-nez v0, :cond_6

    .line 76
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getReturnProducts()Ljava/lang/Boolean;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 80
    :cond_6
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getReturnStubs()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_14

    move v0, v2

    .line 81
    :goto_7
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 82
    if-nez v0, :cond_7

    .line 84
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getReturnStubs()Ljava/lang/Boolean;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 88
    :cond_7
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getReturnRefinements()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_15

    move v0, v2

    .line 89
    :goto_8
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 90
    if-nez v0, :cond_8

    .line 92
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getReturnRefinements()Ljava/lang/Boolean;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 96
    :cond_8
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getReturnCorrections()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_16

    move v0, v2

    .line 97
    :goto_9
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 98
    if-nez v0, :cond_9

    .line 100
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getReturnCorrections()Ljava/lang/Boolean;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 104
    :cond_9
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getIsPrefetch()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_17

    move v0, v2

    .line 105
    :goto_a
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 106
    if-nez v0, :cond_a

    .line 108
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getIsPrefetch()Ljava/lang/Boolean;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 112
    :cond_a
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_18

    move v0, v2

    .line 113
    :goto_b
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 114
    if-nez v0, :cond_b

    .line 116
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 120
    :cond_b
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getIncludeAddOnItems()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_19

    move v0, v2

    .line 121
    :goto_c
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 122
    if-nez v0, :cond_c

    .line 124
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->getIncludeAddOnItems()Ljava/lang/Boolean;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 126
    :cond_c
    return-void

    .end local v0    # "isAbsent":Z
    :cond_d
    move v0, v3

    .line 24
    goto/16 :goto_0

    .restart local v0    # "isAbsent":Z
    :cond_e
    move v0, v3

    .line 32
    goto/16 :goto_1

    :cond_f
    move v0, v3

    .line 40
    goto/16 :goto_2

    :cond_10
    move v0, v3

    .line 48
    goto/16 :goto_3

    :cond_11
    move v0, v3

    .line 56
    goto/16 :goto_4

    :cond_12
    move v0, v3

    .line 64
    goto/16 :goto_5

    :cond_13
    move v0, v3

    .line 72
    goto/16 :goto_6

    :cond_14
    move v0, v3

    .line 80
    goto/16 :goto_7

    :cond_15
    move v0, v3

    .line 88
    goto/16 :goto_8

    :cond_16
    move v0, v3

    .line 96
    goto :goto_9

    :cond_17
    move v0, v3

    .line 104
    goto :goto_a

    :cond_18
    move v0, v3

    .line 112
    goto :goto_b

    :cond_19
    move v0, v3

    .line 120
    goto :goto_c
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/AdvSearchRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;Ljava/io/DataOutputStream;)V

    return-void
.end method
