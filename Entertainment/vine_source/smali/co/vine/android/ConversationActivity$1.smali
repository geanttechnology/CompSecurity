.class Lco/vine/android/ConversationActivity$1;
.super Landroid/content/BroadcastReceiver;
.source "ConversationActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ConversationActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationActivity;


# direct methods
.method constructor <init>(Lco/vine/android/ConversationActivity;)V
    .locals 0

    .prologue
    .line 414
    iput-object p1, p0, Lco/vine/android/ConversationActivity$1;->this$0:Lco/vine/android/ConversationActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 418
    :try_start_0
    const-string v4, "connectivity"

    invoke-virtual {p1, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/ConnectivityManager;

    .line 420
    .local v1, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 421
    .local v0, "activeNetwork":Landroid/net/NetworkInfo;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v4

    if-eqz v4, :cond_1

    const/4 v3, 0x1

    .line 422
    .local v3, "isConnected":Z
    :goto_0
    if-eqz v3, :cond_0

    iget-object v4, p0, Lco/vine/android/ConversationActivity$1;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mLastIsConnected:Z
    invoke-static {v4}, Lco/vine/android/ConversationActivity;->access$300(Lco/vine/android/ConversationActivity;)Z

    move-result v4

    if-eq v4, v3, :cond_0

    .line 423
    const-string v4, "ConvActivity;RTC"

    const-string v5, "Connectivity change received, reconnecting"

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 424
    iget-object v4, p0, Lco/vine/android/ConversationActivity$1;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mMainHandler:Landroid/os/Handler;
    invoke-static {v4}, Lco/vine/android/ConversationActivity;->access$500(Lco/vine/android/ConversationActivity;)Landroid/os/Handler;

    move-result-object v4

    iget-object v5, p0, Lco/vine/android/ConversationActivity$1;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mReconnectRunnable:Ljava/lang/Runnable;
    invoke-static {v5}, Lco/vine/android/ConversationActivity;->access$400(Lco/vine/android/ConversationActivity;)Ljava/lang/Runnable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 425
    iget-object v4, p0, Lco/vine/android/ConversationActivity$1;->this$0:Lco/vine/android/ConversationActivity;

    # invokes: Lco/vine/android/ConversationActivity;->reconnectWithBackoff()V
    invoke-static {v4}, Lco/vine/android/ConversationActivity;->access$600(Lco/vine/android/ConversationActivity;)V

    .line 427
    :cond_0
    iget-object v4, p0, Lco/vine/android/ConversationActivity$1;->this$0:Lco/vine/android/ConversationActivity;

    # setter for: Lco/vine/android/ConversationActivity;->mLastIsConnected:Z
    invoke-static {v4, v3}, Lco/vine/android/ConversationActivity;->access$302(Lco/vine/android/ConversationActivity;Z)Z
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 431
    .end local v0    # "activeNetwork":Landroid/net/NetworkInfo;
    .end local v1    # "cm":Landroid/net/ConnectivityManager;
    .end local v3    # "isConnected":Z
    :goto_1
    return-void

    .line 421
    .restart local v0    # "activeNetwork":Landroid/net/NetworkInfo;
    .restart local v1    # "cm":Landroid/net/ConnectivityManager;
    :cond_1
    const/4 v3, 0x0

    goto :goto_0

    .line 428
    .end local v0    # "activeNetwork":Landroid/net/NetworkInfo;
    .end local v1    # "cm":Landroid/net/ConnectivityManager;
    :catch_0
    move-exception v2

    .line 429
    .local v2, "e":Ljava/lang/SecurityException;
    const-string v4, "We are not gangsta enough to acess the connectivity state."

    invoke-static {v4, v2}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method
