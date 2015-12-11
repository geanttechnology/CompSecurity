.class public Lcom/amazon/rio/j2me/client/codec/SearchRequestDefaultEncoder;
.super Ljava/lang/Object;
.source "SearchRequestDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;Ljava/io/DataOutputStream;)V
    .locals 11
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/32 v9, 0x7fffffff

    const-wide/32 v7, -0x80000000

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 20
    move-object v1, p1

    .line 24
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getQuery()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_6

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

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getQuery()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 32
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getCategoryRefinements()Ljava/util/List;

    move-result-object v4

    if-nez v4, :cond_7

    move v0, v2

    .line 33
    :goto_1
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 34
    if-nez v0, :cond_1

    .line 36
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Encoder;)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getCategoryRefinements()Ljava/util/List;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 41
    :cond_1
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    new-instance v5, Ljava/lang/Integer;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getPage()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 46
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    new-instance v5, Ljava/lang/Integer;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getSize()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 51
    invoke-static {v7, v8, v9, v10}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    new-instance v5, Ljava/lang/Integer;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getMaxImageDimension()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 55
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getReturnRefinements()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_8

    move v0, v2

    .line 56
    :goto_2
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 57
    if-nez v0, :cond_2

    .line 59
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getReturnRefinements()Ljava/lang/Boolean;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 63
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getQueryDescriptor()Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    move-result-object v4

    if-nez v4, :cond_9

    move v0, v2

    .line 64
    :goto_3
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 65
    if-nez v0, :cond_3

    .line 67
    new-instance v4, Lcom/amazon/rio/j2me/client/codec/QueryDescriptorDefaultEncoder;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/codec/QueryDescriptorDefaultEncoder;-><init>()V

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getQueryDescriptor()Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    move-result-object v5

    invoke-virtual {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/QueryDescriptorDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;Ljava/io/DataOutputStream;)V

    .line 71
    :cond_3
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_a

    move v0, v2

    .line 72
    :goto_4
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 73
    if-nez v0, :cond_4

    .line 75
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 79
    :cond_4
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getIncludeAddOnItems()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_b

    move v0, v2

    .line 80
    :goto_5
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 81
    if-nez v0, :cond_5

    .line 83
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;->getIncludeAddOnItems()Ljava/lang/Boolean;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 85
    :cond_5
    return-void

    .end local v0    # "isAbsent":Z
    :cond_6
    move v0, v3

    .line 24
    goto/16 :goto_0

    .restart local v0    # "isAbsent":Z
    :cond_7
    move v0, v3

    .line 32
    goto/16 :goto_1

    :cond_8
    move v0, v3

    .line 55
    goto :goto_2

    :cond_9
    move v0, v3

    .line 63
    goto :goto_3

    :cond_a
    move v0, v3

    .line 71
    goto :goto_4

    :cond_b
    move v0, v3

    .line 79
    goto :goto_5
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/SearchRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;Ljava/io/DataOutputStream;)V

    return-void
.end method
