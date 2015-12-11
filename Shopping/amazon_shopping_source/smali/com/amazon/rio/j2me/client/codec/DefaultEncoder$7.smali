.class final Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$7;
.super Ljava/lang/Object;
.source "DefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Encoder;)Lcom/amazon/rio/j2me/client/codec/Encoder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Ljava/util/List",
        "<TT;>;>;"
    }
.end annotation


# instance fields
.field final synthetic val$elementEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;


# direct methods
.method constructor <init>(Lcom/amazon/rio/j2me/client/codec/Encoder;)V
    .locals 0

    .prologue
    .line 148
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$7;->val$elementEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
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
    .line 148
    check-cast p1, Ljava/util/List;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$7;->encode(Ljava/util/List;Ljava/io/DataOutputStream;)V

    return-void
.end method

.method public encode(Ljava/util/List;Ljava/io/DataOutputStream;)V
    .locals 5
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TT;>;",
            "Ljava/io/DataOutputStream;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 151
    .local p1, "o":Ljava/util/List;, "Ljava/util/List<TT;>;"
    move-object v0, p1

    .line 152
    .local v0, "array":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    .line 153
    .local v2, "size":I
    invoke-virtual {p2, v2}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 154
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 155
    iget-object v3, p0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$7;->val$elementEncoder:Lcom/amazon/rio/j2me/client/codec/Encoder;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v3, v4, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 154
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 156
    :cond_0
    return-void
.end method
