.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/FKMR;
.super Ljava/lang/Object;
.source "FKMR.java"


# virtual methods
.method public abstract getIndex()I
.end method

.method public abstract getKeywords()Ljava/util/List;
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

.method public abstract getMessage()Ljava/util/List;
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

.method public abstract getResults()Lcom/amazon/searchapp/retailsearch/model/ProductSection;
.end method

.method public abstract getSeeAllLink()Lcom/amazon/searchapp/retailsearch/model/Link;
.end method

.method public abstract getStyledText()Ljava/util/List;
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

.method public abstract getTotalResults()J
.end method
