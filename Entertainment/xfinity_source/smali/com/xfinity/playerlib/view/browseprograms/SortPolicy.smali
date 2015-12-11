.class public abstract Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
.super Ljava/lang/Object;
.source "SortPolicy.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;, "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    return-void
.end method


# virtual methods
.method public abstract getComparator(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;",
            ")",
            "Ljava/util/Comparator",
            "<TT;>;"
        }
    .end annotation
.end method

.method public getCurrentSortComparator()Ljava/util/Comparator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Comparator",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 24
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;, "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getCurrentSortType()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getComparator(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)Ljava/util/Comparator;

    move-result-object v0

    return-object v0
.end method

.method public abstract getCurrentSortType()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
.end method

.method public abstract getSortTypes()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;",
            ">;"
        }
    .end annotation
.end method

.method public abstract setCurrentSortType(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
.end method
