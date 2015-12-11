.class Lio/branch/referral/ServerRequestQueue$1;
.super Ljava/lang/Object;
.source "ServerRequestQueue.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/ServerRequestQueue;->persist()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/branch/referral/ServerRequestQueue;


# direct methods
.method constructor <init>(Lio/branch/referral/ServerRequestQueue;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lio/branch/referral/ServerRequestQueue$1;->this$0:Lio/branch/referral/ServerRequestQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 11

    .prologue
    .line 69
    new-instance v5, Lorg/json/JSONArray;

    invoke-direct {v5}, Lorg/json/JSONArray;-><init>()V

    .line 70
    .local v5, "jsonArr":Lorg/json/JSONArray;
    iget-object v6, p0, Lio/branch/referral/ServerRequestQueue$1;->this$0:Lio/branch/referral/ServerRequestQueue;

    # getter for: Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;
    invoke-static {v6}, Lio/branch/referral/ServerRequestQueue;->access$000(Lio/branch/referral/ServerRequestQueue;)Ljava/util/List;

    move-result-object v8

    monitor-enter v8

    .line 71
    :try_start_0
    iget-object v6, p0, Lio/branch/referral/ServerRequestQueue$1;->this$0:Lio/branch/referral/ServerRequestQueue;

    # getter for: Lio/branch/referral/ServerRequestQueue;->queue:Ljava/util/List;
    invoke-static {v6}, Lio/branch/referral/ServerRequestQueue;->access$000(Lio/branch/referral/ServerRequestQueue;)Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/branch/referral/ServerRequest;

    .line 72
    .local v1, "aQueue":Lio/branch/referral/ServerRequest;
    invoke-virtual {v1}, Lio/branch/referral/ServerRequest;->toJSON()Lorg/json/JSONObject;

    move-result-object v4

    .line 73
    .local v4, "json":Lorg/json/JSONObject;
    if-eqz v4, :cond_0

    .line 74
    invoke-virtual {v5, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_0

    .line 87
    .end local v1    # "aQueue":Lio/branch/referral/ServerRequest;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "json":Lorg/json/JSONObject;
    .end local v5    # "jsonArr":Lorg/json/JSONArray;
    :catchall_0
    move-exception v6

    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v6

    .line 79
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v5    # "jsonArr":Lorg/json/JSONArray;
    :cond_1
    :try_start_1
    iget-object v6, p0, Lio/branch/referral/ServerRequestQueue$1;->this$0:Lio/branch/referral/ServerRequestQueue;

    # getter for: Lio/branch/referral/ServerRequestQueue;->editor:Landroid/content/SharedPreferences$Editor;
    invoke-static {v6}, Lio/branch/referral/ServerRequestQueue;->access$100(Lio/branch/referral/ServerRequestQueue;)Landroid/content/SharedPreferences$Editor;

    move-result-object v7

    const-string v9, "BNCServerRequestQueue"

    instance-of v6, v5, Lorg/json/JSONArray;

    if-nez v6, :cond_2

    invoke-virtual {v5}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v6

    :goto_1
    invoke-interface {v7, v9, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_1
    .catch Ljava/util/ConcurrentModificationException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 84
    :try_start_2
    iget-object v6, p0, Lio/branch/referral/ServerRequestQueue$1;->this$0:Lio/branch/referral/ServerRequestQueue;

    # getter for: Lio/branch/referral/ServerRequestQueue;->editor:Landroid/content/SharedPreferences$Editor;
    invoke-static {v6}, Lio/branch/referral/ServerRequestQueue;->access$100(Lio/branch/referral/ServerRequestQueue;)Landroid/content/SharedPreferences$Editor;

    move-result-object v7

    const-string v9, "BNCServerRequestQueue"

    instance-of v6, v5, Lorg/json/JSONArray;

    if-nez v6, :cond_3

    invoke-virtual {v5}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v6

    .end local v5    # "jsonArr":Lorg/json/JSONArray;
    :goto_2
    invoke-interface {v7, v9, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_2
    .catch Ljava/util/ConcurrentModificationException; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 87
    :goto_3
    :try_start_3
    monitor-exit v8
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 88
    return-void

    .line 79
    .restart local v5    # "jsonArr":Lorg/json/JSONArray;
    :cond_2
    :try_start_4
    move-object v0, v5

    check-cast v0, Lorg/json/JSONArray;

    move-object v6, v0

    invoke-static {v6}, Lcom/newrelic/agent/android/instrumentation/JSONArrayInstrumentation;->toString(Lorg/json/JSONArray;)Ljava/lang/String;
    :try_end_4
    .catch Ljava/util/ConcurrentModificationException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result-object v6

    goto :goto_1

    .line 84
    :cond_3
    :try_start_5
    check-cast v5, Lorg/json/JSONArray;

    .end local v5    # "jsonArr":Lorg/json/JSONArray;
    invoke-static {v5}, Lcom/newrelic/agent/android/instrumentation/JSONArrayInstrumentation;->toString(Lorg/json/JSONArray;)Ljava/lang/String;
    :try_end_5
    .catch Ljava/util/ConcurrentModificationException; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-result-object v6

    goto :goto_2

    .line 80
    .restart local v5    # "jsonArr":Lorg/json/JSONArray;
    :catch_0
    move-exception v2

    .line 81
    .local v2, "ex":Ljava/util/ConcurrentModificationException;
    :try_start_6
    const-string v7, "Persisting Queue: "

    instance-of v6, v5, Lorg/json/JSONArray;

    if-nez v6, :cond_4

    invoke-virtual {v5}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v6

    :goto_4
    invoke-static {v7, v6}, Lio/branch/referral/PrefHelper;->Debug(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 84
    :try_start_7
    iget-object v6, p0, Lio/branch/referral/ServerRequestQueue$1;->this$0:Lio/branch/referral/ServerRequestQueue;

    # getter for: Lio/branch/referral/ServerRequestQueue;->editor:Landroid/content/SharedPreferences$Editor;
    invoke-static {v6}, Lio/branch/referral/ServerRequestQueue;->access$100(Lio/branch/referral/ServerRequestQueue;)Landroid/content/SharedPreferences$Editor;

    move-result-object v7

    const-string v9, "BNCServerRequestQueue"

    instance-of v6, v5, Lorg/json/JSONArray;

    if-nez v6, :cond_5

    invoke-virtual {v5}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v6

    .end local v5    # "jsonArr":Lorg/json/JSONArray;
    :goto_5
    invoke-interface {v7, v9, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_7
    .catch Ljava/util/ConcurrentModificationException; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto :goto_3

    .line 85
    :catch_1
    move-exception v6

    goto :goto_3

    .line 81
    .restart local v5    # "jsonArr":Lorg/json/JSONArray;
    :cond_4
    :try_start_8
    move-object v0, v5

    check-cast v0, Lorg/json/JSONArray;

    move-object v6, v0

    invoke-static {v6}, Lcom/newrelic/agent/android/instrumentation/JSONArrayInstrumentation;->toString(Lorg/json/JSONArray;)Ljava/lang/String;
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    move-result-object v6

    goto :goto_4

    .line 84
    :cond_5
    :try_start_9
    check-cast v5, Lorg/json/JSONArray;

    .end local v5    # "jsonArr":Lorg/json/JSONArray;
    invoke-static {v5}, Lcom/newrelic/agent/android/instrumentation/JSONArrayInstrumentation;->toString(Lorg/json/JSONArray;)Ljava/lang/String;
    :try_end_9
    .catch Ljava/util/ConcurrentModificationException; {:try_start_9 .. :try_end_9} :catch_1
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    move-result-object v6

    goto :goto_5

    .line 83
    .end local v2    # "ex":Ljava/util/ConcurrentModificationException;
    .restart local v5    # "jsonArr":Lorg/json/JSONArray;
    :catchall_1
    move-exception v6

    .line 84
    :try_start_a
    iget-object v7, p0, Lio/branch/referral/ServerRequestQueue$1;->this$0:Lio/branch/referral/ServerRequestQueue;

    # getter for: Lio/branch/referral/ServerRequestQueue;->editor:Landroid/content/SharedPreferences$Editor;
    invoke-static {v7}, Lio/branch/referral/ServerRequestQueue;->access$100(Lio/branch/referral/ServerRequestQueue;)Landroid/content/SharedPreferences$Editor;

    move-result-object v9

    const-string v10, "BNCServerRequestQueue"

    instance-of v7, v5, Lorg/json/JSONArray;

    if-nez v7, :cond_6

    invoke-virtual {v5}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v7

    .end local v5    # "jsonArr":Lorg/json/JSONArray;
    :goto_6
    invoke-interface {v9, v10, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v7

    invoke-interface {v7}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_a
    .catch Ljava/util/ConcurrentModificationException; {:try_start_a .. :try_end_a} :catch_2
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 85
    :goto_7
    :try_start_b
    throw v6
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    .line 84
    .restart local v5    # "jsonArr":Lorg/json/JSONArray;
    :cond_6
    :try_start_c
    check-cast v5, Lorg/json/JSONArray;

    .end local v5    # "jsonArr":Lorg/json/JSONArray;
    invoke-static {v5}, Lcom/newrelic/agent/android/instrumentation/JSONArrayInstrumentation;->toString(Lorg/json/JSONArray;)Ljava/lang/String;
    :try_end_c
    .catch Ljava/util/ConcurrentModificationException; {:try_start_c .. :try_end_c} :catch_2
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    move-result-object v7

    goto :goto_6

    .line 85
    :catch_2
    move-exception v7

    goto :goto_7

    :catch_3
    move-exception v6

    goto :goto_3
.end method
