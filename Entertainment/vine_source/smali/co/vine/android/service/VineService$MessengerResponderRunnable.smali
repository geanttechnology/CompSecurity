.class Lco/vine/android/service/VineService$MessengerResponderRunnable;
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
    name = "MessengerResponderRunnable"
.end annotation


# instance fields
.field private final mActionCode:I

.field private final mBundle:Landroid/os/Bundle;

.field private final mReasonPhrase:Ljava/lang/String;

.field private final mResponder:Landroid/os/Messenger;

.field private final mStartId:I

.field private final mStatusCode:I

.field final synthetic this$0:Lco/vine/android/service/VineService;


# direct methods
.method public constructor <init>(Lco/vine/android/service/VineService;Landroid/os/Messenger;IILjava/lang/String;Landroid/os/Bundle;I)V
    .locals 0
    .param p2, "responder"    # Landroid/os/Messenger;
    .param p3, "actionCode"    # I
    .param p4, "statusCode"    # I
    .param p5, "reasonPhrase"    # Ljava/lang/String;
    .param p6, "bundle"    # Landroid/os/Bundle;
    .param p7, "startId"    # I

    .prologue
    .line 4020
    iput-object p1, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->this$0:Lco/vine/android/service/VineService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4021
    iput-object p2, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mResponder:Landroid/os/Messenger;

    .line 4022
    iput p3, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mActionCode:I

    .line 4023
    iput p4, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mStatusCode:I

    .line 4024
    iput-object p5, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mReasonPhrase:Ljava/lang/String;

    .line 4025
    iput-object p6, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mBundle:Landroid/os/Bundle;

    .line 4026
    iput p7, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mStartId:I

    .line 4027
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 4030
    iget-object v3, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mResponder:Landroid/os/Messenger;

    if-eqz v3, :cond_0

    .line 4031
    new-instance v2, Landroid/os/Message;

    invoke-direct {v2}, Landroid/os/Message;-><init>()V

    .line 4032
    .local v2, "msg":Landroid/os/Message;
    iget v3, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mActionCode:I

    iput v3, v2, Landroid/os/Message;->what:I

    .line 4033
    iget v3, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mStatusCode:I

    iput v3, v2, Landroid/os/Message;->arg1:I

    .line 4034
    invoke-virtual {v2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    .line 4035
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "reason_phrase"

    iget-object v4, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mReasonPhrase:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 4036
    iget-object v3, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mBundle:Landroid/os/Bundle;

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 4038
    :try_start_0
    iget-object v3, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mResponder:Landroid/os/Messenger;

    invoke-virtual {v3, v2}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4043
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v2    # "msg":Landroid/os/Message;
    :cond_0
    :goto_0
    iget v3, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mStartId:I

    if-lez v3, :cond_1

    .line 4044
    iget-object v3, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->this$0:Lco/vine/android/service/VineService;

    iget v4, p0, Lco/vine/android/service/VineService$MessengerResponderRunnable;->mStartId:I

    invoke-virtual {v3, v4}, Lco/vine/android/service/VineService;->attemptStop(I)V

    .line 4046
    :cond_1
    return-void

    .line 4039
    .restart local v0    # "b":Landroid/os/Bundle;
    .restart local v2    # "msg":Landroid/os/Message;
    :catch_0
    move-exception v1

    .line 4040
    .local v1, "e":Ljava/lang/Exception;
    const-string v3, "Error sending service response"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v1, v3, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method
