.class Lcom/espn/androidplayersdk/datamanager/FeedsUpdateListener;
.super Ljava/lang/Object;
.source "FeedsUpdateListener.java"

# interfaces
.implements Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    return-void
.end method

.method public static intiListener()Lcom/espn/androidplayersdk/datamanager/FeedsUpdateListener;
    .locals 1

    .prologue
    .line 16
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsUpdateListener;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/FeedsUpdateListener;-><init>()V

    return-object v0
.end method


# virtual methods
.method public handleError(I)V
    .locals 0
    .param p1, "errorCode"    # I

    .prologue
    .line 60
    return-void
.end method

.method public update(Lorg/apache/http/HttpEntity;Ljava/lang/String;)V
    .locals 0
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;
    .param p2, "identifier"    # Ljava/lang/String;

    .prologue
    .line 54
    return-void
.end method

.method public update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 4
    .param p1, "object"    # Lorg/json/JSONObject;
    .param p2, "identifier"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p3, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    const-string v2, "featuredCatEventType"

    invoke-virtual {p3, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 29
    const-string p2, "featuredCategoryEvent"

    .line 30
    :cond_0
    const-string v2, "featuredTopSportEventType"

    invoke-virtual {p3, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 31
    const-string p2, "featuredTopSportEvent"

    .line 33
    :cond_1
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/GeneralParser;

    invoke-direct {v1, p2}, Lcom/espn/androidplayersdk/datamanager/GeneralParser;-><init>(Ljava/lang/String;)V

    .line 34
    .local v1, "parser":Lcom/espn/androidplayersdk/datamanager/GeneralParser;
    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->instantiateJSONParser()V

    .line 35
    invoke-virtual {v1, p1, p3}, Lcom/espn/androidplayersdk/datamanager/GeneralParser;->parse(Lorg/json/JSONObject;Ljava/util/HashMap;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 40
    .end local v1    # "parser":Lcom/espn/androidplayersdk/datamanager/GeneralParser;
    :goto_0
    return-void

    .line 36
    :catch_0
    move-exception v0

    .line 37
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Error"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 38
    const/4 v2, 0x4

    invoke-virtual {p0, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsUpdateListener;->handleError(I)V

    goto :goto_0
.end method
