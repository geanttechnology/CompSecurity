.class Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;
.super Ljava/lang/Object;
.source "VideoAdView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnErrorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/media/MediaPlayer;II)Z
    .locals 7
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "framework_err"    # I
    .param p3, "impl_err"    # I

    .prologue
    const/4 v6, 0x1

    const/4 v5, -0x1

    .line 118
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->access$000(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "onError: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 119
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    # setter for: Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mCurrentState:I
    invoke-static {v2, v5}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->access$102(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;I)I

    .line 120
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    # setter for: Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mTargetState:I
    invoke-static {v2, v5}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->access$202(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;I)I

    .line 122
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;
    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->access$300(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)Landroid/widget/MediaController;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 123
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->mediaController:Landroid/widget/MediaController;
    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->access$300(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)Landroid/widget/MediaController;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/MediaController;->hide()V

    .line 125
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 127
    .local v0, "info":Landroid/os/Bundle;
    const/16 v2, 0xc8

    if-ne p2, v2, :cond_1

    .line 128
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    iget-object v2, v2, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    iget-object v3, v3, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_UNKNOWN()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const-string v1, "The video is streamed and its container is not valid for progressive playback i.e the video\'s index (e.g moov atom) is not at the start of the file."

    .line 143
    .local v1, "msg":Ljava/lang/String;
    :goto_0
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    iget-object v2, v2, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_INFO()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;
    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->access$400(Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;)Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    move-result-object v2

    invoke-virtual {v2, v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onAdVideoViewError(Landroid/os/Bundle;)V

    .line 146
    return v6

    .line 131
    .end local v1    # "msg":Ljava/lang/String;
    :cond_1
    if-ne p2, v6, :cond_2

    .line 133
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    iget-object v2, v2, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    iget-object v3, v3, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_UNKNOWN()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    const-string v1, "media file format is not recognized."

    .restart local v1    # "msg":Ljava/lang/String;
    goto :goto_0

    .line 135
    .end local v1    # "msg":Ljava/lang/String;
    :cond_2
    const/16 v2, 0x64

    if-ne p2, v2, :cond_3

    .line 136
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    iget-object v2, v2, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    iget-object v3, v3, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_IO()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    const-string v1, "media server has gone away."

    .restart local v1    # "msg":Ljava/lang/String;
    goto :goto_0

    .line 139
    .end local v1    # "msg":Ljava/lang/String;
    :cond_3
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    iget-object v2, v2, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->INFO_KEY_ERROR_CODE()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    iget-object v3, v3, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->ERROR_IO()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    const-string v1, "unknown common IO error."

    .restart local v1    # "msg":Ljava/lang/String;
    goto :goto_0
.end method
