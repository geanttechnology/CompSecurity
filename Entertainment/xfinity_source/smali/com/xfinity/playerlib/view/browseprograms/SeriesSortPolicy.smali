.class public Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;
.super Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
.source "SeriesSortPolicy.java"


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
.field protected final newSortComparator:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field protected final popularityComparator:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field protected final sortTypes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;",
            ">;"
        }
    .end annotation
.end field

.field protected final titleComparator:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field protected final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V
    .locals 4
    .param p1, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .prologue
    const/4 v3, 0x1

    .line 22
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;-><init>()V

    .line 17
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    const/4 v1, 0x0

    sget-object v2, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    aput-object v2, v0, v1

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->NEW:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    aput-object v1, v0, v3

    const/4 v1, 0x2

    sget-object v2, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->ALPHA:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->sortTypes:Ljava/util/List;

    .line 18
    new-instance v0, Lcom/xfinity/playerlib/model/comparator/DibicProgramNewProgramComparator;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/comparator/DibicProgramNewProgramComparator;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->newSortComparator:Ljava/util/Comparator;

    .line 19
    new-instance v0, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;

    invoke-direct {v0, v3}, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;-><init>(Z)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->titleComparator:Ljava/util/Comparator;

    .line 20
    new-instance v0, Lcom/xfinity/playerlib/model/comparator/DibicProgramPopularityComparator;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/comparator/DibicProgramPopularityComparator;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->popularityComparator:Ljava/util/Comparator;

    .line 23
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 24
    return-void
.end method


# virtual methods
.method public getComparator(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)Ljava/util/Comparator;
    .locals 3
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
    .line 33
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy$1;->$SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType:[I

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 41
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

    .line 35
    :pswitch_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->popularityComparator:Ljava/util/Comparator;

    .line 39
    :goto_0
    return-object v0

    .line 37
    :pswitch_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->newSortComparator:Ljava/util/Comparator;

    goto :goto_0

    .line 39
    :pswitch_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->titleComparator:Ljava/util/Comparator;

    goto :goto_0

    .line 33
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public getCurrentSortType()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getSeriesSort()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    move-result-object v0

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
    .line 28
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->sortTypes:Ljava/util/List;

    return-object v0
.end method

.method public setCurrentSortType(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 1
    .param p1, "sortType"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setSeriesSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 53
    return-void
.end method
