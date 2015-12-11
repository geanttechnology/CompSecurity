.class public Lcom/comcast/cim/model/Rating;
.super Ljava/lang/Object;
.source "Rating.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final MATURE_RATINGS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/model/Rating;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final rating:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 17
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    .line 18
    .local v0, "matureRatings":Ljava/util/Set;, "Ljava/util/Set<Lcom/comcast/cim/model/Rating;>;"
    new-instance v1, Lcom/comcast/cim/model/Rating;

    const-string v2, "R"

    invoke-direct {v1, v2}, Lcom/comcast/cim/model/Rating;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 19
    new-instance v1, Lcom/comcast/cim/model/Rating;

    const-string v2, "X"

    invoke-direct {v1, v2}, Lcom/comcast/cim/model/Rating;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 20
    new-instance v1, Lcom/comcast/cim/model/Rating;

    const-string v2, "TV-MA"

    invoke-direct {v1, v2}, Lcom/comcast/cim/model/Rating;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 21
    new-instance v1, Lcom/comcast/cim/model/Rating;

    const-string v2, "NC-17"

    invoke-direct {v1, v2}, Lcom/comcast/cim/model/Rating;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 22
    new-instance v1, Lcom/comcast/cim/model/Rating;

    const-string v2, "NSFW"

    invoke-direct {v1, v2}, Lcom/comcast/cim/model/Rating;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 23
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    sput-object v1, Lcom/comcast/cim/model/Rating;->MATURE_RATINGS:Ljava/util/Set;

    .line 24
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "rating"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 30
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notEmpty(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 31
    iput-object p1, p0, Lcom/comcast/cim/model/Rating;->rating:Ljava/lang/String;

    .line 32
    return-void
.end method

.method private normalizeRating(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "rating"    # Ljava/lang/String;

    .prologue
    .line 50
    if-nez p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, " "

    const-string v1, ""

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "-"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 55
    if-ne p0, p1, :cond_1

    .line 64
    :cond_0
    :goto_0
    return v3

    .line 58
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    if-eq v5, v6, :cond_3

    :cond_2
    move v3, v4

    .line 59
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 61
    check-cast v0, Lcom/comcast/cim/model/Rating;

    .line 62
    .local v0, "other":Lcom/comcast/cim/model/Rating;
    iget-object v5, p0, Lcom/comcast/cim/model/Rating;->rating:Ljava/lang/String;

    invoke-direct {p0, v5}, Lcom/comcast/cim/model/Rating;->normalizeRating(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 63
    .local v2, "thisNormalizedRating":Ljava/lang/String;
    iget-object v5, v0, Lcom/comcast/cim/model/Rating;->rating:Ljava/lang/String;

    invoke-direct {p0, v5}, Lcom/comcast/cim/model/Rating;->normalizeRating(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 64
    .local v1, "otherNormalizedRating":Ljava/lang/String;
    if-eqz v2, :cond_5

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    :cond_4
    move v3, v4

    goto :goto_0

    :cond_5
    if-nez v1, :cond_4

    goto :goto_0
.end method

.method public getRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/comcast/cim/model/Rating;->rating:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 69
    iget-object v1, p0, Lcom/comcast/cim/model/Rating;->rating:Ljava/lang/String;

    invoke-direct {p0, v1}, Lcom/comcast/cim/model/Rating;->normalizeRating(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 70
    .local v0, "normalizedRating":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isMature()Z
    .locals 1

    .prologue
    .line 39
    sget-object v0, Lcom/comcast/cim/model/Rating;->MATURE_RATINGS:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonValue;
    .end annotation

    .prologue
    .line 76
    invoke-virtual {p0}, Lcom/comcast/cim/model/Rating;->getRating()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
