.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
.super Ljava/lang/Object;
.source "RefinementFilter.java"


# virtual methods
.method public abstract getAncestry()Ljava/util/List;
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

.method public abstract getClearLink()Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
.end method

.method public abstract getDetail()Ljava/lang/String;
.end method

.method public abstract getGroup()Ljava/lang/String;
.end method

.method public abstract getId()Ljava/lang/String;
.end method

.method public abstract getLabel()Ljava/lang/String;
.end method

.method public abstract getRemovesSiblings()Z
.end method

.method public abstract getType()Ljava/lang/String;
.end method

.method public abstract getValues()Ljava/util/List;
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
