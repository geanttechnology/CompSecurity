.class Lnet/singular/sdk/Controller$5;
.super Ljava/lang/Object;
.source "Controller.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/Controller;->postEventDelayed(Lorg/json/JSONObject;J)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/Controller;

.field final synthetic val$delayMillis:J

.field final synthetic val$event_copy:Lorg/json/JSONObject;


# direct methods
.method constructor <init>(Lnet/singular/sdk/Controller;Lorg/json/JSONObject;J)V
    .locals 1

    .prologue
    .line 281
    iput-object p1, p0, Lnet/singular/sdk/Controller$5;->this$0:Lnet/singular/sdk/Controller;

    iput-object p2, p0, Lnet/singular/sdk/Controller$5;->val$event_copy:Lorg/json/JSONObject;

    iput-wide p3, p0, Lnet/singular/sdk/Controller$5;->val$delayMillis:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    .prologue
    .line 285
    :try_start_0
    iget-object v4, p0, Lnet/singular/sdk/Controller$5;->this$0:Lnet/singular/sdk/Controller;

    # getter for: Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;
    invoke-static {v4}, Lnet/singular/sdk/Controller;->access$500(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/Collector;

    move-result-object v4

    invoke-virtual {v4}, Lnet/singular/sdk/Collector;->getTemporalIds()Lorg/json/JSONObject;

    move-result-object v3

    .line 286
    .local v3, "temporal_ids":Lorg/json/JSONObject;
    invoke-virtual {v3}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v1

    .line 287
    .local v1, "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 288
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 289
    .local v2, "key":Ljava/lang/String;
    const-string v4, "event_timestamp_s"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    const-string v4, "sdk_event_id"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 293
    iget-object v4, p0, Lnet/singular/sdk/Controller$5;->val$event_copy:Lorg/json/JSONObject;

    invoke-virtual {v3, v2}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v2, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 303
    .end local v1    # "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "temporal_ids":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 304
    .local v0, "e":Lorg/json/JSONException;
    iget-object v4, p0, Lnet/singular/sdk/Controller$5;->this$0:Lnet/singular/sdk/Controller;

    const-string v5, "postEventDelayed runnable"

    # invokes: Lnet/singular/sdk/Controller;->logException(Ljava/lang/Exception;Ljava/lang/String;)V
    invoke-static {v4, v0, v5}, Lnet/singular/sdk/Controller;->access$300(Lnet/singular/sdk/Controller;Ljava/lang/Exception;Ljava/lang/String;)V

    .line 308
    .end local v0    # "e":Lorg/json/JSONException;
    :goto_1
    return-void

    .line 296
    .restart local v1    # "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .restart local v3    # "temporal_ids":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    iget-object v4, p0, Lnet/singular/sdk/Controller$5;->this$0:Lnet/singular/sdk/Controller;

    # getter for: Lnet/singular/sdk/Controller;->eventStore:Lnet/singular/sdk/EventStore;
    invoke-static {v4}, Lnet/singular/sdk/Controller;->access$600(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/EventStore;

    move-result-object v4

    iget-object v5, p0, Lnet/singular/sdk/Controller$5;->val$event_copy:Lorg/json/JSONObject;

    invoke-virtual {v4, v5}, Lnet/singular/sdk/EventStore;->addEvent(Lorg/json/JSONObject;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 297
    iget-object v4, p0, Lnet/singular/sdk/Controller$5;->this$0:Lnet/singular/sdk/Controller;

    # getter for: Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v4}, Lnet/singular/sdk/Controller;->access$700(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/SingularLog;

    move-result-object v4

    const-string v5, "net.singular.sdk.Controller"

    const-string v6, "postEventDelayed: event saved to db, posting with delay = %d to sender"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-wide v10, p0, Lnet/singular/sdk/Controller$5;->val$delayMillis:J

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    iget-object v4, p0, Lnet/singular/sdk/Controller$5;->this$0:Lnet/singular/sdk/Controller;

    iget-wide v6, p0, Lnet/singular/sdk/Controller$5;->val$delayMillis:J

    invoke-virtual {v4, v6, v7}, Lnet/singular/sdk/Controller;->activateSender(J)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 305
    .end local v1    # "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v3    # "temporal_ids":Lorg/json/JSONObject;
    :catch_1
    move-exception v0

    .line 306
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v4, p0, Lnet/singular/sdk/Controller$5;->this$0:Lnet/singular/sdk/Controller;

    const-string v5, "postEventDelayed runnable"

    # invokes: Lnet/singular/sdk/Controller;->logException(Ljava/lang/Exception;Ljava/lang/String;)V
    invoke-static {v4, v0, v5}, Lnet/singular/sdk/Controller;->access$300(Lnet/singular/sdk/Controller;Ljava/lang/Exception;Ljava/lang/String;)V

    goto :goto_1

    .line 301
    .end local v0    # "e":Ljava/lang/RuntimeException;
    .restart local v1    # "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .restart local v3    # "temporal_ids":Lorg/json/JSONObject;
    :cond_2
    :try_start_2
    iget-object v4, p0, Lnet/singular/sdk/Controller$5;->this$0:Lnet/singular/sdk/Controller;

    # getter for: Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v4}, Lnet/singular/sdk/Controller;->access$700(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/SingularLog;

    move-result-object v4

    const-string v5, "net.singular.sdk.Controller"

    const-string v6, "postEventDelayed: eventStore.addEvent failed :("

    invoke-virtual {v4, v5, v6}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1
.end method
