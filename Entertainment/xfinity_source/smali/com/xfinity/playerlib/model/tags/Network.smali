.class public final Lcom/xfinity/playerlib/model/tags/Network;
.super Ljava/lang/Object;
.source "Network.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Lcom/xfinity/playerlib/model/tags/Tag;
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable;",
        "Lcom/xfinity/playerlib/model/tags/Tag;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/xfinity/playerlib/model/tags/Network;",
        ">;"
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final categories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private categoryMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private final companyId:J

.field private final featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

.field private final hasAllMoviesCategory:Z

.field private final hasAllTvCategory:Z

.field private final id:Ljava/lang/String;

.field private final isPremium:Z

.field private final movieGenres:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private final name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 124
    new-instance v0, Lcom/xfinity/playerlib/model/tags/Network$1;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/tags/Network$1;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/model/tags/Network;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(JLcom/xfinity/playerlib/model/tags/FeaturedShow;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/util/List;)V
    .locals 7
    .param p1, "companyId"    # J
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "companyId"
        .end annotation
    .end param
    .param p3, "featuredShow"    # Lcom/xfinity/playerlib/model/tags/FeaturedShow;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "featuredShow"
        .end annotation
    .end param
    .param p4, "id"    # Ljava/lang/String;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "id"
        .end annotation
    .end param
    .param p5    # Ljava/util/List;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "movieTags"
        .end annotation
    .end param
    .param p6, "name"    # Ljava/lang/String;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "name"
        .end annotation
    .end param
    .param p7, "isPremium"    # Z
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "premium"
        .end annotation
    .end param
    .param p8    # Ljava/util/List;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "tabs"
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Lcom/xfinity/playerlib/model/tags/FeaturedShow;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;",
            "Ljava/lang/String;",
            "Z",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 35
    .local p5, "movieGenres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    .local p8, "categories":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    new-instance v3, Ljava/util/TreeMap;

    invoke-direct {v3}, Ljava/util/TreeMap;-><init>()V

    iput-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->categoryMap:Ljava/util/Map;

    .line 37
    if-nez p5, :cond_0

    new-instance p5, Ljava/util/ArrayList;

    .end local p5    # "movieGenres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-direct {p5}, Ljava/util/ArrayList;-><init>()V

    .line 38
    .restart local p5    # "movieGenres":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    :cond_0
    if-nez p8, :cond_1

    new-instance p8, Ljava/util/ArrayList;

    .end local p8    # "categories":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-direct {p8}, Ljava/util/ArrayList;-><init>()V

    .line 40
    .restart local p8    # "categories":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    :cond_1
    invoke-static {p5}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 41
    invoke-static {p8}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 43
    const/4 v1, 0x0

    .line 44
    .local v1, "moviesCategoryPresent":Z
    const/4 v2, 0x0

    .line 46
    .local v2, "tvCategoryPresent":Z
    invoke-interface {p8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 47
    .local v0, "category":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 48
    const/4 v1, 0x1

    .line 52
    :cond_2
    :goto_1
    iget-object v4, p0, Lcom/xfinity/playerlib/model/tags/Network;->categoryMap:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 49
    :cond_3
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 50
    const/4 v2, 0x1

    goto :goto_1

    .line 55
    .end local v0    # "category":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    :cond_4
    iput-object p3, p0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    .line 56
    iput-object p4, p0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    .line 57
    invoke-static {p5}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    .line 58
    iput-object p6, p0, Lcom/xfinity/playerlib/model/tags/Network;->name:Ljava/lang/String;

    .line 59
    iput-boolean p7, p0, Lcom/xfinity/playerlib/model/tags/Network;->isPremium:Z

    .line 60
    invoke-static {p8}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    .line 61
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllMoviesCategory:Z

    .line 62
    iput-boolean v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllTvCategory:Z

    .line 63
    iput-wide p1, p0, Lcom/xfinity/playerlib/model/tags/Network;->companyId:J

    .line 65
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 6
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 136
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    new-instance v3, Ljava/util/TreeMap;

    invoke-direct {v3}, Ljava/util/TreeMap;-><init>()V

    iput-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->categoryMap:Ljava/util/Map;

    .line 137
    const-class v3, Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    invoke-virtual {v3}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    iput-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    .line 138
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    .line 139
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/xfinity/playerlib/model/tags/Network;->companyId:J

    .line 140
    const-class v3, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v3}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    invoke-direct {p0, p1, v3}, Lcom/xfinity/playerlib/model/tags/Network;->readList(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/util/List;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    .line 141
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->name:Ljava/lang/String;

    .line 142
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v3

    if-eqz v3, :cond_1

    const/4 v3, 0x1

    :goto_0
    iput-boolean v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->isPremium:Z

    .line 143
    const-class v3, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v3}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    invoke-direct {p0, p1, v3}, Lcom/xfinity/playerlib/model/tags/Network;->readList(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/util/List;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    .line 145
    const/4 v1, 0x0

    .line 146
    .local v1, "moviesCategoryPresent":Z
    const/4 v2, 0x0

    .line 148
    .local v2, "tvCategoryPresent":Z
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 149
    .local v0, "category":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 150
    const/4 v1, 0x1

    .line 155
    :cond_0
    :goto_2
    iget-object v4, p0, Lcom/xfinity/playerlib/model/tags/Network;->categoryMap:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 142
    .end local v0    # "category":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .end local v1    # "moviesCategoryPresent":Z
    .end local v2    # "tvCategoryPresent":Z
    :cond_1
    const/4 v3, 0x0

    goto :goto_0

    .line 151
    .restart local v0    # "category":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .restart local v1    # "moviesCategoryPresent":Z
    .restart local v2    # "tvCategoryPresent":Z
    :cond_2
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 152
    const/4 v2, 0x1

    goto :goto_2

    .line 158
    .end local v0    # "category":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    :cond_3
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllMoviesCategory:Z

    .line 159
    iput-boolean v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllTvCategory:Z

    .line 161
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/xfinity/playerlib/model/tags/Network$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lcom/xfinity/playerlib/model/tags/Network$1;

    .prologue
    .line 16
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/tags/Network;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method private readList(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/util/List;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;
    .param p2, "classLoader"    # Ljava/lang/ClassLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/os/Parcel;",
            "Ljava/lang/ClassLoader;",
            ")",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 164
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 165
    .local v0, "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->readList(Ljava/util/List;Ljava/lang/ClassLoader;)V

    .line 166
    return-object v0
.end method


# virtual methods
.method public compareTo(Lcom/xfinity/playerlib/model/tags/Network;)I
    .locals 5
    .param p1, "that"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 257
    new-instance v3, Lorg/apache/commons/lang3/builder/CompareToBuilder;

    invoke-direct {v3}, Lorg/apache/commons/lang3/builder/CompareToBuilder;-><init>()V

    .line 258
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v4

    if-nez v4, :cond_1

    :goto_1
    invoke-virtual {v3, v0, v1}, Lorg/apache/commons/lang3/builder/CompareToBuilder;->append(ZZ)Lorg/apache/commons/lang3/builder/CompareToBuilder;

    move-result-object v0

    .line 259
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/CompareToBuilder;->append(Ljava/lang/Object;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/CompareToBuilder;

    move-result-object v0

    .line 260
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/CompareToBuilder;->toComparison()I

    move-result v0

    return v0

    :cond_0
    move v0, v2

    .line 258
    goto :goto_0

    :cond_1
    move v1, v2

    goto :goto_1
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 16
    check-cast p1, Lcom/xfinity/playerlib/model/tags/Network;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/tags/Network;->compareTo(Lcom/xfinity/playerlib/model/tags/Network;)I

    move-result v0

    return v0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 110
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 8
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 187
    if-ne p0, p1, :cond_1

    .line 227
    :cond_0
    :goto_0
    return v1

    .line 190
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 191
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 194
    check-cast v0, Lcom/xfinity/playerlib/model/tags/Network;

    .line 196
    .local v0, "network":Lcom/xfinity/playerlib/model/tags/Network;
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/tags/Network;->companyId:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/model/tags/Network;->companyId:J

    cmp-long v3, v4, v6

    if-eqz v3, :cond_4

    move v1, v2

    .line 197
    goto :goto_0

    .line 199
    :cond_4
    iget-boolean v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllMoviesCategory:Z

    iget-boolean v4, v0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllMoviesCategory:Z

    if-eq v3, v4, :cond_5

    move v1, v2

    .line 200
    goto :goto_0

    .line 202
    :cond_5
    iget-boolean v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllTvCategory:Z

    iget-boolean v4, v0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllTvCategory:Z

    if-eq v3, v4, :cond_6

    move v1, v2

    .line 203
    goto :goto_0

    .line 205
    :cond_6
    iget-boolean v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->isPremium:Z

    iget-boolean v4, v0, Lcom/xfinity/playerlib/model/tags/Network;->isPremium:Z

    if-eq v3, v4, :cond_7

    move v1, v2

    .line 206
    goto :goto_0

    .line 208
    :cond_7
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    if-eqz v3, :cond_9

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_a

    :cond_8
    move v1, v2

    .line 209
    goto :goto_0

    .line 208
    :cond_9
    iget-object v3, v0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    if-nez v3, :cond_8

    .line 211
    :cond_a
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->categoryMap:Ljava/util/Map;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/Network;->categoryMap:Ljava/util/Map;

    invoke-interface {v3, v4}, Ljava/util/Map;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_b

    move v1, v2

    .line 212
    goto :goto_0

    .line 214
    :cond_b
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    if-eqz v3, :cond_d

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_e

    :cond_c
    move v1, v2

    .line 215
    goto :goto_0

    .line 214
    :cond_d
    iget-object v3, v0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    if-nez v3, :cond_c

    .line 217
    :cond_e
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    if-eqz v3, :cond_10

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_11

    :cond_f
    move v1, v2

    .line 218
    goto :goto_0

    .line 217
    :cond_10
    iget-object v3, v0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    if-nez v3, :cond_f

    .line 220
    :cond_11
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    if-eqz v3, :cond_13

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_14

    :cond_12
    move v1, v2

    .line 221
    goto/16 :goto_0

    .line 220
    :cond_13
    iget-object v3, v0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    if-nez v3, :cond_12

    .line 223
    :cond_14
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/Network;->name:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/Network;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 224
    goto/16 :goto_0
.end method

.method public getCategories()Ljava/util/List;
    .locals 1
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
    .line 94
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    return-object v0
.end method

.method public getCategoryById(Ljava/lang/String;)Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 246
    sget-object v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 247
    sget-object v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 252
    :goto_0
    return-object v0

    .line 248
    :cond_0
    sget-object v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 249
    sget-object v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    goto :goto_0

    .line 252
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->categoryMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    goto :goto_0
.end method

.method public getCompanyId()J
    .locals 2

    .prologue
    .line 77
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->companyId:J

    return-wide v0
.end method

.method public getFeaturedShow()Lcom/xfinity/playerlib/model/tags/FeaturedShow;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getMovieGenres()Ljava/util/List;
    .locals 1
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
    .line 90
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->name:Ljava/lang/String;

    return-object v0
.end method

.method public hasAllMoviesCategory()Z
    .locals 1

    .prologue
    .line 98
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllMoviesCategory:Z

    return v0
.end method

.method public hasAllTvCategory()Z
    .locals 1

    .prologue
    .line 102
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllTvCategory:Z

    return v0
.end method

.method public hashCode()I
    .locals 7

    .prologue
    const/4 v3, 0x1

    const/4 v1, 0x0

    .line 232
    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->hashCode()I

    move-result v0

    .line 233
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v4, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v4, v2

    .line 234
    mul-int/lit8 v4, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    :goto_2
    add-int v0, v4, v2

    .line 235
    mul-int/lit8 v2, v0, 0x1f

    iget-object v4, p0, Lcom/xfinity/playerlib/model/tags/Network;->name:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v4

    add-int v0, v2, v4

    .line 236
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->isPremium:Z

    if-eqz v2, :cond_3

    move v2, v3

    :goto_3
    add-int v0, v4, v2

    .line 237
    mul-int/lit8 v4, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    :goto_4
    add-int v0, v4, v2

    .line 238
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllMoviesCategory:Z

    if-eqz v2, :cond_5

    move v2, v3

    :goto_5
    add-int v0, v4, v2

    .line 239
    mul-int/lit8 v2, v0, 0x1f

    iget-boolean v4, p0, Lcom/xfinity/playerlib/model/tags/Network;->hasAllTvCategory:Z

    if-eqz v4, :cond_6

    :goto_6
    add-int v0, v2, v3

    .line 240
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->categoryMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 241
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->companyId:J

    iget-wide v4, p0, Lcom/xfinity/playerlib/model/tags/Network;->companyId:J

    const/16 v6, 0x20

    ushr-long/2addr v4, v6

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 242
    return v0

    .end local v0    # "result":I
    :cond_0
    move v0, v1

    .line 232
    goto :goto_0

    .restart local v0    # "result":I
    :cond_1
    move v2, v1

    .line 233
    goto :goto_1

    :cond_2
    move v2, v1

    .line 234
    goto :goto_2

    :cond_3
    move v2, v1

    .line 236
    goto :goto_3

    :cond_4
    move v2, v1

    .line 237
    goto :goto_4

    :cond_5
    move v2, v1

    .line 238
    goto :goto_5

    :cond_6
    move v3, v1

    .line 239
    goto :goto_6
.end method

.method public isPremium()Z
    .locals 1

    .prologue
    .line 86
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->isPremium:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 174
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "id"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    .line 175
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "name"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->name:Ljava/lang/String;

    .line 176
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "companyId"

    iget-wide v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->companyId:J

    .line 177
    invoke-virtual {v0, v1, v2, v3}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;J)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "isPremium"

    iget-boolean v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->isPremium:Z

    .line 178
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Z)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "categories"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    .line 179
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "featuredShow"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    .line 180
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "moviesGenres"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    .line 181
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    .line 182
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 4
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v0, 0x0

    .line 115
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/Network;->featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    invoke-virtual {p1, v1, v0}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 116
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/Network;->id:Ljava/lang/String;

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 117
    iget-wide v2, p0, Lcom/xfinity/playerlib/model/tags/Network;->companyId:J

    invoke-virtual {p1, v2, v3}, Landroid/os/Parcel;->writeLong(J)V

    .line 118
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/Network;->movieGenres:Ljava/util/List;

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeList(Ljava/util/List;)V

    .line 119
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/Network;->name:Ljava/lang/String;

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 120
    iget-boolean v1, p0, Lcom/xfinity/playerlib/model/tags/Network;->isPremium:Z

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    .line 121
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/Network;->categories:Ljava/util/List;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeList(Ljava/util/List;)V

    .line 122
    return-void
.end method
