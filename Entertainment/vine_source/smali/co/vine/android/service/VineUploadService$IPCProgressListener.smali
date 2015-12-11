.class public Lco/vine/android/service/VineUploadService$IPCProgressListener;
.super Lco/vine/android/service/UploadProgressListener;
.source "VineUploadService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/VineUploadService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "IPCProgressListener"
.end annotation


# static fields
.field public static final PROGRESS_RATIO_TRANSCODE:D = 0.65

.field public static final PROGRESS_RATIO_UPLOAD:D = 0.33


# instance fields
.field final synthetic this$0:Lco/vine/android/service/VineUploadService;


# direct methods
.method public constructor <init>(Lco/vine/android/service/VineUploadService;Ljava/lang/String;)V
    .locals 0
    .param p2, "path"    # Ljava/lang/String;

    .prologue
    .line 805
    iput-object p1, p0, Lco/vine/android/service/VineUploadService$IPCProgressListener;->this$0:Lco/vine/android/service/VineUploadService;

    .line 806
    invoke-direct {p0, p2}, Lco/vine/android/service/UploadProgressListener;-><init>(Ljava/lang/String;)V

    .line 807
    return-void
.end method

.method private sendMessageToActivity(Landroid/os/Message;)V
    .locals 1
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 853
    :try_start_0
    # getter for: Lco/vine/android/service/VineUploadService;->sUploadResultReceiver:Landroid/os/Messenger;
    invoke-static {}, Lco/vine/android/service/VineUploadService;->access$100()Landroid/os/Messenger;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 857
    :goto_0
    return-void

    .line 854
    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method public onPostFinished(Z)V
    .locals 5
    .param p1, "success"    # Z

    .prologue
    const/4 v4, 0x0

    .line 818
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 819
    .local v0, "data":Landroid/os/Bundle;
    # getter for: Lco/vine/android/service/VineUploadService;->sUploadResultReceiver:Landroid/os/Messenger;
    invoke-static {}, Lco/vine/android/service/VineUploadService;->access$100()Landroid/os/Messenger;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 820
    const-string v1, "success"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 821
    const/4 v1, 0x7

    invoke-static {v4, v1, v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-direct {p0, v1}, Lco/vine/android/service/VineUploadService$IPCProgressListener;->sendMessageToActivity(Landroid/os/Message;)V

    .line 822
    if-nez p1, :cond_0

    .line 823
    const-string v1, "upload_progress"

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 824
    const/4 v1, 0x6

    invoke-static {v4, v1, v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-direct {p0, v1}, Lco/vine/android/service/VineUploadService$IPCProgressListener;->sendMessageToActivity(Landroid/os/Message;)V

    .line 827
    :cond_0
    return-void
.end method

.method public onTranscodeStarted()V
    .locals 2

    .prologue
    .line 811
    # getter for: Lco/vine/android/service/VineUploadService;->sUploadResultReceiver:Landroid/os/Messenger;
    invoke-static {}, Lco/vine/android/service/VineUploadService;->access$100()Landroid/os/Messenger;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 812
    const/4 v0, 0x0

    const/4 v1, 0x4

    invoke-static {v0, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    invoke-direct {p0, v0}, Lco/vine/android/service/VineUploadService$IPCProgressListener;->sendMessageToActivity(Landroid/os/Message;)V

    .line 814
    :cond_0
    return-void
.end method

.method public progressChanged(Lco/vine/android/util/VineProgressEvent;)V
    .locals 6
    .param p1, "progressEvent"    # Lco/vine/android/util/VineProgressEvent;

    .prologue
    .line 841
    iget-wide v2, p0, Lco/vine/android/service/VineUploadService$IPCProgressListener;->currentSize:J

    invoke-virtual {p1}, Lco/vine/android/util/VineProgressEvent;->getBytesTransfered()I

    move-result v4

    int-to-long v4, v4

    add-long/2addr v2, v4

    iput-wide v2, p0, Lco/vine/android/service/VineUploadService$IPCProgressListener;->currentSize:J

    .line 842
    iget-wide v2, p0, Lco/vine/android/service/VineUploadService$IPCProgressListener;->currentSize:J

    const-wide/16 v4, 0x64

    mul-long/2addr v2, v4

    iget-wide v4, p0, Lco/vine/android/service/VineUploadService$IPCProgressListener;->size:J

    div-long/2addr v2, v4

    long-to-int v1, v2

    .line 843
    .local v1, "p":I
    # getter for: Lco/vine/android/service/VineUploadService;->sUploadResultReceiver:Landroid/os/Messenger;
    invoke-static {}, Lco/vine/android/service/VineUploadService;->access$100()Landroid/os/Messenger;

    move-result-object v2

    if-eqz v2, :cond_0

    iget v2, p0, Lco/vine/android/service/VineUploadService$IPCProgressListener;->lastProgress:I

    sub-int/2addr v2, v1

    invoke-static {v2}, Ljava/lang/Math;->abs(I)I

    move-result v2

    const/4 v3, 0x2

    if-le v2, v3, :cond_0

    .line 844
    iput v1, p0, Lco/vine/android/service/VineUploadService$IPCProgressListener;->lastProgress:I

    .line 845
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 846
    .local v0, "data":Landroid/os/Bundle;
    const-string v2, "upload_progress"

    int-to-double v3, v1

    invoke-virtual {v0, v2, v3, v4}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 847
    const/4 v2, 0x0

    const/4 v3, 0x6

    invoke-static {v2, v3, v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    invoke-direct {p0, v2}, Lco/vine/android/service/VineUploadService$IPCProgressListener;->sendMessageToActivity(Landroid/os/Message;)V

    .line 849
    .end local v0    # "data":Landroid/os/Bundle;
    :cond_0
    return-void
.end method

.method public updateTranscodeProgress(I)V
    .locals 4
    .param p1, "p"    # I

    .prologue
    .line 831
    # getter for: Lco/vine/android/service/VineUploadService;->sUploadResultReceiver:Landroid/os/Messenger;
    invoke-static {}, Lco/vine/android/service/VineUploadService;->access$100()Landroid/os/Messenger;

    move-result-object v1

    if-eqz v1, :cond_0

    iget v1, p0, Lco/vine/android/service/VineUploadService$IPCProgressListener;->lastProgress:I

    sub-int/2addr v1, p1

    invoke-static {v1}, Ljava/lang/Math;->abs(I)I

    move-result v1

    const/4 v2, 0x2

    if-le v1, v2, :cond_0

    .line 832
    iput p1, p0, Lco/vine/android/service/VineUploadService$IPCProgressListener;->lastProgress:I

    .line 833
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 834
    .local v0, "data":Landroid/os/Bundle;
    const-string v1, "transcode_progress"

    int-to-double v2, p1

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 835
    const/4 v1, 0x0

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-direct {p0, v1}, Lco/vine/android/service/VineUploadService$IPCProgressListener;->sendMessageToActivity(Landroid/os/Message;)V

    .line 837
    .end local v0    # "data":Landroid/os/Bundle;
    :cond_0
    return-void
.end method
