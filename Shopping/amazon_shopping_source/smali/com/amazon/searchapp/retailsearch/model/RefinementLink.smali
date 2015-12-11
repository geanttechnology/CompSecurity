.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
.super Ljava/lang/Object;
.source "RefinementLink.java"


# virtual methods
.method public abstract getAvailability()Z
.end method

.method public abstract getBrowseUrl()Ljava/lang/String;
.end method

.method public abstract getCategories()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementLink;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getCount()J
.end method

.method public abstract getId()Ljava/lang/String;
.end method

.method public abstract getSelected()Z
.end method

.method public abstract getStyleText()Ljava/util/List;
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

.method public abstract getText()Ljava/lang/String;
.end method

.method public abstract getUrl()Ljava/lang/String;
.end method
