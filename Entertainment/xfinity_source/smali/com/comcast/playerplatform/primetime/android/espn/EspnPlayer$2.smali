.class Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$2;
.super Landroid/content/BroadcastReceiver;
.source "EspnPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;->isChannelListAvailable()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

.field final synthetic val$waitForConfig:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;Ljava/util/concurrent/CountDownLatch;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$2;->this$0:Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer;

    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$2;->val$waitForConfig:Ljava/util/concurrent/CountDownLatch;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/espn/EspnPlayer$2;->val$waitForConfig:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 168
    invoke-virtual {p1, p0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 169
    return-void
.end method
