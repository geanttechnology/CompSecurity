.class Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$1;
.super Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;
.source "PlayerConfigUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->configureSynchronous(J)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

.field final synthetic val$waitForConfig:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;Ljava/util/concurrent/CountDownLatch;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$1;->val$waitForConfig:Ljava/util/concurrent/CountDownLatch;

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;-><init>()V

    return-void
.end method


# virtual methods
.method public configurationFailed(Ljava/lang/String;)V
    .locals 2
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 80
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;->configurationFailed(Ljava/lang/String;)V

    .line 81
    # getter for: Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->access$000()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "configurationFailed: {}"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Object;)V

    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$1;->val$waitForConfig:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 83
    return-void
.end method

.method public configurationLoaded()V
    .locals 1

    .prologue
    .line 74
    invoke-super {p0}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;->configurationLoaded()V

    .line 75
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil$1;->val$waitForConfig:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 76
    return-void
.end method
