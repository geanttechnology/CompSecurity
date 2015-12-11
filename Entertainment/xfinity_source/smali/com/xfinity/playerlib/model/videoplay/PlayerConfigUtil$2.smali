.class Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$2;
.super Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;
.source "PlayerConfigUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->configureESPNPlayer(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;Landroid/content/Context;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    .prologue
    .line 106
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$2;->this$0:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$2;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;-><init>()V

    return-void
.end method


# virtual methods
.method public configurationFailed(Ljava/lang/String;)V
    .locals 2
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 117
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;->configurationFailed(Ljava/lang/String;)V

    .line 118
    # getter for: Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->access$000()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "configurationFailed: {}"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Object;)V

    .line 119
    return-void
.end method

.method public configurationLoaded()V
    .locals 3

    .prologue
    .line 109
    invoke-super {p0}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;->configurationLoaded()V

    .line 110
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isEspnReady()Z

    move-result v0

    if-nez v0, :cond_0

    .line 111
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$2;->val$context:Landroid/content/Context;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->initializeESPN(Landroid/content/Context;Z)V

    .line 113
    :cond_0
    return-void
.end method
