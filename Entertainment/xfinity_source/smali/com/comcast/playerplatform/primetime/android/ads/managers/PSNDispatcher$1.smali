.class Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher$1;
.super Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
.source "PSNDispatcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;->dispatchPSN(Lcom/comcast/playerplatform/primetime/android/ads/PlacementEvent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher$1;->this$0:Lcom/comcast/playerplatform/primetime/android/ads/managers/PSNDispatcher;

    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;-><init>()V

    return-void
.end method


# virtual methods
.method public configurationNotReady()V
    .locals 0

    .prologue
    .line 60
    invoke-super {p0}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;->configurationNotReady()V

    .line 61
    return-void
.end method

.method public redirectUrlFound(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 55
    invoke-super {p0, p1}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;->redirectUrlFound(Ljava/lang/String;)V

    .line 56
    return-void
.end method

.method public requestFailed(Ljava/lang/String;)V
    .locals 3
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-super {p0, p1}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;->requestFailed(Ljava/lang/String;)V

    .line 50
    const-string v0, "PaukTest"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "PSN failed:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 51
    return-void
.end method

.method public responseReceived(Ljava/lang/String;)V
    .locals 3
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 44
    const-string v0, "PaukTest"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "PSN success:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 45
    return-void
.end method
