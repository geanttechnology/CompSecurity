.class public Lcom/amazon/client/metrics/codec/ProtocolBufferDiskWriter;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static main([Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/ProtocolBufferExample;->generateEncodedMetrics()[B

    new-instance v0, Ljava/io/FileOutputStream;

    const-string/jumbo v1, "/home/yilin/metrics-logs/encoded-file"

    invoke-direct {v0, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/amazon/client/metrics/codec/ProtocolBufferExample;->generateEncodedMetrics()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/FileOutputStream;->write([B)V

    return-void
.end method
