.class public Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;
.super Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;
.source "NetworkProgramsFilterDialog.java"


# instance fields
.field private categoryId:Ljava/lang/String;

.field private companyId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;-><init>()V

    return-void
.end method

.method public static createBundle(Ljava/lang/Long;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 4
    .param p0, "companyId"    # Ljava/lang/Long;
    .param p1, "categoryId"    # Ljava/lang/String;

    .prologue
    .line 79
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 80
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "companyId"

    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 81
    const-string v1, "categoryId"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    return-object v0
.end method


# virtual methods
.method protected createBrowseFilterCategoriesPanel()Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    .locals 1

    .prologue
    .line 87
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->isDualPanel:Z

    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel;->newInstance(Z)Lcom/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel;

    move-result-object v0

    return-object v0
.end method

.method protected getFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 4

    .prologue
    .line 75
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    iget-wide v2, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->companyId:J

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->categoryId:Ljava/lang/String;

    invoke-virtual {v0, v2, v3, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getNetworkProgramsFilter(JLjava/lang/String;)Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    return-object v0
.end method

.method protected getGenres(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Ljava/util/List;
    .locals 4
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
    .line 53
    iget-wide v2, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->companyId:J

    invoke-interface {p1, v2, v3}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworkByCompanyId(J)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v1

    .line 55
    .local v1, "network":Lcom/xfinity/playerlib/model/tags/Network;
    const/4 v0, 0x0

    .line 56
    .local v0, "genres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->categoryId:Ljava/lang/String;

    sget-object v3, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 57
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/tags/Network;->getMovieGenres()Ljava/util/List;

    move-result-object v0

    .line 62
    :cond_0
    :goto_0
    invoke-static {v0}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->nullOrEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 63
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getPublicMovieGenres()Ljava/util/List;

    move-result-object v0

    .line 65
    :cond_1
    return-object v0

    .line 58
    :cond_2
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->categoryId:Ljava/lang/String;

    sget-object v3, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 59
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getPublicTvGenres()Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 22
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->onCreate(Landroid/os/Bundle;)V

    .line 25
    iget-wide v2, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->companyId:J

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->categoryId:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 26
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 27
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "companyId"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->companyId:J

    .line 28
    const-string v1, "categoryId"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->categoryId:Ljava/lang/String;

    .line 31
    .end local v0    # "bundle":Landroid/os/Bundle;
    :cond_0
    iget-wide v2, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->companyId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->categoryId:Ljava/lang/String;

    invoke-static {v1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 33
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 46
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 47
    const-string v0, "categoryId"

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->categoryId:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    const-string v0, "companyId"

    iget-wide v2, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->companyId:J

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 49
    return-void
.end method

.method protected processSavedInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 37
    const-string v0, "companyId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->companyId:J

    .line 38
    const-string v0, "categoryId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->categoryId:Ljava/lang/String;

    .line 40
    iget-wide v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->companyId:J

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->categoryId:Ljava/lang/String;

    invoke-static {v0}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    return-void
.end method
