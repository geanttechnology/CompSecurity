.class public interface abstract Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall$ResponseParser;
.super Ljava/lang/Object;
.source "SearchServiceCall.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "ResponseParser"
.end annotation


# virtual methods
.method public abstract parse(Ljava/io/InputStream;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
