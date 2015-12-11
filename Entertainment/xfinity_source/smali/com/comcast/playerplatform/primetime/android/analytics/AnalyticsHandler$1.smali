.class Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$1;
.super Ljava/lang/Object;
.source "AnalyticsHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->pluginInitialized(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$1;->this$0:Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$1;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v4, 0x1

    .line 60
    new-instance v2, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;

    invoke-direct {v2}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;-><init>()V

    .line 61
    .local v2, "value":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;
    const-string v3, "PlayerPlatform"

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setPlayerId(Ljava/lang/String;)V

    .line 62
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/PlayerPlatformVersion;->getPlayerPlatformVersion()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setPlayerVersion(Ljava/lang/String;)V

    .line 63
    const-string v3, "VIPER"

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setOrganization(Ljava/lang/String;)V

    .line 64
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setNative(Ljava/lang/Boolean;)V

    .line 65
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setSupportVod(Ljava/lang/Boolean;)V

    .line 66
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setSupportLinear(Ljava/lang/Boolean;)V

    .line 67
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setSupportCdvr(Ljava/lang/Boolean;)V

    .line 68
    const-string v3, "os.name"

    invoke-static {v3}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setOsId(Ljava/lang/String;)V

    .line 69
    const-string v3, "os.version"

    invoke-static {v3}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setOsVersion(Ljava/lang/String;)V

    .line 70
    const-string v3, "os.arch"

    invoke-static {v3}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setOsArchitecture(Ljava/lang/String;)V

    .line 71
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Runtime;->availableProcessors()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setCpuCore(Ljava/lang/String;)V

    .line 72
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$1;->val$context:Landroid/content/Context;

    # invokes: Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->getDisplaySize(Landroid/content/Context;)Landroid/graphics/Point;
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->access$000(Landroid/content/Context;)Landroid/graphics/Point;

    move-result-object v1

    .line 73
    .local v1, "size":Landroid/graphics/Point;
    iget v3, v1, Landroid/graphics/Point;->y:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setScreenHeight(Ljava/lang/String;)V

    .line 74
    iget v3, v1, Landroid/graphics/Point;->x:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->setScreenWidth(Ljava/lang/String;)V

    .line 75
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$1;->this$0:Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;

    # invokes: Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->access$100(Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;)J

    move-result-wide v4

    invoke-direct {v0, v4, v5, v2}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;-><init>(JLcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;)V

    .line 76
    .local v0, "message":Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PluginInitializedMessage;
    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$1;->this$0:Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;

    # invokes: Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V
    invoke-static {v3, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->access$200(Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 77
    return-void
.end method
