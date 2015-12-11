.class public Lcom/xfinity/playerlib/model/comparator/DibicProgramReleaseYearComparator;
.super Ljava/lang/Object;
.source "DibicProgramReleaseYearComparator.java"

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
.field private final titleComparator:Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    new-instance v0, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;-><init>(Z)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/comparator/DibicProgramReleaseYearComparator;->titleComparator:Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;

    return-void
.end method


# virtual methods
.method public compare(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)I
    .locals 3
    .param p1, "p1"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .param p2, "p2"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 13
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getReleaseYear()I

    move-result v1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getReleaseYear()I

    move-result v2

    sub-int v0, v1, v2

    .line 14
    .local v0, "val":I
    if-nez v0, :cond_0

    .line 15
    iget-object v1, p0, Lcom/xfinity/playerlib/model/comparator/DibicProgramReleaseYearComparator;->titleComparator:Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;

    invoke-virtual {v1, p1, p2}, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;->compare(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)I

    move-result v0

    .line 17
    :cond_0
    return v0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 7
    check-cast p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    check-cast p2, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/model/comparator/DibicProgramReleaseYearComparator;->compare(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)I

    move-result v0

    return v0
.end method
