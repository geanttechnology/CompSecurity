.class public Lcom/amazon/client/ftue/InferenceResponseReceiver;
.super Landroid/content/BroadcastReceiver;
.source "InferenceResponseReceiver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;
    }
.end annotation


# static fields
.field private static final LOG:Lcom/amazon/logging/Logger;


# instance fields
.field private final listener:Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/client/ftue/InferenceResponseReceiver;

    invoke-static {v0}, Lcom/amazon/venezia/logging/Loggers;->logger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/client/ftue/InferenceResponseReceiver;->LOG:Lcom/amazon/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;

    .prologue
    .line 50
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 51
    iput-object p1, p0, Lcom/amazon/client/ftue/InferenceResponseReceiver;->listener:Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;

    .line 52
    return-void
.end method


# virtual methods
.method public getIntentFilter()Landroid/content/IntentFilter;
    .locals 2

    .prologue
    .line 72
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 73
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string/jumbo v1, "com.amazon.mas.client.authentication.InferredCorPfm.RESPONSE"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 74
    const-string/jumbo v1, "com.amazon.mas.client.authentication.InferredCorPfm.INTERACTIVE"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 75
    return-object v0
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 56
    iget-object v1, p0, Lcom/amazon/client/ftue/InferenceResponseReceiver;->listener:Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;

    if-eqz v1, :cond_0

    .line 57
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 58
    .local v0, "action":Ljava/lang/String;
    const-string/jumbo v1, "com.amazon.mas.client.authentication.InferredCorPfm.RESPONSE"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 59
    sget-object v1, Lcom/amazon/client/ftue/InferenceResponseReceiver;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v2, "Received FTUE Inference broadcast"

    invoke-virtual {v1, v2}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 60
    iget-object v1, p0, Lcom/amazon/client/ftue/InferenceResponseReceiver;->listener:Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;

    invoke-interface {v1, p2}, Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;->onInferenceComplete(Landroid/content/Intent;)V

    .line 65
    .end local v0    # "action":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 61
    .restart local v0    # "action":Ljava/lang/String;
    :cond_1
    const-string/jumbo v1, "com.amazon.mas.client.authentication.InferredCorPfm.INTERACTIVE"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 62
    iget-object v1, p0, Lcom/amazon/client/ftue/InferenceResponseReceiver;->listener:Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;

    invoke-interface {v1, p2}, Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;->onInferenceRequiresInteraction(Landroid/content/Intent;)V

    goto :goto_0
.end method
