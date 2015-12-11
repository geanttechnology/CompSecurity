.class public Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;
.super Ljava/lang/Object;
.source "DibicProgramTitleComparator.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
        ">;"
    }
.end annotation


# instance fields
.field private final isAscending:Z


# direct methods
.method public constructor <init>(Z)V
    .locals 0
    .param p1, "isAscending"    # Z

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;->isAscending:Z

    .line 13
    return-void
.end method


# virtual methods
.method public compare(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)I
    .locals 3
    .param p1, "p1"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .param p2, "p2"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 17
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getSortTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getSortTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v0

    .line 18
    .local v0, "val":I
    iget-boolean v1, p0, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;->isAscending:Z

    if-eqz v1, :cond_0

    .end local v0    # "val":I
    :goto_0
    return v0

    .restart local v0    # "val":I
    :cond_0
    neg-int v0, v0

    goto :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 7
    check-cast p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    check-cast p2, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;->compare(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)I

    move-result v0

    return v0
.end method
