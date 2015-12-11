.class public Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
.super Ljava/lang/Object;
.source "DibicProgramFilter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    }
.end annotation


# instance fields
.field private currentAlphaFilters:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private currentGenreFilters:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private currentNetworkFilters:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private currentProgramTypeFilters:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private downloadableOn:Z

.field private filterChangeListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            ">;>;"
        }
    .end annotation
.end field

.field private hideLockedOn:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->filterChangeListeners:Ljava/util/List;

    .line 21
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    .line 23
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    .line 25
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    .line 27
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    .line 38
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 2
    .param p1, "value"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->filterChangeListeners:Ljava/util/List;

    .line 21
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    .line 23
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    .line 25
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    .line 27
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    .line 44
    new-instance v0, Ljava/util/HashMap;

    iget-object v1, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    .line 45
    new-instance v0, Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentAlphaFilters()Ljava/util/HashMap;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    .line 46
    new-instance v0, Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    .line 47
    new-instance v0, Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentProgramTypeFilters()Ljava/util/HashMap;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    .line 48
    iget-boolean v0, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->hideLockedOn:Z

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->hideLockedOn:Z

    .line 49
    iget-boolean v0, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->downloadableOn:Z

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->downloadableOn:Z

    .line 50
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->filterChangeListeners:Ljava/util/List;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->filterChangeListeners:Ljava/util/List;

    .line 51
    return-void
.end method

