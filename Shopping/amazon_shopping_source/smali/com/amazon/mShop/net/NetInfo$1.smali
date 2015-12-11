.class final Lcom/amazon/mShop/net/NetInfo$1;
.super Landroid/content/BroadcastReceiver;
.source "NetInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/NetInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 237
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 240
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 243
    .local v0, "action":Ljava/lang/String;
    const-string/jumbo v2, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 244
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string/jumbo v3, "connectivity"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/ConnectivityManager;

    .line 247
    .local v1, "connectivity":Landroid/net/ConnectivityManager;
    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v2

    # invokes: Lcom/amazon/mShop/net/NetInfo;->setActiveNetworkInfo(Landroid/net/NetworkInfo;)V
    invoke-static {v2}, Lcom/amazon/mShop/net/NetInfo;->access$000(Landroid/net/NetworkInfo;)V

    .line 250
    # invokes: Lcom/amazon/mShop/net/NetInfo;->collectNetworkInfoCosting()V
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->access$100()V

    .line 252
    .end local v1    # "connectivity":Landroid/net/ConnectivityManager;
    :cond_0
    return-void
.end method
