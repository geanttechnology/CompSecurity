.class public Lcom/poshmark/utils/MetricsTrackingUtils;
.super Ljava/lang/Object;
.source "MetricsTrackingUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "goal"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 18
    move-object v2, p0

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 19
    .local v2, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v2, :cond_0

    .line 20
    invoke-virtual {v2}, Lcom/poshmark/ui/PMActivity;->getScreenNavigationStack()Ljava/util/List;

    move-result-object v3

    .line 21
    .local v3, "screenStack":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v3, :cond_0

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v6

    if-lez v6, :cond_0

    .line 22
    new-instance v4, Lcom/poshmark/data_model/models/TrackingGoal;

    invoke-direct {v4, p1, v3}, Lcom/poshmark/data_model/models/TrackingGoal;-><init>(Ljava/lang/String;Ljava/util/List;)V

    .line 23
    .local v4, "tg":Lcom/poshmark/data_model/models/TrackingGoal;
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 24
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 25
    .local v1, "gson":Lcom/google/gson/Gson;
    const-class v5, Lcom/poshmark/data_model/models/TrackingGoal;

    instance-of v6, v1, Lcom/google/gson/Gson;

    if-nez v6, :cond_1

    invoke-virtual {v1, v4, v5}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v5

    .line 30
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v1    # "gson":Lcom/google/gson/Gson;
    .end local v3    # "screenStack":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v4    # "tg":Lcom/poshmark/data_model/models/TrackingGoal;
    :cond_0
    :goto_0
    return-object v5

    .line 25
    .restart local v0    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    .restart local v3    # "screenStack":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v4    # "tg":Lcom/poshmark/data_model/models/TrackingGoal;
    :cond_1
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v4, v5}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method

.method public static getTrackingStackAsJson(Landroid/app/Activity;)Ljava/lang/String;
    .locals 6
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v4, 0x0

    .line 35
    move-object v2, p0

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 36
    .local v2, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v2, :cond_0

    .line 37
    invoke-virtual {v2}, Lcom/poshmark/ui/PMActivity;->getScreenNavigationStack()Ljava/util/List;

    move-result-object v3

    .line 38
    .local v3, "screenStack":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v3, :cond_0

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 39
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 40
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 41
    .local v1, "gson":Lcom/google/gson/Gson;
    const-class v4, Ljava/util/List;

    instance-of v5, v1, Lcom/google/gson/Gson;

    if-nez v5, :cond_1

    invoke-virtual {v1, v3, v4}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    .line 46
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    .end local v1    # "gson":Lcom/google/gson/Gson;
    .end local v3    # "screenStack":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    :goto_0
    return-object v4

    .line 41
    .restart local v0    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    .restart local v3    # "screenStack":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_1
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v3, v4}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method
