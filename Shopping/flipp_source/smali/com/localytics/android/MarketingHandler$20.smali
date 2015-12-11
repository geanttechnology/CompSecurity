.class Lcom/localytics/android/MarketingHandler$20;
.super Lcom/localytics/android/MarketingCallable;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/localytics/android/MarketingHandler;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingHandler;)V
    .locals 0

    .prologue
    .line 2611
    iput-object p1, p0, Lcom/localytics/android/MarketingHandler$20;->this$0:Lcom/localytics/android/MarketingHandler;

    invoke-direct {p0}, Lcom/localytics/android/MarketingCallable;-><init>()V

    return-void
.end method


# virtual methods
.method call([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 14

    .prologue
    const/4 v13, 0x0

    const/16 v12, 0x32

    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 2615
    aget-object v0, p1, v9

    check-cast v0, Ljava/lang/String;

    .line 2616
    aget-object v1, p1, v10

    check-cast v1, Ljava/lang/String;

    .line 2617
    aget-object v2, p1, v11

    check-cast v2, Ljava/lang/String;

    .line 2618
    const-wide/16 v4, 0x0

    .line 2620
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 2622
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2624
    const-class v3, Ljava/lang/IllegalArgumentException;

    const-string v7, "event cannot be null or empty"

    invoke-static {v3, v7}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    .line 2629
    :cond_0
    :try_start_0
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    # getter for: Lcom/localytics/android/MarketingHandler;->JS_STRINGS_THAT_MEAN_NULL:Ljava/util/List;
    invoke-static {}, Lcom/localytics/android/MarketingHandler;->access$1100()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 2631
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-static {v3}, Lcom/localytics/android/JsonHelper;->toMap(Lorg/json/JSONObject;)Ljava/util/Map;

    move-result-object v3

    .line 2632
    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 2634
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v8

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v6, v8, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 2640
    :catch_0
    move-exception v0

    const-string v0, "[JavaScriptClient]: Failed to parse the json object in tagEventNative"

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 2703
    :goto_1
    return-object v13

    .line 2646
    :cond_1
    :try_start_1
    invoke-static {v2}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-wide v2

    move-wide v4, v2

    .line 2669
    :cond_2
    :goto_2
    if-eqz v1, :cond_7

    .line 2675
    invoke-interface {v6}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 2677
    const-string v1, "attributes is empty.  Did the caller make an error?"

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 2680
    :cond_3
    invoke-interface {v6}, Ljava/util/Map;->size()I

    move-result v1

    if-le v1, v12, :cond_4

    .line 2682
    const-string v1, "attributes size is %d, exceeding the maximum size of %d.  Did the caller make an error?"

    new-array v2, v11, [Ljava/lang/Object;

    invoke-interface {v6}, Ljava/util/Map;->size()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v9

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v10

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 2685
    :cond_4
    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_5
    :goto_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_7

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 2687
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 2688
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 2690
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 2692
    const-class v2, Ljava/lang/IllegalArgumentException;

    const-string v7, "attributes cannot contain null or empty keys"

    invoke-static {v2, v7}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    .line 2695
    :cond_6
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 2697
    const-class v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "attributes cannot contain null or empty values"

    invoke-static {v1, v2}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    goto :goto_3

    :catch_1
    move-exception v3

    .line 2654
    :try_start_2
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    # getter for: Lcom/localytics/android/MarketingHandler;->JS_STRINGS_THAT_MEAN_NULL:Ljava/util/List;
    invoke-static {}, Lcom/localytics/android/MarketingHandler;->access$1100()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 2656
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-static {v3}, Lcom/localytics/android/JsonHelper;->toMap(Lorg/json/JSONObject;)Ljava/util/Map;

    move-result-object v2

    .line 2657
    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_4
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 2659
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v6, v7, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_4

    :catch_2
    move-exception v2

    goto/16 :goto_2

    .line 2702
    :cond_7
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler$20;->this$0:Lcom/localytics/android/MarketingHandler;

    iget-object v1, v1, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v1, v0, v6, v4, v5}, Lcom/localytics/android/LocalyticsDao;->tagEvent(Ljava/lang/String;Ljava/util/Map;J)V

    goto/16 :goto_1
.end method
