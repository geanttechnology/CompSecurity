.class Lco/vine/android/ConversationActivity$3;
.super Ljava/lang/Object;
.source "ConversationActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


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
    .line 597
    iput-object p1, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 600
    iget-object v1, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;
    invoke-static {v1}, Lco/vine/android/ConversationActivity;->access$200(Lco/vine/android/ConversationActivity;)Lco/vine/android/VineWebSocketClient;

    move-result-object v1

    if-nez v1, :cond_0

    .line 601
    iget-object v1, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    # invokes: Lco/vine/android/ConversationActivity;->prepareClient()V
    invoke-static {v1}, Lco/vine/android/ConversationActivity;->access$700(Lco/vine/android/ConversationActivity;)V

    .line 603
    :cond_0
    iget-object v1, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;
    invoke-static {v1}, Lco/vine/android/ConversationActivity;->access$200(Lco/vine/android/ConversationActivity;)Lco/vine/android/VineWebSocketClient;

    move-result-object v0

    .line 604
    .local v0, "client":Lco/vine/android/VineWebSocketClient;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lco/vine/android/VineWebSocketClient;->isConnecting()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-virtual {v0}, Lco/vine/android/VineWebSocketClient;->isConnected()Z

    move-result v1

    if-nez v1, :cond_1

    .line 605
    invoke-virtual {v0}, Lco/vine/android/VineWebSocketClient;->connect()V

    .line 606
    iget-object v3, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    iget-object v1, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mReconnectDelay:J
    invoke-static {v1}, Lco/vine/android/ConversationActivity;->access$800(Lco/vine/android/ConversationActivity;)J

    move-result-wide v1

    const-wide/16 v4, 0x3e80

    cmp-long v1, v1, v4

    if-gez v1, :cond_2

    iget-object v1, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mReconnectDelay:J
    invoke-static {v1}, Lco/vine/android/ConversationActivity;->access$800(Lco/vine/android/ConversationActivity;)J

    move-result-wide v1

    const-wide/16 v4, 0x2

    mul-long/2addr v1, v4

    :goto_0
    # setter for: Lco/vine/android/ConversationActivity;->mReconnectDelay:J
    invoke-static {v3, v1, v2}, Lco/vine/android/ConversationActivity;->access$802(Lco/vine/android/ConversationActivity;J)J

    .line 608
    iget-object v1, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mMainHandler:Landroid/os/Handler;
    invoke-static {v1}, Lco/vine/android/ConversationActivity;->access$500(Lco/vine/android/ConversationActivity;)Landroid/os/Handler;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mReconnectRunnable:Ljava/lang/Runnable;
    invoke-static {v2}, Lco/vine/android/ConversationActivity;->access$400(Lco/vine/android/ConversationActivity;)Ljava/lang/Runnable;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mReconnectDelay:J
    invoke-static {v3}, Lco/vine/android/ConversationActivity;->access$800(Lco/vine/android/ConversationActivity;)J

    move-result-wide v3

    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 609
    const-string v1, "ConvActivity;RTC"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Posted reconnect with delay="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mReconnectDelay:J
    invoke-static {v3}, Lco/vine/android/ConversationActivity;->access$800(Lco/vine/android/ConversationActivity;)J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "ms"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 611
    :cond_1
    return-void

    .line 606
    :cond_2
    iget-object v1, p0, Lco/vine/android/ConversationActivity$3;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mReconnectDelay:J
    invoke-static {v1}, Lco/vine/android/ConversationActivity;->access$800(Lco/vine/android/ConversationActivity;)J

    move-result-wide v1

    goto :goto_0
.end method
