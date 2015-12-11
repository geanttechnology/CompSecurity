.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/ResourceSet;
.super Ljava/lang/Object;
.source "ResourceSet.java"


# virtual methods
.method public abstract getId()Ljava/lang/String;
.end method

.method public abstract getImages()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ImageResource;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getStrings()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StringResource;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getVersion()Ljava/lang/String;
.end method
