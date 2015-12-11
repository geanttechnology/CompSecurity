.class public Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;
.super Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;
.source "SeriesCollectionSortPolicy.java"


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V
    .locals 0
    .param p1, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .prologue
    .line 8
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;-><init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V

    .line 9
    return-void
.end method


# virtual methods
.method public getCurrentSortType()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getSeriesCollectionSort()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    move-result-object v0

    return-object v0
.end method

.method public setCurrentSortType(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 1
    .param p1, "sortType"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setSeriesCollectionSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 19
    return-void
.end method
