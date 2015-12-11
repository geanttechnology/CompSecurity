.class public Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;
.super Ljava/lang/Object;
.source "PlayerConfigurationListener.java"

# interfaces
.implements Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public configurationFailed(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->removeListener(Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;)V

    .line 16
    return-void
.end method

.method public configurationLoaded()V
    .locals 1

    .prologue
    .line 10
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->removeListener(Lcom/comcast/playerplatform/util/android/IConfigurationEventListener;)V

    .line 11
    return-void
.end method
