.class Lco/vine/android/service/VineUploadService$NotificationProgressListener;
.super Lco/vine/android/service/UploadProgressListener;
.source "VineUploadService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/VineUploadService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "NotificationProgressListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/service/VineUploadService;


# direct methods
.method public constructor <init>(Lco/vine/android/service/VineUploadService;Ljava/lang/String;)V
    .locals 0
    .param p2, "path"    # Ljava/lang/String;

    .prologue
    .line 729
    iput-object p1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->this$0:Lco/vine/android/service/VineUploadService;

    .line 730
    invoke-direct {p0, p2}, Lco/vine/android/service/UploadProgressListener;-><init>(Ljava/lang/String;)V

    .line 731
    return-void
.end method

.method private updateNotification(Ljava/lang/String;IIZ)V
    .locals 6
    .param p1, "thumbnail"    # Ljava/lang/String;
    .param p2, "title"    # I
    .param p3, "text"    # I
    .param p4, "showProgress"    # Z

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 778
    const-string v1, "Update notification: {}, {}."

    invoke-static {p4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iget v3, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->lastProgress:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 779
    new-instance v0, Landroid/support/v4/app/NotificationCompat$Builder;

    iget-object v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->this$0:Lco/vine/android/service/VineUploadService;

    invoke-direct {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    .line 780
    .local v0, "nb":Landroid/support/v4/app/NotificationCompat$Builder;
    iget-object v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->this$0:Lco/vine/android/service/VineUploadService;

    # invokes: Lco/vine/android/service/VineUploadService;->setScaledNotificationIcon(Ljava/lang/String;)Landroid/graphics/Bitmap;
    invoke-static {v1, p1}, Lco/vine/android/service/VineUploadService;->access$600(Lco/vine/android/service/VineUploadService;Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 781
    const v1, 0x7f0201ff

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 782
    iget-object v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->this$0:Lco/vine/android/service/VineUploadService;

    invoke-virtual {v1, p2}, Lco/vine/android/service/VineUploadService;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 783
    iget-object v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->this$0:Lco/vine/android/service/VineUploadService;

    invoke-virtual {v1, p3}, Lco/vine/android/service/VineUploadService;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 784
    const-wide/16 v1, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setWhen(J)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 785
    invoke-virtual {v0, v5}, Landroid/support/v4/app/NotificationCompat$Builder;->setOngoing(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 786
    if-eqz p4, :cond_1

    .line 787
    iget v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->lastProgress:I

    if-lez v1, :cond_0

    .line 788
    const/16 v1, 0x64

    iget v2, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->lastProgress:I

    invoke-virtual {v0, v1, v2, v4}, Landroid/support/v4/app/NotificationCompat$Builder;->setProgress(IIZ)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 795
    :goto_0
    iget-object v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->this$0:Lco/vine/android/service/VineUploadService;

    # invokes: Lco/vine/android/service/VineUploadService;->showNotification(Landroid/support/v4/app/NotificationCompat$Builder;I)V
    invoke-static {v1, v0, v5}, Lco/vine/android/service/VineUploadService;->access$700(Lco/vine/android/service/VineUploadService;Landroid/support/v4/app/NotificationCompat$Builder;I)V

    .line 796
    return-void

    .line 790
    :cond_0
    invoke-virtual {v0, v4, v4, v5}, Landroid/support/v4/app/NotificationCompat$Builder;->setProgress(IIZ)Landroid/support/v4/app/NotificationCompat$Builder;

    goto :goto_0

    .line 793
    :cond_1
    invoke-virtual {v0, v4, v4, v5}, Landroid/support/v4/app/NotificationCompat$Builder;->setProgress(IIZ)Landroid/support/v4/app/NotificationCompat$Builder;

    goto :goto_0
.end method

.method private updateTranscodeNotification(Ljava/lang/String;)V
    .locals 3
    .param p1, "thumbnail"    # Ljava/lang/String;

    .prologue
    .line 773
    const v0, 0x7f0e0184

    const v1, 0x7f0e0185

    const/4 v2, 0x1

    invoke-direct {p0, p1, v0, v1, v2}, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->updateNotification(Ljava/lang/String;IIZ)V

    .line 774
    return-void
.end method

.method private updateUploadNotification(Ljava/lang/String;)V
    .locals 3
    .param p1, "thumbnail"    # Ljava/lang/String;

    .prologue
    .line 769
    const v0, 0x7f0e0261

    const v1, 0x7f0e0262

    const/4 v2, 0x1

    invoke-direct {p0, p1, v0, v1, v2}, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->updateNotification(Ljava/lang/String;IIZ)V

    .line 770
    return-void
.end method


# virtual methods
.method public onPostFinished(Z)V
    .locals 2
    .param p1, "success"    # Z

    .prologue
    .line 739
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->this$0:Lco/vine/android/service/VineUploadService;

    const/4 v1, 0x1

    # invokes: Lco/vine/android/service/VineUploadService;->clearNotification(I)V
    invoke-static {v0, v1}, Lco/vine/android/service/VineUploadService;->access$400(Lco/vine/android/service/VineUploadService;I)V

    .line 740
    if-eqz p1, :cond_0

    .line 741
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->this$0:Lco/vine/android/service/VineUploadService;

    # invokes: Lco/vine/android/service/VineUploadService;->cancelFailedNofitication()V
    invoke-static {v0}, Lco/vine/android/service/VineUploadService;->access$500(Lco/vine/android/service/VineUploadService;)V

    .line 743
    :cond_0
    return-void
.end method

.method public onTranscodeStarted()V
    .locals 0

    .prologue
    .line 735
    return-void
.end method

.method public progressChanged(Lco/vine/android/util/VineProgressEvent;)V
    .locals 5
    .param p1, "progressEvent"    # Lco/vine/android/util/VineProgressEvent;

    .prologue
    .line 747
    iget-wide v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->currentSize:J

    invoke-virtual {p1}, Lco/vine/android/util/VineProgressEvent;->getBytesTransfered()I

    move-result v3

    int-to-long v3, v3

    add-long/2addr v1, v3

    iput-wide v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->currentSize:J

    .line 748
    iget-wide v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->currentSize:J

    const-wide/16 v3, 0x64

    mul-long/2addr v1, v3

    iget-wide v3, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->size:J

    div-long/2addr v1, v3

    long-to-int v0, v1

    .line 749
    .local v0, "p":I
    iget v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->lastProgress:I

    sub-int/2addr v1, v0

    invoke-static {v1}, Ljava/lang/Math;->abs(I)I

    move-result v1

    const/4 v2, 0x2

    if-le v1, v2, :cond_0

    .line 750
    iput v0, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->lastProgress:I

    .line 751
    iget-object v1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->thumbnail:Ljava/lang/String;

    invoke-direct {p0, v1}, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->updateUploadNotification(Ljava/lang/String;)V

    .line 753
    :cond_0
    return-void
.end method

.method public showPostNotification(Ljava/lang/String;)V
    .locals 3
    .param p1, "thumbnail"    # Ljava/lang/String;

    .prologue
    .line 765
    const v0, 0x7f0e0183

    const v1, 0x7f0e0049

    const/4 v2, 0x1

    invoke-direct {p0, p1, v0, v1, v2}, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->updateNotification(Ljava/lang/String;IIZ)V

    .line 766
    return-void
.end method

.method public updateTranscodeProgress(I)V
    .locals 2
    .param p1, "p"    # I

    .prologue
    .line 757
    iget v0, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->lastProgress:I

    sub-int/2addr v0, p1

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v0

    const/4 v1, 0x2

    if-le v0, v1, :cond_0

    .line 758
    iput p1, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->lastProgress:I

    .line 759
    iget-object v0, p0, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->thumbnail:Ljava/lang/String;

    invoke-direct {p0, v0}, Lco/vine/android/service/VineUploadService$NotificationProgressListener;->updateTranscodeNotification(Ljava/lang/String;)V

    .line 761
    :cond_0
    return-void
.end method
