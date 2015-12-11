.class public abstract Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
.super Ljava/lang/Object;
.source "HalBaseConsumable.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/hal/model/HalParseable;


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonSubTypes;
    value = {
        .subannotation Lcom/fasterxml/jackson/annotation/JsonSubTypes$Type;
            name = "movie"
            value = Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;
        .end subannotation,
        .subannotation Lcom/fasterxml/jackson/annotation/JsonSubTypes$Type;
            name = "tvseries"
            value = Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
        .end subannotation,
        .subannotation Lcom/fasterxml/jackson/annotation/JsonSubTypes$Type;
            name = "video"
            value = Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
        .end subannotation
    }
.end annotation

.annotation runtime Lcom/fasterxml/jackson/annotation/JsonTypeInfo;
    include = .enum Lcom/fasterxml/jackson/annotation/JsonTypeInfo$As;->PROPERTY:Lcom/fasterxml/jackson/annotation/JsonTypeInfo$As;
    property = "type"
    use = .enum Lcom/fasterxml/jackson/annotation/JsonTypeInfo$Id;->NAME:Lcom/fasterxml/jackson/annotation/JsonTypeInfo$Id;
.end annotation


# static fields
.field private static final sdf:Ljava/text/SimpleDateFormat;


# instance fields
.field private castList:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalActor;",
            ">;"
        }
    .end annotation
.end field

.field private description:Ljava/lang/String;

.field private merlinEntityId:Lcom/xfinity/playerlib/model/MerlinId;

.field private reviews:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalReview;",
            ">;"
        }
    .end annotation
.end field

.field private title:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 119
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "EEE, dd MMM yyyy HH:mm:ss"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->sdf:Ljava/text/SimpleDateFormat;

    .line 120
    sget-object v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->sdf:Ljava/text/SimpleDateFormat;

    const-string v1, "UTC"

    invoke-static {v1}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 121
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->castList:Ljava/util/Set;

    .line 35
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->reviews:Ljava/util/List;

    return-void
.end method

