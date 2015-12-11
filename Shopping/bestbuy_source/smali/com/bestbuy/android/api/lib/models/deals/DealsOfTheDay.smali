.class public Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private content:Ljava/lang/String;

.field private offersList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;",
            ">;"
        }
    .end annotation
.end field

.field private widgetTitle:Ljava/lang/String;

.field private widgetType:Ljava/lang/String;

.field private widgetsList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    return-void
.end method

.method public static loadDealsData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;
    .locals 5

    .prologue
    .line 52
    new-instance v1, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;-><init>()V

    .line 53
    if-eqz p0, :cond_0

    const-string v0, "widgets"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 55
    :try_start_0
    const-string v0, "widgets"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->loadWidgetsList(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->widgetsList:Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 60
    :cond_0
    :goto_0
    return-object v1

    .line 56
    :catch_0
    move-exception v0

    .line 57
    sget-object v2, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Couldn\'t parse deals data:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public getContent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->content:Ljava/lang/String;

    return-object v0
.end method

.method public getOffersList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;",
            ">;"
        }
    .end annotation

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->offersList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getWidgetTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->widgetTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getWidgetType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->widgetType:Ljava/lang/String;

    return-object v0
.end method

.method public getWidgetsList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;",
            ">;"
        }
    .end annotation

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->widgetsList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public loadWidgetsList(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;",
            ">;"
        }
    .end annotation

    .prologue
    .line 64
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 65
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-lez v0, :cond_2

    .line 66
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-gt v0, v2, :cond_2

    .line 67
    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 68
    if-eqz v2, :cond_1

    .line 69
    new-instance v3, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;-><init>()V

    .line 70
    const-string v4, "content"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->content:Ljava/lang/String;

    .line 71
    const-string v4, "widgetType"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->widgetType:Ljava/lang/String;

    .line 72
    const-string v4, "widgetTitle"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->widgetTitle:Ljava/lang/String;

    .line 73
    const-string v4, "offers"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 74
    const-string v4, "offers"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    invoke-static {v2}, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay$DODOffers;->loadDODoffersArrayData(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v2

    iput-object v2, v3, Lcom/bestbuy/android/api/lib/models/deals/DealsOfTheDay;->offersList:Ljava/util/ArrayList;

    .line 76
    :cond_0
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 66
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 80
    :cond_2
    return-object v1
.end method
