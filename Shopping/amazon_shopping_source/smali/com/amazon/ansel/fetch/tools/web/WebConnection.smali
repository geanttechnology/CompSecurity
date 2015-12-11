.class public interface abstract Lcom/amazon/ansel/fetch/tools/web/WebConnection;
.super Ljava/lang/Object;
.source "WebConnection.java"


# virtual methods
.method public abstract abort()V
.end method

.method public abstract getResponse()Lcom/amazon/ansel/fetch/tools/web/WebResponse;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
