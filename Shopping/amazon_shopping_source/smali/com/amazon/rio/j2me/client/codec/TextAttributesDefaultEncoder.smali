.class public Lcom/amazon/rio/j2me/client/codec/TextAttributesDefaultEncoder;
.super Ljava/lang/Object;
.source "TextAttributesDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;Ljava/io/DataOutputStream;)V
    .locals 8
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 20
    move-object v1, p1

    .line 24
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getSize()Ljava/lang/Integer;

    move-result-object v4

    if-nez v4, :cond_5

    move v0, v2

    .line 25
    .local v0, "isAbsent":Z
    :goto_0
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 26
    if-nez v0, :cond_0

    .line 28
    const/4 v4, 0x3

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getSize()Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 32
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getStyle()Ljava/lang/Integer;

    move-result-object v4

    if-nez v4, :cond_6

    move v0, v2

    .line 33
    :goto_1
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 34
    if-nez v0, :cond_1

    .line 36
    const/4 v4, 0x2

    invoke-static {v4}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getEnumInstance(I)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getStyle()Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 40
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getColor()Ljava/lang/Integer;

    move-result-object v4

    if-nez v4, :cond_7

    move v0, v2

    .line 41
    :goto_2
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 42
    if-nez v0, :cond_2

    .line 44
    const-wide/32 v4, -0x80000000

    const-wide/32 v6, 0x7fffffff

    invoke-static {v4, v5, v6, v7}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getColor()Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 48
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getLinkUrl()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_8

    move v0, v2

    .line 49
    :goto_3
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 50
    if-nez v0, :cond_3

    .line 52
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getLinkUrl()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 56
    :cond_3
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getAllowTruncation()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_9

    move v0, v2

    .line 57
    :goto_4
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 58
    if-nez v0, :cond_4

    .line 60
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getAllowTruncation()Ljava/lang/Boolean;

    move-result-object v3

    invoke-interface {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 62
    :cond_4
    return-void

    .end local v0    # "isAbsent":Z
    :cond_5
    move v0, v3

    .line 24
    goto :goto_0

    .restart local v0    # "isAbsent":Z
    :cond_6
    move v0, v3

    .line 32
    goto :goto_1

    :cond_7
    move v0, v3

    .line 40
    goto :goto_2

    :cond_8
    move v0, v3

    .line 48
    goto :goto_3

    :cond_9
    move v0, v3

    .line 56
    goto :goto_4
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/TextAttributesDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;Ljava/io/DataOutputStream;)V

    return-void
.end method
