.class public interface abstract Lcom/amazon/rio/j2me/client/trans/IServiceConnection;
.super Ljava/lang/Object;
.source "IServiceConnection.java"


# virtual methods
.method public abstract addCustomHeaders(Ljava/lang/String;)V
.end method

.method public abstract cancel()V
.end method

.method public abstract close()V
.end method

.method public abstract getUrl()Ljava/lang/String;
.end method

.method public abstract send([[B)Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
