.class public Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;
.super Lcom/xfinity/playerlib/model/dibic/AbstractDibicResource;
.source "DefaultDibicResource.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final allPrograms:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field private final processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

.field private final titleIndex:Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V
    .locals 2
    .param p2, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .param p3, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/user/PlayNowUserManager;",
            ")V"
        }
    .end annotation

    .prologue
    .line 36
    .local p1, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/dibic/AbstractDibicResource;-><init>()V

    .line 37
    iput-object p3, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 38
    invoke-static {p1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->allPrograms:Ljava/util/List;

    .line 40
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processPrograms(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    .line 42
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    iget-object v1, v1, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->nonAdultPrograms:Ljava/util/List;

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;-><init>(Ljava/util/List;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->titleIndex:Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;

    .line 43
    return-void
.end method

.method private addOrUpdate(Ljava/util/Map;Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 3
    .param p2, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .param p3, "genre"    # Ljava/lang/String;
    .param p4, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;>;",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ")V"
        }
    .end annotation

    .prologue
    .line 170
    .local p1, "ngMaps":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/tags/Network;Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;>;"
    invoke-interface {p1, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 172
    .local v1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    if-nez v1, :cond_0

    .line 173
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 174
    .local v2, "progList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface {v2, p4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 175
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 176
    .local v0, "genreMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-interface {v0, p3, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    invoke-interface {p1, p2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 188
    .end local v0    # "genreMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    :goto_0
    return-void

    .line 179
    .end local v2    # "progList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_0
    invoke-interface {v1, p3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 180
    .restart local v2    # "progList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-nez v2, :cond_1

    .line 181
    new-instance v2, Ljava/util/ArrayList;

    .end local v2    # "progList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 182
    .restart local v2    # "progList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface {v2, p4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 183
    invoke-interface {v1, p3, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 185
    :cond_1
    invoke-interface {v2, p4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private isAdultContentEnabledInSettings()Z
    .locals 5

    .prologue
    .line 70
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 72
    .local v2, "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsAdultContent()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 79
    .end local v2    # "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    .local v1, "returnValue":Z
    :goto_0
    return v1

    .line 74
    .end local v1    # "returnValue":Z
    :catch_0
    move-exception v0

    .line 75
    .local v0, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Cannot check settings for the wants adult content flag"

    invoke-interface {v3, v4, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 76
    const/4 v1, 0x0

    .restart local v1    # "returnValue":Z
    goto :goto_0
.end method

.method private processPrograms(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;
    .locals 19
    .param p2, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ")",
            "Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;"
        }
    .end annotation

    .prologue
    .line 191
    .local p1, "input":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    new-instance v9, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    const/4 v15, 0x0

    move-object/from16 v0, p0

    invoke-direct {v9, v0, v15}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;-><init>(Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$1;)V

    .line 193
    .local v9, "items":Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v5

    .line 194
    .local v5, "filtered":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    .line 195
    .local v2, "adultGenres":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v10

    .line 196
    .local v10, "merlinIdMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v3

    .line 197
    .local v3, "adultMerlinIdMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v12

    .line 198
    .local v12, "networkGenreMaps":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/tags/Network;Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;>;"
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v4

    .line 200
    .local v4, "adultNetworkGenreMaps":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/tags/Network;Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;>;"
    new-instance v14, Ljava/util/HashSet;

    invoke-direct {v14}, Ljava/util/HashSet;-><init>()V

    .line 203
    .local v14, "publicGenres":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface/range {p2 .. p2}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getPublicMovieGenres()Ljava/util/List;

    move-result-object v15

    invoke-interface {v15}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :goto_0
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_0

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 204
    .local v6, "g":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-interface {v14, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 206
    .end local v6    # "g":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    :cond_0
    invoke-interface/range {p2 .. p2}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getPublicTvGenres()Ljava/util/List;

    move-result-object v15

    invoke-interface {v15}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :goto_1
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_1

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 207
    .restart local v6    # "g":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-interface {v14, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 210
    .end local v6    # "g":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    :cond_1
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :cond_2
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v16

    if-eqz v16, :cond_b

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 212
    .local v13, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v8

    .line 214
    .local v8, "isMovie":Z
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isAdult()Z

    move-result v16

    if-nez v16, :cond_3

    .line 215
    invoke-interface {v5, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 216
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-interface {v10, v0, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 219
    :cond_3
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getNetworks()Ljava/util/Set;

    move-result-object v16

    invoke-interface/range {v16 .. v16}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :cond_4
    :goto_2
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_2

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/xfinity/playerlib/model/tags/Network;

    .line 220
    .local v11, "network":Lcom/xfinity/playerlib/model/tags/Network;
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isAdult()Z

    move-result v17

    if-eqz v17, :cond_6

    .line 221
    invoke-virtual {v11}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v17

    if-eqz v17, :cond_4

    .line 222
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getGenreIds()Ljava/util/Set;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v17

    :cond_5
    :goto_3
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_4

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 223
    .local v7, "genre":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-direct {v0, v4, v11, v7, v13}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->addOrUpdate(Ljava/util/Map;Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    .line 224
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-interface {v3, v0, v13}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 226
    invoke-interface {v14, v7}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v18

    if-nez v18, :cond_5

    .line 227
    invoke-interface {v2, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 232
    .end local v7    # "genre":Ljava/lang/String;
    :cond_6
    invoke-virtual {v11}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v17

    if-eqz v17, :cond_7

    .line 233
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getGenreIds()Ljava/util/Set;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v17

    :goto_4
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_7

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 234
    .restart local v7    # "genre":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-direct {v0, v12, v11, v7, v13}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->addOrUpdate(Ljava/util/Map;Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    .line 235
    move-object/from16 v0, p0

    invoke-direct {v0, v4, v11, v7, v13}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->addOrUpdate(Ljava/util/Map;Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    goto :goto_4

    .line 244
    .end local v7    # "genre":Ljava/lang/String;
    :cond_7
    invoke-virtual {v11}, Lcom/xfinity/playerlib/model/tags/Network;->getCategories()Ljava/util/List;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Ljava/util/List;->size()I

    move-result v17

    if-eqz v17, :cond_8

    invoke-virtual {v11}, Lcom/xfinity/playerlib/model/tags/Network;->hasAllMoviesCategory()Z

    move-result v17

    if-eqz v17, :cond_9

    :cond_8
    if-eqz v8, :cond_9

    .line 245
    sget-object v17, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v12, v11, v1, v13}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->addOrUpdate(Ljava/util/Map;Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    .line 246
    sget-object v17, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v4, v11, v1, v13}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->addOrUpdate(Ljava/util/Map;Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    goto/16 :goto_2

    .line 247
    :cond_9
    invoke-virtual {v11}, Lcom/xfinity/playerlib/model/tags/Network;->getCategories()Ljava/util/List;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Ljava/util/List;->size()I

    move-result v17

    if-eqz v17, :cond_a

    invoke-virtual {v11}, Lcom/xfinity/playerlib/model/tags/Network;->hasAllTvCategory()Z

    move-result v17

    if-eqz v17, :cond_4

    :cond_a
    if-nez v8, :cond_4

    .line 248
    sget-object v17, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v12, v11, v1, v13}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->addOrUpdate(Ljava/util/Map;Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    .line 249
    sget-object v17, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v4, v11, v1, v13}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->addOrUpdate(Ljava/util/Map;Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    goto/16 :goto_2

    .line 255
    .end local v8    # "isMovie":Z
    .end local v11    # "network":Lcom/xfinity/playerlib/model/tags/Network;
    .end local v13    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_b
    invoke-static {v2}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v15

    iput-object v15, v9, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->adultGenres:Ljava/util/Set;

    .line 256
    invoke-static {v5}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v15

    iput-object v15, v9, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->nonAdultPrograms:Ljava/util/List;

    .line 257
    invoke-static {v10}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v15

    iput-object v15, v9, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->merlinIdMap:Ljava/util/Map;

    .line 258
    invoke-static {v3}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v15

    iput-object v15, v9, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->adultMerlinIdMap:Ljava/util/Map;

    .line 259
    invoke-static {v12}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v15

    iput-object v15, v9, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->networkGenreMaps:Ljava/util/Map;

    .line 260
    invoke-static {v4}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v15

    iput-object v15, v9, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->adultNetworkGenreMaps:Ljava/util/Map;

    .line 262
    return-object v9
.end method


# virtual methods
.method public getGenreMapForNetwork(Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;
    .locals 2
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 100
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->isAdultContentEnabledInSettings()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 101
    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    iget-object v1, v1, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->adultNetworkGenreMaps:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 106
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    :goto_0
    if-nez v0, :cond_0

    .line 107
    new-instance v0, Ljava/util/HashMap;

    .end local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 109
    .restart local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    :cond_0
    return-object v0

    .line 103
    .end local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    iget-object v1, v1, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->networkGenreMaps:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .restart local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    goto :goto_0
.end method

.method public getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .locals 2
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 52
    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    iget-object v1, v1, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->merlinIdMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 54
    .local v0, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->isAdultContentEnabledInSettings()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 55
    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    iget-object v1, v1, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->adultMerlinIdMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 58
    .restart local v0    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_0
    return-object v0
.end method

.method public getPrograms()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->nonAdultPrograms:Ljava/util/List;

    return-object v0
.end method

.method public getProgramsMatchingGenresAndNetwork(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;
    .locals 9
    .param p2, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ")",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 115
    .local p1, "genres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    new-instance v5, Ljava/util/TreeMap;

    invoke-direct {v5}, Ljava/util/TreeMap;-><init>()V

    .line 119
    .local v5, "results":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v6

    if-nez v6, :cond_3

    .line 121
    :cond_0
    invoke-virtual {p0, p2}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->getProgramsMatchingNetwork(Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/List;

    move-result-object v4

    .line 123
    .local v4, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-eqz v4, :cond_1

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v6

    if-lez v6, :cond_1

    .line 124
    const/4 v6, 0x0

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 125
    sget-object v6, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-interface {v5, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 157
    .end local v4    # "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_1
    :goto_0
    return-object v5

    .line 127
    .restart local v4    # "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_2
    sget-object v6, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-interface {v5, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 132
    .end local v4    # "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_3
    const/4 v2, 0x0

    .line 133
    .local v2, "hasAdultGenre":Z
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_4
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_5

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 134
    .local v1, "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    iget-object v7, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    iget-object v7, v7, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->adultGenres:Ljava/util/Set;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 135
    const/4 v2, 0x1

    .line 141
    .end local v1    # "genre":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    :cond_5
    if-eqz v2, :cond_7

    .line 142
    invoke-virtual {p0, p2}, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->getGenreMapForNetwork(Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;

    move-result-object v0

    .line 147
    .local v0, "cached":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    :goto_1
    if-eqz v0, :cond_1

    .line 148
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_6
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 149
    .local v3, "key":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v0, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 150
    .restart local v4    # "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-eqz v4, :cond_6

    .line 151
    invoke-interface {v5, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 144
    .end local v0    # "cached":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    .end local v3    # "key":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .end local v4    # "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_7
    iget-object v6, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    iget-object v6, v6, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->networkGenreMaps:Ljava/util/Map;

    invoke-interface {v6, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .restart local v0    # "cached":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    goto :goto_1
.end method

.method public getProgramsMatchingNetwork(Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/List;
    .locals 4
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 84
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 88
    .local v1, "programList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->processedItems:Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;

    iget-object v2, v2, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource$ProcessedItems;->nonAdultPrograms:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 89
    .local v0, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getNetworks()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 90
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 94
    .end local v0    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_1
    return-object v1
.end method

.method public getProgramsMatchingTitleFilter(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p1, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DefaultDibicResource;->titleIndex:Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/dibic/DibicTitleIndex;->getSublistMatchingTitleQuery(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
