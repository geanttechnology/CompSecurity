.class Lco/vine/android/service/VineService$ExecutionRunnable;
.super Ljava/lang/Object;
.source "VineService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/VineService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ExecutionRunnable"
.end annotation


# instance fields
.field private final mActionCode:I

.field private final mBundle:Landroid/os/Bundle;

.field private final mMessenger:Landroid/os/Messenger;

.field private final mResponder:Lco/vine/android/service/VineServiceResponder;

.field private final mStartId:I

.field final synthetic this$0:Lco/vine/android/service/VineService;


# direct methods
.method public constructor <init>(Lco/vine/android/service/VineService;IILandroid/os/Bundle;Lco/vine/android/service/VineServiceResponder;Landroid/os/Messenger;)V
    .locals 0
    .param p2, "startId"    # I
    .param p3, "actionCode"    # I
    .param p4, "bundle"    # Landroid/os/Bundle;
    .param p5, "responder"    # Lco/vine/android/service/VineServiceResponder;
    .param p6, "messenger"    # Landroid/os/Messenger;

    .prologue
    .line 4058
    iput-object p1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->this$0:Lco/vine/android/service/VineService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4059
    iput p2, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mStartId:I

    .line 4060
    iput p3, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mActionCode:I

    .line 4061
    iput-object p4, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    .line 4062
    iput-object p5, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mResponder:Lco/vine/android/service/VineServiceResponder;

    .line 4063
    iput-object p6, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mMessenger:Landroid/os/Messenger;

    .line 4064
    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    const/4 v6, 0x1

    .line 4067
    const/16 v1, 0xa

    invoke-static {v1}, Landroid/os/Process;->setThreadPriority(I)V

    .line 4068
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->this$0:Lco/vine/android/service/VineService;

    iget v2, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mActionCode:I

    iget-object v3, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    invoke-virtual {v1, v2, v3}, Lco/vine/android/service/VineService;->executeAction(ILandroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v8

    .line 4069
    .local v8, "result":Landroid/os/Bundle;
    const-string v1, "executionCode"

    invoke-virtual {v8, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 4131
    :cond_0
    :goto_0
    const-string v1, "statusCode"

    invoke-virtual {v8, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v4

    .line 4132
    .local v4, "statusCode":I
    const-string v1, "reasonPhrase"

    invoke-virtual {v8, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 4135
    .local v5, "reasonPhrase":Ljava/lang/String;
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mResponder:Lco/vine/android/service/VineServiceResponder;

    if-eqz v1, :cond_2

    .line 4136
    new-instance v0, Lco/vine/android/service/VineService$ResponderRunnable;

    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->this$0:Lco/vine/android/service/VineService;

    iget-object v2, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mResponder:Lco/vine/android/service/VineServiceResponder;

    iget v3, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mActionCode:I

    iget-object v6, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    iget v7, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mStartId:I

    invoke-direct/range {v0 .. v7}, Lco/vine/android/service/VineService$ResponderRunnable;-><init>(Lco/vine/android/service/VineService;Lco/vine/android/service/VineServiceResponder;IILjava/lang/String;Landroid/os/Bundle;I)V

    .line 4145
    .local v0, "responderRunnable":Ljava/lang/Runnable;
    :goto_1
    if-eqz v0, :cond_1

    .line 4146
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->this$0:Lco/vine/android/service/VineService;

    # getter for: Lco/vine/android/service/VineService;->mMainHandler:Landroid/os/Handler;
    invoke-static {v1}, Lco/vine/android/service/VineService;->access$200(Lco/vine/android/service/VineService;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 4148
    :cond_1
    return-void

    .line 4071
    .end local v0    # "responderRunnable":Ljava/lang/Runnable;
    .end local v4    # "statusCode":I
    .end local v5    # "reasonPhrase":Ljava/lang/String;
    :pswitch_0
    const-string v1, "Session key was invalid. Refreshing session key and then will try again"

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 4073
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->this$0:Lco/vine/android/service/VineService;

    const/16 v2, 0x3e8

    iget-object v3, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    invoke-virtual {v1, v2, v3}, Lco/vine/android/service/VineService;->executeAction(ILandroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v8

    .line 4074
    const-string v1, "executionCode"

    invoke-virtual {v8, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    packed-switch v1, :pswitch_data_1

    .line 4087
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Session key successfully refreshed. Trying original action of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mActionCode:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " again"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 4089
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->this$0:Lco/vine/android/service/VineService;

    iget v2, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mActionCode:I

    iget-object v3, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    invoke-virtual {v1, v2, v3}, Lco/vine/android/service/VineService;->executeAction(ILandroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v8

    .line 4090
    const-string v1, "executionCode"

    invoke-virtual {v8, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    packed-switch v1, :pswitch_data_2

    .line 4103
    # getter for: Lco/vine/android/service/VineService;->LOGGABLE:Z
    invoke-static {}, Lco/vine/android/service/VineService;->access$100()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 4104
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    const-string v2, "refresh_session"

    invoke-virtual {v1, v2, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 4105
    const-string v1, "Session key refresh and retry complete."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 4076
    :pswitch_1
    const-string v1, "Session key could not be refreshed. Aborting."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 4077
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    const-string v2, "logged_out"

    invoke-virtual {v1, v2, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 4081
    :pswitch_2
    const-string v1, "Session was logged out."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 4082
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    const-string v2, "logged_out"

    invoke-virtual {v1, v2, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 4092
    :pswitch_3
    const-string v1, "Session key is still invalid. Aborting."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 4093
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    const-string v2, "logged_out"

    invoke-virtual {v1, v2, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 4097
    :pswitch_4
    const-string v1, "Session was logged out."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 4098
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    const-string v2, "logged_out"

    invoke-virtual {v1, v2, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 4116
    :pswitch_5
    const-string v1, "Captcha triggered"

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 4117
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    const-string v2, "captcha_url"

    const-string v3, "captcha_url"

    invoke-virtual {v8, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 4121
    :pswitch_6
    const-string v1, "Session was logged out."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 4122
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    const-string v2, "logged_out"

    invoke-virtual {v1, v2, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto/16 :goto_0

    .line 4138
    .restart local v4    # "statusCode":I
    .restart local v5    # "reasonPhrase":Ljava/lang/String;
    :cond_2
    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mMessenger:Landroid/os/Messenger;

    if-eqz v1, :cond_3

    .line 4139
    new-instance v0, Lco/vine/android/service/VineService$MessengerResponderRunnable;

    iget-object v1, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->this$0:Lco/vine/android/service/VineService;

    iget-object v2, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mMessenger:Landroid/os/Messenger;

    iget v3, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mActionCode:I

    iget-object v6, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    iget v7, p0, Lco/vine/android/service/VineService$ExecutionRunnable;->mStartId:I

    invoke-direct/range {v0 .. v7}, Lco/vine/android/service/VineService$MessengerResponderRunnable;-><init>(Lco/vine/android/service/VineService;Landroid/os/Messenger;IILjava/lang/String;Landroid/os/Bundle;I)V

    .restart local v0    # "responderRunnable":Ljava/lang/Runnable;
    goto/16 :goto_1

    .line 4142
    .end local v0    # "responderRunnable":Ljava/lang/Runnable;
    :cond_3
    const/4 v0, 0x0

    .restart local v0    # "responderRunnable":Ljava/lang/Runnable;
    goto/16 :goto_1

    .line 4069
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_6
        :pswitch_5
    .end packed-switch

    .line 4074
    :pswitch_data_1
    .packed-switch 0x2
        :pswitch_1
        :pswitch_2
    .end packed-switch

    .line 4090
    :pswitch_data_2
    .packed-switch 0x2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method
