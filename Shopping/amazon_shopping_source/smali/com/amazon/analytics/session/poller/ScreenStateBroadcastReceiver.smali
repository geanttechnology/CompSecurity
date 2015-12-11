.class public Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "ScreenStateBroadcastReceiver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;,
        Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;
    }
.end annotation


# instance fields
.field private final logic:Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;


# direct methods
.method public constructor <init>(Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;)V
    .locals 1
    .param p1, "screenChangeListener"    # Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 19
    new-instance v0, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;

    invoke-direct {v0, p1}, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;-><init>(Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$ScreenStateChangeListener;)V

    iput-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver;->logic:Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;

    .line 20
    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver;->logic:Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/analytics/session/poller/ScreenStateBroadcastReceiver$Logic;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V

    .line 28
    return-void
.end method
