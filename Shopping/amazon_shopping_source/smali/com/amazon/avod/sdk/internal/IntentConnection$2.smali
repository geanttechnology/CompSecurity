.class Lcom/amazon/avod/sdk/internal/IntentConnection$2;
.super Landroid/content/BroadcastReceiver;
.source "IntentConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/avod/sdk/internal/IntentConnection;->informApp(Ljava/lang/String;Lcom/amazon/avod/sdk/ResponseHandler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/avod/sdk/internal/IntentConnection;

.field final synthetic val$responseHandler:Lcom/amazon/avod/sdk/ResponseHandler;


# direct methods
.method constructor <init>(Lcom/amazon/avod/sdk/internal/IntentConnection;Lcom/amazon/avod/sdk/ResponseHandler;)V
    .locals 0

    .prologue
    .line 244
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/IntentConnection$2;->this$0:Lcom/amazon/avod/sdk/internal/IntentConnection;

    iput-object p2, p0, Lcom/amazon/avod/sdk/internal/IntentConnection$2;->val$responseHandler:Lcom/amazon/avod/sdk/ResponseHandler;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 247
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/amazon/avod/sdk/internal/IntentConnection$2;->getResultExtras(Z)Landroid/os/Bundle;

    move-result-object v0

    .line 248
    .local v0, "results":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/IntentConnection$2;->val$responseHandler:Lcom/amazon/avod/sdk/ResponseHandler;

    if-eqz v1, :cond_0

    .line 249
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/IntentConnection$2;->val$responseHandler:Lcom/amazon/avod/sdk/ResponseHandler;

    invoke-static {v0}, Lcom/amazon/avod/sdk/CallResponse;->fromBundle(Landroid/os/Bundle;)Lcom/amazon/avod/sdk/CallResponse;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/amazon/avod/sdk/ResponseHandler;->handleResponse(Lcom/amazon/avod/sdk/CallResponse;)V

    .line 251
    :cond_0
    return-void
.end method
