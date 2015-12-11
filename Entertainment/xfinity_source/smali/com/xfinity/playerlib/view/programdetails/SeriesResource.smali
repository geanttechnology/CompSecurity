.class public Lcom/xfinity/playerlib/view/programdetails/SeriesResource;
.super Ljava/lang/Object;
.source "SeriesResource.java"


# instance fields
.field public final bookmarkMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation
.end field

.field public final dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

.field public final entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

.field public final tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/model/dibic/DibicResource;Ljava/util/Map;)V
    .locals 0
    .param p1, "entitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p2, "tvSeriesFacade"    # Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    .param p3, "dibicResource"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p4, "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 24
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    invoke-static {p3}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    invoke-static {p4}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 28
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    .line 29
    iput-object p3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 30
    iput-object p4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->bookmarkMap:Ljava/util/Map;

    .line 31
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 35
    if-ne p0, p1, :cond_1

    .line 55
    :cond_0
    :goto_0
    return v1

    .line 38
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 39
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 41
    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    .line 42
    .local v0, "that":Lcom/xfinity/playerlib/view/programdetails/SeriesResource;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->bookmarkMap:Ljava/util/Map;

    iget-object v4, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->bookmarkMap:Ljava/util/Map;

    invoke-interface {v3, v4}, Ljava/util/Map;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    .line 43
    goto :goto_0

    .line 45
    :cond_4
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    iget-object v4, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    move v1, v2

    .line 46
    goto :goto_0

    .line 48
    :cond_5
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    iget-object v4, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    move v1, v2

    .line 49
    goto :goto_0

    .line 52
    :cond_6
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    iget-object v4, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 53
    goto :goto_0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 60
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 61
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 62
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 63
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->bookmarkMap:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 64
    return v0
.end method
