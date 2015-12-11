.class public interface abstract Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;
.super Ljava/lang/Object;
.source "AmazonWebserviceCallResponseParser.java"


# virtual methods
.method public abstract getErrorCode(Ljava/net/HttpURLConnection;)Ljava/lang/String;
.end method

.method public abstract parse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;[B)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;,
            Ljava/io/IOException;
        }
    .end annotation
.end method
