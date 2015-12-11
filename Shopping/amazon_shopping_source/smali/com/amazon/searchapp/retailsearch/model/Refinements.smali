.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/Refinements;
.super Ljava/lang/Object;
.source "Refinements.java"


# virtual methods
.method public abstract getClearAllLink()Lcom/amazon/searchapp/retailsearch/model/Link;
.end method

.method public abstract getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;
.end method

.method public abstract getFilters()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getPrioritizedFilterIds()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method
