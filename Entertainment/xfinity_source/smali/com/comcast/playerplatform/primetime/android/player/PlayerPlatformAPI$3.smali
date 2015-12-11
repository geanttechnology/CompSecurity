.class Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;
.super Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;
.source "PlayerPlatformAPI.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V
    .locals 0

    .prologue
    .line 1237
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-direct {p0}, Lcom/comcast/playerplatform/drm/java/event/AbstractDrmLicenseEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public acquiringLicense(Ljava/lang/String;)V
    .locals 1
    .param p1, "asset"    # Ljava/lang/String;

    .prologue
    .line 1265
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1266
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->acquiringLicense(Ljava/lang/String;)V

    .line 1268
    :cond_0
    return-void
.end method

.method public offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V
    .locals 1
    .param p1, "asset"    # Ljava/lang/String;
    .param p2, "licenseStart"    # Ljava/util/Date;
    .param p3, "licenseEnd"    # Ljava/util/Date;
    .param p4, "policyId"    # Ljava/lang/String;

    .prologue
    .line 1248
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1249
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->offlineDRMComplete(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V

    .line 1251
    :cond_0
    return-void
.end method

.method public offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;

    .prologue
    .line 1255
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1256
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->offlineDRMFailure(Ljava/lang/String;Ljava/lang/String;)V

    .line 1258
    :cond_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 1259
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->listenerManager:Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->access$600(Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/events/PlayerEventManager;->mediaFailed(Ljava/lang/String;Ljava/lang/String;)V

    .line 1261
    :cond_1
    return-void
.end method
