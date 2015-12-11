.class Lnet/singular/sdk/SessionManager$1;
.super Ljava/lang/Object;
.source "SessionManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/SessionManager;->onPause()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/SessionManager;

.field final synthetic val$session_end_event:Lorg/json/JSONObject;


# direct methods
.method constructor <init>(Lnet/singular/sdk/SessionManager;Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lnet/singular/sdk/SessionManager$1;->this$0:Lnet/singular/sdk/SessionManager;

    iput-object p2, p0, Lnet/singular/sdk/SessionManager$1;->val$session_end_event:Lorg/json/JSONObject;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 132
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/SessionManager$1;->this$0:Lnet/singular/sdk/SessionManager;

    # getter for: Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v1}, Lnet/singular/sdk/SessionManager;->access$000(Lnet/singular/sdk/SessionManager;)Lnet/singular/sdk/SingularLog;

    move-result-object v1

    const-string v2, "singular_sdk"

    const-string v3, "SessionManager: delayed Runnable started"

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 133
    iget-object v1, p0, Lnet/singular/sdk/SessionManager$1;->this$0:Lnet/singular/sdk/SessionManager;

    # getter for: Lnet/singular/sdk/SessionManager;->controller:Lnet/singular/sdk/Controller;
    invoke-static {v1}, Lnet/singular/sdk/SessionManager;->access$100(Lnet/singular/sdk/SessionManager;)Lnet/singular/sdk/Controller;

    move-result-object v1

    iget-object v2, p0, Lnet/singular/sdk/SessionManager$1;->val$session_end_event:Lorg/json/JSONObject;

    invoke-virtual {v1, v2}, Lnet/singular/sdk/Controller;->postEventNow(Lorg/json/JSONObject;)V

    .line 134
    iget-object v1, p0, Lnet/singular/sdk/SessionManager$1;->this$0:Lnet/singular/sdk/SessionManager;

    # invokes: Lnet/singular/sdk/SessionManager;->deleteSessionFromKeyValueStore()V
    invoke-static {v1}, Lnet/singular/sdk/SessionManager;->access$200(Lnet/singular/sdk/SessionManager;)V

    .line 135
    iget-object v1, p0, Lnet/singular/sdk/SessionManager$1;->this$0:Lnet/singular/sdk/SessionManager;

    const/4 v2, 0x0

    # setter for: Lnet/singular/sdk/SessionManager;->session_id:Ljava/lang/String;
    invoke-static {v1, v2}, Lnet/singular/sdk/SessionManager;->access$302(Lnet/singular/sdk/SessionManager;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 140
    :goto_0
    return-void

    .line 136
    :catch_0
    move-exception v0

    .line 138
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v1, p0, Lnet/singular/sdk/SessionManager$1;->this$0:Lnet/singular/sdk/SessionManager;

    # getter for: Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v1}, Lnet/singular/sdk/SessionManager;->access$000(Lnet/singular/sdk/SessionManager;)Lnet/singular/sdk/SingularLog;

    move-result-object v1

    const-string v2, "singular_sdk"

    const-string v3, "SessionManager:onPause() failed"

    invoke-virtual {v1, v2, v3, v0}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
