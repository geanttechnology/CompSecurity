.class Lcom/adobe/mediacore/qos/QOSProvider$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/qos/QOSProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/qos/QOSProvider;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/qos/QOSProvider;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/qos/QOSProvider$1;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBufferComplete()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$1;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_bufferingMetrics:Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$000(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->recordBufferFull()V

    return-void
.end method

.method public onBufferStart()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$1;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_bufferingMetrics:Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$000(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/BufferingMetrics;->recordBufferEmpty()V

    return-void
.end method

.method public onLoadInfo(Lcom/adobe/mediacore/qos/LoadInfo;)V
    .locals 0

    return-void
.end method

.method public onOperationFailed(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V
    .locals 3

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SEEK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    if-ne v0, v1, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$1;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_seekMetrics:Lcom/adobe/mediacore/qos/metrics/SeekMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$100(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/SeekMetrics;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;->FAIL:Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->recordSeekComplete(Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;)V

    goto :goto_0

    :cond_2
    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->getInnerNotification()Lcom/adobe/mediacore/MediaPlayerNotification;

    move-result-object v0

    :goto_1
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerNotification;->getCode()Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SEEK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    if-ne v1, v2, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$1;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_seekMetrics:Lcom/adobe/mediacore/qos/metrics/SeekMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$100(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/SeekMetrics;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;->FAIL:Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->recordSeekComplete(Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;)V

    goto :goto_0

    :cond_3
    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerNotification;->getInnerNotification()Lcom/adobe/mediacore/MediaPlayerNotification;

    move-result-object v0

    goto :goto_1
.end method

.method public onSeekComplete(J)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$1;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_seekMetrics:Lcom/adobe/mediacore/qos/metrics/SeekMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$100(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/SeekMetrics;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;->SUCCESS:Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->recordSeekComplete(Lcom/adobe/mediacore/qos/metrics/SeekMetrics$Result;)V

    return-void
.end method

.method public onSeekStart()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/qos/QOSProvider$1;->this$0:Lcom/adobe/mediacore/qos/QOSProvider;

    # getter for: Lcom/adobe/mediacore/qos/QOSProvider;->_seekMetrics:Lcom/adobe/mediacore/qos/metrics/SeekMetrics;
    invoke-static {v0}, Lcom/adobe/mediacore/qos/QOSProvider;->access$100(Lcom/adobe/mediacore/qos/QOSProvider;)Lcom/adobe/mediacore/qos/metrics/SeekMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/SeekMetrics;->recordSeekStart()V

    return-void
.end method
