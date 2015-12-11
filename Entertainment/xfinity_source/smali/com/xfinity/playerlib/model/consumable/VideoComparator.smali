.class public Lcom/xfinity/playerlib/model/consumable/VideoComparator;
.super Ljava/lang/Object;
.source "VideoComparator.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/SortableVideo;",
        ">;"
    }
.end annotation


# instance fields
.field private entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 0
    .param p1, "entitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 20
    return-void
.end method

.method private getNetworkDisplayName(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Ljava/lang/String;
    .locals 2
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/SortableVideo;

    .prologue
    .line 93
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v0

    .line 94
    .local v0, "networkInfo":Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getName()Ljava/lang/String;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const-string v1, ""

    goto :goto_0
.end method

.method private getNumLanguages(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)I
    .locals 1
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/SortableVideo;

    .prologue
    .line 79
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getLanguageCodes()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getLanguageCodes()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method private videoIsPremium(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Z
    .locals 2
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/SortableVideo;

    .prologue
    .line 88
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v0

    .line 89
    .local v0, "networkInfo":Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->isPremium()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private videoLanguagesContainEnglish(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Z
    .locals 2
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/SortableVideo;

    .prologue
    .line 83
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getLanguageCodes()Ljava/util/List;

    move-result-object v0

    .line 84
    .local v0, "languages":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public compare(Lcom/xfinity/playerlib/model/consumable/SortableVideo;Lcom/xfinity/playerlib/model/consumable/SortableVideo;)I
    .locals 8
    .param p1, "a"    # Lcom/xfinity/playerlib/model/consumable/SortableVideo;
    .param p2, "b"    # Lcom/xfinity/playerlib/model/consumable/SortableVideo;

    .prologue
    const/4 v2, 0x1

    const/4 v1, -0x1

    .line 26
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    if-nez v3, :cond_1

    .line 74
    :cond_0
    :goto_0
    return v1

    .line 28
    :cond_1
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    if-nez v3, :cond_2

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    if-eqz v3, :cond_2

    move v1, v2

    .line 29
    goto :goto_0

    .line 33
    :cond_2
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getProviderCode()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getProviderCode()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 35
    :cond_3
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getProviderCode()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_4

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getProviderCode()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    move v1, v2

    .line 36
    goto :goto_0

    .line 40
    :cond_4
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->videoIsPremium(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Z

    move-result v3

    if-eqz v3, :cond_5

    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->videoIsPremium(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 42
    :cond_5
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->videoIsPremium(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Z

    move-result v3

    if-nez v3, :cond_6

    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->videoIsPremium(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Z

    move-result v3

    if-eqz v3, :cond_6

    move v1, v2

    .line 43
    goto :goto_0

    .line 47
    :cond_6
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->videoLanguagesContainEnglish(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->videoLanguagesContainEnglish(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 49
    :cond_7
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->videoLanguagesContainEnglish(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Z

    move-result v3

    if-nez v3, :cond_8

    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->videoLanguagesContainEnglish(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Z

    move-result v3

    if-eqz v3, :cond_8

    move v1, v2

    .line 50
    goto :goto_0

    .line 54
    :cond_8
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->getNumLanguages(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)I

    move-result v3

    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->getNumLanguages(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)I

    move-result v4

    if-gt v3, v4, :cond_0

    .line 56
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->getNumLanguages(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)I

    move-result v3

    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->getNumLanguages(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)I

    move-result v4

    if-ge v3, v4, :cond_9

    move v1, v2

    .line 57
    goto/16 :goto_0

    .line 61
    :cond_9
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->getNetworkDisplayName(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->getNetworkDisplayName(Lcom/xfinity/playerlib/model/consumable/SortableVideo;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    .line 62
    .local v0, "nameComparison":I
    if-eq v0, v1, :cond_0

    .line 64
    if-ne v0, v2, :cond_a

    move v1, v2

    .line 65
    goto/16 :goto_0

    .line 69
    :cond_a
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getVideoId()J

    move-result-wide v4

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getVideoId()J

    move-result-wide v6

    cmp-long v3, v4, v6

    if-ltz v3, :cond_0

    .line 71
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getVideoId()J

    move-result-wide v4

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SortableVideo;->getVideoId()J

    move-result-wide v6

    cmp-long v1, v4, v6

    if-lez v1, :cond_b

    move v1, v2

    .line 72
    goto/16 :goto_0

    .line 74
    :cond_b
    const/4 v1, 0x0

    goto/16 :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 10
    check-cast p1, Lcom/xfinity/playerlib/model/consumable/SortableVideo;

    check-cast p2, Lcom/xfinity/playerlib/model/consumable/SortableVideo;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;->compare(Lcom/xfinity/playerlib/model/consumable/SortableVideo;Lcom/xfinity/playerlib/model/consumable/SortableVideo;)I

    move-result v0

    return v0
.end method
