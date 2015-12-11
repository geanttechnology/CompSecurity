.class Lcom/localytics/android/MarketingHandler$23;
.super Lcom/localytics/android/MarketingCallable;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/localytics/android/MarketingHandler;

.field final synthetic val$attributes:Ljava/util/Map;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingHandler;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 2759
    iput-object p1, p0, Lcom/localytics/android/MarketingHandler$23;->this$0:Lcom/localytics/android/MarketingHandler;

    iput-object p2, p0, Lcom/localytics/android/MarketingHandler$23;->val$attributes:Ljava/util/Map;

    invoke-direct {p0}, Lcom/localytics/android/MarketingCallable;-><init>()V

    return-void
.end method


# virtual methods
.method call([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 2763
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$23;->val$attributes:Ljava/util/Map;

    if-nez v0, :cond_0

    move-object v0, v2

    .line 2788
    :goto_0
    return-object v0

    .line 2768
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$23;->val$attributes:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-nez v0, :cond_1

    move-object v0, v2

    .line 2770
    goto :goto_0

    .line 2776
    :cond_1
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 2777
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$23;->val$attributes:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 2779
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 2780
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 2781
    invoke-virtual {v3, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 2787
    :catch_0
    move-exception v0

    const-string v0, "[JavaScriptClient]: Failed to get attributes"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    move-object v0, v2

    .line 2788
    goto :goto_0

    .line 2783
    :cond_2
    :try_start_1
    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v0

    goto :goto_0
.end method
