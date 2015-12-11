.class Lcom/facebook/InsightsLogger$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/facebook/InsightsLogger;

.field final synthetic val$eventName:Ljava/lang/String;

.field final synthetic val$parameters:Landroid/os/Bundle;

.field final synthetic val$valueToSum:D


# direct methods
.method constructor <init>(Lcom/facebook/InsightsLogger;Ljava/lang/String;DLandroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 214
    iput-object p1, p0, Lcom/facebook/InsightsLogger$1;->this$0:Lcom/facebook/InsightsLogger;

    iput-object p2, p0, Lcom/facebook/InsightsLogger$1;->val$eventName:Ljava/lang/String;

    iput-wide p3, p0, Lcom/facebook/InsightsLogger$1;->val$valueToSum:D

    iput-object p5, p0, Lcom/facebook/InsightsLogger$1;->val$parameters:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 219
    iget-object v0, p0, Lcom/facebook/InsightsLogger$1;->val$eventName:Ljava/lang/String;

    iget-wide v1, p0, Lcom/facebook/InsightsLogger$1;->val$valueToSum:D

    iget-object v3, p0, Lcom/facebook/InsightsLogger$1;->val$parameters:Landroid/os/Bundle;

    # invokes: Lcom/facebook/InsightsLogger;->buildJSONForEvent(Ljava/lang/String;DLandroid/os/Bundle;)Ljava/lang/String;
    invoke-static {v0, v1, v2, v3}, Lcom/facebook/InsightsLogger;->access$000(Ljava/lang/String;DLandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    .line 220
    if-nez v0, :cond_1

    .line 261
    :cond_0
    :goto_0
    return-void

    .line 225
    :cond_1
    invoke-static {}, Lcom/facebook/model/GraphObject$Factory;->create()Lcom/facebook/model/GraphObject;

    move-result-object v1

    .line 226
    const-string v2, "event"

    const-string v3, "CUSTOM_APP_EVENTS"

    invoke-interface {v1, v2, v3}, Lcom/facebook/model/GraphObject;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    .line 227
    const-string v2, "custom_events"

    invoke-interface {v1, v2, v0}, Lcom/facebook/model/GraphObject;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    .line 229
    iget-object v2, p0, Lcom/facebook/InsightsLogger$1;->this$0:Lcom/facebook/InsightsLogger;

    # getter for: Lcom/facebook/InsightsLogger;->applicationId:Ljava/lang/String;
    invoke-static {v2}, Lcom/facebook/InsightsLogger;->access$100(Lcom/facebook/InsightsLogger;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/facebook/internal/Utility;->queryAppAttributionSupportAndWait(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 230
    iget-object v2, p0, Lcom/facebook/InsightsLogger$1;->this$0:Lcom/facebook/InsightsLogger;

    # getter for: Lcom/facebook/InsightsLogger;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/facebook/InsightsLogger;->access$200(Lcom/facebook/InsightsLogger;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-static {v2}, Lcom/facebook/Settings;->getAttributionId(Landroid/content/ContentResolver;)Ljava/lang/String;

    move-result-object v2

    .line 231
    if-eqz v2, :cond_2

    .line 232
    const-string v3, "attribution"

    invoke-interface {v1, v3, v2}, Lcom/facebook/model/GraphObject;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    .line 236
    :cond_2
    const-string v2, "%s/activities"

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/facebook/InsightsLogger$1;->this$0:Lcom/facebook/InsightsLogger;

    # getter for: Lcom/facebook/InsightsLogger;->applicationId:Ljava/lang/String;
    invoke-static {v4}, Lcom/facebook/InsightsLogger;->access$100(Lcom/facebook/InsightsLogger;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 240
    :try_start_0
    iget-object v3, p0, Lcom/facebook/InsightsLogger$1;->this$0:Lcom/facebook/InsightsLogger;

    # invokes: Lcom/facebook/InsightsLogger;->sessionToLogTo()Lcom/facebook/Session;
    invoke-static {v3}, Lcom/facebook/InsightsLogger;->access$300(Lcom/facebook/InsightsLogger;)Lcom/facebook/Session;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v3, v2, v1, v4}, Lcom/facebook/Request;->newPostRequest(Lcom/facebook/Session;Ljava/lang/String;Lcom/facebook/model/GraphObject;Lcom/facebook/Request$Callback;)Lcom/facebook/Request;

    move-result-object v1

    .line 241
    invoke-virtual {v1}, Lcom/facebook/Request;->executeAndWait()Lcom/facebook/Response;

    move-result-object v1

    .line 245
    invoke-virtual {v1}, Lcom/facebook/Response;->getError()Lcom/facebook/FacebookRequestError;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Lcom/facebook/Response;->getError()Lcom/facebook/FacebookRequestError;

    move-result-object v2

    invoke-virtual {v2}, Lcom/facebook/FacebookRequestError;->getErrorCode()I

    move-result v2

    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    .line 248
    const-string v2, "Error publishing Insights event \'%s\'\n  Response: %s\n  Error: %s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    const/4 v0, 0x1

    invoke-virtual {v1}, Lcom/facebook/Response;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v0, 0x2

    invoke-virtual {v1}, Lcom/facebook/Response;->getError()Lcom/facebook/FacebookRequestError;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/FacebookRequestError;->toString()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v0

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    # invokes: Lcom/facebook/InsightsLogger;->notifyDeveloperError(Ljava/lang/String;)V
    invoke-static {v0}, Lcom/facebook/InsightsLogger;->access$400(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 256
    :catch_0
    move-exception v0

    .line 258
    const-string v1, "Insights-exception: "

    invoke-static {v1, v0}, Lcom/facebook/internal/Utility;->logd(Ljava/lang/String;Ljava/lang/Exception;)V

    goto/16 :goto_0
.end method
