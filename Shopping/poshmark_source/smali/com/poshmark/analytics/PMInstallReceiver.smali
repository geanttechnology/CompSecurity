.class public Lcom/poshmark/analytics/PMInstallReceiver;
.super Landroid/content/BroadcastReceiver;
.source "PMInstallReceiver.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 20
    new-instance v1, Lcom/mobileapptracker/Tracker;

    invoke-direct {v1}, Lcom/mobileapptracker/Tracker;-><init>()V

    .line 21
    .local v1, "tracker":Lcom/mobileapptracker/Tracker;
    invoke-virtual {v1, p1, p2}, Lcom/mobileapptracker/Tracker;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V

    .line 24
    new-instance v2, Lnet/singular/sdk/InstallReceiver;

    invoke-direct {v2}, Lnet/singular/sdk/InstallReceiver;-><init>()V

    invoke-virtual {v2, p1, p2}, Lnet/singular/sdk/InstallReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V

    .line 27
    new-instance v0, Lcom/google/analytics/tracking/android/CampaignTrackingReceiver;

    invoke-direct {v0}, Lcom/google/analytics/tracking/android/CampaignTrackingReceiver;-><init>()V

    .line 28
    .local v0, "googleCampaignTrackingRcvr":Lcom/google/analytics/tracking/android/CampaignTrackingReceiver;
    invoke-virtual {v0, p1, p2}, Lcom/google/analytics/tracking/android/CampaignTrackingReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V

    .line 30
    return-void
.end method
