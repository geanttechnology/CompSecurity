.class Lco/vine/android/service/RealTimeChatService$VineServiceHandler;
.super Landroid/os/Handler;
.source "RealTimeChatService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/RealTimeChatService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "VineServiceHandler"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/service/RealTimeChatService;


# direct methods
.method constructor <init>(Lco/vine/android/service/RealTimeChatService;)V
    .locals 0

    .prologue
    .line 263
    iput-object p1, p0, Lco/vine/android/service/RealTimeChatService$VineServiceHandler;->this$0:Lco/vine/android/service/RealTimeChatService;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 266
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/service/RealTimeChatService$VineServiceHandler;->this$0:Lco/vine/android/service/RealTimeChatService;

    invoke-virtual {v1}, Lco/vine/android/service/RealTimeChatService;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    .line 267
    iget-object v0, p0, Lco/vine/android/service/RealTimeChatService$VineServiceHandler;->this$0:Lco/vine/android/service/RealTimeChatService;

    # getter for: Lco/vine/android/service/RealTimeChatService;->mExecutor:Ljava/util/concurrent/ExecutorService;
    invoke-static {v0}, Lco/vine/android/service/RealTimeChatService;->access$1100(Lco/vine/android/service/RealTimeChatService;)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;

    iget-object v2, p0, Lco/vine/android/service/RealTimeChatService$VineServiceHandler;->this$0:Lco/vine/android/service/RealTimeChatService;

    iget v3, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v4

    iget-object v5, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    invoke-direct {v1, v2, v3, v4, v5}, Lco/vine/android/service/RealTimeChatService$ExecutionRunnable;-><init>(Lco/vine/android/service/RealTimeChatService;ILandroid/os/Bundle;Landroid/os/Messenger;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 268
    return-void
.end method
