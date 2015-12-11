.class Lco/vine/android/ConversationActivity$RealTimeChatReceiver;
.super Landroid/content/BroadcastReceiver;
.source "ConversationActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ConversationActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RealTimeChatReceiver"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationActivity;


# direct methods
.method private constructor <init>(Lco/vine/android/ConversationActivity;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lco/vine/android/ConversationActivity$RealTimeChatReceiver;->this$0:Lco/vine/android/ConversationActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/ConversationActivity;Lco/vine/android/ConversationActivity$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/ConversationActivity;
    .param p2, "x1"    # Lco/vine/android/ConversationActivity$1;

    .prologue
    .line 171
    invoke-direct {p0, p1}, Lco/vine/android/ConversationActivity$RealTimeChatReceiver;-><init>(Lco/vine/android/ConversationActivity;)V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const-wide/16 v6, 0x0

    .line 174
    const-string v4, "co.vine.android.service.mergeSelfNewMessage"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 175
    const-string v4, "message_id"

    invoke-virtual {p2, v4, v6, v7}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v2

    .line 176
    .local v2, "messageId":J
    const-string v4, "conversation_id"

    invoke-virtual {p2, v4, v6, v7}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v0

    .line 177
    .local v0, "conversationId":J
    cmp-long v4, v2, v6

    if-lez v4, :cond_0

    cmp-long v4, v0, v6

    if-lez v4, :cond_0

    iget-object v4, p0, Lco/vine/android/ConversationActivity$RealTimeChatReceiver;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;
    invoke-static {v4}, Lco/vine/android/ConversationActivity;->access$200(Lco/vine/android/ConversationActivity;)Lco/vine/android/VineWebSocketClient;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 178
    iget-object v4, p0, Lco/vine/android/ConversationActivity$RealTimeChatReceiver;->this$0:Lco/vine/android/ConversationActivity;

    # getter for: Lco/vine/android/ConversationActivity;->mClient:Lco/vine/android/VineWebSocketClient;
    invoke-static {v4}, Lco/vine/android/ConversationActivity;->access$200(Lco/vine/android/ConversationActivity;)Lco/vine/android/VineWebSocketClient;

    move-result-object v4

    invoke-virtual {v4, v0, v1, v2, v3}, Lco/vine/android/VineWebSocketClient;->alertNewPrivateMessage(JJ)V

    .line 181
    .end local v0    # "conversationId":J
    .end local v2    # "messageId":J
    :cond_0
    return-void
.end method
