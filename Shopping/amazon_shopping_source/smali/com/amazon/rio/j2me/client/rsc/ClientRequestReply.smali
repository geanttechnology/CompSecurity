.class public interface abstract Lcom/amazon/rio/j2me/client/rsc/ClientRequestReply;
.super Ljava/lang/Object;
.source "ClientRequestReply.java"


# virtual methods
.method public abstract cancelled(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
.end method

.method public abstract communicationError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
.end method

.method public abstract consumeReply(Ljava/io/InputStream;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract internalError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
.end method

.method public abstract produceRequestData(Ljava/io/OutputStream;Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
