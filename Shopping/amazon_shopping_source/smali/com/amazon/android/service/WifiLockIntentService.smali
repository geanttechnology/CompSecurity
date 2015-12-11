.class public abstract Lcom/amazon/android/service/WifiLockIntentService;
.super Landroid/app/IntentService;
.source "WifiLockIntentService.java"


# static fields
.field private static final LOG:Lcom/amazon/logging/Logger;


# instance fields
.field private networkLock:Landroid/net/wifi/WifiManager$WifiLock;

.field private final serviceName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/amazon/android/service/WifiLockIntentService;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/service/WifiLockIntentService;->LOG:Lcom/amazon/logging/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 34
    iput-object p1, p0, Lcom/amazon/android/service/WifiLockIntentService;->serviceName:Ljava/lang/String;

    .line 35
    return-void
.end method


# virtual methods
.method public onCreate()V
    .locals 4

    .prologue
    .line 43
    invoke-super {p0}, Landroid/app/IntentService;->onCreate()V

    .line 44
    invoke-virtual {p0}, Lcom/amazon/android/service/WifiLockIntentService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string/jumbo v2, "wifi"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    .line 45
    .local v0, "wifiManager":Landroid/net/wifi/WifiManager;
    iget-object v1, p0, Lcom/amazon/android/service/WifiLockIntentService;->serviceName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/net/wifi/WifiManager;->createWifiLock(Ljava/lang/String;)Landroid/net/wifi/WifiManager$WifiLock;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/android/service/WifiLockIntentService;->networkLock:Landroid/net/wifi/WifiManager$WifiLock;

    .line 46
    iget-object v1, p0, Lcom/amazon/android/service/WifiLockIntentService;->networkLock:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {v1}, Landroid/net/wifi/WifiManager$WifiLock;->acquire()V

    .line 47
    sget-object v1, Lcom/amazon/android/service/WifiLockIntentService;->LOG:Lcom/amazon/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "acquired network lock for \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/android/service/WifiLockIntentService;->serviceName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/android/service/WifiLockIntentService;->networkLock:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {v0}, Landroid/net/wifi/WifiManager$WifiLock;->isHeld()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 57
    iget-object v0, p0, Lcom/amazon/android/service/WifiLockIntentService;->networkLock:Landroid/net/wifi/WifiManager$WifiLock;

    invoke-virtual {v0}, Landroid/net/wifi/WifiManager$WifiLock;->release()V

    .line 58
    sget-object v0, Lcom/amazon/android/service/WifiLockIntentService;->LOG:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "released network lock for \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/android/service/WifiLockIntentService;->serviceName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 60
    :cond_0
    return-void
.end method