.method private removeTz(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "inputDate"    # Ljava/lang/String;

    .prologue
    .line 129
    const/4 v0, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x4

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public castListAsString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 56
    const-string v1, ""

    .line 57
    .local v1, "listString":Ljava/lang/String;
    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->castList:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;

    .line 58
    .local v0, "actor":Lcom/xfinity/playerlib/model/consumable/hal/HalActor;
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 59
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 61
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 62
    goto :goto_0

    .line 64
    .end local v0    # "actor":Lcom/xfinity/playerlib/model/consumable/hal/HalActor;
    :cond_1
    return-object v1
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 142
    if-ne p0, p1, :cond_1

    .line 165
    :cond_0
    :goto_0
    return v1

    .line 145
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 146
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 149
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;

    .line 151
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->castList:Ljava/util/Set;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->castList:Ljava/util/Set;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->castList:Ljava/util/Set;

    invoke-interface {v3, v4}, Ljava/util/Set;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_4
    move v1, v2

    .line 152
    goto :goto_0

    .line 151
    :cond_5
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->castList:Ljava/util/Set;

    if-nez v3, :cond_4

    .line 154
    :cond_6
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->description:Ljava/lang/String;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->description:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->description:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    :cond_7
    move v1, v2

    .line 155
    goto :goto_0

    .line 154
    :cond_8
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->description:Ljava/lang/String;

    if-nez v3, :cond_7

    .line 157
    :cond_9
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->merlinEntityId:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v3, :cond_b

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->merlinEntityId:Lcom/xfinity/playerlib/model/MerlinId;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->merlinEntityId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    :cond_a
    move v1, v2

    .line 158
    goto :goto_0

    .line 157
    :cond_b
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->merlinEntityId:Lcom/xfinity/playerlib/model/MerlinId;

    if-nez v3, :cond_a

    .line 161
    :cond_c
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->title:Ljava/lang/String;

    if-eqz v3, :cond_d

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->title:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->title:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 162
    goto :goto_0

    .line 161
    :cond_d
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->title:Ljava/lang/String;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getCastList()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalActor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->castList:Ljava/util/Set;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->merlinEntityId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public abstract getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
.end method

.method public getReviews()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalReview;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->reviews:Ljava/util/List;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->title:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 170
    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->merlinEntityId:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->merlinEntityId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId;->hashCode()I

    move-result v0

    .line 171
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->title:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->title:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v3, v2

    .line 172
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->description:Ljava/lang/String;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->description:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_2
    add-int v0, v3, v2

    .line 173
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->castList:Ljava/util/Set;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->castList:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 174
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 170
    goto :goto_0

    .restart local v0    # "result":I
    :cond_2
    move v2, v1

    .line 171
    goto :goto_1

    :cond_3
    move v2, v1

    .line 172
    goto :goto_2
.end method

.method protected parseDate(Ljava/lang/String;)Ljava/util/Date;
    .locals 4
    .param p1, "inputDate"    # Ljava/lang/String;

    .prologue
    .line 133
    if-eqz p1, :cond_0

    .line 134
    sget-object v0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->sdf:Ljava/text/SimpleDateFormat;

    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->removeTz(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/text/ParsePosition;

    const/4 v3, 0x0

    invoke-direct {v2, v3}, Ljava/text/ParsePosition;-><init>(I)V

    invoke-virtual {v0, v1, v2}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;

    move-result-object v0

    .line 136
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 12
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 76
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 77
    const-string v7, "id"

    invoke-virtual {p1, v7}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 78
    .local v3, "merlinId":Ljava/lang/String;
    new-instance v7, Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v8

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-direct {v7, v8, v9}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V

    iput-object v7, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->merlinEntityId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 81
    .end local v3    # "merlinId":Ljava/lang/String;
    :cond_0
    const-string v7, "name"

    invoke-virtual {p1, v7}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->title:Ljava/lang/String;

    .line 82
    iget-object v7, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->title:Ljava/lang/String;

    if-nez v7, :cond_1

    const-string v7, ""

    iput-object v7, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->title:Ljava/lang/String;

    .line 83
    :cond_1
    const-string v7, "description"

    invoke-virtual {p1, v7}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->description:Ljava/lang/String;

    .line 84
    iget-object v7, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->description:Ljava/lang/String;

    if-nez v7, :cond_2

    const-string v7, ""

    iput-object v7, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->description:Ljava/lang/String;

    .line 86
    :cond_2
    const-string v7, "actor"

    invoke-virtual {p1, v7}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalItemList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 87
    .local v1, "actors":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    if-eqz v1, :cond_3

    .line 88
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 89
    .local v4, "nextActor":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;-><init>()V

    .line 90
    .local v0, "actor":Lcom/xfinity/playerlib/model/consumable/hal/HalActor;
    invoke-virtual {p1, v4}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v8

    invoke-virtual {v0, v8}, Lcom/xfinity/playerlib/model/consumable/hal/HalActor;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 91
    iget-object v8, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->castList:Ljava/util/Set;

    invoke-interface {v8, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 95
    .end local v0    # "actor":Lcom/xfinity/playerlib/model/consumable/hal/HalActor;
    .end local v4    # "nextActor":Lcom/comcast/cim/microdata/model/MicrodataItem;
    :cond_3
    const-string v7, "reviews"

    invoke-virtual {p1, v7}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalItemList(Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 96
    .local v6, "reviewItems":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/microdata/model/MicrodataItem;>;"
    if-eqz v6, :cond_4

    .line 97
    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/comcast/cim/microdata/model/MicrodataItem;

    .line 98
    .local v5, "reviewItem":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v2, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;

    invoke-direct {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;-><init>()V

    .line 99
    .local v2, "halReview":Lcom/xfinity/playerlib/model/consumable/hal/HalReview;
    invoke-virtual {p1, v5}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v8

    invoke-virtual {v2, v8}, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 100
    iget-object v8, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalBaseConsumable;->reviews:Ljava/util/List;

    invoke-interface {v8, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 103
    .end local v2    # "halReview":Lcom/xfinity/playerlib/model/consumable/hal/HalReview;
    .end local v5    # "reviewItem":Lcom/comcast/cim/microdata/model/MicrodataItem;
    :cond_4
    return-void
.end method
