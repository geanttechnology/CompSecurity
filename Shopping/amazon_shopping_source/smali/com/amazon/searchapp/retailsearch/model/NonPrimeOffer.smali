.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/NonPrimeOffer;
.super Ljava/lang/Object;
.source "NonPrimeOffer.java"


# virtual methods
.method public abstract getAsin()Ljava/lang/String;
.end method

.method public abstract getLabel()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
.end method
