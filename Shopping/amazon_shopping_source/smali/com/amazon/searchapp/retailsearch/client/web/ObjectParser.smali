.class public interface abstract Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;
.super Ljava/lang/Object;
.source "ObjectParser.java"


# virtual methods
.method public abstract parse(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TResult:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/io/InputStream;",
            "Ljava/lang/Class",
            "<TTResult;>;)TTResult;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
