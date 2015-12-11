.class Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;
.super Landroid/content/BroadcastReceiver;
.source "MediaLicenseRenewalScheduler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConnectivityChangeReceiver"
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private isRegistered:Z

.field final synthetic this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;)V
    .locals 1

    .prologue
    .line 47
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;->this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 48
    const-class v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;->LOG:Lorg/slf4j/Logger;

    .line 50
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;->isRegistered:Z

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;
    .param p2, "x1"    # Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$1;

    .prologue
    .line 47
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;-><init>(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;)V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x0

    .line 54
    const-string v0, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "noConnectivity"

    .line 55
    invoke-virtual {p2, v0, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_1

    .line 56
    monitor-enter p0

    .line 57
    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;->isRegistered:Z

    if-eqz v0, :cond_0

    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Connection re-established"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 59
    invoke-static {p1}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->createIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 60
    invoke-virtual {p1, p0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 61
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;->isRegistered:Z

    .line 63
    :cond_0
    monitor-exit p0

    .line 65
    :cond_1
    return-void

    .line 63
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public register()V
    .locals 2

    .prologue
    .line 68
    monitor-enter p0

    .line 69
    :try_start_0
    iget-boolean v1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;->isRegistered:Z

    if-nez v1, :cond_0

    .line 70
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 71
    .local v0, "filter":Landroid/content/IntentFilter;
    iget-object v1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;->this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    # getter for: Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->context:Landroid/content/Context;
    invoke-static {v1}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->access$100(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, p0, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 72
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;->isRegistered:Z

    .line 74
    .end local v0    # "filter":Landroid/content/IntentFilter;
    :cond_0
    monitor-exit p0

    .line 75
    return-void

    .line 74
    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method
