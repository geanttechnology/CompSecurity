.class Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;
.super Ljava/lang/Object;
.source "AndroidPlayer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;JLcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

.field final synthetic val$asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;Lcom/comcast/playerplatform/primetime/android/asset/Asset;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->val$asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 125
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    sget-object v3, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->INITIALIZING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    # setter for: Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    invoke-static {v2, v3}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->access$002(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 126
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->notifyPlayStateChange()V
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)V

    .line 129
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 130
    .local v0, "cookies":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "Cookie"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->val$asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    iget-object v4, v4, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->authCookieName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->val$asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    iget-object v4, v4, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->authCookieValue:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->access$300(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)Landroid/media/MediaPlayer;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->appContext:Landroid/content/Context;
    invoke-static {v3}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->access$200(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)Landroid/content/Context;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->val$asset:Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    invoke-virtual {v4}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getManifestUri()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v3, v4, v0}, Landroid/media/MediaPlayer;->setDataSource(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;)V

    .line 133
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    sget-object v3, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->INITIALIZED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    # setter for: Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    invoke-static {v2, v3}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->access$002(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 134
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->notifyPlayStateChange()V
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)V

    .line 135
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    # getter for: Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->primeTimePlayer:Landroid/media/MediaPlayer;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->access$300(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)Landroid/media/MediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->prepareAsync()V

    .line 136
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    sget-object v3, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    # setter for: Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->status:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    invoke-static {v2, v3}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->access$002(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 137
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer$3;->this$0:Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;

    # invokes: Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->notifyPlayStateChange()V
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;->access$100(Lcom/comcast/playerplatform/primetime/android/player/AndroidPlayer;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 149
    .end local v0    # "cookies":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return-void

    .line 138
    :catch_0
    move-exception v1

    .line 139
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method
