.class public Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;
.super Ljava/lang/Object;
.source "MediaLicenseRenewalScheduler.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final connectivityChangeReceiver:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;

.field private final context:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;-><init>(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$1;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->connectivityChangeReceiver:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;

    .line 23
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->context:Landroid/content/Context;

    .line 24
    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;

    .prologue
    .line 16
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->context:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public runAtInterval(J)V
    .locals 13
    .param p1, "millisecondsFromNow"    # J

    .prologue
    .line 27
    sget-object v3, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->LOG:Lorg/slf4j/Logger;

    const-string v8, "Scheduling next run"

    invoke-interface {v3, v8}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 30
    iget-object v3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->context:Landroid/content/Context;

    const-string v8, "alarm"

    invoke-virtual {v3, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/AlarmManager;

    .line 31
    .local v1, "mgr":Landroid/app/AlarmManager;
    iget-object v3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->context:Landroid/content/Context;

    invoke-static {v3}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->createIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 32
    .local v0, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->context:Landroid/content/Context;

    const/4 v8, 0x0

    const/high16 v9, 0x8000000

    invoke-static {v3, v8, v0, v9}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    .line 35
    .local v2, "pendingIntent":Landroid/app/PendingIntent;
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v4

    .line 36
    .local v4, "sinceBootTime":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 37
    .local v6, "wallClockTime":J
    const/4 v3, 0x3

    add-long v8, v4, p1

    invoke-virtual {v1, v3, v8, v9, v2}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 39
    sget-object v3, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->LOG:Lorg/slf4j/Logger;

    const-string v8, "{} scheduled to run again at approximately {}"

    sget-object v9, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalService;->NAME:Ljava/lang/String;

    add-long v10, v6, p1

    invoke-static {v10, v11}, Lcom/comcast/cim/utils/DebugUtil;->millisToDateString(J)Ljava/lang/String;

    move-result-object v10

    invoke-interface {v3, v8, v9, v10}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 40
    return-void
.end method

.method public runWhenConnectionIsAvailable()V
    .locals 2

    .prologue
    .line 43
    sget-object v0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Scheduling to run when internet connection is available"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 44
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler;->connectivityChangeReceiver:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalScheduler$ConnectivityChangeReceiver;->register()V

    .line 45
    return-void
.end method
