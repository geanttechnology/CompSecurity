.class Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;
.super Ljava/lang/Object;
.source "RealTimeChatService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/RealTimeChatService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ExecutionRunnable"
.end annotation


# instance fields
.field private final mActionCode:I

.field private final mBundle:Landroid/os/Bundle;

.field private final mResponder:Landroid/os/Messenger;

.field final synthetic this$0:Lco/vine/android/service/RealTimeChatService;


# direct methods
.method public constructor <init>(Lco/vine/android/service/RealTimeChatService;ILandroid/os/Bundle;Landroid/os/Messenger;)V
    .locals 0
    .param p2, "actionCode"    # I
    .param p3, "bundle"    # Landroid/os/Bundle;
    .param p4, "messenger"    # Landroid/os/Messenger;

    .prologue
    .line 276
    iput-object p1, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->this$0:Lco/vine/android/service/RealTimeChatService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 277
    iput p2, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->mActionCode:I

    .line 278
    iput-object p3, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    .line 279
    iput-object p4, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->mResponder:Landroid/os/Messenger;

    .line 280
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 283
    const/16 v2, 0xa

    invoke-static {v2}, Landroid/os/Process;->setThreadPriority(I)V

    .line 284
    iget-object v2, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->this$0:Lco/vine/android/service/RealTimeChatService;

    iget v3, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->mActionCode:I

    iget-object v4, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    # invokes: Lco/vine/android/service/RealTimeChatService;->executeAction(ILandroid/os/Bundle;)V
    invoke-static {v2, v3, v4}, Lco/vine/android/service/RealTimeChatService;->access$1200(Lco/vine/android/service/RealTimeChatService;ILandroid/os/Bundle;)V

    .line 287
    iget-object v2, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    const-string v3, "respond"

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 288
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v1

    .line 289
    .local v1, "msg":Landroid/os/Message;
    iget v2, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->mActionCode:I

    iput v2, v1, Landroid/os/Message;->what:I

    .line 290
    iget-object v2, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->mBundle:Landroid/os/Bundle;

    invoke-virtual {v1, v2}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 292
    :try_start_0
    iget-object v2, p0, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;->mResponder:Landroid/os/Messenger;

    invoke-virtual {v2, v1}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 297
    .end local v1    # "msg":Landroid/os/Message;
    :cond_0
    :goto_0
    return-void

    .line 293
    .restart local v1    # "msg":Landroid/os/Message;
    :catch_0
    move-exception v0

    .line 294
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Error sending service response"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v2, v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method
