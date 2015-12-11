.class Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;
.super Ljava/lang/Object;
.source "PrimeTimePlayer.java"

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V
    .locals 0

    .prologue
    .line 1062
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDRMMetadata(Lcom/adobe/mediacore/DRMMetadataInfo;)V
    .locals 3
    .param p1, "info"    # Lcom/adobe/mediacore/DRMMetadataInfo;

    .prologue
    .line 1066
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1067
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$1000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->player:Lcom/adobe/mediacore/MediaPlayer;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$000(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/adobe/mediacore/MediaPlayer;

    move-result-object v1

    invoke-interface {v1}, Lcom/adobe/mediacore/MediaPlayer;->getDRMManager()Lcom/adobe/ave/drm/DRMManager;

    move-result-object v1

    invoke-virtual {p1}, Lcom/adobe/mediacore/DRMMetadataInfo;->getDRMMetadata()Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->drmMetaDataAvailable(Lcom/adobe/ave/drm/DRMManager;Lcom/adobe/ave/drm/DRMMetadata;)V

    .line 1070
    :cond_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow:[I

    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->currentChannel:Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    invoke-static {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$2100(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmWorkflow()Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1081
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->playWithoutDrmWorkflow()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$2500(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    .line 1083
    :goto_0
    return-void

    .line 1072
    :pswitch_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->acquireLicenseForStreaming(Lcom/adobe/mediacore/DRMMetadataInfo;)V
    invoke-static {v0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$2200(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/adobe/mediacore/DRMMetadataInfo;)V

    goto :goto_0

    .line 1075
    :pswitch_1
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->acquireLicenseForOffline()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$2300(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;)V

    goto :goto_0

    .line 1078
    :pswitch_2
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$5;->this$0:Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->acquireLicenseForWhitelist(Lcom/adobe/mediacore/DRMMetadataInfo;)V
    invoke-static {v0, p1}, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;->access$2400(Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;Lcom/adobe/mediacore/DRMMetadataInfo;)V

    goto :goto_0

    .line 1070
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
