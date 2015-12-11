.class Lnet/singular/sdk/CountersLogger$1;
.super Ljava/lang/Object;
.source "CountersLogger.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/CountersLogger;->saveCounters()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/CountersLogger;


# direct methods
.method constructor <init>(Lnet/singular/sdk/CountersLogger;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lnet/singular/sdk/CountersLogger$1;->this$0:Lnet/singular/sdk/CountersLogger;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 94
    :try_start_0
    iget-object v0, p0, Lnet/singular/sdk/CountersLogger$1;->this$0:Lnet/singular/sdk/CountersLogger;

    # getter for: Lnet/singular/sdk/CountersLogger;->countersKeyValueStore:Lnet/singular/sdk/KeyValueStore;
    invoke-static {v0}, Lnet/singular/sdk/CountersLogger;->access$100(Lnet/singular/sdk/CountersLogger;)Lnet/singular/sdk/KeyValueStore;

    move-result-object v1

    const-string v2, "COUNTERS_KEY"

    iget-object v0, p0, Lnet/singular/sdk/CountersLogger$1;->this$0:Lnet/singular/sdk/CountersLogger;

    # getter for: Lnet/singular/sdk/CountersLogger;->counters:Lorg/json/JSONObject;
    invoke-static {v0}, Lnet/singular/sdk/CountersLogger;->access$000(Lnet/singular/sdk/CountersLogger;)Lorg/json/JSONObject;

    move-result-object v0

    instance-of v3, v0, Lorg/json/JSONObject;

    if-nez v3, :cond_0

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v1, v2, v0}, Lnet/singular/sdk/KeyValueStore;->put(Ljava/lang/String;Ljava/lang/String;)Z

    .line 96
    :goto_1
    return-void

    .line 94
    :cond_0
    check-cast v0, Lorg/json/JSONObject;

    invoke-static {v0}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 95
    :catch_0
    move-exception v0

    goto :goto_1
.end method
