.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
.super Ljava/lang/Object;
.source "SessionInputBuffer.java"


# virtual methods
.method public abstract getMetrics()Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;
.end method

.method public abstract isDataAvailable(I)Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract read()I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract read([BII)I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract readLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
