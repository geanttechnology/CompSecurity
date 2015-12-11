.class public Lcom/amazon/identity/auth/device/storage/LambortishClock$ChangeTimestampsBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "LambortishClock.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/LambortishClock;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChangeTimestampsBroadcastReceiver"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method public static isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z
    .locals 1
    .param p0, "platform"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .prologue
    .line 48
    invoke-static {p0}, Lcom/amazon/identity/auth/device/storage/DistributedDataStorage;->shouldPlatformUseThisStore(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 25
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 26
    .local v0, "action":Ljava/lang/String;
    const-string/jumbo v2, "android.intent.action.TIME_SET"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 28
    # getter for: Lcom/amazon/identity/auth/device/storage/LambortishClock;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->access$000()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Cannot Handle intent with action %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 44
    :goto_0
    return-void

    .line 32
    :cond_0
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    .line 33
    .local v1, "wrappedContext":Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    const-string/jumbo v2, "sso_platform"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 36
    invoke-static {v2}, Lcom/amazon/identity/auth/device/storage/LambortishClock$ChangeTimestampsBroadcastReceiver;->isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 38
    # getter for: Lcom/amazon/identity/auth/device/storage/LambortishClock;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->access$000()Ljava/lang/String;

    goto :goto_0

    .line 43
    :cond_1
    invoke-static {v1}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/LambortishClock;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/storage/LambortishClock;->notifySystemTimeChanged()V

    goto :goto_0
.end method
