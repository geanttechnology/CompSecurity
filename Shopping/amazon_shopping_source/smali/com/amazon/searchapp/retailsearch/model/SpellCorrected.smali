.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;
.super Ljava/lang/Object;
.source "SpellCorrected.java"


# virtual methods
.method public abstract getCorrectedKeywords()Ljava/lang/String;
.end method

.method public abstract getDetailedStyledText()Ljava/util/List;
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

.method public abstract getSeeMoreLink()Lcom/amazon/searchapp/retailsearch/model/Link;
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
