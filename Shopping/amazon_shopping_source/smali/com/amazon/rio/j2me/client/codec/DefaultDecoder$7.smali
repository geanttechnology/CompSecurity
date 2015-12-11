.class final Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$7;
.super Ljava/lang/Object;
.source "DefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Ljava/util/List",
        "<TT;>;>;"
    }
.end annotation


# instance fields
.field final synthetic val$elementDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;


# direct methods
.method constructor <init>(Lcom/amazon/rio/j2me/client/codec/Decoder;)V
    .locals 0

    .prologue
    .line 163
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$7;->val$elementDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/io/DataInputStream;
    .param p2, "x1"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 163
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$7;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/util/List;
    .locals 7
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/DataInputStream;",
            "Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;",
            ")",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 166
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readInt()I

    move-result v4

    .line 167
    .local v4, "size":I
    if-nez p2, :cond_1

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 168
    .local v0, "array":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :goto_0
    if-eqz p2, :cond_2

    const/4 v6, 0x1

    new-array v3, v6, [I

    .line 170
    .local v3, "path":[I
    :goto_1
    if-eqz p2, :cond_0

    .line 171
    # getter for: Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->EMPTY_PATH:[I
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->access$100()[I

    move-result-object v6

    invoke-interface {p2, v4, v6}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->aboutToReceiveArrayOfSize(I[I)V

    .line 173
    :cond_0
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_2
    if-ge v2, v4, :cond_4

    .line 175
    iget-object v6, p0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$7;->val$elementDecoder:Lcom/amazon/rio/j2me/client/codec/Decoder;

    invoke-interface {v6, p1, v5}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    .line 176
    .local v1, "element":Ljava/lang/Object;, "TT;"
    if-nez p2, :cond_3

    .line 177
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 173
    :goto_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .end local v0    # "array":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .end local v1    # "element":Ljava/lang/Object;, "TT;"
    .end local v2    # "i":I
    .end local v3    # "path":[I
    :cond_1
    move-object v0, v5

    .line 167
    goto :goto_0

    .restart local v0    # "array":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :cond_2
    move-object v3, v5

    .line 168
    goto :goto_1

    .line 180
    .restart local v1    # "element":Ljava/lang/Object;, "TT;"
    .restart local v2    # "i":I
    .restart local v3    # "path":[I
    :cond_3
    const/4 v6, 0x0

    aput v2, v3, v6

    .line 181
    invoke-interface {p2, v1, v3}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    goto :goto_3

    .line 185
    .end local v1    # "element":Ljava/lang/Object;, "TT;"
    :cond_4
    if-eqz p2, :cond_5

    .line 186
    # getter for: Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->EMPTY_PATH:[I
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->access$100()[I

    move-result-object v5

    invoke-interface {p2, v0, v5}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 187
    :cond_5
    return-object v0
.end method
