.class public Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
.super Ljava/lang/Object;
.source "UploadResultBroadcaster.java"


# static fields
.field private static final DEFAULT_QUEUE_NAME:Ljava/lang/String; = "Unspecified"


# instance fields
.field private mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;->mContext:Landroid/content/Context;

    .line 26
    return-void
.end method


# virtual methods
.method public broadcastResult(II)V
    .locals 1
    .param p1, "resultCode"    # I
    .param p2, "numBatchesSent"    # I

    .prologue
    .line 36
    const-string/jumbo v0, "Unspecified"

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;->broadcastResult(IILjava/lang/String;)V

    .line 37
    return-void
.end method

.method public broadcastResult(IILjava/lang/String;)V
    .locals 3
    .param p1, "resultCode"    # I
    .param p2, "numBatchesSent"    # I
    .param p3, "mQueueName"    # Ljava/lang/String;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;->mContext:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v2, "com.amazon.intent.action.METRICS_UPLOAD_RESULT"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string/jumbo v2, "NUM_BATCHES_SENT"

    invoke-virtual {v1, v2, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "RESULT_CODE"

    invoke-virtual {v1, v2, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "QUEUE_NAME"

    invoke-virtual {v1, v2, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 50
    return-void
.end method
