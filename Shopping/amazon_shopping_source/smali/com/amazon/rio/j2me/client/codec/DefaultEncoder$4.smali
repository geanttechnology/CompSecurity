.class final Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$4;
.super Ljava/lang/Object;
.source "DefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getIntegerInstance(JJ)Lcom/amazon/rio/j2me/client/codec/Encoder;
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
    .line 100
    iput-wide p1, p0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$4;->val$lowerBound:J

    iput-wide p3, p0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$4;->val$upperBound:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public encode(Ljava/lang/Integer;Ljava/io/DataOutputStream;)V
    .locals 7
    .param p1, "value"    # Ljava/lang/Integer;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 103
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    int-to-long v0, v0

    iget-wide v2, p0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$4;->val$lowerBound:J

    iget-wide v4, p0, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$4;->val$upperBound:J

    move-object v6, p2

    # invokes: Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->encodeIntegerInRange(JJJLjava/io/DataOutputStream;)V
    invoke-static/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->access$000(JJJLjava/io/DataOutputStream;)V

    .line 104
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
    .line 100
    check-cast p1, Ljava/lang/Integer;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder$4;->encode(Ljava/lang/Integer;Ljava/io/DataOutputStream;)V

    return-void
.end method
