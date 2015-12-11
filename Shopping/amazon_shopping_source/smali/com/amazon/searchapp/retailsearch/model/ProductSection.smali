.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/ProductSection;
.super Ljava/lang/Object;
.source "ProductSection.java"


# virtual methods
.method public abstract getItems()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/Product;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getNumSections()I
.end method

.method public abstract getPage()I
.end method

.method public abstract getSection()I
.end method
