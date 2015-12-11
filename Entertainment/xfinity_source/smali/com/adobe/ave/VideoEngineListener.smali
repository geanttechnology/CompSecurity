.class public Lcom/adobe/ave/VideoEngineListener;
.super Ljava/lang/Object;
.source "VideoEngineListener.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackgroundManifestError(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "error"    # Lcom/adobe/ave/MediaErrorCode;
    .param p3, "desc"    # Ljava/lang/String;

    .prologue
    .line 169
    return-void
.end method

.method public onBackgroundManifestWarning(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "error"    # Lcom/adobe/ave/MediaErrorCode;
    .param p3, "desc"    # Ljava/lang/String;

    .prologue
    .line 180
    return-void
.end method

.method public onDRMError(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/drm/DRMError;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "error"    # Lcom/adobe/ave/drm/DRMError;

    .prologue
    .line 158
    return-void
.end method

.method public onDRMMetadata(Lcom/adobe/ave/VideoEngine;[BIJ)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "data"    # [B
    .param p3, "length"    # I
    .param p4, "timestamp"    # J

    .prologue
    .line 77
    return-void
.end method

.method public onData(Lcom/adobe/ave/VideoEngine;JLcom/adobe/ave/DataType;[BI)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "timestamp"    # J
    .param p4, "dataType"    # Lcom/adobe/ave/DataType;
    .param p5, "data"    # [B
    .param p6, "length"    # I

    .prologue
    .line 106
    return-void
.end method

.method public onDictionaryData(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/Dictionary;J)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "dic"    # Lcom/adobe/ave/Dictionary;
    .param p3, "time"    # J

    .prologue
    .line 146
    return-void
.end method

.method public onError(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "error"    # Lcom/adobe/ave/MediaErrorCode;
    .param p3, "desc"    # Ljava/lang/String;

    .prologue
    .line 37
    return-void
.end method

.method public onLoadInfo(Lcom/adobe/ave/VideoEngine;Ljava/lang/String;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "desc"    # Ljava/lang/String;

    .prologue
    .line 85
    return-void
.end method

.method public onManifestLoad(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;IIJ)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "result"    # Lcom/adobe/ave/MediaErrorCode;
    .param p3, "userData"    # I
    .param p4, "handle"    # I
    .param p5, "duration"    # J

    .prologue
    .line 117
    return-void
.end method

.method public onPlayState(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/PlayState;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "state"    # Lcom/adobe/ave/PlayState;

    .prologue
    .line 45
    return-void
.end method

.method public onSeekComplete(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "result"    # Lcom/adobe/ave/MediaErrorCode;

    .prologue
    .line 125
    return-void
.end method

.method public onStreamMetadata(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/StreamMetadata;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "metadata"    # Lcom/adobe/ave/StreamMetadata;

    .prologue
    .line 66
    return-void
.end method

.method public onStreamSwitch(Lcom/adobe/ave/VideoEngine;JLcom/adobe/ave/SwitchInfo;II)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "time"    # J
    .param p4, "info"    # Lcom/adobe/ave/SwitchInfo;
    .param p5, "bitrate"    # I
    .param p6, "userData"    # I

    .prologue
    .line 56
    return-void
.end method

.method public onTimeline(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/UpdateType;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "updateType"    # Lcom/adobe/ave/UpdateType;

    .prologue
    .line 93
    return-void
.end method

.method public onTrickPlayEnded(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "result"    # Lcom/adobe/ave/MediaErrorCode;

    .prologue
    .line 156
    return-void
.end method

.method public onWarning(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 0
    .param p1, "ve"    # Lcom/adobe/ave/VideoEngine;
    .param p2, "error"    # Lcom/adobe/ave/MediaErrorCode;
    .param p3, "desc"    # Ljava/lang/String;

    .prologue
    .line 136
    return-void
.end method
