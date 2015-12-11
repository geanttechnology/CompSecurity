.class public interface abstract Lcom/amazon/ansel/fetch/tools/web/WebClient;
.super Ljava/lang/Object;
.source "WebClient.java"


# virtual methods
.method public abstract createConnection(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/ansel/fetch/tools/collection/CollectionMap;Lcom/amazon/ansel/fetch/tools/web/RequestContent;)Lcom/amazon/ansel/fetch/tools/web/WebConnection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/ansel/fetch/tools/collection/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/ansel/fetch/tools/web/RequestContent;",
            ")",
            "Lcom/amazon/ansel/fetch/tools/web/WebConnection;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
