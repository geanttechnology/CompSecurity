.class Lcom/espn/androidplayersdk/datamanager/GeneralParser;
.super Ljava/lang/Object;
.source "GeneralParser.java"


# instance fields
.field mType:Ljava/lang/String;

.field parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "pType"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    .line 27
    return-void
.end method


# virtual methods
.method public instantiateJSONParser()V
    .locals 3

    .prologue
    .line 32
    :try_start_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "configs/sdk"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 33
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/ConfigParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/ConfigParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    .line 85
    :cond_0
    :goto_0
    return-void

    .line 35
    :cond_1
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "/networks"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 36
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/ChannelsParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 82
    :catch_0
    move-exception v0

    .line 83
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 38
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_2
    :try_start_1
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "listings/top"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 39
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto :goto_0

    .line 41
    :cond_3
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "video/channels"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 42
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedEventsParserII;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto :goto_0

    .line 44
    :cond_4
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "listings?types=live"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 45
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/LiveEventsParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto :goto_0

    .line 47
    :cond_5
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "/categories?"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 48
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/SportsParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/SportsParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto :goto_0

    .line 50
    :cond_6
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "/categories/top?"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 51
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/TopSportParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/TopSportParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto :goto_0

    .line 53
    :cond_7
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "/categories/"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 54
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto/16 :goto_0

    .line 56
    :cond_8
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "categories/listings?"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 57
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EventsByLeagueParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto/16 :goto_0

    .line 59
    :cond_9
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "listings?categories"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 60
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EventBySportParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto/16 :goto_0

    .line 62
    :cond_a
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "listings?network"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 63
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EventsByChannelParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EventsByChannelParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto/16 :goto_0

    .line 65
    :cond_b
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "listings?network"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 66
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EventsByChannelParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EventsByChannelParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto/16 :goto_0

    .line 68
    :cond_c
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "watch/trending?"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 69
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/TrendingEventsParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto/16 :goto_0

    .line 71
    :cond_d
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "watch/features?"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 72
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto/16 :goto_0

    .line 74
    :cond_e
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "featuredCategoryEvent"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 75
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryEventsParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/FeaturedCategoryEventsParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    goto/16 :goto_0

    .line 77
    :cond_f
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "featuredTopSportEvent"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 78
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/TopSportEventParser;-><init>()V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method public instantiateXMLParser()V
    .locals 3

    .prologue
    .line 90
    :try_start_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->mType:Ljava/lang/String;

    const-string v2, "XML"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 97
    :goto_0
    return-void

    .line 93
    :catch_0
    move-exception v0

    .line 94
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    .locals 2
    .param p1, "json"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 100
    .local p2, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    if-eqz v0, :cond_0

    .line 101
    if-eqz p1, :cond_1

    .line 102
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    invoke-interface {v0, p1, p2}, Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;->parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V

    .line 105
    :cond_0
    :goto_0
    return-void

    .line 104
    :cond_1
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parser:Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;->errorHandler(I)V

    goto :goto_0
.end method

.method public parseXML(Lorg/apache/http/HttpEntity;)V
    .locals 0
    .param p1, "httpEntity"    # Lorg/apache/http/HttpEntity;

    .prologue
    .line 114
    return-void
.end method
