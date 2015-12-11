.class Lco/vine/android/service/VineUploadService$IncomingHandler;
.super Landroid/os/Handler;
.source "VineUploadService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/VineUploadService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "IncomingHandler"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/service/VineUploadService;


# direct methods
.method private constructor <init>(Lco/vine/android/service/VineUploadService;)V
    .locals 0

    .prologue
    .line 328
    iput-object p1, p0, Lco/vine/android/service/VineUploadService$IncomingHandler;->this$0:Lco/vine/android/service/VineUploadService;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/service/VineUploadService;Lco/vine/android/service/VineUploadService$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/service/VineUploadService;
    .param p2, "x1"    # Lco/vine/android/service/VineUploadService$1;

    .prologue
    .line 328
    invoke-direct {p0, p1}, Lco/vine/android/service/VineUploadService$IncomingHandler;-><init>(Lco/vine/android/service/VineUploadService;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 10
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v9, 0x0

    .line 331
    const-string v6, "VineUploadService"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Message received, what="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p1, Landroid/os/Message;->what:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", replyTo="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 332
    iget v5, p1, Landroid/os/Message;->what:I

    .line 333
    .local v5, "what":I
    packed-switch v5, :pswitch_data_0

    .line 360
    :cond_0
    :goto_0
    return-void

    .line 335
    :pswitch_0
    iget-object v4, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    .line 336
    .local v4, "replyTo":Landroid/os/Messenger;
    if-eqz v4, :cond_0

    .line 337
    # setter for: Lco/vine/android/service/VineUploadService;->sUploadResultReceiver:Landroid/os/Messenger;
    invoke-static {v4}, Lco/vine/android/service/VineUploadService;->access$102(Landroid/os/Messenger;)Landroid/os/Messenger;

    .line 338
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 339
    .local v1, "data":Landroid/os/Bundle;
    iget-object v6, p0, Lco/vine/android/service/VineUploadService$IncomingHandler;->this$0:Lco/vine/android/service/VineUploadService;

    # getter for: Lco/vine/android/service/VineUploadService;->mCurrentTask:Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    invoke-static {v6}, Lco/vine/android/service/VineUploadService;->access$200(Lco/vine/android/service/VineUploadService;)Lco/vine/android/service/VineUploadService$ServiceAsyncTask;

    move-result-object v0

    .line 340
    .local v0, "currentTask":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    if-eqz v0, :cond_1

    .line 341
    const-string v6, "conversation_row_id"

    iget-wide v7, v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->conversationRowId:J

    invoke-virtual {v1, v6, v7, v8}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 342
    const-string v6, "thumbnail"

    iget-object v7, v0, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->thumbnail:Ljava/lang/String;

    invoke-virtual {v1, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 343
    sget-object v6, Landroid/os/AsyncTask$Status;->FINISHED:Landroid/os/AsyncTask$Status;

    invoke-virtual {v0}, Lco/vine/android/service/VineUploadService$ServiceAsyncTask;->getStatus()Landroid/os/AsyncTask$Status;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/os/AsyncTask$Status;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    const/4 v3, 0x1

    .line 344
    .local v3, "isActive":Z
    :goto_1
    const-string v6, "is_active"

    invoke-virtual {v1, v6, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 347
    .end local v3    # "isActive":Z
    :cond_1
    const/4 v6, 0x0

    const/4 v7, 0x3

    :try_start_0
    invoke-static {v6, v7, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 349
    :catch_0
    move-exception v2

    .line 350
    .local v2, "e":Landroid/os/RemoteException;
    const-string v6, "Failed to reply."

    invoke-static {v6, v2}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 343
    .end local v2    # "e":Landroid/os/RemoteException;
    :cond_2
    const/4 v3, 0x0

    goto :goto_1

    .line 356
    .end local v0    # "currentTask":Lco/vine/android/service/VineUploadService$ServiceAsyncTask;
    .end local v1    # "data":Landroid/os/Bundle;
    .end local v4    # "replyTo":Landroid/os/Messenger;
    :pswitch_1
    # setter for: Lco/vine/android/service/VineUploadService;->sUploadResultReceiver:Landroid/os/Messenger;
    invoke-static {v9}, Lco/vine/android/service/VineUploadService;->access$102(Landroid/os/Messenger;)Landroid/os/Messenger;

    goto :goto_0

    .line 333
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
