.class public interface abstract Lcom/amazon/searchapp/retailsearch/client/web/WebClient;
.super Ljava/lang/Object;
.source "WebClient.java"


# virtual methods
.method public abstract createConnection(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap;Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;)Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/searchapp/retailsearch/client/web/CollectionMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;",
            ")",
            "Lcom/amazon/searchapp/retailsearch/client/web/WebConnection;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
