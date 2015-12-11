.class public Lco/vine/android/service/ResourceService$CameraServiceBinder;
.super Landroid/os/Handler;
.source "ResourceService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/ResourceService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "CameraServiceBinder"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/service/ResourceService;


# direct methods
.method public constructor <init>(Lco/vine/android/service/ResourceService;)V
    .locals 0

    .prologue
    .line 208
    iput-object p1, p0, Lco/vine/android/service/ResourceService$CameraServiceBinder;->this$0:Lco/vine/android/service/ResourceService;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 212
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 219
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid request: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p1, Landroid/os/Message;->what:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 221
    :goto_0
    return-void

    .line 214
    :pswitch_0
    new-instance v0, Landroid/content/Intent;

    sget-boolean v1, Lco/vine/android/service/ResourceService;->isConversationActive:Z

    if-eqz v1, :cond_0

    const-string v1, "co.vine.android.camera.request.conversation.state.on"

    :goto_1
    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 215
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "co.vine.android.camera.request.conversation.state.id"

    sget-wide v2, Lco/vine/android/service/ResourceService;->lastActiveconversationRowId:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 216
    iget-object v1, p0, Lco/vine/android/service/ResourceService$CameraServiceBinder;->this$0:Lco/vine/android/service/ResourceService;

    const-string v2, "co.vine.android.BROADCAST"

    invoke-virtual {v1, v0, v2}, Lco/vine/android/service/ResourceService;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto :goto_0

    .line 214
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    const-string v1, "co.vine.android.camera.request.conversation.state.off"

    goto :goto_1

    .line 212
    nop

    :pswitch_data_0
    .packed-switch 0x65
        :pswitch_0
    .end packed-switch
.end method