.method private matches(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Z
    .locals 9
    .param p1, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .param p2, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 169
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentGenreFilters()Ljava/util/HashMap;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-static {v7}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->nullOrEmpty(Ljava/util/Collection;)Z

    move-result v7

    if-nez v7, :cond_0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentGenreFilters()Ljava/util/HashMap;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getGenreIds()Ljava/util/Set;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->containsAny(Ljava/util/Collection;Ljava/util/Collection;)Z

    move-result v7

    if-eqz v7, :cond_2

    :cond_0
    move v4, v6

    .line 170
    .local v4, "matches":Z
    :goto_0
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    invoke-virtual {v7}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    .line 171
    .local v0, "alphaFilters":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    invoke-static {v0}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->nullOrEmpty(Ljava/util/Collection;)Z

    move-result v7

    if-nez v7, :cond_1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getSortTitle()Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v7, v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->titleStartsWithAny(Ljava/lang/String;Ljava/util/Collection;)Z

    move-result v7

    if-eqz v7, :cond_3

    :cond_1
    move v7, v6

    :goto_1
    and-int/2addr v4, v7

    .line 173
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v2

    .line 174
    .local v2, "companyIdStrings":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 175
    .local v3, "companyIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 176
    .local v1, "companyIdString":Ljava/lang/String;
    invoke-static {v1}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v3, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .end local v0    # "alphaFilters":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    .end local v1    # "companyIdString":Ljava/lang/String;
    .end local v2    # "companyIdStrings":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    .end local v3    # "companyIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    .end local v4    # "matches":Z
    :cond_2
    move v4, v5

    .line 169
    goto :goto_0

    .restart local v0    # "alphaFilters":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    .restart local v4    # "matches":Z
    :cond_3
    move v7, v5

    .line 171
    goto :goto_1

    .line 179
    .restart local v2    # "companyIdStrings":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    .restart local v3    # "companyIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    :cond_4
    invoke-static {v3}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->nullOrEmpty(Ljava/util/Collection;)Z

    move-result v7

    if-nez v7, :cond_5

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getNetworkCompanyIds()Ljava/util/List;

    move-result-object v7

    invoke-static {v3, v7}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->containsAny(Ljava/util/Collection;Ljava/util/Collection;)Z

    move-result v7

    if-eqz v7, :cond_b

    :cond_5
    move v7, v6

    :goto_3
    and-int/2addr v4, v7

    .line 180
    iget-boolean v7, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->hideLockedOn:Z

    if-eqz v7, :cond_6

    invoke-virtual {p2, p1}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v7

    if-eqz v7, :cond_c

    :cond_6
    move v7, v6

    :goto_4
    and-int/2addr v4, v7

    .line 181
    iget-boolean v7, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->downloadableOn:Z

    if-eqz v7, :cond_7

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isDownloadable()Z

    move-result v7

    if-eqz v7, :cond_d

    :cond_7
    move v7, v6

    :goto_5
    and-int/2addr v4, v7

    .line 182
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentProgramTypeFilters()Ljava/util/HashMap;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-static {v7}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->nullOrEmpty(Ljava/util/Collection;)Z

    move-result v7

    if-nez v7, :cond_9

    .line 183
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentProgramTypeFilters()Ljava/util/HashMap;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v7

    const-string v8, "movies"

    invoke-interface {v7, v8}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_8

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v7

    if-nez v7, :cond_9

    .line 184
    :cond_8
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentProgramTypeFilters()Ljava/util/HashMap;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v7

    const-string v8, "movies"

    invoke-interface {v7, v8}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_a

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v7

    if-nez v7, :cond_a

    :cond_9
    move v5, v6

    :cond_a
    and-int/2addr v4, v5

    .line 186
    return v4

    :cond_b
    move v7, v5

    .line 179
    goto :goto_3

    :cond_c
    move v7, v5

    .line 180
    goto :goto_4

    :cond_d
    move v7, v5

    .line 181
    goto :goto_5
.end method

.method private titleStartsWithAny(Ljava/lang/String;Ljava/util/Collection;)Z
    .locals 3
    .param p1, "title"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 190
    .local p2, "strings":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 191
    .local v0, "string":Ljava/lang/String;
    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 192
    const/4 v1, 0x1

    .line 195
    .end local v0    # "string":Ljava/lang/String;
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected addEntry(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "label"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 244
    .local p3, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {p3, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 245
    invoke-interface {p3, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 246
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->notifyOnChangeListeners()V

    .line 248
    :cond_0
    return-void
.end method

.method public addToSelectedList(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "label"    # Ljava/lang/String;
    .param p3, "category"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .prologue
    .line 125
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$1;->$SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory:[I

    invoke-virtual {p3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 139
    :goto_0
    return-void

    .line 127
    :pswitch_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    invoke-virtual {p0, p1, p2, v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->addEntry(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 130
    :pswitch_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    invoke-virtual {p0, p1, p2, v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->addEntry(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 133
    :pswitch_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    invoke-virtual {p0, p1, p2, v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->addEntry(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 136
    :pswitch_3
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    invoke-virtual {p0, p1, p2, v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->addEntry(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 125
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public clearAllFilters()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 211
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 212
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 213
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 214
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 215
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->hideLockedOn:Z

    .line 216
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->downloadableOn:Z

    .line 217
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->notifyOnChangeListeners()V

    .line 218
    return-void
.end method

.method public clearFiltersForCategory(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 1
    .param p1, "category"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .prologue
    .line 142
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getFiltersForCategory(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 143
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->notifyOnChangeListeners()V

    .line 144
    return-void
.end method

.method public empty()Z
    .locals 1

    .prologue
    .line 221
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    if-gtz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    if-gtz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    if-gtz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    if-gtz v0, :cond_0

    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->hideLockedOn:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->downloadableOn:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentAlphaFilters()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    return-object v0
.end method

.method public getCurrentGenreFilters()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    return-object v0
.end method

.method public getCurrentNetworkFilters()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    return-object v0
.end method

.method public getCurrentProgramTypeFilters()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 78
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    return-object v0
.end method

.method public getFilteredPrograms(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Ljava/util/List;
    .locals 4
    .param p2, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 199
    .local p1, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 201
    .local v0, "filteredPrograms":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 202
    .local v1, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-direct {p0, v1, p2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->matches(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 203
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 207
    .end local v1    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_1
    return-object v0
.end method

.method public getFiltersForCategory(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)Ljava/util/Map;
    .locals 4
    .param p1, "category"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 148
    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$1;->$SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory:[I

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 162
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Was not expecting category: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 150
    :pswitch_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    .line 165
    .local v0, "currentFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return-object v0

    .line 153
    .end local v0    # "currentFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :pswitch_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    .line 154
    .restart local v0    # "currentFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    goto :goto_0

    .line 156
    .end local v0    # "currentFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :pswitch_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    .line 157
    .restart local v0    # "currentFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    goto :goto_0

    .line 159
    .end local v0    # "currentFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :pswitch_3
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    .line 160
    .restart local v0    # "currentFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    goto :goto_0

    .line 148
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public isDownloadableOn()Z
    .locals 1

    .prologue
    .line 94
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->downloadableOn:Z

    return v0
.end method

.method public isHideLockOn()Z
    .locals 1

    .prologue
    .line 82
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->hideLockedOn:Z

    return v0
.end method

.method protected notifyOnChangeListeners()V
    .locals 3

    .prologue
    .line 238
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->filterChangeListeners:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    .line 239
    .local v0, "filterChangeListener":Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;, "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener<Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;>;"
    invoke-interface {v0, p0}, Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;->onFilterChange(Ljava/lang/Object;)V

    goto :goto_0

    .line 241
    .end local v0    # "filterChangeListener":Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;, "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener<Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;>;"
    :cond_0
    return-void
.end method

.method public registerOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 54
    .local p1, "listener":Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;, "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener<Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->filterChangeListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method protected removeEntry(Ljava/lang/String;Ljava/util/Map;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;)V"
        }
    .end annotation

    .prologue
    .line 251
    .local p2, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    invoke-interface {p2, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 252
    invoke-interface {p2, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 253
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->notifyOnChangeListeners()V

    .line 255
    :cond_0
    return-void
.end method

.method public removeFromSelectedList(Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "category"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    .prologue
    .line 106
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$1;->$SwitchMap$com$xfinity$playerlib$view$browseprograms$DibicProgramFilter$FilterCategory:[I

    invoke-virtual {p2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 120
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected SearchCategory: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 108
    :pswitch_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    invoke-virtual {p0, p1, v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->removeEntry(Ljava/lang/String;Ljava/util/Map;)V

    .line 122
    :goto_0
    return-void

    .line 111
    :pswitch_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    invoke-virtual {p0, p1, v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->removeEntry(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 114
    :pswitch_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    invoke-virtual {p0, p1, v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->removeEntry(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 117
    :pswitch_3
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    invoke-virtual {p0, p1, v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->removeEntry(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 106
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public setDownloadableOn(Z)V
    .locals 1
    .param p1, "on"    # Z

    .prologue
    .line 98
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->downloadableOn:Z

    if-eq v0, p1, :cond_0

    .line 99
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->downloadableOn:Z

    .line 100
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->notifyOnChangeListeners()V

    .line 102
    :cond_0
    return-void
.end method

.method public setHideLockOn(Z)V
    .locals 1
    .param p1, "on"    # Z

    .prologue
    .line 87
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->hideLockedOn:Z

    if-eq v0, p1, :cond_0

    .line 88
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->hideLockedOn:Z

    .line 89
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->notifyOnChangeListeners()V

    .line 91
    :cond_0
    return-void
.end method

.method public unregisterOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z
    .locals 1
    .param p1, "listener"    # Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->filterChangeListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public updateWith(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 1
    .param p1, "backupFilter"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 226
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentGenreFilters:Ljava/util/HashMap;

    .line 227
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentAlphaFilters:Ljava/util/HashMap;

    .line 228
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->filterChangeListeners:Ljava/util/List;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->filterChangeListeners:Ljava/util/List;

    .line 229
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentNetworkFilters:Ljava/util/HashMap;

    .line 230
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->currentProgramTypeFilters:Ljava/util/HashMap;

    .line 231
    iget-boolean v0, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->hideLockedOn:Z

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->hideLockedOn:Z

    .line 232
    iget-boolean v0, p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->downloadableOn:Z

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->downloadableOn:Z

    .line 234
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->notifyOnChangeListeners()V

    .line 235
    return-void
.end method
