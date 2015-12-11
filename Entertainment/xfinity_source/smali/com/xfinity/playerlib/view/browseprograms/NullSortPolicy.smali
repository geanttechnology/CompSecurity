.class public Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;
.super Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
.source "NullSortPolicy.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
        ">;"
    }
.end annotation


# instance fields
.field protected final titleComparator:Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;-><init>()V

    .line 10
    new-instance v0, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;-><init>(Z)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;->titleComparator:Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;

    return-void
.end method


# virtual methods
.method public getComparator(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)Ljava/util/Comparator;
    .locals 1
    .param p1, "sortType"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;",
            ")",
            "Ljava/util/Comparator",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 14
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;->titleComparator:Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;

    return-object v0
.end method

.method public getCurrentSortType()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->NONE:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    return-object v0
.end method

.method public getSortTypes()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;",
            ">;"
        }
    .end annotation

    .prologue
    .line 19
    const/4 v0, 0x0

    return-object v0
.end method

.method public setCurrentSortType(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 3
    .param p1, "sortType"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 29
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->NONE:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    if-eq p1, v0, :cond_0

    .line 30
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected sort type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 32
    :cond_0
    return-void
.end method
