.class public Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;
.super Landroid/content/BroadcastReceiver;
.source "SessionUserChangedToAccountForPackageChangedAdpater.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static isValidOnThisPlatform(Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Z
    .locals 1
    .param p0, "platform"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .prologue
    .line 56
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isPreMergeDevice()Z

    move-result v0

    return v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 25
    sget-object v0, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;->TAG:Ljava/lang/String;

    .line 27
    new-instance v0, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater$1;

    invoke-direct {v0, p0, p1}, Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater$1;-><init>(Lcom/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater;Landroid/content/Context;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 49
    return-void
.end method
