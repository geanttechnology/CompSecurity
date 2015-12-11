.class final Lcom/facebook/internal/Utility$1;
.super Ljava/lang/Object;
.source "Utility.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/internal/Utility;->loadAppSettingsAsync(Landroid/content/Context;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$applicationId:Ljava/lang/String;

.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$settingsKey:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 777
    iput-object p1, p0, Lcom/facebook/internal/Utility$1;->val$context:Landroid/content/Context;

    iput-object p2, p0, Lcom/facebook/internal/Utility$1;->val$settingsKey:Ljava/lang/String;

    iput-object p3, p0, Lcom/facebook/internal/Utility$1;->val$applicationId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 781
    iget-object v5, p0, Lcom/facebook/internal/Utility$1;->val$context:Landroid/content/Context;

    const-string v6, "com.facebook.internal.preferences.APP_SETTINGS"

    invoke-virtual {v5, v6, v8}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    .line 784
    .local v4, "sharedPrefs":Landroid/content/SharedPreferences;
    iget-object v5, p0, Lcom/facebook/internal/Utility$1;->val$settingsKey:Ljava/lang/String;

    const/4 v6, 0x0

    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 785
    .local v3, "settingsJSONString":Ljava/lang/String;
    invoke-static {v3}, Lcom/facebook/internal/Utility;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 786
    const/4 v2, 0x0

    .line 788
    .local v2, "settingsJSON":Lorg/json/JSONObject;
    :try_start_0
    new-instance v5, Lorg/json/JSONObject;

    invoke-static {v3}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 792
    :goto_0
    if-eqz v2, :cond_0

    .line 793
    iget-object v5, p0, Lcom/facebook/internal/Utility$1;->val$applicationId:Ljava/lang/String;

    # invokes: Lcom/facebook/internal/Utility;->parseAppSettingsFromJSON(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/facebook/internal/Utility$FetchedAppSettings;
    invoke-static {v5, v2}, Lcom/facebook/internal/Utility;->access$000(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/facebook/internal/Utility$FetchedAppSettings;

    .line 797
    .end local v2    # "settingsJSON":Lorg/json/JSONObject;
    :cond_0
    iget-object v5, p0, Lcom/facebook/internal/Utility$1;->val$applicationId:Ljava/lang/String;

    # invokes: Lcom/facebook/internal/Utility;->getAppSettingsQueryResponse(Ljava/lang/String;)Lorg/json/JSONObject;
    invoke-static {v5}, Lcom/facebook/internal/Utility;->access$100(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 798
    .local v1, "resultJSON":Lorg/json/JSONObject;
    if-eqz v1, :cond_1

    .line 799
    iget-object v5, p0, Lcom/facebook/internal/Utility$1;->val$applicationId:Ljava/lang/String;

    # invokes: Lcom/facebook/internal/Utility;->parseAppSettingsFromJSON(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/facebook/internal/Utility$FetchedAppSettings;
    invoke-static {v5, v1}, Lcom/facebook/internal/Utility;->access$000(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/facebook/internal/Utility$FetchedAppSettings;

    .line 801
    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    iget-object v7, p0, Lcom/facebook/internal/Utility$1;->val$settingsKey:Ljava/lang/String;

    .line 802
    instance-of v5, v1, Lorg/json/JSONObject;

    if-nez v5, :cond_2

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    .end local v1    # "resultJSON":Lorg/json/JSONObject;
    :goto_1
    invoke-interface {v6, v7, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    .line 803
    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 806
    :cond_1
    # getter for: Lcom/facebook/internal/Utility;->loadingSettings:Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {}, Lcom/facebook/internal/Utility;->access$200()Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v5

    invoke-virtual {v5, v8}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 807
    return-void

    .line 789
    .restart local v2    # "settingsJSON":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 790
    .local v0, "je":Lorg/json/JSONException;
    const-string v5, "FacebookSDK"

    invoke-static {v5, v0}, Lcom/facebook/internal/Utility;->logd(Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0

    .line 802
    .end local v0    # "je":Lorg/json/JSONException;
    .end local v2    # "settingsJSON":Lorg/json/JSONObject;
    .restart local v1    # "resultJSON":Lorg/json/JSONObject;
    :cond_2
    check-cast v1, Lorg/json/JSONObject;

    .end local v1    # "resultJSON":Lorg/json/JSONObject;
    invoke-static {v1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v5

    goto :goto_1
.end method
