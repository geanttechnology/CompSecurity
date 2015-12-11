.class public Lcom/xfinity/playerlib/view/browseprograms/MoviesFilterDialog;
.super Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;
.source "MoviesFilterDialog.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;-><init>()V

    return-void
.end method


# virtual methods
.method protected getFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MoviesFilterDialog;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getMovieFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    return-object v0
.end method

.method protected getGenres(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Ljava/util/List;
    .locals 1
    .param p1, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation

    .prologue
    .line 17
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getPublicMovieGenres()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method protected processSavedInstanceState(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 13
    return-void
.end method
