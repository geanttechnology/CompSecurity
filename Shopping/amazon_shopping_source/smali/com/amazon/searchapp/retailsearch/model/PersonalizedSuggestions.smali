.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
.super Ljava/lang/Object;
.source "PersonalizedSuggestions.java"


# virtual methods
.method public abstract getRequestId()Ljava/lang/String;
.end method

.method public abstract getSearchedText()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SearchedText;",
            ">;"
        }
    .end annotation
.end method

.method public abstract setSearchedText(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/SearchedText;",
            ">;)V"
        }
    .end annotation
.end method
