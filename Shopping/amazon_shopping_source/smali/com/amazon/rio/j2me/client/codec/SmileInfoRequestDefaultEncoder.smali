.class public Lcom/amazon/rio/j2me/client/codec/SmileInfoRequestDefaultEncoder;
.super Ljava/lang/Object;
.source "SmileInfoRequestDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;Ljava/io/DataOutputStream;)V
    .locals 1
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 20
    move-object v0, p1

    .line 21
    .local v0, "record":Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/SmileInfoRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;Ljava/io/DataOutputStream;)V

    return-void
.end method
