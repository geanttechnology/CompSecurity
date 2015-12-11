.class Lco/vine/android/service/GCMNotificationService$2;
.super Landroid/content/BroadcastReceiver;
.source "GCMNotificationService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/GCMNotificationService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/service/GCMNotificationService;


# direct methods
.method constructor <init>(Lco/vine/android/service/GCMNotificationService;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lco/vine/android/service/GCMNotificationService$2;->this$0:Lco/vine/android/service/GCMNotificationService;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 111
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$2;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mNotificationsToFire:Ljava/util/HashMap;
    invoke-static {v4}, Lco/vine/android/service/GCMNotificationService;->access$200(Lco/vine/android/service/GCMNotificationService;)Ljava/util/HashMap;

    move-result-object v5

    monitor-enter v5

    .line 112
    :try_start_0
    const-string v4, "Received camera request result: {}."

    invoke-static {v4, p2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 113
    const-string v4, "co.vine.android.camera.request.conversation.state.on"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 114
    const-string v4, "co.vine.android.camera.request.conversation.state.id"

    const-wide/16 v6, -0x1

    invoke-virtual {p2, v4, v6, v7}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v1

    .line 115
    .local v1, "conversationRowId":J
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$2;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mNotificationsToFire:Ljava/util/HashMap;
    invoke-static {v4}, Lco/vine/android/service/GCMNotificationService;->access$200(Lco/vine/android/service/GCMNotificationService;)Ljava/util/HashMap;

    move-result-object v4

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 116
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$2;->this$0:Lco/vine/android/service/GCMNotificationService;

    const-string v6, "notification_id"

    const/4 v7, 0x2

    invoke-virtual {p2, v6, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v6

    # invokes: Lco/vine/android/service/GCMNotificationService;->updateNotification(IJ)V
    invoke-static {v4, v6, v1, v2}, Lco/vine/android/service/GCMNotificationService;->access$300(Lco/vine/android/service/GCMNotificationService;IJ)V

    .line 118
    .end local v1    # "conversationRowId":J
    :cond_0
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$2;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mNotificationsToFire:Ljava/util/HashMap;
    invoke-static {v4}, Lco/vine/android/service/GCMNotificationService;->access$200(Lco/vine/android/service/GCMNotificationService;)Ljava/util/HashMap;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/service/GCMNotificationService$BuildableNotification;

    .line 119
    .local v0, "buildableNotification":Lco/vine/android/service/GCMNotificationService$BuildableNotification;
    invoke-virtual {v0}, Lco/vine/android/service/GCMNotificationService$BuildableNotification;->build()V

    goto :goto_0

    .line 122
    .end local v0    # "buildableNotification":Lco/vine/android/service/GCMNotificationService$BuildableNotification;
    .end local v3    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4

    .line 121
    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_1
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$2;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mNotificationsToFire:Ljava/util/HashMap;
    invoke-static {v4}, Lco/vine/android/service/GCMNotificationService;->access$200(Lco/vine/android/service/GCMNotificationService;)Ljava/util/HashMap;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/HashMap;->clear()V

    .line 122
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 123
    return-void
.end method
