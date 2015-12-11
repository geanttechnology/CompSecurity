.class Lnet/singular/sdk/Collector$4;
.super Ljava/lang/Object;
.source "Collector.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/Collector;->saveTemporalIds(Lnet/singular/sdk/PostableWorker;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/Collector;


# direct methods
.method constructor <init>(Lnet/singular/sdk/Collector;)V
    .locals 0

    .prologue
    .line 357
    iput-object p1, p0, Lnet/singular/sdk/Collector$4;->this$0:Lnet/singular/sdk/Collector;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 361
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/Collector$4;->this$0:Lnet/singular/sdk/Collector;

    # invokes: Lnet/singular/sdk/Collector;->initKeyValueStore()V
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$300(Lnet/singular/sdk/Collector;)V

    .line 363
    iget-object v1, p0, Lnet/singular/sdk/Collector$4;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->preferences:Lnet/singular/sdk/KeyValueStore;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$400(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/KeyValueStore;

    move-result-object v2

    const-string v3, "temporal_ids"

    iget-object v1, p0, Lnet/singular/sdk/Collector$4;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->temporalIds:Lorg/json/JSONObject;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$500(Lnet/singular/sdk/Collector;)Lorg/json/JSONObject;

    move-result-object v1

    instance-of v4, v1, Lorg/json/JSONObject;

    if-nez v4, :cond_0

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_0
    invoke-virtual {v2, v3, v1}, Lnet/singular/sdk/KeyValueStore;->put(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 365
    iget-object v1, p0, Lnet/singular/sdk/Collector$4;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$200(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/SingularLog;

    move-result-object v1

    const-string v2, "singular_sdk"

    const-string v3, "saveTemporalIdsRunnable: couldn\'t save the temporal id"

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;)V

    .line 372
    :goto_1
    return-void

    .line 363
    :cond_0
    check-cast v1, Lorg/json/JSONObject;

    invoke-static {v1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 367
    :cond_1
    iget-object v1, p0, Lnet/singular/sdk/Collector$4;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$200(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/SingularLog;

    move-result-object v1

    const-string v2, "singular_sdk"

    const-string v3, "saveTemporalIdsRunnable: Successful!"

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/SingularLog;->v(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 369
    :catch_0
    move-exception v0

    .line 370
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v1, p0, Lnet/singular/sdk/Collector$4;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$200(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/SingularLog;

    move-result-object v1

    const-string v2, "singular_sdk"

    const-string v3, "saveTemporalIdsRunnable: RuntimeException - couldn\'t save the temporal id"

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method
