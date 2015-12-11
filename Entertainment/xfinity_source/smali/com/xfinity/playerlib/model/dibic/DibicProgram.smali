.class public abstract Lcom/xfinity/playerlib/model/dibic/DibicProgram;
.super Ljava/lang/Object;
.source "DibicProgram.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/Program;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;
    }
.end annotation


# static fields
.field private static final FORBIDDEN_WORDS:[Ljava/lang/String;


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private bitFields:I

.field private companyIdKeys:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private daysOfWeekKey:I

.field private dictionary:Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

.field private firstVideoExpirationDate:J

.field private genreKeys:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private lastVideoExpirationDate:J

.field private longFormCount:I

.field private merlinId:J

.field private networkKeys:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private networks:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field

.field private popularity:I

.field private providerCodesKeys:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private releaseYear:I

.field private sortTitle:Ljava/lang/String;

.field private tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

.field private title:Ljava/lang/String;

.field private titleKey:I

.field private trailerCount:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 49
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "A "

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "An "

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "The "

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "\'"

    aput-object v2, v0, v1

    sput-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->FORBIDDEN_WORDS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->LOG:Lorg/slf4j/Logger;

    .line 26
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networks:Ljava/util/Set;

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->providerCodesKeys:Ljava/util/List;

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networkKeys:Ljava/util/List;

    .line 56
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->genreKeys:Ljava/util/List;

    .line 57
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->companyIdKeys:Ljava/util/List;

    return-void
.end method

.method private bitFieldsContain(Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;)Z
    .locals 2
    .param p1, "flag"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    .prologue
    .line 235
    iget v0, p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->bitMask:I

    .line 236
    .local v0, "bitMask":I
    iget v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFields:I

    and-int/2addr v1, v0

    if-ne v1, v0, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method getBitFieldsForTestingOnly()I
    .locals 1

    .prologue
    .line 265
    iget v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFields:I

    return v0
.end method

.method public getDaysOfWeek()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 184
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->dictionary:Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

    iget v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->daysOfWeekKey:I

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->getStringsByKey(I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getFirstVideoExpirationDate()J
    .locals 2

    .prologue
    .line 196
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->firstVideoExpirationDate:J

    return-wide v0
.end method

.method public getFlags()Ljava/util/Set;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 225
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v1

    .line 226
    .local v1, "flags":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;>;"
    invoke-static {}, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->values()[Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    move-result-object v3

    array-length v4, v3

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v4, :cond_1

    aget-object v0, v3, v2

    .line 227
    .local v0, "flag":Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFieldsContain(Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 228
    invoke-interface {v1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 226
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 231
    .end local v0    # "flag":Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;
    :cond_1
    return-object v1
.end method

.method public getGenreIds()Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 168
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v1

    .line 169
    .local v1, "genres":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->genreKeys:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 170
    .local v0, "genreKey":Ljava/lang/Integer;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->dictionary:Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->getStringsByKey(I)Ljava/util/List;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 172
    .end local v0    # "genreKey":Ljava/lang/Integer;
    :cond_0
    return-object v1
.end method

.method public getGenres()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation

    .prologue
    .line 176
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 177
    .local v1, "genres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getGenreIds()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 178
    .local v0, "genreId":Ljava/lang/String;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    invoke-interface {v3, v0}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getGenreById(Ljava/lang/String;)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 180
    .end local v0    # "genreId":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method public getLastVideoExpirationDate()J
    .locals 2

    .prologue
    .line 200
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->lastVideoExpirationDate:J

    return-wide v0
.end method

.method public getLongFormCount()I
    .locals 1

    .prologue
    .line 188
    iget v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->longFormCount:I

    return v0
.end method

.method public getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 4

    .prologue
    .line 118
    new-instance v0, Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinIdNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v1

    iget-wide v2, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->merlinId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V

    return-object v0
.end method

.method public getNetworkCompanyIds()Ljava/util/List;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 149
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 150
    .local v5, "companyIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    iget-object v7, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->companyIdKeys:Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    .line 151
    .local v2, "companyIdKey":Ljava/lang/Integer;
    iget-object v8, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->dictionary:Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->getStringsByKey(I)Ljava/util/List;

    move-result-object v4

    .line 152
    .local v4, "companyIdStrings":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 154
    .local v3, "companyIdString":Ljava/lang/String;
    :try_start_0
    invoke-static {v3}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 155
    .local v0, "companyId":J
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-interface {v5, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 156
    .end local v0    # "companyId":J
    :catch_0
    move-exception v6

    .line 157
    .local v6, "e":Ljava/lang/NumberFormatException;
    iget-object v9, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->LOG:Lorg/slf4j/Logger;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "No company id found for key: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v9, v10}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 161
    .end local v2    # "companyIdKey":Ljava/lang/Integer;
    .end local v3    # "companyIdString":Ljava/lang/String;
    .end local v4    # "companyIdStrings":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v6    # "e":Ljava/lang/NumberFormatException;
    :cond_1
    return-object v5
.end method

.method public getNetworks()Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation

    .prologue
    .line 141
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networks:Ljava/util/Set;

    if-nez v0, :cond_0

    .line 142
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getNetworkCompanyIds()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworksByCompanyIds(Ljava/util/List;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networks:Ljava/util/Set;

    .line 144
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networks:Ljava/util/Set;

    return-object v0
.end method

.method public getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 123
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    return-object v0
.end method

.method public getPopularity()I
    .locals 1

    .prologue
    .line 220
    iget v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->popularity:I

    return v0
.end method

.method public getProviderCodes()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 131
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 132
    .local v1, "providerCodesKeysList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->providerCodesKeys:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 133
    .local v0, "providerCodesKey":Ljava/lang/Integer;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->dictionary:Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->getStringsByKey(I)Ljava/util/List;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 136
    .end local v0    # "providerCodesKey":Ljava/lang/Integer;
    :cond_0
    return-object v1
.end method

.method public getReleaseYear()I
    .locals 1

    .prologue
    .line 127
    iget v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->releaseYear:I

    return v0
.end method

.method public getSortTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->sortTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->title:Ljava/lang/String;

    return-object v0
.end method

.method getTitleWords()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 114
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->dictionary:Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

    iget v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->titleKey:I

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->getStringsByKey(I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getTrailerCount()I
    .locals 1

    .prologue
    .line 192
    iget v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->trailerCount:I

    return v0
.end method

.method public isAdult()Z
    .locals 1

    .prologue
    .line 208
    sget-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->ADULT:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFieldsContain(Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;)Z

    move-result v0

    return v0
.end method

.method public isDownloadable()Z
    .locals 1

    .prologue
    .line 212
    sget-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->DOWNLOADABLE:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFieldsContain(Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;)Z

    move-result v0

    return v0
.end method

.method public isKids()Z
    .locals 1

    .prologue
    .line 216
    sget-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->KIDS:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFieldsContain(Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;)Z

    move-result v0

    return v0
.end method

.method public abstract isMovie()Z
.end method

.method public isNew()Z
    .locals 1

    .prologue
    .line 204
    sget-object v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->NEW:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFieldsContain(Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;)Z

    move-result v0

    return v0
.end method

.method public merge(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 4
    .param p1, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 242
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networkKeys:Ljava/util/List;

    iget-object v1, p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networkKeys:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 243
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->companyIdKeys:Ljava/util/List;

    iget-object v1, p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->companyIdKeys:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 244
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->genreKeys:Ljava/util/List;

    iget-object v1, p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->genreKeys:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 245
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->providerCodesKeys:Ljava/util/List;

    iget-object v1, p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->providerCodesKeys:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 247
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networks:Ljava/util/Set;

    if-nez v0, :cond_1

    .line 248
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getNetworks()Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networks:Ljava/util/Set;

    .line 253
    :goto_0
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->firstVideoExpirationDate:J

    iget-wide v2, p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->firstVideoExpirationDate:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->firstVideoExpirationDate:J

    .line 254
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->lastVideoExpirationDate:J

    iget-wide v2, p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->lastVideoExpirationDate:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->lastVideoExpirationDate:J

    .line 255
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isDownloadable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 256
    iget v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFields:I

    sget-object v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->DOWNLOADABLE:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    iget v1, v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->bitMask:I

    or-int/2addr v0, v1

    iput v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFields:I

    .line 258
    :cond_0
    return-void

    .line 250
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networks:Ljava/util/Set;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getNetworks()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    goto :goto_0
.end method

.method public parse(Lorg/apache/commons/io/input/SwappedDataInputStream;)V
    .locals 2
    .param p1, "inputStream"    # Lorg/apache/commons/io/input/SwappedDataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 70
    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->merlinId:J

    .line 71
    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->titleKey:I

    .line 72
    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->releaseYear:I

    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->providerCodesKeys:Ljava/util/List;

    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 74
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->networkKeys:Ljava/util/List;

    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 75
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->genreKeys:Ljava/util/List;

    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 76
    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->daysOfWeekKey:I

    .line 77
    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFields:I

    .line 78
    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->longFormCount:I

    .line 79
    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->trailerCount:I

    .line 80
    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->firstVideoExpirationDate:J

    .line 81
    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->lastVideoExpirationDate:J

    .line 82
    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->popularity:I

    .line 83
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->companyIdKeys:Ljava/util/List;

    invoke-virtual {p1}, Lorg/apache/commons/io/input/SwappedDataInputStream;->readInt()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 84
    return-void
.end method

.method public populateStrings()V
    .locals 6

    .prologue
    .line 87
    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->dictionary:Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

    iget v2, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->titleKey:I

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/dibic/DibicDictionary;->getStringByKey(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->title:Ljava/lang/String;

    .line 88
    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->title:Ljava/lang/String;

    iput-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->sortTitle:Ljava/lang/String;

    .line 89
    sget-object v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->FORBIDDEN_WORDS:[Ljava/lang/String;

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 90
    .local v0, "word":Ljava/lang/String;
    iget-object v4, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->title:Ljava/lang/String;

    invoke-virtual {v4, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 91
    iget-object v4, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->title:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->sortTitle:Ljava/lang/String;

    .line 92
    iget-object v4, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->sortTitle:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->sortTitle:Ljava/lang/String;

    .line 89
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 95
    .end local v0    # "word":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method setBitFieldsForTestingOnly(I)V
    .locals 0
    .param p1, "fields"    # I

    .prologue
    .line 261
    iput p1, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFields:I

    .line 262
    return-void
.end method

.method public setDictionary(Lcom/xfinity/playerlib/model/dibic/DibicDictionary;)V
    .locals 0
    .param p1, "dictionary"    # Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

    .prologue
    .line 98
    iput-object p1, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->dictionary:Lcom/xfinity/playerlib/model/dibic/DibicDictionary;

    .line 99
    return-void
.end method

.method setDownloadable(Z)V
    .locals 2
    .param p1, "downloadable"    # Z

    .prologue
    .line 269
    if-eqz p1, :cond_0

    .line 270
    iget v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFields:I

    sget-object v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->DOWNLOADABLE:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    iget v1, v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->bitMask:I

    or-int/2addr v0, v1

    iput v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFields:I

    .line 274
    :goto_0
    return-void

    .line 272
    :cond_0
    iget v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFields:I

    sget-object v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->DOWNLOADABLE:Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;

    iget v1, v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram$Flags;->bitMask:I

    xor-int/lit8 v1, v1, -0x1

    and-int/2addr v0, v1

    iput v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->bitFields:I

    goto :goto_0
.end method

.method public setTagsRoot(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)V
    .locals 0
    .param p1, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 103
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 278
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "merlinId"

    .line 279
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "title"

    .line 280
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "programArtId"

    .line 281
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    .line 282
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
