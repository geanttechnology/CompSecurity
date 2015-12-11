.class final Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$4;
.super Ljava/lang/Object;
.source "DefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Decoder;
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
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic val$lowerBound:J

.field final synthetic val$upperBound:J


# direct methods
.method constructor <init>(JJ)V
    .locals 0

    .prologue
    .line 112
    iput-wide p1, p0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$4;->val$lowerBound:J

    iput-wide p3, p0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$4;->val$upperBound:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Integer;
    .locals 6
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 115
    iget-wide v2, p0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$4;->val$lowerBound:J

    iget-wide v4, p0, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$4;->val$upperBound:J

    # invokes: Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->decodeIntegerInRange(JJLjava/io/DataInputStream;)J
    invoke-static {v2, v3, v4, v5, p1}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->access$000(JJLjava/io/DataInputStream;)J

    move-result-wide v0

    .line 116
    .local v0, "value":J
    long-to-int v2, v0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    return-object v2
.end method

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
    .line 112
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder$4;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method
