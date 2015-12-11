.class public Lcom/xfinity/playerlib/model/downloads/comparator/DownloadableFileTitleComparator;
.super Ljava/lang/Object;
.source "DownloadableFileTitleComparator.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
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
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/downloads/comparator/DownloadableFileTitleComparator;->isAscending:Z

    .line 15
    return-void
.end method


# virtual methods
.method public compare(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)I
    .locals 8
    .param p1, "f1"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "f2"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 19
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v4

    .line 20
    .local v4, "watchable1":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v5

    .line 21
    .local v5, "watchable2":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;

    move-result-object v0

    .line 22
    .local v0, "info1":Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;
    invoke-interface {v5}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;

    move-result-object v1

    .line 25
    .local v1, "info2":Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;
    if-eqz v0, :cond_4

    if-eqz v1, :cond_4

    .line 27
    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeriesSortTitle()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeriesSortTitle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v3

    .line 28
    .local v3, "value":I
    if-nez v3, :cond_0

    .line 30
    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v6

    if-eqz v6, :cond_1

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 32
    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v7

    sub-int v3, v6, v7

    .line 33
    if-nez v3, :cond_0

    .line 35
    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v7

    sub-int v3, v6, v7

    .line 48
    :cond_0
    :goto_0
    move v2, v3

    .line 60
    .end local v3    # "value":I
    .local v2, "val":I
    :goto_1
    iget-boolean v6, p0, Lcom/xfinity/playerlib/model/downloads/comparator/DownloadableFileTitleComparator;->isAscending:Z

    if-eqz v6, :cond_7

    .end local v2    # "val":I
    :goto_2
    return v2

    .line 37
    .restart local v3    # "value":I
    :cond_1
    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 39
    const/4 v3, -0x1

    goto :goto_0

    .line 40
    :cond_2
    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v6

    if-eqz v6, :cond_3

    .line 42
    const/4 v3, 0x1

    goto :goto_0

    .line 45
    :cond_3
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSortTitle()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSortTitle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v3

    goto :goto_0

    .line 49
    .end local v3    # "value":I
    :cond_4
    if-eqz v0, :cond_5

    .line 51
    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeriesSortTitle()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSortTitle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v2

    .restart local v2    # "val":I
    goto :goto_1

    .line 52
    .end local v2    # "val":I
    :cond_5
    if-eqz v1, :cond_6

    .line 54
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSortTitle()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeriesSortTitle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v2

    .restart local v2    # "val":I
    goto :goto_1

    .line 57
    .end local v2    # "val":I
    :cond_6
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSortTitle()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSortTitle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v2

    .restart local v2    # "val":I
    goto :goto_1

    .line 60
    :cond_7
    neg-int v2, v2

    goto :goto_2
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 9
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    check-cast p2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/model/downloads/comparator/DownloadableFileTitleComparator;->compare(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)I

    move-result v0

    return v0
.end method
