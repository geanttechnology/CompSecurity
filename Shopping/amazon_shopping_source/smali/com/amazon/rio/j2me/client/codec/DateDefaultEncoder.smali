.class public Lcom/amazon/rio/j2me/client/codec/DateDefaultEncoder;
.super Ljava/lang/Object;
.source "DateDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/Date;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/io/DataOutputStream;)V
    .locals 7
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v5, 0x1

    .line 20
    move-object v0, p1

    .line 24
    .local v0, "record":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    const-wide/16 v1, 0x708

    const-wide/16 v3, 0x807

    invoke-static {v1, v2, v3, v4}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v1

    new-instance v2, Ljava/lang/Integer;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->getYear()I

    move-result v3

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v1, v2, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 29
    const-wide/16 v1, 0xc

    invoke-static {v5, v6, v1, v2}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v1

    new-instance v2, Ljava/lang/Integer;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->getMonth()I

    move-result v3

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v1, v2, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 34
    const-wide/16 v1, 0x1f

    invoke-static {v5, v6, v1, v2}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v1

    new-instance v2, Ljava/lang/Integer;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Date;->getDay()I

    move-result v3

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v1, v2, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 36
    return-void
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/Date;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/DateDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/io/DataOutputStream;)V

    return-void
.end method
